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
				System.out.println("\nSelect a TODO");
				int pos = scan2.nextInt() - 1;

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

			if (selection == 4) {
				removeItem();
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
		
	}

}