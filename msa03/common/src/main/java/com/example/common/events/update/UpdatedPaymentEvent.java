package com.example.common.events.update;

import com.example.common.dto.PaymentDetailDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdatedPaymentEvent {
    private String paymentId;

    private String orderId;
    private int totalPaymentAmt;
    private String paymentStatus;
    private List<PaymentDetailDTO> paymentDetails;
    private boolean isCompensation;
}
