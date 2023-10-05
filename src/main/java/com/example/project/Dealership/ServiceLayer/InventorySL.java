package com.example.project.Dealership.ServiceLayer;

import com.example.project.Dealership.Entity.Vehicle;
import com.example.project.Dealership.Repository.VehicleRepo;
import com.example.project.Dealership.Util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventorySL {

    @Autowired
    VehicleRepo vehicleRepo;

    public Page<Vehicle> getAllVehicles(int pageNum, int size, String order, String sortBy){

        Pageable paging=null;

        if(order.equals(Pages.ASC)){
            paging= PageRequest.of(pageNum, size, Sort.by(sortBy).ascending());

        }else{
            paging= PageRequest.of(pageNum, size,Sort.by(sortBy).descending());

        }

        return vehicleRepo.findAll(paging);
    }

    public Page<Vehicle>GetSearchedVehicles(int pageNum,int size,String order,String sortBy,String isNew){

        Pageable paging=getSortOrder(pageNum,size,order,sortBy);

        List<Vehicle> vehicleList= vehicleRepo.findAll(paging).stream().filter(p ->
                p.isNew()==Boolean.getBoolean(isNew)).toList();

        Page<Vehicle> page = new PageImpl<>(vehicleList);

        return page;
    }

    private Pageable getSortOrder(int pageNum,int size,String order,String sortBy){
        Pageable paging=null;

        if(order.equals(Pages.ASC)){
            paging= PageRequest.of(pageNum, size, Sort.by(sortBy).ascending());

        }else{
            paging= PageRequest.of(pageNum, size,Sort.by(sortBy).descending());

        }
        return paging;
    }
}
