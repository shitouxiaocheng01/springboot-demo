package top.xluo.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;

/**
 * @Author Lingyi
 * @Date 2019/12/13
 * @Description mybatis-plus代码生成器
 **/
public class MyCodeGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置 (给出常用配置,字段释义看源码)
                new GlobalConfig()
                    .setAuthor("ethon灬羅")
                    .setOutputDir("E:\\springboot-demo\\spring-boot-mybatisplus\\src\\main\\java")
                    .setFileOverride(true)
                    .setActiveRecord(true)
                    .setEnableCache(false)
                    .setBaseResultMap(true)
                    .setBaseColumnList(true)
                    // 自定义文件命名, %s 会自动填充表实体属性
                    .setEntityName("%sEntity")
                    .setMapperName("%sMapper")
                    .setXmlName("%sMapper")
                    .setServiceName("%sService")
                    .setControllerName("%sController")
        ).setDataSource(
                new DataSourceConfig()
                    .setDbType(DbType.MYSQL)
                    .setTypeConvert(new MySqlTypeConvert() {
                    })
        );
    }
}
