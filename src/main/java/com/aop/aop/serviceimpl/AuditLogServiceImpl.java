package com.aop.aop.serviceimpl;

import com.aop.aop.entity.AuditLog;
import com.aop.aop.repository.AuditLogRepository;
import com.aop.aop.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public List<AuditLog> getAuditLogs() {
        return auditLogRepository.findAll();
    }
}
