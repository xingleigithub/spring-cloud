/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.xl.common.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author Chill
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	//@ApiModelProperty(value = "状态码", required = true)
	private int code;
	//@ApiModelProperty(value = "是否成功", required = true)
	private boolean success;
	//@ApiModelProperty(value = "承载数据")
	private T data;
	//@ApiModelProperty(value = "返回消息", required = true)
	private String msg;
	//@ApiModelProperty(value = "版本号", required = true)
	private String v;

	private R(IResultCode resultCode) {
		this(resultCode, null, resultCode.getMessage());
	}

	private R(IResultCode resultCode, String msg) {
		this(resultCode, null, msg);
	}

	private R(IResultCode resultCode, T data) {
		this(resultCode, data, resultCode.getMessage());
	}

	private R(IResultCode resultCode, T data, String msg) {
		this(resultCode.getCode(), data, msg);
	}

	private R(int code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.success = ResultCode.SUCCESS.code == code;
	}


	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data) {
		return data(data, XlConstant.DEFAULT_SUCCESS_MESSAGE);
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data, String msg) {
		return data(HttpServletResponse.SC_OK, data, msg);
	}

	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(int code, T data, String msg) {
		return new R<T>(code, data, data == null ? XlConstant.DEFAULT_NULL_MESSAGE : msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(String msg) {
		return new R<T>(ResultCode.SUCCESS, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode) {
		return new R<T>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode, String msg) {
		return new R<T>(resultCode, msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(String msg) {
		return new R<T>(ResultCode.FAILURE, msg);
	}


	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(int code, String msg) {
		return new R<T>(code, null, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode) {
		return new R<T>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode, String msg) {
		return new R<T>(resultCode, msg);
	}


}
