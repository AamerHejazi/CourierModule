package com.knowledgeways.cts.courier.dbImplementation;

import com.knowledgeways.cts.courier.model.Organization;
import com.knowledgeways.cts.courier.model.Organizations;
import org.jooq.DSLContext;

import java.util.List;
import java.util.stream.Collectors;

import static com.knowledgeways.cts.courier.courier.tables.Organizations.ORGANIZATIONS;

public class OrganizationsDB implements Organizations {

    private final DSLContext jooq;

    public OrganizationsDB(DSLContext jooq) {
        this.jooq = jooq;
    }

    @Override
    public List<Organization> list() {
        return this.jooq.select(ORGANIZATIONS.ORGANIZATION_ID)
                .from(ORGANIZATIONS)
                .fetch(ORGANIZATIONS.ORGANIZATION_ID)
                .stream()
                .map(organizationId -> new OrganizationDB(organizationId, jooq))
                .collect(Collectors.toList());
    }
}
