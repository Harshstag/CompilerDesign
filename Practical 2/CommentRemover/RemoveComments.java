import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveComments {

    private static final Pattern SINGLE_LINE_COMMENT_PATTERN = Pattern.compile("//.*");
    private static final Pattern MULTI_LINE_COMMENT_PATTERN = Pattern.compile("/\\*(.*?)\\*/");

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(outputFile);

        String line;
        while ((line = reader.readLine()) != null) {
            Matcher singleLineCommentMatcher = SINGLE_LINE_COMMENT_PATTERN.matcher(line);
            Matcher multiLineCommentMatcher = MULTI_LINE_COMMENT_PATTERN.matcher(line);

            if (!singleLineCommentMatcher.find() && !multiLineCommentMatcher.find()) {
                writer.println(line);
            }
        }

        reader.close();
        writer.close();
    }
}