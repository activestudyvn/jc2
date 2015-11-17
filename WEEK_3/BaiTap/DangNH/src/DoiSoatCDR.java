import java.util.regex.Pattern;

/**
 * Created by 404NotFound on 11/12/2015.
 */
public class DoiSoatCDR {
    public DoiSoatCDR() {
        Pattern phonePattern = Pattern.compile("849\\d+");
        Pattern inputPattern = Pattern.compile("cdr_\\d+_8x56_\\d.txt");
        Pattern outputPattern = Pattern.compile("\\d+_8x56_\\d.txt");

    }
}
