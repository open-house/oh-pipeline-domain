package sk.openhouse.automation.pipelinedomain.domain.response;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents resource
 * 
 * @author pete
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "link")
@XmlType(propOrder = {"href", "method", "description", "schemaLocation"})
public class LinkResponse {

    @XmlAttribute(name = "href")
    private URI href;

    @XmlAttribute(name = "method")
    private String method;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "schemaLocation")
    private URI schemaLocation;

    /**
     * @return uri of the resource
     */
    public URI getHref() {
        return href;
    }

    /**
     * @param link uri of the resource
     */
    public void setHref(URI href) {
        this.href = href;
    }

    /**
     * @return http method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method http method
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
     * @return resource xml schema location
     */
    public URI getSchemaLocation() {
        return schemaLocation;
    }

    /**
     * @param schemaLocation resource xml schema location
     */
    public void setSchemaLocation(URI schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(href)
                .append(method)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof LinkResponse)) {
            return false;
        }

        final LinkResponse other = (LinkResponse) object;
        return new EqualsBuilder()
                .append(href, other.href)
                .append(method, other.method)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("href", href)
                .append("method", method)
                .append("description", description)
                .append("schemaLocation", schemaLocation)
                .toString();
    }
}
