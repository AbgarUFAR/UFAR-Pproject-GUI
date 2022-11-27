package dto.response;

import com.google.gson.annotations.SerializedName;
import constant.enumeration.ResponseStatus;
import lombok.Data;

@Data
public class ErrorResponse {

    private ResponseStatus status;
    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("error_message")
    private String errorMessage;
}
