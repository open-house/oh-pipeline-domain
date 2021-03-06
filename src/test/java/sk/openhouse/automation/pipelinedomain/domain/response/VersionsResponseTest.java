package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.Test;

import sk.openhouse.automation.pipelinedomain.domain.util.TestUtil;

public class VersionsResponseTest {

    @Test
    public void testEquals() {

        EqualsVerifier.forClass(VersionsResponse.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testMarshall() throws JAXBException {

        String versionNumber = "7.5";

        VersionResponse versionResponse = new VersionResponse();
        versionResponse.setVersionNumber(versionNumber);

        List<VersionResponse> versions = new ArrayList<VersionResponse>();
        versions.add(versionResponse);

        String description = "test";
        String href = "http://localhost:3000";
        String method = "GET";

        VersionsResponse versionsResponse = new VersionsResponse();
        versionsResponse.setVersions(versions);
        versionsResponse.setDescription(description);
        versionsResponse.setHref(href);
        versionsResponse.setMethod(method);

        String marshalled = TestUtil.marshall(VersionsResponse.class, versionsResponse);
        VersionsResponse unmarshalled = (VersionsResponse) TestUtil.unmarshall(VersionsResponse.class, marshalled);

        Assert.assertEquals(unmarshalled.getVersions().get(0).getVersionNumber(), versionNumber);
        Assert.assertEquals(unmarshalled.getDescription(), description);
        Assert.assertEquals(unmarshalled.getHref(), href);
        Assert.assertEquals(unmarshalled.getMethod(), method);
    }
}
