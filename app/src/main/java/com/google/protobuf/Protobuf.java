package com.google.protobuf;

import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Protobuf {
    public static final Protobuf INSTANCE = new Protobuf();
    public final ConcurrentHashMap schemaCache = new ConcurrentHashMap();

    public Protobuf() {
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
    }

    /* JADX WARN: Code duplicated, block: B:197:0x0403  */
    /* JADX WARN: Code duplicated, block: B:212:0x0454  */
    public final Schema schemaFor(Class cls) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        char cCharAt;
        int i14;
        int i15;
        char cCharAt2;
        int i16;
        char cCharAt3;
        int i17;
        char cCharAt4;
        int i18;
        char cCharAt5;
        int i19;
        char cCharAt6;
        int i20;
        char cCharAt7;
        Schema messageSchema;
        int i21;
        int i22;
        int[] iArr2;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i23;
        int i24;
        int i25;
        Field fieldReflectField;
        int i26;
        char cCharAt8;
        int i27;
        int i28;
        Field fieldReflectField2;
        Field fieldReflectField3;
        int i29;
        char cCharAt9;
        int i30;
        char cCharAt10;
        int i31;
        int i32;
        char cCharAt11;
        int i33;
        int i34;
        char cCharAt12;
        ConcurrentHashMap concurrentHashMap = this.schemaCache;
        Object obj = concurrentHashMap.get(cls);
        if (obj != null) {
            return (Schema) obj;
        }
        Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            Class cls3 = Android.MEMORY_CLASS;
            Class cls4 = SchemaUtil.GENERATED_MESSAGE_CLASS;
            if (cls4 != null && !cls4.isAssignableFrom(cls)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                return null;
            }
        }
        Class cls5 = Android.MEMORY_CLASS;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Full runtime messages are not supported by this schema factory: ".concat(cls.getName()));
            return null;
        }
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            RawMessageInfo rawMessageInfo = (RawMessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
            int iCharAt2 = 0;
            if ((rawMessageInfo.flags & 2) == 2) {
                messageSchema = new MessageSetSchema(SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, rawMessageInfo.defaultInstance);
            } else {
                ExtensionSchemaLite extensionSchemaLite = SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA;
                ExtensionSchemaLite extensionSchemaLite2 = PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(rawMessageInfo.getSyntax()) != 1 ? Utf8.MobileProcessor.LITE_SCHEMA : null;
                Unsafe unsafe = MessageSchema.UNSAFE;
                if (unsafe == null) {
                    throw new RuntimeException("Lite gencode is primarily intended for Android use and uses sun.misc.Unsafe which is not available in the current environment. To run in this environment, you may need to switch to standard gencode.");
                }
                if (!(rawMessageInfo instanceof RawMessageInfo)) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                String str = rawMessageInfo.info;
                int length = str.length();
                if (str.charAt(0) >= 55296) {
                    int i35 = 1;
                    while (true) {
                        i = i35 + 1;
                        if (str.charAt(i35) < 55296) {
                            break;
                        }
                        i35 = i;
                    }
                } else {
                    i = 1;
                }
                int i36 = i + 1;
                int iCharAt3 = str.charAt(i);
                if (iCharAt3 >= 55296) {
                    int i37 = iCharAt3 & 8191;
                    int i38 = 13;
                    while (true) {
                        i34 = i36 + 1;
                        cCharAt12 = str.charAt(i36);
                        if (cCharAt12 < 55296) {
                            break;
                        }
                        i37 |= (cCharAt12 & 8191) << i38;
                        i38 += 13;
                        i36 = i34;
                    }
                    iCharAt3 = i37 | (cCharAt12 << i38);
                    i36 = i34;
                }
                if (iCharAt3 == 0) {
                    iArr = MessageSchema.EMPTY_INT_ARRAY;
                    i10 = 0;
                    i8 = 0;
                    i9 = 0;
                    iCharAt = 0;
                    i11 = 0;
                    i6 = i36;
                    i12 = 0;
                } else {
                    int i39 = i36 + 1;
                    int iCharAt4 = str.charAt(i36);
                    if (iCharAt4 >= 55296) {
                        int i40 = iCharAt4 & 8191;
                        int i41 = 13;
                        while (true) {
                            i20 = i39 + 1;
                            cCharAt7 = str.charAt(i39);
                            if (cCharAt7 < 55296) {
                                break;
                            }
                            i40 |= (cCharAt7 & 8191) << i41;
                            i41 += 13;
                            i39 = i20;
                        }
                        iCharAt4 = i40 | (cCharAt7 << i41);
                        i39 = i20;
                    }
                    int i42 = i39 + 1;
                    int iCharAt5 = str.charAt(i39);
                    if (iCharAt5 >= 55296) {
                        int i43 = iCharAt5 & 8191;
                        int i44 = 13;
                        while (true) {
                            i19 = i42 + 1;
                            cCharAt6 = str.charAt(i42);
                            if (cCharAt6 < 55296) {
                                break;
                            }
                            i43 |= (cCharAt6 & 8191) << i44;
                            i44 += 13;
                            i42 = i19;
                        }
                        iCharAt5 = i43 | (cCharAt6 << i44);
                        i42 = i19;
                    }
                    int i45 = i42 + 1;
                    iCharAt = str.charAt(i42);
                    if (iCharAt >= 55296) {
                        int i46 = iCharAt & 8191;
                        int i47 = i45;
                        int i48 = 13;
                        while (true) {
                            i18 = i47 + 1;
                            cCharAt5 = str.charAt(i47);
                            if (cCharAt5 < 55296) {
                                break;
                            }
                            i46 |= (cCharAt5 & 8191) << i48;
                            i48 += 13;
                            i47 = i18;
                        }
                        iCharAt = i46 | (cCharAt5 << i48);
                        i2 = i18;
                    } else {
                        i2 = i45;
                    }
                    int i49 = i2 + 1;
                    int iCharAt6 = str.charAt(i2);
                    if (iCharAt6 >= 55296) {
                        int i50 = iCharAt6 & 8191;
                        int i51 = i49;
                        int i52 = 13;
                        while (true) {
                            i17 = i51 + 1;
                            cCharAt4 = str.charAt(i51);
                            if (cCharAt4 < 55296) {
                                break;
                            }
                            i50 |= (cCharAt4 & 8191) << i52;
                            i52 += 13;
                            i51 = i17;
                        }
                        iCharAt6 = i50 | (cCharAt4 << i52);
                        i3 = i17;
                    } else {
                        i3 = i49;
                    }
                    int i53 = i3 + 1;
                    iCharAt2 = str.charAt(i3);
                    if (iCharAt2 >= 55296) {
                        int i54 = iCharAt2 & 8191;
                        int i55 = i53;
                        int i56 = 13;
                        while (true) {
                            i16 = i55 + 1;
                            cCharAt3 = str.charAt(i55);
                            if (cCharAt3 < 55296) {
                                break;
                            }
                            i54 |= (cCharAt3 & 8191) << i56;
                            i56 += 13;
                            i55 = i16;
                        }
                        iCharAt2 = i54 | (cCharAt3 << i56);
                        i4 = i16;
                    } else {
                        i4 = i53;
                    }
                    int i57 = i4 + 1;
                    int iCharAt7 = str.charAt(i4);
                    if (iCharAt7 >= 55296) {
                        int i58 = iCharAt7 & 8191;
                        int i59 = i57;
                        int i60 = 13;
                        while (true) {
                            i15 = i59 + 1;
                            cCharAt2 = str.charAt(i59);
                            if (cCharAt2 < 55296) {
                                break;
                            }
                            i58 |= (cCharAt2 & 8191) << i60;
                            i60 += 13;
                            i59 = i15;
                        }
                        iCharAt7 = i58 | (cCharAt2 << i60);
                        i5 = i15;
                    } else {
                        i5 = i57;
                    }
                    int i61 = i5 + 1;
                    if (str.charAt(i5) >= 55296) {
                        do {
                            i14 = i61;
                            i61 = i14 + 1;
                        } while (str.charAt(i14) >= 55296);
                    }
                    int i62 = i61;
                    i6 = i62 + 1;
                    int iCharAt8 = str.charAt(i62);
                    if (iCharAt8 >= 55296) {
                        int i63 = iCharAt8 & 8191;
                        int i64 = i6;
                        int i65 = 13;
                        while (true) {
                            i13 = i64 + 1;
                            cCharAt = str.charAt(i64);
                            i7 = iCharAt6;
                            if (cCharAt < 55296) {
                                break;
                            }
                            i63 |= (cCharAt & 8191) << i65;
                            i65 += 13;
                            i64 = i13;
                            iCharAt6 = i7;
                        }
                        iCharAt8 = i63 | (cCharAt << i65);
                        i6 = i13;
                    } else {
                        i7 = iCharAt6;
                    }
                    int[] iArr3 = new int[iCharAt8 + iCharAt7 + iCharAt4];
                    i8 = (iCharAt4 * 2) + iCharAt5;
                    int i66 = iCharAt7;
                    i9 = iCharAt8;
                    i10 = i66;
                    iArr = iArr3;
                    i11 = iCharAt4;
                    i12 = i7;
                }
                Object[] objArr = rawMessageInfo.objects;
                Class<?> cls6 = rawMessageInfo.defaultInstance.getClass();
                int i67 = i10;
                int[] iArr4 = new int[iCharAt2 * 3];
                Object[] objArr2 = new Object[iCharAt2 * 2];
                int i68 = i9 + i67;
                int i69 = i6;
                int i70 = i9;
                int i71 = i68;
                int i72 = 0;
                int i73 = 0;
                while (i69 < length) {
                    int i74 = i69 + 1;
                    int iCharAt9 = str.charAt(i69);
                    Object[] objArr3 = objArr2;
                    if (iCharAt9 >= 55296) {
                        int i75 = iCharAt9 & 8191;
                        int i76 = i74;
                        int i77 = 13;
                        while (true) {
                            i32 = i76 + 1;
                            cCharAt11 = str.charAt(i76);
                            i33 = i75;
                            if (cCharAt11 < 55296) {
                                break;
                            }
                            i75 = i33 | ((cCharAt11 & 8191) << i77);
                            i77 += 13;
                            i76 = i32;
                        }
                        iCharAt9 = i33 | (cCharAt11 << i77);
                        i21 = i32;
                    } else {
                        i21 = i74;
                    }
                    int i78 = i21 + 1;
                    int iCharAt10 = str.charAt(i21);
                    int i79 = iCharAt9;
                    if (iCharAt10 >= 55296) {
                        int i80 = iCharAt10 & 8191;
                        int i81 = i78;
                        int i82 = 13;
                        while (true) {
                            i30 = i81 + 1;
                            cCharAt10 = str.charAt(i81);
                            i31 = i80;
                            if (cCharAt10 < 55296) {
                                break;
                            }
                            i80 = i31 | ((cCharAt10 & 8191) << i82);
                            i82 += 13;
                            i81 = i30;
                        }
                        iCharAt10 = i31 | (cCharAt10 << i82);
                        i22 = i30;
                    } else {
                        i22 = i78;
                    }
                    int i83 = length;
                    int i84 = iCharAt10 & 255;
                    int i85 = i12;
                    if ((iCharAt10 & 1024) != 0) {
                        iArr[i72] = i73;
                        i72++;
                    }
                    int i86 = i8;
                    if (i84 >= 51) {
                        int i87 = i22 + 1;
                        int iCharAt11 = str.charAt(i22);
                        char c = 55296;
                        if (iCharAt11 >= 55296) {
                            int i88 = iCharAt11 & 8191;
                            int i89 = 13;
                            while (true) {
                                i29 = i87 + 1;
                                cCharAt9 = str.charAt(i87);
                                if (cCharAt9 < c) {
                                    break;
                                }
                                i88 |= (cCharAt9 & 8191) << i89;
                                i89 += 13;
                                i87 = i29;
                                c = 55296;
                            }
                            iCharAt11 = i88 | (cCharAt9 << i89);
                            i87 = i29;
                        }
                        int i90 = i84 - 51;
                        int i91 = iCharAt11;
                        if (i90 == 9 || i90 == 17) {
                            i28 = i86 + 1;
                            objArr3[((i73 / 3) * 2) + 1] = objArr[i86];
                        } else if (i90 != 12 || (!PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.equals(rawMessageInfo.getSyntax(), 1) && (iCharAt10 & 2048) == 0)) {
                            i28 = i86;
                        } else {
                            i28 = i86 + 1;
                            objArr3[((i73 / 3) * 2) + 1] = objArr[i86];
                        }
                        int i92 = i91 * 2;
                        Object obj2 = objArr[i92];
                        int i93 = i87;
                        if (obj2 instanceof Field) {
                            fieldReflectField2 = (Field) obj2;
                        } else {
                            fieldReflectField2 = MessageSchema.reflectField(cls6, (String) obj2);
                            objArr[i92] = fieldReflectField2;
                            iArr[i71] = i73;
                            i71++;
                        }
                        int i94 = i28;
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                        int i95 = i92 + 1;
                        Object obj3 = objArr[i95];
                        if (obj3 instanceof Field) {
                            fieldReflectField3 = (Field) obj3;
                        } else {
                            fieldReflectField3 = MessageSchema.reflectField(cls6, (String) obj3);
                            objArr[i95] = fieldReflectField3;
                        }
                        int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                        i9 = i9;
                        i8 = i94;
                        i25 = 0;
                        iObjectFieldOffset2 = iObjectFieldOffset4;
                        i24 = iObjectFieldOffset3;
                        iArr2 = iArr;
                        i23 = i93;
                    } else {
                        int i96 = i86 + 1;
                        Field fieldReflectField4 = MessageSchema.reflectField(cls6, (String) objArr[i86]);
                        if (i84 == 9 || i84 == 17) {
                            iArr2 = iArr;
                            objArr3[((i73 / 3) * 2) + 1] = fieldReflectField4.getType();
                        } else {
                            if (i84 == 27 || i84 == 49) {
                                iArr2 = iArr;
                                i27 = i86 + 2;
                                objArr3[((i73 / 3) * 2) + 1] = objArr[i96];
                            } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                                iArr2 = iArr;
                                if (rawMessageInfo.getSyntax() == 1 || (iCharAt10 & 2048) != 0) {
                                    i27 = i86 + 2;
                                    objArr3[((i73 / 3) * 2) + 1] = objArr[i96];
                                }
                                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                                if ((iCharAt10 & 4096) != 0 || i84 > 17) {
                                    iObjectFieldOffset2 = 1048575;
                                    i23 = i22;
                                    i24 = iObjectFieldOffset;
                                    i25 = 0;
                                } else {
                                    i23 = i22 + 1;
                                    int iCharAt12 = str.charAt(i22);
                                    if (iCharAt12 >= 55296) {
                                        int i97 = iCharAt12 & 8191;
                                        int i98 = 13;
                                        while (true) {
                                            i26 = i23 + 1;
                                            cCharAt8 = str.charAt(i23);
                                            if (cCharAt8 < 55296) {
                                                break;
                                            }
                                            i97 |= (cCharAt8 & 8191) << i98;
                                            i98 += 13;
                                            i23 = i26;
                                        }
                                        iCharAt12 = i97 | (cCharAt8 << i98);
                                        i23 = i26;
                                    }
                                    int i99 = (iCharAt12 / 32) + (i11 * 2);
                                    Object obj4 = objArr[i99];
                                    if (obj4 instanceof Field) {
                                        fieldReflectField = (Field) obj4;
                                    } else {
                                        fieldReflectField = MessageSchema.reflectField(cls6, (String) obj4);
                                        objArr[i99] = fieldReflectField;
                                    }
                                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                                    i25 = iCharAt12 % 32;
                                    i24 = iObjectFieldOffset;
                                }
                            } else {
                                if (i84 == 50) {
                                    int i100 = i70 + 1;
                                    iArr[i70] = i73;
                                    int i101 = (i73 / 3) * 2;
                                    int i102 = i86 + 2;
                                    objArr3[i101] = objArr[i96];
                                    if ((iCharAt10 & 2048) != 0) {
                                        i8 = i86 + 3;
                                        objArr3[i101 + 1] = objArr[i102];
                                        iArr2 = iArr;
                                        i70 = i100;
                                    } else {
                                        i8 = i102;
                                        i70 = i100;
                                        iArr2 = iArr;
                                    }
                                } else {
                                    iArr2 = iArr;
                                }
                                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                                if ((iCharAt10 & 4096) != 0) {
                                    iObjectFieldOffset2 = 1048575;
                                    i23 = i22;
                                    i24 = iObjectFieldOffset;
                                    i25 = 0;
                                } else {
                                    iObjectFieldOffset2 = 1048575;
                                    i23 = i22;
                                    i24 = iObjectFieldOffset;
                                    i25 = 0;
                                }
                            }
                            i8 = i27;
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                            if ((iCharAt10 & 4096) != 0) {
                                iObjectFieldOffset2 = 1048575;
                                i23 = i22;
                                i24 = iObjectFieldOffset;
                                i25 = 0;
                            } else {
                                iObjectFieldOffset2 = 1048575;
                                i23 = i22;
                                i24 = iObjectFieldOffset;
                                i25 = 0;
                            }
                        }
                        i8 = i96;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((iCharAt10 & 4096) != 0) {
                            iObjectFieldOffset2 = 1048575;
                            i23 = i22;
                            i24 = iObjectFieldOffset;
                            i25 = 0;
                        } else {
                            iObjectFieldOffset2 = 1048575;
                            i23 = i22;
                            i24 = iObjectFieldOffset;
                            i25 = 0;
                        }
                    }
                    int i103 = i73 + 1;
                    iArr4[i73] = i79;
                    int i104 = i73 + 2;
                    Unsafe unsafe2 = unsafe;
                    iArr4[i103] = ((iCharAt10 & 512) != 0 ? 536870912 : 0) | ((iCharAt10 & 256) != 0 ? WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE : 0) | ((iCharAt10 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i84 << 20) | i24;
                    i73 += 3;
                    iArr4[i104] = (i25 << 20) | iObjectFieldOffset2;
                    i69 = i23;
                    i9 = i9;
                    length = i83;
                    objArr2 = objArr3;
                    unsafe = unsafe2;
                    i12 = i85;
                    iArr = iArr2;
                    cls6 = cls6;
                    str = str;
                }
                messageSchema = new MessageSchema(iArr4, objArr2, iCharAt, i12, rawMessageInfo.defaultInstance, iArr, i9, i68, extensionSchemaLite, extensionSchemaLite2);
            }
            byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
            Schema schema = (Schema) concurrentHashMap.putIfAbsent(cls, messageSchema);
            return schema != null ? schema : messageSchema;
        } catch (Exception e) {
            PathKt$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
            return null;
        }
    }
}
