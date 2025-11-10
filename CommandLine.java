public class CommandLine {
 
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: No arguments provided.");
            return;
        }
        
        // Check if only operator is provided (no numbers)
        if (args.length == 1) {
            System.out.println("Error: Operator provided only");
            return;
        }
        
        // Get the operator (first argument)
        String operator = args[0];
        
        // Convert all remaining arguments to numbers
        double[] numbers = new double[args.length - 1];
        try {
            for (int i = 1; i < args.length; i++) {
                numbers[i - 1] = Double.parseDouble(args[i]); // .parseDouble turns our text into type double
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: All arguments after the operator must be valid numbers.");
            return;
        }
        
        // Perform the calculation
        double result = calculate(operator, numbers);
        
        // Display the result
        System.out.println("Result: " + result);
    }

    private static double calculate(String operator, double[] numbers) {
        double result;
        
        switch (operator) {
            case "+":
                result = 0;
                for (double num : numbers) {
                    result += num;
                }
                break;
                
            case "*":
                result = 1;
                for (double num : numbers) {
                    result *= num;
                }
                break;
                
            case "-":
                result = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    result -= numbers[i];
                }
                break;
                
            case "/":
                result = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        return 0;
                    }
                    result /= numbers[i];
                }
                break;
                
            default:
                result = 0;
                break;
        }
        
        return result;
    }
}