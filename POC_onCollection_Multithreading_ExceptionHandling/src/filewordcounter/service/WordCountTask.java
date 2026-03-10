package filewordcounter.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

public class WordCountTask implements Runnable {
    private final File file;
    private final ConcurrentMap<String, Integer> wordCountMap;
    private final CountDownLatch latch;

    public WordCountTask(File file, ConcurrentMap<String, Integer> wordCountMap, CountDownLatch latch) {
        this.file = file;
        this.wordCountMap = wordCountMap;
        this.latch = latch;
    }


    @Override
    public void run() {
        int count = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            wordCountMap.put(file.getName(), count);
            System.out.println(file.getName() + " has " + count + " words.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
            wordCountMap.put(file.getName(), 0);
        } finally {
            latch.countDown(); //it will use to notify  task is done
        }

    }
}
