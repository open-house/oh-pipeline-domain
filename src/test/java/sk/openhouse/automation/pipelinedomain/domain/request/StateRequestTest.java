package sk.openhouse.automation.pipelinedomain.domain.request;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.PhaseState;
import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class StateRequestTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(StateRequest.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        PhaseState name = PhaseState.FAIL;
        StateRequest stateRequest = new StateRequest();
        stateRequest.setName(name);

        String marshalled = TestUtil.marshall(StateRequest.class, stateRequest);
        StateRequest unmarshalled = (StateRequest) TestUtil.unmarshall(StateRequest.class, marshalled);

        Assert.assertEquals(unmarshalled.getName(), stateRequest.getName());
        Assert.assertEquals(unmarshalled.getName(), name);
    }
}
