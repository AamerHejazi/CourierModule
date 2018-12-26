package com.knowledgeways.cts.courier.config;


import com.knowledgeways.cts.courier.dbImplementation.CouriersDB;
import com.knowledgeways.cts.courier.model.Couriers;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Bean
    public Couriers couriersdb(DSLContext jooq)  {
        return new CouriersDB(jooq);
    }


}
