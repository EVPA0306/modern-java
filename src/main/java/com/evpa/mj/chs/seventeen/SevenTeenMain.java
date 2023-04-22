package com.evpa.mj.chs.seventeen;

import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SevenTeenMain {

    private static Observable<Long> onePerSecond = Observable.interval(1,TimeUnit.SECONDS);

    public static void main(String[] args) {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        Map<String, String> parameters = new HashMap<>();
        parameters.put("newOnly","NEW");
        parameters.get("newOnly").equalsIgnoreCase("NEW");
        if (parameters.containsKey("oldOnly"))
            parameters.get("oldOnly").equalsIgnoreCase("OLD");
        //getTemperatures("Denver").subscribe(new TempSubscriber());
        //getCelciusTemperatures("Denver").subscribe(new TempSubscriber());
        onePerSecond.blockingSubscribe(i -> System.out.println(TempInfo.fetch("Denver")));
    }

    private static Publisher<TempInfo> getCelciusTemperatures(String town) {
        return subscriber -> {
            TempProcessor tempProcessor = new TempProcessor();
            tempProcessor.subscribe(subscriber);
            tempProcessor.onSubscribe(new TempSubscription(tempProcessor,town));
        };
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber ->
            subscriber.onSubscribe(new TempSubscription(subscriber,town));
    }
}
