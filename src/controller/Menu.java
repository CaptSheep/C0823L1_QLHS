package controller;

import services.ClassManage;

import java.util.Scanner;

public class Menu {
    ClassManage classManage = new ClassManage();
    Scanner scanner = new Scanner(System.in);

    public void mainMenu(){
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
                   System.out.println("Menu Student");
                   break;
           }
       }
       while (true);
    }

    public void classMenu(){
        int choice;
        do{
            System.out.println("1 . Create class");
            System.out.println("2 . Show all classes");
            System.out.println("3 . Edit classes");
            System.out.println("4 . Delete classes");
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
            }
        }
        while (true);
    }
}
