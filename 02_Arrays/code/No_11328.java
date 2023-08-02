package Arrays.code;
import java.io.*;

public class No_11328 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        // 1. 입력한 문자열이 서로 길이가 같은지 확인해서 구별한다 단, 길이다 다르면 impossible이다
        // 2. 입력한 문자열은 모두 영어 소문자이므로 배열에 첫번째 문자열의 문자를 아스키 번호에 맞추어 개수별로 저장한다
        // 3. 두번째 문자열에서 문자를 배열에서 찾아 개수를 -1 하는데 단, 배열을 조회했을 때 0이면 impossible이다
        // 4. 위의 조건을 모두 만족하면 possible이다

        String result = "Possible";

        for(int i = 0; i < testCase; i++){
            String[] temp = br.readLine().split(" ");

            if(temp[0].length() == temp[1].length()){
                int[] alphabet = new int[26];
                int length = temp[0].length();

                // 문자로 변환 후 0~26으로 변환, 개수 카운트
                for(int j = 0; j < length; j++){
                    alphabet[temp[0].charAt(j) - 'a']++;
                }
                // str1, str2 비교
                for (int j = 0; j < length; j++){
                    if(alphabet[temp[1].charAt(j) - 'a'] != 0){
                        alphabet[temp[1].charAt(j) - 'a']--;
                    }
                    else{
                        result = "Impossible";
                    }
                }
            }
            else{
                result = "Impossible";
            }

            bw.write(result);
            bw.write("\n");
            result = "Possible";
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
