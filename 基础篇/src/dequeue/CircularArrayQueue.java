package dequeue;

/**
 * @author yongkang.zhang
 * created at 2019-06-28
 */
public class CircularArrayQueue {

	private String[] nodes;

	private int capacity;


	/**
	 * 队首指针
	 */
	private int head = 0;

	/**
	 * 队尾指针
	 */
	private int tail = 0;

	public CircularArrayQueue(int capacity) {
		this.capacity = capacity;
		this.nodes = new String[capacity];
	}

	public boolean add(String str) {
		// 队列满的情况
		if (((tail + 1) % capacity) == head) {
			return false;
		}

		// 队列空的情况
		nodes[tail] = str;
		tail = (tail + 1) % capacity;

		return true;
	}

	public String dequeue() {
		// 队列空的情况
		if (head == tail) {
			return null;
		}

		String result = nodes[head];
		head = (head + 1) % capacity;
		return result;
	}
}
