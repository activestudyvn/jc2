package org;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by 404NotFound on 11/4/2015.
 */
public class FileCDR implements AutoCloseable, Closeable {
    //Field declaration
    private int writeType;
    private int maxValue;
    private int fileType;
    private String fileName;
    private String filePath;
    private int count;
    private BufferedWriter writer = null;
    private boolean continueWrite;
    private String fullFilePath;
    private LocalDateTime lastCreationTime;
    //End field declaration

    //Constructor declaration

    /**
     * Create a new immutable FileCDR Object with default value:
     * writeType = 1
     * maxValue = 200
     * fileType = 1
     * fileName = "DefaultFilename"
     * filePath = in current directory
     */
    public FileCDR() {
        this(1, 200, 1, "DefaultFilename", "");
    }

    /**
     * Create a new immutable FileCDR Object
     *
     * @param writeType Can be 1,2,3.
     *                  1: Export files when reach maxValue lines.
     *                  2: Export files when reach maxValue file size.
     *                  3: Export files when reach maxValue hours.
     * @param maxValue  limit value to export new file
     * @param fileType  Can be 1,2.
     *                  1: Export files with increment count naming mode
     *                  2: Export files name with time created
     * @param fileName  Base Name of files to export.
     */
    public FileCDR(int writeType, int maxValue, int fileType, String fileName) {
        this(writeType, maxValue, fileType, fileName, "");
    }

    /**
     * Create a new immutable FileCDR Object. If file doesn't exist, the file and all parent directories will be created.
     *
     * @param writeType Can be 1,2,3.
     *                  1: Create new files when reach maxValue lines.
     *                  2: Create new files when reach maxValue file size.
     *                  3: Create new files when reach maxValue hours.
     * @param maxValue  limit value to export new file
     * @param fileType  Can be 1,2.
     *                  1: Create new files in an increment naming mode
     *                  2: Create new files name with time created
     * @param fileName  Base name of files to export.
     * @param filePath  Path to data file
     */
    public FileCDR(int writeType, int maxValue, int fileType, String fileName, String filePath) {
        this.writeType = writeType;
        this.maxValue = maxValue;
        this.fileType = fileType;
        this.fileName = fileName;
        this.filePath = filePath;
        if (!filePath.equals("")) {
            File file = new File(filePath);
            if (!file.exists()) file.mkdirs();
            this.fullFilePath = filePath + "/" + fileName;
        } else fullFilePath = fileName;
    }
    //End constructor declaration

    /**
     * Write source to filePath, name of files are fileName+x based on fileType
     *
     * @param source
     * @throws IOException
     */
    public void write(String source) throws IOException {
        switch (writeType) {
            case 1: {
                WriteByNumberOfLine(source);
                break;
            }
            case 2: {
                WriteBySize(source);
                break;
            }
            case 3: {
                WriteByTimeCreated(source);
                break;
            }
        }
    }

    /**
     * Close file stream
     *
     * @throws IOException if an I/O error occur
     */
    @Override
    public void close() throws IOException {
        if (this.writer != null) {
            this.writer.close();
            this.writer = null;
        }
    }

    /**
     * Write in writeType 1
     * Export files when reach maxValue lines.
     *
     * @param source String to write
     * @throws IOException if an I/O error occur
     */
    private void WriteByNumberOfLine(String source) throws IOException {
        //Check fileType Mode

        switch (fileType) {
            case 1: {
                if (isEnoughLine(new File(fullFilePath + count))) {
                    this.count++;
                    continueWrite = false;
                }
                write(source, new File(fullFilePath + count));
                continueWrite = true;
                break;
            }
            case 2: {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss-SSS");
                String timeNow = LocalDateTime.now().format(formatter);
                if (getLastModifiedFile() == null || isEnoughLine(getLastModifiedFile())) {
                    continueWrite = false;
                    write(source, new File(fullFilePath + timeNow));
                    continueWrite = true;
                } else {
                    continueWrite = true;
                    write(source, getLastModifiedFile());
                }
                break;
            }
        }
    }

