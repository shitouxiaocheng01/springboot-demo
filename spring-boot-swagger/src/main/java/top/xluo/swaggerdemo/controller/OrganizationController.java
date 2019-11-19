package top.xluo.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import top.xluo.swaggerdemo.entity.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lingyi
 * @Date 2019/11/18
 * @Description TODO
 **/
@RestController
@RequestMapping("/organization")
@Api(tags = "组织相关操作")
public class OrganizationController {

    @ApiOperation("新增组织")
    @PostMapping("/addOrganization")
    public String addOrganization(@RequestBody Organization organization) {
        System.out.println(organization);
        return "新增成功！";
    }

    @ApiOperation("获取组织列表")
    @GetMapping("/getOrganizationList")
    public List<Organization> getOrganizationList() {
        List<Organization> list = new ArrayList<>();
        Organization organization = new Organization("1", "家庭", "这是一个家庭");
        list.add(organization);
        return list;
    }

    @ApiOperation("根据id删除组织")
    @GetMapping("/deleteById")
    public String deleteById(@ApiParam(value = "用户id")@RequestParam(value = "id", required = true)String id) {
        return "删除成功！";
    }
}
