package com.example.deliveryservice.queries;

import com.example.common.config.Constants;
import com.example.common.dto.DeliveryDTO;
import com.example.deliveryservice.entity.Delivery;
import com.example.deliveryservice.repository.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class DeliveryQueryHandler {

    private final DeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryQueryHandler(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @QueryHandler(queryName = Constants.QUERY_REPORT)
    private DeliveryDTO handle(String orderId) {
       log.info("[@QueryHandler] Handle <{}> for Order Id: {}", Constants.QUERY_REPORT,orderId);
        Optional<Delivery> optDelivery = deliveryRepository.findByOrderId(orderId);
        if(optDelivery.isPresent()) {
            Delivery delivery = optDelivery.get();
            DeliveryDTO deliveryDTO = new DeliveryDTO();
            BeanUtils.copyProperties(delivery, deliveryDTO);
            return deliveryDTO;
        } else {
            log.info("Can't find delivery info for Order Id:{}", orderId);
            return null;
        }

    }
}
