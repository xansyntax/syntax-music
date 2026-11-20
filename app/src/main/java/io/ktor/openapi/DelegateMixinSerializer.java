package io.ktor.openapi;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BK\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R.\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR2\u0010\u001e\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0004\u0012\u00020\u00050\u001b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020 8\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lio/ktor/openapi/DelegateMixinSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "baseSerializer", "", "", "Lio/ktor/openapi/PropertyDelegateDescriptor;", "properties", "Lkotlin/Function2;", "", "", "copy", "<init>", "(Lkotlinx/serialization/KSerializer;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "reverseLookup", "Ljava/util/List;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DelegateMixinSerializer<T> implements KSerializer {
    private final KSerializer baseSerializer;
    private final Function2 copy;
    private final SerialDescriptor descriptor;
    private final Map<String, PropertyDelegateDescriptor> properties;
    private final List<Pair> reverseLookup;

    public DelegateMixinSerializer(KSerializer kSerializer, Map<String, PropertyDelegateDescriptor> map, Function2 function2) {
        kSerializer.getClass();
        map.getClass();
        function2.getClass();
        this.baseSerializer = kSerializer;
        this.properties = map;
        this.copy = function2;
        Set<Map.Entry<String, PropertyDelegateDescriptor>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((PropertyDelegateDescriptor) entry.getValue()).getKeyMatcher(), (String) entry.getKey()));
        }
        this.reverseLookup = arrayList;
        this.descriptor = this.baseSerializer.getDescriptor();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        decoder.getClass();
        GenericElement.Companion companion = GenericElement.INSTANCE;
        Map<ElementKey, GenericElement> mapExtract = DelegateMixinSerializerKt.extract((GenericElement) decoder.decodeSerializableValue(companion.serializer()), (List<? extends Pair>) this.reverseLookup);
        Object objDeserialize = companion.orEmpty(mapExtract.get(ElementKey.Root.INSTANCE)).deserialize(this.baseSerializer);
        Map<String, PropertyDelegateDescriptor> map = this.properties;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, PropertyDelegateDescriptor> entry : map.entrySet()) {
            String key = entry.getKey();
            PropertyDelegateDescriptor value = entry.getValue();
            GenericElement genericElement = mapExtract.get(new ElementKey.Property(key));
            arrayList.add(genericElement != null ? genericElement.deserialize(value.getSerializer()) : null);
        }
        return (T) this.copy.invoke(objDeserialize, arrayList);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        GenericElement genericElementTrySerializeToElement;
        encoder.getClass();
        Iterator<T> it = GenericElement_jvmKt.getGenericElementSerialAdapters().iterator();
        do {
            if (!it.hasNext()) {
                genericElementTrySerializeToElement = null;
                break;
            }
            genericElementTrySerializeToElement = ((GenericElementSerialAdapter) it.next()).trySerializeToElement(encoder, value, this.baseSerializer);
        } while (genericElementTrySerializeToElement == null);
        if (genericElementTrySerializeToElement == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$4(Reflection.getOrCreateKotlinClass(encoder.getClass()).getSimpleName(), "No GenericElementSerialAdapter found for ");
            return;
        }
        Map<ElementKey, GenericElement> mapExtract = DelegateMixinSerializerKt.extract(genericElementTrySerializeToElement, this.properties.keySet());
        if (mapExtract.size() == 1) {
            encoder.encodeSerializableValue(this.baseSerializer, value);
            return;
        }
        encoder.getSerializersModule();
        KSerializer kSerializerSerializer = GenericElement.INSTANCE.serializer();
        Iterator<T> it2 = mapExtract.values().iterator();
        if (!it2.hasNext()) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Empty collection can't be reduced.");
            return;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = ((GenericElement) next).plus((GenericElement) it2.next());
        }
        encoder.encodeSerializableValue(kSerializerSerializer, next);
    }
}
