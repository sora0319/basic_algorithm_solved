package code;
import java.io.*;
import java.util.*;
public class No_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> checkList = new Stack<>();

        while(true){
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            boolean isBalance = true;
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '(' || input.charAt(i) == '['){
                    checkList.push(input.charAt(i));
                } else if(input.charAt(i) == ')'){
                    if(checkList.isEmpty() || checkList.peek() != '('){
                        isBalance = false;
                        break;
                    } else {
                        checkList.pop();
                    }
                } else if(input.charAt(i) == ']') {
                    if(checkList.isEmpty() || checkList.peek() != '['){
                        isBalance = false;
                        break;
                    } else {
                        checkList.pop();
                    }
                } else{
                    // 일반 영어 문자열
                }
            }
            if (!checkList.isEmpty() || !isBalance) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }
            checkList.clear();
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
