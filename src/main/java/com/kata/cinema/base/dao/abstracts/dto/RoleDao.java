package com.kata.cinema.base.dao.abstracts.dto;


import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.enums.Roles;


public interface RoleDao extends AbstractDao<Long, Role> {

    Role findByName(Roles name);

}
