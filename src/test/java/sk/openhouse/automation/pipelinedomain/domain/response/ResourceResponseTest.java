package sk.openhouse.automation.pipelinedomain.domain.response;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.ResourceResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class ResourceResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(ResourceResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String description = "some description";
        String method = "POST";

        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setMethod(method);

        ResourceResponse resourceResponse = new ResourceResponse();
        resourceResponse.setDescription(description);
        resourceResponse.setLink(linkResponse);

        String marshalled = TestUtil.marshall(ResourceResponse.class, resourceResponse);
        ResourceResponse unmarshalled = (ResourceResponse) TestUtil.unmarshall(ResourceResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getDescription(), description);
        Assert.assertEquals(unmarshalled.getLink().getMethod(), method);
    }
}
