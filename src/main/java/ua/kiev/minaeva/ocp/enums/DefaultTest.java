package ua.kiev.minaeva.ocp.enums;

public class DefaultTest {

    enum STATUS {
        PASS, FAIL;
    }

    private static boolean checkStatus(STATUS status) {
        switch(status) {
            case PASS:
                return true;
            case FAIL:
                return false;
            default: {
                assert false : "<<<DANGER ZONE>>>";
                return false;
            }
        }
    }

    public static void main(String[] args) {
//        checkStatus(null); // NullPointerException
//        System.out.println(checkStatus(false)); // won't compile
//        System.out.println(checkStatus("false")); // won't compile
        System.out.println(checkStatus(STATUS.PASS)); // true
    }
}
