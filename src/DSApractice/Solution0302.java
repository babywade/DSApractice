package DSApractice;

public class Solution0302 {
	public static void main(String[] args) {
		SingleLinkedNode head = new SingleLinkedNode("a");
		SingleLinkedNode node = head;
		node.next = new SingleLinkedNode("b");
		node = node.next;
		node.next = new SingleLinkedNode("c");
		node = node.next;
        node.next = new SingleLinkedNode("d");
        node = node.next;
        node.next = new SingleLinkedNode("e");
        node = node.next;
        print(head);
        print(swapAdjacentNodes(head));
	}
	{
		DoubleLinkedNode head = new DoubleLinkedNode("a");
		DoubleLinkedNode node1 = head, node2;
		node1.next = new DoubleLinkedNode("b");
        node2 = node1.next;
        node2.prev = node1;
        node1 = node2;
        node1.next = new DoubleLinkedNode("c");
        node2 = node1.next;
        node2.prev = node1;
        node1 = node2;
        node1.next = new DoubleLinkedNode("d");
        node2 = node1.next;
        node2.prev = node1;
        node1 = node2;
        node1.next = new DoubleLinkedNode("e");
        node2 = node1.next;
        node2.prev = node1;
        print(head);
        print(swapAdjacentNodes(head));
	}
	private static void print(SingleLinkedNode head) {
		while (head != null) {
			if (head.next != null)
				System.out.print(head + "->");
			else
				System.out.print(head);
			head = head.next;
		}
		System.out.println();
	}
	
	private static void print(DoubleLinkedNode head) {
		while (head != null) {
			if (head.prev != null)
				System.out.print("<-");
			System.out.println();
			if (head.next != null)
				System.out.print("->");
			head = head.next;
		}
		System.out.println();
	}
	public static SingleLinkedNode swapAdjacentNodes(SingleLinkedNode head) {
		if (head == null || head.next == null)
			return head;
		SingleLinkedNode dummy = new SingleLinkedNode("");
	    SingleLinkedNode cur = head;
	    dummy.next = cur;
	    SingleLinkedNode before = dummy, after;
	    while (cur != null && cur.next != null) {
	        after = cur.next.next;
	        before.next = cur.next;
	        cur.next.next = cur;
	        cur.next = after;
	        before = cur;
	        cur = cur.next;
	    }
	    return dummy.next;
	}
	
    public static DoubleLinkedNode swapAdjacentNodes(DoubleLinkedNode head) {
        if (head == null || head.next == null) return head;
        DoubleLinkedNode dummy = new DoubleLinkedNode("");
        DoubleLinkedNode cur = head;
        dummy.next = cur;
        cur.prev = dummy;
        DoubleLinkedNode before, first, second, after;
        while (cur != null && cur.next != null) {
            after = cur.next.next;
            first = cur;
            second = cur.next;
            before = cur.prev;
            if (before != null)
                before.next = second;
            second.prev = before;
            second.next = first;
            first.prev = second;
            first.next = after;
            if (after != null)
                after.prev = first;
            cur = after;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
    
	static class SingleLinkedNode {
		String data;
		SingleLinkedNode next;
		
		SingleLinkedNode(String data) {
			// TODO 自动生成的构造函数存根
			this.data = data;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return data;
		}
	}
	static class DoubleLinkedNode {
		String data;
		DoubleLinkedNode prev, next;
		
		DoubleLinkedNode(String data) {
			// TODO 自动生成的构造函数存根
			this.data = data;
			this.prev = this.next = null;
		}
		
		@Override
		public String toString() {
			return data;
		}
	}
}
