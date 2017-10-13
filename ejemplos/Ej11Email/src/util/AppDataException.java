package util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppDataException extends Exception{
	private Throwable innerException;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public AppDataException(Throwable e, String message){
		this.innerException=e;
		this.setMessage(message);
	}
	
	public AppDataException(Throwable e, String message, Level errorLevel){
		this(e,message);
		Logger logger = LogManager.getLogger(getClass());
		logger.log(errorLevel,message);
	}

}
