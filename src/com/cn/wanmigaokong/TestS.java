package com.cn.wanmigaokong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class TestS {
	public static void main(String[] args) {
		// 获得同步锁的ArrayList,与ArrayList一样，LinkedList也是非同步的。如果多个线程同时访问一个List，则必须自己实现访问同步。一种解决方法是在创建List时构造一个同步的List：
		List list = Collections.synchronizedList(new ArrayList<>());
//Vector    与ArrayList相似，但是Vector是同步的。所以说Vector是线程安全的动态数组。它的操作与ArrayList几乎一样。
		Vector ve=new Vector();
		new Stack();
		System.out.println(System.getProperty("file.encoding"));
		
	}
}
