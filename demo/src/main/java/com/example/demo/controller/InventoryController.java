package com.example.demo.controller;

import com.example.demo.domain.InventoryPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController

public class InventoryController {

    public static void main(String[] args) {


        SpringApplication.run(InventoryController.class, args);

    }
    @GetMapping("/getInvPicture")
    public Double getInv(@RequestParam(value = "prodID") String prodID, @RequestParam(value = "prodName")String prodName, @RequestParam(value = "reqDate") Date reqDate){
        Date myDate1 = new Date(2021, 03, 20);
        InventoryPOJO inv1 = new InventoryPOJO("Prod1","Shirt","EACH", 10.0, myDate1);

        Date myDate2 = new Date(2021, 03, 21);
        InventoryPOJO inv2 = new InventoryPOJO("Prod1","Shirt","EACH", 20.0, myDate1);

        Date myDate3 = new Date(2021, 03, 28);
        InventoryPOJO inv3 = new InventoryPOJO("Prod1","Shirt","EACH", 20.0, myDate1);

        List <InventoryPOJO> invList = new ArrayList<>()  ;
        invList.add(inv1);
        invList.add(inv2);
        invList.add(inv3);

        Stream<InventoryPOJO> inventoryPOJOStream = invList.stream().filter(p -> p.getAvailDate().compareTo(reqDate) > 10);
Double res = inventoryPOJOStream.mapToDouble(InventoryPOJO::getAvailQty).reduce(0,(val1,val2)->(val1 + val2));
        return res;
    }

}

