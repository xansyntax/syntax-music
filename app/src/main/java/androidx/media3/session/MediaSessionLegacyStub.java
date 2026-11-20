package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.VolumeProvider;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import androidx.appcompat.app.AlertController;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.DisplayCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import androidx.media3.extractor.mp4.BoxParser;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionLegacyStub$3$$ExternalSyntheticLambda0;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.RatingCompat;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.FastFallbackExchangeFinder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionLegacyStub extends MediaSessionCompat$Callback {
    public static final int PENDING_INTENT_FLAG_MUTABLE;
    public final AndroidAutoConnectionStateObserver androidAutoObserver;
    public Player.Commands availablePlayerCommands;
    public SessionCommands availableSessionCommands;
    public final ComponentName broadcastReceiverComponentName;
    public final Dispatcher connectedControllersManager;
    public final AlertController.ButtonHandler connectionTimeoutHandler;
    public volatile int connectionTimeoutMs;
    public final FastFallbackExchangeFinder controllerLegacyCbForBroadcast;
    public ImmutableList customLayout;
    public BoxParser.StsdData legacyError;
    public final Bundle legacyExtras;
    public final boolean mayNeedButtonReservationWorkaroundForSeekbar;
    public ImmutableList mediaButtonPreferences;
    public FastFallbackExchangeFinder pendingBitmapLoadCallback;
    public final boolean playIfSuppressed;
    public final NetworkTypeObserver.Receiver runtimeBroadcastReceiver;
    public final CallbackWrapper sessionCompat;
    public int sessionFlags;
    public final MediaLibrarySessionImpl sessionImpl;
    public final MediaBrowserCompat sessionManager;
    public AnonymousClass3 volumeProviderCompat;

    /* JADX INFO: renamed from: androidx.media3.session.MediaSessionLegacyStub$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 {
        public final String controlId;
        public final int controlType;
        public int currentVolume;
        public final int maxVolume;
        public final /* synthetic */ Handler val$handler;
        public final /* synthetic */ PlayerWrapper val$player;
        public VolumeProvider volumeProviderFwk;

        public AnonymousClass3(int i, int i2, int i3, String str, Handler handler, PlayerWrapper playerWrapper) {
            this.val$handler = handler;
            this.val$player = playerWrapper;
            this.controlType = i;
            this.maxVolume = i2;
            this.currentVolume = i3;
            this.controlId = str;
        }

        public final VolumeProvider getVolumeProvider() {
            final AnonymousClass3 anonymousClass3;
            if (this.volumeProviderFwk != null) {
                anonymousClass3 = this;
            } else if (Build.VERSION.SDK_INT >= 30) {
                final int i = this.currentVolume;
                final String str = this.controlId;
                final int i2 = this.controlType;
                final int i3 = this.maxVolume;
                anonymousClass3 = this;
                anonymousClass3.volumeProviderFwk = new VolumeProvider(i2, i3, i, str) { // from class: androidx.media3.session.legacy.VolumeProviderCompat$1
                    @Override // android.media.VolumeProvider
                    public final void onAdjustVolume(int i4) {
                        MediaSessionLegacyStub.AnonymousClass3 anonymousClass4 = this.this$0;
                        Util.postOrRun(anonymousClass4.val$handler, new MediaSessionLegacyStub$3$$ExternalSyntheticLambda0(anonymousClass4.val$player, i4, (byte) 1));
                    }

                    @Override // android.media.VolumeProvider
                    public final void onSetVolumeTo(int i4) {
                        MediaSessionLegacyStub.AnonymousClass3 anonymousClass4 = this.this$0;
                        Util.postOrRun(anonymousClass4.val$handler, new MediaSessionLegacyStub$3$$ExternalSyntheticLambda0(anonymousClass4.val$player, i4, (byte) 0));
                    }
                };
            } else {
                anonymousClass3 = this;
                final int i4 = anonymousClass3.maxVolume;
                final int i5 = anonymousClass3.currentVolume;
                final int i6 = anonymousClass3.controlType;
                anonymousClass3.volumeProviderFwk = new VolumeProvider(i6, i4, i5) { // from class: androidx.media3.session.legacy.VolumeProviderCompat$2
                    @Override // android.media.VolumeProvider
                    public final void onAdjustVolume(int i7) {
                        MediaSessionLegacyStub.AnonymousClass3 anonymousClass4 = this.this$0;
                        Util.postOrRun(anonymousClass4.val$handler, new MediaSessionLegacyStub$3$$ExternalSyntheticLambda0(anonymousClass4.val$player, i7, (byte) 1));
                    }

                    @Override // android.media.VolumeProvider
                    public final void onSetVolumeTo(int i7) {
                        MediaSessionLegacyStub.AnonymousClass3 anonymousClass4 = this.this$0;
                        Util.postOrRun(anonymousClass4.val$handler, new MediaSessionLegacyStub$3$$ExternalSyntheticLambda0(anonymousClass4.val$player, i7, (byte) 0));
                    }
                };
            }
            return anonymousClass3.volumeProviderFwk;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ControllerLegacyCb implements MediaSession$ControllerCb {
        public final MediaSessionManager$RemoteUserInfo remoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
            this.remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return Objects.equals(this.remoteUserInfo, ((ControllerLegacyCb) obj).remoteUserInfo);
        }

        public final int hashCode() {
            return Objects.hash(this.remoteUserInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SessionTask {
        void run(MediaSession$ControllerInfo mediaSession$ControllerInfo);
    }

    static {
        PENDING_INTENT_FLAG_MUTABLE = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0052  */
    public MediaSessionLegacyStub(MediaLibrarySessionImpl mediaLibrarySessionImpl, Uri uri, Handler handler, Bundle bundle, boolean z, ImmutableList immutableList, ImmutableList immutableList2, SessionCommands sessionCommands, Player.Commands commands, Bundle bundle2) {
        boolean z2;
        ComponentName componentName;
        ComponentName serviceComponentByAction;
        PendingIntent foregroundService;
        this.sessionImpl = mediaLibrarySessionImpl;
        this.playIfSuppressed = z;
        this.customLayout = immutableList;
        this.mediaButtonPreferences = immutableList2;
        this.availableSessionCommands = sessionCommands;
        this.availablePlayerCommands = commands;
        this.legacyExtras = new Bundle(bundle2);
        Context context = mediaLibrarySessionImpl.context;
        this.sessionManager = MediaBrowserCompat.getSessionManager(context);
        this.controllerLegacyCbForBroadcast = new FastFallbackExchangeFinder(this);
        Dispatcher dispatcher = new Dispatcher(mediaLibrarySessionImpl);
        this.connectedControllersManager = dispatcher;
        this.connectionTimeoutMs = 300000;
        this.connectionTimeoutHandler = new AlertController.ButtonHandler(mediaLibrarySessionImpl.applicationHandler.getLooper(), dispatcher);
        int i = Build.VERSION.SDK_INT;
        boolean z3 = true;
        byte b = 0;
        if (i < 33) {
            z2 = false;
        } else {
            String str = Util.DEVICE_DEBUG_INFO;
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                z2 = false;
            } else {
                String str2 = Build.MANUFACTURER;
                if (str2.equals("Google") || str2.equals("motorola") || str2.equals("vivo") || str2.equals("Sony") || str2.equals("Nothing") || str2.equals("unknown")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        this.mayNeedButtonReservationWorkaroundForSeekbar = z2;
        if (!immutableList2.isEmpty()) {
            updateCustomLayoutAndLegacyExtrasForMediaButtonPreferences();
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
        } else {
            if (!listQueryBroadcastReceivers.isEmpty()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(listQueryBroadcastReceivers.size(), "Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found ");
                throw null;
            }
            componentName = null;
        }
        this.broadcastReceiverComponentName = componentName;
        if (componentName == null || i < 31) {
            serviceComponentByAction = getServiceComponentByAction(context, "androidx.media3.session.MediaLibraryService");
            serviceComponentByAction = serviceComponentByAction == null ? getServiceComponentByAction(context, "androidx.media3.session.MediaSessionService") : serviceComponentByAction;
            if (serviceComponentByAction == null || serviceComponentByAction.equals(componentName)) {
                z3 = false;
            }
        } else {
            z3 = false;
            serviceComponentByAction = componentName;
        }
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", uri);
        if (serviceComponentByAction == null) {
            NetworkTypeObserver.Receiver receiver = new NetworkTypeObserver.Receiver((byte) 6, this);
            this.runtimeBroadcastReceiver = receiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            String scheme = uri.getScheme();
            String str3 = Util.DEVICE_DEBUG_INFO;
            intentFilter.addDataScheme(scheme);
            if (i < 33) {
                context.registerReceiver(receiver, intentFilter);
            } else {
                context.registerReceiver(receiver, intentFilter, 4);
            }
            intent2.setPackage(context.getPackageName());
            foregroundService = PendingIntent.getBroadcast(context, 0, intent2, PENDING_INTENT_FLAG_MUTABLE);
            serviceComponentByAction = new ComponentName(context, context.getClass());
        } else {
            intent2.setComponent(serviceComponentByAction);
            foregroundService = z3 ? PendingIntent.getForegroundService(context, 0, intent2, PENDING_INTENT_FLAG_MUTABLE) : PendingIntent.getBroadcast(context, 0, intent2, PENDING_INTENT_FLAG_MUTABLE);
            this.runtimeBroadcastReceiver = null;
        }
        CallbackWrapper callbackWrapper = new CallbackWrapper(context, TextUtils.join(".", new String[]{"androidx.media3.session.id", mediaLibrarySessionImpl.sessionId}), i >= 31 ? null : serviceComponentByAction, i < 31 ? foregroundService : null, bundle);
        this.sessionCompat = callbackWrapper;
        if (i >= 31 && componentName != null) {
            DisplayCompat.setMediaButtonBroadcastReceiver(callbackWrapper, componentName);
        }
        PendingIntent pendingIntent = mediaLibrarySessionImpl.sessionActivity;
        if (pendingIntent != null) {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setSessionActivity(pendingIntent);
        }
        callbackWrapper.setCallback(this, handler);
        this.androidAutoObserver = z2 ? new AndroidAutoConnectionStateObserver(context, new MediaSessionLegacyStub$$ExternalSyntheticLambda0(this, b)) : null;
    }

    public static MediaItem createMediaItemForMediaRequest(String str, Uri uri, String str2, Bundle bundle) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        builder.mediaId = str;
        EmojiProcessor emojiProcessor = new EmojiProcessor((byte) 20);
        emojiProcessor.mSpanFactory = uri;
        emojiProcessor.mMetadataRepo = str2;
        emojiProcessor.mGlyphChecker = bundle;
        builder.requestMetadata = new MediaItem.RequestMetadata(emojiProcessor);
        return builder.build();
    }

    public static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r23v2 */
    public final PlaybackStateCompat createPlaybackStateCompat(PlayerWrapper playerWrapper) {
        long j;
        ?? r23;
        int i;
        int iConvertToLegacyErrorCode;
        String message;
        Bundle bundle;
        long j2;
        int i2;
        long j3;
        BoxParser.StsdData stsdData = this.legacyError;
        Bundle bundle2 = this.legacyExtras;
        if (stsdData != null && stsdData.requiredSampleTransformation) {
            new Bundle((Bundle) stsdData.format).putAll(bundle2);
            ArrayList arrayList = new ArrayList();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i3 = stsdData.nalUnitLengthFieldLength;
            String str = (String) stsdData.trackEncryptionBoxes;
            str.getClass();
            return new PlaybackStateCompat(7, -1L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0L, i3, str, jElapsedRealtime, arrayList, -1L, (Bundle) stsdData.format);
        }
        PlaybackException playerError = playerWrapper.getPlayerError();
        int i4 = 1;
        boolean z = playerWrapper.isCommandAvailable(16) && !playerWrapper.isCurrentMediaItemLive();
        boolean z2 = playerError != null || Util.shouldShowPlayButton(playerWrapper, this.playIfSuppressed);
        PlaybackStateCompat playbackStateCompat = null;
        int i5 = 7;
        if (playerError == null) {
            ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
            if (playerWrapper.getPlayerError() == null) {
                int playbackState = playerWrapper.getPlaybackState();
                if (playbackState == 1) {
                    i5 = 0;
                } else if (playbackState != 2) {
                    if (playbackState != 3) {
                        if (playbackState != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(playbackState, "Unrecognized State: "));
                            return null;
                        }
                        i5 = 1;
                    } else if (z2) {
                        i5 = 2;
                    } else {
                        i5 = 3;
                    }
                } else if (z2) {
                    i5 = 2;
                } else {
                    i5 = 6;
                }
            }
        }
        int i6 = i5;
        Player.Commands commandsIntersect = MediaUtils.intersect(this.availablePlayerCommands, playerWrapper.getAvailableCommands());
        long j4 = 128;
        int i7 = 0;
        while (i7 < commandsIntersect.flags.flags.size()) {
            int i8 = commandsIntersect.flags.get(i7);
            if (i8 == i4) {
                j3 = z2 ? 516L : 514L;
            } else if (i8 == 2) {
                j3 = 16384;
            } else if (i8 == 3) {
                j3 = 1;
            } else if (i8 != 31) {
                switch (i8) {
                    case 5:
                        j3 = 256;
                        break;
                    case 6:
                    case 7:
                        j3 = 16;
                        break;
                    case 8:
                    case 9:
                        j3 = 32;
                        break;
                    case 10:
                        j3 = 4096;
                        break;
                    case 11:
                        j3 = 8;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        j3 = 64;
                        break;
                    case 13:
                        j3 = 4194304;
                        break;
                    case 14:
                        j3 = 2621440;
                        break;
                    case 15:
                        j3 = 262144;
                        break;
                    default:
                        j3 = 0;
                        break;
                }
            } else {
                j3 = 240640;
            }
            j4 |= j3;
            i7++;
            i4 = 1;
        }
        if (!this.mediaButtonPreferences.isEmpty() && CommandButton.containsButtonForSlot(2, this.customLayout)) {
            j4 &= -17;
        }
        if (!this.mediaButtonPreferences.isEmpty() && CommandButton.containsButtonForSlot(3, this.customLayout)) {
            j4 &= -33;
        }
        if (!z) {
            j4 &= -257;
        }
        long j5 = j4;
        if (playerWrapper.isCommandAvailable(17)) {
            int currentMediaItemIndex = playerWrapper.getCurrentMediaItemIndex();
            ImmutableSet immutableSet2 = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
            j = currentMediaItemIndex == -1 ? -1L : currentMediaItemIndex;
        } else {
            j = -1;
        }
        float f = playerWrapper.getPlaybackParameters().speed;
        float f2 = (playerWrapper.isPlaying() && z) ? f : 0.0f;
        Bundle bundle3 = playerError != null ? new Bundle(playerError.extras) : new Bundle();
        if (playerError == null && stsdData != null) {
            bundle3.putAll((Bundle) stsdData.format);
        }
        bundle3.putAll(bundle2);
        bundle3.putFloat("EXO_SPEED", f);
        MediaItem currentMediaItemWithCommandCheck = playerWrapper.getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck != null) {
            String str2 = currentMediaItemWithCommandCheck.mediaId;
            if (!"".equals(str2)) {
                bundle3.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", str2);
            }
        }
        long currentPosition = z ? playerWrapper.getCurrentPosition() : -1L;
        long bufferedPosition = z ? playerWrapper.getBufferedPosition() : -1L;
        ArrayList arrayList2 = new ArrayList();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        int i9 = 0;
        while (i9 < this.customLayout.size()) {
            CommandButton commandButton = (CommandButton) this.customLayout.get(i9);
            SessionCommand sessionCommand = commandButton.sessionCommand;
            Uri uri = commandButton.iconUri;
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            int i10 = commandButton.icon;
            Bundle bundle4 = commandButton.extras;
            int i11 = i9;
            if (sessionCommand != null) {
                Bundle bundle5 = sessionCommand.customExtras;
                bundle = bundle3;
                String str3 = sessionCommand.customAction;
                j2 = currentPosition;
                if (commandButton.isEnabled && sessionCommand.commandCode == 0) {
                    SessionCommands sessionCommands = this.availableSessionCommands;
                    if ((sessionCommand != null && sessionCommands.commands.contains(sessionCommand)) || (((i2 = commandButton.playerCommand) != -1 && commandsIntersect.contains(i2)) || CommandButton.isPredefinedCustomCommandButtonCode(str3))) {
                        boolean z3 = i10 != 0;
                        boolean z4 = uri != null;
                        if (z3 || z4 || !bundle4.isEmpty()) {
                            bundle5 = new Bundle(bundle5);
                        }
                        if (!bundle4.isEmpty()) {
                            bundle5.putAll(bundle4);
                        }
                        if (z3) {
                            bundle5.putInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", i10);
                        }
                        if (z4) {
                            uri.getClass();
                            bundle5.putString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT", uri.toString());
                        }
                        CharSequence charSequence = commandButton.displayName;
                        int i12 = commandButton.iconResId;
                        if (TextUtils.isEmpty(str3)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("You must specify an action to build a CustomAction");
                            return playbackStateCompat2;
                        }
                        if (TextUtils.isEmpty(charSequence)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("You must specify a name to build a CustomAction");
                            return playbackStateCompat2;
                        }
                        if (i12 == 0) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("You must specify an icon resource id to build a CustomAction");
                            return playbackStateCompat2;
                        }
                        arrayList2.add(new PlaybackStateCompat.CustomAction(str3, charSequence, i12, bundle5));
                    }
                }
            } else {
                bundle = bundle3;
                j2 = currentPosition;
            }
            i9 = i11 + 1;
            playbackStateCompat = playbackStateCompat2;
            bundle3 = bundle;
            currentPosition = j2;
        }
        Bundle bundle6 = bundle3;
        PlaybackStateCompat playbackStateCompat3 = playbackStateCompat;
        long j6 = currentPosition;
        if (playerError == null) {
            if (stsdData != null) {
                iConvertToLegacyErrorCode = stsdData.nalUnitLengthFieldLength;
                message = (String) stsdData.trackEncryptionBoxes;
            } else {
                r23 = playbackStateCompat3;
                i = 0;
            }
            return new PlaybackStateCompat(i6, j6, bufferedPosition, f2, j5, i, r23, jElapsedRealtime2, arrayList2, j, bundle6);
        }
        ImmutableSet immutableSet3 = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        iConvertToLegacyErrorCode = LegacyConversions.convertToLegacyErrorCode(playerError.errorCode);
        message = playerError.getMessage();
        i = iConvertToLegacyErrorCode;
        r23 = message;
        return new PlaybackStateCompat(i6, j6, bufferedPosition, f2, j5, i, r23, jElapsedRealtime2, arrayList2, j, bundle6);
    }

    public final void dispatchSessionTaskWithPlayerCommand(final int i, final SessionTask sessionTask, final MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, final boolean z) {
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.sessionImpl;
        if (mediaLibrarySessionImpl.isReleased()) {
            return;
        }
        if (mediaSessionManager$RemoteUserInfo != null) {
            Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.SessionTask sessionTask2 = sessionTask;
                    MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
                    MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaSessionLegacyStub.sessionImpl;
                    if (mediaLibrarySessionImpl2.isReleased()) {
                        return;
                    }
                    boolean zIsActive = ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).sessionFwk.isActive();
                    int i2 = i;
                    MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo2 = mediaSessionManager$RemoteUserInfo;
                    if (!zIsActive) {
                        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i2, "Ignore incoming player command before initialization. command=", ", pid=");
                        sbM2m.append(mediaSessionManager$RemoteUserInfo2.impl.pid);
                        Log.w("MediaSessionLegacyStub", sbM2m.toString());
                        return;
                    }
                    MediaSession$ControllerInfo mediaSession$ControllerInfoTryGetController = mediaSessionLegacyStub.tryGetController(mediaSessionManager$RemoteUserInfo2);
                    if (!mediaSessionLegacyStub.connectedControllersManager.isPlayerCommandAvailable(mediaSession$ControllerInfoTryGetController, i2)) {
                        if (i2 != 1 || mediaLibrarySessionImpl2.playerWrapper.getPlayWhenReady()) {
                            return;
                        }
                        Log.w("MediaSessionLegacyStub", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
                        return;
                    }
                    MediaLibrarySessionCallback mediaLibrarySessionCallback = mediaLibrarySessionImpl2.callback$1;
                    mediaLibrarySessionImpl2.resolveControllerInfoForCallback(mediaSession$ControllerInfoTryGetController);
                    mediaLibrarySessionCallback.getClass();
                    try {
                        sessionTask2.run(mediaSession$ControllerInfoTryGetController);
                    } catch (RemoteException e) {
                        Log.w("MediaSessionLegacyStub", "Exception in " + mediaSession$ControllerInfoTryGetController, e);
                    }
                    if (z) {
                        new SparseBooleanArray().append(i2, true);
                        mediaLibrarySessionImpl2.onPlayerInteractionFinishedOnHandler(mediaSession$ControllerInfoTryGetController);
                    }
                }
            });
            return;
        }
        Log.d("RemoteUserInfo is null, ignoring command=" + i);
    }

    public final void dispatchSessionTaskWithSessionCommandInternal(final SessionCommand sessionCommand, final int i, final SessionTask sessionTask, final MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        Object objValueOf;
        if (mediaSessionManager$RemoteUserInfo != null) {
            Util.postOrRun(this.sessionImpl.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.SessionTask sessionTask2 = sessionTask;
                    MediaSessionLegacyStub mediaSessionLegacyStub = this.f$0;
                    if (mediaSessionLegacyStub.sessionImpl.isReleased()) {
                        return;
                    }
                    boolean zIsActive = ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).sessionFwk.isActive();
                    SessionCommand sessionCommand2 = sessionCommand;
                    char c = i;
                    MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo2 = mediaSessionManager$RemoteUserInfo;
                    if (!zIsActive) {
                        StringBuilder sb = new StringBuilder("Ignore incoming session command before initialization. command=");
                        sb.append(sessionCommand2 == null ? Integer.valueOf(c) : sessionCommand2.customAction);
                        sb.append(", pid=");
                        sb.append(mediaSessionManager$RemoteUserInfo2.impl.pid);
                        Log.w("MediaSessionLegacyStub", sb.toString());
                        return;
                    }
                    MediaSession$ControllerInfo mediaSession$ControllerInfoTryGetController = mediaSessionLegacyStub.tryGetController(mediaSessionManager$RemoteUserInfo2);
                    Dispatcher dispatcher = mediaSessionLegacyStub.connectedControllersManager;
                    if (sessionCommand2 != null) {
                        if (!dispatcher.isSessionCommandAvailable(mediaSession$ControllerInfoTryGetController, sessionCommand2)) {
                            return;
                        }
                    } else if (!dispatcher.isSessionCommandAvailable(mediaSession$ControllerInfoTryGetController, c)) {
                        return;
                    }
                    try {
                        sessionTask2.run(mediaSession$ControllerInfoTryGetController);
                    } catch (RemoteException e) {
                        Log.w("MediaSessionLegacyStub", "Exception in " + mediaSession$ControllerInfoTryGetController, e);
                    }
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
        if (sessionCommand == null) {
            objValueOf = sessionCommand;
            objValueOf = Integer.valueOf(i);
        }
        objValueOf = sessionCommand;
        sb.append(objValueOf);
        Log.d(sb.toString());
    }

    public final void handleMediaRequest(MediaItem mediaItem, boolean z, boolean z2) {
        dispatchSessionTaskWithPlayerCommand(31, new MediaSessionImpl$$ExternalSyntheticLambda16(this, mediaItem, z, z2), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        if (mediaDescriptionCompat != null) {
            if (i == -1 || i >= 0) {
                dispatchSessionTaskWithPlayerCommand(20, new ExoPlayerImpl$$ExternalSyntheticLambda5((Object) this, (Object) mediaDescriptionCompat, i, (byte) 4), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), false);
            }
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (str.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN") && resultReceiver != null) {
            resultReceiver.send(0, this.sessionImpl.sessionToken.toBundle());
        } else {
            SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
            dispatchSessionTaskWithSessionCommandInternal(sessionCommand, 0, new MediaSessionLegacyStub$$ExternalSyntheticLambda24(this, sessionCommand, bundle, resultReceiver), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo());
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onCustomAction(String str, Bundle bundle) {
        boolean zBooleanValue;
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        SessionCommand sessionCommand = new SessionCommand(str, bundle);
        boolean zIsPredefinedCustomCommandButtonCode = CommandButton.isPredefinedCustomCommandButtonCode(str);
        CallbackWrapper callbackWrapper = this.sessionCompat;
        if (!zIsPredefinedCustomCommandButtonCode) {
            dispatchSessionTaskWithSessionCommandInternal(sessionCommand, 0, new MediaSessionStub$$ExternalSyntheticLambda81(this, sessionCommand, bundle, (byte) 3), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo());
            return;
        }
        try {
            CommandButton commandButtonConvertFromPredefinedCustomCommand = CommandButton.convertFromPredefinedCustomCommand(sessionCommand);
            int i = commandButtonConvertFromPredefinedCustomCommand.playerCommand;
            Object obj = commandButtonConvertFromPredefinedCustomCommand.parameter;
            if (!commandButtonConvertFromPredefinedCustomCommand.canExecuteAction()) {
                Log.w("MediaSessionLegacyStub", "Can't execute predefined custom command: ".concat(str));
                return;
            }
            SessionCommand sessionCommand2 = commandButtonConvertFromPredefinedCustomCommand.sessionCommand;
            if (sessionCommand2 != null) {
                UtilsKt.checkState(sessionCommand2.commandCode == 40010);
                obj.getClass();
                dispatchSessionTaskWithSessionCommandInternal(null, 40010, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (Rating) obj), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo());
                return;
            }
            PlayerWrapper playerWrapper = this.sessionImpl.playerWrapper;
            if (i != 1) {
                zBooleanValue = false;
            } else if (obj != null) {
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else if (playerWrapper.getPlayWhenReady()) {
                zBooleanValue = false;
            } else {
                zBooleanValue = true;
            }
            if (zBooleanValue) {
                dispatchSessionTaskWithPlayerCommand(1, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 6), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), false);
            } else if (i != 31) {
                dispatchSessionTaskWithPlayerCommand(i, new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) commandButtonConvertFromPredefinedCustomCommand, (byte) 16), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), true);
            } else {
                obj.getClass();
                handleMediaRequest((MediaItem) obj, false, false);
            }
        } catch (RuntimeException e) {
            Log.w("MediaSessionLegacyStub", "Failed to convert predefined custom command: " + sessionCommand.customAction, e);
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onFastForward() {
        dispatchSessionTaskWithPlayerCommand(12, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 10), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        MediaSessionManager$RemoteUserInfo currentControllerInfo = ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo();
        currentControllerInfo.getClass();
        return this.sessionImpl.onMediaButtonEvent(new MediaSession$ControllerInfo(currentControllerInfo, 0, 0, false, null, Bundle.EMPTY), intent);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPause() {
        dispatchSessionTaskWithPlayerCommand(1, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 11), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPlay() {
        dispatchSessionTaskWithPlayerCommand(1, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 6), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), true, true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), true, true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), true, true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPrepare() {
        dispatchSessionTaskWithPlayerCommand(2, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 7), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), true, false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), true, false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), true, false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) mediaDescriptionCompat, (byte) 17), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onRewind() {
        dispatchSessionTaskWithPlayerCommand(11, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 5), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSeekTo(long j) {
        dispatchSessionTaskWithPlayerCommand(5, new MediaSessionLegacyStub$$ExternalSyntheticLambda6(this, j, (byte) 0), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSetPlaybackSpeed(float f) {
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(13, new MediaSessionLegacyStub$$ExternalSyntheticLambda10(this, f, (byte) 0), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSetRating(RatingCompat ratingCompat) {
        onSetRating$1(ratingCompat);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSetRating$1(RatingCompat ratingCompat) {
        Rating ratingConvertToRating = LegacyConversions.convertToRating(ratingCompat);
        if (ratingConvertToRating != null) {
            dispatchSessionTaskWithSessionCommandInternal(null, 40010, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, ratingConvertToRating), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo());
            return;
        }
        Log.w("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + ratingCompat);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSetRepeatMode(int i) {
        dispatchSessionTaskWithPlayerCommand(15, new MediaSessionLegacyStub$$ExternalSyntheticLambda7(this, i, (byte) 1), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSetShuffleMode(int i) {
        dispatchSessionTaskWithPlayerCommand(14, new MediaSessionLegacyStub$$ExternalSyntheticLambda7(this, i, (byte) 0), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSkipToNext() {
        boolean zIsCommandAvailable = this.sessionImpl.playerWrapper.isCommandAvailable(9);
        CallbackWrapper callbackWrapper = this.sessionCompat;
        if (zIsCommandAvailable) {
            dispatchSessionTaskWithPlayerCommand(9, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 0), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), true);
        } else {
            dispatchSessionTaskWithPlayerCommand(8, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 9), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), true);
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSkipToPrevious() {
        boolean zIsCommandAvailable = this.sessionImpl.playerWrapper.isCommandAvailable(7);
        CallbackWrapper callbackWrapper = this.sessionCompat;
        if (zIsCommandAvailable) {
            dispatchSessionTaskWithPlayerCommand(7, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 3), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), true);
        } else {
            dispatchSessionTaskWithPlayerCommand(6, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 4), ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).getCurrentControllerInfo(), true);
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onSkipToQueueItem(long j) {
        if (j < 0) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(10, new MediaSessionLegacyStub$$ExternalSyntheticLambda6(this, j, (byte) 1), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onStop() {
        dispatchSessionTaskWithPlayerCommand(3, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(this, (byte) 8), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), true);
    }

    public final MediaSession$ControllerInfo tryGetController(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        MediaSession$ControllerInfo controller = this.connectedControllersManager.getController(mediaSessionManager$RemoteUserInfo);
        if (controller == null) {
            MediaSession$ControllerInfo mediaSession$ControllerInfo = new MediaSession$ControllerInfo(mediaSessionManager$RemoteUserInfo, 0, 0, this.sessionManager.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfo), new ControllerLegacyCb(mediaSessionManager$RemoteUserInfo), Bundle.EMPTY);
            MediaSession$ConnectionResult mediaSession$ConnectionResultOnConnectOnHandler = this.sessionImpl.onConnectOnHandler(mediaSession$ControllerInfo);
            this.connectedControllersManager.addController(mediaSessionManager$RemoteUserInfo, mediaSession$ControllerInfo, mediaSession$ConnectionResultOnConnectOnHandler.availableSessionCommands, mediaSession$ConnectionResultOnConnectOnHandler.availablePlayerCommands);
            MediaLibrarySessionImpl mediaLibrarySessionImpl = this.sessionImpl;
            if (!mediaLibrarySessionImpl.isMediaNotificationControllerConnected || !MediaLibrarySessionImpl.isSystemUiController(mediaSession$ControllerInfo)) {
                mediaLibrarySessionImpl.callback$1.getClass();
            }
            controller = mediaSession$ControllerInfo;
        }
        AlertController.ButtonHandler buttonHandler = this.connectionTimeoutHandler;
        long j = this.connectionTimeoutMs;
        buttonHandler.removeMessages(1001, controller);
        buttonHandler.sendMessageDelayed(buttonHandler.obtainMessage(1001, controller), j);
        return controller;
    }

    public final void updateCustomLayoutAndLegacyExtrasForMediaButtonPreferences() {
        AndroidAutoConnectionStateObserver androidAutoConnectionStateObserver;
        this.customLayout = CommandButton.getCustomLayoutFromMediaButtonPreferences(CommandButton.copyWithUnavailableButtonsDisabled(this.mediaButtonPreferences, this.availableSessionCommands, this.availablePlayerCommands), true, true, 9);
        boolean z = this.mayNeedButtonReservationWorkaroundForSeekbar;
        Bundle bundle = this.legacyExtras;
        if (z && ((androidAutoConnectionStateObserver = this.androidAutoObserver) == null || !androidAutoConnectionStateObserver.isConnected.get())) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", (this.customLayout.isEmpty() || CommandButton.containsButtonForSlot(2, this.customLayout)) ? false : true);
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        } else {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", !CommandButton.containsButtonForSlot(2, this.customLayout));
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", !CommandButton.containsButtonForSlot(3, this.customLayout));
        }
    }

    public final void updateCustomLayoutAndLegacyExtrasForMediaButtonPreferencesAndInformExtrasChanged() {
        Bundle bundle = this.legacyExtras;
        boolean z = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
        boolean z2 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        updateCustomLayoutAndLegacyExtrasForMediaButtonPreferences();
        if (bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) == z && bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) == z2) {
            return;
        }
        ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).sessionFwk.setExtras(bundle);
    }

    public final void updateLegacySessionPlaybackState(PlayerWrapper playerWrapper) {
        Util.postOrRun(this.sessionImpl.applicationHandler, new MediaSessionLegacyStub$$ExternalSyntheticLambda5(this, playerWrapper, (byte) 0));
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat$Callback
    public final void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat != null) {
            dispatchSessionTaskWithPlayerCommand(20, new ExoPlayerImpl$$ExternalSyntheticLambda5((Object) this, (Object) mediaDescriptionCompat, -1, (byte) 4), ((MediaSessionCompat$MediaSessionImplApi23) this.sessionCompat.mCallback).getCurrentControllerInfo(), false);
        }
    }
}
