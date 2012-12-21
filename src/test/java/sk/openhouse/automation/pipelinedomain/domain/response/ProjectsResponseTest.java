package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.response.ProjectsResponse;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class ProjectsResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(ProjectsResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException, URISyntaxException {

        String name = "test_project";

        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setName(name);

        List<ProjectResponse> projects = new ArrayList<ProjectResponse>();
        projects.add(projectResponse);
        ProjectsResponse projectsResponse = new ProjectsResponse();
        projectsResponse.setProjects(projects);

        String marshalled = TestUtil.marshall(ProjectsResponse.class, projectsResponse);
        ProjectsResponse unmarshalled = (ProjectsResponse) TestUtil.unmarshall(ProjectsResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getProjects().get(0).getName(), name);
    }
}
