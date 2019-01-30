import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {

	private ArrayList<ToDo> list;
	
	
	private Scanner scan3 = new Scanner(System.in);

	public ToDoList() {
		list = new ArrayList<ToDo>();
	}

	public void giveOptions() {
		int selection = 0;

		while (selection != 7) {
			System.out.println("1] Add a new TODO");
			System.out.println("2] Display the list");
			System.out.println("3] Set an item to complete or not complete");
			System.out.println("4] Remove an item from the list");
			System.out.println("5] Selection Sort list");
			System.out.println("6] Bubble Sort list");
			System.out.println("7] Quit");

			Scanner scan = new Scanner(System.in);
			selection = scan.nextInt();
			
			Scanner scan2 = new Scanner(System.in);

			if (selection == 1) {
				
				System.out.println("Description: ");
				String description = scan2.nextLine();

				System.out.println("Priority: ");
				int priority = scan2.nextInt();

				addToDo(description.trim(), priority);

				//addToDo("Something", 8);
			}

			if (selection == 2) {
				System.out.println("TODO LIST");
				displayList();
			}

			if (selection == 3) {
				displayList();
				int pos = selectToDo();
				setCompleteStatus(pos);
			}

			if (selection == 4) {
				displayList();
				int pos = selectToDo();
				System.out.println("Remove To Do " + (pos+1) + "? (Yes or No)");
				String str = scan2.nextLine();

				if (str.toLowerCase().equals("yes")) {
					removeItem(pos);
				}
			}

			if (selection == 5) {
				selectionSort();
			}

			if (selection == 6) {
				bubbleSort();
			}

			System.out.println("\n");
		}
		System.out.println("Bye.");
	}


	public void addToDo(String description, int priority) {
		list.add(new ToDo(description, priority));
	}

	public void displayList() {
		for (int i = 0; i < list.size(); i++) {
			(list.get(i)).printToDo(i + 1);
			System.out.println("\n");
		}
	}

	public void setItem(int index, boolean completeStatus) {
		if (completeStatus) {
			(list.get(index)).setComplete();
			System.out.println("SET TO COMPLETE");
		} else {
			(list.get(index)).setIncomplete();
		}
	}

	public void removeItem(int index) {
		list.remove(index);
	}

	public void setCompleteStatus(int pos) {
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Set complete or incomplete?");
		String completeResponse = scan3.nextLine();
		boolean completeBool;

		System.out.println(completeResponse);

		if (completeResponse.toLowerCase().equals("complete")) {
			completeBool = true;

		} else {
			completeBool = false;
		}

		setItem(pos, completeBool);
	}

	public int selectToDo() {
		Scanner scan4 = new Scanner(System.in);
		System.out.println("\nSelect a TODO");
		int pos = scan4.nextInt() - 1;
		return pos;
	}

	public void selectionSort() {
		int smallest = list.get(0).getPriority();

		for (int front = 0; front < list.size(); front++) {
			smallest = list.get(front).getPriority();
			for (int index = front; index < list.size(); index++) {
				if (list.get(index).getPriority() < smallest) {
					smallest = list.get(index).getPriority();
					switchSpots(index, front);
				}
			}
		}
	}

	public void bubbleSort() {
		boolean done = false;

		while (!done) {
			done = true;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getPriority() < list.get(i-1).getPriority()) {
					switchSpots(i, i - 1);
					done = false;
				}
			}
		}
	}

	public void switchSpots(int index, int front) {
		ToDo temp = list.get(front);
		list.set(front, list.get(index));
		list.set(index, temp);
		displayList();
		System.out.println("Switched " + (index + 1) + "with " + (front + 1));
	}

}