package sk.openhouse.automation.pipelinedomain.domain.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * List of resources
 * 
 * @author pete
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "links")
public class LinksResponse {

    @XmlElement(name = "link")
    private List<LinkResponse> links = new ArrayList<LinkResponse>();

    /**
     * @return list of resources
     */
    public List<LinkResponse> getLinks() {
        return links;
    }

    /**
     * @param resources list of resources
     */
    public void setLinks(List<LinkResponse> links) {
        this.links = links;
    }

    @Override
    public final int hashCode() {

        return new HashCodeBuilder()
                .append(links)
                .toHashCode();
    }

    @Override
    public final boolean equals(Object object) {

        if (!(object instanceof LinksResponse)) {
            return false;
        }

        final LinksResponse other = (LinksResponse) object;
        return new EqualsBuilder()
                .append(links, other.links)
                .isEquals();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("links", links)
                .toString();
    }
}
