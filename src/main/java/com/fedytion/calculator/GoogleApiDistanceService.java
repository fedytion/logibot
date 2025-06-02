package com.fedytion.calculator;

import com.fedytion.config.Env;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

public class GoogleApiDistanceService implements DistanceService {

    @Override
    public double getDistance(String origin, String destination) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse("https://maps.googleapis.com/maps/api/distancematrix/json")).newBuilder();
        urlBuilder.addQueryParameter("origins", origin);
        urlBuilder.addQueryParameter("destinations", destination);
        urlBuilder.addQueryParameter("units", "metric");
        urlBuilder.addQueryParameter("key", Env.get("GOOGLE_API_KEY"));

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String jsonData = response.body().string();
            JSONObject json = new JSONObject(jsonData);
            JSONArray rows = json.getJSONArray("rows");
            JSONObject elements = rows.getJSONObject(0).getJSONArray("elements").getJSONObject(0);
            JSONObject distance = elements.getJSONObject("distance");

            return distance.getDouble("value") / 1000.0; // метри → кілометри
        }
    }
}
