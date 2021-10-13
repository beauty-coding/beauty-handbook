package com.beauty.wechat.utils;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ֤tokenϢĹ
 */
public class CheckSignatureUtil {
	public static final String token = "yufw";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		ArrayList<String> list = new ArrayList<String>();
		list.add(token);
		list.add(timestamp);
		list.add(nonce);
		Collections.sort(list);
		StringBuilder content = new StringBuilder();
		for(String str:list){
			content.append(str);
		}
		return signature.equals(HashUtil.hash(content.toString(),"SHA1"));
	}
}
