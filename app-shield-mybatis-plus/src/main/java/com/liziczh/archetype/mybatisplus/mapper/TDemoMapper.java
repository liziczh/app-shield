package com.liziczh.archetype.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.archetype.api.entity.TDemo;

@Repository
@Mapper
public interface TDemoMapper extends BaseMapper<TDemo> {
}
