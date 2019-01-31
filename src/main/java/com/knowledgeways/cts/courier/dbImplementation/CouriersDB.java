package com.knowledgeways.cts.courier.dbImplementation;

import static com.knowledgeways.cts.courier.courier.tables.Couriers.COURIERS;

import com.knowledgeways.cts.courier.courier.tables.records.CouriersRecord;
import com.knowledgeways.cts.courier.model.Courier;
import com.knowledgeways.cts.courier.model.Couriers;
import org.jooq.Condition;
import org.jooq.DSLContext;

import java.util.List;
import java.util.stream.Collectors;


public class CouriersDB implements Couriers {

    private final DSLContext jooq;
    public CouriersDB(DSLContext jooq) {
        this.jooq = jooq;
    }

    @Override
    public Courier courier(Integer courierId) {

        final CouriersRecord rec;
        rec = this.jooq.selectFrom(COURIERS)
                .where(COURIERS.COURIER_ID.eq(courierId))
                .fetchOne();
        if (rec == null) {
            throw new NullPointerException("No id like what you have input");
        }
        return new CourierDB(rec.getCourierId(), jooq);
    }

    @Override
    public void create(String nameAr, String nameEn, String mobile, Integer organizationId) {

        if (nameAr == null || nameAr.equals("")) {
            throw new NullPointerException("Arabic name field is empty");
        }
        if (mobile == null || mobile.equals("")) {
            throw new NullPointerException("mobile number field is empty");
        }
        if (nameEn == null || nameEn.equals("")) {
            throw new NullPointerException("English name field is empty");
        }
        if (organizationId == null) {
            throw new NullPointerException("organizationId field is empty");
        }
        this.jooq.insertInto(COURIERS)
                .columns(COURIERS.NAME_AR, COURIERS.NAME_EN, COURIERS.MOBILE, COURIERS.ORGANIZATION_ID)
                .values(nameAr, nameEn, mobile, organizationId)
                .execute();
    }

    @Override
    public List<Courier> courierList(Integer organizationId) {
         Condition condition = COURIERS.ORGANIZATION_ID.eq(organizationId);
        if(organizationId == null) {
            condition = COURIERS.COURIER_ID.isNotNull();
        }
        return this.jooq.select(COURIERS.COURIER_ID)
                .from(COURIERS)
                .where(condition)
                .fetch(COURIERS.COURIER_ID)
                .stream()
                .map(courierId -> new CourierDB(courierId, jooq))
                .collect(Collectors.toList());
    }
}
