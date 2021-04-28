package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {

	@Test
	public void test01() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sakila");
		dataSource.setUser("root");
		dataSource.setPassword("wzy950505");
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}

	@Test
	public void test02() throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
		dataSource.setUsername("root");
		dataSource.setPassword("wzy950505");

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		int row = jdbcTemplate.update("insert into t_order value (?,?)",8,100);
		System.out.println(row);
	}

	@Test
	/**
	 * 注解：描述当前代码 - 保存到 jvm 运行期
	 * 1 判断当前 Class 类中有哪些属性
	 * 2 通过反射去获取 类/属性/方法 头上是否有注解 .getAonnotation() - null - @Test
	 * 3 根据这个注解名字/类型 执行对应的逻辑
	 */
	public void test03() throws Exception {
		ResourceBundle rs = ResourceBundle.getBundle("jdbc");
		System.out.println(rs.getString("driver"));
	}

}
