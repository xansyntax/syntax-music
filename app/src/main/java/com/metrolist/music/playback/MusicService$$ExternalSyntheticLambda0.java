package com.metrolist.music.playback;

import android.widget.Toast;
import androidx.media3.session.MediaControllerHolder;
import com.metrolist.music.discord.DiscordRpcManager;
import com.yalantis.ucrop.R;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicService$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MusicService f$0;

    public /* synthetic */ MusicService$$ExternalSyntheticLambda0(MusicService musicService, byte b) {
        this.$r8$classId = b;
        this.f$0 = musicService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MusicService musicService = this.f$0;
        switch (b) {
            case 0:
                boolean z = MusicService.isRunning;
                ConnectionPool connectionPool = Timber.Forest;
                connectionPool.tag("DiscordSvc");
                Boolean boolValueOf = Boolean.valueOf(musicService.player.isPlaying());
                DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
                ConnectionPool.i(boolValueOf, Boolean.valueOf(discordRpcManager.isReady()));
                if (!musicService.player.isPlaying() && discordRpcManager.isReady()) {
                    connectionPool.tag("DiscordSvc");
                    ConnectionPool.i(new Object[0]);
                    musicService.discordIntentionalDisconnect = true;
                    discordRpcManager.disconnect();
                    break;
                }
                break;
            case 1:
                boolean z2 = MusicService.isRunning;
                ConnectionPool connectionPool2 = Timber.Forest;
                connectionPool2.tag("DiscordSvc");
                Boolean boolValueOf2 = Boolean.valueOf(musicService.player.isPlaying());
                DiscordRpcManager discordRpcManager2 = DiscordRpcManager.INSTANCE;
                ConnectionPool.i(boolValueOf2, Boolean.valueOf(discordRpcManager2.isReady()));
                if (!musicService.player.isPlaying() && discordRpcManager2.isReady()) {
                    connectionPool2.tag("DiscordSvc");
                    ConnectionPool.i(new Object[0]);
                    musicService.discordIntentionalDisconnect = true;
                    discordRpcManager2.disconnect();
                    break;
                }
                break;
            case 2:
                boolean z3 = MusicService.isRunning;
                try {
                    MediaControllerHolder mediaControllerHolder = musicService.controllerFuture;
                    if (mediaControllerHolder != null) {
                    }
                } catch (Exception unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                    musicService.controllerFuture = null;
                    musicService.stopSelf();
                    return;
                }
                break;
            default:
                Toast.makeText(musicService, musicService.getString(R.string.android_auto_target_playlist_not_set), 0).show();
                break;
        }
    }
}
