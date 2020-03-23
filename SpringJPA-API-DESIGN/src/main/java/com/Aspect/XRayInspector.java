package com.Aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

import com.amazonaws.xray.entities.Subsegment;
import com.amazonaws.xray.spring.aop.AbstractXRayInterceptor;

public class XRayInspector extends AbstractXRayInterceptor {

	@Override    
    protected Map<String, Map<String, Object>> generateMetadata(ProceedingJoinPoint proceedingJoinPoint, Subsegment subsegment)  {      
        return super.generateMetadata(proceedingJoinPoint, subsegment);    
    }    
  
  @Override    
  @Pointcut("@within(com.amazonaws.xray.spring.aop.XRayEnabled) && bean(*Controller)")    
  public void xrayEnabledClasses() {}

}
