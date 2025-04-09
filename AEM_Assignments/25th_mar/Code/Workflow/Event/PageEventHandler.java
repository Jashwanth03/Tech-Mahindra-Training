// PageEventHandler.java - /apps/myproject/src/main/java/com/myproject/event/PageEventHandler.java
package com.myproject.event;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = EventHandler.class,
    property = {
        "event.topics=org/apache/sling/api/resource/Resource/*"
    }
)
public class PageEventHandler implements EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(PageEventHandler.class);

    @Override
    public void handleEvent(Event event) {
        String path = (String) event.getProperty("path");
        LOG.info("Resource event occurred at path: {}", path);
    }
}