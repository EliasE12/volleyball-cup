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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
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
public class VolleyballCupController implements Initializable {

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
    @FXML private JFXTextField tfCountry;
    @FXML private Label lbTimeLoadInfo;
    @FXML private ImageView ivBanner;
    @FXML private Pane pPrintStructure;
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
            chooser.setInitialDirectory(new File(".\\resourses\\data"));
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
            ivPhoto.setImage(new Image(searched.getPathPhoto()));
            lbId.setText(searched.getId());
            lbFirstName.setText(searched.getFirstName());
            lbLastName.setText(searched.getLastName());
            lbEmail.setText(searched.getEmail());
            lbGender.setText(searched.getGender());
            lbCountry.setText(searched.getCountry());
            lbBirthday.setText(searched.getBirthday());
            lbTimeViewer.setText(cup.getTime()+" ms");
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
            ivPhoto.setImage(new Image(searched.getPathPhoto()));
            lbId.setText(searched.getId());
            lbFirstName.setText(searched.getFirstName());
            lbLastName.setText(searched.getLastName());
            lbEmail.setText(searched.getEmail());
            lbGender.setText(searched.getGender());
            lbCountry.setText(searched.getCountry());
            lbBirthday.setText(searched.getBirthday());
            lbTimeCompetitor.setText(cup.getTime()+" ms");
        } catch (EmptyIdException e) {
            lbInfoCompetitor.setText("No ha ingresado el id del particpante.");
        } catch (NotExistCompetitorException e) {
            lbInfoCompetitor.setText("El participante con el id ingresado no existe.");
        }
    }



    public void drawTreeViewers(BorderPane borderPane, ImageView imageView, TextArea textArea, Viewer viewer) {

        imageView.setImage(new Image(viewer.getPathPhoto()));

        textArea.setText(viewer.toString());

        borderPane.setTop(imageView);
        borderPane.setBottom(textArea);
        borderPane.setStyle("-fx-background-color:  #1e90ff");
        borderPane.setLayoutX(0);
        borderPane.setLayoutY(0);

        pPrintStructure.getChildren().addAll(borderPane);

    }
    // Pinta la estructura del árbol binario da búsqueda de espectadores.
    @FXML
    public void controlViewers(ActionEvent event){

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(200,155);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);

        TextArea textArea = new TextArea();
        textArea.setPrefSize(200,155);

        try {

            Viewer root = cup.treeViewersToPrint(cup.viewersToPrint(tfCountry.getText()));
            if (root != null) {
                while (root != null) {
                    drawTreeViewers(borderPane, imageView, textArea, root);
                    if (root.getLeftViewer() != null) {
                        drawTreeViewers(borderPane, imageView, textArea, root.getLeftViewer());
                        root = root.getLeftViewer();
                    }
                    if (root.getRightViewer() != null) {
                        drawTreeViewers(borderPane, imageView, textArea, root.getRightViewer());
                        root = root.getRightViewer();
                    }
                }
            }
        }catch (EmptyCountryException e){
            e.printStackTrace();
        }
    }


    // Pinta la estructura de la lista doblemente enlazada de participantes.
    @FXML
    public void controlCompetitors(ActionEvent event){
        try {
            List<Competitor> competitorList = cup.competitorsToPrint(tfCountry.getText());

            int desplace = 0;
            int counter = 0;
            for (Competitor competitor: competitorList) {

                BorderPane borderPane = new BorderPane();
                borderPane.setPrefSize(200.0, 155.0);
                borderPane.setLayoutX(desplace);
                borderPane.setLayoutY(20.0);

                ImageView imageView = new ImageView(new Image(competitor.getPathPhoto()));
                imageView.setFitHeight(80);
                imageView.setFitWidth(90);

                TextArea textArea = new TextArea();
                textArea.setText(competitor.toString());
                textArea.setPrefSize(200.0, 155.0);

                borderPane.setTop(imageView);
                borderPane.setBottom(textArea);
                borderPane.setStyle("-fx-background-color:  #1e90ff");

                pPrintStructure.getChildren().addAll(borderPane);

                if (counter != competitorList.size() - 1) {

                    Line line1 = new Line(borderPane.getLayoutX() + 200, borderPane.getLayoutY() + 100, borderPane.getLayoutX() + 200 + 190, borderPane.getLayoutY() + 100);
                    Line line2 = new Line(borderPane.getLayoutX() + 200, borderPane.getLayoutY() + 150, borderPane.getLayoutX() + 200 + 190, borderPane.getLayoutY() + 150);

                    Line f1 = new Line(line1.getStartX() + 100, line1.getStartY(), line1.getStartX() + 90, line1.getStartY() - 10);
                    Line f2 = new Line(line1.getStartX() + 100, line1.getStartY(), line1.getStartX() + 90, line1.getStartY() + 10);

                    Line f3 = new Line(line2.getStartX(), line2.getStartY(), line2.getStartX() + 10, line2.getStartY() - 10);
                    Line f4 = new Line(line2.getStartX(), line2.getStartY(), line2.getStartX() + 10, line2.getStartY() + 10);

                    pPrintStructure.getChildren().addAll(line1, line2, f1, f2, f3, f4);
                }
                counter++;
                desplace += 300;
            }
        }catch (EmptyCountryException e){
            lbInfoStructure.setText("No ha ingresado el nombre de un país.");
        }
    }




}


