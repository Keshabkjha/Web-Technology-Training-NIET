public class Day1 {
    public static void main(String[] args) {
        // Input: A string representing a list of integers separated by commas
        String input = "1,2,3,4,5";

        // Split the input string into an array of strings
        String[] stringArray = input.split(",");

        // Convert the array of strings to an array of integers
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i].trim());
        }

        // Print the resulting integer array
        for (int num : intArray) {
            System.out.print(num + " ");
        }
    }
}
