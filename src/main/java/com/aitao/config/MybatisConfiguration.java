package com.aitao.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by sunyu on 2017/9/2.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.aitao.dao")
public class MybatisConfiguration {
    @Value("${spring.main.datasource.url}")
    private String url;
    @Value("${spring.main.datasource.username}")
    private String user;
    @Value("${spring.main.datasource.password}")
    private String password;

    @Primary
    @Bean
    public DataSource primaryDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Primary
    @Bean
    public DataSourceTransactionManager makeDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Primary
    @Bean
    public SqlSessionFactory makeSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.aitao.domain");
        return sessionFactory.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate makeSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//        try
//        {
//            //2.使用DriverManager获取数据库连接，其中返回的Connection就代表了Java程序和数据库的连接
//            //不同数据库的URL写法需要查看驱动文档，用户名、密码由DBA分配
//            Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zhangzhichengdb?SSL=false","root","123456");
//            //3.使用Connection来创建一个Statement对象
//            Statement stmt=conn.createStatement();
//            //4.执行SQL语句
//            //Statement有三种执行SQL语句的方法
//            ResultSet rs=stmt.executeQuery("select * "+"from tb_user "+"where id=1");
//            while(rs.next())
//            {
//                System.out.println(rs.getString(1));
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}
