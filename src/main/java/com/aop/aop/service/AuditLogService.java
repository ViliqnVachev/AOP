package com.aop.aop.service;

import com.aop.aop.entity.AuditLog;

import java.util.List;

public interface AuditLogService {
    List<AuditLog> getAuditLogs();
}
