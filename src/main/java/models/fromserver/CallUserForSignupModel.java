package models.fromserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallUserForSignupModel {

    @JsonProperty("type")
    private boolean type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("text")
    private String text;

}
