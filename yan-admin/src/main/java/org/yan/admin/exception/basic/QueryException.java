package org.yan.admin.exception.basic;

public class QueryException extends CrudException {
    public QueryException() {
    }

    public QueryException(String message) {
        super(message);
    }
}
