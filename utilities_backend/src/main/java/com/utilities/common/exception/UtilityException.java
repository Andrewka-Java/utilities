/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.common.exception;

public class UtilityException extends Exception {

    public UtilityException(final String message) {
        super(message);
    }

    public UtilityException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
