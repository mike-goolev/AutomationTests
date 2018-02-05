import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.util.logging.Logger;
import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Logger logger = Logger.getGlobal();

        long t1 = System.nanoTime();
        logger.info(String.format("Sending request: \n" + "%s on %s%n%s",
                request.url(), chain.connection(), request.headers(), request.body()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        logger.info(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers(), response.body()));

        return response;
    }
}