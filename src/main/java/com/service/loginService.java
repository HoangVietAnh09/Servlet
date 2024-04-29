package com.service;
import com.repository.usesRepository;

import java.util.List;
import com.model.uses;

public class loginService {
    private usesRepository usesrepository = new usesRepository();
    public boolean checkLogin(String username, String password){
        List<uses> list = usesrepository.getUserByUsernameAndPasswd(username, password);
        return list.size() > 0;
    }

}
