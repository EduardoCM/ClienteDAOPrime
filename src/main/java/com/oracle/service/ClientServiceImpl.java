package com.oracle.service;

import javax.ejb.Stateless;


@Stateless
public class ClientServiceImpl implements ClienteService{

    @Override
    public void clientService() {
        
        for(int x = 0; x <= 1000; x++){
            System.out.println("::: " + x);
        }
    }

    
}
