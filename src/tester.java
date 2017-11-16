public class tester {

    public static void main(String[] args){

        int[] list = new int[2];

        for(int i = 0; i < 2; i++){ list[i] = Integer.parseInt(args[i]); }

        int b = list[0] + list[1];

        System.out.println(b); }}
