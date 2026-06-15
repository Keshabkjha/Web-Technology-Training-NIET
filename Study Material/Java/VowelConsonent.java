import java.util.Scanner;
public class VowelConsonent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int countV = 0;
        int countC = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e'||ch == 'i' ||ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                countV++;
            }
            else{
                countC++;
            }
        }
        System.out.println("Vowel: "+countV);
        System.out.println("Consonent: "+countC);
        }
    }
