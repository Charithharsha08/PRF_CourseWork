

	import java.util.*;
public class dummy {
	
	static Scanner input = new Scanner(System.in); 
    static String [] details = {"admin" , "1234"};
    static final String [] Command ={"Y","N","y","n"};
    static String [] [] supDetail = new String[0][2];
    static String [] itemcategory = new String[0];
    static String [][] item = new String[0][6];
	public static void main (String[] args) {
		login(); 
	}
	
	private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
        if (os.equals("Linux")) {
        System.out.print("\033\143");
        } else if (os.equals("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        }
        } catch (final Exception e) {
        //handle the exception
        System.err.println(e.getMessage());
        }
        }
		public static void login(){
		System.out.println("+-------------------+------------------+----------------+------------------+");
        System.out.println("|                                 LOGIN PAGE                               |");
        System.out.println("+-------------------+------------------+----------------+------------------+");
		
		boolean status = true;
		while (true) {
			System.out.print("User Name : ");
			String name = input.next();
				if (!details[0].equals(name)) {
					System.out.println("\n" + "incorrect user name, please try again ! " + "\n");	
					}
				else{
					break;
				}
			}
			while (true) {
				System.out.print("Password : ");
				String password = input.next();
				if (!details[1].equals(password)) {
				System.out.println("\n" + "incorrect password, please try again ! " + "\n");
				}
				else{
				break;	
				}
			}
			
			welcomePage();
		}
		public static void welcomePage(){
			clearConsole();	
		System.out.println("+-------------------+------------------+----------------+------------------+");
        System.out.println("|                  WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                 |");
        System.out.println("+-------------------+------------------+----------------+------------------+");
   
        System.out.println("[01] Change The Credential" +"              [02] Supplier Manage "); 
        System.out.println("[03] Stock Manage                         [04] Log Out");   
        System.out.println("[05] Exit the system \n");

        System.out.print("Enter an option to continue  > ");
        int inputNumber = input.nextInt();
        
      
            switch (inputNumber) {
                case 1:
                   ChangeTheCredential(); 
                    break;
                case 2:
                   SupplierManage();
                    break;
                case 3 :
                     StockManage();
                case 4 :
                    LogOut();
                case 5 :
                    exitTheSystem();
                    break;
                default :
                    System.out.println("\nIt's not a valid number\n");
                    welcomePage();

        } 
}
public static void ChangeTheCredential(){
	clearConsole();
System.out.println("+-------------------+------------------+----------------+------------------+");
System.out.println("|                              CREDENTIAL MANAGE                           |");
System.out.println("+-------------------+------------------+----------------+------------------+");        

 String name ;

	while (true) {
	    System.out.print("Please enter the user name to veriffy it's you :");
		name = input.next();

	if (details[0].equals(name)) {
		System.out.println("Hey" + " " + name +"\n");
		   break;
	}else{
		System.out.println("\nIncorrect username. try again ! \n");
		   }
		}

  String password;

   while (true) {
	  System.out.print("Enter Your Currernt password:");
	   password = input.next();
	   
	   if (details[1].equals(password)) {
		   System.out.print("Enter Your new password: ");
		   String newPass = input.next();
		   details[1] = newPass;
		   break;
	   }else{
			System.out.println("Incorrect password. try again ! \n");
		   }
   		}
		
   
		   System.out.print("Password Change Successfully ! \n");
		   System.out.print("Do you want to go home page (Y/N)");
		   String answer = input.next();
		   
		   if (Command[0].equals(answer) || Command[2].equals(answer)){
			   welcomePage();
		   }else{
			   clearConsole(); 
			   ChangeTheCredential();
		     
			}
	   }

	   public static void LogOut(){
		String answer;
		System.out.print("\nAre you want to log out (Y/N):");
		answer = input.next();
		System.out.println();
		if (Command[0].equals(answer) || Command[2].equals(answer)) {
			login();
			}else{
			welcomePage();
			}
		}

