package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.kotlin.DslList;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/listentogether/proto/RoomStateKt;", "", "<init>", "()V", "Dsl", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class RoomStateKt {
    public static final int $stable = 0;
    public static final RoomStateKt INSTANCE = new RoomStateKt();

    private RoomStateKt() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0003^_`B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J3\u0010\u001e\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\t\u001a\u00020\u001aH\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f¢\u0006\u0002\b\u001fJ4\u0010 \u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\t\u001a\u00020\u001aH\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(!¢\u0006\u0002\b!J9\u0010\"\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0$H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(%¢\u0006\u0002\b%J:\u0010 \u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0$H\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(&¢\u0006\u0002\b&J<\u0010'\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\u001aH\u0087\u0002b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(*¢\u0006\u0002\b*J+\u0010+\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(,¢\u0006\u0002\b,J\u0006\u00103\u001a\u00020\u0013J\u0006\u00104\u001a\u000205J\u0006\u0010>\u001a\u00020\u0013J\u0006\u0010E\u001a\u00020\u0013J\u0006\u0010I\u001a\u00020\u0013J\u0006\u0010P\u001a\u00020\u0013J3\u0010\u001e\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00192\u0006\u0010\t\u001a\u00020-H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(T¢\u0006\u0002\bTJ4\u0010 \u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00192\u0006\u0010\t\u001a\u00020-H\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(U¢\u0006\u0002\bUJ9\u0010\"\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020-0$H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(V¢\u0006\u0002\bVJ:\u0010 \u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020-0$H\u0087\nb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(W¢\u0006\u0002\bWJ<\u0010'\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020-H\u0087\u0002b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(X¢\u0006\u0002\bXJ+\u0010+\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u0019H\u0007b\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(Y¢\u0006\u0002\bYJ\u0006\u0010]\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRA\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dRA\u0010.\u001a\u00020-2\u0006\u0010\t\u001a\u00020-8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(/\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(1¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00106\u001a\u0004\u0018\u00010-*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b7\u00108RA\u00109\u001a\u0002052\u0006\u0010\t\u001a\u0002058G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(:\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(<¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=RA\u0010@\u001a\u00020?2\u0006\u0010\t\u001a\u00020?8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(A\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DRA\u0010F\u001a\u00020?2\u0006\u0010\t\u001a\u00020?8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(G\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(H¢\u0006\f\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DRA\u0010K\u001a\u00020J2\u0006\u0010\t\u001a\u00020J8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(L\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(N¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001d\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020R0\u00198F¢\u0006\u0006\u001a\u0004\bS\u0010\u001dRA\u0010Z\u001a\u00020?2\u0006\u0010\t\u001a\u00020?8G@GX\u0086\u000ez\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b([\u0082\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\\¢\u0006\f\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010DÊ\u0001\u0002\bbÊ\u0001\f\bc\u0012\b\bd\u0012\u0004\b\u0003\u0010\u0000¨\u0006a"}, d2 = {"Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl;", "", "_builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState$Builder;", "<init>", "(Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState$Builder;)V", "_build", "Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState;", "Lkotlin/PublishedApi;", "value", "", "roomCode", "getRoomCode", "()Ljava/lang/String;", "setRoomCode", "(Ljava/lang/String;)V", "Lkotlin/jvm/JvmName;", ContentDisposition.Parameters.Name, "clearRoomCode", "", "hostId", "getHostId", "setHostId", "clearHostId", "users", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/metrolist/music/listentogether/proto/Listentogether$UserInfo;", "Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl$UsersProxy;", "getUsers", "()Lcom/google/protobuf/kotlin/DslList;", "add", "addUsers", "plusAssign", "plusAssignUsers", "addAll", "values", "", "addAllUsers", "plusAssignAllUsers", "set", "index", "", "setUsers", "clear", "clearUsers", "Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "currentTrack", "getCurrentTrack", "()Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "setCurrentTrack", "(Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;)V", "clearCurrentTrack", "hasCurrentTrack", "", "currentTrackOrNull", "getCurrentTrackOrNull", "(Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl;)Lcom/metrolist/music/listentogether/proto/Listentogether$TrackInfo;", "isPlaying", "getIsPlaying", "()Z", "setIsPlaying", "(Z)V", "clearIsPlaying", "", "position", "getPosition", "()J", "setPosition", "(J)V", "clearPosition", "lastUpdate", "getLastUpdate", "setLastUpdate", "clearLastUpdate", "", "volume", "getVolume", "()F", "setVolume", "(F)V", "clearVolume", "queue", "Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl$QueueProxy;", "getQueue", "addQueue", "plusAssignQueue", "addAllQueue", "plusAssignAllQueue", "setQueue", "clearQueue", "revision", "getRevision", "setRevision", "clearRevision", "Companion", "UsersProxy", "QueueProxy", "app", "Lcom/google/protobuf/kotlin/ProtoDslMarker;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Dsl {
        private final Listentogether.RoomState.Builder _builder;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl$QueueProxy;", "Lkotlin/text/CharsKt;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class QueueProxy extends CharsKt {
            public static final int $stable = 8;

            private QueueProxy() {
                throw null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl$UsersProxy;", "Lkotlin/text/CharsKt;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class UsersProxy extends CharsKt {
            public static final int $stable = 8;

            private UsersProxy() {
                throw null;
            }
        }

        private Dsl(Listentogether.RoomState.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ Listentogether.RoomState _build() {
            GeneratedMessageLite generatedMessageLiteM915build = this._builder.m915build();
            generatedMessageLiteM915build.getClass();
            return (Listentogether.RoomState) generatedMessageLiteM915build;
        }

        public final /* synthetic */ void addAllQueue(DslList dslList, Iterable iterable) {
            dslList.getClass();
            iterable.getClass();
            this._builder.addAllQueue(iterable);
        }

        public final /* synthetic */ void addAllUsers(DslList dslList, Iterable iterable) {
            dslList.getClass();
            iterable.getClass();
            this._builder.addAllUsers(iterable);
        }

        public final /* synthetic */ void addQueue(DslList dslList, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            this._builder.addQueue(trackInfo);
        }

        public final /* synthetic */ void addUsers(DslList dslList, Listentogether.UserInfo userInfo) {
            dslList.getClass();
            userInfo.getClass();
            this._builder.addUsers(userInfo);
        }

        public final void clearCurrentTrack() {
            this._builder.clearCurrentTrack();
        }

        public final void clearHostId() {
            this._builder.clearHostId();
        }

        public final void clearIsPlaying() {
            this._builder.clearIsPlaying();
        }

        public final void clearLastUpdate() {
            this._builder.clearLastUpdate();
        }

        public final void clearPosition() {
            this._builder.clearPosition();
        }

        public final /* synthetic */ void clearQueue(DslList dslList) {
            dslList.getClass();
            this._builder.clearQueue();
        }

        public final void clearRevision() {
            this._builder.clearRevision();
        }

        public final void clearRoomCode() {
            this._builder.clearRoomCode();
        }

        public final /* synthetic */ void clearUsers(DslList dslList) {
            dslList.getClass();
            this._builder.clearUsers();
        }

        public final void clearVolume() {
            this._builder.clearVolume();
        }

        public final Listentogether.TrackInfo getCurrentTrack() {
            Listentogether.TrackInfo currentTrack = this._builder.getCurrentTrack();
            currentTrack.getClass();
            return currentTrack;
        }

        public final Listentogether.TrackInfo getCurrentTrackOrNull(Dsl dsl) {
            dsl.getClass();
            return RoomStateKtKt.getCurrentTrackOrNull(dsl._builder);
        }

        public final String getHostId() {
            String hostId = this._builder.getHostId();
            hostId.getClass();
            return hostId;
        }

        public final boolean getIsPlaying() {
            return this._builder.getIsPlaying();
        }

        public final long getLastUpdate() {
            return this._builder.getLastUpdate();
        }

        public final long getPosition() {
            return this._builder.getPosition();
        }

        public final /* synthetic */ DslList getQueue() {
            List<Listentogether.TrackInfo> queueList = this._builder.getQueueList();
            queueList.getClass();
            return new DslList(queueList);
        }

        public final long getRevision() {
            return this._builder.getRevision();
        }

        public final String getRoomCode() {
            String roomCode = this._builder.getRoomCode();
            roomCode.getClass();
            return roomCode;
        }

        public final /* synthetic */ DslList getUsers() {
            List<Listentogether.UserInfo> usersList = this._builder.getUsersList();
            usersList.getClass();
            return new DslList(usersList);
        }

        public final float getVolume() {
            return this._builder.getVolume();
        }

        public final boolean hasCurrentTrack() {
            return this._builder.hasCurrentTrack();
        }

        public final /* synthetic */ void plusAssignAllQueue(DslList dslList, Iterable<Listentogether.TrackInfo> iterable) {
            dslList.getClass();
            iterable.getClass();
            addAllQueue(dslList, iterable);
        }

        public final /* synthetic */ void plusAssignAllUsers(DslList dslList, Iterable<Listentogether.UserInfo> iterable) {
            dslList.getClass();
            iterable.getClass();
            addAllUsers(dslList, iterable);
        }

        public final /* synthetic */ void plusAssignQueue(DslList dslList, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            addQueue(dslList, trackInfo);
        }

        public final /* synthetic */ void plusAssignUsers(DslList dslList, Listentogether.UserInfo userInfo) {
            dslList.getClass();
            userInfo.getClass();
            addUsers(dslList, userInfo);
        }

        public final void setCurrentTrack(Listentogether.TrackInfo trackInfo) {
            trackInfo.getClass();
            this._builder.setCurrentTrack(trackInfo);
        }

        public final void setHostId(String str) {
            str.getClass();
            this._builder.setHostId(str);
        }

        public final void setIsPlaying(boolean z) {
            this._builder.setIsPlaying(z);
        }

        public final void setLastUpdate(long j) {
            this._builder.setLastUpdate(j);
        }

        public final void setPosition(long j) {
            this._builder.setPosition(j);
        }

        public final /* synthetic */ void setQueue(DslList dslList, int i, Listentogether.TrackInfo trackInfo) {
            dslList.getClass();
            trackInfo.getClass();
            this._builder.setQueue(i, trackInfo);
        }

        public final void setRevision(long j) {
            this._builder.setRevision(j);
        }

        public final void setRoomCode(String str) {
            str.getClass();
            this._builder.setRoomCode(str);
        }

        public final /* synthetic */ void setUsers(DslList dslList, int i, Listentogether.UserInfo userInfo) {
            dslList.getClass();
            userInfo.getClass();
            this._builder.setUsers(i, userInfo);
        }

        public final void setVolume(float f) {
            this._builder.setVolume(f);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001b\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Lcom/metrolist/music/listentogether/proto/RoomStateKt$Dsl;", "builder", "Lcom/metrolist/music/listentogether/proto/Listentogether$RoomState$Builder;", "Lkotlin/PublishedApi;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final /* synthetic */ Dsl _create(Listentogether.RoomState.Builder builder) {
                builder.getClass();
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Listentogether.RoomState.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }
}
