package com.metrolist.music.listentogether.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.yalantis.ucrop.view.CropImageView;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Listentogether {

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.proto.Listentogether$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ApproveJoinPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ApproveSuggestionPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getSuggestionId();

        ByteString getSuggestionIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface BufferCompletePayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getTrackId();

        ByteString getTrackIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface BufferReadyPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getTrackId();

        ByteString getTrackIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface BufferWaitPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getTrackId();

        ByteString getTrackIdBytes();

        String getWaitingFor(int i);

        ByteString getWaitingForBytes(int i);

        int getWaitingForCount();

        List<String> getWaitingForList();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ClientCapabilitiesOrBuilder extends MessageLiteOrBuilder {
        String getClientVersion();

        ByteString getClientVersionBytes();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        boolean getSupportsCompression();

        boolean getSupportsProtobuf();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface CreateRoomPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface EnvelopeOrBuilder extends MessageLiteOrBuilder {
        boolean getCompressed();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        ByteString getPayload();

        String getType();

        ByteString getTypeBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ErrorPayloadOrBuilder extends MessageLiteOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getMessage();

        ByteString getMessageBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface HostChangedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getNewHostId();

        ByteString getNewHostIdBytes();

        String getNewHostName();

        ByteString getNewHostNameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface JoinApprovedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getRoomCode();

        ByteString getRoomCodeBytes();

        String getSessionToken();

        ByteString getSessionTokenBytes();

        RoomState getState();

        String getUserId();

        ByteString getUserIdBytes();

        boolean hasState();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface JoinRejectedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface JoinRequestPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface JoinRoomPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getRoomCode();

        ByteString getRoomCodeBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface KickUserPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        String getUserId();

        ByteString getUserIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface KickedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface LeaveRoomPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PingPayloadOrBuilder extends MessageLiteOrBuilder {
        long getClientTime();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        long getSequence();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PlaybackActionPayloadOrBuilder extends MessageLiteOrBuilder {
        String getAction();

        ByteString getActionBytes();

        long getCapturedAtServerTime();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        boolean getInsertNext();

        long getPosition();

        TrackInfo getQueue(int i);

        int getQueueCount();

        List<TrackInfo> getQueueList();

        String getQueueTitle();

        ByteString getQueueTitleBytes();

        long getRevision();

        long getServerTime();

        String getTrackId();

        ByteString getTrackIdBytes();

        TrackInfo getTrackInfo();

        float getVolume();

        boolean hasTrackInfo();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PongPayloadOrBuilder extends MessageLiteOrBuilder {
        long getClientTime();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        long getSequence();

        long getServerReceiveTime();

        long getServerSendTime();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ReconnectPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getSessionToken();

        ByteString getSessionTokenBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ReconnectedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        boolean getIsHost();

        String getRoomCode();

        ByteString getRoomCodeBytes();

        RoomState getState();

        String getUserId();

        ByteString getUserIdBytes();

        boolean hasState();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface RejectJoinPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        String getUserId();

        ByteString getUserIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface RejectSuggestionPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        String getSuggestionId();

        ByteString getSuggestionIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface RoomCreatedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getRoomCode();

        ByteString getRoomCodeBytes();

        String getSessionToken();

        ByteString getSessionTokenBytes();

        String getUserId();

        ByteString getUserIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface RoomStateOrBuilder extends MessageLiteOrBuilder {
        TrackInfo getCurrentTrack();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getHostId();

        ByteString getHostIdBytes();

        boolean getIsPlaying();

        long getLastUpdate();

        long getPosition();

        TrackInfo getQueue(int i);

        int getQueueCount();

        List<TrackInfo> getQueueList();

        long getRevision();

        String getRoomCode();

        ByteString getRoomCodeBytes();

        UserInfo getUsers(int i);

        int getUsersCount();

        List<UserInfo> getUsersList();

        float getVolume();

        boolean hasCurrentTrack();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ServerCapabilitiesOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getServerVersion();

        ByteString getServerVersionBytes();

        boolean getSupportsCompression();

        boolean getSupportsProtobuf();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SuggestTrackPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        TrackInfo getTrackInfo();

        boolean hasTrackInfo();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SuggestionApprovedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getSuggestionId();

        ByteString getSuggestionIdBytes();

        TrackInfo getTrackInfo();

        boolean hasTrackInfo();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SuggestionReceivedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getFromUserId();

        ByteString getFromUserIdBytes();

        String getFromUsername();

        ByteString getFromUsernameBytes();

        String getSuggestionId();

        ByteString getSuggestionIdBytes();

        TrackInfo getTrackInfo();

        boolean hasTrackInfo();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SuggestionRejectedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getReason();

        ByteString getReasonBytes();

        String getSuggestionId();

        ByteString getSuggestionIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SyncStatePayloadOrBuilder extends MessageLiteOrBuilder {
        TrackInfo getCurrentTrack();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        boolean getIsPlaying();

        long getLastUpdate();

        long getPosition();

        TrackInfo getQueue(int i);

        int getQueueCount();

        List<TrackInfo> getQueueList();

        long getRevision();

        float getVolume();

        boolean hasCurrentTrack();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface TrackInfoOrBuilder extends MessageLiteOrBuilder {
        String getAlbum();

        ByteString getAlbumBytes();

        String getArtist();

        ByteString getArtistBytes();

        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        long getDuration();

        String getId();

        ByteString getIdBytes();

        String getSuggestedBy();

        ByteString getSuggestedByBytes();

        String getThumbnail();

        ByteString getThumbnailBytes();

        String getTitle();

        ByteString getTitleBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface TransferHostPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getNewHostId();

        ByteString getNewHostIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface UserDisconnectedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface UserInfoOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        boolean getIsConnected();

        boolean getIsHost();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface UserJoinedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface UserLeftPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface UserReconnectedPayloadOrBuilder extends MessageLiteOrBuilder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        /* synthetic */ MessageLite getDefaultInstanceForType();

        String getUserId();

        ByteString getUserIdBytes();

        String getUsername();

        ByteString getUsernameBytes();

        /* synthetic */ boolean isInitialized();
    }

    private Listentogether() {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class PlaybackActionPayload extends GeneratedMessageLite implements PlaybackActionPayloadOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int CAPTURED_AT_SERVER_TIME_FIELD_NUMBER = 11;
        private static final PlaybackActionPayload DEFAULT_INSTANCE;
        public static final int INSERT_NEXT_FIELD_NUMBER = 5;
        private static volatile Parser PARSER = null;
        public static final int POSITION_FIELD_NUMBER = 3;
        public static final int QUEUE_FIELD_NUMBER = 6;
        public static final int QUEUE_TITLE_FIELD_NUMBER = 7;
        public static final int REVISION_FIELD_NUMBER = 10;
        public static final int SERVER_TIME_FIELD_NUMBER = 9;
        public static final int TRACK_ID_FIELD_NUMBER = 2;
        public static final int TRACK_INFO_FIELD_NUMBER = 4;
        public static final int VOLUME_FIELD_NUMBER = 8;
        private int bitField0_;
        private long capturedAtServerTime_;
        private boolean insertNext_;
        private long position_;
        private long revision_;
        private long serverTime_;
        private TrackInfo trackInfo_;
        private float volume_;
        private String action_ = "";
        private String trackId_ = "";
        private Internal.ProtobufList queue_ = GeneratedMessageLite.emptyProtobufList();
        private String queueTitle_ = "";

        static {
            PlaybackActionPayload playbackActionPayload = new PlaybackActionPayload();
            DEFAULT_INSTANCE = playbackActionPayload;
            GeneratedMessageLite.registerDefaultInstance(PlaybackActionPayload.class, playbackActionPayload);
        }

        private PlaybackActionPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllQueue(Iterable<? extends TrackInfo> iterable) {
            ensureQueueIsMutable();
            AbstractMessageLite.addAll(iterable, this.queue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAction() {
            this.action_ = getDefaultInstance().getAction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCapturedAtServerTime() {
            this.capturedAtServerTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInsertNext() {
            this.insertNext_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPosition() {
            this.position_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueue() {
            this.queue_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueueTitle() {
            this.queueTitle_ = getDefaultInstance().getQueueTitle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevision() {
            this.revision_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerTime() {
            this.serverTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackId() {
            this.trackId_ = getDefaultInstance().getTrackId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackInfo() {
            this.trackInfo_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVolume() {
            this.volume_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        private void ensureQueueIsMutable() {
            Internal.ProtobufList protobufList = this.queue_;
            if (((AbstractProtobufList) protobufList).isMutable) {
                return;
            }
            this.queue_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static PlaybackActionPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.trackInfo_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.trackInfo_ = trackInfo;
            } else {
                this.trackInfo_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.trackInfo_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static PlaybackActionPayload parseDelimitedFrom(InputStream inputStream) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PlaybackActionPayload parseFrom(ByteBuffer byteBuffer) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeQueue(int i) {
            ensureQueueIsMutable();
            this.queue_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(String str) {
            Objects.requireNonNull(str);
            this.action_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.action_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapturedAtServerTime(long j) {
            this.capturedAtServerTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInsertNext(boolean z) {
            this.insertNext_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPosition(long j) {
            this.position_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.set(i, trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueueTitle(String str) {
            Objects.requireNonNull(str);
            this.queueTitle_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueueTitleBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.queueTitle_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevision(long j) {
            this.revision_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerTime(long j) {
            this.serverTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackId(String str) {
            Objects.requireNonNull(str);
            this.trackId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.trackId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.trackInfo_ = trackInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVolume(float f) {
            this.volume_ = f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004ဉ\u0000\u0005\u0007\u0006\u001b\u0007Ȉ\b\u0001\t\u0002\n\u0003\u000b\u0002", new Object[]{"bitField0_", "action_", "trackId_", "position_", "trackInfo_", "insertNext_", "queue_", TrackInfo.class, "queueTitle_", "volume_", "serverTime_", "revision_", "capturedAtServerTime_"});
            }
            if (iOrdinal == 3) {
                return new PlaybackActionPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (PlaybackActionPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public String getAction() {
            return this.action_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public ByteString getActionBytes() {
            return ByteString.copyFromUtf8(this.action_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public long getCapturedAtServerTime() {
            return this.capturedAtServerTime_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public boolean getInsertNext() {
            return this.insertNext_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public long getPosition() {
            return this.position_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public TrackInfo getQueue(int i) {
            return (TrackInfo) this.queue_.get(i);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public int getQueueCount() {
            return this.queue_.size();
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public List<TrackInfo> getQueueList() {
            return this.queue_;
        }

        public TrackInfoOrBuilder getQueueOrBuilder(int i) {
            return (TrackInfoOrBuilder) this.queue_.get(i);
        }

        public List<? extends TrackInfoOrBuilder> getQueueOrBuilderList() {
            return this.queue_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public String getQueueTitle() {
            return this.queueTitle_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public ByteString getQueueTitleBytes() {
            return ByteString.copyFromUtf8(this.queueTitle_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public long getRevision() {
            return this.revision_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public long getServerTime() {
            return this.serverTime_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public String getTrackId() {
            return this.trackId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public ByteString getTrackIdBytes() {
            return ByteString.copyFromUtf8(this.trackId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public TrackInfo getTrackInfo() {
            TrackInfo trackInfo = this.trackInfo_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public float getVolume() {
            return this.volume_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
        public boolean hasTrackInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements PlaybackActionPayloadOrBuilder {
            private Builder() {
                super(PlaybackActionPayload.DEFAULT_INSTANCE);
            }

            public Builder addAllQueue(Iterable<? extends TrackInfo> iterable) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).addAllQueue(iterable);
                return this;
            }

            public Builder addQueue(TrackInfo.Builder builder) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).addQueue((TrackInfo) builder.m915build());
                return this;
            }

            public Builder clearAction() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearAction();
                return this;
            }

            public Builder clearCapturedAtServerTime() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearCapturedAtServerTime();
                return this;
            }

            public Builder clearInsertNext() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearInsertNext();
                return this;
            }

            public Builder clearPosition() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearPosition();
                return this;
            }

            public Builder clearQueue() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearQueue();
                return this;
            }

            public Builder clearQueueTitle() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearQueueTitle();
                return this;
            }

            public Builder clearRevision() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearRevision();
                return this;
            }

            public Builder clearServerTime() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearServerTime();
                return this;
            }

            public Builder clearTrackId() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearTrackId();
                return this;
            }

            public Builder clearTrackInfo() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearTrackInfo();
                return this;
            }

            public Builder clearVolume() {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).clearVolume();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public String getAction() {
                return ((PlaybackActionPayload) this.instance).getAction();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public ByteString getActionBytes() {
                return ((PlaybackActionPayload) this.instance).getActionBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public long getCapturedAtServerTime() {
                return ((PlaybackActionPayload) this.instance).getCapturedAtServerTime();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public boolean getInsertNext() {
                return ((PlaybackActionPayload) this.instance).getInsertNext();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public long getPosition() {
                return ((PlaybackActionPayload) this.instance).getPosition();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public TrackInfo getQueue(int i) {
                return ((PlaybackActionPayload) this.instance).getQueue(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public int getQueueCount() {
                return ((PlaybackActionPayload) this.instance).getQueueCount();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public List<TrackInfo> getQueueList() {
                return Collections.unmodifiableList(((PlaybackActionPayload) this.instance).getQueueList());
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public String getQueueTitle() {
                return ((PlaybackActionPayload) this.instance).getQueueTitle();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public ByteString getQueueTitleBytes() {
                return ((PlaybackActionPayload) this.instance).getQueueTitleBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public long getRevision() {
                return ((PlaybackActionPayload) this.instance).getRevision();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public long getServerTime() {
                return ((PlaybackActionPayload) this.instance).getServerTime();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public String getTrackId() {
                return ((PlaybackActionPayload) this.instance).getTrackId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public ByteString getTrackIdBytes() {
                return ((PlaybackActionPayload) this.instance).getTrackIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public TrackInfo getTrackInfo() {
                return ((PlaybackActionPayload) this.instance).getTrackInfo();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public float getVolume() {
                return ((PlaybackActionPayload) this.instance).getVolume();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PlaybackActionPayloadOrBuilder
            public boolean hasTrackInfo() {
                return ((PlaybackActionPayload) this.instance).hasTrackInfo();
            }

            public Builder mergeTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).mergeTrackInfo(trackInfo);
                return this;
            }

            public Builder removeQueue(int i) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).removeQueue(i);
                return this;
            }

            public Builder setAction(String str) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setAction(str);
                return this;
            }

            public Builder setActionBytes(ByteString byteString) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setActionBytes(byteString);
                return this;
            }

            public Builder setCapturedAtServerTime(long j) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setCapturedAtServerTime(j);
                return this;
            }

            public Builder setInsertNext(boolean z) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setInsertNext(z);
                return this;
            }

            public Builder setPosition(long j) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setPosition(j);
                return this;
            }

            public Builder setQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setQueue(i, (TrackInfo) builder.m915build());
                return this;
            }

            public Builder setQueueTitle(String str) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setQueueTitle(str);
                return this;
            }

            public Builder setQueueTitleBytes(ByteString byteString) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setQueueTitleBytes(byteString);
                return this;
            }

            public Builder setRevision(long j) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setRevision(j);
                return this;
            }

            public Builder setServerTime(long j) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setServerTime(j);
                return this;
            }

            public Builder setTrackId(String str) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setTrackId(str);
                return this;
            }

            public Builder setTrackIdBytes(ByteString byteString) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setTrackIdBytes(byteString);
                return this;
            }

            public Builder setTrackInfo(TrackInfo.Builder builder) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setTrackInfo((TrackInfo) builder.m915build());
                return this;
            }

            public Builder setVolume(float f) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setVolume(f);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).addQueue(i, trackInfo);
                return this;
            }

            public Builder setQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setQueue(i, trackInfo);
                return this;
            }

            public Builder setTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).setTrackInfo(trackInfo);
                return this;
            }

            public Builder addQueue(TrackInfo trackInfo) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).addQueue(trackInfo);
                return this;
            }

            public Builder addQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((PlaybackActionPayload) this.instance).addQueue(i, (TrackInfo) builder.m915build());
                return this;
            }
        }

        public static Builder newBuilder(PlaybackActionPayload playbackActionPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(playbackActionPayload);
        }

        public static PlaybackActionPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PlaybackActionPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PlaybackActionPayload parseFrom(ByteString byteString) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PlaybackActionPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(i, trackInfo);
        }

        public static PlaybackActionPayload parseFrom(byte[] bArr) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PlaybackActionPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PlaybackActionPayload parseFrom(InputStream inputStream) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PlaybackActionPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PlaybackActionPayload parseFrom(CodedInputStream codedInputStream) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PlaybackActionPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PlaybackActionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class RoomState extends GeneratedMessageLite implements RoomStateOrBuilder {
        public static final int CURRENT_TRACK_FIELD_NUMBER = 4;
        private static final RoomState DEFAULT_INSTANCE;
        public static final int HOST_ID_FIELD_NUMBER = 2;
        public static final int IS_PLAYING_FIELD_NUMBER = 5;
        public static final int LAST_UPDATE_FIELD_NUMBER = 7;
        private static volatile Parser PARSER = null;
        public static final int POSITION_FIELD_NUMBER = 6;
        public static final int QUEUE_FIELD_NUMBER = 9;
        public static final int REVISION_FIELD_NUMBER = 10;
        public static final int ROOM_CODE_FIELD_NUMBER = 1;
        public static final int USERS_FIELD_NUMBER = 3;
        public static final int VOLUME_FIELD_NUMBER = 8;
        private int bitField0_;
        private TrackInfo currentTrack_;
        private boolean isPlaying_;
        private long lastUpdate_;
        private long position_;
        private long revision_;
        private float volume_;
        private String roomCode_ = "";
        private String hostId_ = "";
        private Internal.ProtobufList users_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList queue_ = GeneratedMessageLite.emptyProtobufList();

        static {
            RoomState roomState = new RoomState();
            DEFAULT_INSTANCE = roomState;
            GeneratedMessageLite.registerDefaultInstance(RoomState.class, roomState);
        }

        private RoomState() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllQueue(Iterable<? extends TrackInfo> iterable) {
            ensureQueueIsMutable();
            AbstractMessageLite.addAll(iterable, this.queue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUsers(Iterable<? extends UserInfo> iterable) {
            ensureUsersIsMutable();
            AbstractMessageLite.addAll(iterable, this.users_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUsers(UserInfo userInfo) {
            Objects.requireNonNull(userInfo);
            ensureUsersIsMutable();
            this.users_.add(userInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCurrentTrack() {
            this.currentTrack_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHostId() {
            this.hostId_ = getDefaultInstance().getHostId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsPlaying() {
            this.isPlaying_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastUpdate() {
            this.lastUpdate_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPosition() {
            this.position_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueue() {
            this.queue_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevision() {
            this.revision_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomCode() {
            this.roomCode_ = getDefaultInstance().getRoomCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsers() {
            this.users_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVolume() {
            this.volume_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        private void ensureQueueIsMutable() {
            Internal.ProtobufList protobufList = this.queue_;
            if (((AbstractProtobufList) protobufList).isMutable) {
                return;
            }
            this.queue_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        private void ensureUsersIsMutable() {
            Internal.ProtobufList protobufList = this.users_;
            if (((AbstractProtobufList) protobufList).isMutable) {
                return;
            }
            this.users_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static RoomState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCurrentTrack(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.currentTrack_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.currentTrack_ = trackInfo;
            } else {
                this.currentTrack_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.currentTrack_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static RoomState parseDelimitedFrom(InputStream inputStream) {
            return (RoomState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RoomState parseFrom(ByteBuffer byteBuffer) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeQueue(int i) {
            ensureQueueIsMutable();
            this.queue_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUsers(int i) {
            ensureUsersIsMutable();
            this.users_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentTrack(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.currentTrack_ = trackInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostId(String str) {
            Objects.requireNonNull(str);
            this.hostId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.hostId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsPlaying(boolean z) {
            this.isPlaying_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastUpdate(long j) {
            this.lastUpdate_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPosition(long j) {
            this.position_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.set(i, trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevision(long j) {
            this.revision_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCode(String str) {
            Objects.requireNonNull(str);
            this.roomCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.roomCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsers(int i, UserInfo userInfo) {
            Objects.requireNonNull(userInfo);
            ensureUsersIsMutable();
            this.users_.set(i, userInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVolume(float f) {
            this.volume_ = f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004ဉ\u0000\u0005\u0007\u0006\u0002\u0007\u0002\b\u0001\t\u001b\n\u0003", new Object[]{"bitField0_", "roomCode_", "hostId_", "users_", UserInfo.class, "currentTrack_", "isPlaying_", "position_", "lastUpdate_", "volume_", "queue_", TrackInfo.class, "revision_"});
            }
            if (iOrdinal == 3) {
                return new RoomState();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (RoomState.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public TrackInfo getCurrentTrack() {
            TrackInfo trackInfo = this.currentTrack_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public String getHostId() {
            return this.hostId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public ByteString getHostIdBytes() {
            return ByteString.copyFromUtf8(this.hostId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public boolean getIsPlaying() {
            return this.isPlaying_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public long getLastUpdate() {
            return this.lastUpdate_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public long getPosition() {
            return this.position_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public TrackInfo getQueue(int i) {
            return (TrackInfo) this.queue_.get(i);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public int getQueueCount() {
            return this.queue_.size();
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public List<TrackInfo> getQueueList() {
            return this.queue_;
        }

        public TrackInfoOrBuilder getQueueOrBuilder(int i) {
            return (TrackInfoOrBuilder) this.queue_.get(i);
        }

        public List<? extends TrackInfoOrBuilder> getQueueOrBuilderList() {
            return this.queue_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public long getRevision() {
            return this.revision_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public String getRoomCode() {
            return this.roomCode_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public ByteString getRoomCodeBytes() {
            return ByteString.copyFromUtf8(this.roomCode_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public UserInfo getUsers(int i) {
            return (UserInfo) this.users_.get(i);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public int getUsersCount() {
            return this.users_.size();
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public List<UserInfo> getUsersList() {
            return this.users_;
        }

        public UserInfoOrBuilder getUsersOrBuilder(int i) {
            return (UserInfoOrBuilder) this.users_.get(i);
        }

        public List<? extends UserInfoOrBuilder> getUsersOrBuilderList() {
            return this.users_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public float getVolume() {
            return this.volume_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
        public boolean hasCurrentTrack() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements RoomStateOrBuilder {
            private Builder() {
                super(RoomState.DEFAULT_INSTANCE);
            }

            public Builder addAllQueue(Iterable<? extends TrackInfo> iterable) {
                copyOnWrite();
                ((RoomState) this.instance).addAllQueue(iterable);
                return this;
            }

            public Builder addAllUsers(Iterable<? extends UserInfo> iterable) {
                copyOnWrite();
                ((RoomState) this.instance).addAllUsers(iterable);
                return this;
            }

            public Builder addQueue(TrackInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).addQueue((TrackInfo) builder.m915build());
                return this;
            }

            public Builder addUsers(UserInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).addUsers((UserInfo) builder.m915build());
                return this;
            }

            public Builder clearCurrentTrack() {
                copyOnWrite();
                ((RoomState) this.instance).clearCurrentTrack();
                return this;
            }

            public Builder clearHostId() {
                copyOnWrite();
                ((RoomState) this.instance).clearHostId();
                return this;
            }

            public Builder clearIsPlaying() {
                copyOnWrite();
                ((RoomState) this.instance).clearIsPlaying();
                return this;
            }

            public Builder clearLastUpdate() {
                copyOnWrite();
                ((RoomState) this.instance).clearLastUpdate();
                return this;
            }

            public Builder clearPosition() {
                copyOnWrite();
                ((RoomState) this.instance).clearPosition();
                return this;
            }

            public Builder clearQueue() {
                copyOnWrite();
                ((RoomState) this.instance).clearQueue();
                return this;
            }

            public Builder clearRevision() {
                copyOnWrite();
                ((RoomState) this.instance).clearRevision();
                return this;
            }

            public Builder clearRoomCode() {
                copyOnWrite();
                ((RoomState) this.instance).clearRoomCode();
                return this;
            }

            public Builder clearUsers() {
                copyOnWrite();
                ((RoomState) this.instance).clearUsers();
                return this;
            }

            public Builder clearVolume() {
                copyOnWrite();
                ((RoomState) this.instance).clearVolume();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public TrackInfo getCurrentTrack() {
                return ((RoomState) this.instance).getCurrentTrack();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public String getHostId() {
                return ((RoomState) this.instance).getHostId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public ByteString getHostIdBytes() {
                return ((RoomState) this.instance).getHostIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public boolean getIsPlaying() {
                return ((RoomState) this.instance).getIsPlaying();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public long getLastUpdate() {
                return ((RoomState) this.instance).getLastUpdate();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public long getPosition() {
                return ((RoomState) this.instance).getPosition();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public TrackInfo getQueue(int i) {
                return ((RoomState) this.instance).getQueue(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public int getQueueCount() {
                return ((RoomState) this.instance).getQueueCount();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public List<TrackInfo> getQueueList() {
                return Collections.unmodifiableList(((RoomState) this.instance).getQueueList());
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public long getRevision() {
                return ((RoomState) this.instance).getRevision();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public String getRoomCode() {
                return ((RoomState) this.instance).getRoomCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public ByteString getRoomCodeBytes() {
                return ((RoomState) this.instance).getRoomCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public UserInfo getUsers(int i) {
                return ((RoomState) this.instance).getUsers(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public int getUsersCount() {
                return ((RoomState) this.instance).getUsersCount();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public List<UserInfo> getUsersList() {
                return Collections.unmodifiableList(((RoomState) this.instance).getUsersList());
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public float getVolume() {
                return ((RoomState) this.instance).getVolume();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomStateOrBuilder
            public boolean hasCurrentTrack() {
                return ((RoomState) this.instance).hasCurrentTrack();
            }

            public Builder mergeCurrentTrack(TrackInfo trackInfo) {
                copyOnWrite();
                ((RoomState) this.instance).mergeCurrentTrack(trackInfo);
                return this;
            }

            public Builder removeQueue(int i) {
                copyOnWrite();
                ((RoomState) this.instance).removeQueue(i);
                return this;
            }

            public Builder removeUsers(int i) {
                copyOnWrite();
                ((RoomState) this.instance).removeUsers(i);
                return this;
            }

            public Builder setCurrentTrack(TrackInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).setCurrentTrack((TrackInfo) builder.m915build());
                return this;
            }

            public Builder setHostId(String str) {
                copyOnWrite();
                ((RoomState) this.instance).setHostId(str);
                return this;
            }

            public Builder setHostIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RoomState) this.instance).setHostIdBytes(byteString);
                return this;
            }

            public Builder setIsPlaying(boolean z) {
                copyOnWrite();
                ((RoomState) this.instance).setIsPlaying(z);
                return this;
            }

            public Builder setLastUpdate(long j) {
                copyOnWrite();
                ((RoomState) this.instance).setLastUpdate(j);
                return this;
            }

            public Builder setPosition(long j) {
                copyOnWrite();
                ((RoomState) this.instance).setPosition(j);
                return this;
            }

            public Builder setQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).setQueue(i, (TrackInfo) builder.m915build());
                return this;
            }

            public Builder setRevision(long j) {
                copyOnWrite();
                ((RoomState) this.instance).setRevision(j);
                return this;
            }

            public Builder setRoomCode(String str) {
                copyOnWrite();
                ((RoomState) this.instance).setRoomCode(str);
                return this;
            }

            public Builder setRoomCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RoomState) this.instance).setRoomCodeBytes(byteString);
                return this;
            }

            public Builder setUsers(int i, UserInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).setUsers(i, (UserInfo) builder.m915build());
                return this;
            }

            public Builder setVolume(float f) {
                copyOnWrite();
                ((RoomState) this.instance).setVolume(f);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((RoomState) this.instance).addQueue(i, trackInfo);
                return this;
            }

            public Builder addUsers(int i, UserInfo userInfo) {
                copyOnWrite();
                ((RoomState) this.instance).addUsers(i, userInfo);
                return this;
            }

            public Builder setCurrentTrack(TrackInfo trackInfo) {
                copyOnWrite();
                ((RoomState) this.instance).setCurrentTrack(trackInfo);
                return this;
            }

            public Builder setQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((RoomState) this.instance).setQueue(i, trackInfo);
                return this;
            }

            public Builder setUsers(int i, UserInfo userInfo) {
                copyOnWrite();
                ((RoomState) this.instance).setUsers(i, userInfo);
                return this;
            }

            public Builder addQueue(TrackInfo trackInfo) {
                copyOnWrite();
                ((RoomState) this.instance).addQueue(trackInfo);
                return this;
            }

            public Builder addUsers(UserInfo userInfo) {
                copyOnWrite();
                ((RoomState) this.instance).addUsers(userInfo);
                return this;
            }

            public Builder addQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).addQueue(i, (TrackInfo) builder.m915build());
                return this;
            }

            public Builder addUsers(int i, UserInfo.Builder builder) {
                copyOnWrite();
                ((RoomState) this.instance).addUsers(i, (UserInfo) builder.m915build());
                return this;
            }
        }

        public static Builder newBuilder(RoomState roomState) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(roomState);
        }

        public static RoomState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RoomState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RoomState parseFrom(ByteString byteString) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RoomState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(i, trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUsers(int i, UserInfo userInfo) {
            Objects.requireNonNull(userInfo);
            ensureUsersIsMutable();
            this.users_.add(i, userInfo);
        }

        public static RoomState parseFrom(byte[] bArr) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RoomState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RoomState parseFrom(InputStream inputStream) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RoomState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RoomState parseFrom(CodedInputStream codedInputStream) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RoomState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class SyncStatePayload extends GeneratedMessageLite implements SyncStatePayloadOrBuilder {
        public static final int CURRENT_TRACK_FIELD_NUMBER = 1;
        private static final SyncStatePayload DEFAULT_INSTANCE;
        public static final int IS_PLAYING_FIELD_NUMBER = 2;
        public static final int LAST_UPDATE_FIELD_NUMBER = 4;
        private static volatile Parser PARSER = null;
        public static final int POSITION_FIELD_NUMBER = 3;
        public static final int QUEUE_FIELD_NUMBER = 5;
        public static final int REVISION_FIELD_NUMBER = 7;
        public static final int VOLUME_FIELD_NUMBER = 6;
        private int bitField0_;
        private TrackInfo currentTrack_;
        private boolean isPlaying_;
        private long lastUpdate_;
        private long position_;
        private Internal.ProtobufList queue_ = GeneratedMessageLite.emptyProtobufList();
        private long revision_;
        private float volume_;

        static {
            SyncStatePayload syncStatePayload = new SyncStatePayload();
            DEFAULT_INSTANCE = syncStatePayload;
            GeneratedMessageLite.registerDefaultInstance(SyncStatePayload.class, syncStatePayload);
        }

        private SyncStatePayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllQueue(Iterable<? extends TrackInfo> iterable) {
            ensureQueueIsMutable();
            AbstractMessageLite.addAll(iterable, this.queue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCurrentTrack() {
            this.currentTrack_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsPlaying() {
            this.isPlaying_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastUpdate() {
            this.lastUpdate_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPosition() {
            this.position_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueue() {
            this.queue_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevision() {
            this.revision_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVolume() {
            this.volume_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        private void ensureQueueIsMutable() {
            Internal.ProtobufList protobufList = this.queue_;
            if (((AbstractProtobufList) protobufList).isMutable) {
                return;
            }
            this.queue_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static SyncStatePayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCurrentTrack(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.currentTrack_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.currentTrack_ = trackInfo;
            } else {
                this.currentTrack_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.currentTrack_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static SyncStatePayload parseDelimitedFrom(InputStream inputStream) {
            return (SyncStatePayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SyncStatePayload parseFrom(ByteBuffer byteBuffer) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeQueue(int i) {
            ensureQueueIsMutable();
            this.queue_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentTrack(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.currentTrack_ = trackInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsPlaying(boolean z) {
            this.isPlaying_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastUpdate(long j) {
            this.lastUpdate_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPosition(long j) {
            this.position_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.set(i, trackInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevision(long j) {
            this.revision_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVolume(float f) {
            this.volume_ = f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0007\u0003\u0002\u0004\u0002\u0005\u001b\u0006\u0001\u0007\u0003", new Object[]{"bitField0_", "currentTrack_", "isPlaying_", "position_", "lastUpdate_", "queue_", TrackInfo.class, "volume_", "revision_"});
            }
            if (iOrdinal == 3) {
                return new SyncStatePayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (SyncStatePayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public TrackInfo getCurrentTrack() {
            TrackInfo trackInfo = this.currentTrack_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public boolean getIsPlaying() {
            return this.isPlaying_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public long getLastUpdate() {
            return this.lastUpdate_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public long getPosition() {
            return this.position_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public TrackInfo getQueue(int i) {
            return (TrackInfo) this.queue_.get(i);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public int getQueueCount() {
            return this.queue_.size();
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public List<TrackInfo> getQueueList() {
            return this.queue_;
        }

        public TrackInfoOrBuilder getQueueOrBuilder(int i) {
            return (TrackInfoOrBuilder) this.queue_.get(i);
        }

        public List<? extends TrackInfoOrBuilder> getQueueOrBuilderList() {
            return this.queue_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public long getRevision() {
            return this.revision_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public float getVolume() {
            return this.volume_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
        public boolean hasCurrentTrack() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements SyncStatePayloadOrBuilder {
            private Builder() {
                super(SyncStatePayload.DEFAULT_INSTANCE);
            }

            public Builder addAllQueue(Iterable<? extends TrackInfo> iterable) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).addAllQueue(iterable);
                return this;
            }

            public Builder addQueue(TrackInfo.Builder builder) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).addQueue((TrackInfo) builder.m915build());
                return this;
            }

            public Builder clearCurrentTrack() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearCurrentTrack();
                return this;
            }

            public Builder clearIsPlaying() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearIsPlaying();
                return this;
            }

            public Builder clearLastUpdate() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearLastUpdate();
                return this;
            }

            public Builder clearPosition() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearPosition();
                return this;
            }

            public Builder clearQueue() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearQueue();
                return this;
            }

            public Builder clearRevision() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearRevision();
                return this;
            }

            public Builder clearVolume() {
                copyOnWrite();
                ((SyncStatePayload) this.instance).clearVolume();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public TrackInfo getCurrentTrack() {
                return ((SyncStatePayload) this.instance).getCurrentTrack();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public boolean getIsPlaying() {
                return ((SyncStatePayload) this.instance).getIsPlaying();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public long getLastUpdate() {
                return ((SyncStatePayload) this.instance).getLastUpdate();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public long getPosition() {
                return ((SyncStatePayload) this.instance).getPosition();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public TrackInfo getQueue(int i) {
                return ((SyncStatePayload) this.instance).getQueue(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public int getQueueCount() {
                return ((SyncStatePayload) this.instance).getQueueCount();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public List<TrackInfo> getQueueList() {
                return Collections.unmodifiableList(((SyncStatePayload) this.instance).getQueueList());
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public long getRevision() {
                return ((SyncStatePayload) this.instance).getRevision();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public float getVolume() {
                return ((SyncStatePayload) this.instance).getVolume();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SyncStatePayloadOrBuilder
            public boolean hasCurrentTrack() {
                return ((SyncStatePayload) this.instance).hasCurrentTrack();
            }

            public Builder mergeCurrentTrack(TrackInfo trackInfo) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).mergeCurrentTrack(trackInfo);
                return this;
            }

            public Builder removeQueue(int i) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).removeQueue(i);
                return this;
            }

            public Builder setCurrentTrack(TrackInfo.Builder builder) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setCurrentTrack((TrackInfo) builder.m915build());
                return this;
            }

            public Builder setIsPlaying(boolean z) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setIsPlaying(z);
                return this;
            }

            public Builder setLastUpdate(long j) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setLastUpdate(j);
                return this;
            }

            public Builder setPosition(long j) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setPosition(j);
                return this;
            }

            public Builder setQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setQueue(i, (TrackInfo) builder.m915build());
                return this;
            }

            public Builder setRevision(long j) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setRevision(j);
                return this;
            }

            public Builder setVolume(float f) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setVolume(f);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).addQueue(i, trackInfo);
                return this;
            }

            public Builder setCurrentTrack(TrackInfo trackInfo) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setCurrentTrack(trackInfo);
                return this;
            }

            public Builder setQueue(int i, TrackInfo trackInfo) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).setQueue(i, trackInfo);
                return this;
            }

            public Builder addQueue(TrackInfo trackInfo) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).addQueue(trackInfo);
                return this;
            }

            public Builder addQueue(int i, TrackInfo.Builder builder) {
                copyOnWrite();
                ((SyncStatePayload) this.instance).addQueue(i, (TrackInfo) builder.m915build());
                return this;
            }
        }

        public static Builder newBuilder(SyncStatePayload syncStatePayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(syncStatePayload);
        }

        public static SyncStatePayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SyncStatePayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SyncStatePayload parseFrom(ByteString byteString) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SyncStatePayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addQueue(int i, TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            ensureQueueIsMutable();
            this.queue_.add(i, trackInfo);
        }

        public static SyncStatePayload parseFrom(byte[] bArr) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SyncStatePayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SyncStatePayload parseFrom(InputStream inputStream) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SyncStatePayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SyncStatePayload parseFrom(CodedInputStream codedInputStream) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SyncStatePayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SyncStatePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ApproveJoinPayload extends GeneratedMessageLite implements ApproveJoinPayloadOrBuilder {
        private static final ApproveJoinPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";

        static {
            ApproveJoinPayload approveJoinPayload = new ApproveJoinPayload();
            DEFAULT_INSTANCE = approveJoinPayload;
            GeneratedMessageLite.registerDefaultInstance(ApproveJoinPayload.class, approveJoinPayload);
        }

        private ApproveJoinPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static ApproveJoinPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ApproveJoinPayload parseDelimitedFrom(InputStream inputStream) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ApproveJoinPayload parseFrom(ByteBuffer byteBuffer) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"userId_"});
            }
            if (iOrdinal == 3) {
                return new ApproveJoinPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ApproveJoinPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveJoinPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveJoinPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ApproveJoinPayloadOrBuilder {
            private Builder() {
                super(ApproveJoinPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((ApproveJoinPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveJoinPayloadOrBuilder
            public String getUserId() {
                return ((ApproveJoinPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveJoinPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((ApproveJoinPayload) this.instance).getUserIdBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((ApproveJoinPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ApproveJoinPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ApproveJoinPayload approveJoinPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(approveJoinPayload);
        }

        public static ApproveJoinPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ApproveJoinPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ApproveJoinPayload parseFrom(ByteString byteString) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ApproveJoinPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ApproveJoinPayload parseFrom(byte[] bArr) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ApproveJoinPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ApproveJoinPayload parseFrom(InputStream inputStream) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ApproveJoinPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ApproveJoinPayload parseFrom(CodedInputStream codedInputStream) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ApproveJoinPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ApproveSuggestionPayload extends GeneratedMessageLite implements ApproveSuggestionPayloadOrBuilder {
        private static final ApproveSuggestionPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SUGGESTION_ID_FIELD_NUMBER = 1;
        private String suggestionId_ = "";

        static {
            ApproveSuggestionPayload approveSuggestionPayload = new ApproveSuggestionPayload();
            DEFAULT_INSTANCE = approveSuggestionPayload;
            GeneratedMessageLite.registerDefaultInstance(ApproveSuggestionPayload.class, approveSuggestionPayload);
        }

        private ApproveSuggestionPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestionId() {
            this.suggestionId_ = getDefaultInstance().getSuggestionId();
        }

        public static ApproveSuggestionPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ApproveSuggestionPayload parseDelimitedFrom(InputStream inputStream) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ApproveSuggestionPayload parseFrom(ByteBuffer byteBuffer) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionId(String str) {
            Objects.requireNonNull(str);
            this.suggestionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestionId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"suggestionId_"});
            }
            if (iOrdinal == 3) {
                return new ApproveSuggestionPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ApproveSuggestionPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveSuggestionPayloadOrBuilder
        public String getSuggestionId() {
            return this.suggestionId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveSuggestionPayloadOrBuilder
        public ByteString getSuggestionIdBytes() {
            return ByteString.copyFromUtf8(this.suggestionId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ApproveSuggestionPayloadOrBuilder {
            private Builder() {
                super(ApproveSuggestionPayload.DEFAULT_INSTANCE);
            }

            public Builder clearSuggestionId() {
                copyOnWrite();
                ((ApproveSuggestionPayload) this.instance).clearSuggestionId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveSuggestionPayloadOrBuilder
            public String getSuggestionId() {
                return ((ApproveSuggestionPayload) this.instance).getSuggestionId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ApproveSuggestionPayloadOrBuilder
            public ByteString getSuggestionIdBytes() {
                return ((ApproveSuggestionPayload) this.instance).getSuggestionIdBytes();
            }

            public Builder setSuggestionId(String str) {
                copyOnWrite();
                ((ApproveSuggestionPayload) this.instance).setSuggestionId(str);
                return this;
            }

            public Builder setSuggestionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ApproveSuggestionPayload) this.instance).setSuggestionIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ApproveSuggestionPayload approveSuggestionPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(approveSuggestionPayload);
        }

        public static ApproveSuggestionPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ApproveSuggestionPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ApproveSuggestionPayload parseFrom(ByteString byteString) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ApproveSuggestionPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ApproveSuggestionPayload parseFrom(byte[] bArr) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ApproveSuggestionPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ApproveSuggestionPayload parseFrom(InputStream inputStream) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ApproveSuggestionPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ApproveSuggestionPayload parseFrom(CodedInputStream codedInputStream) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ApproveSuggestionPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ApproveSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class BufferCompletePayload extends GeneratedMessageLite implements BufferCompletePayloadOrBuilder {
        private static final BufferCompletePayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int TRACK_ID_FIELD_NUMBER = 1;
        private String trackId_ = "";

        static {
            BufferCompletePayload bufferCompletePayload = new BufferCompletePayload();
            DEFAULT_INSTANCE = bufferCompletePayload;
            GeneratedMessageLite.registerDefaultInstance(BufferCompletePayload.class, bufferCompletePayload);
        }

        private BufferCompletePayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackId() {
            this.trackId_ = getDefaultInstance().getTrackId();
        }

        public static BufferCompletePayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static BufferCompletePayload parseDelimitedFrom(InputStream inputStream) {
            return (BufferCompletePayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferCompletePayload parseFrom(ByteBuffer byteBuffer) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackId(String str) {
            Objects.requireNonNull(str);
            this.trackId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.trackId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"trackId_"});
            }
            if (iOrdinal == 3) {
                return new BufferCompletePayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (BufferCompletePayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferCompletePayloadOrBuilder
        public String getTrackId() {
            return this.trackId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferCompletePayloadOrBuilder
        public ByteString getTrackIdBytes() {
            return ByteString.copyFromUtf8(this.trackId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements BufferCompletePayloadOrBuilder {
            private Builder() {
                super(BufferCompletePayload.DEFAULT_INSTANCE);
            }

            public Builder clearTrackId() {
                copyOnWrite();
                ((BufferCompletePayload) this.instance).clearTrackId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferCompletePayloadOrBuilder
            public String getTrackId() {
                return ((BufferCompletePayload) this.instance).getTrackId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferCompletePayloadOrBuilder
            public ByteString getTrackIdBytes() {
                return ((BufferCompletePayload) this.instance).getTrackIdBytes();
            }

            public Builder setTrackId(String str) {
                copyOnWrite();
                ((BufferCompletePayload) this.instance).setTrackId(str);
                return this;
            }

            public Builder setTrackIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BufferCompletePayload) this.instance).setTrackIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(BufferCompletePayload bufferCompletePayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(bufferCompletePayload);
        }

        public static BufferCompletePayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferCompletePayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BufferCompletePayload parseFrom(ByteString byteString) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BufferCompletePayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BufferCompletePayload parseFrom(byte[] bArr) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BufferCompletePayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BufferCompletePayload parseFrom(InputStream inputStream) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferCompletePayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferCompletePayload parseFrom(CodedInputStream codedInputStream) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BufferCompletePayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferCompletePayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class BufferReadyPayload extends GeneratedMessageLite implements BufferReadyPayloadOrBuilder {
        private static final BufferReadyPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int TRACK_ID_FIELD_NUMBER = 1;
        private String trackId_ = "";

        static {
            BufferReadyPayload bufferReadyPayload = new BufferReadyPayload();
            DEFAULT_INSTANCE = bufferReadyPayload;
            GeneratedMessageLite.registerDefaultInstance(BufferReadyPayload.class, bufferReadyPayload);
        }

        private BufferReadyPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackId() {
            this.trackId_ = getDefaultInstance().getTrackId();
        }

        public static BufferReadyPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static BufferReadyPayload parseDelimitedFrom(InputStream inputStream) {
            return (BufferReadyPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferReadyPayload parseFrom(ByteBuffer byteBuffer) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackId(String str) {
            Objects.requireNonNull(str);
            this.trackId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.trackId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"trackId_"});
            }
            if (iOrdinal == 3) {
                return new BufferReadyPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (BufferReadyPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferReadyPayloadOrBuilder
        public String getTrackId() {
            return this.trackId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferReadyPayloadOrBuilder
        public ByteString getTrackIdBytes() {
            return ByteString.copyFromUtf8(this.trackId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements BufferReadyPayloadOrBuilder {
            private Builder() {
                super(BufferReadyPayload.DEFAULT_INSTANCE);
            }

            public Builder clearTrackId() {
                copyOnWrite();
                ((BufferReadyPayload) this.instance).clearTrackId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferReadyPayloadOrBuilder
            public String getTrackId() {
                return ((BufferReadyPayload) this.instance).getTrackId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferReadyPayloadOrBuilder
            public ByteString getTrackIdBytes() {
                return ((BufferReadyPayload) this.instance).getTrackIdBytes();
            }

            public Builder setTrackId(String str) {
                copyOnWrite();
                ((BufferReadyPayload) this.instance).setTrackId(str);
                return this;
            }

            public Builder setTrackIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BufferReadyPayload) this.instance).setTrackIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(BufferReadyPayload bufferReadyPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(bufferReadyPayload);
        }

        public static BufferReadyPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferReadyPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BufferReadyPayload parseFrom(ByteString byteString) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BufferReadyPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BufferReadyPayload parseFrom(byte[] bArr) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BufferReadyPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BufferReadyPayload parseFrom(InputStream inputStream) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferReadyPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferReadyPayload parseFrom(CodedInputStream codedInputStream) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BufferReadyPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferReadyPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class BufferWaitPayload extends GeneratedMessageLite implements BufferWaitPayloadOrBuilder {
        private static final BufferWaitPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int TRACK_ID_FIELD_NUMBER = 1;
        public static final int WAITING_FOR_FIELD_NUMBER = 2;
        private String trackId_ = "";
        private Internal.ProtobufList waitingFor_ = GeneratedMessageLite.emptyProtobufList();

        static {
            BufferWaitPayload bufferWaitPayload = new BufferWaitPayload();
            DEFAULT_INSTANCE = bufferWaitPayload;
            GeneratedMessageLite.registerDefaultInstance(BufferWaitPayload.class, bufferWaitPayload);
        }

        private BufferWaitPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllWaitingFor(Iterable<String> iterable) {
            ensureWaitingForIsMutable();
            AbstractMessageLite.addAll(iterable, this.waitingFor_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addWaitingFor(String str) {
            Objects.requireNonNull(str);
            ensureWaitingForIsMutable();
            this.waitingFor_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addWaitingForBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureWaitingForIsMutable();
            this.waitingFor_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackId() {
            this.trackId_ = getDefaultInstance().getTrackId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWaitingFor() {
            this.waitingFor_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureWaitingForIsMutable() {
            Internal.ProtobufList protobufList = this.waitingFor_;
            if (((AbstractProtobufList) protobufList).isMutable) {
                return;
            }
            this.waitingFor_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static BufferWaitPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static BufferWaitPayload parseDelimitedFrom(InputStream inputStream) {
            return (BufferWaitPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferWaitPayload parseFrom(ByteBuffer byteBuffer) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackId(String str) {
            Objects.requireNonNull(str);
            this.trackId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.trackId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWaitingFor(int i, String str) {
            Objects.requireNonNull(str);
            ensureWaitingForIsMutable();
            this.waitingFor_.set(i, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"trackId_", "waitingFor_"});
            }
            if (iOrdinal == 3) {
                return new BufferWaitPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (BufferWaitPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public String getTrackId() {
            return this.trackId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public ByteString getTrackIdBytes() {
            return ByteString.copyFromUtf8(this.trackId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public String getWaitingFor(int i) {
            return (String) this.waitingFor_.get(i);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public ByteString getWaitingForBytes(int i) {
            return ByteString.copyFromUtf8((String) this.waitingFor_.get(i));
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public int getWaitingForCount() {
            return this.waitingFor_.size();
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
        public List<String> getWaitingForList() {
            return this.waitingFor_;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements BufferWaitPayloadOrBuilder {
            private Builder() {
                super(BufferWaitPayload.DEFAULT_INSTANCE);
            }

            public Builder addAllWaitingFor(Iterable<String> iterable) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).addAllWaitingFor(iterable);
                return this;
            }

            public Builder addWaitingFor(String str) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).addWaitingFor(str);
                return this;
            }

            public Builder addWaitingForBytes(ByteString byteString) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).addWaitingForBytes(byteString);
                return this;
            }

            public Builder clearTrackId() {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).clearTrackId();
                return this;
            }

            public Builder clearWaitingFor() {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).clearWaitingFor();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public String getTrackId() {
                return ((BufferWaitPayload) this.instance).getTrackId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public ByteString getTrackIdBytes() {
                return ((BufferWaitPayload) this.instance).getTrackIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public String getWaitingFor(int i) {
                return ((BufferWaitPayload) this.instance).getWaitingFor(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public ByteString getWaitingForBytes(int i) {
                return ((BufferWaitPayload) this.instance).getWaitingForBytes(i);
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public int getWaitingForCount() {
                return ((BufferWaitPayload) this.instance).getWaitingForCount();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.BufferWaitPayloadOrBuilder
            public List<String> getWaitingForList() {
                return Collections.unmodifiableList(((BufferWaitPayload) this.instance).getWaitingForList());
            }

            public Builder setTrackId(String str) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).setTrackId(str);
                return this;
            }

            public Builder setTrackIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).setTrackIdBytes(byteString);
                return this;
            }

            public Builder setWaitingFor(int i, String str) {
                copyOnWrite();
                ((BufferWaitPayload) this.instance).setWaitingFor(i, str);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(BufferWaitPayload bufferWaitPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(bufferWaitPayload);
        }

        public static BufferWaitPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferWaitPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BufferWaitPayload parseFrom(ByteString byteString) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BufferWaitPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BufferWaitPayload parseFrom(byte[] bArr) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BufferWaitPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BufferWaitPayload parseFrom(InputStream inputStream) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BufferWaitPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BufferWaitPayload parseFrom(CodedInputStream codedInputStream) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BufferWaitPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BufferWaitPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ClientCapabilities extends GeneratedMessageLite implements ClientCapabilitiesOrBuilder {
        public static final int CLIENT_VERSION_FIELD_NUMBER = 3;
        private static final ClientCapabilities DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SUPPORTS_COMPRESSION_FIELD_NUMBER = 2;
        public static final int SUPPORTS_PROTOBUF_FIELD_NUMBER = 1;
        private String clientVersion_ = "";
        private boolean supportsCompression_;
        private boolean supportsProtobuf_;

        static {
            ClientCapabilities clientCapabilities = new ClientCapabilities();
            DEFAULT_INSTANCE = clientCapabilities;
            GeneratedMessageLite.registerDefaultInstance(ClientCapabilities.class, clientCapabilities);
        }

        private ClientCapabilities() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientVersion() {
            this.clientVersion_ = getDefaultInstance().getClientVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSupportsCompression() {
            this.supportsCompression_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSupportsProtobuf() {
            this.supportsProtobuf_ = false;
        }

        public static ClientCapabilities getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ClientCapabilities parseDelimitedFrom(InputStream inputStream) {
            return (ClientCapabilities) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientCapabilities parseFrom(ByteBuffer byteBuffer) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientVersion(String str) {
            Objects.requireNonNull(str);
            this.clientVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clientVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportsCompression(boolean z) {
            this.supportsCompression_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportsProtobuf(boolean z) {
            this.supportsProtobuf_ = z;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003Ȉ", new Object[]{"supportsProtobuf_", "supportsCompression_", "clientVersion_"});
            }
            if (iOrdinal == 3) {
                return new ClientCapabilities();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ClientCapabilities.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
        public String getClientVersion() {
            return this.clientVersion_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
        public ByteString getClientVersionBytes() {
            return ByteString.copyFromUtf8(this.clientVersion_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
        public boolean getSupportsCompression() {
            return this.supportsCompression_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
        public boolean getSupportsProtobuf() {
            return this.supportsProtobuf_;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ClientCapabilitiesOrBuilder {
            private Builder() {
                super(ClientCapabilities.DEFAULT_INSTANCE);
            }

            public Builder clearClientVersion() {
                copyOnWrite();
                ((ClientCapabilities) this.instance).clearClientVersion();
                return this;
            }

            public Builder clearSupportsCompression() {
                copyOnWrite();
                ((ClientCapabilities) this.instance).clearSupportsCompression();
                return this;
            }

            public Builder clearSupportsProtobuf() {
                copyOnWrite();
                ((ClientCapabilities) this.instance).clearSupportsProtobuf();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
            public String getClientVersion() {
                return ((ClientCapabilities) this.instance).getClientVersion();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
            public ByteString getClientVersionBytes() {
                return ((ClientCapabilities) this.instance).getClientVersionBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
            public boolean getSupportsCompression() {
                return ((ClientCapabilities) this.instance).getSupportsCompression();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ClientCapabilitiesOrBuilder
            public boolean getSupportsProtobuf() {
                return ((ClientCapabilities) this.instance).getSupportsProtobuf();
            }

            public Builder setClientVersion(String str) {
                copyOnWrite();
                ((ClientCapabilities) this.instance).setClientVersion(str);
                return this;
            }

            public Builder setClientVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientCapabilities) this.instance).setClientVersionBytes(byteString);
                return this;
            }

            public Builder setSupportsCompression(boolean z) {
                copyOnWrite();
                ((ClientCapabilities) this.instance).setSupportsCompression(z);
                return this;
            }

            public Builder setSupportsProtobuf(boolean z) {
                copyOnWrite();
                ((ClientCapabilities) this.instance).setSupportsProtobuf(z);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ClientCapabilities clientCapabilities) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(clientCapabilities);
        }

        public static ClientCapabilities parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientCapabilities parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientCapabilities parseFrom(ByteString byteString) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientCapabilities parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientCapabilities parseFrom(byte[] bArr) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientCapabilities parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientCapabilities parseFrom(InputStream inputStream) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientCapabilities parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientCapabilities parseFrom(CodedInputStream codedInputStream) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientCapabilities parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class CreateRoomPayload extends GeneratedMessageLite implements CreateRoomPayloadOrBuilder {
        private static final CreateRoomPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 1;
        private String username_ = "";

        static {
            CreateRoomPayload createRoomPayload = new CreateRoomPayload();
            DEFAULT_INSTANCE = createRoomPayload;
            GeneratedMessageLite.registerDefaultInstance(CreateRoomPayload.class, createRoomPayload);
        }

        private CreateRoomPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static CreateRoomPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static CreateRoomPayload parseDelimitedFrom(InputStream inputStream) {
            return (CreateRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateRoomPayload parseFrom(ByteBuffer byteBuffer) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"username_"});
            }
            if (iOrdinal == 3) {
                return new CreateRoomPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (CreateRoomPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.CreateRoomPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.CreateRoomPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements CreateRoomPayloadOrBuilder {
            private Builder() {
                super(CreateRoomPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((CreateRoomPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.CreateRoomPayloadOrBuilder
            public String getUsername() {
                return ((CreateRoomPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.CreateRoomPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((CreateRoomPayload) this.instance).getUsernameBytes();
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((CreateRoomPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((CreateRoomPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(CreateRoomPayload createRoomPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(createRoomPayload);
        }

        public static CreateRoomPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateRoomPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CreateRoomPayload parseFrom(ByteString byteString) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CreateRoomPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CreateRoomPayload parseFrom(byte[] bArr) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CreateRoomPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CreateRoomPayload parseFrom(InputStream inputStream) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CreateRoomPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CreateRoomPayload parseFrom(CodedInputStream codedInputStream) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CreateRoomPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CreateRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class Envelope extends GeneratedMessageLite implements EnvelopeOrBuilder {
        public static final int COMPRESSED_FIELD_NUMBER = 3;
        private static final Envelope DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int PAYLOAD_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean compressed_;
        private String type_ = "";
        private ByteString payload_ = ByteString.EMPTY;

        static {
            Envelope envelope = new Envelope();
            DEFAULT_INSTANCE = envelope;
            GeneratedMessageLite.registerDefaultInstance(Envelope.class, envelope);
        }

        private Envelope() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCompressed() {
            this.compressed_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPayload() {
            this.payload_ = getDefaultInstance().getPayload();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        public static Envelope getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Envelope parseDelimitedFrom(InputStream inputStream) {
            return (Envelope) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Envelope parseFrom(ByteBuffer byteBuffer) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCompressed(boolean z) {
            this.compressed_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPayload(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.payload_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            Objects.requireNonNull(str);
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.type_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\u0007", new Object[]{"type_", "payload_", "compressed_"});
            }
            if (iOrdinal == 3) {
                return new Envelope();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (Envelope.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
        public boolean getCompressed() {
            return this.compressed_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
        public ByteString getPayload() {
            return this.payload_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements EnvelopeOrBuilder {
            private Builder() {
                super(Envelope.DEFAULT_INSTANCE);
            }

            public Builder clearCompressed() {
                copyOnWrite();
                ((Envelope) this.instance).clearCompressed();
                return this;
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((Envelope) this.instance).clearPayload();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Envelope) this.instance).clearType();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
            public boolean getCompressed() {
                return ((Envelope) this.instance).getCompressed();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
            public ByteString getPayload() {
                return ((Envelope) this.instance).getPayload();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
            public String getType() {
                return ((Envelope) this.instance).getType();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.EnvelopeOrBuilder
            public ByteString getTypeBytes() {
                return ((Envelope) this.instance).getTypeBytes();
            }

            public Builder setCompressed(boolean z) {
                copyOnWrite();
                ((Envelope) this.instance).setCompressed(z);
                return this;
            }

            public Builder setPayload(ByteString byteString) {
                copyOnWrite();
                ((Envelope) this.instance).setPayload(byteString);
                return this;
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((Envelope) this.instance).setType(str);
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Envelope) this.instance).setTypeBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(Envelope envelope) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(envelope);
        }

        public static Envelope parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Envelope parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Envelope parseFrom(ByteString byteString) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Envelope parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Envelope parseFrom(byte[] bArr) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Envelope parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Envelope parseFrom(InputStream inputStream) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Envelope parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Envelope parseFrom(CodedInputStream codedInputStream) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Envelope parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ErrorPayload extends GeneratedMessageLite implements ErrorPayloadOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final ErrorPayload DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser PARSER;
        private String code_ = "";
        private String message_ = "";

        static {
            ErrorPayload errorPayload = new ErrorPayload();
            DEFAULT_INSTANCE = errorPayload;
            GeneratedMessageLite.registerDefaultInstance(ErrorPayload.class, errorPayload);
        }

        private ErrorPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = getDefaultInstance().getCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        public static ErrorPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ErrorPayload parseDelimitedFrom(InputStream inputStream) {
            return (ErrorPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ErrorPayload parseFrom(ByteBuffer byteBuffer) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(String str) {
            Objects.requireNonNull(str);
            this.code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.code_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            Objects.requireNonNull(str);
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"code_", "message_"});
            }
            if (iOrdinal == 3) {
                return new ErrorPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ErrorPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
        public String getCode() {
            return this.code_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
        public ByteString getCodeBytes() {
            return ByteString.copyFromUtf8(this.code_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ErrorPayloadOrBuilder {
            private Builder() {
                super(ErrorPayload.DEFAULT_INSTANCE);
            }

            public Builder clearCode() {
                copyOnWrite();
                ((ErrorPayload) this.instance).clearCode();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((ErrorPayload) this.instance).clearMessage();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
            public String getCode() {
                return ((ErrorPayload) this.instance).getCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
            public ByteString getCodeBytes() {
                return ((ErrorPayload) this.instance).getCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
            public String getMessage() {
                return ((ErrorPayload) this.instance).getMessage();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ErrorPayloadOrBuilder
            public ByteString getMessageBytes() {
                return ((ErrorPayload) this.instance).getMessageBytes();
            }

            public Builder setCode(String str) {
                copyOnWrite();
                ((ErrorPayload) this.instance).setCode(str);
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ErrorPayload) this.instance).setCodeBytes(byteString);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((ErrorPayload) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((ErrorPayload) this.instance).setMessageBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ErrorPayload errorPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(errorPayload);
        }

        public static ErrorPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ErrorPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ErrorPayload parseFrom(ByteString byteString) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ErrorPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ErrorPayload parseFrom(byte[] bArr) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ErrorPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ErrorPayload parseFrom(InputStream inputStream) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ErrorPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ErrorPayload parseFrom(CodedInputStream codedInputStream) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ErrorPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class HostChangedPayload extends GeneratedMessageLite implements HostChangedPayloadOrBuilder {
        private static final HostChangedPayload DEFAULT_INSTANCE;
        public static final int NEW_HOST_ID_FIELD_NUMBER = 1;
        public static final int NEW_HOST_NAME_FIELD_NUMBER = 2;
        private static volatile Parser PARSER;
        private String newHostId_ = "";
        private String newHostName_ = "";

        static {
            HostChangedPayload hostChangedPayload = new HostChangedPayload();
            DEFAULT_INSTANCE = hostChangedPayload;
            GeneratedMessageLite.registerDefaultInstance(HostChangedPayload.class, hostChangedPayload);
        }

        private HostChangedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewHostId() {
            this.newHostId_ = getDefaultInstance().getNewHostId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewHostName() {
            this.newHostName_ = getDefaultInstance().getNewHostName();
        }

        public static HostChangedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static HostChangedPayload parseDelimitedFrom(InputStream inputStream) {
            return (HostChangedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HostChangedPayload parseFrom(ByteBuffer byteBuffer) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostId(String str) {
            Objects.requireNonNull(str);
            this.newHostId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.newHostId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostName(String str) {
            Objects.requireNonNull(str);
            this.newHostName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.newHostName_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"newHostId_", "newHostName_"});
            }
            if (iOrdinal == 3) {
                return new HostChangedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (HostChangedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
        public String getNewHostId() {
            return this.newHostId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
        public ByteString getNewHostIdBytes() {
            return ByteString.copyFromUtf8(this.newHostId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
        public String getNewHostName() {
            return this.newHostName_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
        public ByteString getNewHostNameBytes() {
            return ByteString.copyFromUtf8(this.newHostName_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements HostChangedPayloadOrBuilder {
            private Builder() {
                super(HostChangedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearNewHostId() {
                copyOnWrite();
                ((HostChangedPayload) this.instance).clearNewHostId();
                return this;
            }

            public Builder clearNewHostName() {
                copyOnWrite();
                ((HostChangedPayload) this.instance).clearNewHostName();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
            public String getNewHostId() {
                return ((HostChangedPayload) this.instance).getNewHostId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
            public ByteString getNewHostIdBytes() {
                return ((HostChangedPayload) this.instance).getNewHostIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
            public String getNewHostName() {
                return ((HostChangedPayload) this.instance).getNewHostName();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.HostChangedPayloadOrBuilder
            public ByteString getNewHostNameBytes() {
                return ((HostChangedPayload) this.instance).getNewHostNameBytes();
            }

            public Builder setNewHostId(String str) {
                copyOnWrite();
                ((HostChangedPayload) this.instance).setNewHostId(str);
                return this;
            }

            public Builder setNewHostIdBytes(ByteString byteString) {
                copyOnWrite();
                ((HostChangedPayload) this.instance).setNewHostIdBytes(byteString);
                return this;
            }

            public Builder setNewHostName(String str) {
                copyOnWrite();
                ((HostChangedPayload) this.instance).setNewHostName(str);
                return this;
            }

            public Builder setNewHostNameBytes(ByteString byteString) {
                copyOnWrite();
                ((HostChangedPayload) this.instance).setNewHostNameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(HostChangedPayload hostChangedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(hostChangedPayload);
        }

        public static HostChangedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HostChangedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HostChangedPayload parseFrom(ByteString byteString) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static HostChangedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static HostChangedPayload parseFrom(byte[] bArr) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HostChangedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static HostChangedPayload parseFrom(InputStream inputStream) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HostChangedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HostChangedPayload parseFrom(CodedInputStream codedInputStream) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HostChangedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (HostChangedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class JoinApprovedPayload extends GeneratedMessageLite implements JoinApprovedPayloadOrBuilder {
        private static final JoinApprovedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int ROOM_CODE_FIELD_NUMBER = 1;
        public static final int SESSION_TOKEN_FIELD_NUMBER = 3;
        public static final int STATE_FIELD_NUMBER = 4;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private int bitField0_;
        private RoomState state_;
        private String roomCode_ = "";
        private String userId_ = "";
        private String sessionToken_ = "";

        static {
            JoinApprovedPayload joinApprovedPayload = new JoinApprovedPayload();
            DEFAULT_INSTANCE = joinApprovedPayload;
            GeneratedMessageLite.registerDefaultInstance(JoinApprovedPayload.class, joinApprovedPayload);
        }

        private JoinApprovedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomCode() {
            this.roomCode_ = getDefaultInstance().getRoomCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionToken() {
            this.sessionToken_ = getDefaultInstance().getSessionToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.state_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static JoinApprovedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeState(RoomState roomState) {
            Objects.requireNonNull(roomState);
            RoomState roomState2 = this.state_;
            if (roomState2 == null || roomState2 == RoomState.getDefaultInstance()) {
                this.state_ = roomState;
            } else {
                this.state_ = (RoomState) ((RoomState.Builder) RoomState.newBuilder(this.state_).mergeFrom((GeneratedMessageLite) roomState)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static JoinApprovedPayload parseDelimitedFrom(InputStream inputStream) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinApprovedPayload parseFrom(ByteBuffer byteBuffer) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCode(String str) {
            Objects.requireNonNull(str);
            this.roomCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.roomCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionToken(String str) {
            Objects.requireNonNull(str);
            this.sessionToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sessionToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(RoomState roomState) {
            Objects.requireNonNull(roomState);
            this.state_ = roomState;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "roomCode_", "userId_", "sessionToken_", "state_"});
            }
            if (iOrdinal == 3) {
                return new JoinApprovedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (JoinApprovedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public String getRoomCode() {
            return this.roomCode_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public ByteString getRoomCodeBytes() {
            return ByteString.copyFromUtf8(this.roomCode_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public String getSessionToken() {
            return this.sessionToken_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public ByteString getSessionTokenBytes() {
            return ByteString.copyFromUtf8(this.sessionToken_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public RoomState getState() {
            RoomState roomState = this.state_;
            return roomState == null ? RoomState.getDefaultInstance() : roomState;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
        public boolean hasState() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements JoinApprovedPayloadOrBuilder {
            private Builder() {
                super(JoinApprovedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearRoomCode() {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).clearRoomCode();
                return this;
            }

            public Builder clearSessionToken() {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).clearSessionToken();
                return this;
            }

            public Builder clearState() {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).clearState();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public String getRoomCode() {
                return ((JoinApprovedPayload) this.instance).getRoomCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public ByteString getRoomCodeBytes() {
                return ((JoinApprovedPayload) this.instance).getRoomCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public String getSessionToken() {
                return ((JoinApprovedPayload) this.instance).getSessionToken();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public ByteString getSessionTokenBytes() {
                return ((JoinApprovedPayload) this.instance).getSessionTokenBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public RoomState getState() {
                return ((JoinApprovedPayload) this.instance).getState();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public String getUserId() {
                return ((JoinApprovedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((JoinApprovedPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinApprovedPayloadOrBuilder
            public boolean hasState() {
                return ((JoinApprovedPayload) this.instance).hasState();
            }

            public Builder mergeState(RoomState roomState) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).mergeState(roomState);
                return this;
            }

            public Builder setRoomCode(String str) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setRoomCode(str);
                return this;
            }

            public Builder setRoomCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setRoomCodeBytes(byteString);
                return this;
            }

            public Builder setSessionToken(String str) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setSessionToken(str);
                return this;
            }

            public Builder setSessionTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setSessionTokenBytes(byteString);
                return this;
            }

            public Builder setState(RoomState.Builder builder) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setState((RoomState) builder.m915build());
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setState(RoomState roomState) {
                copyOnWrite();
                ((JoinApprovedPayload) this.instance).setState(roomState);
                return this;
            }
        }

        public static Builder newBuilder(JoinApprovedPayload joinApprovedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(joinApprovedPayload);
        }

        public static JoinApprovedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinApprovedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JoinApprovedPayload parseFrom(ByteString byteString) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JoinApprovedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JoinApprovedPayload parseFrom(byte[] bArr) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JoinApprovedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JoinApprovedPayload parseFrom(InputStream inputStream) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinApprovedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinApprovedPayload parseFrom(CodedInputStream codedInputStream) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JoinApprovedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class JoinRejectedPayload extends GeneratedMessageLite implements JoinRejectedPayloadOrBuilder {
        private static final JoinRejectedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 1;
        private String reason_ = "";

        static {
            JoinRejectedPayload joinRejectedPayload = new JoinRejectedPayload();
            DEFAULT_INSTANCE = joinRejectedPayload;
            GeneratedMessageLite.registerDefaultInstance(JoinRejectedPayload.class, joinRejectedPayload);
        }

        private JoinRejectedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        public static JoinRejectedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static JoinRejectedPayload parseDelimitedFrom(InputStream inputStream) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRejectedPayload parseFrom(ByteBuffer byteBuffer) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"reason_"});
            }
            if (iOrdinal == 3) {
                return new JoinRejectedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (JoinRejectedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRejectedPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRejectedPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements JoinRejectedPayloadOrBuilder {
            private Builder() {
                super(JoinRejectedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((JoinRejectedPayload) this.instance).clearReason();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRejectedPayloadOrBuilder
            public String getReason() {
                return ((JoinRejectedPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRejectedPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((JoinRejectedPayload) this.instance).getReasonBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((JoinRejectedPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinRejectedPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(JoinRejectedPayload joinRejectedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(joinRejectedPayload);
        }

        public static JoinRejectedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRejectedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JoinRejectedPayload parseFrom(ByteString byteString) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JoinRejectedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JoinRejectedPayload parseFrom(byte[] bArr) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JoinRejectedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JoinRejectedPayload parseFrom(InputStream inputStream) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRejectedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRejectedPayload parseFrom(CodedInputStream codedInputStream) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JoinRejectedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class JoinRequestPayload extends GeneratedMessageLite implements JoinRequestPayloadOrBuilder {
        private static final JoinRequestPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String username_ = "";

        static {
            JoinRequestPayload joinRequestPayload = new JoinRequestPayload();
            DEFAULT_INSTANCE = joinRequestPayload;
            GeneratedMessageLite.registerDefaultInstance(JoinRequestPayload.class, joinRequestPayload);
        }

        private JoinRequestPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static JoinRequestPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static JoinRequestPayload parseDelimitedFrom(InputStream inputStream) {
            return (JoinRequestPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRequestPayload parseFrom(ByteBuffer byteBuffer) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "username_"});
            }
            if (iOrdinal == 3) {
                return new JoinRequestPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (JoinRequestPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements JoinRequestPayloadOrBuilder {
            private Builder() {
                super(JoinRequestPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
            public String getUserId() {
                return ((JoinRequestPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((JoinRequestPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
            public String getUsername() {
                return ((JoinRequestPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRequestPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((JoinRequestPayload) this.instance).getUsernameBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinRequestPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(JoinRequestPayload joinRequestPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(joinRequestPayload);
        }

        public static JoinRequestPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRequestPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JoinRequestPayload parseFrom(ByteString byteString) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JoinRequestPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JoinRequestPayload parseFrom(byte[] bArr) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JoinRequestPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JoinRequestPayload parseFrom(InputStream inputStream) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRequestPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRequestPayload parseFrom(CodedInputStream codedInputStream) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JoinRequestPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRequestPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class JoinRoomPayload extends GeneratedMessageLite implements JoinRoomPayloadOrBuilder {
        private static final JoinRoomPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int ROOM_CODE_FIELD_NUMBER = 1;
        public static final int USERNAME_FIELD_NUMBER = 2;
        private String roomCode_ = "";
        private String username_ = "";

        static {
            JoinRoomPayload joinRoomPayload = new JoinRoomPayload();
            DEFAULT_INSTANCE = joinRoomPayload;
            GeneratedMessageLite.registerDefaultInstance(JoinRoomPayload.class, joinRoomPayload);
        }

        private JoinRoomPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomCode() {
            this.roomCode_ = getDefaultInstance().getRoomCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static JoinRoomPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static JoinRoomPayload parseDelimitedFrom(InputStream inputStream) {
            return (JoinRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRoomPayload parseFrom(ByteBuffer byteBuffer) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCode(String str) {
            Objects.requireNonNull(str);
            this.roomCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.roomCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"roomCode_", "username_"});
            }
            if (iOrdinal == 3) {
                return new JoinRoomPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (JoinRoomPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
        public String getRoomCode() {
            return this.roomCode_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
        public ByteString getRoomCodeBytes() {
            return ByteString.copyFromUtf8(this.roomCode_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements JoinRoomPayloadOrBuilder {
            private Builder() {
                super(JoinRoomPayload.DEFAULT_INSTANCE);
            }

            public Builder clearRoomCode() {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).clearRoomCode();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
            public String getRoomCode() {
                return ((JoinRoomPayload) this.instance).getRoomCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
            public ByteString getRoomCodeBytes() {
                return ((JoinRoomPayload) this.instance).getRoomCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
            public String getUsername() {
                return ((JoinRoomPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.JoinRoomPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((JoinRoomPayload) this.instance).getUsernameBytes();
            }

            public Builder setRoomCode(String str) {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).setRoomCode(str);
                return this;
            }

            public Builder setRoomCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).setRoomCodeBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((JoinRoomPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(JoinRoomPayload joinRoomPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(joinRoomPayload);
        }

        public static JoinRoomPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRoomPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JoinRoomPayload parseFrom(ByteString byteString) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JoinRoomPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JoinRoomPayload parseFrom(byte[] bArr) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JoinRoomPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JoinRoomPayload parseFrom(InputStream inputStream) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JoinRoomPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JoinRoomPayload parseFrom(CodedInputStream codedInputStream) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JoinRoomPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JoinRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class KickUserPayload extends GeneratedMessageLite implements KickUserPayloadOrBuilder {
        private static final KickUserPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String reason_ = "";

        static {
            KickUserPayload kickUserPayload = new KickUserPayload();
            DEFAULT_INSTANCE = kickUserPayload;
            GeneratedMessageLite.registerDefaultInstance(KickUserPayload.class, kickUserPayload);
        }

        private KickUserPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static KickUserPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static KickUserPayload parseDelimitedFrom(InputStream inputStream) {
            return (KickUserPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KickUserPayload parseFrom(ByteBuffer byteBuffer) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "reason_"});
            }
            if (iOrdinal == 3) {
                return new KickUserPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (KickUserPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements KickUserPayloadOrBuilder {
            private Builder() {
                super(KickUserPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((KickUserPayload) this.instance).clearReason();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((KickUserPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
            public String getReason() {
                return ((KickUserPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((KickUserPayload) this.instance).getReasonBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
            public String getUserId() {
                return ((KickUserPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickUserPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((KickUserPayload) this.instance).getUserIdBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((KickUserPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((KickUserPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((KickUserPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((KickUserPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(KickUserPayload kickUserPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(kickUserPayload);
        }

        public static KickUserPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KickUserPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KickUserPayload parseFrom(ByteString byteString) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KickUserPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KickUserPayload parseFrom(byte[] bArr) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KickUserPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KickUserPayload parseFrom(InputStream inputStream) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KickUserPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KickUserPayload parseFrom(CodedInputStream codedInputStream) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KickUserPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickUserPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class KickedPayload extends GeneratedMessageLite implements KickedPayloadOrBuilder {
        private static final KickedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 1;
        private String reason_ = "";

        static {
            KickedPayload kickedPayload = new KickedPayload();
            DEFAULT_INSTANCE = kickedPayload;
            GeneratedMessageLite.registerDefaultInstance(KickedPayload.class, kickedPayload);
        }

        private KickedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        public static KickedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static KickedPayload parseDelimitedFrom(InputStream inputStream) {
            return (KickedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KickedPayload parseFrom(ByteBuffer byteBuffer) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"reason_"});
            }
            if (iOrdinal == 3) {
                return new KickedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (KickedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickedPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.KickedPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements KickedPayloadOrBuilder {
            private Builder() {
                super(KickedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((KickedPayload) this.instance).clearReason();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickedPayloadOrBuilder
            public String getReason() {
                return ((KickedPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.KickedPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((KickedPayload) this.instance).getReasonBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((KickedPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((KickedPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(KickedPayload kickedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(kickedPayload);
        }

        public static KickedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KickedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KickedPayload parseFrom(ByteString byteString) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KickedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KickedPayload parseFrom(byte[] bArr) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KickedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KickedPayload parseFrom(InputStream inputStream) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KickedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KickedPayload parseFrom(CodedInputStream codedInputStream) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KickedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KickedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class LeaveRoomPayload extends GeneratedMessageLite implements LeaveRoomPayloadOrBuilder {
        private static final LeaveRoomPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER;

        static {
            LeaveRoomPayload leaveRoomPayload = new LeaveRoomPayload();
            DEFAULT_INSTANCE = leaveRoomPayload;
            GeneratedMessageLite.registerDefaultInstance(LeaveRoomPayload.class, leaveRoomPayload);
        }

        private LeaveRoomPayload() {
        }

        public static LeaveRoomPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static LeaveRoomPayload parseDelimitedFrom(InputStream inputStream) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LeaveRoomPayload parseFrom(ByteBuffer byteBuffer) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            }
            if (iOrdinal == 3) {
                return new LeaveRoomPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (LeaveRoomPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements LeaveRoomPayloadOrBuilder {
            private Builder() {
                super(LeaveRoomPayload.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(LeaveRoomPayload leaveRoomPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(leaveRoomPayload);
        }

        public static LeaveRoomPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LeaveRoomPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LeaveRoomPayload parseFrom(ByteString byteString) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LeaveRoomPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LeaveRoomPayload parseFrom(byte[] bArr) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LeaveRoomPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LeaveRoomPayload parseFrom(InputStream inputStream) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LeaveRoomPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LeaveRoomPayload parseFrom(CodedInputStream codedInputStream) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LeaveRoomPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LeaveRoomPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class PingPayload extends GeneratedMessageLite implements PingPayloadOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 1;
        private static final PingPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SEQUENCE_FIELD_NUMBER = 2;
        private long clientTime_;
        private long sequence_;

        static {
            PingPayload pingPayload = new PingPayload();
            DEFAULT_INSTANCE = pingPayload;
            GeneratedMessageLite.registerDefaultInstance(PingPayload.class, pingPayload);
        }

        private PingPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientTime() {
            this.clientTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSequence() {
            this.sequence_ = 0L;
        }

        public static PingPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static PingPayload parseDelimitedFrom(InputStream inputStream) {
            return (PingPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingPayload parseFrom(ByteBuffer byteBuffer) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTime(long j) {
            this.clientTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSequence(long j) {
            this.sequence_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0003", new Object[]{"clientTime_", "sequence_"});
            }
            if (iOrdinal == 3) {
                return new PingPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (PingPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PingPayloadOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PingPayloadOrBuilder
        public long getSequence() {
            return this.sequence_;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements PingPayloadOrBuilder {
            private Builder() {
                super(PingPayload.DEFAULT_INSTANCE);
            }

            public Builder clearClientTime() {
                copyOnWrite();
                ((PingPayload) this.instance).clearClientTime();
                return this;
            }

            public Builder clearSequence() {
                copyOnWrite();
                ((PingPayload) this.instance).clearSequence();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PingPayloadOrBuilder
            public long getClientTime() {
                return ((PingPayload) this.instance).getClientTime();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PingPayloadOrBuilder
            public long getSequence() {
                return ((PingPayload) this.instance).getSequence();
            }

            public Builder setClientTime(long j) {
                copyOnWrite();
                ((PingPayload) this.instance).setClientTime(j);
                return this;
            }

            public Builder setSequence(long j) {
                copyOnWrite();
                ((PingPayload) this.instance).setSequence(j);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(PingPayload pingPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(pingPayload);
        }

        public static PingPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PingPayload parseFrom(ByteString byteString) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PingPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PingPayload parseFrom(byte[] bArr) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PingPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PingPayload parseFrom(InputStream inputStream) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingPayload parseFrom(CodedInputStream codedInputStream) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PingPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PingPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class PongPayload extends GeneratedMessageLite implements PongPayloadOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 1;
        private static final PongPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SEQUENCE_FIELD_NUMBER = 4;
        public static final int SERVER_RECEIVE_TIME_FIELD_NUMBER = 2;
        public static final int SERVER_SEND_TIME_FIELD_NUMBER = 3;
        private long clientTime_;
        private long sequence_;
        private long serverReceiveTime_;
        private long serverSendTime_;

        static {
            PongPayload pongPayload = new PongPayload();
            DEFAULT_INSTANCE = pongPayload;
            GeneratedMessageLite.registerDefaultInstance(PongPayload.class, pongPayload);
        }

        private PongPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientTime() {
            this.clientTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSequence() {
            this.sequence_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerReceiveTime() {
            this.serverReceiveTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerSendTime() {
            this.serverSendTime_ = 0L;
        }

        public static PongPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static PongPayload parseDelimitedFrom(InputStream inputStream) {
            return (PongPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PongPayload parseFrom(ByteBuffer byteBuffer) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTime(long j) {
            this.clientTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSequence(long j) {
            this.sequence_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerReceiveTime(long j) {
            this.serverReceiveTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerSendTime(long j) {
            this.serverSendTime_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0003", new Object[]{"clientTime_", "serverReceiveTime_", "serverSendTime_", "sequence_"});
            }
            if (iOrdinal == 3) {
                return new PongPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (PongPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
        public long getSequence() {
            return this.sequence_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
        public long getServerReceiveTime() {
            return this.serverReceiveTime_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
        public long getServerSendTime() {
            return this.serverSendTime_;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements PongPayloadOrBuilder {
            private Builder() {
                super(PongPayload.DEFAULT_INSTANCE);
            }

            public Builder clearClientTime() {
                copyOnWrite();
                ((PongPayload) this.instance).clearClientTime();
                return this;
            }

            public Builder clearSequence() {
                copyOnWrite();
                ((PongPayload) this.instance).clearSequence();
                return this;
            }

            public Builder clearServerReceiveTime() {
                copyOnWrite();
                ((PongPayload) this.instance).clearServerReceiveTime();
                return this;
            }

            public Builder clearServerSendTime() {
                copyOnWrite();
                ((PongPayload) this.instance).clearServerSendTime();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
            public long getClientTime() {
                return ((PongPayload) this.instance).getClientTime();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
            public long getSequence() {
                return ((PongPayload) this.instance).getSequence();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
            public long getServerReceiveTime() {
                return ((PongPayload) this.instance).getServerReceiveTime();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.PongPayloadOrBuilder
            public long getServerSendTime() {
                return ((PongPayload) this.instance).getServerSendTime();
            }

            public Builder setClientTime(long j) {
                copyOnWrite();
                ((PongPayload) this.instance).setClientTime(j);
                return this;
            }

            public Builder setSequence(long j) {
                copyOnWrite();
                ((PongPayload) this.instance).setSequence(j);
                return this;
            }

            public Builder setServerReceiveTime(long j) {
                copyOnWrite();
                ((PongPayload) this.instance).setServerReceiveTime(j);
                return this;
            }

            public Builder setServerSendTime(long j) {
                copyOnWrite();
                ((PongPayload) this.instance).setServerSendTime(j);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(PongPayload pongPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(pongPayload);
        }

        public static PongPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PongPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PongPayload parseFrom(ByteString byteString) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PongPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PongPayload parseFrom(byte[] bArr) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PongPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PongPayload parseFrom(InputStream inputStream) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PongPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PongPayload parseFrom(CodedInputStream codedInputStream) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PongPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (PongPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ReconnectPayload extends GeneratedMessageLite implements ReconnectPayloadOrBuilder {
        private static final ReconnectPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SESSION_TOKEN_FIELD_NUMBER = 1;
        private String sessionToken_ = "";

        static {
            ReconnectPayload reconnectPayload = new ReconnectPayload();
            DEFAULT_INSTANCE = reconnectPayload;
            GeneratedMessageLite.registerDefaultInstance(ReconnectPayload.class, reconnectPayload);
        }

        private ReconnectPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionToken() {
            this.sessionToken_ = getDefaultInstance().getSessionToken();
        }

        public static ReconnectPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ReconnectPayload parseDelimitedFrom(InputStream inputStream) {
            return (ReconnectPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReconnectPayload parseFrom(ByteBuffer byteBuffer) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionToken(String str) {
            Objects.requireNonNull(str);
            this.sessionToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sessionToken_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"sessionToken_"});
            }
            if (iOrdinal == 3) {
                return new ReconnectPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ReconnectPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectPayloadOrBuilder
        public String getSessionToken() {
            return this.sessionToken_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectPayloadOrBuilder
        public ByteString getSessionTokenBytes() {
            return ByteString.copyFromUtf8(this.sessionToken_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ReconnectPayloadOrBuilder {
            private Builder() {
                super(ReconnectPayload.DEFAULT_INSTANCE);
            }

            public Builder clearSessionToken() {
                copyOnWrite();
                ((ReconnectPayload) this.instance).clearSessionToken();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectPayloadOrBuilder
            public String getSessionToken() {
                return ((ReconnectPayload) this.instance).getSessionToken();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectPayloadOrBuilder
            public ByteString getSessionTokenBytes() {
                return ((ReconnectPayload) this.instance).getSessionTokenBytes();
            }

            public Builder setSessionToken(String str) {
                copyOnWrite();
                ((ReconnectPayload) this.instance).setSessionToken(str);
                return this;
            }

            public Builder setSessionTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ReconnectPayload) this.instance).setSessionTokenBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ReconnectPayload reconnectPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(reconnectPayload);
        }

        public static ReconnectPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReconnectPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReconnectPayload parseFrom(ByteString byteString) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReconnectPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReconnectPayload parseFrom(byte[] bArr) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReconnectPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReconnectPayload parseFrom(InputStream inputStream) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReconnectPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReconnectPayload parseFrom(CodedInputStream codedInputStream) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReconnectPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ReconnectedPayload extends GeneratedMessageLite implements ReconnectedPayloadOrBuilder {
        private static final ReconnectedPayload DEFAULT_INSTANCE;
        public static final int IS_HOST_FIELD_NUMBER = 4;
        private static volatile Parser PARSER = null;
        public static final int ROOM_CODE_FIELD_NUMBER = 1;
        public static final int STATE_FIELD_NUMBER = 3;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean isHost_;
        private RoomState state_;
        private String roomCode_ = "";
        private String userId_ = "";

        static {
            ReconnectedPayload reconnectedPayload = new ReconnectedPayload();
            DEFAULT_INSTANCE = reconnectedPayload;
            GeneratedMessageLite.registerDefaultInstance(ReconnectedPayload.class, reconnectedPayload);
        }

        private ReconnectedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsHost() {
            this.isHost_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomCode() {
            this.roomCode_ = getDefaultInstance().getRoomCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.state_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static ReconnectedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeState(RoomState roomState) {
            Objects.requireNonNull(roomState);
            RoomState roomState2 = this.state_;
            if (roomState2 == null || roomState2 == RoomState.getDefaultInstance()) {
                this.state_ = roomState;
            } else {
                this.state_ = (RoomState) ((RoomState.Builder) RoomState.newBuilder(this.state_).mergeFrom((GeneratedMessageLite) roomState)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ReconnectedPayload parseDelimitedFrom(InputStream inputStream) {
            return (ReconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReconnectedPayload parseFrom(ByteBuffer byteBuffer) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsHost(boolean z) {
            this.isHost_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCode(String str) {
            Objects.requireNonNull(str);
            this.roomCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.roomCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(RoomState roomState) {
            Objects.requireNonNull(roomState);
            this.state_ = roomState;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004\u0007", new Object[]{"bitField0_", "roomCode_", "userId_", "state_", "isHost_"});
            }
            if (iOrdinal == 3) {
                return new ReconnectedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ReconnectedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public boolean getIsHost() {
            return this.isHost_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public String getRoomCode() {
            return this.roomCode_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public ByteString getRoomCodeBytes() {
            return ByteString.copyFromUtf8(this.roomCode_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public RoomState getState() {
            RoomState roomState = this.state_;
            return roomState == null ? RoomState.getDefaultInstance() : roomState;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
        public boolean hasState() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ReconnectedPayloadOrBuilder {
            private Builder() {
                super(ReconnectedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearIsHost() {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).clearIsHost();
                return this;
            }

            public Builder clearRoomCode() {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).clearRoomCode();
                return this;
            }

            public Builder clearState() {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).clearState();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public boolean getIsHost() {
                return ((ReconnectedPayload) this.instance).getIsHost();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public String getRoomCode() {
                return ((ReconnectedPayload) this.instance).getRoomCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public ByteString getRoomCodeBytes() {
                return ((ReconnectedPayload) this.instance).getRoomCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public RoomState getState() {
                return ((ReconnectedPayload) this.instance).getState();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public String getUserId() {
                return ((ReconnectedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((ReconnectedPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ReconnectedPayloadOrBuilder
            public boolean hasState() {
                return ((ReconnectedPayload) this.instance).hasState();
            }

            public Builder mergeState(RoomState roomState) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).mergeState(roomState);
                return this;
            }

            public Builder setIsHost(boolean z) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setIsHost(z);
                return this;
            }

            public Builder setRoomCode(String str) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setRoomCode(str);
                return this;
            }

            public Builder setRoomCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setRoomCodeBytes(byteString);
                return this;
            }

            public Builder setState(RoomState.Builder builder) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setState((RoomState) builder.m915build());
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setState(RoomState roomState) {
                copyOnWrite();
                ((ReconnectedPayload) this.instance).setState(roomState);
                return this;
            }
        }

        public static Builder newBuilder(ReconnectedPayload reconnectedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(reconnectedPayload);
        }

        public static ReconnectedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReconnectedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReconnectedPayload parseFrom(ByteString byteString) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReconnectedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReconnectedPayload parseFrom(byte[] bArr) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReconnectedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReconnectedPayload parseFrom(InputStream inputStream) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReconnectedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReconnectedPayload parseFrom(CodedInputStream codedInputStream) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReconnectedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class RejectJoinPayload extends GeneratedMessageLite implements RejectJoinPayloadOrBuilder {
        private static final RejectJoinPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String reason_ = "";

        static {
            RejectJoinPayload rejectJoinPayload = new RejectJoinPayload();
            DEFAULT_INSTANCE = rejectJoinPayload;
            GeneratedMessageLite.registerDefaultInstance(RejectJoinPayload.class, rejectJoinPayload);
        }

        private RejectJoinPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static RejectJoinPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static RejectJoinPayload parseDelimitedFrom(InputStream inputStream) {
            return (RejectJoinPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RejectJoinPayload parseFrom(ByteBuffer byteBuffer) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "reason_"});
            }
            if (iOrdinal == 3) {
                return new RejectJoinPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (RejectJoinPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements RejectJoinPayloadOrBuilder {
            private Builder() {
                super(RejectJoinPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).clearReason();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
            public String getReason() {
                return ((RejectJoinPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((RejectJoinPayload) this.instance).getReasonBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
            public String getUserId() {
                return ((RejectJoinPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectJoinPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((RejectJoinPayload) this.instance).getUserIdBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RejectJoinPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(RejectJoinPayload rejectJoinPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(rejectJoinPayload);
        }

        public static RejectJoinPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RejectJoinPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RejectJoinPayload parseFrom(ByteString byteString) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RejectJoinPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RejectJoinPayload parseFrom(byte[] bArr) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RejectJoinPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RejectJoinPayload parseFrom(InputStream inputStream) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RejectJoinPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RejectJoinPayload parseFrom(CodedInputStream codedInputStream) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RejectJoinPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectJoinPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class RejectSuggestionPayload extends GeneratedMessageLite implements RejectSuggestionPayloadOrBuilder {
        private static final RejectSuggestionPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int SUGGESTION_ID_FIELD_NUMBER = 1;
        private String suggestionId_ = "";
        private String reason_ = "";

        static {
            RejectSuggestionPayload rejectSuggestionPayload = new RejectSuggestionPayload();
            DEFAULT_INSTANCE = rejectSuggestionPayload;
            GeneratedMessageLite.registerDefaultInstance(RejectSuggestionPayload.class, rejectSuggestionPayload);
        }

        private RejectSuggestionPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestionId() {
            this.suggestionId_ = getDefaultInstance().getSuggestionId();
        }

        public static RejectSuggestionPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static RejectSuggestionPayload parseDelimitedFrom(InputStream inputStream) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RejectSuggestionPayload parseFrom(ByteBuffer byteBuffer) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionId(String str) {
            Objects.requireNonNull(str);
            this.suggestionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestionId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"suggestionId_", "reason_"});
            }
            if (iOrdinal == 3) {
                return new RejectSuggestionPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (RejectSuggestionPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
        public String getSuggestionId() {
            return this.suggestionId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
        public ByteString getSuggestionIdBytes() {
            return ByteString.copyFromUtf8(this.suggestionId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements RejectSuggestionPayloadOrBuilder {
            private Builder() {
                super(RejectSuggestionPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).clearReason();
                return this;
            }

            public Builder clearSuggestionId() {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).clearSuggestionId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
            public String getReason() {
                return ((RejectSuggestionPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((RejectSuggestionPayload) this.instance).getReasonBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
            public String getSuggestionId() {
                return ((RejectSuggestionPayload) this.instance).getSuggestionId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RejectSuggestionPayloadOrBuilder
            public ByteString getSuggestionIdBytes() {
                return ((RejectSuggestionPayload) this.instance).getSuggestionIdBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public Builder setSuggestionId(String str) {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).setSuggestionId(str);
                return this;
            }

            public Builder setSuggestionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RejectSuggestionPayload) this.instance).setSuggestionIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(RejectSuggestionPayload rejectSuggestionPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(rejectSuggestionPayload);
        }

        public static RejectSuggestionPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RejectSuggestionPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RejectSuggestionPayload parseFrom(ByteString byteString) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RejectSuggestionPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RejectSuggestionPayload parseFrom(byte[] bArr) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RejectSuggestionPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RejectSuggestionPayload parseFrom(InputStream inputStream) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RejectSuggestionPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RejectSuggestionPayload parseFrom(CodedInputStream codedInputStream) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RejectSuggestionPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RejectSuggestionPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class RoomCreatedPayload extends GeneratedMessageLite implements RoomCreatedPayloadOrBuilder {
        private static final RoomCreatedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int ROOM_CODE_FIELD_NUMBER = 1;
        public static final int SESSION_TOKEN_FIELD_NUMBER = 3;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private String roomCode_ = "";
        private String userId_ = "";
        private String sessionToken_ = "";

        static {
            RoomCreatedPayload roomCreatedPayload = new RoomCreatedPayload();
            DEFAULT_INSTANCE = roomCreatedPayload;
            GeneratedMessageLite.registerDefaultInstance(RoomCreatedPayload.class, roomCreatedPayload);
        }

        private RoomCreatedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomCode() {
            this.roomCode_ = getDefaultInstance().getRoomCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionToken() {
            this.sessionToken_ = getDefaultInstance().getSessionToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        public static RoomCreatedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static RoomCreatedPayload parseDelimitedFrom(InputStream inputStream) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RoomCreatedPayload parseFrom(ByteBuffer byteBuffer) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCode(String str) {
            Objects.requireNonNull(str);
            this.roomCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.roomCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionToken(String str) {
            Objects.requireNonNull(str);
            this.sessionToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sessionToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"roomCode_", "userId_", "sessionToken_"});
            }
            if (iOrdinal == 3) {
                return new RoomCreatedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (RoomCreatedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public String getRoomCode() {
            return this.roomCode_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public ByteString getRoomCodeBytes() {
            return ByteString.copyFromUtf8(this.roomCode_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public String getSessionToken() {
            return this.sessionToken_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public ByteString getSessionTokenBytes() {
            return ByteString.copyFromUtf8(this.sessionToken_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements RoomCreatedPayloadOrBuilder {
            private Builder() {
                super(RoomCreatedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearRoomCode() {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).clearRoomCode();
                return this;
            }

            public Builder clearSessionToken() {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).clearSessionToken();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).clearUserId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public String getRoomCode() {
                return ((RoomCreatedPayload) this.instance).getRoomCode();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public ByteString getRoomCodeBytes() {
                return ((RoomCreatedPayload) this.instance).getRoomCodeBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public String getSessionToken() {
                return ((RoomCreatedPayload) this.instance).getSessionToken();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public ByteString getSessionTokenBytes() {
                return ((RoomCreatedPayload) this.instance).getSessionTokenBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public String getUserId() {
                return ((RoomCreatedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.RoomCreatedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((RoomCreatedPayload) this.instance).getUserIdBytes();
            }

            public Builder setRoomCode(String str) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setRoomCode(str);
                return this;
            }

            public Builder setRoomCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setRoomCodeBytes(byteString);
                return this;
            }

            public Builder setSessionToken(String str) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setSessionToken(str);
                return this;
            }

            public Builder setSessionTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setSessionTokenBytes(byteString);
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((RoomCreatedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(RoomCreatedPayload roomCreatedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(roomCreatedPayload);
        }

        public static RoomCreatedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RoomCreatedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RoomCreatedPayload parseFrom(ByteString byteString) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RoomCreatedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RoomCreatedPayload parseFrom(byte[] bArr) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RoomCreatedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RoomCreatedPayload parseFrom(InputStream inputStream) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RoomCreatedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RoomCreatedPayload parseFrom(CodedInputStream codedInputStream) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RoomCreatedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RoomCreatedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class ServerCapabilities extends GeneratedMessageLite implements ServerCapabilitiesOrBuilder {
        private static final ServerCapabilities DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SERVER_VERSION_FIELD_NUMBER = 3;
        public static final int SUPPORTS_COMPRESSION_FIELD_NUMBER = 2;
        public static final int SUPPORTS_PROTOBUF_FIELD_NUMBER = 1;
        private String serverVersion_ = "";
        private boolean supportsCompression_;
        private boolean supportsProtobuf_;

        static {
            ServerCapabilities serverCapabilities = new ServerCapabilities();
            DEFAULT_INSTANCE = serverCapabilities;
            GeneratedMessageLite.registerDefaultInstance(ServerCapabilities.class, serverCapabilities);
        }

        private ServerCapabilities() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerVersion() {
            this.serverVersion_ = getDefaultInstance().getServerVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSupportsCompression() {
            this.supportsCompression_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSupportsProtobuf() {
            this.supportsProtobuf_ = false;
        }

        public static ServerCapabilities getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ServerCapabilities parseDelimitedFrom(InputStream inputStream) {
            return (ServerCapabilities) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServerCapabilities parseFrom(ByteBuffer byteBuffer) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerVersion(String str) {
            Objects.requireNonNull(str);
            this.serverVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.serverVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportsCompression(boolean z) {
            this.supportsCompression_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportsProtobuf(boolean z) {
            this.supportsProtobuf_ = z;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003Ȉ", new Object[]{"supportsProtobuf_", "supportsCompression_", "serverVersion_"});
            }
            if (iOrdinal == 3) {
                return new ServerCapabilities();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (ServerCapabilities.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
        public String getServerVersion() {
            return this.serverVersion_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
        public ByteString getServerVersionBytes() {
            return ByteString.copyFromUtf8(this.serverVersion_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
        public boolean getSupportsCompression() {
            return this.supportsCompression_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
        public boolean getSupportsProtobuf() {
            return this.supportsProtobuf_;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements ServerCapabilitiesOrBuilder {
            private Builder() {
                super(ServerCapabilities.DEFAULT_INSTANCE);
            }

            public Builder clearServerVersion() {
                copyOnWrite();
                ((ServerCapabilities) this.instance).clearServerVersion();
                return this;
            }

            public Builder clearSupportsCompression() {
                copyOnWrite();
                ((ServerCapabilities) this.instance).clearSupportsCompression();
                return this;
            }

            public Builder clearSupportsProtobuf() {
                copyOnWrite();
                ((ServerCapabilities) this.instance).clearSupportsProtobuf();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
            public String getServerVersion() {
                return ((ServerCapabilities) this.instance).getServerVersion();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
            public ByteString getServerVersionBytes() {
                return ((ServerCapabilities) this.instance).getServerVersionBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
            public boolean getSupportsCompression() {
                return ((ServerCapabilities) this.instance).getSupportsCompression();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.ServerCapabilitiesOrBuilder
            public boolean getSupportsProtobuf() {
                return ((ServerCapabilities) this.instance).getSupportsProtobuf();
            }

            public Builder setServerVersion(String str) {
                copyOnWrite();
                ((ServerCapabilities) this.instance).setServerVersion(str);
                return this;
            }

            public Builder setServerVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ServerCapabilities) this.instance).setServerVersionBytes(byteString);
                return this;
            }

            public Builder setSupportsCompression(boolean z) {
                copyOnWrite();
                ((ServerCapabilities) this.instance).setSupportsCompression(z);
                return this;
            }

            public Builder setSupportsProtobuf(boolean z) {
                copyOnWrite();
                ((ServerCapabilities) this.instance).setSupportsProtobuf(z);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ServerCapabilities serverCapabilities) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(serverCapabilities);
        }

        public static ServerCapabilities parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServerCapabilities parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ServerCapabilities parseFrom(ByteString byteString) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ServerCapabilities parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServerCapabilities parseFrom(byte[] bArr) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServerCapabilities parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ServerCapabilities parseFrom(InputStream inputStream) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServerCapabilities parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServerCapabilities parseFrom(CodedInputStream codedInputStream) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServerCapabilities parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServerCapabilities) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class SuggestTrackPayload extends GeneratedMessageLite implements SuggestTrackPayloadOrBuilder {
        private static final SuggestTrackPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int TRACK_INFO_FIELD_NUMBER = 1;
        private int bitField0_;
        private TrackInfo trackInfo_;

        static {
            SuggestTrackPayload suggestTrackPayload = new SuggestTrackPayload();
            DEFAULT_INSTANCE = suggestTrackPayload;
            GeneratedMessageLite.registerDefaultInstance(SuggestTrackPayload.class, suggestTrackPayload);
        }

        private SuggestTrackPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackInfo() {
            this.trackInfo_ = null;
            this.bitField0_ &= -2;
        }

        public static SuggestTrackPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.trackInfo_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.trackInfo_ = trackInfo;
            } else {
                this.trackInfo_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.trackInfo_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static SuggestTrackPayload parseDelimitedFrom(InputStream inputStream) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestTrackPayload parseFrom(ByteBuffer byteBuffer) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.trackInfo_ = trackInfo;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "trackInfo_"});
            }
            if (iOrdinal == 3) {
                return new SuggestTrackPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (SuggestTrackPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestTrackPayloadOrBuilder
        public TrackInfo getTrackInfo() {
            TrackInfo trackInfo = this.trackInfo_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestTrackPayloadOrBuilder
        public boolean hasTrackInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements SuggestTrackPayloadOrBuilder {
            private Builder() {
                super(SuggestTrackPayload.DEFAULT_INSTANCE);
            }

            public Builder clearTrackInfo() {
                copyOnWrite();
                ((SuggestTrackPayload) this.instance).clearTrackInfo();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestTrackPayloadOrBuilder
            public TrackInfo getTrackInfo() {
                return ((SuggestTrackPayload) this.instance).getTrackInfo();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestTrackPayloadOrBuilder
            public boolean hasTrackInfo() {
                return ((SuggestTrackPayload) this.instance).hasTrackInfo();
            }

            public Builder mergeTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestTrackPayload) this.instance).mergeTrackInfo(trackInfo);
                return this;
            }

            public Builder setTrackInfo(TrackInfo.Builder builder) {
                copyOnWrite();
                ((SuggestTrackPayload) this.instance).setTrackInfo((TrackInfo) builder.m915build());
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestTrackPayload) this.instance).setTrackInfo(trackInfo);
                return this;
            }
        }

        public static Builder newBuilder(SuggestTrackPayload suggestTrackPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(suggestTrackPayload);
        }

        public static SuggestTrackPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestTrackPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SuggestTrackPayload parseFrom(ByteString byteString) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SuggestTrackPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SuggestTrackPayload parseFrom(byte[] bArr) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SuggestTrackPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SuggestTrackPayload parseFrom(InputStream inputStream) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestTrackPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestTrackPayload parseFrom(CodedInputStream codedInputStream) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SuggestTrackPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestTrackPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class SuggestionApprovedPayload extends GeneratedMessageLite implements SuggestionApprovedPayloadOrBuilder {
        private static final SuggestionApprovedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int SUGGESTION_ID_FIELD_NUMBER = 1;
        public static final int TRACK_INFO_FIELD_NUMBER = 2;
        private int bitField0_;
        private String suggestionId_ = "";
        private TrackInfo trackInfo_;

        static {
            SuggestionApprovedPayload suggestionApprovedPayload = new SuggestionApprovedPayload();
            DEFAULT_INSTANCE = suggestionApprovedPayload;
            GeneratedMessageLite.registerDefaultInstance(SuggestionApprovedPayload.class, suggestionApprovedPayload);
        }

        private SuggestionApprovedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestionId() {
            this.suggestionId_ = getDefaultInstance().getSuggestionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackInfo() {
            this.trackInfo_ = null;
            this.bitField0_ &= -2;
        }

        public static SuggestionApprovedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.trackInfo_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.trackInfo_ = trackInfo;
            } else {
                this.trackInfo_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.trackInfo_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static SuggestionApprovedPayload parseDelimitedFrom(InputStream inputStream) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionApprovedPayload parseFrom(ByteBuffer byteBuffer) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionId(String str) {
            Objects.requireNonNull(str);
            this.suggestionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestionId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.trackInfo_ = trackInfo;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "suggestionId_", "trackInfo_"});
            }
            if (iOrdinal == 3) {
                return new SuggestionApprovedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (SuggestionApprovedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
        public String getSuggestionId() {
            return this.suggestionId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
        public ByteString getSuggestionIdBytes() {
            return ByteString.copyFromUtf8(this.suggestionId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
        public TrackInfo getTrackInfo() {
            TrackInfo trackInfo = this.trackInfo_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
        public boolean hasTrackInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements SuggestionApprovedPayloadOrBuilder {
            private Builder() {
                super(SuggestionApprovedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearSuggestionId() {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).clearSuggestionId();
                return this;
            }

            public Builder clearTrackInfo() {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).clearTrackInfo();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
            public String getSuggestionId() {
                return ((SuggestionApprovedPayload) this.instance).getSuggestionId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
            public ByteString getSuggestionIdBytes() {
                return ((SuggestionApprovedPayload) this.instance).getSuggestionIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
            public TrackInfo getTrackInfo() {
                return ((SuggestionApprovedPayload) this.instance).getTrackInfo();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionApprovedPayloadOrBuilder
            public boolean hasTrackInfo() {
                return ((SuggestionApprovedPayload) this.instance).hasTrackInfo();
            }

            public Builder mergeTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).mergeTrackInfo(trackInfo);
                return this;
            }

            public Builder setSuggestionId(String str) {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).setSuggestionId(str);
                return this;
            }

            public Builder setSuggestionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).setSuggestionIdBytes(byteString);
                return this;
            }

            public Builder setTrackInfo(TrackInfo.Builder builder) {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).setTrackInfo((TrackInfo) builder.m915build());
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestionApprovedPayload) this.instance).setTrackInfo(trackInfo);
                return this;
            }
        }

        public static Builder newBuilder(SuggestionApprovedPayload suggestionApprovedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(suggestionApprovedPayload);
        }

        public static SuggestionApprovedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionApprovedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SuggestionApprovedPayload parseFrom(ByteString byteString) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SuggestionApprovedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SuggestionApprovedPayload parseFrom(byte[] bArr) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SuggestionApprovedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SuggestionApprovedPayload parseFrom(InputStream inputStream) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionApprovedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionApprovedPayload parseFrom(CodedInputStream codedInputStream) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SuggestionApprovedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionApprovedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class SuggestionReceivedPayload extends GeneratedMessageLite implements SuggestionReceivedPayloadOrBuilder {
        private static final SuggestionReceivedPayload DEFAULT_INSTANCE;
        public static final int FROM_USERNAME_FIELD_NUMBER = 3;
        public static final int FROM_USER_ID_FIELD_NUMBER = 2;
        private static volatile Parser PARSER = null;
        public static final int SUGGESTION_ID_FIELD_NUMBER = 1;
        public static final int TRACK_INFO_FIELD_NUMBER = 4;
        private int bitField0_;
        private TrackInfo trackInfo_;
        private String suggestionId_ = "";
        private String fromUserId_ = "";
        private String fromUsername_ = "";

        static {
            SuggestionReceivedPayload suggestionReceivedPayload = new SuggestionReceivedPayload();
            DEFAULT_INSTANCE = suggestionReceivedPayload;
            GeneratedMessageLite.registerDefaultInstance(SuggestionReceivedPayload.class, suggestionReceivedPayload);
        }

        private SuggestionReceivedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFromUserId() {
            this.fromUserId_ = getDefaultInstance().getFromUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFromUsername() {
            this.fromUsername_ = getDefaultInstance().getFromUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestionId() {
            this.suggestionId_ = getDefaultInstance().getSuggestionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackInfo() {
            this.trackInfo_ = null;
            this.bitField0_ &= -2;
        }

        public static SuggestionReceivedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            TrackInfo trackInfo2 = this.trackInfo_;
            if (trackInfo2 == null || trackInfo2 == TrackInfo.getDefaultInstance()) {
                this.trackInfo_ = trackInfo;
            } else {
                this.trackInfo_ = (TrackInfo) ((TrackInfo.Builder) TrackInfo.newBuilder(this.trackInfo_).mergeFrom((GeneratedMessageLite) trackInfo)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static SuggestionReceivedPayload parseDelimitedFrom(InputStream inputStream) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionReceivedPayload parseFrom(ByteBuffer byteBuffer) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromUserId(String str) {
            Objects.requireNonNull(str);
            this.fromUserId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.fromUserId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromUsername(String str) {
            Objects.requireNonNull(str);
            this.fromUsername_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.fromUsername_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionId(String str) {
            Objects.requireNonNull(str);
            this.suggestionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestionId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackInfo(TrackInfo trackInfo) {
            Objects.requireNonNull(trackInfo);
            this.trackInfo_ = trackInfo;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "suggestionId_", "fromUserId_", "fromUsername_", "trackInfo_"});
            }
            if (iOrdinal == 3) {
                return new SuggestionReceivedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (SuggestionReceivedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public String getFromUserId() {
            return this.fromUserId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public ByteString getFromUserIdBytes() {
            return ByteString.copyFromUtf8(this.fromUserId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public String getFromUsername() {
            return this.fromUsername_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public ByteString getFromUsernameBytes() {
            return ByteString.copyFromUtf8(this.fromUsername_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public String getSuggestionId() {
            return this.suggestionId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public ByteString getSuggestionIdBytes() {
            return ByteString.copyFromUtf8(this.suggestionId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public TrackInfo getTrackInfo() {
            TrackInfo trackInfo = this.trackInfo_;
            return trackInfo == null ? TrackInfo.getDefaultInstance() : trackInfo;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
        public boolean hasTrackInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements SuggestionReceivedPayloadOrBuilder {
            private Builder() {
                super(SuggestionReceivedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearFromUserId() {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).clearFromUserId();
                return this;
            }

            public Builder clearFromUsername() {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).clearFromUsername();
                return this;
            }

            public Builder clearSuggestionId() {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).clearSuggestionId();
                return this;
            }

            public Builder clearTrackInfo() {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).clearTrackInfo();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public String getFromUserId() {
                return ((SuggestionReceivedPayload) this.instance).getFromUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public ByteString getFromUserIdBytes() {
                return ((SuggestionReceivedPayload) this.instance).getFromUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public String getFromUsername() {
                return ((SuggestionReceivedPayload) this.instance).getFromUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public ByteString getFromUsernameBytes() {
                return ((SuggestionReceivedPayload) this.instance).getFromUsernameBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public String getSuggestionId() {
                return ((SuggestionReceivedPayload) this.instance).getSuggestionId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public ByteString getSuggestionIdBytes() {
                return ((SuggestionReceivedPayload) this.instance).getSuggestionIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public TrackInfo getTrackInfo() {
                return ((SuggestionReceivedPayload) this.instance).getTrackInfo();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionReceivedPayloadOrBuilder
            public boolean hasTrackInfo() {
                return ((SuggestionReceivedPayload) this.instance).hasTrackInfo();
            }

            public Builder mergeTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).mergeTrackInfo(trackInfo);
                return this;
            }

            public Builder setFromUserId(String str) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setFromUserId(str);
                return this;
            }

            public Builder setFromUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setFromUserIdBytes(byteString);
                return this;
            }

            public Builder setFromUsername(String str) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setFromUsername(str);
                return this;
            }

            public Builder setFromUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setFromUsernameBytes(byteString);
                return this;
            }

            public Builder setSuggestionId(String str) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setSuggestionId(str);
                return this;
            }

            public Builder setSuggestionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setSuggestionIdBytes(byteString);
                return this;
            }

            public Builder setTrackInfo(TrackInfo.Builder builder) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setTrackInfo((TrackInfo) builder.m915build());
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setTrackInfo(TrackInfo trackInfo) {
                copyOnWrite();
                ((SuggestionReceivedPayload) this.instance).setTrackInfo(trackInfo);
                return this;
            }
        }

        public static Builder newBuilder(SuggestionReceivedPayload suggestionReceivedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(suggestionReceivedPayload);
        }

        public static SuggestionReceivedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionReceivedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SuggestionReceivedPayload parseFrom(ByteString byteString) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SuggestionReceivedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SuggestionReceivedPayload parseFrom(byte[] bArr) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SuggestionReceivedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SuggestionReceivedPayload parseFrom(InputStream inputStream) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionReceivedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionReceivedPayload parseFrom(CodedInputStream codedInputStream) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SuggestionReceivedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionReceivedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class SuggestionRejectedPayload extends GeneratedMessageLite implements SuggestionRejectedPayloadOrBuilder {
        private static final SuggestionRejectedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int SUGGESTION_ID_FIELD_NUMBER = 1;
        private String suggestionId_ = "";
        private String reason_ = "";

        static {
            SuggestionRejectedPayload suggestionRejectedPayload = new SuggestionRejectedPayload();
            DEFAULT_INSTANCE = suggestionRejectedPayload;
            GeneratedMessageLite.registerDefaultInstance(SuggestionRejectedPayload.class, suggestionRejectedPayload);
        }

        private SuggestionRejectedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestionId() {
            this.suggestionId_ = getDefaultInstance().getSuggestionId();
        }

        public static SuggestionRejectedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static SuggestionRejectedPayload parseDelimitedFrom(InputStream inputStream) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionRejectedPayload parseFrom(ByteBuffer byteBuffer) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            Objects.requireNonNull(str);
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionId(String str) {
            Objects.requireNonNull(str);
            this.suggestionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestionIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestionId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"suggestionId_", "reason_"});
            }
            if (iOrdinal == 3) {
                return new SuggestionRejectedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (SuggestionRejectedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
        public String getSuggestionId() {
            return this.suggestionId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
        public ByteString getSuggestionIdBytes() {
            return ByteString.copyFromUtf8(this.suggestionId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements SuggestionRejectedPayloadOrBuilder {
            private Builder() {
                super(SuggestionRejectedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearReason() {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).clearReason();
                return this;
            }

            public Builder clearSuggestionId() {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).clearSuggestionId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
            public String getReason() {
                return ((SuggestionRejectedPayload) this.instance).getReason();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
            public ByteString getReasonBytes() {
                return ((SuggestionRejectedPayload) this.instance).getReasonBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
            public String getSuggestionId() {
                return ((SuggestionRejectedPayload) this.instance).getSuggestionId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.SuggestionRejectedPayloadOrBuilder
            public ByteString getSuggestionIdBytes() {
                return ((SuggestionRejectedPayload) this.instance).getSuggestionIdBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).setReason(str);
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).setReasonBytes(byteString);
                return this;
            }

            public Builder setSuggestionId(String str) {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).setSuggestionId(str);
                return this;
            }

            public Builder setSuggestionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SuggestionRejectedPayload) this.instance).setSuggestionIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(SuggestionRejectedPayload suggestionRejectedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(suggestionRejectedPayload);
        }

        public static SuggestionRejectedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionRejectedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SuggestionRejectedPayload parseFrom(ByteString byteString) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SuggestionRejectedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SuggestionRejectedPayload parseFrom(byte[] bArr) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SuggestionRejectedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SuggestionRejectedPayload parseFrom(InputStream inputStream) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SuggestionRejectedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SuggestionRejectedPayload parseFrom(CodedInputStream codedInputStream) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SuggestionRejectedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SuggestionRejectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class TrackInfo extends GeneratedMessageLite implements TrackInfoOrBuilder {
        public static final int ALBUM_FIELD_NUMBER = 4;
        public static final int ARTIST_FIELD_NUMBER = 3;
        private static final TrackInfo DEFAULT_INSTANCE;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser PARSER = null;
        public static final int SUGGESTED_BY_FIELD_NUMBER = 7;
        public static final int THUMBNAIL_FIELD_NUMBER = 6;
        public static final int TITLE_FIELD_NUMBER = 2;
        private long duration_;
        private String id_ = "";
        private String title_ = "";
        private String artist_ = "";
        private String album_ = "";
        private String thumbnail_ = "";
        private String suggestedBy_ = "";

        static {
            TrackInfo trackInfo = new TrackInfo();
            DEFAULT_INSTANCE = trackInfo;
            GeneratedMessageLite.registerDefaultInstance(TrackInfo.class, trackInfo);
        }

        private TrackInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAlbum() {
            this.album_ = getDefaultInstance().getAlbum();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearArtist() {
            this.artist_ = getDefaultInstance().getArtist();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDuration() {
            this.duration_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuggestedBy() {
            this.suggestedBy_ = getDefaultInstance().getSuggestedBy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThumbnail() {
            this.thumbnail_ = getDefaultInstance().getThumbnail();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = getDefaultInstance().getTitle();
        }

        public static TrackInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static TrackInfo parseDelimitedFrom(InputStream inputStream) {
            return (TrackInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TrackInfo parseFrom(ByteBuffer byteBuffer) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlbum(String str) {
            Objects.requireNonNull(str);
            this.album_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlbumBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.album_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setArtist(String str) {
            Objects.requireNonNull(str);
            this.artist_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setArtistBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.artist_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDuration(long j) {
            this.duration_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            Objects.requireNonNull(str);
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.id_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestedBy(String str) {
            Objects.requireNonNull(str);
            this.suggestedBy_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuggestedByBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.suggestedBy_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbnail(String str) {
            Objects.requireNonNull(str);
            this.thumbnail_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbnailBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.thumbnail_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(String str) {
            Objects.requireNonNull(str);
            this.title_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitleBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.title_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0002\u0006Ȉ\u0007Ȉ", new Object[]{"id_", "title_", "artist_", "album_", "duration_", "thumbnail_", "suggestedBy_"});
            }
            if (iOrdinal == 3) {
                return new TrackInfo();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (TrackInfo.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getAlbum() {
            return this.album_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getAlbumBytes() {
            return ByteString.copyFromUtf8(this.album_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getArtist() {
            return this.artist_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getArtistBytes() {
            return ByteString.copyFromUtf8(this.artist_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public long getDuration() {
            return this.duration_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getSuggestedBy() {
            return this.suggestedBy_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getSuggestedByBytes() {
            return ByteString.copyFromUtf8(this.suggestedBy_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getThumbnail() {
            return this.thumbnail_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getThumbnailBytes() {
            return ByteString.copyFromUtf8(this.thumbnail_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public String getTitle() {
            return this.title_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
        public ByteString getTitleBytes() {
            return ByteString.copyFromUtf8(this.title_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements TrackInfoOrBuilder {
            private Builder() {
                super(TrackInfo.DEFAULT_INSTANCE);
            }

            public Builder clearAlbum() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearAlbum();
                return this;
            }

            public Builder clearArtist() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearArtist();
                return this;
            }

            public Builder clearDuration() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearDuration();
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearId();
                return this;
            }

            public Builder clearSuggestedBy() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearSuggestedBy();
                return this;
            }

            public Builder clearThumbnail() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearThumbnail();
                return this;
            }

            public Builder clearTitle() {
                copyOnWrite();
                ((TrackInfo) this.instance).clearTitle();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getAlbum() {
                return ((TrackInfo) this.instance).getAlbum();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getAlbumBytes() {
                return ((TrackInfo) this.instance).getAlbumBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getArtist() {
                return ((TrackInfo) this.instance).getArtist();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getArtistBytes() {
                return ((TrackInfo) this.instance).getArtistBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public long getDuration() {
                return ((TrackInfo) this.instance).getDuration();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getId() {
                return ((TrackInfo) this.instance).getId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getIdBytes() {
                return ((TrackInfo) this.instance).getIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getSuggestedBy() {
                return ((TrackInfo) this.instance).getSuggestedBy();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getSuggestedByBytes() {
                return ((TrackInfo) this.instance).getSuggestedByBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getThumbnail() {
                return ((TrackInfo) this.instance).getThumbnail();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getThumbnailBytes() {
                return ((TrackInfo) this.instance).getThumbnailBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public String getTitle() {
                return ((TrackInfo) this.instance).getTitle();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TrackInfoOrBuilder
            public ByteString getTitleBytes() {
                return ((TrackInfo) this.instance).getTitleBytes();
            }

            public Builder setAlbum(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setAlbum(str);
                return this;
            }

            public Builder setAlbumBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setAlbumBytes(byteString);
                return this;
            }

            public Builder setArtist(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setArtist(str);
                return this;
            }

            public Builder setArtistBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setArtistBytes(byteString);
                return this;
            }

            public Builder setDuration(long j) {
                copyOnWrite();
                ((TrackInfo) this.instance).setDuration(j);
                return this;
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setId(str);
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setIdBytes(byteString);
                return this;
            }

            public Builder setSuggestedBy(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setSuggestedBy(str);
                return this;
            }

            public Builder setSuggestedByBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setSuggestedByBytes(byteString);
                return this;
            }

            public Builder setThumbnail(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setThumbnail(str);
                return this;
            }

            public Builder setThumbnailBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setThumbnailBytes(byteString);
                return this;
            }

            public Builder setTitle(String str) {
                copyOnWrite();
                ((TrackInfo) this.instance).setTitle(str);
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackInfo) this.instance).setTitleBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(TrackInfo trackInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(trackInfo);
        }

        public static TrackInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TrackInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TrackInfo parseFrom(ByteString byteString) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TrackInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TrackInfo parseFrom(byte[] bArr) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TrackInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TrackInfo parseFrom(InputStream inputStream) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TrackInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TrackInfo parseFrom(CodedInputStream codedInputStream) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TrackInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TrackInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class TransferHostPayload extends GeneratedMessageLite implements TransferHostPayloadOrBuilder {
        private static final TransferHostPayload DEFAULT_INSTANCE;
        public static final int NEW_HOST_ID_FIELD_NUMBER = 1;
        private static volatile Parser PARSER;
        private String newHostId_ = "";

        static {
            TransferHostPayload transferHostPayload = new TransferHostPayload();
            DEFAULT_INSTANCE = transferHostPayload;
            GeneratedMessageLite.registerDefaultInstance(TransferHostPayload.class, transferHostPayload);
        }

        private TransferHostPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewHostId() {
            this.newHostId_ = getDefaultInstance().getNewHostId();
        }

        public static TransferHostPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static TransferHostPayload parseDelimitedFrom(InputStream inputStream) {
            return (TransferHostPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TransferHostPayload parseFrom(ByteBuffer byteBuffer) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostId(String str) {
            Objects.requireNonNull(str);
            this.newHostId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewHostIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.newHostId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"newHostId_"});
            }
            if (iOrdinal == 3) {
                return new TransferHostPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (TransferHostPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TransferHostPayloadOrBuilder
        public String getNewHostId() {
            return this.newHostId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.TransferHostPayloadOrBuilder
        public ByteString getNewHostIdBytes() {
            return ByteString.copyFromUtf8(this.newHostId_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements TransferHostPayloadOrBuilder {
            private Builder() {
                super(TransferHostPayload.DEFAULT_INSTANCE);
            }

            public Builder clearNewHostId() {
                copyOnWrite();
                ((TransferHostPayload) this.instance).clearNewHostId();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TransferHostPayloadOrBuilder
            public String getNewHostId() {
                return ((TransferHostPayload) this.instance).getNewHostId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.TransferHostPayloadOrBuilder
            public ByteString getNewHostIdBytes() {
                return ((TransferHostPayload) this.instance).getNewHostIdBytes();
            }

            public Builder setNewHostId(String str) {
                copyOnWrite();
                ((TransferHostPayload) this.instance).setNewHostId(str);
                return this;
            }

            public Builder setNewHostIdBytes(ByteString byteString) {
                copyOnWrite();
                ((TransferHostPayload) this.instance).setNewHostIdBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(TransferHostPayload transferHostPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(transferHostPayload);
        }

        public static TransferHostPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TransferHostPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TransferHostPayload parseFrom(ByteString byteString) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TransferHostPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TransferHostPayload parseFrom(byte[] bArr) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TransferHostPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TransferHostPayload parseFrom(InputStream inputStream) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TransferHostPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TransferHostPayload parseFrom(CodedInputStream codedInputStream) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TransferHostPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TransferHostPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UserDisconnectedPayload extends GeneratedMessageLite implements UserDisconnectedPayloadOrBuilder {
        private static final UserDisconnectedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String username_ = "";

        static {
            UserDisconnectedPayload userDisconnectedPayload = new UserDisconnectedPayload();
            DEFAULT_INSTANCE = userDisconnectedPayload;
            GeneratedMessageLite.registerDefaultInstance(UserDisconnectedPayload.class, userDisconnectedPayload);
        }

        private UserDisconnectedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static UserDisconnectedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static UserDisconnectedPayload parseDelimitedFrom(InputStream inputStream) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserDisconnectedPayload parseFrom(ByteBuffer byteBuffer) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "username_"});
            }
            if (iOrdinal == 3) {
                return new UserDisconnectedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (UserDisconnectedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements UserDisconnectedPayloadOrBuilder {
            private Builder() {
                super(UserDisconnectedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
            public String getUserId() {
                return ((UserDisconnectedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((UserDisconnectedPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
            public String getUsername() {
                return ((UserDisconnectedPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserDisconnectedPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((UserDisconnectedPayload) this.instance).getUsernameBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((UserDisconnectedPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(UserDisconnectedPayload userDisconnectedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(userDisconnectedPayload);
        }

        public static UserDisconnectedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserDisconnectedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserDisconnectedPayload parseFrom(ByteString byteString) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserDisconnectedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserDisconnectedPayload parseFrom(byte[] bArr) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserDisconnectedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserDisconnectedPayload parseFrom(InputStream inputStream) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserDisconnectedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserDisconnectedPayload parseFrom(CodedInputStream codedInputStream) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserDisconnectedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserDisconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UserInfo extends GeneratedMessageLite implements UserInfoOrBuilder {
        private static final UserInfo DEFAULT_INSTANCE;
        public static final int IS_CONNECTED_FIELD_NUMBER = 4;
        public static final int IS_HOST_FIELD_NUMBER = 3;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private boolean isConnected_;
        private boolean isHost_;
        private String userId_ = "";
        private String username_ = "";

        static {
            UserInfo userInfo = new UserInfo();
            DEFAULT_INSTANCE = userInfo;
            GeneratedMessageLite.registerDefaultInstance(UserInfo.class, userInfo);
        }

        private UserInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsConnected() {
            this.isConnected_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsHost() {
            this.isHost_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static UserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream) {
            return (UserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfo parseFrom(ByteBuffer byteBuffer) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsConnected(boolean z) {
            this.isConnected_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsHost(boolean z) {
            this.isHost_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u0007", new Object[]{"userId_", "username_", "isHost_", "isConnected_"});
            }
            if (iOrdinal == 3) {
                return new UserInfo();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (UserInfo.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public boolean getIsConnected() {
            return this.isConnected_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public boolean getIsHost() {
            return this.isHost_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements UserInfoOrBuilder {
            private Builder() {
                super(UserInfo.DEFAULT_INSTANCE);
            }

            public Builder clearIsConnected() {
                copyOnWrite();
                ((UserInfo) this.instance).clearIsConnected();
                return this;
            }

            public Builder clearIsHost() {
                copyOnWrite();
                ((UserInfo) this.instance).clearIsHost();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((UserInfo) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((UserInfo) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public boolean getIsConnected() {
                return ((UserInfo) this.instance).getIsConnected();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public boolean getIsHost() {
                return ((UserInfo) this.instance).getIsHost();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public String getUserId() {
                return ((UserInfo) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public ByteString getUserIdBytes() {
                return ((UserInfo) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public String getUsername() {
                return ((UserInfo) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserInfoOrBuilder
            public ByteString getUsernameBytes() {
                return ((UserInfo) this.instance).getUsernameBytes();
            }

            public Builder setIsConnected(boolean z) {
                copyOnWrite();
                ((UserInfo) this.instance).setIsConnected(z);
                return this;
            }

            public Builder setIsHost(boolean z) {
                copyOnWrite();
                ((UserInfo) this.instance).setIsHost(z);
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((UserInfo) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserInfo) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((UserInfo) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((UserInfo) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(UserInfo userInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(userInfo);
        }

        public static UserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserInfo parseFrom(ByteString byteString) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserInfo parseFrom(byte[] bArr) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserInfo parseFrom(InputStream inputStream) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UserJoinedPayload extends GeneratedMessageLite implements UserJoinedPayloadOrBuilder {
        private static final UserJoinedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String username_ = "";

        static {
            UserJoinedPayload userJoinedPayload = new UserJoinedPayload();
            DEFAULT_INSTANCE = userJoinedPayload;
            GeneratedMessageLite.registerDefaultInstance(UserJoinedPayload.class, userJoinedPayload);
        }

        private UserJoinedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static UserJoinedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static UserJoinedPayload parseDelimitedFrom(InputStream inputStream) {
            return (UserJoinedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserJoinedPayload parseFrom(ByteBuffer byteBuffer) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "username_"});
            }
            if (iOrdinal == 3) {
                return new UserJoinedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (UserJoinedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements UserJoinedPayloadOrBuilder {
            private Builder() {
                super(UserJoinedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
            public String getUserId() {
                return ((UserJoinedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((UserJoinedPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
            public String getUsername() {
                return ((UserJoinedPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserJoinedPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((UserJoinedPayload) this.instance).getUsernameBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((UserJoinedPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(UserJoinedPayload userJoinedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(userJoinedPayload);
        }

        public static UserJoinedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserJoinedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserJoinedPayload parseFrom(ByteString byteString) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserJoinedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserJoinedPayload parseFrom(byte[] bArr) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserJoinedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserJoinedPayload parseFrom(InputStream inputStream) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserJoinedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserJoinedPayload parseFrom(CodedInputStream codedInputStream) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserJoinedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserJoinedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UserLeftPayload extends GeneratedMessageLite implements UserLeftPayloadOrBuilder {
        private static final UserLeftPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String username_ = "";

        static {
            UserLeftPayload userLeftPayload = new UserLeftPayload();
            DEFAULT_INSTANCE = userLeftPayload;
            GeneratedMessageLite.registerDefaultInstance(UserLeftPayload.class, userLeftPayload);
        }

        private UserLeftPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static UserLeftPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static UserLeftPayload parseDelimitedFrom(InputStream inputStream) {
            return (UserLeftPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserLeftPayload parseFrom(ByteBuffer byteBuffer) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "username_"});
            }
            if (iOrdinal == 3) {
                return new UserLeftPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (UserLeftPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements UserLeftPayloadOrBuilder {
            private Builder() {
                super(UserLeftPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((UserLeftPayload) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((UserLeftPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
            public String getUserId() {
                return ((UserLeftPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((UserLeftPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
            public String getUsername() {
                return ((UserLeftPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserLeftPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((UserLeftPayload) this.instance).getUsernameBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((UserLeftPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserLeftPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((UserLeftPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((UserLeftPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(UserLeftPayload userLeftPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(userLeftPayload);
        }

        public static UserLeftPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserLeftPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserLeftPayload parseFrom(ByteString byteString) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserLeftPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserLeftPayload parseFrom(byte[] bArr) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserLeftPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserLeftPayload parseFrom(InputStream inputStream) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserLeftPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserLeftPayload parseFrom(CodedInputStream codedInputStream) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserLeftPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserLeftPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class UserReconnectedPayload extends GeneratedMessageLite implements UserReconnectedPayloadOrBuilder {
        private static final UserReconnectedPayload DEFAULT_INSTANCE;
        private static volatile Parser PARSER = null;
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private String userId_ = "";
        private String username_ = "";

        static {
            UserReconnectedPayload userReconnectedPayload = new UserReconnectedPayload();
            DEFAULT_INSTANCE = userReconnectedPayload;
            GeneratedMessageLite.registerDefaultInstance(UserReconnectedPayload.class, userReconnectedPayload);
        }

        private UserReconnectedPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.username_ = getDefaultInstance().getUsername();
        }

        public static UserReconnectedPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static UserReconnectedPayload parseDelimitedFrom(InputStream inputStream) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserReconnectedPayload parseFrom(ByteBuffer byteBuffer) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            Objects.requireNonNull(str);
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            Objects.requireNonNull(str);
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int iOrdinal = methodToInvoke.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"userId_", "username_"});
            }
            if (iOrdinal == 3) {
                return new UserReconnectedPayload();
            }
            if (iOrdinal == 4) {
                return new Builder(0);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            Parser parser = PARSER;
            if (parser != null) {
                return parser;
            }
            synchronized (UserReconnectedPayload.class) {
                try {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return defaultInstanceBasedParser;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public static final class Builder extends GeneratedMessageLite.Builder implements UserReconnectedPayloadOrBuilder {
            private Builder() {
                super(UserReconnectedPayload.DEFAULT_INSTANCE);
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).clearUserId();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).clearUsername();
                return this;
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
            public String getUserId() {
                return ((UserReconnectedPayload) this.instance).getUserId();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
            public ByteString getUserIdBytes() {
                return ((UserReconnectedPayload) this.instance).getUserIdBytes();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
            public String getUsername() {
                return ((UserReconnectedPayload) this.instance).getUsername();
            }

            @Override // com.metrolist.music.listentogether.proto.Listentogether.UserReconnectedPayloadOrBuilder
            public ByteString getUsernameBytes() {
                return ((UserReconnectedPayload) this.instance).getUsernameBytes();
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((UserReconnectedPayload) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(UserReconnectedPayload userReconnectedPayload) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(userReconnectedPayload);
        }

        public static UserReconnectedPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserReconnectedPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserReconnectedPayload parseFrom(ByteString byteString) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserReconnectedPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserReconnectedPayload parseFrom(byte[] bArr) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserReconnectedPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserReconnectedPayload parseFrom(InputStream inputStream) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserReconnectedPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserReconnectedPayload parseFrom(CodedInputStream codedInputStream) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserReconnectedPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UserReconnectedPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
