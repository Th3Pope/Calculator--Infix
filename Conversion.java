package sample;

import java.util.*;
import java.util.List;
import javafx.scene.control.TextField;

public class Conversion {
    int lPren;
    int rPren;
    Stack<String> stack;


    public void FunctionCall(List<Character> list, TextField txt) {
        List<String> strLst = listToString(list);

        //check for correct input
        boolean g2g = FunChecker(strLst);
        if (!g2g) {
            txt.clear();
            txt.appendText("Incorrect Expression");
        }
        callCaculations(strLst,txt);
    }


    void callCaculations(List<String> strLst, TextField txt) {
        stack = new Stack<>();

        for (int i = 0; i < strLst.size(); i++) {

            stack.push(strLst.get(i));

            if (stack.peek().contains(")")) {
                popDatStack(stack, txt);
            }
        }
    }

    void popDatStack(Stack<String> stack, TextField txt) {

        List<String> tempPop = new ArrayList<>();
        System.out.println("STACK " + stack.toString());

        while (!stack.peek().equals("(")) {
            String tmp = stack.pop();

            tempPop.add(tmp);
            System.out.println(tmp + " pop");

        }
        System.out.println("Popped out +" + stack.pop());//extra paren removal

        //cos
        int curr5 = 0;
        while (tempPop.size() > curr5) {
            if (tempPop.get(curr5).equals("c")) {

                String right = tempPop.get(curr5 -1 );
                tempPop.remove(curr5);
                tempPop.remove(curr5 - 1);

                cos( right, tempPop, curr5);

                curr5--;
            }
            curr5++;
        }

        //sin
        int curr6 = 0;
        while (tempPop.size() > curr6) {
            if (tempPop.get(curr6).equals("s")) {

                String right = tempPop.get(curr6 -1 );
                tempPop.remove(curr6);
                tempPop.remove(curr6 - 1);

                sin( right, tempPop, curr6);

                curr6--;
            }
            curr6++;
        }

        //tan
        int curr7 = 0;
        while (tempPop.size() > curr7) {
            if (tempPop.get(curr7).equals("t")) {

                String right = tempPop.get(curr7 -1 );
                tempPop.remove(curr7);
                tempPop.remove(curr7 - 1);

                tan( right, tempPop, curr7);

                curr7--;
            }
            curr7++;
        }

        //cot
        int curr8 = 0;
        while (tempPop.size() > curr8) {
            if (tempPop.get(curr8).equals("o")) {

                String right = tempPop.get(curr8 -1 );
                tempPop.remove(curr8);
                tempPop.remove(curr8 - 1);

                cot( right, tempPop, curr8);

                curr8--;
            }
            curr8++;
        }

        //natural log
        int curr9 = 0;
        while (tempPop.size() > curr9) {
            if (tempPop.get(curr9).equals("l")) {

                String right = tempPop.get(curr9 -1 );
                tempPop.remove(curr9);
                tempPop.remove(curr9 - 1);

                natLog( right, tempPop, curr9);

                curr9--;
            }
            curr9++;
        }

        // log10
        int curr10 = 0;
        while (tempPop.size() > curr10) {
            if (tempPop.get(curr10).equals("L")) {

                String right = tempPop.get(curr10 -1 );
                tempPop.remove(curr10);
                tempPop.remove(curr10 - 1);

                log( right, tempPop, curr10);

                curr10--;
            }
            curr10++;
        }

        int curr2 = 0;
        while (tempPop.size() > curr2) {
            if (tempPop.get(curr2).equals("^")) {

                String left = tempPop.get(curr2 - 1);
                String right = tempPop.get(curr2 + 1);
                tempPop.remove(curr2 + 1);
                tempPop.remove(curr2);
                tempPop.remove(curr2 - 1);

                toThePower(left, right, tempPop, curr2);

                curr2--;
                curr2--;
            }

            curr2++;
        }

        int curr = 0;
        while (tempPop.size() > curr) {

            if (tempPop.get(curr).equals(")")) {
                tempPop.remove(curr);
            }

            if (tempPop.get(curr).equals("*")) {

                String left = tempPop.get(curr - 1);
                String right = tempPop.get(curr + 1);

                tempPop.remove(curr + 1);
                tempPop.remove(curr);
                tempPop.remove(curr - 1);

                multiply(left, right, tempPop, curr);

                curr--;
            }

            if (tempPop.get(curr).equals("/")) {

                String left = tempPop.get(curr - 1);
                String right = tempPop.get(curr + 1);

                tempPop.remove(curr + 1);
                tempPop.remove(curr);
                tempPop.remove(curr - 1);

                divide(left, right, tempPop, curr);

                curr--;

            }
            curr++;
        }


        int curr3 = 0;
        while (tempPop.size() > curr3) {
            if (tempPop.get(curr3).equals("+")) {

                String left = tempPop.get(curr3 - 1);
                String right = tempPop.get(curr3 + 1);

                tempPop.remove(curr3 + 1);
                tempPop.remove(curr3);
                tempPop.remove(curr3 - 1);

                addition(left, right, tempPop, curr3);

                curr3--;

                System.out.println(left + " " + right);

            }
            curr3++;
        }

        //is there a double neg situation? This is the one.
        int curr4 = 0;
        while (tempPop.size() > curr4) {

            if (tempPop.get(curr4).equals("-")) {

                String left = tempPop.get(curr4 - 1);
                String right = tempPop.get(curr4 + 1);
                tempPop.remove(curr4 + 1);
                tempPop.remove(curr4);
                tempPop.remove(curr4 - 1);

                subtract(left, right, tempPop, curr4);

                curr4--;
            }
            curr4++;
        }






       // System.out.println(tempPop.toString());
        stack.push(tempPop.get(0));
        System.out.println("POST STACK " + stack.toString());
//Main update = new Main();
txt.clear();
txt.appendText(stack.toString());
    }


public void cos(String right, List<String> tempPop, int curr) {

        Double cosine = Math.cos(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(cosine));
}

