package com.deepblue.qrshare.business.entities;

import lombok.Data;

@Data
public class ScannedQRCode {

    private final String canal;
    private final String content;
}
