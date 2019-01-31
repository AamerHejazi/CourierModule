package com.knowledgeways.cts.courier.model;


import java.util.List;

public interface Couriers {

    Courier courier(Integer courierId);

    void create(String nameAr, String nameEn, String mobile, Integer OrganizationId);

    List<Courier> courierList(Integer organizationId);

}
