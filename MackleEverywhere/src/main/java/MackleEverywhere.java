import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HGender;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;

@ExtensionInfo(
        Title =  "MackleEverywhere",
        Description =  "Mackle Bee Everywhere",
        Version =  "1.0",
        Author =  "sirjonasxx"
)
class MackleEverywhere extends Extension {

    public static void main(String[] args) {
        new MackleEverywhere(args).run();
    }

    public MackleEverywhere(String[] args) {
        super(args);
    }


    @Override
    protected void initExtension() {
        intercept(HMessage.Direction.TOCLIENT, "Users", this::onUsers);
    }

    private void onUsers(HMessage hMessage) {
        HEntity[] hEntities = HEntity.parse(hMessage.getPacket());
        hMessage.setBlocked(true);

        for (HEntity entity : hEntities) {
            entity.setName("Macklebee");
            entity.setFigureId("hr-828-58.hd-180-1.ch-210-73.lg-280-82.sh-295-1408");
            entity.setGender(HGender.Male);
        }
        sendToClient(HEntity.constructPacket(hEntities, hMessage.getPacket().headerId()));
    }
}
