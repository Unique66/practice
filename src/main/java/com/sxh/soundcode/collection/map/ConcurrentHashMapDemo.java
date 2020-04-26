package com.sxh.soundcode.collection.map;/**
 * Created by SXH on 2020/1/4 16:21.
 */

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SXH
 * @description 理解ConcurrentHashMap和HashMap源码
 * @date 2020/1/4 16:21.
 */
public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
		HashMap hashMap = new HashMap();
		concurrentHashMap.put("1","3");
	}
}
