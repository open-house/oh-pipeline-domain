package sk.openhouse.automation.pipelinedomain.domain.request;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class VersionRequestTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(VersionRequest.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String versionNumber = "0.1";
        VersionRequest versionRequest = new VersionRequest();
        versionRequest.setVersionNumber(versionNumber);

        String marshalled = TestUtil.marshall(VersionRequest.class, versionRequest);
        VersionRequest unmarshalled = (VersionRequest) TestUtil.unmarshall(VersionRequest.class, marshalled);

        Assert.assertEquals(unmarshalled.getVersionNumber(), versionRequest.getVersionNumber());
        Assert.assertEquals(unmarshalled.getVersionNumber(), versionNumber);
    }
}
