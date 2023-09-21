import controller.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.mainMenu();

//        File file = new File("demo.txt");
//        FileWriter fileWriter = new FileWriter(file);
////        fileWriter.write("C0823L1");
////        // Nếu chưa có close () thì sẽ không ghi vào file
////        fileWriter.close();
//
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.write("Hello ACE");
//        bufferedWriter.close();
//        fileWriter.close();
//
//        System.out.println("Is exist ? " +  file.canWrite());
    }
}