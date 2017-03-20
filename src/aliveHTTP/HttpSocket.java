package aliveHTTP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * SERVICE
 * @author genius
 *
 */
public class HttpSocket {
	public static boolean pingHost(String host, int port, int timeout) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port),timeout);
			return true;
		} catch(IOException e) {
			return false;	// timeout or unreachable or failed DNS lookup
		}
	}
	
	public static void main(String args[]) {
		if(pingHost("https://www.google.co.kr",80,1000)) {
			System.out.println("ok");
		}
	}
}
