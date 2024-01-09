package code;

public class Stack {

    final int MX = 1000000;
    int [] dat = new int[MX];
    int pos = 0;
    public static void main(String[] args) {

    }

    void push(int x){
        dat[pos++] = x;
    }

    void pop(){
        pos--;
    }

    int top(){
        return dat[pos-1];
    }
}
