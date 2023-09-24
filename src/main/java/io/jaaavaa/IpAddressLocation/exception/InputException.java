package io.jaaavaa.IpAddressLocation.exception;

/**
 * Represents user input errors such as missing and invalid parameters.
 * Default code is 400.
 */
public class InputException extends IPLocationApiException {
    /**
     * initialize and call base exception constructor
     *
     * @param message
     * @param code
     */
    public InputException(String message, int code) {
        super(message, code);
    }
}
