package linkedlistumuc;

class NodeUMUC<StudentA> {    
	//T iData;
	//StudentA student;
	StudentA student;
	public NodeUMUC<StudentA> next;    
	public NodeUMUC<StudentA> previous;  
	
	public StudentA getiData() {        
		return student;    
		} 
	
	public void setiData(StudentA student) {        
		this.student = student;    
		}
	
	public NodeUMUC<StudentA> getNext() {
		return next;    
		}    
	
	public void setNext(NodeUMUC<StudentA> next) {        
		this.next = next;    
		}    
	
	public NodeUMUC<StudentA> getPrevious() {        
		return previous;    
		}    
	
	public void setPrevious(NodeUMUC<StudentA> previous) {
		this.previous = previous;    
		}    
	
	public String toString() { 
		String temp = " " + student;
		return temp;  
		}
}