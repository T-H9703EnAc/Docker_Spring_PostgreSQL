package jp.com.app.service;

import java.util.List;
import jp.com.app.dto.*;

public interface SampleService1 {
    public List<SampleDto1Response> getSelectSql();

    public void getInsertSql(SampleDto1Request req);

    public void getUpdateSql(SampleDto1Request req);

    public void getDeleteSql(SampleDto1Request req);
}
