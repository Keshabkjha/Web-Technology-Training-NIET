import java.util.*;
public class RotateArraybyK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] res =new int[nums.length];
        int c=0;
        for(int i = nums.length-k;i<nums.length;i++){
            res[c]= nums[i];
            c++;
        }
        for(int i = 0;i<nums.length-k;i++){
            res[c] = nums[i];
            c++;
        }
        System.out.println(Arrays.toString(res));
    }
}
