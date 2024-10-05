package com.example.mega_task.service;

import com.example.mega_task.entities.Owner;
import com.example.mega_task.models.OwnerModel;

public interface OwnerService {

    Owner createOwner(OwnerModel ownerModel);

    Owner getById(Long id);

    Owner updateOwner(OwnerModel ownerModel);

    Owner deleteOwner(OwnerModel ownerModel);

}
