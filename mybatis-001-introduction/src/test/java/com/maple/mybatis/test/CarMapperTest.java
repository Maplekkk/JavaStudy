package com.maple.mybatis.test;

import com.maple.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * ClassName:CarMapperTest
 * Package: com.maple.mybatis.test
 * Description:
 * Author maple
 * Create 2022-12-29
 * Version: v1.0
 */
public class CarMapperTest {
    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int insertCar = sqlSession.insert("insertCar");
        System.out.println(insertCar);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 开启会话(底层开启事务)
            sqlSession = sqlSessionFactory.openSession();
            int cnt = sqlSession.insert("insertCar");
            System.out.println(cnt);
            // 执行到这里, 没有发生任何异常就提交事务。
            sqlSession.commit();
        } catch (IOException e) {
            // 回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            // 关闭会话
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
