package Arrays.code;

import java.util.*;

public class VectorTest {
    public static void main(String[] args){
        Vector<Integer> v1 = new Vector<>();

        // add vector element
        v1.add(2);
        v1.add(5);

        // total vector print
        System.out.println(v1);

        // print one vector element
        System.out.println(v1.get(1));

        // print one element in vector
        for (Integer v : v1){
            System.out.println(v);
        }
    }
}
