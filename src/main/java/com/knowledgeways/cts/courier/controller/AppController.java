package com.knowledgeways.cts.courier.controller;

import com.knowledgeways.cts.courier.forms.CouriersForm;
import com.knowledgeways.cts.courier.model.Courier;
import com.knowledgeways.cts.courier.model.Couriers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/cts/couriers")
public class AppController {

    private final Couriers couriers;

    @Autowired
    public AppController(Couriers couriers) {

        this.couriers = couriers;
    }

    @GetMapping
    public List<Courier> couriers() {

        return this.couriers.courierList();
    }

    @GetMapping("/{courierId}")//TODO
    public Courier courier(@PathVariable Integer courierId) {

        return this.couriers.courier(courierId);
    }

    @PostMapping
    public void create(@RequestBody CouriersForm couriersForm) {

        String nameEn = couriersForm.getNameEn();
        String mobile = couriersForm.getMobile();
        String nameAr = couriersForm.getNameAr();
        this.couriers.create(nameAr, nameEn, mobile);
    }


    @PutMapping("/{courierId}")//TODO
    public void update(@PathVariable Integer courierId, @RequestBody CouriersForm couriersForm) {

        String nameAr = couriersForm.getNameAr();
        String nameEn = couriersForm.getNameEn();
        String mobile = couriersForm.getMobile();
        this.couriers.courier(courierId).update(nameAr, nameEn, mobile);
    }

    @PutMapping("/{courierId}/enable")
    public void enabled(@PathVariable Integer courierId){
       this.couriers.courier(courierId).enabled();
    }

    @PutMapping("/{courierId}/disable")
    public void disabled(@PathVariable Integer courierId){
        this.couriers.courier(courierId).disabled();
    }

    @DeleteMapping("/{courierId}")
    public void delete(@PathVariable Integer courierId) {
        this.couriers.courier(courierId).delete();
    }
}
