import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToIntegerConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a Roman numeral
        System.out.print("Enter a Roman numeral: ");

        // Read the Roman numeral input from the user
        String romanNumeral = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity

        // Convert the Roman numeral to an integer
        int integerEquivalent = romanToInteger(romanNumeral);

        // Display the integer equivalent
        System.out.println("Integer equivalent: " + integerEquivalent);

        // Close the Scanner to release resources
        scanner.close();
    }

    // Function to convert a Roman numeral to an integer
    public static int romanToInteger(String romanNumeral) {
        // Create a map to store the values of Roman numerals
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Iterate through the Roman numeral string from right to left
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentChar = romanNumeral.charAt(i);
            int currentValue = romanValues.get(currentChar);

            // Check if we need to subtract (e.g., IV or IX)
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
