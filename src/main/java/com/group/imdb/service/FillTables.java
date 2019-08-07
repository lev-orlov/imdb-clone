package com.group.imdb.service;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Service
public class FillTables {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public ResponseEntity run() {
        String home = System.getProperty("user.home");
        Path dir = Paths.get(home, "Downloads", "tables");
        copyFilesFromDirToTables(dir);

        return ResponseEntity.ok().build();
    }


    private void copyFilesFromDirToTables(Path dir) {
        try {
            Files.list(dir)
                    .filter(path -> path.toString().endsWith(".tsv"))
                    .collect(toMap(path -> path.getFileName().toString(), Function.identity()))
                    .forEach((k, path) -> {
                        String tableName = k.substring(0, k.length() - 4).replace(".", "_");
                        copyInTable(tableName, path);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  Connection getCon() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private void copyInTable(String tableName, Path filePath) {
        try (Connection con = getCon()){
            long rowsInserted =
                    new CopyManager((BaseConnection) con)
                            .copyIn("COPY " + tableName + " FROM STDIN (FORMAT csv, DELIMITER E'\\t', HEADER , NULL '\\N', QUOTE E'\\b')",
                                    Files.newBufferedReader(filePath)
                            );
            System.out.printf("%d row(s) inserted %s%n", rowsInserted, tableName);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
