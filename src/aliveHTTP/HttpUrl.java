package aliveHTTP;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrl {

	public static boolean httpUrl(String url, boolean available) {
		try {
			final URLConnection conn = new URL(url).openConnection();
			conn.connect();
			// 로그 메소드
			available =true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return available;
	}
	public static void main(String[] args) {
		if(httpUrl("http://www.google.co.kr", false)) {
			System.out.println("Service available, yeah!");
		} else {
			System.out.println("Service unavailable, oh no");
		}
	}

}
