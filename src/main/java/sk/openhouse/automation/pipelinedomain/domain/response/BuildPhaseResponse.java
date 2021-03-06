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
@XmlRootElement(name = "build-phase")
@XmlType(propOrder = { "name", "states", "links" })
public class BuildPhaseResponse {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "states")
    private StatesResponse states = new StatesResponse();

    @XmlElement(name = "links")
    private LinksResponse links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatesResponse getStates() {
        return states;
    }

    public void setStates(StatesResponse states) {
        this.states = states;
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
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(name)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof BuildPhaseResponse)) {
            return false;
        }

        final BuildPhaseResponse other = (BuildPhaseResponse) object;
        return new EqualsBuilder()
                .append(name, other.name)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("name", name)
                .append("states", states)
                .append("links", links)
                .toString();
    }
}
