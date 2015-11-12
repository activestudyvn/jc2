import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
    static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //list dir in input and output folder
    static ArrayList<File> listInputDir = new ArrayList<>();
    static ArrayList<File> listOutputDir = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //Get list dir in input and output folder
        for (File inputSubDir : input.listFiles()) {
            listInputDir.add(inputSubDir);
        }
        for (File outputSubDir : output.listFiles()) {
            listOutputDir.add(outputSubDir);
        }

        for (File inputDir : listInputDir) {
            //get all files in inputDir. File name must match inputPattern
            File[] filesInput = inputDir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return inputPattern.matcher(file.getName()).matches();
                }
            });

            //get outputDir in output folder which have the same name with inputDir folder
            Optional<File> outputDir = listOutputDir.parallelStream()
                    .filter(file -> file.getName().equals(inputDir.getName())).findAny();
            if (!outputDir.isPresent()) continue;

            //get all files in inputDir. File name must match outputPattern
            File[] filesOutput = outputDir.get().listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return outputPattern.matcher(file.getName()).matches();
                }
            });

            //get a set of phone string in input and output folder
            Set<String> inputSet = getPhoneSet(filesInput);
            Set<String> outputSet = getPhoneSet(filesOutput);
            Set<String> tempInputSet = new HashSet<>(inputSet);
            LocalDate fileDate = LocalDate.parse(inputDir.getName(), defaultDateFormatter);
            inputSet.removeAll(outputSet);
            System.out.println(fileDate.format(dateFormatter) + " Input co nhung Output ko co: " + inputSet);
            outputSet.removeAll(tempInputSet);
            System.out.println(fileDate.format(dateFormatter) + "Output co nhung Input ko co: " + outputSet);
        }
    }

    /**
     * Get a set of phone number from a file array
     *
     * @param fileArr file array to get phone number
     * @return Set\<String\>
     * @throws IOException when I/O error occur
     */
    static Set<String> getPhoneSet(File[] fileArr) throws IOException {
        Set<String> phoneSet = new HashSet<>();
        for (File file : fileArr) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s = "";
                int count = 1;
                while ((s = reader.readLine()) != null) {
                    if (phonePattern.matcher(s).matches()) {
                        phoneSet.add(s);
                    }
                }
            }
        }
        return phoneSet;
    }

}
