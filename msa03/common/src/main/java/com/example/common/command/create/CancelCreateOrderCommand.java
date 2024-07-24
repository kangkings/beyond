package com.example.common.command.create;

import com.example.common.dto.OrderStatusEnum;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
@Builder
public class CancelCreateOrderCommand {
    @TargetAggregateIdentifier
    String orderId;
    String orderStatus = OrderStatusEnum.FAILED.value();
}
