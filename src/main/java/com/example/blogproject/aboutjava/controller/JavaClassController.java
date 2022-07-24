package com.example.blogproject.aboutjava.controller;

import com.example.blogproject.aboutjava.dto.OuterClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/java/class")
public class JavaClassController {
    @GetMapping("/outer-class")
    public ResponseEntity outerClassTest(){
        OuterClass outerClass = new OuterClass("outerClassTest");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("innerClassTest");
        controllerPrint("innerClass",innerClass);
        innerClass.print("controller","controller","컨트롤러에서 method 호출");
//        OuterClass.InnerClass("innerClassTest");
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass("staticInnerClass");
        controllerPrint("staticInnerClass",staticInnerClass);
        return new ResponseEntity(HttpStatus.OK);
        /*
        *
        * className= OuterClass fieldName= finalOuterField fieldValue= staticOuterField
        * className= OuterClass fieldName= outerField fieldValue= outerClassTest
        * className= OuterClass fieldName= staticInnerField fieldValue= staticInnerField
        * className= InnerClass fieldName= staticOuterField fieldValue= staticOuterField
        * className= InnerClass fieldName= outerField fieldValue= outerClassTest
        * className= InnerClass fieldName= defaultInnerField fieldValue= defaultInnerField
        * className= InnerClass fieldName= innerField fieldValue= innerClassTest
        * ---------------innerClass---------------
        * OuterClass.InnerClass(defaultInnerField=defaultInnerField, innerField=innerClassTest)
        * className= controller fieldName= controller fieldValue= 컨트롤러에서 method 호출
        * className= staticInnerClass fieldName= finalOuterField fieldValue= staticOuterField
        * className= staticInnerClass fieldName= staticInnerField fieldValue= staticInnerField
        * className= staticInnerClass fieldName= innerField fieldValue= staticInnerClass
        * ---------------staticInnerClass---------------
        * OuterClass.StaticInnerClass(innerField=staticInnerClass)
        * */
    }
    @PostMapping("/outer-class")
    public ResponseEntity requestOuterClass(@RequestBody OuterClass outerClass){
        return new ResponseEntity(HttpStatus.OK);
    }

    public void controllerPrint(String fieldName,Object obj){
        System.out.println("---------------"+fieldName+"---------------");
        System.out.println(obj);
    }



}
