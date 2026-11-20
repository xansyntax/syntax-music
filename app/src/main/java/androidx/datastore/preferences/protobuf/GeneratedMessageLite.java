package androidx.datastore.preferences.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Builder implements Cloneable {
        public final GeneratedMessageLite defaultInstance;
        public GeneratedMessageLite instance;

        public Builder(GeneratedMessageLite generatedMessageLite) {
            this.defaultInstance = generatedMessageLite;
            if (generatedMessageLite.isMutable()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Default instance must be immutable.");
                throw null;
            }
            this.instance = generatedMessageLite.newMutableInstance$1();
        }

        public final GeneratedMessageLite build() {
            GeneratedMessageLite generatedMessageLiteBuildPartial = buildPartial();
            generatedMessageLiteBuildPartial.getClass();
            if (GeneratedMessageLite.isInitialized(generatedMessageLiteBuildPartial, true)) {
                return generatedMessageLiteBuildPartial;
            }
            throw new UninitializedMessageException();
        }

        public final GeneratedMessageLite buildPartial() {
            boolean zIsMutable = this.instance.isMutable();
            GeneratedMessageLite generatedMessageLite = this.instance;
            if (!zIsMutable) {
                return generatedMessageLite;
            }
            generatedMessageLite.getClass();
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(generatedMessageLite.getClass()).makeImmutable(generatedMessageLite);
            generatedMessageLite.markImmutable();
            return this.instance;
        }

        public final Object clone() {
            Builder builder = (Builder) this.defaultInstance.dynamicMethod(5);
            builder.instance = buildPartial();
            return builder;
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            GeneratedMessageLite generatedMessageLiteNewMutableInstance$1 = this.defaultInstance.newMutableInstance$1();
            GeneratedMessageLite generatedMessageLite = this.instance;
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(generatedMessageLiteNewMutableInstance$1.getClass()).mergeFrom(generatedMessageLiteNewMutableInstance$1, generatedMessageLite);
            this.instance = generatedMessageLiteNewMutableInstance$1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DefaultInstanceBasedParser implements Parser {
        static {
            ExtensionRegistryLite.getEmptyRegistry();
        }
    }

    public GeneratedMessageLite() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = UnknownFieldSetLite.DEFAULT_INSTANCE;
    }

    public static GeneratedMessageLite getDefaultInstance(Class cls) {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite != null) {
            return generatedMessageLite;
        }
        try {
            GeneratedMessageLite generatedMessageLite2 = (GeneratedMessageLite) ((GeneratedMessageLite) UnsafeUtil.UNSAFE.allocateInstance(cls)).dynamicMethod(6);
            if (generatedMessageLite2 != null) {
                defaultInstanceMap.put(cls, generatedMessageLite2);
                return generatedMessageLite2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return null;
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object invokeOrDie(Method method, GeneratedMessageLite generatedMessageLite, Object... objArr) {
        try {
            return method.invoke(generatedMessageLite, objArr);
        } catch (IllegalAccessException e) {
            PathKt$$ExternalSyntheticBUOutline0.m("Couldn't use Java reflection to implement protocol message reflection.", (Throwable) e);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            PathKt$$ExternalSyntheticBUOutline0.m("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static final boolean isInitialized(GeneratedMessageLite generatedMessageLite, boolean z) {
        byte bByteValue = ((Byte) generatedMessageLite.dynamicMethod(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        boolean zIsInitialized = protobuf.schemaFor(generatedMessageLite.getClass()).isInitialized(generatedMessageLite);
        if (z) {
            generatedMessageLite.dynamicMethod(2);
        }
        return zIsInitialized;
    }

    public static void registerDefaultInstance(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.markImmutable();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    public abstract Object dynamicMethod(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        return protobuf.schemaFor(getClass()).equals(this, (GeneratedMessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    public final int getSerializedSize(Schema schema) {
        int serializedSize;
        int serializedSize2;
        if (isMutable()) {
            if (schema == null) {
                Protobuf protobuf = Protobuf.INSTANCE;
                protobuf.getClass();
                serializedSize2 = protobuf.schemaFor(getClass()).getSerializedSize(this);
            } else {
                serializedSize2 = schema.getSerializedSize(this);
            }
            if (serializedSize2 >= 0) {
                return serializedSize2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(serializedSize2, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.memoizedSerializedSize;
        if ((i & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & Integer.MAX_VALUE;
        }
        if (schema == null) {
            Protobuf protobuf2 = Protobuf.INSTANCE;
            protobuf2.getClass();
            serializedSize = protobuf2.schemaFor(getClass()).getSerializedSize(this);
        } else {
            serializedSize = schema.getSerializedSize(this);
        }
        setMemoizedSerializedSize(serializedSize);
        return serializedSize;
    }

    public final int hashCode() {
        if (isMutable()) {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            return protobuf.schemaFor(getClass()).hashCode(this);
        }
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        Protobuf protobuf2 = Protobuf.INSTANCE;
        protobuf2.getClass();
        int iHashCode = protobuf2.schemaFor(getClass()).hashCode(this);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public final boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final GeneratedMessageLite newMutableInstance$1() {
        return (GeneratedMessageLite) dynamicMethod(4);
    }

    public final void setMemoizedSerializedSize(int i) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = MessageLiteToString.INDENT_BUFFER;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        MessageLiteToString.reflectivePrintWithIndent(this, sb, 0);
        return sb.toString();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    public final void writeTo(CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder) {
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        Schema schemaSchemaFor = protobuf.schemaFor(getClass());
        ManifestSchemaFactory manifestSchemaFactory = codedOutputStream$OutputStreamEncoder.wrapper;
        if (manifestSchemaFactory == null) {
            manifestSchemaFactory = new ManifestSchemaFactory(codedOutputStream$OutputStreamEncoder);
        }
        schemaSchemaFor.writeTo(this, manifestSchemaFactory);
    }
}
