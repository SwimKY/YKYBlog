package com.yky.ykyblog.controller;


import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.service.ArchiveService;
import com.yky.ykyblog.service.ArticleService;
import com.yky.ykyblog.utils.DataMap;
import com.yky.ykyblog.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe: 归档
 */
@RestController
@Slf4j
public class ArchivesControl {

    @Autowired
    ArchiveService archiveService;
    @Autowired
    ArticleService articleService;

    /**
     * 获得所有归档日期以及每个归档日期的文章数目
     * @return
     */
    @GetMapping(value = "/findArchiveNameAndArticleNum")
    public String findArchiveNameAndArticleNum(){
        try {
            DataMap data = archiveService.findArchiveNameAndArticleNum();
            return JsonResult.build(data).toJSON();
        } catch (Exception e){
            log.error("Find archive name and article num exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

    /**
     * 分页获得该归档日期下的文章
     */
    @GetMapping(value = "/getArchiveArticle", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getArchiveArticle(@RequestParam("archive") String archive,
                                        @RequestParam("rows") int rows,
                                        @RequestParam("pageNum") int pageNum){
        try {
            DataMap data = articleService.findArticleByArchive(archive, rows, pageNum);
            return JsonResult.build(data).toJSON();
        } catch (Exception e){
            log.error("Get archive article [{}] exception", archive, e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }
}
