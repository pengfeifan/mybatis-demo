package com.github.demo.main;

import com.alibaba.fastjson.JSON;
import com.github.demo.mapper.UserModelMapper;
import com.github.demo.model.UserModel;
import com.github.demo.util.HttpUtil;
import com.github.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author williamfan
 */
public class MainDemo {

    public static void main(String[] args) {
        // Pagination
        SqlSession sqlSession = MybatisUtil.getSessionFactory().openSession();
        UserModelMapper userDao = sqlSession.getMapper(UserModelMapper.class);
        try {
            List<UserModel> list = userDao.selectAllWithPagination(0, 10);
            for (UserModel user : list) {
                System.out.println(JSON.toJSONString(user));
            }
        } finally {
            sqlSession.close();
        }

    }

    public static void sendReq() {
        Map params = new HashMap<String, String>();

        params.put("function", "listPagination");
        params.put("args", "{\"offset\":\"0\"}");

        String result = HttpUtil.requestJson("http://localhost:8081/list", JSON.toJSONString(params));
        System.out.println(result);
    }


}
