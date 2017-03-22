package callbacks;

/**
 * Created by michael on 3/22/17.
 */
public class MyFetcher implements Fetcher {

    private Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(this.data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
