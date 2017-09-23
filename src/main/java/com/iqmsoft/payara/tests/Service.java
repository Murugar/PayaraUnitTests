package com.iqmsoft.payara.tests;

import javax.ejb.Stateless;


@Stateless
public class Service {

    public String nome(){
        return "task";
    }
}
