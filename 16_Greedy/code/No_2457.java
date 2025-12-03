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

        flowers.sort((f1, f2) -> {
            if (f1.startMonth != f2.startMonth) {
                return Integer.compare(f1.startMonth, f2.startMonth);
            }

            if(f1.startDay != f2.startDay) {
                return Integer.compare(f1.startDay, f2.startDay);
            }

            if(f1.endMonth != f2.endMonth) {
                return Integer.compare(f2.endMonth, f1.endMonth);
            }

            return Integer.compare(f2.endDay, f1.endDay);
        });


        int[] endDate = {11,30};
        int[] pointEndDate = {3,1};

        for (int i = 0; i < N; i++) {
            Flower flower = flowers.get(i);

            // 날짜를 모두 비교하기


        }

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
