import java.util.HashMap;

public class IDandPasswords {
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	IDandPasswords() {
		logininfo.put("Bro", "pizza");
		logininfo.put("Brometheus", "PASSWORD");
		logininfo.put("BroCode", "abc123");
		logininfo.put("aigerim", "123");
	}
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
