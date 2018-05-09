package com.javasoft.libs.controllers;

import com.javasoft.libs.models.StudentVO;

public class CalcController {
	public static void calc(StudentVO s) {
		int tot = s.getKor() + s.getEng() + s.getMat() + s.getEdp();
		double avg = tot / 4.;
		char grade = (avg <= 100 && avg >= 90) ? 'A' :
			                     	(avg < 90 && avg >= 80) ? 'B' :
			                     		(avg < 80 && avg >= 70) ? 'C' :
			                     			(avg < 70 && avg >= 60) ? 'D' : 'F';
		s.setTot(tot);   s.setAvg(avg);  s.setGrade(grade);
	}
}
