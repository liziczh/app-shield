package com.liziczh.archetype.admin.aop;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.liziczh.base.common.aop.BaseExceptionMailAop;

@Component
@Aspect
public class MgmExceptionMailAop extends BaseExceptionMailAop {
	@Override
	protected void sendErrorMessage(Exception exception, String className, String methodName, String methodParams, Date occurTime) {
	}
}
