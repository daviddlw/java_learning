package com.david.spring.transaction;


public interface BookShopDao
{
	public double findBookPriceByIsBn(String isbn);
	
	public void updateBookStock(String isbn);
	
	public void updateUserAccount(String username, double price);
}
