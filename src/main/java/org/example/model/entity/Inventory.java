package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.example.model.InventorySize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


/*
{
    "_id" : ObjectId("65e1972386f0ed5851d36b37"),
    "status" : "A",
    "qty" : 40,
    "size" : {
        "w" : 20,
        "h" : 14
    },
    "item" : [
        "A",
        "D",
        "E"
    ]
}
 */
@Document(collection = "inventory")
@Getter
@Setter
public class Inventory {

    @Id
    private ObjectId id;

    @Field("status")
    private String status;

    @Field("qty")
    private Integer quantity;

    @Field("size")
    private InventorySize size;

    @Field("item")
    private List<String> itemList;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}