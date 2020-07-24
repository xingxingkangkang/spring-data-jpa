package com.example.example1;

import org.springframework.data.repository.CrudRepository;

/**
 * @author A20246
 * @date 2020/7/23
 * @time 17:15
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
