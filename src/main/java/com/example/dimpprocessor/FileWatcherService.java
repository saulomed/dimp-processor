package com.example.dimpprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@Component
@EnableScheduling
public class FileWatcherService {

    @Value("${file.watcher.directory}")
    private String directoryPath;

    @Autowired
    private DimpFileProcessorService processorService;

    private final Set<String> processedFiles = new HashSet<>();

    @Scheduled(fixedRate = 10000) // Check every 10 seconds
    public void watchDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                if (!processedFiles.contains(file.getName())) {
                    try {
                        processorService.processFile(file.getAbsolutePath());
                        processedFiles.add(file.getName());
                        System.out.println("Processed file: " + file.getName());
                    } catch (IOException | ParseException e) {
                        System.err.println("Error processing file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
