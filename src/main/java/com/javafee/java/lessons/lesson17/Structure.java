package com.javafee.java.lessons.lesson17;

import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    List<Optional<Block>> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Optional<Block>> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}