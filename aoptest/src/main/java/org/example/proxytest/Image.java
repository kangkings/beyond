package org.example.proxytest;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Image {
    public BufferedImage getImage() throws IOException;
}
