import java.util.Scanner;

public class Month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<1 || n>12){
            System.out.println("Invalid Month");
        }
        else{
            if(n>=3 && n<=5){
                System.out.println("Spring");
            }
            else if(n>=6 && n<=8){
                System.out.println("Summer");
            }
            else if(n>=9 && n<=11){
                System.out.println("Autumn");
            }
            else{
                System.out.println("Winter");
            }
        }
    }
}
