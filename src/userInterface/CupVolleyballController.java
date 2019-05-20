package userInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import customExceptions.EmptyCountryException;
import customExceptions.EmptyIdException;
import customExceptions.NotExistCompetitorException;
import customExceptions.NotExistViewerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Competitor;
import model.Cup;
import model.Viewer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

// Clase
public class CupVolleyballController implements Initializable {

    // Atributos
    @FXML private JFXTextField tfPathFile;
    @FXML private Label lbInfoFile;
    @FXML private JFXTextField tfViewerId;
    @FXML private JFXButton btSearchViewer;
    @FXML private Label lbTimeViewer;
    @FXML private Label lbInfoViewer;
    @FXML private JFXTextField tfCompetitorId;
    @FXML private JFXButton btSearchCompetitor;
    @FXML private Label lbTimeCompetitor;
    @FXML private Label lbInfoCompetitor;
    @FXML private ImageView ivPhoto;
    @FXML private Label lbId;
    @FXML private Label lbFirstName;
    @FXML private Label lbLastName;
    @FXML private Label lbEmail;
    @FXML private Label lbGender;
    @FXML private Label lbCountry;
    @FXML private Label lbBirthday;
    @FXML private JFXButton btViewers;
    @FXML private JFXButton btCompetitors;
    @FXML private JFXTextField tfCountry;
    @FXML private Label lbTimeLoadInfo;
    @FXML private ImageView ivBanner;
    @FXML private ScrollPane spPrintStructure;
    @FXML private Label lbInfoStructure;

    private Cup cup;
    private File dataFile;

    // Métodos

    // Inicializa la relación con el modelo.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cup = new Cup();

        ivBanner.setImage(new Image("img/banner.jpg"));
        ivPhoto.setImage(new Image("img/photo.png"));

