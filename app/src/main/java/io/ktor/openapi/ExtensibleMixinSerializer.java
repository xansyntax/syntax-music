package io.ktor.openapi;

import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.openapi.Extensible;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012 \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0002`\u00070\u0003BA\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012*\u0010\u000b\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0002`\u0007\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Extensible;", "T", "Lio/ktor/openapi/SinglePropertyMixinSerializer;", "", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "Lkotlinx/serialization/KSerializer;", "baseSerializer", "Lkotlin/Function2;", "copy", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function2;)V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ExtensibleMixinSerializer<T extends Extensible> extends SinglePropertyMixinSerializer<T, Map<String, ? extends GenericElement>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensibleMixinSerializer(KSerializer kSerializer, Function2 function2) {
        super(kSerializer, new PropertyReference1Impl() { // from class: io.ktor.openapi.ExtensibleMixinSerializer.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((Extensible) obj).getExtensions();
            }
        }, HexFormatKt.getNullable(new HashMapSerializer(StringSerializer.INSTANCE, GenericElement.INSTANCE.serializer(), (byte) 1)), new URLUtilsKt$$ExternalSyntheticLambda0((byte) 19), function2);
        kSerializer.getClass();
        function2.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(String str) {
        str.getClass();
        return StringsKt__StringsJVMKt.startsWith(str, "x-", false);
    }
}
