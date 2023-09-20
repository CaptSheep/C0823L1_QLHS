package services;

import model.Classes;
import model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    ArrayList<Student> students ;
    Scanner scanner ;

    public StudentManager() {
        students = new ArrayList<>();
        scanner =  new Scanner(System.in);
    }

    public void showAllStudent(){
        for (Student student : students){
            System.out.println(student);
        }
    }

    public void addStudent(ClassManage classManage){
        System.out.println("Input Student name :");
        String name= scanner.nextLine();
        System.out.println("Input Student Age :");
//        int age = scanner.nextInt();
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Input Student Gender :");
        String gender = scanner.nextLine();
        System.out.println("Input Student Point : ");
        double point = Double.parseDouble(scanner.nextLine());

        // Bước 1 : Hiển thị thông báo nhập ID lớp
        // Bước 2 : Hiển thị danh sách lớp đang có trong mảng
        // Bước 3 : Cho người dùng nhập ID lớp
        // Bước 4 : Kiểm tra xem ID nhập có trùng ID lớp không ?
        // Bước 5 : Nếu có thì thêm lớp vừa chọn vào trong đối tượng Student
        // Bước 6 : Nếu không thì in ra ID sai ( có thể làm hoặc k )
        System.out.println("Input ID Class : ");
        classManage.showClasses();
        System.out.println("Input your choice: ");
        int id = Integer.parseInt(scanner.nextLine());
        Classes findClass = classManage.findClassByID(id);
        if(findClass != null){
            Student student = new Student(name,age,gender,point,findClass);
            students.add(student);
            System.out.println("Create Student Success");
        }
        else {
            System.out.println("ID Not Found");
        }

    }

    public Student findStudentById(int id ){

        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId() == id){
                return students.get(i);
            }
        }
        return null;
    }

    public void editStudent(){
        System.out.println("Input Student ID :");
        int id = Integer.parseInt(scanner.nextLine());
        Student findStudent = this.findStudentById(id);
        if(findStudent != null){
            System.out.println("Input New Student Name : ");
            String name = scanner.nextLine();
            System.out.println("Input New Student Age : ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Input New Student Gender : ");
            String gender = scanner.nextLine();
            System.out.println("Input New Student Point : ");
            double point = Double.parseDouble(scanner.nextLine());
            findStudent.setName(name);
            findStudent.setAge(age);
            findStudent.setGender(gender);
            findStudent.setAvgPoint(point);
            System.out.println("Edit Student Success");
        }
        else {
            System.out.println("ID Not Found");
        }

    }

    public void deleteStudent(){
        System.out.println("Input Student ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        Student findStudent = this.findStudentById(id);
        if(findStudent != null){
            students.remove(findStudent);

        }
        else {
            System.out.println("ID Not Found");
        }
    }


}
