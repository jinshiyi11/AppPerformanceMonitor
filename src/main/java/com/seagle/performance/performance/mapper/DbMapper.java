package com.seagle.performance.performance.mapper;

import com.seagle.performance.performance.entity.BlockInfo;
import org.apache.ibatis.annotations.*;

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
}
