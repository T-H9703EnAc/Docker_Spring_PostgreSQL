package jp.com.app.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.com.app.entity.*;
@Mapper
public interface Sample1Mapper {
    public List<SampleEntity1Response> selectSql();

    public void insertSql(SampleEntity1Request req);

    public void updateSql(SampleEntity1Request req);

    public void deleteSql(SampleEntity1Request req);
}
