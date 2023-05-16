import java.util.Scanner;
public class RecursiveDescentParser {
    private String input;
    private int index;
    
    public RecursiveDescentParser(String input) {
        this.input = input;
        this.index = 0;
    }
    
    // Grammar rule: expression -> term { ( '+' | '-' ) term }
    private double expression() {
        double result = term();
        
        while (index < input.length()) {
            char operator = input.charAt(index);
            if (operator != '+' && operator != '-') {
                break;
            }
            index++;
            
            double term = term();
            if (operator == '+') {
                result += term;
            } else {
                result -= term;
            }
        }
        
        return result;
    }
    
    // Grammar rule: term -> factor { ( '*' | '/' ) factor }
    private double term() {
        double result = factor();
        
        while (index < input.length()) {
            char operator = input.charAt(index);
            if (operator != '*' && operator != '/') {
                break;
            }
            index++;
            
            double factor = factor();
            if (operator == '*') {
                result *= factor;
            } else {
                result /= factor;
            }
        }
        
        return result;
    }
    
    // Grammar rule: factor -> number | '(' expression ')'
    private double factor() {
        double result;
        char ch = input.charAt(index);
        if (ch >= '0' && ch <= '9') {
            result = number();
        } else if (ch == '(') {
            index++;
            result = expression();
            index++;
        } else {
            throw new RuntimeException("Invalid input: " + ch);
        }
        return result;
    }
    
    // Grammar rule: number -> digit { digit }
    private double number() {
        double result = 0;
        while (index < input.length()) {
            char ch = input.charAt(index);
            if (ch < '0' || ch > '9') {
                break;
            }
            result = result * 10 + (ch - '0');
            index++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();
        scanner.close();
        
        RecursiveDescentParser parser = new RecursiveDescentParser(input);
        double result = parser.expression();
        System.out.println("Result: " + result);
    }
}
