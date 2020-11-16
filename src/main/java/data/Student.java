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
    private String groupID;
    @Getter
    @Setter
    private String mail;
    @Getter
    @Setter
    private String phone;

    public Student() {
    }

    public Student(int id, String fio, String groupID, String mail, String phone) {
        this.id = id;
        this.fio = fio;
        this.groupID = groupID;
        this.mail = mail;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.fio);
        hash = 59 * hash + Objects.hashCode(this.groupID);
        hash = 59 * hash + Objects.hashCode(this.mail);
        hash = 59 * hash + Objects.hashCode(this.phone);
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
        if (!Objects.equals(this.groupID, other.groupID)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.phone, other.phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{id=").append(id);
        sb.append(", fio=").append(fio);
        sb.append(", groupID=").append(groupID);
        sb.append(", mail=").append(mail);
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }

}
