package okhttp3.internal.http2;

import android.net.Uri;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$9$4$3;
import com.metrolist.music.ui.screens.equalizer.wizard.DeviceModel;
import com.metrolist.music.ui.screens.equalizer.wizard.EQProfileVariant;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3;
import com.metrolist.music.ui.utils.AppBarKt;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.sse.ServerSentEventKt;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda1;
import okio.Buffer;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public final FlowControlListener$None flowControlListener;
    public long intervalPingsSent;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final ErrorCode.Companion pushObserver;
    public final TaskQueue pushQueue;
    public final WindowCounter readBytes;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final NavDeepLinkRequest socket;
    public final LinkedHashMap streams = new LinkedHashMap();
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public void onSettings(Http2Connection http2Connection, Settings settings) {
            settings.getClass();
        }

        public void onStream(Http2Stream http2Stream) {
            http2Stream.close(ErrorCode.REFUSED_STREAM, null);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(4, DatagramKt.MAX_DATAGRAM_SIZE);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(RulerTrackingMap rulerTrackingMap) {
        this.listener = (Listener) rulerTrackingMap.layoutNodes;
        String str = (String) rulerTrackingMap.accessFlags;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            throw null;
        }
        this.connectionName = str;
        byte b = 3;
        this.nextStreamId = 3;
        TaskRunner taskRunner = (TaskRunner) rulerTrackingMap.rulers;
        this.taskRunner = taskRunner;
        TaskQueue taskQueueNewQueue = taskRunner.newQueue();
        this.writerQueue = taskQueueNewQueue;
        this.pushQueue = taskRunner.newQueue();
        this.settingsListenerQueue = taskRunner.newQueue();
        this.pushObserver = ErrorCode.Companion.CANCEL;
        this.flowControlListener = (FlowControlListener$None) rulerTrackingMap.newRulers;
        Settings settings = new Settings();
        settings.set(4, 16777216);
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        NavDeepLinkRequest navDeepLinkRequest = (NavDeepLinkRequest) rulerTrackingMap.values;
        if (navDeepLinkRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            throw null;
        }
        this.socket = navDeepLinkRequest;
        this.writer = new Http2Writer((RealBufferedSink) navDeepLinkRequest.mimeType);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader((RealBufferedSource) navDeepLinkRequest.action));
        this.currentPushRequests = new LinkedHashSet();
        int i = rulerTrackingMap.size;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            taskQueueNewQueue.schedule(new TaskQueue$execute$1(str.concat(" ping"), new RealWebSocket$$ExternalSyntheticLambda1(this, nanos, b)), nanos);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i;
        Object[] array;
        TimeZone timeZone = _UtilJvmKt.UTC;
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                array = null;
            } else {
                array = this.streams.values().toArray(new Http2Stream[0]);
                this.streams.clear();
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.cancel();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final Http2Stream getStream(int i) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = (Http2Stream) this.streams.get(Integer.valueOf(i));
        }
        return http2Stream;
    }

    public final Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
            notifyAll();
        }
        return http2Stream;
    }

    public final void shutdown(ErrorCode errorCode) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void updateConnectionFlowControl$okhttp(long j) {
        synchronized (this) {
            try {
                WindowCounter.update$default(this.readBytes, j, 0L, 2);
                long unacknowledged = this.readBytes.getUnacknowledged();
                if (unacknowledged >= this.okHttpSettings.getInitialWindowSize() / 2) {
                    writeWindowUpdateLater$okhttp(0, unacknowledged);
                    WindowCounter.update$default(this.readBytes, 0L, unacknowledged, 1);
                }
                FlowControlListener$None flowControlListener$None = this.flowControlListener;
                WindowCounter windowCounter = this.readBytes;
                flowControlListener$None.getClass();
                windowCounter.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void writeData(int i, boolean z, Buffer buffer, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.writeBytesTotal;
                            j3 = this.writeBytesMaximum;
                            if (j2 >= j3) {
                                if (!this.streams.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.writer.maxFrameSize);
                j4 = iMin;
                this.writeBytesTotal += j4;
            }
            j -= j4;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    public final void writeSynResetLater$okhttp(int i, ErrorCode errorCode) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i + "] writeSynReset", 0L, new Http2Connection$$ExternalSyntheticLambda3(this, i, errorCode, (byte) 0), 6);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i + "] windowUpdate", 0L, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Http2Connection http2Connection = this.f$0;
                try {
                    http2Connection.writer.windowUpdate(i, j);
                } catch (IOException e) {
                    ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.close$okhttp(errorCode, errorCode, e);
                }
                return Unit.INSTANCE;
            }
        }, 6);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public final class ReaderRunnable implements Function0 {
        public final /* synthetic */ byte $r8$classId;
        public final Object reader;
        public final /* synthetic */ Object this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            this.$r8$classId = (byte) 0;
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v45 */
        /* JADX WARN: Type inference failed for: r10v46 */
        /* JADX WARN: Type inference failed for: r10v8 */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws Throwable {
            byte b = this.$r8$classId;
            final byte b2 = 0;
            byte b3 = 4;
            byte b4 = 2;
            final byte b5 = 1;
            Unit unit = Unit.INSTANCE;
            Object obj = this.this$0;
            Object obj2 = this.reader;
            switch (b) {
                case 0:
                    Http2Connection http2Connection = (Http2Connection) obj;
                    Http2Reader http2Reader = (Http2Reader) obj2;
                    ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
                    IOException iOException = null;
                    try {
                        try {
                            try {
                                if (!http2Reader.nextFrame(true, this)) {
                                    throw new IOException("Required SETTINGS preface not received");
                                }
                                do {
                                    try {
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } while (http2Reader.nextFrame(false, this));
                                ErrorCode errorCode2 = ErrorCode.NO_ERROR;
                                try {
                                    errorCode = ErrorCode.CANCEL;
                                    http2Connection.close$okhttp(errorCode2, errorCode, null);
                                    this = errorCode2;
                                } catch (IOException e) {
                                    iOException = e;
                                    ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                                    http2Connection.close$okhttp(errorCode3, errorCode3, iOException);
                                    this = errorCode3;
                                }
                                _UtilCommonKt.closeQuietly(http2Reader);
                                return unit;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (IOException e2) {
                            iOException = e2;
                        }
                        this = errorCode;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    http2Connection.close$okhttp(this, errorCode, iOException);
                    _UtilCommonKt.closeQuietly(http2Reader);
                    throw th;
                case 1:
                    ((Function1) obj2).invoke(obj);
                    return unit;
                case 2:
                    final String str = ((Timeline.Window) obj2).mediaItem.mediaId;
                    ((BottomSheetPageState) obj).show(new ComposableLambdaImpl(true, -26648497, new Function3() { // from class: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            byte b6 = b5;
                            Unit unit2 = Unit.INSTANCE;
                            String str2 = str;
                            switch (b6) {
                                case 0:
                                    Composer composer = (Composer) obj4;
                                    int iIntValue = ((Number) obj5).intValue();
                                    ((ColumnScopeInstance) obj3).getClass();
                                    GapComposer gapComposer = (GapComposer) composer;
                                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        str2.getClass();
                                        AppBarKt.ShowMediaInfo(str2, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    Composer composer2 = (Composer) obj4;
                                    int iIntValue2 = ((Number) obj5).intValue();
                                    ((ColumnScopeInstance) obj3).getClass();
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        str2.getClass();
                                        AppBarKt.ShowMediaInfo(str2, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }));
                    return unit;
                case 3:
                    final String str2 = ((MediaItem) obj2).mediaId;
                    ((BottomSheetPageState) obj).show(new ComposableLambdaImpl(true, 1604607397, new Function3() { // from class: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            byte b6 = b2;
                            Unit unit2 = Unit.INSTANCE;
                            String str3 = str2;
                            switch (b6) {
                                case 0:
                                    Composer composer = (Composer) obj4;
                                    int iIntValue = ((Number) obj5).intValue();
                                    ((ColumnScopeInstance) obj3).getClass();
                                    GapComposer gapComposer = (GapComposer) composer;
                                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        str3.getClass();
                                        AppBarKt.ShowMediaInfo(str3, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    Composer composer2 = (Composer) obj4;
                                    int iIntValue2 = ((Number) obj5).intValue();
                                    ((ColumnScopeInstance) obj3).getClass();
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        str3.getClass();
                                        AppBarKt.ShowMediaInfo(str3, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    }));
                    return unit;
                case 4:
                    Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) obj).id, (NavHostController) obj2);
                    return unit;
                case 5:
                    NavHostController navHostController = (NavHostController) obj;
                    YTItem yTItem = (YTItem) obj2;
                    if (yTItem != null) {
                        if (yTItem instanceof AlbumItem) {
                            Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem).id, navHostController);
                        } else if (yTItem instanceof PlaylistItem) {
                            Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem).id, navHostController);
                        } else if (yTItem instanceof ArtistItem) {
                            Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem).id, navHostController);
                        }
                    }
                    return unit;
                case 6:
                    MenuState menuState = (MenuState) obj2;
                    menuState.show(new ComposableLambdaImpl(true, 816093706, new AccountScreenKt$AccountScreen$1$1$11$1$1.AnonymousClass1((EventWithSong) obj, menuState, b5)));
                    return unit;
                case 7:
                    BrowseEndpoint browseEndpoint = ((MoodAndGenres.Item) obj).endpoint;
                    NavHostController.navigate$default((NavHostController) obj2, "youtube_browse/" + browseEndpoint.browseId + "?params=" + browseEndpoint.params);
                    return unit;
                case 8:
                    MenuState menuState2 = (MenuState) obj2;
                    menuState2.show(new ComposableLambdaImpl(true, 1181704194, new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$3(menuState2, (MutableState) obj, b3)));
                    return unit;
                case 9:
                    NavHostController.navigate$default((NavHostController) obj2, "online_playlist/".concat(StringsKt.removePrefix(((CommunityPlaylistItem) obj).playlist.id, "VL")));
                    return unit;
                case 10:
                    ((Function1) obj2).invoke((Artist) obj);
                    return unit;
                case 11:
                    Format$$ExternalSyntheticOutline0.m("local_playlist/", ((Playlist) obj).playlist.id, (NavHostController) obj2);
                    return unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    Format$$ExternalSyntheticOutline0.m("artist/", ((com.metrolist.music.db.entities.Artist) obj).artist.id, (NavHostController) obj2);
                    return unit;
                case 13:
                    MenuState menuState3 = (MenuState) obj2;
                    menuState3.show(new ComposableLambdaImpl(true, -2012011785, new ArtistScreenKt$ArtistScreen$2$1$1$9$4$3((YTItem) obj, menuState3, b4)));
                    return unit;
                case 14:
                    ((Function1) obj2).invoke((DeviceModel) obj);
                    return unit;
                case 15:
                    ((Function1) obj2).invoke(((EQProfileVariant) obj).id);
                    return unit;
                case 16:
                    MenuState menuState4 = (MenuState) obj2;
                    menuState4.show(new ComposableLambdaImpl(true, 972681154, new OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3((EpisodeItem) obj, menuState4, b4)));
                    return unit;
                case 17:
                    RecognitionHistory recognitionHistory = (RecognitionHistory) obj2;
                    Format$$ExternalSyntheticOutline0.m("search/", Uri.encode("__metrolist_search_query__".concat(Fragment$5$$ExternalSyntheticOutline0.m(recognitionHistory.title, ServerSentEventKt.SPACE, recognitionHistory.artist))), (NavHostController) obj);
                    return unit;
                case 18:
                    ((MutableState) obj).setValue((RecognitionHistory) obj2);
                    return unit;
                case 19:
                    ((MusicDatabase) obj2).query(new RenderScriptBlurEffect$updateSurface$2$4(b4, (SearchHistory) obj));
                    return unit;
                default:
                    String str3 = ((SearchHistory) obj).query;
                    int length = str3.length();
                    ((Function1) obj2).invoke(new TextFieldValue(4, TextRangeKt.TextRange(length, length), str3));
                    return unit;
            }
        }

        public /* synthetic */ ReaderRunnable(Object obj, Object obj2, byte b) {
            this.$r8$classId = b;
            this.reader = obj;
            this.this$0 = obj2;
        }
    }
}
