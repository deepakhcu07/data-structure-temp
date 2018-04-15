package com.deepak.datastructure.linear;

import com.deepak.datastructure.linear.LinkedList.Node;

public class Merge2SortedLinkedList {

	public static void main(String []args) {
		// Creating List
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addFirst(105);
		list1.addFirst(95);
		list1.addFirst(75);
		list1.addFirst(65);
		list1.addFirst(55);
		list1.addFirst(45);
		
		
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.addFirst(125);
		list2.addFirst(115);
		list2.addFirst(92);
		list2.addFirst(54);
		list2.addFirst(52);
		list2.addFirst(20);
		
		System.out.println(list1);
		
		System.out.println(list2);
		
		list1 = merge(list1,list2);
		
		
		System.out.println(list1);
		
		
	}
	
	
	public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		
		//Check if either of the List is NULL or empty
		
		if(isNullorEmpty(list1)) {
			return list2;
		}
		if(isNullorEmpty(list2)) {
			return list1;
		}
		
		Node<Integer> head1 = list1.getHead();
		Node<Integer> head2 = list2.getHead();
		Node<Integer> previous = null;
		
		Node<Integer> temp1 = head1;
		Node<Integer> temp2 = head2;
		while(temp1!=null  && temp2!=null) {
			// IF List 1 element is small 
			if(temp1.getElement() <= temp2.getElement()) {
				previous = temp1;
				temp1 = temp1.getNext();
				
			} else {
				Node<Integer> toFix = temp2;
				temp2 = temp2.getNext();
				if(previous!=null) {
					previous.setNext(toFix);
					toFix.setNext(temp1);
					previous = previous.getNext();
				}else {
					toFix.setNext(temp1);
					list1.setHead(toFix);
				}
				
				
			}
		}
		
		
		
		if(temp2==null) {
			return list1;
		}
		if(temp2 != null) {
			previous.setNext(temp2);
		}
		
		System.out.println(list1);
		
		return list1;
		
		
	}
	
	public static boolean isNullorEmpty(LinkedList<Integer> list) {
		if(list == null || list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
}
