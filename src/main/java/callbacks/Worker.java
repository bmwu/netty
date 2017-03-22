package callbacks;

/**
 * Created by michael on 3/22/17.
 */
public class Worker {

    private void doWork() {

        MyFetcher myFetcher = new MyFetcher(new Data(1, 0));
        myFetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("Received an data: " + data.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("An error occurred: " + throwable.getMessage());
            }
        });

    }

    public static void main(String[] args) {

        Worker worker = new Worker();
        worker.doWork();
    }
}
