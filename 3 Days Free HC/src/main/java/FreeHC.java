import gearth.extensions.ExtensionForm;
import gearth.extensions.ExtensionInfo;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;
import javafx.event.ActionEvent;

@ExtensionInfo(
        Title =  "3 Days Free HC",
        Description =  "Gives you free HC",
        Version =  "1.0",
        Author =  "sirjonasxx"
)
public class FreeHC extends ExtensionForm {

    public void getFreeHcClick(ActionEvent actionEvent) {
        sendToServer(new HPacket("NewUserExperienceGetGifts", HMessage.Direction.TOSERVER, 1, 1, 1));
        writeToConsole("Successfully gave free HC!");
    }
}