    /**
     * Write in writeType 2
     *
     * @param source String to write
     * @throws IOException if an I/O error occur
     */
    private void WriteBySize(String source) throws IOException {
        //Check fileType Mode
        switch (fileType) {
            case 1: {
                if (isEnoughSize(new File(fullFilePath + count))) {
                    this.count++;
                    continueWrite = false;
                }
                write(source, new File(fullFilePath + count));
                continueWrite = true;
                break;
            }
            case 2: {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss-SSS");
                String timeNow = LocalDateTime.now().format(formatter);
                if (getLastModifiedFile() == null || isEnoughSize(getLastModifiedFile())) {
                    continueWrite = false;
                    write(source, new File(fullFilePath + timeNow));
                    continueWrite = true;
                } else {
                    continueWrite = true;
                    write(source, getLastModifiedFile());
                }
                break;
            }
        }
    }

    /**
     * Write in writeType 3
     *
     * @param source data to write
     * @throws IOException if an I/O error occur
     */
    private void WriteByTimeCreated(String source) throws IOException {
        long hours = ChronoUnit.HOURS.between(lastCreationTime, LocalDateTime.now());
        System.out.println(hours);
        //Check fileType Mode
        switch (fileType) {
            case 1: {
                if (hours >= maxValue) {
                    this.count++;
                    continueWrite = false;
                    lastCreationTime = LocalDateTime.now();
                }
                write(source, new File(fullFilePath + count));
                continueWrite = true;
                break;
            }
            case 2: {
                if (hours >= maxValue) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss-SSS");
                    String timeNow = LocalDateTime.now().format(formatter);
                    continueWrite = false;
                    lastCreationTime = LocalDateTime.now();
                    write(source, new File(fullFilePath + timeNow));
                    continueWrite = true;
                } else {
                    continueWrite = true;
                    write(source, getLastModifiedFile());
                }
                break;
            }
        }
    }

    /**
     * Write to file
     *
     * @param source String to write
     * @param file   file to write
     * @throws IOException if an I/O error occur
     */
    private void write(String source, File file) throws IOException {
        if (writer != null && continueWrite) {
            writer.write(source);
            writer.newLine();
            writer.flush();
        } else {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(source);
            writer.newLine();
            writer.flush();
        }
    }

    /**
     * Check if the file has maxValue of lines
     *
     * @param file File to check
     * @return true if the file has maxValue line
     * false if file object is null or file doesn't exist
     * @throws IOException if an I/O error occur
     */
    private boolean isEnoughLine(File file) throws IOException {
        if (!file.exists()) return false;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        System.out.println(lines + "\t" + maxValue);
        return lines == maxValue;
    }

    /**
     * Check if the file has maxValue size
     *
     * @param file File to check
     * @return true if the file has maxValue size
     * @throws IOException if an I/O error occur
     */
    private boolean isEnoughSize(File file) throws IOException {
        if (!file.exists()) return false;
        // Get length of file in bytes
        long fileSizeInBytes = file.length();
        long fileSizeInKB = fileSizeInBytes / 1024;
        long fileSizeInMB = fileSizeInKB / 1024;
        return fileSizeInMB == this.maxValue;
    }

    /**
     * Get the newest file in directory
     *
     * @return LocalDateTime Object represent the last modified time of newest file in directory
     */
    private File getLastModifiedFile() {
        File fl = new File(filePath);
        File[] files = fl.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        if (files.length == 0) return null;
        long lastMod = Long.MIN_VALUE;
        File newest = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                newest = file;
                lastMod = file.lastModified();
            }
        }
        return newest;
    }

//    private LocalDateTime getLastModifiedTime() {
//        File lasModFile = getLastModifiedFile();
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        String lastModTime = sdf.format(lasModFile.lastModified());
//        LocalDateTime dateTime = LocalDateTime.parse(lastModTime);
//        return dateTime;
//    }

    public String getFilePath() {
        return filePath;
    }

    public int getWriteType() {
        return writeType;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getFileType() {
        return fileType;
    }

    public String getFileName() {
        return fileName;
    }


}
