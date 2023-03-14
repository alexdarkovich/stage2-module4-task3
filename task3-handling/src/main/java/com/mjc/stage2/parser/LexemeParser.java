package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] lexemes = string.split(LEXEME_REGEX);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        for (String lexeme : lexemes) {
            AbstractTextComponent lexemeComponent;
            Matcher wordMatcher = wordPattern.matcher(lexeme);
            if (nextParser != null && wordMatcher.find()) {
                lexemeComponent = new TextComponent(TextComponentType.WORD);
                nextParser.parse(lexemeComponent, lexeme);
            } else {
                char symbol = lexeme.charAt(0);
                lexemeComponent = new SymbolLeaf(symbol);
            }
            abstractTextComponent.add(lexemeComponent);
        }
    }

    // Write your code here!

}
