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

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            Flower flower = new Flower(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]),
                    Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));

            flowers.add(flower);
        }

        flowers.sort(Comparator.comparingInt((Flower f) -> f.endMonth).thenComparingInt(f -> f.endDay)
                .thenComparingInt(f -> f.startMonth).thenComparingInt(f -> f.startDay));

        int[] endDate = {11,30};
        int[] pointEndDate = {3,1};
        for (int i = 0; i < N; i++) {
            Flower flower = flowers.get(i);
            if (flower.startMonth >= pointEndDate[0] && flower.startMonth <= endDate[0]) {

            }
        }

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
