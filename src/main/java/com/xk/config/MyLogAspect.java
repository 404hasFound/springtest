package com.xk.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAspect {
	
	private  static  final Logger logger = Logger.getLogger(MyLogAspect.class);
	final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	 @Pointcut("execution (* com.xk.service..*.*(..))")  
	 public  void serviceAspect() {  
	 }  
	 
	 @Pointcut("execution (* com.xk.controller..*.*(..))")
	 private void controllerAspect() {}
	 
	 @Around("serviceAspect() || controllerAspect()")
	 public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		 Object[] paramValues = jp.getArgs();
		 String args = "";
		 Object re= null;
		 String cudate = sdf.format(new Date());
		 for(Object st:paramValues){
			 args += st==null?"null,":st.toString()+",";
		 }
		 try {
			 re = jp.proceed();
			 String res = "";
			 try{res=re.toString();}catch(Exception e){res="Object转换出错";}
			 logger.info("---"+cudate+"----------------------------------------------------------------------------------");
			 logger.info("| 方法：" + jp.getStaticPart().getSignature());
			 logger.info("| 参数："+args);
			 logger.info("| 返回："+res+"%n");
			 			
		}  catch (Throwable e) {
			StackTraceElement ste1=null;
			for(StackTraceElement ste:e.getStackTrace()){
				if(ste.getClassName().contains("com.xk")){
					ste1 = ste;
					break;
				}
			}
			logger.info("---"+cudate+"-----------------------------------------------------------------------------------");
			logger.info("| 错误："+e+" java文件："+ste1.getFileName()+" 行数："+ste1.getLineNumber());
			logger.info("| 方法：" + jp.getStaticPart().getSignature());
			logger.info("| 参数： "+args+"%n");
			throw e;
		}
		 return re;
	}    
	 

}
