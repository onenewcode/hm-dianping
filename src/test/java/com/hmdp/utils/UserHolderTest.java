package com.hmdp.utils;

import com.hmdp.dto.UserDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserHolderTest {

    @Test
    void saveUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void removeUser() {
    }

    @BeforeEach
    void init() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(2333333L);
        userDTO.setIcon("FDscx");
        userDTO.setNickName("fdsfsd");

        UserHolder.saveUser(userDTO);
    }

    @Test
    void oo() {
        System.out.println(UserHolder.getUser());
    }
}