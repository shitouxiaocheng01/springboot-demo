package top.xluo.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

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
                    .setSwagger2(true)
                    // 自定义文件命名, %s 会自动填充表实体属性
                    .setEntityName("%sEntity")
                    .setMapperName("%sMapper")
                    .setXmlName("%sMapper")
                    .setServiceName("%sService")
                    .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                    .setDbType(DbType.MYSQL)
                    .setTypeConvert(new MySqlTypeConvert() {
                        @Override
                        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                            System.out.println("转换类型: " + fieldType);
                            if (fieldType.toLowerCase().contains("double")) {
                                return DbColumnType.BASE_LONG;
                            }
                            return super.processTypeConvert(globalConfig, fieldType);
                        }
                    })
                    .setDriverName("com.mysql.jdbc.Driver")
                    .setUsername("dbAdminC")
                    .setPassword("Kenuo123")
                    .setUrl("jdbc:mysql://10.122.81.99:3306/dawn?useUnicode=true&characterEncoding=utf-8&useSSL=false")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
//                    .setCapitalMode(true)   //oracle可以开启
//                    .setTablePrefix(new String[] {"user"})   //修改表前缀
                    .setNaming(NamingStrategy.no_change)
                    .setInclude(new String[] {"person"})    // 需要生成的表
//                    .setExclude(new String[] {"test"})    // 排除生成的表
//                    .setSuperEntityClass("com.xx.xx.XxEntity")    // 自定义实体父类
                    .setSuperEntityColumns(new String[] {"class_id"})    // 自定义公共字段
                    .setSuperMapperClass("com.xx.xx.XxMapper")
                    .setSuperServiceClass("")
                    .setSuperServiceImplClass("")
                    .setEntityLombokModel(true)
                    .setEntityBooleanColumnRemoveIsPrefix(true)
                    .setRestControllerStyle(true)
                    .setControllerMappingHyphenStyle(true)
                    .setEntityTableFieldAnnotationEnable(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                    .setParent("top.xluo.mybatisplus")
                    .setController("controller")  // 默认web
        );
        mpg.execute();
    }
}
