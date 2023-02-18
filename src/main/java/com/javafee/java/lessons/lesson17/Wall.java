package com.javafee.java.lessons.lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public List<Optional<Block>> findBlockByColor(String color) {
        List<Optional<Block>> helpList = new ArrayList<>();
        for (Block block : blocks)
            if (block.getColor().equals(color))
                helpList.add(Optional.of(block));
        return helpList;
    }

    @Override
    public List<Optional<Block>> findBlocksByMaterial(String material) {
        List<Optional<Block>> helpList = new ArrayList<>();
        for (Block block : blocks)
            if (block.getMaterial().equals(material))
                helpList.add(Optional.of(block));
        return helpList;
    }

    @Override
    public int count() {
        int counter = 0;
        for (Block block : blocks)
            counter += 1;
        return counter;
    }
}