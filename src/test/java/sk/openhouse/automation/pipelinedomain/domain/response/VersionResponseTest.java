package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void testCompareTo() {

        VersionResponse versionResponse1 = new VersionResponse();
        versionResponse1.setVersionNumber("0.1");

        VersionResponse versionResponse3 = new VersionResponse();
        versionResponse3.setVersionNumber("0.3");

        VersionResponse versionResponse2 = new VersionResponse();
        versionResponse2.setVersionNumber("0.2");

        List<VersionResponse> versions = new ArrayList<VersionResponse>();
        versions.add(versionResponse1);
        versions.add(versionResponse3);
        versions.add(versionResponse2);

        Collections.sort(versions);
        Assert.assertEquals(versions.get(0).getVersionNumber(), "0.3");
    }
}
