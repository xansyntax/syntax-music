package io.ktor.openapi;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/openapi/GenericElementListEncoder;", "Lio/ktor/openapi/GenericElementEncoder;", "Lkotlin/Function0;", "", "onClose", "", "isRoot", "", "Lio/ktor/openapi/GenericElement;", "elements", "<init>", "(Lkotlin/jvm/functions/Function0;ZLjava/util/List;)V", "build", "()Lio/ktor/openapi/GenericElement;", "element", "storeElement", "(Lio/ktor/openapi/GenericElement;)V", "shouldCreateNested", "()Z", "encodeNull", "()V", "Z", "Ljava/util/List;", "getElements$ktor_openapi_schema", "()Ljava/util/List;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementListEncoder extends GenericElementEncoder {
    private final List<GenericElement> elements;
    private final boolean isRoot;

    public /* synthetic */ GenericElementListEncoder(Function0 function0, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new ArrayList() : list);
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public GenericElement build() {
        return new GenericElementList(this.elements, null, 2, null);
    }

    public final List<GenericElement> getElements$ktor_openapi_schema() {
        return this.elements;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public boolean shouldCreateNested() {
        return !this.isRoot;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public void storeElement(GenericElement element) {
        element.getClass();
        this.elements.add(element);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericElementListEncoder(Function0 function0, boolean z, List<GenericElement> list) {
        super(function0);
        function0.getClass();
        list.getClass();
        this.isRoot = z;
        this.elements = list;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
    }
}
