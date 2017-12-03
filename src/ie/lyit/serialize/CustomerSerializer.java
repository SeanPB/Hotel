package ie.lyit.serialize;

import java.util.ArrayList;

import ie.lyit.hotel.Customer;

import java.io.*;
import java.util.*;

public class CustomerSerializer {
	// Constant FILENAME for the file to be created
	final String FILENAME = "customers.bin";

	// Declare ArrayList called Customers - for storing a list of Customers
	private ArrayList<Customer> customers;
	

	// Default Constructor
	public CustomerSerializer(){
		// Construct Customers ArrayList
		customers = new ArrayList<Customer>();
	}

	//////////////////////////////////////////////////////
	// Method Name : add()								//
	// Return Type : void								//
	// Parameters : None								//
	// Purpose : Reads one Customer record from the user    //
	//           and adds it to the ArrayList Customers     //
	//////////////////////////////////////////////////////	
	public void add(){
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();	
		// And add it to the Customers ArrayList
		customers.add(customer);
	}

	////////////////////////////////////////////////////////
	// Method Name : list()							      //
	// Return Type : void			  				      //
	// Parameters : None						 	      //
	// Purpose : Lists all Customer records in the ArrayList  //
	////////////////////////////////////////////////////////	
	public void list(){
		// for every Customer object in Customers
      for(Customer tmpCustomer:customers)
			// display it
			System.out.println(tmpCustomer);
	}
	
	////////////////////////////////////////////////////////////
	// Method Name : view()									  //
	// Return Type : void								      //
	// Parameters : None								      //
	// Purpose : Displays the required Customer record on screen  //
	//         : And returns it, or null if not found         //   
	////////////////////////////////////////////////////////////	
	
	public Customer view(){
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the Customer to be viewed from the user
		System.out.println("ENTER NUMBER OF Customer : ");
		int CustomerToView=keyboard.nextInt();
		
		// for every Customer object in Customers
	    for(Customer tmpCustomer:customers){

		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   
		}
	    // if we reach this code the Customer was not found so return null
	    System.out.println("Customer Not Found: ");
	    return null;		
	}

	///////////////////////////////////////////////////////////
	// Method Name : delete()								 //
	// Return Type : void									 //
	// Parameters : None									 //
	// Purpose : Deletes the required Customer record from Customers //
	///////////////////////////////////////////////////////////	
	public void delete(){	
		// Call view() to find, display, & return the Customer to delete
		Customer tempCustomer = view();
		
		// If the Customer != null, i.e. it was found then...
	    if(tempCustomer != null)
	    	
		   // ...remove it from Customers
	       customers.remove(tempCustomer);
	}
	
	///////////////////////////////////////////////////////////
	// Method Name : edit()			  					     //
	// Return Type : void									 //
	// Parameters : None									 //
	// Purpose : Edits the required Customer record in Customers     //
	///////////////////////////////////////////////////////////	
	public void edit(){	
		// Call view() to find, display, & return the Customer to edit
		Customer tempCustomer = view();
		// If the Customer != null, i.e. it was found then...
	    if(tempCustomer != null){
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new Customer and...
		   tempCustomer.read();
		   // reset the object in Customers
		   customers.set(index, tempCustomer);
	    }
	}
	
	///////////////////////////////////////////////////////
	// Method Name : writeRecordsToFile()    			 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Writes the ArrayList Customers to the       //
	//		     File Customers.bin before closing the File  //
	///////////////////////////////////////////////////////	
	public void writeRecordsToFile(){
		try{
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
	
			os.writeObject(customers);
	
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customer data.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	///////////////////////////////////////////////////////
	// Method Name : readRecordsFromFile()    			 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads the ArrayList from the File back  //
	//		     into Customers before closing the File      //
	///////////////////////////////////////////////////////	
	public void readRecordsFromFile(){
		try{
			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);
			customers=(ArrayList<Customer>)is.readObject();
			

			// COULD use code below to ensure it is an ArrayList
			// BUT no need-we are confident file contains an ArrayList
			// Object o = is.readObject(); 	// READ an object from the file
			// if(o instanceof ArrayList)  	// IF object is an ArrayList
			//    Customers=(ArrayList<Customer>)o;//    ASSIGN object to Customers			

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find Customers file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
	}	

}