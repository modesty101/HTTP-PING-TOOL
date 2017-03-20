package aliveHTTP;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
/**
 * ANDROID
 * @author genius
 *
 */
/*
 *  ConnectivityManager connMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = connMan.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnected()) {
        try {
            URL urlServer = new URL("your server url");
            HttpURLConnection urlConn = (HttpURLConnection) urlServer.openConnection();
            urlConn.setConnectTimeout(3000); //<- 3Seconds Timeout 
            urlConn.connect();
            if (urlConn.getResponseCode() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (MalformedURLException e1) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
    return false;
 */
public class HttpInet {
	public static boolean exists(String url) {
		try {
			// 리다이렉트: 추가적인 응답을 하지 않음.
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setConnectTimeout(1000);
			con.setReadTimeout(1000);
			con.setRequestMethod("HEAD");
			
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean reachable() {
		try {
			InetAddress.getByName("www.google.co.kr").isReachable(1000);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {
		if(exists("https://www.google.co.kr")) {
			System.out.println("ok");
		}
		
		if(reachable()) {
			System.out.println("reachable");
		}

	}

}
