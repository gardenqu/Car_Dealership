package com.example.project.Dealership.Controller;

import com.example.project.Dealership.Entity.Vehicle;
import com.example.project.Dealership.Repository.VehicleRepo;
import com.example.project.Dealership.ServiceLayer.InventorySL;
import com.example.project.Dealership.Util.Constants;
import com.example.project.Dealership.Util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    InventorySL inventorySL;

    @Autowired
    VehicleRepo vr;

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("err")
        public List<Vehicle> getV(){

        return vr.findAll();
        }

    @GetMapping("all")
    public List<Vehicle> getListOfVehicles(
            @RequestParam(defaultValue = Pages.DEFAULTPAGENUMBER) int page,
            @RequestParam(defaultValue = Pages.DEFAULTPAGESIZE) int size,
            @RequestParam(defaultValue = Pages.ASC) String order,
            @RequestParam(defaultValue = Pages.SORTBYSALEPRICE) String sortBy

    ){

        return inventorySL.getAllVehicles(page,size,order,sortBy).toList();
    }


    @GetMapping("new")
    public List<Vehicle> getNewVehicles(
            @RequestParam(defaultValue = Pages.DEFAULTPAGENUMBER) int page,
            @RequestParam(defaultValue = Pages.DEFAULTPAGESIZE) int size,
            @RequestParam(defaultValue = Pages.ASC) String order,
            @RequestParam(defaultValue = Pages.SORTBYSALEPRICE) String sortBy,
            @RequestParam(defaultValue = Constants.NEW) String isNew

    )  {



        return inventorySL.GetSearchedVehicles(page,size,order,sortBy,isNew).toList();
    }

}
