package java_learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.david.jdbcTemplate.Department;
import com.david.jdbcTemplate.Employee;

public class TestJdbcTemplate
{
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
	private static DataSource dataSource;
	private static JdbcTemplate jdbcTemplate;
	private static NamedParameterJdbcTemplate npJdbcTemplate;

	static
	{
		dataSource = (DataSource) ctx.getBean("dataSource");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		npJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testDataSource()
	{
		System.out.println(dataSource);
	}

	@Test
	public void testUpdate()
	{
		String sql = "update employee set name = 'david.dai' where id=?";
		int count = jdbcTemplate.update(sql, 1);
		System.out.println("成功执行了" + count + "条记录。");
	}

	@Test
	public void testInsert()
	{
		String sql = "insert into employee (name, email, dept_id) values (?, ?, ?)";
		int count = jdbcTemplate.update(sql, new Object[] { "newadd", "newadd@qq.com", 1 });
		System.out.println("成功新增了" + count + "条记录。");
	}

	@Test
	public void testBatchInsert()
	{
		String sql = "insert into employee (name, email, dept_id) values (?, ?, ?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "aa", "aa@qq.com", 1 });
		batchArgs.add(new Object[] { "bb", "bb@qq.com", 2 });
		batchArgs.add(new Object[] { "cc", "cc@qq.com", 3 });
		batchArgs.add(new Object[] { "dd", "dd@qq.com", 1 });
		batchArgs.add(new Object[] { "ee", "ee@qq.com", 2 });
		batchArgs.add(new Object[] { "ff", "ff@qq.com", 3 });

		int[] executeRsArr = jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println("执行结果：" + Arrays.toString(executeRsArr));
		System.out.println("成功新增了" + executeRsArr.length + "条记录");
	}

	/**
	 * 不能使用queryForObject(sql, Class<T>, Object...)的方法 转而使用queryForObject(sql,
	 * RowMapper<T>, Object...)的方法
	 */
	@Test
	public void testQueryForObject()
	{
		String sql = "select id, name, email, dept_id deptId from employee where id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}

	@Test
	public void testQueryForObjectList()
	{
		String sql = "select id, name, email, dept_id deptId from employee";
		List<Map<String, Object>> employees = jdbcTemplate.queryForList(sql);
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> ls = jdbcTemplate.query(sql, rowMapper);
		System.out.println(employees);
		System.err.println(ls);
	}

	@Test
	public void testInsertForNamedParameterJdbcTemplate()
	{
		String sql = "insert into department (name) values (:name)";
		Department dept = new Department();
		dept.setName("市场部");
		SqlParameterSource dataSource = new BeanPropertySqlParameterSource(dept);
		int count = npJdbcTemplate.update(sql, dataSource);
		System.out.println("成功增加了：" + count);
	}
}
