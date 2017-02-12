package ru.hse.iot.practice.model;

/**
 * Created by Daniil on 13.02.2017.
 */

import ru.hse.iot.practice.api.ApiInterface;
import ru.hse.iot.practice.api.ApiModule;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Krist on 19.11.2016.
 */

public class Model{

    private final Observable.Transformer schedulersTransformer;
    private ApiInterface apiInterface = ApiModule.getApiInterface();

    public Model() {
        schedulersTransformer = o -> ((Observable) o).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io()) // TODO: remove when https://github.com/square/okhttp/issues/1592 is fixed
        ;
    }

    public void turnOnLight(String color, String state) {
         apiInterface.turnOnLight(color, state);
    }

    public void player(String state) {
        apiInterface.player(state);
    }

    public void sendText(String text){
        apiInterface.sendText(text);
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }
}
