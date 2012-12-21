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

public class StatesResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(StatesResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        Date date = new Date();
        PhaseState name = PhaseState.SUCCESS;

        StateResponse stateResponse = new StateResponse();
        stateResponse.setDate(date);
        stateResponse.setName(name);

        List<StateResponse> states = new ArrayList<StateResponse>();
        states.add(stateResponse);

        StatesResponse statesResponse = new StatesResponse();
        statesResponse.setStates(states);

        String marshalled = TestUtil.marshall(StatesResponse.class, statesResponse);
        StatesResponse unmarshalled = (StatesResponse) TestUtil.unmarshall(StatesResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getStates().get(0).getDate(), date);
        Assert.assertEquals(unmarshalled.getStates().get(0).getName(), name);
    }
}
