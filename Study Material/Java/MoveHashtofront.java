import java.util.*;
public class MoveHashtofront {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = s.trim();
        String res = "";
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='#'){
                res+=str.charAt(i);
            }
        }
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)!='#'){
                res+=str.charAt(i);
            }
        }
        System.out.println(res);

    }
}
















