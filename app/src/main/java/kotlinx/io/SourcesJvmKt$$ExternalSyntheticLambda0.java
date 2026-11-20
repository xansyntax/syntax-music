package kotlinx.io;

import io.ktor.util.date.GMTDate;
import io.ktor.util.debug.IntellijIdeaDebugDetector;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonLiteralSerializer;
import kotlinx.serialization.json.JsonNullSerializer;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitiveSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SourcesJvmKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SourcesJvmKt$$ExternalSyntheticLambda0(ObjectSerializer objectSerializer) {
        this.$r8$classId = (byte) 4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return GMTDate._childSerializers$_anonymous_();
            case 2:
                return GMTDate._childSerializers$_anonymous_$0();
            case 3:
                return Boolean.valueOf(IntellijIdeaDebugDetector.isDebuggerConnected_delegate$lambda$0());
            case 4:
                StructureKind$MAP structureKind$MAP = StructureKind$MAP.INSTANCE$3;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
                if (StringsKt.isBlank("kotlin.Unit")) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
                    return null;
                }
                if (structureKind$MAP == StructureKind$MAP.INSTANCE$1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                    return null;
                }
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("kotlin.Unit");
                classSerialDescriptorBuilder.annotations = EmptyList.INSTANCE;
                return new SerialDescriptorImpl("kotlin.Unit", structureKind$MAP, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
            case 5:
                return JsonPrimitiveSerializer.descriptor;
            case 6:
                return JsonNullSerializer.descriptor;
            case 7:
                return JsonLiteralSerializer.descriptor;
            case 8:
                return JsonObjectSerializer.descriptor;
            default:
                return JsonArraySerializer.descriptor;
        }
    }

    public /* synthetic */ SourcesJvmKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }
}
