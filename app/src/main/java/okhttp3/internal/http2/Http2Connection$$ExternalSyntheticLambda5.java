package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Http2Connection$$ExternalSyntheticLambda5 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Http2Connection f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ Http2Connection$$ExternalSyntheticLambda5(Http2Connection http2Connection, int i, List list, boolean z) {
        this.$r8$classId = (byte) 2;
        this.f$0 = http2Connection;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Http2Connection http2Connection = this.f$0;
                int i = this.f$1;
                http2Connection.pushObserver.getClass();
                try {
                    http2Connection.writer.rstStream(i, ErrorCode.CANCEL);
                    synchronized (http2Connection) {
                        http2Connection.currentPushRequests.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
                return Unit.INSTANCE;
            case 1:
                Http2Connection http2Connection2 = this.f$0;
                int i2 = this.f$1;
                http2Connection2.pushObserver.getClass();
                synchronized (http2Connection2) {
                    http2Connection2.currentPushRequests.remove(Integer.valueOf(i2));
                }
                return Unit.INSTANCE;
            default:
                Http2Connection http2Connection3 = this.f$0;
                int i3 = this.f$1;
                http2Connection3.pushObserver.getClass();
                try {
                    http2Connection3.writer.rstStream(i3, ErrorCode.CANCEL);
                    synchronized (http2Connection3) {
                        http2Connection3.currentPushRequests.remove(Integer.valueOf(i3));
                    }
                } catch (IOException unused2) {
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ Http2Connection$$ExternalSyntheticLambda5(Http2Connection http2Connection, int i, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = http2Connection;
        this.f$1 = i;
    }
}
