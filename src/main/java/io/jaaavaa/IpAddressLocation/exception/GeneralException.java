package io.jaaavaa.IpAddressLocation.exception;

/**
 * An unclassified, general error. Default code is 500
 */
public class GeneralException extends IPLocationApiException {
    /**
     * initialize and call base exception constructor
     *
     * @param message
     * @param code
     */
    public GeneralException(String message, int code) {
        super(message, code);
    }
}
