package com.th3pu1.ratatouilleapi.controller;


import com.th3pu1.ratatouilleapi.model.RoleRequest;
import com.th3pu1.ratatouilleapi.model.RoleResponse;
import com.th3pu1.ratatouilleapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public List<RoleResponse> listRoles(){
        return roleService.getRoleList();
    }


    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public RoleResponse getRole(@PathVariable Long id){
        Optional<RoleResponse> role = roleService.getRoleDetail(id);
        return role.orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/api/roles", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
    public RoleResponse addRole(@RequestBody RoleRequest request){
        Optional<RoleResponse> role = roleService.addRole(request.getName());

        return role.orElseThrow(ResourceNotFoundException::new);
    }
}
