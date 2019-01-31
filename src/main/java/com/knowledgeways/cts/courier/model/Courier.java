package com.knowledgeways.cts.courier.model;

public interface Courier {

    Integer courierId();

    String nameAr();

    String nameEn();

    String mobile();

    boolean isActive();

    void update(String nameAr, String nameEn, String mobile);

    void delete();

    void enabled();

    void disabled();

    Integer orgnaizationId();
}
