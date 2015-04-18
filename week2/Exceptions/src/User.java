
public class User {
	String username;
	
	public User(String username) throws DatabaseCorruptedException{
		if(username == null || username.isEmpty()){
			throw new DatabaseCorruptedException("Username uninitialized!");
		}
	}
	
	/*public static void main(String [] args){
		try {
			User s = new User("");
		} catch (DatabaseCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
