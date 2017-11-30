import java.io.*;
public class addTwoNumbers{

    public static void main(String[] args)throws IOException{

        int[] list = new int[2];

        list[0] = 36;

        list[1] = 48;

        int b = list[0] + list[1];
/*
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);
        bw.write(Integer.toString(b));
        StringBuffer sb = sw.getBuffer();
        System.out.println(sb);
*/
        StringWriter sw = new StringWriter();
        sw.write(b + "");

        System.out.println(b); }}