package com.spacep.client;

import com.spacep.pojo.EmpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;


// Declarative Client
/*
@Singleton
public class EmpClient {
    private RxHttpClient httpClient;

    public EmpClient(@Client("Emp Client") RxHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String greet() {
        HttpRequest<String> req = HttpRequest.GET("http://dummy.restapiexample.com/api/v1/employees");
        return httpClient.retrieve(req).blockingFirst();
    }

    public Single<String> getEmpAsyncAlpha() {
        ObjectMapper objectmapper = new ObjectMapper();
        HttpRequest<String> req = HttpRequest.GET("http://dummy.restapiexample.com/api/v1/employees" );
        return httpClient.retrieve(req).first("An error has occurred")
                .flatMap(resp -> {

                });

    }

    public Single<String> getEmpAsyncBeta() {
        HttpRequest<String> req = HttpRequest.GET("http://dummy.restapiexample.com/api/v1/employees" );
        return httpClient.exchange(req).
    }
}*/

@Client("http://dummy.restapiexample.com/api/v1")
public interface EmpClient{

    @Get("/employees")
    Single<EmpResponse> getEmpAsyncAlpha();

    @Get("/employees")
    Single<EmpResponse> getEmpAsyncBeta();
}
