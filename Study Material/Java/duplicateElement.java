import java.util.*;
public class duplicateElement {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[] arr={4,3,2,7,8,2,3,1};
        for(int i = 0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.print(arr[i]+" ");
                }
            }
        }
    }
}
