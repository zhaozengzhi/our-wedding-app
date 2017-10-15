package cn.zhaozengzhi.wedding.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 数据库基础配置
 * Created by zhaozengzhi on 2017/8/25.
 */
@Configuration
@EnableAutoConfiguration
@MapperScan("cn.zhaozengzhi.wedding.dao")
public class DatasourceConfiguration
{
    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.maxActive}")
    private int maxActive;

    @Value("${jdbc.maxIdle}")
    private int maxIdle;

    @Value("${jdbc.maxWait}")
    private int maxWait;

    @Value("${jdbc.minIdle}")
    private int minIdle;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() throws SQLException
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setValidationQueryTimeout(-1);
        dataSource.setLogAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(1800);
        dataSource.setRemoveAbandoned(true);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setFilters("stat,log4j2,config");

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException, SQLException
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mapper/*.xml";
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.zhaozengzhi.wedding.model");
        return sqlSessionFactoryBean;
    }
}
