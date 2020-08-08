package com.yky.ykyblog.service.Impl;


import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.mapper.RewardMapper;
import com.yky.ykyblog.model.Reward;
import com.yky.ykyblog.service.RewardService;
import com.yky.ykyblog.utils.DataMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:
 */
@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardMapper rewardMapper;

    @Override
    public DataMap save(Reward reward) {
        rewardMapper.save(reward);
        return DataMap.success(CodeType.ADD_REWARD_SUCCESS)
                .setData(reward.getId());
    }

    @Override
    public DataMap getRewardInfo() {
        List<Reward> rewardList = rewardMapper.getAllReward();
        return DataMap.success().setData(rewardList);
    }

    @Override
    public DataMap deleteReward(int id) {
        rewardMapper.deleteRewardById(id);
        return DataMap.success(CodeType.DELETE_REWARD_SUCCESS);
    }
}
