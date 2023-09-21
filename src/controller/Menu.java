package controller;

import services.ClassManage;
import services.StudentManager;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    ClassManage classManage = new ClassManage();
    StudentManager studentManager = new StudentManager();
    Scanner scanner = new Scanner(System.in);

    public Menu() throws IOException {
    }

    public void mainMenu() throws IOException {
        int choice;
       do{
           System.out.println("1 . Class Menu");
           System.out.println("2 . Student Menu");
           System.out.println("Input choice : ");
           choice = Integer.parseInt(scanner.nextLine());
           switch (choice){
               case 1 :
                  this.classMenu();
                   break;
               case 2 :
                  this.studentMenu();
                   break;
           }
       }
       while (true);
    }

    public void classMenu() throws IOException {
        int choice;
        do{
            System.out.println("1 . Create class");
            System.out.println("2 . Show all classes");
            System.out.println("3 . Edit classes");
            System.out.println("4 . Delete classes");
            System.out.println("0 . Back ");
            System.out.println("Input choice : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 :
                    classManage.addClasses();
                    break;
                case 2 :
                    classManage.showClasses();
                    break;
                case 3 :
                    classManage.editClasses();
                    break;
                case 4 :
                    classManage.deleteClasses();
                    break;
                case 0 :
                    this.mainMenu();
                    break;

            }
        }
        while (true);
    }
    public void studentMenu() throws IOException {
        int choice;
        do{
            System.out.println("1 . Create new Student");
            System.out.println("2 . Show all Students");
            System.out.println("3 . Edit Student");
            System.out.println("4 . Delete Student");
            System.out.println("0 . Back ");
            System.out.println("Input choice : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 :
                    studentManager.addStudent(classManage);
                    break;
                case 2 :
                    studentManager.showAllStudent();
                    break;
                case 3 :
                    studentManager.editStudent();
                    break;
                case 4:
                    studentManager.deleteStudent();
                    break;
                case 0 :
                    this.mainMenu();
                    break;
            }
        }
        while (true);
    }
}
