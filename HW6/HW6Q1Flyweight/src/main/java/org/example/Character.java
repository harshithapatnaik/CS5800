package org.example;

import java.io.Serializable;


public class Character implements Serializable {
    private final char character;
    private final CharacterProperties properties;

    public Character(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperties getProperties() {
        return properties;
    }
}
