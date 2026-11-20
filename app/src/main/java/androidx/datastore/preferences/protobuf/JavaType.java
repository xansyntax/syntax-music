package androidx.datastore.preferences.protobuf;

import com.yalantis.ucrop.view.CropImageView;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum JavaType {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(ByteString$LiteralByteString.class, ByteString$LiteralByteString.EMPTY),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);

    public final Class boxedType;
    public final Object defaultDefault;

    JavaType(Class cls, Serializable serializable) {
        this.boxedType = cls;
        this.defaultDefault = serializable;
    }
}
