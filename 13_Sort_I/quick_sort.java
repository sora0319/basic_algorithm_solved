import java.io.IOException;
import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) throws IOException {
        int[] numbers = {5,-7,6,10,7,1,-3,12};
        quickSort(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
    public static void quickSort(int[] numbers, int pivotPoint, int right){
        if(right <= pivotPoint+1) return;
        int pivot = numbers[pivotPoint];

        // pivot을 기준으로 왼쪽은 pivot 보다 작은 수 오른 쪽은 pivot 보다 큰 수로 분류한다
        int l = pivotPoint+1, r = right;
        while(true){
            while(numbers[l] < pivot) l++; // pivot 보다 작으면 큰 수 찾을때까지 증가
            while(numbers[r] >= pivot) r--; // pivot 보다 크거나 같으면 작은 수 찾을 때까지 감소
            if(r < l) break;
            swap(numbers, l, r);
        }
        swap(numbers, pivotPoint, r);

        quickSort(numbers, pivotPoint, r);
        quickSort(numbers, r+1, right);
    }

    private static void swap(int[] numbers, int l, int r){
        int temp = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = temp;
    }
}
