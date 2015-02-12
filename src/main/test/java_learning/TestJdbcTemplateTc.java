package java_learning;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.transaction.BookService;
import com.david.spring.transaction.BookShopDao;
import com.david.spring.transaction.CashierService;

public class TestJdbcTemplateTc
{
	private static ApplicationContext ctx = null;
	private static BookShopDao bookShopDao = null;
	private static BookService bookService = null;
	private static CashierService cashierService = null;

	static
	{
		ctx = new ClassPathXmlApplicationContext("jdbcTemplateTransaction.xml");
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
		bookService = (BookService) ctx.getBean("bookService");
		cashierService = (CashierService) ctx.getBean("cashierService");
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testPurchaseBookFlow()
	{
		bookService.purchase("daviddai", "1001");
	}

	@Test
	public void testCachierService()
	{
		cashierService.checkOut("daviddai", Arrays.asList(new String[] { "1001", "1002" }));
	}

	@Test
	public void testFindBookPriceByIsBn()
	{
		double price = bookShopDao.findBookPriceByIsBn("1002");
		System.out.println(price);
	}

	@Test
	public void testUpdateBookStock()
	{
		bookShopDao.updateBookStock("1001");
	}

	@Test
	public void testUpdateUserAccount()
	{
		bookShopDao.updateUserAccount("daviddai", 888);
	}

}
