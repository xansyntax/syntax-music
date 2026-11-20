package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.pages.PlaylistPage;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ PlaylistItem $playlist;
    public final /* synthetic */ byte $r8$classId;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(PlaylistItem playlistItem, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playlist = playlistItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(this.$playlist, continuation, (byte) 0);
            case 1:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(this.$playlist, continuation, (byte) 1);
            case 2:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(this.$playlist, continuation, (byte) 2);
            default:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1(this.$playlist, continuation, (byte) 3);
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (r8 == r4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        if (r8 == r4) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cd, code lost:
    
        if (r8 == r4) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0112, code lost:
    
        if (r8 == r4) goto L83;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objM1025playlistgIAlus;
        Object objCompletedLibrary;
        Object objM1025playlistgIAlus2;
        Object objCompletedLibrary2;
        Object objM1025playlistgIAlus3;
        Object objCompletedLibrary3;
        Object objM1025playlistgIAlus4;
        Object objCompletedLibrary4;
        byte b = this.$r8$classId;
        EmptyList emptyList = EmptyList.INSTANCE;
        PlaylistItem playlistItem = this.$playlist;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        List list = null;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    String str = playlistItem.id;
                    this.label = (byte) 1;
                    objM1025playlistgIAlus = youTube.m1025playlistgIAlus(str, this);
                    if (objM1025playlistgIAlus != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus = ((Result) obj).value;
                } else if (b2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary = ((Result) obj).value;
                    if (objCompletedLibrary instanceof Result.Failure) {
                        objCompletedLibrary = null;
                    }
                    PlaylistPage playlistPage = (PlaylistPage) objCompletedLibrary;
                    list = playlistPage != null ? playlistPage.songs : null;
                    if (list == null) {
                        return emptyList;
                    }
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return list;
                this.label = (byte) 2;
                objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                break;
            case 1:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube2 = YouTube.INSTANCE;
                    String str2 = playlistItem.id;
                    this.label = (byte) 1;
                    objM1025playlistgIAlus2 = youTube2.m1025playlistgIAlus(str2, this);
                    if (objM1025playlistgIAlus2 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus2 = ((Result) obj).value;
                } else if (b3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary2 = ((Result) obj).value;
                    if (objCompletedLibrary2 instanceof Result.Failure) {
                        objCompletedLibrary2 = null;
                    }
                    PlaylistPage playlistPage2 = (PlaylistPage) objCompletedLibrary2;
                    list = playlistPage2 != null ? playlistPage2.songs : null;
                    if (list == null) {
                        return emptyList;
                    }
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return list;
                this.label = (byte) 2;
                objCompletedLibrary2 = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus2, this);
                break;
            case 2:
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube3 = YouTube.INSTANCE;
                    String str3 = playlistItem.id;
                    this.label = (byte) 1;
                    objM1025playlistgIAlus3 = youTube3.m1025playlistgIAlus(str3, this);
                    if (objM1025playlistgIAlus3 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b4 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus3 = ((Result) obj).value;
                } else if (b4 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary3 = ((Result) obj).value;
                    if (objCompletedLibrary3 instanceof Result.Failure) {
                        objCompletedLibrary3 = null;
                    }
                    PlaylistPage playlistPage3 = (PlaylistPage) objCompletedLibrary3;
                    list = playlistPage3 != null ? playlistPage3.songs : null;
                    if (list == null) {
                        return emptyList;
                    }
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return list;
                this.label = (byte) 2;
                objCompletedLibrary3 = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus3, this);
                break;
            default:
                byte b5 = this.label;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube4 = YouTube.INSTANCE;
                    String str4 = playlistItem.id;
                    this.label = (byte) 1;
                    objM1025playlistgIAlus4 = youTube4.m1025playlistgIAlus(str4, this);
                    if (objM1025playlistgIAlus4 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b5 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus4 = ((Result) obj).value;
                } else if (b5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary4 = ((Result) obj).value;
                    if (objCompletedLibrary4 instanceof Result.Failure) {
                        objCompletedLibrary4 = null;
                    }
                    PlaylistPage playlistPage4 = (PlaylistPage) objCompletedLibrary4;
                    list = playlistPage4 != null ? playlistPage4.songs : null;
                    if (list == null) {
                        return emptyList;
                    }
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return list;
                this.label = (byte) 2;
                objCompletedLibrary4 = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus4, this);
                break;
        }
    }
}
