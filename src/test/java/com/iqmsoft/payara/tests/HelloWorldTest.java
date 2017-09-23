package com.iqmsoft.payara.tests;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iqmsoft.payara.tests.HelloWorld;
import com.iqmsoft.payara.tests.Service;

import org.junit.runner.RunWith;





//@RunWith(Arquillian.class)
public class HelloWorldTest extends Arquillian {

    @Inject
    private Service service;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(HelloWorld.class)
                .addClass(Service.class);
                //.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test()
    public void sayHelloTest() {
        HelloWorld helloWorld = new HelloWorld();
        Assert.assertEquals(helloWorld.sayHello(), "Hello Payara");
    }

    @Test()
    public void nomeTest() {
        
        Assert.assertEquals(service.nome(), "task");
    }
}
