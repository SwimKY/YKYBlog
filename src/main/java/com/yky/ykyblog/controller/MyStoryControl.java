package com.yky.ykyblog.controller;


import com.yky.ykyblog.constant.CodeType;
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
 * Describe:
 */
@RestController
@Slf4j
public class MyStoryControl {

    private static final String CATEGORY = "我的故事";

    @Autowired
    ArticleService articleService;

    @GetMapping(value = "/getMyStory", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getMyStory(@RequestParam("rows") int rows,
                                 @RequestParam("pageNum") int pageNum){
        try {
            DataMap data = articleService.findArticleByCategory(CATEGORY, rows, pageNum);
            return JsonResult.build(data).toJSON();
        } catch (Exception e){
            log.error("Get myStory exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}
