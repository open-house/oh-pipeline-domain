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
@XmlRootElement(name = "project")
@XmlType(propOrder = {"name", "links"})
public class ProjectResponse {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "links")
    private LinksResponse links;

    /**
     * @return unique product name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return list of links for a project(s)
     */
    public LinksResponse getLinks() {
        return links;
    }

    /**
     * @param links list of links for a project(s)
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

        if (!(object instanceof ProjectResponse)) {
            return false;
        }

        final ProjectResponse other = (ProjectResponse) object;
        return new EqualsBuilder()
                .append(name, other.name)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("name", name)
                .append("links", links)
                .toString();
    }
}
