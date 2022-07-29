package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class ListMaker {

    static ArrayList<String> myArrList  = new ArrayList<String>();


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu  = "A - Add D - Delete P - Print Q - Quit";
	    boolean done = false;
	    String cmd = "";
        int delete = 0;

	    do {
            displayList ();

            cmd = SafeInput.getRegExString (in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase ();

            switch (cmd) {
                case "A":
                    String add = SafeInput.getNonZeroLenString (in, "What would you like to add to your list?");
                    myArrList.add (add);
                    done = false;
                    break;
                case "D":
                    delete = SafeInput.getRangedInt (in, "What would you like to delete? Please enter the number of the item.", 1, myArrList.size());
                    System.out.println (myArrList.size());
                    delete = delete - 1;
                    String var = myArrList.get(delete);
                    myArrList.set(delete, "");
                    done = false;
                    break;
                case "P":
                    done = false;
                    break;
                case "Q":
                    boolean response = SafeInput.getYNConfirm (in, "Are you sure you want to quit?");
                    if (response){
                        System.exit (0);
                        done = true;
                    }
                    else
                    {
                        done = false;
                    }
                    break;
            }
        }while(!done);
    }

    private static void displayList()
    {
        System.out.println ("------------------------------------------------------");
        if (myArrList .size() != 0) {
            for (int i = 0; i < myArrList .size (); i++) {
                System.out.printf ("%3d%8s", i + 1, myArrList.get(i));
            }
        }
        else
        {
            System.out.println ("The List is empty");
        }
        System.out.println ();
        System.out.println ("------------------------------------------------------");

    }
}
