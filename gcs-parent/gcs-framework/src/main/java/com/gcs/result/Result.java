package com.gcs.result;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * Result : 响应的结果对象
 *
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 6288374846131788743L;

    /**
     * 信息
     */
    private String message;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回数据
     */
    private Object data;
    
    

	public Result() {
		super();
	}
	
	

	public Result(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}


	public Result(String message, int code, Object data) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}


    
}
