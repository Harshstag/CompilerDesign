import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SkipWhiteSpaces {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(outputFile);

        String line;
        while ((line = reader.readLine()) != null) {
            String trimmedLine = line.trim();
            if (!trimmedLine.isEmpty()) {
                writer.println(trimmedLine);
            }
        }

        reader.close();
        writer.close();
    }
}