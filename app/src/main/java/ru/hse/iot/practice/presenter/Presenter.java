package ru.hse.iot.practice.presenter;

import android.util.Log;

import java.util.List;

import ru.hse.iot.practice.MainActivity;
import ru.hse.iot.practice.model.Lamp;
import ru.hse.iot.practice.model.Model;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil on 13.02.2017.
 */

public class Presenter {
    private Model model = new Model();
    private MainActivity activity;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public Presenter(MainActivity activity){
        this.activity = activity;
    }

    public void turnOnLight(String color, String state) {

        Subscription userInfoSubscription = model.turnOnLight(color, state)
                .subscribe(new Observer<Lamp>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Lamp lamp) {
                        Log.d("my app", "On next");
                    }
                });
        addSubscription(userInfoSubscription);
    }

    public void sendText(String text) {

        Subscription userInfoSubscription = model.sendText(text)
                .subscribe(new Observer<Lamp>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Lamp lamp) {
                        Log.d("my app", "On next");
                    }
                });
        addSubscription(userInfoSubscription);
    }
    public void getTemp() {

        Subscription userInfoSubscription = model.getTemp()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(String temp) {
                        activity.showTemp(temp);
                    }
                });
        addSubscription(userInfoSubscription);
    }

    public void player(String text) {

        Subscription userInfoSubscription = model.player(text)
                .subscribe(new Observer<Lamp>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Lamp lamp) {
                        Log.d("my app", "On next");
                    }
                });
        addSubscription(userInfoSubscription);
    }
}
