package models.toserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthFormBody {
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("login")
    private String login;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("password")
    private String password;
    @JsonProperty("passwordValidation")
    private String passwordValidation;
}
