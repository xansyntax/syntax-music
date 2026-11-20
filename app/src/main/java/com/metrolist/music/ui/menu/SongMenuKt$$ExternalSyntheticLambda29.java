package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import coil3.RealImageLoader$execute$result$1;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.screens.LoginJsInterface;
import com.metrolist.music.ui.screens.LoginStage;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel$search$1;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda29 implements Function0 {
    public final /* synthetic */ byte $r8$classId = 5;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, LoginJsInterface loginJsInterface, CoroutineScope coroutineScope) {
        this.f$2 = coroutineScope;
        this.f$3 = mutableState;
        this.f$4 = mutableState2;
        this.f$0 = mutableState3;
        this.f$5 = loginJsInterface;
        this.f$1 = context;
        this.f$6 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$6;
        Object obj2 = this.f$5;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        Object obj5 = this.f$4;
        Object obj6 = this.f$2;
        Object obj7 = this.f$3;
        switch (b) {
            case 0:
                Song song = (Song) obj4;
                Context context = (Context) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj6;
                MutableState mutableState = (MutableState) obj7;
                MutableState mutableState2 = (MutableState) obj5;
                MusicDatabase musicDatabase = (MusicDatabase) obj2;
                Function0 function0 = (Function0) obj;
                String str = song.song.uploadEntityId;
                if (str != null) {
                    mutableState2.setValue(Boolean.TRUE);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new DownloadUtil.AnonymousClass1(str, musicDatabase, song, context, function0, mutableState2, mutableState, null), 2);
                } else {
                    Toast.makeText(context, R.string.delete_uploaded_song_failed, 0).show();
                    mutableState.setValue(Boolean.FALSE);
                }
                break;
            case 1:
                Context context2 = (Context) obj3;
                String str2 = (String) obj4;
                String str3 = (String) obj6;
                String str4 = (String) obj5;
                String str5 = (String) obj2;
                MutableState mutableState3 = (MutableState) obj7;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                MediaMetadata mediaMetadata = (MediaMetadata) ((State) obj).getValue();
                String strM = Fragment$5$$ExternalSyntheticOutline0.m("https://music.youtube.com/watch?v=", mediaMetadata != null ? mediaMetadata.id : null);
                StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("\"", str3, "\"\n\n", str4, " - ");
                sbM.append(str5);
                sbM.append("\n");
                sbM.append(strM);
                intent.putExtra("android.intent.extra.TEXT", sbM.toString());
                context2.startActivity(Intent.createChooser(intent, str2));
                mutableState3.setValue(Boolean.FALSE);
                break;
            case 2:
                ((MutableState) obj7).setValue(Boolean.FALSE);
                AwaitKt.launch$default((CoroutineScope) obj6, null, null, new RealImageLoader$execute$result$1(obj2, obj4, obj, obj5, obj3, (Continuation) null, (byte) 11), 3);
                break;
            case 3:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj6;
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope2, DefaultIoScheduler.INSTANCE, null, new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1((Function0) obj, (SnapshotStateList) obj4, (Function1) obj3, coroutineScope2, (Function1) obj7, (Function1) obj5, (MusicDatabase) obj2, null), 2);
                break;
            case 4:
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj4;
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj6;
                Context context3 = (Context) obj3;
                MutableState mutableState4 = (MutableState) obj7;
                State state = (State) obj;
                String str6 = mediaMetadata2.id;
                String str7 = ((TextFieldValue) obj5).annotatedString.text;
                String str8 = ((TextFieldValue) obj2).annotatedString.text;
                int i = mediaMetadata2.duration;
                MediaMetadata.Album album = mediaMetadata2.album;
                String str9 = album != null ? album.title : null;
                str6.getClass();
                str7.getClass();
                str8.getClass();
                StateFlowImpl stateFlowImpl = lyricsMenuViewModel.isLoading;
                Boolean bool = Boolean.TRUE;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, bool);
                StateFlowImpl stateFlowImpl2 = lyricsMenuViewModel.results;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, EmptyList.INSTANCE);
                StandaloneCoroutine standaloneCoroutine = lyricsMenuViewModel.job;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(lyricsMenuViewModel);
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                lyricsMenuViewModel.job = AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new LyricsMenuViewModel$search$1(lyricsMenuViewModel, str6, str7, str8, i, str9, null), 2);
                mutableState4.setValue(bool);
                if (!((Boolean) state.getValue()).booleanValue()) {
                    Toast.makeText(context3, context3.getString(R.string.error_no_internet), 0).show();
                }
                break;
            case 5:
                CoroutineScope coroutineScope3 = (CoroutineScope) obj6;
                MutableState mutableState5 = (MutableState) obj5;
                MutableState mutableState6 = (MutableState) obj4;
                LoginJsInterface loginJsInterface = (LoginJsInterface) obj2;
                Context context4 = (Context) obj3;
                MutableState mutableState7 = (MutableState) obj;
                YouTubeAccount youTubeAccount = (YouTubeAccount) ((MutableState) obj7).getValue();
                if (youTubeAccount != null) {
                    if (!youTubeAccount.isSelected) {
                        String strConcat = youTubeAccount.signinUrl;
                        if (strConcat != null) {
                            if (!StringsKt__StringsJVMKt.startsWith(strConcat, "http://", false) && !StringsKt__StringsJVMKt.startsWith(strConcat, "https://", false)) {
                                strConcat = StringsKt__StringsJVMKt.startsWith(strConcat, "/", false) ? "https://music.youtube.com".concat(strConcat) : "https://music.youtube.com/".concat(strConcat);
                            }
                            mutableState5.setValue(LoginStage.SwitchingAccount);
                            WebView webView = (WebView) mutableState6.getValue();
                            if (webView != null) {
                                webView.loadUrl(strConcat);
                            }
                        }
                    } else {
                        mutableState5.setValue(LoginStage.Completing);
                        AwaitKt.launch$default(coroutineScope3, null, null, new NetworkFetcher$doFetch$fetchResult$1(mutableState6, loginJsInterface, context4, mutableState7, mutableState5, null, (byte) 6), 3);
                    }
                }
                break;
            default:
                MutableState mutableState8 = (MutableState) obj7;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj6;
                MutableState mutableState9 = (MutableState) obj5;
                MutableState mutableState10 = (MutableState) obj4;
                MutableState mutableState11 = (MutableState) obj3;
                MutableState mutableState12 = (MutableState) obj2;
                String str10 = (String) obj;
                if (!((Boolean) mutableState8.getValue()).booleanValue()) {
                    AwaitKt.launch$default(coroutineScope4, null, null, new QueueMenuKt$QueueMenu$7$1$1$1(mutableState8, mutableState9, mutableState10, mutableState11, mutableState12, str10, (Continuation) null), 3);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(Context context, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, Song song, Function0 function0, CoroutineScope coroutineScope) {
        this.f$0 = song;
        this.f$1 = context;
        this.f$2 = coroutineScope;
        this.f$3 = mutableState;
        this.f$4 = mutableState2;
        this.f$5 = musicDatabase;
        this.f$6 = function0;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(Context context, String str, String str2, String str3, String str4, State state, MutableState mutableState) {
        this.f$1 = context;
        this.f$0 = str;
        this.f$2 = str2;
        this.f$4 = str3;
        this.f$5 = str4;
        this.f$6 = state;
        this.f$3 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, String str) {
        this.f$3 = mutableState;
        this.f$2 = coroutineScope;
        this.f$4 = mutableState2;
        this.f$0 = mutableState3;
        this.f$1 = mutableState4;
        this.f$5 = mutableState5;
        this.f$6 = str;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(SnapshotStateList snapshotStateList, MusicDatabase musicDatabase, Function0 function0, Function1 function1, Function1 function2, Function1 function3, CoroutineScope coroutineScope) {
        this.f$2 = coroutineScope;
        this.f$6 = function0;
        this.f$0 = snapshotStateList;
        this.f$1 = function1;
        this.f$3 = function2;
        this.f$4 = function3;
        this.f$5 = musicDatabase;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(LyricsMenuViewModel lyricsMenuViewModel, MediaMetadata mediaMetadata, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, Context context, MutableState mutableState, State state) {
        this.f$0 = lyricsMenuViewModel;
        this.f$2 = mediaMetadata;
        this.f$4 = textFieldValue;
        this.f$5 = textFieldValue2;
        this.f$1 = context;
        this.f$3 = mutableState;
        this.f$6 = state;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda29(CoroutineScope coroutineScope, MutableState mutableState, MusicDatabase musicDatabase, AddToPlaylistPosition addToPlaylistPosition, Function0 function0, MutableState mutableState2, MutableState mutableState3) {
        this.f$2 = coroutineScope;
        this.f$3 = mutableState;
        this.f$5 = musicDatabase;
        this.f$0 = addToPlaylistPosition;
        this.f$6 = function0;
        this.f$4 = mutableState2;
        this.f$1 = mutableState3;
    }
}
