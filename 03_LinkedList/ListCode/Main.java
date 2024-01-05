package ListCode;


public class Main {
    public static void main(String [] args){
        SinglyLinkedList singleList = new SinglyLinkedList();

        singleList.addFirst(100);
        singleList.addLast(200);
        singleList.addLast(300);
        singleList.add(2, 150);
        System.out.println(singleList.toString());

        System.out.println(singleList.removeFirst());
        System.out.println(singleList);

        singleList.add(1, 180);
        singleList.addLast(400);
        System.out.println(singleList);

        System.out.println(singleList.remove(0));
        System.out.println(singleList);
    }
}
