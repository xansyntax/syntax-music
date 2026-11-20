package com.metrolist.music;

import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.datastore.core.Data;
import androidx.datastore.core.Message$Update;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.media3.common.MediaItem;
import androidx.room.RoomDatabase;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.room.coroutines.PassthroughConnection;
import androidx.room.coroutines.PooledConnectionImpl;
import coil3.Extras;
import coil3.ImageLoader$Builder;
import coil3.RealImageLoader;
import coil3.SingletonImageLoader;
import coil3.disk.RealDiskCache;
import coil3.network.NetworkResponse;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.transition.Transition;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.ArtistConjunctions;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.cipher.QuickJsEngine;
import com.metrolist.innertubex.extraction.PlayerClientDirector;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.kugou.KuGou;
import com.metrolist.lastfm.LastFM;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.discord.DiscordGateway;
import com.metrolist.music.extensions.StringExtKt;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.PersistPlayerState;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.recognition.RecognitionForegroundService;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.CrashHandler;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.InitializedLazyImpl;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.ByteString;
import okio.FileSystem;
import okio.JvmSystemFileSystem;
import okio.Path;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class App extends Hilt_App implements SingletonImageLoader.Factory {
    public static final Companion Companion = new Companion();
    public CoroutineScope applicationScope;
    public volatile Integer cachedCoilCacheSize;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a2, code lost:
        
            if (kotlinx.coroutines.AwaitKt.withContext(r6, r7, r0) == r5) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object forgetAccount(Context context, Continuation continuation) throws IOException {
            App$Companion$forgetAccount$1 app$Companion$forgetAccount$1;
            if (continuation instanceof App$Companion$forgetAccount$1) {
                app$Companion$forgetAccount$1 = (App$Companion$forgetAccount$1) continuation;
                int i = app$Companion$forgetAccount$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    app$Companion$forgetAccount$1.label = i - Integer.MIN_VALUE;
                } else {
                    app$Companion$forgetAccount$1 = new App$Companion$forgetAccount$1(this, continuation);
                }
            } else {
                app$Companion$forgetAccount$1 = new App$Companion$forgetAccount$1(this, continuation);
            }
            Object objSafeDataStoreEdit = app$Companion$forgetAccount$1.result;
            int i2 = app$Companion$forgetAccount$1.label;
            byte b = 2;
            Continuation continuation2 = null;
            byte b2 = 0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objSafeDataStoreEdit);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objSafeDataStoreEdit);
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objSafeDataStoreEdit);
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            ConnectionPool.d(new Object[0]);
            Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(b, continuation2, b);
            app$Companion$forgetAccount$1.label = 1;
            objSafeDataStoreEdit = UtilsKt.safeDataStoreEdit(context, recomposer$join$2, app$Companion$forgetAccount$1);
            if (objSafeDataStoreEdit != coroutineSingletons) {
            }
            return coroutineSingletons;
            if (((Boolean) objSafeDataStoreEdit).booleanValue()) {
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
            } else {
                Timber.Forest.getClass();
                ConnectionPool.e(new Object[0]);
            }
            ConnectionPool.d(new Object[0]);
            YouTube youTube = YouTube.INSTANCE;
            YouTube.setCookie(null);
            YouTube.setVisitorData(null);
            YouTube.setDataSyncId(null);
            YouTube.setAuthUser("0");
            ConnectionPool.d(new Object[0]);
            ConnectionPool.d(new Object[0]);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
            App$Companion$forgetAccount$2 app$Companion$forgetAccount$2 = new App$Companion$forgetAccount$2(b, continuation2, b2);
            app$Companion$forgetAccount$1.label = 2;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.App$initializeSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public MutablePreferences L$0;
        public Exception L$6;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Companion companion = App.Companion;
            return App.this.initializeSettings(this);
        }
    }

    public final CoroutineScope getApplicationScope() {
        CoroutineScope coroutineScope = this.applicationScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationScope");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0221  */
    /* JADX WARN: Code duplicated, block: B:113:0x0248  */
    /* JADX WARN: Code duplicated, block: B:124:0x024e A[EDGE_INSN: B:124:0x024e->B:115:0x024e BREAK  A[LOOP:0: B:111:0x022a->B:126:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object initializeSettings(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        MutablePreferences mutablePreferences;
        String language;
        Map map;
        MutablePreferences mutablePreferences2;
        Exception exc;
        Object failure;
        boolean zBooleanValue;
        InnerTube innerTube;
        InnerTube.SessionSnapshot sessionSnapshot;
        InnerTube.SessionSnapshot sessionSnapshotCopy$default;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objFirst = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow data = UtilsKt.getDataStore(this).getData();
            anonymousClass1.label = 1;
            objFirst = StateFlowKt.first(data, anonymousClass1);
            if (objFirst != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objFirst);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            exc = anonymousClass1.L$6;
            mutablePreferences2 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFirst);
        }
        UtilsKt.reportException(exc);
        mutablePreferences = mutablePreferences2;
        YouTube youTube = YouTube.INSTANCE;
        Boolean bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.UseLoginForBrowse);
        zBooleanValue = bool != null ? bool.booleanValue() : true;
        innerTube = YouTube.innerTube.innerTubeX;
        do {
            sessionSnapshot = (InnerTube.SessionSnapshot) innerTube.session.get();
            sessionSnapshotCopy$default = InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, null, null, null, null, zBooleanValue, false, 0L, 447);
            if (!sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                break;
            }
        } while (!innerTube.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
        NotificationChannel notificationChannel = new NotificationChannel("updates", getString(R.string.update_channel_name), 3);
        notificationChannel.setDescription(getString(R.string.update_channel_desc));
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        return Unit.INSTANCE;
        mutablePreferences = (MutablePreferences) objFirst;
        Locale locale = Locale.getDefault();
        String language2 = locale.getLanguage();
        int i3 = ArtistConjunctions.$r8$clinit;
        List listListOf = CollectionsKt__IterablesKt.listOf(new Integer(R.string.and));
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            try {
                failure = getString(((Number) it.next()).intValue());
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            String str = (String) failure;
            if (str != null) {
                arrayList.add(str);
            }
        }
        YouTube youTube2 = YouTube.INSTANCE;
        String country = (String) mutablePreferences.get(PreferenceKeysKt.ContentCountryKey);
        if (country == null) {
            country = locale.getCountry();
            if (!PreferenceKeysKt.CountryCodeToName.containsKey(country)) {
                country = null;
            }
            if (country == null) {
                country = "US";
            }
        } else {
            if (country.equals("SYSTEM_DEFAULT")) {
                country = null;
            }
            if (country == null) {
                country = locale.getCountry();
                if (!PreferenceKeysKt.CountryCodeToName.containsKey(country)) {
                    country = null;
                }
                if (country == null) {
                    country = "US";
                }
            }
        }
        String str2 = (String) mutablePreferences.get(PreferenceKeysKt.ContentLanguageKey);
        if (str2 == null) {
            language = locale.getLanguage();
            map = PreferenceKeysKt.LanguageCodeToName;
            if (map.containsKey(language)) {
                str2 = language;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                if (map.containsKey(language2)) {
                    str2 = language2;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "en";
                }
            }
        } else {
            if (str2.equals("SYSTEM_DEFAULT")) {
                str2 = null;
            }
            if (str2 == null) {
                language = locale.getLanguage();
                map = PreferenceKeysKt.LanguageCodeToName;
                if (map.containsKey(language)) {
                    str2 = language;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    if (map.containsKey(language2)) {
                        str2 = language2;
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        str2 = "en";
                    }
                }
            }
        }
        YouTubeLocale youTubeLocale = new YouTubeLocale(country, str2);
        com.metrolist.innertube.InnerTube innerTube2 = YouTube.innerTube;
        innerTube2.getClass();
        innerTube2.innerTubeX.setLocale(youTubeLocale);
        if (Intrinsics.areEqual(language2, "zh-TW")) {
            KuGou kuGou = KuGou.INSTANCE;
        }
        LastFM lastFM = LastFM.INSTANCE;
        LastFM.API_KEY = "";
        LastFM.SECRET = "";
        if (Intrinsics.areEqual(mutablePreferences.get(PreferenceKeysKt.ProxyEnabledKey), Boolean.TRUE)) {
            final String str3 = (String) mutablePreferences.get(PreferenceKeysKt.ProxyUsernameKey);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = (String) mutablePreferences.get(PreferenceKeysKt.ProxyPasswordKey);
            final String str5 = str4 != null ? str4 : "";
            String str6 = (String) mutablePreferences.get(PreferenceKeysKt.ProxyTypeKey);
            Proxy.Type typeValueOf = Proxy.Type.HTTP;
            if (str6 != null) {
                try {
                    typeValueOf = Proxy.Type.valueOf(str6);
                } catch (IllegalArgumentException unused) {
                }
            }
            if (str3.length() > 0 || str5.length() > 0) {
                if (typeValueOf == Proxy.Type.HTTP) {
                    YouTube youTube3 = YouTube.INSTANCE;
                    Charset charset = Charsets.ISO_8859_1;
                    charset.getClass();
                    byte[] bytes = (str3 + ':' + str5).getBytes(charset);
                    bytes.getClass();
                    String strConcat = "Basic ".concat(new ByteString(bytes).base64());
                    com.metrolist.innertube.InnerTube innerTube3 = YouTube.innerTube;
                    if (!Intrinsics.areEqual(innerTube3.configuredProxyAuth, strConcat)) {
                        innerTube3.configuredProxyAuth = strConcat;
                        if (innerTube3.configuredProxy != null) {
                            innerTube3.recreateTransport();
                        }
                    }
                } else {
                    Authenticator.setDefault(new Authenticator() { // from class: com.metrolist.music.App.initializeSettings.10
                        @Override // java.net.Authenticator
                        public final PasswordAuthentication getPasswordAuthentication() {
                            char[] charArray = str5.toCharArray();
                            charArray.getClass();
                            return new PasswordAuthentication(str3, charArray);
                        }
                    });
                }
            }
            try {
                String str7 = (String) mutablePreferences.get(PreferenceKeysKt.ProxyUrlKey);
                if (str7 != null) {
                    YouTube youTube4 = YouTube.INSTANCE;
                    Regex regex = StringExtKt.combiningDiacriticalMarksRegex;
                    List listSplit$default = StringsKt.split$default(str7, new String[]{ServerSentEventKt.COLON}, 0, 6);
                    InetSocketAddress inetSocketAddressCreateUnresolved = InetSocketAddress.createUnresolved((String) listSplit$default.get(0), Integer.parseInt((String) listSplit$default.get(1)));
                    inetSocketAddressCreateUnresolved.getClass();
                    Proxy proxy = new Proxy(typeValueOf, inetSocketAddressCreateUnresolved);
                    com.metrolist.innertube.InnerTube innerTube4 = YouTube.innerTube;
                    if (!Intrinsics.areEqual(innerTube4.configuredProxy, proxy)) {
                        innerTube4.configuredProxy = proxy;
                        innerTube4.recreateTransport();
                    }
                }
            } catch (Exception e) {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                SyncUtils.AnonymousClass3 anonymousClass3 = new SyncUtils.AnonymousClass3(this, continuation, (byte) 9);
                anonymousClass1.L$0 = mutablePreferences;
                anonymousClass1.L$6 = e;
                anonymousClass1.label = 2;
                if (AwaitKt.withContext(handlerContext, anonymousClass3, anonymousClass1) != coroutineSingletons) {
                    mutablePreferences2 = mutablePreferences;
                    exc = e;
                    UtilsKt.reportException(exc);
                    mutablePreferences = mutablePreferences2;
                }
                return coroutineSingletons;
            }
        }
        YouTube youTube5 = YouTube.INSTANCE;
        Boolean bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.UseLoginForBrowse);
        zBooleanValue = bool2 != null ? bool2.booleanValue() : true;
        innerTube = YouTube.innerTube.innerTubeX;
        do {
            sessionSnapshot = (InnerTube.SessionSnapshot) innerTube.session.get();
            sessionSnapshotCopy$default = InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, null, null, null, null, zBooleanValue, false, 0L, 447);
            if (!sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                break;
                break;
            }
        } while (!innerTube.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
        NotificationChannel notificationChannel2 = new NotificationChannel("updates", getString(R.string.update_channel_name), 3);
        notificationChannel2.setDescription(getString(R.string.update_channel_desc));
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel2);
        return Unit.INSTANCE;
    }

    @Override // coil3.SingletonImageLoader.Factory
    public final RealImageLoader newImageLoader(Context context) {
        int iIntValue;
        context.getClass();
        Integer num = this.cachedCoilCacheSize;
        char c = 1;
        Continuation continuation = null;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            iIntValue = ((Number) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new App$observeSettingsChanges$1(this, continuation, c == true ? 1 : 0))).intValue();
        }
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(this);
        Extras.Key key = ImageRequestsKt.transformationsKey;
        Extras.Key key2 = ImageRequests_androidKt.transitionFactoryKey;
        ((Extras.Builder) imageLoader$Builder.extras).set(ImageRequests_androidKt.transitionFactoryKey, Transition.Factory.NONE);
        byte b = 0;
        ((Extras.Builder) imageLoader$Builder.extras).set(ImageRequests_androidKt.allowHardwareKey, Boolean.valueOf(Build.VERSION.SDK_INT >= 28));
        imageLoader$Builder.memoryCacheLazy = new SynchronizedLazyImpl(new App$$ExternalSyntheticLambda0(context, b));
        if (iIntValue == 0) {
            imageLoader$Builder.defaults = ImageRequest.Defaults.copy$default((ImageRequest.Defaults) imageLoader$Builder.defaults, null, 16351);
        } else {
            JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
            File cacheDir = getCacheDir();
            cacheDir.getClass();
            File fileResolve = FilesKt.resolve(cacheDir, "coil");
            String str = Path.DIRECTORY_SEPARATOR;
            Path path = Path.Companion.get$default(fileResolve);
            long j = ((long) (iIntValue * 1024)) * 1024;
            if (j <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("size must be > 0.");
                return null;
            }
            imageLoader$Builder.diskCacheLazy = new InitializedLazyImpl(new RealDiskCache(j, jvmSystemFileSystem, path));
            imageLoader$Builder.defaults = ImageRequest.Defaults.copy$default((ImageRequest.Defaults) imageLoader$Builder.defaults, null, 16319);
        }
        return imageLoader$Builder.build();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0067 A[SYNTHETIC] */
    @Override // com.metrolist.music.Hilt_App, android.app.Application
    public final void onCreate() {
        Object failure;
        String processName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Iterator<T> it;
        Object next;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        super.onCreate();
        byte b = 0;
        Continuation continuation = null;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        } else {
            try {
                failure = StringsKt.substringBefore$default(FilesKt.readText$default(new File("/proc/self/cmdline")), (char) 0);
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            processName = (String) failure;
            if (processName == null) {
                Object systemService = getSystemService("activity");
                systemService.getClass();
                runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    it = runningAppProcesses.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (((ActivityManager.RunningAppProcessInfo) next).pid != Process.myPid());
                    runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                    if (runningAppProcessInfo != null) {
                        processName = runningAppProcessInfo.processName;
                    } else {
                        processName = null;
                    }
                } else {
                    processName = null;
                }
            } else {
                if (StringsKt.isBlank(processName)) {
                    processName = null;
                }
                if (processName == null) {
                    Object systemService2 = getSystemService("activity");
                    systemService2.getClass();
                    runningAppProcesses = ((ActivityManager) systemService2).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        it = runningAppProcesses.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (((ActivityManager.RunningAppProcessInfo) next).pid != Process.myPid());
                        runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                        if (runningAppProcessInfo != null) {
                            processName = runningAppProcessInfo.processName;
                        } else {
                            processName = null;
                        }
                    } else {
                        processName = null;
                    }
                }
            }
        }
        if (Intrinsics.areEqual(processName, getPackageName())) {
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(applicationContext));
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            ArtistNameAliases.INSTANCE.initialize(this);
            try {
                File file = new File(getFilesDir(), "datastore");
                if (!file.isDirectory() && !file.mkdirs()) {
                    file.getPath();
                    ConnectionPool.w(new Object[0]);
                }
            } catch (Exception unused) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
            }
            synchronized (InnerTubeXPlayer.INSTANCE) {
                if (InnerTubeXPlayer.applicationContext == null) {
                    InnerTubeXPlayer.applicationContext = getApplicationContext();
                }
            }
            CoroutineScope applicationScope = getApplicationScope();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(applicationScope, DefaultIoScheduler.INSTANCE, null, new C01391(this, continuation, b), 2);
            AwaitKt.launch$default(getApplicationScope(), null, null, new C01391(this, null), 3);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.App$onCreate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01391 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public Object L$0;
        public boolean label;
        public /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C01391(byte b, Object obj, Object obj2, Continuation continuation, boolean z) {
            super(2, continuation);
            this.$r8$classId = b;
            this.label = z;
            this.L$0 = obj;
            this.this$0 = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new C01391(this.this$0, continuation, (byte) 0);
                case 1:
                    C01391 c01391 = new C01391(this.this$0, continuation, (byte) 1);
                    c01391.L$0 = obj;
                    return c01391;
                case 2:
                    return new C01391((Function2) this.L$0, (Data) this.this$0, continuation, (byte) 2);
                case 3:
                    C01391 c01392 = new C01391(this.this$0, continuation, (byte) 3);
                    c01392.L$0 = obj;
                    return c01392;
                case 4:
                    C01391 c01393 = new C01391(this.this$0, continuation, (byte) 4);
                    c01393.L$0 = obj;
                    return c01393;
                case 5:
                    return new C01391((TriggerBasedInvalidationTracker) this.L$0, (Function0) this.this$0, continuation, (byte) 5);
                case 6:
                    return new C01391((Function2) this.L$0, (PooledConnectionImpl) this.this$0, continuation, (byte) 6);
                case 7:
                    return new C01391((Function2) this.L$0, (Ref$ObjectRef) this.this$0, continuation, (byte) 7);
                case 8:
                    return new C01391((Function2) this.L$0, (PassthroughConnection) this.this$0, continuation, (byte) 8);
                case 9:
                    return new C01391((RoomDatabase) this.L$0, continuation, (Function1) this.this$0);
                case 10:
                    C01391 c01394 = new C01391(this.this$0, continuation, (byte) 10);
                    c01394.L$0 = obj;
                    return c01394;
                case 11:
                    C01391 c01395 = new C01391(this.this$0, continuation, (byte) 11);
                    c01395.L$0 = obj;
                    return c01395;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new C01391(this.this$0, continuation, (byte) 12);
                case 13:
                    return new C01391((Function2) this.L$0, (QuickJsEngine.Runtime) this.this$0, continuation, (byte) 13);
                case 14:
                    return new C01391((PlayerClientDirector) this.L$0, (InnerTube.SessionSnapshot) this.this$0, continuation, (byte) 14);
                case 15:
                    C01391 c01396 = new C01391((App) this.L$0, continuation);
                    c01396.this$0 = obj;
                    return c01396;
                case 16:
                    return new C01391((DiscordGateway) this.L$0, (String) this.this$0, continuation, (byte) 16);
                case 17:
                    return new C01391((ListenTogetherClient) this.L$0, (String) this.this$0, continuation, (byte) 17);
                case 18:
                    return new C01391((MediaLibrarySessionCallback) this.L$0, (String) this.this$0, continuation, (byte) 18);
                case 19:
                    return new C01391((MusicService) this.L$0, (Ref$BooleanRef) this.this$0, continuation, (byte) 19);
                case 20:
                    return new C01391((MusicService) this.L$0, (PersistPlayerState) this.this$0, continuation, (byte) 20);
                case 21:
                    return new C01391((MusicService) this.L$0, (MediaMetadata) this.this$0, continuation, (byte) 21);
                case 22:
                    return new C01391((MusicService) this.L$0, (MediaItem) this.this$0, continuation, (byte) 22);
                case 23:
                    return new C01391((Context) this.L$0, (ArrayList) this.this$0, continuation, (byte) 23);
                case 24:
                    return new C01391((RecognitionForegroundService) this.L$0, (String) this.this$0, continuation, (byte) 24);
                case 25:
                    C01391 c01397 = new C01391(this.this$0, continuation, (byte) 25);
                    c01397.L$0 = obj;
                    return c01397;
                case 26:
                    return new C01391((byte) 26, (ComposableLambdaImpl) this.L$0, (MutableState) this.this$0, continuation, this.label);
                case 27:
                    return new C01391((MutableState) this.L$0, (ParcelableSnapshotMutableFloatState) this.this$0, continuation, (byte) 27);
                case 28:
                    return new C01391((byte) 28, (FocusRequester) this.L$0, (SoftwareKeyboardController) this.this$0, continuation, this.label);
                default:
                    return new C01391((Playlist) this.L$0, (String) this.this$0, continuation, (byte) 29);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((C01391) create((Message$Update) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((C01391) create((PooledConnectionImpl.TransactionImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 8:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 10:
                    return ((C01391) create((NetworkResponse) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 18:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 22:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 23:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 24:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 25:
                    return ((C01391) create((Flow) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 26:
                    ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 27:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 28:
                    ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                default:
                    return ((C01391) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:341:0x06cb  */
        /* JADX WARN: Code duplicated, block: B:343:0x06e2  */
        /* JADX WARN: Code duplicated, block: B:345:0x06f0  */
        /* JADX WARN: Code duplicated, block: B:349:0x06ff  */
        /* JADX WARN: Code duplicated, block: B:351:0x070c  */
        /* JADX WARN: Code duplicated, block: B:354:0x0714  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:344:0x06ee -> B:346:0x06f2). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1942
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.App.C01391.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01391(RoomDatabase roomDatabase, Continuation continuation, Function1 function1) {
            super(2, continuation);
            this.$r8$classId = (byte) 9;
            this.L$0 = roomDatabase;
            this.this$0 = function1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01391(App app, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 15;
            this.L$0 = app;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C01391(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.L$0 = obj;
            this.this$0 = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C01391(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }
    }
}
