package com.example.common.command.update;

import com.example.common.dto.PaymentDetailDTO;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Value
@Builder
public class UpdatePaymentCommand {
    @TargetAggregateIdentifier
    String paymentId;

    String orderId;
    int totalPaymentAmt;
    String paymentStatus;
    List<PaymentDetailDTO> paymentDetails;
    boolean isCompensation;
}
