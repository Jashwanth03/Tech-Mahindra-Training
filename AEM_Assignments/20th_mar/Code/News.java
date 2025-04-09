
package com.myproject.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class News {
    @Inject
    private String newsTitle;

    @Inject
    private String newsDetail;

    @Inject
    private String publishedDate;

    @Inject
    private String source;

    // Getters
    public String getNewsTitle() { return newsTitle; }
    public String getNewsDetail() { return newsDetail; }
    public String getPublishedDate() { return publishedDate; }
    public String getSource() { return source; }
}

// news.html - /apps/myproject/components/news/news.html
<div class="cop-news-component">
    <h2>${properties.newsTitle}</h2>
    <p>${properties.newsDetail}</p>
    <div>Published: ${properties.publishedDate}</div>
    <div>Source: ${properties.source}</div>
</div>