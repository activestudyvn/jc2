import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Created by 404NotFound on 11/9/2015.
 */
public class Ex2 {
    static final Pattern phonePattern = Pattern.compile("849\\d+");
    static final Pattern inputPattern = Pattern.compile("cdr_\\d+_8x56_\\d.txt");
    static final Pattern outputPattern = Pattern.compile("\\d+_8x56_\\d.txt");
    static final File input = new File("input");
    static final File output = new File("output");
    static final DateTimeFormatter defaultDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) throws IOException {
        ArrayList<File> listInputDir = new ArrayList<>();
        ArrayList<File> listOutputDir = new ArrayList<>();
        File[] filesInput;
        File[] filesOutput;
        for (File inputSubDir : input.listFiles()) {
            listInputDir.add(inputSubDir);
        }
        for (File outputSubDir : output.listFiles()) {
            listOutputDir.add(outputSubDir);
        }
        for (File inputDir : listInputDir) {
            filesInput = inputDir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return inputPattern.matcher(file.getName()).matches();
                }
            });
            Optional<File> outputDir = listOutputDir.parallelStream().filter(file -> file.getName().equals(inputDir.getName())).findAny();
            if (!outputDir.isPresent()) continue;
            filesOutput = outputDir.get().listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return outputPattern.matcher(file.getName()).matches();
                }
            });
            HashSet<String> inputSet = getPhoneSet(filesInput);
            HashSet<String> outputSet = getPhoneSet(filesOutput);
            HashSet<String> inputTemp = (HashSet<String>) inputSet.clone();
            inputSet.removeAll(outputSet);
            LocalDate fileDate = LocalDate.parse(inputDir.getName(), defaultDateFormatter);
            System.out.println(fileDate.format(dateFormatter) + " Input co nhung Output ko co: " + inputSet);
            outputSet.removeAll(inputTemp);
            System.out.println("Output co nhung Input ko co: " + outputSet);
        }
        for (File outputDir : listOutputDir) {
            filesOutput = outputDir.listFiles();
        }
    }

    static HashSet<String> getPhoneSet(File[] fileArr) throws IOException {
        HashSet<String> phoneSet = new HashSet<>();
        for (File file : fileArr) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s = "";
                int count = 1;
                while ((s = reader.readLine()) != null) {
                    if (phonePattern.matcher(s).matches()) phoneSet.add(s);
                }
            }
        }
        return phoneSet;
    }
}
