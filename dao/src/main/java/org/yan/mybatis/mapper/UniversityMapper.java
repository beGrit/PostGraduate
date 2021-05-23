package org.yan.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UniversityMapper {
    String findNameById(Long id);
}
