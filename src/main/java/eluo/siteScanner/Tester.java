package eluo.siteScanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Tester {
	SiteHandler wench = new SiteHandler();
	
	public static void main(String[] args) {
		
		URLConnection request = null;
		String sURL = "https://pacaio.match.qq.com/irs/rcd?cid=4&token=9513f1a78a663e1d25b46a826f248c3c&ext=&page=0&expIds=&callback=__jp2"; //just a string

	    // Connect to the URL using java's native library
	    URL url = null;
		try {
			url = new URL(sURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    try {
	    	request = url.openConnection();
			request.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root=null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
        
       
	}
	
}
