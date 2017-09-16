package com.th3pu1.ratatouilleapi.controller;


import com.th3pu1.ratatouilleapi.model.RoleRequest;
import com.th3pu1.ratatouilleapi.model.RoleResponse;
import com.th3pu1.ratatouilleapi.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public List<RoleResponse> listRoles(){
        logger.debug("listRoles called");
        return roleService.getRoleList();
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public RoleResponse getRole(@PathVariable Long id){
        logger.debug("getRole called with id: {}", id);
        Optional<RoleResponse> role = roleService.getRoleDetail(id);
        return role.orElseThrow(ResourceNotFoundException::new);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/roles", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
    public RoleResponse addRole(@RequestBody RoleRequest request){
        logger.debug("addRole caleed with request: {}" , request.toString());
        Optional<RoleResponse> role = roleService.addRole(request.getName());
        return role.orElseThrow(ResourceNotFoundException::new);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id){
        logger.debug("deleteRole called with id: {}", id);
        roleService.deleteRole(id);
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public RoleResponse updateRole(@RequestBody RoleRequest request,
                                   @PathVariable Long id){

        logger.debug("updateRole called with id: {}, request: {}", id, request);
        return roleService.updateRole(id, request.getName())
                .orElseThrow(ResourceNotFoundException::new);
    }
}
