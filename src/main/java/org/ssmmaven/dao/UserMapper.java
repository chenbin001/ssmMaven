package org.ssmmaven.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.ssmmaven.bean.User;

@Repository
public interface UserMapper {

    User checkLogin(@Param(value = "userName") String userName, @Param(value = "password") String password);
}
