import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Properties;
public class Main {

	static int Category_Number;
	static Main pract = new Main();
	static String mal,na,pass;
	static String mail = "",usuario = "",contra = "";
	static List <Category> list1Category = new ArrayList <Category>();
	static List <Product> list1Product = new ArrayList<Product>();
	static boolean user_menu = false;
	static boolean user_menu2 = false;
	
   
    void Administrator() {
    	
    	
    	Scanner am = new Scanner(System.in);

    	int Admin_menu = 0;
    	
    	while(Admin_menu!=3) {
    	
    	System.out.println("Welcome to the admin menu.");
    	System.out.println("1. Manage products");
    	System.out.println("2. Manage categories and sub categories");
    	System.out.println("3. Exit");  
    	
    	try {
    	Admin_menu = am.nextInt();
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		System.out.println("That's not a numeric value.");
    		
    	}finally {
    		
    		
    		System.out.println("Adios");
    		
    	}
    	if(Admin_menu == 1) {
    		
    		Scanner ef = new Scanner(System.in);
    		int product_menu2 = 0;
    		
    		while(product_menu2 !=4) {
    			
    			System.out.println("Welcome to the manage product menu.");
        		System.out.println("1. View all the products");
        		System.out.println("2. Add product");
        		System.out.println("3. Delete a product");
        		System.out.println("4. Exit");
        		product_menu2 = ef.nextInt();
        		
        		
        		if(product_menu2 == 1) {
        			
        			System.out.println("");
        			System.out.println("---------------------------------------------------------------");
    			
    			   for (int i = 0; i <= list1Product.size() - 1; i++) {
            
    				   System.out.println(i+1 + "Product :"); 
      				   System.out.println("//Product Name:  " + list1Product.get(i).NameProduct + "//Product Price :"+list1Product.get(i).price+ "//Product Category: " 
    				   + list1Product.get(i).NameCategory + " //SubCategory:  "
      						   + list1Product.get(i).SubCategory + " //ID:  " + list1Product.get(i).IdCategory);
      				   
      				   if(list1Product.get(i).stock) {
      					   
      					   System.out.println("The product is in Stock");
      					   
      				   }else {
      					   
      					   System.out.println("The product isn't in Stock");
  
      				   }
      				   
      				   System.out.println("");
      				   System.out.println("");
        			}
        			
        			
        		}
        		
        		if(product_menu2 == 2) {

        		Scanner fb = new Scanner(System.in);	
        		Scanner ft = new Scanner(System.in);	
        		Scanner fg = new Scanner(System.in);
    			Scanner fl = new Scanner(System.in);
    			Scanner fi = new Scanner(System.in);
    			Scanner f2 = new Scanner(System.in);
    			Scanner f3 = new Scanner(System.in);
    			String product_name = "", name_category = "", sub_category = "", i_d = "";
    			float pr_price;
    			
    			int cantidad1 = 0;
    			
    			int bool = 0;
    			System.out.println("To create a new product introduce Product Name, Product Price, Category Name, Sub Category Name and Category ID");
    			System.out.println("");
    			System.out.println("Product Name : ");
    			product_name = fb.nextLine();
    			System.out.println("Product Price :");
    			pr_price = ft.nextFloat();
    			System.out.println("Category name : ");
    			name_category = fg.nextLine();
    			System.out.println("Sub Category name : ");
    			sub_category = fl.nextLine();
    			System.out.println("Category ID : ");
    			i_d = fi.nextLine();
    			System.out.println("Number of Products : ");
    			cantidad1 = f3.nextInt();
    			System.out.println("If the product is in stock introduce 1, if it isn't introduce 0");
    			bool = f2.nextInt();
    			

    			if(product_name !="" && pr_price!=0 && name_category!="" && sub_category!="" && i_d!="" && (bool ==1 || bool ==0)) {
    			
    				if(bool == 1) {
    					
    					list1Product.add(new Product(pr_price,product_name,name_category, sub_category, i_d,true,false,cantidad1,0));
    					
    				}
    				else {
    					
    					list1Product.add(new Product(pr_price,product_name,name_category, sub_category, i_d,false,false,cantidad1,0));
    					
    					
    				}
    				
    				
    			
    			
    			}
	
        		}
        		
        		if(product_menu2 == 3) {
        			
        			       			 
        			int delete_product;
    				Scanner yl = new Scanner(System.in);
    				System.out.println("Introduce the number of theproduct that you want to delete.");
    				delete_product = yl.nextInt();
    				delete_product = delete_product -1;
    			
    				list1Product.remove(delete_product);
 
        		}
        		

    		}
    		
    		
    	}
    	
    	if(Admin_menu==2) {
    		
    		Scanner az = new Scanner(System.in);
    		
    		int admin_menu_2 = 0;
    		
    		while(admin_menu_2 != 4) {
    			
    		System.out.println("Welcome to the manage category menu.");
    		System.out.println("1. View all the categories and sub categories");
    		System.out.println("2. Add category and sub category");
    		System.out.println("3. Delete a category and sub category");
    		System.out.println("4. Exit");
    		
    		admin_menu_2 = az.nextInt();
    		
    		if(admin_menu_2 == 2) {
    			
    			
    			Scanner fg = new Scanner(System.in);
    			Scanner fl = new Scanner(System.in);
    			Scanner fi = new Scanner(System.in);
    			
    			String name_category = "", sub_category = "", i_d = "";
    			
    			System.out.println("To create a new category introduce Category Name, Sub Category Name and Category ID");
    			System.out.println("");
    			System.out.println("Category name : ");
    			name_category = fg.nextLine();
    			System.out.println("Sub Category name : ");
    			sub_category = fl.nextLine();
    			System.out.println("Category ID : ");
    			i_d = fi.nextLine();
    			
    			if(name_category!="" && sub_category!="" && i_d!="") {
    			
    			list1Category.add(new Category(name_category, sub_category, i_d ));
    			
    			}
    			
    		}
    		
    		if(admin_menu_2 == 1) {
    			
    			System.out.println("");
    			System.out.println("---------------------------------------------------------------");
    			
    			   for (int i = 0; i <= list1Category.size() - 1; i++) {
            
    				   System.out.println(i+1 + "Category :"); 
      				   System.out.println("//Name Category:  " + list1Category.get(i).NameCategory + " //SubCategory:  "
      						   + list1Category.get(i).SubCategory + " //ID:  " + list1Category.get(i).IdCategory);
      				   
      				   System.out.println("");
      				   
        		}
	
    		}
    		
    		if(admin_menu_2 == 3) {
    			
    			int delete_number;
    			Scanner yf = new Scanner(System.in);
    			System.out.println("Introduce the number of the category and sub category that you want to delete.");
    			delete_number = yf.nextInt();
    			delete_number = delete_number -1;
    			
    			list1Category.remove(delete_number);
    			
    			
    		}
    		
    		
    		
    		
    		
    		}
    		
    		
     }
    		
    	}
    	
        	
    }
    
