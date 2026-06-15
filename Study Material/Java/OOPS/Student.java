package OOPS;

public class Student {
    int studentId;
    String studentName;
    int studentAge;
    public Student(int studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
    public void display(){
        System.out.println(studentId);
        System.out.println(studentName);
        System.out.println(studentAge);
    }

}
