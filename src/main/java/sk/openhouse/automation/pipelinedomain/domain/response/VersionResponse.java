package sk.openhouse.automation.pipelinedomain.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "version")
@XmlType(propOrder = {"versionNumber", "links"})
public class VersionResponse implements Comparable<VersionResponse> {

    @XmlElement(name = "version-number")
    private String versionNumber;

    @XmlElement(name = "links")
    private LinksResponse links;

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * @return list of resources
     */
    public LinksResponse getLinks() {
        return links;
    }

    /**
     * @param links list of resources
     */
    public void setLinks(LinksResponse links) {
        this.links = links;
    }

    @Override
    public int compareTo(VersionResponse o) {
        return o.versionNumber.compareTo(versionNumber);
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(versionNumber)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof VersionResponse)) {
            return false;
        }

        final VersionResponse other = (VersionResponse) object;
        return new EqualsBuilder()
                .append(versionNumber, other.versionNumber)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("number", versionNumber)
                .append("links", links)
                .toString();
    }
}
