package top.xluo.swaggerdemo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Lingyi
 * @Date 2019/11/18
 * @Description TODO
 **/
@Data
public class User {

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("用户年龄")
    private int age;

    public User() { }

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
