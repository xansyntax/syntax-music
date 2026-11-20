package io.ktor.util.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/util/collections/SerializedMapValue;", "T", "", "", "key", "Lkotlin/Function1;", "serialize", "deserialize", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/String;", "getKey$ktor_utils", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "getSerialize$ktor_utils", "()Lkotlin/jvm/functions/Function1;", "getDeserialize$ktor_utils", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerializedMapValue<T> {
    private final Function1 deserialize;
    private final String key;
    private final Function1 serialize;

    public SerializedMapValue(String str, Function1 function1, Function1 function2) {
        str.getClass();
        function1.getClass();
        function2.getClass();
        this.key = str;
        this.serialize = function1;
        this.deserialize = function2;
    }

    /* JADX INFO: renamed from: getDeserialize$ktor_utils, reason: from getter */
    public final Function1 getDeserialize() {
        return this.deserialize;
    }

    /* JADX INFO: renamed from: getKey$ktor_utils, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: getSerialize$ktor_utils, reason: from getter */
    public final Function1 getSerialize() {
        return this.serialize;
    }
}
