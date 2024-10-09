package com.aluracursos.challenge;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class apiservicio {
    public Moneda buscaMoneda(String apiKey){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            String json = response.body().replace("\"conversion_rates\":{","\"conversion_rates\":[{").replace("}\n" +"}","}]\n" + "}");
            //System.out.println(json);
            return new Gson().fromJson(json, Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