        btSearchCompetitor.setDisable(true);
        btSearchViewer.setDisable(true);
        tfViewerId.setDisable(true);
        tfCompetitorId.setDisable(true);
    }

    // Controla el botón que busca el archivo de los espectadores.
    @FXML
    public void controlExplorer(ActionEvent event) {

        try {
            FileChooser chooser = new FileChooser();
            chooser.setInitialDirectory(new File("C:\\Users\\elias\\IdeaProjects\\volleyball-cup\\resourses\\data"));
            dataFile = chooser.showOpenDialog(new Stage());
            tfPathFile.setText(dataFile.getAbsolutePath());
            lbInfoFile.setText("Se encontró la lista de espectadores.");
        } catch (Exception e) {
            lbInfoFile.setText("No se econtró la lista de espectadores.");
        }
    }

    // Controla el botón que carga el archivo de las espectadores.
    @FXML
    public void controlLoad(ActionEvent event) {
        try {
            if (dataFile.exists()) {
                cup.EmptyTree();
                cup.EmptyList();
                cup.loadInfo(dataFile);
                lbTimeLoadInfo.setText(String.valueOf(cup.getTime())+" ms");
            }
            lbInfoFile.setText("La lista de espetadores se cargó correctamente.");
        } catch (FileNotFoundException e) {
            lbInfoFile.setText("Error al cargar la lista de espectadores.");
        }catch (IOException e){
            lbInfoFile.setText("Error al cargar la lista de espectadores.");
        }

        btSearchCompetitor.setDisable(false);
        btSearchViewer.setDisable(false);
        tfViewerId.setDisable(false);
        tfCompetitorId.setDisable(false);
    }

    // Controla el botón que busca un espectador.
    @FXML
    public void ControlSearchViewer(ActionEvent event){
        tfCompetitorId.clear();
        lbInfoCompetitor.setText("");
        Viewer searched;
        try {
            searched = cup.searchViewer(tfViewerId.getText());
            ivPhoto.setImage(new Image(searched.getPhoto()));
            lbId.setText(searched.getId());
            lbFirstName.setText(searched.getFirstName());
            lbLastName.setText(searched.getLastName());
            lbEmail.setText(searched.getEmail());
            lbGender.setText(searched.getGender());
            lbCountry.setText(searched.getCountry());
            lbBirthday.setText(searched.getBirthday());
            lbTimeViewer.setText(String.valueOf(cup.getTime())+" ms");
        }catch (EmptyIdException e){
            lbInfoViewer.setText("No ha ingresado el id del espectador.");
        }catch (NotExistViewerException e){
            lbInfoViewer.setText("El espectador con el id ingresado no existe.");
        }
    }

    // Controla el botón que busca un participante.
    @FXML
    public void controlSearchCompetitor(ActionEvent event) {
        tfViewerId.clear();
        lbInfoViewer.setText("");
        Competitor searched;
        try {
            searched = cup.searchCompetitor(tfCompetitorId.getText());
            ivPhoto.setImage(new Image(searched.getPhoto()));
            lbId.setText(searched.getId());
            lbFirstName.setText(searched.getFirstName());
            lbLastName.setText(searched.getLastName());
            lbEmail.setText(searched.getEmail());
            lbGender.setText(searched.getGender());
            lbCountry.setText(searched.getCountry());
            lbBirthday.setText(searched.getBirthday());
            lbTimeCompetitor.setText(String.valueOf(cup.getTime())+" ms");
        } catch (EmptyIdException e) {
            lbInfoCompetitor.setText("No ha ingresado el id del particpante.");
        } catch (NotExistCompetitorException e) {
            lbInfoCompetitor.setText("El participante con el id ingresado no existe.");
        }
    }

    // Pinta la estructura del árbol binario da búsqueda de espectadores.
    @FXML
    public void controlViewers(ActionEvent event){

    }

    // Pinta la estructura de la lista doblemente enlazada de participantes.
    @FXML
    public void controlCompetitors(ActionEvent event){
        try {
            List<Competitor> competitorList = cup.printCompetitors(tfCountry.getText());

            HBox hBox = new HBox();
            spPrintStructure.setContent(hBox);
            spPrintStructure.setPannable(true);
            int desplace = 0;

            for (Competitor competitor: competitorList) {

                ImageView imageView = new ImageView(new Image(competitor.getPhoto()));
                imageView.setFitHeight(80.0);
                imageView.setFitWidth(80.0);
                imageView.setLayoutX(200.0);
                imageView.setLayoutY(8.0);

                TextArea textArea = new TextArea();
                textArea.setText("Id: "+ competitor.getId()+"\n"+
                                         "Nombre: "+ competitor.getFirstName()+"\n"+
                                         "Apellido: "+ competitor.getLastName()+"\n"+
                                         "Email: "+ competitor.getEmail()+"\n"+
                                         "Género: "+ competitor.getGender()+"\n"+
                                         "País: "+ competitor.getCountry()+"\n"+
                                         "Cumpleaños: "+ competitor.getBirthday()+"\n"

                );
                textArea.setPrefSize(200.0,155.0);

                BorderPane borderPane = new BorderPane();
                borderPane.setPrefSize(200.0,155.0);
                borderPane.setLayoutX(200.0 + desplace);
                borderPane.setLayoutY(20.0);
                borderPane.setTop(imageView);
                borderPane.setBottom(textArea);
                borderPane.setStyle("-fx-background-color:  #1e90ff");

                Separator separator = new Separator();
                separator.setPrefSize(190,3);
                separator.setLayoutY(200);

                separator.setHalignment(HPos.CENTER);
                separator.setStyle("-fx-background-color: Black");

                Line line1 = new Line(70,90,50,90);
                Line line2 = new Line(25,120,50,120);

                hBox.getChildren().addAll(borderPane,line2);

                desplace += 300;
            }

        }catch (EmptyCountryException e){
            lbInfoStructure.setText("No ha ingresado el nombre de un país.");
        }
    }




}


