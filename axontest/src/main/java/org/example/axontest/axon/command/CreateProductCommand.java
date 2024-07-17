package org.example.axontest.axon.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    private String name;
    private Integer price;
    private Integer amount;
}