    void start() {
		
		boolean passwor = false;
		
		if(user_menu == false) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Amabro.");
		System.out.println("To create an user is necessary to introduce an e-mail, an user name and a password.");
		System.out.println("");
		System.out.println("Introduce an email:");
		mail = sc.nextLine();
		Scanner sd = new Scanner(System.in);
		System.out.println("Introduce an user name:");
		usuario = sd.nextLine();
		Scanner se = new Scanner(System.in);
		
		String proof = "";
		
		while(!passwor) {
		
		System.out.println("Introduce a password: ");
		contra = se.nextLine();
		Scanner st = new Scanner(System.in);
		System.out.println("Introduce the password again: ");
		proof = st.nextLine();
		
		if(contra.equals(proof)) {
			passwor = true;
			User Usuario = new User(usuario, mail, contra);
			
			user_menu = true;
			break;
		}
		
		}
		
		}
		
		if(user_menu2) {
			
			
			while(user_menu2) {
			
			Scanner dp = new Scanner(System.in);
			Scanner df = new Scanner(System.in);
			
			String user2 = "",pass = "";
			
			System.out.println("Sign in.");
			System.out.println("Introduce the username or the email.");
			user2 = dp.nextLine();
			System.out.println("Introduce the password.");
			pass = df.nextLine();
			
			if((user2.equals(User.getName()) ||user2.equals(User.getEmail()) )) {
				
				if(pass.equals(User.getPassword())) {
				
				user_menu2 = false;
				
				}
				
			}else {
				
				
				user_menu2 = true;
				
			}
			
			
		}
		
		}
		
		
	}
    
    void user_menu() {
		
		
    	String n_user, ma_il, contri;
    	
    	int number_menu = 0;
    	
    	while(number_menu != 3) {
			
			Scanner nm = new Scanner(System.in);
			System.out.println("");
			System.out.println("Welcome to the Account menu of Amabro. ");
			System.out.println("");
			System.out.println("1. Account settings. ");
			System.out.println("2. Account info.");
			System.out.println("Introduce the number 3 to go back. ");
			System.out.println("");
			System.out.println("Introduce the number of the option. ");
			number_menu = nm.nextInt();

		switch(number_menu) {
		
		case 1:
		
		{
			
			int settings = 0;
			Scanner nj = new Scanner(System.in);
			
			System.out.println("Account settings ");
			System.out.println("1. Change user name.");
			System.out.println("2. Change email.");
			System.out.println("3. Change password.");
			System.out.println("Introduce any other key to go back. ");
			settings = nj.nextInt();
			
			switch(settings) {
			
			case 1 :
				
				Scanner sf = new Scanner(System.in);
				System.out.println("Introduce the new user name: ");
				n_user = sf.nextLine();
				User.setName(n_user);
				break;
				
			case 2 :
				
				Scanner sh = new Scanner(System.in);
				System.out.println("Introduce the new email");
				ma_il = sh.nextLine();
				User.setEmail(ma_il);
				break;
				
			case 3 : 
			
				Scanner sj = new Scanner(System.in);
				System.out.println("Introduce the new password");
				contri = sj.nextLine();
				User.setPassword(contri);
				break;
				
				
			default : 	
				
				System.out.println("Exit.");
				break;
			}
		}
		
		
		case 2: 
			
		{
			 
			System.out.println("Welcome to the Account info."); 
			System.out.println(""); 
			System.out.println("User name of the account: " + User.getName());
			System.out.println("");
			System.out.println("Email of the account: " + User.getEmail());
			
		}
				
		}
		
    	}
		
	}
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(FileReader reader =  new FileReader("config")) {
			
	        Properties properties = new Properties();
	        properties.load(reader);
	        
	       
	       String email = properties.getProperty("email");
	       String username = properties.getProperty("username");
	       String password = properties.getProperty("password");
	        
	        mal = email;
	        na = username;
	        pass = password;
	        
	      
	        
	       }catch (Exception e) {;
	       
	       e.printStackTrace();
	       
	       }
		
		
		Scanner a = new Scanner(System.in);
		
		int origin = 0;
		
	    	list1Category.add(new Category("Sports", "Swimming", "10010"));
	    	list1Category.add(new Category("Sports", "Basketball", "10010"));
	    	list1Category.add(new Category("Sports", "Soccer", "10010"));
	    	
	    	list1Category.add(new Category("Tecnollogy", "Computers", "10011"));
	    	list1Category.add(new Category("Tecnollogy", "Mobile Phones", "10012"));
	    	list1Category.add(new Category("Tecnollogy", "TV", "10013"));
	    	
	    	list1Category.add(new Category("Clothes and complements", "Sweatshirts", "10021"));
	    	list1Category.add(new Category("Clothes and complements", "T Shirts", "10022"));
	    	list1Category.add(new Category("Clothes and complements", "Pants", "1002"));
	    	
	    	//int c,int cc
	    	
	    	list1Product.add(new Product(11, "Swimming Glasses","Sports", "Swimming", "10011",true,false,10,0));
	    	list1Product.add(new Product(10, "Velax swimsuit","Sports","Swimming", "10012",true,false,10,0));
	    	
	    	list1Product.add(new Product(8, "Basket Ball","Sports", "Basketball", "10011",true,false,10,0));
	    	list1Product.add(new Product(10, "Soccer Ball","Sports", "Basketball", "10011",true,false,10,0));
	    	
	    	list1Product.add(new Product(12, "Goalkeeper gloves","Sports" , "Soccer", "10011",true,false,10,0));
	    	list1Product.add(new Product(40, "Shoes","Sports" , "Soccer", "10011",true,false,10,0));
	    	
	    	
	    	list1Product.add(new Product(150, "Xiaomi 4","Tecnollogy" , "Computers", "10011",true,false,10,0));
	    	list1Product.add(new Product(157, "Dell Lao","Tecnollogy" , "Computers", "10011",true,false,10,0));
	    	
	    	list1Product.add(new Product(100, "Xiamo Paco","Tecnollogy" , "Mobile Phones", "10011",true,false,10,0));
	    	list1Product.add(new Product(15, "Motorola Final","Tecnollogy" , "Mobile Phones", "10011",true,false,10,0));
	    	
	    	list1Product.add(new Product(1554, "Pepe Tv","Tecnollogy" , "TV", "10011",true,false,10,0));
	    	list1Product.add(new Product(1509, "Sony Tv","Tecnollogy" , "TV", "10011",true,false,10,0));
	    	
	    	
	    	list1Product.add(new Product(15, "Jay Clock","Clothes and complements" , "Sweatshirts", "10011",true,false,10,0));
	    	list1Product.add(new Product(16, "Arctic Monkeys","Clothes and complements" , "Sweatshirts", "10011",true,false,10,0));
	    	
	    	list1Product.add(new Product(5, "One Piece","Clothes and complements" , "T Shirts", "10011",true,false,10,0));
	    	list1Product.add(new Product(17, "Velax T","Clothes and complements" , "T Shirts", "10011",true,false,10,0));
	    	
	    	list1Product.add(new Product(25, "Shorts","Clothes and complements" , "Pants", "10011",true,false,10,0));
	    	list1Product.add(new Product(11, "Big Pants","Clothes and complements" , "Pants", "10011",true,false,10,0));
	    	
		
		while(origin!=3){
			
		System.out.println("User or Administrator.");
		System.out.println("1.User");
		System.out.println("2.Administrator");
		System.out.println("3.Go out");
		System.out.println("");
		System.out.println("Introduce the number of the option.");
		origin = a.nextInt();
		
		if(origin == 1) {
			
			pract.start();
			user_menu = true;
			user_menu2 = true;
			System.out.println("");
			
			Scanner df = new Scanner(System.in);

			int menu2 = 0;
			
			while(menu2 !=6) {
			
			System.out.println("1. Account");
			System.out.println("2. Products.");
			System.out.println("3. Categories.");
			System.out.println("4. Change product price to dollars.");
			System.out.println("5. Buy menu.");
			System.out.println("6. Go out.");
			System.out.println("Introduce the number of the option.");
			menu2 = df.nextInt();
			
			if(menu2 == 1) {
				
				pract.user_menu();
				
			}
			
			
			if(menu2 == 2) {
				
				Scanner dr = new Scanner(System.in);
				System.out.println("List of Categories :");
				
				System.out.println("");
    			System.out.println("---------------------------------------------------------------");
				
				for (int i = 0; i <= list1Category.size() - 1; i++) {

 				   System.out.println(i+1 + "Category :"); 
   				   System.out.println("//Name Category:  " + list1Category.get(i).NameCategory + " //SubCategory:  "
   						   + list1Category.get(i).SubCategory + " //ID:  " + list1Category.get(i).IdCategory);
   				   
   				   
   				   System.out.println("");
			
				}
				
				System.out.println("");
				System.out.println("Introduce the number of the category.");
				Category_Number = dr.nextInt();
				
				Category_Number = Category_Number -1;
				
				String hola = list1Category.get(Category_Number).NameCategory;
				
				System.out.println("");
    			System.out.println("---------------------------------------------------------------");
				
				for (int i = 0; i <= list1Product.size() - 1; i++) {
		            
					if(hola.equals(list1Product.get(i).NameCategory)) {
					
 				   System.out.println(i+1 + "Product :"); 
   				   System.out.println("//Product Name:  " + list1Product.get(i).NameProduct + "//Product Price :"+list1Product.get(i).price);
   				   if(list1Product.get(i).stock) {
					   
					   System.out.println("The product is in Stock");
					   
				   }else {
					   
					   System.out.println("The product isn't in Stock");

				   }
   				   
   				   System.out.println("");
   				   System.out.println("");
   				   
					}
   				   
     			}
								
	
			}
			
			
			if(menu2 == 3) {
				
				System.out.println("Categories : ");
				System.out.println("");
    			System.out.println("---------------------------------------------------------------");
				
				 for (int i = 0; i <= list1Category.size() - 1; i++) {
    
	    				   System.out.println(i+1 + "Category :"); 
	      				   System.out.println("//Name Category:  " + list1Category.get(i).NameCategory + " //SubCategory:  "
	      						   + list1Category.get(i).SubCategory + " //ID:  " + list1Category.get(i).IdCategory);
	      				   
	      				   System.out.println("");
				
				 }
				
			}
			
			if(menu2 == 4) {
				
				int menu2dollar;
				Scanner hg = new Scanner(System.in);
				
				System.out.println("Introduce the number of the product that you want to see the price in Dollars.");
				menu2dollar = hg.nextInt();
				menu2dollar = menu2dollar -1;
				
				
				System.out.println("The price in dollars is : "+ Product.dolar(list1Product.get(menu2dollar).price) );
				System.out.println("");
				
				
			}
			
			
			if(menu2 == 5) {
				
				Scanner buy = new Scanner(System.in);
				int buymenu = 0;
				
				while(buymenu != 5) {
					
					System.out.println("1. Buy a product.");
					System.out.println("2. Don't buy a product.");
					System.out.println("3. Cart info.");
					System.out.println("4. Print ticket.");
					System.out.println("5. Exit.");
					System.out.println("Introduce the number of the option.");
					buymenu = buy.nextInt();
					
					
					if(buymenu == 1) {
						
						Scanner hu = new Scanner(System.in);
						int buy1 = 0;
						
						//list1Product.get(menu2dollar).price
						
						System.out.println("Introduce the number of the product that you want to buy.");
						buy1 = hu.nextInt();
						buy1 = buy1-1;
						
						if(list1Product.get(buy1).stock && list1Product.get(buy1).getCantidad()!=0&& buy1!=0  ) {
							
							int canty = 0;
							Scanner dy = new Scanner(System.in);
							System.out.println("How many products do you want ?");
							canty = dy.nextInt();
							
							if(canty <= list1Product.get(buy1).getCantidad()&& canty!=0) {
								
								int cant = list1Product.get(buy1).getCantidad() - canty;
								int cantc =  list1Product.get(buy1).getCantidadcomprados() + canty;
								list1Product.get(buy1).setCompra(true);
								list1Product.get(buy1).setCantidad(cant);
								list1Product.get(buy1).setCantidadcomprados(cantc);
								
								
							}else {
								
								System.out.println("Sorry, there are only : "+ list1Product.get(buy1).getCantidad());
								System.out.println("");
							}
							
							
						}else {
							
							System.out.println("The product isn't in Stock");
							System.out.println("");

						}
							
							
						
					}
					
					
					if(buymenu == 2) {
						
						Scanner hj = new Scanner(System.in);
						int product_1;
						int pr;
						
						System.out.println("Buy products: ");
						System.out.println("");
						
						for (int i = 0; i <= list1Product.size() - 1; i++) {

			   				   if(list1Product.get(i).compra) {
								   
								    System.out.println(i+1 + "Product :");
								    System.out.println("Number of Products : "+list1Product.get(i).getCantidadcomprados());
			   				   		System.out.println("//Product Name:  " + list1Product.get(i).NameProduct + "//Product Price :"+list1Product.get(i).price+"�");
								   	
							   }

			     		}
					
						System.out.println("");
						System.out.println("");
						Scanner wr = new Scanner(System.in);
						
						System.out.println("If you want to remove a product from the cart introduce 1.");
						System.out.println("");
						pr = wr.nextInt();
						if(pr == 1) {
							
							System.out.println("Introduce the number of the product you want to remove.");
							product_1 = hj.nextInt();
							product_1 = product_1-1;
							
							
							int productcant = 0;
							
							
							if(list1Product.get(product_1).getCantidadcomprados() != 1) {
								Scanner ft = new Scanner(System.in);
								
								System.out.println("How many products do you want to remove?");
								productcant = ft.nextInt();
								productcant = list1Product.get(product_1).getCantidadcomprados() - productcant;
								if(productcant>list1Product.get(product_1).getCantidadcomprados()) {
									
									System.out.println("There are only : "+ list1Product.get(product_1).getCantidadcomprados());
	
								}
								
							}else {
								
								productcant = list1Product.get(product_1).getCantidadcomprados()-1;
							}
							
							

							list1Product.get(product_1).setCantidadcomprados(productcant);
							
							if(list1Product.get(product_1).getCantidadcomprados() == 0) {
								
							list1Product.get(product_1).setCompra(false);
							
							}
							
						}
						
					}
					
					
					if(buymenu == 3) {
						
						float total_price = 0;

						
						System.out.println("---------------------------------------------------------------");
						System.out.println("Products that you buy:");
						System.out.println("");
						System.out.println("");
						
						
						
						for (int i = 0; i <= list1Product.size() - 1; i++) {

   				   if(list1Product.get(i).compra) {
					   
					    System.out.println(i+1 + "Product :"); 
					    System.out.println("Number of Products : " + list1Product.get(i).getCantidadcomprados());
   				   		System.out.println("//Product Name:  " + list1Product.get(i).NameProduct + "//Product Price :"+list1Product.get(i).price+"�");
					   
   				   		total_price = total_price + list1Product.get(i).price*list1Product.get(i).getCantidadcomprados();
   				   		
				   }

     			         }
						
						System.out.println("");
						System.out.println("The total price is : " + total_price+"�");
						
					}
					
					
					
					if(buymenu == 4) {
						
						String ruta = "C:/Users/sergi/Desktop/TicketAmabro.txt";
						
						int path = 0;
						Scanner tr = new Scanner(System.in);
						System.out.println("Introduce the option.");
						System.out.println("1. Predeterminated Path.");
						System.out.println("2. Other Path");
						path = tr.nextInt();
						
						if(path == 1) {
							
							System.out.println("The ticket of your buy is in your Desktop.");
							
						}
						
						if(path == 2) {
							Scanner tx = new Scanner(System.in);
							String newpath;
							System.out.println("Introduce the new Path.");
							newpath = tx.nextLine();
							ruta = newpath;
							
						}
						
						FileReader leer = null;
						FileWriter escribir = null;
						
						String jump = "\r\n";
						String space = "\t";
						
						
						try {

							File f = new File(ruta);
							
							
							if(f.exists()) {
								
								f.delete();
								f.createNewFile();
								
							}
							
							FileWriter f2 = new FileWriter(f, true);
							
							float tprice = 0;
							float tpriceiva =  0;
							
							f2.write("\t \t \t \t AMABRO BUY TICKET ");
							f2.write(jump);
							f2.write(jump);
				
							for(int i = 0;i<list1Product.size();i++) {
								
								if(list1Product.get(i).compra) {
								f2.write(jump);
								f2.write("-------------------------------------");
								f2.write(jump);
								f2.write(i+1 + "Product -->");
								f2.write(jump);
								f2.write("Number of Products : "+list1Product.get(i).getCantidadcomprados());
								f2.write(space);
								f2.write("Product Name :" + list1Product.get(i).NameProduct);
								f2.write(space);
								f2.write("Price :" + list1Product.get(i).price+"�");
								f2.write(jump);
								
							
								tprice = tprice +  list1Product.get(i).price*list1Product.get(i).getCantidadcomprados();
								
								
								
								}
							}
							tpriceiva = (float) (tprice * 0.21);
							float jony = tpriceiva + tprice;
							f2.write(jump);
							f2.write(jump);
							f2.write("Total Price : " + (int) tprice+"�");
							f2.write(jump);
							f2.write("Total Price + IVA : " + jony+"�");
							f2.write(jump);
							f2.write("IVA = 21%");
							f2.close();

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
	
					}
												
					}
					
					
					
					
				}
				
				
			}
			
			}

		if(origin == 2) {

	        Scanner p1 = new Scanner(System.in);
	        Scanner p2 = new Scanner(System.in);
	        Scanner p3 = new Scanner(System.in);
	        
	        String email,username,password;
			
			 System.out.println("Introduce an email : ");
		        email = p1.nextLine();
		        System.out.println("Introduce an username : ");
		        username = p2.nextLine();
		        System.out.println("Introduce a password : ");
		        password = p3.nextLine();

		        if(mal.equals(email)&&(na.equals(username))&&(pass.equals(password))) {
		        	System.out.println("");
		        	pract.Administrator();
		        	
		        }else {
		        	
		        	origin = 3;
		        }	
		}
		else{	
	
		}
		
		}
		
		System.out.println("Goodbye");
		System.out.println("");
	}
}