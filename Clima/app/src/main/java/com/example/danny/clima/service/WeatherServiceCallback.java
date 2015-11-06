package com.example.danny.clima.service;

import com.example.danny.clima.data.Channel;

/**
 * Created by Danny on 05/11/2015.
 */
public interface WeatherServiceCallback {
    void serviceSucess(Channel channel);
    void  serviceFailure(Exception exception);
}
