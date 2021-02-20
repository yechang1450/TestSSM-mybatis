package cn.zcbigdata.mybits_demo.controller;


import cn.zcbigdata.mybits_demo.entity.User;
import cn.zcbigdata.mybits_demo.service.UserService;
import cn.zcbigdata.mybits_demo.util.ObjtoLayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 增
     */
    @RequestMapping(value = "insert/acc={acc}&&pwd={password}&&tel={tel}")
    public void insert(@PathVariable String acc, @PathVariable String password, @PathVariable long tel) {
        User user = new User();
        user.setUserName(acc);
        user.setPassWord(password);
        user.setTel(tel);
        user.setRealName("user");
        userService.insert(user);
        System.out.println("注册成功");
    }

    /**
     * selectAll
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectAll", produces = "text/json;charset=utf-8")
    public String selectAll() throws Exception {
        List<User> allData = userService.selectAll();
        String[] all = {"id", "userName", "passWord", "realName", "tel"};
        String data = ObjtoLayJson.ListtoJson(allData, all);
        System.out.println(data);
        return data;
    }

    /**
     * 查ByUserName
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "selectByName/acc={userName}", produces = "text/json;charset=utf-8")
    public String selectByName(@PathVariable String userName) {
        System.out.println(userService.selectByName(userName).toString());
        return userService.selectByName(userName).toString();
    }

    /**
     * 查ByUserName
     *
     * @param tel
     * @return
     */
    @RequestMapping(value = "selectByTel/tel={tel}", produces = "text/json;charset=utf-8")
    public String selectByTel(@PathVariable String tel) {
        System.out.println(userService.selectByTel(tel).toString());
        return userService.selectByTel(tel).toString();
    }

    /**
     * 改
     */
    @RequestMapping(value = "updatePwd/acc={acc}&&pwd={password}")
    public void updatePwd(@PathVariable String acc, @PathVariable String password) {
        User user = new User();
        user.setUserName(acc);
        user.setPassWord(password);
        userService.updatePwd(user);
        System.out.println("密码修改成功");
    }
}
