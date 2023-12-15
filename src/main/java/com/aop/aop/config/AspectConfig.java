package com.aop.aop.config;

import com.aop.aop.entity.AuditLog;
import com.aop.aop.entity.Employee;
import com.aop.aop.repository.AuditLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Aspect
@Configuration
public class AspectConfig {

    @Autowired
    private AuditLogRepository auditLogRepository;

    //Point cut expression: access modifier + return type + packageName.className.methodName(..)
    @AfterReturning("execution (public * com.aop.aop.serviceimpl.EmployeeServiceImpl.addEmployee(..))")
    public void logBeforeAddEmployee(JoinPoint joinPoint) {
        auditLogRepository.saveAndFlush(AuditLog.builder().createDate(new Date())
                .description("Details of employee added " + joinPoint.getArgs()[0]).build());
    }

    @AfterThrowing("execution (public * com.aop.aop.serviceimpl.EmployeeServiceImpl.updateEmployee(..))")
    public void errorWhileUpdatingEmployee(JoinPoint joinPoint) {
        Employee employee = (Employee) joinPoint.getArgs()[0];
        auditLogRepository.saveAndFlush(AuditLog.builder().createDate(new Date())
                .description("Error while updating entity: There is no employee with id " + employee.getId()).build());
    }
}
