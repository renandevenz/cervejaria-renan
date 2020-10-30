package com.beerhouse.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;

import static org.springframework.core.GenericTypeResolver.resolveTypeArguments;

@Slf4j
public abstract class AbstractGlobalExceptionHandler<E extends Exception, T> implements RestExceptionHandler<E, T> {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final Class<E> exceptionClass;
    private final HttpStatus status;

    protected AbstractGlobalExceptionHandler(HttpStatus status) {
        this.exceptionClass = determineTargetType();
        this.status = status;
        LOG.trace("Tipo de exceção genérica determinado: {}", exceptionClass.getName());
    }

    protected AbstractGlobalExceptionHandler(Class<E> exceptionClass, HttpStatus status) {
        this.exceptionClass = exceptionClass;
        this.status = status;
    }

    public abstract T createBody(E ex, HttpServletRequest req);

    public ResponseEntity<T> handleException(E ex, HttpServletRequest req) {

        logException(ex, req);

        T body = createBody(ex, req);
        HttpHeaders headers = createHeaders(ex, req);

        return new ResponseEntity<>(body, headers, getStatus());
    }

    public Class<E> getExceptionClass() {
        return exceptionClass;
    }

    public HttpStatus getStatus() {
        return status;
    }

    protected HttpHeaders createHeaders(E ex, HttpServletRequest req) {
        return new HttpHeaders();
    }

    protected void logException(E ex, HttpServletRequest req) {

        if (LOG.isErrorEnabled() && getStatus().value() >= 500 || LOG.isInfoEnabled()) {
            Marker marker = MarkerFactory.getMarker(ex.getClass().getName());

            String uri = req.getRequestURI();
            if (req.getQueryString() != null) {
                uri += '?' + req.getQueryString();
            }
            String msg = String.format("%s %s ~> %s", req.getMethod(), uri, getStatus());

            if (getStatus().value() >= 500) {
                LOG.error(marker, msg, ex);

            } else if (LOG.isDebugEnabled()) {
                LOG.debug(marker, msg, ex);

            } else {
                LOG.info(marker, msg);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Class<E> determineTargetType() {
        return (Class<E>) Objects.requireNonNull(resolveTypeArguments(getClass(), AbstractGlobalExceptionHandler.class))[0];
    }
}