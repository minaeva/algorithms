package ua.kiev.minaeva.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AuthorReflection {

    public static void main(String[] args) {
        try {
            Class<?> authorClass = Class.forName("ua.kiev.minaeva.reflection.Author");

            System.out.println("name " + authorClass.getName());

            Constructor<?>[] constructors = authorClass.getConstructors();
            System.out.println("constructors " + Arrays.toString(constructors));


            Method[] methods = authorClass.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            Field[] fields = authorClass.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            Constructor<?> parametrizedConstructor = authorClass.getConstructor(String.class, int.class);
            Object instanceWithValues = parametrizedConstructor.newInstance("Felix", 1980);

            Method getNameMethod = authorClass.getMethod("getName");
            System.out.println("Name of a created author: " + getNameMethod.invoke(instanceWithValues));

            Method getYearMethod = authorClass.getMethod("getYearOfBirth");
            System.out.println("Year of a created author: " + getYearMethod.invoke(instanceWithValues));

            Constructor<?> noArgConstructor = authorClass.getConstructor();
            Object instanceWithoutValues = noArgConstructor.newInstance();

            Field nameField = authorClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(instanceWithoutValues, "John");

            Field yearField = authorClass.getDeclaredField("yearOfBirth");
            yearField.setAccessible(true);
            yearField.set(instanceWithoutValues, 1991);

            System.out.println("Modified name: " + getNameMethod.invoke(instanceWithoutValues));
            System.out.println("Modified year: " + getYearMethod.invoke(instanceWithoutValues));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
