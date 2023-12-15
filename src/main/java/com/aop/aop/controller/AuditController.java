package com.aop.aop.controller;

import com.aop.aop.entity.AuditLog;
import com.aop.aop.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/logs")
    public List<AuditLog> getRecords() {
        return auditLogService.getAuditLogs();
    }

}
