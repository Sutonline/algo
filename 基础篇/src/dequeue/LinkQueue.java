package dequeue;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于链表的队列
 * @author yongkang.zhang
 * created at 2019-06-28
 */
public class LinkQueue {

	private Node headNode;
	private Node tailNode;

	private int capacity;
	private int size;

	public LinkQueue(int capacity) {
		this.capacity = capacity;
	}

	private boolean push(Node node) {
		if (size > capacity) {
			return false;
		}

		if (headNode == null) {
			headNode = node;
			tailNode = node;
		} else {
			tailNode.next = node;
			node.prev = tailNode;
			node.next = null;
			tailNode = node;
		}

		return true;
	}

	private Node dequeue() {
		Node node = headNode;
		headNode = headNode.next;
		headNode.prev = null;

		return node;
	}

	private static class Node {
		private Node prev;
		private Node next;
		private String data;
	}

}
