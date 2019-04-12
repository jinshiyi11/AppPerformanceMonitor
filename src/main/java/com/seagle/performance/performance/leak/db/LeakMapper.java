package com.seagle.performance.performance.leak.db;

import com.seagle.performance.performance.entity.ResponseBlockInfo;
import com.seagle.performance.performance.leak.bean.ResponseLeakCanaryInfo;
import com.seagle.performance.performance.leak.bean.ResponseMatrixLeakInfo;
import com.seagle.performance.performance.leak.bean.UploadLeakCanaryInfo;
import com.seagle.performance.performance.leak.bean.UploadMatrixLeakInfo;
import com.seagle.performance.performance.mapper.TimeHandler;
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

    @Insert("INSERT INTO leakCanaryInfo(info) VALUES(" +
            "#{leakInfo.mInfo})")
    void addLeakCanaryInfo(@Param("leakInfo") UploadLeakCanaryInfo leakInfo);

    @Select("SELECT COUNT(*) FROM leakCanaryInfo;")
    int getLeakCanaryInfoCount();

    @SelectProvider(type = LeakMapper.SqlBuilder.class, method = "buildLeakCanaryInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(id = true, property = "mInfo", column = "info"),
            @Result(property = "mInsertTime", column = "insertTime", typeHandler = TimeHandler.class)
    })
    List<ResponseLeakCanaryInfo> getLeakCanaryInfoList(@Param("start") int start, @Param("count") int count);

    class SqlBuilder {
        public String buildMatrixLeakInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,activity, tag, process, occurTime FROM matrixLeakInfo ORDER BY id DESC LIMIT " + start + "," + count;
            return sql;
        }

        public String buildLeakCanaryInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,info, insertTime FROM leakCanaryInfo ORDER BY id DESC LIMIT " + start + "," + count;
            return sql;
        }
    }
}
