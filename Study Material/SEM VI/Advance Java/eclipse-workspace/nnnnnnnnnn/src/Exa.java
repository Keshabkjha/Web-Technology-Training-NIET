class A extends Exception {}
public class Exa{
    public static void main(String[] args){
        int x = 5, y = 0;
        try{
            y = y/x;
            try{
                throw new A();
            }catch (A e){
                System.out.println("Exception");
            }
        }catch(ArithmeticException e){
            System.out.print("Error");
        }finally{
            System.out.print("finally");
        }
    }
}