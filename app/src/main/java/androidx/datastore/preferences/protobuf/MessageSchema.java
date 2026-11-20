package androidx.datastore.preferences.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.CharArrayPoolBase;
import okio.Path$$ExternalSyntheticBUOutline0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSchema implements Schema {
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Unsafe UNSAFE;
    public final int[] buffer;
    public final int checkInitializedCount;
    public final AbstractMessageLite defaultInstance;
    public final int[] intArray;
    public final ListFieldSchemaLite listFieldSchema;
    public final boolean lite;
    public final MapFieldSchemaLite mapFieldSchema;
    public final int maxFieldNumber;
    public final int minFieldNumber;
    public final NewInstanceSchemaLite newInstanceSchema;
    public final Object[] objects;
    public final int repeatedFieldOffsetStart;
    public final UnknownFieldSetLiteSchema unknownFieldSchema;

    static {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new UnsafeUtil.AnonymousClass1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        UNSAFE = unsafe;
    }

    public MessageSchema(int[] iArr, Object[] objArr, int i, int i2, AbstractMessageLite abstractMessageLite, int[] iArr2, int i3, int i4, NewInstanceSchemaLite newInstanceSchemaLite, ListFieldSchemaLite listFieldSchemaLite, UnknownFieldSetLiteSchema unknownFieldSetLiteSchema, ExtensionSchemaLite extensionSchemaLite, MapFieldSchemaLite mapFieldSchemaLite) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = abstractMessageLite instanceof GeneratedMessageLite;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchemaLite;
        this.listFieldSchema = listFieldSchemaLite;
        this.unknownFieldSchema = unknownFieldSetLiteSchema;
        this.defaultInstance = abstractMessageLite;
        this.mapFieldSchema = mapFieldSchemaLite;
    }

    public static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x026b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0272  */
    /* JADX WARN: Code duplicated, block: B:129:0x0288  */
    /* JADX WARN: Code duplicated, block: B:130:0x028b  */
    public static MessageSchema newSchema(RawMessageInfo rawMessageInfo, NewInstanceSchemaLite newInstanceSchemaLite, ListFieldSchemaLite listFieldSchemaLite, UnknownFieldSetLiteSchema unknownFieldSetLiteSchema, ExtensionSchemaLite extensionSchemaLite, MapFieldSchemaLite mapFieldSchemaLite) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        int iObjectFieldOffset3;
        Field fieldReflectField;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldReflectField2;
        int i26;
        Object obj2;
        Field fieldReflectField3;
        int i27;
        char cCharAt10;
        int i28;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(rawMessageInfo instanceof RawMessageInfo)) {
            PathKt$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        String str = rawMessageInfo.info;
        int length = str.length();
        char c = 55296;
        if (str.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (str.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = str.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = str.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i5 = 0;
            i7 = 0;
            iArr = EMPTY_INT_ARRAY;
            i4 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = str.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = str.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = str.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = str.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = str.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = str.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = str.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = str.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = str.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = str.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = str.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = str.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = str.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = str.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = str.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = str.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i60 = (iCharAt3 * 2) + iCharAt4;
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt3;
            i33 = i57;
            iArr = iArr2;
            i5 = iCharAt6;
            i6 = i60;
            i7 = iCharAt9;
        }
        Object[] objArr = rawMessageInfo.objects;
        Class<?> cls = rawMessageInfo.defaultInstance.getClass();
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[iCharAt * 2];
        int i62 = i7 + i3;
        int i63 = i62;
        int i64 = i7;
        int i65 = 0;
        int i66 = 0;
        while (i33 < length) {
            int i67 = i33 + 1;
            int iCharAt10 = str.charAt(i33);
            if (iCharAt10 >= c) {
                int i68 = iCharAt10 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i30 = i69 + 1;
                    cCharAt12 = str.charAt(i69);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i68 |= (cCharAt12 & 8191) << i70;
                    i70 += 13;
                    i69 = i30;
                }
                iCharAt10 = i68 | (cCharAt12 << i70);
                i16 = i30;
            } else {
                i16 = i67;
            }
            int i71 = i16 + 1;
            int iCharAt11 = str.charAt(i16);
            if (iCharAt11 >= c) {
                int i72 = iCharAt11 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i29 = i73 + 1;
                    cCharAt11 = str.charAt(i73);
                    i17 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i72 |= (cCharAt11 & 8191) << i74;
                    i74 += 13;
                    i73 = i29;
                    length = i17;
                }
                iCharAt11 = i72 | (cCharAt11 << i74);
                i18 = i29;
            } else {
                i17 = length;
                i18 = i71;
            }
            int i75 = iCharAt11 & 255;
            int i76 = iCharAt10;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i77 = i4;
            Unsafe unsafe = UNSAFE;
            if (i75 >= 51) {
                int i78 = i18 + 1;
                int iCharAt12 = str.charAt(i18);
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i27 = i80 + 1;
                        cCharAt10 = str.charAt(i80);
                        i28 = i79;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i79 = i28 | ((cCharAt10 & 8191) << i81);
                        i81 += 13;
                        i80 = i27;
                    }
                    iCharAt12 = i28 | (cCharAt10 << i81);
                    i23 = i27;
                } else {
                    i23 = i78;
                }
                int i82 = iCharAt12;
                int i83 = i75 - 51;
                int i84 = i23;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    objArr2[((i66 / 3) * 2) + 1] = objArr[i6];
                } else {
                    if (i83 == 12 && (PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.equals(rawMessageInfo.getSyntax(), 1) || (iCharAt11 & 2048) != 0)) {
                        i24 = i6 + 1;
                        objArr2[((i66 / 3) * 2) + 1] = objArr[i6];
                    }
                    i25 = i82 * 2;
                    obj = objArr[i25];
                    if (obj instanceof Field) {
                        fieldReflectField2 = (Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objArr[i25] = fieldReflectField2;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i26 = i25 + 1;
                    obj2 = objArr[i26];
                    if (obj2 instanceof Field) {
                        fieldReflectField3 = (Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objArr[i26] = fieldReflectField3;
                    }
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    objArr2 = objArr2;
                    i20 = i84;
                    i21 = 0;
                }
                i6 = i24;
                i25 = i82 * 2;
                obj = objArr[i25];
                if (obj instanceof Field) {
                    fieldReflectField2 = (Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objArr[i25] = fieldReflectField2;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i26 = i25 + 1;
                obj2 = objArr[i26];
                if (obj2 instanceof Field) {
                    fieldReflectField3 = (Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objArr[i26] = fieldReflectField3;
                }
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                objArr2 = objArr2;
                i20 = i84;
                i21 = 0;
            } else {
                int i85 = i6 + 1;
                Field fieldReflectField4 = reflectField(cls, (String) objArr[i6]);
                if (i75 == 9 || i75 == 17) {
                    i19 = i85;
                    objArr2[((i66 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i22 = i6 + 2;
                        objArr2[((i66 / 3) * 2) + 1] = objArr[i85];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i19 = i85;
                        if (rawMessageInfo.getSyntax() == 1 || (iCharAt11 & 2048) != 0) {
                            i22 = i6 + 2;
                            objArr2[((i66 / 3) * 2) + 1] = objArr[i19];
                        }
                    } else if (i75 == 50) {
                        int i86 = i64 + 1;
                        iArr[i64] = i66;
                        int i87 = (i66 / 3) * 2;
                        i19 = i6 + 2;
                        objArr2[i87] = objArr[i85];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr2[i87 + 1] = objArr[i19];
                            i19 = i6 + 3;
                        }
                        i64 = i86;
                    } else {
                        i19 = i85;
                    }
                    i19 = i22;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) == 0 || i75 > 17) {
                    iObjectFieldOffset2 = 1048575;
                    i20 = i18;
                    i21 = 0;
                } else {
                    int i88 = i18 + 1;
                    int iCharAt13 = str.charAt(i18);
                    if (iCharAt13 >= 55296) {
                        int i89 = iCharAt13 & 8191;
                        int i90 = 13;
                        while (true) {
                            i20 = i88 + 1;
                            cCharAt9 = str.charAt(i88);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i89 |= (cCharAt9 & 8191) << i90;
                            i90 += 13;
                            i88 = i20;
                        }
                        iCharAt13 = i89 | (cCharAt9 << i90);
                    } else {
                        i20 = i88;
                    }
                    int i91 = (iCharAt13 / 32) + (i77 * 2);
                    Object obj3 = objArr[i91];
                    if (obj3 instanceof Field) {
                        fieldReflectField = (Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls, (String) obj3);
                        objArr[i91] = fieldReflectField;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i21 = iCharAt13 % 32;
                }
                if (i75 < 18 || i75 > 49) {
                    iObjectFieldOffset3 = iObjectFieldOffset2;
                } else {
                    iArr[i63] = iObjectFieldOffset;
                    iObjectFieldOffset3 = iObjectFieldOffset2;
                    i63++;
                }
                i6 = i19;
            }
            int i92 = i66 + 1;
            iArr3[i66] = i76;
            int i93 = i66 + 2;
            String str2 = str;
            iArr3[i92] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | iObjectFieldOffset;
            i66 += 3;
            iArr3[i93] = (i21 << 20) | iObjectFieldOffset3;
            objArr2 = objArr2;
            str = str2;
            i33 = i20;
            length = i17;
            i4 = i77;
            iArr3 = iArr3;
            i62 = i62;
            c = 55296;
        }
        return new MessageSchema(iArr3, objArr2, i2, i5, rawMessageInfo.defaultInstance, iArr, i7, i62, newInstanceSchemaLite, listFieldSchemaLite, unknownFieldSetLiteSchema, extensionSchemaLite, mapFieldSchemaLite);
    }

    public static long offset(int i) {
        return i & 1048575;
    }

    public static int oneofIntAt(long j, Object obj) {
        return ((Integer) UnsafeUtil.getObject(j, obj)).intValue();
    }

    public static long oneofLongAt(long j, Object obj) {
        return ((Long) UnsafeUtil.getObject(j, obj)).longValue();
    }

    public static Field reflectField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Field ", str, " for ");
            sbM4m.append(cls.getName());
            sbM4m.append(" not found. Known fields are ");
            sbM4m.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM4m.toString());
        }
    }

    public static int type(int i) {
        return (i & 267386880) >>> 20;
    }

    public final boolean arePresentForEquals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2, int i) {
        return isFieldPresent(i, generatedMessageLite) == isFieldPresent(i, generatedMessageLite2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean equals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        int[] iArr = this.buffer;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean zSafeEquals = true;
            if (i < length) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long j = iTypeAndOffsetAt & 1048575;
                switch (type(iTypeAndOffsetAt)) {
                    case 0:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                            zSafeEquals = false;
                        } else {
                            com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.MEMORY_ACCESSOR;
                            if (Double.doubleToLongBits(memoryAccessor.getDouble(j, generatedMessageLite)) != Double.doubleToLongBits(memoryAccessor.getDouble(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                        }
                        break;
                    case 1:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                            zSafeEquals = false;
                        } else {
                            com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor2 = UnsafeUtil.MEMORY_ACCESSOR;
                            if (Float.floatToIntBits(memoryAccessor2.getFloat(j, generatedMessageLite)) != Float.floatToIntBits(memoryAccessor2.getFloat(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                        }
                        break;
                    case 2:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 3:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 4:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 5:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 6:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 7:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                            zSafeEquals = false;
                        } else {
                            com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor3 = UnsafeUtil.MEMORY_ACCESSOR;
                            if (memoryAccessor3.getBoolean(j, generatedMessageLite) != memoryAccessor3.getBoolean(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                        }
                        break;
                    case 8:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                            zSafeEquals = false;
                        }
                        break;
                    case 9:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                            zSafeEquals = false;
                        }
                        break;
                    case 10:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                            zSafeEquals = false;
                        }
                        break;
                    case 11:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 13:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 14:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 15:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 16:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                            zSafeEquals = false;
                        }
                        break;
                    case 17:
                        if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                            zSafeEquals = false;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zSafeEquals = SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2));
                        break;
                    case 50:
                        zSafeEquals = SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        if (UnsafeUtil.getInt(j2, generatedMessageLite) != UnsafeUtil.getInt(j2, generatedMessageLite2) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                            zSafeEquals = false;
                        }
                        break;
                }
                if (zSafeEquals) {
                    i += 3;
                }
            } else {
                this.unknownFieldSchema.getClass();
                if (generatedMessageLite.unknownFields.equals(generatedMessageLite2.unknownFields)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void filterMapUnknownEnumValues(int i, Object obj, Object obj2) {
        int i2 = this.buffer[i];
        if (UnsafeUtil.getObject(typeAndOffsetAt(i) & 1048575, obj) == null) {
            return;
        }
        getEnumFieldVerifier(i);
    }

    public final void getEnumFieldVerifier(int i) {
        if (this.objects[((i / 3) * 2) + 1] == null) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
    }

    public final Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.objects;
        Schema schema = (Schema) objArr[i2];
        if (schema != null) {
            return schema;
        }
        Schema schemaSchemaFor = Protobuf.INSTANCE.schemaFor((Class) objArr[i2 + 1]);
        objArr[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    /* JADX WARN: Code duplicated, block: B:88:0x01ce  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int getSerializedSize(GeneratedMessageLite generatedMessageLite) {
        int i;
        int iComputeTagSize;
        int iComputeTagSize2;
        int iComputeTagSize3;
        int iComputeUInt64SizeNoTag;
        int iComputeTagSize4;
        int iComputeUInt64SizeNoTag2;
        int iComputeTagSize5;
        int iComputeTagSize6;
        int iComputeTagSize7;
        int serializedSize;
        int iComputeUInt32SizeNoTag;
        int iComputeBytesSize;
        int iComputeTagSize8;
        int serializedSize2;
        int iComputeSizeFixed64List;
        int iComputeTagSize9;
        int size;
        int iComputeSizeUInt64ListNoTag;
        int iComputeTagSize10;
        int iComputeTagSize11;
        int size2;
        int iComputeTagSize12;
        int iComputeUInt32SizeNoTag2;
        int serializedSize3;
        int iComputeTagSize13;
        int iComputeTagSize14;
        int iComputeUInt64SizeNoTag3;
        int iComputeTagSize15;
        int iComputeUInt64SizeNoTag4;
        int i2;
        MessageSchema messageSchema = this;
        GeneratedMessageLite generatedMessageLite2 = generatedMessageLite;
        int i3 = 0;
        int i4 = 0;
        int iComputeBytesSize2 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = messageSchema.buffer;
            if (i3 >= iArr.length) {
                messageSchema.unknownFieldSchema.getClass();
                return generatedMessageLite2.unknownFields.getSerializedSize() + iComputeBytesSize2;
            }
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i3);
            int iType = type(iTypeAndOffsetAt);
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & 1048575;
            Unsafe unsafe = UNSAFE;
            if (iType <= 17) {
                if (i8 != i5) {
                    i4 = i8 == 1048575 ? 0 : unsafe.getInt(generatedMessageLite2, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iTypeAndOffsetAt & 1048575;
            if (iType >= FieldType.DOUBLE_LIST_PACKED.id) {
                byte b = FieldType.SINT64_LIST_PACKED.id;
            }
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j2 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(j2);
                        iComputeBytesSize2 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j3 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(j3);
                        iComputeBytesSize2 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i9 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(i9);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeBytesSize2 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize5 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize5 + 8;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize6 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) + 1;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        Object object = unsafe.getObject(generatedMessageLite2, j);
                        iComputeBytesSize2 = (object instanceof ByteString$LiteralByteString ? CodedOutputStream$OutputStreamEncoder.computeBytesSize(i6, (ByteString$LiteralByteString) object) : CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) object) + CodedOutputStream$OutputStreamEncoder.computeTagSize(i6)) + iComputeBytesSize2;
                    }
                    messageSchema = this;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        Object object2 = unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema = messageSchema.getMessageFieldSchema(i3);
                        Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize7 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        serializedSize = ((AbstractMessageLite) object2).getSerializedSize(messageFieldSchema);
                        iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(serializedSize);
                        i2 = iComputeUInt32SizeNoTag + serializedSize + iComputeTagSize7;
                        iComputeBytesSize2 += i2;
                    }
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeBytesSize = CodedOutputStream$OutputStreamEncoder.computeBytesSize(i6, (ByteString$LiteralByteString) unsafe.getObject(generatedMessageLite2, j));
                        iComputeBytesSize2 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i10 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(i10);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeBytesSize2 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i11 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(i11);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeBytesSize2 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize5 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize5 + 8;
                        iComputeBytesSize2 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i12 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((i12 >> 31) ^ (i12 << 1));
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeBytesSize2 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j4 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((j4 << 1) ^ (j4 >> 63));
                        iComputeBytesSize2 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        AbstractMessageLite abstractMessageLite = (AbstractMessageLite) unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(i3);
                        iComputeTagSize8 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * 2;
                        serializedSize2 = abstractMessageLite.getSerializedSize(messageFieldSchema2);
                        iComputeSizeFixed64List = serializedSize2 + iComputeTagSize8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 18:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 19:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list.size() == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = (CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * list.size()) + SchemaUtil.computeSizeInt64ListNoTag(list);
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list2.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag(list2);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls4 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list3.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag(list3);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 23:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 24:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls5 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size3 = list4.size();
                    iComputeBytesSize2 += size3 == 0 ? 0 : (CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) + 1) * size3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls6 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * size4;
                        for (int i13 = 0; i13 < size4; i13++) {
                            Object obj = list5.get(i13);
                            if (obj instanceof ByteString$LiteralByteString) {
                                int size5 = ((ByteString$LiteralByteString) obj).size();
                                iComputeTagSize9 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size5) + size5 + iComputeTagSize9;
                            } else {
                                iComputeTagSize9 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj) + iComputeTagSize9;
                            }
                        }
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Schema messageFieldSchema3 = messageSchema.getMessageFieldSchema(i3);
                    Class cls7 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        iComputeTagSize11 = 0;
                    } else {
                        iComputeTagSize11 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * size6;
                        for (int i14 = 0; i14 < size6; i14++) {
                            int serializedSize4 = ((AbstractMessageLite) list6.get(i14)).getSerializedSize(messageFieldSchema3);
                            iComputeTagSize11 += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(serializedSize4) + serializedSize4;
                        }
                    }
                    iComputeBytesSize2 += iComputeTagSize11;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls8 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size7 = list7.size();
                    if (size7 == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * size7;
                        for (int i15 = 0; i15 < list7.size(); i15++) {
                            int size8 = ((ByteString$LiteralByteString) list7.get(i15)).size();
                            iComputeTagSize9 += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size8) + size8;
                        }
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls9 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list8.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag(list8);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls10 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list9.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeEnumListNoTag(list9);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 31:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 32:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeBytesSize2 += iComputeSizeFixed64List;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls11 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list10.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag(list10);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls12 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list11.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag(list11);
                        iComputeTagSize10 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 35:
                    List list12 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls13 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 36:
                    List list13 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls14 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 37:
                    size2 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 38:
                    size2 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 39:
                    size2 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 40:
                    List list14 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls15 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 41:
                    List list15 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls16 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 42:
                    List list16 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls17 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 43:
                    size2 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 44:
                    size2 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 45:
                    List list17 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls18 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 46:
                    List list18 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls19 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 47:
                    size2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 48:
                    size2 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeBytesSize2 += iComputeUInt32SizeNoTag2 + iComputeTagSize12 + size2;
                    }
                    break;
                case 49:
                    List list19 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Schema messageFieldSchema4 = messageSchema.getMessageFieldSchema(i3);
                    Class cls20 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size9 = list19.size();
                    if (size9 == 0) {
                        serializedSize3 = 0;
                    } else {
                        serializedSize3 = 0;
                        for (int i16 = 0; i16 < size9; i16++) {
                            serializedSize3 += ((AbstractMessageLite) list19.get(i16)).getSerializedSize(messageFieldSchema4) + (CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * 2);
                        }
                    }
                    iComputeBytesSize2 += serializedSize3;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(generatedMessageLite2, j);
                    Object obj2 = messageSchema.objects[(i3 / 3) * 2];
                    messageSchema.mapFieldSchema.getClass();
                    MapFieldLite mapFieldLite = (MapFieldLite) object3;
                    MapEntryLite mapEntryLite = (MapEntryLite) obj2;
                    if (mapFieldLite.isEmpty()) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = 0;
                        for (Map.Entry entry : mapFieldLite.entrySet()) {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            mapEntryLite.getClass();
                            int iComputeTagSize16 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                            int iComputeSerializedSize = MapEntryLite.computeSerializedSize(mapEntryLite.metadata, key, value);
                            iComputeTagSize9 += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(iComputeSerializedSize) + iComputeSerializedSize + iComputeTagSize16;
                        }
                    }
                    iComputeBytesSize2 += iComputeTagSize9;
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(jOneofLongAt);
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeBytesSize2 += i2;
                    }
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt2 = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(jOneofLongAt2);
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeBytesSize2 += i2;
                    }
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(iOneofIntAt);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeSizeFixed64List = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) + 1;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        Object object4 = unsafe.getObject(generatedMessageLite2, j);
                        iComputeBytesSize2 = (object4 instanceof ByteString$LiteralByteString ? CodedOutputStream$OutputStreamEncoder.computeBytesSize(i6, (ByteString$LiteralByteString) object4) : CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) object4) + CodedOutputStream$OutputStreamEncoder.computeTagSize(i6)) + iComputeBytesSize2;
                    }
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        Object object5 = unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema5 = messageSchema.getMessageFieldSchema(i3);
                        Class cls21 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize7 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        serializedSize = ((AbstractMessageLite) object5).getSerializedSize(messageFieldSchema5);
                        iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(serializedSize);
                        i2 = iComputeUInt32SizeNoTag + serializedSize + iComputeTagSize7;
                        iComputeBytesSize2 += i2;
                    }
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeSizeFixed64List = CodedOutputStream$OutputStreamEncoder.computeBytesSize(i6, (ByteString$LiteralByteString) unsafe.getObject(generatedMessageLite2, j));
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt2 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(iOneofIntAt2);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt3 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(iOneofIntAt3);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt4 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iOneofIntAt4 >> 31) ^ (iOneofIntAt4 << 1));
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt3 = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jOneofLongAt3 << 1) ^ (jOneofLongAt3 >> 63));
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeBytesSize2 += i2;
                    }
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        AbstractMessageLite abstractMessageLite2 = (AbstractMessageLite) unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema6 = messageSchema.getMessageFieldSchema(i3);
                        iComputeTagSize8 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i6) * 2;
                        serializedSize2 = abstractMessageLite2.getSerializedSize(messageFieldSchema6);
                        iComputeSizeFixed64List = serializedSize2 + iComputeTagSize8;
                        iComputeBytesSize2 += iComputeSizeFixed64List;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d7 A[PHI: r3
      0x00d7: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x01f0, B:41:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int hashCode(GeneratedMessageLite generatedMessageLite) {
        int i;
        int iHashLong;
        int i2;
        int[] iArr = this.buffer;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int i5 = iArr[i4];
            long j = 1048575 & iTypeAndOffsetAt;
            int i6 = 1237;
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.MEMORY_ACCESSOR.getDouble(j, generatedMessageLite)));
                    i3 = iHashLong + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.MEMORY_ACCESSOR.getFloat(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 4:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case 5:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 6:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    boolean z = UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j, generatedMessageLite);
                    Charset charset = Internal.UTF_8;
                    if (z) {
                        i6 = 1231;
                    }
                    i3 = i6 + i2;
                    break;
                case 8:
                    i = i3 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(j, generatedMessageLite)).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(j, generatedMessageLite);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 11:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case 13:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case 14:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 15:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                    i3 = iHashLong + i;
                    break;
                case 16:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                    i3 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(j, generatedMessageLite);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(((Double) UnsafeUtil.getObject(j, generatedMessageLite)).doubleValue()));
                        i3 = iHashLong + i;
                    }
                    break;
                case 52:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Float.floatToIntBits(((Float) UnsafeUtil.getObject(j, generatedMessageLite)).floatValue());
                        i3 = iHashLong + i;
                    }
                    break;
                case 53:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(j, generatedMessageLite));
                        i3 = iHashLong + i;
                    }
                    break;
                case 54:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(j, generatedMessageLite));
                        i3 = iHashLong + i;
                    }
                    break;
                case 55:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 56:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(j, generatedMessageLite));
                        i3 = iHashLong + i;
                    }
                    break;
                case 57:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 58:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i2 = i3 * 53;
                        boolean zBooleanValue = ((Boolean) UnsafeUtil.getObject(j, generatedMessageLite)).booleanValue();
                        Charset charset2 = Internal.UTF_8;
                        if (zBooleanValue) {
                            i6 = 1231;
                        }
                        i3 = i6 + i2;
                    }
                    break;
                case 59:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(j, generatedMessageLite)).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 60:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 61:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 62:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 63:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 64:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 65:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(j, generatedMessageLite));
                        i3 = iHashLong + i;
                    }
                    break;
                case 66:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = oneofIntAt(j, generatedMessageLite);
                        i3 = iHashLong + i;
                    }
                    break;
                case 67:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(j, generatedMessageLite));
                        i3 = iHashLong + i;
                    }
                    break;
                case 68:
                    if (isOneofPresent(i5, i4, generatedMessageLite)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
            }
        }
        this.unknownFieldSchema.getClass();
        return generatedMessageLite.unknownFields.hashCode() + (i3 * 53);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f1 A[RETURN] */
    public final boolean isFieldPresent(int i, Object obj) {
        int i2 = this.buffer[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            if (((1 << (i2 >>> 20)) & UnsafeUtil.getInt(j, obj)) != 0) {
                return true;
            }
            return false;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long j2 = iTypeAndOffsetAt & 1048575;
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (Double.doubleToRawLongBits(UnsafeUtil.MEMORY_ACCESSOR.getDouble(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 1:
                if (Float.floatToRawIntBits(UnsafeUtil.MEMORY_ACCESSOR.getFloat(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 2:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 4:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 5:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 6:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 7:
                return UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j2, obj);
            case 8:
                Object object = UnsafeUtil.getObject(j2, obj);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString$LiteralByteString) {
                    return !ByteString$LiteralByteString.EMPTY.equals(object);
                }
                Path$$ExternalSyntheticBUOutline0.m();
                return false;
            case 9:
                if (UnsafeUtil.getObject(j2, obj) != null) {
                    return true;
                }
                return false;
            case 10:
                return !ByteString$LiteralByteString.EMPTY.equals(UnsafeUtil.getObject(j2, obj));
            case 11:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 13:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 14:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 15:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 16:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 17:
                if (UnsafeUtil.getObject(j2, obj) != null) {
                    return true;
                }
                return false;
            default:
                Path$$ExternalSyntheticBUOutline0.m();
                return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(Object obj) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int[] iArr = this.buffer;
            int i7 = iArr[i6];
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int i8 = iArr[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = UNSAFE.getInt(obj, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                int i11 = i4;
                i = i3;
                i2 = i11;
            }
            if ((268435456 & iTypeAndOffsetAt) == 0 || isFieldPresent(obj, i6, i, i2, i10)) {
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9 && iType != 17) {
                    if (iType != 27) {
                        if (iType == 60 || iType == 68) {
                            if (!isOneofPresent(i7, i6, obj) || getMessageFieldSchema(i6).isInitialized(UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj))) {
                                i5++;
                                i3 = i;
                                i4 = i2;
                            }
                        } else if (iType != 49) {
                            if (iType != 50) {
                                continue;
                            } else {
                                Object object = UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj);
                                this.mapFieldSchema.getClass();
                                MapFieldLite mapFieldLite = (MapFieldLite) object;
                                if (mapFieldLite.isEmpty()) {
                                    continue;
                                } else {
                                    if (((MapEntryLite) this.objects[(i6 / 3) * 2]).metadata.valueType.javaType != WireFormat$JavaType.MESSAGE) {
                                        continue;
                                    } else {
                                        Schema schemaSchemaFor = null;
                                        for (Object obj2 : mapFieldLite.values()) {
                                            if (schemaSchemaFor == null) {
                                                schemaSchemaFor = Protobuf.INSTANCE.schemaFor(obj2.getClass());
                                            }
                                            if (!schemaSchemaFor.isInitialized(obj2)) {
                                            }
                                        }
                                    }
                                }
                            }
                            i5++;
                            i3 = i;
                            i4 = i2;
                        }
                    }
                    List list = (List) UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        Schema messageFieldSchema = getMessageFieldSchema(i6);
                        for (int i12 = 0; i12 < list.size(); i12++) {
                            if (messageFieldSchema.isInitialized(list.get(i12))) {
                            }
                        }
                    }
                    i5++;
                    i3 = i;
                    i4 = i2;
                } else if (!isFieldPresent(obj, i6, i, i2, i10) || getMessageFieldSchema(i6).isInitialized(UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj))) {
                    i5++;
                    i3 = i;
                    i4 = i2;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean isOneofPresent(int i, int i2, Object obj) {
        return UnsafeUtil.getInt((long) (this.buffer[i2 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void makeImmutable(Object obj) {
        if (isMutable(obj)) {
            if (obj instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
                generatedMessageLite.setMemoizedSerializedSize(Integer.MAX_VALUE);
                generatedMessageLite.memoizedHashCode = 0;
                generatedMessageLite.markImmutable();
            }
            int[] iArr = this.buffer;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long j = 1048575 & iTypeAndOffsetAt;
                int iType = type(iTypeAndOffsetAt);
                Unsafe unsafe = UNSAFE;
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(i, obj)) {
                                    getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.getClass();
                                ProtobufArrayList protobufArrayList = (ProtobufArrayList) ((Internal.ProtobufList) UnsafeUtil.getObject(j, obj));
                                if (protobufArrayList.isMutable) {
                                    protobufArrayList.isMutable = false;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    this.mapFieldSchema.getClass();
                                    ((MapFieldLite) object).isMutable = false;
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (isOneofPresent(iArr[i], i, obj)) {
                        getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                    }
                } else if (isFieldPresent(i, obj)) {
                    getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                }
            }
            this.unknownFieldSchema.getClass();
            UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) obj).unknownFields;
            if (unknownFieldSetLite.isMutable) {
                unknownFieldSetLite.isMutable = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:160:0x082a A[Catch: all -> 0x0500, TryCatch #0 {all -> 0x0500, blocks: (B:158:0x0825, B:160:0x082a, B:161:0x082f, B:114:0x04fb, B:117:0x0503, B:118:0x051b, B:119:0x0533, B:120:0x054b, B:121:0x0563, B:122:0x057b, B:123:0x0593, B:124:0x05ab, B:125:0x05c3, B:126:0x05eb, B:127:0x060b, B:128:0x062b, B:129:0x064c, B:130:0x066d, B:131:0x0690, B:132:0x06b0, B:133:0x06c9, B:134:0x06f1, B:135:0x0702, B:136:0x0724, B:137:0x0745, B:138:0x0766, B:139:0x0786, B:140:0x07a6, B:141:0x07c5, B:142:0x07e7, B:148:0x0809), top: B:179:0x0825 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0839 A[LOOP:2: B:164:0x0837->B:165:0x0839, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x0850 A[LOOP:3: B:170:0x084e->B:171:0x0850, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x085a  */
    /* JADX WARN: Code duplicated, block: B:208:0x0835 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:? A[RETURN, SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void mergeFrom(Object obj, GapBuffer gapBuffer, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int[] iArr;
        int i;
        int i2;
        GapBuffer gapBuffer2;
        ExtensionRegistryLite extensionRegistryLite2;
        int i3;
        MessageSchema messageSchema = this;
        Object obj2 = obj;
        GapBuffer gapBuffer3 = gapBuffer;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        extensionRegistryLite3.getClass();
        if (!isMutable(obj2)) {
            PathKt$$ExternalSyntheticBUOutline0.m$3(obj2, "Mutating immutable message: ");
            return;
        }
        UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = messageSchema.unknownFieldSchema;
        int[] iArr2 = messageSchema.intArray;
        int i4 = messageSchema.repeatedFieldOffsetStart;
        int i5 = messageSchema.checkInitializedCount;
        UnknownFieldSetLite builderFromMessage = null;
        while (true) {
            try {
                int fieldNumber = gapBuffer3.getFieldNumber();
                int iPositionForFieldNumber = messageSchema.positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(iPositionForFieldNumber);
                    try {
                        try {
                            int iType = type(iTypeAndOffsetAt);
                            Unsafe unsafe = UNSAFE;
                            ListFieldSchemaLite listFieldSchemaLite = messageSchema.listFieldSchema;
                            switch (iType) {
                                case 0:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(1);
                                    try {
                                        try {
                                            UnsafeUtil.MEMORY_ACCESSOR.putDouble(obj, jOffset, ((CharArrayPoolBase) gapBuffer2.buffer).readDouble());
                                            obj2 = obj;
                                            messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                            obj2 = obj;
                                            try {
                                                unknownFieldSetLiteSchema.getClass();
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                                }
                                                if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                                    i3 = i2;
                                                    while (i5 < i3) {
                                                        messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                        i5++;
                                                    }
                                                    if (builderFromMessage == null) {
                                                        return;
                                                    }
                                                    ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                i = i2;
                                                while (i5 < i) {
                                                    messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                    i5++;
                                                }
                                                if (builderFromMessage != null) {
                                                    unknownFieldSetLiteSchema.getClass();
                                                    ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj2 = obj;
                                            i = i2;
                                            while (i5 < i) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage != null) {
                                                unknownFieldSetLiteSchema.getClass();
                                                ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                            }
                                            throw th;
                                        }
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                        obj2 = obj;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj2 = obj;
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 1:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset2 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(5);
                                    UnsafeUtil.MEMORY_ACCESSOR.putFloat(obj2, jOffset2, ((CharArrayPoolBase) gapBuffer2.buffer).readFloat());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 2:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset3 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putLong(obj2, jOffset3, ((CharArrayPoolBase) gapBuffer2.buffer).readInt64());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 3:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset4 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putLong(obj2, jOffset4, ((CharArrayPoolBase) gapBuffer2.buffer).readUInt64());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 4:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset5 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putInt(((CharArrayPoolBase) gapBuffer2.buffer).readInt32(), jOffset5, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 5:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset6 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(1);
                                    UnsafeUtil.putLong(obj2, jOffset6, ((CharArrayPoolBase) gapBuffer2.buffer).readFixed64());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 6:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset7 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(5);
                                    UnsafeUtil.putInt(((CharArrayPoolBase) gapBuffer2.buffer).readFixed32(), jOffset7, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 7:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset8 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.MEMORY_ACCESSOR.putBoolean(obj2, jOffset8, ((CharArrayPoolBase) gapBuffer2.buffer).readBool());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 8:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    messageSchema.readString(iTypeAndOffsetAt, gapBuffer2, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 9:
                                    messageSchema = messageSchema;
                                    iArr = iArr2;
                                    i2 = i4;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite) messageSchema.mutableMessageFieldForMerge(iPositionForFieldNumber, obj2);
                                    Schema messageFieldSchema = messageSchema.getMessageFieldSchema(iPositionForFieldNumber);
                                    gapBuffer2.requireWireType(2);
                                    gapBuffer2.mergeMessageFieldInternal(abstractMessageLite, messageFieldSchema, extensionRegistryLite2);
                                    unsafe.putObject(obj2, messageSchema.typeAndOffsetAt(iPositionForFieldNumber) & 1048575, abstractMessageLite);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 10:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    UnsafeUtil.putObject(obj2, offset(iTypeAndOffsetAt), gapBuffer2.readBytes());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 11:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset9 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putInt(((CharArrayPoolBase) gapBuffer2.buffer).readUInt32(), jOffset9, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case DictionaryEntry.PRONUNCIATION /* 12 */:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer2.requireWireType(0);
                                    int i6 = ((CharArrayPoolBase) gapBuffer2.buffer).readEnum();
                                    messageSchema.getEnumFieldVerifier(iPositionForFieldNumber);
                                    UnsafeUtil.putInt(i6, offset(iTypeAndOffsetAt), obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 13:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset10 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(5);
                                    UnsafeUtil.putInt(((CharArrayPoolBase) gapBuffer2.buffer).readSFixed32(), jOffset10, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 14:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset11 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(1);
                                    UnsafeUtil.putLong(obj2, jOffset11, ((CharArrayPoolBase) gapBuffer2.buffer).readSFixed64());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 15:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset12 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putInt(((CharArrayPoolBase) gapBuffer2.buffer).readSInt32(), jOffset12, obj2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 16:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset13 = offset(iTypeAndOffsetAt);
                                    gapBuffer2.requireWireType(0);
                                    UnsafeUtil.putLong(obj2, jOffset13, ((CharArrayPoolBase) gapBuffer2.buffer).readSInt64());
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 17:
                                    messageSchema = messageSchema;
                                    iArr = iArr2;
                                    i2 = i4;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    AbstractMessageLite abstractMessageLite2 = (AbstractMessageLite) messageSchema.mutableMessageFieldForMerge(iPositionForFieldNumber, obj2);
                                    Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(iPositionForFieldNumber);
                                    gapBuffer2.requireWireType(3);
                                    gapBuffer2.mergeGroupFieldInternal(abstractMessageLite2, messageFieldSchema2, extensionRegistryLite2);
                                    unsafe.putObject(obj2, messageSchema.typeAndOffsetAt(iPositionForFieldNumber) & 1048575, abstractMessageLite2);
                                    messageSchema.setFieldPresent(iPositionForFieldNumber, obj2);
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 18:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset14 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readDoubleList(ListFieldSchemaLite.mutableListAt(jOffset14, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 19:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset15 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readFloatList(ListFieldSchemaLite.mutableListAt(jOffset15, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 20:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset16 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readInt64List(ListFieldSchemaLite.mutableListAt(jOffset16, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 21:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset17 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readUInt64List(ListFieldSchemaLite.mutableListAt(jOffset17, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 22:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset18 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readInt32List(ListFieldSchemaLite.mutableListAt(jOffset18, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 23:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset19 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readFixed64List(ListFieldSchemaLite.mutableListAt(jOffset19, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 24:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset20 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readFixed32List(ListFieldSchemaLite.mutableListAt(jOffset20, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 25:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    long jOffset21 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer2.readBoolList(ListFieldSchemaLite.mutableListAt(jOffset21, obj2));
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 26:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    try {
                                        messageSchema.readStringList(iTypeAndOffsetAt, gapBuffer2, obj2);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                        unknownFieldSetLiteSchema.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                        }
                                        if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            i3 = i2;
                                            while (i5 < i3) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 27:
                                    iArr = iArr2;
                                    i2 = i4;
                                    try {
                                        messageSchema.readMessageList(obj2, iTypeAndOffsetAt, gapBuffer3, messageSchema.getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                        gapBuffer2 = gapBuffer3;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                        gapBuffer2 = gapBuffer3;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        unknownFieldSetLiteSchema.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                        }
                                        if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            i3 = i2;
                                            while (i5 < i3) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 28:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset22 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readBytesList(ListFieldSchemaLite.mutableListAt(jOffset22, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 29:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset23 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readUInt32List(ListFieldSchemaLite.mutableListAt(jOffset23, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 30:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset24 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    Internal.ProtobufList protobufListMutableListAt = ListFieldSchemaLite.mutableListAt(jOffset24, obj2);
                                    gapBuffer3.readEnumList(protobufListMutableListAt);
                                    messageSchema.getEnumFieldVerifier(iPositionForFieldNumber);
                                    SchemaUtil.filterUnknownEnumList(obj2, fieldNumber, protobufListMutableListAt, builderFromMessage, unknownFieldSetLiteSchema);
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 31:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset25 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSFixed32List(ListFieldSchemaLite.mutableListAt(jOffset25, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 32:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset26 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSFixed64List(ListFieldSchemaLite.mutableListAt(jOffset26, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 33:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset27 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSInt32List(ListFieldSchemaLite.mutableListAt(jOffset27, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 34:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset28 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSInt64List(ListFieldSchemaLite.mutableListAt(jOffset28, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 35:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset29 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readDoubleList(ListFieldSchemaLite.mutableListAt(jOffset29, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 36:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset30 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readFloatList(ListFieldSchemaLite.mutableListAt(jOffset30, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 37:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset31 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readInt64List(ListFieldSchemaLite.mutableListAt(jOffset31, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 38:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset32 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readUInt64List(ListFieldSchemaLite.mutableListAt(jOffset32, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 39:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset33 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readInt32List(ListFieldSchemaLite.mutableListAt(jOffset33, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 40:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset34 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readFixed64List(ListFieldSchemaLite.mutableListAt(jOffset34, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 41:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset35 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readFixed32List(ListFieldSchemaLite.mutableListAt(jOffset35, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 42:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset36 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readBoolList(ListFieldSchemaLite.mutableListAt(jOffset36, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 43:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset37 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readUInt32List(ListFieldSchemaLite.mutableListAt(jOffset37, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 44:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset38 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    Internal.ProtobufList protobufListMutableListAt2 = ListFieldSchemaLite.mutableListAt(jOffset38, obj2);
                                    gapBuffer3.readEnumList(protobufListMutableListAt2);
                                    messageSchema.getEnumFieldVerifier(iPositionForFieldNumber);
                                    SchemaUtil.filterUnknownEnumList(obj2, fieldNumber, protobufListMutableListAt2, builderFromMessage, unknownFieldSetLiteSchema);
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 45:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset39 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSFixed32List(ListFieldSchemaLite.mutableListAt(jOffset39, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 46:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset40 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSFixed64List(ListFieldSchemaLite.mutableListAt(jOffset40, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 47:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset41 = offset(iTypeAndOffsetAt);
                                    listFieldSchemaLite.getClass();
                                    gapBuffer3.readSInt32List(ListFieldSchemaLite.mutableListAt(jOffset41, obj2));
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema;
                                    gapBuffer2 = gapBuffer3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 48:
                                    iArr = iArr2;
                                    i2 = i4;
                                    try {
                                        long jOffset42 = offset(iTypeAndOffsetAt);
                                        listFieldSchemaLite.getClass();
                                        gapBuffer3.readSInt64List(ListFieldSchemaLite.mutableListAt(jOffset42, obj2));
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        gapBuffer2 = gapBuffer3;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        gapBuffer2 = gapBuffer3;
                                        unknownFieldSetLiteSchema.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                        }
                                        if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            i3 = i2;
                                            while (i5 < i3) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 49:
                                    iArr = iArr2;
                                    i2 = i4;
                                    obj2 = obj;
                                    try {
                                        messageSchema.readGroupList(obj2, offset(iTypeAndOffsetAt), gapBuffer, messageSchema.getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                        gapBuffer3 = gapBuffer;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        gapBuffer2 = gapBuffer3;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused6) {
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        gapBuffer2 = gapBuffer;
                                        unknownFieldSetLiteSchema.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                        }
                                        if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            i3 = i2;
                                            while (i5 < i3) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 50:
                                    iArr = iArr2;
                                    i2 = i4;
                                    try {
                                        messageSchema.mergeMap(obj2, iPositionForFieldNumber, messageSchema.objects[(iPositionForFieldNumber / 3) * 2], extensionRegistryLite3, gapBuffer3);
                                        obj2 = obj;
                                        gapBuffer2 = gapBuffer;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused7) {
                                        obj2 = obj;
                                        gapBuffer2 = gapBuffer;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema;
                                        unknownFieldSetLiteSchema.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                        }
                                        if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            i3 = i2;
                                            while (i5 < i3) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                i5++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj2 = obj;
                                        messageSchema = messageSchema;
                                        i = i2;
                                        while (i5 < i) {
                                            messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                            i5++;
                                        }
                                        if (builderFromMessage != null) {
                                            unknownFieldSetLiteSchema.getClass();
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                        throw th;
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 51:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset43 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(1);
                                    UnsafeUtil.putObject(obj2, jOffset43, Double.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readDouble()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 52:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset44 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(5);
                                    UnsafeUtil.putObject(obj2, jOffset44, Float.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readFloat()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 53:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset45 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset45, Long.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readInt64()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 54:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset46 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset46, Long.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readUInt64()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 55:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset47 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset47, Integer.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readInt32()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 56:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset48 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(1);
                                    UnsafeUtil.putObject(obj2, jOffset48, Long.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readFixed64()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 57:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset49 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(5);
                                    UnsafeUtil.putObject(obj2, jOffset49, Integer.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readFixed32()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 58:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset50 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset50, Boolean.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readBool()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 59:
                                    iArr = iArr2;
                                    i2 = i4;
                                    messageSchema.readString(iTypeAndOffsetAt, gapBuffer3, obj2);
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 60:
                                    iArr = iArr2;
                                    i2 = i4;
                                    AbstractMessageLite abstractMessageLite3 = (AbstractMessageLite) messageSchema.mutableOneofMessageFieldForMerge(fieldNumber, iPositionForFieldNumber, obj2);
                                    Schema messageFieldSchema3 = messageSchema.getMessageFieldSchema(iPositionForFieldNumber);
                                    gapBuffer3.requireWireType(2);
                                    gapBuffer3.mergeMessageFieldInternal(abstractMessageLite3, messageFieldSchema3, extensionRegistryLite3);
                                    unsafe.putObject(obj2, messageSchema.typeAndOffsetAt(iPositionForFieldNumber) & 1048575, abstractMessageLite3);
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 61:
                                    iArr = iArr2;
                                    i2 = i4;
                                    UnsafeUtil.putObject(obj2, offset(iTypeAndOffsetAt), gapBuffer3.readBytes());
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 62:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset51 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset51, Integer.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readUInt32()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 63:
                                    iArr = iArr2;
                                    i2 = i4;
                                    gapBuffer3.requireWireType(0);
                                    int i7 = ((CharArrayPoolBase) gapBuffer3.buffer).readEnum();
                                    messageSchema.getEnumFieldVerifier(iPositionForFieldNumber);
                                    UnsafeUtil.putObject(obj2, offset(iTypeAndOffsetAt), Integer.valueOf(i7));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 64:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset52 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(5);
                                    UnsafeUtil.putObject(obj2, jOffset52, Integer.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readSFixed32()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 65:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset53 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(1);
                                    UnsafeUtil.putObject(obj2, jOffset53, Long.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readSFixed64()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 66:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset54 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset54, Integer.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readSInt32()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 67:
                                    iArr = iArr2;
                                    i2 = i4;
                                    long jOffset55 = offset(iTypeAndOffsetAt);
                                    gapBuffer3.requireWireType(0);
                                    UnsafeUtil.putObject(obj2, jOffset55, Long.valueOf(((CharArrayPoolBase) gapBuffer3.buffer).readSInt64()));
                                    messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                case 68:
                                    try {
                                        AbstractMessageLite abstractMessageLite4 = (AbstractMessageLite) messageSchema.mutableOneofMessageFieldForMerge(fieldNumber, iPositionForFieldNumber, obj2);
                                        Schema messageFieldSchema4 = messageSchema.getMessageFieldSchema(iPositionForFieldNumber);
                                        gapBuffer3.requireWireType(3);
                                        gapBuffer3.mergeGroupFieldInternal(abstractMessageLite4, messageFieldSchema4, extensionRegistryLite3);
                                        iArr = iArr2;
                                        i2 = i4;
                                        try {
                                            try {
                                                unsafe.putObject(obj2, messageSchema.typeAndOffsetAt(iPositionForFieldNumber) & 1048575, abstractMessageLite4);
                                                messageSchema.setOneofPresent(fieldNumber, iPositionForFieldNumber, obj2);
                                                gapBuffer2 = gapBuffer3;
                                                extensionRegistryLite2 = extensionRegistryLite3;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                messageSchema = messageSchema;
                                                i = i2;
                                                while (i5 < i) {
                                                    messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                    i5++;
                                                }
                                                if (builderFromMessage != null) {
                                                    unknownFieldSetLiteSchema.getClass();
                                                    ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                                }
                                                throw th;
                                            }
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused8) {
                                            gapBuffer2 = gapBuffer3;
                                            extensionRegistryLite2 = extensionRegistryLite3;
                                            unknownFieldSetLiteSchema.getClass();
                                            if (builderFromMessage == null) {
                                                builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                            }
                                            if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                                i3 = i2;
                                                while (i5 < i3) {
                                                    messageSchema.filterMapUnknownEnumValues(iArr[i5], obj2, builderFromMessage);
                                                    i5++;
                                                }
                                                if (builderFromMessage == null) {
                                                    return;
                                                }
                                                ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                            }
                                        }
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused9) {
                                        iArr = iArr2;
                                        i2 = i4;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        iArr = iArr2;
                                        i2 = i4;
                                    }
                                    gapBuffer3 = gapBuffer2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    iArr2 = iArr;
                                    i4 = i2;
                                    messageSchema = messageSchema;
                                    break;
                                default:
                                    if (builderFromMessage == null) {
                                        unknownFieldSetLiteSchema.getClass();
                                        builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                                    }
                                    unknownFieldSetLiteSchema.getClass();
                                    if (UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer3, builderFromMessage)) {
                                        iArr = iArr2;
                                        i2 = i4;
                                        gapBuffer2 = gapBuffer3;
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        gapBuffer3 = gapBuffer2;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        iArr2 = iArr;
                                        i4 = i2;
                                        messageSchema = messageSchema;
                                    } else {
                                        while (i5 < i4) {
                                            messageSchema.filterMapUnknownEnumValues(iArr2[i5], obj2, builderFromMessage);
                                            i5++;
                                        }
                                        if (builderFromMessage == null) {
                                            return;
                                        }
                                    }
                                    break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused10) {
                            iArr = iArr2;
                            i2 = i4;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        messageSchema = messageSchema;
                        iArr = iArr2;
                        i2 = i4;
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    while (i5 < i4) {
                        messageSchema.filterMapUnknownEnumValues(iArr2[i5], obj2, builderFromMessage);
                        i5++;
                    }
                    if (builderFromMessage == null) {
                        return;
                    } else {
                        unknownFieldSetLiteSchema.getClass();
                    }
                } else {
                    unknownFieldSetLiteSchema.getClass();
                    if (builderFromMessage == null) {
                        builderFromMessage = UnknownFieldSetLiteSchema.getBuilderFromMessage(obj2);
                    }
                    if (!UnknownFieldSetLiteSchema.mergeOneFieldFrom(0, gapBuffer3, builderFromMessage)) {
                        while (i5 < i4) {
                            messageSchema.filterMapUnknownEnumValues(iArr2[i5], obj2, builderFromMessage);
                            i5++;
                        }
                        if (builderFromMessage == null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                messageSchema = messageSchema;
                iArr = iArr2;
                i = i4;
            }
        }
        ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
    }

    public final void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, GapBuffer gapBuffer) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException, InvalidProtocolBufferException.InvalidWireTypeException {
        long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
        Object object = UnsafeUtil.getObject(jTypeAndOffsetAt, obj);
        MapFieldSchemaLite mapFieldSchemaLite = this.mapFieldSchema;
        if (object == null) {
            mapFieldSchemaLite.getClass();
            object = MapFieldLite.EMPTY_MAP_FIELD.mutableCopy();
            UnsafeUtil.putObject(obj, jTypeAndOffsetAt, object);
        } else {
            mapFieldSchemaLite.getClass();
            if (!((MapFieldLite) object).isMutable) {
                Object objMutableCopy = MapFieldLite.EMPTY_MAP_FIELD.mutableCopy();
                MapFieldSchemaLite.mergeFrom(objMutableCopy, object);
                UnsafeUtil.putObject(obj, jTypeAndOffsetAt, objMutableCopy);
                object = objMutableCopy;
            }
        }
        mapFieldSchemaLite.getClass();
        MapFieldLite mapFieldLite = (MapFieldLite) object;
        MapEntryLite.Metadata metadata = ((MapEntryLite) obj2).metadata;
        gapBuffer.requireWireType(2);
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) gapBuffer.buffer;
        int iPushLimit = charArrayPoolBase.pushLimit(charArrayPoolBase.readUInt32());
        Object obj3 = metadata.defaultValue;
        Object field = "";
        Object field2 = obj3;
        while (true) {
            try {
                int fieldNumber = gapBuffer.getFieldNumber();
                if (fieldNumber == Integer.MAX_VALUE || charArrayPoolBase.isAtEnd()) {
                    break;
                }
                if (fieldNumber == 1) {
                    field = gapBuffer.readField(metadata.keyType, null, null);
                } else if (fieldNumber != 2) {
                    try {
                        if (!gapBuffer.skipField()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (!gapBuffer.skipField()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    }
                } else {
                    field2 = gapBuffer.readField(metadata.valueType, obj3.getClass(), extensionRegistryLite);
                }
            } catch (Throwable th) {
                charArrayPoolBase.popLimit(iPushLimit);
                throw th;
            }
        }
        mapFieldLite.put(field, field2);
        charArrayPoolBase.popLimit(iPushLimit);
    }

    public final void mergeMessage(int i, Object obj, Object obj2) {
        if (isFieldPresent(i, obj2)) {
            long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, jTypeAndOffsetAt);
            if (object == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(this.buffer[i], obj2);
                return;
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(i, obj)) {
                if (isMutable(object)) {
                    GeneratedMessageLite generatedMessageLiteNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance, object);
                    unsafe.putObject(obj, jTypeAndOffsetAt, generatedMessageLiteNewInstance);
                } else {
                    unsafe.putObject(obj, jTypeAndOffsetAt, object);
                }
                setFieldPresent(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jTypeAndOffsetAt);
            if (!isMutable(object2)) {
                GeneratedMessageLite generatedMessageLiteNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance2, object2);
                unsafe.putObject(obj, jTypeAndOffsetAt, generatedMessageLiteNewInstance2);
                object2 = generatedMessageLiteNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    public final void mergeOneofMessage(int i, Object obj, Object obj2) {
        int[] iArr = this.buffer;
        int i2 = iArr[i];
        if (isOneofPresent(i2, i, obj2)) {
            long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, jTypeAndOffsetAt);
            if (object == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(iArr[i], obj2);
                return;
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(i2, i, obj)) {
                if (isMutable(object)) {
                    GeneratedMessageLite generatedMessageLiteNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance, object);
                    unsafe.putObject(obj, jTypeAndOffsetAt, generatedMessageLiteNewInstance);
                } else {
                    unsafe.putObject(obj, jTypeAndOffsetAt, object);
                }
                setOneofPresent(i2, i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jTypeAndOffsetAt);
            if (!isMutable(object2)) {
                GeneratedMessageLite generatedMessageLiteNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance2, object2);
                unsafe.putObject(obj, jTypeAndOffsetAt, generatedMessageLiteNewInstance2);
                object2 = generatedMessageLiteNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    public final Object mutableMessageFieldForMerge(int i, Object obj) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
        if (!isFieldPresent(i, obj)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, jTypeAndOffsetAt);
        if (isMutable(object)) {
            return object;
        }
        GeneratedMessageLite generatedMessageLiteNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance, object);
        }
        return generatedMessageLiteNewInstance;
    }

    public final Object mutableOneofMessageFieldForMerge(int i, int i2, Object obj) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(i, i2, obj)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, typeAndOffsetAt(i2) & 1048575);
        if (isMutable(object)) {
            return object;
        }
        GeneratedMessageLite generatedMessageLiteNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(generatedMessageLiteNewInstance, object);
        }
        return generatedMessageLiteNewInstance;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final GeneratedMessageLite newInstance() {
        this.newInstanceSchema.getClass();
        return ((GeneratedMessageLite) this.defaultInstance).newMutableInstance$1();
    }

    public final int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        int[] iArr = this.buffer;
        int length = (iArr.length / 3) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void readGroupList(Object obj, long j, GapBuffer gapBuffer, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int tag;
        this.listFieldSchema.getClass();
        Internal.ProtobufList protobufListMutableListAt = ListFieldSchemaLite.mutableListAt(j, obj);
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) gapBuffer.buffer;
        int i = gapBuffer.capacity;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            GeneratedMessageLite generatedMessageLiteNewInstance = schema.newInstance();
            gapBuffer.mergeGroupFieldInternal(generatedMessageLiteNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(generatedMessageLiteNewInstance);
            ((ProtobufArrayList) protobufListMutableListAt).add(generatedMessageLiteNewInstance);
            if (charArrayPoolBase.isAtEnd() || gapBuffer.gapEnd != 0) {
                return;
            } else {
                tag = charArrayPoolBase.readTag();
            }
        } while (tag == i);
        gapBuffer.gapEnd = tag;
    }

    public final void readMessageList(Object obj, int i, GapBuffer gapBuffer, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int tag;
        this.listFieldSchema.getClass();
        Internal.ProtobufList protobufListMutableListAt = ListFieldSchemaLite.mutableListAt(i & 1048575, obj);
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) gapBuffer.buffer;
        int i2 = gapBuffer.capacity;
        if ((i2 & 7) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            GeneratedMessageLite generatedMessageLiteNewInstance = schema.newInstance();
            gapBuffer.mergeMessageFieldInternal(generatedMessageLiteNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(generatedMessageLiteNewInstance);
            ((ProtobufArrayList) protobufListMutableListAt).add(generatedMessageLiteNewInstance);
            if (charArrayPoolBase.isAtEnd() || gapBuffer.gapEnd != 0) {
                return;
            } else {
                tag = charArrayPoolBase.readTag();
            }
        } while (tag == i2);
        gapBuffer.gapEnd = tag;
    }

    public final void readString(int i, GapBuffer gapBuffer, Object obj) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException, InvalidProtocolBufferException.InvalidWireTypeException {
        if ((536870912 & i) != 0) {
            gapBuffer.requireWireType(2);
            UnsafeUtil.putObject(obj, i & 1048575, ((CharArrayPoolBase) gapBuffer.buffer).readStringRequireUtf8());
        } else if (!this.lite) {
            UnsafeUtil.putObject(obj, i & 1048575, gapBuffer.readBytes());
        } else {
            gapBuffer.requireWireType(2);
            UnsafeUtil.putObject(obj, i & 1048575, ((CharArrayPoolBase) gapBuffer.buffer).readString());
        }
    }

    public final void readStringList(int i, GapBuffer gapBuffer, Object obj) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException, InvalidProtocolBufferException.InvalidWireTypeException {
        boolean z = (536870912 & i) != 0;
        ListFieldSchemaLite listFieldSchemaLite = this.listFieldSchema;
        if (z) {
            listFieldSchemaLite.getClass();
            gapBuffer.readStringListInternal(ListFieldSchemaLite.mutableListAt(i & 1048575, obj), true);
        } else {
            listFieldSchemaLite.getClass();
            gapBuffer.readStringListInternal(ListFieldSchemaLite.mutableListAt(i & 1048575, obj), false);
        }
    }

    public final void setFieldPresent(int i, Object obj) {
        int i2 = this.buffer[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt((1 << (i2 >>> 20)) | UnsafeUtil.getInt(j, obj), j, obj);
    }

    public final void setOneofPresent(int i, int i2, Object obj) {
        UnsafeUtil.putInt(i, this.buffer[i2 + 2] & 1048575, obj);
    }

    public final int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void writeTo(Object obj, ManifestSchemaFactory manifestSchemaFactory) throws IOException {
        int i;
        int i2;
        boolean z;
        MessageSchema messageSchema = this;
        manifestSchemaFactory.getClass();
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int[] iArr = messageSchema.buffer;
        int length = iArr.length;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i5);
            int i7 = iArr[i5];
            int iType = type(iTypeAndOffsetAt);
            Unsafe unsafe = UNSAFE;
            if (iType <= 17) {
                int i8 = iArr[i5 + 2];
                i = 1;
                int i9 = i8 & i3;
                if (i9 != i4) {
                    i6 = i9 == i3 ? 0 : unsafe.getInt(obj, i9);
                    i4 = i9;
                }
                i2 = 1 << (i8 >>> 20);
            } else {
                i = 1;
                i2 = 0;
            }
            long j = iTypeAndOffsetAt & i3;
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, Double.doubleToRawLongBits(UnsafeUtil.MEMORY_ACCESSOR.getDouble(j, obj)));
                    }
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, Float.floatToRawIntBits(UnsafeUtil.MEMORY_ACCESSOR.getFloat(j, obj)));
                    }
                    messageSchema = this;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeInt32(i7, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeBool(i7, UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j, obj));
                    }
                    messageSchema = this;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            codedOutputStream$OutputStreamEncoder.writeString(i7, (String) object);
                        } else {
                            codedOutputStream$OutputStreamEncoder.writeBytes(i7, (ByteString$LiteralByteString) object);
                        }
                    }
                    messageSchema = this;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeMessage(i7, (AbstractMessageLite) unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i5));
                    }
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeBytes(i7, (ByteString$LiteralByteString) unsafe.getObject(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt32(i7, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeInt32(i7, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        int i10 = unsafe.getInt(obj, j);
                        codedOutputStream$OutputStreamEncoder.writeUInt32(i7, (i10 >> 31) ^ (i10 << 1));
                    }
                    messageSchema = this;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        long j2 = unsafe.getLong(obj, j);
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, (j2 >> 63) ^ (j2 << 1));
                    }
                    messageSchema = this;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(obj, i5, i4, i6, i2)) {
                        manifestSchemaFactory.writeGroup(i7, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i5));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 26:
                    int i11 = iArr[i5];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list != null && !list.isEmpty()) {
                        for (int i12 = 0; i12 < list.size(); i12++) {
                            codedOutputStream$OutputStreamEncoder.writeString(i11, (String) list.get(i12));
                        }
                    }
                    break;
                case 27:
                    int i13 = iArr[i5];
                    List list2 = (List) unsafe.getObject(obj, j);
                    Schema messageFieldSchema = messageSchema.getMessageFieldSchema(i5);
                    Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i14 = 0; i14 < list2.size(); i14++) {
                            codedOutputStream$OutputStreamEncoder.writeMessage(i13, (AbstractMessageLite) list2.get(i14), messageFieldSchema);
                        }
                    }
                    break;
                case 28:
                    int i15 = iArr[i5];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i16 = 0; i16 < list3.size(); i16++) {
                            codedOutputStream$OutputStreamEncoder.writeBytes(i15, (ByteString$LiteralByteString) list3.get(i16));
                        }
                    }
                    break;
                case 29:
                    z = false;
                    SchemaUtil.writeUInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 30:
                    z = false;
                    SchemaUtil.writeEnumList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 31:
                    z = false;
                    SchemaUtil.writeSFixed32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 32:
                    z = false;
                    SchemaUtil.writeSFixed64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 33:
                    z = false;
                    SchemaUtil.writeSInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 34:
                    z = false;
                    SchemaUtil.writeSInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, i);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(iArr[i5], (List) unsafe.getObject(obj, j), manifestSchemaFactory, true);
                    break;
                case 49:
                    int i17 = iArr[i5];
                    List list4 = (List) unsafe.getObject(obj, j);
                    Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(i5);
                    Class cls4 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            manifestSchemaFactory.writeGroup(i17, list4.get(i18), messageFieldSchema2);
                        }
                    }
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j);
                    if (object2 != null) {
                        int i19 = 2;
                        Object obj2 = messageSchema.objects[(i5 / 3) * 2];
                        messageSchema.mapFieldSchema.getClass();
                        MapEntryLite.Metadata metadata = ((MapEntryLite) obj2).metadata;
                        for (Map.Entry entry : ((MapFieldLite) object2).entrySet()) {
                            codedOutputStream$OutputStreamEncoder.writeTag(i7, i19);
                            codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            FieldSet.writeElement(codedOutputStream$OutputStreamEncoder, metadata.keyType, i, key);
                            i19 = 2;
                            FieldSet.writeElement(codedOutputStream$OutputStreamEncoder, metadata.valueType, 2, value);
                            i = 1;
                        }
                    }
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, Double.doubleToRawLongBits(((Double) UnsafeUtil.getObject(j, obj)).doubleValue()));
                    }
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, Float.floatToRawIntBits(((Float) UnsafeUtil.getObject(j, obj)).floatValue()));
                    }
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, oneofLongAt(j, obj));
                    }
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, oneofLongAt(j, obj));
                    }
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeInt32(i7, oneofIntAt(j, obj));
                    }
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, oneofLongAt(j, obj));
                    }
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, oneofIntAt(j, obj));
                    }
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeBool(i7, ((Boolean) UnsafeUtil.getObject(j, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof String) {
                            codedOutputStream$OutputStreamEncoder.writeString(i7, (String) object3);
                        } else {
                            codedOutputStream$OutputStreamEncoder.writeBytes(i7, (ByteString$LiteralByteString) object3);
                        }
                    }
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeMessage(i7, (AbstractMessageLite) unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i5));
                    }
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeBytes(i7, (ByteString$LiteralByteString) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeUInt32(i7, oneofIntAt(j, obj));
                    }
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeInt32(i7, oneofIntAt(j, obj));
                    }
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed32(i7, oneofIntAt(j, obj));
                    }
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        codedOutputStream$OutputStreamEncoder.writeFixed64(i7, oneofLongAt(j, obj));
                    }
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        int iOneofIntAt = oneofIntAt(j, obj);
                        codedOutputStream$OutputStreamEncoder.writeUInt32(i7, (iOneofIntAt >> 31) ^ (iOneofIntAt << 1));
                    }
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        long jOneofLongAt = oneofLongAt(j, obj);
                        codedOutputStream$OutputStreamEncoder.writeUInt64(i7, (jOneofLongAt << i) ^ (jOneofLongAt >> 63));
                    }
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(i7, i5, obj)) {
                        manifestSchemaFactory.writeGroup(i7, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i5));
                    }
                    break;
                default:
                    break;
            }
            i5 += 3;
            i3 = 1048575;
        }
        messageSchema.unknownFieldSchema.getClass();
        ((GeneratedMessageLite) obj).unknownFields.writeTo(manifestSchemaFactory);
    }

    public final boolean isFieldPresent(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(i, obj);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void mergeFrom(Object obj, Object obj2) {
        Object obj3;
        if (isMutable(obj)) {
            obj2.getClass();
            int i = 0;
            while (true) {
                int[] iArr = this.buffer;
                if (i < iArr.length) {
                    int iTypeAndOffsetAt = typeAndOffsetAt(i);
                    long j = 1048575 & iTypeAndOffsetAt;
                    int i2 = iArr[i];
                    switch (type(iTypeAndOffsetAt)) {
                        case 0:
                            if (!isFieldPresent(i, obj2)) {
                                obj3 = obj;
                            } else {
                                com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.MEMORY_ACCESSOR;
                                obj3 = obj;
                                memoryAccessor.putDouble(obj3, j, memoryAccessor.getDouble(j, obj2));
                                setFieldPresent(i, obj3);
                            }
                            break;
                        case 1:
                            if (isFieldPresent(i, obj2)) {
                                com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor2 = UnsafeUtil.MEMORY_ACCESSOR;
                                memoryAccessor2.putFloat(obj, j, memoryAccessor2.getFloat(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 2:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 3:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 4:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 5:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 6:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 7:
                            if (isFieldPresent(i, obj2)) {
                                com.google.protobuf.UnsafeUtil.MemoryAccessor memoryAccessor3 = UnsafeUtil.MEMORY_ACCESSOR;
                                memoryAccessor3.putBoolean(obj, j, memoryAccessor3.getBoolean(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 8:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 9:
                            mergeMessage(i, obj, obj2);
                            obj3 = obj;
                            break;
                        case 10:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 11:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 13:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 14:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 15:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 16:
                            if (isFieldPresent(i, obj2)) {
                                UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                                setFieldPresent(i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 17:
                            mergeMessage(i, obj, obj2);
                            obj3 = obj;
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.listFieldSchema.getClass();
                            Internal.ProtobufList protobufListMutableCopyWithCapacity = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj2);
                            int i3 = ((ProtobufArrayList) protobufListMutableCopyWithCapacity).size;
                            int i4 = ((ProtobufArrayList) protobufList).size;
                            if (i3 > 0 && i4 > 0) {
                                if (!((ProtobufArrayList) protobufListMutableCopyWithCapacity).isMutable) {
                                    protobufListMutableCopyWithCapacity = ((ProtobufArrayList) protobufListMutableCopyWithCapacity).mutableCopyWithCapacity(i4 + i3);
                                }
                                ((ProtobufArrayList) protobufListMutableCopyWithCapacity).addAll(protobufList);
                            }
                            if (i3 > 0) {
                                protobufList = protobufListMutableCopyWithCapacity;
                            }
                            UnsafeUtil.putObject(obj, j, protobufList);
                            obj3 = obj;
                            break;
                        case 50:
                            Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                            Object object = UnsafeUtil.getObject(j, obj);
                            Object object2 = UnsafeUtil.getObject(j, obj2);
                            this.mapFieldSchema.getClass();
                            UnsafeUtil.putObject(obj, j, MapFieldSchemaLite.mergeFrom(object, object2));
                            obj3 = obj;
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (isOneofPresent(i2, i, obj2)) {
                                UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                                setOneofPresent(i2, i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 60:
                            mergeOneofMessage(i, obj, obj2);
                            obj3 = obj;
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (isOneofPresent(i2, i, obj2)) {
                                UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                                setOneofPresent(i2, i, obj);
                            }
                            obj3 = obj;
                            break;
                        case 68:
                            mergeOneofMessage(i, obj, obj2);
                            obj3 = obj;
                            break;
                        default:
                            obj3 = obj;
                            break;
                    }
                    i += 3;
                    obj = obj3;
                } else {
                    SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
                    return;
                }
            }
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$3(obj, "Mutating immutable message: ");
        }
    }
}
