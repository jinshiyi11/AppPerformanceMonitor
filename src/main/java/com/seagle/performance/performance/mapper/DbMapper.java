package com.seagle.performance.performance.mapper;

import com.seagle.performance.performance.entity.ResponseBlockDetail;
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

    @Insert("INSERT INTO blockInfo(`key`,stack,blockTime,model,versionName,versionCode) VALUES(" +
            "#{blockInfo.mKey},#{blockInfo.mStackTrace},#{blockInfo.mBlockTime},#{blockInfo.mModel},#{blockInfo.mVersionName},#{blockInfo.mVersionCode})")
    void addBlockInfo(@Param("blockInfo") UploadBlockInfo blockInfo);

    @Select("SELECT COUNT(*) FROM (SELECT id FROM blockInfo group by `key`) a;")
    int getBlockInfoCount();

    @Select("SELECT COUNT(*) FROM (SELECT id FROM blockInfo WHERE `key`=#{key}) a;")
    int getBlockInfoCountByKey(@Param("key") String key);

    @SelectProvider(type = SqlBuilder.class, method = "buildBlockInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mStackTrace", column = "stack"),
            @Result(property = "mBlockTime", column = "blockTime"),
            @Result(property = "mInsertTime", column = "insert_time"),
            @Result(property = "mOccurCount", column = "occurCount")
    })
    List<ResponseBlockInfo> getBlockInfoList(@Param("start") int start, @Param("count") int count);

    @Select("SELECT `key` FROM blockInfo WHERE id=#{id}")
    String getBlockKey(@Param("id") int id);

    @Select("SELECT * FROM blockInfo WHERE `key`=#{key} ORDER BY id DESC LIMIT #{start},#{pageCount}")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mStackTrace", column = "stack"),
            @Result(property = "mBlockTime", column = "blockTime"),
            @Result(property = "mInsertTime", column = "insert_time"),
            @Result(property = "mOccurCount", column = "occurCount"),
            @Result(property = "mModel", column = "model"),
            @Result(property = "mVersionName", column = "versionName"),
            @Result(property = "mVersionCode", column = "versionCode")
    })
    List<ResponseBlockDetail> getBlockDetailList(@Param("key") String key, @Param("start") int start, @Param("pageCount") int pageCount);

    class SqlBuilder {
        public String buildBlockInfoListSql(@Param("start") int start, @Param("count") int count) {
            String sql = "SELECT id,`key`, count(*) as occurCount, max(blockTime) as blockTime, max(insert_time) as insert_time,stack FROM blockInfo group by `key` ORDER BY blockTime DESC LIMIT " + start + "," + count;
            return sql;
        }
    }
}
