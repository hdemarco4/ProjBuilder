import java.io.*;
public class addTwoNumbers{
    final static PipedOutputStream os = new PipedOutputStream();

    public static void main(String[] args)throws IOException{

        int[] list = new int[2];

        list[0] = 36;

        list[1] = 48;

        int b = list[0] + list[1];

        os.connect(ProgBuild.input);

        os.write((byte)b); }}