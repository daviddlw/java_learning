package java_learning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.david.concurrency.EvenChecker;
import com.david.concurrency.EvenGenerator;
import com.david.concurrency.MutexEvenGenerator;

public class ConcurrenyTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void test()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void evenGeneratorTest()
	{
//		EvenChecker.test(new EvenGenerator());
		EvenChecker.test(new MutexEvenGenerator());
	}

}
