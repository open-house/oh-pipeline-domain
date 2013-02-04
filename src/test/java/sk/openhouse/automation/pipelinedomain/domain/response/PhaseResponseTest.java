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
        boolean auto = false;
        URI uri = new URI("http://localhost/uri");
        String username = "test_user";
        String password = "test_password";

        PhaseResponse phaseResponse = new PhaseResponse();
        phaseResponse.setName(name);
        phaseResponse.setAuto(auto);
        phaseResponse.setUri(uri);
        phaseResponse.setUsername(username);
        phaseResponse.setPassword(password.getBytes());

        LinkResponse linkResponse = new LinkResponse();
        List<LinkResponse> links = new ArrayList<LinkResponse>();
        links.add(linkResponse);
        LinksResponse linksResponse = new LinksResponse();
        linksResponse.setLinks(links);
        phaseResponse.setLinks(linksResponse);

        String marshalled = TestUtil.marshall(PhaseResponse.class, phaseResponse);
        PhaseResponse unmarshalled = (PhaseResponse) TestUtil.unmarshall(PhaseResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.isAuto(), auto);
        Assert.assertEquals(unmarshalled.getUri(), uri);
        Assert.assertEquals(unmarshalled.getLinks().getLinks().size(), 1);
        Assert.assertNull(unmarshalled.getUsername());
        Assert.assertNull(unmarshalled.getPassword());
    }
}
