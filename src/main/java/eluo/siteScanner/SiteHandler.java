package eluo.siteScanner;

import java.io.OutputStream;
import java.util.HashMap;

public class SiteHandler {

	OutputStream stream;
	Object jsonObj;
	
	public OutputStream getContent(HashMap<String, String> params) {
		
		return convert(page(params.get("site")));
	}
	
	private OutputStream convert(Object jsonObject) {
		return stream;
	}
	
	private Object page(String site) {
		
		return jsonObj;
	}
	
}
