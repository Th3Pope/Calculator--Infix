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

    EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getSource()==buttonArrNums [0]){
                list.add('0');
                updateText();
            }
            if(event.getSource()==buttonArrNums [1]){
                list.add('1');
                updateText();
            }
            if(event.getSource()==buttonArrNums [2]){
                list.add('2');
                updateText();
            }
            if(event.getSource()==buttonArrNums [3]){
                list.add('3');
                updateText();
            }
            if(event.getSource()==buttonArrNums [4]){
                list.add('4');
                updateText();
            }
            if(event.getSource()==buttonArrNums [5]){
                list.add('5');
                updateText();
            }
            if(event.getSource()==buttonArrNums [6]){
                list.add('6');
                updateText();
            }
            if(event.getSource()==buttonArrNums [7]){
                list.add('7');
                updateText();
            }
            if(event.getSource()==buttonArrNums [8]){
                list.add('8');
                updateText();
            }
            if(event.getSource()==buttonArrNums [9]){
                list.add('9');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [0]){
                list.add('+');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [1]){
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
                list.add('s');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [6]){
                list.add('c');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [7]){
                list.add('t');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [8]){
                list.add('c');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [9]){
                list.add('l');//ln
                updateText();
            }
            if(event.getSource()==buttonArrFunc [10]){
                list.add('L');//Log
                updateText();
            }
            if(event.getSource()==buttonArrFunc [11]){
                list.add('(');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [12]){
                list.add(')');
                updateText();
            }
            if(event.getSource()==buttonArrFunc [13]){
                checkCaculation();
            }
            if(event.getSource()==buttonArrFunc [14]){
                list.clear();
                updateText();
            }
        }
    };


 public void updateText(){
     System.out.println(list.toString());
  StringBuilder bobTheBuilder = new StringBuilder();
  for (int i = 0 ; i<list.size(); i++){
      bobTheBuilder.append(list.get(i));
  }



     text.clear();
     text.appendText(bobTheBuilder.toString());
 }


    @Override
    public void start(Stage primaryStage) throws Exception {




        primaryStage.setTitle("Caculator");


        GridPane gridFun = new GridPane();
        buttonArrFunc = new Button[15];

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

        for (int i = 0; i < 15; i++) {
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

    public void caculateResult(){

     



    }
    //hacked so it passes
    //TODO:
    public void checkCaculation(){
     boolean pass = false;
     if (list.contains("(")){
         if (list.contains(")")){
             pass = true;
         }
     }
     //if(list.contains())
     pass = true;
     if (pass) {
         caculateResult();
     }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
