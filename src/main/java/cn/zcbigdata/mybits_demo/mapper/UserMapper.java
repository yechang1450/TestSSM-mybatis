package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.User;

import java.util.List;


public interface UserMapper {


    /**
     * 增
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 改
     *
     * @param user
     * @return
     */
    int updatePwd(User user);

    /**
     * 查All
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 查ByName
     *
     * @param userName
     * @return
     */
    User selectByName(String userName);

    /**
     * 查ByTel
     *
     * @param tel
     * @return
     */
    User selectByTel(String tel);
}
