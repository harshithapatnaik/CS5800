package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        document.addCharacter('H', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('e', Flyweight.getCharacterProperties("Calibri", "Blue", 14));
        document.addCharacter('l', Flyweight.getCharacterProperties("Verdana", "Black", 16));
        document.addCharacter('l', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('o', Flyweight.getCharacterProperties("Calibri", "Blue", 14));
        document.addCharacter('W', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('o', Flyweight.getCharacterProperties("Verdana", "Black", 16));
        document.addCharacter('r', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('l', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('d', Flyweight.getCharacterProperties("Verdana", "Black", 16));
        document.addCharacter('C', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('S', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('5', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('8', Flyweight.getCharacterProperties("Calibri", "Blue", 14));
        document.addCharacter('0', Flyweight.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('0', Flyweight.getCharacterProperties("Calibri", "Blue", 14));

        try {
            document.save("HelloWorldCS5800.txt");
            System.out.println("Document saved successfully...!!!");

            // Load the saved document
            Document loadedDocument = Document.load("HelloWorldCS5800.txt");

            // Print loaded characters with their properties
            System.out.println("Loaded characters with their properties:");
            for (Character character : loadedDocument.getCharacters()) {
                System.out.println("Character: " + character.getCharacter() +
                        ", Font: " + character.getProperties().getFont() +
                        ", Color: " + character.getProperties().getColor() +
                        ", Size: " + character.getProperties().getSize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}