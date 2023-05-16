import java.util.Scanner;

public class ThreeAddressCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an arithmetic expression: ");
        String expression = scanner.nextLine();

        // Create a parse tree for the expression.
        ParseTree parseTree = new ParseTree(expression);

        // Create a list of three address code instructions.
        List<Instruction> instructions = new ArrayList<>();

        // Recursively generate three address code for the parse tree.
        generate3AddressCode(parseTree, instructions);

        // Print the three address code instructions.
        for (Instruction instruction : instructions) {
            System.out.println(instruction);
        }
    }

    private static void generate3AddressCode(ParseTree parseTree, List<Instruction> instructions) {
        if (parseTree.isLeaf()) {
            // The parse tree is a leaf node, so the instruction is simply to store the value of the leaf node in a temporary variable
            Instruction instruction = new Instruction(parseTree.getValue(), "temp");
            instructions.add(instruction);
        } else {
            // The parse tree is not a leaf node, so the instruction is to perform an operation on the values of the children nodes
            String operator = parseTree.getOperator();
            Instruction leftInstruction = generate3AddressCode(parseTree.getLeftChild(), instructions);
            Instruction rightInstruction = generate3AddressCode(parseTree.getRightChild(), instructions);
            Instruction instruction = new Instruction(operator, leftInstruction.getResult(), rightInstruction.getResult());
            instructions.add(instruction);
        }
    }
}

class ParseTree {

    private String value;
    private String operator;
    private ParseTree leftChild;
    private ParseTree rightChild;

    public ParseTree(String value) {
        this.value = value;
    }

    public ParseTree(String value, String operator, ParseTree leftChild, ParseTree rightChild) {
        this.value = value;
        this.operator = operator;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getValue() {
        return value;
    }

    public String getOperator() {
        return operator;
    }

    public ParseTree getLeftChild() {
        return leftChild;
    }

    public ParseTree getRightChild() {
        return rightChild;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}

class Instruction {

    private String operator;
    private String leftOperand;
    private String rightOperand;
    private String result;

    public Instruction(String operator, String leftOperand, String rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.result = null;
    }

    public String getOperator() {
        return operator;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}