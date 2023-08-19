package vergara_rodolfo_linked_list;

public class SinglyLinkedList {
	public Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
		}else {
			Node runner = head;
			while(runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}
	
	public void remove() {
		if(head == null) {
			System.out.println("There are no elements in the list.");
		}else if(head.next == null) {
			head = null;
		}else {
			Node runner = head;
			Node temp = null;
			while(runner.next != null) {
				temp = runner;
				runner = runner.next;
			}
			temp.next = null;
		}
	}
	
	public void printValues() {
		if(head == null) {
			System.out.println("There are no elements in the list.");
		}else if(head.next == null) {
			System.out.println("["+head.Value+"]");
		}else {
			Node runner = head;
			System.out.print("[");
			while(runner.next != null) {
				System.out.print(runner.Value+",");
				runner = runner.next;
			}
			System.out.print(runner.Value+"]\n");
		}
	}
	
	public Node find(int n) {
		if(head == null) {
			System.out.println("There are no elements in the list.");
		}else if(head.next == null) {
			if(head.Value == n)
				return head;
			else
				return new Node(-100000000);
		}else {
			Node runner = head;
			boolean flag = false;
			while(runner.next != null) {
				if(runner.Value == n) {
					flag = true;
					break;
				}
				else 
					runner = runner.next;
			}
			if(flag)
				return runner;
			return new Node(-100000000);
		}
		return new Node(-100000000);

	}
	
	public void removeAt(int n) {
		if(head == null) {
			System.out.println("There are no elements in the list.");
		}else if(head.next == null) {
			if(n == 0) {
				head = null;
			}else {
				System.out.println("There is only one element and your index is too big.");
			}
		}else {
			if(n == 0) {
				Node runner = head;
				head = runner.next;
			}else {
				Node runner = head;
				Node temp = null;
				int i = 0;
				while(runner.next != null) {
					if(i == n) {
						break;
					}
					temp = runner;
					runner = runner.next;
					i++;
				}
				if(i == n) {
					
					temp.next = runner.next;
				}else {
					System.out.println("Your index is too big.");
				}
			}
		}
	}
}
