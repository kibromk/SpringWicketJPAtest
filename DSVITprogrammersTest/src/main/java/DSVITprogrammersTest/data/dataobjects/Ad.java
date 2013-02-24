package DSVITprogrammersTest.data.dataobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Ad extends DomainObject {

    private static final long serialVersionUID = 2959377496669050427L;

    @Id
    @GeneratedValue
    private Long id;

    private String title;




    public Ad() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ad other = (Ad) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Ad [id=%s, title=%s]", id, title);
    }
}