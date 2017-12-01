import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class ProgBuild {
    private static Process process;

    public static void main(String[] args) throws IOException, InterruptedException{

        Random rand = new Random();
        int[] list = new int[2];

        for (int k = 0; k < 2; k++) {
            list[k] = rand.nextInt(100);
        }

        String a = "add" + list[0] + "Plus" + list[1];
//        String a = "addTwoNumbers";

        writer(a, list);

        Path path = FileSystems.getDefault().getPath(".");
        String compile = "javac " + a + ".java";
        String run = "java " + a;
        String[] commands = {"CMD", "/C", path.toString(), compile, run};

        ProcessBuilder pb2 = new ProcessBuilder(commands);
        Process process2 = pb2.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process2.getInputStream()));

        String s;

        while((s=br.readLine())!=null){
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
            out.println("        list[0] = " + list[0] + ";\n");
            out.println("        list[1] = " + list[1] + ";\n");
            out.println("        int b = list[0] + list[1];\n");

            out.println("        Process process2 = ProgBuild.getP();\n");
            out.println("        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));\n");
            out.println("        bw.write((char)b);\n");

            out.println("        System.out.println(b); }}");
            out.close();

        } catch (IOException ex) {
            System.out.println("File write error");
        }
    }

    public void setP(Process process2){
        process = process2;
    }
    public static Process getP(){
        return process;
    }
}