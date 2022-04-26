package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.TreeSet;

public class Controller {
    public TextField tfLetra;
    public Button btComprobar;
    public Label lbOculta;
    public Label fxintentos;
    public Label lbLetrasNo;
    public HBox LyLetras;
    public ImageView imagen;
    Ahorcado ahorcado=new Ahorcado();
    TreeSet<String> letrasNoAcertadas=new TreeSet<>();
    public void initialize(){
        ahorcado.obtenerPalabraAleatoria();
        lbOculta.setText(ahorcado.ocultarPalabraSimbolo());
        fxintentos.setText("Intentos :"+ahorcado.IntentosMax);
    }

    public void btNuevoJuego(ActionEvent actionEvent) {

        ahorcado=new Ahorcado();
        letrasNoAcertadas.clear();
        tfLetra.setDisable(false);
        LyLetras.getChildren().clear();
        initialize();
    }

    public void ttfComprobar(KeyEvent keyEvent) {
        char letra=tfLetra.getText().trim().charAt(0);
        if( ahorcado.cambiarSimbolosPorLetra(letra)==false) {
            int intentos=ahorcado.intentosRestantes();
            fxintentos.setText("Intentos :"+intentos);
            Image image = new Image(getClass().getResourceAsStream("imagenes/"+intentos+".jpg"),400,400,false,false);
            imagen.setImage(image);
            letrasNoAcertadas.add(letra+"");
           // lbLetrasNo.setText(letrasNoAcertadas.toString());
            MostrasLetra(letra+"");
            if(intentos==0){
                fxintentos.setText("GAME OVER  sin intentos: Palabra: "+ahorcado.getPalabra());
                tfLetra.setDisable(true);

            }

        }

        lbOculta.setText(ahorcado.getPalabra_oculta());

        if(ahorcado.comprobarPalabra()==true){
            fxintentos.setText("HAS ACERTADO ");
            tfLetra.setDisable(true);

        }
        tfLetra.clear();

    }
    private void MostrasLetra(String letra){
        if ( LyLetras.getChildren().size()<letrasNoAcertadas.size()) {
            Label label = new Label();
            label.setFont(new Font("Cambria", 30));

           label.setStyle("-fx-border-style: dotted , dashed  , dashed  , dashed; -fx-border-color: blue;-fx-border-width: 3;");

            label.setText(letra);
            LyLetras.getChildren().add(label);
        }
    }
}
