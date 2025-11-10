public class CommandLine {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            System.out.println("Usage: java CommandLine <operator> <num1> <num2> ...");
            System.out.println("Supported operators: +  -  *  /");
            return;
        }

        String operator = args[0];

        // Check if operator is valid
        if (!operator.matches("[+\\-*/]")) {
            System.out.println("Invalid operator: " + operator);
            System.out.println("Please use one of the following: +  -  *  /");
            return;
        }

        // Check if there are numbers to operate on
        if (args.length == 1) {
            System.out.println("Operator provided but no numbers.");
            System.out.println("Usage: java CommandLine " + operator + " <num1> <num2> ...");
            return;
        }

        // Convert arguments to numbers
        double[] numbers = new double[args.length - 1];
        try {
            for (int i = 1; i < args.length; i++) {
                numbers[i - 1] = Double.parseDouble(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: All arguments after the operator must be valid numbers.");
            return;
        }

        // Perform calculation
        double result = numbers[0];
        switch (operator) {
            case "+":
                for (int i = 1; i < numbers.length; i++) result += numbers[i];
                break;
            case "-":
                for (int i = 1; i < numbers.length; i++) result -= numbers[i];
                break;
            case "*":
                for (int i = 1; i < numbers.length; i++) result *= numbers[i];
                break;
            case "/":
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] == 0) {
                        System.out.println("Error: Division by zero.");
                        return;
                    }
                    result /= numbers[i];
                }
                break;
        }

        System.out.println("Result: " + result);
    }
}




// ex:
// java CommandLine "*" 5 2
// java CommandLine / 200 20 
// java CommandLine + 500 234
// java CommandLine + 1 2
// java CommandLine - 8 3 