package kotlinx.coroutines.channels;

import com.google.common.base.Joiner;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BufferedChannelKt {
    public static final ChannelSegment NULL_SEGMENT = new ChannelSegment(-1, null, null, 0);
    public static final int SEGMENT_SIZE = InlineList.systemProp$default(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
    public static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = InlineList.systemProp$default(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
    public static final Joiner BUFFERED = new Joiner("BUFFERED", (byte) 5);
    public static final Joiner IN_BUFFER = new Joiner("SHOULD_BUFFER", (byte) 5);
    public static final Joiner RESUMING_BY_RCV = new Joiner("S_RESUMING_BY_RCV", (byte) 5);
    public static final Joiner RESUMING_BY_EB = new Joiner("RESUMING_BY_EB", (byte) 5);
    public static final Joiner POISONED = new Joiner("POISONED", (byte) 5);
    public static final Joiner DONE_RCV = new Joiner("DONE_RCV", (byte) 5);
    public static final Joiner INTERRUPTED_SEND = new Joiner("INTERRUPTED_SEND", (byte) 5);
    public static final Joiner INTERRUPTED_RCV = new Joiner("INTERRUPTED_RCV", (byte) 5);
    public static final Joiner CHANNEL_CLOSED = new Joiner("CHANNEL_CLOSED", (byte) 5);
    public static final Joiner SUSPEND = new Joiner("SUSPEND", (byte) 5);
    public static final Joiner SUSPEND_NO_WAITER = new Joiner("SUSPEND_NO_WAITER", (byte) 5);
    public static final Joiner FAILED = new Joiner("FAILED", (byte) 5);
    public static final Joiner NO_RECEIVE_RESULT = new Joiner("NO_RECEIVE_RESULT", (byte) 5);
    public static final Joiner CLOSE_HANDLER_CLOSED = new Joiner("CLOSE_HANDLER_CLOSED", (byte) 5);
    public static final Joiner CLOSE_HANDLER_INVOKED = new Joiner("CLOSE_HANDLER_INVOKED", (byte) 5);
    public static final Joiner NO_CLOSE_CAUSE = new Joiner("NO_CLOSE_CAUSE", (byte) 5);
}
