package com.example.mp7_bdevereux;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class Pig extends Application {

    public String diceRoll() {
        ArrayList<Integer> dice1 = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            dice1.add(i);
        }
        Collections.shuffle(dice1);
        playerActions(dice1.get(0));
        String rollValue = String.valueOf(dice1.get(0));
        return rollValue;
    }

    public void playerActions(int diceValue){
        int tempDiceValue;
        int sum;
        if (diceValue==1){

            System.out.println("You've rolled a 1, your score for this round is 0.");
            sum = 0;
            //advances to next player
        }else{
            System.out.println("You've rolled a "+ diceValue);
            //need a variable to hold total score of dice.
            tempDiceValue = diceValue;
            //sum = diceValue + sum;
        }
    }

    public void RollHold(){
        Button hold = new Button("Hold");
        Button rollAgain = new Button("Roll Again");
        AtomicInteger returnValue = new AtomicInteger();
        hold.setOnMouseClicked(e->{

        });
        rollAgain.setOnMouseClicked(e->{
           // diceRoll();
        });
    }
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        Pig pig = new Pig();


        //objects for menu scene
        Button newGame = new Button("Start new game");
        Button highScores = new Button("View high scores");
        RadioButton playerSelector = new RadioButton("Player");
        RadioButton pcSelector = new RadioButton("Computer");
        ToggleGroup toggle = new ToggleGroup();
        Label label = new Label("Who will you play against?");
        GridPane menuPane = new GridPane();

        //add radiobuttons to group
        playerSelector.setToggleGroup(toggle);
        pcSelector.setToggleGroup(toggle);

        menuPane.add(label, 0,0 );
        menuPane.add(newGame, 10, 0);
        menuPane.add(highScores, 10,3);
        menuPane.add(playerSelector, 0,2);
        menuPane.add(pcSelector, 0, 5);
        menuPane.getChildren();
        Scene menuScene = new Scene(menuPane,400,400);
        primaryStage.setScene(menuScene);
        primaryStage.show();

        //Objects for game scene
        Button roll = new Button("Roll");
        Button stay = new Button("Stay");
        Text p1Points = new Text();
        Text p2Points = new Text();
        Text currentPlayer = new Text();
        Text currentRollAmount = new Text();

        GridPane gamePane = new GridPane();

        /*gamePane.add(roll,2,5);
        gamePane.add(stay, 4,5);*/
        gamePane.add(roll,0,0);
        gamePane.add(stay, 0,1);
        gamePane.add(p1Points,10,1 );
        gamePane.add(p2Points, 10, 3);
        gamePane.add(currentPlayer, 4, 0);
        gamePane.add(currentRollAmount,5,10);
        gamePane.getChildren();

        Scene gameScene = new Scene(gamePane, 400, 400);

        //button Actions
        roll.setOnMouseClicked(e->{
            diceRoll();
            currentRollAmount.setText(diceRoll());

        });

        newGame.setOnAction(e->{
            primaryStage.setScene(gameScene);
            primaryStage.show();
        });
    }
}