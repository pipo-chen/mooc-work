package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FastJsonDemo {
	@Test
	public void String2Object() {

		//模拟前台发过来的数据 字符串 和 数组
		String jsonString = "{'uid': 1001, 'username':'zhangsan','password':'12324'}";
		String jsonArray = "['北京','成都','深圳']";

		//解析
		User user = JSON.parseObject(jsonString, User.class);

		List<String> list = JSON.parseArray(jsonArray, String.class);

		//查看结果
		System.out.println(user);
		System.out.println(list);

	}

	@Test
	public void Obj2JsonString() {
		//模拟后台处理完成的数据发送给前台
		//1. User 对象
		User user = new User(1011,"zhangsan","7788");

		//2. 集合对象
		List<String> citys = new ArrayList<>();
		Collections.addAll(citys,"北京","成都","上海" );
		//3. 集合对象里面是自定义类型
		List<User> users = new ArrayList<>();
		Collections.addAll(users,
				new User(1001,"wangpang","123"),
				new User(1002, "chenyao","456"),
				new User(1003, "lisi","789"));

		//通过 fastJson 来完成转换
		String userString = JSON.toJSONString(user);
		String citysString = JSON.toJSONString(citys);
		String usersString = JSON.toJSONString(users);

		//输出查看效果
		System.out.println(userString);
		System.out.println(citysString);
		System.out.println(usersString);



	}
}
