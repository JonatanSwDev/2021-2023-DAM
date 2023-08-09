
public class CommonVar {
	 //private final static String database = "jdbc:mysql://172.20.254.161/aad_06?useSSL=false"; //Clase
	 //private final static String database = "jdbc:mysql://iescierva.net:9305/aad_06?useSSL=false"; //Casa
	 private final static String database = "jdbc:mysql://localhost:3306/aad_06"; //Local
	 private final static String user = "aad_06";
	 private final static String password = "aad_06";
	 
	 protected static String getDatabase() {
	        return database;
	    }
	    protected static String getUser() {
	        return user;
	    }
	    protected static String getPassword() {
	        return password;
	    }
}
