package com.github.hcsp.encapsulation;

import com.github.hcsp.test.helper.JavaASTReader;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void createValidCat() {
        Cat cat = Cat.newCat("ABC", 0);
        Assertions.assertEquals("ABC", cat.getName());
        Assertions.assertEquals(0, cat.getAge());
    }

    @Test
    public void createInvalidCat() {
        Cat cat1 = Cat.newCat(null, -1);
        Cat cat2 = Cat.newCat("", -1);
        Cat cat3 = Cat.newCat(new String(""), 1);
        Cat cat4 = Cat.newCat(null, 1);
        Assertions.assertTrue(cat1 == cat2);
        Assertions.assertTrue(cat3 == cat2);
        Assertions.assertTrue(cat3 == cat4);
        Assertions.assertEquals("Invalid cat", cat1.getName());
    }

    @Test
    public void noPublicConstructor() {
        Assertions.assertTrue(
                JavaASTReader.findAll(Cat.class, ConstructorDeclaration.class).stream()
                        .noneMatch(ConstructorDeclaration::isPublic));
    }
}
