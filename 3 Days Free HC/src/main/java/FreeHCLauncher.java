import gearth.Main;
import gearth.extensions.ExtensionForm;
import gearth.extensions.ExtensionFormCreator;
import gearth.ui.GEarthController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FreeHCLauncher extends ExtensionFormCreator {

    public ExtensionForm createForm(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("freehc.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Free HC");
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add(GEarthController.class.getResource("/gearth/ui/bootstrap3.css").toExternalForm());
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("G-EarthLogoSmaller.png")));

        primaryStage.setResizable(false);

        return loader.getController();

    }

    public static void main(String[] args) {
        runExtensionForm(args, FreeHCLauncher.class);
    }

}
