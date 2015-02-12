package com.david.spring.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务嵌套的话默认传播行为沿用同一个事务
 * @author pc
 *
 */
@Transactional
@Service("cashierService")
public class CashierServiceImpl implements CashierService
{
	@Autowired
	private BookService bookService;
	
	@Override
	public void checkOut(String username, List<String> isbns)
	{
		// TODO Auto-generated method stub
		for (String isbn : isbns)
		{
			bookService.purchase(username, isbn);
		}
	}

}
