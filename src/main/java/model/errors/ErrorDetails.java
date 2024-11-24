package model.errors;

import lombok.*;

@AllArgsConstructor
public class ErrorDetails extends RuntimeException {
    String message;
    String description;
    
    
	public ErrorDetails(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}
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
