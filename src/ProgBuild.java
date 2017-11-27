import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
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

        writer(a, list);

        Path path = FileSystems.getDefault().getPath(".");
        String compile = "javac " + a + ".java";
        String run = "java " + a;
        String[] commands = {"CMD", "/C", path.toString(), compile, run};

        ProcessBuilder pb2 = new ProcessBuilder(commands);
        Process process2 = pb2.start();

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process2.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null)
        {
            System.out.println("The answer is: " + s);
        }

    }

    public static void writer(String a, int[] list){

        try {
            PrintWriter out = new PrintWriter(a + ".java", "UTF-8");
            out.println("import java.io.*;");
            out.println("public class " + a + "{\n");
            out.println("    public static void main(String[] args){\n");
            out.println("        int[] list = new int[2];\n");
            out.println("        OutputStream os = new FileOutputStream(\"file.txt\");\n");
            out.println("        list[0] = " + list[0] + ";\n");
            out.println("        list[1] = " + list[1] + ";\n");
            out.println("        int b = list[0] + list[1];\n");
            out.println("        os.write(b);\n");
            out.println("        os.close(); }}\n");
            out.close();

        } catch (IOException ex) {
            System.out.println("File write error");
        }
    }
}