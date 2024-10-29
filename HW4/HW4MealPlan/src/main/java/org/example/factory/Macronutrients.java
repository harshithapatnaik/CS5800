package org.example.factory;

import org.example.enums.*;
import java.util.List;

public interface Macronutrients {
    List<Carbs> createCarbs();
    List<Protein> createProtein();
    List<Fats> createFats();
}