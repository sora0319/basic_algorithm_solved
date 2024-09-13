package code;

import java.io.*;
import java.util.*;
public class No_2910 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Info> numbers = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int order = 1;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (numbers.containsKey(n)) {
                numbers.get(n).add();
            } else {
                Info info = new Info(order,1);
                numbers.put(n, info);
                order++;
            }
        }

        List<Integer> keySet = new ArrayList<>(numbers.keySet());

        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if(numbers.get(n1).frequency > numbers.get(n2).frequency) return -1;
                if(numbers.get(n1).frequency < numbers.get(n2).frequency) return 1;
                if(numbers.get(n1).order < numbers.get(n2).order) return -1;
                return 1;
            }
        });

        for (int key : keySet) {
            for (int i = 0; i < numbers.get(key).frequency; i++) {
                bw.write(String.valueOf(key));
                bw.write(" ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
    private static class Info{
        int order;
        int frequency;

        Info(int order, int frequency) {
            this.order = order;
            this.frequency = frequency;
        }

        private void add() {
            this.frequency++;
        }
    }
}
