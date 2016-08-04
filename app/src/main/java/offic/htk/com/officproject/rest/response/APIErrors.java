package offic.htk.com.officproject.rest.response;

/**
 * Created by nguyen on 27/07/2016.
 */
public class APIErrors {
    private boolean success;
    private String error_message;

    public APIErrors() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
