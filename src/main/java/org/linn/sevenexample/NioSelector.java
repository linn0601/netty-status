package org.linn.sevenexample;

import java.io.IOException;
import java.nio.channels.Selector;

public class NioSelector {

    public static void main(String[] args) throws IOException {
        //通过Selector 类创建Selector
        Selector selector = Selector.open();
    }
}
