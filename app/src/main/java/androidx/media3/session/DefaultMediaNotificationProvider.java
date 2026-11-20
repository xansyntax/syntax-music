package androidx.media3.session;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityRecreator;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.mp4.BoxParser;
import androidx.navigation.NavDeepLinkRequest;
import coil3.util.UtilsKt;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.primitives.ImmutableIntArray;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.uuid.UuidKt;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultMediaNotificationProvider implements MediaNotification$Provider {
    public static final Supplier maxNotificationIconSize = DatabaseDao_Impl.AnonymousClass17.memoize(new MediaSessionImpl$$ExternalSyntheticLambda15(5));
    public final String channelId;
    public final int channelNameResourceId;
    public final Context context;
    public BitmapLoader mediaSessionBitmapLoader;
    public CallbackWrapper notificationIconBitmapLoader;
    public final NotificationIdProvider notificationIdProvider;
    public final NotificationManager notificationManager;
    public BoxParser.StsdData pendingOnBitmapLoadedFutureCallback;
    public int smallIconResourceId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface NotificationIdProvider {
        int getNotificationId(MediaLibraryService.MediaLibrarySession mediaLibrarySession);
    }

    public DefaultMediaNotificationProvider(Context context, NotificationIdProvider notificationIdProvider, String str, int i) {
        this.context = context;
        this.notificationIdProvider = notificationIdProvider;
        this.channelId = str;
        this.channelNameResourceId = i;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.getClass();
        this.notificationManager = notificationManager;
        this.smallIconResourceId = R.drawable.media3_notification_small_icon;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x02de  */
    /* JADX WARN: Code duplicated, block: B:113:0x0306  */
    /* JADX WARN: Code duplicated, block: B:116:0x032c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0330  */
    /* JADX WARN: Code duplicated, block: B:122:0x0342  */
    /* JADX WARN: Code duplicated, block: B:127:0x0360  */
    /* JADX WARN: Code duplicated, block: B:128:0x0380  */
    /* JADX WARN: Code duplicated, block: B:138:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:141:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:142:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:148:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:151:0x0339 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.media3.session.MediaNotification$Provider
    public final PriorityQueue createNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession, ImmutableList immutableList, DefaultActionFactory defaultActionFactory, MediaNotification$Provider.Callback callback) {
        int i;
        DefaultMediaNotificationProvider defaultMediaNotificationProvider;
        int i2;
        MediaLibrarySessionImpl mediaLibrarySessionImpl;
        NotificationCompat$Builder notificationCompat$Builder;
        long jCurrentTimeMillis;
        boolean z;
        BitmapLoader bitmapLoader;
        ListenableFuture listenableFutureLoadBitmapFromMetadata;
        BoxParser.StsdData stsdData;
        int i3;
        int i4 = this.channelNameResourceId;
        Context context = this.context;
        String string = context.getString(i4);
        String str = Util.DEVICE_DEBUG_INFO;
        NotificationManager notificationManager = this.notificationManager;
        String str2 = this.channelId;
        if (notificationManager.getNotificationChannel(str2) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str2, string, 2);
            if (Build.VERSION.SDK_INT <= 27) {
                notificationChannel.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Player player = mediaLibrarySession.getPlayer();
        NotificationCompat$Builder notificationCompat$Builder2 = new NotificationCompat$Builder(context, str2);
        int notificationId = this.notificationIdProvider.getNotificationId(mediaLibrarySession);
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(mediaLibrarySession);
        Player.Commands availableCommands = player.getAvailableCommands();
        MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibrarySession.impl;
        boolean z2 = mediaLibrarySessionImpl2.playIfSuppressed;
        String str3 = mediaLibrarySessionImpl2.sessionId;
        boolean zShouldShowPlayButton = Util.shouldShowPlayButton(player, z2);
        int i5 = 1;
        RegularImmutableList customLayoutFromMediaButtonPreferences = CommandButton.getCustomLayoutFromMediaButtonPreferences(immutableList, true, true, 9);
        boolean zContainsButtonForSlot = CommandButton.containsButtonForSlot(2, customLayoutFromMediaButtonPreferences);
        boolean zContainsButtonForSlot2 = CommandButton.containsButtonForSlot(3, customLayoutFromMediaButtonPreferences);
        ImmutableList.Builder builder = new ImmutableList.Builder(4);
        if (zContainsButtonForSlot) {
            builder.add(customLayoutFromMediaButtonPreferences.get(0));
            i = 1;
        } else {
            if (availableCommands.flags.containsAny(7, 6)) {
                CommandButton.Builder builder2 = new CommandButton.Builder(57413);
                builder2.setPlayerCommand(6);
                builder2.displayName = context.getString(R.string.media3_controls_seek_to_previous_description);
                builder.add((Object) builder2.build());
            }
            i5 = 0;
            i = 1;
        }
        if (availableCommands.contains(i)) {
            if (zShouldShowPlayButton) {
                CommandButton.Builder builder3 = new CommandButton.Builder(57399);
                builder3.setPlayerCommand(i);
                builder3.displayName = context.getString(R.string.media3_controls_play_description);
                builder.add((Object) builder3.build());
            } else {
                CommandButton.Builder builder4 = new CommandButton.Builder(57396);
                builder4.setPlayerCommand(i);
                builder4.displayName = context.getString(R.string.media3_controls_pause_description);
                builder.add((Object) builder4.build());
            }
        }
        if (zContainsButtonForSlot2) {
            builder.add(customLayoutFromMediaButtonPreferences.get(i5));
            i5++;
        } else if (availableCommands.flags.containsAny(9, 8)) {
            CommandButton.Builder builder5 = new CommandButton.Builder(57412);
            builder5.setPlayerCommand(8);
            builder5.displayName = context.getString(R.string.media3_controls_seek_to_next_description);
            builder.add((Object) builder5.build());
        }
        while (i5 < customLayoutFromMediaButtonPreferences.size) {
            builder.add(customLayoutFromMediaButtonPreferences.get(i5));
            i5++;
        }
        RegularImmutableList regularImmutableListBuild = builder.build();
        int[] iArrCopyOf = new int[3];
        int[] iArr = new int[3];
        Arrays.fill(iArrCopyOf, -1);
        Arrays.fill(iArr, -1);
        int i6 = 0;
        boolean z3 = false;
        while (i6 < regularImmutableListBuild.size) {
            CommandButton commandButton = (CommandButton) regularImmutableListBuild.get(i6);
            SessionCommand sessionCommand = commandButton.sessionCommand;
            RegularImmutableList regularImmutableList = regularImmutableListBuild;
            int i7 = commandButton.playerCommand;
            Context context2 = context;
            CharSequence charSequence = commandButton.displayName;
            int[] iArr2 = iArr;
            int i8 = commandButton.iconResId;
            int i9 = i6;
            ImmutableIntArray immutableIntArray = commandButton.slots;
            boolean z4 = z3;
            ArrayList arrayList = notificationCompat$Builder2.mActions;
            if (sessionCommand != null) {
                int i10 = sessionCommand.commandCode;
                MediaSessionService mediaSessionService = defaultActionFactory.service;
                UtilsKt.checkArgument(i10 == 0);
                PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
                IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(mediaSessionService.getResources(), mediaSessionService.getPackageName(), i8);
                Class<?> cls = mediaSessionService.getClass();
                UtilsKt.checkArgument(i10 == 0);
                int iNextInt = ThreadLocalRandom.current().nextInt();
                UtilsKt.checkArgument(i10 == 0);
                Intent intent = new Intent("androidx.media3.session.CUSTOM_NOTIFICATION_ACTION");
                intent.setData(MediaLibrarySessionImpl.createSessionUri(str3));
                intent.setComponent(new ComponentName(mediaSessionService, cls));
                intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION", sessionCommand.customAction);
                intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS", sessionCommand.customExtras);
                arrayList.add(new NotificationCompat$Action(iconCompatCreateWithResource, charSequence, PendingIntent.getService(mediaSessionService, iNextInt, intent, 201326592)));
            } else {
                UtilsKt.checkState(i7 != -1);
                PorterDuff.Mode mode2 = IconCompat.DEFAULT_TINT_MODE;
                IconCompat iconCompatCreateWithResource2 = IconCompat.createWithResource(context2.getResources(), context2.getPackageName(), i8);
                MediaSessionService mediaSessionService2 = defaultActionFactory.service;
                Class<?> cls2 = mediaSessionService2.getClass();
                if (i7 == 1) {
                    i3 = 85;
                } else if (i7 == 3) {
                    i3 = 86;
                } else if (i7 == 11) {
                    i3 = 89;
                } else if (i7 != 12) {
                    switch (i7) {
                        case 6:
                        case 7:
                            i3 = 88;
                            break;
                        case 8:
                        case 9:
                            i3 = 87;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                } else {
                    i3 = 90;
                }
                UtilsKt.checkArgument(UtilsKt.isSupportedKeyCode(i3));
                Bundle bundle = Bundle.EMPTY;
                arrayList.add(new NotificationCompat$Action(iconCompatCreateWithResource2, charSequence, (mediaLibrarySession.getPlayer().getPlayWhenReady() || i7 != 1) ? PendingIntent.getService(mediaSessionService2, i3, UtilsKt.createMediaButtonIntentInternal(mediaSessionService2, i3, bundle, str3, cls2), 201326592) : PendingIntent.getForegroundService(mediaSessionService2, i3, UtilsKt.createMediaButtonIntentInternal(mediaSessionService2, i3, bundle, str3, cls2), 201326592)));
            }
            int i11 = commandButton.extras.getInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
            if (i11 < 0 || i11 >= 3) {
                if (immutableIntArray.get(0) == 2) {
                    iArr2[0] = i9;
                } else {
                    if (immutableIntArray.get(0) == 1) {
                        iArr2[1] = i9;
                    } else if (immutableIntArray.get(0) == 3) {
                        iArr2[2] = i9;
                    }
                    z3 = z4;
                }
                z3 = z4;
            } else {
                iArrCopyOf[i11] = i9;
                z3 = true;
            }
            i6 = i9 + 1;
            regularImmutableListBuild = regularImmutableList;
            context = context2;
            iArr = iArr2;
            notificationId = notificationId;
            mediaLibrarySessionImpl2 = mediaLibrarySessionImpl2;
            notificationCompat$Builder2 = notificationCompat$Builder2;
            player = player;
        }
        Player player2 = player;
        NotificationCompat$Builder notificationCompat$Builder3 = notificationCompat$Builder2;
        int i12 = notificationId;
        int[] iArr3 = iArr;
        MediaLibrarySessionImpl mediaLibrarySessionImpl3 = mediaLibrarySessionImpl2;
        if (!z3) {
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 3; i13 < i15; i15 = 3) {
                int i16 = iArr3[i13];
                if (i16 != -1) {
                    iArrCopyOf[i14] = i16;
                    i14++;
                }
                i13++;
            }
        }
        for (int i17 = 0; i17 < 3; i17++) {
            if (iArrCopyOf[i17] == -1) {
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i17);
                navDeepLinkRequest.mimeType = iArrCopyOf;
                if (player2.isCommandAvailable(18)) {
                    MediaMetadata mediaMetadata = player2.getMediaMetadata();
                    notificationCompat$Builder = notificationCompat$Builder3;
                    notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(mediaMetadata.title);
                    notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(mediaMetadata.artist);
                    mediaLibrarySessionImpl = mediaLibrarySessionImpl3;
                    bitmapLoader = mediaLibrarySessionImpl.bitmapLoader;
                    defaultMediaNotificationProvider = this;
                    if (defaultMediaNotificationProvider.notificationIconBitmapLoader != null || !bitmapLoader.equals(defaultMediaNotificationProvider.mediaSessionBitmapLoader)) {
                        defaultMediaNotificationProvider.mediaSessionBitmapLoader = bitmapLoader;
                        defaultMediaNotificationProvider.notificationIconBitmapLoader = new CallbackWrapper((byte) 26, (Object) new PriorityQueue((Object) bitmapLoader, ((Integer) maxNotificationIconSize.get()).intValue(), (byte) 9));
                    }
                    listenableFutureLoadBitmapFromMetadata = defaultMediaNotificationProvider.notificationIconBitmapLoader.loadBitmapFromMetadata(mediaMetadata);
                    if (listenableFutureLoadBitmapFromMetadata == null) {
                        i2 = i12;
                    } else {
                        stsdData = defaultMediaNotificationProvider.pendingOnBitmapLoadedFutureCallback;
                        if (stsdData != null) {
                            stsdData.requiredSampleTransformation = true;
                        }
                        if (listenableFutureLoadBitmapFromMetadata.isDone()) {
                            try {
                                notificationCompat$Builder.setLargeIcon((Bitmap) UuidKt.getDone(listenableFutureLoadBitmapFromMetadata));
                            } catch (CancellationException | ExecutionException e) {
                                Log.w("NotificationProvider", "Failed to load bitmap: " + e.getMessage());
                            }
                            i2 = i12;
                        } else {
                            i2 = i12;
                            BoxParser.StsdData stsdData2 = new BoxParser.StsdData(i2, notificationCompat$Builder, callback);
                            defaultMediaNotificationProvider.pendingOnBitmapLoadedFutureCallback = stsdData2;
                            Handler handler = mediaLibrarySessionImpl.applicationHandler;
                            Objects.requireNonNull(handler);
                            listenableFutureLoadBitmapFromMetadata.addListener(new ActivityRecreator.AnonymousClass1(listenableFutureLoadBitmapFromMetadata, stsdData2, (byte) 1), new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler, (byte) 0));
                        }
                    }
                } else {
                    defaultMediaNotificationProvider = this;
                    i2 = i12;
                    mediaLibrarySessionImpl = mediaLibrarySessionImpl3;
                    notificationCompat$Builder = notificationCompat$Builder3;
                }
                if (player2.isPlaying() || player2.isPlayingAd() || player2.isCurrentMediaItemDynamic() || player2.getPlaybackParameters().speed != 1.0f) {
                    jCurrentTimeMillis = -9223372036854775807L;
                } else {
                    jCurrentTimeMillis = System.currentTimeMillis() - player2.getContentPosition();
                }
                if (jCurrentTimeMillis != -9223372036854775807L) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    jCurrentTimeMillis = 0;
                }
                Notification notification = notificationCompat$Builder.mNotification;
                notification.when = jCurrentTimeMillis;
                notificationCompat$Builder.mShowWhen = z;
                notificationCompat$Builder.mUseChronometer = z;
                if (Build.VERSION.SDK_INT >= 31) {
                    notificationCompat$Builder.mFgsDeferBehavior = (byte) 1;
                }
                notificationCompat$Builder.mContentIntent = mediaLibrarySessionImpl.sessionActivity;
                defaultActionFactory.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", true);
                MediaSessionService mediaSessionService3 = defaultActionFactory.service;
                Class<?> cls3 = mediaSessionService3.getClass();
                UtilsKt.checkArgument(UtilsKt.isSupportedKeyCode(86));
                Bundle bundle3 = Bundle.EMPTY;
                notification.deleteIntent = PendingIntent.getService(mediaSessionService3, 86, UtilsKt.createMediaButtonIntentInternal(mediaSessionService3, 86, bundle2, str3, cls3), 201326592);
                notificationCompat$Builder.setFlag(8, true);
                notification.icon = defaultMediaNotificationProvider.smallIconResourceId;
                notificationCompat$Builder.setStyle(navDeepLinkRequest);
                notificationCompat$Builder.mVisibility = 1;
                notificationCompat$Builder.setFlag(2, false);
                notificationCompat$Builder.mGroupKey = "media3_group_key";
                return new PriorityQueue(i2, notificationCompat$Builder.build());
            }
        }
        navDeepLinkRequest.mimeType = iArrCopyOf;
        if (player2.isCommandAvailable(18)) {
            MediaMetadata mediaMetadata2 = player2.getMediaMetadata();
            notificationCompat$Builder = notificationCompat$Builder3;
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(mediaMetadata2.title);
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(mediaMetadata2.artist);
            mediaLibrarySessionImpl = mediaLibrarySessionImpl3;
            bitmapLoader = mediaLibrarySessionImpl.bitmapLoader;
            defaultMediaNotificationProvider = this;
            if (defaultMediaNotificationProvider.notificationIconBitmapLoader != null) {
                defaultMediaNotificationProvider.mediaSessionBitmapLoader = bitmapLoader;
                defaultMediaNotificationProvider.notificationIconBitmapLoader = new CallbackWrapper((byte) 26, (Object) new PriorityQueue((Object) bitmapLoader, ((Integer) maxNotificationIconSize.get()).intValue(), (byte) 9));
            } else {
                defaultMediaNotificationProvider.mediaSessionBitmapLoader = bitmapLoader;
                defaultMediaNotificationProvider.notificationIconBitmapLoader = new CallbackWrapper((byte) 26, (Object) new PriorityQueue((Object) bitmapLoader, ((Integer) maxNotificationIconSize.get()).intValue(), (byte) 9));
            }
            listenableFutureLoadBitmapFromMetadata = defaultMediaNotificationProvider.notificationIconBitmapLoader.loadBitmapFromMetadata(mediaMetadata2);
            if (listenableFutureLoadBitmapFromMetadata == null) {
                i2 = i12;
            } else {
                stsdData = defaultMediaNotificationProvider.pendingOnBitmapLoadedFutureCallback;
                if (stsdData != null) {
                    stsdData.requiredSampleTransformation = true;
                }
                if (listenableFutureLoadBitmapFromMetadata.isDone()) {
                    notificationCompat$Builder.setLargeIcon((Bitmap) UuidKt.getDone(listenableFutureLoadBitmapFromMetadata));
                    i2 = i12;
                } else {
                    i2 = i12;
                    BoxParser.StsdData stsdData3 = new BoxParser.StsdData(i2, notificationCompat$Builder, callback);
                    defaultMediaNotificationProvider.pendingOnBitmapLoadedFutureCallback = stsdData3;
                    Handler handler2 = mediaLibrarySessionImpl.applicationHandler;
                    Objects.requireNonNull(handler2);
                    listenableFutureLoadBitmapFromMetadata.addListener(new ActivityRecreator.AnonymousClass1(listenableFutureLoadBitmapFromMetadata, stsdData3, (byte) 1), new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler2, (byte) 0));
                }
            }
        } else {
            defaultMediaNotificationProvider = this;
            i2 = i12;
            mediaLibrarySessionImpl = mediaLibrarySessionImpl3;
            notificationCompat$Builder = notificationCompat$Builder3;
        }
        if (player2.isPlaying()) {
            jCurrentTimeMillis = -9223372036854775807L;
        } else {
            jCurrentTimeMillis = -9223372036854775807L;
        }
        if (jCurrentTimeMillis != -9223372036854775807L) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            jCurrentTimeMillis = 0;
        }
        Notification notification2 = notificationCompat$Builder.mNotification;
        notification2.when = jCurrentTimeMillis;
        notificationCompat$Builder.mShowWhen = z;
        notificationCompat$Builder.mUseChronometer = z;
        if (Build.VERSION.SDK_INT >= 31) {
            notificationCompat$Builder.mFgsDeferBehavior = (byte) 1;
        }
        notificationCompat$Builder.mContentIntent = mediaLibrarySessionImpl.sessionActivity;
        defaultActionFactory.getClass();
        Bundle bundle4 = new Bundle();
        bundle4.putBoolean("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", true);
        MediaSessionService mediaSessionService4 = defaultActionFactory.service;
        Class<?> cls4 = mediaSessionService4.getClass();
        UtilsKt.checkArgument(UtilsKt.isSupportedKeyCode(86));
        Bundle bundle5 = Bundle.EMPTY;
        notification2.deleteIntent = PendingIntent.getService(mediaSessionService4, 86, UtilsKt.createMediaButtonIntentInternal(mediaSessionService4, 86, bundle4, str3, cls4), 201326592);
        notificationCompat$Builder.setFlag(8, true);
        notification2.icon = defaultMediaNotificationProvider.smallIconResourceId;
        notificationCompat$Builder.setStyle(navDeepLinkRequest);
        notificationCompat$Builder.mVisibility = 1;
        notificationCompat$Builder.setFlag(2, false);
        notificationCompat$Builder.mGroupKey = "media3_group_key";
        return new PriorityQueue(i2, notificationCompat$Builder.build());
    }

    @Override // androidx.media3.session.MediaNotification$Provider
    public final CallbackWrapper getNotificationChannelInfo() {
        return new CallbackWrapper(this.channelId, this.context.getString(this.channelNameResourceId), (byte) 27);
    }

    @Override // androidx.media3.session.MediaNotification$Provider
    public final void handleCustomCommand(MediaLibraryService.MediaLibrarySession mediaLibrarySession, String str, Bundle bundle) {
    }
}
