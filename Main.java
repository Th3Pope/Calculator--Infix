package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Button[] buttonArrFunc;
    Button[] buttonArrNums;
    List<Character> list = new ArrayList<>();
    TextField text;

    public void caculateResult(){

Conversion convert = new Conversion();
convert.FunctionCall(list, text);



    }

    EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            if(event.getSource()==buttonArrNums [0]){
                if (list.size()==0){
                    list.add('(');
                }

                list.add('0');

                updateText();
            }
            if(event.getSource()==buttonArrNums [1]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('1');
                updateText();
            }
            if(event.getSource()==buttonArrNums [2]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('2');
                updateText();
            }
            if(event.getSource()==buttonArrNums [3]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('3');
                updateText();
            }
            if(event.getSource()==buttonArrNums [4]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('4');
                updateText();
            }
            if(event.getSource()==buttonArrNums [5]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('5');
                updateText();
            }
            if(event.getSource()==buttonArrNums [6]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('6');
                updateText();
            }
            if(event.getSource()==buttonArrNums [7]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('7');
                updateText();
            }
            if(event.getSource()==buttonArrNums [8]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('8');
                updateText();
            }
            if(event.getSource()==buttonArrNums [9]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('9');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [0]){
                list.add('+');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [1]){
                list.add('+');////////////////////////////////testing since subtraction method is shit
                list.add('-');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [2]){
                list.add('*');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [3]){
                list.add('/');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [4]){
                list.add('^');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [5]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('s');
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [6]){ //cos
                if (list.size()==0){
                    list.add('(');
                }
                list.add('c');
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [7]){ //tan
                if (list.size()==0){
                    list.add('(');
                }
                list.add('t');
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [8]){ // cot need to edit the screen
                if (list.size()==0){
                    list.add('(');
                }
                list.add('o');
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [9]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('l');//ln
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [10]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('L');//Log
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [11]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [12]){
                list.add(')');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [13]){
                list.add(')');
               // checkCaculation();
                caculateResult();
            }
            if(event.getSource()==buttonArrFunc [14]){
                list.clear();
                updateText();
            }
            if(event.getSource()==buttonArrFunc [15]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('.');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [16]){
                if (list.size()==0){
                    list.add('(');
                }
                list.add('-');
                updateText();
            }
        }
    };


    public void updateText(){
        System.out.println(list.toString());
        StringBuilder bobTheBuilder = new StringBuilder();
        for (int i = 1 ; i<list.size(); i++) { //converst from s or l ect using switch.


            //this is for use of the addition method with subtraction
            if (i+1 < list.size()){
                if (list.get(i).equals('+')&&list.get(i+1).equals('-')){
                    i++;
                }
                else if (list.get(i-1).equals('+')&&list.get(i).equals('-')){
                    bobTheBuilder.append('-');
                }
            }
             bobTheBuilder.append(list.get(i));
        }

            text.clear();

        text.appendText(bobTheBuilder.toString());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {




        primaryStage.setTitle("Caculator");


        GridPane gridFun = new GridPane();
        buttonArrFunc = new Button[17];

        buttonArrFunc[0] = new Button("+");
        GridPane.setConstraints(buttonArrFunc[0], 1, 1);
        buttonArrFunc[1] = new Button("-");
        GridPane.setConstraints(buttonArrFunc[1], 1, 2);
        buttonArrFunc[2] = new Button("*");
        GridPane.setConstraints(buttonArrFunc[2], 1, 3);
        buttonArrFunc[3] = new Button("/");
        GridPane.setConstraints(buttonArrFunc[3], 1, 4);
        buttonArrFunc[4] = new Button("^");
        GridPane.setConstraints(buttonArrFunc[4], 2, 1);
        buttonArrFunc[5] = new Button("sin");
        GridPane.setConstraints(buttonArrFunc[5], 2, 2);
        buttonArrFunc[6] = new Button("cos");
        GridPane.setConstraints(buttonArrFunc[6], 2, 3);
        buttonArrFunc[7] = new Button("tan");
        GridPane.setConstraints(buttonArrFunc[7], 2, 4);
        buttonArrFunc[8] = new Button("cot");
        GridPane.setConstraints(buttonArrFunc[8], 3, 1);
        buttonArrFunc[9] = new Button("ln");
        GridPane.setConstraints(buttonArrFunc[9], 3, 2);
        buttonArrFunc[10] = new Button("log10");
        GridPane.setConstraints(buttonArrFunc[10], 3, 3);
        buttonArrFunc[11] = new Button("(");
        GridPane.setConstraints(buttonArrFunc[11], 3, 4);
        buttonArrFunc[12] = new Button(")");
        GridPane.setConstraints(buttonArrFunc[12], 4, 1);
        buttonArrFunc[13] = new Button("=");
        GridPane.setConstraints(buttonArrFunc[13], 4, 2);
        buttonArrFunc[14] = new Button("C");
        GridPane.setConstraints(buttonArrFunc[14], 4, 3);
        buttonArrFunc[15] = new Button(".");
        GridPane.setConstraints(buttonArrFunc[15], 4, 4);

        buttonArrFunc[16] = new Button("NEG");
        GridPane.setConstraints(buttonArrFunc[16], 1, 5);//////////Negation

        for (int i = 0; i < 17; i++) {
            gridFun.getChildren().add(buttonArrFunc[i]);
            buttonArrFunc[i].setOnMouseClicked(mouseClick);
        }


        GridPane gridNums = new GridPane();
        buttonArrNums = new Button[10];
        for (int i = 0, r = 1, c = 1; i < 10; i++) {

            if (r == 5) {
                r = 1;
                c++;
            }

            buttonArrNums[i] = new Button(String.valueOf(i));
            buttonArrNums[i].setOnMouseClicked(mouseClick);

            GridPane.setConstraints(buttonArrNums[i], r, c);
            gridNums.getChildren().add(buttonArrNums[i]);
            r++;

        }

        gridNums.setPadding(new Insets(10, 10, 10, 10)); // edge/ window padding
        gridNums.setVgap(8); //vertical spacing/cell
        gridNums.setHgap(10); //horizontal spacing/cell

        //text field
        text = new TextField("00");
        GridPane.setConstraints(text, 6, 0);
        text.setDisable(true);//disable intput for dumb input
        text.setStyle("-fx-opacity: 1;");
        //text.textProperty().bind();

        //set the shit where it needs to be
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(gridNums);
        borderPane.setRight(gridFun);
        borderPane.setTop(text);

        Scene scene = new Scene(borderPane, 300, 250);


        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
