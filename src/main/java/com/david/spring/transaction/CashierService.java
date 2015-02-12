package com.david.spring.transaction;

import java.util.List;

public interface CashierService
{
	public void checkOut(String username, List<String> isbns);
}
