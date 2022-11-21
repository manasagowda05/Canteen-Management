package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.StyleSheet;
import javax.xml.catalog.Catalog;

import com.mysql.cj.xdevapi.Statement;

import entities.Customer;
import entities.Food;
import entities.FoodOrder;
import entities.Vendor;
import db.DBConnection;


public class CanteenManagementDAOImp implements CanteenManagementDAO{
	
	private List<Customer> customerList=new ArrayList<>();
	private List<Vendor> vendorList=new ArrayList<>();
	private List<Food> foodList=new ArrayList<>();
	private List<FoodOrder> foodOrderList=new ArrayList<>();
	private Connection connection=null;
	private PreparedStatement statement=null;
	private ResultSet resultSet=null;
	
	public CanteenManagementDAOImp() {
		try {
			connection=DBConnection.getConnection();
			if(connection!=null){
				System.out.println("Connection success");
			}
			else{
				System.out.println("Connection fail");
			}
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addCustomer(){
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter customer name");
		String cname=scanner.nextLine();
		System.out.println("Enter customer phone number");
		String cphone=scanner.nextLine();
		System.out.println("Enter customer email address");
		String cemail=scanner.nextLine();
		System.out.println("Enter customer wallet balance");
		double cwalletbalance=scanner.nextDouble();
		String sql="insert into customer values(?,?,?,?,?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			statement.setString(2, cname);
			statement.setString(3, cphone);
			statement.setString(4, cemail);
			statement.setDouble(5, cwalletbalance);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void removeCustomer() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		String sql="delete from customer where cid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void editCustomer() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name of the customer to edit");
		String cname=sc.nextLine();
		
		System.out.println("Enter new walletbalance of the customer");
		double cwalletbalance=sc.nextDouble();
		String sql= "update customer set cwalletbalance=? where cname=?;";
		try{
			statement=connection.prepareStatement(sql);
			statement.setDouble(1, cwalletbalance);
			statement.setString(2, cname);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void searchCustomerById() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();

		String sql="select * from customer where cid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getDouble(5));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getAllCustomers() {
		// TODO Auto-generated method stub
		String sql="select * from customer";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getDouble(5));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void addVendor() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter vendor name");
		String vname=scanner.nextLine();
		System.out.println("Enter vendor phone number");
		String vphone=scanner.nextLine();
		System.out.println("Enter vendor email address");
		String vemail=scanner.nextLine();
		
		String sql="insert into vendor values(?,?,?,?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, vid);
			statement.setString(2, vname);
			statement.setString(3, vphone);
			statement.setString(4, vemail);
			
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
		
	}

	@Override
	public void removeVendor() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		scanner.nextLine();

		String sql="delete from vendor where vid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, vid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}	
		
	}

	@Override
	public void editVendor() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id of the vendor to edit");
		int vid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new gmail id of the vendor ");
		String vemail=sc.nextLine();

		String sql= "update vendor set vemail=? where vid=?";
		try{
			statement=connection.prepareStatement(sql);
			statement.setString(1, vemail);
			statement.setInt(2, vid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void searchVendorById() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		scanner.nextLine();

		String sql="select * from vendor where vid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, vid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void getAllVendors() {
		// TODO Auto-generated method stub
		String sql="select * from vendor";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		
	}

	@Override
	public void addFood() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter food description");
		String fdesc=sc.nextLine();
		System.out.println("Enter food price");
		double fprice=sc.nextDouble();

		String sql="insert into food values(?,?,?);";

		try{
			statement=connection.prepareStatement(sql);
			statement.setInt(1, fid);
			statement.setString(2, fdesc);
			statement.setDouble(3, fprice);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}		
		
		
	}

	@Override
	public void removeFood() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=sc.nextInt();
		sc.nextLine();

