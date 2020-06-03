import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.extensions.extra.harble.ChatConsole;
import gearth.extensions.extra.harble.ChatInputListener;
import gearth.extensions.extra.harble.HashSupport;
import gearth.misc.harble_api.HarbleAPI;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;

@ExtensionInfo(
        Title =  "Harble extension",
        Description =  "",
        Version =  "0.1",
        Author =  "sirjonasxx"
)
public class HarbleExtension extends Extension {

    public static void main(String[] args) {
        new HarbleExtension(args).run();
    }

    private HashSupport hashSupport;

    public HarbleExtension(String[] args) {
        super(args);
    }


    @Override
    protected void initExtension() {
        hashSupport = new HashSupport(this);
        ChatConsole chatConsole = new ChatConsole(hashSupport, this,
                "I will make you wave when you type \"I want to wave\" in a room!");

        chatConsole.onInput(s -> chatConsole.writeOutput("You entered: " + s, false));

        hashSupport.intercept(HMessage.Direction.TOSERVER, "RoomUserTalk", this::onUserTalk);
    }

    private void onUserTalk(HMessage hMessage) {
        HPacket packet = hMessage.getPacket();

        if (packet.readString().equals("I want to wave")) {
            packet.replaceString(6, "I am waving");
            hashSupport.sendToServer("RoomUserAction", 1); // makes you wave
        }
    }

}
