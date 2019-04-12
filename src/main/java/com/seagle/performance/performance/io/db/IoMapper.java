package com.seagle.performance.performance.io.db;

import com.seagle.performance.performance.io.bean.ResponseIoLeakInfo;
import com.seagle.performance.performance.io.bean.UploadIoLeakInfo;
import com.seagle.performance.performance.mapper.TimeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IoMapper {
    @Insert("INSERT INTO ioLeakInfo(stack,process,occurTime) VALUES(" +
            "#{leakInfo.mStack},#{leakInfo.mProcess},#{leakInfo.mOccurTime})")
    void addIoBlockInfo(@Param("leakInfo") UploadIoLeakInfo leakInfo);

    @Select("SELECT COUNT(*) FROM ioLeakInfo")
    int getIoLeakInfoCount();

    @SelectProvider(type = IoMapper.SqlBuilder.class, method = "buildIoLeakInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mStack", column = "stack"),
            @Result(property = "mInsertTime", column = "insertTime", typeHandler = TimeHandler.class)
    })
    List<ResponseIoLeakInfo> getIoLeakInfoList(@Param("start") int start, @Param("count") int count);


    class SqlBuilder {
        public String buildIoLeakInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,stack, insertTime FROM ioLeakInfo ORDER BY id DESC LIMIT " + start + "," + count;
            return sql;
        }
    }
}
