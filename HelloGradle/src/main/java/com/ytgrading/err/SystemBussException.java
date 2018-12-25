package com.ytgrading.err;

/**
 * 系统业务异常 throw new SystemException("XXXX")
 * 
 * 
 * @date 2014-12-10
 * @Email：mmm333zzz520@163.com
 */
public class SystemBussException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

	public SystemBussException() {
		super();
	}

	public SystemBussException(String message) {
		super(message);
	}

	public SystemBussException(String code, String message) {
		super(message);
		this.code = code;
	}

	public SystemBussException(Throwable cause) {
		super(cause);
	}

	public SystemBussException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemBussException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
