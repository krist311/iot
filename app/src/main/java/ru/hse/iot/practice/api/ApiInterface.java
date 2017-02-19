package ru.hse.iot.practice.api;

import java.util.List;


import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;

import retrofit.http.POST;
import retrofit.http.Path;
import ru.hse.iot.practice.model.Lamp;
import rx.Observable;

public interface ApiInterface {

    @GET("light/{color}/{state}")
    //Observable<Lamp> turnOnLight( String color,  String state);
    Observable<Lamp> turnOnLight(@Path("color") String color, @Path("state") String state);
    @GET("player/{state}")
    Observable<Lamp> player(@Path("state") String command);
    @GET("lcd/{text}")
    Observable<Lamp> sendText(@Path("text") String text);
    @GET("gettemp")
    Observable<String> getTemp();
}
