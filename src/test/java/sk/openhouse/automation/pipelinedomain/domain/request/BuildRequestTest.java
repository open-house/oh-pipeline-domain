package sk.openhouse.automation.pipelinedomain.domain.request;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class BuildRequestTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(BuildRequest.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        int buildNumber = 7;
        BuildRequest buildRequest = new BuildRequest();
        buildRequest.setNumber(buildNumber);

        String marshalled = TestUtil.marshall(BuildRequest.class, buildRequest);
        BuildRequest unmarshalled = (BuildRequest) TestUtil.unmarshall(BuildRequest.class, marshalled);

        Assert.assertEquals(unmarshalled.getNumber(), buildNumber);
    }
}
