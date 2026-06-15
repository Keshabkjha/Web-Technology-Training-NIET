public class PrimeCheck {
    public static void main(String[] args) {
        int num = 29; // this is the number to test
        boolean isPrime = true;

        // check if the number is divisible by any number other than 1 and itself
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
