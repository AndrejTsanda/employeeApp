package com.tsanda.employeeApp.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryManager {

    private static final Logger log = Logger.getLogger(QueryManager.class);

    @Autowired
    private AbstractBeanFactory abstractBeanFactory;

    public String getQuery(final String key) {

        try {
            final String sql = abstractBeanFactory.resolveEmbeddedValue("${" + key + "}");
            log.debug("Key = [" + key + "] has been loaded from Spring Properties.");
            return sql;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
