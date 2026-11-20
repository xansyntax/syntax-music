package com.google.common.base;

import android.os.Bundle;
import android.os.Looper;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Consumer;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.ResolvingDataSource;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.SessionResult;
import coil3.util.UtilsKt;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps$TransformedEntriesListMultimap;
import com.google.common.collect.Multimaps$TransformedEntriesListMultimap$$ExternalSyntheticLambda0;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ImmediateFuture;
import com.metrolist.innertube.models.response.PlayerResponse$StreamingData$Format;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.playback.CachedStreamUrl;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.DownloadUtilKt;
import com.metrolist.music.playback.StreamUrlCache;
import com.metrolist.music.utils.InnerTubeXPlayer;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.text.CharsKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Splitter$$ExternalSyntheticLambda0 implements MediaControllerStub.ControllerTask, MediaSessionStub.SessionTask, MediaSessionStub.ControllerPlayerTask, ResolvingDataSource.Resolver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Splitter$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x008a A[LOOP:0: B:25:0x0084->B:27:0x008a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e0 A[Catch: all -> 0x013c, TryCatch #1 {all -> 0x013c, blocks: (B:30:0x00ca, B:34:0x00e0, B:40:0x00f0, B:42:0x00fa, B:44:0x0100, B:46:0x010f, B:48:0x0115, B:55:0x0127, B:57:0x012d, B:35:0x00e5, B:36:0x00e8), top: B:82:0x00ca, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00e5 A[Catch: all -> 0x013c, TryCatch #1 {all -> 0x013c, blocks: (B:30:0x00ca, B:34:0x00e0, B:40:0x00f0, B:42:0x00fa, B:44:0x0100, B:46:0x010f, B:48:0x0115, B:55:0x0127, B:57:0x012d, B:35:0x00e5, B:36:0x00e8), top: B:82:0x00ca, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8 A[Catch: all -> 0x013c, TryCatch #1 {all -> 0x013c, blocks: (B:30:0x00ca, B:34:0x00e0, B:40:0x00f0, B:42:0x00fa, B:44:0x0100, B:46:0x010f, B:48:0x0115, B:55:0x0127, B:57:0x012d, B:35:0x00e5, B:36:0x00e8), top: B:82:0x00ca, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:51:0x011e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0121  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.datasource.ResolvingDataSource.Resolver
    public DataSpec resolveDataSpec(DataSpec dataSpec) {
        Request.Builder builder;
        Continuation continuation;
        Object obj;
        Long l;
        Response responseExecute;
        int i;
        String strHeader$default;
        Regex regex;
        Long longOrNull;
        Object obj2;
        String string;
        MatcherMatchResult matcherMatchResultMatchEntire;
        String str;
        Long longOrNull2;
        DownloadUtil downloadUtil = (DownloadUtil) this.f$0;
        dataSpec.getClass();
        String str2 = dataSpec.key;
        Continuation continuation2 = null;
        if (str2 == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No media id");
            return null;
        }
        long j = dataSpec.length;
        long j2 = 0;
        long j3 = j >= 0 ? j : 1L;
        SimpleCache simpleCache = downloadUtil.playerCache;
        StreamUrlCache streamUrlCache = downloadUtil.songUrlCache;
        if (simpleCache.isCached(dataSpec.position, j3, str2)) {
            return dataSpec;
        }
        CachedStreamUrl cachedStreamUrl = streamUrlCache.get(str2);
        if (cachedStreamUrl != null) {
            return RegexKt.withResolvedStream(dataSpec, cachedStreamUrl);
        }
        long jGeneration = streamUrlCache.generation(str2);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object obj3 = ((Result) AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new SimpleActor$offer$2(downloadUtil, str2, continuation2, (byte) 12))).value;
        ResultKt.throwOnFailure(obj3);
        InnerTubeXPlayer.PlaybackData playbackData = (InnerTubeXPlayer.PlaybackData) obj3;
        PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = playbackData.format;
        String str3 = playbackData.streamUrl;
        Long l2 = playerResponse$StreamingData$Format.contentLength;
        if (l2 == null) {
            builder = new Request.Builder();
            builder.method("GET", null);
            builder.url(str3);
            for (Map.Entry entry : playbackData.streamHeaders.entrySet()) {
                builder.header((String) entry.getKey(), (String) entry.getValue());
                continuation2 = continuation2;
                j2 = j2;
            }
            continuation = continuation2;
            long j4 = j2;
            builder.header(HttpHeaders.Range, "bytes=0-0");
            Request request = new Request(builder);
            try {
                OkHttpClient okHttpClient = downloadUtil.streamHttpClient;
                okHttpClient.getClass();
                responseExecute = new RealCall(okHttpClient, request, false).execute();
                try {
                    i = responseExecute.code;
                    strHeader$default = Response.header$default(HttpHeaders.ContentRange, responseExecute);
                    String strHeader$default2 = Response.header$default(HttpHeaders.ContentLength, responseExecute);
                    if (i != 206) {
                        regex = DownloadUtilKt.PARTIAL_CONTENT_RANGE;
                    } else if (i != 416) {
                        Regex regex2 = DownloadUtilKt.PARTIAL_CONTENT_RANGE;
                        regex = continuation;
                    } else {
                        regex = DownloadUtilKt.UNSATISFIED_CONTENT_RANGE;
                    }
                    if (regex != 0) {
                        if (strHeader$default != null || (string = StringsKt.trim(strHeader$default).toString()) == null || (matcherMatchResultMatchEntire = regex.matchEntire(string)) == null || (str = (String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(1)) == null || (longOrNull2 = StringsKt__StringsJVMKt.toLongOrNull(10, str)) == null || longOrNull2.longValue() <= j4) {
                            obj2 = continuation;
                        } else {
                            obj2 = longOrNull2;
                        }
                    } else if (i == 200 || strHeader$default2 == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, strHeader$default2)) == null) {
                        obj2 = continuation;
                    } else {
                        long jLongValue = longOrNull.longValue();
                        obj2 = longOrNull;
                        if (jLongValue <= j4) {
                            obj2 = continuation;
                        }
                    }
                    responseExecute.close();
                    obj = obj2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(responseExecute, th);
                        throw th2;
                    }
                }
            } catch (IOException unused) {
                obj = continuation;
            }
            l = obj;
        } else {
            if (l2.longValue() <= 0) {
                l2 = null;
            }
            if (l2 == null) {
                builder = new Request.Builder();
                builder.method("GET", null);
                builder.url(str3);
                while (r5.hasNext()) {
                    builder.header((String) entry.getKey(), (String) entry.getValue());
                    continuation2 = continuation2;
                    j2 = j2;
                }
                continuation = continuation2;
                long j5 = j2;
                builder.header(HttpHeaders.Range, "bytes=0-0");
                Request request2 = new Request(builder);
                OkHttpClient okHttpClient2 = downloadUtil.streamHttpClient;
                okHttpClient2.getClass();
                responseExecute = new RealCall(okHttpClient2, request2, false).execute();
                i = responseExecute.code;
                strHeader$default = Response.header$default(HttpHeaders.ContentRange, responseExecute);
                String strHeader$default3 = Response.header$default(HttpHeaders.ContentLength, responseExecute);
                if (i != 206) {
                    regex = DownloadUtilKt.PARTIAL_CONTENT_RANGE;
                } else if (i != 416) {
                    Regex regex3 = DownloadUtilKt.PARTIAL_CONTENT_RANGE;
                    regex = continuation;
                } else {
                    regex = DownloadUtilKt.UNSATISFIED_CONTENT_RANGE;
                }
                if (regex != 0) {
                    if (strHeader$default != null) {
                        obj2 = continuation;
                    } else {
                        obj2 = continuation;
                    }
                } else if (i == 200) {
                    obj2 = continuation;
                } else {
                    obj2 = continuation;
                }
                responseExecute.close();
                obj = obj2;
                l = obj;
            } else {
                l = l2;
            }
        }
        downloadUtil.database.query(new MainActivity$$ExternalSyntheticLambda59((Object) l, str2, (Object) playerResponse$StreamingData$Format, (Object) playbackData, (byte) 9));
        String str4 = (l == 0 || StringsKt.contains(str3, "&range=", false)) ? str3 : str3 + "&range=0-" + (l.longValue() - 1);
        downloadUtil.songUrlCache.put(str2, str4, playbackData.streamHeaders, playbackData.streamClient, playbackData.streamExpiresInSeconds, playbackData.requireBoundedRange, playbackData.rangeChunkSizeBytes, playbackData.useRangeChunks, jGeneration);
        return RegexKt.withResolvedStream(dataSpec, new CachedStreamUrl(str4, playbackData.streamHeaders, playbackData.streamClient, playbackData.requireBoundedRange, playbackData.rangeChunkSizeBytes, playbackData.useRangeChunks));
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        MediaController mediaController = mediaControllerImplBase.instance;
        Bundle bundle = (Bundle) this.f$0;
        if (mediaControllerImplBase.isConnected()) {
            RegularImmutableList regularImmutableList = mediaControllerImplBase.resolvedMediaButtonPreferences;
            RegularImmutableList regularImmutableList2 = mediaControllerImplBase.resolvedCustomLayout;
            mediaControllerImplBase.sessionExtras = bundle;
            RegularImmutableList regularImmutableListResolveMediaButtonPreferences = MediaControllerImplBase.resolveMediaButtonPreferences(mediaControllerImplBase.mediaButtonPreferencesOriginal, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, bundle);
            mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences;
            mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionExtras, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.getSessionInterfaceVersion());
            boolean zEquals = mediaControllerImplBase.resolvedMediaButtonPreferences.equals(regularImmutableList);
            mediaControllerImplBase.resolvedCustomLayout.equals(regularImmutableList2);
            mediaController.getClass();
            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
            MediaController.Listener listener = mediaController.listener;
            listener.getClass();
            if (zEquals) {
                return;
            }
            listener.onMediaButtonPreferencesChanged();
        }
    }

    public Object transformEntry(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$0;
        switch (b) {
            case 5:
                return ((Format$$ExternalSyntheticLambda1) obj3).apply(obj2);
            case 6:
                return ((Format$$ExternalSyntheticLambda1) obj3).apply(obj2);
            default:
                return Maps.transform(new Multimaps$TransformedEntriesListMultimap$$ExternalSyntheticLambda0((Multimaps$TransformedEntriesListMultimap) obj3, obj), (List) ((Collection) obj2));
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 2:
                return mediaLibrarySessionImpl.onGetLibraryRootOnHandler(mediaSession$ControllerInfo, (MediaLibraryService.LibraryParams) obj);
            default:
                ImmediateFuture immediateFuture = ImmediateFuture.NULL;
                MediaSessionStub.ControllerPlayerTask controllerPlayerTask = (MediaSessionStub.ControllerPlayerTask) obj;
                if (!mediaLibrarySessionImpl.isReleased()) {
                    controllerPlayerTask.run(mediaLibrarySessionImpl.playerWrapper, mediaSession$ControllerInfo);
                    MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i, new SessionResult(0));
                }
                return immediateFuture;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        ((Consumer) this.f$0).accept(playerWrapper);
    }
}
