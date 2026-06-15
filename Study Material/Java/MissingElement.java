import java.util.*;
public class MissingElement {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int [] arr = {1,2,4,5,6};
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 1;i<n;i++){
            if(arr[i]-arr[i-1]!=1){
                System.out.println(arr[i-1]+1);}
        }
    }
}
