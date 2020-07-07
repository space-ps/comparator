package com.spacep.controller;

import com.spacep.client.EmpClient;
import com.spacep.pojo.EmpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;


@Controller("/hello")
public class ComparatorController {

    private static final Logger log = LoggerFactory.getLogger(ComparatorController.class);

    @Inject
    EmpClient client;

    @Get
    public Single<EmpResponse> getResponse() {
        Single<EmpResponse> alpha = client.getEmpAsyncAlpha();

        Single<EmpResponse> beta = client.getEmpAsyncBeta();

        return alpha
                .doOnSuccess(alphaResp ->{
                    beta.subscribe(betaResponse -> {
                        //This is to simulate a failure
                        betaResponse.setStatus("failed");
                       if(!alphaResp.equals(betaResponse)) {
                           log.error("RESPONSE Mismatch");
                       }
                    });
        });



    }

}