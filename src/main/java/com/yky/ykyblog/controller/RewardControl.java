package com.yky.ykyblog.controller;


import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.service.RewardService;
import com.yky.ykyblog.utils.DataMap;
import com.yky.ykyblog.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:
 */
@RestController
@Slf4j
public class RewardControl {

    @Autowired
    private RewardService rewardService;

    @PostMapping(value = "/getRewardInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getRewardInfo(){
        try {
            DataMap data = rewardService.getRewardInfo();
            return JsonResult.build(data).toJSON();
        } catch (Exception e){
            log.error("Get reward info exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}
