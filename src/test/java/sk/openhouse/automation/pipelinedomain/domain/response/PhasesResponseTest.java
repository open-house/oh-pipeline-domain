package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class PhasesResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(PhasesResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException, URISyntaxException {

        String name = "test_phase";
        URI uri = new URI("http://localhost/uri");

        PhaseResponse phaseResponse = new PhaseResponse();
        phaseResponse.setName(name);
        phaseResponse.setUri(uri);

        List<PhaseResponse> phases = new ArrayList<PhaseResponse>();
        phases.add(phaseResponse);
        PhasesResponse phasesResponse = new PhasesResponse();
        phasesResponse.setPhases(phases);

        String marshalled = TestUtil.marshall(PhasesResponse.class, phasesResponse);
        PhasesResponse unmarshalled = (PhasesResponse) TestUtil.unmarshall(PhasesResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getPhases().get(0).getName(), name);
        Assert.assertEquals(unmarshalled.getPhases().get(0).getUri(), uri);
    }
}
