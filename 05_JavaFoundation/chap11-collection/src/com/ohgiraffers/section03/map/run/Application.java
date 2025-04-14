package com.ohgiraffers.section03.map.run;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        /** HashMap을 이용하고 활용할 수 있다. */
        HashMap hmap = new HashMap();

        /** 키와 값을 쌍으로 저장한다.
         * 키와 값은 반드시 객체여야한다. */

        hmap.put("one", new Date());
        hmap.put(12, "red apple");
        hmap.put(33, 123);

        System.out.println("hmap: " + hmap);

        /** 키 값은 중복 저장할 수 없다. 새로운 값으로 덮어쓰기 된다. */
        hmap.put(12, "yellow banana");
        System.out.println("hmap: " + hmap);

        /** 값 객체는 중복 저장할 수 있다. */
        hmap.put(9, "yellow banana");
        System.out.println("hmap: " + hmap);

        /** 값 객체의 내용을 가져올 때 */
        System.out.println("키 9에 대한 객체: " + hmap.get(9));

        /** 키 값을 가지고 삭제 */
        hmap.remove(9);
        System.out.println("hmap: " + hmap);

        /** 문자열 키와 문자열 값을 가지는 HashMap 생성 */
        HashMap<String, String> hmap2 = new HashMap<>();

        hmap2.put("one", "java");
        hmap2.put("two", "mysql");
        hmap2.put("three", "jdbc");
        hmap2.put("four", "html");
        hmap2.put("five", "css");


        /** KeySet()을 이용해 Key만 따로 set으로 */
        Iterator<String> keyIter = hmap2.keySet().iterator();

        while (keyIter.hasNext())
        {
            String key = keyIter.next();
            String value = hmap2.get(key);
            System.out.println(key + " = " + value);
        }

        /** Iterator대신 향상된 for문 사용 */
        System.out.println("=== 향상된 for문 사용 ===");
        for (String key : hmap2.keySet())
        {
            System.out.println(key + " = " + hmap2.get(key));
        }

        /** 저장 된 value 객체들만 values()로 Collection으로 만든 뒤 iterator로 값에 대한 목록을 만든다. */
        Collection<String> values = hmap2.values();
        Iterator<String> valueIter = values.iterator();

        while(valueIter.hasNext())
        {
            System.out.println("value: " + valueIter.next());
        }

        System.out.println("=== 향상된 for문으로 value값 조회 ===");
        for (String value : hmap2.values())
        {
            System.out.println("value: " + value);
        }

        /** Map의 내부 클래스인 EntrySet을 이용: entrySet() */
        Set<Map.Entry<String, String>> set = hmap2.entrySet(); // 키와 값 모두를 반환하는 entrySet
        Iterator<Map.Entry<String, String>> entryIter = set.iterator();

        while(entryIter.hasNext())
        {
            Map.Entry<String, String> entry = entryIter.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("=== Iterator 대신 향상된 for문 사용 ===");
        for (Map.Entry<String, String> entry : hmap2.entrySet())
        {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
