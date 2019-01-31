package com.knowledgeways.cts.courier.dbImplementation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.knowledgeways.cts.courier.model.Courier;
import org.jooq.DSLContext;

import static com.knowledgeways.cts.courier.courier.tables.Couriers.COURIERS;

public class CourierDB implements Courier {

    private final Integer courierId;
    private final DSLContext jooq;

    public CourierDB(Integer courierId, DSLContext jooq) {
        this.courierId = courierId;
        this.jooq = jooq;
    }

    @JsonGetter
    @Override
    public Integer courierId() {
        return this.courierId;
    }

    @JsonGetter
    @Override
    public String nameAr() {
        return this.jooq.select(COURIERS.NAME_AR)
                .from(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .fetchOne(COURIERS.NAME_AR);
    }

    @JsonGetter
    @Override
    public String nameEn() {
        return this.jooq.select(COURIERS.NAME_EN)
                .from(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .fetchOne(COURIERS.NAME_EN);
    }

    @JsonGetter
    @Override
    public String mobile() {
        return this.jooq.select(COURIERS.MOBILE)
                .from(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .fetchOne(COURIERS.MOBILE);
    }

    @JsonGetter
    @Override
    public boolean isActive() {
        return this.jooq.select(COURIERS.ACTIVE)
                .from(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .fetchOne(COURIERS.ACTIVE);
    }

    @Override
    public void update(String nameAr, String nameEn, String mobile) {

        if (nameAr == null || nameAr.equals("")) {
            throw new NullPointerException("Arabic name field is empty");
        }

        if (nameEn == null || nameEn.equals("")) {
            throw new NullPointerException("English name field is empty");
        }

        if (mobile == null || mobile.equals("")) {
            throw new NullPointerException("mobile number field is empty");
        }

        this.jooq.update(COURIERS)
                .set(COURIERS.NAME_AR, nameAr)
                .set(COURIERS.NAME_EN, nameEn)
                .set(COURIERS.MOBILE, mobile)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .execute();
    }

    @Override
    public void delete() {
        this.jooq.delete(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .execute();
    }

    @Override
    public void enabled() {
        this.jooq.update(COURIERS)
                .set(COURIERS.ACTIVE, true)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .execute();
    }

    @Override
    public void disabled() {
        this.jooq.update(COURIERS)
                .set(COURIERS.ACTIVE, false)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .execute();
    }

    @JsonGetter
    @Override
    public Integer orgnaizationId() {
        return this.jooq.select(COURIERS.ORGANIZATION_ID)
                .from(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId()))
                .fetchOne(COURIERS.ORGANIZATION_ID);
    }
}
