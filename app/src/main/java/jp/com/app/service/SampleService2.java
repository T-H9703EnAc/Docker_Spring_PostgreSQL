package jp.com.app.service;

import jp.com.app.dto.SampleDto2Request;
import jp.com.app.exception.DBException;

public interface SampleService2 {
    public void getError(SampleDto2Request req) throws DBException;

    public void postError(SampleDto2Request req) throws DBException;
}
