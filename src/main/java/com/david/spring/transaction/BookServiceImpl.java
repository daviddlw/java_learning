package com.david.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookShopDao bookShopDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void purchase(String username, String isbn)
	{
		// 1. 查询书的单价
		double price = bookShopDao.findBookPriceByIsBn(isbn);
		// 2. 更新书的库存
		bookShopDao.updateBookStock(isbn);
		// 3. 更新账户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
