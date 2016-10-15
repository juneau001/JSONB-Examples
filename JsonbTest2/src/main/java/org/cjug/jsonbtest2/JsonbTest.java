/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cjug.jsonbtest2;

import java.util.ArrayList;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 *
 * @author Juneau
 */
public class JsonbTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Java object and convert to JSON
        System.out.println("Object >> JSON");
        Member member = new Member();
        member.setFirstName("Chicago");
        member.setLastName("JUG");
        Jsonb jsonbobject = JsonbBuilder.create();
        String memberResult = jsonbobject.toJson(member);
        System.out.println(memberResult);
        
        // Create a Java List and Convert to JSON
        System.out.println("Create List >> JSON");
        Member member1 = new Member();
        member1.setFirstName("Josh");
        member1.setLastName("Juneau");
        member1.setEmailAddress("josh.juneau@cjug.org");
        Member member2 = new Member();
        member2.setFirstName("Bob");
        member2.setLastName("Paulin");
        member2.setEmailAddress("bob.paulin@cjug.org");
        List<Member> members = new ArrayList();
        members.add(member1);
        members.add(member2);
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(members);
        System.out.println(result);
        
        System.out.println("Json >> Object");
        List<Member> newMemberList = jsonb.fromJson(result, List.class);
        System.out.println(newMemberList);
        
        System.out.println("Adapter Example");
        
        AdaptedCar car = new AdaptedCar();
        car.distance = 12;
        
        JsonbConfig config = new JsonbConfig();
        config.withAdapters(new CarAdapter());
        Jsonb jsonb2 = JsonbBuilder.newBuilder().withConfig(config).build();
        
        String result2 = jsonb2.toJson(car);
        System.out.println(result2);
    }
    
}
