package model;

public class TasaConversion {
    private String time_last_update_utc;
    private String base_code;
    private String target_code;
    private Double conversion_rate;
    private Double conversion_result;

    public TasaConversion(TasaConversionAPI tasaConversionAPI){
        this.time_last_update_utc = tasaConversionAPI.time_last_update_utc();
        this.base_code = tasaConversionAPI.base_code();
        this.target_code = tasaConversionAPI.target_code();
        this.conversion_rate = tasaConversionAPI.conversion_rate();
        this.conversion_result = tasaConversionAPI.conversion_result();
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return "TasaConversion{" +
                "Ultima actualizacion '" + time_last_update_utc + '\'' +
                ", Moneda base '" + base_code + '\'' +
                ", Moneda destino '" + target_code + '\'' +
                ", Tasa de conversion " + conversion_rate +
                ", Resultado " + conversion_result +
                '}';
    }
}
