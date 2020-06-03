import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;

@ExtensionInfo(
        Title =  "Template extension",
        Description =  "",
        Version =  "0.1",
        Author =  "sirjonasxx"
)
public class TemplateExtension extends Extension {

    public static void main(String[] args) {
        new TemplateExtension(args).run();
    }



    public TemplateExtension(String[] args) {
        super(args);
    }

    @Override
    protected void initExtension() {
        // intercepts all incoming messages
        intercept(HMessage.Direction.TOCLIENT, this::onIncomingMessage);

        // intercepts all outgoing messages with headerId 5
        intercept(HMessage.Direction.TOCLIENT, 5, hMessage -> {
            hMessage.setBlocked(true);  // blocks the packet
            sendToServer(new HPacket(1000, "hi"));  // sends another packet
        });
    }

    @Override
    protected void onStartConnection() {

    }

    private void onIncomingMessage(HMessage hMessage) {
        // do something
    }

}
