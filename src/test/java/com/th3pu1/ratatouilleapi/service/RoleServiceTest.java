package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.model.RoleResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() throws Exception {
        Optional<RoleResponse> resp = roleService.addRole("test");

        assertTrue(resp.isPresent());
        RoleResponse role = resp.get();
        // Ensure that the output role name match with input
        assertEquals("test", role.getName());
        // Ensure that the returned ID is Long
        assertTrue(role.getId() > 0);
    }

    @Test
    public void getRole() throws Exception{
        Optional<RoleResponse> resp = roleService.getRoleDetail(1L);
        assertTrue(resp.isPresent());

        assertFalse(roleService.getRoleDetail(200L).isPresent());
    }

}