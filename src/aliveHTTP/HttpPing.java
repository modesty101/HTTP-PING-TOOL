package aliveHTTP;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPing {

	public static boolean pingUrl(final String address) throws Exception {
		final URL url = new URL("http://"+address);
		final HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
		urlConn.setConnectTimeout(1000);
		final long startTime = System.currentTimeMillis();
		urlConn.connect();
		final long endTime=System.currentTimeMillis();
		if(urlConn.getResponseCode()==HttpURLConnection.HTTP_OK) {
			System.out.println("Time (ms) : "+(endTime-startTime));
			System.out.println("Ping to "+address+" was success");
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		try {
			boolean flag = pingUrl("www.google.co.kr");
			System.out.println(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
