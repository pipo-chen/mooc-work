import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. 使用 serverSocket 监听某个端口
 * 2. 创建一个类 HTTPServer 继承 java
 * 3. 获得浏览器请求，解析资源文件路径
 * 4. 读取资源文件，响应给浏览器
 */
public class ServerToBrowser {
	public static final  String HTML_ROOT = "/Users/ct/Documents/Alg/mooc-work/java-web02-server/src/";
	public static  void main(String[] args) throws IOException {
		//创建服务器监听 8080 端口
		ServerSocket server = new ServerSocket(7000);
		while (true) {
			Socket browser = server.accept();
			System.out.println("一个客户建立连接");

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						//获取请求包，并处理数据得到需要的东西
						BufferedReader br = new BufferedReader(new InputStreamReader(browser.getInputStream()));

						//获取请求（GET / picture.html HTTP 1.1 头部信息）
						String line = br.readLine();
						System.out.println(line);

						//获得访问的资源
						String path = line.split(" ")[1].substring(1);
						FileInputStream fis = null;
						try {
							//创建文件输入流
							fis = new FileInputStream(HTML_ROOT+path);
						} catch (Exception e) {
							fis = new FileInputStream(HTML_ROOT+"server-browser-test.html");
						}

						//获取文件输出并生成一个返回报文
						OutputStream os = browser.getOutputStream();
						os.write("HTTP/1.1 200 ok\r\n".getBytes());
						os.write("Content-Type: text/html\r\n".getBytes());
						os.write("\r\n".getBytes());

						byte[] buffer = new byte[2014];
						int len = -1;
						while ((len = fis.read(buffer)) != -1) {
							os.write(buffer, 0, len);
						}
						fis.close();
						browser.close();
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}



	}
}
