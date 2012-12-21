package sk.openhouse.automation.pipelinedomain.domain.request;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.request.ProjectRequest;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class ProjectRequestTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(ProjectRequest.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String name = "test_project";
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setName(name);

        String marshalled = TestUtil.marshall(ProjectRequest.class, projectRequest);
        ProjectRequest unmarshalled = (ProjectRequest) TestUtil.unmarshall(ProjectRequest.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), projectRequest.getName());
        Assert.assertEquals(unmarshalled.getName(), name);
    }
}
