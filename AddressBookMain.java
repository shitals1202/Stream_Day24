import java.util.Scanner;

public class AddressBookMain{
	public static void main(String[] args) {
		
		System.out.println("Welcome To AddressBook System");
		AddressBookUser entry = new AddressBookUser();
		Scanner sc = new Scanner(System.in);
		//System.out.println("How many entries you want to do");
		int n = 1;
		int exit =5;
		while(n!=exit) {
		System.out.println("Enter 0 for Adding new contact: ");
		System.out.println("Enter 1 for Edit contact: ");
		System.out.println("Enter 2 for Delete Contact: ");
		System.out.println("Enter 4 for Search Contact: ");
		System.out.println("press 5 for exit");
		 n = sc.nextInt();
		switch(n) {
		case 0:
			entry.addContact();
			break;
		case 1:
			entry.editContact();
			break;
		case 2:
			entry.deleteUserEntry();
			break;
		case 3:
			entry.searchContact();
			break;
		}
		sc.close();
	}
}
}