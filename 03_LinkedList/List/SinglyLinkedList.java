package List;

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
        else if(index == size-1){
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
        while(f != null){
            String stored = String.valueOf(f.data);
            datas += stored + ", ";
            f = f.next;
        }
        datas += "]";
        return datas;
    }
}
