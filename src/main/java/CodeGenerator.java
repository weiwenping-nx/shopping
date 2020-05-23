import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 */
public class CodeGenerator {
    private static final Logger log = LoggerFactory.getLogger(CodeGenerator.class);

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//生成文件的输出目录
        gc.setOpen(false);
        gc.setAuthor("wwp");//开发人员
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        //时间数据类型
        gc.setDateType(DateType.ONLY_DATE);

        //
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        // 数据库 schema name
//         dsc.setSchemaName("public");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("awen");
        dsc.setPassword("123456");
        dsc.setTypeConvert(new OracleTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                System.out.println("字段类型：" + fieldType);
                fieldType = fieldType.toLowerCase();
                //修改数据库和bena的映射类型，只要是number 就改成 int
                if (fieldType.contains("number")) {
                    return DbColumnType.INTEGER;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));//父包模块名
        pc.setParent("com.awen");//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao");
        mpg.setPackageInfo(pc);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setService("");//不输出 service
        templateConfig.setController("");//不输出 controller
//        templateConfig.setServiceImpl("");
//        templateConfig.setEntityKt("");
//        templateConfig.setXml("");
//        templateConfig.setMapper("");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setEntityLombokModel(false);//【实体】是否为lombok模型（默认 false）
        //表名
        //需要包含的表名，允许正则表达式 或者 exclude  二选一
        strategy.setInclude("T_STUDENT_TEST");
        //需要排除的表
//        strategy.setExclude("C_PROD_COMM_PRO","C_PROD_COMM_PRO");
        //strategy.setSuperEntityColumns("id");//自定义基础的Entity类，公共字段
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //配置表前缀 生成的代码名称不带表前缀
        strategy.setTablePrefix("T_");
        mpg.setStrategy(strategy);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);
        mpg.execute();
    }
}
