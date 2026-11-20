package com.google.protobuf;

import com.yalantis.ucrop.view.CropImageView;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum WireFormat$JavaType {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(ByteString.EMPTY),
    ENUM(null),
    MESSAGE(null);

    public final Object defaultDefault;

    WireFormat$JavaType(Serializable serializable) {
        this.defaultDefault = serializable;
    }
}
