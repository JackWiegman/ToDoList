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

		while (selection != 5) {
			System.out.println("1] Add a new TODO");
			System.out.println("2] Display the list");
			System.out.println("3] Set an item to complete or not complete");
			System.out.println("4] Remove an item from the list");
			System.out.println("5] Quit");

			Scanner scan = new Scanner(System.in);
			selection = scan.nextInt();
			

			if (selection == 1) {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Description: ");
				String description = scan2.nextLine();

				System.out.println("Priority: ");
				int priority = scan2.nextInt();

				addToDo(description, priority);

				//addToDo("Something", 8);
			}

			if (selection == 2) {
				System.out.println("TODO LIST");
				displayList();
			}

			if (selection == 3) {
				
				setItem();
			}

			if (selection == 4) {
				//removeItem();
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
			list.get(i).printToDo();
		}
	}

	public void setItem(int index, boolean completeStatus) {
		if (completeStatus) {
			
		}
	}

}