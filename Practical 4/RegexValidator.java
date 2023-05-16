import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {

    private static final Pattern REGEX_PATTERN = Pattern.compile("ab*");

    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String inputString = System.console().readLine();

        Matcher matcher = REGEX_PATTERN.matcher(inputString);
        if (matcher.matches()) {
            System.out.println("The string \"" + inputString + "\" matches the regular expression \"" + REGEX_PATTERN.pattern() + "\"");
        } else {
            System.out.println("The string \"" + inputString + "\" does not match the regular expression \"" + REGEX_PATTERN.pattern() + "\"");
        }
    }
}