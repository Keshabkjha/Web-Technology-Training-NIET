public class ArmstrongChecker {  

    public static String checkArmstrong(int num) {  
        // Convert the number to string to easily access digits  
        String numStr = Integer.toString(num);  
        // Calculate the number of digits  
        int n = numStr.length();  
        // Initialize a sum variable  
        int sumOfPowers = 0;  
        
        // Calculate the sum of each digit raised to the power of n  
        for (char digitChar : numStr.toCharArray()) {  
            int digit = Character.getNumericValue(digitChar);  
            sumOfPowers += Math.pow(digit, n);  
        }  
        
        // Check if sumOfPowers is equal to the original number  
        if (sumOfPowers == num) {  
            return "yes";  
        } else {  
            return "no";  
        }  
    }  

    public static void main(String[] args) {  
        // Example Test Cases  
        System.out.println(checkArmstrong(1634));  // Output: "yes"  
        System.out.println(checkArmstrong(372));   // Output: "no"  
    }  
}