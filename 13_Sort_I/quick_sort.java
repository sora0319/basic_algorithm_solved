import java.io.IOException;

public class quick_sort {
    public static void main(String[] args) throws IOException {
        int[] numbers = {5,-7,6,10,7,1,-3,12};


    }
    public static void quickSort(int[] numbers){
        int pivot = numbers[0];

        // pivot을 기준으로 왼쪽은 pivot 보다 작은 수 오른 쪽은 pivot 보다 큰 수로 분류한다
        int l = 1, r = numbers.length-1;
        while(l < r){
            while(numbers[l] < pivot) l++; // pivot 보다 작으면 큰 수 찾을때까지 증가
            while(numbers[r] >= pivot) r--; // pivot 보다 크거나 같으면 작은 수 찾을 때까지 감소
            swap(numbers[l], numbers[r]);
        }
        swap(numbers[0], numbers[r]);


    }

    private static void swap(int n1, int n2){
        int temp = n1;
        n1 = n2;
        n2 = n1;
    }
}
