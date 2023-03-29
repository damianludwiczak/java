package com.javafee.java.lessons.lesson17;

import java.util.List;

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
