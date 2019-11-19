package top.xluo.swaggerdemo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Lingyi
 * @Date 2019/11/18
 * @Description TODO
 **/
@Data
public class Organization {

    @ApiModelProperty("组织id")
    private String id;

    @ApiModelProperty("组织名")
    private String name;

    @ApiModelProperty("组织描述")
    private String desc;

    public Organization() {
    }

    public Organization(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
}
