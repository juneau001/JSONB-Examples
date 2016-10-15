/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cjug.jsonbtest2;

import javax.json.bind.adapter.JsonbAdapter;



/**
 *
 * @author Juneau
 */
public class CarAdapter implements JsonbAdapter {
    public AdaptedCar toJson(Car car){
        AdaptedCar adapted = new AdaptedCar();
        adapted.distance = car.distance * 160934;
        return adapted;
    }
    
    public Car toJson(AdaptedCar adapted){
        Car car = new Car();
        car.distance = adapted.distance;
        return car;
    }

    @Override
    public Object adaptToJson(Object b) throws Exception {
        Car car = (Car) b;
        AdaptedCar adapted = new AdaptedCar();
        adapted.distance = car.distance * 160934;
        return adapted;
        
    }

    @Override
    public Object adaptFromJson(Object a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
