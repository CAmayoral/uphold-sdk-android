package com.uphold.uphold_android_sdk.test.util;

import com.darylteo.rx.promises.java.Promise;
import com.darylteo.rx.promises.java.functions.RepromiseFunction;

import com.uphold.uphold_android_sdk.BuildConfig;
import com.uphold.uphold_android_sdk.client.restadapter.UpholdRestAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * MockRestAdapter.
 */

public class MockRestAdapter<T> {

    private AtomicReference<Exception> exceptionReference;
    private AtomicReference<Request> requestReference;
    private AtomicReference<T> resultReference;
    private UpholdRestAdapter mockRestAdapter;
    private RestAdapter restAdapter;

    public MockRestAdapter(final String responseString, final HashMap<String, String> headers) {
        this.exceptionReference = new AtomicReference<>();
        this.requestReference = new AtomicReference<>();
        this.resultReference = new AtomicReference<>();
        this.mockRestAdapter = new UpholdRestAdapter();
        this.restAdapter = new RestAdapter.Builder().setEndpoint(BuildConfig.API_SERVER_URL)
            .setRequestInterceptor(this.mockRestAdapter.getUpholdRequestInterceptor())
            .setClient(new Client() {
                @Override
                public Response execute(Request request) throws IOException {
                    requestReference.set(request);

                    return new Response("some/url", 200, "reason", new ArrayList<Header>() {{
                        if (headers != null) {
                            for (Map.Entry<String, String> entry : headers.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();

                                add(new retrofit.client.Header(key, value));
                            }
                        }
                    }}, new TypedByteArray("application/json", responseString == null ? new byte[0] : responseString.getBytes()));
                }
        }).build();

        this.mockRestAdapter.setAdapter(this.restAdapter);
    }

    public Promise<T> request(RepromiseFunction<UpholdRestAdapter, T> fn) throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);

        Promise<T> promise = fn.call(this.mockRestAdapter).then(new RepromiseFunction<T, T>() {
            @Override
            public Promise<T> call(T result) {
                resultReference.set(result);

                latch.countDown();

                return null;
            }
        }).fail(new RepromiseFunction<Exception, T>() {
            @Override
            public Promise<T> call(Exception e) {
                exceptionReference.set(e);

                latch.countDown();

                return null;
            }
        });

        latch.await();

        return promise;
    }

    public Exception getException() {
        return exceptionReference.get();
    }

    public Request getRequest() {
        return requestReference.get();
    }

    public RestAdapter getRestAdapter() {
        return this.restAdapter;
    }

    public T getResult() {
        return resultReference.get();
    }

}
