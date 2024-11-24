package model.errors;

public class ErrorDetails extends RuntimeException {
	private String message;
	private String description;

	// Constructor
	public ErrorDetails(String message, String description) {
		super(message); // Truyền message cho RuntimeException
		this.message = message;
		this.description = description;
	}

	// Getter và Setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
