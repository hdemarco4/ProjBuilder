import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ProgBuild {


    public static void main(String[] args) throws IOException, InterruptedException{

        System.out.println("Enter name of new file: ");
        Scanner scan1 = new Scanner(System.in);
        String a = scan1.nextLine();


        Scanner scan2 = new Scanner(System.in);
        int[] list = new int[2];

        for (int k = 0; k < 2; k++) {
            System.out.println("Enter two numbers (hit enter after each): ");
            list[k] = scan2.nextInt();
        }

        writer(a);

        String commands = "cmd.exe", "/c", "javac " + a + ".java", "java " + a, list[0] + "", list[1] + "";

        ProcessBuilder pb2 = new ProcessBuilder(commands);
        Process process2 = pb2.start();
        int answer = process2.waitFor();

        System.out.println("The answer is " + answer);


    }

    public static void writer(String a){

        try {
            PrintWriter out = new PrintWriter(a + ".java", "UTF-8");
            out.println("public class " + a + "{\n");
            out.println("    public static void main(String[] args){\n");
            out.println("        int[] list = new int[2];\n");
            out.println("        for(int i = 0; i < 2; i++){ list[i] = Integer.parseInt(args[i]); }\n");
            out.println("        int b = list[0] + list[1];\n");
            out.println("        System.out.println(b); }}\n");
            out.close();

        } catch (IOException ex) {
            System.out.println("File write error");
        }
    }
}
