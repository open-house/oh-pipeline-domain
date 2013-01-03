package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.LinksResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class LinksResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(LinksResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String description = "some description";

        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setDescription(description);

        List<LinkResponse> links = new ArrayList<LinkResponse>();
        links.add(linkResponse);

        LinksResponse linksResponse = new LinksResponse();
        linksResponse.setLinks(links);

        String marshalled = TestUtil.marshall(LinksResponse.class, linksResponse);
        LinksResponse unmarshalled = (LinksResponse) TestUtil.unmarshall(LinksResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getLinks().get(0).getDescription(), description);
    }
}
