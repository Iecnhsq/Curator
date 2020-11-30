package data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private String location;
    @Getter
    @Setter
    private String phone_s;
    @Getter
    @Setter
    private String group_s;
    @Getter
    @Setter
    private String mailparents;
    @Getter
    @Setter
    private String phoneparents;

    public Student() {
    }

    public Student(int id, String fio, String location, String phone_s, String group_s, String mailparents, String phoneparents) {
        this.id = id;
        this.fio = fio;
        this.location = location;
        this.phone_s = phone_s;
        this.group_s = group_s;
        this.mailparents = mailparents;
        this.phoneparents = phoneparents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.fio);
        hash = 89 * hash + Objects.hashCode(this.location);
        hash = 89 * hash + Objects.hashCode(this.phone_s);
        hash = 89 * hash + Objects.hashCode(this.group_s);
        hash = 89 * hash + Objects.hashCode(this.mailparents);
        hash = 89 * hash + Objects.hashCode(this.phoneparents);
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
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fio, other.fio)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.phone_s, other.phone_s)) {
            return false;
        }
        if (!Objects.equals(this.group_s, other.group_s)) {
            return false;
        }
        if (!Objects.equals(this.mailparents, other.mailparents)) {
            return false;
        }
        return Objects.equals(this.phoneparents, other.phoneparents);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{id=").append(id);
        sb.append(", fio=").append(fio);
        sb.append(", location=").append(location);
        sb.append(", phone_s=").append(phone_s);
        sb.append(", group_s=").append(group_s);
        sb.append(", mailparents=").append(mailparents);
        sb.append(", phoneparents=").append(phoneparents);
        sb.append('}');
        return sb.toString();
    }

}
