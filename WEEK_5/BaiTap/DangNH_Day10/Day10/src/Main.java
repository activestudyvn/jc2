
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.processor.DataFilter;
import org.processor.FileReader;
import org.processor.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 404NotFound
 */
public class Main {
        static final String inputFilePath = "input.txt";
        static final String successOutputFile  = "success.txt";
        static final String failedOutputFile = "failed.txt";
    public static void main(String[] args) {
        
        BlockingQueue<String> dataQueue = new ArrayBlockingQueue<>(1000000, true);
        
        FileReader reader = new FileReader(inputFilePath, dataQueue);
        DataFilter checker = new DataFilter(dataQueue);
        
        BlockingQueue<String> successOutputQueue = checker.getSuccessData();
        BlockingQueue<String> failedOutputQueue = checker.getFailedData();
        
        FileWriter writeSuccessData = new FileWriter(successOutputFile, successOutputQueue);
        FileWriter writeFailedData = new FileWriter(failedOutputFile, failedOutputQueue);
        
        new Thread(reader).start();
        new Thread(checker).start();
        new Thread(writeSuccessData).start();
        new Thread(writeFailedData).start();
    }
}
