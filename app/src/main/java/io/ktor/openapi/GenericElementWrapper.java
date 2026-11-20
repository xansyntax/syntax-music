package io.ktor.openapi;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001d"}, d2 = {"Lio/ktor/openapi/GenericElementWrapper;", "", "T", "Lio/ktor/openapi/GenericElement;", "element", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "", "entries", "()Ljava/util/List;", "items", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getElement", "()Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "getElementSerialName", "elementSerialName", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementWrapper<T> implements GenericElement {
    private final T element;
    private final KSerializer elementSerializer;

    public GenericElementWrapper(T t, KSerializer kSerializer) {
        t.getClass();
        kSerializer.getClass();
        this.element = t;
        this.elementSerializer = kSerializer;
    }

    private final String getElementSerialName() {
        return getElementSerializer().getDescriptor().getSerialName();
    }

    @Override // io.ktor.openapi.GenericElement
    public <T> T deserialize(DeserializationStrategy serializer) {
        serializer.getClass();
        T element = getElement();
        if (element == null) {
            element = null;
        }
        if (element != null) {
            return element;
        }
        GenericElementKt.serialError("Cannot deserialize " + Reflection.getOrCreateKotlinClass(getElement().getClass()) + " to " + getElementSerialName());
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    @Override // io.ktor.openapi.GenericElement
    public List<Pair> entries() {
        return GenericElement.INSTANCE.encodeToElement(getElementSerializer(), getElement()).entries();
    }

    @Override // io.ktor.openapi.GenericElement
    public T getElement() {
        return this.element;
    }

    @Override // io.ktor.openapi.GenericElement
    public KSerializer getElementSerializer() {
        return this.elementSerializer;
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isArray() {
        return super.isArray();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isObject() {
        return super.isObject();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isString() {
        return super.isString();
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> items() {
        GenericElement genericElementString;
        if (!(getElement() instanceof Iterable)) {
            GenericElementKt.serialError("Cannot get items for a non-iterable element " + getElementSerialName());
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        Iterable iterable = (Iterable) getElement();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (T t : iterable) {
            if (t == null) {
                GenericElementKt.serialError("Expected element but was null");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            }
            boolean z = t instanceof GenericElement;
            if (z) {
                genericElementString = (GenericElement) t;
            } else if (z) {
                genericElementString = (GenericElement) t;
            } else {
                if (!(t instanceof String)) {
                    throw new SerializationException("Serializer for class 'kotlin.Any' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n");
                }
                genericElementString = new GenericElementString((String) t, null, 2, null);
            }
            arrayList.add(genericElementString);
        }
        return arrayList;
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ GenericElement plus(GenericElement genericElement) {
        return super.plus(genericElement);
    }

    public String toString() {
        return "GenericElementWrapper(" + getElementSerialName() + ": " + StringsKt.take(20, getElement().toString()) + ')';
    }
}
