package com.products.store2;

import java.sql.SQLException;
import java.util.List;

public interface IproductStore {
	
	public List<product> getAllProducts(String name, int plow, int phigh) throws SQLException;

}
