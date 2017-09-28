import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainQuizDuellStart extends Application {

    private PlayerList playerList;
    private IQuestionPool pool;
    private Player currentPlayer;
    private Question q;
    private Duel d;

    private ComboBox<String> comboBox1, comboBox2;
    private ComboBox<String> duelBox;
    private Button newButton;
    private Label lb_opponent;

    private TextArea txtQuestion;
    private VBox vboxDuel;

    @Override
    public void start(Stage primaryStage) {
        try {
            initGame();

            VBox vbox_pl1 = createUIPlayer();

            vboxDuel=new VBox();

            // TODO create the missing UI parts

            VBox root = new VBox(10);
            root.setAlignment(Pos.TOP_CENTER);
            root.getChildren().addAll(vbox_pl1,vboxDuel);

            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("QuizDuell");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disableNewDuel() {
        newButton.setDisable(true);
        duelBox.setDisable(true);
        comboBox2.setDisable(true);
    }

    private void enableNewDuel() {
        newButton.setDisable(false);
        duelBox.setDisable(false);
        comboBox2.setDisable(false);
        comboBox2.getSelectionModel().clearSelection();
    }



    private void playRound(Duel d, Player p) {
        Label lbl1= new Label("Duel "+ d.getNumber() + " - Round "+d.displayCurrentRound());
        txtQuestion = new TextArea();
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(new Button("A"));
        buttons.add(new Button("B"));
        buttons.add(new Button("C"));
        buttons.add(new Button("D"));
        Label lbl2 = new Label();
        Button next = new Button("Next");
        next.setDisable(true);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(buttons);
        vboxDuel.getChildren().addAll(lbl1, txtQuestion, hbox, lbl2, next);
        for (Button btn :buttons) {
            btn.setOnAction(event-> {
                if (d.evaluateAnswer(btn.getText())) {
                    lbl2.setText("Correct Answer!!");
                } else {
                    lbl2.setText("Wrong!! The correct answer is " + d.getCorrectAnswer());
                }
                for(Button button:buttons){button.setDisable(true);}
                next.setDisable(false);
            });
        }
        next.setOnAction(event->{
            for(Button btn:buttons){btn.setDisable(false);}
            next.setDisable(true);
            lbl2.setText("");
            displayQuestion(d, p);
        });
        displayQuestion(d,p);
    }

    private void displayQuestion(Duel d, Player p){
        if(d.roundActive()&&d.canBeContinued(p))
            txtQuestion.setText(d.getNextQuestion());
        else
        {
            d.cleanUpRound();
            vboxDuel.getChildren().clear();
        }
    }

    private VBox createUIPlayer() {

        ObservableList<String> options = FXCollections.observableArrayList();
        options.setAll(playerList.allNames());

        comboBox1 = new ComboBox<String>(options);
        comboBox1.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                currentPlayer = playerList.get(newValue);
                if (currentPlayer != null) {
                    System.out.println(
                            "Player " + currentPlayer.getName() + " selected");
                    resetDuelBox();
                    enableNewDuel();
                } else {
                    disableNewDuel();
                }
            }

        });

        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(new Label("Select your name:"), comboBox1);

        // create ComboxBox for opponents
        HBox opponentsBox = createOpponents(options);
        opponentsBox.setDisable(true);

        newButton = new Button("New Duel");
        newButton.setDisable(true);
        newButton.setOnAction(event -> {
            opponentsBox.setDisable(false);
        });

        Pane duelHBox = createDuelBox();

        HBox hbox2 = new HBox(4, new VBox(5, newButton, opponentsBox),
                new Separator(Orientation.VERTICAL), duelHBox);
        hbox2.setAlignment(Pos.TOP_CENTER);

        VBox vbox1 = new VBox(5);
        vbox1.setAlignment(Pos.TOP_CENTER);
        vbox1.getChildren().addAll(hbox1, new Separator(), hbox2,
                new Separator());

        return vbox1;

    }

    private Pane createDuelBox() {

        ObservableList<String> options = FXCollections.observableArrayList();
        options.setAll(getDuells());

        duelBox = new ComboBox<String>(options);
        duelBox.setDisable(true);
        duelBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if (newValue != null) {
                    System.out.println("new Value duelBox " + newValue);
                    // create a new Duel and play a round
                    d = currentPlayer.getDuell(new Integer(newValue));
                    System.out.println("Duel " + d.getNumber() + " selected");
                    playRound(d, currentPlayer);
                }
            }

        });
        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(new Label("Select Duel:"), duelBox);

        lb_opponent = new Label("");

        return new VBox(5, hbox1, lb_opponent);
    }

    private void resetDuelBox() {
        System.out.println("resetDuelBox");
        ObservableList<String> options = FXCollections.observableArrayList();
        options.setAll(getDuells());
        duelBox.getSelectionModel().clearSelection();
        duelBox.setItems(options);
        d = null;
        lb_opponent.setText("");
    }

    private ArrayList<String> getDuells() {
        ArrayList<Duel> duels = new ArrayList<Duel>();
        if (currentPlayer != null) {
            duels = currentPlayer.getDuells();
        }

        ArrayList<String> stringList = new ArrayList<String>();
        for (Duel duel : duels) {
            stringList.add("" + duel.getNumber());
        }
        return stringList;
    }

    private HBox createOpponents(ObservableList<String> options) {
        comboBox2 = new ComboBox<String>(options);
        comboBox2.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                Player opponent = playerList.get(newValue);
                if (opponent != null) {
                    System.out
                            .println("Opponent " + opponent.getName() + " selected");
                    d = new Duel(currentPlayer, opponent, pool);
                    currentPlayer.addDuell(d);
                    opponent.addDuell(d);
                    // TODO let the current player play the next round
                    playRound(d,currentPlayer);
                }

            }

        });
        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(new Label("Opponent:"), comboBox2);

        return hbox1;
    }

    private void initGame() {
        playerList = new PlayerList();
        playerList.init();
        pool = new MockQuestionPool();
    }

    public static void main(String[] args) {
        launch(args);
    }

}