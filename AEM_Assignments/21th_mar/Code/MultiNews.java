package com.myproject.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.List;

@Model(adaptables = Resource.class)
public class MultiNews {
    @ChildResource
    private List<NewsItem> newsItems;

    public List<NewsItem> getNewsItems() { return newsItems; }
}

@Model(adaptables = Resource.class)
public class NewsItem {
    @Inject
    private String newsTitle;

    @Inject
    private String newsSource;

    public String getNewsTitle() { return newsTitle; }
    public String getNewsSource() { return newsSource; }
}

// multinews.html - /apps/myproject/components/multinews/multinews.html
<div data-sly-use.model="com.myproject.models.MultiNews">
    <div data-sly-list.item="${model.newsItems}">
        <h2>${item.newsTitle}</h2>
        <div>Source: ${item.newsSource}</div>
    </div>
</div>