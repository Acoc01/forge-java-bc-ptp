package vergara_rodolfo_linked_list;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        sll.remove();
        sll.printValues();
        System.out.println("Nodo: "+sll.find(10).Value);
        sll.removeAt(5);
        sll.removeAt(2);
        sll.printValues();
	}

}
