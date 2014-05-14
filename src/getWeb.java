import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class getWeb {

	/**
	 * @param args
	 */
	private static final String url = "http://www.appannie.com/apps/ios/top/united-states/games/action/?device=iphone&date=2014-05-08";
	private static final String url_alt = "http://www.mkyong.com";
	
	public static void main(String[] args) {
		try{
			URL appannie = new URL(url);
	        URLConnection page = appannie.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                 page.getInputStream(), "UTF-8"));
	        String inputLine;
	        StringBuilder a = new StringBuilder();
	        while ((inputLine = in.readLine()) != null)
	        	a.append(inputLine);
	        in.close();

	        System.out.println(a.toString());
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
