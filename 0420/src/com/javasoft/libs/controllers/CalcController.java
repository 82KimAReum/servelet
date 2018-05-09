package com.javasoft.libs.controllers;

import com.javasoft.libs.models.VO;

public class CalcController {
	public static VO calc(String seatcode,String place,String ipin1,String ipin2,String persent) {
		String train=null;String seat=null;int km=0; int per=0;int discount;int fee;String gender=null;
		if(place.equals("CA")) {
			place="서울";  km=400;
		}else if(place.equals("CB")) {
			place="부산";  km=50;
		}else if(place.equals("CC")) {
			place="대구";  km=110;
		}else if(place.equals("CD")) {
			place="광주";  km=180;
		}
		if(seatcode.substring(0, 1).equals("TA")) {
			train="새마을호";
		}else if(seatcode.substring(0, 1).equals("TB")) {
			train="무궁화호";
		}else if(seatcode.substring(0, 1).equals("TC")) {
			train="통일호";
		}
		if(seatcode.substring(2).equals("SA")) {
			seat="특실";
			switch(train) {
			case "새마을호": km*=80; break;
			case "무궁화호": km*=60; break;
			case "통일호": break;		
			}
		}else if(seatcode.substring(2).equals("SB")) {
			seat="1등칸";
			switch(train) {
			case "새마을호": km*=65; break;
			case "무궁화호": km*=55; break;
			case "통일호":  break;		
			}
		}else if(seatcode.substring(2).equals("SC")) {
			seat="보통칸";
			switch(train) {
			case "새마을호": km*=50; break;
			case "무궁화호": km*=40; break;
			case "통일호": km*=30; break;		
			}
		}	
		if(persent.equals("P0")) {
			persent="일반"; per=0;
		}else if(persent.equals("P1")) {
			persent="소인";per=50;
		}else if(persent.equals("P2")) {
			persent="군인";per=30;
		}else if(persent.equals("P3")) {
			persent="장애인";per=80;
		}
		discount =km*per;
		fee=km-discount;
		if(ipin2.charAt(0)==1) {
			gender="남자";
		}if(ipin2.charAt(0)==2) {
			gender="여자";
		}
		
		VO vo=new VO( place, gender, train, seat, persent, discount, fee);
		return vo;
	}
}
