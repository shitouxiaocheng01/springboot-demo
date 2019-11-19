package top.xluo.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import top.xluo.swaggerdemo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lingyi
 * @Date 2019/11/18
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关操作")
public class UserController {

    @ApiOperation("新增用户")
    @PostMapping("/addUser")
    public String addUser(@ApiParam(value = "用户实体", required = true)@RequestBody User user) {
        System.out.println(user);
        return "新增成功！";
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/getUserList")
    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        User user = new User("1", "张三", 18);
        list.add(user);
        return list;
    }

    @ApiOperation("根据id删除用户")
    @GetMapping("/deleteById")
    public String deleteById(@ApiParam(value = "用户id", required = true) @RequestParam(value = "id", required = true)String id) {
        return "删除成功！";
    }

    @ApiOperation("根据id更新用户")
    @GetMapping("/updateUserById")
    public String updateUserById(@ApiParam(value = "用户id", required = true)@RequestParam(value = "id", required = true)String id,
                                 @ApiParam(value = "用户实体", required = true)@RequestBody User user) {
        return "更新成功！";
    }
}
