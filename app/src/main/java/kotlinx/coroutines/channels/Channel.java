package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Channel extends SendChannel, ReceiveChannel {
    public static final Factory Factory = Factory.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory {
        public static final /* synthetic */ Factory $$INSTANCE = new Factory();
        public static final int CHANNEL_DEFAULT_CAPACITY = (int) InlineList.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
    }
}
