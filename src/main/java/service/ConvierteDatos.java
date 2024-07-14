package service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.TasaConversion;
import model.TasaConversionAPI;

public class ConvierteDatos {

    public TasaConversionAPI convierteDatos(String json){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        TasaConversionAPI tasaConversionAPI = gson.fromJson(json, TasaConversionAPI.class);

        TasaConversion tasaConversion = new TasaConversion(tasaConversionAPI);

        return tasaConversionAPI;
    }
}
