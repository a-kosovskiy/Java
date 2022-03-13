package com.t1.class06.task01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Seller extends User {
    public void viewActiveBuyers(List<Buyer> buyers) {
        String pathName = "src/com/t1/class06/task01/ActiveBuyersExport.csv";
        try {
            File file = new File(pathName);
            try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                buyers.sort(Buyer::compareTo);
                for (Buyer buyer : buyers) {
                    output.write(buyer.toString());
                    output.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
