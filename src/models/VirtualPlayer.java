package models;

public class VirtualPlayer extends BasePlayer {
    String emotion;
    public VirtualPlayer(String name, String emotion) {
        super(name);
        this.emotion = emotion;
    }

    public String getEmotion() {
        return this.emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void DefeatNotification() {
        StringBuffer noti = new StringBuffer();
        noti.append(this.name);
        noti.append(": ");
        noti.append(this.getEmotion());
        System.out.println(noti.toString());
    }
}
