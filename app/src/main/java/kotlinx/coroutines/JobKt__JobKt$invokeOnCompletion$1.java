package kotlinx.coroutines;

import androidx.media3.datasource.cache.ContentMetadata;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JobKt__JobKt$invokeOnCompletion$1 extends FunctionReferenceImpl implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JobKt__JobKt$invokeOnCompletion$1(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
        super(i, obj, cls, str, str2, i2);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((JobNode) this.receiver).invoke((Throwable) obj);
                return unit;
            case 1:
                String str = (String) obj;
                str.getClass();
                StateFlowImpl stateFlowImpl = ((LibraryMixViewModel) this.receiver)._searchQuery;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, str);
                return unit;
            case 2:
                String str2 = (String) obj;
                str2.getClass();
                StateFlowImpl stateFlowImpl2 = ((LibraryPlaylistsViewModel) this.receiver)._searchQuery;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, str2);
                return unit;
            case 3:
                String str3 = (String) obj;
                str3.getClass();
                StateFlowImpl stateFlowImpl3 = ((LibrarySongsViewModel) this.receiver)._searchQuery;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, str3);
                return unit;
            default:
                Song song = (Song) obj;
                song.getClass();
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) this.receiver;
                cachePlaylistViewModel.getClass();
                FormatEntity formatEntity = song.format;
                if (formatEntity != null) {
                    return Long.valueOf(formatEntity.contentLength);
                }
                long contentLength = ContentMetadata.getContentLength(cachePlaylistViewModel.playerCache.getContentMetadata(song.song.id));
                Long lValueOf = Long.valueOf(contentLength);
                if (contentLength > 0) {
                    return lValueOf;
                }
                return null;
        }
    }
}
