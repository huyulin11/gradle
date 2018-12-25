package com.kaifantech.util.set.queue;

import java.util.LinkedList;

public class LimitQueue<E> {

	private int limit; // 队列长度

	private LinkedList<E> list = new LinkedList<E>();

	public LinkedList<E> getList() {
		return list;
	}

	public LimitQueue(int limit) {
		this.limit = limit;
	}

	/**
	 * 入列：当队列大小已满时，把队头的元素poll掉
	 */
	public void offer(E e) {
		if (list.size() >= limit) {
			list.poll();
		}
		list.offer(e);
	}

	public E get(int position) {
		return list.get(position);
	}

	public E getLast() {
		return list.getLast();
	}

	public E getFirst() {
		return list.getFirst();
	}

	public int getLimit() {
		return limit;
	}

	public int size() {
		return list.size();
	}

}
