package io.ktor.util.collections;

import io.ktor.http.LinkHeader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: Add missing generic type declarations: [Key] */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0011\u0010\u0003\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"io/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1$iterator$1", "", "", "hasNext", "()Z", LinkHeader.Rel.Next, "()Ljava/lang/Object;", "", "remove", "()V", "keys", "Ljava/util/Iterator;", "current", "Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConcurrentSetKt$ConcurrentSet$1$iterator$1<Key> implements Iterator<Key>, KMappedMarker {
    private Key current;
    private final Iterator<Key> keys;
    final /* synthetic */ ConcurrentSetKt.AnonymousClass1 this$0;

    public ConcurrentSetKt$ConcurrentSet$1$iterator$1(ConcurrentSetKt.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
        this.keys = anonymousClass1.delegate.keySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.keys.hasNext();
    }

    @Override // java.util.Iterator
    public Key next() {
        Key next = this.keys.next();
        this.current = next;
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        Key key = this.current;
        if (key == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("next() has not been called");
        } else {
            this.this$0.delegate.remove(key);
            this.current = null;
        }
    }
}
