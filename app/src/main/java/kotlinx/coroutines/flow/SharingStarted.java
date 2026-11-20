package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SharingStarted {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final StartedLazily Eagerly = new StartedLazily((byte) 1);
        public static final StartedLazily Lazily = new StartedLazily((byte) 0);
    }

    Flow command(SubscriptionCountStateFlow subscriptionCountStateFlow);
}
