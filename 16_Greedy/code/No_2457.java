package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No_2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();
        int count = 0;




        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
    static class Flower{
        int startMonth;
        int startDay;
        int endMonth;
        int endDay;

        Flower(int startMonth, int startDay, int endMonth, int endDay){
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }
    }
}
