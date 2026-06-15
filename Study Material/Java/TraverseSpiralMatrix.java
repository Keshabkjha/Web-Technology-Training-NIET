import java.util.*;
public class TraverseSpiralMatrix
{   public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int arr[][] = new int[rows][cols];
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            arr[i][j] = sc.nextInt();
        }
    }
    int top = 0;
    int bottom = rows-1;
    int left =0;
    int right = cols-1;
    while(top<=bottom && left<=right) {
        for (int i = left; i <= right; i++) {
            System.out.print(arr[top][i] + " ");
        }
        top++;
        for (int i = top; i <= bottom; i++) {
            System.out.print(arr[i][right] + " ");
        }
        right--;
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                System.out.print(arr[bottom][i] + " ");
            }
            bottom--;
        }
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                System.out.print(arr[i][left] + " ");
            }
            left++;
        }
    }
}
}
