import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class ProgBuild {
    final static PipedInputStream  input  = new PipedInputStream();

    public static void main(String[] args) throws IOException, InterruptedException{

        Random rand = new Random();
        int[] list = new int[2];

        for (int k = 0; k < 2; k++) {
            list[k] = rand.nextInt(100);
        }

//        String a = "add" + list[0] + "Plus" + list[1];
        String a = "addTwoNumbers";

        writer(a, list);

        Path path = FileSystems.getDefault().getPath(".");
        String compile = "javac " + a + ".java";
        String run = "java " + a;
        String[] commands = {"CMD", "/C", path.toString(), compile, run};

        ProcessBuilder pb2 = new ProcessBuilder(commands);
        Process process2 = pb2.start();


        input.connect(addTwoNumbers.os);

        int s = 0;
        int data = input.read();
        if(data != -1) {
            s = data;
        }
            System.out.println("The answer is: " + s);
    }

    public static void writer(String a, int[] list){

        try {
            PrintWriter out = new PrintWriter(a + ".java", "UTF-8");
            out.println("import java.io.*;");
            out.println("public class " + a + "{\n");
            out.println("    final static PipedOutputStream os = new PipedOutputStream();\n");
            out.println("    public static void main(String[] args)throws IOException{\n");
            out.println("        int[] list = new int[2];\n");
            out.println("        list[0] = " + list[0] + ";\n");
            out.println("        list[1] = " + list[1] + ";\n");
            out.println("        int b = list[0] + list[1];\n");
            out.println("        os.connect(ProgBuild.input);\n");
            out.println("        os.write((byte)b); }}");
            out.close();

        } catch (IOException ex) {
            System.out.println("File write error");
        }
    }
}