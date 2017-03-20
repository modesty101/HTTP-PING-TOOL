package aliveHTTP;

public class HttpRuntime {
	public static boolean httpRuntime() throws Exception {
		Runtime time = Runtime.getRuntime();
		Process proc = time.exec("ping -c 1 www.google.co.kr");
		int mPingResult = proc.waitFor();
		if(mPingResult==0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main() throws Exception {
		if(httpRuntime()) {
			System.out.println("ok");
		}
	}
}
