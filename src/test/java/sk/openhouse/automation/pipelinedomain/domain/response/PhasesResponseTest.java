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

        String description = "test";
        String href = "http://localhost:3000";
        String method = "GET";
        String schemaLocation = "http://localhost:3000/schema/phase";

        List<PhaseResponse> phases = new ArrayList<PhaseResponse>();
        phases.add(phaseResponse);
        PhasesResponse phasesResponse = new PhasesResponse();
        phasesResponse.setPhases(phases);
        phasesResponse.setDescription(description);
        phasesResponse.setHref(href);
        phasesResponse.setMethod(method);
        phasesResponse.setSchemaLocation(schemaLocation);

        String marshalled = TestUtil.marshall(PhasesResponse.class, phasesResponse);
        PhasesResponse unmarshalled = (PhasesResponse) TestUtil.unmarshall(PhasesResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getPhases().get(0).getName(), name);
        Assert.assertEquals(unmarshalled.getPhases().get(0).getUri(), uri);
        Assert.assertEquals(unmarshalled.getDescription(), description);
        Assert.assertEquals(unmarshalled.getHref(), href);
        Assert.assertEquals(unmarshalled.getMethod(), method);
        Assert.assertEquals(unmarshalled.getSchemaLocation(), schemaLocation);
    }
}