    public void cot(String right, List<String> tempPop, int curr) {

        Double cot = 1.0 / Math.tan(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(cot));

    }

    public void sin(String right, List<String> tempPop, int curr) {

        Double sin = Math.sin(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(sin));

    }

    public void tan(String right, List<String> tempPop, int curr) {

        Double tan = Math.tan(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(tan));

    }

    public void natLog(String right, List<String> tempPop, int curr) {

        Double ln = Math.log(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(ln));
    }

    public void log(String right, List<String> tempPop, int curr) {

        Double log = Math.log10(Double.parseDouble(right));

        tempPop.add(curr-1,Double.toString(log));
    }


    public void multiply(String left, String right, List<String> tempPop, int curr) {

        Double multiply = Double.parseDouble(left) * Double.parseDouble(right);

        tempPop.add(curr - 1, Double.toString(multiply));

    }


    public void divide(String right, String left, List<String> tempPop, int curr) {

        Double divide = Double.parseDouble(left) / Double.parseDouble(right);

        tempPop.add(curr - 1, Double.toString(divide));

    }

    public void toThePower(String pow, String num, List<String> tempPop, int curr) {

        Double big = Math.pow(Double.parseDouble(num), Double.parseDouble(pow));

        tempPop.add(curr - 1, Double.toString(big));
    }

    //only used in double neg situations
    public void subtract(String right, String left, List<String> tempPop, int curr) { // subtraction is fucked up

        Double sub = Double.parseDouble(left) - Double.parseDouble(right);

        tempPop.add(curr - 1, Double.toString(sub));

    }


    public void addition(String right, String left, List<String> tempPop, int curr) {

        Double add = Double.parseDouble(right) + Double.parseDouble(left);

        tempPop.add(curr - 1, Double.toString(add));
    }


    public boolean FunChecker(List<String> strLst) {

        boolean run = true;
        lPren = 0;
        rPren = 0;


        for (int i = 0; i < strLst.size(); i++) {
            if (strLst.get(i).equals("(")) {
                lPren++;
            }
            if (strLst.get(i).equals(")")) {
                rPren++;
            }

        }
        if (lPren != rPren) { //check for open and close parens
            run = false;
        }

        if (strLst.get(1).equals("+") || strLst.get(1).equals("/") || strLst.get(1).equals("*") || strLst.get(1).equals("^")) {
            run = false;
        }
        if (strLst.get(strLst.size() - 1).equals("+") || strLst.get(strLst.size() - 1).equals("/") || strLst.get(strLst.size() - 1).equals("*") || strLst.get(strLst.size() - 1).equals("^")) {
            run = false;
        }

        return run;
    }


    public List<String> listToString(List<Character> list) {

        List<String> strList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) { //converst from s or l ect using switch.
            StringBuilder builderDigit = new StringBuilder();
            StringBuilder builderAlpha = new StringBuilder();
            StringBuilder operator = new StringBuilder();

            if (Character.isDigit(list.get(i)) || list.get(i).equals('.') || list.get(i).equals('-')) {//||list.get(i).equals('-')&&((list.get(i-1) == '-' || list.get(i).equals('-')&&list.get(i-1) == '+' || list.get(i).equals('-')&&list.get(i-1) == '*' ||
                //  list.get(i).equals('-')&&list.get(i-1) == '/' || list.get(i).equals('-')&&list.get(i-1) == '(' ||  list.get(i).equals('-')&&list.get(i-1) == '^'))) {
                while (Character.isDigit(list.get(i)) || list.get(i).equals('.') || (list.get(i).equals('-') && Character.isDigit(list.get(i + 1)) && !(Character.isDigit(list.get(i - 1))))) {
                    builderDigit.append(list.get(i));

                   // System.out.println(list.get(i) + " AT ADD");
                    if (i < list.size() - 1)
                        i++;
                    else break;
                }
                if (!builderDigit.toString().contains(".")) {
                    builderDigit.append(".0");
                }
            }
            if (Character.isAlphabetic(list.get(i))) {
                while (Character.isAlphabetic(list.get(i))) {
                    builderAlpha.append(list.get(i));
                    // builderAlpha.append(list.get(i+1)); //will be "("
                    if (i < list.size() - 1) {
                        i++;
                        // i++;
                    } else break;
                }
            }
            //binary operators
            if (list.get(i) == '-' || list.get(i) == '+' || list.get(i) == '*' ||
                    list.get(i) == '/' || list.get(i) == '(' || list.get(i) == ')' || list.get(i) == '^') {
                if (list.get(i) == '+' && list.get(i-1) == '+'){
                    //skips on the rare occation of a ++- operation (ie adding a neg) 
                }
                else operator.append(list.get(i));

            }
            if (builderDigit.length() != 0)
                strList.add(builderDigit.toString());
            if (builderAlpha.length() != 0)
                strList.add(builderAlpha.toString());
            if (operator.length() != 0)
                strList.add(operator.toString());
        }

        System.out.println(strList.toString());

        return strList;

    }


}
