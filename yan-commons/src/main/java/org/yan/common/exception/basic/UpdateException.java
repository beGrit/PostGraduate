package org.yan.common.exception.basic;

public class UpdateException extends CrudException {
    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }
}
