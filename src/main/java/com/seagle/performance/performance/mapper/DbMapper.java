package com.seagle.performance.performance.mapper;

import com.seagle.performance.performance.entity.BlockInfo;
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
    void addBlockInfo(@Param("blockInfo") BlockInfo blockInfo);

    @SelectProvider(type = SqlBuilder.class, method = "buildBlockInfoListSql")
    @Results({
            @Result(id = true, property = "mId", column = "id"),
            @Result(property = "mStackTrace", column = "stack"),
            @Result(property = "mBlockTime", column = "blockTime"),
            @Result(property = "mInsertTime", column = "insert_time", typeHandler = TimeHandler.class)
    })
    List<BlockInfo> getBlockInfoList(@Param("id") long id, @Param("count") int count);


    class SqlBuilder {
        public String buildBlockInfoListSql(@Param("id") long id, @Param("count") int count) {
            String sql = "SELECT id,stack,blockTime,insert_time FROM blockInfo WHERE";

            sql += " id<" + id + " ORDER BY id DESC LIMIT " + count;
            return sql;
        }
    }
}
