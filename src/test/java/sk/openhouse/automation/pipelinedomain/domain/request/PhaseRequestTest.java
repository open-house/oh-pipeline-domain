package sk.openhouse.automation.pipelinedomain.domain.request;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class PhaseRequestTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(PhaseRequest.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException, URISyntaxException {

        String name = "test";
        URI uri = new URI("http://localhost/test");
        String username = "test_user";
        String password = "test_pass";

        PhaseRequest phaseRequest = new PhaseRequest();
        phaseRequest.setName(name);
        phaseRequest.setUri(uri);
        phaseRequest.setUsername(username);
        phaseRequest.setPassword(password);

        String marshalled = TestUtil.marshall(PhaseRequest.class, phaseRequest);
        PhaseRequest unmarshalled = (PhaseRequest) TestUtil.unmarshall(PhaseRequest.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.getUri(), uri);
        Assert.assertEquals(unmarshalled.getUsername(), username);
        Assert.assertEquals(unmarshalled.getPassword(), password);
    }

    @Test
    public void testMarshallEmpty() throws JAXBException, URISyntaxException {

        PhaseRequest phaseRequest = new PhaseRequest();

        String marshalled = TestUtil.marshall(PhaseRequest.class, phaseRequest);
        PhaseRequest unmarshalled = (PhaseRequest) TestUtil.unmarshall(PhaseRequest.class, marshalled);

        Assert.assertNull(unmarshalled.getName());
        Assert.assertNull(unmarshalled.getUri());
        Assert.assertNull(unmarshalled.getUsername());
        Assert.assertNull(unmarshalled.getPassword());
    }
}
