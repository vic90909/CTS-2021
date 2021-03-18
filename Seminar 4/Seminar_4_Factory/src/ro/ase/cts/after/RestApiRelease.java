package ro.ase.cts.after;

public class RestApiRelease implements RestApi {
	
	public RestApiRelease() {
		System.out.println("Api Release");
	}
	
	@Override
	public void connect() {
		System.out.println("Connected succesfully! Release!");
	}
}
