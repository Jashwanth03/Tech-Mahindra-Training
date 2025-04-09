// HelloWorldJob.java - /apps/myproject/src/main/java/com/myproject/job/HelloWorldJob.java
package com.myproject.job;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = JobConsumer.class,
    property = {
        JobConsumer.PROPERTY_TOPICS + "=myproject/helloworld/job"
    }
)
public class HelloWorldJob implements JobConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public JobResult process(Job job) {
        LOG.info("Hello World from Sling Job!");
        return JobResult.OK;
    }
}

// Trigger Job
@Component
public class JobTrigger {
    @Reference
    private JobManager jobManager;

    @Activate
    public void activate() {
        Map<String, Object> jobProperties = new HashMap<>();
        jobManager.addJob("myproject/helloworld/job", jobProperties);
    }
}