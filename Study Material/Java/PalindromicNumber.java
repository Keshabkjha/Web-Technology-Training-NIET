public class PalindromicNumber {
    public static void main(String[] args) {
        int number = 12321;
//        String str = Integer.toString(number);
//        String reverseStr = new StringBuilder(str).reverse().toString();
//        if (str.equals(reverseStr)) {
//            System.out.println(number + " is a palindromic number.");
//        } else {
//            System.out.println(number + " is not a palindromic number.");
//        }
        int rev = 0;
        while (number > rev) {
            rev = rev * 10 + number % 10;
        }
        if (number == rev) {
            System.out.println(number + " is a palindromic number.");
        }
    }
}
