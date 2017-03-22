package callbacks;

/**
 * Created by michael on 3/22/17.
 */
public interface FetcherCallback {
    void onData(Data data) throws Exception;
    void onError(Throwable throwable);
}
