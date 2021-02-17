package ua.khpi.oop.momot09;

import java.io.Serializable;

public class Node<T> implements Serializable{
	public T element;
	public Node<T> next;
	
	private static final long serialVersionUID = -6298777302126321006L;
	
	public Node() {}
	public Node(T el) {
		super();
		this.element = el;
	}
}
