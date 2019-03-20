package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String companySuffix = "company.com";
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	
	//Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		//Call A Method asking for the department - return department
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		//Call A Method That returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is: " + email);

		
		
		
		
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + ". Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
		Scanner in = new Scanner (System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	//Generate A random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	
	//Set Mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
		
	}
	
	//Change password
	public void changePassword(String password) {
		this.password = password;
		
	}
	
	public int getMailboxCapacity() {return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}


}
