package Arrays.code;
import java.io.*;

public class No_1919 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] alpabet = new int[26];

        // str1, str2의 문자 개수를 각각 str1 은 +1로 str2 는 -1로 배열에 저장한다
        // 배열에서 0이아닌 값을 찾는다

        int oneLength = str1.length();
        int secLength = str2.length();

        for(int i = 0; i < oneLength; i++){
            alpabet[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < secLength; i++){
            alpabet[str2.charAt(i) - 'a']--;
        }

        int result = 0;
        for(int i = 0; i < 26; i++){
            if(alpabet[i] != 0){
                result += Math.abs(alpabet[i]);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
