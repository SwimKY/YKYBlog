package com.yky.ykyblog.service.Impl;

import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.mapper.TagMapper;
import com.yky.ykyblog.model.Tag;
import com.yky.ykyblog.service.TagService;
import com.yky.ykyblog.utils.DataMap;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public void addTags(String[] tags, int tagSize) {
        for (String tag : tags) {
            if (tagMapper.findIsExistByTagName(tag) == 0) {
                Tag t = new Tag(tag, tagSize);
                tagMapper.save(t);
            }
        }
    }

    //加mapper加入redis缓存设置 --todo--可以修改service返回逻辑，在service进行缓存设置
    @Override
    public DataMap findTagsCloud() {
        List<Tag> tags = tagMapper.findTagsCloud();
        Map<String, Object> dataMap = new HashMap<>(2);
        dataMap.put("result", JSONArray.fromObject(tags));
        dataMap.put("tagsNum", tags.size());
        return DataMap.success(CodeType.FIND_TAGS_CLOUD).setData(dataMap);
    }

    @Override
    public int countTagsNum() {
        return tagMapper.countTagsNum();
    }

    @Override
    public int getTagsSizeByTagName(String tagName) {
        return tagMapper.getTagsSizeByTagName(tagName);
    }
}
