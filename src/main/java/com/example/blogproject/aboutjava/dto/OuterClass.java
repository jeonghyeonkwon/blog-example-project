package com.example.blogproject.aboutjava.dto;

import lombok.ToString;

@ToString
public class OuterClass {
    private static String staticOuterField = "staticOuterField";

    private String outerField;

    public OuterClass(String outerField){

        this.outerField = outerField;

//        InnerClass.print("OuterClass","finalOuterField",this.staticOuterField);
//        InnerClass.print("OuterClass","outerField",this.outerField);
//        InnerClass.print("OuterClass","staticInnerField", staticInnerField);
//        InnerClass.print("finalOuterField","innerField",innerField);

        StaticInnerClass.staticPrint("OuterClass","finalOuterField",this.staticOuterField);
        StaticInnerClass.staticPrint("OuterClass","outerField",this.outerField);
        StaticInnerClass.staticPrint("OuterClass","staticInnerField", StaticInnerClass.staticInnerField);
//        StaticInnerClass.print("finalOuterField","innerField",innerField); //컴파일 요류
    }
    /*

    * https://www.youtube.com/watch?v=C6CczyrkYXU&t=902s
    * innerClass로 선언하면 outerClass에 모든 값들을 참조 할 수 있으므로 의존성이 강해진다
    * innerClass 역할이 끝나고 gc가 제 역할을 수행하지 못함
    * */
    @ToString
    public class InnerClass{
        private  String defaultInnerField = "defaultInnerField";
        private String innerField;
        public InnerClass(String innerField){
            this.innerField = innerField;
            print("InnerClass","staticOuterField",staticOuterField);
            print("InnerClass","outerField",outerField);
            print("InnerClass","defaultInnerField",this.defaultInnerField);
            print("InnerClass","innerField",this.innerField);
        }
        public void print(String className,String fieldName,String fieldValue){
            System.out.printf("className= %s fieldName= %s fieldValue= %s\n",className,fieldName,fieldValue);
        }
    }
    /*
    *
    * 만약 static 클래스로 선언한것이 외부 인스턴스를 참조하지 않는다면
    * 임시적 참조를 유지하지 않는다
    * */
    @ToString
    public static class StaticInnerClass{
        private static String staticInnerField = "staticInnerField";
        private String innerField;
        public StaticInnerClass(String innerField){
            this.innerField = innerField;
            staticPrint("staticInnerClass","finalOuterField",staticOuterField);
//            staticPrint("staticInnerClass","outerField",outerField); //컴파일 오류
            staticPrint("staticInnerClass","staticInnerField",this.staticInnerField);
            staticPrint("staticInnerClass","innerField",this.innerField);
        }
        public static void staticPrint(String className,String fieldName,String fieldValue){

            System.out.printf("className= %s fieldName= %s fieldValue= %s\n",className,fieldName,fieldValue);
        }
    }

}