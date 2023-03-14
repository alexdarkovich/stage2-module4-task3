package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser{
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        char[] symbols = string.toCharArray();

        for (char s : symbols) {
            SymbolLeaf symbol = new SymbolLeaf(s);
            abstractTextComponent.add(symbol);
        }
    }

    // Write your code here!

}
