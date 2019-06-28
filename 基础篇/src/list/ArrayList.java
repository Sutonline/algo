package list;

import java.util.Arrays;

/**
 * @author yongkang.zhang
 * created at 2019-06-28
 */
public class ArrayList {

	private String[] nodes;
	int capacity = 8;
	int index = 0;

	public ArrayList(int capacity) {
		this.capacity = capacity;
		nodes = new String[10];
	}

	public boolean add(String str) {
		if (index >= capacity) {
			// 扩容
			capacity = capacity << 1;
			String[] newNodes = new String[capacity];
			for (int i = 0; i < nodes.length; i++) {
				newNodes[i] = nodes[i];
			}
			nodes = newNodes;
		}
		index++;
		nodes[index] = str;

		return true;
	}

	public String get(int idx) {
		if (idx > 0 && idx < capacity) {
			return nodes[idx];
		}

		throw new IndexOutOfBoundsException(idx + " over capacity " + capacity + "limit");
	}

	public boolean delete(int idx) {
		if (idx > 0 && idx < capacity) {
			shift(idx);
			return true;
		}

		throw new IndexOutOfBoundsException(idx + " over capacity " + capacity + "limit");
	}

	private void shift(int idx) {
		if (idx == nodes.length - 1) {
			nodes[idx] = null;
		}

		for (int i = 0; i < nodes.length - 1; i++) {
			if (i <= idx) {
				continue;
			}

			nodes[i] = nodes[i + 1];
		}
	}
}
