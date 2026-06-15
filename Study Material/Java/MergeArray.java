import java.util.Arrays;
public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int l = array1.length + array2.length;
        int c = 0;
        int[] mergedarray = new int[l];
        for(int i = 0;i<array1.length;i++){
            mergedarray[c] = array1[i];
            c++;

        }
        for(int j = 0;j<array2.length;j++){
            mergedarray[c] = array2[j];
            c++;
        }
        System.out.println(Arrays.toString(mergedarray));
    }

}
