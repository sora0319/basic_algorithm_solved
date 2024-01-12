package code;
import java.io.*;
import java.util.*;
public class No_17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> check = new Stack<>();
        Stack<Integer> space = new Stack<>();

        int repeat = Integer.parseInt(br.readLine());
        int[] nge = new int[repeat];
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < repeat; i++){

            while(!check.isEmpty() && check.peek() < sequence[i]){
                check.pop();
                nge[space.pop()] = sequence[i];
            }

            check.push(sequence[i]);
            space.push(i);
        }

        while(!check.isEmpty()){
            check.pop();
            nge[space.pop()] = -1;
        }

        for(int n : nge){
            bw.write(String.valueOf(n) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
