package com.david.spring.transaction;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double findBookPriceByIsBn(String isbn)
	{
		// TODO Auto-generated method stub
		String sql = "select price from springbook where isbn = ?";
		BigDecimal result = jdbcTemplate.queryForObject(sql, BigDecimal.class, isbn);
		double price = result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return price;
	}

	@Override
	public void updateBookStock(String isbn)
	{
		// TODO Auto-generated method stub
		String sql = "update springbookstock set stock = stock-1 where isbn = ?";
		int count = jdbcTemplate.update(sql, isbn);

		String checkSql = "select stock from springbookstock where isbn = ?";
		int currentStock = jdbcTemplate.queryForObject(checkSql, Integer.class, isbn);
		System.out.println(currentStock);
		if (currentStock <= 0)
		{
			throw new BookStockException("库存不足！");
		}

		System.err.println("成功更新了: " + count + "条记录");
	}

	@Override
	public void updateUserAccount(String username, double price)
	{
		// TODO Auto-generated method stub

		String checkSql = "select balance from springaccount where username = ?";
		BigDecimal result = jdbcTemplate.queryForObject(checkSql, BigDecimal.class, username);
		double currentStock = result.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(currentStock);
		if (currentStock < price)
		{
			throw new UserAccountException("余额不足！");
		}

		String sql = "update springaccount set balance = balance - ? where username = ?";
		int count = jdbcTemplate.update(sql, new Object[] { price, username });
		System.err.println("成功更新了: " + count + "条记录");
	}

}
