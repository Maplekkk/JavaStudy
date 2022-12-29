package com.maple.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * ClassName:SqlSessionUtil
 * Package: com.maple.mybatis.utils
 * Description:
 * Author maple
 * Create 2022-12-29
 * Version: v1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private SqlSessionUtil(){}

    /**
     *
     * 获取会话对象
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
