// HelloWorldService.java - /apps/myproject/src/main/java/com/myproject/service/HelloWorldService.java
package com.myproject.service;

import org.osgi.service.component.annotations.Component;

@Component(service = HelloWorldService.class)
public class HelloWorldService {
    public String getHelloWorld() {
        return "Hello World from Service!";
    }
}

// Update News.java - /apps/myproject/models/News.java
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class News {
    private static final Logger LOG = LoggerFactory.getLogger(News.class);

    @Inject
    private String newsTitle;

    @Inject
    private String newsDetail;

    @Inject
    private String publishedDate;

    @Inject
    private String source;

    @Reference
    private HelloWorldService helloWorldService;

    @PostConstruct
    protected void init() {
        String message = helloWorldService.getHelloWorld();
        LOG.info("Service message in News component: {}", message);
    }

    // Existing getters...
}