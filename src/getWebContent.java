import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class getWebContent {

	/**
	 * @param args
	 */
	private static final String authtoken = "cb624b539cd1114901e5173d513a28a6584a0d3b";
//	private static final String url = "http://api.appannie.com/v1.1/apps/ios/app/294791909/details";
	private static final String url= "api.appannie.com/v1.1/apps/ios/app/12345678/ranks?" +
			"start_date=2012-01-01&end_date=2012-02-01" +
			"&interval=hourly" +
			"&countries=US+CN";
	
	public static void main(String[] args) {
		CloseableHttpResponse response;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Authorization", "Bearer "+authtoken);
		try {
			response = httpclient.execute(httpget);
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		        InputStream inputStream = entity.getContent();
		        // Convert response to string using String Builder
				 try {
					 BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
					 StringBuilder sBuilder = new StringBuilder();
					 String line = null;
					 while ((line = bReader.readLine()) != null) {
						 sBuilder.append(line + "\n");
					 }
					 inputStream.close();
					 String result = sBuilder.toString();
					 System.out.println(result);
				 } catch (Exception e) {					 
				 }				 
		    }
		} catch(ClientProtocolException e1){
			e1.printStackTrace();
		} catch(IOException e2){
			e2.printStackTrace();
		}
		

	}

}
