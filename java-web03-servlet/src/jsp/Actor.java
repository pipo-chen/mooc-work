package jsp;

import java.io.Serializable;

/**
 * 1. JAVABEAN 类需要继承 Serializable
 * 2. 需要 一个无参数的构造函数
 */
public class Actor implements Serializable {
	private int id;
	private String first_name;
	private String last_name;

	private static final long serialVersionUID = 1L;

	public Actor() {
		//无参构造函数
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
