package org.example;

import java.util.HashMap;

public class Flyweight {
    private static final HashMap<String, CharacterProperties> characterPropertiesCache = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + "_" + color + "_" + size;
        if (!characterPropertiesCache.containsKey(key)) {
            characterPropertiesCache.put(key, new CharacterProperties(font, color, size));
        }
        return characterPropertiesCache.get(key);
    }
}