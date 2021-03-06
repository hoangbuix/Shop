package com.hoangbui.shopping.model.mapper;


import com.hoangbui.shopping.entity.RoleEntity;
import com.hoangbui.shopping.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Objects;

public class UserMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet) {
        try {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAvatar(resultSet.getString("avatar"));
            user.setUsername(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setActiveCode(resultSet.getString("active_code"));
            user.setActiveFlag(resultSet.getInt("active_flag"));
            user.setCreatedDate(resultSet.getDate("created_date"));
            user.setUpdatedDate(resultSet.getDate("updated_date"));
            try {
                if (!Objects.equals(resultSet.getString("role_name"), "")) {
                    RoleEntity role = new RoleEntity();
                    role.setRoleName(resultSet.getString("role_name"));
                    user.setRoles(Collections.singleton(role));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
