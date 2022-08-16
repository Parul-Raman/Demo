package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InventoryPOJO {

    String productID;
    String prodName;
    String UOM;
    Double availQty;
    Date availDate;
}
