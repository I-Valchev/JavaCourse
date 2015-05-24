
public class ServiceNotAvailableAtTheMoment extends Exception{
	private static String reasons = "Reason1\nReason2\nReason3";
	public ServiceNotAvailableAtTheMoment() {super("Service failed! Possible reasons might be: " + reasons);}
}
