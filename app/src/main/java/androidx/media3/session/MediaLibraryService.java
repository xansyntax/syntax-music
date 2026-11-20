package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import androidx.media3.common.Player;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MusicService;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaLibraryService extends MediaSessionService {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LibraryParams {
        public static final String FIELD_EXTRAS;
        public static final String FIELD_OFFLINE;
        public static final String FIELD_RECENT;
        public static final String FIELD_SUGGESTED;
        public final Bundle extras;
        public final boolean isOffline;
        public final boolean isRecent;
        public final boolean isSuggested;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_EXTRAS = Integer.toString(0, 36);
            FIELD_RECENT = Integer.toString(1, 36);
            FIELD_OFFLINE = Integer.toString(2, 36);
            FIELD_SUGGESTED = Integer.toString(3, 36);
        }

        public LibraryParams(Bundle bundle, boolean z, boolean z2, boolean z3) {
            this.extras = new Bundle(bundle);
            this.isRecent = z;
            this.isOffline = z2;
            this.isSuggested = z3;
        }

        public static LibraryParams fromBundle(Bundle bundle) {
            Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_EXTRAS));
            boolean z = bundle.getBoolean(FIELD_RECENT, false);
            boolean z2 = bundle.getBoolean(FIELD_OFFLINE, false);
            boolean z3 = bundle.getBoolean(FIELD_SUGGESTED, false);
            if (bundleConvertToNullIfInvalid == null) {
                bundleConvertToNullIfInvalid = Bundle.EMPTY;
            }
            return new LibraryParams(bundleConvertToNullIfInvalid, z, z2, z3);
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(FIELD_EXTRAS, this.extras);
            bundle.putBoolean(FIELD_RECENT, this.isRecent);
            bundle.putBoolean(FIELD_OFFLINE, this.isOffline);
            bundle.putBoolean(FIELD_SUGGESTED, this.isSuggested);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaLibrarySession {
        public final MediaLibrarySessionImpl impl;
        public static final Object STATIC_LOCK = new Object();
        public static final HashMap SESSION_ID_TO_SESSION_MAP = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public static final AtomicReference bitmapSizesToAvoidApi29 = new AtomicReference(null);
            public BitmapLoader bitmapLoader;
            public boolean buildCalled;
            public final MediaLibrarySessionCallback callback;
            public final RegularImmutableList commandButtonsForMediaItems;
            public final Context context;
            public final RegularImmutableList customLayout;
            public final String id;
            public final boolean isPeriodicPositionUpdateEnabled;
            public final byte libraryErrorReplicationMode;
            public final RegularImmutableList mediaButtonPreferences;
            public final boolean playIfSuppressed;
            public final Player player;
            public PendingIntent sessionActivity;
            public final Bundle sessionExtras;
            public final Bundle tokenExtras;

            public Builder(MusicService musicService, Player player, MediaLibrarySessionCallback mediaLibrarySessionCallback) {
                Context applicationContext = musicService.getApplicationContext();
                applicationContext.getClass();
                this.context = applicationContext;
                player.getClass();
                this.player = player;
                UtilsKt.checkArgument(player.canAdvertiseSession());
                this.id = "";
                this.callback = mediaLibrarySessionCallback;
                this.tokenExtras = new Bundle();
                this.sessionExtras = new Bundle();
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                RegularImmutableList regularImmutableList = RegularImmutableList.EMPTY;
                this.customLayout = regularImmutableList;
                this.mediaButtonPreferences = regularImmutableList;
                this.playIfSuppressed = true;
                this.isPeriodicPositionUpdateEnabled = true;
                this.commandButtonsForMediaItems = regularImmutableList;
                this.libraryErrorReplicationMode = (byte) 2;
            }
        }

        public MediaLibrarySession(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, MediaLibrarySessionCallback mediaLibrarySessionCallback, Bundle bundle, Bundle bundle2, BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
            synchronized (STATIC_LOCK) {
                HashMap map = SESSION_ID_TO_SESSION_MAP;
                if (map.containsKey(str)) {
                    throw new IllegalStateException("Session ID must be unique. ID=" + str);
                }
                map.put(str, this);
            }
            this.impl = new MediaLibrarySessionImpl(this, context, str, player, pendingIntent, immutableList, immutableList2, immutableList3, mediaLibrarySessionCallback, bundle, bundle2, bitmapLoader, z, z2, i);
        }

        public final Player getPlayer() {
            return this.impl.playerWrapper.player;
        }

        public final void setPlayer(Player player) {
            player.getClass();
            UtilsKt.checkArgument(player.canAdvertiseSession());
            UtilsKt.checkArgument(player.getApplicationLooper() == getPlayer().getApplicationLooper());
            UtilsKt.checkState(player.getApplicationLooper() == Looper.myLooper());
            MediaLibrarySessionImpl mediaLibrarySessionImpl = this.impl;
            PlayerWrapper playerWrapper = mediaLibrarySessionImpl.playerWrapper;
            if (player == playerWrapper.player) {
                return;
            }
            mediaLibrarySessionImpl.setPlayerInternal(playerWrapper, new PlayerWrapper(player));
        }
    }

    @Override // androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!"androidx.media3.session.MediaLibraryService".equals(intent.getAction())) {
            return super.onBind(intent);
        }
        MediaSessionService.MediaSessionServiceStub mediaSessionServiceStub = this.stub;
        mediaSessionServiceStub.getClass();
        return mediaSessionServiceStub;
    }

    @Override // androidx.media3.session.MediaSessionService
    /* JADX INFO: renamed from: onGetSession$1, reason: merged with bridge method [inline-methods] */
    public abstract MediaLibrarySession onGetSession(MediaSession$ControllerInfo mediaSession$ControllerInfo);
}
