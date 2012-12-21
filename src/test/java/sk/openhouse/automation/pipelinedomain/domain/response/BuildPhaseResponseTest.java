package sk.openhouse.automation.pipelinedomain.domain.response;

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
    public void testMarshall() throws JAXBException {

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

        String marshalled = TestUtil.marshall(BuildPhaseResponse.class, buildPhaseResponse);
        BuildPhaseResponse unmarshalled = (BuildPhaseResponse) TestUtil.unmarshall(BuildPhaseResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), name);
        Assert.assertEquals(unmarshalled.getStates().getStates().get(0).getName(), stateName);
        Assert.assertEquals(unmarshalled.getStates().getStates().get(0).getDate(), stateDate);
    }
}
