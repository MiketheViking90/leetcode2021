package plaid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview {

    // Cenbral Bank Algo
    // go through each transfer, track each bank's balance for each transfer
    // go thru each bank, get each transfer to A or from A (based on owe or receive)

    private static String CENTRAL_BANK = "A";

    public static List<String> getTransfers(List<String> txns) {
        Map<String, Integer> netBalances = new HashMap<>();
        for (String txn : txns) {
            String fromBank = txn.substring(0, 1);
            String toBank = txn.substring(1, 2);
            int amount = Integer.parseInt(txn.substring(2));

            int fromBalance = netBalances.getOrDefault(fromBank, 0);
            netBalances.put(fromBank, fromBalance - amount);

            int toBalance = netBalances.getOrDefault(toBank, 0);
            netBalances.put(toBank, toBalance + amount);
        }

        List<String> outputs = new ArrayList<>();
        for (String bank : netBalances.keySet()) {
            if (bank.equals(CENTRAL_BANK)) {
                continue;
            }
            int balance = netBalances.get(bank);
            if (balance < 0) {
                String output = bank + CENTRAL_BANK + (-1 * balance);
                outputs.add(output);
            } else if (balance > 0){
                String output = CENTRAL_BANK + bank + balance;
                outputs.add(output);
            }
        }

        return outputs;
    }

    public static List<String> getTransfersPairs(List<String> txns) {
        Map<String, Integer> netBalances = new HashMap<>();
        for (String txn : txns) {
            String fromBank = txn.substring(0, 1);
            String toBank = txn.substring(1, 2);
            String key = (fromBank.compareTo(toBank) < 0) ? fromBank + toBank : toBank + fromBank;
            int amount = Integer.parseInt(txn.substring(2));
            if (!fromBank.equals(key.substring(0, 1))) {
                amount *= -1;
            }

            int curBalance = netBalances.getOrDefault(key, 0);
            netBalances.put(key, curBalance + amount);
        }

        List<String> outputs = new ArrayList<>();
        for (String pair : netBalances.keySet()) {
            int balance = netBalances.get(pair);
            if (balance < 0) {
                balance *= -1;
                String key = new StringBuilder(pair).reverse().toString();
                String output = key + balance;
                outputs.add(output);
            } else if (balance > 0){
                String output = pair + balance;
                outputs.add(output);
            }
        }

        return outputs;
    }

    public static void main(String[] args) {
        List<String> txns = List.of("AB1", "BA2", "BC1");
        List<String> output = getTransfersPairs(txns);
        System.out.println(output);


//        txns = List.of();
//        output = getTransfersPairs(txns);
//        System.out.println(output);
//
//        txns = List.of("AB1", "AC1", "AD1", "AE1");
//        output = getTransfersPairs(txns);
//        System.out.println(output);
//
//        txns = List.of("BC1", "BD1", "BD12", "CA781");
//        output = getTransfersPairs(txns);
//        System.out.println(output);

        // zeros and cycles
        txns = List.of("BC1", "CB1");
        output = getTransfersPairs(txns);
        System.out.println(output);

//
//        txns = List.of("BC1", "CD1", "DB1");
//        output = getTransfersPairs(txns);
//        System.out.println(output);
//
//
//        txns = List.of("BC8", "CD5", "DB3");
//        output = getTransfersPairs(txns);
//        System.out.println(output);


        //"BC6"
        txns = List.of("BC1", "BC3", "BC5", "CB3"); // BC6
        output = getTransfersPairs(txns);
        System.out.println(output);


//        txns = List.of("CD1", "EF3", "GH5", "HG3");
//        output = getTransfersPairs(txns);
//        System.out.println(output);


        //"BC6"
        txns = List.of("AB1", "AC1", "AD1", "BC1", "BD1", "CD1");
        output = getTransfersPairs(txns);
        List<String> output1 = getTransfers(txns);
        System.out.println(output);
        System.out.println(output1);
    }

}
