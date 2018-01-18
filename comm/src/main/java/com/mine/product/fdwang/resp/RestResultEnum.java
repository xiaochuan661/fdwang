package com.mine.product.fdwang.resp;

/**
 * 自定义异常枚举类 Created by fengqiang on 2016/11/16.
 */
public enum RestResultEnum {
	SUCCESS(200, "操作成功"),
	ERROR(500, "操作错误");


	private int key;
	private String message;

	RestResultEnum(int key, String message) {
		this.key = key;
		this.message = message;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
