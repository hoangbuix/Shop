package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.RoleEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.entity.UserRoleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements RowMapper<UserRoleEntity> {
    @Override
    public UserRoleEntity mapRow(ResultSet resultSet) {
        try {
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setId(resultSet.getInt("id"));
            try {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                userRole.setUsers(user);
                RoleEntity role = new RoleEntity();
                role.setId(resultSet.getInt("id"));
                userRole.setRoles(role);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            userRole.setActiveFlag(resultSet.getInt("active_flag"));
            userRole.setCreatedDate(resultSet.getDate("created_date"));
            userRole.setUpdatedDate(resultSet.getDate("updated_date"));
            return userRole;
        } catch (SQLException e) {
            return null;
        }
    }
}
