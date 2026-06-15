import java.util.*;
public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=0;i<n;i++){
            ll.add(sc.nextInt());
        }
        Collections.reverse(ll);
        System.out.println(ll);
    }
}
