package blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	 String fieldName;
	 String fieldValue;
	 String message;
	 
	 public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
		this.message = resourceName + " not found for " + fieldName + " : " + fieldValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
	 
}
