package retodaw.dtos;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "email")
@Builder
public class UsuarioRegistroDTO {
    private String email;
    private String password;

    public UsuarioRegistroDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
