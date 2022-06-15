package com.products.store2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://store2.products.com/", portName = "ProductStoreImplPort", serviceName = "ProductStoreImplService")
public class ProductStoreImpl implements IproductStore {

	@WebMethod(operationName = "getAllProducts", action = "urn:GetAllProducts")
	@RequestWrapper(className = "com.products.store2.jaxws.GetAllProducts", localName = "getAllProducts", targetNamespace = "http://store2.products.com/")
	@ResponseWrapper(className = "com.products.store2.jaxws.GetAllProductsResponse", localName = "getAllProductsResponse", targetNamespace = "http://store2.products.com/")
	@Override
	public List<product> getAllProducts(String name, int pl, int ph) throws SQLException{
		List<product> ls = new ArrayList<product>();
		ResultSet rs=null;
		ConnectDB db = new ConnectDB();
		Connection con = db.getConnection();
		PreparedStatement st=null;
		st=con.prepareStatement("select * from newproducts where pname=? and price between ? and ?");
		st.setString(1, name);
		st.setLong(2, pl);
		st.setLong(3,ph);
		
		rs=st.executeQuery();
		while(rs.next()){
			product p = new product();
			p.setModel(rs.getString("pmodel"));
			p.setName(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			ls.add(p);
		}
		return ls;
		}
		

}
