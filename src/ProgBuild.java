import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ProgBuild {


    public static void main(String[] args){

        System.out.println("Enter name of new file: ");
        Scanner scan1 = new Scanner(System.in);
        String a = scan1.nextLine();


        Scanner scan2 = new Scanner(System.in);
        int[] list = new int[2];

        for (int k = 0; k < 2; k++) {
            System.out.println("Enter two numbers (hit enter after each): ");
            list[k] = scan2.nextInt();
        }


        writer(a, list);

    }

    public static void writer(String a, int[] list){

        try {
            PrintWriter writer = new PrintWriter(a + ".txt", "UTF-8");
            writer.println("int[] list = new int[2]");
            
            writer.println("int b = list[0] + list[1];");
            writer.println("System.out.println(b);");
            writer.close();

        } catch (IOException ex) {
        // report
        }
    }
}
