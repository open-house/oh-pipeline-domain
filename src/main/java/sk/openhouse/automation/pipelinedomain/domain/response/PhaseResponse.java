package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a single project phase
 * 
 * @author pete
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "phase")
@XmlType(propOrder = {"name", "auto", "uri", "links"})
public class PhaseResponse {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "auto")
    private boolean auto = true;

    @XmlElement(name = "uri")
    private URI uri;

    @XmlElement(name = "links")
    private LinksResponse links;

    private transient String username;

    private transient byte[] password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(name)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof PhaseResponse)) {
            return false;
        }

        final PhaseResponse other = (PhaseResponse) object;
        return new EqualsBuilder()
                .append(name, other.name)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("name", name)
                .append("auto", auto)
                .append("uri", uri)
                .append("links", links)
                .append("username", username)
                .append("password", "******")
                .toString();
    }
}
