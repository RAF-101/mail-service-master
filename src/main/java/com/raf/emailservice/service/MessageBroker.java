package com.raf.emailservice.service;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.usage.SystemUsage;

public class MessageBroker {
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();

        broker.addConnector("tcp://localhost:61616");
        broker.setPersistent(false);
        SystemUsage systemUsage = broker.getSystemUsage();
        systemUsage.getStoreUsage().setLimit(1024 * 1024 * 8);
        systemUsage.getTempUsage().setLimit(1024 * 1024 * 8);
        broker.start();
    }
}
