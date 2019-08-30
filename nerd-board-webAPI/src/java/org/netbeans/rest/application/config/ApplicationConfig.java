/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mathe
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(controller.CategoriaController.class);
        resources.add(controller.CategoriaJogoController.class);
        resources.add(controller.ClienteController.class);
        resources.add(controller.JogoController.class);
        resources.add(controller.PedidoController.class);
        resources.add(controller.PedidoJogoController.class);
        resources.add(controller.ReservaController.class);
        resources.add(controller.ReservaJogoController.class);
    }
    
}
