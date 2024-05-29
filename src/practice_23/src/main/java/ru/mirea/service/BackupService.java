package ru.mirea.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.mirea.model.Manufacture;
import ru.mirea.model.Worker;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BackupService {
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ManufactureService manufactureService;

    private static final Logger log = LoggerFactory.getLogger(BackupService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Path BACKUP_DIRECTORY = Paths.get(System.getProperty("user.dir"), "backup");

    private void createBackupDirectory() throws IOException {
        if (!Files.exists(BACKUP_DIRECTORY)) {
            Files.createDirectories(BACKUP_DIRECTORY);
        }
    }

    private void makeWorkersBackup() {
        List<Worker> workers = workerService.readAll();
        try {
            createBackupDirectory();
            RandomAccessFile writer = new RandomAccessFile(BACKUP_DIRECTORY.resolve("workers.txt").toFile(), "rw");
            writer.setLength(0);
            for (Worker worker : workers) {
                String productStr = String.format("%d %s %s %s\n",
                        worker.getId(),
                        worker.getFirstName(),
                        worker.getMiddleName(),
                        worker.getLastName());
                writer.write(productStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeManufacturesBackup() {
        List<Manufacture> manufactures = manufactureService.readAll();
        try {
            createBackupDirectory();
            RandomAccessFile writer = new RandomAccessFile(BACKUP_DIRECTORY.resolve("manufactures.txt").toFile(), "rw");
            writer.setLength(0);
            for (Manufacture manufacture : manufactures) {
                String marketStr = String.format("%d %s \n",
                        manufacture.getId(),
                        manufacture.getName());
                writer.write(marketStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(fixedRate = 10000000)
    public void makeBackup() {
        makeWorkersBackup();
        // makeManufacturesBackup();
        log.info("Backups are made: {}", dateFormat.format(new Date()));
    }
}
