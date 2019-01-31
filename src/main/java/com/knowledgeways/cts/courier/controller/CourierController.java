package com.knowledgeways.cts.courier.controller;

import com.knowledgeways.cts.courier.forms.CouriersForm;
import com.knowledgeways.cts.courier.model.Courier;
import com.knowledgeways.cts.courier.model.Couriers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/cts/couriers")
public class CourierController {

    private final Couriers couriers;

    @Autowired
    public CourierController(Couriers couriers) {

        this.couriers = couriers;
    }

    @GetMapping("/organization")
    public List<Courier> OrganizationCouriers(@RequestParam Integer organizationId) {
        return this.couriers.courierList(organizationId);
    }

    @GetMapping
    public List<Courier> AllCouriers() {
        return this.couriers.courierList(null);
    }

    @GetMapping("/{courierId}/courier")//TODO
    public Courier courier(@PathVariable Integer courierId) {

        return this.couriers.courier(courierId);
    }

    @PostMapping
    public void create(@RequestBody CouriersForm couriersForm) {

        String nameEn = couriersForm.getNameEn();
        String mobile = couriersForm.getMobile();
        String nameAr = couriersForm.getNameAr();
        Integer organizationId = couriersForm.getOrganizationId();
        this.couriers.create(nameAr, nameEn, mobile, organizationId);
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
