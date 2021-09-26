/**
 * <p>Title: Status.java</p>
 * <p>Description: </p>
 *
 * @author zhouyao
 * @date 2021年6月25日
 * @version 1.0
 */
package com.atguigu.team.service;

/*
 *   封装员工的状态
 */
//public class Status {
//	private final String NAME;
//
//	private Status(String name) {
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status VOCATION = new Status("VOCATION");
//	public static final Status BUSY = new Status("BUSY");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//}

public enum Status {
    FREE, VOCATION, BUSY;
}













