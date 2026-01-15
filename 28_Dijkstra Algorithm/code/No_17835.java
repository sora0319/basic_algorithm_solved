package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class No_17835 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, List<City>> cities = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] meeting = new int[K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(!cities.containsKey(U)){
                cities.put(U, new ArrayList<>());
            }

            List<City> linkedCities = cities.get(U);
            linkedCities.add(new City(C, V));
        }

        st = new StringTokenizer(br.readLine());
        meeting[0] = Integer.parseInt(st.nextToken());
        meeting[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int[] minDistance = new int[N];

        }


        br.close();
        bw.flush();
        bw.close();
    }

    private static class City{
        int distance;
        int name;

        City(int distance, int name) {
            this.distance = distance;
            this.name = name;
        }
    }
}
