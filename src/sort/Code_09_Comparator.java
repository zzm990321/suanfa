package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 排序分析 实现Comparator里的compare方法 前面的做被减数 表示增序
 */
public class Code_09_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }
    public static  class  AgeAscendIngComparator implements Comparator<Student>{
        //降序
        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void printStudents(Student[] students){
        for(Student student : students){
            System.out.println("Name : " + student.name+ ",ID" + student.id +",age" + student.age);
        }
        System.out.println("===============");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A",1,23);
        Student student2 = new Student("B",2,21);
        Student student3 = new Student("C",3,22);

        Student[] students = new Student[]{student3 ,student2,student1};
        printStudents(students);

        Arrays.sort(students,new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students,new AgeAscendIngComparator());
        printStudents(students);
    }
}
