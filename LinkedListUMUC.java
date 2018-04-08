/* * File: LinkedListUMUC.java 
 * * Author: Alice Stanford
 * * Date: November 10, 2016 
 * * Purpose: Homework2: Create a generic linked list class 
 * * using an internal node class */

package linkedlistumuc;

public class LinkedListUMUC <StudentA> {    
	NodeUMUC head;    
	NodeUMUC tail; 
	
	//Construtor class    
	public LinkedListUMUC() {        
		head=tail=null;    
		}    
	
	//Adds first (head value)    
	void insertHead (StudentA data) {        
		NodeUMUC temp = new NodeUMUC();        
		temp.setiData(data);        
		if(head==null) {            
			head=temp;            
			tail=head;            
			head.setNext(tail);            
			head.setPrevious(tail);        
			} 
		else {            
			temp.setNext(head);            
			temp.setPrevious(tail);            
			tail.setNext(temp);            
			head.setPrevious(temp);            
			head=temp;        
			}    
		}   
	
	//Adds last (tail value)    
	void insertTail (StudentA data) {        
		NodeUMUC temp=new NodeUMUC();        
		temp.setiData(data);        
		if(tail==null) {            
			head=temp;            
			tail=head;            
			tail.setNext(tail);            
			tail.setPrevious(tail);        
			} 
		else {            
			temp.setNext(head);            
			head.setPrevious(temp);            
			temp.setPrevious(tail);            
			tail.setNext(temp);            
			tail=temp;        
			}    
		}    
	//Displays everything to string    
	@Override    
	public String toString() {        
		StringBuilder str = new StringBuilder();        
		if (head==null){            
			return "Empty List";        
			}        
		NodeUMUC temp;
		temp=head;       
		while(temp.getNext()!=head) {            
			str.append(temp.getiData()+"  ");    
			str.append( System.getProperty( "line.separator" ) );
			temp=temp.getNext();        
			}        
		str.append(temp.getiData());        
		return str.toString();    
		}    
	
	//Removes last (tail value)    
	StudentA removeTail() {        
		NodeUMUC temp, temp1;        
		if(tail==head){            
			temp1=tail;            
			tail=null;            
			head=null;            
			return (StudentA)temp1.getiData();        
			}        
		
		temp=tail.getPrevious();        
		head.setPrevious(temp);        
		temp.setNext(head);        
		temp1=tail;        
		tail=temp;        
		return (StudentA)temp1.getiData();    
		}    
	
	//Removes first (head value)    
	@SuppressWarnings("unchecked")
	StudentA removeHead() {        
		NodeUMUC temp, temp1;        
		if(tail==head){            
			temp1=tail;            
			tail=null;            
			head=null;            
			return (StudentA)temp1.getiData();        
			}        
		temp=head.getNext();        
		tail.setNext(temp);        
		temp.setPrevious(tail);        
		temp1=head;        
		head=temp;        
		return (StudentA)temp1.getiData();    
		}    
	
	//Removes selected postion of that value (int)    
	@SuppressWarnings("unchecked")
	StudentA removeElementAt (int index) {        
		NodeUMUC temp=head;        
		int count=0;        
		if(index==1){            
			return removeHead();        
			}        
		do {            
			count++;            
			if(count==index&&temp.getNext()==head){                
				return removeTail();            
				}            
			if(count==index) {                
				temp.getPrevious().setNext(temp.getNext());                
				temp.getNext().setPrevious(temp.getPrevious());                
				return (StudentA)temp.getiData();            
				}            
			temp=temp.getNext();        
				} while (temp!=head);        
		System.out.println("There are only " +count+" node in list so can't delete" 
				+ " any node and returning tail's data");       
		return (StudentA)tail.getiData();    
		}    
	
	@SuppressWarnings("unchecked")
	StudentA peekElementAt (int index){        
		NodeUMUC temp=head;        
		int count=0;        
		do {            
			count++;            
			if (count==index)            
				return (StudentA)temp.getiData();            
			temp=temp.getNext();                      
			} while (temp!=head);        
		System.out.println("There are only "+count+" node in List so returning"                
			+ " tail node data");        
		return (StudentA)tail.getiData();    
		} 
	
	@SuppressWarnings("unchecked")
	StudentA peekHead() {       
		return (StudentA)head.getiData();
		}    
	
	@SuppressWarnings("unchecked")
	StudentA peekTail() {        
		return(StudentA)tail.getiData();    
		}    
	}
