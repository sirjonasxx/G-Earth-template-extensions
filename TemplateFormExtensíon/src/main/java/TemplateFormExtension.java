import gearth.extensions.Extension;
import gearth.extensions.ExtensionForm;
import gearth.extensions.ExtensionInfo;
import gearth.protocol.HMessage;
import gearth.ui.GEarthController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@ExtensionInfo(
        Title =  "Template form extension",
        Description =  "",
        Version =  "0.1",
        Author =  "sirjonasxx"
)
public class TemplateFormExtension extends ExtensionForm {

    public Button button;

    public static void main(String[] args) {
        runExtensionForm(args, TemplateFormExtension.class);
    }

    //initialize javaFX elements
    public void initialize() {
        button.setText("Click me!");
    }

    @Override
    public ExtensionForm launchForm(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(TemplateFormExtension.class.getResource("templateform.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Template form extension");
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add(GEarthController.class.getResource("/gearth/ui/bootstrap3.css").toExternalForm());

        return loader.getController();
    }

    @Override
    protected void initExtension() {

    }


    public void onClickButton(ActionEvent actionEvent) {
        writeToConsole("I have been clicked!");
    }
}
