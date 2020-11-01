import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerToBrowser {
	public static final String ROOT = "/Users/ct/Desktop/";

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(8080);
		while (true) {
			Socket browser = server.accept();
			System.out.println("一个客户端建立连接");

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(browser.getInputStream()));
						String line = br.readLine();
						System.out.println(line);
						String path = line.split(" ")[1].substring(1);
						FileInputStream fil = null;
						try {
							fil = new FileInputStream(ROOT + path);
						} catch (Exception e) {
							fil = new FileInputStream(ROOT + "test.html");
						}

						OutputStream os = browser.getOutputStream();
						os.write("HTTP/1.1 200 OK\r\n".getBytes());
						os.write("Content-Type:text/html;charset-utf-8\r\n".getBytes());
						os.write("\r\n".getBytes());

						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = fil.read(buffer)) != -1) {
							os.write(buffer, 0, len);
						}
						fil.close();
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
