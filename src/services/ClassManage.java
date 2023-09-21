package services;

import model.Classes;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassManage {
    // Tạo nơi lưu trữ lớp
    // CRUD lớp : C - Create , R - Read , U - Update , D - Delete
    // Thứ lấy dữ liệu người dùng nhập vào

    private ArrayList<Classes> classes;
    private Scanner scanner;

    public ClassManage() throws IOException {
        classes = new ArrayList<Classes>();
        scanner = new Scanner(System.in);
        this.readFileClass(classes);
    }

    public void showClasses(){
       // for ( KDL bien : mang ) {}
        for(Classes classes : classes){
            System.out.println(classes);
        }
    }



    public void writeFileClass(ArrayList<Classes> classes) throws IOException {
        // Bước 1 : Khai báo FileWriter ( nơi minh sẽ ghi thông tin vào )
        FileWriter fileWriter = new FileWriter("Class.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Bước 2 : Muốn in cái gì ????
        for(Classes classInfo : classes){
            bufferedWriter.write(classInfo.classInfo());
            // newLine () sẽ in ra 1 dòng mới thay vì ghi cùng dòng với giá trị trước
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();

    }

    public void readFileClass(ArrayList<Classes> classes) throws IOException {
        FileReader fileReader = new FileReader("Class.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data = "";
        while((data = bufferedReader.readLine()) != null){
            // data = 1,C0823L1
            // data sau khi split = {1,C0823L1} ( mảng gồm 2 phần tử ( id, name ) )
            String [] arrayData  = data.split(",");
            Classes newClass = new Classes(arrayData[1]);
            classes.add(newClass);
        }
    }

    public void addClasses() throws IOException {
        System.out.println("Input class name : ");
        String nameClass = scanner.nextLine();


        // Bước 1 : Hứng dữ liệu người dùng nhập vào biến nameClass
        // Bước 2 : Tạo mới 1 đối tượng class với constructor Classes( String name )
        // Bước 3 : gắn giá trị nameClass vào name trong constructor
        // Bước 4 :  Classes class = new Class("name")

        classes.add(new Classes(nameClass));
        this.writeFileClass(classes);
        System.out.println("Add Class Success");
    }

    // Tìm kiếm luôn trả về đối tượng ( nếu có )
    // Nếu không có trả về null;

    public Classes findClassByID( int id ){
        // Nếu dùng array thì là arr.length;
        // Nếu dùng arraylist thì là arr.size();
        // Duyệt toàn bộ mảng => kiểm tra id xem có tồn tại không ?
        for (int i = 0; i < classes.size(); i++) {

            // Nêu dùng mảng thì là classes[i]
            // Nếu dùng arraylist thì là classes.get(i)

            if(classes.get(i).getId() == id){
                return classes.get(i);
            }
        }
        return null;
    }

    public void editClasses(){
        // Bước 1 : Nhập ID
        // Bước 2 : Kiểm tra đối tượng với id vừa nhập
        // Bước 3 : Nếu có đối tượng ( != null ) thì sửa thông tin
        // Bước 4 : Nếu không có đối tượng thì trả về null
        System.out.println("Input ID class : ");
        int id = Integer.parseInt(scanner.nextLine());
        Classes findClass = this.findClassByID(id);
        if(findClass != null){
            System.out.println("Input new class name : ");
            String name = scanner.nextLine();
            findClass.setName(name);
            System.out.println("Edit Success");
        }
        else {
            System.out.println("ID not found.");
        }
    }

    public void deleteClasses(){
        System.out.println("Input ID class : ");
        int id = Integer.parseInt(scanner.nextLine());
        Classes findClass = this.findClassByID(id);
        if(findClass != null){
            // arraylist hỗ trợ xoá bằng phương thức remove
            // Trong phương thức sẽ truyền 1 đối tượng muốn xoá
            classes.remove(findClass);
            System.out.println("Delete Success");
        }else {
            System.out.println("ID not found");
        }
    }


}
