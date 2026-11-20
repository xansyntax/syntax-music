package com.metrolist.music;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.compose.ComponentActivityKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.app.NavUtils;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.datastore.core.AtomicInt;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.media3.common.FlagSet;
import androidx.media3.extractor.flv.TagPayloadReader;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.concurrent.FileLock;
import coil3.compose.AsyncImagePainter;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.ListenTogetherManager$initialize$1;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.screens.settings.DarkMode;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories$ActivityEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.internal.LazyClassKeyMap;
import io.ktor.client.utils.CIOKt;
import io.ktor.utils.io.ByteChannelKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends FragmentActivity implements GeneratedComponentManager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ParcelableSnapshotMutableState appReady$delegate;
    public volatile ActivityComponentManager componentManager;
    public MusicDatabase database;
    public DownloadUtil downloadUtil;
    public boolean isServiceBound;
    public final ParcelableSnapshotMutableState latestVersionName$delegate;
    public ListenTogetherManager listenTogetherManager;
    public Intent pendingIntent;
    public PlayerConnection playerConnection;
    public final ParcelableSnapshotMutableState playerConnectionSnapshot$delegate;
    public final MainActivity$serviceConnection$1 serviceConnection;
    public SyncUtils syncUtils;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    /* JADX WARN: Type inference failed for: r0v9, types: [com.metrolist.music.MainActivity$serviceConnection$1] */
    public MainActivity() {
        addOnContextAvailableListener(new Hilt_MainActivity$1(this, (byte) 0));
        this.latestVersionName$delegate = Stack.mutableStateOf$default("4.1.0");
        this.appReady$delegate = Stack.mutableStateOf$default(Boolean.valueOf(DialogKt.shown));
        this.playerConnectionSnapshot$delegate = Stack.mutableStateOf$default(null);
        this.serviceConnection = new ServiceConnection() { // from class: com.metrolist.music.MainActivity$serviceConnection$1
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder instanceof MusicService.MusicBinder) {
                    MusicService.MusicBinder musicBinder = (MusicService.MusicBinder) iBinder;
                    MainActivity mainActivity = this.this$0;
                    MusicDatabase musicDatabase = mainActivity.database;
                    if (musicDatabase == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("database");
                        throw null;
                    }
                    PlayerConnection playerConnection = new PlayerConnection(mainActivity, musicBinder, musicDatabase, ViewModelKt.getCoroutineScope(mainActivity.getLifecycle()));
                    mainActivity.playerConnection = playerConnection;
                    mainActivity.playerConnectionSnapshot$delegate.setValue(playerConnection);
                    mainActivity.getListenTogetherManager().setPlayerConnection(mainActivity.playerConnection);
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                MainActivity mainActivity = this.this$0;
                mainActivity.getListenTogetherManager().setPlayerConnection(null);
                PlayerConnection playerConnection = mainActivity.playerConnection;
                if (playerConnection != null) {
                    playerConnection.dispose();
                }
            }
        };
    }

    public static void handleRecognitionIntent(Intent intent, NavHostController navHostController) {
        if (Intrinsics.areEqual(intent.getAction(), "com.metrolist.music.action.RECOGNITION")) {
            boolean booleanExtra = intent.getBooleanExtra("auto_start_recognition", false);
            intent.setAction(null);
            intent.removeExtra("auto_start_recognition");
            navHostController.navigate(booleanExtra ? "recognition?autoStart=true" : "recognition", new KuGouKt$$ExternalSyntheticLambda0((byte) 16));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void handleWidgetTargetIntent(Intent intent, NavHostController navHostController) {
        if (Intrinsics.areEqual(intent.getAction(), "com.metrolist.music.action.OPEN_WIDGET_TARGET")) {
            String stringExtra = intent.getStringExtra("widget_target_type");
            final String stringExtra2 = intent.getStringExtra("widget_target_id");
            TagPayloadReader tagPayloadReader = null;
            intent.setAction(null);
            intent.removeExtra("widget_target_type");
            intent.removeExtra("widget_target_id");
            if (stringExtra2 == null || StringsKt.isBlank(stringExtra2)) {
                stringExtra2 = null;
            }
            if (stringExtra != null) {
                switch (stringExtra.hashCode()) {
                    case -1012222381:
                        if (stringExtra.equals("online") && stringExtra2 != null) {
                            tagPayloadReader = new TagPayloadReader(stringExtra2) { // from class: com.metrolist.music.MainActivity$WidgetTargetRoute$OnlinePlaylist
                                public final String id;

                                {
                                    super("online_playlist/".concat(stringExtra2));
                                    this.id = stringExtra2;
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof MainActivity$WidgetTargetRoute$OnlinePlaylist) && this.id.equals(((MainActivity$WidgetTargetRoute$OnlinePlaylist) obj).id);
                                }

                                public final int hashCode() {
                                    return this.id.hashCode();
                                }

                                public final String toString() {
                                    return IntIntPair$$ExternalSyntheticOutline0.m("OnlinePlaylist(id=", this.id, ")");
                                }
                            };
                        }
                        break;
                    case 115029:
                        if (stringExtra.equals("top")) {
                            if (stringExtra2 == null) {
                                stringExtra2 = "50";
                            }
                            tagPayloadReader = new TagPayloadReader(stringExtra2) { // from class: com.metrolist.music.MainActivity$WidgetTargetRoute$TopSongs
                                public final String limit;

                                {
                                    super("top_playlist/".concat(stringExtra2));
                                    this.limit = stringExtra2;
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof MainActivity$WidgetTargetRoute$TopSongs) && this.limit.equals(((MainActivity$WidgetTargetRoute$TopSongs) obj).limit);
                                }

                                public final int hashCode() {
                                    return this.limit.hashCode();
                                }

                                public final String toString() {
                                    return IntIntPair$$ExternalSyntheticOutline0.m("TopSongs(limit=", this.limit, ")");
                                }
                            };
                        }
                        break;
                    case 102974381:
                        if (stringExtra.equals("liked")) {
                            tagPayloadReader = MainActivity$WidgetTargetRoute$LikedSongs.INSTANCE;
                        }
                        break;
                    case 103145323:
                        if (stringExtra.equals("local") && stringExtra2 != null) {
                            tagPayloadReader = new TagPayloadReader(stringExtra2) { // from class: com.metrolist.music.MainActivity$WidgetTargetRoute$LocalPlaylist
                                public final String id;

                                {
                                    super("local_playlist/".concat(stringExtra2));
                                    this.id = stringExtra2;
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof MainActivity$WidgetTargetRoute$LocalPlaylist) && this.id.equals(((MainActivity$WidgetTargetRoute$LocalPlaylist) obj).id);
                                }

                                public final int hashCode() {
                                    return this.id.hashCode();
                                }

                                public final String toString() {
                                    return IntIntPair$$ExternalSyntheticOutline0.m("LocalPlaylist(id=", this.id, ")");
                                }
                            };
                        }
                        break;
                    case 2039141159:
                        if (stringExtra.equals("downloaded")) {
                            tagPayloadReader = MainActivity$WidgetTargetRoute$DownloadedSongs.INSTANCE;
                        }
                        break;
                }
            }
            if (tagPayloadReader == null) {
                return;
            }
            NavHostController.navigate$default(navHostController, (String) tagPayloadReader.output);
        }
    }

    public final void MetrolistApp(String str, Function1 function1, PlayerConnection playerConnection, MusicDatabase musicDatabase, DownloadUtil downloadUtil, SyncUtils syncUtils, Composer composer, int i) {
        int i2;
        GapComposer gapComposer;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1;
        MutableState mutableState;
        MutableState mutableState2;
        PlayerConnection playerConnection2 = playerConnection;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1114761166);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer2.changed(playerConnection2) : gapComposer2.changedInstance(playerConnection2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? gapComposer2.changed(musicDatabase) : gapComposer2.changedInstance(musicDatabase) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? gapComposer2.changed(downloadUtil) : gapComposer2.changedInstance(downloadUtil) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= (262144 & i) == 0 ? gapComposer2.changed(syncUtils) : gapComposer2.changedInstance(syncUtils) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changedInstance(this) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            Preferences$Key preferences$Key = PreferenceKeysKt.CheckForUpdatesKey;
            Boolean bool = Boolean.TRUE;
            UtilsKt.rememberPreference(preferences$Key, bool, gapComposer2, 48);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            Boolean bool2 = Boolean.FALSE;
            gapComposer2.startReplaceGroup(1167065940);
            gapComposer2.end(false);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.DynamicThemeKey, bool2, gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.EnableHighRefreshRateKey, bool, gapComposer2, 48);
            Boolean bool3 = (Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue();
            bool3.getClass();
            boolean zChangedInstance = gapComposer2.changedInstance(this) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new DownloadUtil.AnonymousClass2(this, dataStoreKt$rememberPreference$1$1RememberPreference2, null, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer2, bool3, (Function2) objRememberedValue2);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.DarkModeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key2, (byte) 0));
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            DarkMode darkMode = DarkMode.AUTO;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue4, darkMode, gapComposer2, 48);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key2);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2) objRememberedValue5;
            boolean zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
            boolean zChanged = gapComposer2.changed(((DarkMode) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.getValue()).ordinal()) | gapComposer2.changed(zIsSystemInDarkTheme);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                if (((DarkMode) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.getValue()) != darkMode) {
                    zIsSystemInDarkTheme = ((DarkMode) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.getValue()) == DarkMode.ON;
                }
                objRememberedValue6 = Boolean.valueOf(zIsSystemInDarkTheme);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            Boolean bool4 = (Boolean) objRememberedValue6;
            boolean zBooleanValue = bool4.booleanValue();
            boolean zChangedInstance2 = gapComposer2.changedInstance(this) | gapComposer2.changed(zBooleanValue);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new AnonymousClass1(this, zBooleanValue, (Continuation) null);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            Stack.LaunchedEffect(gapComposer2, bool4, (Function2) objRememberedValue7);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = UtilsKt.rememberPreference(PreferenceKeysKt.EnableLandscapeScalingKey, bool2, gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = UtilsKt.rememberPreference(PreferenceKeysKt.DensityScaleKey, Float.valueOf(1.0f), gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference5 = UtilsKt.rememberPreference(PreferenceKeysKt.PureBlackKey, bool2, gapComposer2, 48);
            boolean zChanged2 = gapComposer2.changed(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference5.$state.getValue()).booleanValue()) | gapComposer2.changed(zBooleanValue);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = Boolean.valueOf(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference5.$state.getValue()).booleanValue() && zBooleanValue);
                gapComposer2.updateRememberedValue(objRememberedValue8);
            }
            boolean zBooleanValue2 = ((Boolean) objRememberedValue8).booleanValue();
            Preferences$Key preferences$Key3 = PreferenceKeysKt.UiStyleKey;
            Context context2 = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue9;
            Object objRememberedValue10 = gapComposer2.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context2).getData(), preferences$Key3, (byte) 1));
                gapComposer2.updateRememberedValue(objRememberedValue10);
            }
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue10, UiStyle.EDITORIAL, gapComposer2, 48);
            Object objRememberedValue11 = gapComposer2.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context2, preferences$Key3);
                gapComposer2.updateRememberedValue(objRememberedValue11);
            }
            MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) objRememberedValue11;
            Preferences$Key preferences$Key4 = PreferenceKeysKt.SelectedThemeColorKey;
            Shapes shapes = ThemeKt.EditorialShapes;
            final long jIntValue = ((long) ((Number) UtilsKt.rememberPreference(preferences$Key4, Integer.valueOf(ColorKt.m498toArgb8_81llA(-17343425833598976L)), gapComposer2, 0).$state.getValue()).intValue()) << 32;
            Object[] objArr = new Object[0];
            Object objRememberedValue12 = gapComposer2.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = new LastFM$$ExternalSyntheticLambda1((byte) 16);
                gapComposer2.updateRememberedValue(objRememberedValue12);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue12, gapComposer2, 48);
            Object[] objArr2 = new Object[0];
            Path.Companion companion = ThemeKt.ColorSaver;
            boolean zChanged3 = gapComposer2.changed(jIntValue);
            Object objRememberedValue13 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new Function0() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int i3 = MainActivity.$r8$clinit;
                        return Stack.mutableStateOf$default(new Color(jIntValue));
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue13);
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) companion, (Function0) objRememberedValue13, (Composer) gapComposer2, 0);
            Object objRememberedValue14 = gapComposer2.rememberedValue();
            if (objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = new LinkedHashMap();
                gapComposer2.updateRememberedValue(objRememberedValue14);
            }
            Map map = (Map) objRememberedValue14;
            Color color = new Color(jIntValue);
            boolean zChanged4 = gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changed(mutableStateRememberSaveable) | gapComposer2.changed(jIntValue);
            Object objRememberedValue15 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = new MainActivity$MetrolistApp$4$1(jIntValue, dataStoreKt$rememberPreference$1$1RememberPreference, mutableStateRememberSaveable, (Continuation) null);
                dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference;
                mutableState = mutableStateRememberSaveable;
                gapComposer2.updateRememberedValue(objRememberedValue15);
            } else {
                mutableState = mutableStateRememberSaveable;
                dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference;
            }
            Stack.LaunchedEffect(gapComposer2, color, (Function2) objRememberedValue15);
            Boolean bool5 = (Boolean) dataStoreKt$rememberPreference$1$1.getValue();
            bool5.getClass();
            Color color2 = new Color(jIntValue);
            boolean zChanged5 = ((i2 & 896) == 256 || ((i2 & 512) != 0 && gapComposer2.changedInstance(playerConnection2))) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1) | gapComposer2.changed(mutableState) | gapComposer2.changed(jIntValue) | gapComposer2.changedInstance(map) | gapComposer2.changedInstance(this);
            Object objRememberedValue16 = gapComposer2.rememberedValue();
            if (zChanged5 || objRememberedValue16 == neverEqualPolicy) {
                MutableState mutableState5 = mutableState;
                MainActivity$MetrolistApp$5$1 mainActivity$MetrolistApp$5$1 = new MainActivity$MetrolistApp$5$1(playerConnection2, jIntValue, dataStoreKt$rememberPreference$1$1, mutableState5, map, this, (Continuation) null);
                playerConnection2 = playerConnection2;
                mutableState2 = mutableState5;
                gapComposer2.updateRememberedValue(mainActivity$MetrolistApp$5$1);
                objRememberedValue16 = mainActivity$MetrolistApp$5$1;
            } else {
                mutableState2 = mutableState;
            }
            Stack.LaunchedEffect(playerConnection2, bool5, color2, (Function2) objRememberedValue16, gapComposer2);
            gapComposer = gapComposer2;
            ThemeKt.m1515MetrolistThemeT042LqI(zBooleanValue, zBooleanValue2, ((Color) mutableState2.getValue()).value, (UiStyle) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.getValue(), Expect_jvmKt.rememberComposableLambda(-1417960629, new MainActivity$$ExternalSyntheticLambda14(dataStoreKt$rememberPreference$1$1RememberPreference3, dataStoreKt$rememberPreference$1$1RememberPreference4, zBooleanValue2, playerConnection2, this, musicDatabase, downloadUtil, syncUtils, mutableState4, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, str, mutableState3), gapComposer2), gapComposer, 24576, 0);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda15(this, str, function1, playerConnection, musicDatabase, downloadUtil, syncUtils, i, (byte) 0);
        }
    }

    public final ActivityComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                try {
                    if (this.componentManager == null) {
                        this.componentManager = new ActivityComponentManager(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.componentManager;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider$Factory defaultViewModelProviderFactory = super.getDefaultViewModelProviderFactory();
        DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl = (DaggerApp_HiltComponents_SingletonC$ActivityCImpl) ((DefaultViewModelFactories$ActivityEntryPoint) EntryPoints.get(this, DefaultViewModelFactories$ActivityEntryPoint.class));
        LazyClassKeyMap viewModelKeys = daggerApp_HiltComponents_SingletonC$ActivityCImpl.getViewModelKeys();
        FileLock fileLock = new FileLock(daggerApp_HiltComponents_SingletonC$ActivityCImpl.singletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityCImpl.activityRetainedCImpl);
        defaultViewModelProviderFactory.getClass();
        return new HiltViewModelFactory(viewModelKeys, defaultViewModelProviderFactory, fileLock);
    }

    public final ListenTogetherManager getListenTogetherManager() {
        ListenTogetherManager listenTogetherManager = this.listenTogetherManager;
        if (listenTogetherManager != null) {
            return listenTogetherManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listenTogetherManager");
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x019b  */
    /* JADX WARN: Code duplicated, block: B:95:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ad  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0105, code lost:
    
        if (r1.equals("channel") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010e, code lost:
    
        if (r1.equals("c") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0111, code lost:
    
        r9 = r0.getLastPathSegment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0115, code lost:
    
        if (r9 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0117, code lost:
    
        androidx.navigation.NavHostController.navigate$default(r11, "artist/".concat(r9));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleDeepLinkIntent(Intent intent, NavHostController navHostController) {
        String str;
        String queryParameter;
        String queryParameter2;
        String host;
        String string;
        Uri data = intent.getData();
        Continuation continuation = null;
        if (data == null) {
            Bundle extras = intent.getExtras();
            data = (extras == null || (string = extras.getString("android.intent.extra.TEXT")) == null) ? null : Uri.parse(string);
            if (data == null) {
                return;
            }
        }
        intent.setData(null);
        intent.removeExtra("android.intent.extra.TEXT");
        LifecycleCoroutineScopeImpl coroutineScope = ViewModelKt.getCoroutineScope(getLifecycle());
        String queryParameter3 = data.getQueryParameter("code");
        boolean z = true;
        if (queryParameter3 == null && (queryParameter3 = data.getQueryParameter("room")) == null) {
            List<String> pathSegments = data.getPathSegments();
            pathSegments.getClass();
            queryParameter3 = (String) CollectionsKt.getOrNull(1, pathSegments);
        }
        List<String> pathSegments2 = data.getPathSegments();
        pathSegments2.getClass();
        if (!Intrinsics.areEqual(CollectionsKt.firstOrNull((List) pathSegments2), "listen") && ((host = data.getHost()) == null || !host.equalsIgnoreCase("listen"))) {
            z = false;
        }
        if (queryParameter3 != null && !StringsKt.isBlank(queryParameter3) && z) {
            CharSequence charSequence = (CharSequence) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.ListenTogetherUsernameKey, "");
            if (StringsKt.isBlank(charSequence)) {
                charSequence = "Guest";
            }
            getListenTogetherManager().joinRoom(queryParameter3, (String) charSequence);
            return;
        }
        List<String> pathSegments3 = data.getPathSegments();
        pathSegments3.getClass();
        String str2 = (String) CollectionsKt.firstOrNull((List) pathSegments3);
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1380604278:
                    if (str2.equals("browse")) {
                        String lastPathSegment = data.getLastPathSegment();
                        if (lastPathSegment != null) {
                            NavHostController.navigate$default(navHostController, "album/".concat(lastPathSegment));
                        }
                    }
                    break;
                case -906336856:
                    if (str2.equals("search")) {
                        String queryParameter4 = data.getQueryParameter("q");
                        if (queryParameter4 != null) {
                            NavHostController.navigate$default(navHostController, "search/" + Uri.encode("__metrolist_search_query__".concat(queryParameter4)));
                        }
                    }
                    break;
                case 99:
                    break;
                case 738950403:
                    break;
                case 1879474642:
                    if (str2.equals("playlist")) {
                        String queryParameter5 = data.getQueryParameter("list");
                        if (queryParameter5 == null || StringsKt.isBlank(queryParameter5) || queryParameter5.equalsIgnoreCase("null")) {
                            Toast.makeText(this, R.string.playlist_unavailable, 0).show();
                        } else if (!StringsKt__StringsJVMKt.startsWith(queryParameter5, "OLAK5uy_", false)) {
                            NavHostController.navigate$default(navHostController, "online_playlist/".concat(queryParameter5));
                        } else {
                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                            AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1(queryParameter5, navHostController, continuation, (byte) 11), 2);
                        }
                    }
                    break;
            }
        }
        if (!Intrinsics.areEqual(str2, "watch")) {
            if (Intrinsics.areEqual(data.getHost(), "youtu.be")) {
                List<String> pathSegments4 = data.getPathSegments();
                pathSegments4.getClass();
                queryParameter = (String) CollectionsKt.firstOrNull((List) pathSegments4);
            } else {
                str = null;
            }
            queryParameter2 = data.getQueryParameter("list");
            if (str != null) {
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new NavHostKt$NavHost$29$1((Object) str, (Object) queryParameter2, (Object) this, continuation, (byte) 7), 2);
            } else if (queryParameter2 != null) {
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1(queryParameter2, this, continuation, (byte) 12), 2);
            }
        }
        queryParameter = data.getQueryParameter("v");
        str = queryParameter;
        queryParameter2 = data.getQueryParameter("list");
        if (str != null) {
            DefaultScheduler defaultScheduler4 = Dispatchers.Default;
            AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new NavHostKt$NavHost$29$1((Object) str, (Object) queryParameter2, (Object) this, continuation, (byte) 7), 2);
        } else if (queryParameter2 != null) {
            DefaultScheduler defaultScheduler5 = Dispatchers.Default;
            AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new AsyncImagePainter.AnonymousClass1(queryParameter2, this, continuation, (byte) 12), 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006c  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Locale localeForLanguageTag;
        onCreate$com$metrolist$music$Hilt_MainActivity(bundle);
        byte b = 0;
        getWindow().getDecorView().setLayoutDirection(0);
        MathKt.setDecorFitsSystemWindows(getWindow(), false);
        ListenTogetherManager listenTogetherManager = getListenTogetherManager();
        ContextScope contextScope = listenTogetherManager.scope;
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        StandaloneCoroutine standaloneCoroutine = listenTogetherManager.eventCollectorJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        listenTogetherManager.eventCollectorJob = AwaitKt.launch$default(contextScope, null, null, new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, b), 3);
        AwaitKt.launch$default(contextScope, null, null, new ListenTogetherManager$initialize$1(listenTogetherManager, continuation, (byte) 2), 3);
        if (Build.VERSION.SDK_INT < 33) {
            String str = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.AppLanguageKey);
            if (str == null) {
                localeForLanguageTag = Locale.getDefault();
            } else {
                if (str.equals("SYSTEM_DEFAULT")) {
                    str = null;
                }
                if (str == null || (localeForLanguageTag = Locale.forLanguageTag(str)) == null) {
                    localeForLanguageTag = Locale.getDefault();
                }
            }
            localeForLanguageTag.getClass();
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.setLocale(localeForLanguageTag);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        AwaitKt.launch$default(ViewModelKt.getCoroutineScope(getLifecycle()), null, null, new AnonymousClass1(this, continuation, b), 3);
        LifecycleCoroutineScopeImpl coroutineScope = ViewModelKt.getCoroutineScope(getLifecycle());
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new SimpleActor$offer$2(this, continuation, (byte) 10), 2);
        AwaitKt.launch$default(ViewModelKt.getCoroutineScope(getLifecycle()), defaultIoScheduler, null, new AnonymousClass1(this, continuation, (byte) 4), 2);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(true, 1140052535, new MainActivity$$ExternalSyntheticLambda0(b, this)));
        if (DialogKt.shown) {
            return;
        }
        ComposeView composeView = new ComposeView(this);
        composeView.setContent(new ComposableLambdaImpl(true, 1228217350, new MainActivity$$ExternalSyntheticLambda1(this, composeView, b)));
        addContentView(composeView, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void onCreate$com$metrolist$music$Hilt_MainActivity(Bundle bundle) {
        super.onCreate(bundle);
        ActivityComponentManager activityComponentManagerComponentManager = componentManager();
        ActivityRetainedComponentManager activityRetainedComponentManager = activityComponentManagerComponentManager.activityRetainedComponentManager;
        MainActivity mainActivity = activityRetainedComponentManager.viewModelStoreOwner;
        InitializerViewModelFactory initializerViewModelFactory = new InitializerViewModelFactory((byte) 2, activityRetainedComponentManager.context);
        ViewModelStore viewModelStore = mainActivity.getViewModelStore();
        CreationExtras viewModelCreationExtras = ViewModelKt.getViewModelCreationExtras(mainActivity);
        viewModelStore.getClass();
        viewModelCreationExtras.getClass();
        Dispatcher dispatcher = new Dispatcher(viewModelStore, initializerViewModelFactory, viewModelCreationExtras);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ActivityRetainedComponentManager.ActivityRetainedComponentViewModel.class);
        String qualifiedName = orCreateKotlinClass.getQualifiedName();
        if (qualifiedName == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
            return;
        }
        FlagSet.Builder builder = ((ActivityRetainedComponentManager.ActivityRetainedComponentViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName))).savedStateHandleHolder;
        activityComponentManagerComponentManager.activitySavedStateHandleHolder = builder;
        if (((CreationExtras) builder.flags) == null) {
            CreationExtras defaultViewModelCreationExtras = activityComponentManagerComponentManager.activity.getDefaultViewModelCreationExtras();
            if (builder.buildCalled) {
                builder.flags = defaultViewModelCreationExtras;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("setExtras should only be called for an Activity that extends ComponentActivity");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054 A[PHI: r1
      0x0054: PHI (r1v5 com.metrolist.music.playback.PlayerConnection) = (r1v4 com.metrolist.music.playback.PlayerConnection), (r1v7 com.metrolist.music.playback.PlayerConnection) binds: [B:25:0x0071, B:19:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        PlayerConnection playerConnection;
        if (isFinishing()) {
            getListenTogetherManager().disconnect();
        }
        onDestroy$com$metrolist$music$Hilt_MainActivity();
        boolean z = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.StopMusicOnTaskClearKey, Boolean.FALSE)).booleanValue() && isFinishing();
        PlayerConnection playerConnection2 = this.playerConnection;
        if (playerConnection2 != null) {
            playerConnection2.dispose();
        }
        this.playerConnection = null;
        this.playerConnectionSnapshot$delegate.setValue(null);
        if (this.isServiceBound) {
            try {
                try {
                    unbindService(this.serviceConnection);
                    this.isServiceBound = false;
                    getListenTogetherManager().setPlayerConnection(null);
                    playerConnection = this.playerConnection;
                    if (playerConnection != null) {
                        playerConnection.dispose();
                    }
                } catch (IllegalArgumentException unused) {
                    Timber.Forest.tag("MainActivity");
                    ConnectionPool.w$1(new Object[0]);
                    this.isServiceBound = false;
                    getListenTogetherManager().setPlayerConnection(null);
                    playerConnection = this.playerConnection;
                    if (playerConnection != null) {
                        playerConnection.dispose();
                    }
                }
            } catch (Throwable th) {
                this.isServiceBound = false;
                getListenTogetherManager().setPlayerConnection(null);
                PlayerConnection playerConnection3 = this.playerConnection;
                if (playerConnection3 != null) {
                    playerConnection3.dispose();
                }
                throw th;
            }
        }
        if (z) {
            stopService(new Intent(this, (Class<?>) MusicService.class));
        }
    }

    public final void onDestroy$com$metrolist$music$Hilt_MainActivity() {
        super.onDestroy();
        FlagSet.Builder builder = componentManager().activitySavedStateHandleHolder;
        if (builder != null) {
            builder.flags = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        this.pendingIntent = intent;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 && NavUtils.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            NavUtils.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, CIOKt.DEFAULT_HTTP_POOL_SIZE);
        }
        boolean z = MusicService.isRunning;
        if (!MusicService.isRunning) {
            Intent intent = new Intent(this, (Class<?>) MusicService.class);
            try {
                if (i >= 31) {
                    startForegroundService(intent);
                } else {
                    startService(intent);
                }
            } catch (ForegroundServiceStartNotAllowedException unused) {
                Timber.Forest.getClass();
                ConnectionPool.w$1(new Object[0]);
            } catch (IllegalStateException unused2) {
                Timber.Forest.getClass();
                ConnectionPool.w$1(new Object[0]);
            }
        }
        if (this.isServiceBound) {
            return;
        }
        bindService(new Intent(this, (Class<?>) MusicService.class), this.serviceConnection, 1);
        this.isServiceBound = true;
    }

    /* JADX INFO: renamed from: com.metrolist.music.MainActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MainActivity mainActivity, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 1;
            this.this$0 = mainActivity;
            this.label = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MainActivity mainActivity = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1(mainActivity, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1(mainActivity, this.label, continuation);
                case 2:
                    return new AnonymousClass1(mainActivity, (AvailableUpdate) null, continuation);
                case 3:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(mainActivity, continuation, (byte) 3);
                    anonymousClass1.label = ((Boolean) obj).booleanValue();
                    return anonymousClass1;
                default:
                    return new AnonymousClass1(mainActivity, continuation, (byte) 4);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 2:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    Boolean bool = (Boolean) obj;
                    bool.booleanValue();
                    ((AnonymousClass1) create(bool, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                default:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LifecyclesKt windowInsetsControllerCompat$Impl30;
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            MainActivity mainActivity = this.this$0;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(mainActivity).getData(), (byte) 9));
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(mainActivity, continuation, (byte) 3);
                        this.label = true;
                        if (StateFlowKt.collectLatest(flowDistinctUntilChanged, anonymousClass1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    boolean z2 = this.label;
                    int i = MainActivity.$r8$clinit;
                    Window window = mainActivity.getWindow();
                    AtomicInt atomicInt = new AtomicInt(mainActivity.getWindow().getDecorView().getRootView());
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 35) {
                        windowInsetsControllerCompat$Impl30 = new WindowInsetsControllerCompat$Impl35(window, atomicInt);
                    } else {
                        windowInsetsControllerCompat$Impl30 = i2 >= 30 ? new WindowInsetsControllerCompat$Impl30(window, atomicInt) : new WindowInsetsControllerCompat$Impl26(window, atomicInt);
                    }
                    boolean z3 = !z2;
                    windowInsetsControllerCompat$Impl30.setAppearanceLightStatusBars(z3);
                    windowInsetsControllerCompat$Impl30.setAppearanceLightNavigationBars(z3);
                    return unit;
                case 2:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(null, null);
                        this.label = true;
                        if (UtilsKt.safeDataStoreEdit(mainActivity, recomposer$join$2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                case 3:
                    boolean z5 = this.label;
                    ResultKt.throwOnFailure(obj);
                    if (z5) {
                        mainActivity.getWindow().setFlags(8192, 8192);
                    } else {
                        mainActivity.getWindow().clearFlags(8192);
                    }
                    return unit;
                default:
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        Recomposer$join$2 recomposer$join$3 = new Recomposer$join$2(2, continuation, (byte) 6);
                        this.label = true;
                        if (UtilsKt.safeDataStoreEdit(mainActivity, recomposer$join$3, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(MainActivity mainActivity, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = mainActivity;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MainActivity mainActivity, AvailableUpdate availableUpdate, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 2;
            this.this$0 = mainActivity;
        }
    }
}
