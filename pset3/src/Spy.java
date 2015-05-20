/**
 * Created by adrian on 5/15/15.
 */
public class Spy {
    private String encodedMsg;
    private Encodable cryptStrategy;

    public Spy(Encodable cryptStrategy) {
        this.cryptStrategy = cryptStrategy;
        this.encodedMsg = "";
    }

    public void setEncodedMsg(String msg) {
        this.encodedMsg = this.getCryptStrategy().encodeString(msg);
    }

    public String getEncodedMsg() {
        return this.encodedMsg;
    }

    public String getDecodedMsg() {
        return this.cryptStrategy.decodeString(this.encodedMsg);
    }

    public void setCryptStrategy(Encodable cryptStrategy) {
        this.cryptStrategy = cryptStrategy;
        this.setEncodedMsg("");
    }

    public Encodable getCryptStrategy() {
        return this.cryptStrategy;
    }

    public boolean isAlpha(String input) {
        return input.matches("[a-z]+");
    }

    public static void main(String args[]) {
        Spy bond = SpyFactory.getSpy(EncodableFactory.getCaesar(1));
        bond.setEncodedMsg("shaken");
        System.out.println("msg 1 encoded: " + bond.getEncodedMsg());
        System.out.println("msg 1 decoded: " + bond.getDecodedMsg());

        bond.setCryptStrategy(EncodableFactory.getCaesar(13));
        bond.setEncodedMsg("licensetokill");
        System.out.println("msg 2 encoded: " + bond.getEncodedMsg());
        System.out.println("msg 2 decoded: " + bond.getDecodedMsg());

        bond.setCryptStrategy(EncodableFactory.getVigenere("james"));
        bond.setEncodedMsg("doubleohseven");
        System.out.println("msg 3 encoded: " + bond.getEncodedMsg());
        System.out.println("msg 3 decoded: " + bond.getDecodedMsg());

    }

}
