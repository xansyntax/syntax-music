package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.ByteString$LiteralByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.RawMessageInfo;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesProto$Value extends GeneratedMessageLite {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile Parser PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends GeneratedMessageLite.Builder {
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static PreferencesProto$Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) ((GeneratedMessageLite.Builder) DEFAULT_INSTANCE.dynamicMethod(5));
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(int i) {
        Parser defaultInstanceBasedParser;
        switch (PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", PreferencesProto$StringSet.class});
            case 3:
                return new PreferencesProto$Value();
            case 4:
                return new Builder(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PreferencesProto$Value.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser();
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean getBoolean() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final ByteString$LiteralByteString getBytes() {
        return this.valueCase_ == 8 ? (ByteString$LiteralByteString) this.value_ : ByteString$LiteralByteString.EMPTY;
    }

    public final double getDouble() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float getFloat() {
        return this.valueCase_ == 2 ? ((Float) this.value_).floatValue() : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final int getInteger() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long getLong() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public final String getString() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public final PreferencesProto$StringSet getStringSet() {
        return this.valueCase_ == 6 ? (PreferencesProto$StringSet) this.value_ : PreferencesProto$StringSet.getDefaultInstance();
    }

    public final int getValueCase() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    public final void setBoolean(boolean z) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z);
    }

    public final void setBytes(ByteString$LiteralByteString byteString$LiteralByteString) {
        this.valueCase_ = 8;
        this.value_ = byteString$LiteralByteString;
    }

    public final void setDouble(double d) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d);
    }

    public final void setFloat(float f) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f);
    }

    public final void setInteger(int i) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i);
    }

    public final void setLong(long j) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j);
    }

    public final void setString(String str) {
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void setStringSet(PreferencesProto$StringSet preferencesProto$StringSet) {
        this.value_ = preferencesProto$StringSet;
        this.valueCase_ = 6;
    }
}
