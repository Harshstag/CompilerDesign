public class IfElseToWhile {

    public static void main(String[] args) {
        int number = 10;

        if (number > 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }

        // Convert the if-else statement to a while loop
        while (number > 0) {
            System.out.println("The number is positive");
            number--;
        }
    }
}