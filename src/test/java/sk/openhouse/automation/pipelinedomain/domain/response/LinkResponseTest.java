package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.LinkResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class LinkResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(LinkResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException, URISyntaxException {

        URI href = new URI("http://localhost/test");
        String method = "POST";
        URI schemaLocation = new URI("http://localhost/schema");

        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setHref(href);
        linkResponse.setMethod(method);
        linkResponse.setSchemaLocation(schemaLocation);

        String marshalled = TestUtil.marshall(LinkResponse.class, linkResponse);
        LinkResponse unmarshalled = (LinkResponse) TestUtil.unmarshall(LinkResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getHref(), linkResponse.getHref());
        Assert.assertEquals(unmarshalled.getMethod(), linkResponse.getMethod());
        Assert.assertEquals(unmarshalled.getSchemaLocation(), linkResponse.getSchemaLocation());

        Assert.assertEquals(unmarshalled.getHref(), href);
        Assert.assertEquals(unmarshalled.getMethod(), method);
        Assert.assertEquals(unmarshalled.getSchemaLocation(), schemaLocation);
    }
}
