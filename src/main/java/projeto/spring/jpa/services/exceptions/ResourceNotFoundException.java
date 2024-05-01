package projeto.spring.jpa.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException (Long id) {
		super("Resource Not Found. Id: " + id);
	}
	
	public ResourceNotFoundException (Long id, String msg) {
		super(String.format("Resource Not Found%s. Id: " + id, msg));
	}


}
