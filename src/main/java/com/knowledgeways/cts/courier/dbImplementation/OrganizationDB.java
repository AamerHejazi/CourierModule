package com.knowledgeways.cts.courier.dbImplementation;
import static com.knowledgeways.cts.courier.courier.tables.Organizations.ORGANIZATIONS;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.knowledgeways.cts.courier.model.Organization;
import org.jooq.DSLContext;

public class OrganizationDB implements Organization {

    private final DSLContext jooq;
    private final Integer organizationId;
    public OrganizationDB(Integer organizationId,DSLContext jooq) {
        this.jooq = jooq;
        this.organizationId = organizationId;
    }

    @JsonGetter
    @Override
    public Integer organizationId() {
        return organizationId;
    }

    @JsonGetter
    @Override
    public String nameAr() {
        return this.jooq.select(ORGANIZATIONS.NAME_AR)
                .from(ORGANIZATIONS)
                .where(ORGANIZATIONS.ORGANIZATION_ID.eq(organizationId()))
                .fetchOne(ORGANIZATIONS.NAME_AR);
    }
}
