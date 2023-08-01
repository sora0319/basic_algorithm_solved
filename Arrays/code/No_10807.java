package Arrays.code;
import java.io.*;

public class No_10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] space = new int[201];

        int size = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());

        for(int i = 0; i < size; i++){
            int n = Integer.parseInt(temp[i]) + 100;
            space[n]++;
        }

        bw.write(String.valueOf(space[v+100]));

        bw.flush();
        bw.close();
        br.close();
    }
}
