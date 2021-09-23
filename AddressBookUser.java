import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookUser{
	static ArrayList<ContatctUser> contactofuser = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	ContatctUser userData;
	int noOfEntry;
	String userFirstName, userLastName , address , city , state , emailId;
	long pinCode;
	long phoneNumber;
	
	public void addContact() {
		noOfEntry = sc.nextInt();
		for(int i=0; i< noOfEntry; i++) {
			System.out.println("Enter First Name: ");
			userFirstName = sc.next();
			try {
				for (int j=0; j<= contactofuser.size();j++) {
					if(contactofuser.isEmpty()) {
						break;
					}else {
						if(userFirstName.equals(userData.userFirstName))
							throw new UserIsThere();
					}
				}
				System.out.println("Enter Last Name: ");
				userLastName = sc.next();
				System.out.println("Enter Address: ");
				address = sc.next();
				System.out.println("Enter City: ");
				city = sc.next();
				System.out.println("Enter State: ");
				state = sc.next();
				System.out.println("Enter Email Id: ");
				emailId = sc.next();
				System.out.println("Enter Pin Code: ");
				pinCode = sc.nextLong();
				System.out.println("Enter phone number: ");
				phoneNumber = sc.nextLong();
				contactofuser.add(new ContatctUser(userFirstName, userLastName, address, city, state, pinCode,
						phoneNumber, emailId));
			} catch (UserIsThere e) {
				System.out.println(e.getMessage());
			}

			for (int k = 0; k < noOfEntry; k++) {
				userData = contactofuser.get(i);
				System.out.println(userData.userFirstName + "  " + userData.userLastName + " " + userData.address + " "
						+ userData.city + " " + userData.state + " " + userData.mailId + " " + userData.pinCode + " "
						+ userData.phoneNum);
			}

		}
	}

	public void editContact() {
		System.out.println("Enter the name of the person");
		userFirstName = sc.next();
		int counter = 0;
		for (int i = 0; i < contactofuser.size(); i++) {
			userData = contactofuser.get(i);
			if (userFirstName.equals(userData.userFirstName)) {
				System.out.println();
				System.out.println("Do u want to edit entire contact details? yes or no");
				String ch = sc.next();
				if (ch.equals("yes")) {
					System.out.println("Enter your new address:");
					address = sc.next();
					System.out.println("Enter your new city:");
					city = sc.next();
					System.out.println("Enter your new state:");
					state = sc.next();
					System.out.println("Enter your new email:");
					emailId = sc.next();
					System.out.println("Enter your new zip:");
					pinCode = sc.nextInt();
					System.out.println("Enter your new phn number:");
					phoneNumber = sc.nextLong();
					contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state, pinCode,
							phoneNumber, emailId));
					counter = 1;
				} else {
				
					System.out.println("Enter your choice to edit particular details.:1.firstname 2.lastname 3.address 4.city 5.state 6.email 7.zip 8.phn number");
					int input = sc.nextInt();
					switch (input) {
					case 1:
						System.out.println("Enter your new first name:");
						userFirstName = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 2:
						System.out.println("Enter your new last name:");
						userLastName = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 3:
						System.out.println("Enter your new address:");
						address = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 4:
						System.out.println("Enter your new city:");
						city = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber,emailId));
						break;
					case 5:
						System.out.println("Enter your new state:");
						state = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 6:
						System.out.println("Enter your new email:");
						emailId = sc.next();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 7:
						System.out.println("Enter your new zip");
						pinCode = sc.nextInt();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;
					case 8:
						System.out.println("Enter your new phn number");
						phoneNumber = sc.nextLong();
						contactofuser.set(i, new ContatctUser(userFirstName, userLastName, address, city, state,
								pinCode, phoneNumber, emailId));
						break;

					}
					counter = 1;
				}

				System.out.println("After new entery");

				for (i = 0; i < noOfEntry; i++) {
					userData = contactofuser.get(i);
					System.out.println(userData.userFirstName + " " + userData.userLastName + " " + userData.address
							+ " " + userData.city + " " + userData.state + " " + userData.mailId + " "
							+ userData.pinCode + " " + userData.phoneNum);
				}
				if (counter == 0)
					System.out.println("you have not enterd the correct name");

			}

		}
		
	}

	public void deleteUserEntry() {
		System.out.println();
		System.out.println("Enter the name of person you want to delete");
		userFirstName = sc.next();
		int counter = 0;
		for (int i = 0; i < contactofuser.size(); i++) {
			userData = contactofuser.get(i);
			if (userFirstName.equals(ContatctUser.userFirstName)) {
				contactofuser.remove(userData);
				counter = 1;
				System.out.println();
				System.out.println("yes its deleted");
			}
		}
		if (counter == 0) {

			System.out.println("invalid input");
		}
		
	}

	public void searchContact() {
		if (contactofuser.isEmpty()) {
			System.out.println("There in entry of any user");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 if you want to search by city name else press any number for searching by state");
		int temp = sc.nextInt();
		if (temp == 1) {
			System.out.println("Enter City Name: ");
			String city = sc.next();

			for (int i = 0; i < contactofuser.size(); i++) {
				if (contactofuser.get(i).getState() == city) {
					System.out.println("  " + contactofuser.get(i).getFirstName());
				}
			}
		} else {
			System.out.println("Enter State Name: ");
			String State = sc.next();
			for (int i = 0; i < contactofuser.size(); i++) {
				if (contactofuser.get(i).getCity() == State) {
					System.out.println("  " + contactofuser.get(i).getFirstName());
				}
			}
		}
	}
		
	}
	@SuppressWarnings("serial")
	class UserIsThere extends Exception {
		@Override
		public String getMessage() {
			return "User of this name is present";
		}
	}
	