package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class BuildsResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(BuildsResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        int number = 3;
        BuildsResponse buildsResponse = new BuildsResponse();
        BuildResponse buildResponse = new BuildResponse();
        buildResponse.setNumber(number);

        List<BuildResponse> builds = new ArrayList<BuildResponse>();
        builds.add(buildResponse);
        buildsResponse.setBuilds(builds);

        String marshalled = TestUtil.marshall(BuildsResponse.class, buildsResponse);
        BuildsResponse unmarshalled = (BuildsResponse) TestUtil.unmarshall(BuildsResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getBuilds().get(0).getNumber(), number);
    }
}
