package com.metrolist.music.ui.menu;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $format;
    public final /* synthetic */ Context $localContext;
    public final /* synthetic */ Playlist $playlist;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1(String str, Context context, Playlist playlist, List list, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$format = str;
        this.$localContext = context;
        this.$playlist = playlist;
        this.$songs = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1(this.$format, this.$localContext, this.$playlist, this.$songs, continuation, (byte) 0);
            default:
                return new PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1(this.$format, this.$localContext, this.$playlist, this.$songs, continuation, (byte) 1);
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
                ((PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((PlaylistScreenMenusKt$LocalPlaylistMenu$3$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = "audio/x-mpegurl";
        String str2 = this.$format;
        Context context = this.$localContext;
        Playlist playlist = this.$playlist;
        List list = this.$songs;
        switch (b) {
            case 0:
                PlaylistEntity playlistEntity = playlist.playlist;
                ResultKt.throwOnFailure(obj);
                Serializable serializableM1526exportPlaylistAsCSV0E7RQCE = str2.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context, playlistEntity.name, list) : str2.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context, playlistEntity.name, list) : new Result.Failure(new IllegalArgumentException("Unknown format"));
                if (!(serializableM1526exportPlaylistAsCSV0E7RQCE instanceof Result.Failure)) {
                    Uri exportFileUri = UtilsKt.getExportFileUri(context, (File) serializableM1526exportPlaylistAsCSV0E7RQCE);
                    if (str2.equals("csv")) {
                        str = "text/csv";
                    } else if (!str2.equals("m3u")) {
                        str = "*/*";
                    }
                    AlbumMenuKt.shareExportFile(context, exportFileUri, str);
                }
                if (Result.m1866exceptionOrNullimpl(serializableM1526exportPlaylistAsCSV0E7RQCE) != null) {
                    Toast.makeText(context, R.string.export_failed, 0).show();
                }
                break;
            default:
                PlaylistEntity playlistEntity2 = playlist.playlist;
                ResultKt.throwOnFailure(obj);
                Serializable serializableM1526exportPlaylistAsCSV0E7RQCE2 = str2.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context, playlistEntity2.name, list) : str2.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context, playlistEntity2.name, list) : new Result.Failure(new IllegalArgumentException("Unknown format"));
                if (!(serializableM1526exportPlaylistAsCSV0E7RQCE2 instanceof Result.Failure)) {
                    File file = (File) serializableM1526exportPlaylistAsCSV0E7RQCE2;
                    if (str2.equals("csv")) {
                        str = "text/csv";
                    } else if (!str2.equals("m3u")) {
                        str = "application/octet-stream";
                    }
                    Object objSaveToPublicDocuments$default = UtilsKt.saveToPublicDocuments$default(context, file, str);
                    if (!(objSaveToPublicDocuments$default instanceof Result.Failure)) {
                        Toast.makeText(context, R.string.export_success, 0).show();
                    }
                    if (Result.m1866exceptionOrNullimpl(objSaveToPublicDocuments$default) != null) {
                        Toast.makeText(context, R.string.export_failed, 0).show();
                    }
                }
                if (Result.m1866exceptionOrNullimpl(serializableM1526exportPlaylistAsCSV0E7RQCE2) != null) {
                    Toast.makeText(context, R.string.export_failed, 0).show();
                }
                break;
        }
        return unit;
    }
}
