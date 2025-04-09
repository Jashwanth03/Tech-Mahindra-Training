// ApiConfigService.java - /apps/myproject/src/main/java/com/myproject/config/ApiConfigService.java
package com.myproject.config;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = ApiConfigService.class, immediate = true)
@Designate(ocd = ApiConfigService.Config.class)
public class ApiConfigService {
    private static final Logger LOG = LoggerFactory.getLogger(ApiConfigService.class);
    private String apiUrl;

    @ObjectClassDefinition(name = "API Configuration")
    public @interface Config {
        @AttributeDefinition(name = "3rd Party API URL", description = "URL of the 3rd party API")
        String apiUrl() default "https://jsonplaceholder.typicode.com/posts";
    }

    @Activate
    @Modified
    protected void activate(Config config) {
        apiUrl = config.apiUrl();
        fetchAndLogApiData();
    }

    private void fetchAndLogApiData() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonData = EntityUtils.toString(response.getEntity());
                LOG.info("API Data from {}: {}", apiUrl, jsonData);
            }
        } catch (Exception e) {
            LOG.error("Error fetching API data", e);
        }
    }
}