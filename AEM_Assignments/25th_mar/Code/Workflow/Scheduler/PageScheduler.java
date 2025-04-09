// PageScheduler.java - /apps/myproject/src/main/java/com/myproject/scheduler/PageScheduler.java
package com.myproject.scheduler;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = Runnable.class,
    immediate = true
)
@Designate(ocd = PageScheduler.Config.class)
public class PageScheduler implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(PageScheduler.class);
    private String schedulerExpression;

    @ObjectClassDefinition(name = "Yellow World Scheduler Configuration")
    public @interface Config {
        @AttributeDefinition(
            name = "Cron Expression",
            description = "Cron expression for scheduling (every 5 mins: 0 0/5 * * * ?)"
        )
        String scheduler_expression() default "0 0/5 * * * ?";
    }

    @Activate
    @Modified
    public void activate(Config config) {
        schedulerExpression = config.scheduler_expression();
        Scheduler scheduler = getScheduler();
        scheduler.addPeriodicJob(
            "yellow-world-job",
            this,
            null,
            schedulerExpression,
            true
        );
    }

    @Reference
    private Scheduler scheduler;

    private Scheduler getScheduler() {
        return scheduler;
    }

    @Override
    public void run() {
        LOG.info("Yellow World from Scheduler!");
    }
}