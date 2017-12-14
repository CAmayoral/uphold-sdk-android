package com.uphold.uphold_android_sdk.test.integration.service;

import com.darylteo.rx.promises.java.Promise;
import com.darylteo.rx.promises.java.functions.RepromiseFunction;

import junit.framework.Assert;

import com.uphold.uphold_android_sdk.client.restadapter.UpholdRestAdapter;
import com.uphold.uphold_android_sdk.client.retrofitpromise.RetrofitPromise;
import com.uphold.uphold_android_sdk.model.Rate;
import com.uphold.uphold_android_sdk.service.TickerService;
import com.uphold.uphold_android_sdk.test.BuildConfig;
import com.uphold.uphold_android_sdk.test.util.MockRestAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.List;

import retrofit.client.Request;

/**
 * TickerService integration tests.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TickerServiceTest {

    @Test
    public void getAllTickersShouldReturnTheRequest() throws Exception {
        final MockRestAdapter<List<Rate>> adapter = new MockRestAdapter<>(null, null);

        adapter.request(new RepromiseFunction<UpholdRestAdapter, List<Rate>>() {
            @Override
            public Promise<List<Rate>> call(UpholdRestAdapter upholdRestAdapter) {
                TickerService tickerService = adapter.getRestAdapter().create(TickerService.class);
                RetrofitPromise<List<Rate>> promise = new RetrofitPromise<>();

                tickerService.getAllTickers(promise);

                return promise;
            }
        });

        Request request = adapter.getRequest();

        Assert.assertEquals(request.getMethod(), "GET");
        Assert.assertEquals(request.getUrl(), String.format("%s/v0/ticker", BuildConfig.API_SERVER_URL));
    }

    @Test
    public void getAllTickersByCurrencyShouldReturnTheRequest() throws Exception {
        final MockRestAdapter<List<Rate>> adapter = new MockRestAdapter<>(null, null);

        adapter.request(new RepromiseFunction<UpholdRestAdapter, List<Rate>>() {
            @Override
            public Promise<List<Rate>> call(UpholdRestAdapter upholdRestAdapter) {
                TickerService tickerService = adapter.getRestAdapter().create(TickerService.class);
                RetrofitPromise<List<Rate>> promise = new RetrofitPromise<>();

                tickerService.getAllTickersByCurrency("foobar", promise);

                return promise;
            }
        });

        Request request = adapter.getRequest();

        Assert.assertEquals(request.getMethod(), "GET");
        Assert.assertEquals(request.getUrl(), String.format("%s/v0/ticker/foobar", BuildConfig.API_SERVER_URL));
    }

}
