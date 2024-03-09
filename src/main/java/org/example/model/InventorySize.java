package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class InventorySize {

    @Field("w")
    private Integer width;

    @Field("h")
    private Integer height;
}