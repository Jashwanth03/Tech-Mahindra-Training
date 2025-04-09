// PrintPageTitleProcess.java - /apps/myproject/src/main/java/com/myproject/workflow/PrintPageTitleProcess.java
package com.myproject.workflow;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component(
    service = WorkflowProcess.class,
    property = {
        "process.label=Print Page Title Process"
    }
)
public class PrintPageTitleProcess implements WorkflowProcess {
    private static final Logger LOG = LoggerFactory.getLogger(PrintPageTitleProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) 
            throws WorkflowException {
        String payloadPath = workItem.getWorkflowData().getPayload().toString();
        ResourceResolver resolver = workflowSession.getSession().adaptTo(ResourceResolver.class);
        
        String pageTitle = resolver.getResource(payloadPath + "/jcr:content")
            .getValueMap()
            .get("jcr:title", "No Title Found");
        
        LOG.info("Workflow executed on page: {} with title: {}", payloadPath, pageTitle);
        LOG.info("Workflow Metadata: {}", workItem.getWorkflow().getMetaDataMap().toString());
    }
}