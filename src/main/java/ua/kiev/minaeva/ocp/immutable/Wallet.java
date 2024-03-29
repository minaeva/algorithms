package ua.kiev.minaeva.ocp.immutable;

import java.util.Arrays;

public class Wallet {

    final static private int[] wallet = {1, 2, 3};
    public static int[] getWallet() {
        System.out.println(Arrays.toString(wallet));
        return wallet.clone();
    }

}

class WalletTest {

    public static void main(String[] args) {
        int[] result = Wallet.getWallet();
        result[2] = 0;
        Wallet.getWallet();
    }
}