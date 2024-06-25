import java.io.*;

public class merge_sort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(numbers);

        for(int n : numbers){
            bw.write(String.valueOf(n));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;

        if(right > left) {
            int mid = (left+right)/2;

            // divide
            int[] leftSide = divider(numbers, left, mid);
            int[] rightSide = divider(numbers, mid + 1, right);
            mergeSort(leftSide);
            mergeSort(rightSide);

            //Conquer
            int i = 0, l = 0, r = 0;
            while (l < leftSide.length && r < rightSide.length){
                if(leftSide[l] < rightSide[r]){
                    numbers[i++] = leftSide[l++];
                }
                else if(leftSide[l] > rightSide[r]){
                    numbers[i++] = rightSide[r++];
                }
            }

            while(i < numbers.length){
                if(l < leftSide.length){
                    numbers[i++] = leftSide[l++];
                }
                if(r < rightSide.length){
                    numbers[i++] = rightSide[r++];
                }
            }
        }
    }

    private static int[] divider(int[] numbers, int left, int right) {
        int[] temp = new int[right-left+1];
        int k = 0;
        for (int i = left; i <= right; i++) {
            temp[k++] = numbers[i];
        }
        return temp;
    }
}
