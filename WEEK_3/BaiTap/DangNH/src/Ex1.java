import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 404NotFound on 11/8/2015.
 */
public class Ex1 {
    public static void main(String[] args) throws IOException {
        //Get input string
        Path path = Paths.get("inPut1.txt");
        byte[] encoded = Files.readAllBytes(path);
        String input = new String(encoded);

        //Find upper case char
        String upperCaseRegex = "[A-Z]";
        Matcher regexMatcher = Pattern.compile(upperCaseRegex).matcher(input);
        System.out.println("Uppercase char:");
        while (regexMatcher.find()){
            System.out.println(regexMatcher.group(0));
        }
        System.out.println();
        //No. of char
        System.out.println("No. of char: " + input.toCharArray().length);

        //Count lower case char
        int count = 0;
        String lowerCaseRegex = "[^A-Z]";
        regexMatcher = Pattern.compile(lowerCaseRegex).matcher(input);
        while (regexMatcher.find()) {
            count++;
        }
        System.out.print("No. of lower case char: " );
        System.out.println(count);

        //replace string
        input = Pattern.compile(" +\\t|\\t +| +").matcher(input).replaceAll(" ");

        //insert string
        StringBuilder sb = new StringBuilder(input);
        sb.insert(input.indexOf("$")+1, "o con ga cua toi");

        //write to output.txt
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(sb.toString());
        }

    }
}
