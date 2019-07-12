package quartz.task.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quartz.task.config.properties.DruidProperties;

import javax.sql.DataSource;

/**
 * 数据库连接池配置
 *
 * @author hejq
 * @date 2019/7/12 17:15
 */
@Configuration
public class DruidConfig {
    @Bean
    public DataSource masterDataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

}
