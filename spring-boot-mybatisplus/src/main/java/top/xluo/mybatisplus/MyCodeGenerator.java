package top.xluo.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lingyi
 * @Date 2019/12/13
 * @Description mybatis-plus代码生成器
 **/
public class MyCodeGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        // 全局配置 (给出常用配置,字段释义看源码)
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("ethon灬羅");
        gc.setOutputDir("E:\\springboot-demo\\spring-boot-mybatisplus\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true);
        // 自定义文件命名, %s 会自动填充表实体属性
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
                @Override
                public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                    System.out.println("转换类型: " + fieldType);
                    if (fieldType.toLowerCase().contains("double")) {
                        return DbColumnType.BASE_LONG;
                    }
                    return super.processTypeConvert(globalConfig, fieldType);
                }
            });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("dbAdminC");
        dsc.setPassword("Kenuo123");
        dsc.setUrl("jdbc:mysql://10.122.81.99:3306/dawn?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig sc = new StrategyConfig();
//        sc.setCapitalMode(true);   //oracle可以开启
//        sc.setTablePrefix(new String[] {"user"});   //修改表前缀
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setInclude(new String[] {"person", "user_role"});    // 需要生成的表
//        sc.setExclude(new String[] {"test"});    // 排除生成的表
//        sc.setSuperEntityClass("com.xx.xx.XxEntity");    // 自定义实体父类
        sc.setSuperEntityColumns(new String[] {"class_id"});   // 自定义公共字段
//        sc.setSuperMapperClass("com.xx.xx.XxMapper");
//        sc.setSuperServiceClass("");
//        sc.setSuperServiceImplClass("");
        sc.setEntityLombokModel(true);
        sc.setEntityBooleanColumnRemoveIsPrefix(true);
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);
        sc.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(sc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("top.xluo.mybatisplus");
        pc.setController("controller");  // 默认web
        mpg.setPackageInfo(pc);


        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {  // 方法内容可以啥都不写
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return "E:/springboot-demo/spring-boot-mybatisplus/src/main/resources/mapper/" +
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        mpg.execute();
    }
}
