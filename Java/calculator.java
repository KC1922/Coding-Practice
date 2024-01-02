import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*simple calculator that takes in a calculation and returns the result.
supports basic arithmetic, trigonometric functions, logarithms, and exponentiation.
also supports using the result of the previous calculation in the next calculation.
to use the result of the previous calculation, enter the operator/function followed by the number.
e.g., to add 5 to the previous result, enter "+ 5". To calculate the sine of the previous result, enter "sin".
to clear the result, enter "clear".
to see a list of available operations, enter "help".
program demonstrates use of functional interfaces, while loops to simulate quitting, and a Map to store operators and their corresponding operations.*/
public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean quit = false;

        while (!quit) {
            System.out.print("Enter a calculation (e.g., '1 + 2' or 'sin 30'), or type 'help' to see avaiable operations: ");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");

            if (inputArray.length == 1 && inputArray[0].equalsIgnoreCase("help")) {
                displayHelp();
                continue;
            }


            double num1;
            String operator;
            double num2;

            //use a Map to store operators and their corresponding operations
            Map<String, Operation> operations = new HashMap<>();
            operations.put("+", (a, b) -> a + b);
            operations.put("-", (a, b) -> a - b);
            operations.put("*", (a, b) -> a * b);
            operations.put("/", (a, b) -> b == 0 ? Double.POSITIVE_INFINITY : a / b);
            operations.put("sin", (a, b) -> Math.sin(Math.toRadians(b)));
            operations.put("cos", (a, b) -> Math.cos(Math.toRadians(b)));
            operations.put("tan", (a, b) -> Math.tan(Math.toRadians(b)));
            operations.put("asin", (a, b) -> Math.asin(Math.toRadians(b)));
            operations.put("acos", (a, b) -> Math.acos(Math.toRadians(b)));
            operations.put("atan", (a, b) -> Math.atan(Math.toRadians(b)));
            operations.put("log", (a, b) -> Math.log10(b));
            operations.put("ln", (a, b) -> Math.log(b));
            operations.put("sqrt", (a, b) -> Math.sqrt(b));
            operations.put("^", (a, b) -> Math.pow(a, b));

            try {
                if (inputArray.length == 3) 
                {
                    num1 = Double.parseDouble(inputArray[0]);
                    operator = inputArray[1];
                    num2 = Double.parseDouble(inputArray[2]);
                } 
                else if (inputArray.length == 2) 
                {
                    num1 = result;
                    operator = inputArray[0].toLowerCase();
                    num2 = Double.parseDouble(inputArray[1]);
                } 
                //check if string is more than 1 character to know if sin, cos, tan, etc.
                else if (inputArray.length == 1 && inputArray[0].length() > 1)
                {
                    num2 = result;
                    operator = inputArray[0].toLowerCase();
                    num1 = 0;
                }
                else 
                {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input. Ensure input is a valid calculation or 'clear'.");
                continue;
            }



            //check if the operator exists in the Map
            Operation operation = operations.get(operator);
            if (operation != null) {
                result = operation.calculate(num1, num2);
            } else {
                System.out.println("ERROR: Invalid operator or function.");
                continue;
            }

            System.out.println("Result: " + result);
            System.out.print("Continue? (y/n/clear): ");
            String continueInput = scanner.nextLine();
            switch (continueInput.toLowerCase()) {
                case "y":
                    break;
                case "n":
                    quit = true;
                    break;
                case "clear":
                    result = 0;
                    System.out.println("Result cleared.");
                    break;
                default:
                    System.out.println("ERROR: Invalid input. Exiting program.");
                    quit = true;
                    break;
            }

        }

        scanner.close();
    }

    //functional interface for operations
    interface Operation {
        double calculate(double a, double b);
    }

    //helper method to display help
    private static void displayHelp() {
        System.out.println("\nAvailable operations: \n______________________\n");
        System.out.printf("%-30s %-30s %-30s%n", "Addition: +", "Subtraction: -", "Multiplication: *");
        System.out.printf("%-30s %-30s %-30s%n", "Division: /", "Sine: sin", "Cosine: cos");
        System.out.printf("%-30s %-30s %-30s%n", "Tangent: tan", "Arcsine: asin", "Arccosine: acos");
        System.out.printf("%-30s %-30s %-30s%n", "Arctangent: atan", "Logarithm (base 10): log", "Natural logarithm: ln");
        System.out.printf("%-30s %-30s %-30s%n", "Square root: sqrt", "Exponentiation: ^", "Clear result: clear");
        System.out.println("\nHow to use previous calulation result: \n_______________________________________\n");
        System.out.println("  To add 5 to the last result: + 5");
        System.out.println("  To calculate sine (or similar) of the last result: sin");
        System.out.println();
    }
}
