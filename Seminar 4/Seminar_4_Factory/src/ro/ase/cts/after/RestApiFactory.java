package ro.ase.cts.after;

public class RestApiFactory {
	
	public static final String DEVELOPMENT="Development";
	public static final String RELEASE="Release";

	public static RestApi createConnection(String serverType) {
		if(DEVELOPMENT.equals(serverType)){
			return new RestApiDevelopment();
		}else if(RELEASE.equals(serverType)){
			return new RestApiRelease();
		}
		return null;
	}
}
