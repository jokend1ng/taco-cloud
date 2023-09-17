package com.example.tacocloud.converters;

import com.example.tacocloud.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter  implements Converter<String,Ingredient> {
    private Map<String,Ingredient>ingredietMap = new HashMap<>();
    public IngredientByIdConverter(){
        ingredietMap.put("FLTO",new Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP));
        ingredietMap.put("COTO",new Ingredient("COTO","Corn Tortilla", Ingredient.Type.WRAP));
        ingredietMap.put("GRBF",new Ingredient("GRBF","Ground Beef", Ingredient.Type.PROTEIN));
        ingredietMap.put("CARN",new Ingredient("CARN","Carnitas", Ingredient.Type.PROTEIN));
        ingredietMap.put("TMTO",new Ingredient("TMTO","Decid Tomatoes", Ingredient.Type.VEGGIES));
        ingredietMap.put("LETC",new Ingredient("LETC","Lettuce", Ingredient.Type.VEGGIES));
        ingredietMap.put("CHED",new Ingredient("CHED","Cheddar", Ingredient.Type.CHEESE));
        ingredietMap.put("JACK",new Ingredient("JACK","Monterrey Jack", Ingredient.Type.CHEESE));
        ingredietMap.put("SLSA",new Ingredient("SLSA","Salsa", Ingredient.Type.SAUCE));
        ingredietMap.put("SRCR",new Ingredient("SRCR","Sour Cream", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredietMap.get(id);
    }
}
