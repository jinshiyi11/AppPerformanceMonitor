package com.seagle.performance.performance.mapper;

import com.seagle.performance.performance.entity.ResponseBlockInfo;
import com.seagle.performance.performance.entity.UploadBlockInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface DbMapper {
    @Select("SELECT EXISTS(SELECT 1 FROM blockInfo WHERE key=#{key})")
    boolean exists(@Param("key") String key);

    @Insert("INSERT INTO blockInfo(`key`,stack,blockTime) VALUES(" +
            "#{blockInfo.mKey},#{blockInfo.mStackTrace},#{blockInfo.mBlockTime})")
    void addBlockInfo(@Param("blockInfo") UploadBlockInfo blockInfo);

    @Select("SELECT COUNT(*) FROM (SELECT id FROM blockInfo group by `key`) a;")
    int getBlockInfoCount();

    @SelectProvider(type = SqlBuilder.class, method = "buildBlockInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mStackTrace", column = "stack"),
            @Result(property = "mBlockTime", column = "blockTime"),
            @Result(property = "mInsertTime", column = "insert_time", typeHandler = TimeHandler.class),
            @Result(property = "mOccurCount", column = "occurCount")
    })
    List<ResponseBlockInfo> getBlockInfoList(@Param("start") int start, @Param("count") int count);


    class SqlBuilder {
        public String buildBlockInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,`key`, count(*) as occurCount, max(blockTime) as blockTime, max(insert_time) as insert_time,stack FROM blockInfo group by `key` ORDER BY blockTime DESC LIMIT " + start + "," + count;
            return sql;
        }
    }
}
