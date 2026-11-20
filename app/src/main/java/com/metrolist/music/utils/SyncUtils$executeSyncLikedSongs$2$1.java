package com.metrolist.music.utils;

import com.metrolist.innertube.YouTube;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncLikedSongs$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncLikedSongs$2$1(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 0);
            case 1:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 1);
            case 2:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 2);
            case 3:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 3);
            case 4:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 4);
            case 5:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 5);
            default:
                return new SyncUtils$executeSyncLikedSongs$2$1(1, continuation, (byte) 6);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return ((SyncUtils$executeSyncLikedSongs$2$1) create(continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a6, code lost:
    
        if (r6 == r3) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r6 == r3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r6 == r3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b6, code lost:
    
        if (r6 == r3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f2, code lost:
    
        if (r6 == r3) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012e, code lost:
    
        if (r6 == r3) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x016a, code lost:
    
        if (r6 == r3) goto L91;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objM1025playlistgIAlus;
        Object objCompletedLibrary;
        Object objM1011library0E7RQCE;
        Object objCompletedPlaylist;
        Object objM1011library0E7RQCE2;
        Object objCompletedPlaylist2;
        Object objM1011library0E7RQCE3;
        Object objCompletedPlaylist3;
        Object objM1011library0E7RQCE4;
        Object objCompletedPlaylist4;
        Object objM1011library0E7RQCE5;
        Object objCompletedPlaylist5;
        Object objM1011library0E7RQCE6;
        Object objCompletedPlaylist6;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1025playlistgIAlus = youTube.m1025playlistgIAlus("LM", this);
                    if (objM1025playlistgIAlus != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus = ((Result) obj).value;
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary = ((Result) obj).value;
                }
                return new Result(objCompletedLibrary);
                this.label = (byte) 2;
                objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                break;
            case 1:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube2 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_library_corpus_artists", 0, this);
                    if (objM1011library0E7RQCE != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE = ((Result) obj).value;
                } else {
                    if (b3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist);
                this.label = (byte) 2;
                objCompletedPlaylist = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE, this);
                break;
            case 2:
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube3 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE2 = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_videos", 0, this);
                    if (objM1011library0E7RQCE2 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b4 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE2 = ((Result) obj).value;
                } else {
                    if (b4 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist2 = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist2);
                this.label = (byte) 2;
                objCompletedPlaylist2 = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE2, this);
                break;
            case 3:
                byte b5 = this.label;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube4 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE3 = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_albums", 0, this);
                    if (objM1011library0E7RQCE3 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b5 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE3 = ((Result) obj).value;
                } else {
                    if (b5 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist3 = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist3);
                this.label = (byte) 2;
                objCompletedPlaylist3 = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE3, this);
                break;
            case 4:
                byte b6 = this.label;
                if (b6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube5 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE4 = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_playlists", 0, this);
                    if (objM1011library0E7RQCE4 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b6 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE4 = ((Result) obj).value;
                } else {
                    if (b6 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist4 = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist4);
                this.label = (byte) 2;
                objCompletedPlaylist4 = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE4, this);
                break;
            case 5:
                byte b7 = this.label;
                if (b7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube6 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE5 = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_library_privately_owned_releases", 0, this);
                    if (objM1011library0E7RQCE5 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b7 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE5 = ((Result) obj).value;
                } else {
                    if (b7 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist5 = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist5);
                this.label = (byte) 2;
                objCompletedPlaylist5 = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE5, this);
                break;
            default:
                byte b8 = this.label;
                if (b8 == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube7 = YouTube.INSTANCE;
                    this.label = (byte) 1;
                    objM1011library0E7RQCE6 = youTube7.m1011library0E7RQCE("FEmusic_library_privately_owned_tracks", 1, this);
                    if (objM1011library0E7RQCE6 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b8 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1011library0E7RQCE6 = ((Result) obj).value;
                } else {
                    if (b8 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCompletedPlaylist6 = ((Result) obj).value;
                }
                return new Result(objCompletedPlaylist6);
                this.label = (byte) 2;
                objCompletedPlaylist6 = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE6, this);
                break;
        }
    }
}