		public static void exitTheSystem(){
			return;
		} 
		public static void SupplierManage(){
			clearConsole();
		   System.out.println("+-------------------+------------------+----------------+------------------+");
		   System.out.println("|                               SUPPLIER MANAGE                            |");
		   System.out.println("+-------------------+------------------+----------------+------------------+");
		   
		   System.out.println("[01] Add supplier\t\t\t[02] update supplier\n[03] delete supplier\t\t\t[04] view supplier\n[05] serch supplier\t\t\t[06]Home Page\n"); 
		   
		   System.out.print("Enter an option to continue  > ");
		   int inputNumber = input.nextInt();
   
		   switch (inputNumber) {
			   case 1:
				   AddSupplier();
				   break;
   
			   case 2:
				   updateSupplier();
				   break;
			   
			   case 3:
				  deleteSupplier();
				   break;
   
			   case 4:
				 viewSupplier();
				   break;
   
			   case 5:
				   serchSupplier();
				   break;
				   
			   case 6:
				  welcomePage();
				   break;
   
			   default:
			   System.out.println("\nIt's not a valid number\n");
				   SupplierManage();
				   break;
		   }
	   }
	   public static void growArray() {
			String temp [][] = new String[supDetail.length + 1][2];
			for(int i = 0 ; i < temp.length -1 ; i++ ){
			temp[i] = supDetail[i];
		}
		supDetail=temp;
	}
	public static void AddSupplier(){
		clearConsole();

	   System.out.println("+-------------------+------------------+----------------+------------------+");
	   System.out.println("|                                ADD SUPPLIER                              |");
	   System.out.println("+-------------------+------------------+----------------+------------------+"); 
   

	   while (true) {
		   
			 boolean duplicate =false;
		   System.out.println();
		   System.out.print("supplier id : ");
		   String id = input.next();
		 
		   for(int i = 0 ; i < supDetail.length ; i++){
			   if (id.equals(supDetail[i][0])) {
				   System.out.println("already exists, try another supplier id!");
				   duplicate = true;
				   break;
				}
		   }
		   if (!duplicate) {
				   growArray();
			   supDetail[supDetail.length -1 ][0]=id;
			   System.out.print("Supplier name ");
			   supDetail[supDetail.length -1 ][1] = input.next();
			   System.out.print("Added successfully ! do you want to another suplier (Y/N)");
			   String answer = input.next();

				 if (Command[1].equals(answer)|| Command[3].equals(answer)){
			   SupplierManage();
				 }else{
					AddSupplier();
				 }
				} 
			}
		   
		 }
		 public static void updateSupplier() {
			clearConsole();
				   System.out.println("+-------------------+------------------+----------------+------------------+");
				   System.out.println("|                                UPDATE SUPPLIER                           |");
				   System.out.println("+-------------------+------------------+----------------+------------------+");	 
				 
				boolean found =false;
			   while (true) {
			   System.out.println();
			   System.out.print("supplier id : ");
			   String id = input.next();

			   for(int i = 0 ; i < supDetail.length ; i++ ){
				 if(supDetail [i][0].equals(id)){
					System.out.print("Supplier name ");
				   supDetail[i][1] = input.next(); 
				   System.out.print("Added successfully ! do you want to another suplier (Y/N)");
				   String answer = input.next();

					 if (Command[1].equals(answer)|| Command[3].equals(answer)){
				   SupplierManage();
					 }else{
						updateSupplier();
					 }
					}
				}
			 if (!found){
				 System.out.println("Cant find supplier Id, try again !");
			   }
				  
			   }
			 }
			 public static void deleteSupplier(){
				clearConsole();
			   System.out.println("+-------------------+------------------+----------------+------------------+");
			   System.out.println("|                               DELETE SUPPLIER                            |");
			   System.out.println("+-------------------+------------------+----------------+------------------+");	  
			  deleteSupplierF();
			  }	
			  public static void  deleteSupplierF(){
				   boolean found =false;
				  while (true) {
				  System.out.println();
				  System.out.print("supplier id : ");
				  String id = input.next();
				  
				  int x = 0; 
				  
				  for (int i = 0; i < supDetail.length; i++)
				  {
				  if(supDetail [i][0].equals(id)) {
				  String[][] temp = new String[supDetail.length - 1][0];
				  x = i;
				  found =true;
				  for (int j = i; j < supDetail.length-1; j++) {
				  
				  supDetail[j] = supDetail[j+1];	
				   }
			  	  for (int k = 0; k < temp.length; k++)
			  		{
			 	 temp [k] =supDetail[k];	
			 	 }
				supDetail=temp;
  
			  System.out.print("Deleate successful ! Do you want to delete another supplier (Y/N) ");
			  String answer = input.next();
  				
				 if (Command[1].equals(answer)|| Command[3].equals(answer)){
					SupplierManage();
			  	}else{
					deleteSupplierF(); 
					}
				  }
			  }
	  
		  if(! found ) {
			  System.out.println("Can't find id, try again !");
					  }
					}
  				}
				  public static void viewSupplier(){
					clearConsole();
				   System.out.println("+-------------------+------------------+----------------+------------------+");
				   System.out.println("|                                 VIEW SUPPLIER                            |");
				   System.out.println("+-------------------+------------------+----------------+------------------+");	    
					System.out.printf("+-------------------------------------------------------+%n");
                    System.out.printf("| %-30s | %-20s |%n","SUPPLIER ID","SUPPLIER NAME");
					System.out.printf("+-------------------------------------------------------+%n");
				   for (int i = 0; i < supDetail.length; i++) {
					System.out.printf("| %-30s | %-20s |%n",supDetail[i][0],supDetail[i][1]);
					System.out.printf("+-------------------------------------------------------+%n");
				   }
				   while (true) {
					System.out.print("Do you want to go supplier manage page ? (Y/N): ");
					String answer = input.next();
					
					 if (Command[0].equals(answer) || Command[2].equals(answer)){
							SupplierManage();
					 }else{
							welcomePage();
					 }
					}
				}
				public static void serchSupplier(){
					clearConsole();
					System.out.println("+-------------------+------------------+----------------+------------------+");
					System.out.println("|                               SEARCH SUPPLIER                            |");
					System.out.println("+-------------------+------------------+----------------+------------------+");	  
		   while (true) {
			 boolean status = false;
		   System.out.print("Supplier id : ");
		   String id = input.next();
		   for(int i = 0 ; i < supDetail.length ; i++){
			   if (supDetail[i][0].equals(id)) {
					status = true;
				   System.out.print("Supplier Name : " + supDetail[i][1]+"\nDo you want to continue (Y/N)");
					   String answer = input.next();
					   if (Command[1].equals(answer) || Command[3].equals(answer)){
						   SupplierManage();
						   }else{
							serchSupplier();
						   }
					   }   
					   
				   }if (!status) {
		   System.out.println("Can't found supplier, try again !");
					   }   
			 }
		  }
		  public static void StockManage(){
			clearConsole();
		   System.out.println("+-------------------+------------------+----------------+------------------+");
		   System.out.println("|                               STOCK MANAGEMENT                           |");
		   System.out.println("+-------------------+------------------+----------------+------------------+");
  
		   System.out.println("[01] Manage Item Categories \t\t\t[02] Add Item \n[03] Get Item Supplier Wise \t\t\t[04] view Items\n[05] Rank Items Per Unit Price\t\t\t[06] Home Page\n"); 
	   
	   System.out.print("Enter an option to continue  > ");
	   int inputNumber = input.nextInt();

	   switch (inputNumber) {
		   case 1:
			 manageItemCategories();
			   break;

		   case 2:
			 addItem();
			   break;
		   
		   case 3:
			getItemSupplierWise();
			   break;

		   case 4:
			viewItems();
			   break;

		   case 5:
			rankItemsPerUnitPrice();
			   break;
			   
		   case 6:
		 	welcomePage();
			   break;

		   default:
		   System.out.println("\nIt's not a valid number\n");
			   StockManage();
			   break;
	   }
   }
   public static void manageItemCategories(){
	clearConsole();
	System.out.println("+-------------------+------------------+----------------+------------------+");
	System.out.println("|                             MANAGE ITEM CATEGORY                         |");
	System.out.println("+-------------------+------------------+----------------+------------------+");

	System.out.println("[01] Add New Categories \t\t\t[02] Delete Item Category \n[03] Update Item Categories \t\t\t[04] Stock Management \n"); 

System.out.print("Enter an option to continue  > ");
int inputNumber = input.nextInt();

switch (inputNumber) {
   case 1:
	 addNewCategories();
	   break;

   case 2:
	  deleteItemCategory();
	   break;
   
   case 3:
	 updateItemCategories();
	   break;

   case 4:
	StockManage();
	   break;
   default:
   System.out.println("\nIt's not a valid number\n");
	   manageItemCategories();
	   break;
}
clearConsole();
}
   public static void growItemcategoryArray() {
   String temp [] = new String[itemcategory.length + 1];
   for(int i = 0 ; i < temp.length -1 ; i++ ){
	   temp[i] = itemcategory[i];
   }
   itemcategory=temp;
}
   public static void addNewCategories(){
	clearConsole();
	System.out.println("+-------------------+------------------+----------------+------------------+");
	System.out.println("|                             ADD ITEM CATEGORY                            |");
	System.out.println("+-------------------+------------------+----------------+------------------+");  
	
	 while (true) {   
	System.out.print("enter the new item category : ");
	 String id = input.next();
	 boolean duplicate = false;
	   for(int i = 0 ; i < itemcategory.length ; i++){
		   if (id.equals(itemcategory[i])) {
			   System.out.println("already exists, try another item category!");
			   duplicate = true;
			   break;
			}
	   }
	   if (!duplicate) {
			   growItemcategoryArray();
		   itemcategory[itemcategory.length -1 ]=id;
		   System.out.print("Added successfully ! do you want to another item category (Y/N)");
		   String answer = input.next();

			 if (Command[1].equals(answer) || Command[3].equals(answer)){
		   StockManage();
			 }else{
				addNewCategories();
			 }
			}

		}
	}
		
public static void deleteItemCategory(){
	clearConsole();
	System.out.println("+-------------------+------------------+----------------+------------------+");
	System.out.println("|                            DELETE ITEM CATEGORY                          |");
	System.out.println("+-------------------+------------------+----------------+------------------+");  
   deleteItemCategoryF();
}
	
public static void deleteItemCategoryF(){
	   boolean found =false;
	   while (true) {
	   System.out.println();
	   System.out.print("item category : ");
	   String id = input.next();
	   
	   int x = 0; 
	   
	   for (int i = 0; i < itemcategory.length; i++)
	   {
	   if(itemcategory [i].equals(id)) {
	   String[] temp = new String[itemcategory.length - 1];
	   x = i;
	   found =true;
	   
	   
   
	   
	   

	   for (int j = i; j < itemcategory.length-1; j++) {
	   
	   itemcategory[j] = itemcategory[j+1];	
	   
   }
   for (int k = 0; k < temp.length; k++)
   {
   temp [k] =itemcategory[k];	
   }
				   itemcategory=temp;

System.out.print("Deleate successful ! Do you want to delete another item category (Y/N) ");
   String answer = input.next();


			 if (Command[1].equals(answer) || Command[3].equals(answer)){
		   manageItemCategories();
			 }else{
				 deleteItemCategoryF();
				 }
}

}


if(!found) {
   System.out.println("Can't find item category, try again !");
		   }    	
} 
			  
} 
public static void updateItemCategories(){	
			clearConsole();	  
		   System.out.println("+-------------------+------------------+----------------+------------------+");
		   System.out.println("|                           UPDATE ITEM CATEGORY                           |");
		   System.out.println("+-------------------+------------------+----------------+------------------+");	 
		   updateItemCategoriesF();
	   }
	   public static void updateItemCategoriesF(){
			   boolean found =false;
	   while (true) {
	   System.out.println();
	   System.out.print("item category : ");
	   String id = input.next();

	   for(int i = 0 ; i < itemcategory.length ; i++ ){
		 if(itemcategory [i].equals(id)){
			System.out.print("new item category ");
		   itemcategory[i] = input.next(); 
		   System.out.print("Added successfully ! do you want to another item to category (Y/N)");
		   String answer = input.next();

			 if (Command[1].equals(answer) || Command[3].equals(answer)){
		   manageItemCategories();
			 }else{
			  updateItemCategoriesF(); 
			 }
			}
		}
	 if (!found){
		 System.out.println("Cant find category, try again !");
	   }
	   
	   }
			 
	   }
	 public static void addItem(){
	   clearConsole();
		 System.out.println("+-------------------+------------------+----------------+------------------+");
		 System.out.println("|                                   ADD ITEM                               |");
		 System.out.println("+-------------------+------------------+----------------+------------------+");

	   if (itemcategory.length==0) {
		   System.out.print("OOPS! It seems that you don't have any item categories in the system. \nDo you want to add new item category (Y/N) ");
		   String answer = input.next();
		   if (Command[0].equals(answer) || Command[2].equals(answer)){
		   addNewCategories();
		   }else{
			  addItem();
		   }
	   }
	   if (itemcategory.length!=0 ) {
		   if (supDetail.length ==0) {
		   System.out.print("OOPS! It seems that you don't have any Supplier  in the system. \nDo you want to add new supplier (Y/N) ");
		   String answer = input.next();
		   if (Command[0].equals(answer)){
		   AddSupplier();
		   }else{
			   addItem();
		   }
		   }
		   clearConsole();
	   }
	 
	   if (itemcategory.length!=0 && supDetail.length !=0 ) {
		   String code;
		   String num;
		 growItemArray();

		   System.out.print("Item Code : ");
		   code = input.next();
		  	System.out.println("Code eka"+code);		
		   item[item.length -1 ][0]=code;
		   
		   System.out.println("supplier list : ");
		   System.out.printf("+-------------------------------------------+%n");
		   System.out.printf("| %-5s | %-15s | %-15s |%n","#","Supplier id","supplier name");
		   System.out.printf("+-------------------------------------------+%n");

		   for(int i = 0 ; i < supDetail.length ; i++){
		   System.out.printf("| %-5s | %-15s | %-15s |%n",i+1,supDetail[i][0],supDetail[i][1]);
		   System.out.printf("+-------------------------------------------+%n");

		   }
		   System.out.print("enter supplier number : ");
		   num = input.next();
		   int supNum= Integer.parseInt(num);
		   item[item.length -1 ][1]=supDetail[supNum-1][0];
		   System.out.println("item category : ");
		   System.out.printf("+-------------------------------------------+%n");
		   System.out.printf("| %-5s | %-30s |%n","#","Category name");
		   System.out.printf("+-------------------------------------------+%n");
		   System.out.println();

		   for (int i = 0 ; i < itemcategory.length ; i++ ){
		   System.out.printf("| %-5s | %-30s |%n",i+1,itemcategory[i]);
		   System.out.printf("+-------------------------------------------+%n");
		   System.out.println();

		   }
		   
		   System.out.print("Enter your Category number  : ");
		   String catNum = input.next();
		   int catogary= Integer.parseInt(catNum);
		   item[item.length -1 ][2]=itemcategory[catogary-1];
			System.out.println();


		   System.out.print("Description : ");
		   String description = input.next();
		   item[item.length -1 ][3]=description;
		   System.out.println();

		   System.out.print("Unit price : ");
		   String unitPrice = input.next();
		   item[item.length -1 ][4]=unitPrice;
		   System.out.println();


		   System.out.print("Qty on hand : ");
		   String qty = input.next();
		   item[item.length -1 ][5]=qty;
		   System.out.println();

		   System.out.print("Added successfull! Do you want to continue (Y/N) : ");
		   String answer = input.next();
		   System.out.println();
		   if (Command[0].equals(answer) || Command[2].equals(answer)){
		   		addItem();
		   }else{
				StockManage();   
		   }
	   }
	}
	  public static void growItemArray() {
   String temp [][] = new String[item.length + 1][6];
   for(int i = 0 ; i < temp.length -1 ; i++ ){
	   temp[i] = item[i];
   }
   item=temp;
	}
	public static void getItemSupplierWise(){
		clearConsole();
		System.out.println("+-------------------+------------------+----------------+------------------+");
		System.out.println("|                               SEARCH SUPPLIER                            |");
		System.out.println("+-------------------+------------------+----------------+------------------+");
		  String supId;
		 int i ; 

			 System.out.print("Enter supplier id : ");
			 supId = input.next();

		for( i = 0 ; i < supDetail.length ; i++){
		  if (supDetail[i][0].equals(supId)) {
			  System.out.println("Supplier name "+supDetail[i][1]);
			}
		  }
		  System.out.printf("++%n");
		  System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
		  System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND ","CATEGORY");
		  System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
		for(int j = 0 ;j < item.length ; j++ ){
		  if (item[j][1].equals(supId)) {
		  System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n",item[j][0],  item[j][3], item[j][4],item[j][5],item[j][2]);
		  System.out.printf("+-----------------------------------------------------------------------------------------+ %n");

				}
			}
	   }
	   public static  void viewItems(){
		for(int i = 0; i < itemcategory.length ;i++){
			System.out.println(itemcategory[i]);
			System.out.println();
			System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND ","CATEGORY");
			System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
			for(int j = 0 ; j < item.length ; j++){
			if (itemcategory[i].equals(item[j][2])) {
		    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n",item[j][0],  item[j][3], item[j][4],item[j][5],item[j][2]);
			System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
			}
			}
		}
		
	   }
	   public static void rankItemsPerUnitPrice(){
		String [][] temp = new String[item.length][6];
		
		
        for (int i = 0 ; i < item.length-1;i++){
            for(int j = 0 ; j < item.length-1; j++){
                if(Integer.parseInt(item[j][4]) > Integer.parseInt(item[j+1][4])){
                    temp[j] = item[j];
                    item[j] = item[j+1];
                    item[j+1] = temp[j];
                }
            }
        }

		//for(int i = 0; i < itemcategory.length ;i++){
		//	System.out.println(itemcategory[i]);
			System.out.println();
			System.out.printf("+----------------------------------------------------------------------------------------------+ %n");
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n","SID","CODE","DESC","PRICE","QTY","CAT");
			System.out.printf("+-----------------------------------------------------------------------------------------+ %n");
			for(int j = 0 ; j < item.length ; j++){
			//if (itemcategory[i].equals(temp2[j][2])) {
		    System.out.printf("| %-15s| %-15s | %-15s | %-15s | %-15s | %-15s |%n",item[j][1],item[j][0],  item[j][3], item[j][4],item[j][5],item[j][2]);
			System.out.printf("+----------------------------------------------------------------------------------------------+ %n");
			//}
			}
		//}
	   }
	   
}
