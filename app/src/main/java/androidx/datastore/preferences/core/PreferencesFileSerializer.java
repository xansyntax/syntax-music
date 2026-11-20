package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto$PreferenceMap;
import androidx.datastore.preferences.PreferencesProto$StringSet;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import androidx.datastore.preferences.protobuf.ByteString$LiteralByteString;
import androidx.datastore.preferences.protobuf.CodedOutputStream$OutputStreamEncoder;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesFileSerializer {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[9];
            System.arraycopy(PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.$VALUES, 0, iArr, 0, 9);
            int[] iArr2 = new int[iArr.length];
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[6] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[4] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr2;
        }
    }

    public static MutablePreferences readFrom(FileInputStream fileInputStream) throws CorruptionException {
        byte[] bArr;
        try {
            PreferencesProto$PreferenceMap from = PreferencesProto$PreferenceMap.parseFrom(fileInputStream);
            MutablePreferences mutablePreferences = new MutablePreferences(false);
            Preferences$Pair[] preferences$PairArr = (Preferences$Pair[]) Arrays.copyOf(new Preferences$Pair[0], 0);
            mutablePreferences.checkNotFrozen$datastore_preferences_core();
            if (preferences$PairArr.length > 0) {
                Preferences$Pair preferences$Pair = preferences$PairArr[0];
                throw null;
            }
            Map preferencesMap = from.getPreferencesMap();
            preferencesMap.getClass();
            for (Map.Entry entry : preferencesMap.entrySet()) {
                String str = (String) entry.getKey();
                PreferencesProto$Value preferencesProto$Value = (PreferencesProto$Value) entry.getValue();
                str.getClass();
                preferencesProto$Value.getClass();
                int valueCase = preferencesProto$Value.getValueCase();
                switch (valueCase == 0 ? -1 : WhenMappings.$EnumSwitchMapping$0[PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(valueCase)]) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        throw new CorruptionException("Value case is null.", null);
                    case 0:
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    case 1:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), Boolean.valueOf(preferencesProto$Value.getBoolean()));
                        break;
                    case 2:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), Float.valueOf(preferencesProto$Value.getFloat()));
                        break;
                    case 3:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), Double.valueOf(preferencesProto$Value.getDouble()));
                        break;
                    case 4:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), Integer.valueOf(preferencesProto$Value.getInteger()));
                        break;
                    case 5:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), Long.valueOf(preferencesProto$Value.getLong()));
                        break;
                    case 6:
                        mutablePreferences.setUnchecked$datastore_preferences_core(new Preferences$Key(str), preferencesProto$Value.getString());
                        break;
                    case 7:
                        Preferences$Key preferences$Key = new Preferences$Key(str);
                        Internal.ProtobufList stringsList = preferencesProto$Value.getStringSet().getStringsList();
                        stringsList.getClass();
                        mutablePreferences.setUnchecked$datastore_preferences_core(preferences$Key, CollectionsKt.toSet(stringsList));
                        break;
                    case 8:
                        Preferences$Key preferences$Key2 = new Preferences$Key(str);
                        ByteString$LiteralByteString bytes = preferencesProto$Value.getBytes();
                        int size = bytes.size();
                        if (size == 0) {
                            bArr = Internal.EMPTY_BYTE_ARRAY;
                        } else {
                            byte[] bArr2 = new byte[size];
                            bytes.copyToInternal(bArr2, size);
                            bArr = bArr2;
                        }
                        mutablePreferences.setUnchecked$datastore_preferences_core(preferences$Key2, bArr);
                        break;
                    case 9:
                        throw new CorruptionException("Value not set.", null);
                }
            }
            return new MutablePreferences(new LinkedHashMap(mutablePreferences.asMap()), true);
        } catch (InvalidProtocolBufferException e) {
            throw new CorruptionException("Unable to parse preferences proto.", e);
        }
    }

    public static void writeTo(Object obj, Buffer.C03821 c03821) throws IOException {
        GeneratedMessageLite generatedMessageLiteBuild;
        Map mapAsMap = ((MutablePreferences) obj).asMap();
        PreferencesProto$PreferenceMap.Builder builderNewBuilder = PreferencesProto$PreferenceMap.newBuilder();
        for (Map.Entry entry : mapAsMap.entrySet()) {
            Preferences$Key preferences$Key = (Preferences$Key) entry.getKey();
            Object value = entry.getValue();
            String str = preferences$Key.name;
            if (value instanceof Boolean) {
                PreferencesProto$Value.Builder builderNewBuilder2 = PreferencesProto$Value.newBuilder();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                builderNewBuilder2.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder2.instance).setBoolean(zBooleanValue);
                generatedMessageLiteBuild = builderNewBuilder2.build();
            } else if (value instanceof Float) {
                PreferencesProto$Value.Builder builderNewBuilder3 = PreferencesProto$Value.newBuilder();
                float fFloatValue = ((Number) value).floatValue();
                builderNewBuilder3.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder3.instance).setFloat(fFloatValue);
                generatedMessageLiteBuild = builderNewBuilder3.build();
            } else if (value instanceof Double) {
                PreferencesProto$Value.Builder builderNewBuilder4 = PreferencesProto$Value.newBuilder();
                double dDoubleValue = ((Number) value).doubleValue();
                builderNewBuilder4.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder4.instance).setDouble(dDoubleValue);
                generatedMessageLiteBuild = builderNewBuilder4.build();
            } else if (value instanceof Integer) {
                PreferencesProto$Value.Builder builderNewBuilder5 = PreferencesProto$Value.newBuilder();
                int iIntValue = ((Number) value).intValue();
                builderNewBuilder5.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder5.instance).setInteger(iIntValue);
                generatedMessageLiteBuild = builderNewBuilder5.build();
            } else if (value instanceof Long) {
                PreferencesProto$Value.Builder builderNewBuilder6 = PreferencesProto$Value.newBuilder();
                long jLongValue = ((Number) value).longValue();
                builderNewBuilder6.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder6.instance).setLong(jLongValue);
                generatedMessageLiteBuild = builderNewBuilder6.build();
            } else if (value instanceof String) {
                PreferencesProto$Value.Builder builderNewBuilder7 = PreferencesProto$Value.newBuilder();
                builderNewBuilder7.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder7.instance).setString((String) value);
                generatedMessageLiteBuild = builderNewBuilder7.build();
            } else if (value instanceof Set) {
                PreferencesProto$Value.Builder builderNewBuilder8 = PreferencesProto$Value.newBuilder();
                PreferencesProto$StringSet.Builder builderNewBuilder9 = PreferencesProto$StringSet.newBuilder();
                builderNewBuilder9.copyOnWrite();
                ((PreferencesProto$StringSet) builderNewBuilder9.instance).addAllStrings((Set) value);
                builderNewBuilder8.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder8.instance).setStringSet((PreferencesProto$StringSet) builderNewBuilder9.build());
                generatedMessageLiteBuild = builderNewBuilder8.build();
            } else {
                if (!(value instanceof byte[])) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                    return;
                }
                PreferencesProto$Value.Builder builderNewBuilder10 = PreferencesProto$Value.newBuilder();
                byte[] bArr = (byte[]) value;
                ByteString$LiteralByteString byteString$LiteralByteStringCopyFrom = ByteString$LiteralByteString.copyFrom(bArr, 0, bArr.length);
                builderNewBuilder10.copyOnWrite();
                ((PreferencesProto$Value) builderNewBuilder10.instance).setBytes(byteString$LiteralByteStringCopyFrom);
                generatedMessageLiteBuild = builderNewBuilder10.build();
            }
            builderNewBuilder.getClass();
            builderNewBuilder.copyOnWrite();
            ((PreferencesProto$PreferenceMap) builderNewBuilder.instance).internalGetMutablePreferences().put(str, (PreferencesProto$Value) generatedMessageLiteBuild);
        }
        PreferencesProto$PreferenceMap preferencesProto$PreferenceMap = (PreferencesProto$PreferenceMap) builderNewBuilder.build();
        int serializedSize = preferencesProto$PreferenceMap.getSerializedSize(null);
        Logger logger = CodedOutputStream$OutputStreamEncoder.logger;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = new CodedOutputStream$OutputStreamEncoder(c03821, serializedSize);
        preferencesProto$PreferenceMap.writeTo(codedOutputStream$OutputStreamEncoder);
        if (codedOutputStream$OutputStreamEncoder.position > 0) {
            codedOutputStream$OutputStreamEncoder.doFlush();
        }
    }
}
