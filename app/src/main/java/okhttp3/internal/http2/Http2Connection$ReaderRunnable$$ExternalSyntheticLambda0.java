package okhttp3.internal.http2;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Http2Connection$ReaderRunnable$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ Http2Connection$ReaderRunnable$$ExternalSyntheticLambda0(Object obj, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        boolean z = true;
        int i = this.f$2;
        int i2 = this.f$1;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                Http2Connection http2Connection = (Http2Connection) obj;
                try {
                    http2Connection.writer.ping(i2, true, i);
                    break;
                } catch (IOException e) {
                    ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.close$okhttp(errorCode, errorCode, e);
                }
                return Unit.INSTANCE;
            default:
                PersistentHashMap persistentHashMap = ((SnapshotStateMap) obj).getReadable$runtime().map;
                Iterable intRange = new IntRange(i2, i, 1);
                if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                    Iterator it = intRange.iterator();
                    while (((IntProgressionIterator) it).hasNext()) {
                        if (!persistentHashMap.containsKey(Integer.valueOf(((IntIterator) it).nextInt()))) {
                            z = false;
                        }
                    }
                }
                return Boolean.valueOf(z);
        }
    }
}
