import java.io.*;
import java.util.*;

public class ProgBuild {

    public static void main(String[] args) throws IOException, InterruptedException{

        Random rand = new Random();
        int[] list = new int[2];

        for (int k = 0; k < 2; k++) {
            list[k] = rand.nextInt(100);
        }

        String a = "add" + list[0] + "Plus" + list[1];
        File fa = new File(a + ".java");

        writer(a, list);

        System.out.println("First number: " + list[0]);
        System.out.println("Second number: " + list[1]);

        compileP(fa);
        runP(fa);
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
            out.println("        System.out.println(b); }}");
            out.close();

        } catch (IOException ex) {
            System.out.println("File write error");
        }
    }

    public static void compileP(File fa){
        System.out.println("Compiling " + fa);
        try {
            Process pro = Runtime.getRuntime().exec("javac " + fa.getAbsoluteFile());
            pro.waitFor();
        }
        catch (Exception e){
            System.err.println("Error compiling " + fa);
        }
    }

    public static String classN(File file) {
        return file.getName().split(".java")[0];
    }

    public static void runP(File fa){
        System.out.println("Running " + fa);
        String cn = classN(fa);
        try{
            Process pro = Runtime.getRuntime().exec("java " + cn);
            BufferedReader in = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                System.out.println("The answer is: " + s);
            }
            pro.waitFor();
        } catch (Exception e) {
            System.err.println("Error running " + fa);
            e.printStackTrace();
        }
    }
}