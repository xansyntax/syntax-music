package io.ktor.openapi;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015R,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/openapi/GenericElementMapEncoder;", "Lio/ktor/openapi/GenericElementEncoder;", "Lkotlin/Function0;", "", "onClose", "", "Lkotlin/Pair;", "", "Lio/ktor/openapi/GenericElement;", "entries", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/util/List;)V", "build", "()Lio/ktor/openapi/GenericElement;", "", "shouldCreateNested", "()Z", "element", "storeElement", "(Lio/ktor/openapi/GenericElement;)V", "encodeNull", "()V", "Ljava/util/List;", "getEntries$ktor_openapi_schema", "()Ljava/util/List;", "currentKey", "Ljava/lang/String;", "waitingForKey", "Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementMapEncoder extends GenericElementEncoder {
    private String currentKey;
    private final List<Pair> entries;
    private boolean waitingForKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericElementMapEncoder(Function0 function0, List<Pair> list) {
        super(function0);
        function0.getClass();
        list.getClass();
        this.entries = list;
        this.waitingForKey = true;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public GenericElement build() {
        return new GenericElementMap(MapsKt__MapsKt.toMap(this.entries), null, 2, null);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        boolean z = this.waitingForKey;
        if (z) {
            GenericElementKt.serialError("Map key cannot be null");
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        } else {
            this.currentKey = null;
            this.waitingForKey = !z;
        }
    }

    public final List<Pair> getEntries$ktor_openapi_schema() {
        return this.entries;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public boolean shouldCreateNested() {
        return !this.waitingForKey;
    }

    @Override // io.ktor.openapi.GenericElementEncoder
    public void storeElement(GenericElement element) {
        element.getClass();
        if (this.waitingForKey) {
            this.currentKey = element.getElement().toString();
            this.waitingForKey = false;
            return;
        }
        List<Pair> list = this.entries;
        String str = this.currentKey;
        if (str == null) {
            GenericElementKt.serialError("Map value without key");
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        } else {
            list.add(new Pair(str, element));
            this.currentKey = null;
            this.waitingForKey = true;
        }
    }

    public /* synthetic */ GenericElementMapEncoder(Function0 function0, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new ArrayList() : list);
    }
}
