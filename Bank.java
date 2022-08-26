import java.util.*;
import java.time.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;

class Registration    // Registration class for new user
{
	public String fName;
	public String address;
	public String adharNo;
	public String mobNo;
	public String email;
	public String dateOfBirth;
	public int age;
	
	private String pass;   // passwod make priavte for achive encapsulation

	Registration(String fName, String address, String adharNo,String mobNo, String email, String dateOfBirth, int age, String pass)
	{
		this.fName = fName;
		this.address = address;
		this.adharNo = adharNo;
		this.mobNo = mobNo;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.pass = pass;
	}

	public void setPassword(String pass)
	{
		this.pass = pass;
	}

	public String getPassword()
	{
		return pass;
	}
}

class BankAccount	 // BankAccount class for Login (existing users)
{
	public long balance;
	public long previousTransaction;
	public String customerName;
	public String customerID;

	BankAccount(String cName, String cId)
	{
		customerName = cName;
		customerID = cId;
	}

	public void Deposit(long amount)
	{
		if(amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
		}

 	public void withdraw(long amount)
	{
		if(amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

 	public long getPreviousTransaction()
	{
		return previousTransaction;
	}
}

class Transaction 	// Transaction class is use for to save the all transactions
{
	public String customerID;
	public String status;
	public long amount;
	public String timedate;

	Transaction(String customerID, String status, long amount, String timedate)
	{
		this.customerID = customerID;
		this.status = status;
		this.amount = amount;
		this.timedate = timedate;
	}
}

class Validations  
{
	public int option, age;
	public long amountDeposit1, amountWithdraw1;
	public boolean flag;

	InputStreamReader iobj = new InputStreamReader(System.in);
	BufferedReader bobj = new BufferedReader(iobj);

	public int acceptOption() throws IOException
	{
		do{
			try{
				flag = false;

				System.out.print("Enter an option : ");
				option = Integer.parseInt(bobj.readLine());

				if(option<0)
				{
					System.out.println("Enter valid option.!!!");
					System.out.println("\n------------------------------------------------------\n");
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid option.!!!");
				System.out.println("\n------------------------------------------------------\n");
			}
		}while(flag == false);

		return option;
	}

	public long acceptAmountToDeposit() throws IOException
	{
		do{
			try{
				flag = false;

				System.out.print("Enter an amount : ");
				amountDeposit1= Long.parseLong(bobj.readLine());

				if(amountDeposit1<0)
				{
					System.out.println("Enter valid amount.!!!");
					System.out.println("\n------------------------------------------------------\n");
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid amount.!!!");
				System.out.println("\n------------------------------------------------------\n");
			}
		}while(flag == false);

		return amountDeposit1;
	}

	public long acceptAmountToWithdraw() throws IOException
	{
		do{
			try{
				flag = false;

				System.out.print("Enter an amount : ");
				amountWithdraw1= Long.parseLong(bobj.readLine());

				if(amountWithdraw1<0)
				{
					System.out.println("Enter valid amount.!!!");
					System.out.println("\n------------------------------------------------------\n");
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid amount.!!!");
				System.out.println("\n------------------------------------------------------\n");
			}
		}while(flag == false);

		return amountWithdraw1;
	}

	public int acceptAge() throws IOException
	{
		do{
			try{
				flag = false;

				System.out.print("\nEnter Your Age : ");
				age = Integer.parseInt(bobj.readLine());

				if(age <= 0)
				{
					System.out.println("\nEnter valid age.!!!\n");
					System.out.println("------------------------------------------------------");
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nEnter valid age.!!!\n");
				System.out.println("------------------------------------------------------");
			}
		}while(flag == false);

		return age;
	}
}

class xDateTime   // xDateTime class use to access local date and time
{
	public String time()
	{
		LocalDateTime tobj = LocalDateTime.now();
		DateTimeFormatter fobj = DateTimeFormatter.ofPattern("dd-MMM-yyyy\tHH:mm:ss");
		String fDate = tobj.format(fobj);

		return fDate;
	}
}

class Bank
{
	public static void main(String arg[]) throws IOException
	{
 		ArrayList<Registration> rlist = new ArrayList<Registration>(); 
 		LinkedList<BankAccount> blist = new LinkedList<BankAccount>();
 		ArrayList<Transaction> tlist = new ArrayList<Transaction>();

 		InputStreamReader iobj1 = new InputStreamReader(System.in);
 		BufferedReader bobj1 = new BufferedReader(iobj1);

 		Validations vobj = new Validations();
 		xDateTime xtobj = new xDateTime();

 		int index = 0;
 		int option1 = 0;
 		boolean b1 = false;
 		
 		System.out.println("\n------------------------------------------------------\n");
 		System.out.println("\t\tWelcome to My Bank");
 		
 		while(true)
 		{
 			System.out.println("\n------------------------------------------------------\n");
 			System.out.println("\tMenu");
 			System.out.println("1. Create Account.");
	 		System.out.println("2. Login Account.");
	 		System.out.println("3. Number of Customers.");
	 		System.out.println("4. Exit.\n");

 			int option = vobj.acceptOption();

 			switch(option)
 			{
	 			case 1:
	 				{
	 					/*Accept information from user for creating new account*/

	 					System.out.print("\nEnter your full name : ");
	 					String fName = bobj1.readLine();

	 					System.out.print("\nEnter address : ");
	 					String address = bobj1.readLine();

	 					System.out.print("\nEnter Adhar Number : ");
	 					String adharNo = bobj1.readLine();

	 					if(adharNo.length() != 12)    // Validation for 12 digit adhar number 
	 					{
	 						System.out.println("\n\tInvalid Adhar Number.");
	 						break;
	 					}
	 				
	 					for(Registration list1:rlist)
						{
							if(list1.adharNo.equals(adharNo))
							{
								System.out.println("\t\nYour account already exits.");
								b1 = true;
								break;
							}
						}

						if(b1==true)
						{
							break;
						}

	 					System.out.print("\nEnter mobile Number : ");
	 					String mobNo = bobj1.readLine();

	 					if(mobNo.length() != 10)    // Validation for 10 digit mobile number 
	 					{
	 						System.out.println("\n\tInvalid Mobile Number.");
	 						break;
	 					}

	 					System.out.print("\nEnter your Email Id : ");
	 					String email = bobj1.readLine();
	 					
	 					System.out.print("\nEnter Date of Birth : ");
	 					String dateOfBirth = bobj1.readLine();

	 					int age = vobj.acceptAge();

	 					System.out.print("\nSet Password to your Account : ");
	 					String pass = bobj1.readLine();

	 					rlist.add(new Registration(fName, address, adharNo, mobNo, email, dateOfBirth, age, pass));
	 					blist.add(new BankAccount(fName,adharNo));

	 					System.out.println("\n------------------------------------------------------");
	 					System.out.println("\nAccount Created Successfully.\n");
	 					System.out.println("Your ID is : "+adharNo);
	 	
	 					break;
	 				}

	 			case 2:
		 			{
		 				/*Accept loin details*/

		 				System.out.println("\n------------------------------------------------------");
		 				System.out.println("\n\tLogin...");
		 				System.out.print("\nEnter Customer ID : ");
		 				String uname = bobj1.readLine();

		 				System.out.print("\nEnter Password : ");
		 				String pass = bobj1.readLine();

		 				System.out.println();
		 				boolean b = false;

		 				/*To check loin details are valid or not*/

		 				for(Registration riglist:rlist)
		 				{
		 					
		 					if(riglist.adharNo.equals(uname) && riglist.getPassword().equals(pass))
		 					{
		 						System.out.println("\tLogin Successfully.");

		 						System.out.print("\n\t\tUser Details");
		 						System.out.print("\n\tName      : "+riglist.fName+"\n\tAddress   : "+riglist.address+"\n\tAdhar No  : "+riglist.adharNo);
		 						System.out.print("\n\tMobile No : "+riglist.mobNo);
		 						System.out.print("\n\tEmail Id  : "+riglist.email+"\n\tDOB       : "+riglist.dateOfBirth+"\n\tAge       : "+riglist.age+"\n");
		 						System.out.println("\n------------------------------------------------------\n");

		 						index = rlist.indexOf(riglist);

		 						b = true;
		 						break;
		 					}
		 				}

		 				if(b == true)  //if loin details match
		 				{
		 					System.out.println("\tWelcome : "+blist.get(index).customerName);
							System.out.println("\tCustomer Id : "+blist.get(index).customerID);
							
							System.out.println("\n1.Check Balance.");
							System.out.println("2.Deposit");
							System.out.println("3.Withdraw");
							System.out.println("4.Previous Transaction");
							System.out.println("5.Show All Transactions");
							System.out.println("6.Change Password");
							System.out.println("7.Log out");

							do{
								System.out.println("------------------------------------------------------\n");
								option1 = vobj.acceptOption();		
								System.out.println("\n------------------------------------------------------");

								switch(option1)
								{
									case 1:
										{
											System.out.println("");
											System.out.println("\t\tYour account balance is : "+blist.get(index).balance);
											System.out.println("");
											break;
										}

									case 2:
										{
											System.out.println("");

											System.out.println("\tDeposit...\n");
											
											long amountDeposit = vobj.acceptAmountToDeposit();
											if(amountDeposit < 100)
											{
												System.out.println("\n\t\tInvalid Amount.\n"+"\n\t\tPlease enter amount greater than 100.\n");
											}
											else
											{
												blist.get(index).Deposit(amountDeposit);
												System.out.println("\n\t\tThe RS "+amountDeposit+" is deposited successfully.\n");
												tlist.add(new Transaction(blist.get(index).customerID,"Deposited",amountDeposit,xtobj.time()));
											}

											break;
										}

									case 3:
										{
											System.out.println("");
											System.out.println("\tWithdraw...\n");

											long amountWithdraw = vobj.acceptAmountToWithdraw();

											if(amountWithdraw < 100)
											{
												System.out.println("\n\t\tInvalid Amount.\n"+"\n\t\tPlease enter amount greater than 100.\n");
												break;											
											}
											
											if(amountWithdraw > blist.get(index).balance)
											{
												System.out.println("\n\t\tInsufficient Account Balunce.");
												System.out.println("");
											}
											else if((blist.get(index).balance - amountWithdraw) < 100)
											{
												System.out.println("\n\t\tMinimum account balance should be atleat 100.");	//
												System.out.println("");
											}
											else
											{
												blist.get(index).withdraw(amountWithdraw);
												System.out.println("\n\t\tThe RS "+amountWithdraw+" is withdraw successfully.");
												System.out.println("");
												tlist.add(new Transaction(blist.get(index).customerID,"Withdraw ",amountWithdraw,xtobj.time()));
											}

											break;
										}	

									case 4:
										{
											System.out.println("");
											System.out.println("\tPrevious Transaction...\n");
											long iRet = blist.get(index).getPreviousTransaction();

											if(iRet > 0)
											{
												System.out.println("\t\tDeposited : "+iRet);
												System.out.println("");
											}
											else if(iRet < 0)
											{
												System.out.println("\t\tWithdraw : "+Math.abs(iRet));
												System.out.println("");
											}
											else
											{
												System.out.println("\t\tNo Transaction Occured !!!.");
												System.out.println("");
											}
						
											break;
										}

									case 5:	
										{
											boolean bRet = false;
											System.out.println("\n\tTransactions History...\n");
											System.out.println("\tCustomer Name : "+blist.get(index).customerName);
											System.out.println("\tCustomer Id   : "+blist.get(index).customerID);
											System.out.println();

											System.out.println("	Status	     Amount		   Date		  Time"+"\n");
											for(Transaction tlist1:tlist)
											{
												if(blist.get(index).customerID.equals(tlist1.customerID))
												{
													System.out.println("\t"+tlist1.status+"  :  "+tlist1.amount+"\t\t"+tlist1.timedate);
													bRet = true;
												}
											}
											System.out.println("");

											if(bRet == false)
											{
												System.out.println("\tNo Transaction Occured !!!.");
												System.out.println("");
											}

											System.out.println("\t\tYour account balance is : "+blist.get(index).balance+"\n");
											
											break;
										}	

									case 6:
										{
											System.out.print("\nEnter Old Password : ");
											String pass1 = bobj1.readLine();
											if(rlist.get(index).getPassword().equals(pass1))
											{
												System.out.print("Enter new Password : ");
												String pass2 = bobj1.readLine();
												rlist.get(index).setPassword(pass2);
												System.out.println("\nPassword changed successfully.\n");
											}
											else
											{
												System.out.println("\nPassword not match.\n");
											}

											break;
										}	

									case 7:
										{
											System.out.println("\nAccount log out successfully.");
											break;
										}

									default:
									{
										System.out.println("");
										System.out.println("Invalid Option!!!.Please enter again.");
										System.out.println("");
									}	
								}
							}while(option1 != 7);
		 				}

		 				if(b == false)  //if loin details not matches with registration details
		 				{
		 					System.out.println("Incorrect Customer ID or Password");
		 					System.out.println("\n------------------------------------------------------\n");
		 				}

		 				break;
		 			}	

		 		case 3:
		 			{
		 				System.out.println("Number of Customers : "+rlist.size());
		 				break;
		 			}	

		 		case 4:
			 		{
			 			System.out.println("\n------------------------------------------------------\n");
			 			System.out.println("Thank You for using our service.");
			 			System.out.println("\n------------------------------------------------------\n");
			 			System.exit(0);
			 		}	
 			}
 		}
	}
}