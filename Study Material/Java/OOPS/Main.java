package OOPS;

public class Main{
    public static void main(String[] args) {
//        Student s1=new Student();
//        s1.studentId=101;
//        s1.studentName="John";
//        s1.studentAge=20;
//        s1.display();
//        Student s2 = new Student();
//        s2.studentId=102;
//        s2.studentName="Sam";
//        s2.studentAge=21;
//        s2.display();
        Student s1 = new Student(101,"John",20);
        s1.display();
        Student s2 = new Student(102,"Sam",21);
        s2.display();
    }
}
