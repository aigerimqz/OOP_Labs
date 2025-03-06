import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener{
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal){
		logininfo = loginInfoOriginal;
		
	}

}
