package io.ktor.http;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexingIterable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0086\u0002¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/http/AsciiBitSet;", "", "", "low", "high", "<init>", "(JJ)V", "", "char", "", "contains", "(C)Z", "", "byte", "(B)Z", "other", "plus", "(Lio/ktor/http/AsciiBitSet;)Lio/ktor/http/AsciiBitSet;", "", "code", "containsCode", "(I)Z", "J", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AsciiBitSet {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long high;
    private final long low;

    private AsciiBitSet(long j, long j2) {
        this.low = j;
        this.high = j2;
    }

    private final boolean containsCode(int code) {
        if ((code >>> 7) != 0) {
            return false;
        }
        return (((code < 64 ? this.low : this.high) >>> code) & 1) == 1;
    }

    public final boolean contains(char c) {
        return containsCode(c);
    }

    public final AsciiBitSet plus(AsciiBitSet other) {
        other.getClass();
        return new AsciiBitSet(this.low | other.low, other.high | this.high);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/AsciiBitSet$Companion;", "", "<init>", "()V", "", "", "chars", "Lio/ktor/http/AsciiBitSet;", "of", "(Ljava/lang/Iterable;)Lio/ktor/http/AsciiBitSet;", "", "(Ljava/lang/String;)Lio/ktor/http/AsciiBitSet;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AsciiBitSet of(Iterable<Character> chars) {
            chars.getClass();
            Iterator<Character> it = chars.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                char cCharValue = it.next().charValue();
                if (cCharValue >= 128) {
                    throw new IllegalArgumentException(("Only ASCII characters are supported, got '" + cCharValue + "' (code " + ((int) cCharValue) + ')').toString());
                }
                if (cCharValue < '@') {
                    j |= 1 << cCharValue;
                } else {
                    j2 |= 1 << cCharValue;
                }
            }
            return new AsciiBitSet(j, j2, null);
        }

        private Companion() {
        }

        public final AsciiBitSet of(String chars) {
            chars.getClass();
            return of(chars.length() == 0 ? EmptyList.INSTANCE : new IndexingIterable((byte) 3, chars));
        }
    }

    public final boolean contains(byte b) {
        return containsCode(b);
    }

    public /* synthetic */ AsciiBitSet(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }
}
