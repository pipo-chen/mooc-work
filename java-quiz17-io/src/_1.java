import java.io.*;
import java.io.File;

public class _1 {
	public static void main(String[] args) {
		String path = "src/pipo.txt";
		String target_path_copy = "src/pipo_copy_test.txt";
		String target_path_merge = "src/pipo_merge_test.txt";

		//init
		FileUtils fileUtils = new FileUtils();
		fileUtils.create(path);
		fileUtils.create(target_path_merge);
		fileUtils.writeBuffered(path,"网易 IO 作业", true);
		fileUtils.writeBuffered(path,"作为文件内容输入...", false);
		fileUtils.writeBuffered(target_path_merge, "这是一个即将被合并的文件..", false);

		//operation
		fileUtils.copy(path, target_path_copy);
		fileUtils.merge(path,target_path_merge);
	}
}

interface FileUtil {
	/**
	 * 创建指定文件
	 * @param path 待创建文件地址
	 */
	public void create(String path);

	/**
	 * 删除指定文件
	 * @param path 待文件地址
	 */
	public void delete(String path);

	/**
	 * 文件读取
	 * @param path
	 */
	public void read(String path);

	/**
	 * 通过缓存区进行文件读取固定大小
	 * @param path
	 */
	public String readBuffered(String path);

	/**
	 * 通过循环完成文件的读取
	 * @param path
	 */
	public void readBufferedAdvance(String path);

	/**
	 * 写文件
	 * @param path 地址
	 * @param content 内容
	 * @param isCover 是否覆盖原内容
	 */
	public void write(String path, String content, boolean isCover);

	/**
	 * 通过缓存中写文件
	 * @param path 地址
	 * @param content 内容
	 * @param isCover 是否覆盖原内容
	 */
	public void writeBuffered(String path, String content, boolean isCover) ;

	/**
	 * 文件拷贝
	 * @param source_path 源文件地址
	 * @param target_path 目标文件地址
	 */
	public void copy(String source_path, String target_path);

	/**
	 * 文件移动
	 * @param source_path 源文件地址
	 * @param target_path 目标文件地址
	 */
	public void remove(String source_path, String target_path);

	/**
	 * 文件合并
	 * @param sorce_path 源文件地址
	 * @param target_path 目标文件地址
	 */
	public void merge(String sorce_path, String target_path);

}

class FileUtils implements FileUtil {
	@Override
	public void create(String path) {
		File f = new File(path);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String path) {
		File f = new File(path);
		f.delete();
	}

	@Override
	public void read(String path) {
		File f = new File(path);
		InputStream is = null;
		try {
			is = new FileInputStream(f);
			for (int i = 0; i < f.length(); i++) {
				char ch = (char) is.read();
				System.out.println(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String readBuffered(String path) {
		InputStream is = null;
		String content = "";
		try {
			is = new FileInputStream(path);
			byte[] buff = new byte[is.available()];
			is.read(buff);
			content = new String(buff);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	@Override
	public void readBufferedAdvance(String path) {
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			byte[] buff = new byte[2];
			int index;
			while ((index = is.read(buff)) != -1) {
				System.out.println(new String(buff));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void write(String path, String content, boolean isCover) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(path), !isCover);
			for (int i = 0; i <content.length(); i++) {
				fos.write(content.charAt(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeBuffered(String path, String content, boolean isCover) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path, !isCover);
			byte[] buff = content.getBytes();
			fos.write(buff);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void merge(String sorce_path, String target_path) {

		String source = readBuffered(sorce_path);
		writeBuffered(target_path, source, false);

	}

	@Override
	public void remove(String source_path, String target_path) {
		String source = readBuffered(source_path);
		writeBuffered(target_path, source, true);
		delete(source_path);
	}

	@Override
	public void copy(String source_path, String target_path) {
		String source = readBuffered(source_path);
		writeBuffered(target_path, source, true);
	}
}




