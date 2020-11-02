package packag;

public class InvalidPositionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; //attribute (house keeping).

	/**
	 * Creates an instance of the exception and assigns it a custom message.
	 * 
	 * 
	 */
	public InvalidPositionException(String message){
		
		
		super(message);
	}

}
