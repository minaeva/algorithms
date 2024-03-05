package ua.kiev.minaeva.ocp.inner_classes;

public class LocalInnerExample {

}

class OuterToLocal {

    public static void main(String[] args) {
        int a = 43;
//        a++; // cannot be accessed by local
        class Local {
            {
                System.out.println(a);
            }
        }
    }

}
