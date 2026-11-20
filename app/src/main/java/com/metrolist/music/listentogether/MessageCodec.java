package com.metrolist.music.listentogether;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.metrolist.music.listentogether.proto.Listentogether;
import dagger.hilt.EntryPoints;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Pair;
import kotlin.text.CharsKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageCodec {
    public static Pair decode(byte[] bArr) {
        byte[] bytes;
        bArr.getClass();
        Listentogether.Envelope from = Listentogether.Envelope.parseFrom(bArr);
        byte[] byteArray = from.getPayload().toByteArray();
        String type = from.getType();
        if (from.getCompressed()) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArray));
                try {
                    bytes = EntryPoints.readBytes(gZIPInputStream);
                    gZIPInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(gZIPInputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception unused) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
                bytes = null;
            }
            if (bytes != null) {
                byteArray = bytes;
            }
        }
        return new Pair(type, byteArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static GeneratedMessageLite decodePayload(String str, byte[] bArr) {
        bArr.getClass();
        if (bArr.length == 0) {
            return null;
        }
        switch (str.hashCode()) {
            case -1941230026:
                if (str.equals("reconnected")) {
                    return Listentogether.ReconnectedPayload.parseFrom(bArr);
                }
                return null;
            case -1849187859:
                if (str.equals("sync_state")) {
                    return Listentogether.SyncStatePayload.parseFrom(bArr);
                }
                return null;
            case -1343902913:
                if (str.equals("sync_playback")) {
                    return Listentogether.PlaybackActionPayload.parseFrom(bArr);
                }
                return null;
            case -1131623067:
                if (str.equals("kicked")) {
                    return Listentogether.KickedPayload.parseFrom(bArr);
                }
                return null;
            case -1024893420:
                if (str.equals("buffer_wait")) {
                    return Listentogether.BufferWaitPayload.parseFrom(bArr);
                }
                return null;
            case -752968828:
                if (str.equals("room_created")) {
                    return Listentogether.RoomCreatedPayload.parseFrom(bArr);
                }
                return null;
            case -412578243:
                if (str.equals("user_joined")) {
                    return Listentogether.UserJoinedPayload.parseFrom(bArr);
                }
                return null;
            case -241805892:
                if (str.equals("suggestion_received")) {
                    return Listentogether.SuggestionReceivedPayload.parseFrom(bArr);
                }
                return null;
            case -41582503:
                if (str.equals("suggestion_rejected")) {
                    return Listentogether.SuggestionRejectedPayload.parseFrom(bArr);
                }
                return null;
            case 3446776:
                if (str.equals("pong")) {
                    return Listentogether.PongPayload.parseFrom(bArr);
                }
                return null;
            case 46372851:
                if (str.equals("join_rejected")) {
                    return Listentogether.JoinRejectedPayload.parseFrom(bArr);
                }
                return null;
            case 96784904:
                if (str.equals("error")) {
                    return Listentogether.ErrorPayload.parseFrom(bArr);
                }
                return null;
            case 339284987:
                if (str.equals("user_left")) {
                    return Listentogether.UserLeftPayload.parseFrom(bArr);
                }
                return null;
            case 569480792:
                if (str.equals("buffer_complete")) {
                    return Listentogether.BufferCompletePayload.parseFrom(bArr);
                }
                return null;
            case 793518018:
                if (str.equals("user_reconnected")) {
                    return Listentogether.UserReconnectedPayload.parseFrom(bArr);
                }
                return null;
            case 1408227101:
                if (str.equals("host_changed")) {
                    return Listentogether.HostChangedPayload.parseFrom(bArr);
                }
                return null;
            case 1752158866:
                if (str.equals("suggestion_approved")) {
                    return Listentogether.SuggestionApprovedPayload.parseFrom(bArr);
                }
                return null;
            case 1791421999:
                if (str.equals("user_disconnected")) {
                    return Listentogether.UserDisconnectedPayload.parseFrom(bArr);
                }
                return null;
            case 1840114220:
                if (str.equals("join_approved")) {
                    return Listentogether.JoinApprovedPayload.parseFrom(bArr);
                }
                return null;
            case 1948101754:
                if (str.equals("join_request")) {
                    return Listentogether.JoinRequestPayload.parseFrom(bArr);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0041  */
    public final byte[] encode(String str, MessageLite messageLite) {
        byte[] byteArray;
        boolean z;
        if (messageLite == null || (byteArray = messageLite.toByteArray()) == null) {
            byteArray = new byte[0];
        }
        if (byteArray.length > 100) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(byteArray);
                    gZIPOutputStream.close();
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    byteArray2.getClass();
                    if (byteArray2.length < byteArray.length) {
                        z = true;
                        byteArray = byteArray2;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(gZIPOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CharsKt.closeFinally(byteArrayOutputStream, th3);
                    throw th4;
                }
            }
        } else {
            z = false;
        }
        byte[] byteArray3 = ((Listentogether.Envelope) Listentogether.Envelope.newBuilder().setType(str).setPayload(ByteString.copyFrom(byteArray, 0, byteArray.length)).setCompressed(z).m915build()).toByteArray();
        byteArray3.getClass();
        return byteArray3;
    }
}
