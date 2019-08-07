package com.group.imdb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

@Service
public class DownloadImdbCSV {

    private static List<String> fileNames = Arrays.asList("title.ratings.tsv.gz", "title.basics.tsv.gz", "title.principals.tsv.gz", "name.basics.tsv.gz");
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public ResponseEntity run() {
        String home = System.getProperty("user.home");
        Path path = Paths.get(home, "Downloads", "tables");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String fileName : fileNames) {
            String datasetUrl = "https://datasets.imdbws.com/";
            String from = datasetUrl + fileName;
            String to = Paths.get(path.toString(), fileName).toString();
            threadPool.submit(new DownloadTask(from, to));
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    private static class DownloadTask implements Runnable {

        private String fromURL;
        private String toFileLocation;

        DownloadTask(String fromURL, String toFileLocation) {
            this.fromURL = fromURL;
            this.toFileLocation = toFileLocation;
        }

        @Override
        public void run() {
            downloadFile(fromURL, toFileLocation);
            unzipFile(toFileLocation);
            deleteFile(toFileLocation);
        }

        private void downloadFile(String fromURL, String toFileLocation) {
            System.out.println("starting download " + fromURL);
            try (FileOutputStream out = new FileOutputStream(toFileLocation)) {
                URL url = new URL(fromURL);
                ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
                FileChannel outChannel = out.getChannel();
                outChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                System.out.println("download finished " + fromURL);
            } catch (IOException e) {
                System.out.println("couldn't download file - " + fromURL + "\n" + e.getMessage());
            }
        }

        private void unzipFile(String fileName) {
            Path to = Paths.get(fileName.substring(0, fileName.length() - 3));
            System.out.println("unzipping started " + fileName);
            try (GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(fileName))) {
                Files.copy(gzis, to, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("unzipping finished " + to);
            } catch (IOException e) {
                System.out.println("couldn't unzip file - " + fileName + "\n" + e.getMessage());
            }
        }

        private void deleteFile(String fileName) {
            Path path = Paths.get(fileName);
            try {
                Files.delete(path);
                System.out.println("file deleted " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
