package io.ktor.websocket;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/FrameType;", "", "", "controlFrame", "", "opcode", "<init>", "(Ljava/lang/String;IZI)V", "Z", "getControlFrame", "()Z", "I", "getOpcode", "()I", "Companion", "TEXT", "BINARY", "CLOSE", "PING", "PONG", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);

    private static final FrameType[] byOpcodeArray;
    private static final int maxOpcode;
    private final boolean controlFrame;
    private final int opcode;
    private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object next;
        Iterator<E> it = getEntries().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int i = ((FrameType) next).opcode;
                do {
                    Object next2 = it.next();
                    int i2 = ((FrameType) next2).opcode;
                    if (i < i2) {
                        next = next2;
                        i = i2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        next.getClass();
        int i3 = ((FrameType) next).opcode;
        maxOpcode = i3;
        int i4 = i3 + 1;
        FrameType[] frameTypeArr = new FrameType[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            Iterator<E> it2 = getEntries().iterator();
            Object obj = null;
            boolean z = false;
            while (true) {
                if (!it2.hasNext()) {
                    if (z) {
                        break;
                    }
                } else {
                    Object next3 = it2.next();
                    if (((FrameType) next3).opcode == i5) {
                        if (!z) {
                            z = true;
                            obj = next3;
                        }
                    }
                }
                obj = null;
                break;
            }
            frameTypeArr[i5] = obj;
        }
        byOpcodeArray = frameTypeArr;
    }

    FrameType(boolean z, int i) {
        this.controlFrame = z;
        this.opcode = i;
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/FrameType$Companion;", "", "<init>", "()V", "", "opcode", "Lio/ktor/websocket/FrameType;", "get", "(I)Lio/ktor/websocket/FrameType;", "maxOpcode", "I", "", "byOpcodeArray", "[Lio/ktor/websocket/FrameType;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FrameType get(int opcode) {
            if (opcode < 0 || opcode > FrameType.maxOpcode) {
                return null;
            }
            return FrameType.byOpcodeArray[opcode];
        }

        private Companion() {
        }
    }
}
