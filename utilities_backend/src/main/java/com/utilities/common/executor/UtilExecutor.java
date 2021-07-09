/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.common.executor;

import lombok.SneakyThrows;

import static java.lang.String.format;

@FunctionalInterface
public interface UtilExecutor {

    void execute() throws Exception;

    @SneakyThrows
    default <E extends Exception> void execute(final UtilExecutor executor, final Class<E> throwableException, final String messagePattern, final Object... variables) throws E {
        try {
            executor.execute();
        } catch (final Exception ex) {
            final String errorMessage = format(messagePattern, variables);
            throwableException.getConstructor(String.class, Throwable.class).newInstance(errorMessage, ex);
        }
    }

}
