package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $format;
    public final /* synthetic */ PlaylistItem $playlist;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(List list, String str, Context context, PlaylistItem playlistItem, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$songs = list;
        this.$format = str;
        this.$context = context;
        this.$playlist = playlistItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(this.$songs, this.$format, this.$context, this.$playlist, continuation, (byte) 0);
            default:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1(this.$songs, this.$format, this.$context, this.$playlist, continuation, (byte) 1);
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
                break;
        }
        return ((YouTubePlaylistMenuKt$YouTubePlaylistMenu$16$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0062  */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    /* JADX WARN: Code duplicated, block: B:24:0x007f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x0100  */
    /* JADX WARN: Code duplicated, block: B:54:0x0107  */
    /* JADX WARN: Code duplicated, block: B:56:0x010d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0114  */
    /* JADX WARN: Code duplicated, block: B:60:0x0124  */
    /* JADX WARN: Code duplicated, block: B:62:0x0131  */
    /* JADX WARN: Code duplicated, block: B:66:0x0158  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        Serializable failure;
        Object objWithContext2;
        Serializable failure2;
        int i;
        int i2;
        Object objSaveToPublicDocuments$default;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        PlaylistItem playlistItem = this.$playlist;
        Context context = this.$context;
        List list = this.$songs;
        String str = this.$format;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(playlistItem, null, (byte) 2);
                        this.label = true;
                        objWithContext = AwaitKt.withContext(defaultIoScheduler, youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1, this);
                        if (objWithContext == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    if (str.equals("csv")) {
                        failure = UtilsKt.exportYouTubePlaylistAsCSV(context, playlistItem.title, list);
                    } else if (str.equals("m3u")) {
                        failure = UtilsKt.exportYouTubePlaylistAsM3U(context, playlistItem.title, list);
                    } else {
                        failure = new Result.Failure(new IllegalArgumentException("Unknown format"));
                    }
                    if (!(failure instanceof Result.Failure)) {
                        Uri exportFileUri = UtilsKt.getExportFileUri(context, (File) failure);
                        String str2 = str.equals("csv") ? "text/csv" : "audio/x-mpegurl";
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType(str2);
                        intent.putExtra("android.intent.extra.STREAM", exportFileUri);
                        intent.addFlags(1);
                        context.startActivity(Intent.createChooser(intent, context.getString(R.string.export_playlist)));
                    }
                    if (Result.m1866exceptionOrNullimpl(failure) != null) {
                        return unit;
                    }
                    Toast.makeText(context, R.string.export_failed, 0).show();
                    return unit;
                }
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
                list = (List) objWithContext;
                if (str.equals("csv")) {
                    failure = UtilsKt.exportYouTubePlaylistAsCSV(context, playlistItem.title, list);
                } else if (str.equals("m3u")) {
                    failure = UtilsKt.exportYouTubePlaylistAsM3U(context, playlistItem.title, list);
                } else {
                    failure = new Result.Failure(new IllegalArgumentException("Unknown format"));
                }
                if (!(failure instanceof Result.Failure)) {
                    Uri exportFileUri2 = UtilsKt.getExportFileUri(context, (File) failure);
                    if (str.equals("csv")) {
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType(str2);
                    intent2.putExtra("android.intent.extra.STREAM", exportFileUri2);
                    intent2.addFlags(1);
                    context.startActivity(Intent.createChooser(intent2, context.getString(R.string.export_playlist)));
                }
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    return unit;
                }
                Toast.makeText(context, R.string.export_failed, 0).show();
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                        YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$2 = new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(playlistItem, null, (byte) 3);
                        this.label = true;
                        objWithContext2 = AwaitKt.withContext(defaultIoScheduler2, youTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$2, this);
                        if (objWithContext2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    if (str.equals("csv")) {
                        failure2 = UtilsKt.exportYouTubePlaylistAsCSV(context, playlistItem.title, list);
                    } else if (str.equals("m3u")) {
                        failure2 = UtilsKt.exportYouTubePlaylistAsM3U(context, playlistItem.title, list);
                    } else {
                        failure2 = new Result.Failure(new IllegalArgumentException("Unknown format"));
                    }
                    if (failure2 instanceof Result.Failure) {
                        i = R.string.export_failed;
                        i2 = 0;
                    } else {
                        objSaveToPublicDocuments$default = UtilsKt.saveToPublicDocuments$default(context, (File) failure2, str.equals("csv") ? "text/csv" : "audio/x-mpegurl");
                        if (objSaveToPublicDocuments$default instanceof Result.Failure) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            Toast.makeText(context, R.string.export_success, 0).show();
                        }
                        if (Result.m1866exceptionOrNullimpl(objSaveToPublicDocuments$default) != null) {
                            i = R.string.export_failed;
                            Toast.makeText(context, R.string.export_failed, i2).show();
                        } else {
                            i = R.string.export_failed;
                        }
                    }
                    if (Result.m1866exceptionOrNullimpl(failure2) != null) {
                        return unit;
                    }
                    Toast.makeText(context, i, i2).show();
                    return unit;
                }
                if (!z2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objWithContext2 = obj;
                list = (List) objWithContext2;
                if (str.equals("csv")) {
                    failure2 = UtilsKt.exportYouTubePlaylistAsCSV(context, playlistItem.title, list);
                } else if (str.equals("m3u")) {
                    failure2 = UtilsKt.exportYouTubePlaylistAsM3U(context, playlistItem.title, list);
                } else {
                    failure2 = new Result.Failure(new IllegalArgumentException("Unknown format"));
                }
                if (failure2 instanceof Result.Failure) {
                    objSaveToPublicDocuments$default = UtilsKt.saveToPublicDocuments$default(context, (File) failure2, str.equals("csv") ? "text/csv" : "audio/x-mpegurl");
                    if (objSaveToPublicDocuments$default instanceof Result.Failure) {
                        i2 = 0;
                        Toast.makeText(context, R.string.export_success, 0).show();
                    } else {
                        i2 = 0;
                    }
                    if (Result.m1866exceptionOrNullimpl(objSaveToPublicDocuments$default) != null) {
                        i = R.string.export_failed;
                        Toast.makeText(context, R.string.export_failed, i2).show();
                    } else {
                        i = R.string.export_failed;
                    }
                } else {
                    i = R.string.export_failed;
                    i2 = 0;
                }
                if (Result.m1866exceptionOrNullimpl(failure2) != null) {
                    return unit;
                }
                Toast.makeText(context, i, i2).show();
                return unit;
        }
    }
}
