package ro.ase.acs.adapter;

public class LowCostToFlightBookingAdapter extends FlightBooking {

	private LowCostFlightBooking lowCostFlightBooking;

	public LowCostToFlightBookingAdapter(LowCostFlightBooking lowCostFlightBooking) {
		this.lowCostFlightBooking = lowCostFlightBooking;
	}

	@Override
	public boolean addBooking(int row, char seat) {
		lowCostFlightBooking.reserveSeat();
		return true;
	}

	@Override
	public void displaySeats() {
		lowCostFlightBooking.seatMap();
	}
}
