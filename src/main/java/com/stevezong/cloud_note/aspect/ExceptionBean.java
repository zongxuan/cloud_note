package com.stevezong.cloud_note.aspect;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionBean {
	//e 就是目标组件抛出的异常对象
	@AfterThrowing(throwing="e",pointcut="within(com.stevezong.cloud_note.service..*)")
	public void serviceException(Exception e) {
		try {
			FileWriter fw = new FileWriter("d://zzz.txt",true);
			PrintWriter pw = new PrintWriter(fw,true);
			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sdf.format(time);
			pw.println("=====================================================");
			pw.println("异常类型："+e);
			pw.println("异常时间:"+timeStr);
			pw.println("********************异常详细信息*************************");
			e.printStackTrace(pw);
			pw.println("=====================================================");
			pw.close();
			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("记录异常失败");
		}
	}
}
