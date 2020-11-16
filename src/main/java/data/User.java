package data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String mail;
    @Getter
    @Setter
    private String phone;

    public User() {
    }

    public User(int id, String login, String password, String mail, String phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.login);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.mail);
        hash = 41 * hash + Objects.hashCode(this.phone);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.phone, other.phone);
    }

}
