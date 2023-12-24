package com.example.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.tp.model.Address;
import com.example.tp.model.FeatureCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.example.tp.model.Geometry;
import com.example.tp.model.Properties;
import com.example.tp.model.WeatherResponse;
import com.example.tp.model.Feature;

@Controller
public class MeteoController {



//    @GetMapping("/meteo")
//     public String showMeteoForm() {
//         return "meteo";
    
//     }



@RequestMapping(value = "/meteo",method = RequestMethod.POST)
public String handleData(@RequestParam(name = "address") String address, Model model) throws JsonMappingException, JsonProcessingException{
        

        
        String addresss =   address.toString();

        String uri = "https://api-adresse.data.gouv.fr/search/?q="+addresss+"&limit=1";

        RestTemplate restTemplate = new RestTemplate();

        String jsonResponse = restTemplate.getForObject(uri, String.class, Address.class);



        String jsonString = jsonResponse;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        FeatureCollection featureCollection = objectMapper.readValue(jsonString, FeatureCollection.class);


        String city = featureCollection.getFeatures().get(0).getProperties().getLabel();
        double longitude = featureCollection.getFeatures().get(0).getGeometry().getCoordinates().get(0);
        double latitude = featureCollection.getFeatures().get(0).getGeometry().getCoordinates().get(1) ;
        String insee = featureCollection.getFeatures().get(0).getProperties().getCitycode();

        String token = "492c818f96f68fd70099fb678e1e754a53ec12d1832d9d89fdf0fda3d2ef265d";
        
        String json_weather = fetchWeather(longitude, latitude, insee, token);

        WeatherResponse weatherResponse = objectMapper.readValue(json_weather, WeatherResponse.class);

        int tmin = weatherResponse.getForecast().getTmin();
        int tmax = weatherResponse.getForecast().getTmax();
        int weather = weatherResponse.getForecast().getWeather();        

        /**
         * faire passer les params longitude et latitude a l'api meteo
         */
       // WeatherResponse weatherResponse = callWeatherApi(longitude, latitude);

        //System.out.println(weatherResponse.getForecast().getWeather());

        
        model.addAttribute("city", city);

        model.addAttribute("lgt", longitude);
        
        model.addAttribute("lat", latitude);
        model.addAttribute("insee", insee);

           
        model.addAttribute("tmin", tmin);

        model.addAttribute("tmax", tmax);
        
        model.addAttribute("weather", weather);


        return "meteo";
    }
    

    public String fetchWeather(double longt , double lat,String insee , String token) throws JsonMappingException, JsonProcessingException{
    

        String uri = "https://api.meteo-concept.com/api/forecast/daily/0?token="+token+"&insee="+insee+"&latlng="+longt+"2C"+lat;
        
        RestTemplate restTemplate = new RestTemplate();


        String jsonResponse = restTemplate.getForObject(uri, String.class);
        String jsonString = jsonResponse;
     
        return jsonString;
    }

}
