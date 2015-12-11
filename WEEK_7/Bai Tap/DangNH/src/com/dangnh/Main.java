package com.dangnh;

import com.dangnh.com.dangnh.core.ProcessTask;
import com.dangnh.com.dangnh.core.ReadAreaTask;
import com.dangnh.com.dangnh.core.ReadPositionTask;
import com.dangnh.com.dangnh.core.WriteTask;
import com.dangnh.com.dangnh.model.Alert;
import com.dangnh.com.dangnh.model.Area;
import com.dangnh.com.dangnh.model.Position;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final File positionFile = new File("resource/positions.txt");
        final File areaFile = new File("resource/area.txt");
        final File alertFile = new File("output/alert.txt");
        final BlockingQueue<Position> positionQueue = new ArrayBlockingQueue<>(1024);
        final BlockingQueue<Alert> alertQueue = new ArrayBlockingQueue<>(1024);

        ReadAreaTask readAreaTask = new ReadAreaTask(areaFile);
        ExecutorService executor = Executors.newCachedThreadPool();

        ReadPositionTask readPositionTask = new ReadPositionTask(positionFile, positionQueue);
        executor.execute(readPositionTask);
        Future<List<Area>> future = executor.submit(readAreaTask);

        List<Area> areaList = future.get();
        ProcessTask processTask = new ProcessTask(positionQueue, areaList, alertQueue);
        WriteTask writeTask = new WriteTask(alertQueue, alertFile);
        executor.execute(processTask);
        executor.execute(writeTask);


    }
}
