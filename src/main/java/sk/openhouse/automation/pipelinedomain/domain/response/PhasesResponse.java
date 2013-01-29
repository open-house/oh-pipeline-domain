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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "phases")
public class PhasesResponse {

    @XmlAttribute(name = "href")
    private String href;

    @XmlAttribute(name = "method")
    private String method;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "schemaLocation")
    private String schemaLocation;

    @XmlElement(name = "phases")
    private List<PhaseResponse> phases = new ArrayList<PhaseResponse>();

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
     * @return link to the schema
     */
    public String getSchemaLocation() {
        return schemaLocation;
    }

    /**
     * @param schemaLocation link to the schema
     */
    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public List<PhaseResponse> getPhases() {
        return phases;
    }

    public void setPhases(List<PhaseResponse> phases) {
        this.phases = phases;
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(phases)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof PhasesResponse)) {
            return false;
        }

        final PhasesResponse other = (PhasesResponse) object;
        return new EqualsBuilder()
                .append(phases, other.phases)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("href", href)
                .append("method", method)
                .append("description", description)
                .append("schemaLocation", schemaLocation)
                .append("phases", phases)
                .toString();
    }
}
