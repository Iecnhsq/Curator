package data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subdis")
public class SubDis implements Serializable {

    @Id
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int point;
    @Getter
    @Setter
    private int term;
    @Getter
    @Setter
    private int course;

    public SubDis() {
    }

    public SubDis(int id, String name, int point, int term, int course) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.term = term;
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.point;
        hash = 29 * hash + this.term;
        hash = 29 * hash + this.course;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubDis other = (SubDis) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.point != other.point) {
            return false;
        }
        if (this.term != other.term) {
            return false;
        }
        if (this.course != other.course) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

}
