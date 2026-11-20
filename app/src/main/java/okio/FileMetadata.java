package okio;

import android.content.Context;
import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.Invalidation;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadAlignmentLines;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.unit.Constraints;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.FlagSet;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackAudioOutputProvider;
import androidx.media3.exoplayer.audio.DefaultAudioOffloadSupportProvider;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.navigation.NavDeepLinkRequest;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomConnectionManager$NoOpOpenDelegate;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.room.RoomDatabase$createConnectionManager$2;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.FileLock;
import androidx.room.coroutines.ConnectionPoolImpl;
import androidx.room.coroutines.PassthroughConnectionPool;
import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.driver.SupportSQLiteConnection;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.network.NetworkHeaders;
import coil3.util.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FileMetadata {
    public final /* synthetic */ byte $r8$classId;
    public Object createdAtMillis;
    public Object extras;
    public boolean isDirectory;
    public boolean isRegularFile;
    public Object lastAccessedAtMillis;
    public Object lastModifiedAtMillis;
    public final Object size;
    public final Object symlinkTarget;

    public FileMetadata(DatabaseConfiguration databaseConfiguration, RoomOpenDelegate roomOpenDelegate, RoomDatabase$createConnectionManager$2 roomDatabase$createConnectionManager$2) {
        int i;
        Object connectionPoolImpl;
        this.$r8$classId = (byte) 3;
        RoomDatabase.JournalMode journalMode = databaseConfiguration.journalMode;
        SupportSQLiteOpenHelper.Factory factory = databaseConfiguration.sqliteOpenHelperFactory;
        SQLiteDriver sQLiteDriver = databaseConfiguration.sqliteDriver;
        String str = databaseConfiguration.name;
        this.symlinkTarget = databaseConfiguration;
        this.size = roomOpenDelegate;
        Object obj = databaseConfiguration.callbacks;
        this.createdAtMillis = obj == null ? EmptyList.INSTANCE : obj;
        SupportSQLiteOpenHelper supportSQLiteOpenHelperCreate = null;
        if (sQLiteDriver != null) {
            this.lastAccessedAtMillis = null;
            if (sQLiteDriver.hasConnectionPool()) {
                connectionPoolImpl = new PassthroughConnectionPool(new FileLock(this, sQLiteDriver), str == null ? ":memory:" : str, roomDatabase$createConnectionManager$2);
            } else if (str == null) {
                connectionPoolImpl = new ConnectionPoolImpl(new FileLock(this, sQLiteDriver));
            } else {
                FileLock fileLock = new FileLock(this, sQLiteDriver);
                int iOrdinal = journalMode.ordinal();
                if (iOrdinal == 1) {
                    i = 1;
                } else {
                    if (iOrdinal != 2) {
                        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
                    }
                    i = 4;
                }
                int iOrdinal2 = journalMode.ordinal();
                if (iOrdinal2 != 1 && iOrdinal2 != 2) {
                    throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
                }
                connectionPoolImpl = new ConnectionPoolImpl(fileLock, str, i);
            }
            this.lastModifiedAtMillis = connectionPoolImpl;
        } else {
            if (factory == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("SQLiteManager was constructed with both null driver and open helper factory!");
                throw null;
            }
            Context context = databaseConfiguration.context;
            context.getClass();
            final int i2 = roomOpenDelegate.version;
            supportSQLiteOpenHelperCreate = factory.create(new NavDeepLinkRequest(context, new androidx.media3.decoder.Buffer(i2) { // from class: androidx.room.RoomConnectionManager$SupportOpenHelperCallback
                @Override // androidx.media3.decoder.Buffer
                public final void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                    this.this$0.onCreate(new SupportSQLiteConnection(frameworkSQLiteDatabase));
                }

                @Override // androidx.media3.decoder.Buffer
                public final void onDowngrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i3, int i4) {
                    onUpgrade(frameworkSQLiteDatabase, i3, i4);
                }

                @Override // androidx.media3.decoder.Buffer
                public final void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws Throwable {
                    SupportSQLiteConnection supportSQLiteConnection = new SupportSQLiteConnection(frameworkSQLiteDatabase);
                    FileMetadata fileMetadata = this.this$0;
                    fileMetadata.onOpen(supportSQLiteConnection);
                    fileMetadata.extras = frameworkSQLiteDatabase;
                }

                @Override // androidx.media3.decoder.Buffer
                public final void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i3, int i4) {
                    this.this$0.onMigrate(new SupportSQLiteConnection(frameworkSQLiteDatabase), i3, i4);
                }
            }, str));
            this.lastAccessedAtMillis = supportSQLiteOpenHelperCreate;
            supportSQLiteOpenHelperCreate.getClass();
            ConnectionPool connectionPool = new ConnectionPool();
            connectionPool.delegate = supportSQLiteOpenHelperCreate;
            this.lastModifiedAtMillis = new PassthroughConnectionPool(connectionPool, str == null ? ":memory:" : str, roomDatabase$createConnectionManager$2);
        }
        boolean z = journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        if (supportSQLiteOpenHelperCreate != null) {
            supportSQLiteOpenHelperCreate.setWriteAheadLoggingEnabled(z);
        }
    }

    public static void configureBusyTimeout(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA busy_timeout");
        try {
            sQLiteStatementPrepare.step();
            long j = sQLiteStatementPrepare.getLong(0);
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            if (j < 3000) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX INFO: renamed from: doLookaheadRemeasure-sdFAvZA, reason: not valid java name */
    public static boolean m1916doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean zM658remeasureBRTryo0;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (layoutNode2 == null) {
            return false;
        }
        if (constraints == null) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            Constraints constraints2 = lookaheadPassDelegate != null ? lookaheadPassDelegate.lookaheadConstraints : null;
            if (constraints2 == null || layoutNode2 == null) {
                zM658remeasureBRTryo0 = false;
            } else {
                lookaheadPassDelegate.getClass();
                zM658remeasureBRTryo0 = lookaheadPassDelegate.m658remeasureBRTryo0(constraints2.value);
            }
        } else if (layoutNode2 != null) {
            LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate2.getClass();
            zM658remeasureBRTryo0 = lookaheadPassDelegate2.m658remeasureBRTryo0(constraints.value);
        } else {
            zM658remeasureBRTryo0 = false;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (zM658remeasureBRTryo0 && parent$ui != null) {
            if (parent$ui.lookaheadRoot == null) {
                LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                return zM658remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParentInLookahead$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestLookaheadRemeasure$ui$default(parent$ui, false, 3);
                return zM658remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParentInLookahead$ui() == LayoutNode.UsageByParent.InLayoutBlock) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        }
        return zM658remeasureBRTryo0;
    }

    /* JADX INFO: renamed from: doRemeasure-sdFAvZA, reason: not valid java name */
    public static boolean m1917doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) throws Throwable {
        boolean zM661remeasureBRTryo0;
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        if (constraints != null) {
            if (layoutNode.intrinsicsUsageByParent == usageByParent) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui();
            }
            zM661remeasureBRTryo0 = layoutNode.layoutDelegate.measurePassDelegate.m661remeasureBRTryo0(constraints.value);
        } else {
            MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
            Constraints constraints2 = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
            if (constraints2 != null) {
                if (layoutNode.intrinsicsUsageByParent == usageByParent) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui();
                }
                zM661remeasureBRTryo0 = layoutNode.layoutDelegate.measurePassDelegate.m661remeasureBRTryo0(constraints2.value);
            } else {
                layoutNode.getClass();
                zM661remeasureBRTryo0 = false;
            }
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (zM661remeasureBRTryo0 && parent$ui != null) {
            if (layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                return zM661remeasureBRTryo0;
            }
            if (layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InLayoutBlock) {
                parent$ui.requestRelayout$ui(false);
            }
        }
        return zM661remeasureBRTryo0;
    }

    public static boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
            return (layoutNode.getMeasuredByParentInLookahead$ui() == LayoutNode.UsageByParent.NotUsed && ((lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate) == null || (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) == null || !lookaheadAlignmentLines.getRequired$ui())) ? false : true;
        }
        return false;
    }

    public static boolean getCanAffectPlacedParent(LayoutNode layoutNode) {
        if (!layoutNode.getMeasurePending$ui()) {
            return false;
        }
        do {
            if (layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.NotUsed && !layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui()) {
                LayoutNode parent$ui = layoutNode.getParent$ui();
                if ((parent$ui != null ? parent$ui.layoutDelegate.layoutState : null) != LayoutNode.LayoutState.Measuring) {
                    return false;
                }
            }
            layoutNode = layoutNode.getParent$ui();
            if (layoutNode == null) {
                return false;
            }
        } while (!layoutNode.isPlaced());
        return true;
    }

    public static boolean isUsedInMeasureOrLayout(LayoutNode layoutNode) {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        return layoutNode.isPlaced() || layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent || getCanAffectPlacedParent(layoutNode) || Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode) || layoutNodeLayoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui() || !((lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate) == null || (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) == null || !lookaheadAlignmentLines.getRequired$ui());
    }

    public DefaultAudioSink build() {
        Context context = (Context) this.symlinkTarget;
        UtilsKt.checkState(!this.isDirectory);
        this.isDirectory = true;
        if (((EmojiProcessor) this.createdAtMillis) == null) {
            this.createdAtMillis = new EmojiProcessor(new AudioProcessor[0], new SilenceSkippingAudioProcessor(100000L, 0.2f, 10, (short) 1024), new SonicAudioProcessor());
        }
        AudioTrackAudioOutputProvider audioTrackAudioOutputProvider = (AudioTrackAudioOutputProvider) this.lastAccessedAtMillis;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider = (DefaultAudioOffloadSupportProvider) this.extras;
        if (audioTrackAudioOutputProvider == null) {
            if (defaultAudioOffloadSupportProvider == null) {
                this.extras = new DefaultAudioOffloadSupportProvider(context);
            }
            if (((AudioSink.AudioTrackConfig) this.lastModifiedAtMillis) == null) {
                this.lastModifiedAtMillis = AudioSink.AudioTrackConfig.DEFAULT;
            }
            Dispatcher dispatcher = new Dispatcher(context);
            AudioCapabilities audioCapabilities = context != null ? null : (AudioCapabilities) this.size;
            Context context2 = (Context) dispatcher.executorServiceOrNull;
            if (context2 == null) {
                dispatcher.runningSyncCalls = audioCapabilities;
            }
            DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider2 = (DefaultAudioOffloadSupportProvider) this.extras;
            dispatcher.readyAsyncCalls = defaultAudioOffloadSupportProvider2;
            dispatcher.runningAsyncCalls = (AudioSink.AudioTrackConfig) this.lastModifiedAtMillis;
            if (defaultAudioOffloadSupportProvider2 == null) {
                dispatcher.readyAsyncCalls = new DefaultAudioOffloadSupportProvider(context2);
            }
            this.lastAccessedAtMillis = new AudioTrackAudioOutputProvider(dispatcher);
        } else {
            UtilsKt.checkState(defaultAudioOffloadSupportProvider == null);
            UtilsKt.checkState(((AudioSink.AudioTrackConfig) this.lastModifiedAtMillis) == null);
        }
        return new DefaultAudioSink(this);
    }

    public void configureDatabase(SQLiteConnection sQLiteConnection) throws Throwable {
        Object failure;
        RoomOpenDelegate roomOpenDelegate = (RoomOpenDelegate) this.size;
        configureBusyTimeout(sQLiteConnection);
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.symlinkTarget;
        RoomDatabase.JournalMode journalMode = databaseConfiguration.journalMode;
        RoomDatabase.JournalMode journalMode2 = RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        if (journalMode == journalMode2) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
        if (databaseConfiguration.journalMode == journalMode2) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA user_version");
        try {
            sQLiteStatementPrepare.step();
            int i = (int) sQLiteStatementPrepare.getLong(0);
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            int i2 = roomOpenDelegate.version;
            int i3 = roomOpenDelegate.version;
            if (i != i2) {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        onCreate(sQLiteConnection);
                    } else {
                        onMigrate(sQLiteConnection, i, i3);
                    }
                    SQLite.execSQL(sQLiteConnection, "PRAGMA user_version = " + i3);
                    failure = Unit.INSTANCE;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (!(failure instanceof Result.Failure)) {
                    SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                }
                Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
                if (thM1866exceptionOrNullimpl != null) {
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw thM1866exceptionOrNullimpl;
                }
            }
            onOpen(sQLiteConnection);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th2);
                throw th3;
            }
        }
    }

    public void dispatchOnPositionedCallbacks(boolean z) {
        WeakCache weakCache = (WeakCache) this.createdAtMillis;
        MutableVector mutableVector = (MutableVector) weakCache.values;
        if (z) {
            LayoutNode layoutNode = (LayoutNode) this.symlinkTarget;
            if (layoutNode.globallyPositionedObservers > 0) {
                mutableVector.clear();
                mutableVector.add(layoutNode);
                layoutNode.needsOnGloballyPositionedDispatch = true;
            }
        }
        if (mutableVector.size != 0) {
            Trace.beginSection("Compose:onPositionedCallbacks");
            try {
                weakCache.dispatch();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void drainPostponedMeasureRequests() {
        MutableVector mutableVector = (MutableVector) this.lastAccessedAtMillis;
        int i = mutableVector.size;
        if (i != 0) {
            Object[] objArr = mutableVector.content;
            for (int i2 = 0; i2 < i; i2++) {
                MeasureAndLayoutDelegate$PostponedRequest measureAndLayoutDelegate$PostponedRequest = (MeasureAndLayoutDelegate$PostponedRequest) objArr[i2];
                if (measureAndLayoutDelegate$PostponedRequest.node.isAttached$1()) {
                    boolean z = measureAndLayoutDelegate$PostponedRequest.isLookahead;
                    LayoutNode layoutNode = measureAndLayoutDelegate$PostponedRequest.node;
                    boolean z2 = measureAndLayoutDelegate$PostponedRequest.isForced;
                    if (z) {
                        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, z2, 2);
                    } else {
                        LayoutNode.requestRemeasure$ui$default(layoutNode, z2, 2);
                    }
                }
            }
            mutableVector.clear();
        }
    }

    public void ensureSubtreeLookaheadReplaced(LayoutNode layoutNode) {
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (Intrinsics.areEqual(layoutNode2.isPlacedInLookahead(), Boolean.TRUE) && !layoutNode2.isDeactivated) {
                if (((EmojiProcessor) this.size).contains(layoutNode2)) {
                    layoutNode2.lookaheadReplace$ui();
                }
                ensureSubtreeLookaheadReplaced(layoutNode2);
            }
        }
    }

    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        if (!this.isRegularFile) {
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z ? layoutNode.layoutDelegate.lookaheadMeasurePending : layoutNode.getMeasurePending$ui()) {
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }
        forceMeasureTheSubtreeInternal(layoutNode, z);
    }

    public void forceMeasureTheSubtreeInternal(LayoutNode layoutNode, boolean z) throws Throwable {
        LookaheadPassDelegate lookaheadPassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            if ((!z && (layoutNode2.getMeasuredByParent$ui() == usageByParent || layoutNode2.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui())) || (z && (layoutNode2.getMeasuredByParentInLookahead$ui() == usageByParent || ((lookaheadPassDelegate = layoutNode2.layoutDelegate.lookaheadPassDelegate) != null && (lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines) != null && lookaheadAlignmentLines.getRequired$ui())))) {
                boolean zIsOutMostLookaheadRoot = HitTestResultKt.isOutMostLookaheadRoot(layoutNode2);
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode2.layoutDelegate;
                if (zIsOutMostLookaheadRoot && !z) {
                    if (layoutNodeLayoutDelegate.lookaheadMeasurePending && ((EmojiProcessor) this.size).contains(layoutNode2)) {
                        remeasureIfNeeded(layoutNode2, true);
                    } else {
                        forceMeasureTheSubtree(layoutNode2, true);
                    }
                }
                if (z ? layoutNodeLayoutDelegate.lookaheadMeasurePending : layoutNode2.getMeasurePending$ui()) {
                    remeasureIfNeeded(layoutNode2, z);
                }
                if (!(z ? layoutNodeLayoutDelegate.lookaheadMeasurePending : layoutNode2.getMeasurePending$ui())) {
                    forceMeasureTheSubtreeInternal(layoutNode2, z);
                }
            }
        }
        if (z ? layoutNode.layoutDelegate.lookaheadMeasurePending : layoutNode.getMeasurePending$ui()) {
            remeasureIfNeeded(layoutNode, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v4 */
    public boolean measureAndLayout(Function0 function0) {
        boolean z;
        ?? Pop;
        boolean z2;
        LayoutNode layoutNode;
        boolean z3;
        boolean zRemeasureIfNeeded;
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.size;
        DrawResult drawResult = (DrawResult) emojiProcessor.mSpanFactory;
        LayoutNode layoutNode2 = (LayoutNode) this.symlinkTarget;
        if (!layoutNode2.isAttached$1()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!layoutNode2.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.isRegularFile) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        int i = 0;
        if (((Constraints) this.extras) != null) {
            this.isRegularFile = true;
            this.isDirectory = true;
            try {
                if (emojiProcessor.isNotEmpty()) {
                    z = false;
                    while (true) {
                        DrawResult drawResult2 = (DrawResult) emojiProcessor.mGlyphChecker;
                        SortedSet sortedSet = (SortedSet) drawResult2.block;
                        DrawResult drawResult3 = (DrawResult) emojiProcessor.mMetadataRepo;
                        SortedSet sortedSet2 = (SortedSet) drawResult3.block;
                        if (!((SortedSet) drawResult.block).isEmpty()) {
                            layoutNode = (LayoutNode) ((SortedSet) drawResult.block).first();
                            drawResult.remove(layoutNode);
                            z3 = layoutNode.lookaheadRoot != null;
                            z2 = false;
                        } else if (!sortedSet2.isEmpty()) {
                            layoutNode = (LayoutNode) sortedSet2.first();
                            drawResult3.remove(layoutNode);
                            z3 = layoutNode.lookaheadRoot != null;
                            z2 = true;
                        } else {
                            if (sortedSet.isEmpty()) {
                                break;
                            }
                            LayoutNode layoutNode3 = (LayoutNode) sortedSet.first();
                            drawResult2.remove(layoutNode3);
                            z2 = true;
                            layoutNode = layoutNode3;
                            z3 = false;
                        }
                        if (z2) {
                            zRemeasureIfNeeded = remeasureAndRelayoutIfNeeded(layoutNode, z3);
                        } else {
                            zRemeasureIfNeeded = remeasureIfNeeded(layoutNode, z3);
                            if (layoutNode.layoutDelegate.lookaheadLayoutPending) {
                                emojiProcessor.add(layoutNode, Invalidation.LookaheadPlacement);
                            }
                            if (layoutNode.getLayoutPending$ui()) {
                                emojiProcessor.add(layoutNode, Invalidation.Placement);
                            }
                        }
                        if (layoutNode == layoutNode2 && zRemeasureIfNeeded) {
                            z = true;
                        }
                    }
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    z = false;
                }
                this.isRegularFile = false;
                this.isDirectory = false;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.isRegularFile = false;
                    this.isDirectory = false;
                    throw th2;
                }
            }
        } else {
            z = false;
        }
        MutableVector mutableVector = (MutableVector) this.lastModifiedAtMillis;
        Object[] objArr = mutableVector.content;
        int i2 = mutableVector.size;
        int i3 = 0;
        while (i3 < i2) {
            NodeChain nodeChain = ((LayoutNode) objArr[i3]).nodes;
            InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
            boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(4194304);
            Modifier.Node node = innerNodeCoordinator.tail;
            if (zM678getIncludeSelfInTraversalH91voCI || (node = node.parent) != null) {
                ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = NodeCoordinator.onCommitAffectingLayerParams;
                Modifier.Node nodeHeadNode = innerNodeCoordinator.headNode(zM678getIncludeSelfInTraversalH91voCI);
                while (nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4194304) != 0) {
                    if ((nodeHeadNode.kindSet & 4194304) != 0) {
                        ?? r12 = nodeHeadNode;
                        ?? mutableVector2 = 0;
                        while (r12 != 0) {
                            if (r12 instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) r12).onPlaced((InnerNodeCoordinator) nodeChain.innerCoordinator);
                            } else {
                                if ((r12.kindSet & 4194304) != 0 && (r12 instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) r12).delegate;
                                    int i4 = i;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 4194304) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                Pop = r12;
                                                mutableVector2 = mutableVector2;
                                                mutableVector2 = mutableVector2;
                                                Pop = node2;
                                            } else {
                                                if (mutableVector2 == 0) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector2.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector2.add(node2);
                                            }
                                        } else {
                                            Pop = r12;
                                            mutableVector2 = mutableVector2;
                                        }
                                        node2 = node2.child;
                                        Pop = Pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    if (i4 == 1) {
                                        Pop = r12;
                                        mutableVector2 = mutableVector2;
                                    }
                                }
                                i = 0;
                                r12 = Pop;
                                mutableVector2 = mutableVector2;
                            }
                            Pop = r12;
                            mutableVector2 = mutableVector2;
                            Pop = HitTestResultKt.pop(mutableVector2);
                            i = 0;
                            r12 = Pop;
                            mutableVector2 = mutableVector2;
                        }
                    }
                    if (nodeHeadNode == node) {
                        break;
                    }
                    nodeHeadNode = nodeHeadNode.child;
                    i = 0;
                }
            }
            i3++;
            i = 0;
        }
        mutableVector.clear();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public void m1918measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        LayoutNode layoutNode2 = (LayoutNode) this.symlinkTarget;
        boolean z = layoutNode.isDeactivated;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (z) {
            return;
        }
        if (layoutNode == layoutNode2) {
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }
        if (!layoutNode2.isAttached$1()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }
        if (!layoutNode2.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }
        if (this.isRegularFile) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }
        if (((Constraints) this.extras) != null) {
            this.isRegularFile = true;
            this.isDirectory = false;
            try {
                EmojiProcessor emojiProcessor = (EmojiProcessor) this.size;
                ((DrawResult) emojiProcessor.mSpanFactory).remove(layoutNode);
                ((DrawResult) emojiProcessor.mMetadataRepo).remove(layoutNode);
                ((DrawResult) emojiProcessor.mGlyphChecker).remove(layoutNode);
                if (m1916doLookaheadRemeasuresdFAvZA(layoutNode, new Constraints(j)) || layoutNodeLayoutDelegate.lookaheadLayoutPending) {
                    if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                        layoutNode.lookaheadReplace$ui();
                    }
                }
                ensureSubtreeLookaheadReplaced(layoutNode);
                if (layoutNode.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui();
                }
                boolean zM661remeasureBRTryo0 = layoutNodeLayoutDelegate.measurePassDelegate.m661remeasureBRTryo0(j);
                LayoutNode parent$ui = layoutNode.getParent$ui();
                if (zM661remeasureBRTryo0 && parent$ui != null) {
                    if (layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LayoutNode.requestRemeasure$ui$default(parent$ui, false, 3);
                    } else if (layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InLayoutBlock) {
                        parent$ui.requestRelayout$ui(false);
                    }
                }
                if (layoutNode.getLayoutPending$ui() && layoutNode.isPlaced()) {
                    layoutNode.replace$ui();
                    WeakCache weakCache = (WeakCache) this.createdAtMillis;
                    if (layoutNode.globallyPositionedObservers > 0) {
                        ((MutableVector) weakCache.values).add(layoutNode);
                        layoutNode.needsOnGloballyPositionedDispatch = true;
                    }
                }
                drainPostponedMeasureRequests();
                this.isRegularFile = false;
                this.isDirectory = false;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    this.isRegularFile = false;
                    this.isDirectory = false;
                    throw th2;
                }
            }
        }
        MutableVector mutableVector = (MutableVector) this.lastModifiedAtMillis;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            NodeChain nodeChain = ((LayoutNode) objArr[i2]).nodes;
            InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
            boolean zM678getIncludeSelfInTraversalH91voCI = NodeKindKt.m678getIncludeSelfInTraversalH91voCI(4194304);
            Modifier.Node node = innerNodeCoordinator.tail;
            if (zM678getIncludeSelfInTraversalH91voCI || (node = node.parent) != null) {
                ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = NodeCoordinator.onCommitAffectingLayerParams;
                for (Modifier.Node nodeHeadNode = innerNodeCoordinator.headNode(zM678getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.aggregateChildKindSet & 4194304) != 0; nodeHeadNode = nodeHeadNode.child) {
                    if ((nodeHeadNode.kindSet & 4194304) != 0) {
                        ?? Pop = nodeHeadNode;
                        ?? mutableVector2 = 0;
                        while (Pop != 0) {
                            if (Pop instanceof LayoutAwareModifierNode) {
                                ((LayoutAwareModifierNode) Pop).onPlaced((InnerNodeCoordinator) nodeChain.innerCoordinator);
                            } else if ((Pop.kindSet & 4194304) != 0 && (Pop instanceof DelegatingNode)) {
                                Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                                int i3 = 0;
                                while (node2 != null) {
                                    if ((node2.kindSet & 4194304) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            Pop = Pop;
                                            mutableVector2 = mutableVector2;
                                            mutableVector2 = mutableVector2;
                                            Pop = node2;
                                        } else {
                                            if (mutableVector2 == 0) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (Pop != 0) {
                                                mutableVector2.add(Pop);
                                                Pop = 0;
                                            }
                                            mutableVector2.add(node2);
                                        }
                                    } else {
                                        Pop = Pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    node2 = node2.child;
                                    Pop = Pop;
                                    mutableVector2 = mutableVector2;
                                }
                                if (i3 == 1) {
                                    Pop = Pop;
                                    mutableVector2 = mutableVector2;
                                } else {
                                    Pop = Pop;
                                    mutableVector2 = mutableVector2;
                                }
                            }
                            Pop = HitTestResultKt.pop(mutableVector2);
                        }
                    }
                    if (nodeHeadNode == node) {
                        break;
                    }
                }
            }
        }
        mutableVector.clear();
    }

    public void measureOnly() {
        LayoutNode layoutNode = (LayoutNode) this.symlinkTarget;
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.size;
        if (emojiProcessor.isNotEmpty()) {
            if (!layoutNode.isAttached$1()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
            }
            if (!layoutNode.isPlaced()) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
            }
            if (this.isRegularFile) {
                InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
            }
            if (((Constraints) this.extras) != null) {
                this.isRegularFile = true;
                this.isDirectory = false;
                try {
                    if ((((SortedSet) ((DrawResult) emojiProcessor.mGlyphChecker).block).isEmpty() || ((SortedSet) ((DrawResult) emojiProcessor.mSpanFactory).block).isEmpty()) ? false : true) {
                        if (layoutNode.lookaheadRoot != null) {
                            remeasureOnly(layoutNode, true);
                        } else {
                            remeasureLookaheadRootsInSubtree(layoutNode);
                        }
                    }
                    remeasureOnly(layoutNode, false);
                    this.isRegularFile = false;
                    this.isDirectory = false;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        this.isRegularFile = false;
                        this.isDirectory = false;
                        throw th2;
                    }
                }
            }
        }
    }

    public void onCreate(SQLiteConnection sQLiteConnection) {
        RoomOpenDelegate roomOpenDelegate = (RoomOpenDelegate) this.size;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (sQLiteStatementPrepare.step() && sQLiteStatementPrepare.getLong(0) == 0) {
                z = true;
            }
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            roomOpenDelegate.createAllTables(sQLiteConnection);
            if (!z) {
                FlagSet.Builder builderOnValidateSchema = roomOpenDelegate.onValidateSchema(sQLiteConnection);
                if (!builderOnValidateSchema.buildCalled) {
                    PathKt$$ExternalSyntheticBUOutline0.m(builderOnValidateSchema.flags, "Pre-packaged database has an invalid schema: ");
                    return;
                }
            }
            updateIdentity(sQLiteConnection);
            roomOpenDelegate.onCreate(sQLiteConnection);
            for (RoomDatabase.Callback callback : (List) this.createdAtMillis) {
                callback.getClass();
                if (sQLiteConnection instanceof SupportSQLiteConnection) {
                    callback.onCreate(((SupportSQLiteConnection) sQLiteConnection).db);
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:? A[LOOP:4: B:9:0x0028->B:131:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:56:0x00df  */
    public void onMigrate(SQLiteConnection sQLiteConnection, int i, int i2) {
        Iterable iterable;
        LinkedHashMap linkedHashMap;
        TreeMap treeMap;
        Pair pair;
        Iterator it;
        boolean z;
        int iIntValue;
        TreeMap treeMap2;
        boolean z2;
        RoomOpenDelegate roomOpenDelegate = (RoomOpenDelegate) this.size;
        sQLiteConnection.getClass();
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.symlinkTarget;
        NetworkHeaders.Builder builder = databaseConfiguration.migrationContainer;
        if (i == i2) {
            iterable = EmptyList.INSTANCE;
        } else {
            boolean z3 = i2 > i;
            ArrayList arrayList = new ArrayList();
            int i3 = i;
            while (true) {
                if (z3) {
                    if (i3 < i2) {
                        linkedHashMap = builder.data;
                        if (z3) {
                            treeMap2 = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                            if (treeMap2 == null) {
                                pair = null;
                            } else {
                                pair = new Pair(treeMap2, treeMap2.descendingKeySet());
                            }
                        } else {
                            treeMap = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                            if (treeMap == null) {
                                pair = null;
                            } else {
                                pair = new Pair(treeMap, treeMap.keySet());
                            }
                        }
                        if (pair == null) {
                            Map map = (Map) pair.first;
                            it = ((Iterable) pair.second).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                iIntValue = ((Number) it.next()).intValue();
                                if (z3) {
                                    if (i3 + 1 <= iIntValue && iIntValue <= i2) {
                                        Object obj = map.get(Integer.valueOf(iIntValue));
                                        obj.getClass();
                                        arrayList.add(obj);
                                        z = true;
                                        i3 = iIntValue;
                                        break;
                                    }
                                } else {
                                    if (i2 <= iIntValue && iIntValue < i3) {
                                        Object obj2 = map.get(Integer.valueOf(iIntValue));
                                        obj2.getClass();
                                        arrayList.add(obj2);
                                        z = true;
                                        i3 = iIntValue;
                                        break;
                                        break;
                                    }
                                }
                            }
                            if (!z) {
                            }
                        }
                        iterable = null;
                    } else {
                        iterable = arrayList;
                    }
                } else if (i3 > i2) {
                    linkedHashMap = builder.data;
                    if (z3) {
                        treeMap2 = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                        if (treeMap2 == null) {
                            pair = null;
                        } else {
                            pair = new Pair(treeMap2, treeMap2.descendingKeySet());
                        }
                    } else {
                        treeMap = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                        if (treeMap == null) {
                            pair = null;
                        } else {
                            pair = new Pair(treeMap, treeMap.keySet());
                        }
                    }
                    if (pair == null) {
                        Map map2 = (Map) pair.first;
                        it = ((Iterable) pair.second).iterator();
                        while (true) {
                            if (it.hasNext()) {
                                z = false;
                                break;
                                break;
                            }
                            iIntValue = ((Number) it.next()).intValue();
                            if (z3) {
                                if (i3 + 1 <= iIntValue) {
                                    continue;
                                }
                            } else if (i2 <= iIntValue) {
                                continue;
                            }
                        }
                        if (!z) {
                        }
                    }
                    iterable = null;
                } else {
                    iterable = arrayList;
                }
            }
        }
        if (iterable != null) {
            roomOpenDelegate.onPreMigrate(sQLiteConnection);
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                ((Migration) it2.next()).migrate(sQLiteConnection);
            }
            FlagSet.Builder builderOnValidateSchema = roomOpenDelegate.onValidateSchema(sQLiteConnection);
            if (!builderOnValidateSchema.buildCalled) {
                PathKt$$ExternalSyntheticBUOutline0.m(builderOnValidateSchema.flags, "Migration didn't properly handle: ");
                return;
            } else {
                roomOpenDelegate.onPostMigrate(sQLiteConnection);
                updateIdentity(sQLiteConnection);
                return;
            }
        }
        databaseConfiguration.getClass();
        if (i <= i2 || !databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            Set set = databaseConfiguration.migrationNotRequiredFrom;
            if (!databaseConfiguration.requireMigration || (set != null && set.contains(Integer.valueOf(i)))) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            throw new IllegalStateException(("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if (databaseConfiguration.allowDestructiveMigrationForAllTables) {
            SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(0);
                    if (!StringsKt__StringsJVMKt.startsWith(text, "sqlite_", false) && !text.equals("android_metadata")) {
                        listBuilderCreateListBuilder.add(new Pair(text, Boolean.valueOf(Intrinsics.areEqual(sQLiteStatementPrepare.getText(1), "view"))));
                    }
                }
                ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                ListIterator listIterator = listBuilderBuild.listIterator(0);
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                    if (!itr.hasNext()) {
                        break;
                    }
                    Pair pair2 = (Pair) itr.next();
                    String str = (String) pair2.first;
                    if (((Boolean) pair2.second).booleanValue()) {
                        SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS `" + str + '`');
                    } else {
                        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `" + str + '`');
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        } else {
            roomOpenDelegate.dropAllTables(sQLiteConnection);
        }
        for (RoomDatabase.Callback callback : (List) this.createdAtMillis) {
            callback.getClass();
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                callback.onDestructiveMigration(((SupportSQLiteConnection) sQLiteConnection).db);
            }
        }
        roomOpenDelegate.createAllTables(sQLiteConnection);
    }

    public void onOpen(SQLiteConnection sQLiteConnection) throws Throwable {
        Object failure;
        sQLiteConnection.getClass();
        RoomOpenDelegate roomOpenDelegate = (RoomOpenDelegate) this.size;
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z = sQLiteStatementPrepare.step() && sQLiteStatementPrepare.getLong(0) != 0;
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            if (z) {
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection.prepare("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
                try {
                    String text = sQLiteStatementPrepare2.step() ? sQLiteStatementPrepare2.getText(0) : null;
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, null);
                    if (!roomOpenDelegate.identityHash.equals(text) && !roomOpenDelegate.legacyIdentityHash.equals(text)) {
                        throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + roomOpenDelegate.identityHash + ", found: " + text).toString());
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, th);
                        throw th2;
                    }
                }
            } else {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    FlagSet.Builder builderOnValidateSchema = roomOpenDelegate.onValidateSchema(sQLiteConnection);
                    if (!builderOnValidateSchema.buildCalled) {
                        throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + ((String) builderOnValidateSchema.flags)).toString());
                    }
                    roomOpenDelegate.onPostMigrate(sQLiteConnection);
                    updateIdentity(sQLiteConnection);
                    failure = Unit.INSTANCE;
                    if (!(failure instanceof Result.Failure)) {
                        SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                    }
                    Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
                    if (thM1866exceptionOrNullimpl != null) {
                        SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                        throw thM1866exceptionOrNullimpl;
                    }
                } catch (Throwable th3) {
                    failure = new Result.Failure(th3);
                }
            }
            roomOpenDelegate.onOpen(sQLiteConnection);
            for (RoomDatabase.Callback callback : (List) this.createdAtMillis) {
                callback.getClass();
                if (sQLiteConnection instanceof SupportSQLiteConnection) {
                    callback.onOpen(((SupportSQLiteConnection) sQLiteConnection).db);
                }
            }
            this.isRegularFile = true;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th4);
                throw th5;
            }
        }
    }

    public boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode, boolean z) {
        Constraints constraints;
        LayoutNode parent$ui;
        LayoutNode layoutNode2 = (LayoutNode) this.symlinkTarget;
        boolean z2 = layoutNode.isDeactivated;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        boolean zM1916doLookaheadRemeasuresdFAvZA = false;
        if (!z2 && isUsedInMeasureOrLayout(layoutNode)) {
            if (layoutNode == layoutNode2) {
                constraints = (Constraints) this.extras;
                constraints.getClass();
            } else {
                constraints = null;
            }
            if (z) {
                zM1916doLookaheadRemeasuresdFAvZA = layoutNodeLayoutDelegate.lookaheadMeasurePending ? m1916doLookaheadRemeasuresdFAvZA(layoutNode, constraints) : false;
                if ((zM1916doLookaheadRemeasuresdFAvZA || layoutNodeLayoutDelegate.lookaheadLayoutPending) && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE)) {
                    layoutNode.lookaheadReplace$ui();
                }
            } else {
                boolean zM1917doRemeasuresdFAvZA = layoutNode.getMeasurePending$ui() ? m1917doRemeasuresdFAvZA(layoutNode, constraints) : false;
                if (layoutNode.getLayoutPending$ui() && (layoutNode == layoutNode2 || ((parent$ui = layoutNode.getParent$ui()) != null && parent$ui.isPlaced() && layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent))) {
                    if (layoutNode == layoutNode2) {
                        if (layoutNode.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                            layoutNode.clearSubtreePlacementIntrinsicsUsage();
                        }
                        LayoutNode parent$ui2 = layoutNode.getParent$ui();
                        Placeable.PlacementScope.placeRelative$default(parent$ui2 != null ? ((InnerNodeCoordinator) parent$ui2.nodes.innerCoordinator).placementScope : ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getPlacementScope(), layoutNodeLayoutDelegate.measurePassDelegate, 0, 0);
                    } else {
                        layoutNode.replace$ui();
                    }
                    WeakCache weakCache = (WeakCache) this.createdAtMillis;
                    if (layoutNode.globallyPositionedObservers > 0) {
                        ((MutableVector) weakCache.values).add(layoutNode);
                        layoutNode.needsOnGloballyPositionedDispatch = true;
                    }
                }
                zM1916doLookaheadRemeasuresdFAvZA = zM1917doRemeasuresdFAvZA;
            }
            drainPostponedMeasureRequests();
        }
        return zM1916doLookaheadRemeasuresdFAvZA;
    }

    public boolean remeasureIfNeeded(LayoutNode layoutNode, boolean z) throws Throwable {
        Constraints constraints;
        boolean zM1917doRemeasuresdFAvZA = false;
        if (!layoutNode.isDeactivated && isUsedInMeasureOrLayout(layoutNode)) {
            if (layoutNode == ((LayoutNode) this.symlinkTarget)) {
                constraints = (Constraints) this.extras;
                constraints.getClass();
            } else {
                constraints = null;
            }
            if (z) {
                if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
                    zM1917doRemeasuresdFAvZA = m1916doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
                }
            } else if (layoutNode.getMeasurePending$ui()) {
                zM1917doRemeasuresdFAvZA = m1917doRemeasuresdFAvZA(layoutNode, constraints);
            }
            drainPostponedMeasureRequests();
        }
        return zM1917doRemeasuresdFAvZA;
    }

    public void remeasureLookaheadRootsInSubtree(LayoutNode layoutNode) throws Throwable {
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode2.layoutDelegate.measurePassDelegate.alignmentLines.getRequired$ui()) {
                if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
                    remeasureOnly(layoutNode2, true);
                } else {
                    remeasureLookaheadRootsInSubtree(layoutNode2);
                }
            }
        }
    }

    public void remeasureOnly(LayoutNode layoutNode, boolean z) throws Throwable {
        Constraints constraints;
        if (layoutNode.isDeactivated) {
            return;
        }
        if (layoutNode == ((LayoutNode) this.symlinkTarget)) {
            constraints = (Constraints) this.extras;
            constraints.getClass();
        } else {
            constraints = null;
        }
        if (z) {
            m1916doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
        } else {
            m1917doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public boolean requestRemeasure(LayoutNode layoutNode, boolean z) {
        int iOrdinal = layoutNode.layoutDelegate.layoutState.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                ((MutableVector) this.lastAccessedAtMillis).add(new MeasureAndLayoutDelegate$PostponedRequest(layoutNode, false, z));
            } else {
                if (iOrdinal != 4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return false;
                }
                if (!layoutNode.getMeasurePending$ui() || z) {
                    layoutNode.layoutDelegate.measurePassDelegate.measurePending = true;
                    if (!layoutNode.isDeactivated && (layoutNode.isPlaced() || getCanAffectPlacedParent(layoutNode))) {
                        LayoutNode parent$ui = layoutNode.getParent$ui();
                        if (parent$ui == null || !parent$ui.getMeasurePending$ui()) {
                            ((EmojiProcessor) this.size).add(layoutNode, Invalidation.Measurement);
                        }
                        if (!this.isDirectory) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) this.extras;
                Long l = (Long) this.lastAccessedAtMillis;
                Long l2 = (Long) this.lastModifiedAtMillis;
                Long l3 = (Long) this.createdAtMillis;
                Long l4 = (Long) this.size;
                ArrayList arrayList = new ArrayList();
                if (this.isRegularFile) {
                    arrayList.add("isRegularFile");
                }
                if (this.isDirectory) {
                    arrayList.add("isDirectory");
                }
                if (l4 != null) {
                    arrayList.add("byteCount=" + l4.longValue());
                }
                if (l3 != null) {
                    arrayList.add("createdAt=" + l3.longValue());
                }
                if (l2 != null) {
                    arrayList.add("lastModifiedAt=" + l2.longValue());
                }
                if (l != null) {
                    arrayList.add("lastAccessedAt=" + l.longValue());
                }
                if (!map.isEmpty()) {
                    arrayList.add("extras=" + map);
                }
                return CollectionsKt.joinToString$default(arrayList, ", ", "FileMetadata(", ")", null, 56);
            default:
                return super.toString();
        }
    }

    public void updateIdentity(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((RoomOpenDelegate) this.size).identityHash + "')");
    }

    /* JADX INFO: renamed from: updateRootConstraints-BRTryo0, reason: not valid java name */
    public void m1919updateRootConstraintsBRTryo0(long j) {
        LayoutNode layoutNode = (LayoutNode) this.symlinkTarget;
        Constraints constraints = (Constraints) this.extras;
        if (constraints == null ? false : Constraints.m778equalsimpl0(constraints.value, j)) {
            return;
        }
        if (this.isRegularFile) {
            InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
        }
        this.extras = new Constraints(j);
        boolean zIsAttached$1 = layoutNode.isAttached$1();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (zIsAttached$1) {
            LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
            if (layoutNode2 != null) {
                layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
            }
            layoutNodeLayoutDelegate.measurePassDelegate.measurePending = true;
            ((EmojiProcessor) this.size).add(layoutNode, layoutNode2 != null ? Invalidation.LookaheadMeasurement : Invalidation.Measurement);
        }
    }

    public FileMetadata(DatabaseConfiguration databaseConfiguration, RoomDatabase$$ExternalSyntheticLambda2 roomDatabase$$ExternalSyntheticLambda2, RoomDatabase$createConnectionManager$2 roomDatabase$createConnectionManager$2) {
        this.$r8$classId = (byte) 3;
        this.symlinkTarget = databaseConfiguration;
        this.size = new RoomConnectionManager$NoOpOpenDelegate(-1, "", "");
        List list = databaseConfiguration.callbacks;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.createdAtMillis = list == null ? emptyList : list;
        final DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0((byte) 14, this);
        CollectionsKt.plus(new RoomDatabase.Callback() { // from class: androidx.room.RoomConnectionManager$installOnOpenCallback$newCallbacks$1
            @Override // androidx.room.RoomDatabase.Callback
            public final void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                frameworkSQLiteDatabase.getClass();
                diskLruCache$$ExternalSyntheticLambda0.invoke(frameworkSQLiteDatabase);
            }
        }, list == null ? emptyList : list);
        databaseConfiguration.context.getClass();
        throw new NotImplementedError(0);
    }

    public FileMetadata(LayoutNode layoutNode) {
        this.$r8$classId = (byte) 1;
        this.symlinkTarget = layoutNode;
        this.size = new EmojiProcessor((byte) 10);
        this.createdAtMillis = new WeakCache((byte) 11);
        this.lastModifiedAtMillis = new MutableVector(new LayoutNode[16]);
        this.lastAccessedAtMillis = new MutableVector(new MeasureAndLayoutDelegate$PostponedRequest[16]);
    }

    public FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map) {
        this.$r8$classId = (byte) 0;
        map.getClass();
        this.isRegularFile = z;
        this.isDirectory = z2;
        this.symlinkTarget = path;
        this.size = l;
        this.createdAtMillis = l2;
        this.lastModifiedAtMillis = l3;
        this.lastAccessedAtMillis = l4;
        this.extras = MapsKt__MapsKt.toMap(map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4) {
        this(z, z2, path, l, l2, l3, l4, EmptyMap.INSTANCE);
        this.$r8$classId = (byte) 0;
    }

    public FileMetadata(Context context) {
        this.$r8$classId = (byte) 2;
        this.symlinkTarget = context;
        this.size = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
    }
}
