package com.conversor;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.InputStream;
import java.util.Properties;

public class CurrencyConverter {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String apiKey;

    public CurrencyConverter() {
        this.apiKey = loadApiKey();
    }

    private String loadApiKey() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("api.key");
        } catch (Exception e) {
            throw new RuntimeException("❌ Error al cargar API Key desde config.properties", e);
        }
    }

    public double convert(String from, String to, double amount) {
        String url = BASE_URL + apiKey + "/pair/" + from + "/" + to + "/" + amount;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("❌ Error HTTP: " + response.code());
                return -1;
            }

            String json = response.body().string();
            System.out.println("🔍 JSON: " + json);

            ApiExchangeResponse apiResponse = gson.fromJson(json, ApiExchangeResponse.class);

            if ("success".equalsIgnoreCase(apiResponse.getResult())) {
                return apiResponse.getConversion_result();
            } else {
                System.err.println("❌ Error API: " + apiResponse.getResult());
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
