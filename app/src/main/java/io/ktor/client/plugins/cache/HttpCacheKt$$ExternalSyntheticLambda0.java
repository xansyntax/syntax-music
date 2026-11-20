package io.ktor.client.plugins.cache;

import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.lyrics.LyricsWithProvider;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import io.ktor.http.content.OutgoingContent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpCacheKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ HttpCacheKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                return HttpCacheKt.mergedHeadersLookup$lambda$0((OutgoingContent) obj4, (Function1) obj3, (Function1) obj2, (String) obj);
            default:
                LyricsEntity lyricsEntity = (LyricsEntity) obj4;
                MediaMetadata mediaMetadata = (MediaMetadata) obj3;
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj2;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                DatabaseDao databaseDao = musicDatabase.$$delegate_0;
                if (lyricsEntity != null) {
                    databaseDao.delete(lyricsEntity);
                }
                LyricsWithProvider lyricsWithProvider = (LyricsWithProvider) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new DataStoreKt$get$1((Object) lyricsMenuViewModel, (Object) mediaMetadata, (Continuation) null, (byte) 29));
                databaseDao.upsert(new LyricsEntity(mediaMetadata.id, lyricsWithProvider.lyrics, lyricsWithProvider.provider));
                return Unit.INSTANCE;
        }
    }
}
