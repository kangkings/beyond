package com.example.common.command.create;

import com.example.common.dto.PaymentStatusEnum;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
@Builder
public class CancelCreatePaymentCommand {
    @TargetAggregateIdentifier
    String paymentId;
    String orderId;
    String paymentStatus = PaymentStatusEnum.CANCELED.value();
}
