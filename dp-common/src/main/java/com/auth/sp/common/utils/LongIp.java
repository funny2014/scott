package com.auth.sp.common.utils;

import java.math.BigInteger;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 作者： Mr.薛
 * 时间： 2018年5月29日下午1:06:20
 * 内容： ip读取识别
 * 状态： 编写/修改
 */
public class LongIp {

	public static void main(String[] args) throws UnknownHostException {
		String ip = "58.250.18.34";
//		String ip = "2605:f700:42:1c00::dac9:a712";
		System.out.println("   ip:"+ip+"   转化后："+new LongIp().Dot2LongIP(ip));
		
	}
	
	
	
	public String Dot2LongIP(String ip) throws UnknownHostException{
		InetAddress ia = InetAddress.getByName(ip);
		byte byteArr[] = ia.getAddress();
		if (ia instanceof Inet6Address) {//IP V6
			BigInteger ipnumber = new BigInteger(1, byteArr);
			return ipnumber.toString();
		}else{// IP V4
			String[] ipAddressInArray = ip.split("\\.");
			long result = 0;
			long ip1 = 0;
			for (int x = 3; x >= 0; x--) {
				ip1 = Long.parseLong(ipAddressInArray[3 - x]);
				result |= ip1 << (x << 3);
			}
			return String.valueOf(result);
		}
	}
	
}

