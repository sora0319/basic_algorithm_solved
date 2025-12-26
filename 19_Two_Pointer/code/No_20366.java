package code;

import java.io.*;
import java.util.*;

public class No_20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,List<Set<Integer>>> snowMans = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] snowballs = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            snowballs[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int height = snowballs[i] + snowballs[j];
                if(!snowMans.containsKey(height)){
                    List<Set<Integer>> snows = new ArrayList<>();
                    snowMans.put(height, snows);
                }

                List<Set<Integer>> savedSnow = snowMans.get(height);
                Set<Integer> balls = new HashSet<>();
                balls.add(i);
                balls.add(j);

                savedSnow.add(balls);
            }
        }

        int backKey = 0;
        int minGap = 1200;

        for (int savedKey : snowMans.keySet()) {
            List<Set<Integer>> firstSnow = snowMans.get(savedKey);
            Set<Integer> back = null;
            boolean isDuplicate = false;
            boolean isFind = false;

            if(firstSnow.size() > 1){
                for(Set<Integer> first : firstSnow){
                    for(Set<Integer> second : firstSnow){
                        for(int snow : first){
                            if(second.contains(snow)){
                                isDuplicate = true;
                                break;
                            }
                        }
                        if(!isDuplicate){
                            minGap = 0;
                            isFind = true;
                            break;
                        }
                        isDuplicate = false;

                        if(isFind) break;
                    }
                }
            }

            if(backKey == 0){
                backKey = savedKey;
                continue;
            }

            if (Math.abs(savedKey - backKey) < minGap) {
                List<Set<Integer>> secondSnow = snowMans.get(backKey);

                for(Set<Integer> first : firstSnow){
                    for(Set<Integer> second : secondSnow){

                        for(int snow : second){
                            if(first.contains(snow)){
                                isDuplicate = true;
                                break;
                            }
                        }
                        if(!isDuplicate){
                            minGap = Math.abs(savedKey - backKey);
                            isFind = true;
                            break;
                        }
                        isDuplicate = false;
                    }
                    if(isFind) break;
                }

            }
            backKey = savedKey;
        }

        bw.write(String.valueOf(minGap));
        br.close();
        bw.flush();
        bw.close();
    }

}
