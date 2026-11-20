package com.metrolist.music.utils;

import androidx.compose.foundation.internal.ClipboardUtils;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.AndroidClipboardImpl;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ExplorePage;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.MusicService$onShuffleModeEnabledChanged$1$1;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel$sync$1;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel$sync$1;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel$syncAllLibrary$1$1;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel$sync$1;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Updater$checkForUpdate$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $forceRefresh;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Updater$checkForUpdate$2(Object obj, boolean z, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$0 = obj;
        this.$forceRefresh = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        boolean z = this.$forceRefresh;
        switch (b) {
            case 0:
                Updater$checkForUpdate$2 updater$checkForUpdate$2 = new Updater$checkForUpdate$2(z, continuation);
                updater$checkForUpdate$2.L$0 = obj;
                return updater$checkForUpdate$2;
            case 1:
                return new Updater$checkForUpdate$2(this.L$0, z, continuation, (byte) 1);
            case 2:
                return new Updater$checkForUpdate$2(this.L$0, z, continuation, (byte) 2);
            case 3:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 3);
            case 4:
                return new Updater$checkForUpdate$2(this.L$0, z, continuation, (byte) 4);
            case 5:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 5);
            case 6:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 6);
            case 7:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 7);
            case 8:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 8);
            case 9:
                return new Updater$checkForUpdate$2(z, this.L$0, continuation, (byte) 9);
            default:
                return new Updater$checkForUpdate$2(this.L$0, z, continuation, (byte) 10);
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
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
        return ((Updater$checkForUpdate$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object failure;
        Object objM1525getLatestReleasegIAlus;
        Clipboard clipboard;
        AnnotatedString selectedText;
        Object objM1005exploreIoAF18A;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$forceRefresh;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        boolean z2 = true;
        boolean z3 = true;
        AnnotatedString annotatedString = 0;
        annotatedString = 0;
        switch (b) {
            case 0:
                boolean z4 = this.label;
                try {
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        if (z || System.currentTimeMillis() - Updater.lastCheckTime > 7200000 || Updater.cachedReleaseInfo == null) {
                            Updater updater = Updater.INSTANCE;
                            this.L$0 = null;
                            this.label = true;
                            objM1525getLatestReleasegIAlus = updater.m1525getLatestReleasegIAlus(true, this);
                            if (objM1525getLatestReleasegIAlus == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            Updater updater2 = Updater.INSTANCE;
                            ReleaseInfo releaseInfo = Updater.cachedReleaseInfo;
                            releaseInfo.getClass();
                            if (Updater.compareVersions(releaseInfo.versionName, "4.1.0") <= 0) {
                                z2 = false;
                            }
                            ReleaseInfo releaseInfo2 = Updater.cachedReleaseInfo;
                            releaseInfo2.getClass();
                            failure = new Pair(releaseInfo2, Boolean.valueOf(z2));
                        }
                        return new Result(failure);
                    }
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1525getLatestReleasegIAlus = ((Result) obj).value;
                    if (objM1525getLatestReleasegIAlus instanceof Result.Failure) {
                        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1525getLatestReleasegIAlus);
                        if (thM1866exceptionOrNullimpl == null) {
                            throw new Exception("Unknown error");
                        }
                        throw thM1866exceptionOrNullimpl;
                    }
                    ResultKt.throwOnFailure(objM1525getLatestReleasegIAlus);
                    ReleaseInfo releaseInfo3 = (ReleaseInfo) objM1525getLatestReleasegIAlus;
                    Updater updater3 = Updater.INSTANCE;
                    if (Updater.compareVersions(releaseInfo3.versionName, "4.1.0") <= 0) {
                        z3 = false;
                    }
                    failure = new Pair(releaseInfo3, Boolean.valueOf(z3));
                    return new Result(failure);
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                break;
            case 1:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.L$0;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (!TextRange.m741getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) && !(textFieldSelectionManager.visualTransformation instanceof PasswordVisualTransformation)) {
                    selectedText = DatabaseDao_Impl.AnonymousClass17.getSelectedText(textFieldSelectionManager.getValue$foundation());
                    if (z) {
                        annotatedString = selectedText;
                        int iM743getMaximpl = TextRange.m743getMaximpl(textFieldSelectionManager.getValue$foundation().selection);
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, TextRangeKt.TextRange(iM743getMaximpl, iM743getMaximpl)));
                        textFieldSelectionManager.setHandleState(HandleState.None);
                        annotatedString = selectedText;
                    }
                }
                if (annotatedString == 0 || (clipboard = textFieldSelectionManager.clipboard) == null) {
                    return unit;
                }
                ClipEntry clipEntry = ClipboardUtils.toClipEntry(annotatedString);
                this.label = true;
                ((AndroidClipboardImpl) clipboard).setClipEntry(clipEntry);
                return unit == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MusicService musicService = (MusicService) this.L$0;
                MusicService$onShuffleModeEnabledChanged$1$1 musicService$onShuffleModeEnabledChanged$1$1 = new MusicService$onShuffleModeEnabledChanged$1$1(z, (Continuation) null);
                this.label = true;
                return UtilsKt.safeDataStoreEdit(musicService, musicService$onShuffleModeEnabledChanged$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                boolean z7 = this.label;
                if (!z7) {
                    ResultKt.throwOnFailure(obj);
                    if (!z) {
                        return unit;
                    }
                    this.label = true;
                    if (AwaitKt.delay(300L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z7) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                FocusRequester.m415requestFocus3ESFkO8$default((FocusRequester) this.L$0);
                return unit;
            case 4:
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return YouTube.INSTANCE.m1044toggleSongLibrary0E7RQCE(((SongItem) this.L$0).id, z ^ true, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (!z8) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Object obj2 = ((Result) obj).value;
                return unit;
            case 5:
                boolean z9 = this.label;
                if (z9) {
                    if (z9) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (!z) {
                    return unit;
                }
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                LibraryAlbumsViewModel$sync$1 libraryAlbumsViewModel$sync$1 = new LibraryAlbumsViewModel$sync$1((LibraryAlbumsViewModel) this.L$0, annotatedString, z2 ? (byte) 1 : (byte) 0);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler, libraryAlbumsViewModel$sync$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 6:
                boolean z10 = this.label;
                if (z10) {
                    if (z10) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (!z) {
                    return unit;
                }
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                LibraryArtistsViewModel$sync$1 libraryArtistsViewModel$sync$1 = new LibraryArtistsViewModel$sync$1((LibraryArtistsViewModel) this.L$0, annotatedString, z2 ? (byte) 1 : (byte) 0);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler2, libraryArtistsViewModel$sync$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 7:
                boolean z11 = this.label;
                if (z11) {
                    if (z11) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (!z) {
                    return unit;
                }
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler3 = DefaultIoScheduler.INSTANCE;
                LibraryMixViewModel$syncAllLibrary$1$1 libraryMixViewModel$syncAllLibrary$1$1 = new LibraryMixViewModel$syncAllLibrary$1$1((LibraryMixViewModel) this.L$0, annotatedString, z2 ? (byte) 1 : (byte) 0);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler3, libraryMixViewModel$syncAllLibrary$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 8:
                boolean z12 = this.label;
                if (z12) {
                    if (z12) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (!z) {
                    return unit;
                }
                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler4 = DefaultIoScheduler.INSTANCE;
                LibraryPlaylistsViewModel$sync$1 libraryPlaylistsViewModel$sync$1 = new LibraryPlaylistsViewModel$sync$1((LibraryPlaylistsViewModel) this.L$0, annotatedString, z2 ? (byte) 1 : (byte) 0);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler4, libraryPlaylistsViewModel$sync$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 9:
                boolean z13 = this.label;
                if (z13) {
                    if (z13) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (z) {
                    return unit;
                }
                MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, annotatedString, (byte) 9);
                this.label = true;
                return musicDatabase.withTransaction(recomposer$join$2, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z14 = this.label;
                if (!z14) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = true;
                    objM1005exploreIoAF18A = youTube.m1005exploreIoAF18A(this);
                    if (objM1005exploreIoAF18A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z14) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1005exploreIoAF18A = ((Result) obj).value;
                }
                HomeViewModel homeViewModel = (HomeViewModel) this.L$0;
                if (!(objM1005exploreIoAF18A instanceof Result.Failure)) {
                    ExplorePage explorePage = (ExplorePage) objM1005exploreIoAF18A;
                    StateFlowImpl stateFlowImpl = homeViewModel.explorePage;
                    ExplorePage explorePage2 = new ExplorePage(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(explorePage.newReleaseAlbums), z), CollectionsKt.filterNotNull(explorePage.moodAndGenres));
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, explorePage2);
                }
                Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(objM1005exploreIoAF18A);
                if (thM1866exceptionOrNullimpl2 == null) {
                    return unit;
                }
                thM1866exceptionOrNullimpl2.printStackTrace();
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Updater$checkForUpdate$2(boolean z, Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$forceRefresh = z;
        this.L$0 = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$checkForUpdate$2(boolean z, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$forceRefresh = z;
    }
}
