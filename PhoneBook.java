
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;


public class PhoneBook {
	public static void main(String[] args) {
		displayMenu();

	}

	public static void callContact(String name){
		System.out.println("Calling " + name);

	}

	public static void saveContact(String name, long phoneNumber){
		System.out.println("Saving contact " + name + " : " + phoneNumber);

		try{
			
			PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true));
			pw.println(name + " : " + phoneNumber);
			pw.close();


		}catch(IOException e){
			System.out.println(e.getMessage());

		}




	

	}

	public static void findNumber(String name){

		try(Scanner in = new Scanner(new File("file.txt"))) {
			String s[];

			boolean foundPerson = false;

			while(in.hasNextLine()) {
				s = in.nextLine().split(":");
				if(s[0].equals(name)) {
					System.out.println("The number associated with " + name + " is " + s[1]);
					foundPerson = true;
				}

				
			}

			if(!foundPerson){
				System.out.println("Could not find " + name);
			}

		}catch(IOException e){
			System.out.println(e.getMessage());
		
		} 
	}


	

	public static void displayMenu(){

		try (Scanner in = new Scanner(System.in)){
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

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}