package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * List of versions
 * 
 * @author pete
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "versions")
public class VersionsResponse {

    @XmlAttribute(name = "href")
    private String href;

    @XmlAttribute(name = "method")
    private String method;

    @XmlAttribute(name = "description")
    private String description;

    @XmlElement(name = "version")
    private List<VersionResponse> versions = new ArrayList<VersionResponse>();

    /**
     * @return uri of a resource
     */
    public String getHref() {
        return href;
    }

    /**
     * @param link uri of a resource
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return http method to access the (href) link
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method http method to access the (href) link
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return link description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description of the link
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return list of versions
     */
    public List<VersionResponse> getVersions() {
        return versions;
    }

    /**
     * @param versions list of versions
     */
    public void setVersions(List<VersionResponse> versions) {
        this.versions = versions;
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(versions)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof VersionsResponse)) {
            return false;
        }

        final VersionsResponse other = (VersionsResponse) object;
        return new EqualsBuilder()
                .append(versions, other.versions)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("href", href)
                .append("method", method)
                .append("description", description)
                .append("versions", versions)
                .toString();
    }
}
