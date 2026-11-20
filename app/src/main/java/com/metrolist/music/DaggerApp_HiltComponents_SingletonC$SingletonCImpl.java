package com.metrolist.music;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.CacheEvictor;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.NoOpCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.internal.NavContext;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.room.RoomDatabase$createConnectionManager$2;
import androidx.room.RoomOpenDelegate;
import androidx.room.TransactionExecutor;
import androidx.room.migration.Migration;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.room.support.PrePackagedCopyOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil3.ImageLoader$Builder;
import coil3.network.NetworkHeaders;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.InternalDatabase;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.MusicDatabaseKt;
import com.metrolist.music.di.LyricsHelperEntryPoint;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.recognition.RecognitionEntryPoint;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.widget.MetrolistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetReceiver_GeneratedInjector;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.NotImplementedError;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DaggerApp_HiltComponents_SingletonC$SingletonCImpl implements App_GeneratedInjector, LyricsHelperEntryPoint, RecognitionEntryPoint, PlaylistWidgetReceiver_GeneratedInjector, ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, GeneratedComponent {
    public final NavContext applicationContextModule;
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl = this;
    public final Provider provideApplicationScopeProvider = DoubleCheck.provider(new SwitchingProvider(this, 0));
    public final Provider provideNetworkConnectivityObserverProvider = DoubleCheck.provider(new SwitchingProvider(this, 1));
    public final Provider provideInternalDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this, 3));
    public final Provider provideDaoProvider = DoubleCheck.provider(new SwitchingProvider(this, 2));
    public final Provider provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this, 5));
    public final Provider playlistWidgetManagerProvider = DoubleCheck.provider(new SwitchingProvider(this, 4));
    public final Provider provideDatabaseProvider2 = DoubleCheck.provider(new SwitchingProvider(this, 7));
    public final Provider provideDownloadCacheProvider = DoubleCheck.provider(new SwitchingProvider(this, 8));
    public final Provider providePlayerCacheProvider = DoubleCheck.provider(new SwitchingProvider(this, 9));
    public final Provider downloadUtilProvider = DoubleCheck.provider(new SwitchingProvider(this, 6));
    public final Provider syncUtilsProvider = DoubleCheck.provider(new SwitchingProvider(this, 10));
    public final Provider provideListenTogetherClientProvider = DoubleCheck.provider(new SwitchingProvider(this, 12));
    public final Provider provideListenTogetherManagerProvider = DoubleCheck.provider(new SwitchingProvider(this, 11));
    public final Provider eQProfileRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this, 13));
    public final Provider equalizerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this, 14));
    public final Provider metrolistWidgetManagerProvider = DoubleCheck.provider(new SwitchingProvider(this, 15));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SwitchingProvider implements Provider {
        public final byte id;
        public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

        /* JADX WARN: Multi-variable type inference failed */
        public SwitchingProvider(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl, int i) {
            this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
            this.id = i;
        }

        @Override // dagger.internal.Provider
        public final Object get() {
            String name;
            RoomOpenDelegate roomOpenDelegateCreateOpenDelegate;
            boolean zContainsKey;
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
            DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = this.singletonCImpl;
            byte b = this.id;
            switch (b) {
                case 0:
                    return AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(AwaitKt.SupervisorJob$default(), Dispatchers.Default));
                case 1:
                    return new NetworkConnectivityObserver(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context);
                case 2:
                    InternalDatabase internalDatabase = (InternalDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideInternalDatabaseProvider.get();
                    internalDatabase.getClass();
                    DatabaseDao dao = internalDatabase.getDao();
                    if (dao == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m("Cannot return null from a non-@Nullable @Provides method");
                    }
                    return dao;
                case 3:
                    final Context context = daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context;
                    final String str = "song.db";
                    if (StringsKt.isBlank("song.db")) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    NetworkHeaders.Builder builder = new NetworkHeaders.Builder((byte) 4);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    ArrayList arrayList3 = new ArrayList();
                    ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(InternalDatabase.class);
                    NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(context, "song.db");
                    Migration[] migrationArr = {MusicDatabaseKt.MIGRATION_1_2, MusicDatabaseKt.MIGRATION_21_24, MusicDatabaseKt.MIGRATION_22_24, MusicDatabaseKt.MIGRATION_24_25};
                    for (int i = 0; i < 4; i++) {
                        Migration migration = migrationArr[i];
                        linkedHashSet2.add(Integer.valueOf(migration.startVersion));
                        linkedHashSet2.add(Integer.valueOf(migration.endVersion));
                    }
                    for (Migration migration2 : (Migration[]) Arrays.copyOf(migrationArr, 4)) {
                        builder.addMigration(migration2);
                    }
                    ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(4);
                    executorServiceNewFixedThreadPool.getClass();
                    ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(4);
                    executorServiceNewFixedThreadPool2.getClass();
                    arrayList.add(new RoomDatabase.Callback() { // from class: com.metrolist.music.db.InternalDatabase$Companion$build$1
                        @Override // androidx.room.RoomDatabase.Callback
                        public final void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                            frameworkSQLiteDatabase.getClass();
                            MusicDatabaseKt.applyPragmaSettings(frameworkSQLiteDatabase);
                        }

                        @Override // androidx.room.RoomDatabase.Callback
                        public final void onDestructiveMigration(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                            frameworkSQLiteDatabase.getClass();
                            MusicDatabaseKt.backupDatabase(context, str);
                        }
                    });
                    if (!linkedHashSet2.isEmpty()) {
                        Iterator it = linkedHashSet2.iterator();
                        while (it.hasNext()) {
                            int iIntValue = ((Number) it.next()).intValue();
                            if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: "));
                                return null;
                            }
                        }
                    }
                    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, "song.db", navDeepLinkRequest, builder, arrayList, false, RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING, executorServiceNewFixedThreadPool2, executorServiceNewFixedThreadPool, null, false, true, linkedHashSet, null, null, null, arrayList2, arrayList3, false, null, null);
                    Class javaClass = Okio__OkioKt.getJavaClass(orCreateKotlinClass);
                    Package r0 = javaClass.getPackage();
                    if (r0 == null || (name = r0.getName()) == null) {
                        name = "";
                    }
                    String canonicalName = javaClass.getCanonicalName();
                    canonicalName.getClass();
                    if (name.length() != 0) {
                        canonicalName = canonicalName.substring(name.length() + 1);
                    }
                    String strReplace = canonicalName.replace('.', '_');
                    strReplace.getClass();
                    String strConcat = strReplace.concat("_Impl");
                    try {
                        Class<?> cls = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, javaClass.getClassLoader());
                        cls.getClass();
                        RoomDatabase roomDatabase = (RoomDatabase) cls.getDeclaredConstructor(null).newInstance(null);
                        roomDatabase.getClass();
                        roomDatabase.useTempTrackingTable = true;
                        try {
                            roomOpenDelegateCreateOpenDelegate = roomDatabase.createOpenDelegate();
                            roomOpenDelegateCreateOpenDelegate.getClass();
                            break;
                        } catch (NotImplementedError unused) {
                            roomOpenDelegateCreateOpenDelegate = null;
                        }
                        if (roomOpenDelegateCreateOpenDelegate == null) {
                            new FileMetadata(databaseConfiguration, new RoomDatabase$$ExternalSyntheticLambda2(roomDatabase), new RoomDatabase$createConnectionManager$2(2, roomDatabase, UtilsKt.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1, (byte) 0));
                            throw null;
                        }
                        roomDatabase.connectionManager = new FileMetadata(databaseConfiguration, roomOpenDelegateCreateOpenDelegate, new RoomDatabase$createConnectionManager$2(2, roomDatabase, UtilsKt.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1, (byte) 3));
                        roomDatabase.internalTracker = roomDatabase.createInvalidationTracker();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Set<KClass> requiredAutoMigrationSpecClasses = roomDatabase.getRequiredAutoMigrationSpecClasses();
                        List list = databaseConfiguration.autoMigrationSpecs;
                        int size = list.size();
                        boolean[] zArr = new boolean[size];
                        for (KClass kClass : requiredAutoMigrationSpecClasses) {
                            int size2 = list.size() - 1;
                            if (size2 >= 0) {
                                while (true) {
                                    int i2 = size2 - 1;
                                    if (kClass.isInstance(list.get(size2))) {
                                        zArr[size2] = true;
                                    } else if (i2 < 0) {
                                        size2 = -1;
                                    } else {
                                        size2 = i2;
                                    }
                                }
                            } else {
                                size2 = -1;
                            }
                            if (size2 < 0) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m("A required auto migration spec (", kClass.getQualifiedName(), ") is missing in the database configuration.");
                                return null;
                            }
                            linkedHashMap.put(kClass, list.get(size2));
                        }
                        int size3 = list.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i3 = size3 - 1;
                                if (size3 >= size || !zArr[size3]) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                                    return null;
                                }
                                if (i3 >= 0) {
                                    size3 = i3;
                                }
                            }
                        }
                        for (Migration migration3 : roomDatabase.createAutoMigrations(linkedHashMap)) {
                            byte b2 = migration3.startVersion;
                            byte b3 = migration3.endVersion;
                            NetworkHeaders.Builder builder2 = databaseConfiguration.migrationContainer;
                            LinkedHashMap linkedHashMap2 = builder2.data;
                            if (linkedHashMap2.containsKey(Integer.valueOf(b2))) {
                                Map map = (Map) linkedHashMap2.get(Integer.valueOf(b2));
                                if (map == null) {
                                    map = EmptyMap.INSTANCE;
                                }
                                zContainsKey = map.containsKey(Integer.valueOf(b3));
                            } else {
                                zContainsKey = false;
                            }
                            if (!zContainsKey) {
                                builder2.addMigration(migration3);
                            }
                        }
                        LinkedHashMap requiredTypeConverterClasses = roomDatabase.getRequiredTypeConverterClasses();
                        List list2 = databaseConfiguration.typeConverters;
                        boolean[] zArr2 = new boolean[list2.size()];
                        for (Map.Entry entry : requiredTypeConverterClasses.entrySet()) {
                            KClass kClass2 = (KClass) entry.getKey();
                            for (KClass kClass3 : (List) entry.getValue()) {
                                int size4 = list2.size() - 1;
                                if (size4 >= 0) {
                                    while (true) {
                                        int i4 = size4 - 1;
                                        if (kClass3.isInstance(list2.get(size4))) {
                                            zArr2[size4] = true;
                                        } else if (i4 < 0) {
                                            size4 = -1;
                                        } else {
                                            size4 = i4;
                                        }
                                    }
                                } else {
                                    size4 = -1;
                                }
                                if (size4 < 0) {
                                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m$1("A required type converter (", kClass3.getQualifiedName(), ") for ", kClass2.getQualifiedName(), " is missing in the database configuration.");
                                    return null;
                                }
                                Object obj = list2.get(size4);
                                kClass3.getClass();
                                obj.getClass();
                                roomDatabase.typeConverters.put(kClass3, obj);
                            }
                        }
                        int size5 = list2.size() - 1;
                        if (size5 >= 0) {
                            while (true) {
                                int i5 = size5 - 1;
                                if (!zArr2[size5]) {
                                    throw new IllegalArgumentException("Unexpected type converter " + list2.get(size5) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                }
                                if (i5 >= 0) {
                                    size5 = i5;
                                }
                            }
                        }
                        roomDatabase.internalQueryExecutor = databaseConfiguration.queryExecutor;
                        roomDatabase.internalTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
                        Executor executor = roomDatabase.internalQueryExecutor;
                        if (executor == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                            throw null;
                        }
                        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(new ExecutorCoroutineDispatcherImpl(executor).plus(AwaitKt.SupervisorJob$default()));
                        roomDatabase.coroutineScope = contextScopeCoroutineScope;
                        CoroutineContext coroutineContext = contextScopeCoroutineScope.coroutineContext;
                        TransactionExecutor transactionExecutor = roomDatabase.internalTransactionExecutor;
                        if (transactionExecutor == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
                            throw null;
                        }
                        roomDatabase.transactionContext = coroutineContext.plus(new ExecutorCoroutineDispatcherImpl(transactionExecutor));
                        roomDatabase.allowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                        FileMetadata fileMetadata = roomDatabase.connectionManager;
                        if (fileMetadata == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                            throw null;
                        }
                        SupportSQLiteOpenHelper delegate = (SupportSQLiteOpenHelper) fileMetadata.lastAccessedAtMillis;
                        if (delegate == null) {
                            delegate = null;
                        } else {
                            while (!(delegate instanceof PrePackagedCopyOpenHelper)) {
                                if (delegate instanceof DelegatingOpenHelper) {
                                    delegate = ((DelegatingOpenHelper) delegate).getDelegate();
                                } else {
                                    delegate = null;
                                }
                            }
                        }
                        FileMetadata fileMetadata2 = roomDatabase.connectionManager;
                        if (fileMetadata2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                            throw null;
                        }
                        SupportSQLiteOpenHelper delegate2 = (SupportSQLiteOpenHelper) fileMetadata2.lastAccessedAtMillis;
                        if (delegate2 != null) {
                            while (!(delegate2 instanceof AutoClosingRoomOpenHelper)) {
                                if (delegate2 instanceof DelegatingOpenHelper) {
                                    delegate2 = ((DelegatingOpenHelper) delegate2).getDelegate();
                                }
                            }
                            supportSQLiteOpenHelper = delegate2;
                        }
                        return (InternalDatabase) roomDatabase;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Cannot find implementation for " + javaClass.getCanonicalName() + ". " + strConcat + " does not exist. Is Room annotation processor correctly configured?", e);
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException("Cannot access the constructor " + javaClass.getCanonicalName(), e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException("Failed to create an instance of " + javaClass.getCanonicalName(), e3);
                    }
                case 4:
                    return new PlaylistWidgetManager(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (CoroutineScope) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideApplicationScopeProvider.get());
                case 5:
                    InternalDatabase internalDatabase2 = (InternalDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideInternalDatabaseProvider.get();
                    internalDatabase2.getClass();
                    return new MusicDatabase(internalDatabase2);
                case 6:
                    return new DownloadUtil(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (StandaloneDatabaseProvider) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider2.get(), (SimpleCache) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDownloadCacheProvider.get(), (SimpleCache) daggerApp_HiltComponents_SingletonC$SingletonCImpl.providePlayerCacheProvider.get());
                case 7:
                    return new StandaloneDatabaseProvider(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context.getApplicationContext(), "exoplayer_internal.db", null, 1);
                case 8:
                    Context context2 = daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context;
                    StandaloneDatabaseProvider standaloneDatabaseProvider = (StandaloneDatabaseProvider) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider2.get();
                    standaloneDatabaseProvider.getClass();
                    File filesDir = context2.getFilesDir();
                    filesDir.getClass();
                    return new SimpleCache(FilesKt.resolve(filesDir, "download"), new NoOpCacheEvictor(), standaloneDatabaseProvider);
                case 9:
                    Context context3 = daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context;
                    StandaloneDatabaseProvider standaloneDatabaseProvider2 = (StandaloneDatabaseProvider) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider2.get();
                    standaloneDatabaseProvider2.getClass();
                    Integer num = (Integer) com.metrolist.music.utils.UtilsKt.get(com.metrolist.music.utils.UtilsKt.getDataStore(context3), PreferenceKeysKt.MaxSongCacheSizeKey);
                    int iIntValue2 = num != null ? num.intValue() : 1024;
                    CacheEvictor noOpCacheEvictor = iIntValue2 == -1 ? new NoOpCacheEvictor() : new LeastRecentlyUsedCacheEvictor(((long) (iIntValue2 * 1024)) * 1024);
                    File filesDir2 = context3.getFilesDir();
                    filesDir2.getClass();
                    return new SimpleCache(FilesKt.resolve(filesDir2, "exoplayer"), noOpCacheEvictor, standaloneDatabaseProvider2);
                case 10:
                    return new SyncUtils(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get());
                case 11:
                    Context context4 = daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context;
                    ListenTogetherClient listenTogetherClient = (ListenTogetherClient) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideListenTogetherClientProvider.get();
                    listenTogetherClient.getClass();
                    return new ListenTogetherManager(listenTogetherClient, context4);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new ListenTogetherClient(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context);
                case 13:
                    return new EQProfileRepository(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context);
                case 14:
                    return new EqualizerService();
                case 15:
                    return new MetrolistWidgetManager(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (PlaylistWidgetManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.playlistWidgetManagerProvider.get());
                default:
                    throw new AssertionError((int) b);
            }
        }
    }

    public DaggerApp_HiltComponents_SingletonC$SingletonCImpl(NavContext navContext) {
        this.applicationContextModule = navContext;
    }

    public final ImageLoader$Builder lyricsHelper() {
        return new ImageLoader$Builder(this.applicationContextModule.context, (NetworkConnectivityObserver) this.provideNetworkConnectivityObserverProvider.get());
    }
}
