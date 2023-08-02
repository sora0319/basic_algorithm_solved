package Arrays.code;
import java.io.*;

public class No_13300 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] girls = new int[7];
        int[] boys = new int[7];

        String[] temp = br.readLine().split(" ");
        int peopleSize = Integer.parseInt(temp[0]);
        int roomSize = Integer.parseInt(temp[1]);

        for(int i = 0; i < peopleSize; i++){
            temp = br.readLine().split(" ");

            if(temp[0].equals("0")){
                girls[Integer.parseInt(temp[1])]++;
            }
            else if (temp[0].equals("1")){
                boys[Integer.parseInt(temp[1])]++;
            }
        }

        int room = 0;
        for(int i = 1; i <7; i++ ){
            room += (girls[i] + roomSize-1) / roomSize;
            room += (boys[i] + roomSize-1) / roomSize;
        }

        bw.write(String.valueOf(room));

        bw.flush();
        br.close();
        bw.close();
    }
}
