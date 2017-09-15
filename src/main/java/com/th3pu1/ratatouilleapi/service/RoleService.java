package com.th3pu1.ratatouilleapi.service;

import com.th3pu1.ratatouilleapi.entity.Role;
import com.th3pu1.ratatouilleapi.model.RoleResponse;
import com.th3pu1.ratatouilleapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by pchaivong on 9/15/2017 AD.
 */

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Returns a role detail in RoleResponse format which included ID.
     * It is optional which mean it could be empty in case of the argument `id`
     * is invalid.
     *
     * @param id a role ID
     * @return role details
     */
    public Optional<RoleResponse> getRoleDetail(Long id){
        Role role = roleRepository.findOne(id);

        return (role == null)? Optional.empty(): serialized(role);
    }


    /**
     * Get all available roles.
     * @return List of all roles
     */
    public List<RoleResponse> getRoleList(){

        ArrayList<RoleResponse> items = new ArrayList<>();

        roleRepository.findAll()
                .forEach(i -> {
                    RoleResponse resp = new RoleResponse();
                    resp.setName(i.getRoleName());
                    resp.setId(i.getId());
                    items.add(resp);
                });

        return items;

    }


    /**
     * Save new rows to data base
     * @param name role name
     * @return information of the created role including the generated ID.
     */
    public Optional<RoleResponse> addRole(String name){
        Role role = new Role();
        role.setRoleName(name);
        Role saved = roleRepository.save(role);

        return serialized(saved);
    }


    /**
     *
     * @param id an ID of role that want to update
     * @param newName desired new name
     * @return a complete role detail of the new updated role
     */
    public Optional<RoleResponse> updateRole(Long id, String newName){
        Role query = roleRepository.findOne(id);
        if (query == null) // Not found
            return Optional.empty();

        query.setRoleName(newName);

        Role saved = roleRepository.save(query);
        return serialized(saved);
    }


    /**
     * Delete role with specific id
     * @param id an ID of the role that want to delete
     */
    public void deleteRole(Long id){
        roleRepository.delete(id);
    }


    /**
     * Serialized between Role entity and RoleResponse
     * @param role role object which will be materialized (serialised)
     * @return RoleResponse object. It is optional which can be empty.
     */
    private Optional<RoleResponse> serialized(Role role){
        if (role.getClass() != Role.class)
            return Optional.empty();

        RoleResponse resp = new RoleResponse();
        resp.setId(role.getId());
        resp.setName(role.getRoleName());

        return Optional.of(resp);
    }
}
