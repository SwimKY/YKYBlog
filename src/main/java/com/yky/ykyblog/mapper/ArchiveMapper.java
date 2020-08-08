package com.yky.ykyblog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 归档sql
 */
@Repository
@Mapper
public interface ArchiveMapper {

    @Select("select archiveName from archives order by id desc")
    List<String> findArchives();

    @Insert("insert into archives(archiveName) values(#{archiveName})")
    void save(@Param("archiveName") String archiveName);

    @Select("select IFNULL(max(id),0) from archives where archiveName=#{archiveName}")
    int findArchiveNameByArchiveName(@Param("archiveName") String archiveName);

}
