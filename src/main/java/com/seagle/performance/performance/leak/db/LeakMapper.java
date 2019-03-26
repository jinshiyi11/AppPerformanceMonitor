package com.seagle.performance.performance.leak.db;

import com.seagle.performance.performance.leak.bean.UploadLeakInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LeakMapper {
    @Select("SELECT EXISTS(SELECT 1 FROM leakInfo WHERE key=#{key})")
    boolean exists(@Param("key") String key);

    @Insert("INSERT INTO leakInfo(`key`,stack,blockTime,model,versionName,versionCode) VALUES(" +
            "#{leakInfo.mKey},#{leakInfo.mStackTrace},#{leakInfo.mBlockTime},#{leakInfo.mModel},#{leakInfo.mVersionName},#{leakInfo.mVersionCode})")
    void addBlockInfo(@Param("leakInfo") UploadLeakInfo leakInfo);
}
