package com.products.store2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
	private Connection connection =null;
	public Connection getConnection(){
		try{
			System.out.println("In try block, trying to connect to DB....");
			
			System.out.println("Class loaded is: " + Class.forName("com.mysql.jdbc.Driver").newInstance());
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			if(connection !=null)
				System.out.println("Connection to DB successful");
			
		}catch(Exception e){
			
			System.out.println("unable to connect to database check DB");
			
		}
		return connection;
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String name="mobile";
		String pid="m10";
		ResultSet rs=null;
		ConnectDB db = new ConnectDB();
		Connection con = db.getConnection();
		PreparedStatement st=null;
		st=con.prepareStatement("select * from products where pname=?");
		st.setString(1, name);
		rs=st.executeQuery();
		while(rs.next()){
			List<product> ls = new ArrayList<product>();
			product p = new product();
			p.setModel(rs.getString("pmodel"));
			p.setName(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			ls.add(p);
			for(product p1 : ls)
			System.out.println(p1.getName()+ " ," + p.getModel()+ ", " + p.getPrice()+ ", "+ p.getStock());
		}
		st=con.prepareStatement("select price from products where pid=?");
		st.setString(1, pid);
		rs=st.executeQuery();
		while(rs.next())
		System.out.println("Price of the mobile selected is :" +rs.getInt("price"));

	}

}
