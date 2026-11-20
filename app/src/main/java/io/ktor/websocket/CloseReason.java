package io.ktor.websocket;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\u0011\u0010\n\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lio/ktor/websocket/CloseReason;", "", "", "code", "", ContentType.Message.TYPE, "<init>", "(SLjava/lang/String;)V", "Lio/ktor/websocket/CloseReason$Codes;", "(Lio/ktor/websocket/CloseReason$Codes;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "()S", "component2", "copy", "(SLjava/lang/String;)Lio/ktor/websocket/CloseReason;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "S", "getCode", "Ljava/lang/String;", "getMessage", "getKnownReason", "()Lio/ktor/websocket/CloseReason$Codes;", "knownReason", "Companion", "Codes", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CloseReason {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final short code;
    private final String message;

    public CloseReason(short s, String str) {
        str.getClass();
        this.code = s;
        this.message = str;
        int iUtf8Size = ControlFramesKt.utf8Size(str);
        if (iUtf8Size <= 123) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(iUtf8Size, "Close reason message is too long: ", " bytes, but must not exceed 123 bytes when UTF-8-encoded"));
        throw null;
    }

    public static /* synthetic */ CloseReason copy$default(CloseReason closeReason, short s, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            s = closeReason.code;
        }
        if ((i & 2) != 0) {
            str = closeReason.message;
        }
        return closeReason.copy(s, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final short getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final CloseReason copy(short code, String message) {
        message.getClass();
        return new CloseReason(code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloseReason)) {
            return false;
        }
        CloseReason closeReason = (CloseReason) other;
        return this.code == closeReason.code && Intrinsics.areEqual(this.message, closeReason.message);
    }

    public final short getCode() {
        return this.code;
    }

    public final Codes getKnownReason() {
        return Codes.INSTANCE.byCode(this.code);
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode() + (Short.hashCode(this.code) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CloseReason(reason=");
        Object knownReason = getKnownReason();
        if (knownReason == null) {
            knownReason = Short.valueOf(this.code);
        }
        sb.append(knownReason);
        sb.append(", message=");
        return Format$$ExternalSyntheticOutline0.m(sb, this.message, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes;", "", "", "code", "<init>", "(Ljava/lang/String;IS)V", "S", "getCode", "()S", "Companion", "NORMAL", "GOING_AWAY", "PROTOCOL_ERROR", "CANNOT_ACCEPT", "CLOSED_ABNORMALLY", "NOT_CONSISTENT", "VIOLATED_POLICY", "TOO_BIG", "NO_EXTENSION", "INTERNAL_ERROR", "SERVICE_RESTART", "TRY_AGAIN_LATER", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Codes {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);

        public static final Codes UNEXPECTED_CONDITION;
        private static final Map<Short, Codes> byCodeMap;
        private final short code;
        private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        static {
            EnumEntries entries = getEntries();
            int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(entries, 10));
            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity < 16 ? 16 : iMapCapacity);
            for (Object obj : entries) {
                linkedHashMap.put(Short.valueOf(((Codes) obj).code), obj);
            }
            byCodeMap = linkedHashMap;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        Codes(short s) {
            this.code = s;
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public final short getCode() {
            return this.code;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u0003¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/websocket/CloseReason$Codes;", "byCode", "(S)Lio/ktor/websocket/CloseReason$Codes;", "", "byCodeMap", "Ljava/util/Map;", "UNEXPECTED_CONDITION", "Lio/ktor/websocket/CloseReason$Codes;", "getUNEXPECTED_CONDITION$annotations", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Codes byCode(short code) {
                return (Codes) Codes.byCodeMap.get(Short.valueOf(code));
            }

            private Companion() {
            }

            @Deprecated
            public static /* synthetic */ void getUNEXPECTED_CONDITION$annotations() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/CloseReason$Companion;", "", "<init>", "()V", "Lio/ktor/websocket/CloseReason$Codes;", "code", "", ContentType.Message.TYPE, "Lio/ktor/websocket/CloseReason;", "truncated", "(Lio/ktor/websocket/CloseReason$Codes;Ljava/lang/String;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CloseReason truncated(Codes code, String message) {
            code.getClass();
            message.getClass();
            return new CloseReason(code, ControlFramesKt.utf8Truncate(message, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes codes, String str) {
        this(codes.getCode(), str);
        codes.getClass();
        str.getClass();
    }
}
