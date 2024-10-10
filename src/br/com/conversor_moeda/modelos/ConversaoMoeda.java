package br.com.conversor_moeda.modelos;

import br.com.conversor_moeda.conexao.ConsultaMoeda;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversaoMoeda {
    ConsultaMoeda consulta = new ConsultaMoeda();

    public String converteDolarReal(Double dolar){
        String json = consulta.ConsultarMoeda("USD");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double brl = jsonObject.getAsJsonObject("conversion_rates").get("BRL").getAsDouble();
        return String.format("O valor %.2f [dolar] é de %.2f [real]", dolar, dolar * brl);
    }
    public String converteRealDolar(double real){
        String json = consulta.ConsultarMoeda("BRL");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double usd = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        return String.format("O valor %.2f [real] é de %.2f [dolar]", real , real * usd );
    }
    public String converterDolarPesoArg(double dolar){
        String json = consulta.ConsultarMoeda("USD");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double ars = jsonObject.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();
        return  String.format("O valor %.2f [dolar] é de %.2f [peso argentino]", dolar, dolar * ars);
    }
    public  String converterPesoArgDolar(double peso){
        String json = consulta.ConsultarMoeda("ARS");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double usd = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        return String.format("O valor %.2f [peso argentino] é de %.2f [dolar]",peso , peso * usd );
    }
    public String converterDolarBob(double dolar){
        String json = consulta.ConsultarMoeda("USD");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double bob = jsonObject.getAsJsonObject("conversion_rates").get("BOB").getAsDouble();
        return String.format("O valor %.2f [dolar] é de %.2f [boliviano]",dolar , dolar * bob );
    }
    public String converterBobDolar(double bol){
        String json = consulta.ConsultarMoeda("BOB");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double usd = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        return String.format("O valor %.2f [boliviano] é de %.2f [dolar]", bol , bol * usd );
    }
    public String converterDolarPesoChi(double dolar){
        String json = consulta.ConsultarMoeda("USD");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double clp = jsonObject.getAsJsonObject("conversion_rates").get("CLP").getAsDouble();
        return String.format("O valor %.2f [dolar] é de %.2f [peso chileno]",dolar ,dolar * clp );
    }
    public String converterPesoChiDolar(double peso){
        String json = consulta.ConsultarMoeda("CLP");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double usd = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        return String.format("O valor %.2f [peso chileno] é de %.2f [dolar]",peso ,peso * usd );
    }
    public String converterDolarPesoCol(double dolar){
        String json = consulta.ConsultarMoeda("USD");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double cop = jsonObject.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
        return String.format("O valor %.2f [dolar] é de %.2f [peso colombiano]",dolar ,dolar * cop );
    }
    public String converterPesoColDolar(double peso){
        String json = consulta.ConsultarMoeda("COP");
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double usd = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        return String.format("O valor %.2f [peso colombiano] é de %.2f [dolar]",peso ,peso * usd );
    }
    public String converterMoeda(String moeda, String moedaConversao, double valor){
        String json = consulta.ConsultarMoeda(moeda.toUpperCase());
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double moedaConvertida = jsonObject.getAsJsonObject("conversion_rates").get(moedaConversao.toUpperCase()).getAsDouble();
        return String.format("O valor %.2f [%s] é de %.2f [%s]",valor, moeda.toUpperCase() ,valor * moedaConvertida, moedaConversao.toUpperCase());
    }
}
