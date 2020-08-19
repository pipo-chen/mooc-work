import java.util.Arrays;
import java.util.Objects;

public class TestObjectClass {
	public static void main(String[] args) throws CloneNotSupportedException{
		//初始化
		Book b1 = new Book(1,"红楼");
		Book b2 = new Book(2, "西游");
		Book b3 = new Book(3,"三国");
		Book b4 = new Book(4,"水浒");
		Book [] books = new Book[] {b1,b2,b3,b4};

		//clone()
		Person p1 = new Person(1001,"张三",books);
		Person p2 = (Person) p1.clone();

		//修改 p1 p2 确定是否为浅层复制
		p1.books[0] = new Book(5,"最新");
		p2.name = "李四";
		p2.id = 1002;

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1.equals(p2) -> "+p1.equals(p2));
	}
}

class Book implements Cloneable{
	int bid;
	String bname;

	public Book() {

	}

	public Book(int bid, String bname) {
		this.bid = bid;
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "编号：" + bid +
				", 书名：'" + bname + '\'';
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return bid == book.bid &&
				bname.equals(book.bname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid, bname);
	}
}

class Person implements Cloneable{
	int id;
	String name;
	Book [] books;

	public Person(int id, String name, Book[] books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Person() {

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		//1. 创建对象
		Person person = (Person)super.clone();

		//2. 复制
		Book[] newBooks = new Book[books.length];
		for (int i = 0; i < books.length; i++) {
			Book book = books[i];
			Book nb = (Book) book.clone();
			newBooks[i] = nb;
		}
		//3. 赋值并返回
		person.books = newBooks;
		return person;
	}

	@Override
	public String toString() {
		return  "编号：" + id +
				", 姓名：'" + name + '\'' +
				", 书籍信息：" + Arrays.toString(books);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id &&
				name.equals(person.name) &&
				Arrays.equals(books, person.books);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, name);
		result = 31 * result + Arrays.hashCode(books);
		return result;
	}
}

