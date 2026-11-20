package kotlinx.serialization;

import io.ktor.http.LinkHeader;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SealedClassSerializer$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SealedClassSerializer f$0;

    public /* synthetic */ SealedClassSerializer$$ExternalSyntheticLambda1(SealedClassSerializer sealedClassSerializer, byte b) {
        this.$r8$classId = b;
        this.f$0 = sealedClassSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SealedClassSerializer sealedClassSerializer = this.f$0;
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        switch (b) {
            case 0:
                classSerialDescriptorBuilder.getClass();
                classSerialDescriptorBuilder.element(LinkHeader.Parameters.Type, StringSerializer.descriptor);
                classSerialDescriptorBuilder.element("value", StringsKt__IndentKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + sealedClassSerializer.baseClass.getSimpleName() + '>', SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new SealedClassSerializer$$ExternalSyntheticLambda1(sealedClassSerializer, (byte) 1)));
                List list = sealedClassSerializer._annotations;
                list.getClass();
                classSerialDescriptorBuilder.annotations = list;
                break;
            default:
                classSerialDescriptorBuilder.getClass();
                for (Map.Entry entry : sealedClassSerializer.serialName2Serializer.entrySet()) {
                    classSerialDescriptorBuilder.element((String) entry.getKey(), ((KSerializer) entry.getValue()).getDescriptor());
                }
                break;
        }
        return unit;
    }
}
