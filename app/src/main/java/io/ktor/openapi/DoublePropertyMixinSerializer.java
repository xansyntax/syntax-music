package io.ktor.openapi;

import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda2;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0099\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/DoublePropertyMixinSerializer;", "T", "P0", "P1", "Lio/ktor/openapi/DelegateMixinSerializer;", "Lkotlinx/serialization/KSerializer;", "baseSerializer", "Lkotlin/reflect/KProperty;", "property0", "property0Serializer", "Lkotlin/Function1;", "", "", "property0KeyMatcher", "property1", "property1Serializer", "property1KeyMatcher", "Lkotlin/Function3;", "copy", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlin/reflect/KProperty;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;Lkotlin/reflect/KProperty;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DoublePropertyMixinSerializer<T, P0, P1> extends DelegateMixinSerializer<T> {

    /* JADX INFO: renamed from: io.ktor.openapi.DoublePropertyMixinSerializer$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: io.ktor.openapi.DoublePropertyMixinSerializer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        public AnonymousClass2(Object obj) {
            super(1, obj, Set.class, "contains", "contains(Ljava/lang/Object;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            str.getClass();
            return Boolean.valueOf(((Set) this.receiver).contains(str));
        }
    }

    public DoublePropertyMixinSerializer(KSerializer kSerializer, KProperty kProperty, KSerializer kSerializer2, Function1 function1, KProperty kProperty2, KSerializer kSerializer3, Function1 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function1 anonymousClass1;
        Function1 anonymousClass2;
        if ((i & 8) != 0) {
            SerialDescriptor descriptor = kSerializer2.getDescriptor();
            descriptor.getClass();
            anonymousClass1 = new AnonymousClass1(CollectionsKt.toSet(new IndexingIterable((byte) 4, descriptor)));
        } else {
            anonymousClass1 = function1;
        }
        if ((i & 64) != 0) {
            SerialDescriptor descriptor2 = kSerializer3.getDescriptor();
            descriptor2.getClass();
            anonymousClass2 = new AnonymousClass2(CollectionsKt.toSet(new IndexingIterable((byte) 4, descriptor2)));
        } else {
            anonymousClass2 = function2;
        }
        this(kSerializer, kProperty, kSerializer2, anonymousClass1, kProperty2, kSerializer3, anonymousClass2, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0(Function3 function3, Object obj, List list) {
        list.getClass();
        return function3.invoke(obj, list.get(0), list.get(1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoublePropertyMixinSerializer(KSerializer kSerializer, KProperty<? extends P0> kProperty, KSerializer kSerializer2, Function1 function1, KProperty<? extends P1> kProperty2, KSerializer kSerializer3, Function1 function2, Function3 function3) {
        super(kSerializer, MapsKt__MapsKt.mapOf(new Pair(kProperty.getName(), new PropertyDelegateDescriptor(kSerializer2, function1)), new Pair(kProperty2.getName(), new PropertyDelegateDescriptor(kSerializer3, function2))), new AppBarKt$$ExternalSyntheticLambda2(function3, (byte) 2));
        kSerializer.getClass();
        kProperty.getClass();
        kSerializer2.getClass();
        function1.getClass();
        kProperty2.getClass();
        kSerializer3.getClass();
        function2.getClass();
        function3.getClass();
    }
}
