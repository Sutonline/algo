package list;

import java.util.Objects;

/**
 * @author yongkang.zhang
 * created at 2019-06-28
 */
public class LinkedList {

	private Node headNode;

	private Node tailNode;

	private int capacity;

	private int size;

	public LinkedList(int capacity) {
		this.capacity = capacity;
	}

	public boolean add(String element) {
		if (size > capacity) {
			return false;
		}

		Node node = new Node();
		node.data = element;
		node.prev = tailNode;
		tailNode = node;
		return true;
	}

	public String get(int index) {
		if (index < 0 || index > capacity - 1) {
			throw new ArrayIndexOutOfBoundsException("");
		}

		int idx = 0;
		Node curNode = null;
		while (idx < index) {
			curNode = headNode.next;
			idx++;
		}

		return curNode == null ? null : curNode.data;
	}

	public boolean remove(String str) {
		Node curNode = headNode;
		while (curNode != null) {
			if (Objects.equals(curNode.data, str)) {
				if (curNode.prev == null) {
					headNode = curNode.next;
				}

				if (curNode.next == null) {
					tailNode = curNode.prev;
				}

				curNode.prev.next = curNode.next;
				curNode.next.prev = curNode.prev;
				return true;
			}
			curNode = curNode.next;
		}

		return false;
	}

	private static class Node {
		private Node prev;
		private Node next;
		private String data;
	}

}
