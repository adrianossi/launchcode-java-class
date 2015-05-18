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
    }

    public Encodable getCryptStrategy() {
        return this.cryptStrategy;
    }

    public static void main(String args[]) {
        Spy bond = new Spy(new Caesar(1));
        bond.setEncodedMsg("shaken");
        System.out.println(bond.getEncodedMsg());
        System.out.println(bond.getDecodedMsg());

        bond.setCryptStrategy(new Caesar(13));
        bond.setEncodedMsg("licensetokill");
        System.out.println(bond.getEncodedMsg());
        System.out.println(bond.getDecodedMsg());

    }
}
