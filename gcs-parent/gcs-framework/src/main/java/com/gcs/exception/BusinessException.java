package com.gcs.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7815426752583648734L;
	private int errorCode;
	private String errorMsg;
	
	public BusinessException(int resultCodes,String errorMsg) {
		super();
		setErrorCode(resultCodes);
		setErrorMsg(errorMsg);
	}
	
	public BusinessException(Throwable e) {
		super(e);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


}
