package com.codegym.student.service.user;

import com.codegym.student.model.AppUser;
import com.codegym.student.service.IService;

public interface IAppUserService extends IService<AppUser>{
   AppUser getUserByUsername(String username);
}
