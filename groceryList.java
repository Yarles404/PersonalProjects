package pack1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class groceryList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> Ingredients = new ArrayList<String>();
        ArrayList<Integer> Number = new ArrayList<Integer>();

        int index = 0;

        while (true) {
            System.out.println("Enter an ingredient for your groceries. Make sure repeats have the same name.");
            String addMe = in.next();
            addMe = addMe.toLowerCase();
            if (addMe.equals("Done")) break;

            if (Ingredients.contains(addMe)) {
                index = Ingredients.indexOf(addMe);
                Number.set(index, Number.get(index) + 1);
            }
            else
            {
                Ingredients.add(addMe);
                Number.add(1);
            }
        }

        Writer w = null;
        File groceryText = new File(System.getProperty("user.home"), "/Desktop/groceries.txt");
        FileOutputStream is = null;
        try {
            is = new FileOutputStream(groceryText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(is);
        w = new BufferedWriter(osw);

        try {
            w.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Ingredients.size(); i++)
        {
            System.out.println(Ingredients.get(i) + " " + Number.get(i));

            try {
                w.append(Ingredients.get(i) + " " + Number.get(i) + "\n");

            } catch (IOException e) {
                System.err.println("Problem writing to the file groceries.txt");
            }

        }

        try {
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
