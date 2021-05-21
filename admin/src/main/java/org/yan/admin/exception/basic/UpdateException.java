package org.yan.admin.exception.basic;

public class UpdateException extends CrudException {
    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }
}
