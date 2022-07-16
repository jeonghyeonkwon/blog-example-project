package com.example.blogproject.aboutjava.controller;

import com.example.blogproject.aboutjava.dto.DefaultObjectDto;
import com.example.blogproject.aboutjava.dto.EqualsDto;
import com.example.blogproject.aboutjava.dto.LombokObjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/java/equals")
public class JavaEqualsController {
    /*
     * equals hashcode 관련 내용 정리
     * */
    @GetMapping("")
    public ResponseEntity equalsAndHashCodes(){
        /*
         * String 비교
         * */

        String str1 = "abc";
        String str2 = "abc";

        String str3 = new String("abc");
        String str4 = new String("abc");

        System.out.println("String 비교");

        System.out.println("str1 hash : " + str1.hashCode());
        System.out.println("str2 hash : " + str2.hashCode());
        System.out.println("str3 hash : " + str3.hashCode());
        System.out.println("str4 hash : " + str4.hashCode());
        System.out.println("str1 == str2 : " + (str1==str2)); // 같다
        System.out.println("str1 == str3 : " + (str1==str3)); // 다르다
        System.out.println("str3 == str4 : " + (str3==str4)); // 다르다
        // 결론 :
        // 1. 4개의 해시코드는 모두 같다.
        // 2. equals는 안해봐도 다 같다
        // 3. new String 으로 생성한 것은 주소가 다르다.
        // 4. 주소값과 hashCode는 연관성이 없다.
        System.out.println();

        /*
         * ----------------- 기본 클래스 비교
         * */
        DefaultObjectDto dDto1 = new DefaultObjectDto("dto1","common",1L);
        DefaultObjectDto dEqualsDto1 = new DefaultObjectDto("dto1","common",1L);
        DefaultObjectDto dDto2 = new DefaultObjectDto("dto2","common",2L);

        System.out.println("***** Default Dto *****");
        // 클래스명@문자 문자는 hashCode를 16진수로 변환한것

        System.out.println(dDto1);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(dDto1.hashCode()));
        System.out.println(dEqualsDto1);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(dEqualsDto1.hashCode()));
        System.out.println(dDto2);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(dDto2.hashCode()));

        // 각 객체는 힙메모리의 서로 다른 객체이므로 해시코드가 다르다 (재정의 해주지 않았을때)
        System.out.println("dto1 hashCode : " + dDto1.hashCode());
        System.out.println("equalsDto1 hashCode : " + dEqualsDto1.hashCode());
        System.out.println("dto2 hashCode : " + dDto2.hashCode());
        System.out.println("dto1 == equalsDto1 : " + (dDto1==dEqualsDto1));
        System.out.println("dto1 == dto2 : " + (dDto1==dDto2));
        System.out.println("dto1.equals(equalsDto1) : " + dDto1.equals(dEqualsDto1));
        System.out.println("dto1.equals(dto2) : " + dDto1.equals(dDto2));

        Set<DefaultObjectDto> dSet = new HashSet<>();
        dSet.add(dDto1);
        dSet.add(dEqualsDto1);
        dSet.add(dDto2);
        Iterator<DefaultObjectDto> dIterator = dSet.iterator();
        while(dIterator.hasNext()){
            DefaultObjectDto next = dIterator.next();
            System.out.printf("default set iterator -> name : %s commonValue : %s number : %d\n" ,next.getName(),next.getCommonValue(),next.getNumber() );
        }

        System.out.println();
        /*
         * ----------------- 롬복 @EqualsAndHashCode 이용하여 비교
         * */
        LombokObjectDto lDto1 = new LombokObjectDto("dto1","common",1L);
        LombokObjectDto lEqualsDto1 = new LombokObjectDto("dto1","common",1L);
        LombokObjectDto lDto2 = new LombokObjectDto("dto2","common",2L);
        System.out.println("***** Lombok Dto *****");
        // 롬복의 @EqualsAndHashCode는 데이터들이 같다면 같은 해시코드를 사용하도록 함
        System.out.println("dto1 hashCode : " + lDto1.hashCode());
        System.out.println("EqualsDto1 hashCode : " + lEqualsDto1.hashCode());
        System.out.println("dto2 hashCode : " + lDto2.hashCode());
        System.out.println("dto1 == lEqualsDto1 : " + (lDto1==lEqualsDto1));
        System.out.println("dto1 == dto2 : " + (lDto1==lDto2));
        System.out.println("dto1.equals(lEqualsDto1) : " + lDto1.equals(lEqualsDto1));
        System.out.println("dto1.equals(dto2) : " + lDto1.equals(lDto2));

        Set<LombokObjectDto> lSet = new HashSet<>();
        lSet.add(lDto1);
        lSet.add(lEqualsDto1);
        lSet.add(lDto2);
        Iterator<LombokObjectDto> lIterator = lSet.iterator();
        while(lIterator.hasNext()){
            LombokObjectDto next = lIterator.next();
            System.out.printf("lombok set iterator -> name : %s commonValue : %s number : %d\n" ,next.getName(),next.getCommonValue(),next.getNumber() );
        }

        System.out.println();

        /*
         * ----------------- equals 재정의 (commonValue만 같으면 같은것으로 취급)
         * */

        EqualsDto eDto1 = new EqualsDto("dto1","common",1L);
        EqualsDto eEqualsDto1 = new EqualsDto("dto1","common",1L);
        EqualsDto eDto2 = new EqualsDto("dto2","common",2L);
        System.out.println("***** Equals Dto *****");

        // 클래스 내부에서 hashCode를 commonValue를 해시코드로 재정의 했으므로 모든 클래스의 해쉬 코드는 같다
        System.out.println(eDto1);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(eDto1.hashCode()));
        System.out.println(eEqualsDto1);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(eEqualsDto1.hashCode()));
        System.out.println(eDto2);
        System.out.println("hashCode 16진수 변환 : " + Integer.toHexString(eDto2.hashCode()));

        System.out.println("dto1 hashCode : " + eDto1.hashCode());
        System.out.println("EqualsDto1 hashCode : " + eEqualsDto1.hashCode());
        System.out.println("dto2 hashCode : " + eDto2.hashCode());
        System.out.println("dto1 == lEqualsDto1 : " + (eDto1==eEqualsDto1));
        System.out.println("dto1 == dto2 : " + (eDto1==eDto2));
        System.out.println("dto1.equals(lEqualsDto1) : " + eDto1.equals(eEqualsDto1));
        System.out.println("dto1.equals(dto2) : " + eDto1.equals(eDto2));


        Set<EqualsDto> eSet = new HashSet<>();
        eSet.add(eDto1);
        eSet.add(eEqualsDto1);
        eSet.add(eDto2);
        Iterator<EqualsDto> eIterator = eSet.iterator();
        while(eIterator.hasNext()){
            EqualsDto next = eIterator.next();
            System.out.printf("equals set iterator -> name : %s commonValue : %s number : %d\n" ,next.getName(),next.getCommonValue(),next.getNumber() );
        }
        System.out.println();

        Set<EqualsDto> dESet = new TreeSet();
        dESet.add(eDto1);
        dESet.add(eEqualsDto1);
        dESet.add(eDto2);
        Iterator<EqualsDto> dEIterator = dESet.iterator();
        while(dEIterator.hasNext()){
            EqualsDto next = dEIterator.next();
            System.out.printf("equals TreeSet iterator -> name : %s commonValue : %s number : %d\n" ,next.getName(),next.getCommonValue(),next.getNumber() );
        }
        System.out.println();
        // 결론 :
        // 해시코드가 같다면 equals는 참이다
        // hashSet 자료구조를 사용하면서 해시코드가 같다면 최근에 들어온 객체가 덮어씌어 진다.
        // treeSet은 hashCode와 연관성이 없다.

        return new ResponseEntity(HttpStatus.OK);

        /* ------------------출력 결과
        *   String 비교
            str1 hash : 96354
            str2 hash : 96354
            str3 hash : 96354
            str4 hash : 96354
            str1 == str2 : true
            str1 == str3 : false
            str3 == str4 : false

            ***** Default Dto *****
            com.example.blogproject.aboutjava.dto.DefaultObjectDto@5d70708d
            hashCode 16진수 변환 : 5d70708d
            com.example.blogproject.aboutjava.dto.DefaultObjectDto@4cfe3243
            hashCode 16진수 변환 : 4cfe3243
            com.example.blogproject.aboutjava.dto.DefaultObjectDto@8762e34
            hashCode 16진수 변환 : 8762e34
            dto1 hashCode : 1567649933
            equalsDto1 hashCode : 1291727427
            dto2 hashCode : 141962804
            dto1 == equalsDto1 : false
            dto1 == dto2 : false
            dto1.equals(equalsDto1) : false
            dto1.equals(dto2) : false
            default set iterator -> name : dto2 commonValue : common number : 2
            default set iterator -> name : dto1 commonValue : common number : 1
            default set iterator -> name : dto1 commonValue : common number : 1

            ***** Lombok Dto *****
            dto1 hashCode : -1172056243
            EqualsDto1 hashCode : -1172056243
            dto2 hashCode : -1172052703
            dto1 == lEqualsDto1 : false
            dto1 == dto2 : false
            dto1.equals(lEqualsDto1) : true
            dto1.equals(dto2) : false
            lombok set iterator -> name : dto2 commonValue : common number : 2
            lombok set iterator -> name : dto1 commonValue : common number : 1

            ***** Equals Dto *****
            com.example.blogproject.aboutjava.dto.EqualsDto@af3f2a0a
            hashCode 16진수 변환 : af3f2a0a
            com.example.blogproject.aboutjava.dto.EqualsDto@af3f2a0a
            hashCode 16진수 변환 : af3f2a0a
            com.example.blogproject.aboutjava.dto.EqualsDto@af3f2a0a
            hashCode 16진수 변환 : af3f2a0a
            dto1 hashCode : -1354814966
            EqualsDto1 hashCode : -1354814966
            dto2 hashCode : -1354814966
            dto1 == lEqualsDto1 : false
            dto1 == dto2 : false
            dto1.equals(lEqualsDto1) : true
            dto1.equals(dto2) : true
            equals set iterator -> name : dto1 commonValue : common number : 1

            equals TreeSet iterator -> name : dto1 commonValue : common number : 1
            equals TreeSet iterator -> name : dto2 commonValue : common number : 2
        *
        *
        * 도움되는 글 : https://okky.kr/article/596050
        * */
    }
}
