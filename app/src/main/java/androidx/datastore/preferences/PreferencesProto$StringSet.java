package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyStringList;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection;
import androidx.datastore.preferences.protobuf.ProtobufArrayList;
import androidx.datastore.preferences.protobuf.RawMessageInfo;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesProto$StringSet extends GeneratedMessageLite {
    private static final PreferencesProto$StringSet DEFAULT_INSTANCE;
    private static volatile Parser PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private Internal.ProtobufList strings_ = ProtobufArrayList.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends GeneratedMessageLite.Builder {
    }

    static {
        PreferencesProto$StringSet preferencesProto$StringSet = new PreferencesProto$StringSet();
        DEFAULT_INSTANCE = preferencesProto$StringSet;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$StringSet.class, preferencesProto$StringSet);
    }

    public static PreferencesProto$StringSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) ((GeneratedMessageLite.Builder) DEFAULT_INSTANCE.dynamicMethod(5));
    }

    public final void addAllStrings(Iterable iterable) {
        Internal.ProtobufList protobufListMutableCopyWithCapacity = this.strings_;
        if (!((ProtobufArrayList) protobufListMutableCopyWithCapacity).isMutable) {
            ProtobufArrayList protobufArrayList = (ProtobufArrayList) protobufListMutableCopyWithCapacity;
            int i = protobufArrayList.size;
            protobufListMutableCopyWithCapacity = protobufArrayList.mutableCopyWithCapacity(i == 0 ? 10 : i * 2);
            this.strings_ = protobufListMutableCopyWithCapacity;
        }
        Charset charset = Internal.UTF_8;
        if (iterable instanceof LazyStringList) {
            ((LazyStringList) iterable).getUnderlyingElements();
            PathKt$$ExternalSyntheticBUOutline0.m();
            return;
        }
        if (iterable instanceof PrimitiveNonBoxingCollection) {
            ((ProtobufArrayList) protobufListMutableCopyWithCapacity).addAll((Collection) iterable);
            return;
        }
        if ((protobufListMutableCopyWithCapacity instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) protobufListMutableCopyWithCapacity).ensureCapacity(((Collection) iterable).size() + ((ProtobufArrayList) protobufListMutableCopyWithCapacity).size);
        }
        ProtobufArrayList protobufArrayList2 = (ProtobufArrayList) protobufListMutableCopyWithCapacity;
        int i2 = protobufArrayList2.size;
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (protobufArrayList2.size - i2) + " is null.";
                for (int i3 = protobufArrayList2.size - 1; i3 >= i2; i3--) {
                    protobufArrayList2.remove(i3);
                }
                PathKt$$ExternalSyntheticBUOutline0.m(str);
                return;
            }
            protobufArrayList2.add(obj);
        }
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new PreferencesProto$StringSet();
            case 4:
                return new Builder(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PreferencesProto$StringSet.class) {
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

    public final Internal.ProtobufList getStringsList() {
        return this.strings_;
    }
}
