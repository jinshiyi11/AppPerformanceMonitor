package com.seagle.performance.performance.leak.db;

import com.seagle.performance.performance.entity.ResponseBlockInfo;
import com.seagle.performance.performance.leak.bean.ResponseMatrixLeakInfo;
import com.seagle.performance.performance.leak.bean.UploadMatrixLeakInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeakMapper {
    @Insert("INSERT INTO matrixLeakInfo(activity,tag,process,occurTime) VALUES(" +
            "#{leakInfo.mActivity},#{leakInfo.mTag},#{leakInfo.mProcess},#{leakInfo.mOccurTime})")
    void addMatrixBlockInfo(@Param("leakInfo") UploadMatrixLeakInfo leakInfo);

    @Select("SELECT COUNT(*) FROM matrixLeakInfo;")
    int getMatrixLeakInfoCount();

    @SelectProvider(type = LeakMapper.SqlBuilder.class, method = "buildMatrixLeakInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mActivity", column = "activity"),
            @Result(property = "mTag", column = "tag"),
            @Result(property = "mProcess", column = "process"),
            @Result(property = "mOccurTime", column = "occurTime")
    })
    List<ResponseMatrixLeakInfo> getMatrixLeakInfoList(@Param("start") int start, @Param("count") int count);

    class SqlBuilder {
        public String buildMatrixLeakInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,activity, tag, process, occurTime FROM matrixLeakInfo ORDER BY id DESC LIMIT " + start + "," + count;
            return sql;
        }
    }
}
