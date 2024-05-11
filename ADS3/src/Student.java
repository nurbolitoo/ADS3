
public class Student {
    private String name;
    private int studentId;

    public Student(String name) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName(){
        return name;
    }
    public int getStudentId(){
        return studentId;
    }

    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}