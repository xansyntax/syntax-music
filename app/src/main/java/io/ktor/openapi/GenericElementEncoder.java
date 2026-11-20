package io.ktor.openapi;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000 L2\u00020\u0001:\u0001LB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H$¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H$¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001e\u001a\u00020\u0003\"\b\b\u0000\u0010\u001a*\u00020\u00192\u0006\u0010\u001b\u001a\u00028\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\"H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020%H\u0096\u0080\u0004¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020(H\u0096\u0080\u0004¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020+H\u0096\u0080\u0004¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020.H\u0096\u0080\u0004¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u000201H\u0096\u0080\u0004¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u000204H\u0096\u0080\u0004¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u000207H\u0096\u0080\u0004¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020(H\u0096\u0080\u0004¢\u0006\u0004\b<\u0010=R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020A8\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER$\u0010F\u001a\u0004\u0018\u00010\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lio/ktor/openapi/GenericElementEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlin/Function0;", "", "onClose", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Lio/ktor/openapi/GenericElement;", "build", "()Lio/ktor/openapi/GenericElement;", "element", "storeElement", "(Lio/ktor/openapi/GenericElement;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "", "shouldCreateNested", "()Z", "closeNested", "()V", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "T", "value", "Lkotlinx/serialization/KSerializer;", "serializer", "captureValue", "(Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)V", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeChar", "(C)V", "", "encodeString", "(Ljava/lang/String;)V", "enumDescriptor", "index", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "Lkotlin/jvm/functions/Function0;", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentNestedEncoder", "Lio/ktor/openapi/GenericElementEncoder;", "getCurrentNestedEncoder", "()Lio/ktor/openapi/GenericElementEncoder;", "setCurrentNestedEncoder", "(Lio/ktor/openapi/GenericElementEncoder;)V", "Companion", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class GenericElementEncoder extends AbstractEncoder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GenericElementEncoder currentNestedEncoder;
    private final Function0 onClose;
    private final SerializersModule serializersModule;

    public GenericElementEncoder(Function0 function0) {
        function0.getClass();
        this.onClose = function0;
        this.serializersModule = SerializersModuleKt.EmptySerializersModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit beginStructure$lambda$0(GenericElementEncoder genericElementEncoder) {
        genericElementEncoder.closeNested();
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        descriptor.getClass();
        if (!shouldCreateNested()) {
            return this;
        }
        GenericElementEncoder genericElementEncoderElementEncoder$ktor_openapi_schema = INSTANCE.elementEncoder$ktor_openapi_schema(descriptor, false, new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 27, this));
        this.currentNestedEncoder = genericElementEncoderElementEncoder$ktor_openapi_schema;
        return genericElementEncoderElementEncoder$ktor_openapi_schema;
    }

    public abstract GenericElement build();

    public final <T> void captureValue(T value, KSerializer serializer) {
        value.getClass();
        serializer.getClass();
        storeElement(new GenericElementWrapper(value, serializer));
    }

    public final void closeNested() {
        GenericElementEncoder genericElementEncoder = this.currentNestedEncoder;
        if (genericElementEncoder != null) {
            storeElement(genericElementEncoder.build());
            this.currentNestedEncoder = null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean value) {
        captureValue(Boolean.valueOf(value), BooleanSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte value) {
        captureValue(Byte.valueOf(value), ByteSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char value) {
        captureValue(Character.valueOf(value), CharSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double value) {
        captureValue(Double.valueOf(value), DoubleSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        enumDescriptor.getClass();
        captureValue(enumDescriptor.getElementName(index), StringSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float value) {
        captureValue(Float.valueOf(value), FloatSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int value) {
        captureValue(Integer.valueOf(value), IntSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long value) {
        captureValue(Long.valueOf(value), LongSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short value) {
        captureValue(Short.valueOf(value), ShortSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        value.getClass();
        captureValue(value, StringSerializer.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(SerialDescriptor descriptor) {
        descriptor.getClass();
        if (this.currentNestedEncoder != null) {
            closeNested();
        }
        this.onClose.invoke();
    }

    public final GenericElementEncoder getCurrentNestedEncoder() {
        return this.currentNestedEncoder;
    }

    public final Function0 getOnClose() {
        return this.onClose;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void setCurrentNestedEncoder(GenericElementEncoder genericElementEncoder) {
        this.currentNestedEncoder = genericElementEncoder;
    }

    public abstract boolean shouldCreateNested();

    public abstract void storeElement(GenericElement element);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0004\b\u0007\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/openapi/GenericElementEncoder$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/openapi/GenericElementEncoder;", "elementEncoder$ktor_openapi_schema", "(Lkotlinx/serialization/KSerializer;)Lio/ktor/openapi/GenericElementEncoder;", "elementEncoder", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "isRoot", "Lkotlin/Function0;", "", "onClose", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ZLkotlin/jvm/functions/Function0;)Lio/ktor/openapi/GenericElementEncoder;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GenericElementEncoder elementEncoder$ktor_openapi_schema$default(Companion companion, SerialDescriptor serialDescriptor, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                function0 = new Header$$ExternalSyntheticLambda0((byte) 11);
            }
            return companion.elementEncoder$ktor_openapi_schema(serialDescriptor, z, function0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final GenericElementEncoder elementEncoder$ktor_openapi_schema(SerialDescriptor descriptor, boolean isRoot, Function0 onClose) {
            descriptor.getClass();
            onClose.getClass();
            Okio__OkioKt kind = descriptor.getKind();
            if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2)) {
                return new GenericElementListEncoder(onClose, isRoot, null, 4, null);
            }
            int i = 2;
            return Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE) ? new GenericElementMapEncoder(onClose, null, i, 0 == true ? 1 : 0) : new GenericElementEntriesEncoder(onClose, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        }

        private Companion() {
        }

        public final GenericElementEncoder elementEncoder$ktor_openapi_schema(KSerializer serializer) {
            serializer.getClass();
            return elementEncoder$ktor_openapi_schema$default(this, serializer.getDescriptor(), true, null, 4, null);
        }
    }
}
