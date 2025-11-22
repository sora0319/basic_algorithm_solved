package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        int N=Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] humans=new int[N];

        for (int h = 0; h < N; h++) {
            humans[h] = Integer.valueOf(inputs[h]);
        }

        Arrays.sort(humans);

        for(int h = 0; h < N; h++){
            answer += humans[h] * (N-h);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

}
