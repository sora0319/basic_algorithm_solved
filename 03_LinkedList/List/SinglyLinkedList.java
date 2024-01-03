package List;

import java.util.ArrayList;

public class SinglyLinkedList {
    private Node first;
    private Node last;
    private int size = 0;

    private static class Node {
        private Node next;
        private Object data;

        private Node(Object data){
            this.data = data;
        }
    }

    public void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        size++;

        if(first.next == null){
            last = first;
        }
    }

    public void addLast(Object data){
        Node newNode = new Node(data);
        if(size == 0){
            addFirst(data);
        }
        else{
            last.next = newNode;
            last = newNode;
            size++;
        }

    }

    public void add(int index, Object data){
        if(index == 0){
            addFirst(data);
        }
        else if(index == size){
            addLast(data);
        }
        else{
            Node f = first;
            for(int i = 0; i < index-1; i++){
                f = f.next;
            }
            Node newNode = new Node(data);
            newNode.next = f.next;
            f.next= newNode;
            size++;
        }
    }

    public String toString(){
        String datas = "[";
        Node f = first;
        while(f.next != null){
            String stored = String.valueOf(f.data);
            datas += stored + ", ";
            f = f.next;
        }
        datas += f.data + "]";
        return datas;
    }

    public Object removeFirst(){
        Object removeData = first.data;
        first = first.next;
        size --;
        return removeData;
    }

    public Object remove(int index){
        if(index == 0){
            removeFirst();
        }

        Node f = first;
        for(int i = 0; i < index-1; i++){
            f = f.next;
        }

        Node removeNode = f.next;
        f.next = removeNode.next;
        return removeNode.data;
    }
}
