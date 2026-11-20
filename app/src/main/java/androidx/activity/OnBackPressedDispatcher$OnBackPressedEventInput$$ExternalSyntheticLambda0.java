package androidx.activity;

import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.compose.foundation.layout.Arrangement$SpacingAlignmentCalculator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.insets.ProtectionGroup;
import androidx.core.view.insets.SystemBarStateMonitor;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.BackgroundThreadStateHandler$StateChangeListener;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.ProgressiveDownloader;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.BinarySearchSeeker$SeekTimestampConverter;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.ts.SeiReader;
import androidx.media3.session.CommandButton;
import androidx.media3.session.ConnectionState;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda62;
import androidx.media3.session.MediaUtils;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionPositionInfo;
import androidx.media3.session.SessionToken;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 implements ActivityResultCallback, Arrangement$SpacingAlignmentCalculator, OnApplyWindowInsetsListener, ListenerSet.Event, BackgroundThreadStateHandler$StateChangeListener, DefaultTrackSelector.TrackInfo.Factory, BinarySearchSeeker$SeekTimestampConverter, Consumer, MediaControllerStub.ControllerTask {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(int i, PendingIntent pendingIntent) {
        this.$r8$classId = (byte) 29;
        this.f$0 = pendingIntent;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (b) {
            case 22:
                SubtitleExtractor subtitleExtractor = (SubtitleExtractor) obj2;
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                SubtitleExtractor.Sample sample = new SubtitleExtractor.Sample(cuesWithTiming.startTimeUs, CueDecoder.encode(cuesWithTiming.cues, cuesWithTiming.durationUs));
                subtitleExtractor.samples.add(sample);
                long j = subtitleExtractor.seekTimeUs;
                if (j == -9223372036854775807L || cuesWithTiming.endTimeUs >= j) {
                    subtitleExtractor.writeToOutput(sample);
                }
                break;
            default:
                ((ImmutableList.Builder) obj2).add(obj);
                break;
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement$SpacingAlignmentCalculator
    public int align(int i, LayoutDirection layoutDirection) {
        return ((BiasAlignment.Horizontal) this.f$0).align(0, i, layoutDirection);
    }

    public void consume(long j, ParsableByteArray parsableByteArray) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 21:
                AacUtil.consume(j, parsableByteArray, ((FragmentedMp4Extractor) obj).ceaTrackOutputs);
                break;
            case 25:
                AacUtil.consume(j, parsableByteArray, ((SeiReader) obj).outputs);
                break;
            default:
                AacUtil.consumeCcData(j, parsableByteArray, ((SeiReader) obj).outputs);
                break;
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
    public RegularImmutableList create(int i, TrackGroup trackGroup, int[] iArr) {
        DefaultTrackSelector.Parameters parameters = (DefaultTrackSelector.Parameters) this.f$0;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            builder.add((Object) new DefaultTrackSelector.ImageTrackInfo(i, trackGroup, i2, parameters, iArr[i2]));
        }
        return builder.build();
    }

    public void dispose() {
        Function2 function2 = (Function2) this.f$0;
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.minus(SnapshotKt.applyObservers, function2);
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (b) {
            case 6:
                ((Player.Listener) obj).onCues((CueGroup) obj2);
                break;
            case 7:
                ((Player.Listener) obj).onMediaMetadataChanged(ExoPlayerImpl.this.mediaMetadata);
                break;
            case 8:
                ((Player.Listener) obj).onMetadata((Metadata) obj2);
                break;
            case 9:
                ((Player.Listener) obj).onDeviceInfoChanged((DeviceInfo) obj2);
                break;
            case 10:
            case 11:
            default:
                ((AnalyticsListener) obj).onDrmSessionManagerError((Exception) obj2);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((AnalyticsListener) obj).onVideoDisabled((DecoderCounters) obj2);
                break;
            case 13:
                ((AnalyticsListener) obj).getClass();
                break;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ((Function1) ((MutableState) this.f$0).getValue()).invoke(obj);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        SystemBarStateMonitor systemBarStateMonitor = (SystemBarStateMonitor) this.f$0;
        ArrayList arrayList = systemBarStateMonitor.mCallbacks;
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        Insets insetsMin = Insets.min(impl.getInsets(519), impl.getInsets(64));
        Insets insetsMin2 = Insets.min(impl.getInsetsIgnoringVisibility(519), impl.getInsetsIgnoringVisibility(64));
        if (!insetsMin.equals(systemBarStateMonitor.mInsets) || !insetsMin2.equals(systemBarStateMonitor.mInsetsIgnoringVisibility)) {
            systemBarStateMonitor.mInsets = insetsMin;
            systemBarStateMonitor.mInsetsIgnoringVisibility = insetsMin2;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ProtectionGroup protectionGroup = (ProtectionGroup) arrayList.get(size);
                protectionGroup.mInsets = insetsMin;
                protectionGroup.mInsetsIgnoringVisibility = insetsMin2;
                protectionGroup.updateInsets();
            }
        }
        return windowInsetsCompat;
    }

    public void onProgress(long j, long j2) {
        float f;
        DownloadManager.Task task = ((ProgressiveDownloader) this.f$0).progressListener;
        if (task == null) {
            return;
        }
        if (j == -1 || j == 0) {
            f = -1.0f;
        } else {
            String str = Util.DEVICE_DEBUG_INFO;
            f = 100.0f;
            if (j == 0 || j2 != j) {
                f = 100.0f * (j2 / j);
            }
        }
        task.downloadProgress.bytesDownloaded = j2;
        task.downloadProgress.percentDownloaded = f;
        if (j != task.contentLength) {
            task.contentLength = j;
            DownloadManager.InternalHandler internalHandler = task.internalHandler;
            if (internalHandler != null) {
                internalHandler.obtainMessage(11, (int) (j >> 32), (int) j, task).sendToTarget();
            }
        }
    }

    @Override // androidx.media3.common.util.BackgroundThreadStateHandler$StateChangeListener
    public void onStateChanged(Object obj, Object obj2) {
        RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) this.f$0;
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState2 = (StreamVolumeManager$StreamVolumeState) obj2;
        ExoPlayerImpl.ComponentListener componentListener = (ExoPlayerImpl.ComponentListener) rulerTrackingMap.values;
        boolean z = streamVolumeManager$StreamVolumeState.muted;
        int i = streamVolumeManager$StreamVolumeState.volume;
        if (!z && streamVolumeManager$StreamVolumeState2.muted) {
            rulerTrackingMap.size = i;
        }
        int i2 = streamVolumeManager$StreamVolumeState2.volume;
        boolean z2 = streamVolumeManager$StreamVolumeState2.muted;
        if (i != i2 || z != z2) {
            ExoPlayerImpl.this.listeners.sendEvent(30, new MediaSessionStub$$ExternalSyntheticLambda62(i2, z2));
        }
        if (streamVolumeManager$StreamVolumeState.streamType == streamVolumeManager$StreamVolumeState2.streamType && streamVolumeManager$StreamVolumeState.minVolume == streamVolumeManager$StreamVolumeState2.minVolume && streamVolumeManager$StreamVolumeState.maxVolume == streamVolumeManager$StreamVolumeState2.maxVolume) {
            return;
        }
        ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
        RulerTrackingMap rulerTrackingMap2 = exoPlayerImpl.streamVolumeManager;
        GapBuffer gapBuffer = new GapBuffer(0);
        gapBuffer.gapStart = rulerTrackingMap2 != null ? ((StreamVolumeManager$StreamVolumeState) ((RulerTrackingMap) rulerTrackingMap2.accessFlags).get()).minVolume : 0;
        gapBuffer.gapEnd = rulerTrackingMap2 != null ? ((StreamVolumeManager$StreamVolumeState) ((RulerTrackingMap) rulerTrackingMap2.accessFlags).get()).maxVolume : 0;
        DeviceInfo deviceInfoBuild = gapBuffer.build();
        if (deviceInfoBuild.equals(exoPlayerImpl.deviceInfo)) {
            return;
        }
        exoPlayerImpl.deviceInfo = deviceInfoBuild;
        exoPlayerImpl.listeners.sendEvent(29, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 9, (Object) deviceInfoBuild));
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 27:
                ConnectionState connectionState = (ConnectionState) obj;
                IMediaSession iMediaSession = connectionState.sessionBinder;
                SessionToken sessionToken = mediaControllerImplBase.token;
                MediaController mediaController = mediaControllerImplBase.instance;
                if (mediaControllerImplBase.iSession != null) {
                    Log.e("MCImplBase", "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                    mediaController.release();
                } else {
                    ImmutableList immutableList = connectionState.commandButtonsForMediaItems;
                    Bundle bundle = connectionState.sessionExtras;
                    mediaControllerImplBase.iSession = iMediaSession;
                    mediaControllerImplBase.playerInfo = connectionState.playerInfo;
                    mediaControllerImplBase.sessionActivity = connectionState.sessionActivity;
                    mediaControllerImplBase.sessionCommands = connectionState.sessionCommands;
                    Player.Commands commands = connectionState.playerCommandsFromSession;
                    mediaControllerImplBase.playerCommandsFromSession = commands;
                    Player.Commands commands2 = connectionState.playerCommandsFromPlayer;
                    mediaControllerImplBase.playerCommandsFromPlayer = commands2;
                    Player.Commands commandsCreateIntersectedCommandsWithControllerOverrides = mediaControllerImplBase.createIntersectedCommandsWithControllerOverrides(commands, commands2);
                    mediaControllerImplBase.intersectedPlayerCommands = commandsCreateIntersectedCommandsWithControllerOverrides;
                    ImmutableList immutableList2 = connectionState.customLayout;
                    mediaControllerImplBase.customLayoutOriginal = immutableList2;
                    ImmutableList immutableList3 = connectionState.mediaButtonPreferences;
                    mediaControllerImplBase.mediaButtonPreferencesOriginal = immutableList3;
                    RegularImmutableList regularImmutableListResolveMediaButtonPreferences = MediaControllerImplBase.resolveMediaButtonPreferences(immutableList3, immutableList2, mediaControllerImplBase.sessionCommands, commandsCreateIntersectedCommandsWithControllerOverrides, bundle);
                    mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences;
                    mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences, mediaControllerImplBase.customLayoutOriginal, connectionState.sessionExtras, mediaControllerImplBase.sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, connectionState.sessionInterfaceVersion);
                    StatusLine statusLine = new StatusLine(4);
                    for (int i = 0; i < immutableList.size(); i++) {
                        CommandButton commandButton = (CommandButton) immutableList.get(i);
                        SessionCommand sessionCommand = commandButton.sessionCommand;
                        if (sessionCommand != null && sessionCommand.commandCode == 0) {
                            statusLine.put(sessionCommand.customAction, commandButton);
                        }
                    }
                    statusLine.build(true);
                    MediaSession.Token platformToken = connectionState.platformToken;
                    if (platformToken == null) {
                        platformToken = sessionToken.impl.getPlatformToken();
                    }
                    if (platformToken != null) {
                        mediaControllerImplBase.platformController = new android.media.session.MediaController(mediaControllerImplBase.context, platformToken);
                    }
                    try {
                        iMediaSession.asBinder().linkToDeath(mediaControllerImplBase.deathRecipient, 0);
                        mediaControllerImplBase.connectedToken = new SessionToken(sessionToken.impl.getUid(), connectionState.libraryVersion, connectionState.sessionInterfaceVersion, sessionToken.impl.getPackageName(), connectionState.sessionBinder, connectionState.tokenExtras, platformToken);
                        mediaControllerImplBase.sessionExtras = bundle;
                        mediaController.notifyAccepted();
                    } catch (RemoteException unused) {
                        mediaController.release();
                        return;
                    }
                }
                break;
            case 28:
                SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) obj;
                if (mediaControllerImplBase.isConnected() && mediaControllerImplBase.pendingMaskingSequencedFutureNumbers.isEmpty()) {
                    SessionPositionInfo sessionPositionInfo2 = mediaControllerImplBase.playerInfo.sessionPositionInfo;
                    if (sessionPositionInfo2.eventTimeMs < sessionPositionInfo.eventTimeMs && MediaUtils.areSessionPositionInfosInSamePeriodOrAd(sessionPositionInfo, sessionPositionInfo2)) {
                        mediaControllerImplBase.playerInfo = mediaControllerImplBase.playerInfo.copyWithSessionPositionInfo(sessionPositionInfo);
                        break;
                    }
                }
                break;
            default:
                PendingIntent pendingIntent = (PendingIntent) obj;
                if (mediaControllerImplBase.isConnected() && !Objects.equals(mediaControllerImplBase.sessionActivity, pendingIntent)) {
                    mediaControllerImplBase.sessionActivity = pendingIntent;
                    MediaController mediaController2 = mediaControllerImplBase.instance;
                    mediaController2.getClass();
                    UtilsKt.checkState(Looper.myLooper() == mediaController2.applicationHandler.getLooper());
                    mediaController2.listener.getClass();
                    break;
                }
                break;
        }
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker$SeekTimestampConverter
    public long timeUsToTargetTime(long j) {
        FlacStreamMetadata flacStreamMetadata = (FlacStreamMetadata) this.f$0;
        return Util.constrainValue((j * ((long) flacStreamMetadata.sampleRate)) / 1000000, 0L, flacStreamMetadata.totalSamples - 1);
    }

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(AnalyticsListener.EventTime eventTime, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    public /* synthetic */ OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(AnalyticsListener.EventTime eventTime, Object obj, long j) {
        this.$r8$classId = (byte) 13;
        this.f$0 = obj;
    }
}
