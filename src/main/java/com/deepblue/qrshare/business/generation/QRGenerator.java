package com.deepblue.qrshare.business.generation;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.File;

public class QRGenerator {

    public File generateQRCodeImage(String text) {
        return QRCode.from(text)
                .withSize(500, 500)
                .to(ImageType.PNG)
                .file();
    }
}
