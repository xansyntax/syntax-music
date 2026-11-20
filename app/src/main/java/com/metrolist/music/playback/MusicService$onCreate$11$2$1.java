package com.metrolist.music.playback;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayerImpl;
import com.google.common.math.IntMath;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$onCreate$11$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $mediaId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MusicService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicService$onCreate$11$2$1(MusicService musicService, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = musicService;
        this.$mediaId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$mediaId;
        MusicService musicService = this.this$0;
        switch (b) {
            case 0:
                return new MusicService$onCreate$11$2$1(musicService, str, continuation, (byte) 0);
            case 1:
                return new MusicService$onCreate$11$2$1(musicService, str, continuation, (byte) 1);
            case 2:
                return new MusicService$onCreate$11$2$1(musicService, str, continuation, (byte) 2);
            default:
                return new MusicService$onCreate$11$2$1(musicService, str, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((MusicService$onCreate$11$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 1:
                ((MusicService$onCreate$11$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 2:
                return ((MusicService$onCreate$11$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                ((MusicService$onCreate$11$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaItem mediaItemFindNextMediaItemById;
        MediaItem mediaItemFindNextMediaItemById2;
        MediaMetadata metadata;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$mediaId;
        MusicService musicService = this.this$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    musicService.getPlayerCache().removeResource(str);
                    musicService.getDownloadCache().removeResource(str);
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                    break;
                } catch (Exception unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                }
                return unit;
            case 1:
                ResultKt.throwOnFailure(obj);
                long currentPosition = musicService.player.getCurrentPosition();
                int currentMediaItemIndex = musicService.player.getCurrentMediaItemIndex();
                if (currentMediaItemIndex == -1) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.w(new Object[0]);
                    musicService.handleFinalFailure();
                } else {
                    musicService.player.seekTo(currentMediaItemIndex, currentPosition, false);
                    musicService.player.prepare();
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                }
                return unit;
            case 2:
                ResultKt.throwOnFailure(obj);
                MediaItem mediaItemFindNextMediaItemById3 = IntMath.findNextMediaItemById(musicService.player, str);
                if (mediaItemFindNextMediaItemById3 != null && (metadata = UuidKt.getMetadata(mediaItemFindNextMediaItemById3)) != null) {
                    return metadata;
                }
                ExoPlayerImpl exoPlayerImpl = musicService.secondaryPlayer;
                MediaMetadata metadata2 = (exoPlayerImpl == null || (mediaItemFindNextMediaItemById2 = IntMath.findNextMediaItemById(exoPlayerImpl, str)) == null) ? null : UuidKt.getMetadata(mediaItemFindNextMediaItemById2);
                if (metadata2 != null) {
                    return metadata2;
                }
                ExoPlayerImpl exoPlayerImpl2 = musicService.fadingPlayer;
                if (exoPlayerImpl2 == null || (mediaItemFindNextMediaItemById = IntMath.findNextMediaItemById(exoPlayerImpl2, str)) == null) {
                    return null;
                }
                return UuidKt.getMetadata(mediaItemFindNextMediaItemById);
            default:
                ResultKt.throwOnFailure(obj);
                DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
                if (!discordRpcManager.isInitialized()) {
                    discordRpcManager.init(musicService);
                }
                discordRpcManager.reconnectWithToken(str);
                return unit;
        }
    }
}
