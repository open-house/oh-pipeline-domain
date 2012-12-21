package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class PhaseResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(PhaseResponse.class)
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

        String marshalled = TestUtil.marshall(PhaseResponse.class, phaseResponse);
        PhaseResponse unmarshalled = (PhaseResponse) TestUtil.unmarshall(PhaseResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.getUri(), uri);
    }
}
