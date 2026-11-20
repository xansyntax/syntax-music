package io.ktor.openapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/openapi/GenericElementEntriesEncoder;", "Lio/ktor/openapi/GenericElementEncoder;", "Lkotlin/Function0;", "", "onClose", "", "Lkotlin/Pair;", "", "Lio/ktor/openapi/GenericElement;", "entries", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/util/List;)V", "build", "()Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "encodeElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "element", "storeElement", "(Lio/ktor/openapi/GenericElement;)V", "encodeNull", "()V", "shouldCreateNested", "()Z", "Ljava/util/List;", "getEntries$ktor_openapi_schema", "()Ljava/util/List;", "currentElementName", "Ljava/lang/String;", "rootElement", "Lio/ktor/openapi/GenericElement;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementEntriesEncoder extends GenericElementEncoder {
    private String currentElementName;
    private final List<Pair> entries;
    private GenericElement rootElement;

    public /* synthetic */ GenericElementEntriesEncoder(Function0 function0, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new ArrayList() : list);
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public GenericElement build() {
        GenericElement genericElement = this.rootElement;
        return genericElement == null ? GenericElementKt.GenericElement((Collection<? extends Pair>) this.entries) : genericElement;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        descriptor.getClass();
        this.currentElementName = descriptor.getElementName(index);
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        this.currentElementName = null;
    }

    public final List<Pair> getEntries$ktor_openapi_schema() {
        return this.entries;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public boolean shouldCreateNested() {
        return this.rootElement == null || this.currentElementName != null;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public void storeElement(GenericElement element) {
        element.getClass();
        String str = this.currentElementName;
        if (str == null) {
            this.rootElement = element;
        } else {
            this.entries.add(new Pair(str, element));
            this.currentElementName = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericElementEntriesEncoder(Function0 function0, List<Pair> list) {
        super(function0);
        function0.getClass();
        list.getClass();
        this.entries = list;
    }
}
