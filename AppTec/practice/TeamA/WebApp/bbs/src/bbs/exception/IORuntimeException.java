package bbs.exception;

import java.io.IOException;

public class IORuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IORuntimeException(IOException cause) {
		super(cause);
	}

}
