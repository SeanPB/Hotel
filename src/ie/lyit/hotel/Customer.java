package ie.lyit.hotel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person{// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;			    // AND number

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	
	
	//read
	public void read(){
		
		
	      JTextField txtTitle = new JTextField();
	      txtTitle.setText("");
	      
	      JTextField txtFirstName = new JTextField();
	      txtFirstName.setText("");
	      
	      JTextField txtSurname = new JTextField();
	      txtSurname.setText("");
	      
	      JTextField txtAddress = new JTextField();
	      
	      txtFirstName.requestFocus();
	      JTextField txtemailAddress = new JTextField();
	      JTextField txtphoneNumber = new JTextField();
	      
			String fName = txtFirstName.getText();
			String sName = txtSurname.getText();
			String title = txtTitle.getText();

	      Object[] message = {
	    	  "Title: ", txtTitle,
	          "First Name:", txtFirstName,
	          "Surname:", txtSurname,
	          "Address:", txtAddress,
	          "Email:", txtemailAddress,
	          "Phone Number:", txtphoneNumber,
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer Details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	          this.name = new Name(txtTitle.getText(), txtFirstName.getText(), txtSurname.getText());
	          this.name.toString();
	          this.address = txtAddress.getText();
	          this.emailAddress = txtemailAddress.getText();
	          this.phoneNumber = txtphoneNumber.getText();
	      }   
	}
}