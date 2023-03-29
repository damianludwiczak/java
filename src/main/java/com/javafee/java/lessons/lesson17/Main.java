package com.javafee.java.lessons.lesson17;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wall wall = new Wall();
        List<Block> blockList2 = new ArrayList<>();
        blockList2.add(buildBlock("a", "1"));
        blockList2.add(buildBlock("b", "2"));
        List<Block> blockList = new ArrayList<>();
        blockList.add(buildBlock("c", "1"));
        blockList.add(buildBlock("c", "2"));
        wall.setBlocks(blockList2);
        wall.getBlocks().add((CompositeBlock) buildCompositeBlock(blockList,"c", "3"));
        System.out.println("aaa");
        wall.findBlockByColor("c").forEach(System.out::println);
        System.out.println(wall.findBlocksByMaterial("3"));
        System.out.println(wall.count());
        }
    public static Block buildBlock(String color, String material) {
        return new Block() {
            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return material;
            }
        };
    }

    public static Block buildCompositeBlock(List<Block> blocks, String color, String material) {
        return new CompositeBlock() {
            @Override
            public List<Block> getBlocks() {
                return blocks;
            }

            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return material;
            }
        };
    }
}
