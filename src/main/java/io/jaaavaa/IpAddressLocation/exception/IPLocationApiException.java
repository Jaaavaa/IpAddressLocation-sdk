package io.jaaavaa.IpAddressLocation.exception;

/**
 * This is the base exception class which has a publicly accessible message and code that
 * is received from IP Api.
 */
public class IPLocationApiException extends Throwable {

    /**
     * variables
     */
    public String message;
    public int code;

    /**
     * constructor that sets the message
     *
     * @param message
     */
    public IPLocationApiException(String message) {
        this.message = message;
    }

    /**
     * constructor that sets the message and code
     *
     * @param message
     * @param code
     */
    public IPLocationApiException(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
