package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.ResourcesResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class ResourcesResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(ResourcesResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String description = "some description";

        ResourceResponse resourceResponse = new ResourceResponse();
        resourceResponse.setDescription(description);

        List<ResourceResponse> resources = new ArrayList<ResourceResponse>();
        resources.add(resourceResponse);

        ResourcesResponse resourcesResponse = new ResourcesResponse();
        resourcesResponse.setResources(resources);

        String marshalled = TestUtil.marshall(ResourcesResponse.class, resourcesResponse);
        ResourcesResponse unmarshalled = (ResourcesResponse) TestUtil.unmarshall(ResourcesResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getResources().get(0).getDescription(), description);
    }
}
