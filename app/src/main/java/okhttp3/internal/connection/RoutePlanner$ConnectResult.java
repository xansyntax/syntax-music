package okhttp3.internal.connection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RoutePlanner$ConnectResult {
    public final RoutePlanner$Plan nextPlan;
    public final RoutePlanner$Plan plan;
    public final Throwable throwable;

    public /* synthetic */ RoutePlanner$ConnectResult(RoutePlanner$Plan routePlanner$Plan, ConnectPlan connectPlan, Throwable th, int i) {
        this(routePlanner$Plan, (i & 2) != 0 ? null : connectPlan, (i & 4) != 0 ? null : th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoutePlanner$ConnectResult)) {
            return false;
        }
        RoutePlanner$ConnectResult routePlanner$ConnectResult = (RoutePlanner$ConnectResult) obj;
        return Intrinsics.areEqual(this.plan, routePlanner$ConnectResult.plan) && Intrinsics.areEqual(this.nextPlan, routePlanner$ConnectResult.nextPlan) && Intrinsics.areEqual(this.throwable, routePlanner$ConnectResult.throwable);
    }

    public final int hashCode() {
        int iHashCode = this.plan.hashCode() * 31;
        RoutePlanner$Plan routePlanner$Plan = this.nextPlan;
        int iHashCode2 = (iHashCode + (routePlanner$Plan == null ? 0 : routePlanner$Plan.hashCode())) * 31;
        Throwable th = this.throwable;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
    }

    public RoutePlanner$ConnectResult(RoutePlanner$Plan routePlanner$Plan, RoutePlanner$Plan routePlanner$Plan2, Throwable th) {
        this.plan = routePlanner$Plan;
        this.nextPlan = routePlanner$Plan2;
        this.throwable = th;
    }
}
