package ro.ase.cts.before;

import ro.ase.cts.after.RestApi;

public class RestApiDevelopment implements RestApi {
	
	public RestApiDevelopment() {
		System.out.println("Api Development");
	}
	
	@Override
	public void connect() {
		System.out.println("Connected succesfully! Development!");
	}
}
