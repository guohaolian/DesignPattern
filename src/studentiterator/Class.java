package studentiterator;

import java.util.*;

public class Class {
    private List<Student> studentList=new ArrayList<Student>();
    public void addStudent(Student student){
        studentList.add(student);
    }

    public void sortStudentByAge(){
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.getAge()- s1.getAge();
            }
        });

    }

    public Iterator<Student> iterator(){
        return new Itr();
    }

    private class Itr implements Iterator<Student> {
        private int cursor;
        private int expectedSize = studentList.size();

        @Override
        public boolean hasNext() {
            return cursor!=expectedSize;
        }

        @Override
        public Student next() {
            checkExpectedSize();
            return studentList.get(cursor++);
        }

        private void checkExpectedSize() {
            if(studentList.size()!=expectedSize){
                throw new ConcurrentModificationException();
            }
        }
    }

}
