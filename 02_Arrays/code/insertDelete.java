package Arrays.code;

import java.util.Arrays;

public class insertDelete {
    public static void main(String[] args){
        int[] number = new int[10];
        number[0] = 0;
        number[1] = 1;
        number[2] = 2;
        number[3] = 4;

        insert(3, number, 3);
        System.out.println(Arrays.toString(number));

        delete(1, number);
        System.out.println(Arrays.toString(number));

    }
    public static void insert(int num, int[] target, int space){
        int temp = 0;
        int save;

        for(int i = 0; i < target.length; i++){
            if (i == space){
                temp = target[i];
                target[i] = num;
            }
            else if(i > space){
                save = target[i];
                target[i] = temp;
                temp = save;
            }
        }
    }

    public static void delete(int space, int[] target){
        for(int i = 0; i < target.length; i++){
            if(i == target.length-1){
                target[i] = 0;
            }
            else if(i >= space){
                target[i] = target[i+1];
            }
        }
    }

}
