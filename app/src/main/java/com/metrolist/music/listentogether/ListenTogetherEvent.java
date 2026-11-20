package com.metrolist.music.listentogether;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.listentogether.proto.Listentogether;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListenTogetherEvent {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BufferComplete extends ListenTogetherEvent {
        public final String trackId;

        public BufferComplete(String str) {
            this.trackId = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BufferComplete) && this.trackId.equals(((BufferComplete) obj).trackId);
        }

        public final int hashCode() {
            return this.trackId.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("BufferComplete(trackId=", this.trackId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BufferWait extends ListenTogetherEvent {
        public final String trackId;
        public final List waitingFor;

        public BufferWait(String str, List list) {
            this.trackId = str;
            this.waitingFor = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BufferWait)) {
                return false;
            }
            BufferWait bufferWait = (BufferWait) obj;
            return this.trackId.equals(bufferWait.trackId) && this.waitingFor.equals(bufferWait.waitingFor);
        }

        public final int hashCode() {
            return this.waitingFor.hashCode() + (this.trackId.hashCode() * 31);
        }

        public final String toString() {
            return "BufferWait(trackId=" + this.trackId + ", waitingFor=" + this.waitingFor + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConnectionError extends ListenTogetherEvent {
        public final String error;

        public ConnectionError(String str) {
            this.error = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConnectionError) && this.error.equals(((ConnectionError) obj).error);
        }

        public final int hashCode() {
            return this.error.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("ConnectionError(error=", this.error, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Disconnected extends ListenTogetherEvent {
        public static final Disconnected INSTANCE = new Disconnected();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Disconnected);
        }

        public final int hashCode() {
            return 1536023536;
        }

        public final String toString() {
            return "Disconnected";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HostChanged extends ListenTogetherEvent {
        public final String newHostId;
        public final String newHostName;

        public HostChanged(String str, String str2) {
            this.newHostId = str;
            this.newHostName = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HostChanged)) {
                return false;
            }
            HostChanged hostChanged = (HostChanged) obj;
            return this.newHostId.equals(hostChanged.newHostId) && this.newHostName.equals(hostChanged.newHostName);
        }

        public final int hashCode() {
            return this.newHostName.hashCode() + (this.newHostId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("HostChanged(newHostId=", this.newHostId, ", newHostName=", this.newHostName, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JoinApproved extends ListenTogetherEvent {
        public final String roomCode;
        public final Listentogether.RoomState state;
        public final String userId;

        public JoinApproved(String str, String str2, Listentogether.RoomState roomState) {
            this.roomCode = str;
            this.userId = str2;
            this.state = roomState;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JoinApproved)) {
                return false;
            }
            JoinApproved joinApproved = (JoinApproved) obj;
            return this.roomCode.equals(joinApproved.roomCode) && this.userId.equals(joinApproved.userId) && this.state.equals(joinApproved.state);
        }

        public final int hashCode() {
            return this.state.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.roomCode.hashCode() * 31, 31, this.userId);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("JoinApproved(roomCode=", this.roomCode, ", userId=", this.userId, ", state=");
            sbM.append(this.state);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JoinRejected extends ListenTogetherEvent {
        public final String reason;

        public JoinRejected(String str) {
            this.reason = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof JoinRejected) && this.reason.equals(((JoinRejected) obj).reason);
        }

        public final int hashCode() {
            return this.reason.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("JoinRejected(reason=", this.reason, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class JoinRequestReceived extends ListenTogetherEvent {
        public final String userId;
        public final String username;

        public JoinRequestReceived(String str, String str2) {
            this.userId = str;
            this.username = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JoinRequestReceived)) {
                return false;
            }
            JoinRequestReceived joinRequestReceived = (JoinRequestReceived) obj;
            return this.userId.equals(joinRequestReceived.userId) && this.username.equals(joinRequestReceived.username);
        }

        public final int hashCode() {
            return this.username.hashCode() + (this.userId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("JoinRequestReceived(userId=", this.userId, ", username=", this.username, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Kicked extends ListenTogetherEvent {
        public final String reason;

        public Kicked(String str) {
            this.reason = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Kicked) && this.reason.equals(((Kicked) obj).reason);
        }

        public final int hashCode() {
            return this.reason.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("Kicked(reason=", this.reason, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaybackSync extends ListenTogetherEvent {
        public final Listentogether.PlaybackActionPayload action;

        public PlaybackSync(Listentogether.PlaybackActionPayload playbackActionPayload) {
            this.action = playbackActionPayload;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlaybackSync) && this.action.equals(((PlaybackSync) obj).action);
        }

        public final int hashCode() {
            return this.action.hashCode();
        }

        public final String toString() {
            return "PlaybackSync(action=" + this.action + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Reconnected extends ListenTogetherEvent {
        public final boolean isHost;
        public final String roomCode;
        public final Listentogether.RoomState state;
        public final String userId;

        public Reconnected(String str, String str2, Listentogether.RoomState roomState, boolean z) {
            this.roomCode = str;
            this.userId = str2;
            this.state = roomState;
            this.isHost = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reconnected)) {
                return false;
            }
            Reconnected reconnected = (Reconnected) obj;
            return this.roomCode.equals(reconnected.roomCode) && this.userId.equals(reconnected.userId) && this.state.equals(reconnected.state) && this.isHost == reconnected.isHost;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.isHost) + ((this.state.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.roomCode.hashCode() * 31, 31, this.userId)) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Reconnected(roomCode=", this.roomCode, ", userId=", this.userId, ", state=");
            sbM.append(this.state);
            sbM.append(", isHost=");
            sbM.append(this.isHost);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Reconnecting extends ListenTogetherEvent {
        public final int attempt;

        public Reconnecting(int i) {
            this.attempt = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Reconnecting) && this.attempt == ((Reconnecting) obj).attempt;
        }

        public final int hashCode() {
            return Integer.hashCode(15) + (Integer.hashCode(this.attempt) * 31);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.attempt, "Reconnecting(attempt=", ", maxAttempts=15)");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RoomCreated extends ListenTogetherEvent {
        public final String roomCode;
        public final String userId;

        public RoomCreated(String str, String str2) {
            this.roomCode = str;
            this.userId = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RoomCreated)) {
                return false;
            }
            RoomCreated roomCreated = (RoomCreated) obj;
            return this.roomCode.equals(roomCreated.roomCode) && this.userId.equals(roomCreated.userId);
        }

        public final int hashCode() {
            return this.userId.hashCode() + (this.roomCode.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("RoomCreated(roomCode=", this.roomCode, ", userId=", this.userId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ServerError extends ListenTogetherEvent {
        public final String code;
        public final String message;

        public ServerError(String str, String str2) {
            this.code = str;
            this.message = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServerError)) {
                return false;
            }
            ServerError serverError = (ServerError) obj;
            return this.code.equals(serverError.code) && this.message.equals(serverError.message);
        }

        public final int hashCode() {
            return this.message.hashCode() + (this.code.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("ServerError(code=", this.code, ", message=", this.message, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SyncStateReceived extends ListenTogetherEvent {
        public final Listentogether.SyncStatePayload state;

        public SyncStateReceived(Listentogether.SyncStatePayload syncStatePayload) {
            this.state = syncStatePayload;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SyncStateReceived) && this.state.equals(((SyncStateReceived) obj).state);
        }

        public final int hashCode() {
            return this.state.hashCode();
        }

        public final String toString() {
            return "SyncStateReceived(state=" + this.state + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UserDisconnected extends ListenTogetherEvent {
        public final String userId;
        public final String username;

        public UserDisconnected(String str, String str2) {
            this.userId = str;
            this.username = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserDisconnected)) {
                return false;
            }
            UserDisconnected userDisconnected = (UserDisconnected) obj;
            return this.userId.equals(userDisconnected.userId) && this.username.equals(userDisconnected.username);
        }

        public final int hashCode() {
            return this.username.hashCode() + (this.userId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("UserDisconnected(userId=", this.userId, ", username=", this.username, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UserJoined extends ListenTogetherEvent {
        public final String userId;
        public final String username;

        public UserJoined(String str, String str2) {
            this.userId = str;
            this.username = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserJoined)) {
                return false;
            }
            UserJoined userJoined = (UserJoined) obj;
            return this.userId.equals(userJoined.userId) && this.username.equals(userJoined.username);
        }

        public final int hashCode() {
            return this.username.hashCode() + (this.userId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("UserJoined(userId=", this.userId, ", username=", this.username, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UserLeft extends ListenTogetherEvent {
        public final String userId;
        public final String username;

        public UserLeft(String str, String str2) {
            this.userId = str;
            this.username = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserLeft)) {
                return false;
            }
            UserLeft userLeft = (UserLeft) obj;
            return this.userId.equals(userLeft.userId) && this.username.equals(userLeft.username);
        }

        public final int hashCode() {
            return this.username.hashCode() + (this.userId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("UserLeft(userId=", this.userId, ", username=", this.username, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UserReconnected extends ListenTogetherEvent {
        public final String userId;
        public final String username;

        public UserReconnected(String str, String str2) {
            this.userId = str;
            this.username = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserReconnected)) {
                return false;
            }
            UserReconnected userReconnected = (UserReconnected) obj;
            return this.userId.equals(userReconnected.userId) && this.username.equals(userReconnected.username);
        }

        public final int hashCode() {
            return this.username.hashCode() + (this.userId.hashCode() * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("UserReconnected(userId=", this.userId, ", username=", this.username, ")");
        }
    }
}
