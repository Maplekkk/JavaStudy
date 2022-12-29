package com.maple.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * ClassName:MybatisIntroductionTest
 * Package: com.maple.mybatis.test
 * Description:
 * Author maple
 * Create 2022-12-29
 * Version: v1.0
 */
public class MybatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        // 获得sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获得SqlSessionFactory对象
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        // 一般情况下一个数据库对应一个SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        // 返回值是影响数据库的记录条数
        int count = sqlSession.insert("insertCar");
        System.out.println("插入了几条记录: " + count);


        // 手动提交, mybatis不支持自动提交
        sqlSession.commit();
    }
}
