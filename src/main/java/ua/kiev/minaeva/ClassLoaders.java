package ua.kiev.minaeva;

public class ClassLoaders {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoaders.class.getClassLoader();
        System.out.println("systemClassLoader " + systemClassLoader);

        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println("extensionClassLoader " + extensionClassLoader);

        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        //Bootstrap ClassLoader is represented as null because it is implemented in native code and not in Java
        System.out.println("bootstrapClassLoader " + bootstrapClassLoader);
    }
}
