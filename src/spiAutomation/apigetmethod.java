package spiAutomation;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class apigetmethod {

	public static void main(String[] args) throws Exception, Exception {
		
		String uri = "https://reqres.in//api/users?page=2";
		
		Get(uri);

	}
	
	
	//Get method
	
	public static void Get(String url) throws Exception, IOException
	{
		CloseableHttpClient httpclient= HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //get request
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);// hit the url
		int getstatuscode = closablehttpresponse.getStatusLine().getStatusCode();// get status code
		System.out.println(getstatuscode);
		
		String responsestring = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8"); //utf-8 corrects the special 
																		//characters and returns pure string
		
		System.out.println(responsestring);
		Header[] hedderarray = closablehttpresponse.getAllHeaders();
	
		
		JSONObject respoonsejasonobject= new JSONObject(responsestring);
		System.out.println(respoonsejasonobject);
		
		HashMap allheaders=new HashMap<String,String>();
		for(Header header:hedderarray)
		{
			allheaders.put(header.getName(), header.getValue());
		}
		
		System.out.println(allheaders);
		
	}

}
