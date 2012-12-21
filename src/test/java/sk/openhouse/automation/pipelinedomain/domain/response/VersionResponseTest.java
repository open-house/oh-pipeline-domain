package sk.openhouse.automation.pipelinedomain.domain.response;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class VersionResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(VersionResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String versionNumber = "7.5";

        VersionResponse versionResponse = new VersionResponse();
        versionResponse.setVersionNumber(versionNumber);

        String marshalled = TestUtil.marshall(VersionResponse.class, versionResponse);
        VersionResponse unmarshalled = (VersionResponse) TestUtil.unmarshall(VersionResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getVersionNumber(), versionNumber);
    }
}
