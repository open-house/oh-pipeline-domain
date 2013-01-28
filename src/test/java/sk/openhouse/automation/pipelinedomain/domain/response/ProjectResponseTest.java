package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.ProjectResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class ProjectResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(ProjectResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String name = "test_project";

        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setName(name);

        LinkResponse linkResponse = new LinkResponse();
        List<LinkResponse> links = new ArrayList<LinkResponse>();
        links.add(linkResponse);
        LinksResponse linksResponse = new LinksResponse();
        linksResponse.setLinks(links);
        projectResponse.setLinks(linksResponse);

        String marshalled = TestUtil.marshall(ProjectResponse.class, projectResponse);
        ProjectResponse unmarshalled = (ProjectResponse) TestUtil.unmarshall(ProjectResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.getLinks().getLinks().size(), 1);
    }
}
