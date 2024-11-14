package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char character, CharacterProperties properties) {
        characters.add(new Character(character, properties));
    }

    public void save(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write("Character: " + character.getCharacter() +
                        ", Font: " + character.getProperties().getFont() +
                        ", Color: " + character.getProperties().getColor() +
                        ", Size: " + character.getProperties().getSize() + "\n");
            }
        }
    }

    public static Document load(String filename) throws IOException {
        Document doc = new Document();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                char character = parts[0].split(":")[1].trim().charAt(0);
                String font = parts[1].split(":")[1].trim();
                String color = parts[2].split(":")[1].trim();
                int size = Integer.parseInt(parts[3].split(":")[1].trim());
                doc.addCharacter(character, new CharacterProperties(font, color, size));
            }
        }
        return doc;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}