package com.sajib.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(String configFile) {




        if (sessionFactory == null) {
            configFile += ".cfg.xml";

            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure(configFile)
                    .build();
            MetadataSources metadataSources = new MetadataSources(standardRegistry);
            metadataSources.addPackage("com.sajib.hibernate.model");
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;

    }

}
