package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.GapBuffer;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static final Map<Class<?>, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DefaultInstanceBasedParser implements Parser {
        static {
            ExtensionRegistryLite.getEmptyRegistry();
        }

        public DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExtensionDescriptor implements Comparable {
        public final int number;
        public final WireFormat$FieldType type;

        public ExtensionDescriptor(int i, WireFormat$FieldType wireFormat$FieldType, boolean z, boolean z2) {
            this.number = i;
            this.type = wireFormat$FieldType;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.number - ((ExtensionDescriptor) obj).number;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class GeneratedExtension extends ExtensionLite {
        public final Object defaultValue;

        public GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor) {
            if (messageLite == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Null containingTypeDefaultInstance");
                throw null;
            }
            if (extensionDescriptor.type == WireFormat$FieldType.MESSAGE && messageLite2 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Null messageDefaultInstance");
                throw null;
            }
            this.defaultValue = obj;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MethodToInvoke {
        public static final /* synthetic */ MethodToInvoke[] $VALUES;
        public static final MethodToInvoke BUILD_MESSAGE_INFO;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE;
        public static final MethodToInvoke GET_MEMOIZED_IS_INITIALIZED;
        public static final MethodToInvoke GET_PARSER;
        public static final MethodToInvoke NEW_BUILDER;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE;
        public static final MethodToInvoke SET_MEMOIZED_IS_INITIALIZED;

        static {
            MethodToInvoke methodToInvoke = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            GET_MEMOIZED_IS_INITIALIZED = methodToInvoke;
            MethodToInvoke methodToInvoke2 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            SET_MEMOIZED_IS_INITIALIZED = methodToInvoke2;
            MethodToInvoke methodToInvoke3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            BUILD_MESSAGE_INFO = methodToInvoke3;
            MethodToInvoke methodToInvoke4 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            NEW_MUTABLE_INSTANCE = methodToInvoke4;
            MethodToInvoke methodToInvoke5 = new MethodToInvoke("NEW_BUILDER", 4);
            NEW_BUILDER = methodToInvoke5;
            MethodToInvoke methodToInvoke6 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            GET_DEFAULT_INSTANCE = methodToInvoke6;
            MethodToInvoke methodToInvoke7 = new MethodToInvoke("GET_PARSER", 6);
            GET_PARSER = methodToInvoke7;
            $VALUES = new MethodToInvoke[]{methodToInvoke, methodToInvoke2, methodToInvoke3, methodToInvoke4, methodToInvoke5, methodToInvoke6, methodToInvoke7};
        }

        public static MethodToInvoke valueOf(String str) {
            return (MethodToInvoke) Enum.valueOf(MethodToInvoke.class, str);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }
    }

    public GeneratedMessageLite() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = UnknownFieldSetLite.DEFAULT_INSTANCE;
    }

    public static GeneratedExtension access$100(ExtensionLite extensionLite) {
        extensionLite.getClass();
        return (GeneratedExtension) extensionLite;
    }

    public static void checkMessageInitialized(GeneratedMessageLite generatedMessageLite) throws InvalidProtocolBufferException {
        if (generatedMessageLite != null && !generatedMessageLite.isInitialized()) {
            throw new InvalidProtocolBufferException(generatedMessageLite.newUninitializedMessageException().getMessage());
        }
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.EMPTY_LIST;
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.EMPTY_LIST;
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.EMPTY_LIST;
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.EMPTY_LIST;
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.EMPTY_LIST;
    }

    public static <E> Internal.ProtobufList emptyProtobufList() {
        return ProtobufArrayList.EMPTY_LIST;
    }

    public static <T extends GeneratedMessageLite> T getDefaultInstance(Class<T> cls) {
        Map<Class<?>, GeneratedMessageLite> map = defaultInstanceMap;
        T t = (T) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        try {
            T t2 = (T) ((GeneratedMessageLite) UnsafeUtil.UNSAFE.allocateInstance(cls)).getDefaultInstanceForType();
            if (t2 != null) {
                map.put((Class<?>) cls, t2);
                return t2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return null;
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
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
        byte bByteValue = ((Byte) generatedMessageLite.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
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
            generatedMessageLite.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zIsInitialized ? generatedMessageLite : null, null);
        }
        return zIsInitialized;
    }

    public static Internal.IntList mutableCopy(Internal.IntList intList) {
        return ((IntArrayList) intList).mutableCopyWithCapacity(((IntArrayList) intList).size * 2);
    }

    public static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap enumLiteMap, int i, WireFormat$FieldType wireFormat$FieldType, boolean z, Class<?> cls) {
        return new GeneratedExtension(containingtype, ProtobufArrayList.EMPTY_LIST, messageLite, new ExtensionDescriptor(i, wireFormat$FieldType, true, z));
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap enumLiteMap, int i, WireFormat$FieldType wireFormat$FieldType, Class<?> cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(i, wireFormat$FieldType, false, false));
    }

    public static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialDelimitedFrom(t, inputStream, ExtensionRegistryLite.getEmptyRegistry());
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream.ArrayDecoderOldVarint arrayDecoderOldVarintNewInstance;
        if (byteBuffer.hasArray()) {
            arrayDecoderOldVarintNewInstance = CodedInputStream.newInstance(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            arrayDecoderOldVarintNewInstance = CodedInputStream.newInstance(bArr, 0, iRemaining, true);
        }
        T t2 = (T) parseFrom(t, arrayDecoderOldVarintNewInstance, extensionRegistryLite);
        checkMessageInitialized(t2);
        return t2;
    }

    public static GeneratedMessageLite parsePartialDelimitedFrom(GeneratedMessageLite generatedMessageLite, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(inputStream, i)));
            GeneratedMessageLite partialFrom = parsePartialFrom(generatedMessageLite, codedInputStreamNewInstance, extensionRegistryLite);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e) {
            if (e.wasThrownFromInputStream) {
                throw new InvalidProtocolBufferException(e.getMessage(), e);
            }
            throw e;
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage(), e2);
        }
    }

    public static <T extends GeneratedMessageLite> T parsePartialFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.newMutableInstance();
        try {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            Schema schemaSchemaFor = protobuf.schemaFor(t2.getClass());
            GapBuffer gapBuffer = codedInputStream.wrapper;
            if (gapBuffer == null) {
                gapBuffer = new GapBuffer(codedInputStream);
            }
            schemaSchemaFor.mergeFrom(t2, gapBuffer, extensionRegistryLite);
            schemaSchemaFor.makeImmutable(t2);
            return t2;
        } catch (InvalidProtocolBufferException e) {
            if (e.wasThrownFromInputStream) {
                throw new InvalidProtocolBufferException(e.getMessage(), e);
            }
            throw e;
        } catch (UninitializedMessageException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3.getMessage(), e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw e4;
        }
    }

    public static <T extends GeneratedMessageLite> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    public final Object buildMessageInfo() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO, null, null);
    }

    public final void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public final void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    public final int computeHashCode() {
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        return protobuf.schemaFor(getClass()).hashCode(this);
    }

    public final <MessageType2 extends GeneratedMessageLite, BuilderType2 extends Builder> BuilderType2 createBuilder() {
        return (BuilderType2) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
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

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE, null, null);
    }

    public final int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    public final int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final Parser getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER, null, null);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public int getSerializedSize(Schema schema) {
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
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
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

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    public final boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void makeImmutable() {
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        protobuf.schemaFor(getClass()).makeImmutable(this);
        markImmutable();
    }

    public final void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final void mergeLengthDelimitedField(int i, ByteString byteString) {
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            unknownFieldSetLite = new UnknownFieldSetLite();
            this.unknownFields = unknownFieldSetLite;
        }
        unknownFieldSetLite.checkMutable();
        if (i != 0) {
            unknownFieldSetLite.storeField((i << 3) | 2, byteString);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Zero is not a valid field number.");
        }
    }

    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFieldSetLite);
    }

    public final void mergeVarintField(int i, int i2) {
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            unknownFieldSetLite = new UnknownFieldSetLite();
            this.unknownFields = unknownFieldSetLite;
        }
        unknownFieldSetLite.checkMutable();
        if (i != 0) {
            unknownFieldSetLite.storeField(i << 3, Long.valueOf(i2));
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Zero is not a valid field number.");
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final Builder newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    public final GeneratedMessageLite newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
    }

    public final boolean parseUnknownField(int i, CodedInputStream codedInputStream) {
        if ((i & 7) == 4) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            unknownFieldSetLite = new UnknownFieldSetLite();
            this.unknownFields = unknownFieldSetLite;
        }
        return unknownFieldSetLite.mergeFieldFrom(i, codedInputStream);
    }

    public final void setMemoizedHashCode(int i) {
        this.memoizedHashCode = i;
    }

    public void setMemoizedSerializedSize(int i) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public final Builder m914toBuilder() {
        return ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null)).mergeFrom(this);
    }

    public String toString() {
        String string = super.toString();
        char[] cArr = MessageLiteToString.INDENT_BUFFER;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        MessageLiteToString.reflectivePrintWithIndent(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        Schema schemaSchemaFor = protobuf.schemaFor(getClass());
        ConnectionPool connectionPool = codedOutputStream.wrapper;
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
            if (codedOutputStream == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("output");
                throw null;
            }
            connectionPool.delegate = codedOutputStream;
            codedOutputStream.wrapper = connectionPool;
        }
        schemaSchemaFor.writeTo(this, connectionPool);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Builder extends AbstractMessageLite.Builder {
        private final GeneratedMessageLite defaultInstance;
        protected GeneratedMessageLite instance;

        public Builder(GeneratedMessageLite generatedMessageLite) {
            this.defaultInstance = generatedMessageLite;
            if (generatedMessageLite.isMutable()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Default instance must be immutable.");
                throw null;
            }
            this.instance = generatedMessageLite.newMutableInstance();
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public final GeneratedMessageLite m915build() {
            GeneratedMessageLite generatedMessageLiteBuildPartial = buildPartial();
            if (generatedMessageLiteBuildPartial.isInitialized()) {
                return generatedMessageLiteBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(generatedMessageLiteBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public GeneratedMessageLite buildPartial() {
            boolean zIsMutable = this.instance.isMutable();
            GeneratedMessageLite generatedMessageLite = this.instance;
            if (!zIsMutable) {
                return generatedMessageLite;
            }
            generatedMessageLite.makeImmutable();
            return this.instance;
        }

        /* JADX INFO: renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final Builder m916clear() {
            if (this.defaultInstance.isMutable()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Default instance must be immutable.");
                return null;
            }
            this.instance = this.defaultInstance.newMutableInstance();
            return this;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m919clone() {
            Builder builderNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            builderNewBuilderForType.instance = buildPartial();
            return builderNewBuilderForType;
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        public void copyOnWriteInternal() {
            GeneratedMessageLite generatedMessageLiteNewMutableInstance = this.defaultInstance.newMutableInstance();
            GeneratedMessageLite generatedMessageLite = this.instance;
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(generatedMessageLiteNewMutableInstance.getClass()).mergeFrom(generatedMessageLiteNewMutableInstance, generatedMessageLite);
            this.instance = generatedMessageLiteNewMutableInstance;
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            if (generatedMessageLite != null && !getDefaultInstanceForType().getClass().isInstance(generatedMessageLite)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("mergeFrom(MessageLite) can only merge messages of the same type.");
                return null;
            }
            if (getDefaultInstanceForType().equals(generatedMessageLite)) {
                return this;
            }
            copyOnWrite();
            GeneratedMessageLite generatedMessageLite2 = this.instance;
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(generatedMessageLite2.getClass()).mergeFrom(generatedMessageLite2, generatedMessageLite);
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public Builder internalMergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom(generatedMessageLite);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m922mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                Protobuf protobuf = Protobuf.INSTANCE;
                GeneratedMessageLite generatedMessageLite = this.instance;
                protobuf.getClass();
                protobuf.schemaFor(generatedMessageLite.getClass()).mergeFrom(this.instance, bArr, i, i + i2, new ArrayDecoders$Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                PathKt$$ExternalSyntheticBUOutline0.m("Reading from byte array should not throw IOException.", (Throwable) e2);
                return null;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m921mergeFrom(byte[] bArr, int i, int i2) {
            return m922mergeFrom(bArr, i, i2, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m920mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                Protobuf protobuf = Protobuf.INSTANCE;
                GeneratedMessageLite generatedMessageLite = this.instance;
                protobuf.getClass();
                Schema schemaSchemaFor = protobuf.schemaFor(generatedMessageLite.getClass());
                GeneratedMessageLite generatedMessageLite2 = this.instance;
                GapBuffer gapBuffer = codedInputStream.wrapper;
                if (gapBuffer == null) {
                    gapBuffer = new GapBuffer(codedInputStream);
                }
                schemaSchemaFor.mergeFrom(generatedMessageLite2, gapBuffer, extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public final <MessageType2 extends GeneratedMessageLite, BuilderType2 extends Builder> BuilderType2 createBuilder(MessageType2 messagetype2) {
        return (BuilderType2) createBuilder().mergeFrom((GeneratedMessageLite) messagetype2);
    }

    public static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialDelimitedFrom(t, inputStream, extensionRegistryLite);
        checkMessageInitialized(t2);
        return t2;
    }

    public static Internal.LongList mutableCopy(Internal.LongList longList) {
        return ((LongArrayList) longList).mutableCopyWithCapacity(((LongArrayList) longList).size * 2);
    }

    public static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        return ((FloatArrayList) floatList).mutableCopyWithCapacity(((FloatArrayList) floatList).size * 2);
    }

    public static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        return ((DoubleArrayList) doubleList).mutableCopyWithCapacity(((DoubleArrayList) doubleList).size * 2);
    }

    public static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        return ((BooleanArrayList) booleanList).mutableCopyWithCapacity(((BooleanArrayList) booleanList).size * 2);
    }

    public static <E> Internal.ProtobufList mutableCopy(Internal.ProtobufList protobufList) {
        return protobufList.mutableCopyWithCapacity(protobufList.size() * 2);
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer) {
        return (T) parseFrom(t, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        T t2 = (T) parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry());
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream.ArrayDecoderOldVarint arrayDecoderOldVarintNewCodedInput = byteString.newCodedInput();
        T t2 = (T) parsePartialFrom(t, arrayDecoderOldVarintNewCodedInput, extensionRegistryLite);
        arrayDecoderOldVarintNewCodedInput.checkLastTagWas(0);
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry());
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite);
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry());
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite);
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, CodedInputStream codedInputStream) {
        return (T) parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) parsePartialFrom(t, codedInputStream, extensionRegistryLite);
        checkMessageInitialized(t2);
        return t2;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        if (i2 == 0) {
            return generatedMessageLite;
        }
        GeneratedMessageLite generatedMessageLiteNewMutableInstance = generatedMessageLite.newMutableInstance();
        try {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            Schema schemaSchemaFor = protobuf.schemaFor(generatedMessageLiteNewMutableInstance.getClass());
            schemaSchemaFor.mergeFrom(generatedMessageLiteNewMutableInstance, bArr, i, i + i2, new ArrayDecoders$Registers(extensionRegistryLite));
            schemaSchemaFor.makeImmutable(generatedMessageLiteNewMutableInstance);
            return generatedMessageLiteNewMutableInstance;
        } catch (InvalidProtocolBufferException e) {
            if (e.wasThrownFromInputStream) {
                throw new InvalidProtocolBufferException(e.getMessage(), e);
            }
            throw e;
        } catch (UninitializedMessageException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3.getMessage(), e3);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static <T extends GeneratedMessageLite> T parsePartialFrom(T t, CodedInputStream codedInputStream) {
        return (T) parsePartialFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
}
