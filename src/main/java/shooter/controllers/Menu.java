package shooter.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;


public class Menu {

    @FXML
    private ImageView menuBcg,playBcg,highscoreBcg,exitBcg;

    MediaPlayer a;

    @FXML
    public void initialize(){
        menuBcg.setImage(new Image(getClass().getResource("/images/menuBcg.png").toExternalForm()));
        playBcg.setImage(new Image(getClass().getResource("/images/playBcg.png").toExternalForm()));
        highscoreBcg.setImage(new Image(getClass().getResource("/images/highscoreBcg.png").toExternalForm()));
        exitBcg.setImage(new Image(getClass().getResource("/images/exitBcg.png").toExternalForm()));
        music();
    }

    private void music(){
        Media med = new Media(getClass().getResource("/sounds/menuMusic.mp3").toExternalForm());
        a =new MediaPlayer(med);
        a.setVolume(0.8);
        a.setAutoPlay(true);
        a.setOnEndOfMedia(new Runnable() {
            public void run() {
                a.seek(Duration.ZERO);
            }
        });
    }

    public void goPlay(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/playFXML.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        a.pause();
    }

    public void highscore(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/highscore.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        a.pause();
    }

    public void exitApp(ActionEvent event) {
        Platform.exit();
    }

}