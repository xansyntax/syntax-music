package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StartedLazily implements SharingStarted {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow command(SubscriptionCountStateFlow subscriptionCountStateFlow) {
        switch (this.$r8$classId) {
            case 0:
                return new SafeFlow((byte) 5, subscriptionCountStateFlow);
            default:
                return new SafeFlow((byte) 4, SharingCommand.START);
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "SharingStarted.Lazily";
            default:
                return "SharingStarted.Eagerly";
        }
    }
}