		String sql="delete from food where fid=?;";
		try{
			statement=connection.prepareStatement(sql);
			statement.setInt(1, fid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" record affected");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void editFood() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enetr new price of food");
		double fprice=sc.nextDouble();

		String sql="update food set fprice=? where fid=?;";
		try{
			statement=connection.prepareStatement(sql);
			statement.setDouble(1, fprice);
			statement.setInt(2, fid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" record affected");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void searchFoodById() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=sc.nextInt();
		sc.nextLine();
		String sql="select * from food where fid=?;";
		try{
			statement=connection.prepareStatement(sql);
			statement.setInt(1, fid);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllFood() {
		// TODO Auto-generated method stub
		String sql="select * from food;";
		try{
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		
		
	}
//customer
	@Override
	public void placeOrder() {
		// TODO Auto-generated method stub
		System.out.println("Product                                 Food id");
		System.out.println("Cold Coffe                                101");
		System.out.println("Salad                                     102");
		System.out.println("Hot coffe                                 103");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter order id");
		int rid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter customer id");
		int cid=sc.nextInt();
		sc.nextLine();

		System.out.println("Enter food id");
		int fid=sc.nextInt();
		sc.nextLine();
					
		System.out.println("Enter vendor id");
		int vid=sc.nextInt();
		sc.nextLine();

		System.out.println("Enter order date");
		String orderdate=sc.nextLine();

					//System.out.println("Enter order status");
		String orderstatus="null";

					//System.out.println("Enter your feedback");
		double fprice;
		String s="select cwalletbalance from customer where cid=?;";
					try{
						statement=connection.prepareStatement(s);
						statement.setInt(1, cid);
						resultSet=statement.executeQuery();
						while(resultSet.next()) {
							System.out.println("Your wallet balance is "+resultSet.getDouble(1));
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
					System.out.println("Enter wallet balance");
					double cwalletbalance=sc.nextDouble();
		do{
			System.out.println("Welcome to cafeteria");
			System.out.println("Menu");
			System.out.println("1.Cold coffe--------------------Rs.140.0\n2.Salad--------------------Rs.180.0\n3.Hot coffe--------------------Rs.250.0\n4.Exit");
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice){
				case 1:
					

					String sql="insert into foodorder values(?,?,?,?,?,'pending',140.0);";
					try{
						statement=connection.prepareStatement(sql);
						statement.setInt(1, rid);
						statement.setInt(2, cid);
						statement.setInt(3, fid);
						statement.setInt(4, vid);
						statement.setString(5, orderdate);
						//statement.setString(6, orderstatus);
						//statement.setString(6, feedback);
						int n=statement.executeUpdate();
						if(n>=0)
							System.out.println(n+" record affected");
					}catch(SQLException e){
						e.printStackTrace();
					}
					
					
					//String sql1="update customer  set cwalletbalance=cwalletbalance-140.0 where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					String sql1="update customer set cwalletbalance=0+(cwalletbalance-140.0) where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					try{
						statement=connection.prepareStatement(sql1);
						int n1=statement.executeUpdate();
						
						if(cwalletbalance>140.0){
							System.out.println("order placed");
							String sq="update foodorder set orderstatus='placed' where cid=?;";
							try{
								statement=connection.prepareStatement(sq);
								statement.setInt(1, cid);
								int n9=statement.executeUpdate();
							}catch(SQLException e){
								e.printStackTrace();
							}
						}
						else{
							System.out.println("Insufficient balance");
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
						
					/* 
							String sql4="select cwalletbalance from customer where cid=?";
								try{
									statement=connection.prepareStatement(sql4);
									statement.setInt(1, cid);
									resultSet=statement.executeQuery();
									while(resultSet.next()) {
										System.out.println("wallet balance is "+resultSet.getDouble(1));
									}
								}catch(SQLException e3){
									e3.printStackTrace();
								}
									String sql1="update customer  set cwalletbalance=cwalletbalance-140.0 where cwalletbalance>140.0 and cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
									try{
										statement=connection.prepareStatement(sql1);
										int n2=statement.executeUpdate();
										String sql5="update foodorder set orderstatus='placed' where cwalletbalance>0;";
										try{
											statement=connection.prepareStatement(sql5);
											int n5=statement.executeUpdate();
											System.out.println("Thank you for ordering");
										}catch(SQLException e1){
											e1.printStackTrace();
											}
									}catch(SQLException e2){
											e2.printStackTrace();
									}
											String sql2="select cwalletbalance from customer where cwalletbalance<=140.0 and cid=?;";
												try{
													statement=connection.prepareStatement(sql2);
													statement.setInt(1, cid);
													resultSet=statement.executeQuery();
													while(resultSet.next()) {
													System.out.println(resultSet.getDouble(1));
													}
												}catch(SQLException e){
													e.printStackTrace();
												}
												System.out.println("please update your wallet balance");
										
									
									//System.out.println("Please update your wallet balance");
								
							//}
						/*if(n>=0){
							//System.out.println("Enter your id");
							String sql4="select cwalletbalance from customer where cwalletbalance>0 and cid=?;";
							try{
								statement=connection.prepareStatement(sql4);
								statement.setInt(1, cid);
								resultSet=statement.executeQuery();
								while(resultSet.next()) {
									System.out.println("wallet balance is "+resultSet.getDouble(1));
								}
							
								System.out.println(n+" record affected");
								//System.out.println("Your order is placed");
							
								String sql1="update customer  set cwalletbalance=cwalletbalance-140 where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
								try{
									statement=connection.prepareStatement(sql1);
									int n2=statement.executeUpdate();
									if(n2>=0){
										String sql5="update foodorder set orderstatus='placed';";
										statement=connection.prepareStatement(sql5);
										int n5=statement.executeUpdate();
										if(n5>=0){
											System.out.println("Thank you for ordering");
											String sql2="select cwalletbalance from customer where cwalletbalance<=0 and cid=?;";
											try{
												statement=connection.prepareStatement(sql2);
												statement.setInt(1, cid);
												resultSet=statement.executeQuery();
												while(resultSet.next()) {
												System.out.println(resultSet.getDouble(1));
												}
											}catch(SQLException e){
												e.printStackTrace();
											}
											System.out.println("Please update your wallet balance");
										}
									}
										
									}catch(SQLException e){
										e.printStackTrace();
									}
								}catch(SQLException e){
									e.printStackTrace();
								}
							}*/
						//}
							//else{
								//System.out.println("please update your wallet balance1");
							//}
						
				break;
				case 2:
					String sq2="insert into foodorder values(?,?,?,?,?,'pending',180.0);";
					try{
						statement=connection.prepareStatement(sq2);
						statement.setInt(1, rid);
						statement.setInt(2, cid);
						statement.setInt(3, fid);
						statement.setInt(4, vid);
						statement.setString(5, orderdate);
						//statement.setString(6, orderstatus);
						//statement.setString(6, feedback);
						int n=statement.executeUpdate();
						if(n>=0)
							System.out.println(n+" record affected");
					}catch(SQLException e){
						e.printStackTrace();
					}
					
					
					//System.out.println("Enter wallet balance");
					//double cwalletbalance=sc.nextDouble();
					//String sql1="update customer  set cwalletbalance=cwalletbalance-140.0 where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					String sq="update customer set cwalletbalance=0+(cwalletbalance-180.0) where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					try{
						statement=connection.prepareStatement(sq);
						int n1=statement.executeUpdate();
						
						if(cwalletbalance>180.0){
							System.out.println("order placed");
							String sql2="update foodorder set orderstatus='placed' where cid=?;";
							try{
								statement=connection.prepareStatement(sql2);
								statement.setInt(1, cid);
								int n9=statement.executeUpdate();
							}catch(SQLException e){
								e.printStackTrace();
							}
						}
						else{
							System.out.println("Insufficient balance");
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
				break;
				case 3:
					String sq3="insert into foodorder values(?,?,?,?,?,'pending',250.0);";
					try{
						statement=connection.prepareStatement(sq3);
						statement.setInt(1, rid);
						statement.setInt(2, cid);
						statement.setInt(3, fid);
						statement.setInt(4, vid);
						statement.setString(5, orderdate);
						//statement.setString(6, orderstatus);
						//statement.setString(6, feedback);
						int n=statement.executeUpdate();
						if(n>=0)
							System.out.println(n+" record affected");
					}catch(SQLException e){
						e.printStackTrace();
					}
					
					
					//System.out.println("Enter wallet balance");
					//double cwalletbalance=sc.nextDouble();
					//String sql1="update customer  set cwalletbalance=cwalletbalance-140.0 where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					String sq4="update customer set cwalletbalance=0+(cwalletbalance-250.0) where cid in (select cid from (select cid from foodorder  where cid=cid) as balance );";
					try{
						statement=connection.prepareStatement(sq4);
						int n1=statement.executeUpdate();
						
						if(cwalletbalance>250.0){
							System.out.println("order placed");
							String sa="update foodorder set orderstatus='placed' where cid=?;";
							try{
								statement=connection.prepareStatement(sa);
								statement.setInt(1, cid);
								int n9=statement.executeUpdate();
							}catch(SQLException e){
								e.printStackTrace();
							}
						}
						else{
							System.out.println("Insufficient balance");
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
				break;
				case 4:
					System.out.println("Bye");
					System.exit(0);
				default:
					System.out.println("Invalid choice");

			}
		}while(true);
	


		
		
	}
//customer
	@Override
	public void checkWalletBalance() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your id");
		int cid=sc.nextInt();
		sc.nextLine();
		String sql="select cwalletbalance from customer where cid=?;";
		try{
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Your wallet balance is "+resultSet.getDouble(1));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
//vendor
	@Override
	public void viewOrdersPlaced() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sql="select * from foodorder where orderstatus='placed';";
		try{
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4)+" "+resultSet.getDate(5)+" "+resultSet.getString(6)+" "+resultSet.getDouble(7));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
//vendor
	@Override
	public void viewPendingOrders() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sql="select * from foodorder where orderstatus='pending';";
		try{
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4)+" "+resultSet.getDate(5)+" "+resultSet.getString(6)+" "+resultSet.getDouble(7));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
//vendor
	@Override
	public void viewCompletedOrders() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sql="select * from foodorder where orderstatus='complete';";
		try{
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4)+" "+resultSet.getDate(5)+" "+resultSet.getString(6)+" "+resultSet.getDouble(7));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
//customer
	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter order id");
		int rid=sc.nextInt();
		sc.nextLine();
		System.out.println("Sure want to cancel order ");
		int cancel=sc.nextInt();
		sc.nextLine();
		System.out.println("Type 1 to cancel your order");
		if(cancel>0){
			String sql="delete from foodorder where rid=?;";
			try{
				statement=connection.prepareStatement(sql);
				statement.setInt(1, rid);
				int n=statement.executeUpdate();
				if(cancel==1){
					System.out.println(n+ " record affected");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Your order is placed");
		}

		//}
		//else if(cancel=="no"){
			//System.out.println("Your order is not canceled\nThank you");

		//}
		
	}
//vendor
	@Override
	public void completeOrder() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("To complete order pending orders are: ");
		String s1="select * from foodorder where orderstatus='placed';";
		try{
			statement=connection.prepareStatement(s1);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4)+" "+resultSet.getDate(5)+" "+resultSet.getString(6)+" "+resultSet.getDouble(7));
			}
			System.out.println("Enter order id");
			int rid=sc.nextInt();
			sc.nextLine();
		//String orderstatus=null;
			String sql="update foodorder set orderstatus='complete' where rid=?;";
			try{
				statement=connection.prepareStatement(sql);
			//statement.setString(1, orderstatus);
				statement.setInt(1, rid);
				int n=statement.executeUpdate();
				if(n>=0){
					System.out.println(n+ " record affected");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
