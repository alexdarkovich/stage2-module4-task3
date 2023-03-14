package com.mjc.stage2.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        String delimiter = componentType.getDelimiter();
        List<String> stringArray = new ArrayList<>();
        for (AbstractTextComponent component : componentList) {
            stringArray.add(component.operation());
            stringArray.add(delimiter);
        }

            StringBuilder sb = new StringBuilder();
            for (String s : stringArray) {
                sb.append(s);
        }
            return sb.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        size++;
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        size--;
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return this.size;
    }
// Write your code here!
}
