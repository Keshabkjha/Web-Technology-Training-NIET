import java.util.*;
public class ReducewithCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String res = "";
        int count = 1;
        for(int i = 1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }
            else{
                res = res + str.charAt(i-1);
                if(count>1){
                    res = res + count;
                    count = 1;
            }
        }
            if(i==str.length()-1){
                res = res + str.charAt(i);
                if(count>1){
                    res = res + count;
                }
            }
        }
        System.out.println(res);
    }
}
