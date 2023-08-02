package Arrays.code;
import java.io.*;

public class No_3273 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] sequence = br.readLine().split(" ");
        int X = Integer.parseInt(br.readLine());

        int[] numbers = new int[2000001];
        int result = 0;

        for (String t : sequence){
            int temp = Integer.parseInt(t);
            if(X > temp &&  numbers[X - temp] == 1){
                result++;
            }
            else{
                numbers[temp] = 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
