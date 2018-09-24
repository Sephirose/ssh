package cn.tedu.ems.service;

/**
 * 应用异常类
 *
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -3156715440774025777L;

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}

}
