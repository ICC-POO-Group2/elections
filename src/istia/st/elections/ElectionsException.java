package istia.st.elections;

public class ElectionsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ElectionsException(){
		super();
	}
	public ElectionsException(String message){
		super(message);
	}
	public ElectionsException(Throwable cause){
		super(cause);
	}
	public ElectionsException(String message, Throwable cause){
		super(message, cause);
	}
}
