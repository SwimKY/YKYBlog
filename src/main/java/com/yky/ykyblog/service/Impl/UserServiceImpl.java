package com.yky.ykyblog.service.Impl;

import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.constant.RoleConstant;
import com.yky.ykyblog.mapper.UserMapper;
import com.yky.ykyblog.model.User;
import com.yky.ykyblog.service.UserService;
import com.yky.ykyblog.utils.DataMap;
import com.yky.ykyblog.utils.OSSUtils;
import com.yky.ykyblog.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //通过手机号查找注册用户
    @Override
    public User findUserByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        return userMapper.findUserByPhone(phone);
    }

    //通过id查找用户名
    @Override
    public String findUsernameById(int id) {
        return userMapper.findUsernameById(id);
    }

    //注册用户
    @Override
    public DataMap insert(User user) {
        //修改用户名取出空格
        user.setUsername(user.getUsername().trim().replaceAll(" ", StringUtil.BLANK));
        String username = user.getUsername();
        //用户名长度进行限制35
        if (username.length() > StringUtil.USERNAME_MAX_LENGTH || StringUtil.BLANK.equals(username)) {
            return DataMap.fail(CodeType.USERNAME_FORMAT_ERROR);
        }
        if (userIsExist(user.getPhone())) {
            return DataMap.fail(CodeType.PHONE_EXIST);
        }
        //设置默认头像
        if (StringUtil.USERNAME_GENDER.equals(user.getGender())) {
            user.setAvatarImgUrl(OSSUtils.MALE_IMAGE);
        } else {
            user.setAvatarImgUrl(OSSUtils.FEMALE_IMAGE);
        }
        userMapper.save(user);
        int userId = userMapper.findUserIdByPhone(user.getPhone());
        insertRole(userId, RoleConstant.ROLE_USER);
        return DataMap.success();
    }

    //通过手机号查找用户id
    @Override
    public int findUserIdByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return 0;
        }
        return userMapper.findUserIdByPhone(phone);
    }

    //通过手机号修改密码
    @Override
    public void updatePasswordByPhone(String phone, String password) {
        userMapper.updatePassword(phone, password);
        //密码修改成功后注销当前用户
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    //通过用户名获得手机号
    @Override
    public String findPhoneByUsername(String username) {
        return userMapper.findPhoneByUsername(username);
    }

    //通过用户名查找id
    @Override
    public int findIdByUsername(String username) {
        return userMapper.findIdByUsername(username);
    }

    //通过手机号查找用户名
    @Override
    public User findUsernameByPhone(String phone) {
        return userMapper.findUsernameByPhone(phone);
    }

    //更新最近登录时间
    @Override
    public void updateRecentlyLanded(String username, String recentlyLanded) {
        String phone = userMapper.findPhoneByUsername(username);
        userMapper.updateRecentlyLanded(phone, recentlyLanded);
    }

    //判断用户名是否存在
    @Override
    public boolean usernameIsExist(String username) {
        User user = userMapper.findUsernameByUsername(username);
        return user != null;
    }

    //通过手机号判断是否为超级用户
    @Override
    public boolean isSuperAdmin(String phone) {
        int userId = userMapper.findUserIdByPhone(phone);
        List<Object> roleIds = userMapper.findRoleIdByUserId(userId);

        for (Object i : roleIds) {
            if ((int) i == 3) {
                return true;
            }
        }
        return false;
    }

    //更改头像
    @Override
    public void updateAvatarImgUrlById(String avatarImgUrl, int id) {
        userMapper.updateAvatarImgUrlById(avatarImgUrl, id);
    }

    //获得头像url
    @Override
    public DataMap getHeadPortraitUrl(int id) {
        String avatarImgUrl = userMapper.getHeadPortraitUrl(id);
        return DataMap.success().setData(avatarImgUrl);
    }

    //获得用户个人信息
    @Override
    public DataMap getUserPersonalInfoByUsername(String username) {
        User user = userMapper.getUserPersonalInfoByUsername(username);
        return DataMap.success().setData(user);
    }

    //保存用户个人信息
    @Override
    public DataMap savePersonalDate(User user, String username) {

        user.setUsername(user.getUsername().trim().replaceAll(" ", StringUtil.BLANK));
        String newName = user.getUsername();
        if (newName.length() > StringUtil.USERNAME_MAX_LENGTH) {
            return DataMap.fail(CodeType.USERNAME_TOO_LANG);
        } else if (StringUtil.BLANK.equals(newName)) {
            return DataMap.fail(CodeType.USERNAME_BLANK);
        }

        int status;
        //改了昵称
        if (!newName.equals(username)) {
            if (usernameIsExist(newName)) {
                return DataMap.fail(CodeType.USERNAME_EXIST);
            }
            status = CodeType.HAS_MODIFY_USERNAME.getCode();
            //注销当前登录用户
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        //没改昵称
        else {
            status = CodeType.NOT_MODIFY_USERNAME.getCode();
        }
        userMapper.savePersonalDate(user, username);
        return DataMap.success(status);
    }

    //获得用户头像的地址
    @Override
    public String getHeadPortraitUrlByUserId(int userId) {
        return userMapper.getHeadPortraitUrl(userId);
    }

    //统计总用户量
    @Override
    public int countUserNum() {
        return userMapper.countUserNum();
    }

    /**
     * 增加用户权限
     *
     * @param userId 用户id
     * @param roleId 权限id
     */
    private void insertRole(int userId, int roleId) {
        userMapper.saveRole(userId, roleId);
    }

    /**
     * 通过手机号判断用户是否存在
     *
     * @param phone 手机号
     * @return true--存在  false--不存在
     */
    private boolean userIsExist(String phone) {
        User user = userMapper.findUserByPhone(phone);
        return user != null;
    }
}
