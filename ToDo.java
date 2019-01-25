import java.lang.*;

public class ToDo {
	private String description;
	private int priority;
	private boolean isCompleted;


	public ToDo(String description, int priority) {
		this.description = description;
		this.priority = priority;
		this.isCompleted = false;
	}

	public String getDescription() {
		return description;
	}

	public int getPriority() {
		return priority;
	}

	public boolean getCompleteStatus() {
		return isCompleted;
	}

	public void setComplete() {
		isCompleted = true;
	}

	public void setIncomplete() {
		isCompleted = false;
	}

	public void setPriority(int val) {
		priority = val;
	} 

	public void printToDo(int listNum) {
		if (isCompleted) {
			System.out.println("\t" + listNum + ": " + description);
			System.out.println("\tPriority " + priority + " *COMPLETE*");
		} else {
			System.out.println("\t" + listNum + ": " + description);
			System.out.println("\tPriority " + priority);
			
		}
	}






}