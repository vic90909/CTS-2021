import ro.ase.cts.after.RestApi;
import ro.ase.cts.after.RestApiDevelopment;
import ro.ase.cts.after.RestApiFactory;

public class NewMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestApi api=RestApiFactory.createConnection("Development");
		api.connect();
	}

}
