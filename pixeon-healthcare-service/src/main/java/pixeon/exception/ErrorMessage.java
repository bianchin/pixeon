package pixeon.exception;

/**
 * Created by gian on 29/01/20.
 */
public class ErrorMessage {

    private String message;

    private ErrorMessage(Builder builder) {
        message = builder.message;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ErrorMessage copy) {
        Builder builder = new Builder();
        builder.message = copy.message;
        return builder;
    }


    public String getMessage() {
        return message;
    }

    public static final class Builder {
        private String message;

        private Builder() {
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(this);
        }
    }
}
