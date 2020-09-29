import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class _2 {
	public static void main(String[] args) {
		int total_stu = 3;
		Student []students = new Student[total_stu];
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (count < total_stu) {
			System.out.println("请输入格式：(姓名,成绩1,成绩2,成绩3)");
			String str = sc.next();
			String[] infos = str.split(",");
			if (infos.length == 4) {
				students[count++] = new Student(infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]),Integer.parseInt(infos[3]));
			}
		}
		System.out.println(Arrays.toString(students));
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));

		String path = "src/stud.txt";
		FileUtils fileUtils = new FileUtils();
		fileUtils.create(path);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			for (int i = 0; i < total_stu; i++) {
				Student s = students[i];
				oos.writeObject(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

class Student implements Comparable<Student>, Serializable {
	public String name;
	public int []scores = new int[3];
	public int total;

	public Student() {
	}

	public Student(String name, int s1, int s2, int s3) {
		this.name = name;
		this.scores[0] = s1;
		this.scores[1] = s2;
		this.scores[2] = s3;
		this.total = s1 + s2 + s3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "n ame=: " + name + '\'' +
				", scores= " + Arrays.toString(scores) +
				'}';
	}

	@Override
	public int compareTo(Student o) {
		return o.total - this.total;
	}
}
