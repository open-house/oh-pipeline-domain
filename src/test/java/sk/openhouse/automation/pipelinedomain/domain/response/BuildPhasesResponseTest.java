package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class BuildPhasesResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(BuildPhasesResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String name = "test_phase";
        BuildPhaseResponse buildPhaseResponse = new BuildPhaseResponse();
        buildPhaseResponse.setName(name);
        List<BuildPhaseResponse> buildPhases = new ArrayList<BuildPhaseResponse>();
        buildPhases.add(buildPhaseResponse);

        BuildPhasesResponse buildPhasesResponse = new BuildPhasesResponse();
        buildPhasesResponse.setBuildPhases(buildPhases);

        String marshalled = TestUtil.marshall(BuildPhasesResponse.class, buildPhasesResponse);
        BuildPhasesResponse unmarshalled = (BuildPhasesResponse) TestUtil.unmarshall(BuildPhasesResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getBuildPhases().get(0).getName(), name);
    }
}
