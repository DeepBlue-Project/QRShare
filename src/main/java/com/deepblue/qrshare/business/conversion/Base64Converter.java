package com.deepblue.qrshare.business.conversion;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Base64Converter {

    public String toBase64(final File file) throws IOException {
        byte[] imageBytes = IOUtils.toByteArray(file.toURI());
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
