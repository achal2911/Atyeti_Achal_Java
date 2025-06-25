package filewordcounter;

import filewordcounter.service.WordCountTask;

import java.io.File;
import java.util.concurrent.*;

public class FileWordCounterSystem {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();

        File[] files = {new File("C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java1\\POC_onCollection_Multithreading_ExceptionHandling\\src\\filewordcounter\\utils\\file1.txt"),
                        new File("C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java1\\POC_onCollection_Multithreading_ExceptionHandling\\src\\filewordcounter\\utils\\file2.txt"),
                        new File("C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java1\\POC_onCollection_Multithreading_ExceptionHandling\\src\\filewordcounter\\utils\\file3.txt"),
                        new File("C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java1\\POC_onCollection_Multithreading_ExceptionHandling\\src\\filewordcounter\\utils\\file4.txt"),
                        new File("src/filewordcounter/utils/missing.txt")};

        CountDownLatch latch = new CountDownLatch(files.length);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(File file:files)
        {
            executor.submit(new WordCountTask(file,wordCountMap,latch));
        }

        latch.await();//latch is used to wait for all tasks to finish
        executor.shutdown();

        System.out.println("\nFinal Word Counts:");
        wordCountMap.forEach((fileName, count) ->
                System.out.println(fileName + " → " + count + " words")
        );

    }
}
