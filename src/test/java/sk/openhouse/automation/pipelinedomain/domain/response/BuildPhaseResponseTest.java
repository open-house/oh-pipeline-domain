package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.PhaseState;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class BuildPhaseResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(BuildPhaseResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException, URISyntaxException {

        String name = "test_phase";
        Date stateDate = new Date();
        PhaseState stateName = PhaseState.IN_PROGRESS;

        StateResponse stateResponse = new StateResponse();
        stateResponse.setDate(stateDate);
        stateResponse.setName(stateName);

        List<StateResponse> states = new ArrayList<StateResponse>();
        states.add(stateResponse);

        StatesResponse statesResponse = new StatesResponse();
        statesResponse.setStates(states);

        BuildPhaseResponse buildPhaseResponse = new BuildPhaseResponse();
        buildPhaseResponse.setName(name);
        buildPhaseResponse.setStates(statesResponse);

        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setDescription("test link");
        linkResponse.setHref(new URI("http://localhost:4000"));
        linkResponse.setMethod("GET");
        linkResponse.setSchemaLocation(new URI("http://localhost:8000/schema"));

        List<LinkResponse> links = new ArrayList<LinkResponse>();
        links.add(linkResponse);
        LinksResponse linksResponse = new LinksResponse();
        linksResponse.setLinks(links);
        buildPhaseResponse.setLinks(linksResponse);

        String marshalled = TestUtil.marshall(BuildPhaseResponse.class, buildPhaseResponse);
        BuildPhaseResponse unmarshalled = (BuildPhaseResponse) TestUtil.unmarshall(BuildPhaseResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.getStates().getStates().get(0).getName(), stateName);
        Assert.assertEquals(unmarshalled.getStates().getStates().get(0).getDate(), stateDate);

        LinkResponse link = unmarshalled.getLinks().getLinks().get(0);
        Assert.assertEquals(link.getDescription(), "test link");
        Assert.assertEquals(link.getMethod(), "GET");
        Assert.assertEquals(link.getHref(), new URI("http://localhost:4000"));
        Assert.assertEquals(link.getSchemaLocation(), new URI("http://localhost:8000/schema"));
    }
}
