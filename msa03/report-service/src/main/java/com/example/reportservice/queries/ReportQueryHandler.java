package com.example.reportservice.queries;

import com.example.common.config.Constants;
import com.example.common.dto.ReportDTO;
import com.example.common.queries.GetReportId;
import com.example.reportservice.entity.Report;
import com.example.reportservice.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ReportQueryHandler {

    private final ReportRepository reportRepository;
    @Autowired
    public ReportQueryHandler(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @QueryHandler
    private String handle(GetReportId qry) {
        log.info("[@QueryHandler] Handle <GetReportId> for Order Id: {}", qry.getOrderId());
        Optional<Report> optReport = reportRepository.findByOrderId(qry.getOrderId());
        if(optReport.isPresent()) {
            return optReport.get().getReportId();
        } else {
            return "";
        }
    }

    @QueryHandler(queryName = Constants.QUERY_REPORT)
    private ReportDTO handle(String orderId) {
        log.info("[@QueryHandler] Handle <{}}> for Order Id: {}", Constants.QUERY_REPORT, orderId);
        Optional<Report> optReport = reportRepository.findByOrderId(orderId);
        if(optReport.isPresent()) {
            ReportDTO report = new ReportDTO();
            BeanUtils.copyProperties(optReport.get(), report);
            return report;
        } else {
            return null;
        }
    }
}
