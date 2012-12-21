package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.Date;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.PhaseState;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class StateResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(StateResponse.class)
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

        String marshalled = TestUtil.marshall(StateResponse.class, stateResponse);
        StateResponse unmarshalled = (StateResponse) TestUtil.unmarshall(StateResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getDate(), date);
        Assert.assertEquals(unmarshalled.getName(), name);
    }
}
