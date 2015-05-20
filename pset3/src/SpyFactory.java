/**
 * Created by adrian on 5/20/15.
 */
public class SpyFactory {

    public static Spy getSpy(Encodable cryptStrategy) {
        return new Spy(cryptStrategy);
    }
}
