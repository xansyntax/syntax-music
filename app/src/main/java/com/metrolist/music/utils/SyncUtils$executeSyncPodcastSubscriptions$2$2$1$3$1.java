package com.metrolist.music.utils;

import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PodcastEntity;
import java.time.LocalDateTime;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ PodcastEntity $dbPodcast;
    public final /* synthetic */ PodcastItem $podcast;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1(PodcastEntity podcastEntity, PodcastItem podcastItem, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$dbPodcast = podcastEntity;
        this.$podcast = podcastItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        PodcastItem podcastItem = this.$podcast;
        PodcastEntity podcastEntity = this.$dbPodcast;
        switch (b) {
            case 0:
                SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1 syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1 = new SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1(podcastEntity, podcastItem, continuation, (byte) 0);
                syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1.L$0 = obj;
                return syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1;
            default:
                SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1 syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$2 = new SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1(podcastEntity, podcastItem, continuation, (byte) 1);
                syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$2.L$0 = obj;
                return syncUtils$executeSyncPodcastSubscriptions$2$2$1$3$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1) create(musicDatabase, continuation)).invokeSuspend(unit);
                break;
            default:
                ((SyncUtils$executeSyncPodcastSubscriptions$2$2$1$3$1) create(musicDatabase, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PodcastEntity podcastEntity = this.$dbPodcast;
        PodcastItem podcastItem = this.$podcast;
        switch (b) {
            case 0:
                String str4 = podcastItem.channelId;
                Artist artist = podcastItem.author;
                MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (podcastEntity == null) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    PodcastEntity podcastEntity2 = new PodcastEntity(podcastItem.id, podcastItem.title, artist != null ? artist.name : null, podcastItem.thumbnail, str4 == null ? artist != null ? artist.id : null : str4, LocalDateTime.now(), 448);
                    musicDatabase.getClass();
                    Boxing.boxLong(musicDatabase.$$delegate_0.insert(podcastEntity2));
                } else if (podcastEntity.bookmarkedAt == null) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    String str5 = podcastItem.title;
                    String str6 = artist != null ? artist.name : null;
                    String str7 = podcastItem.thumbnail;
                    PodcastEntity podcastEntity3 = this.$dbPodcast;
                    if (str4 != null) {
                        str = str4;
                    } else {
                        str2 = artist != null ? artist.id : null;
                        if (str2 == null) {
                            str4 = podcastEntity3.channelId;
                            str = str4;
                        } else {
                            str = str2;
                        }
                    }
                    LocalDateTime localDateTimeNow = LocalDateTime.now();
                    localDateTimeNow.getClass();
                    PodcastEntity podcastEntityCopy$default = PodcastEntity.copy$default(podcastEntity3, str5, str6, str7, str, null, localDateTimeNow, 417);
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.update(podcastEntityCopy$default);
                }
                break;
            default:
                String str8 = podcastItem.channelId;
                Artist artist2 = podcastItem.author;
                MusicDatabase musicDatabase2 = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (podcastEntity == null) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    PodcastEntity podcastEntity4 = new PodcastEntity(podcastItem.id, podcastItem.title, artist2 != null ? artist2.name : null, podcastItem.thumbnail, str8 == null ? artist2 != null ? artist2.id : null : str8, LocalDateTime.now(), 448);
                    musicDatabase2.getClass();
                    Boxing.boxLong(musicDatabase2.$$delegate_0.insert(podcastEntity4));
                } else if (podcastEntity.bookmarkedAt == null) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    String str9 = podcastItem.title;
                    String str10 = artist2 != null ? artist2.name : null;
                    String str11 = podcastItem.thumbnail;
                    PodcastEntity podcastEntity5 = this.$dbPodcast;
                    if (str8 != null) {
                        str3 = str8;
                    } else {
                        str2 = artist2 != null ? artist2.id : null;
                        if (str2 == null) {
                            str8 = podcastEntity5.channelId;
                            str3 = str8;
                        } else {
                            str3 = str2;
                        }
                    }
                    LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                    localDateTimeNow2.getClass();
                    PodcastEntity podcastEntityCopy$default2 = PodcastEntity.copy$default(podcastEntity5, str9, str10, str11, str3, null, localDateTimeNow2, 417);
                    musicDatabase2.getClass();
                    musicDatabase2.$$delegate_0.update(podcastEntityCopy$default2);
                }
                break;
        }
        return unit;
    }
}
