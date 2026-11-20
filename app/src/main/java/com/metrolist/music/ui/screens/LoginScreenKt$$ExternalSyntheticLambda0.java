package com.metrolist.music.ui.screens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda8;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.ExoPlayerImpl;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.yalantis.ucrop.R;
import io.ktor.client.utils.CIOKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoginScreenKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ State f$8;

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda0(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, LoginJsInterface loginJsInterface, CoroutineScope coroutineScope, boolean z) {
        this.f$0 = loginJsInterface;
        this.f$1 = z;
        this.f$2 = context;
        this.f$3 = coroutineScope;
        this.f$4 = mutableState;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
        this.f$7 = mutableState4;
        this.f$8 = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$8;
        Object obj2 = this.f$7;
        Object obj3 = this.f$4;
        Object obj4 = this.f$6;
        Object obj5 = this.f$5;
        Object obj6 = this.f$3;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                final LoginJsInterface loginJsInterface = (LoginJsInterface) obj7;
                final CoroutineScope coroutineScope = (CoroutineScope) obj6;
                final MutableState mutableState = (MutableState) obj3;
                final MutableState mutableState2 = (MutableState) obj5;
                final MutableState mutableState3 = (MutableState) obj4;
                final MutableState mutableState4 = (MutableState) obj2;
                final MutableState mutableState5 = (MutableState) state;
                Context context = (Context) obj;
                context.getClass();
                WebView webView = new WebView(context);
                final Context context2 = this.f$2;
                final boolean z = this.f$1;
                webView.setWebViewClient(new WebViewClient() { // from class: com.metrolist.music.ui.screens.LoginScreenKt$LoginScreen$1$1$1$1$1
                    @Override // android.webkit.WebViewClient
                    public final void onPageFinished(WebView webView2, String str) {
                        webView2.getClass();
                        Uri uri = str != null ? Uri.parse(str) : null;
                        if (Intrinsics.areEqual(uri != null ? uri.getScheme() : null, "https") && Intrinsics.areEqual(uri.getHost(), "music.youtube.com")) {
                            MutableState mutableState6 = mutableState;
                            int iOrdinal = ((LoginStage) mutableState6.getValue()).ordinal();
                            if (iOrdinal == 0 || iOrdinal == 3) {
                                LoginStage loginStage = (LoginStage) mutableState6.getValue();
                                mutableState6.setValue(LoginStage.CheckingAccounts);
                                AwaitKt.launch$default(coroutineScope, null, null, new LoginScreenKt$LoginScreen$handleAuthenticatedPage$1(loginStage, mutableState2, loginJsInterface, context2, mutableState3, mutableState6, mutableState4, z, mutableState5, null), 3);
                            }
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                        webView2.getClass();
                        webResourceRequest.getClass();
                        String scheme = webResourceRequest.getUrl().getScheme();
                        if (Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, "https")) {
                            return false;
                        }
                        if (Intrinsics.areEqual(scheme, "intent")) {
                            Context context3 = context2;
                            try {
                                Intent uri = Intent.parseUri(webResourceRequest.getUrl().toString(), 1);
                                uri.addCategory("android.intent.category.BROWSABLE");
                                uri.setComponent(null);
                                uri.setSelector(null);
                                context3.startActivity(uri);
                            } catch (Throwable unused) {
                            }
                        }
                        return true;
                    }
                });
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setDisplayZoomControls(false);
                webView.addJavascriptInterface(loginJsInterface, "Android");
                mutableState2.setValue(webView);
                if (z) {
                    YouTube youTube = YouTube.INSTANCE;
                    String str = ((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).cookie;
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    Map cookieString = str != null ? StringsKt__IndentKt.parseCookieString(str) : null;
                    if (cookieString == null) {
                        cookieString = EmptyMap.INSTANCE;
                    }
                    for (Map.Entry entry : cookieString.entrySet()) {
                        cookieManager.setCookie("https://music.youtube.com", ((String) entry.getKey()) + "=" + ((String) entry.getValue()) + "; Domain=.youtube.com; Path=/; Secure");
                    }
                    cookieManager.flush();
                }
                webView.loadUrl(z ? "https://music.youtube.com" : "https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmusic.youtube.com");
                return webView;
            case 1:
                ArtistItem artistItem = (ArtistItem) obj7;
                MusicDatabase musicDatabase = (MusicDatabase) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1960084197, new TimePickerKt$$ExternalSyntheticLambda8(this.f$1, artistItem, (PlayerConnection) obj3, (Function0) obj5, (State) obj4, (CoroutineScope) obj6, musicDatabase, this.f$2, (byte) 3)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2008455378, new PlayerKt$$ExternalSyntheticLambda82(musicDatabase, state, artistItem, (byte) 7)), 3);
                return unit;
            default:
                PlayerConnection playerConnection = (PlayerConnection) obj7;
                LayoutDirection layoutDirection = (LayoutDirection) obj6;
                PointerInputScope pointerInputScope = (PointerInputScope) obj5;
                Function2 function2 = (Function2) obj4;
                MutableState mutableState6 = (MutableState) obj3;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj2;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) state;
                Offset offset = (Offset) obj;
                if (!this.f$1) {
                    long currentPosition = playerConnection.getPlayerSafe().getCurrentPosition();
                    long duration = playerConnection.getPlayerSafe().getDuration();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!((Boolean) mutableState6.getValue()).booleanValue() || jCurrentTimeMillis - parcelableSnapshotMutableLongState.getLongValue() >= 1000) {
                        parcelableSnapshotMutableIntState.setIntValue(1);
                    } else {
                        parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + 1);
                    }
                    parcelableSnapshotMutableLongState.setLongValue(jCurrentTimeMillis);
                    int intValue = parcelableSnapshotMutableIntState.getIntValue() * 5000;
                    LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                    Context context3 = this.f$2;
                    if ((layoutDirection != layoutDirection2 || Float.intBitsToFloat((int) (offset.packedValue >> 32)) >= ((int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32)) / 2) && (layoutDirection != LayoutDirection.Rtl || Float.intBitsToFloat((int) (offset.packedValue >> 32)) <= ((int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32)) / 2)) {
                        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                        long j = currentPosition + ((long) intValue);
                        if (j <= duration) {
                            duration = j;
                        }
                        playerSafe.seekToCurrentItem(duration);
                        String string = context3.getString(R.string.seek_forward_dynamic, Integer.valueOf(intValue / CIOKt.DEFAULT_HTTP_POOL_SIZE));
                        string.getClass();
                        function2.invoke(string, Boolean.TRUE);
                    } else {
                        ExoPlayerImpl playerSafe2 = playerConnection.getPlayerSafe();
                        long j2 = currentPosition - ((long) intValue);
                        if (j2 < 0) {
                            j2 = 0;
                        }
                        playerSafe2.seekToCurrentItem(j2);
                        String string2 = context3.getString(R.string.seek_backward_dynamic, Integer.valueOf(intValue / CIOKt.DEFAULT_HTTP_POOL_SIZE));
                        string2.getClass();
                        function2.invoke(string2, Boolean.TRUE);
                    }
                }
                return unit;
        }
    }

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda0(boolean z, ArtistItem artistItem, PlayerConnection playerConnection, Function0 function0, MutableState mutableState, CoroutineScope coroutineScope, MusicDatabase musicDatabase, Context context, MutableState mutableState2) {
        this.f$1 = z;
        this.f$0 = artistItem;
        this.f$4 = playerConnection;
        this.f$5 = function0;
        this.f$6 = mutableState;
        this.f$3 = coroutineScope;
        this.f$7 = musicDatabase;
        this.f$2 = context;
        this.f$8 = mutableState2;
    }

    public /* synthetic */ LoginScreenKt$$ExternalSyntheticLambda0(boolean z, PlayerConnection playerConnection, LayoutDirection layoutDirection, PointerInputScope pointerInputScope, Function2 function2, Context context, MutableState mutableState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
        this.f$1 = z;
        this.f$0 = playerConnection;
        this.f$3 = layoutDirection;
        this.f$5 = pointerInputScope;
        this.f$6 = function2;
        this.f$2 = context;
        this.f$4 = mutableState;
        this.f$7 = parcelableSnapshotMutableLongState;
        this.f$8 = parcelableSnapshotMutableIntState;
    }
}
