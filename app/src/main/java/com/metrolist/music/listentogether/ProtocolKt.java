package com.metrolist.music.listentogether;

import com.google.protobuf.GeneratedMessageLite;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProtocolKt {
    public static Listentogether.PlaybackActionPayload PlaybackActionPayload$default(String str, String str2, Long l, Listentogether.TrackInfo trackInfo, List list, String str3, Float f, Long l2, long j, Long l3, int i) {
        if ((i & 8) != 0) {
            trackInfo = null;
        }
        if ((i & 32) != 0) {
            list = null;
        }
        if ((i & 64) != 0) {
            str3 = null;
        }
        if ((i & 128) != 0) {
            f = null;
        }
        if ((i & 256) != 0) {
            l2 = null;
        }
        if ((i & 512) != 0) {
            j = 0;
        }
        if ((i & 1024) != 0) {
            l3 = null;
        }
        Listentogether.PlaybackActionPayload.Builder capturedAtServerTime = Listentogether.PlaybackActionPayload.newBuilder().setAction(str).setPosition(l != null ? l.longValue() : 0L).setInsertNext(false).setVolume(f != null ? f.floatValue() : 1.0f).setServerTime(l2 != null ? l2.longValue() : 0L).setRevision(j).setCapturedAtServerTime(l3 != null ? l3.longValue() : 0L);
        if (str2 != null) {
            capturedAtServerTime.getClass();
            capturedAtServerTime.setTrackId(str2);
        }
        if (trackInfo != null) {
            capturedAtServerTime.getClass();
            capturedAtServerTime.setTrackInfo(trackInfo);
        }
        if (list != null) {
            capturedAtServerTime.getClass();
            capturedAtServerTime.addAllQueue(list);
        }
        if (str3 != null) {
            capturedAtServerTime.getClass();
            capturedAtServerTime.setQueueTitle(str3);
        }
        GeneratedMessageLite generatedMessageLiteBuild = capturedAtServerTime.m915build();
        generatedMessageLiteBuild.getClass();
        return (Listentogether.PlaybackActionPayload) generatedMessageLiteBuild;
    }

    public static final Listentogether.RoomState RoomState(String str, String str2, List list, Listentogether.TrackInfo trackInfo, boolean z, long j, long j2, float f, List list2, long j3) {
        Listentogether.RoomState.Builder revision = Listentogether.RoomState.newBuilder().setRoomCode(str).setHostId(str2).addAllUsers(list).setIsPlaying(z).setPosition(j).setLastUpdate(j2).setVolume(f).addAllQueue(list2).setRevision(j3);
        if (trackInfo != null) {
            revision.getClass();
            revision.setCurrentTrack(trackInfo);
        }
        GeneratedMessageLite generatedMessageLiteBuild = revision.m915build();
        generatedMessageLiteBuild.getClass();
        return (Listentogether.RoomState) generatedMessageLiteBuild;
    }

    public static final Listentogether.SyncStatePayload SyncStatePayload(Listentogether.TrackInfo trackInfo, boolean z, long j, long j2, List list, Float f, long j3) {
        Listentogether.SyncStatePayload.Builder revision = Listentogether.SyncStatePayload.newBuilder().setIsPlaying(z).setPosition(j).setLastUpdate(j2).setVolume(f != null ? f.floatValue() : CropImageView.DEFAULT_ASPECT_RATIO).setRevision(j3);
        if (trackInfo != null) {
            revision.getClass();
            revision.setCurrentTrack(trackInfo);
        }
        if (list != null) {
            revision.getClass();
            revision.addAllQueue(list);
        }
        GeneratedMessageLite generatedMessageLiteBuild = revision.m915build();
        generatedMessageLiteBuild.getClass();
        return (Listentogether.SyncStatePayload) generatedMessageLiteBuild;
    }

    public static final Listentogether.TrackInfo TrackInfo(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        Listentogether.TrackInfo.Builder artist = Listentogether.TrackInfo.newBuilder().setId(str).setTitle(str2).setArtist(str3);
        if (str4 == null) {
            str4 = "";
        }
        Listentogether.TrackInfo.Builder duration = artist.setAlbum(str4).setDuration(j);
        if (str5 == null) {
            str5 = "";
        }
        Listentogether.TrackInfo.Builder thumbnail = duration.setThumbnail(str5);
        if (str6 == null) {
            str6 = "";
        }
        GeneratedMessageLite generatedMessageLiteBuild = thumbnail.setSuggestedBy(str6).m915build();
        generatedMessageLiteBuild.getClass();
        return (Listentogether.TrackInfo) generatedMessageLiteBuild;
    }

    public static final Listentogether.UserInfo UserInfo(String str, String str2, boolean z, boolean z2) {
        GeneratedMessageLite generatedMessageLiteBuild = Listentogether.UserInfo.newBuilder().setUserId(str).setUsername(str2).setIsHost(z).setIsConnected(z2).m915build();
        generatedMessageLiteBuild.getClass();
        return (Listentogether.UserInfo) generatedMessageLiteBuild;
    }

    public static Listentogether.RoomState copy$default(Listentogether.RoomState roomState, String str, ArrayList arrayList, Listentogether.TrackInfo trackInfo, boolean z, long j, long j2, float f, List list, long j3, int i) {
        String roomCode = roomState.getRoomCode();
        roomCode.getClass();
        if ((i & 2) != 0) {
            str = roomState.getHostId();
            str.getClass();
        }
        List list2 = arrayList;
        if ((i & 4) != 0) {
            List<Listentogether.UserInfo> usersList = roomState.getUsersList();
            usersList.getClass();
            list2 = usersList;
        }
        if ((i & 8) != 0) {
            trackInfo = getCurrentTrackOrNull(roomState);
        }
        if ((i & 16) != 0) {
            z = roomState.getIsPlaying();
        }
        if ((i & 32) != 0) {
            j = roomState.getPosition();
        }
        if ((i & 64) != 0) {
            j2 = roomState.getLastUpdate();
        }
        if ((i & 128) != 0) {
            f = roomState.getVolume();
        }
        if ((i & 256) != 0) {
            list = roomState.getQueueList();
            list.getClass();
        }
        if ((i & 512) != 0) {
            j3 = roomState.getRevision();
        }
        return RoomState(roomCode, str, list2, trackInfo, z, j, j2, f, list, j3);
    }

    public static final Listentogether.TrackInfo getCurrentTrackOrNull(Listentogether.SyncStatePayload syncStatePayload) {
        syncStatePayload.getClass();
        if (!syncStatePayload.hasCurrentTrack()) {
            syncStatePayload = null;
        }
        if (syncStatePayload != null) {
            return syncStatePayload.getCurrentTrack();
        }
        return null;
    }

    public static final Long getPositionOrNull(Listentogether.PlaybackActionPayload playbackActionPayload) {
        long position = playbackActionPayload.getPosition();
        Long lValueOf = Long.valueOf(position);
        if (position != 0 || CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"play", "pause", "seek"}).contains(playbackActionPayload.getAction())) {
            return lValueOf;
        }
        return null;
    }

    public static final List getQueue(Listentogether.RoomState roomState) {
        List<Listentogether.TrackInfo> queueList = roomState.getQueueList();
        queueList.getClass();
        return queueList;
    }

    public static final String getReasonOrNull(Listentogether.SuggestionRejectedPayload suggestionRejectedPayload) {
        String reason = suggestionRejectedPayload.getReason();
        if (reason.length() > 0) {
            return reason;
        }
        return null;
    }

    public static final Long getServerTimeOrNull(Listentogether.PlaybackActionPayload playbackActionPayload) {
        long serverTime = playbackActionPayload.getServerTime();
        Long lValueOf = Long.valueOf(serverTime);
        if (serverTime > 0) {
            return lValueOf;
        }
        return null;
    }

    public static final Listentogether.TrackInfo getTrackInfoOrNull(Listentogether.PlaybackActionPayload playbackActionPayload) {
        if (!playbackActionPayload.hasTrackInfo()) {
            playbackActionPayload = null;
        }
        if (playbackActionPayload != null) {
            return playbackActionPayload.getTrackInfo();
        }
        return null;
    }

    public static final List getUsers(Listentogether.RoomState roomState) {
        List<Listentogether.UserInfo> usersList = roomState.getUsersList();
        usersList.getClass();
        return usersList;
    }

    public static final List getQueue(Listentogether.PlaybackActionPayload playbackActionPayload) {
        return playbackActionPayload.getQueueList();
    }

    public static final Listentogether.TrackInfo getCurrentTrackOrNull(Listentogether.RoomState roomState) {
        if (!roomState.hasCurrentTrack()) {
            roomState = null;
        }
        if (roomState != null) {
            return roomState.getCurrentTrack();
        }
        return null;
    }

    public static Listentogether.UserInfo copy$default(Listentogether.UserInfo userInfo, boolean z, boolean z2, int i) {
        String userId = userInfo.getUserId();
        userId.getClass();
        String username = userInfo.getUsername();
        username.getClass();
        if ((i & 4) != 0) {
            z = userInfo.getIsHost();
        }
        if ((i & 8) != 0) {
            z2 = userInfo.getIsConnected();
        }
        return UserInfo(userId, username, z, z2);
    }

    public static Listentogether.SyncStatePayload copy$default(Listentogether.SyncStatePayload syncStatePayload, boolean z, long j, long j2, long j3, int i) {
        Listentogether.TrackInfo currentTrackOrNull = getCurrentTrackOrNull(syncStatePayload);
        if ((i & 2) != 0) {
            z = syncStatePayload.getIsPlaying();
        }
        return SyncStatePayload(currentTrackOrNull, z, j, j2, syncStatePayload.getQueueList(), Float.valueOf(syncStatePayload.getVolume()), j3);
    }
}
