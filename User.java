mport java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    String username;
    String password;
    int authorization;
   public User(String usn,String pwd, int auth){
    	username = usn;
       	authorization = auth;
       	password = hash(pwd);
	}
 	   
public String hash(String plaintext)
{
	MessageDigest m;
	try {
		m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		return hashtext;
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "error";
}

public String getusn()
{
	return username;
}
public String getpwd()
{
	return password;
}

public int getauth()
{
	return authorization;
}
public void modify(int a, String y)
{
	switch(a)
	{
	case 1: username = y;
	break;
	case 2: password = hash(y);
	break;
	case 3: authorization = Integer.parseInt(y);
	break;
	}
}

}
