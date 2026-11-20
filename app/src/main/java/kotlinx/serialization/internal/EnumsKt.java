package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EnumsKt {
    public static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];
    public static final KSerializer[] EMPTY_SERIALIZER_ARRAY = new KSerializer[0];
    public static final Object NULL = new Object();

    public static final InlineClassDescriptor InlinePrimitiveDescriptor(String str, final KSerializer kSerializer) {
        return new InlineClassDescriptor(str, new GeneratedSerializer() { // from class: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1
            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer[] childSerializers() {
                return new KSerializer[]{kSerializer};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                throw new IllegalStateException("unsupported");
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                throw new IllegalStateException("unsupported");
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                throw new IllegalStateException("unsupported");
            }
        });
    }

    public static final Set cachedSerialNames(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).getSerialNames();
        }
        HashSet hashSet = new HashSet(serialDescriptor.getElementsCount());
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            hashSet.add(serialDescriptor.getElementName(i));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] compactArray(List list) {
        SerialDescriptor[] serialDescriptorArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? EMPTY_DESCRIPTOR_ARRAY : serialDescriptorArr;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    public static final KSerializer constructSerializerForGivenTypeArgs(KClass kClass, KSerializer... kSerializerArr) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        KSerializer kSerializer;
        Field field;
        Object obj2;
        KSerializer kSerializerInvokeSerializerOnCompanion;
        Field field2;
        Serializable serializable;
        kClass.getClass();
        Class javaClass = Okio__OkioKt.getJavaClass(kClass);
        KSerializer[] kSerializerArr2 = (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length);
        if (javaClass.isEnum() && javaClass.getAnnotation(Serializable.class) == null && javaClass.getAnnotation(Polymorphic.class) == null) {
            Object[] enumConstants = javaClass.getEnumConstants();
            String canonicalName = javaClass.getCanonicalName();
            canonicalName.getClass();
            enumConstants.getClass();
            return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
        }
        KSerializer[] kSerializerArr3 = (KSerializer[]) Arrays.copyOf(kSerializerArr2, kSerializerArr2.length);
        PolymorphicSerializer polymorphicSerializer = null;
        try {
            Field declaredField = javaClass.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Throwable unused) {
            obj = null;
        }
        KSerializer kSerializerInvokeSerializerOnCompanion2 = obj == null ? null : invokeSerializerOnCompanion(obj, (KSerializer[]) Arrays.copyOf(kSerializerArr3, kSerializerArr3.length));
        if (kSerializerInvokeSerializerOnCompanion2 != null) {
            return kSerializerInvokeSerializerOnCompanion2;
        }
        String canonicalName2 = javaClass.getCanonicalName();
        if (canonicalName2 == null || StringsKt__StringsJVMKt.startsWith(canonicalName2, "java.", false) || StringsKt__StringsJVMKt.startsWith(canonicalName2, "kotlin.", false)) {
            kSerializer = null;
        } else {
            Field[] declaredFields = javaClass.getDeclaredFields();
            declaredFields.getClass();
            int length = declaredFields.length;
            Field field3 = null;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i >= length) {
                    if (!z) {
                        break;
                    }
                    break;
                }
                Field field4 = declaredFields[i];
                if (Intrinsics.areEqual(field4.getName(), "INSTANCE") && Intrinsics.areEqual(field4.getType(), javaClass) && Modifier.isStatic(field4.getModifiers())) {
                    if (!z) {
                        z = true;
                        field3 = field4;
                    }
                }
                i++;
                field3 = null;
                break;
            }
            if (field3 == null) {
                kSerializer = null;
            } else {
                Object obj3 = field3.get(null);
                Method[] methods = javaClass.getMethods();
                methods.getClass();
                int length2 = methods.length;
                Method method = null;
                int i2 = 0;
                boolean z2 = false;
                while (true) {
                    if (i2 >= length2) {
                        if (!z2) {
                            break;
                        }
                        break;
                    }
                    Method method2 = methods[i2];
                    if (Intrinsics.areEqual(method2.getName(), "serializer")) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        parameterTypes.getClass();
                        if (parameterTypes.length == 0 && Intrinsics.areEqual(method2.getReturnType(), KSerializer.class)) {
                            if (!z2) {
                                z2 = true;
                                method = method2;
                            }
                        }
                    }
                    i2++;
                    method = null;
                    break;
                }
                if (method == null) {
                    kSerializer = null;
                } else {
                    Object objInvoke = method.invoke(obj3, null);
                    if (objInvoke instanceof KSerializer) {
                        kSerializer = (KSerializer) objInvoke;
                    } else {
                        kSerializer = null;
                    }
                }
            }
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        KSerializer[] kSerializerArr4 = (KSerializer[]) Arrays.copyOf(kSerializerArr2, kSerializerArr2.length);
        Field[] declaredFields2 = javaClass.getDeclaredFields();
        declaredFields2.getClass();
        int length3 = declaredFields2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length3) {
                field = null;
                break;
            }
            field = declaredFields2[i3];
            if (Modifier.isStatic(field.getModifiers()) && field.getType().getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i3++;
        }
        if (field == null) {
            obj2 = null;
        } else {
            try {
                field.setAccessible(true);
                obj2 = field.get(null);
            } catch (Throwable unused2) {
                obj2 = null;
            }
        }
        if (obj2 == null || (kSerializerInvokeSerializerOnCompanion = invokeSerializerOnCompanion(obj2, (KSerializer[]) Arrays.copyOf(kSerializerArr4, kSerializerArr4.length))) == null) {
            try {
                Class<?>[] declaredClasses = javaClass.getDeclaredClasses();
                declaredClasses.getClass();
                int length4 = declaredClasses.length;
                Class<?> cls = null;
                int i4 = 0;
                boolean z3 = false;
                while (true) {
                    if (i4 < length4) {
                        Class<?> cls2 = declaredClasses[i4];
                        if (cls2.getSimpleName().equals("$serializer")) {
                            if (!z3) {
                                z3 = true;
                                cls = cls2;
                            }
                        }
                        i4++;
                    } else if (!z3) {
                    }
                    cls = null;
                    break;
                }
                Object obj4 = (cls == null || (field2 = cls.getField("INSTANCE")) == null) ? null : field2.get(null);
                kSerializerInvokeSerializerOnCompanion = obj4 instanceof KSerializer ? (KSerializer) obj4 : null;
            } catch (NoSuchFieldException unused3) {
            }
        }
        KSerializer kSerializer2 = kSerializerInvokeSerializerOnCompanion;
        if (kSerializer2 != null) {
            return kSerializer2;
        }
        if (javaClass.getAnnotation(Polymorphic.class) != null || ((serializable = (Serializable) javaClass.getAnnotation(Serializable.class)) != null && Reflection.getOrCreateKotlinClass(serializable.with()).equals(Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class)))) {
            polymorphicSerializer = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(javaClass));
        }
        return polymorphicSerializer;
    }

    public static final EnumSerializer createAnnotatedEnumSerializer(String str, Enum[] enumArr, String[] strArr, Annotation[][] annotationArr) {
        enumArr.getClass();
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, enumArr.length);
        int length = enumArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Enum r5 = enumArr[i];
            int i3 = i2 + 1;
            String strName = (String) ArraysKt.getOrNull(i2, strArr);
            if (strName == null) {
                strName = r5.name();
            }
            enumDescriptor.addElement(strName, false);
            Annotation[] annotationArr2 = (Annotation[]) ArraysKt.getOrNull(i2, annotationArr);
            if (annotationArr2 != null) {
                for (Annotation annotation : annotationArr2) {
                    enumDescriptor.pushAnnotation(annotation);
                }
            }
            i++;
            i2 = i3;
        }
        EnumSerializer enumSerializer = new EnumSerializer(str, enumArr);
        enumSerializer.overriddenDescriptor = enumDescriptor;
        return enumSerializer;
    }

    public static final int hashCodeImpl(SerialDescriptor serialDescriptor, SerialDescriptor[] serialDescriptorArr) {
        serialDescriptorArr.getClass();
        int iHashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(serialDescriptorArr);
        int elementsCount = serialDescriptor.getElementsCount();
        int i = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(elementsCount > 0)) {
                break;
            }
            int i2 = elementsCount - 1;
            int i3 = i * 31;
            String serialName = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount).getSerialName();
            if (serialName != null) {
                iHashCode2 = serialName.hashCode();
            }
            i = i3 + iHashCode2;
            elementsCount = i2;
        }
        int elementsCount2 = serialDescriptor.getElementsCount();
        int iHashCode3 = 1;
        while (true) {
            if (!(elementsCount2 > 0)) {
                return (((iHashCode * 31) + i) * 31) + iHashCode3;
            }
            int i4 = elementsCount2 - 1;
            int i5 = iHashCode3 * 31;
            Okio__OkioKt kind = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount2).getKind();
            iHashCode3 = i5 + (kind != null ? kind.hashCode() : 0);
            elementsCount2 = i4;
        }
    }

    public static final KSerializer invokeSerializerOnCompanion(Object obj, KSerializer... kSerializerArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (objInvoke instanceof KSerializer) {
                return (KSerializer) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final KClass kclass(KType kType) {
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KClass) {
            return (KClass) classifier;
        }
        if (!(classifier instanceof KTypeParameter)) {
            PathKt$$ExternalSyntheticBUOutline0.m$3(classifier, "Only KClass supported as classifier, got ");
            return null;
        }
        throw new IllegalArgumentException("Captured type parameter " + classifier + " from generic non-reified function. Such functionality cannot be supported because " + classifier + " is erased, either specify serializer explicitly or make calling function inline with reified " + classifier + '.');
    }

    public static final void serializerNotRegistered(KClass kClass) {
        kClass.getClass();
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = "<local class name not available>";
        }
        throw new SerializationException(IntIntPair$$ExternalSyntheticOutline0.m("Serializer for class '", simpleName, "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n"));
    }

    public static final void throwMissingFieldException(SerialDescriptor serialDescriptor, int i, int i2) {
        serialDescriptor.getClass();
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        for (int i4 = 0; i4 < 32; i4++) {
            if ((i3 & 1) != 0) {
                arrayList.add(serialDescriptor.getElementName(i4));
            }
            i3 >>>= 1;
        }
        String serialName = serialDescriptor.getSerialName();
        serialName.getClass();
        throw new MissingFieldException(arrayList.size() == 1 ? IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Field '"), (String) arrayList.get(0), "' is required for type with serial name '", serialName, "', but it was missing") : "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing", null, arrayList, serialName);
    }

    public static final void throwSubtypeNotRegistered(String str, KClass kClass) {
        String string;
        kClass.getClass();
        String str2 = "in the polymorphic scope of '" + kClass.getSimpleName() + '\'';
        if (str == null) {
            string = Format$$ExternalSyntheticOutline0.m('.', "Class discriminator was missing and no default serializers were registered ", str2);
        } else {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Serializer for subclass '", str, "' is not found ", str2, ".\nCheck if class with serial name '");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbM.append(kClass.getSimpleName());
            sbM.append("' has to be sealed and '@Serializable'.");
            string = sbM.toString();
        }
        throw new SerializationException(string);
    }

    public static final String toStringImpl(SerialDescriptor serialDescriptor) {
        return CollectionsKt.joinToString$default(UuidKt.until(0, serialDescriptor.getElementsCount()), ", ", serialDescriptor.getSerialName() + '(', ")", new PingPongKt$$ExternalSyntheticLambda0((byte) 10, (Object) serialDescriptor), 24);
    }
}
