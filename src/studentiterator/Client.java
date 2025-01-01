package studentiterator;
//µü´úÆ÷Ä£Ê½
public class Client {
    public static void main(String[] args) {
        Class cla=new Class();
        cla.addStudent(new Student("John",25));
        cla.addStudent(new Student("Jane",26));
        cla.addStudent(new Student("Jack",27));
        cla.addStudent(new Student("Jill",28));
        cla.addStudent(new Student("Bob",29));
        cla.addStudent(new Student("David",30));
        cla.sortStudentByAge();
        Iterator<Student> it=cla.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
