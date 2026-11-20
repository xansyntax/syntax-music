package io.ktor.openapi;

import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexingIterable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003Ba\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/openapi/SinglePropertyMixinSerializer;", "T", "P", "Lio/ktor/openapi/DelegateMixinSerializer;", "Lkotlinx/serialization/KSerializer;", "baseSerializer", "Lkotlin/reflect/KProperty;", "property", "propertySerializer", "Lkotlin/Function1;", "", "", "propertyKeyMatcher", "Lkotlin/Function2;", "copy", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlin/reflect/KProperty;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SinglePropertyMixinSerializer<T, P> extends DelegateMixinSerializer<T> {

    /* JADX INFO: renamed from: io.ktor.openapi.SinglePropertyMixinSerializer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public AnonymousClass1(Object obj) {
            super(1, obj, Set.class, "contains", "contains(Ljava/lang/Object;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            str.getClass();
            return Boolean.valueOf(((Set) this.receiver).contains(str));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SinglePropertyMixinSerializer(KSerializer kSerializer, KProperty<? extends P> kProperty, KSerializer kSerializer2, Function1 function1, Function2 function2) {
        kSerializer.getClass();
        kProperty.getClass();
        kSerializer2.getClass();
        function1.getClass();
        function2.getClass();
        Map mapSingletonMap = Collections.singletonMap(kProperty.getName(), new PropertyDelegateDescriptor(kSerializer2, function1));
        mapSingletonMap.getClass();
        super(kSerializer, mapSingletonMap, new StringValuesKt$$ExternalSyntheticLambda0(function2, (byte) 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0(Function2 function2, Object obj, List list) {
        Object objInvoke;
        list.getClass();
        Object objFirstOrNull = CollectionsKt.firstOrNull(list);
        return (objFirstOrNull == null || (objInvoke = function2.invoke(obj, objFirstOrNull)) == null) ? obj : objInvoke;
    }

    public SinglePropertyMixinSerializer(KSerializer kSerializer, KProperty kProperty, KSerializer kSerializer2, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            SerialDescriptor descriptor = kSerializer2.getDescriptor();
            descriptor.getClass();
            function1 = new AnonymousClass1(CollectionsKt.toSet(new IndexingIterable((byte) 4, descriptor)));
        }
        this(kSerializer, kProperty, kSerializer2, function1, function2);
    }
}
