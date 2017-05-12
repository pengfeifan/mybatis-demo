package com.github.demo.main;

import com.github.demo.mapper.UserModelMapper;
import com.github.demo.model.UserModel;
import com.github.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author williamfan
 */
public class UserGenMain {
    public static void main(String[] args) {
        insertUser(new UserModel(null, "william", "M", "20170111"));
        batchInsert();
    }

    public static void insertUser(UserModel model) {
        SqlSession sqlSession = MybatisUtil.getSessionFactory().openSession();
        //UserModelMapper userDao = sqlSession.getMapper(UserModelMapper.class);
        try {
            sqlSession.insert("com.github.demo.mapper.UserModelMapper.insertSelective", model);
            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
        } finally {
            sqlSession.close();
        }
    }

    public static void batchInsert() {
        SqlSession sqlSession = MybatisUtil.getSessionFactory().openSession();
        UserModelMapper userDao = sqlSession.getMapper(UserModelMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            System.out.println("==================Begin======================");
            for (int i = 0; i < 100; i++) {
                String uid = UUID.randomUUID().toString().substring(0, 5) + i;
                userDao.insertSelective(new UserModel(null, uid, "M", sdf.format(new Date())));
            }
            sqlSession.commit();
            System.out.println("==================Done======================");
        } finally {
            sqlSession.close();
        }
    }
}
