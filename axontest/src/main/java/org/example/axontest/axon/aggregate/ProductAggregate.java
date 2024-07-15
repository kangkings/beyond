package org.example.axontest.axon.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.spring.stereotype.Aggregate;

//이 클래스를 통해 발생하는 커맨드와 이벤트를 저장한다고 선언하는 어노테이션
@Slf4j
@Aggregate
public class ProductAggregate {
}
