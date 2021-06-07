package org.yan.portal.exception;

public class GradeQueryException extends QueryException {

    String message;

    public GradeQueryException(String s) {
        super(s);
    }
}
