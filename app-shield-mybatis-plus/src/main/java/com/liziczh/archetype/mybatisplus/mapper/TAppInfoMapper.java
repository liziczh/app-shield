package com.liziczh.archetype.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.archetype.api.entity.TAppInfo;

@Repository
@Mapper
public interface TAppInfoMapper extends BaseMapper<TAppInfo> {
}
