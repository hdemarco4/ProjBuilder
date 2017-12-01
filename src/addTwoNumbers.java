import java.io.*;
public class addTwoNumbers{

    public static void main(String[] args)throws IOException{

        int[] list = new int[2];

        list[0] = 36;

        list[1] = 48;

        int b = list[0] + list[1];

        Process process2 = ProgBuild.getP();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));
        bw.write((char)b);

        System.out.println(b); }}