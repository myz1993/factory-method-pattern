package com.github.hcsp.encapsulation;

public class Cat {
    private static final Cat INVALID_CAT = new Cat("Invalid cat", -1);
    private String name;
    private int age;
    
    
    public static Cat newCat(String name, int age) {
        if(age < 0 || name == null || "".equals(name)) {
            // 工厂方法可以在内部很灵活的做一些判空处理等等 本例中如果age小于0或者name是空字符串或者null时 返回预先创建好的INVALID_CAT
            return INVALID_CAT;
        }else {
            return new Cat(name, age);
        }
    }
    
    // 构造器要私有化
    private Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
