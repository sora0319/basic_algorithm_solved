package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Meeting> schedule = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            schedule.add(new Meeting(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        schedule.sort(Comparator.comparingInt((Meeting m) -> m.end).thenComparingInt((Meeting m) -> m.start));

        int count = 1;
        Meeting nowOnMeeting = schedule.get(0);

        for (int i = 1; i < N; i++) {
            if (nowOnMeeting.end <= schedule.get(i).start) {
                count++;
                nowOnMeeting = schedule.get(i);
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }

    static class Meeting {

        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
