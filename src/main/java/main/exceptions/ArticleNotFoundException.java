package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This tag does not exist")
public class ArticleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2075025531723284138L;

}
