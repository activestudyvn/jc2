
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.common.AppLogger;
import org.processor.DataFilter;
import org.processor.FileReader;
import org.processor.FileWriter;
import util.MyQueue;

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
    static final String successOutputFile = "success.txt";
    static final String failedOutputFile = "failed.txt";

    public static void main(String[] args) {
        AppLogger.getInstance().setLevel(AppLogger.WARM);

        MyQueue<String> dataQueue = new MyQueue<>();
        MyQueue<String> successOutputQueue = new MyQueue<>(1000000);
        MyQueue<String> failedOutputQueue = new MyQueue<>(1000000);

        FileReader reader = new FileReader(inputFilePath, dataQueue);
        DataFilter checker = new DataFilter(dataQueue, successOutputQueue, failedOutputQueue);
        FileWriter writeSuccessData = new FileWriter(successOutputFile, successOutputQueue);
        FileWriter writeFailedData = new FileWriter(failedOutputFile, failedOutputQueue);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(reader);
        executor.execute(checker);
        executor.execute(writeSuccessData);
        executor.execute(writeFailedData);
        
        

    }
}
