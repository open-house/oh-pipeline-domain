package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class BuildResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(BuildResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        int number = 3;
        String name = "test_phase";
        BuildResponse buildResponse = new BuildResponse();
        buildResponse.setNumber(number);

        BuildPhaseResponse buildPhaseResponse = new BuildPhaseResponse();
        buildPhaseResponse.setName(name);
        List<BuildPhaseResponse> buildPhases = new ArrayList<BuildPhaseResponse>();
        buildPhases.add(buildPhaseResponse);

        BuildPhasesResponse buildPhasesResponse = new BuildPhasesResponse();
        buildPhasesResponse.setBuildPhases(buildPhases);
        buildResponse.setBuildPhases(buildPhasesResponse);

        String marshalled = TestUtil.marshall(BuildResponse.class, buildResponse);
        BuildResponse unmarshalled = (BuildResponse) TestUtil.unmarshall(BuildResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getBuildPhases().getBuildPhases().get(0).getName(), name);
        Assert.assertEquals(unmarshalled.getNumber(), number);
    }

    @Test
    public void testCompareTo() {

        BuildResponse buildResponse1 = new BuildResponse();
        buildResponse1.setNumber(1);

        BuildResponse buildResponse3 = new BuildResponse();
        buildResponse3.setNumber(3);

        BuildResponse buildResponse2 = new BuildResponse();
        buildResponse2.setNumber(2);

        List<BuildResponse> builds = new ArrayList<BuildResponse>();
        builds.add(buildResponse1);
        builds.add(buildResponse3);
        builds.add(buildResponse2);

        Collections.sort(builds);
        Assert.assertEquals(builds.get(0).getNumber(), 3);
    }
}
