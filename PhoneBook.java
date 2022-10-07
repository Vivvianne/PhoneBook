import java.util.Scanner;


public class PhoneBook {
	public static void main(String[] args) {
		displayMenu();

	}

	public static void callContact(String name){
		System.out.println("Calling " + name);

	}

	public static void saveContact(String name, long phoneNumber){
		System.out.println("Saving contact " + name + " : " + phoneNumber);


	}

	public static void findNumber(String name){
		System.out.println("Could not find " + name);

	}

	public static void displayMenu(){

		Scanner in = new Scanner(System.in);
		String name;

		System.out.println("What would you like to do?");
		System.out.println("1. Call contact.");
		System.out.println("2. Save contact");
		System.out.println("3. Find contact.");

		int choice = in.nextInt();
		in.nextLine();

		switch(choice){
			case 1:
				System.out.println("Who would you like to call? (FirstName LastName)");
				name = in.nextLine();

				callContact(name);
				break;

			case 2:
				System.out.println("\nWhat is the name of the person you would like to save? (Firstname LastName)");
				name = in.nextLine();

				System.out.println("\nWhat is the phone number of the person you are saving?  (254)");
				long phoneNumber = in.nextLong();
				in.nextLine();

				saveContact(name, phoneNumber);

				break;

			case 3:
				System.out.println("what is the name of the person whose phone number you are searching for? (FirstName LastName)");
				findNumber(in.nextLine());
				break;


			default:

				break;
		}


	}
}