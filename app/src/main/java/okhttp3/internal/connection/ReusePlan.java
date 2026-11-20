package okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReusePlan implements RoutePlanner$Plan {
    public final RealConnection connection;

    public ReusePlan(RealConnection realConnection) {
        realConnection.getClass();
        this.connection = realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$ConnectResult connectTcp() {
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$ConnectResult connectTlsEtc() {
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RealConnection handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final boolean isReady() {
        return true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner$Plan
    public final RoutePlanner$Plan retry() {
        throw new IllegalStateException("unexpected retry");
    }
}
