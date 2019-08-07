package com.group.imdb.controller;

import com.group.imdb.service.FillTables;
import com.group.imdb.service.DownloadImdbCSV;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class ServiceController {
    private final FillTables fillTables;
    private final DownloadImdbCSV downloadImdbCSV;

    public ServiceController(FillTables fillTables, DownloadImdbCSV downloadImdbCSV) {
        this.fillTables = fillTables;
        this.downloadImdbCSV = downloadImdbCSV;
    }

    @GetMapping("/downloadcsv")
    public ResponseEntity downloadCSV() {
        return downloadImdbCSV.run();
    }

    @GetMapping("/filltables")
    public ResponseEntity fillTables() {
        return fillTables.run();
    }
}
