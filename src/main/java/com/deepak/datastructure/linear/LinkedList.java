package com.deepak.datastructure.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {
	
	private Node<E> head;
	private int length;
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	// Adding an element at First Position
	public void addFirst(E element) {
		head = new Node<E>(element,head);
		length++;
	}
	
	public void addLast(E element) {
		if(head==null) {
			addFirst(element);
			return;
		}
		
		Node<E> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new Node<E>(element,null);
		length++;
	}
	
	public void addAt(E element, int position) {
		if(position==0) {
			addFirst(element);
			return;
		}
		
		Node<E> current = head;
		Node<E> previous = null;
		for(int i=0;i<position && current!=null;i++) {
			previous = current;
			current = current.next;
		}
		
		previous.next = new Node<E>(element,current);
		length++;
	}
	
	public void insertBefore(E keyElement, E element) {
		if(isEmpty()) {
			return;
		}
		if(head.element.equals(keyElement)) {
			addFirst(element);
			return;
		}
		
		Node<E> current = head;
		Node<E> previous = null;
		while(current!=null) {
			if(current.element.equals(keyElement)) {
				break;
			}
			previous = current;
			current = current.next;
		}
		if(current!=null) {
			previous.next = new Node<E>(element,current);
			length++;
		}
	}
	
	public void insertAfter(E keyElement, E element) {
		if(isEmpty()) {
			return;
		}
		
		Node<E> temp = head;
		while(temp!=null) {
			if(temp.element.equals(keyElement)) {
				break;
			}
			temp = temp.next;
		}
		if(temp!=null) {
			temp.next = new Node<E>(element,temp.next);
			length++;
		}
	}
	
	// Finding elements in a list
	
	public boolean conatins(E element) {
		for(E tmp: this) {
			if(tmp.equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Find the 
	 * @param element
	 * @return index of the element in the list, if found
	 * Otherwise, returns -1
	 */
	public int find(E element) {
		int position = -1;
		Node<E> temp = head;
		int index = 0;
		while(temp!=null) {
			if(temp.element.equals(element)) {
				position = index;
				break;
			}
			index ++;
			temp = temp.next;
		}
		
		return position;
	}
	
	
	// Removing elements
	public void removeFirst() {
		if(isEmpty()) {
			return;
		}
		head = head.next;
		length--;
		return;
	}
	
	public void removeLast() {
		if(isEmpty()) {
			return;
		}
		Node<E> current = head;
		Node<E> previous = null;
		while(current.next!=null) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		length--;
	}
	
	public void removeAt(int position) {
		if(isEmpty()) {
			return;
		}
		if(position==0) {
			removeFirst();
			return;
		}
		Node<E> current = head;
		Node<E> previous = null;
		for(int i=0;i<position && current!=null;i++) {
			previous = current;
			current = current.next;
		}
		if(current==null) {
			throw new IndexOutOfBoundsException();
		}
		previous.next = current.next;
		length--;
	}
	
	public void remove(E element) {
		if(isEmpty()) {
			return;
		}
		if(head.element.equals(element)) {
			removeFirst();
			return;
		}
		Node<E> current = head;
		Node<E> previous = null;
		while(current!=null) {
			if(current.element.equals(element)) {
				break;
			}
			previous = current;
			current = current.next;
		}
		if(current!=null) {
			previous.next = current.next;
			length--;
		}
	}
	
	//
	public LinkedList<E> reverse(){
		LinkedList<E> list = new LinkedList<E>();
		Node<E> temp = head;
		while(temp!=null) {
			list.addFirst(temp.element);
			temp = temp.next;
		}
		return list;
	}
	
	public void reverseList() {
		Node<E> previous = null;
		Node<E> current = head;
		Node<E> next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head =previous;
	}
	
	
	
	
	// To String
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Object obj: this) {
			sb.append(obj + " ");
		}
		return sb.toString();
	}
	
	
	// Iterator Method
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	// An Iterator Class
	private class LinkedListIterator implements Iterator<E>{
		private Node<E> nextNode;
		
		public LinkedListIterator() {
			this.nextNode = head;
		}
		
		public boolean hasNext() {
			return this.nextNode!=null;
		}
		
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = this.nextNode.element;
			this.nextNode = this.nextNode.next;
			return result;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	
	
	
	/**
	 * An Inner class to conatins the infornation about each Node of LinkedList
	 * 
	 */
	private class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E element, Node<E> next){
			this.element = element;
			this.next = next;
		}
	}
	
	
	// Main Method
	
	public static void main(String []args) {
		System.out.println("Adding Element");
		LinkedList< Integer> list = new LinkedList<>();
		
		System.out.println("Adding First");
		list.addFirst(9);
		list.addFirst(8);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Adding Last");
		list.addLast(10);
		list.addLast(15);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Adding at Specific Position");
		list.addAt(11, 3);
		list.addAt(7, 0);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		
		System.out.println("Inserting Before");
		list.insertBefore(15, 14);
		list.insertBefore(14, 13);
		list.insertBefore(18, 17);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		
		System.out.println("Inserting After");
		list.insertAfter(15, 17);
		list.insertAfter(7, 27);
		list.insertAfter(18, 17);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Reverse List ");
		list.reverseList();
		System.out.println(list);
		
		System.out.println("Finding Element");
		
		System.out.println(" Is List Conatins 30 : " + list.conatins(30));
		System.out.println(" Is List Conatins 7 : " + list.conatins(7));
		System.out.println(" Is List Conatins 13 : " + list.conatins(13));
		System.out.println(" Is List Conatins 17 : " + list.conatins(17));
		
		System.out.println("Finding Index");
		
		System.out.println(" Index of element 30 in the List : " + list.find(30));
		System.out.println(" Index of element 7 in the List : " + list.find(7));
		System.out.println(" Index of element 13 in the List : " + list.find(13));
		System.out.println(" Index of element 17 in the List : " + list.find(17));
		
		System.out.println("Removing Elements");
		list.removeFirst();
		list.removeFirst();
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Removing Last Elements");
		list.removeLast();
		list.removeLast();
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Removing At Specific Location");
		list.removeAt(0);
		list.removeAt(3);
		list.removeAt(list.length()-1);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		System.out.println("Removing Specific Element");
		list.remove(15);
		System.out.println(list);
		System.out.println("Length : " + list.length());
		
		
	}




	

}
