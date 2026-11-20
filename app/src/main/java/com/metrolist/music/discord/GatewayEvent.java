package com.metrolist.music.discord;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface GatewayEvent {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Disconnected implements GatewayEvent {
        public final int code;
        public final String reason;
        public final boolean remote;

        public Disconnected(String str, int i, boolean z) {
            str.getClass();
            this.code = i;
            this.reason = str;
            this.remote = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Disconnected)) {
                return false;
            }
            Disconnected disconnected = (Disconnected) obj;
            return this.code == disconnected.code && Intrinsics.areEqual(this.reason, disconnected.reason) && this.remote == disconnected.remote;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.remote) + Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.code) * 31, 31, this.reason);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Disconnected(code=");
            sb.append(this.code);
            sb.append(", reason=");
            sb.append(this.reason);
            sb.append(", remote=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.remote, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HeartbeatAck implements GatewayEvent {
        public final Integer lastSeq;

        public HeartbeatAck(Integer num) {
            this.lastSeq = num;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeartbeatAck) && this.lastSeq.equals(((HeartbeatAck) obj).lastSeq);
        }

        public final int hashCode() {
            return this.lastSeq.hashCode();
        }

        public final String toString() {
            return "HeartbeatAck(lastSeq=" + this.lastSeq + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Hello implements GatewayEvent {
        public final long heartbeatIntervalMs;

        public Hello(long j) {
            this.heartbeatIntervalMs = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Hello) && this.heartbeatIntervalMs == ((Hello) obj).heartbeatIntervalMs;
        }

        public final int hashCode() {
            return Long.hashCode(this.heartbeatIntervalMs);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.heartbeatIntervalMs, "Hello(heartbeatIntervalMs=", ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InvalidSession implements GatewayEvent {
        public final boolean resumable;

        public InvalidSession(boolean z) {
            this.resumable = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidSession) && this.resumable == ((InvalidSession) obj).resumable;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.resumable);
        }

        public final String toString() {
            return "InvalidSession(resumable=" + this.resumable + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Ready implements GatewayEvent {
        public final String resumeGatewayUrl;
        public final String sessionId;

        public Ready(String str, String str2) {
            this.sessionId = str;
            this.resumeGatewayUrl = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ready)) {
                return false;
            }
            Ready ready = (Ready) obj;
            return this.sessionId.equals(ready.sessionId) && Intrinsics.areEqual(this.resumeGatewayUrl, ready.resumeGatewayUrl);
        }

        public final int hashCode() {
            int iHashCode = this.sessionId.hashCode() * 31;
            String str = this.resumeGatewayUrl;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Ready(sessionId=", this.sessionId, ", resumeGatewayUrl=", this.resumeGatewayUrl, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RefreshToken implements GatewayEvent {
        public static final RefreshToken INSTANCE = new RefreshToken();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof RefreshToken);
        }

        public final int hashCode() {
            return -1508167833;
        }

        public final String toString() {
            return "RefreshToken";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Resumed implements GatewayEvent {
        public final String sessionId;

        public Resumed(String str) {
            this.sessionId = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resumed) && this.sessionId.equals(((Resumed) obj).sessionId);
        }

        public final int hashCode() {
            return this.sessionId.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("Resumed(sessionId=", this.sessionId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextDispatch implements GatewayEvent {
        public final JSONObject d;
        public final int op;
        public final String t;

        public TextDispatch(int i, String str, JSONObject jSONObject) {
            this.op = i;
            this.t = str;
            this.d = jSONObject;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextDispatch)) {
                return false;
            }
            TextDispatch textDispatch = (TextDispatch) obj;
            return this.op == textDispatch.op && Intrinsics.areEqual(this.t, textDispatch.t) && this.d.equals(textDispatch.d);
        }

        public final int hashCode() {
            int iHashCode = Integer.hashCode(this.op) * 31;
            String str = this.t;
            return this.d.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final String toString() {
            return "TextDispatch(op=" + this.op + ", t=" + this.t + ", d=" + this.d + ")";
        }
    }
}
