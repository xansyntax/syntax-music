package com.metrolist.music.db;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.Trace;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageOnly;
import androidx.collection.ArrayMap;
import androidx.collection.FloatFloatPair;
import androidx.collection.FloatListKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableFloatList;
import androidx.collection.internal.Lock;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda2;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.carousel.Keyline;
import androidx.compose.material3.carousel.KeylineList;
import androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.tooling.LocationSourceInformation;
import androidx.compose.runtime.tooling.ParameterSourceInformation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.provider.FontRequest;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.emoji2.text.DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.WeakReference;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.BackStackEntryIdViewModel;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.room.RoomSQLiteQuery;
import androidx.room.TransactionElement;
import androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1;
import androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1;
import androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1;
import androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1;
import androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1;
import androidx.room.util.ForeignKeyWithSequence;
import androidx.room.util.TableInfo;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.tracing.TraceApi29Impl;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.network.NetworkHeaders;
import coil3.request.ViewTargetRequestManager;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.dokar.quickjs.binding.JsObject;
import com.dokar.quickjs.converter.TypeConverters;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers$MemoizingSupplier;
import com.google.common.base.Suppliers$NonSerializableMemoizingSupplier;
import com.google.common.math.IntMath;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.App;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.entities.AlbumArtistMap;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlayCountEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.RelatedSongMap;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongAlbumMap;
import com.metrolist.music.db.entities.SongArtistMap;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.discord.DiscordAuth$$ExternalSyntheticLambda1;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onGetChildren$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$playlistDuplicatesBatched$1;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$2$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import com.metrolist.music.utils.SyncUtils$executeSyncSavedPlaylists$2;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.date.GMTDateParser;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UByteArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.jvm.internal.TypeReference;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseDao_Impl implements DatabaseDao {
    public final RoomDatabase __db;
    public final AnonymousClass17 __deleteAdapterOfAlbumArtistMap;
    public final AnonymousClass17 __deleteAdapterOfAlbumEntity;
    public final AnonymousClass17 __deleteAdapterOfEvent;
    public final AnonymousClass17 __deleteAdapterOfLyricsEntity;
    public final AnonymousClass17 __deleteAdapterOfPlaylistEntity;
    public final AnonymousClass17 __deleteAdapterOfPlaylistSongMap;
    public final AnonymousClass17 __deleteAdapterOfSearchHistory;
    public final AnonymousClass17 __deleteAdapterOfSongArtistMap;
    public final AnonymousClass17 __deleteAdapterOfSongEntity;
    public final AnonymousClass1 __insertAdapterOfAlbumArtistMap;
    public final AnonymousClass1 __insertAdapterOfAlbumEntity;
    public final AnonymousClass1 __insertAdapterOfArtistEntity;
    public final AnonymousClass1 __insertAdapterOfEvent;
    public final AnonymousClass1 __insertAdapterOfPlayCountEntity;
    public final AnonymousClass1 __insertAdapterOfPlaylistEntity;
    public final AnonymousClass1 __insertAdapterOfPlaylistSongMap;
    public final AnonymousClass1 __insertAdapterOfPodcastEntity;
    public final AnonymousClass1 __insertAdapterOfRecognitionHistory;
    public final AnonymousClass1 __insertAdapterOfRelatedSongMap;
    public final AnonymousClass1 __insertAdapterOfSearchHistory;
    public final AnonymousClass1 __insertAdapterOfSetVideoIdEntity;
    public final AnonymousClass1 __insertAdapterOfSongArtistMap;
    public final AnonymousClass1 __insertAdapterOfSongEntity;
    public final AnonymousClass17 __updateAdapterOfAlbumEntity;
    public final AnonymousClass17 __updateAdapterOfArtistEntity;
    public final AnonymousClass17 __updateAdapterOfPlaylistEntity;
    public final AnonymousClass17 __updateAdapterOfPlaylistSongMap;
    public final AnonymousClass17 __updateAdapterOfPodcastEntity;
    public final AnonymousClass17 __updateAdapterOfSongEntity;
    public final Splitter __upsertAdapterOfFormatEntity;
    public final Splitter __upsertAdapterOfLyricsEntity;
    public final Splitter __upsertAdapterOfSongAlbumMap;
    public final Splitter __upsertAdapterOfSongEntity;

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao_Impl$addSongsToPlaylist$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Playlist $playlist;
        public final /* synthetic */ boolean $prepend;
        public final /* synthetic */ List $songs;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Playlist playlist, List list, boolean z, Continuation continuation) {
            super(1, continuation);
            this.$playlist = playlist;
            this.$songs = list;
            this.$prepend = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DatabaseDao_Impl.this.new AnonymousClass2(this.$playlist, this.$songs, this.$prepend, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((AnonymousClass2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DatabaseDao_Impl databaseDao_Impl;
            boolean z = this.label;
            Unit unit = Unit.INSTANCE;
            byte b = 1;
            if (z) {
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = true;
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            ArrayList arrayList = new ArrayList();
            Iterator it = this.$songs.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                databaseDao_Impl = DatabaseDao_Impl.this;
                if (!zHasNext) {
                    break;
                }
                Pair pair = (Pair) it.next();
                String str = (String) pair.first;
                Pair pair2 = databaseDao_Impl.getSongByIdBlocking(str) != null ? new Pair(str, (String) pair.second) : null;
                if (pair2 != null) {
                    arrayList.add(pair2);
                }
            }
            if (!arrayList.isEmpty()) {
                Playlist playlist = this.$playlist;
                if (this.$prepend) {
                    String str2 = playlist.playlist.id;
                    int size = arrayList.size();
                    str2.getClass();
                    AnonymousClass17.performBlocking(databaseDao_Impl.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda28(size, str2));
                    int size2 = arrayList.size();
                    int i = 0;
                    int i2 = 0;
                    while (i < size2) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        Pair pair3 = (Pair) obj2;
                        String str3 = (String) pair3.first;
                        String str4 = (String) pair3.second;
                        Song songByIdBlocking = databaseDao_Impl.getSongByIdBlocking(str3);
                        songByIdBlocking.getClass();
                        if (songByIdBlocking.song.inLibrary == null) {
                            databaseDao_Impl.inLibrary(str3, localDateTimeNow);
                        }
                        databaseDao_Impl.insert(new PlaylistSongMap(playlist.playlist.id, str3, i2, str4, 1));
                        i2++;
                    }
                } else {
                    String str5 = playlist.playlist.id;
                    str5.getClass();
                    int iIntValue = ((Number) AnonymousClass17.performBlocking(databaseDao_Impl.__db, true, false, new IconKt$$ExternalSyntheticLambda1(str5, (byte) 27))).intValue();
                    int size3 = arrayList.size();
                    int i3 = iIntValue;
                    int i4 = 0;
                    while (i4 < size3) {
                        Object obj3 = arrayList.get(i4);
                        i4++;
                        Pair pair4 = (Pair) obj3;
                        String str6 = (String) pair4.first;
                        String str7 = (String) pair4.second;
                        Song songByIdBlocking2 = databaseDao_Impl.getSongByIdBlocking(str6);
                        songByIdBlocking2.getClass();
                        if (songByIdBlocking2.song.inLibrary == null) {
                            databaseDao_Impl.inLibrary(str6, localDateTimeNow);
                        }
                        databaseDao_Impl.insert(new PlaylistSongMap(playlist.playlist.id, str6, i3, str7, 1));
                        i3++;
                    }
                }
                String str8 = playlist.playlist.id;
                LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                localDateTimeNow2.getClass();
                str8.getClass();
                AnonymousClass17.performBlocking(databaseDao_Impl.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda37(databaseDao_Impl, localDateTimeNow2, str8, b));
            }
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return unit == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    public DatabaseDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        byte b = 0;
        this.__insertAdapterOfPlayCountEntity = new AnonymousClass1(b);
        byte b2 = 7;
        this.__insertAdapterOfRecognitionHistory = new AnonymousClass1(this, b2);
        byte b3 = 11;
        this.__insertAdapterOfSongEntity = new AnonymousClass1(this, b3);
        byte b4 = 13;
        this.__insertAdapterOfArtistEntity = new AnonymousClass1(this, b4);
        byte b5 = 14;
        this.__insertAdapterOfAlbumEntity = new AnonymousClass1(this, b5);
        byte b6 = 15;
        this.__insertAdapterOfPlaylistEntity = new AnonymousClass1(this, b6);
        byte b7 = 16;
        this.__insertAdapterOfSongArtistMap = new AnonymousClass1(b7);
        byte b8 = 17;
        this.__insertAdapterOfAlbumArtistMap = new AnonymousClass1(b8);
        byte b9 = 1;
        this.__insertAdapterOfPlaylistSongMap = new AnonymousClass1(b9);
        byte b10 = 2;
        this.__insertAdapterOfSearchHistory = new AnonymousClass1(b10);
        byte b11 = 3;
        this.__insertAdapterOfEvent = new AnonymousClass1(this, b11);
        byte b12 = 4;
        this.__insertAdapterOfRelatedSongMap = new AnonymousClass1(b12);
        byte b13 = 5;
        this.__insertAdapterOfSetVideoIdEntity = new AnonymousClass1(b13);
        byte b14 = 6;
        this.__insertAdapterOfPodcastEntity = new AnonymousClass1(this, b14);
        this.__deleteAdapterOfSongEntity = new AnonymousClass17(b);
        this.__deleteAdapterOfSongArtistMap = new AnonymousClass17(b9);
        this.__deleteAdapterOfAlbumEntity = new AnonymousClass17(b10);
        this.__deleteAdapterOfAlbumArtistMap = new AnonymousClass17(b11);
        this.__deleteAdapterOfPlaylistEntity = new AnonymousClass17(b12);
        this.__deleteAdapterOfPlaylistSongMap = new AnonymousClass17(b13);
        this.__deleteAdapterOfLyricsEntity = new AnonymousClass17(b14);
        this.__deleteAdapterOfSearchHistory = new AnonymousClass17(b2);
        byte b15 = 8;
        this.__deleteAdapterOfEvent = new AnonymousClass17(b15);
        byte b16 = 9;
        this.__updateAdapterOfSongEntity = new AnonymousClass17(this, b16);
        byte b17 = 10;
        this.__updateAdapterOfArtistEntity = new AnonymousClass17(this, b17);
        this.__updateAdapterOfAlbumEntity = new AnonymousClass17(this, b3);
        byte b18 = 12;
        this.__updateAdapterOfPlaylistEntity = new AnonymousClass17(this, b18);
        this.__updateAdapterOfPlaylistSongMap = new AnonymousClass17(b4);
        this.__updateAdapterOfPodcastEntity = new AnonymousClass17(this, b5);
        this.__upsertAdapterOfSongAlbumMap = new Splitter(new AnonymousClass1(b15), new AnonymousClass17(b6), b14);
        this.__upsertAdapterOfLyricsEntity = new Splitter(new AnonymousClass1(b16), new AnonymousClass17(b7), b14);
        this.__upsertAdapterOfFormatEntity = new Splitter(new AnonymousClass1(b17), new AnonymousClass17(b8), b14);
        this.__upsertAdapterOfSongEntity = new Splitter(new AnonymousClass1(this, b18), new AnonymousClass17(this, (byte) 18), b14);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0150, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015e, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0161, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void __fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 4;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, false, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `album`.`id` AS `id`,`album`.`playlistId` AS `playlistId`,`album`.`title` AS `title`,`album`.`year` AS `year`,`album`.`thumbnailUrl` AS `thumbnailUrl`,`album`.`themeColor` AS `themeColor`,`album`.`songCount` AS `songCount`,`album`.`duration` AS `duration`,`album`.`explicit` AS `explicit`,`album`.`lastUpdateTime` AS `lastUpdateTime`,`album`.`bookmarkedAt` AS `bookmarkedAt`,`album`.`likedDate` AS `likedDate`,`album`.`inLibrary` AS `inLibrary`,`album`.`isLocal` AS `isLocal`,`album`.`isUploaded` AS `isUploaded`,_junction.`songId` FROM `song_album_map` AS _junction INNER JOIN `album` ON (_junction.`albumId` = `album`.`id`) WHERE _junction.`songId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (keyIterator.hasNext()) {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        if (!sQLiteStatementPrepare.step()) {
            sQLiteStatementPrepare.close();
            return;
        }
        String text = sQLiteStatementPrepare.getText(15);
        if (arrayMap.containsKey(text)) {
            String text2 = sQLiteStatementPrepare.getText(0);
            String text3 = sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1);
            String text4 = sQLiteStatementPrepare.getText(2);
            Integer numValueOf = sQLiteStatementPrepare.isNull(3) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(3));
            String text5 = sQLiteStatementPrepare.isNull(b) ? null : sQLiteStatementPrepare.getText(b);
            Integer numValueOf2 = sQLiteStatementPrepare.isNull(5) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(5));
            int i2 = (int) sQLiteStatementPrepare.getLong(6);
            int i3 = (int) sQLiteStatementPrepare.getLong(7);
            boolean z = ((int) sQLiteStatementPrepare.getLong(8)) != 0;
            LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(9)));
            if (localDateTimeFromTimestamp == null) {
                throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
            }
            arrayMap.put(text, new AlbumEntity(text2, text3, text4, numValueOf, text5, numValueOf2, i2, i3, z, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(10))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(11))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(12))), ((int) sQLiteStatementPrepare.getLong(13)) != 0, ((int) sQLiteStatementPrepare.getLong(14)) != 0));
            b = 4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ed, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void __fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 5;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, true, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `artist`.`id` AS `id`,`artist`.`name` AS `name`,`artist`.`thumbnailUrl` AS `thumbnailUrl`,`artist`.`channelId` AS `channelId`,`artist`.`lastUpdateTime` AS `lastUpdateTime`,`artist`.`bookmarkedAt` AS `bookmarkedAt`,`artist`.`isLocal` AS `isLocal`,`artist`.`isPodcastChannel` AS `isPodcastChannel`,_junction.`songId` FROM `sorted_song_artist_map` AS _junction INNER JOIN `artist` ON (_junction.`artistId` = `artist`.`id`) WHERE _junction.`songId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (keyIterator.hasNext()) {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        if (!sQLiteStatementPrepare.step()) {
            sQLiteStatementPrepare.close();
            return;
        }
        List list = (List) arrayMap.get(sQLiteStatementPrepare.getText(8));
        if (list != null) {
            String text = sQLiteStatementPrepare.getText(0);
            String text2 = sQLiteStatementPrepare.getText(1);
            Long lValueOf = null;
            String text3 = sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2);
            String text4 = sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3);
            LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(4)));
            if (localDateTimeFromTimestamp == null) {
                throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
            }
            if (!sQLiteStatementPrepare.isNull(5)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(5));
            }
            list.add(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(lValueOf), ((int) sQLiteStatementPrepare.getLong(6)) != 0, ((int) sQLiteStatementPrepare.getLong(7)) != 0, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00eb, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ee, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void __fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 1;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, true, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `artist`.`id` AS `id`,`artist`.`name` AS `name`,`artist`.`thumbnailUrl` AS `thumbnailUrl`,`artist`.`channelId` AS `channelId`,`artist`.`lastUpdateTime` AS `lastUpdateTime`,`artist`.`bookmarkedAt` AS `bookmarkedAt`,`artist`.`isLocal` AS `isLocal`,`artist`.`isPodcastChannel` AS `isPodcastChannel`,_junction.`albumId` FROM `album_artist_map` AS _junction INNER JOIN `artist` ON (_junction.`artistId` = `artist`.`id`) WHERE _junction.`albumId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (keyIterator.hasNext()) {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        if (!sQLiteStatementPrepare.step()) {
            sQLiteStatementPrepare.close();
            return;
        }
        List list = (List) arrayMap.get(sQLiteStatementPrepare.getText(8));
        if (list != null) {
            String text = sQLiteStatementPrepare.getText(0);
            String text2 = sQLiteStatementPrepare.getText(1);
            Long lValueOf = null;
            String text3 = sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2);
            String text4 = sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3);
            LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(4)));
            if (localDateTimeFromTimestamp == null) {
                throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
            }
            if (!sQLiteStatementPrepare.isNull(5)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(5));
            }
            list.add(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(lValueOf), ((int) sQLiteStatementPrepare.getLong(6)) != 0, ((int) sQLiteStatementPrepare.getLong(7)) != 0, null));
        }
    }

    public final void __fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 3;
        int i = 0;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, false, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `id`,`itag`,`mimeType`,`codecs`,`bitrate`,`sampleRate`,`contentLength`,`loudnessDb`,`perceptualLoudnessDb`,`playbackUrl` FROM `format` WHERE `id` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i2 = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (!keyIterator.hasNext()) {
                try {
                    break;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            } else {
                sQLiteStatementPrepare.bindText(i2, (String) keyIterator.next());
                i2++;
            }
        }
        sQLiteStatementPrepare.getClass();
        int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "id");
        if (iColumnIndexOf == -1) {
            return;
        }
        while (sQLiteStatementPrepare.step()) {
            String text = sQLiteStatementPrepare.getText(iColumnIndexOf);
            if (arrayMap.containsKey(text)) {
                arrayMap.put(text, new FormatEntity(sQLiteStatementPrepare.getText(i), (int) sQLiteStatementPrepare.getLong(1), sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.getText(b), (int) sQLiteStatementPrepare.getLong(4), sQLiteStatementPrepare.isNull(5) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(5)), sQLiteStatementPrepare.getLong(6), sQLiteStatementPrepare.isNull(7) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(7)), sQLiteStatementPrepare.isNull(8) ? null : Double.valueOf(sQLiteStatementPrepare.getDouble(8)), sQLiteStatementPrepare.isNull(9) ? null : sQLiteStatementPrepare.getText(9)));
                b = 3;
                i = 0;
            }
        }
    }

    public final void __fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 0;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, true, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `songId`,`artistId`,`position` FROM `song_artist_map` WHERE `songId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (!keyIterator.hasNext()) {
                try {
                    break;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            }
            sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
            i++;
        }
        sQLiteStatementPrepare.getClass();
        int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "songId");
        if (iColumnIndexOf == -1) {
            sQLiteStatementPrepare.close();
            return;
        }
        while (sQLiteStatementPrepare.step()) {
            List list = (List) arrayMap.get(sQLiteStatementPrepare.getText(iColumnIndexOf));
            if (list != null) {
                list.add(new SongArtistMap(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), (int) sQLiteStatementPrepare.getLong(2)));
            }
        }
        sQLiteStatementPrepare.close();
    }

    public final void __fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 6;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, false, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`lyricsOffset`,`romanizeLyrics`,`isDownloaded`,`isUploaded`,`isVideo`,`isEpisode`,`playbackPosition`,`uploadEntityId`,`isCached` FROM `song` WHERE `id` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (!keyIterator.hasNext()) {
                try {
                    break;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            } else {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        sQLiteStatementPrepare.getClass();
        int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "id");
        if (iColumnIndexOf == -1) {
            return;
        }
        ArrayMap arrayMap3 = new ArrayMap(0);
        ArrayMap arrayMap4 = new ArrayMap(0);
        ArrayMap arrayMap5 = new ArrayMap(0);
        ArrayMap arrayMap6 = new ArrayMap(0);
        while (sQLiteStatementPrepare.step()) {
            String text = sQLiteStatementPrepare.getText(0);
            if (!arrayMap3.containsKey(text)) {
                arrayMap3.put(text, new ArrayList());
            }
            String text2 = sQLiteStatementPrepare.getText(0);
            if (!arrayMap4.containsKey(text2)) {
                arrayMap4.put(text2, new ArrayList());
            }
            arrayMap5.put(sQLiteStatementPrepare.getText(0), null);
            arrayMap6.put(sQLiteStatementPrepare.getText(0), null);
        }
        sQLiteStatementPrepare.reset();
        __fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap3);
        __fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap4);
        __fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap5);
        __fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap6);
        while (sQLiteStatementPrepare.step()) {
            String text3 = sQLiteStatementPrepare.getText(iColumnIndexOf);
            if (arrayMap.containsKey(text3)) {
                SongEntity songEntity = new SongEntity(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), (int) sQLiteStatementPrepare.getLong(2), sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.isNull(4) ? null : sQLiteStatementPrepare.getText(4), sQLiteStatementPrepare.isNull(5) ? null : sQLiteStatementPrepare.getText(5), ((int) sQLiteStatementPrepare.getLong(6)) != 0, sQLiteStatementPrepare.isNull(7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(7)), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(8))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(9))), ((int) sQLiteStatementPrepare.getLong(10)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(11))), sQLiteStatementPrepare.getLong(12), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(13))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(14))), ((int) sQLiteStatementPrepare.getLong(15)) != 0, sQLiteStatementPrepare.isNull(16) ? null : sQLiteStatementPrepare.getText(16), sQLiteStatementPrepare.isNull(17) ? null : sQLiteStatementPrepare.getText(17), (int) sQLiteStatementPrepare.getLong(18), ((int) sQLiteStatementPrepare.getLong(19)) != 0, ((int) sQLiteStatementPrepare.getLong(20)) != 0, ((int) sQLiteStatementPrepare.getLong(21)) != 0, ((int) sQLiteStatementPrepare.getLong(22)) != 0, ((int) sQLiteStatementPrepare.getLong(23)) != 0, sQLiteStatementPrepare.isNull(24) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(24)), sQLiteStatementPrepare.isNull(25) ? null : sQLiteStatementPrepare.getText(25), ((int) sQLiteStatementPrepare.getLong(26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap3, sQLiteStatementPrepare.getText(0));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap4, sQLiteStatementPrepare.getText(0));
                value2.getClass();
                arrayMap.put(text3, new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap5.get(sQLiteStatementPrepare.getText(0)), (FormatEntity) arrayMap6.get(sQLiteStatementPrepare.getText(0))));
            }
        }
    }

    public final void __fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong_1(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        arrayMap = arrayMap;
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        byte b = 2;
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, true, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, b));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `song`.`id` AS `id`,`song`.`title` AS `title`,`song`.`duration` AS `duration`,`song`.`thumbnailUrl` AS `thumbnailUrl`,`song`.`albumId` AS `albumId`,`song`.`albumName` AS `albumName`,`song`.`explicit` AS `explicit`,`song`.`year` AS `year`,`song`.`date` AS `date`,`song`.`dateModified` AS `dateModified`,`song`.`liked` AS `liked`,`song`.`likedDate` AS `likedDate`,`song`.`totalPlayTime` AS `totalPlayTime`,`song`.`inLibrary` AS `inLibrary`,`song`.`dateDownload` AS `dateDownload`,`song`.`isLocal` AS `isLocal`,`song`.`libraryAddToken` AS `libraryAddToken`,`song`.`libraryRemoveToken` AS `libraryRemoveToken`,`song`.`lyricsOffset` AS `lyricsOffset`,`song`.`romanizeLyrics` AS `romanizeLyrics`,`song`.`isDownloaded` AS `isDownloaded`,`song`.`isUploaded` AS `isUploaded`,`song`.`isVideo` AS `isVideo`,`song`.`isEpisode` AS `isEpisode`,`song`.`playbackPosition` AS `playbackPosition`,`song`.`uploadEntityId` AS `uploadEntityId`,`song`.`isCached` AS `isCached`,_junction.`albumId` FROM `sorted_song_album_map` AS _junction INNER JOIN `song` ON (_junction.`songId` = `song`.`id`) WHERE _junction.`albumId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (!keyIterator.hasNext()) {
                try {
                    break;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            } else {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        ArrayMap arrayMap3 = new ArrayMap(0);
        ArrayMap arrayMap4 = new ArrayMap(0);
        ArrayMap arrayMap5 = new ArrayMap(0);
        ArrayMap arrayMap6 = new ArrayMap(0);
        while (sQLiteStatementPrepare.step()) {
            String text = sQLiteStatementPrepare.getText(0);
            if (!arrayMap3.containsKey(text)) {
                arrayMap3.put(text, new ArrayList());
            }
            String text2 = sQLiteStatementPrepare.getText(0);
            if (!arrayMap4.containsKey(text2)) {
                arrayMap4.put(text2, new ArrayList());
            }
            arrayMap5.put(sQLiteStatementPrepare.getText(0), null);
            arrayMap6.put(sQLiteStatementPrepare.getText(0), null);
        }
        sQLiteStatementPrepare.reset();
        __fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap3);
        __fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap4);
        __fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap5);
        __fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap6);
        while (sQLiteStatementPrepare.step()) {
            List list = (List) arrayMap.get(sQLiteStatementPrepare.getText(27));
            if (list != null) {
                SongEntity songEntity = new SongEntity(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), (int) sQLiteStatementPrepare.getLong(2), sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.isNull(4) ? null : sQLiteStatementPrepare.getText(4), sQLiteStatementPrepare.isNull(5) ? null : sQLiteStatementPrepare.getText(5), ((int) sQLiteStatementPrepare.getLong(6)) != 0, sQLiteStatementPrepare.isNull(7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(7)), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(8))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(9))), ((int) sQLiteStatementPrepare.getLong(10)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(11))), sQLiteStatementPrepare.getLong(12), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(13))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(14))), ((int) sQLiteStatementPrepare.getLong(15)) != 0, sQLiteStatementPrepare.isNull(16) ? null : sQLiteStatementPrepare.getText(16), sQLiteStatementPrepare.isNull(17) ? null : sQLiteStatementPrepare.getText(17), (int) sQLiteStatementPrepare.getLong(18), ((int) sQLiteStatementPrepare.getLong(19)) != 0, ((int) sQLiteStatementPrepare.getLong(20)) != 0, ((int) sQLiteStatementPrepare.getLong(21)) != 0, ((int) sQLiteStatementPrepare.getLong(22)) != 0, ((int) sQLiteStatementPrepare.getLong(23)) != 0, sQLiteStatementPrepare.isNull(24) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(24)), sQLiteStatementPrepare.isNull(25) ? null : sQLiteStatementPrepare.getText(25), ((int) sQLiteStatementPrepare.getLong(26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap3, sQLiteStatementPrepare.getText(0));
                value.getClass();
                List list2 = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap4, sQLiteStatementPrepare.getText(0));
                value2.getClass();
                list.add(new Song(songEntity, list2, (List) value2, (AlbumEntity) arrayMap5.get(sQLiteStatementPrepare.getText(0)), (FormatEntity) arrayMap6.get(sQLiteStatementPrepare.getText(0))));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void __fetchRelationshipsongAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap arrayMap) throws Exception {
        ArrayMap.KeySet keySet = (ArrayMap.KeySet) arrayMap.keySet();
        ArrayMap arrayMap2 = ArrayMap.this;
        if (arrayMap2.isEmpty()) {
            return;
        }
        if (arrayMap.size > 999) {
            IntMath.recursiveFetchArrayMap(arrayMap, true, new DatabaseDao_Impl$$ExternalSyntheticLambda33(this, sQLiteConnection, (byte) 7));
            return;
        }
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT `song`.`thumbnailUrl` AS `thumbnailUrl`,_junction.`playlistId` FROM `playlist_song_map_preview` AS _junction INNER JOIN `song` ON (_junction.`songId` = `song`.`id`) WHERE _junction.`playlistId` IN (");
        SQLite.appendPlaceholders(sbM, arrayMap2.size);
        sbM.append(")");
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(sbM.toString());
        Iterator it = keySet.iterator();
        int i = 1;
        while (true) {
            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
            if (keyIterator.hasNext()) {
                sQLiteStatementPrepare.bindText(i, (String) keyIterator.next());
                i++;
            }
        }
        if (!sQLiteStatementPrepare.step()) {
            sQLiteStatementPrepare.close();
        } else {
            List list = (List) arrayMap.get(sQLiteStatementPrepare.getText(1));
            if (list != null) {
                list.add(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0));
            }
        }
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void addLibraryTokens(String str, String str2, String str3) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MainActivity$$ExternalSyntheticLambda21((Object) str2, (Object) str3, (Object) str, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object addSongsToPlaylist(Playlist playlist, List list, boolean z, ContinuationImpl continuationImpl) {
        Object objPerformInTransactionSuspending = AnonymousClass17.performInTransactionSuspending(this.__db, new AnonymousClass2(playlist, list, z, null), continuationImpl);
        return objPerformInTransactionSuspending == CoroutineSingletons.COROUTINE_SUSPENDED ? objPerformInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object addToPlayCountRow(final String str, final int i, final int i2, final int i3, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, false, true, new Function1() { // from class: com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) throws Exception {
                int i4 = i3;
                String str2 = str;
                int i5 = i;
                int i6 = i2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n    UPDATE playCount\n    SET count = count + ?\n    WHERE song = ? AND year = ? AND month = ?\n    ");
                try {
                    sQLiteStatementPrepare.bindLong(1, i4);
                    sQLiteStatementPrepare.bindText(2, str2);
                    sQLiteStatementPrepare.bindLong(3, i5);
                    sQLiteStatementPrepare.bindLong(4, i6);
                    sQLiteStatementPrepare.step();
                    return Integer.valueOf(MathKt.getTotalChangedRows(sQLiteConnection));
                } finally {
                    sQLiteStatementPrepare.close();
                }
            }
        }, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow album(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 6);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumEntity(String str, SuspendLambda suspendLambda) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new IconKt$$ExternalSyntheticLambda1((byte) 28, this, str), suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumSongs(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 0);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumWithSongs(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 15);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "sorted_song_artist_map", "song_artist_map", "song_album_map", "album", "format", "sorted_song_album_map", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 25);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByLengthAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 2);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 8);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsBySongCountAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 13);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsByYearAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 6);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByLengthAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 16);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 7);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 24);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedBySongCountAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 21);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsLikedByYearAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 15);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 18);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByLengthAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 23);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 9);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 4);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedBySongCountAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 14);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow albumsUploadedByYearAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 17);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow allArtistsByPlayTime() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 12);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "event", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow allSongs() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 15);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artist(String str) {
        str.getClass();
        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1((byte) 21, this, str);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"song_artist_map", "song", "artist"}, iconKt$$ExternalSyntheticLambda1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistAlbumsPreview(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 4);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final ArtistEntity artistByName(String str) {
        str.getClass();
        return (ArtistEntity) AnonymousClass17.performBlocking(this.__db, true, true, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, this, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistEntity(String str, QuickJs.AnonymousClass3 anonymousClass3) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, this, (byte) 6), anonymousClass3);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByCreateDateAsc(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 14);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByNameAsc(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 5);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsByPlayTimeAsc(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 2);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistSongsPreview(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByCreateDateAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 16);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByNameAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 11);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedByPlayTimeAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 18);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBookmarkedBySongCountAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 14);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByCreateDateAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 19);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByNameAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 22);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsByPlayTimeAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 20);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow artistsBySongCountAsc() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 17);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object bookmarkedArtistEntitiesByNameAsc(QuickJs.AnonymousClass3 anonymousClass3) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 4, this), anonymousClass3);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object bookmarkedPlaylistBrowseIds(MediaLibrarySessionCallback$onGetChildren$1 mediaLibrarySessionCallback$onGetChildren$1) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao$$ExternalSyntheticLambda0((byte) 25), mediaLibrarySessionCallback$onGetChildren$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow bookmarkedPodcastChannels() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 21);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow cachePlaylistSongs() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 0);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearListenHistory() {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearPlaylist(String str) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new IconKt$$ExternalSyntheticLambda1(str, (byte) 16));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearRecognitionHistory() {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao$$ExternalSyntheticLambda0((byte) 24));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void clearSearchHistory() {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao$$ExternalSyntheticLambda0((byte) 27));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(SongEntity songEntity) {
        songEntity.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda19(this, songEntity, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void deleteFormat(String str) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 8));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object deletePlayCountsForSong(String str, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, false, true, new IconKt$$ExternalSyntheticLambda1(str, (byte) 18), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void deleteRecognitionHistoryById(long j) {
        AnonymousClass17.performBlocking(this.__db, false, true, new InnerTube$$ExternalSyntheticLambda2(j, (byte) 4));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 26);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 8);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedPodcastEpisodesByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 28);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 0);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 12);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow downloadedSongsByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 22);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow eventCount() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0((byte) 15);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"event"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object existingSongIds(List list, MediaLibrarySessionCallback.C01641 c01641) {
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT id FROM song WHERE id IN (");
        SQLite.appendPlaceholders(sbM, list.size());
        sbM.append(")");
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda101(sbM.toString(), list, (byte) 1), c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow firstEvent() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 10);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "event"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow forgottenFavorites(long j) {
        DatabaseDao_Impl$$ExternalSyntheticLambda166 databaseDao_Impl$$ExternalSyntheticLambda166 = new DatabaseDao_Impl$$ExternalSyntheticLambda166(j, this, (byte) 1);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "event", "song"}, databaseDao_Impl$$ExternalSyntheticLambda166);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow format(String str) {
        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str, (byte) 26);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"format"}, iconKt$$ExternalSyntheticLambda1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow getLifetimePlayCount(String str) {
        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str, (byte) 24);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"playCount"}, iconKt$$ExternalSyntheticLambda1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getPlayCountsForSong(String str, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new IconKt$$ExternalSyntheticLambda1(str, (byte) 19), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Long getPlaybackPosition(String str) {
        str.getClass();
        return (Long) AnonymousClass17.performBlocking(this.__db, true, false, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 3));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow getRelatedSongs(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 1);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "related_song_map", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSetVideoId(String str, ContinuationImpl continuationImpl) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new IconKt$$ExternalSyntheticLambda1(str, (byte) 29), continuationImpl);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSongById(String str, MusicService.C01661 c01661) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 10), c01661);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Song getSongByIdBlocking(String str) {
        str.getClass();
        return (Song) AnonymousClass17.performBlocking(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 12));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object getSongsByIds(List list, MediaLibrarySessionCallback.C01641 c01641) {
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT * FROM song WHERE id IN (");
        SQLite.appendPlaceholders(sbM, list.size());
        sbM.append(")");
        return AnonymousClass17.performSuspending(this.__db, true, true, new MainActivity$$ExternalSyntheticLambda21((Object) sbM.toString(), (Object) list, (Object) this, (byte) 1), c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Long getTotalPlayTimeForSong(String str) {
        str.getClass();
        return (Long) AnonymousClass17.performBlocking(this.__db, true, false, new IconKt$$ExternalSyntheticLambda1(str, (byte) 22));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final boolean hasRelatedSongs(String str) {
        str.getClass();
        return ((Boolean) AnonymousClass17.performBlocking(this.__db, true, true, new IconKt$$ExternalSyntheticLambda1(str, (byte) 20))).booleanValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow historyEvents(LocalDateTime localDateTime, LocalDateTime localDateTime2, LocalDateTime localDateTime3, LocalDateTime localDateTime4, LocalDateTime localDateTime5) {
        SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(this, localDateTime, localDateTime2, localDateTime3, localDateTime4, localDateTime5, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "event"}, songMenuKt$$ExternalSyntheticLambda20);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void inLibrary(String str, LocalDateTime localDateTime) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda37(this, localDateTime, str, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void incrementTotalPlayTime(long j, String str) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new ScrimKt$$ExternalSyntheticLambda1(j, (Object) str, (byte) 3));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(SongEntity songEntity) {
        songEntity.getClass();
        return ((Number) AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda19(this, songEntity, (byte) 2))).longValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object insertPlayCountRow(PlayCountEntity playCountEntity, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, playCountEntity, (byte) 13), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow latestEvent() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 4);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "event"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object librarySongEntitiesByNameAsc(MutatorMutex.AnonymousClass2 anonymousClass2) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 10), anonymousClass2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedAlbumEntitiesByNameAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 1, this), syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedSongIds(SongMenuKt$SongMenu$2$1$1 songMenuKt$SongMenu$2$1$1) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 2), songMenuKt$SongMenu$2$1$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 12);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object likedSongsByCreateDateDesc(int i, int i2, MediaLibrarySessionCallback.C01641 c01641) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda69(i, i2, this, (byte) 2), c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 17);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 14);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsByRowIdAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 13);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow likedSongsCount() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0((byte) 13);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow lyrics(String str) {
        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str, (byte) 25);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"lyrics"}, iconKt$$ExternalSyntheticLambda1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedAlbums(LocalDateTime localDateTime, int i, int i2, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda130 databaseDao_Impl$$ExternalSyntheticLambda130 = new DatabaseDao_Impl$$ExternalSyntheticLambda130(this, localDateTime, localDateTime2, i, i2);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "song_album_map", "event", "album"}, databaseDao_Impl$$ExternalSyntheticLambda130);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedArtists(LocalDateTime localDateTime, int i, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        ScrollNode$$ExternalSyntheticLambda2 scrollNode$$ExternalSyntheticLambda2 = new ScrollNode$$ExternalSyntheticLambda2(this, localDateTime, localDateTime2, i);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "event", "artist"}, scrollNode$$ExternalSyntheticLambda2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedSongs(final LocalDateTime localDateTime, final int i, final int i2, final LocalDateTime localDateTime2) {
        localDateTime.getClass();
        Function1 function1 = new Function1() { // from class: com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda24
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) throws Exception {
                DatabaseDao_Impl databaseDao_Impl = this.f$1;
                LocalDateTime localDateTime3 = localDateTime;
                LocalDateTime localDateTime4 = localDateTime2;
                int i3 = i;
                byte b = i2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT `id`, `title`, `duration`, `thumbnailUrl`, `albumId`, `albumName`, `explicit`, `year`, `date`, `dateModified`, `liked`, `likedDate`, `totalPlayTime`, `inLibrary`, `dateDownload`, `isLocal`, `libraryAddToken`, `libraryRemoveToken`, `lyricsOffset`, `romanizeLyrics`, `isDownloaded`, `isUploaded`, `isVideo`, `isEpisode`, `playbackPosition`, `uploadEntityId`, `isCached` FROM (\n        SELECT song.*,\n               (SELECT COUNT(1)\n                FROM event\n                WHERE songId = song.id\n                  AND timestamp > ? AND timestamp <= ?) AS songCountListened,\n               (SELECT SUM(event.playTime)\n                FROM event\n                WHERE songId = song.id\n                  AND timestamp > ? AND timestamp <= ?) AS timeListened\n        FROM song\n        JOIN (SELECT songId\n                     FROM event\n                     WHERE timestamp > ?\n                     AND timestamp <= ?\n                     GROUP BY songId\n                     ORDER BY SUM(playTime) DESC\n                     LIMIT ? OFFSET ?)\n        ON song.id = songId\n    )");
                try {
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime3);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare.bindNull(1);
                    } else {
                        sQLiteStatementPrepare.bindLong(1, lDateToTimestamp.longValue());
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(localDateTime4);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatementPrepare.bindNull(2);
                    } else {
                        sQLiteStatementPrepare.bindLong(2, lDateToTimestamp2.longValue());
                    }
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(localDateTime3);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatementPrepare.bindNull(3);
                    } else {
                        sQLiteStatementPrepare.bindLong(3, lDateToTimestamp3.longValue());
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(localDateTime4);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatementPrepare.bindNull(4);
                    } else {
                        sQLiteStatementPrepare.bindLong(4, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(localDateTime3);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatementPrepare.bindNull(5);
                    } else {
                        sQLiteStatementPrepare.bindLong(5, lDateToTimestamp5.longValue());
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(localDateTime4);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatementPrepare.bindNull(6);
                    } else {
                        sQLiteStatementPrepare.bindLong(6, lDateToTimestamp6.longValue());
                    }
                    sQLiteStatementPrepare.bindLong(7, i3);
                    sQLiteStatementPrepare.bindLong(8, b);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumId");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumName");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "explicit");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "year");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "date");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateModified");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "liked");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "likedDate");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "totalPlayTime");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "inLibrary");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateDownload");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryAddToken");
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryRemoveToken");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lyricsOffset");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "romanizeLyrics");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDownloaded");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isUploaded");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isVideo");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isEpisode");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playbackPosition");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "uploadEntityId");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isCached");
                    int i4 = columnIndexOrThrow12;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i5 = columnIndexOrThrow11;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i6 = columnIndexOrThrow10;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i7 = columnIndexOrThrow9;
                    ArrayMap arrayMap4 = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text)) {
                            arrayMap.put(text, new ArrayList());
                        }
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap2.containsKey(text2)) {
                            arrayMap2.put(text2, new ArrayList());
                        }
                        arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                        arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                        columnIndexOrThrow8 = columnIndexOrThrow8;
                    }
                    int i8 = columnIndexOrThrow8;
                    String str = null;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        ArrayList arrayList2 = arrayList;
                        int i9 = columnIndexOrThrow2;
                        int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        int i11 = i8;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(i11) ? str : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i11));
                        int i12 = i7;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i12) ? str : Long.valueOf(sQLiteStatementPrepare.getLong(i12)));
                        int i13 = i6;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? str : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        i8 = i11;
                        i7 = i12;
                        int i14 = i5;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i14)) != 0;
                        int i15 = i4;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i15)));
                        int i16 = columnIndexOrThrow13;
                        long j = sQLiteStatementPrepare.getLong(i16);
                        i4 = i15;
                        int i17 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i17)));
                        columnIndexOrThrow14 = i17;
                        int i18 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i18) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i18)));
                        columnIndexOrThrow15 = i18;
                        columnIndexOrThrow13 = i16;
                        int i19 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                        int i20 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                        int i21 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                        int i22 = columnIndexOrThrow19;
                        int i23 = (int) sQLiteStatementPrepare.getLong(i22);
                        int i24 = columnIndexOrThrow20;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                        int i25 = columnIndexOrThrow21;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        int i26 = columnIndexOrThrow22;
                        int i27 = columnIndexOrThrow4;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                        int i28 = columnIndexOrThrow23;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i28)) != 0;
                        int i29 = columnIndexOrThrow24;
                        boolean z8 = ((int) sQLiteStatementPrepare.getLong(i29)) != 0;
                        int i30 = columnIndexOrThrow25;
                        int i31 = columnIndexOrThrow26;
                        int i32 = columnIndexOrThrow27;
                        SongEntity songEntity = new SongEntity(text3, text4, i10, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i23, z4, z5, z6, z7, z8, sQLiteStatementPrepare.isNull(i30) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i30)), sQLiteStatementPrepare.isNull(i31) ? null : sQLiteStatementPrepare.getText(i31), ((int) sQLiteStatementPrepare.getLong(i32)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList2.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow2 = i9;
                        i5 = i14;
                        i6 = i13;
                        columnIndexOrThrow16 = i19;
                        columnIndexOrThrow17 = i20;
                        columnIndexOrThrow18 = i21;
                        columnIndexOrThrow19 = i22;
                        columnIndexOrThrow20 = i24;
                        columnIndexOrThrow3 = columnIndexOrThrow3;
                        str = null;
                        columnIndexOrThrow21 = i25;
                        columnIndexOrThrow4 = i27;
                        columnIndexOrThrow22 = i26;
                        columnIndexOrThrow23 = i28;
                        columnIndexOrThrow24 = i29;
                        columnIndexOrThrow25 = i30;
                        columnIndexOrThrow26 = i31;
                        columnIndexOrThrow27 = i32;
                        arrayList = arrayList2;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            }
        };
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "event", "song"}, function1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow mostPlayedSongsStats(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        MainActivity$$ExternalSyntheticLambda21 mainActivity$$ExternalSyntheticLambda21 = new MainActivity$$ExternalSyntheticLambda21((Object) this, (Object) localDateTime, (Object) localDateTime2, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "event", "song", "song_artist_map"}, mainActivity$$ExternalSyntheticLambda21);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void move(int i, int i2, String str) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MultiParagraph$$ExternalSyntheticLambda1(i, i2, str));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlist(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 9);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Playlist playlistBlocking(String str) {
        str.getClass();
        return (Playlist) AnonymousClass17.performBlocking(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 13));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistByBrowseId(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 7);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistDuplicates(String str, List list, AddToPlaylistDialogKt$playlistDuplicatesBatched$1 addToPlaylistDialogKt$playlistDuplicatesBatched$1) {
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("SELECT songId from playlist_song_map WHERE playlistId = ? AND songId IN (");
        SQLite.appendPlaceholders(sbM, list.size());
        sbM.append(")");
        return AnonymousClass17.performSuspending(this.__db, true, false, new MainActivity$$ExternalSyntheticLambda21((Object) sbM.toString(), (Object) str, (Object) list, (byte) 6), addToPlaylistDialogKt$playlistDuplicatesBatched$1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistEntitiesByNameAsc(SuspendLambda suspendLambda) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 29), suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistSongIdsWithoutArtists(String str, SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 9), syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final List playlistSongMaps(String str) {
        str.getClass();
        return (List) AnonymousClass17.performBlocking(this.__db, true, true, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 7));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistSongs(String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 11);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "playlist_song_map"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 11);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 11);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsBySongCountAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 20);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow playlistsByUpdatedDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 1);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow podcast(String str) {
        str.getClass();
        StringsKt__IndentKt$$ExternalSyntheticLambda0 stringsKt__IndentKt$$ExternalSyntheticLambda0 = new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, this, (byte) 5);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"podcast"}, stringsKt__IndentKt$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow podcastEpisodesByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 18);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow quickPicks(long j) {
        DatabaseDao_Impl$$ExternalSyntheticLambda166 databaseDao_Impl$$ExternalSyntheticLambda166 = new DatabaseDao_Impl$$ExternalSyntheticLambda166(j, this, (byte) 0);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "related_song_map", "song", "event"}, databaseDao_Impl$$ExternalSyntheticLambda166);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final int raw(Joiner joiner) {
        RoomSQLiteQuery roomSQLiteQuery;
        TreeMap treeMap = RoomSQLiteQuery.queryPool;
        String str = joiner.separator;
        TreeMap treeMap2 = RoomSQLiteQuery.queryPool;
        synchronized (treeMap2) {
            Map.Entry entryCeilingEntry = treeMap2.ceilingEntry(0);
            if (entryCeilingEntry != null) {
                treeMap2.remove(entryCeilingEntry.getKey());
                roomSQLiteQuery = (RoomSQLiteQuery) entryCeilingEntry.getValue();
                roomSQLiteQuery.getClass();
                roomSQLiteQuery.query = str;
                roomSQLiteQuery.argCount = 0;
            } else {
                roomSQLiteQuery = new RoomSQLiteQuery(0);
                roomSQLiteQuery.query = str;
                roomSQLiteQuery.argCount = 0;
            }
        }
        String sql = roomSQLiteQuery.getSql();
        byte b = 17;
        DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0(b, roomSQLiteQuery);
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.delegate = new DiskLruCache$$ExternalSyntheticLambda0((byte) 16, diskLruCache$$ExternalSyntheticLambda0);
        return ((Number) AnonymousClass17.performBlocking(this.__db, true, false, new QuickJs$$ExternalSyntheticLambda1(sql, connectionPool, b))).intValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow recognitionHistory() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 8);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"recognition_history"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void repairMissingVideoThumbnails() {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao$$ExternalSyntheticLambda0((byte) 23));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void replaceSongArtists(String str, ArrayList arrayList) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MainActivity$$ExternalSyntheticLambda21((Object) this, (Object) str, (Object) arrayList, (byte) 8));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object savedEpisodeEntitiesByCreateDateAsc(SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 9), syncUtils$executeSyncPlaylist$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 5);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 10);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow savedPodcastEpisodesByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 29);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchAlbums(int i, String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda98 databaseDao_Impl$$ExternalSyntheticLambda98 = new DatabaseDao_Impl$$ExternalSyntheticLambda98(str, i, this, (byte) 3);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"album_artist_map", "artist", "album", "song"}, databaseDao_Impl$$ExternalSyntheticLambda98);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchArtists(int i, String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda28 databaseDao_Impl$$ExternalSyntheticLambda28 = new DatabaseDao_Impl$$ExternalSyntheticLambda28(str, i, this);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"song_artist_map", "song", "artist"}, databaseDao_Impl$$ExternalSyntheticLambda28);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchHistory(String str) {
        str.getClass();
        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str, (byte) 17);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"search_history"}, iconKt$$ExternalSyntheticLambda1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchPlaylists(int i, String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda98 databaseDao_Impl$$ExternalSyntheticLambda98 = new DatabaseDao_Impl$$ExternalSyntheticLambda98(str, i, this, (byte) 0);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"playlist_song_map_preview", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda98);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchSongs(int i, String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda98 databaseDao_Impl$$ExternalSyntheticLambda98 = new DatabaseDao_Impl$$ExternalSyntheticLambda98(str, i, this, (byte) 2);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda98);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow searchSongsExtended(int i, String str) {
        str.getClass();
        DatabaseDao_Impl$$ExternalSyntheticLambda98 databaseDao_Impl$$ExternalSyntheticLambda98 = new DatabaseDao_Impl$$ExternalSyntheticLambda98(str, i, this, (byte) 1);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda98);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow song(String str) {
        DatabaseDao_Impl$$ExternalSyntheticLambda9 databaseDao_Impl$$ExternalSyntheticLambda9 = new DatabaseDao_Impl$$ExternalSyntheticLambda9(str, this, (byte) 8);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda9);
    }

    public final List songArtistMap(String str) {
        str.getClass();
        return (List) AnonymousClass17.performBlocking(this.__db, true, true, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object songEntity(String str, SuspendLambda suspendLambda) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new StringsKt__IndentKt$$ExternalSyntheticLambda0(str, this, (byte) 4), suspendLambda);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final List songIdsWithoutArtists(List list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("\n        SELECT id FROM song\n        WHERE id IN (");
        SQLite.appendPlaceholders(sb, list.size());
        sb.append(")");
        sb.append("\n");
        sb.append("          AND NOT EXISTS (");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, "\n", "              SELECT 1 FROM song_artist_map WHERE song_artist_map.songId = song.id", "\n", "          )");
        return (List) AnonymousClass17.performBlocking(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda101(IntIntPair$$ExternalSyntheticOutline0.m(sb, "\n", "        "), list, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 16);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 19);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 27);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsByRowIdAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 7);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow songsInBookmarkedPlaylists() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 9);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song", "playlist_song_map", "playlist"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow subscribedPodcasts() {
        DatabaseDao$$ExternalSyntheticLambda0 databaseDao$$ExternalSyntheticLambda0 = new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 28);
        return LifecyclesKt.createFlow(this.__db, false, new String[]{"podcast"}, databaseDao$$ExternalSyntheticLambda0);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object transferEvents(String str, String str2, DatabaseDao.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, false, true, new DiscordAuth$$ExternalSyntheticLambda1(str2, str, (byte) 1), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object transferSongStats(String str, String str2, InnerTube$feedback$2 innerTube$feedback$2) {
        Object objPerformInTransactionSuspending = AnonymousClass17.performInTransactionSuspending(this.__db, new QuickJs.C00594((Object) this, (Object) str, (Object) str2, (Continuation) null, (byte) 3), innerTube$feedback$2);
        return objPerformInTransactionSuspending == CoroutineSingletons.COROUTINE_SUSPENDED ? objPerformInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(ArtistEntity artistEntity, ArtistPage artistPage) {
        artistEntity.getClass();
        artistPage.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MainActivity$$ExternalSyntheticLambda21((Object) this, (Object) artistEntity, (Object) artistPage, (byte) 4));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updateArtistThumbnail(String str, String str2) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DiscordAuth$$ExternalSyntheticLambda1(str2, str, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updateDownloadedInfo(String str, boolean z, LocalDateTime localDateTime) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new LyricsUtils$$ExternalSyntheticLambda0(z, this, localDateTime, str));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void updatePlaybackPosition(String str, Long l) {
        str.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(l, str, (byte) 16));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object uploadedAlbumEntitiesByNameAsc(SyncUtils$executeSyncSavedPlaylists$2 syncUtils$executeSyncSavedPlaylists$2) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 3, this), syncUtils$executeSyncSavedPlaylists$2);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object uploadedSongEntitiesByNameAsc(SyncUtils.C01852 c01852) {
        return AnonymousClass17.performSuspending(this.__db, true, false, new DatabaseDao$$ExternalSyntheticLambda0(this, (byte) 26), c01852);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByCreateDateAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda109 databaseDao_Impl$$ExternalSyntheticLambda109 = new DatabaseDao_Impl$$ExternalSyntheticLambda109(this, (byte) 2);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda109);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByNameAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 5);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByPlayTimeAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 1);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Flow uploadedSongsByRowIdAsc() {
        DatabaseDao_Impl$$ExternalSyntheticLambda25 databaseDao_Impl$$ExternalSyntheticLambda25 = new DatabaseDao_Impl$$ExternalSyntheticLambda25(this, (byte) 6);
        return LifecyclesKt.createFlow(this.__db, true, new String[]{"sorted_song_artist_map", "artist", "song_artist_map", "song_album_map", "album", "format", "song"}, databaseDao_Impl$$ExternalSyntheticLambda25);
    }

    public final void upsert(SongAlbumMap songAlbumMap) {
        songAlbumMap.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, songAlbumMap, (byte) 14));
    }

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao_Impl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SizeKt {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        @Override // coil3.size.SizeKt
        public final void bind(SQLiteStatement sQLiteStatement, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    PlayCountEntity playCountEntity = (PlayCountEntity) obj;
                    sQLiteStatement.getClass();
                    playCountEntity.getClass();
                    sQLiteStatement.bindText(1, playCountEntity.song);
                    sQLiteStatement.bindLong(2, playCountEntity.year);
                    sQLiteStatement.bindLong(3, playCountEntity.month);
                    sQLiteStatement.bindLong(4, playCountEntity.count);
                    break;
                case 1:
                    PlaylistSongMap playlistSongMap = (PlaylistSongMap) obj;
                    sQLiteStatement.getClass();
                    playlistSongMap.getClass();
                    sQLiteStatement.bindLong(1, playlistSongMap.id);
                    sQLiteStatement.bindText(2, playlistSongMap.playlistId);
                    sQLiteStatement.bindText(3, playlistSongMap.songId);
                    sQLiteStatement.bindLong(4, playlistSongMap.position);
                    String str = playlistSongMap.setVideoId;
                    if (str != null) {
                        sQLiteStatement.bindText(5, str);
                    } else {
                        sQLiteStatement.bindNull(5);
                    }
                    break;
                case 2:
                    SearchHistory searchHistory = (SearchHistory) obj;
                    sQLiteStatement.getClass();
                    searchHistory.getClass();
                    sQLiteStatement.bindLong(1, searchHistory.id);
                    sQLiteStatement.bindText(2, searchHistory.query);
                    break;
                case 3:
                    Event event = (Event) obj;
                    sQLiteStatement.getClass();
                    event.getClass();
                    sQLiteStatement.bindLong(1, event.id);
                    sQLiteStatement.bindText(2, event.songId);
                    Long lDateToTimestamp = Converters.dateToTimestamp(event.timestamp);
                    if (lDateToTimestamp == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindLong(3, lDateToTimestamp.longValue());
                    }
                    sQLiteStatement.bindLong(4, event.playTime);
                    break;
                case 4:
                    RelatedSongMap relatedSongMap = (RelatedSongMap) obj;
                    sQLiteStatement.getClass();
                    relatedSongMap.getClass();
                    sQLiteStatement.bindLong(1, 0L);
                    sQLiteStatement.bindText(2, relatedSongMap.songId);
                    sQLiteStatement.bindText(3, relatedSongMap.relatedSongId);
                    break;
                case 5:
                    SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) obj;
                    sQLiteStatement.getClass();
                    setVideoIdEntity.getClass();
                    sQLiteStatement.bindText(1, setVideoIdEntity.videoId);
                    String str2 = setVideoIdEntity.setVideoId;
                    if (str2 != null) {
                        sQLiteStatement.bindText(2, str2);
                    } else {
                        sQLiteStatement.bindNull(2);
                    }
                    break;
                case 6:
                    PodcastEntity podcastEntity = (PodcastEntity) obj;
                    sQLiteStatement.getClass();
                    podcastEntity.getClass();
                    sQLiteStatement.bindText(1, podcastEntity.id);
                    sQLiteStatement.bindText(2, podcastEntity.title);
                    String str3 = podcastEntity.author;
                    if (str3 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str3);
                    }
                    String str4 = podcastEntity.thumbnailUrl;
                    if (str4 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str4);
                    }
                    String str5 = podcastEntity.channelId;
                    if (str5 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str5);
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(podcastEntity.bookmarkedAt);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, lDateToTimestamp2.longValue());
                    }
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(podcastEntity.lastUpdateTime);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatement.bindNull(7);
                    } else {
                        sQLiteStatement.bindLong(7, lDateToTimestamp3.longValue());
                    }
                    String str6 = podcastEntity.libraryAddToken;
                    if (str6 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindText(8, str6);
                    }
                    String str7 = podcastEntity.libraryRemoveToken;
                    if (str7 != null) {
                        sQLiteStatement.bindText(9, str7);
                    } else {
                        sQLiteStatement.bindNull(9);
                    }
                    break;
                case 7:
                    RecognitionHistory recognitionHistory = (RecognitionHistory) obj;
                    sQLiteStatement.getClass();
                    recognitionHistory.getClass();
                    sQLiteStatement.bindLong(1, recognitionHistory.id);
                    sQLiteStatement.bindText(2, recognitionHistory.trackId);
                    sQLiteStatement.bindText(3, recognitionHistory.title);
                    sQLiteStatement.bindText(4, recognitionHistory.artist);
                    String str8 = recognitionHistory.album;
                    if (str8 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str8);
                    }
                    String str9 = recognitionHistory.coverArtUrl;
                    if (str9 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str9);
                    }
                    String str10 = recognitionHistory.coverArtHqUrl;
                    if (str10 == null) {
                        sQLiteStatement.bindNull(7);
                    } else {
                        sQLiteStatement.bindText(7, str10);
                    }
                    String str11 = recognitionHistory.genre;
                    if (str11 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindText(8, str11);
                    }
                    String str12 = recognitionHistory.releaseDate;
                    if (str12 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindText(9, str12);
                    }
                    String str13 = recognitionHistory.label;
                    if (str13 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindText(10, str13);
                    }
                    String str14 = recognitionHistory.shazamUrl;
                    if (str14 == null) {
                        sQLiteStatement.bindNull(11);
                    } else {
                        sQLiteStatement.bindText(11, str14);
                    }
                    String str15 = recognitionHistory.appleMusicUrl;
                    if (str15 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindText(12, str15);
                    }
                    String str16 = recognitionHistory.spotifyUrl;
                    if (str16 == null) {
                        sQLiteStatement.bindNull(13);
                    } else {
                        sQLiteStatement.bindText(13, str16);
                    }
                    String str17 = recognitionHistory.isrc;
                    if (str17 == null) {
                        sQLiteStatement.bindNull(14);
                    } else {
                        sQLiteStatement.bindText(14, str17);
                    }
                    String str18 = recognitionHistory.youtubeVideoId;
                    if (str18 == null) {
                        sQLiteStatement.bindNull(15);
                    } else {
                        sQLiteStatement.bindText(15, str18);
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(recognitionHistory.recognizedAt);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatement.bindNull(16);
                    } else {
                        sQLiteStatement.bindLong(16, lDateToTimestamp4.longValue());
                    }
                    sQLiteStatement.bindLong(17, recognitionHistory.liked ? 1L : 0L);
                    break;
                case 8:
                    SongAlbumMap songAlbumMap = (SongAlbumMap) obj;
                    sQLiteStatement.getClass();
                    songAlbumMap.getClass();
                    sQLiteStatement.bindText(1, songAlbumMap.songId);
                    sQLiteStatement.bindText(2, songAlbumMap.albumId);
                    sQLiteStatement.bindLong(3, songAlbumMap.index);
                    break;
                case 9:
                    LyricsEntity lyricsEntity = (LyricsEntity) obj;
                    sQLiteStatement.getClass();
                    lyricsEntity.getClass();
                    sQLiteStatement.bindText(1, lyricsEntity.id);
                    sQLiteStatement.bindText(2, lyricsEntity.lyrics);
                    sQLiteStatement.bindText(3, lyricsEntity.provider);
                    sQLiteStatement.bindText(4, lyricsEntity.translatedLyrics);
                    sQLiteStatement.bindText(5, lyricsEntity.translationLanguage);
                    sQLiteStatement.bindText(6, lyricsEntity.translationMode);
                    break;
                case 10:
                    FormatEntity formatEntity = (FormatEntity) obj;
                    sQLiteStatement.getClass();
                    formatEntity.getClass();
                    sQLiteStatement.bindText(1, formatEntity.id);
                    sQLiteStatement.bindLong(2, formatEntity.itag);
                    sQLiteStatement.bindText(3, formatEntity.mimeType);
                    sQLiteStatement.bindText(4, formatEntity.codecs);
                    sQLiteStatement.bindLong(5, formatEntity.bitrate);
                    Integer num = formatEntity.sampleRate;
                    if (num == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, num.intValue());
                    }
                    sQLiteStatement.bindLong(7, formatEntity.contentLength);
                    Double d = formatEntity.loudnessDb;
                    if (d == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindDouble(8, d.doubleValue());
                    }
                    Double d2 = formatEntity.perceptualLoudnessDb;
                    if (d2 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindDouble(9, d2.doubleValue());
                    }
                    String str19 = formatEntity.playbackUrl;
                    if (str19 != null) {
                        sQLiteStatement.bindText(10, str19);
                    } else {
                        sQLiteStatement.bindNull(10);
                    }
                    break;
                case 11:
                    SongEntity songEntity = (SongEntity) obj;
                    sQLiteStatement.getClass();
                    songEntity.getClass();
                    sQLiteStatement.bindText(1, songEntity.id);
                    sQLiteStatement.bindText(2, songEntity.title);
                    sQLiteStatement.bindLong(3, songEntity.duration);
                    String str20 = songEntity.thumbnailUrl;
                    if (str20 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str20);
                    }
                    String str21 = songEntity.albumId;
                    if (str21 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str21);
                    }
                    String str22 = songEntity.albumName;
                    if (str22 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str22);
                    }
                    sQLiteStatement.bindLong(7, songEntity.explicit ? 1L : 0L);
                    Integer num2 = songEntity.year;
                    if (num2 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num2.intValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(songEntity.date);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindLong(9, lDateToTimestamp5.longValue());
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(songEntity.dateModified);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp6.longValue());
                    }
                    sQLiteStatement.bindLong(11, songEntity.liked ? 1L : 0L);
                    Long lDateToTimestamp7 = Converters.dateToTimestamp(songEntity.likedDate);
                    if (lDateToTimestamp7 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp7.longValue());
                    }
                    sQLiteStatement.bindLong(13, songEntity.totalPlayTime);
                    Long lDateToTimestamp8 = Converters.dateToTimestamp(songEntity.inLibrary);
                    if (lDateToTimestamp8 == null) {
                        sQLiteStatement.bindNull(14);
                    } else {
                        sQLiteStatement.bindLong(14, lDateToTimestamp8.longValue());
                    }
                    Long lDateToTimestamp9 = Converters.dateToTimestamp(songEntity.dateDownload);
                    if (lDateToTimestamp9 == null) {
                        sQLiteStatement.bindNull(15);
                    } else {
                        sQLiteStatement.bindLong(15, lDateToTimestamp9.longValue());
                    }
                    sQLiteStatement.bindLong(16, songEntity.isLocal ? 1L : 0L);
                    String str23 = songEntity.libraryAddToken;
                    if (str23 == null) {
                        sQLiteStatement.bindNull(17);
                    } else {
                        sQLiteStatement.bindText(17, str23);
                    }
                    String str24 = songEntity.libraryRemoveToken;
                    if (str24 == null) {
                        sQLiteStatement.bindNull(18);
                    } else {
                        sQLiteStatement.bindText(18, str24);
                    }
                    sQLiteStatement.bindLong(19, songEntity.lyricsOffset);
                    sQLiteStatement.bindLong(20, songEntity.romanizeLyrics ? 1L : 0L);
                    sQLiteStatement.bindLong(21, songEntity.isDownloaded ? 1L : 0L);
                    sQLiteStatement.bindLong(22, songEntity.isUploaded ? 1L : 0L);
                    sQLiteStatement.bindLong(23, songEntity.isVideo ? 1L : 0L);
                    sQLiteStatement.bindLong(24, songEntity.isEpisode ? 1L : 0L);
                    Long l = songEntity.playbackPosition;
                    if (l == null) {
                        sQLiteStatement.bindNull(25);
                    } else {
                        sQLiteStatement.bindLong(25, l.longValue());
                    }
                    String str25 = songEntity.uploadEntityId;
                    if (str25 == null) {
                        sQLiteStatement.bindNull(26);
                    } else {
                        sQLiteStatement.bindText(26, str25);
                    }
                    sQLiteStatement.bindLong(27, songEntity.isCached ? 1L : 0L);
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    SongEntity songEntity2 = (SongEntity) obj;
                    sQLiteStatement.getClass();
                    songEntity2.getClass();
                    sQLiteStatement.bindText(1, songEntity2.id);
                    sQLiteStatement.bindText(2, songEntity2.title);
                    sQLiteStatement.bindLong(3, songEntity2.duration);
                    String str26 = songEntity2.thumbnailUrl;
                    if (str26 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str26);
                    }
                    String str27 = songEntity2.albumId;
                    if (str27 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str27);
                    }
                    String str28 = songEntity2.albumName;
                    if (str28 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str28);
                    }
                    sQLiteStatement.bindLong(7, songEntity2.explicit ? 1L : 0L);
                    Integer num3 = songEntity2.year;
                    if (num3 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num3.intValue());
                    }
                    Long lDateToTimestamp10 = Converters.dateToTimestamp(songEntity2.date);
                    if (lDateToTimestamp10 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindLong(9, lDateToTimestamp10.longValue());
                    }
                    Long lDateToTimestamp11 = Converters.dateToTimestamp(songEntity2.dateModified);
                    if (lDateToTimestamp11 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp11.longValue());
                    }
                    sQLiteStatement.bindLong(11, songEntity2.liked ? 1L : 0L);
                    Long lDateToTimestamp12 = Converters.dateToTimestamp(songEntity2.likedDate);
                    if (lDateToTimestamp12 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp12.longValue());
                    }
                    sQLiteStatement.bindLong(13, songEntity2.totalPlayTime);
                    Long lDateToTimestamp13 = Converters.dateToTimestamp(songEntity2.inLibrary);
                    if (lDateToTimestamp13 == null) {
                        sQLiteStatement.bindNull(14);
                    } else {
                        sQLiteStatement.bindLong(14, lDateToTimestamp13.longValue());
                    }
                    Long lDateToTimestamp14 = Converters.dateToTimestamp(songEntity2.dateDownload);
                    if (lDateToTimestamp14 == null) {
                        sQLiteStatement.bindNull(15);
                    } else {
                        sQLiteStatement.bindLong(15, lDateToTimestamp14.longValue());
                    }
                    sQLiteStatement.bindLong(16, songEntity2.isLocal ? 1L : 0L);
                    String str29 = songEntity2.libraryAddToken;
                    if (str29 == null) {
                        sQLiteStatement.bindNull(17);
                    } else {
                        sQLiteStatement.bindText(17, str29);
                    }
                    String str30 = songEntity2.libraryRemoveToken;
                    if (str30 == null) {
                        sQLiteStatement.bindNull(18);
                    } else {
                        sQLiteStatement.bindText(18, str30);
                    }
                    sQLiteStatement.bindLong(19, songEntity2.lyricsOffset);
                    sQLiteStatement.bindLong(20, songEntity2.romanizeLyrics ? 1L : 0L);
                    sQLiteStatement.bindLong(21, songEntity2.isDownloaded ? 1L : 0L);
                    sQLiteStatement.bindLong(22, songEntity2.isUploaded ? 1L : 0L);
                    sQLiteStatement.bindLong(23, songEntity2.isVideo ? 1L : 0L);
                    sQLiteStatement.bindLong(24, songEntity2.isEpisode ? 1L : 0L);
                    Long l2 = songEntity2.playbackPosition;
                    if (l2 == null) {
                        sQLiteStatement.bindNull(25);
                    } else {
                        sQLiteStatement.bindLong(25, l2.longValue());
                    }
                    String str31 = songEntity2.uploadEntityId;
                    if (str31 == null) {
                        sQLiteStatement.bindNull(26);
                    } else {
                        sQLiteStatement.bindText(26, str31);
                    }
                    sQLiteStatement.bindLong(27, songEntity2.isCached ? 1L : 0L);
                    break;
                case 13:
                    ArtistEntity artistEntity = (ArtistEntity) obj;
                    sQLiteStatement.getClass();
                    artistEntity.getClass();
                    sQLiteStatement.bindText(1, artistEntity.id);
                    sQLiteStatement.bindText(2, artistEntity.name);
                    String str32 = artistEntity.thumbnailUrl;
                    if (str32 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str32);
                    }
                    String str33 = artistEntity.channelId;
                    if (str33 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str33);
                    }
                    Long lDateToTimestamp15 = Converters.dateToTimestamp(artistEntity.lastUpdateTime);
                    if (lDateToTimestamp15 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindLong(5, lDateToTimestamp15.longValue());
                    }
                    Long lDateToTimestamp16 = Converters.dateToTimestamp(artistEntity.bookmarkedAt);
                    if (lDateToTimestamp16 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, lDateToTimestamp16.longValue());
                    }
                    sQLiteStatement.bindLong(7, artistEntity.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(8, artistEntity.isPodcastChannel ? 1L : 0L);
                    String str34 = artistEntity.cachedPageJson;
                    if (str34 != null) {
                        sQLiteStatement.bindText(9, str34);
                    } else {
                        sQLiteStatement.bindNull(9);
                    }
                    break;
                case 14:
                    AlbumEntity albumEntity = (AlbumEntity) obj;
                    sQLiteStatement.getClass();
                    albumEntity.getClass();
                    sQLiteStatement.bindText(1, albumEntity.id);
                    String str35 = albumEntity.playlistId;
                    if (str35 == null) {
                        sQLiteStatement.bindNull(2);
                    } else {
                        sQLiteStatement.bindText(2, str35);
                    }
                    sQLiteStatement.bindText(3, albumEntity.title);
                    Integer num4 = albumEntity.year;
                    if (num4 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindLong(4, num4.intValue());
                    }
                    String str36 = albumEntity.thumbnailUrl;
                    if (str36 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str36);
                    }
                    Integer num5 = albumEntity.themeColor;
                    if (num5 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, num5.intValue());
                    }
                    sQLiteStatement.bindLong(7, albumEntity.songCount);
                    sQLiteStatement.bindLong(8, albumEntity.duration);
                    sQLiteStatement.bindLong(9, albumEntity.explicit ? 1L : 0L);
                    Long lDateToTimestamp17 = Converters.dateToTimestamp(albumEntity.lastUpdateTime);
                    if (lDateToTimestamp17 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp17.longValue());
                    }
                    Long lDateToTimestamp18 = Converters.dateToTimestamp(albumEntity.bookmarkedAt);
                    if (lDateToTimestamp18 == null) {
                        sQLiteStatement.bindNull(11);
                    } else {
                        sQLiteStatement.bindLong(11, lDateToTimestamp18.longValue());
                    }
                    Long lDateToTimestamp19 = Converters.dateToTimestamp(albumEntity.likedDate);
                    if (lDateToTimestamp19 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp19.longValue());
                    }
                    Long lDateToTimestamp20 = Converters.dateToTimestamp(albumEntity.inLibrary);
                    if (lDateToTimestamp20 == null) {
                        sQLiteStatement.bindNull(13);
                    } else {
                        sQLiteStatement.bindLong(13, lDateToTimestamp20.longValue());
                    }
                    sQLiteStatement.bindLong(14, albumEntity.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(15, albumEntity.isUploaded ? 1L : 0L);
                    break;
                case 15:
                    PlaylistEntity playlistEntity = (PlaylistEntity) obj;
                    sQLiteStatement.getClass();
                    playlistEntity.getClass();
                    sQLiteStatement.bindText(1, playlistEntity.id);
                    sQLiteStatement.bindText(2, playlistEntity.name);
                    String str37 = playlistEntity.browseId;
                    if (str37 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str37);
                    }
                    Long lDateToTimestamp21 = Converters.dateToTimestamp(playlistEntity.createdAt);
                    if (lDateToTimestamp21 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindLong(4, lDateToTimestamp21.longValue());
                    }
                    Long lDateToTimestamp22 = Converters.dateToTimestamp(playlistEntity.lastUpdateTime);
                    if (lDateToTimestamp22 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindLong(5, lDateToTimestamp22.longValue());
                    }
                    sQLiteStatement.bindLong(6, playlistEntity.isEditable ? 1L : 0L);
                    Long lDateToTimestamp23 = Converters.dateToTimestamp(playlistEntity.bookmarkedAt);
                    if (lDateToTimestamp23 == null) {
                        sQLiteStatement.bindNull(7);
                    } else {
                        sQLiteStatement.bindLong(7, lDateToTimestamp23.longValue());
                    }
                    Integer num6 = playlistEntity.remoteSongCount;
                    if (num6 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num6.intValue());
                    }
                    String str38 = playlistEntity.playEndpointParams;
                    if (str38 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindText(9, str38);
                    }
                    String str39 = playlistEntity.thumbnailUrl;
                    if (str39 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindText(10, str39);
                    }
                    String str40 = playlistEntity.shuffleEndpointParams;
                    if (str40 == null) {
                        sQLiteStatement.bindNull(11);
                    } else {
                        sQLiteStatement.bindText(11, str40);
                    }
                    String str41 = playlistEntity.radioEndpointParams;
                    if (str41 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindText(12, str41);
                    }
                    sQLiteStatement.bindLong(13, playlistEntity.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(14, playlistEntity.isAutoSync ? 1L : 0L);
                    break;
                case 16:
                    SongArtistMap songArtistMap = (SongArtistMap) obj;
                    sQLiteStatement.getClass();
                    songArtistMap.getClass();
                    sQLiteStatement.bindText(1, songArtistMap.songId);
                    sQLiteStatement.bindText(2, songArtistMap.artistId);
                    sQLiteStatement.bindLong(3, songArtistMap.position);
                    break;
                case 17:
                    AlbumArtistMap albumArtistMap = (AlbumArtistMap) obj;
                    sQLiteStatement.getClass();
                    albumArtistMap.getClass();
                    sQLiteStatement.bindText(1, albumArtistMap.albumId);
                    sQLiteStatement.bindText(2, albumArtistMap.artistId);
                    sQLiteStatement.bindLong(3, albumArtistMap.order);
                    break;
                default:
                    SpeedDialItem speedDialItem = (SpeedDialItem) obj;
                    sQLiteStatement.getClass();
                    speedDialItem.getClass();
                    sQLiteStatement.bindText(1, speedDialItem.id);
                    String str42 = speedDialItem.secondaryId;
                    if (str42 == null) {
                        sQLiteStatement.bindNull(2);
                    } else {
                        sQLiteStatement.bindText(2, str42);
                    }
                    sQLiteStatement.bindText(3, speedDialItem.title);
                    String str43 = speedDialItem.subtitle;
                    if (str43 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str43);
                    }
                    String str44 = speedDialItem.subtitleIds;
                    if (str44 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str44);
                    }
                    String str45 = speedDialItem.thumbnailUrl;
                    if (str45 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str45);
                    }
                    sQLiteStatement.bindText(7, speedDialItem.type);
                    sQLiteStatement.bindLong(8, speedDialItem.explicit ? 1L : 0L);
                    sQLiteStatement.bindLong(9, speedDialItem.createDate);
                    String str46 = speedDialItem.albumId;
                    if (str46 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindText(10, str46);
                    }
                    String str47 = speedDialItem.albumName;
                    if (str47 != null) {
                        sQLiteStatement.bindText(11, str47);
                    } else {
                        sQLiteStatement.bindNull(11);
                    }
                    break;
            }
        }

        @Override // coil3.size.SizeKt
        public final String createQuery() {
            switch (this.$r8$classId) {
                case 0:
                    return "INSERT OR IGNORE INTO `playCount` (`song`,`year`,`month`,`count`) VALUES (?,?,?,?)";
                case 1:
                    return "INSERT OR IGNORE INTO `playlist_song_map` (`id`,`playlistId`,`songId`,`position`,`setVideoId`) VALUES (nullif(?, 0),?,?,?,?)";
                case 2:
                    return "INSERT OR REPLACE INTO `search_history` (`id`,`query`) VALUES (nullif(?, 0),?)";
                case 3:
                    return "INSERT OR IGNORE INTO `event` (`id`,`songId`,`timestamp`,`playTime`) VALUES (nullif(?, 0),?,?,?)";
                case 4:
                    return "INSERT OR IGNORE INTO `related_song_map` (`id`,`songId`,`relatedSongId`) VALUES (nullif(?, 0),?,?)";
                case 5:
                    return "INSERT OR REPLACE INTO `set_video_id` (`videoId`,`setVideoId`) VALUES (?,?)";
                case 6:
                    return "INSERT OR IGNORE INTO `podcast` (`id`,`title`,`author`,`thumbnailUrl`,`channelId`,`bookmarkedAt`,`lastUpdateTime`,`libraryAddToken`,`libraryRemoveToken`) VALUES (?,?,?,?,?,?,?,?,?)";
                case 7:
                    return "INSERT OR REPLACE INTO `recognition_history` (`id`,`trackId`,`title`,`artist`,`album`,`coverArtUrl`,`coverArtHqUrl`,`genre`,`releaseDate`,`label`,`shazamUrl`,`appleMusicUrl`,`spotifyUrl`,`isrc`,`youtubeVideoId`,`recognizedAt`,`liked`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                case 8:
                    return "INSERT INTO `song_album_map` (`songId`,`albumId`,`index`) VALUES (?,?,?)";
                case 9:
                    return "INSERT INTO `lyrics` (`id`,`lyrics`,`provider`,`translatedLyrics`,`translationLanguage`,`translationMode`) VALUES (?,?,?,?,?,?)";
                case 10:
                    return "INSERT INTO `format` (`id`,`itag`,`mimeType`,`codecs`,`bitrate`,`sampleRate`,`contentLength`,`loudnessDb`,`perceptualLoudnessDb`,`playbackUrl`) VALUES (?,?,?,?,?,?,?,?,?,?)";
                case 11:
                    return "INSERT OR IGNORE INTO `song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`lyricsOffset`,`romanizeLyrics`,`isDownloaded`,`isUploaded`,`isVideo`,`isEpisode`,`playbackPosition`,`uploadEntityId`,`isCached`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return "INSERT INTO `song` (`id`,`title`,`duration`,`thumbnailUrl`,`albumId`,`albumName`,`explicit`,`year`,`date`,`dateModified`,`liked`,`likedDate`,`totalPlayTime`,`inLibrary`,`dateDownload`,`isLocal`,`libraryAddToken`,`libraryRemoveToken`,`lyricsOffset`,`romanizeLyrics`,`isDownloaded`,`isUploaded`,`isVideo`,`isEpisode`,`playbackPosition`,`uploadEntityId`,`isCached`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                case 13:
                    return "INSERT OR IGNORE INTO `artist` (`id`,`name`,`thumbnailUrl`,`channelId`,`lastUpdateTime`,`bookmarkedAt`,`isLocal`,`isPodcastChannel`,`cachedPageJson`) VALUES (?,?,?,?,?,?,?,?,?)";
                case 14:
                    return "INSERT OR IGNORE INTO `album` (`id`,`playlistId`,`title`,`year`,`thumbnailUrl`,`themeColor`,`songCount`,`duration`,`explicit`,`lastUpdateTime`,`bookmarkedAt`,`likedDate`,`inLibrary`,`isLocal`,`isUploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                case 15:
                    return "INSERT OR IGNORE INTO `playlist` (`id`,`name`,`browseId`,`createdAt`,`lastUpdateTime`,`isEditable`,`bookmarkedAt`,`remoteSongCount`,`playEndpointParams`,`thumbnailUrl`,`shuffleEndpointParams`,`radioEndpointParams`,`isLocal`,`isAutoSync`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                case 16:
                    return "INSERT OR IGNORE INTO `song_artist_map` (`songId`,`artistId`,`position`) VALUES (?,?,?)";
                case 17:
                    return "INSERT OR IGNORE INTO `album_artist_map` (`albumId`,`artistId`,`order`) VALUES (?,?,?)";
                default:
                    return "INSERT OR REPLACE INTO `speed_dial_item` (`id`,`secondaryId`,`title`,`subtitle`,`subtitleIds`,`thumbnailUrl`,`type`,`explicit`,`createDate`,`albumId`,`albumName`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }
        }

        public /* synthetic */ AnonymousClass1(DatabaseDao_Impl databaseDao_Impl, byte b) {
            this.$r8$classId = b;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.db.DatabaseDao_Impl$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass17 {
        public static Method asyncTraceBeginMethod;
        public static Method asyncTraceEndMethod;
        public static Method isTagEnabledMethod;
        public static long traceTagApp;
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass17(byte b) {
            this.$r8$classId = b;
        }

        public static final long GridItemSpan(int i) {
            if (!(i > 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("The span value should be higher than 0");
            }
            return i;
        }

        /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
        public static final IntRect m1058IntRectVbeCjmY(long j, long j2) {
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            return new IntRect(i, i2, ((int) (j2 >> 32)) + i, ((int) (j2 & 4294967295L)) + i2);
        }

        public static final void LocalOwnersProvider(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startRestartGroup(233973821);
            byte b = 2;
            if ((((gapComposer.changedInstance(navBackStackEntry) ? 4 : 2) | i | (gapComposer.changedInstance(saveableStateHolder) ? 32 : 16)) & 147) == 146 && gapComposer.getSkipping()) {
                gapComposer.skipToGroupEnd();
            } else {
                Stack.CompositionLocalProvider(new ProvidedValue[]{LocalViewModelStoreOwner.LocalViewModelStoreOwner.defaultProvidedValue$runtime(navBackStackEntry), LocalLifecycleOwnerKt.LocalLifecycleOwner.defaultProvidedValue$runtime(navBackStackEntry), LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner.defaultProvidedValue$runtime(navBackStackEntry)}, Expect_jvmKt.rememberComposableLambda(1808964477, new NavHostKt$NavHost$32.AnonymousClass1(saveableStateHolder, composableLambdaImpl, b), gapComposer), gapComposer, 56);
            }
            RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 13, i, navBackStackEntry, saveableStateHolder, composableLambdaImpl);
            }
        }

        public static PickVisualMediaRequest PickVisualMediaRequest$default() {
            BundleCompat$Api33Impl.getMaxItems$activity();
            BundleCompat$Api33Impl.getMaxItems$activity();
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.mediaType = ActivityResultContracts$PickVisualMedia$ImageAndVideo.INSTANCE;
            BundleCompat$Api33Impl.getMaxItems$activity();
            pickVisualMediaRequest.mediaType = ActivityResultContracts$PickVisualMedia$ImageOnly.INSTANCE;
            return pickVisualMediaRequest;
        }

        public static final void ProvideBasicTextContextMenu(Modifier modifier, ProvidableCompositionLocal providableCompositionLocal, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
            int i2;
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startRestartGroup(-714464401);
            if ((i & 6) == 0) {
                i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= gapComposer.changed(providableCompositionLocal) ? 32 : 16;
            }
            int i3 = i & 384;
            ComposableLambdaImpl composableLambdaImpl2 = AndroidTextContextMenuToolbarProvider_androidKt.lambda$636288403;
            if (i3 == 0) {
                i2 |= gapComposer.changedInstance(composableLambdaImpl2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
            }
            if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                    gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                    objRememberedValue = parcelableSnapshotMutableState;
                }
                BasicTextContextMenuProvider basicTextContextMenuProvider = basicTextContextMenuProvider(composableLambdaImpl2, gapComposer, (i2 >> 6) & 14);
                Stack.CompositionLocalProvider(providableCompositionLocal.defaultProvidedValue$runtime(basicTextContextMenuProvider), Expect_jvmKt.rememberComposableLambda(274270255, new CrossfadeKt$$ExternalSyntheticLambda3(modifier, (MutableState) objRememberedValue, composableLambdaImpl, basicTextContextMenuProvider), gapComposer), gapComposer, 56);
            } else {
                gapComposer.skipToGroupEnd();
            }
            RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0(modifier, providableCompositionLocal, composableLambdaImpl, i);
            }
        }

        public static final void SaveableStateProvider(SaveableStateHolder saveableStateHolder, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startRestartGroup(832919318);
            int i2 = (gapComposer.changedInstance(saveableStateHolder) ? 4 : 2) | i | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16);
            if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
                gapComposer.skipToGroupEnd();
            } else {
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new RoomDatabase$$ExternalSyntheticLambda2((byte) 11);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BackStackEntryIdViewModel.class);
                NetworkHeaders.Builder builder = new NetworkHeaders.Builder((byte) 2);
                builder.addInitializer(Reflection.getOrCreateKotlinClass(BackStackEntryIdViewModel.class), function1);
                BackStackEntryIdViewModel backStackEntryIdViewModel = (BackStackEntryIdViewModel) UtilsKt.viewModel(orCreateKotlinClass, viewModelStoreOwner, builder.build(), viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, gapComposer);
                backStackEntryIdViewModel.saveableStateHolderRef = new WeakReference(saveableStateHolder);
                saveableStateHolder.SaveableStateProvider(backStackEntryIdViewModel.id, composableLambdaImpl, gapComposer, ((i2 << 6) & 896) | (i2 & 112));
            }
            RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(saveableStateHolder, composableLambdaImpl, i, (byte) 5);
            }
        }

        public static void addOrReplaceSpan(SpannableStringBuilder spannableStringBuilder, Object obj, int i, int i2) {
            for (Object obj2 : spannableStringBuilder.getSpans(i, i2, obj.getClass())) {
                if (spannableStringBuilder.getSpanStart(obj2) == i && spannableStringBuilder.getSpanEnd(obj2) == i2 && spannableStringBuilder.getSpanFlags(obj2) == 33) {
                    spannableStringBuilder.removeSpan(obj2);
                }
            }
            spannableStringBuilder.setSpan(obj, i, i2, 33);
        }

        public static final BasicTextContextMenuProvider basicTextContextMenuProvider(ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
            boolean z = (((i & 14) ^ 6) > 4 && ((GapComposer) composer).changed(composableLambdaImpl)) || (i & 6) == 4;
            GapComposer gapComposer = (GapComposer) composer;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new BasicTextContextMenuProvider(composableLambdaImpl);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) objRememberedValue;
            boolean zChanged = gapComposer.changed(basicTextContextMenuProvider);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ScrollState$$ExternalSyntheticLambda0((byte) 27, basicTextContextMenuProvider);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.DisposableEffect(basicTextContextMenuProvider, (Function1) objRememberedValue2, gapComposer);
            return basicTextContextMenuProvider;
        }

        public static final void beginAsyncSection(String str) throws Throwable {
            if (Build.VERSION.SDK_INT >= 29) {
                TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str));
                return;
            }
            String strTruncatedTraceSectionLabel = truncatedTraceSectionLabel(str);
            try {
                Method method = asyncTraceBeginMethod;
                if (method == null) {
                    method = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                    asyncTraceBeginMethod = method;
                }
                if (method == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                method.invoke(null, Long.valueOf(traceTagApp), strTruncatedTraceSectionLabel, 0);
            } catch (Exception e) {
                handleException(e);
            }
        }

        public static final boolean calculateIfHorizontallyStacked(ArrayList arrayList) {
            List list;
            long j;
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 1) {
                    list = EmptyList.INSTANCE;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    Object obj = arrayList.get(0);
                    int size = arrayList.size() - 1;
                    int i = 0;
                    while (i < size) {
                        i++;
                        Object obj2 = arrayList.get(i);
                        SemanticsNode semanticsNode = (SemanticsNode) obj2;
                        SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                        arrayList2.add(new Offset((((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.getBoundsInRoot().m443getCenterF1C5BW0() >> 32)) - Float.intBitsToFloat((int) (semanticsNode.getBoundsInRoot().m443getCenterF1C5BW0() >> 32))))) << 32) | (((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.getBoundsInRoot().m443getCenterF1C5BW0() & 4294967295L)) - Float.intBitsToFloat((int) (semanticsNode.getBoundsInRoot().m443getCenterF1C5BW0() & 4294967295L))))) & 4294967295L)));
                        obj = obj2;
                    }
                    list = arrayList2;
                }
                if (list.size() == 1) {
                    j = ((Offset) CollectionsKt.first(list)).packedValue;
                } else {
                    if (list.isEmpty()) {
                        ListUtilsKt.throwUnsupportedOperationException("Empty collection can't be reduced.");
                    }
                    Object objFirst = CollectionsKt.first(list);
                    int size2 = list.size() - 1;
                    if (1 <= size2) {
                        int i2 = 1;
                        while (true) {
                            objFirst = new Offset(Offset.m439plusMKHz9U(((Offset) objFirst).packedValue, ((Offset) list.get(i2)).packedValue));
                            if (i2 == size2) {
                                break;
                            }
                            i2++;
                        }
                    }
                    j = ((Offset) objFirst).packedValue;
                }
                if (Float.intBitsToFloat((int) (4294967295L & j)) >= Float.intBitsToFloat((int) (j >> 32))) {
                    return false;
                }
            }
            return true;
        }

        public static void checkNotNull(Object obj, String str) {
            if (obj != null) {
                return;
            }
            PathKt$$ExternalSyntheticBUOutline0.m(str);
        }

        public static int checkSelfPermission(Context context, String str) {
            int iNoteProxyOpNoThrow;
            int iMyPid = Process.myPid();
            int iMyUid = Process.myUid();
            String packageName = context.getPackageName();
            if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
                String strPermissionToOp = AppOpsManager.permissionToOp(str);
                if (strPermissionToOp != null) {
                    if (packageName == null) {
                        String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                        if (packagesForUid != null && packagesForUid.length > 0) {
                            packageName = packagesForUid[0];
                        }
                    }
                    int iMyUid2 = Process.myUid();
                    String packageName2 = context.getPackageName();
                    if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                        iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                        if (iNoteProxyOpNoThrow == 0) {
                            iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, AppOpsManagerCompat$Api29Impl.getOpPackageName(context)) : 1;
                        }
                    } else {
                        iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                    }
                    if (iNoteProxyOpNoThrow != 0) {
                        return -2;
                    }
                }
                return 0;
            }
            return -1;
        }

        public static void checkState(String str, boolean z) {
            if (z) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(str);
        }

        public static final MutableState collectIsFocusedAsState(InteractionSource interactionSource, Composer composer, int i) {
            GapComposer gapComposer = (GapComposer) composer;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            byte b = 0;
            boolean z = (((i & 14) ^ 6) > 4 && gapComposer.changed(interactionSource)) || (i & 6) == 4;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FocusInteractionKt$collectIsFocusedAsState$1$1(interactionSource, mutableState, null, b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer, interactionSource, (Function2) objRememberedValue2);
            return mutableState;
        }

        public static Parcelable convert(Parcelable parcelable, Parcelable.Creator creator) {
            if (parcelable == null) {
                return null;
            }
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelable.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                return (Parcelable) creator.createFromParcel(parcelObtain);
            } finally {
                parcelObtain.recycle();
            }
        }

        public static ArrayList convertList(List list, Parcelable.Creator creator) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(convert((Parcelable) list.get(i), creator));
            }
            return arrayList;
        }

        public static FontRequestEmojiCompatConfig create(Context context) {
            ProviderInfo providerInfo;
            FontRequest fontRequest;
            ApplicationInfo applicationInfo;
            byte b = 13;
            Lock defaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 = Build.VERSION.SDK_INT >= 28 ? new DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28(b) : new Lock(b);
            PackageManager packageManager = context.getPackageManager();
            checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    providerInfo = null;
                    break;
                }
                providerInfo = it.next().providerInfo;
                if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                    break;
                }
            }
            if (providerInfo == null) {
                fontRequest = null;
            } else {
                try {
                    String str = providerInfo.authority;
                    String str2 = providerInfo.packageName;
                    Signature[] signingSignatures = defaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28.getSigningSignatures(packageManager, str2);
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : signingSignatures) {
                        arrayList.add(signature.toByteArray());
                    }
                    fontRequest = new FontRequest(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                    fontRequest = null;
                }
            }
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(new FontRequestEmojiCompatConfig.FontRequestMetadataLoader(context, fontRequest));
        }

        public static final KeylineList createShiftedKeylineListForContentPadding(KeylineList keylineList, float f, float f2, float f3, Keyline keyline, int i) {
            ArrayList arrayList = new ArrayList(keylineList.$$delegate_0.size());
            List list = keylineList.$$delegate_0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Keyline keyline2 = keylineList.get(i2);
                if (!keyline2.isAnchor) {
                    arrayList.add(keyline2);
                }
            }
            float size2 = f3 / arrayList.size();
            float f4 = (keyline.offset - (size2 / 2.0f)) + f3;
            ArrayList arrayList2 = new ArrayList();
            int size3 = list.size();
            int i3 = -1;
            int size4 = -1;
            float f5 = 0.0f;
            for (int i4 = 0; i4 < size3; i4++) {
                Keyline keyline3 = keylineList.get(i4);
                float fAbs = keyline3.size - Math.abs(size2);
                boolean z = keyline3.isAnchor;
                arrayList2.add(new KeylineListScopeImpl$TmpKeyline(fAbs, z));
                if (!z && fAbs > f5) {
                    size4 = arrayList2.size() - 1;
                    f5 = fAbs;
                }
            }
            if (size4 >= 0) {
                i3 = size4;
                while (i3 < arrayList2.size() - 1) {
                    int i5 = i3 + 1;
                    if (((KeylineListScopeImpl$TmpKeyline) arrayList2.get(i5)).size != f5) {
                        break;
                    }
                    i3 = i5;
                }
            }
            List listCreateKeylinesWithPivot = RelativeScroller.createKeylinesWithPivot(i, f4, size4, i3, f5, f, f2, arrayList2);
            KeylineList keylineList2 = new KeylineList(listCreateKeylinesWithPivot);
            ArrayList arrayList3 = new ArrayList(listCreateKeylinesWithPivot.size());
            int size5 = listCreateKeylinesWithPivot.size();
            for (int i6 = 0; i6 < size5; i6++) {
                Keyline keyline4 = keylineList2.get(i6);
                arrayList3.add(new Keyline(keyline4.size, keyline4.offset, keylineList.get(i6).unadjustedOffset, keyline4.isFocal, keyline4.isAnchor, keyline4.isPivot, keyline4.cutoff));
            }
            return new KeylineList(arrayList3);
        }

        /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
        public static final long m1059divso9K2fw(long j, float f) {
            return FloatFloatPair.m0constructorimpl(m1063getXDnnuFBc(j) / f, m1064getYDnnuFBc(j) / f);
        }

        /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
        public static final float m1060dotProductybeJwSQ(long j, long j2) {
            return (m1064getYDnnuFBc(j2) * m1064getYDnnuFBc(j)) + (m1063getXDnnuFBc(j2) * m1063getXDnnuFBc(j));
        }

        public static final void endAsyncSection(int i, String str) throws Throwable {
            str.getClass();
            if (Build.VERSION.SDK_INT >= 29) {
                TraceApi29Impl.endAsyncSection(i, truncatedTraceSectionLabel(str));
                return;
            }
            String strTruncatedTraceSectionLabel = truncatedTraceSectionLabel(str);
            try {
                Method method = asyncTraceEndMethod;
                if (method == null) {
                    method = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                    asyncTraceEndMethod = method;
                }
                if (method == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                method.invoke(null, Long.valueOf(traceTagApp), strTruncatedTraceSectionLabel, Integer.valueOf(i));
            } catch (Exception e) {
                handleException(e);
            }
        }

        /* JADX INFO: renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
        public static final int m1061getAndroidTypefaceStyleFO1MlWM(FontWeight fontWeight, int i) {
            boolean z = fontWeight.compareTo(FontWeight.W600) >= 0;
            boolean z2 = i == 1;
            if (z2 && z) {
                return 3;
            }
            if (z) {
                return 1;
            }
            return z2 ? 2 : 0;
        }

        public static final CoroutineContext getCoroutineContext(RoomDatabase roomDatabase, boolean z, ContinuationImpl continuationImpl) {
            TransactionElement transactionElement = (TransactionElement) continuationImpl.getContext().get(TransactionElement.Key);
            CoroutineContext coroutineContext = transactionElement != null ? transactionElement.transactionDispatcher : null;
            if (!roomDatabase.inCompatibilityMode()) {
                ContextScope contextScope = roomDatabase.coroutineScope;
                if (contextScope == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                    throw null;
                }
                CoroutineContext coroutineContext2 = contextScope.coroutineContext;
                if (coroutineContext == null) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                return coroutineContext2.plus(coroutineContext);
            }
            if (coroutineContext != null) {
                ContextScope contextScope2 = roomDatabase.coroutineScope;
                if (contextScope2 != null) {
                    return contextScope2.coroutineContext.plus(coroutineContext);
                }
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                throw null;
            }
            if (z) {
                CoroutineContext coroutineContext3 = roomDatabase.transactionContext;
                if (coroutineContext3 != null) {
                    return coroutineContext3;
                }
                Intrinsics.throwUninitializedPropertyAccessException("transactionContext");
                throw null;
            }
            ContextScope contextScope3 = roomDatabase.coroutineScope;
            if (contextScope3 != null) {
                return contextScope3.coroutineContext;
            }
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            throw null;
        }

        /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
        public static final float m1062getDistanceDnnuFBc(long j) {
            return (float) Math.sqrt((m1064getYDnnuFBc(j) * m1064getYDnnuFBc(j)) + (m1063getXDnnuFBc(j) * m1063getXDnnuFBc(j)));
        }

        public static final ViewParent getParentOrViewTreeDisjointParent(View view) {
            view.getClass();
            ViewParent parent = view.getParent();
            if (parent != null) {
                return parent;
            }
            Object tag = view.getTag(R.id.view_tree_disjoint_parent);
            if (tag instanceof ViewParent) {
                return (ViewParent) tag;
            }
            return null;
        }

        public static final ViewTargetRequestManager getRequestManager(View view) {
            ViewTargetRequestManager viewTargetRequestManager;
            Object tag = view.getTag(R.id.coil3_request_manager);
            ViewTargetRequestManager viewTargetRequestManager2 = tag instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag : null;
            if (viewTargetRequestManager2 != null) {
                return viewTargetRequestManager2;
            }
            synchronized (view) {
                try {
                    Object tag2 = view.getTag(R.id.coil3_request_manager);
                    viewTargetRequestManager = tag2 instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag2 : null;
                    if (viewTargetRequestManager == null) {
                        viewTargetRequestManager = new ViewTargetRequestManager();
                        view.addOnAttachStateChangeListener(viewTargetRequestManager);
                        view.setTag(R.id.coil3_request_manager, viewTargetRequestManager);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return viewTargetRequestManager;
        }

        public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
            AnnotatedString annotatedString = textFieldValue.annotatedString;
            long j = textFieldValue.selection;
            annotatedString.getClass();
            return annotatedString.subSequence(TextRange.m744getMinimpl(j), TextRange.m743getMaximpl(j));
        }

        public static final MutableFloatList getStepInterpolationPoints(float f, List list, boolean z) {
            int i = FloatListKt.$r8$clinit;
            MutableFloatList mutableFloatList = new MutableFloatList();
            mutableFloatList.content = new float[1];
            mutableFloatList.add(CropImageView.DEFAULT_ASPECT_RATIO);
            if (f != CropImageView.DEFAULT_ASPECT_RATIO && !list.isEmpty()) {
                IntRange intRangeUntil = UuidKt.until(1, list.size());
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator it = intRangeUntil.iterator();
                while (((IntProgressionIterator) it).hasNext) {
                    int iNextInt = ((IntIterator) it).nextInt();
                    int i2 = iNextInt - 1;
                    KeylineList keylineList = (KeylineList) list.get(i2);
                    KeylineList keylineList2 = (KeylineList) list.get(iNextInt);
                    mutableFloatList.add(iNextInt == list.size() - 1 ? 1.0f : mutableFloatList.get(i2) + ((z ? ((Keyline) CollectionsKt.first((List) keylineList2)).unadjustedOffset - ((Keyline) CollectionsKt.first((List) keylineList)).unadjustedOffset : ((Keyline) CollectionsKt.last(keylineList)).unadjustedOffset - ((Keyline) CollectionsKt.last(keylineList2)).unadjustedOffset) / f));
                    arrayList.add(Boolean.TRUE);
                }
            }
            return mutableFloatList;
        }

        public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
            AnnotatedString annotatedString = textFieldValue.annotatedString;
            AnnotatedString annotatedString2 = textFieldValue.annotatedString;
            long j = textFieldValue.selection;
            int iM743getMaximpl = TextRange.m743getMaximpl(j);
            int iM743getMaximpl2 = TextRange.m743getMaximpl(j);
            int length = iM743getMaximpl2 + i;
            if (((i ^ length) & (iM743getMaximpl2 ^ length)) < 0) {
                length = annotatedString2.text.length();
            }
            return annotatedString.subSequence(iM743getMaximpl, Math.min(length, annotatedString2.text.length()));
        }

        public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
            AnnotatedString annotatedString = textFieldValue.annotatedString;
            long j = textFieldValue.selection;
            int iM744getMinimpl = TextRange.m744getMinimpl(j);
            int i2 = iM744getMinimpl - i;
            if (((iM744getMinimpl ^ i2) & (i ^ iM744getMinimpl)) < 0) {
                i2 = 0;
            }
            return annotatedString.subSequence(Math.max(0, i2), TextRange.m744getMinimpl(j));
        }

        public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult textLayoutResult, int i) {
            TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            if (textLayoutInput.text.text.length() != 0) {
                int lineForOffset = multiParagraph.getLineForOffset(i);
                if ((i != 0 && lineForOffset == multiParagraph.getLineForOffset(i - 1)) || (i != textLayoutInput.text.text.length() && lineForOffset == multiParagraph.getLineForOffset(i + 1))) {
                    return textLayoutResult.getBidiRunDirection(i);
                }
            }
            return textLayoutResult.getParagraphDirection(i);
        }

        /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
        public static final float m1063getXDnnuFBc(long j) {
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
        public static final float m1064getYDnnuFBc(long j) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }

        public static void handleException(Exception exc) throws Throwable {
            if (exc instanceof InvocationTargetException) {
                Throwable cause = ((InvocationTargetException) exc).getCause();
                if (!(cause instanceof RuntimeException)) {
                    throw new RuntimeException(cause);
                }
                throw cause;
            }
        }

        public static final boolean isEnabled() throws Throwable {
            if (Build.VERSION.SDK_INT >= 29) {
                return TraceApi29Impl.isEnabled();
            }
            try {
                Method method = isTagEnabledMethod;
                if (method == null) {
                    traceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    method = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                    isTagEnabledMethod = method;
                }
                if (method == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                Object objInvoke = method.invoke(null, Long.valueOf(traceTagApp));
                objInvoke.getClass();
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e) {
                handleException(e);
                return false;
            }
        }

        public static final float lerp(float f, float f2, float f3, float f4, float f5) {
            if (f5 <= f3) {
                return f;
            }
            return f5 >= f4 ? f2 : LifecyclesKt.lerp(f, f2, (f5 - f3) / (f4 - f3));
        }

        public static Supplier memoize(final Supplier supplier) {
            if ((supplier instanceof Suppliers$NonSerializableMemoizingSupplier) || (supplier instanceof Suppliers$MemoizingSupplier)) {
                return supplier;
            }
            return supplier instanceof Serializable ? new Suppliers$MemoizingSupplier(supplier) : new Supplier(supplier) { // from class: com.google.common.base.Suppliers$NonSerializableMemoizingSupplier
                public volatile Supplier delegate;
                public final Object lock = new Object();
                public Object value;

                {
                    this.delegate = supplier;
                }

                @Override // com.google.common.base.Supplier
                public final Object get() {
                    if (this.delegate != null) {
                        synchronized (this.lock) {
                            try {
                                if (this.delegate != null) {
                                    Object obj = this.delegate.get();
                                    this.value = obj;
                                    this.delegate = null;
                                    return obj;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return this.value;
                }

                public final String toString() {
                    Object obj = this.delegate;
                    StringBuilder sb = new StringBuilder("Suppliers.memoize(");
                    if (obj == null) {
                        obj = "<supplier that returned " + this.value + ">";
                    }
                    sb.append(obj);
                    sb.append(")");
                    return sb.toString();
                }
            };
        }

        /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
        public static final long m1065minusybeJwSQ(long j, long j2) {
            return FloatFloatPair.m0constructorimpl(m1063getXDnnuFBc(j) - m1063getXDnnuFBc(j2), m1064getYDnnuFBc(j) - m1064getYDnnuFBc(j2));
        }

        public static final KeylineList moveKeylineAndCreateShiftedKeylineList(KeylineList keylineList, int i, int i2, float f, float f2) {
            int i3 = -1;
            int i4 = i > i2 ? 1 : -1;
            float f3 = ((keylineList.get(i).size - keylineList.get(i).cutoff) + f2) * i4;
            int i5 = keylineList.pivotIndex;
            int i6 = i5 + i4;
            float f4 = keylineList.get(i5).offset + f3;
            ArrayList arrayList = new ArrayList();
            ArrayList mutableList = CollectionsKt.toMutableList((Collection) keylineList);
            Keyline keyline = (Keyline) mutableList.get(i);
            mutableList.remove(i);
            mutableList.add(i2, keyline);
            int size = mutableList.size();
            float f5 = 0.0f;
            int size2 = -1;
            for (int i7 = 0; i7 < size; i7++) {
                Keyline keyline2 = (Keyline) mutableList.get(i7);
                float f6 = keyline2.size;
                boolean z = keyline2.isAnchor;
                arrayList.add(new KeylineListScopeImpl$TmpKeyline(f6, z));
                if (!z && f6 > f5) {
                    size2 = arrayList.size() - 1;
                    f5 = f6;
                }
            }
            if (size2 >= 0) {
                i3 = size2;
                while (i3 < arrayList.size() - 1) {
                    int i8 = i3 + 1;
                    if (((KeylineListScopeImpl$TmpKeyline) arrayList.get(i8)).size != f5) {
                        break;
                    }
                    i3 = i8;
                }
            }
            return new KeylineList(RelativeScroller.createKeylinesWithPivot(i6, f4, size2, i3, f5, f, f2, arrayList));
        }

        public static void outputSubtitleEvent(Subtitle subtitle, int i, Consumer consumer) {
            long eventTime = subtitle.getEventTime(i);
            List cues = subtitle.getCues(eventTime);
            if (cues.isEmpty()) {
                return;
            }
            if (i == subtitle.getEventTimeCount() - 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
            long eventTime2 = subtitle.getEventTime(i + 1) - subtitle.getEventTime(i);
            if (eventTime2 > 0) {
                consumer.accept(new CuesWithTiming(eventTime, eventTime2, cues));
            }
        }

        public static final Cache.RealCacheRequest parseSourceInformationInternal(String str) throws Throwable {
            String strTakeUntil;
            boolean z;
            Object obj;
            String strSubstring;
            int i;
            int i2;
            PriorityQueue priorityQueue = new PriorityQueue((Serializable) str, (byte) 3);
            char c = '(';
            int i3 = 1;
            Throwable th = null;
            if (priorityQueue.matches('C')) {
                priorityQueue.size++;
                if (priorityQueue.matches('C')) {
                    priorityQueue.size++;
                }
                if (priorityQueue.matches('(')) {
                    priorityQueue.size++;
                    strTakeUntil = priorityQueue.takeUntil(")");
                    priorityQueue.expect();
                    priorityQueue.size++;
                    z = true;
                } else {
                    z = true;
                    strTakeUntil = null;
                }
            } else {
                strTakeUntil = null;
                z = false;
            }
            while (priorityQueue.size < str.length() - i3 && Character.isLetter(str.charAt(priorityQueue.size)) && str.charAt(priorityQueue.size + i3) == c) {
                char cCharAt = str.charAt(priorityQueue.size);
                if (cCharAt != 'N') {
                    int i4 = priorityQueue.size;
                    if (cCharAt != 'P') {
                        priorityQueue.size = i4 + 2;
                        int i5 = 0;
                        while (true) {
                            if (i5 <= 0 && priorityQueue.matches(')')) {
                                priorityQueue.expect();
                                priorityQueue.size += i3;
                                break;
                            }
                            if (priorityQueue.atEnd()) {
                                priorityQueue.throwParseError("unexpected end");
                                throw th;
                            }
                            if (priorityQueue.matches(c)) {
                                i5++;
                            } else if (priorityQueue.matches(')')) {
                                i5--;
                            }
                            priorityQueue.size += i3;
                        }
                    } else {
                        priorityQueue.size = i4 + 2;
                        ArrayList arrayList = new ArrayList();
                        int i6 = 0;
                        while (!priorityQueue.atEnd() && !priorityQueue.matches(')')) {
                            if (priorityQueue.matches('!')) {
                                priorityQueue.size += i3;
                                String strTakeUntil2 = priorityQueue.takeUntil("!,)");
                                if (strTakeUntil2.length() != 0) {
                                    int i7 = Integer.parseInt(strTakeUntil2);
                                    int i8 = 0;
                                    while (true) {
                                        i2 = i3;
                                        if (i7 <= 0) {
                                            break;
                                        }
                                        int size = arrayList.size();
                                        int i9 = 0;
                                        while (true) {
                                            if (i9 >= size) {
                                                arrayList.add(new ParameterSourceInformation(i8));
                                                i7--;
                                                break;
                                            }
                                            if (((ParameterSourceInformation) arrayList.get(i9)).sortedIndex == i8) {
                                                i8++;
                                                break;
                                            }
                                            i9++;
                                        }
                                        i3 = i2;
                                    }
                                } else {
                                    i6 = i3;
                                    i2 = i6;
                                }
                            } else {
                                i2 = i3;
                                int iTakeIntUntil = priorityQueue.takeIntUntil("!:,)");
                                if (priorityQueue.matches(':')) {
                                    priorityQueue.size++;
                                    StringsKt__StringsJVMKt.replaceFirst$default(priorityQueue.takeUntil("!,)"), "c#", "androidx.compose.");
                                }
                                if (i6 != 0) {
                                    int i10 = 0;
                                    while (i10 < iTakeIntUntil) {
                                        int size2 = arrayList.size();
                                        int i11 = 0;
                                        while (true) {
                                            if (i11 >= size2) {
                                                arrayList.add(new ParameterSourceInformation(i10));
                                                break;
                                            }
                                            if (((ParameterSourceInformation) arrayList.get(i11)).sortedIndex == i10) {
                                                i10++;
                                                break;
                                            }
                                            i11++;
                                        }
                                    }
                                    i6 = 0;
                                }
                                arrayList.add(new ParameterSourceInformation(iTakeIntUntil));
                            }
                            if (priorityQueue.matches(',')) {
                                priorityQueue.size++;
                            }
                            i3 = i2;
                        }
                        i = i3;
                        priorityQueue.expect();
                        priorityQueue.size++;
                    }
                } else {
                    i = i3;
                    priorityQueue.size += 2;
                    ArrayList arrayList2 = new ArrayList();
                    while (!priorityQueue.atEnd() && !priorityQueue.matches(')')) {
                        priorityQueue.takeUntil(":,)");
                        if (priorityQueue.matches(':')) {
                            priorityQueue.size++;
                            StringsKt__StringsJVMKt.replaceFirst$default(priorityQueue.takeUntil(",)"), "c#", "androidx.compose.");
                        }
                        arrayList2.add(new ParameterSourceInformation(arrayList2.size()));
                        if (priorityQueue.matches(',')) {
                            priorityQueue.size++;
                        }
                    }
                    priorityQueue.expect();
                    priorityQueue.size++;
                }
                i3 = i;
                c = '(';
                th = null;
            }
            if (priorityQueue.matches(':')) {
                priorityQueue.size++;
                obj = EmptyList.INSTANCE;
            } else {
                ArrayList arrayList3 = new ArrayList();
                while (!priorityQueue.atEnd() && !priorityQueue.matches(':')) {
                    if (priorityQueue.matches(GMTDateParser.ANY)) {
                        priorityQueue.size++;
                    }
                    Integer numValueOf = !priorityQueue.matches('@') ? Integer.valueOf(priorityQueue.takeIntUntil("@") + 1) : null;
                    priorityQueue.size++;
                    priorityQueue.takeIntUntil("L,:");
                    if (priorityQueue.matches('L')) {
                        priorityQueue.size++;
                        priorityQueue.takeIntUntil(",:");
                    }
                    arrayList3.add(new LocationSourceInformation(numValueOf != null ? numValueOf.intValue() : -1));
                    if (priorityQueue.matches(',')) {
                        priorityQueue.size++;
                    }
                }
                priorityQueue.size++;
                obj = arrayList3;
            }
            String strTakeUntil3 = priorityQueue.takeUntil("#");
            if (strTakeUntil3.length() <= 0) {
                strTakeUntil3 = null;
            }
            if (priorityQueue.matches('#')) {
                int i12 = priorityQueue.size + 1;
                priorityQueue.size = i12;
                strSubstring = str.substring(i12, str.length());
            } else {
                strSubstring = null;
            }
            Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest();
            realCacheRequest.done = z;
            realCacheRequest.editor = strTakeUntil;
            realCacheRequest.cacheOut = strTakeUntil3;
            realCacheRequest.body = strSubstring;
            realCacheRequest.this$0 = obj;
            return realCacheRequest;
        }

        public static final Object performBlocking(RoomDatabase roomDatabase, boolean z, boolean z2, Function1 function1) {
            roomDatabase.getClass();
            ThreadLocal threadLocal = roomDatabase.suspendingTransactionContext;
            roomDatabase.assertNotMainThread();
            if (roomDatabase.inCompatibilityMode() && !roomDatabase.inTransaction()) {
                CoroutineContext coroutineContext = (CoroutineContext) threadLocal.get();
                if ((coroutineContext != null ? (TransactionElement) coroutineContext.get(TransactionElement.Key) : null) != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot access database on a different coroutine context inherited from a suspending transaction.");
                    return null;
                }
            }
            CoroutineContext coroutineContext2 = (CoroutineContext) threadLocal.get();
            if (coroutineContext2 == null) {
                coroutineContext2 = EmptyCoroutineContext.INSTANCE;
            }
            return UtilsKt.runBlockingUninterruptible(new HomeViewModel.C02082(coroutineContext2, roomDatabase, z2, z, function1, (Continuation) null));
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Object performInTransactionSuspending(RoomDatabase roomDatabase, Function1 function1, ContinuationImpl continuationImpl) {
            DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$1;
            Function1 function2;
            if (continuationImpl instanceof DBUtil__DBUtil_androidKt$performInTransactionSuspending$1) {
                dBUtil__DBUtil_androidKt$performInTransactionSuspending$1 = (DBUtil__DBUtil_androidKt$performInTransactionSuspending$1) continuationImpl;
                int i = dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label = i - Integer.MIN_VALUE;
                } else {
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$1(continuationImpl);
                }
            } else {
                dBUtil__DBUtil_androidKt$performInTransactionSuspending$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$1(continuationImpl);
            }
            Object coroutineContext = dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.result;
            int i2 = dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label;
            Continuation continuation = null;
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 == 0) {
                ResultKt.throwOnFailure(coroutineContext);
                if (roomDatabase.inCompatibilityMode()) {
                    InnerTube$executeMutation$2$1 innerTube$executeMutation$2$1 = new InnerTube$executeMutation$2$1(roomDatabase, function1, continuation, (byte) 5);
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label = 1;
                    Object objWithTransactionContext = UtilsKt.withTransactionContext(roomDatabase, dBUtil__DBUtil_androidKt$performInTransactionSuspending$1, innerTube$executeMutation$2$1);
                    if (objWithTransactionContext != obj) {
                        return objWithTransactionContext;
                    }
                } else if (roomDatabase.inCompatibilityMode() && roomDatabase.isOpenInternal$room_runtime() && roomDatabase.inTransaction()) {
                    DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1(roomDatabase, continuation, function1, (byte) 0);
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label = 2;
                    Object objUseConnection = roomDatabase.useConnection(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1, dBUtil__DBUtil_androidKt$performInTransactionSuspending$1);
                    if (objUseConnection != obj) {
                        return objUseConnection;
                    }
                } else {
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$0 = roomDatabase;
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$1 = (SuspendLambda) function1;
                    dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label = 3;
                    coroutineContext = getCoroutineContext(roomDatabase, true, dBUtil__DBUtil_androidKt$performInTransactionSuspending$1);
                    function2 = function1;
                    if (coroutineContext != obj) {
                    }
                }
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(coroutineContext);
                return coroutineContext;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(coroutineContext);
                return coroutineContext;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    ResultKt.throwOnFailure(coroutineContext);
                    return coroutineContext;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Function1 function3 = (Function1) dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$1;
            roomDatabase = dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$0;
            ResultKt.throwOnFailure(coroutineContext);
            function2 = function3;
            App.C01391 c01391 = new App.C01391(roomDatabase, (Continuation) null, function2);
            dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$0 = null;
            dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.L$1 = null;
            dBUtil__DBUtil_androidKt$performInTransactionSuspending$1.label = 4;
            Object objWithContext = AwaitKt.withContext((CoroutineContext) coroutineContext, c01391, dBUtil__DBUtil_androidKt$performInTransactionSuspending$1);
            return objWithContext == obj ? obj : objWithContext;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0016  */
        public static final Object performSuspending(RoomDatabase roomDatabase, boolean z, boolean z2, Function1 function1, Continuation continuation) {
            DBUtil__DBUtil_androidKt$performSuspending$1 dBUtil__DBUtil_androidKt$performSuspending$1;
            RoomDatabase roomDatabase2;
            boolean z3;
            boolean z4;
            Function1 function2;
            if (continuation instanceof DBUtil__DBUtil_androidKt$performSuspending$1) {
                dBUtil__DBUtil_androidKt$performSuspending$1 = (DBUtil__DBUtil_androidKt$performSuspending$1) continuation;
                int i = dBUtil__DBUtil_androidKt$performSuspending$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    dBUtil__DBUtil_androidKt$performSuspending$1.label = i - Integer.MIN_VALUE;
                } else {
                    dBUtil__DBUtil_androidKt$performSuspending$1 = new DBUtil__DBUtil_androidKt$performSuspending$1(continuation);
                }
            } else {
                dBUtil__DBUtil_androidKt$performSuspending$1 = new DBUtil__DBUtil_androidKt$performSuspending$1(continuation);
            }
            DBUtil__DBUtil_androidKt$performSuspending$1 dBUtil__DBUtil_androidKt$performSuspending$2 = dBUtil__DBUtil_androidKt$performSuspending$1;
            Object obj = dBUtil__DBUtil_androidKt$performSuspending$2.result;
            int i2 = dBUtil__DBUtil_androidKt$performSuspending$2.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (roomDatabase.inCompatibilityMode() && roomDatabase.isOpenInternal$room_runtime() && roomDatabase.inTransaction()) {
                    DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(z2, z, roomDatabase, null, function1, (byte) 0);
                    dBUtil__DBUtil_androidKt$performSuspending$2.label = 1;
                    Object objUseConnection = roomDatabase.useConnection(z, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1, dBUtil__DBUtil_androidKt$performSuspending$2);
                    if (objUseConnection != coroutineSingletons) {
                        return objUseConnection;
                    }
                } else {
                    dBUtil__DBUtil_androidKt$performSuspending$2.L$0 = roomDatabase;
                    dBUtil__DBUtil_androidKt$performSuspending$2.L$1 = function1;
                    dBUtil__DBUtil_androidKt$performSuspending$2.Z$0 = z;
                    dBUtil__DBUtil_androidKt$performSuspending$2.Z$1 = z2;
                    dBUtil__DBUtil_androidKt$performSuspending$2.label = 2;
                    CoroutineContext coroutineContext = getCoroutineContext(roomDatabase, z2, dBUtil__DBUtil_androidKt$performSuspending$2);
                    if (coroutineContext != coroutineSingletons) {
                        roomDatabase2 = roomDatabase;
                        z3 = z;
                        obj = coroutineContext;
                        z4 = z2;
                        function2 = function1;
                    }
                }
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boolean z5 = dBUtil__DBUtil_androidKt$performSuspending$2.Z$1;
            boolean z6 = dBUtil__DBUtil_androidKt$performSuspending$2.Z$0;
            Function1 function3 = dBUtil__DBUtil_androidKt$performSuspending$2.L$1;
            RoomDatabase roomDatabase3 = dBUtil__DBUtil_androidKt$performSuspending$2.L$0;
            ResultKt.throwOnFailure(obj);
            z4 = z5;
            z3 = z6;
            function2 = function3;
            roomDatabase2 = roomDatabase3;
            DBUtil__DBUtil_androidKt$performBlocking$1$1 dBUtil__DBUtil_androidKt$performBlocking$1$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$1((Continuation) null, roomDatabase2, z3, z4, function2);
            dBUtil__DBUtil_androidKt$performSuspending$2.L$0 = null;
            dBUtil__DBUtil_androidKt$performSuspending$2.L$1 = null;
            dBUtil__DBUtil_androidKt$performSuspending$2.label = 3;
            Object objWithContext = AwaitKt.withContext((CoroutineContext) obj, dBUtil__DBUtil_androidKt$performBlocking$1$1, dBUtil__DBUtil_androidKt$performSuspending$2);
            return objWithContext == coroutineSingletons ? coroutineSingletons : objWithContext;
        }

        /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
        public static final long m1066plusybeJwSQ(long j, long j2) {
            return FloatFloatPair.m0constructorimpl(m1063getXDnnuFBc(j2) + m1063getXDnnuFBc(j), m1064getYDnnuFBc(j2) + m1064getYDnnuFBc(j));
        }

        public static final void positionToParentOf(SlotWriter slotWriter, Applier applier, int i) {
            while (true) {
                int i2 = slotWriter.parent;
                if (i > i2 && i < slotWriter.currentGroupEnd) {
                    return;
                }
                if (i2 == 0 && i == 0) {
                    return;
                }
                slotWriter.skipToGroupEnd();
                if (slotWriter.isNode(slotWriter.parent)) {
                    applier.up();
                }
                slotWriter.endGroup();
            }
        }

        public static TableInfo read(SQLiteConnection sQLiteConnection, String str) {
            long j;
            Map mapBuild;
            SetBuilder setBuilder;
            sQLiteConnection.getClass();
            SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
            try {
                long j2 = 0;
                if (sQLiteStatementPrepare.step()) {
                    int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
                    int iColumnIndexOf2 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, LinkHeader.Parameters.Type);
                    int iColumnIndexOf3 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "notnull");
                    int iColumnIndexOf4 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "pk");
                    int iColumnIndexOf5 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare, "dflt_value");
                    MapBuilder mapBuilder = new MapBuilder();
                    while (true) {
                        String text = sQLiteStatementPrepare.getText(iColumnIndexOf);
                        j = j2;
                        mapBuilder.put(text, new TableInfo.Column((int) sQLiteStatementPrepare.getLong(iColumnIndexOf4), 2, text, sQLiteStatementPrepare.getText(iColumnIndexOf2), sQLiteStatementPrepare.isNull(iColumnIndexOf5) ? null : sQLiteStatementPrepare.getText(iColumnIndexOf5), sQLiteStatementPrepare.getLong(iColumnIndexOf3) != j2));
                        if (!sQLiteStatementPrepare.step()) {
                            break;
                        }
                        j2 = j;
                    }
                    mapBuild = mapBuilder.build();
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                } else {
                    mapBuild = EmptyMap.INSTANCE;
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                    j = 0;
                }
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
                try {
                    int iColumnIndexOf6 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare2, "id");
                    int iColumnIndexOf7 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare2, "seq");
                    int iColumnIndexOf8 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare2, "table");
                    int iColumnIndexOf9 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare2, "on_delete");
                    int iColumnIndexOf10 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare2, "on_update");
                    List foreignKeyFieldMappings = UtilsKt.readForeignKeyFieldMappings(sQLiteStatementPrepare2);
                    sQLiteStatementPrepare2.reset();
                    SetBuilder setBuilder2 = new SetBuilder();
                    while (sQLiteStatementPrepare2.step()) {
                        if (sQLiteStatementPrepare2.getLong(iColumnIndexOf7) == j) {
                            int i = (int) sQLiteStatementPrepare2.getLong(iColumnIndexOf6);
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            int i2 = iColumnIndexOf6;
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj : foreignKeyFieldMappings) {
                                int i3 = iColumnIndexOf7;
                                List list = foreignKeyFieldMappings;
                                if (((ForeignKeyWithSequence) obj).id == i) {
                                    arrayList3.add(obj);
                                }
                                iColumnIndexOf7 = i3;
                                foreignKeyFieldMappings = list;
                            }
                            int i4 = iColumnIndexOf7;
                            List list2 = foreignKeyFieldMappings;
                            int size = arrayList3.size();
                            int i5 = 0;
                            while (i5 < size) {
                                Object obj2 = arrayList3.get(i5);
                                i5++;
                                ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                                arrayList.add(foreignKeyWithSequence.from);
                                arrayList2.add(foreignKeyWithSequence.to);
                                arrayList3 = arrayList3;
                            }
                            setBuilder2.add(new TableInfo.ForeignKey(sQLiteStatementPrepare2.getText(iColumnIndexOf8), sQLiteStatementPrepare2.getText(iColumnIndexOf9), sQLiteStatementPrepare2.getText(iColumnIndexOf10), arrayList, arrayList2));
                            iColumnIndexOf6 = i2;
                            iColumnIndexOf7 = i4;
                            foreignKeyFieldMappings = list2;
                        }
                    }
                    SetBuilder setBuilderBuild = CharsKt.build(setBuilder2);
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, null);
                    SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
                    try {
                        int iColumnIndexOf11 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare3, ContentDisposition.Parameters.Name);
                        int iColumnIndexOf12 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare3, "origin");
                        int iColumnIndexOf13 = LifecyclesKt.columnIndexOf(sQLiteStatementPrepare3, "unique");
                        if (iColumnIndexOf11 == -1 || iColumnIndexOf12 == -1 || iColumnIndexOf13 == -1) {
                            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare3, null);
                            setBuilder = null;
                        } else {
                            SetBuilder setBuilder3 = new SetBuilder();
                            while (sQLiteStatementPrepare3.step()) {
                                if ("c".equals(sQLiteStatementPrepare3.getText(iColumnIndexOf12))) {
                                    TableInfo.Index index = UtilsKt.readIndex(sQLiteConnection, sQLiteStatementPrepare3.getText(iColumnIndexOf11), sQLiteStatementPrepare3.getLong(iColumnIndexOf13) == 1);
                                    if (index == null) {
                                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare3, null);
                                        setBuilder = null;
                                    } else {
                                        setBuilder3.add(index);
                                    }
                                }
                            }
                            SetBuilder setBuilderBuild2 = CharsKt.build(setBuilder3);
                            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare3, null);
                            setBuilder = setBuilderBuild2;
                        }
                        return new TableInfo(str, mapBuild, setBuilderBuild, setBuilder);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare3, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th5);
                    throw th6;
                }
            }
        }

        public static final IntRect roundToIntRect(Rect rect) {
            return new IntRect(Math.round(rect.left), Math.round(rect.top), Math.round(rect.right), Math.round(rect.bottom));
        }

        public static final void setCollectionInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            Object obj = semanticsNode.getConfig().props.get(SemanticsProperties.CollectionInfo);
            if (obj == null) {
                obj = null;
            }
            CollectionInfo collectionInfo = (CollectionInfo) obj;
            if (collectionInfo != null) {
                accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(collectionInfo.rowCount, collectionInfo.columnCount, false, 0));
                return;
            }
            ArrayList arrayList = new ArrayList();
            Object obj2 = semanticsNode.getConfig().props.get(SemanticsProperties.SelectableGroup);
            if ((obj2 != null ? obj2 : null) != null) {
                List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
                int size = children$ui.size();
                for (int i = 0; i < size; i++) {
                    SemanticsNode semanticsNode2 = (SemanticsNode) children$ui.get(i);
                    if (semanticsNode2.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                        arrayList.add(semanticsNode2);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(zCalculateIfHorizontallyStacked ? 1 : arrayList.size(), zCalculateIfHorizontallyStacked ? arrayList.size() : 1, false, 0));
        }

        public static final void setCollectionItemInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Object obj = semanticsNode.getConfig().props.get(SemanticsProperties.CollectionItemInfo);
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            }
            SemanticsNode parent = semanticsNode.getParent();
            if (parent == null) {
                return;
            }
            Object obj2 = parent.getConfig().props.get(SemanticsProperties.SelectableGroup);
            if (obj2 == null) {
                obj2 = null;
            }
            if (obj2 != null) {
                Object obj3 = parent.getConfig().props.get(SemanticsProperties.CollectionInfo);
                CollectionInfo collectionInfo = (CollectionInfo) (obj3 != null ? obj3 : null);
                if (collectionInfo == null || (collectionInfo.rowCount >= 0 && collectionInfo.columnCount >= 0)) {
                    if (semanticsNode.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                        ArrayList arrayList = new ArrayList();
                        List children$ui = parent.getChildren$ui((4 & 1) != 0 ? !parent.mergingEnabled : false, (4 & 2) == 0);
                        int size = children$ui.size();
                        int i = 0;
                        for (int i2 = 0; i2 < size; i2++) {
                            SemanticsNode semanticsNode2 = (SemanticsNode) children$ui.get(i2);
                            if (semanticsNode2.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                                arrayList.add(semanticsNode2);
                                if (semanticsNode2.layoutNode.getPlaceOrder$ui() < semanticsNode.layoutNode.getPlaceOrder$ui()) {
                                    i++;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                        int i3 = zCalculateIfHorizontallyStacked ? 0 : i;
                        int i4 = zCalculateIfHorizontallyStacked ? i : 0;
                        Object obj4 = semanticsNode.getConfig().props.get(SemanticsProperties.Selected);
                        if (obj4 == null) {
                            obj4 = Boolean.FALSE;
                        }
                        accessibilityNodeInfoCompat.mInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, 1, i4, 1, false, ((Boolean) obj4).booleanValue()));
                    }
                }
            }
        }

        /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
        public static final long m1067timesso9K2fw(long j, float f) {
            return FloatFloatPair.m0constructorimpl(m1063getXDnnuFBc(j) * f, m1064getYDnnuFBc(j) * f);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0051  */
        public static void toCuesWithTiming(Subtitle subtitle, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
            int nextEventTimeIndex;
            boolean z;
            long j = outputOptions.startTimeUs;
            if (j == -9223372036854775807L) {
                nextEventTimeIndex = 0;
            } else {
                nextEventTimeIndex = subtitle.getNextEventTimeIndex(j);
                if (nextEventTimeIndex == -1) {
                    nextEventTimeIndex = subtitle.getEventTimeCount();
                }
                if (nextEventTimeIndex > 0 && subtitle.getEventTime(nextEventTimeIndex - 1) == j) {
                    nextEventTimeIndex--;
                }
            }
            if (j == -9223372036854775807L || nextEventTimeIndex >= subtitle.getEventTimeCount()) {
                z = false;
            } else {
                List cues = subtitle.getCues(j);
                long eventTime = subtitle.getEventTime(nextEventTimeIndex);
                if (cues.isEmpty()) {
                    z = false;
                } else {
                    long j2 = outputOptions.startTimeUs;
                    if (j2 < eventTime) {
                        consumer.accept(new CuesWithTiming(j2, eventTime - j2, cues));
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            for (int i = nextEventTimeIndex; i < subtitle.getEventTimeCount(); i++) {
                outputSubtitleEvent(subtitle, i, consumer);
            }
            if (outputOptions.outputAllCues) {
                if (z) {
                    nextEventTimeIndex--;
                }
                for (int i2 = 0; i2 < nextEventTimeIndex; i2++) {
                    outputSubtitleEvent(subtitle, i2, consumer);
                }
                if (z) {
                    consumer.accept(new CuesWithTiming(subtitle.getEventTime(nextEventTimeIndex), j - subtitle.getEventTime(nextEventTimeIndex), subtitle.getCues(j)));
                }
            }
        }

        public static final String toStringAsFixed(float f) {
            if (Float.isNaN(f)) {
                return "NaN";
            }
            if (Float.isInfinite(f)) {
                return f < CropImageView.DEFAULT_ASPECT_RATIO ? "-Infinity" : "Infinity";
            }
            int iMax = Math.max(1, 0);
            float fPow = (float) Math.pow(10.0d, iMax);
            float f2 = f * fPow;
            int i = (int) f2;
            if (f2 - i >= 0.5f) {
                i++;
            }
            float f3 = i / fPow;
            return iMax > 0 ? String.valueOf(f3) : String.valueOf((int) f3);
        }

        public static String truncatedTraceSectionLabel(String str) {
            String str2 = str.length() <= 127 ? str : null;
            return str2 == null ? str.substring(0, 127) : str2;
        }

        public static final KType typeOfInstance(TypeConverters typeConverters, Object obj) {
            TypeReference typeReferenceTypeOf;
            typeConverters.getClass();
            if (obj.equals(Unit.INSTANCE)) {
                typeReferenceTypeOf = Reflection.typeOf(Unit.class);
            } else if (obj instanceof Byte) {
                typeReferenceTypeOf = Reflection.typeOf(Byte.TYPE);
            } else if (obj instanceof Short) {
                typeReferenceTypeOf = Reflection.typeOf(Short.TYPE);
            } else if (obj instanceof Integer) {
                typeReferenceTypeOf = Reflection.typeOf(Integer.TYPE);
            } else if (obj instanceof Long) {
                typeReferenceTypeOf = Reflection.typeOf(Long.TYPE);
            } else if (obj instanceof Float) {
                typeReferenceTypeOf = Reflection.typeOf(Float.TYPE);
            } else if (obj instanceof Double) {
                typeReferenceTypeOf = Reflection.typeOf(Double.TYPE);
            } else if (obj instanceof Boolean) {
                typeReferenceTypeOf = Reflection.typeOf(Boolean.TYPE);
            } else if (obj instanceof String) {
                typeReferenceTypeOf = Reflection.typeOf(String.class);
            } else if (obj instanceof byte[]) {
                typeReferenceTypeOf = Reflection.typeOf(byte[].class);
            } else if (obj instanceof UByteArray) {
                typeReferenceTypeOf = Reflection.typeOf(UByteArray.class);
            } else if (obj instanceof Object[]) {
                typeReferenceTypeOf = Reflection.typeOf(Object[].class, KTypeProjection.INSTANCE.getSTAR());
            } else if (obj instanceof List) {
                typeReferenceTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.getSTAR());
            } else if (obj instanceof Set) {
                typeReferenceTypeOf = Reflection.typeOf(Set.class, KTypeProjection.INSTANCE.getSTAR());
            } else if (obj instanceof JsObject) {
                typeReferenceTypeOf = Reflection.typeOf(JsObject.class);
            } else if (obj instanceof Map) {
                KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
                KTypeProjection star = companion.getSTAR();
                KTypeProjection star2 = companion.getSTAR();
                ReflectionFactory reflectionFactory = Reflection.factory;
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
                List listAsList = Arrays.asList(star, star2);
                reflectionFactory.getClass();
                listAsList.getClass();
                typeReferenceTypeOf = new TypeReference(orCreateKotlinClass, listAsList, 0);
            } else {
                typeReferenceTypeOf = obj instanceof Error ? Reflection.typeOf(Error.class) : null;
            }
            if (typeReferenceTypeOf != null) {
                return typeReferenceTypeOf;
            }
            KType kType = (KType) typeConverters.classTypeMap.get(Reflection.getOrCreateKotlinClass(obj.getClass()));
            if (kType != null) {
                return kType;
            }
            throw new IllegalStateException("Cannot find the kotlin type of object " + obj + " (" + Reflection.getOrCreateKotlinClass(obj.getClass()) + "), did you forget to add a type converter for it?");
        }

        public final void bind(SQLiteStatement sQLiteStatement, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    SongEntity songEntity = (SongEntity) obj;
                    sQLiteStatement.getClass();
                    songEntity.getClass();
                    sQLiteStatement.bindText(1, songEntity.id);
                    break;
                case 1:
                    SongArtistMap songArtistMap = (SongArtistMap) obj;
                    sQLiteStatement.getClass();
                    songArtistMap.getClass();
                    sQLiteStatement.bindText(1, songArtistMap.songId);
                    sQLiteStatement.bindText(2, songArtistMap.artistId);
                    break;
                case 2:
                    AlbumEntity albumEntity = (AlbumEntity) obj;
                    sQLiteStatement.getClass();
                    albumEntity.getClass();
                    sQLiteStatement.bindText(1, albumEntity.id);
                    break;
                case 3:
                    AlbumArtistMap albumArtistMap = (AlbumArtistMap) obj;
                    sQLiteStatement.getClass();
                    albumArtistMap.getClass();
                    sQLiteStatement.bindText(1, albumArtistMap.albumId);
                    sQLiteStatement.bindText(2, albumArtistMap.artistId);
                    break;
                case 4:
                    PlaylistEntity playlistEntity = (PlaylistEntity) obj;
                    sQLiteStatement.getClass();
                    playlistEntity.getClass();
                    sQLiteStatement.bindText(1, playlistEntity.id);
                    break;
                case 5:
                    PlaylistSongMap playlistSongMap = (PlaylistSongMap) obj;
                    sQLiteStatement.getClass();
                    playlistSongMap.getClass();
                    sQLiteStatement.bindLong(1, playlistSongMap.id);
                    break;
                case 6:
                    LyricsEntity lyricsEntity = (LyricsEntity) obj;
                    sQLiteStatement.getClass();
                    lyricsEntity.getClass();
                    sQLiteStatement.bindText(1, lyricsEntity.id);
                    break;
                case 7:
                    SearchHistory searchHistory = (SearchHistory) obj;
                    sQLiteStatement.getClass();
                    searchHistory.getClass();
                    sQLiteStatement.bindLong(1, searchHistory.id);
                    break;
                case 8:
                    Event event = (Event) obj;
                    sQLiteStatement.getClass();
                    event.getClass();
                    sQLiteStatement.bindLong(1, event.id);
                    break;
                case 9:
                    SongEntity songEntity2 = (SongEntity) obj;
                    sQLiteStatement.getClass();
                    songEntity2.getClass();
                    String str = songEntity2.id;
                    sQLiteStatement.bindText(1, str);
                    sQLiteStatement.bindText(2, songEntity2.title);
                    sQLiteStatement.bindLong(3, songEntity2.duration);
                    String str2 = songEntity2.thumbnailUrl;
                    if (str2 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str2);
                    }
                    String str3 = songEntity2.albumId;
                    if (str3 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str3);
                    }
                    String str4 = songEntity2.albumName;
                    if (str4 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str4);
                    }
                    sQLiteStatement.bindLong(7, songEntity2.explicit ? 1L : 0L);
                    Integer num = songEntity2.year;
                    if (num == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num.intValue());
                    }
                    Long lDateToTimestamp = Converters.dateToTimestamp(songEntity2.date);
                    if (lDateToTimestamp == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindLong(9, lDateToTimestamp.longValue());
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(songEntity2.dateModified);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp2.longValue());
                    }
                    sQLiteStatement.bindLong(11, songEntity2.liked ? 1L : 0L);
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(songEntity2.likedDate);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp3.longValue());
                    }
                    sQLiteStatement.bindLong(13, songEntity2.totalPlayTime);
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(songEntity2.inLibrary);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatement.bindNull(14);
                    } else {
                        sQLiteStatement.bindLong(14, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(songEntity2.dateDownload);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatement.bindNull(15);
                    } else {
                        sQLiteStatement.bindLong(15, lDateToTimestamp5.longValue());
                    }
                    sQLiteStatement.bindLong(16, songEntity2.isLocal ? 1L : 0L);
                    String str5 = songEntity2.libraryAddToken;
                    if (str5 == null) {
                        sQLiteStatement.bindNull(17);
                    } else {
                        sQLiteStatement.bindText(17, str5);
                    }
                    String str6 = songEntity2.libraryRemoveToken;
                    if (str6 == null) {
                        sQLiteStatement.bindNull(18);
                    } else {
                        sQLiteStatement.bindText(18, str6);
                    }
                    sQLiteStatement.bindLong(19, songEntity2.lyricsOffset);
                    sQLiteStatement.bindLong(20, songEntity2.romanizeLyrics ? 1L : 0L);
                    sQLiteStatement.bindLong(21, songEntity2.isDownloaded ? 1L : 0L);
                    sQLiteStatement.bindLong(22, songEntity2.isUploaded ? 1L : 0L);
                    sQLiteStatement.bindLong(23, songEntity2.isVideo ? 1L : 0L);
                    sQLiteStatement.bindLong(24, songEntity2.isEpisode ? 1L : 0L);
                    Long l = songEntity2.playbackPosition;
                    if (l == null) {
                        sQLiteStatement.bindNull(25);
                    } else {
                        sQLiteStatement.bindLong(25, l.longValue());
                    }
                    String str7 = songEntity2.uploadEntityId;
                    if (str7 == null) {
                        sQLiteStatement.bindNull(26);
                    } else {
                        sQLiteStatement.bindText(26, str7);
                    }
                    sQLiteStatement.bindLong(27, songEntity2.isCached ? 1L : 0L);
                    sQLiteStatement.bindText(28, str);
                    break;
                case 10:
                    ArtistEntity artistEntity = (ArtistEntity) obj;
                    sQLiteStatement.getClass();
                    artistEntity.getClass();
                    String str8 = artistEntity.id;
                    sQLiteStatement.bindText(1, str8);
                    sQLiteStatement.bindText(2, artistEntity.name);
                    String str9 = artistEntity.thumbnailUrl;
                    if (str9 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str9);
                    }
                    String str10 = artistEntity.channelId;
                    if (str10 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str10);
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(artistEntity.lastUpdateTime);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindLong(5, lDateToTimestamp6.longValue());
                    }
                    Long lDateToTimestamp7 = Converters.dateToTimestamp(artistEntity.bookmarkedAt);
                    if (lDateToTimestamp7 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, lDateToTimestamp7.longValue());
                    }
                    sQLiteStatement.bindLong(7, artistEntity.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(8, artistEntity.isPodcastChannel ? 1L : 0L);
                    String str11 = artistEntity.cachedPageJson;
                    if (str11 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindText(9, str11);
                    }
                    sQLiteStatement.bindText(10, str8);
                    break;
                case 11:
                    AlbumEntity albumEntity2 = (AlbumEntity) obj;
                    sQLiteStatement.getClass();
                    albumEntity2.getClass();
                    String str12 = albumEntity2.id;
                    sQLiteStatement.bindText(1, str12);
                    String str13 = albumEntity2.playlistId;
                    if (str13 == null) {
                        sQLiteStatement.bindNull(2);
                    } else {
                        sQLiteStatement.bindText(2, str13);
                    }
                    sQLiteStatement.bindText(3, albumEntity2.title);
                    Integer num2 = albumEntity2.year;
                    if (num2 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindLong(4, num2.intValue());
                    }
                    String str14 = albumEntity2.thumbnailUrl;
                    if (str14 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str14);
                    }
                    Integer num3 = albumEntity2.themeColor;
                    if (num3 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, num3.intValue());
                    }
                    sQLiteStatement.bindLong(7, albumEntity2.songCount);
                    sQLiteStatement.bindLong(8, albumEntity2.duration);
                    sQLiteStatement.bindLong(9, albumEntity2.explicit ? 1L : 0L);
                    Long lDateToTimestamp8 = Converters.dateToTimestamp(albumEntity2.lastUpdateTime);
                    if (lDateToTimestamp8 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp8.longValue());
                    }
                    Long lDateToTimestamp9 = Converters.dateToTimestamp(albumEntity2.bookmarkedAt);
                    if (lDateToTimestamp9 == null) {
                        sQLiteStatement.bindNull(11);
                    } else {
                        sQLiteStatement.bindLong(11, lDateToTimestamp9.longValue());
                    }
                    Long lDateToTimestamp10 = Converters.dateToTimestamp(albumEntity2.likedDate);
                    if (lDateToTimestamp10 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp10.longValue());
                    }
                    Long lDateToTimestamp11 = Converters.dateToTimestamp(albumEntity2.inLibrary);
                    if (lDateToTimestamp11 == null) {
                        sQLiteStatement.bindNull(13);
                    } else {
                        sQLiteStatement.bindLong(13, lDateToTimestamp11.longValue());
                    }
                    sQLiteStatement.bindLong(14, albumEntity2.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(15, albumEntity2.isUploaded ? 1L : 0L);
                    sQLiteStatement.bindText(16, str12);
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    PlaylistEntity playlistEntity2 = (PlaylistEntity) obj;
                    sQLiteStatement.getClass();
                    playlistEntity2.getClass();
                    String str15 = playlistEntity2.id;
                    sQLiteStatement.bindText(1, str15);
                    sQLiteStatement.bindText(2, playlistEntity2.name);
                    String str16 = playlistEntity2.browseId;
                    if (str16 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str16);
                    }
                    Long lDateToTimestamp12 = Converters.dateToTimestamp(playlistEntity2.createdAt);
                    if (lDateToTimestamp12 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindLong(4, lDateToTimestamp12.longValue());
                    }
                    Long lDateToTimestamp13 = Converters.dateToTimestamp(playlistEntity2.lastUpdateTime);
                    if (lDateToTimestamp13 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindLong(5, lDateToTimestamp13.longValue());
                    }
                    sQLiteStatement.bindLong(6, playlistEntity2.isEditable ? 1L : 0L);
                    Long lDateToTimestamp14 = Converters.dateToTimestamp(playlistEntity2.bookmarkedAt);
                    if (lDateToTimestamp14 == null) {
                        sQLiteStatement.bindNull(7);
                    } else {
                        sQLiteStatement.bindLong(7, lDateToTimestamp14.longValue());
                    }
                    Integer num4 = playlistEntity2.remoteSongCount;
                    if (num4 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num4.intValue());
                    }
                    String str17 = playlistEntity2.playEndpointParams;
                    if (str17 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindText(9, str17);
                    }
                    String str18 = playlistEntity2.thumbnailUrl;
                    if (str18 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindText(10, str18);
                    }
                    String str19 = playlistEntity2.shuffleEndpointParams;
                    if (str19 == null) {
                        sQLiteStatement.bindNull(11);
                    } else {
                        sQLiteStatement.bindText(11, str19);
                    }
                    String str20 = playlistEntity2.radioEndpointParams;
                    if (str20 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindText(12, str20);
                    }
                    sQLiteStatement.bindLong(13, playlistEntity2.isLocal ? 1L : 0L);
                    sQLiteStatement.bindLong(14, playlistEntity2.isAutoSync ? 1L : 0L);
                    sQLiteStatement.bindText(15, str15);
                    break;
                case 13:
                    PlaylistSongMap playlistSongMap2 = (PlaylistSongMap) obj;
                    sQLiteStatement.getClass();
                    playlistSongMap2.getClass();
                    long j = playlistSongMap2.id;
                    sQLiteStatement.bindLong(1, j);
                    sQLiteStatement.bindText(2, playlistSongMap2.playlistId);
                    sQLiteStatement.bindText(3, playlistSongMap2.songId);
                    sQLiteStatement.bindLong(4, playlistSongMap2.position);
                    String str21 = playlistSongMap2.setVideoId;
                    if (str21 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str21);
                    }
                    sQLiteStatement.bindLong(6, j);
                    break;
                case 14:
                    PodcastEntity podcastEntity = (PodcastEntity) obj;
                    sQLiteStatement.getClass();
                    podcastEntity.getClass();
                    String str22 = podcastEntity.id;
                    sQLiteStatement.bindText(1, str22);
                    sQLiteStatement.bindText(2, podcastEntity.title);
                    String str23 = podcastEntity.author;
                    if (str23 == null) {
                        sQLiteStatement.bindNull(3);
                    } else {
                        sQLiteStatement.bindText(3, str23);
                    }
                    String str24 = podcastEntity.thumbnailUrl;
                    if (str24 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str24);
                    }
                    String str25 = podcastEntity.channelId;
                    if (str25 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str25);
                    }
                    Long lDateToTimestamp15 = Converters.dateToTimestamp(podcastEntity.bookmarkedAt);
                    if (lDateToTimestamp15 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, lDateToTimestamp15.longValue());
                    }
                    Long lDateToTimestamp16 = Converters.dateToTimestamp(podcastEntity.lastUpdateTime);
                    if (lDateToTimestamp16 == null) {
                        sQLiteStatement.bindNull(7);
                    } else {
                        sQLiteStatement.bindLong(7, lDateToTimestamp16.longValue());
                    }
                    String str26 = podcastEntity.libraryAddToken;
                    if (str26 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindText(8, str26);
                    }
                    String str27 = podcastEntity.libraryRemoveToken;
                    if (str27 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindText(9, str27);
                    }
                    sQLiteStatement.bindText(10, str22);
                    break;
                case 15:
                    SongAlbumMap songAlbumMap = (SongAlbumMap) obj;
                    sQLiteStatement.getClass();
                    songAlbumMap.getClass();
                    String str28 = songAlbumMap.songId;
                    sQLiteStatement.bindText(1, str28);
                    String str29 = songAlbumMap.albumId;
                    sQLiteStatement.bindText(2, str29);
                    sQLiteStatement.bindLong(3, songAlbumMap.index);
                    sQLiteStatement.bindText(4, str28);
                    sQLiteStatement.bindText(5, str29);
                    break;
                case 16:
                    LyricsEntity lyricsEntity2 = (LyricsEntity) obj;
                    sQLiteStatement.getClass();
                    lyricsEntity2.getClass();
                    String str30 = lyricsEntity2.id;
                    sQLiteStatement.bindText(1, str30);
                    sQLiteStatement.bindText(2, lyricsEntity2.lyrics);
                    sQLiteStatement.bindText(3, lyricsEntity2.provider);
                    sQLiteStatement.bindText(4, lyricsEntity2.translatedLyrics);
                    sQLiteStatement.bindText(5, lyricsEntity2.translationLanguage);
                    sQLiteStatement.bindText(6, lyricsEntity2.translationMode);
                    sQLiteStatement.bindText(7, str30);
                    break;
                case 17:
                    FormatEntity formatEntity = (FormatEntity) obj;
                    sQLiteStatement.getClass();
                    formatEntity.getClass();
                    String str31 = formatEntity.id;
                    sQLiteStatement.bindText(1, str31);
                    sQLiteStatement.bindLong(2, formatEntity.itag);
                    sQLiteStatement.bindText(3, formatEntity.mimeType);
                    sQLiteStatement.bindText(4, formatEntity.codecs);
                    sQLiteStatement.bindLong(5, formatEntity.bitrate);
                    Integer num5 = formatEntity.sampleRate;
                    if (num5 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindLong(6, num5.intValue());
                    }
                    sQLiteStatement.bindLong(7, formatEntity.contentLength);
                    Double d = formatEntity.loudnessDb;
                    if (d == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindDouble(8, d.doubleValue());
                    }
                    Double d2 = formatEntity.perceptualLoudnessDb;
                    if (d2 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindDouble(9, d2.doubleValue());
                    }
                    String str32 = formatEntity.playbackUrl;
                    if (str32 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindText(10, str32);
                    }
                    sQLiteStatement.bindText(11, str31);
                    break;
                default:
                    SongEntity songEntity3 = (SongEntity) obj;
                    sQLiteStatement.getClass();
                    songEntity3.getClass();
                    String str33 = songEntity3.id;
                    sQLiteStatement.bindText(1, str33);
                    sQLiteStatement.bindText(2, songEntity3.title);
                    sQLiteStatement.bindLong(3, songEntity3.duration);
                    String str34 = songEntity3.thumbnailUrl;
                    if (str34 == null) {
                        sQLiteStatement.bindNull(4);
                    } else {
                        sQLiteStatement.bindText(4, str34);
                    }
                    String str35 = songEntity3.albumId;
                    if (str35 == null) {
                        sQLiteStatement.bindNull(5);
                    } else {
                        sQLiteStatement.bindText(5, str35);
                    }
                    String str36 = songEntity3.albumName;
                    if (str36 == null) {
                        sQLiteStatement.bindNull(6);
                    } else {
                        sQLiteStatement.bindText(6, str36);
                    }
                    sQLiteStatement.bindLong(7, songEntity3.explicit ? 1L : 0L);
                    Integer num6 = songEntity3.year;
                    if (num6 == null) {
                        sQLiteStatement.bindNull(8);
                    } else {
                        sQLiteStatement.bindLong(8, num6.intValue());
                    }
                    Long lDateToTimestamp17 = Converters.dateToTimestamp(songEntity3.date);
                    if (lDateToTimestamp17 == null) {
                        sQLiteStatement.bindNull(9);
                    } else {
                        sQLiteStatement.bindLong(9, lDateToTimestamp17.longValue());
                    }
                    Long lDateToTimestamp18 = Converters.dateToTimestamp(songEntity3.dateModified);
                    if (lDateToTimestamp18 == null) {
                        sQLiteStatement.bindNull(10);
                    } else {
                        sQLiteStatement.bindLong(10, lDateToTimestamp18.longValue());
                    }
                    sQLiteStatement.bindLong(11, songEntity3.liked ? 1L : 0L);
                    Long lDateToTimestamp19 = Converters.dateToTimestamp(songEntity3.likedDate);
                    if (lDateToTimestamp19 == null) {
                        sQLiteStatement.bindNull(12);
                    } else {
                        sQLiteStatement.bindLong(12, lDateToTimestamp19.longValue());
                    }
                    sQLiteStatement.bindLong(13, songEntity3.totalPlayTime);
                    Long lDateToTimestamp20 = Converters.dateToTimestamp(songEntity3.inLibrary);
                    if (lDateToTimestamp20 == null) {
                        sQLiteStatement.bindNull(14);
                    } else {
                        sQLiteStatement.bindLong(14, lDateToTimestamp20.longValue());
                    }
                    Long lDateToTimestamp21 = Converters.dateToTimestamp(songEntity3.dateDownload);
                    if (lDateToTimestamp21 == null) {
                        sQLiteStatement.bindNull(15);
                    } else {
                        sQLiteStatement.bindLong(15, lDateToTimestamp21.longValue());
                    }
                    sQLiteStatement.bindLong(16, songEntity3.isLocal ? 1L : 0L);
                    String str37 = songEntity3.libraryAddToken;
                    if (str37 == null) {
                        sQLiteStatement.bindNull(17);
                    } else {
                        sQLiteStatement.bindText(17, str37);
                    }
                    String str38 = songEntity3.libraryRemoveToken;
                    if (str38 == null) {
                        sQLiteStatement.bindNull(18);
                    } else {
                        sQLiteStatement.bindText(18, str38);
                    }
                    sQLiteStatement.bindLong(19, songEntity3.lyricsOffset);
                    sQLiteStatement.bindLong(20, songEntity3.romanizeLyrics ? 1L : 0L);
                    sQLiteStatement.bindLong(21, songEntity3.isDownloaded ? 1L : 0L);
                    sQLiteStatement.bindLong(22, songEntity3.isUploaded ? 1L : 0L);
                    sQLiteStatement.bindLong(23, songEntity3.isVideo ? 1L : 0L);
                    sQLiteStatement.bindLong(24, songEntity3.isEpisode ? 1L : 0L);
                    Long l2 = songEntity3.playbackPosition;
                    if (l2 == null) {
                        sQLiteStatement.bindNull(25);
                    } else {
                        sQLiteStatement.bindLong(25, l2.longValue());
                    }
                    String str39 = songEntity3.uploadEntityId;
                    if (str39 == null) {
                        sQLiteStatement.bindNull(26);
                    } else {
                        sQLiteStatement.bindText(26, str39);
                    }
                    sQLiteStatement.bindLong(27, songEntity3.isCached ? 1L : 0L);
                    sQLiteStatement.bindText(28, str33);
                    break;
            }
        }

        public void handle(SQLiteConnection sQLiteConnection, Object obj) {
            String str;
            sQLiteConnection.getClass();
            if (obj == null) {
                return;
            }
            switch (this.$r8$classId) {
                case 0:
                    str = "DELETE FROM `song` WHERE `id` = ?";
                    break;
                case 1:
                    str = "DELETE FROM `song_artist_map` WHERE `songId` = ? AND `artistId` = ?";
                    break;
                case 2:
                    str = "DELETE FROM `album` WHERE `id` = ?";
                    break;
                case 3:
                    str = "DELETE FROM `album_artist_map` WHERE `albumId` = ? AND `artistId` = ?";
                    break;
                case 4:
                    str = "DELETE FROM `playlist` WHERE `id` = ?";
                    break;
                case 5:
                    str = "DELETE FROM `playlist_song_map` WHERE `id` = ?";
                    break;
                case 6:
                    str = "DELETE FROM `lyrics` WHERE `id` = ?";
                    break;
                case 7:
                    str = "DELETE FROM `search_history` WHERE `id` = ?";
                    break;
                case 8:
                    str = "DELETE FROM `event` WHERE `id` = ?";
                    break;
                case 9:
                    str = "UPDATE OR ABORT `song` SET `id` = ?,`title` = ?,`duration` = ?,`thumbnailUrl` = ?,`albumId` = ?,`albumName` = ?,`explicit` = ?,`year` = ?,`date` = ?,`dateModified` = ?,`liked` = ?,`likedDate` = ?,`totalPlayTime` = ?,`inLibrary` = ?,`dateDownload` = ?,`isLocal` = ?,`libraryAddToken` = ?,`libraryRemoveToken` = ?,`lyricsOffset` = ?,`romanizeLyrics` = ?,`isDownloaded` = ?,`isUploaded` = ?,`isVideo` = ?,`isEpisode` = ?,`playbackPosition` = ?,`uploadEntityId` = ?,`isCached` = ? WHERE `id` = ?";
                    break;
                case 10:
                    str = "UPDATE OR ABORT `artist` SET `id` = ?,`name` = ?,`thumbnailUrl` = ?,`channelId` = ?,`lastUpdateTime` = ?,`bookmarkedAt` = ?,`isLocal` = ?,`isPodcastChannel` = ?,`cachedPageJson` = ? WHERE `id` = ?";
                    break;
                case 11:
                    str = "UPDATE OR ABORT `album` SET `id` = ?,`playlistId` = ?,`title` = ?,`year` = ?,`thumbnailUrl` = ?,`themeColor` = ?,`songCount` = ?,`duration` = ?,`explicit` = ?,`lastUpdateTime` = ?,`bookmarkedAt` = ?,`likedDate` = ?,`inLibrary` = ?,`isLocal` = ?,`isUploaded` = ? WHERE `id` = ?";
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    str = "UPDATE OR ABORT `playlist` SET `id` = ?,`name` = ?,`browseId` = ?,`createdAt` = ?,`lastUpdateTime` = ?,`isEditable` = ?,`bookmarkedAt` = ?,`remoteSongCount` = ?,`playEndpointParams` = ?,`thumbnailUrl` = ?,`shuffleEndpointParams` = ?,`radioEndpointParams` = ?,`isLocal` = ?,`isAutoSync` = ? WHERE `id` = ?";
                    break;
                case 13:
                    str = "UPDATE OR ABORT `playlist_song_map` SET `id` = ?,`playlistId` = ?,`songId` = ?,`position` = ?,`setVideoId` = ? WHERE `id` = ?";
                    break;
                case 14:
                    str = "UPDATE OR ABORT `podcast` SET `id` = ?,`title` = ?,`author` = ?,`thumbnailUrl` = ?,`channelId` = ?,`bookmarkedAt` = ?,`lastUpdateTime` = ?,`libraryAddToken` = ?,`libraryRemoveToken` = ? WHERE `id` = ?";
                    break;
                case 15:
                    str = "UPDATE `song_album_map` SET `songId` = ?,`albumId` = ?,`index` = ? WHERE `songId` = ? AND `albumId` = ?";
                    break;
                case 16:
                    str = "UPDATE `lyrics` SET `id` = ?,`lyrics` = ?,`provider` = ?,`translatedLyrics` = ?,`translationLanguage` = ?,`translationMode` = ? WHERE `id` = ?";
                    break;
                case 17:
                    str = "UPDATE `format` SET `id` = ?,`itag` = ?,`mimeType` = ?,`codecs` = ?,`bitrate` = ?,`sampleRate` = ?,`contentLength` = ?,`loudnessDb` = ?,`perceptualLoudnessDb` = ?,`playbackUrl` = ? WHERE `id` = ?";
                    break;
                default:
                    str = "UPDATE `song` SET `id` = ?,`title` = ?,`duration` = ?,`thumbnailUrl` = ?,`albumId` = ?,`albumName` = ?,`explicit` = ?,`year` = ?,`date` = ?,`dateModified` = ?,`liked` = ?,`likedDate` = ?,`totalPlayTime` = ?,`inLibrary` = ?,`dateDownload` = ?,`isLocal` = ?,`libraryAddToken` = ?,`libraryRemoveToken` = ?,`lyricsOffset` = ?,`romanizeLyrics` = ?,`isDownloaded` = ?,`isUploaded` = ?,`isVideo` = ?,`isEpisode` = ?,`playbackPosition` = ?,`uploadEntityId` = ?,`isCached` = ? WHERE `id` = ?";
                    break;
            }
            SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
            try {
                bind(sQLiteStatementPrepare, obj);
                sQLiteStatementPrepare.step();
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
                MathKt.getTotalChangedRows(sQLiteConnection);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        }

        public /* synthetic */ AnonymousClass17(DatabaseDao_Impl databaseDao_Impl, byte b) {
            this.$r8$classId = b;
        }
    }

    public final void delete(SongArtistMap songArtistMap) {
        songArtistMap.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda54(this, songArtistMap, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(AlbumEntity albumEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda26(this, albumEntity, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(LyricsEntity lyricsEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda22(this, lyricsEntity, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(PlaylistEntity playlistEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda71(this, playlistEntity, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(ArtistEntity artistEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda60(this, artistEntity, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(FormatEntity formatEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, formatEntity, (byte) 19));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(PlaylistSongMap playlistSongMap) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda2(this, playlistSongMap, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(AlbumEntity albumEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda26(this, albumEntity, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void upsert(SongEntity songEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda19(this, songEntity, (byte) 3));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(LyricsEntity lyricsEntity) {
        lyricsEntity.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda22(this, lyricsEntity, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(RecognitionHistory recognitionHistory) {
        return ((Number) AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, recognitionHistory, (byte) 15))).longValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PlaylistEntity playlistEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda71(this, playlistEntity, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(SearchHistory searchHistory) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda18(this, searchHistory, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PlaylistSongMap playlistSongMap) {
        playlistSongMap.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda2(this, playlistSongMap, (byte) 2));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistsByCreateDateAsc(final int i, final int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new Function1(i, i2, this) { // from class: com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda73
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) throws Exception {
                int i3 = this.f$1;
                int i4 = this.f$2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE songCount > 0 ORDER BY rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, i3);
                    sQLiteStatementPrepare.bindLong(2, i4);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        int i5 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                        String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        int i6 = columnIndexOrThrow2;
                        int i7 = columnIndexOrThrow3;
                        int i8 = columnIndexOrThrow4;
                        arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i5, null));
                        columnIndexOrThrow4 = i8;
                        columnIndexOrThrow3 = i7;
                        columnIndexOrThrow2 = i6;
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            }
        }, anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(ArtistEntity artistEntity) {
        artistEntity.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda60(this, artistEntity, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda69(i, i2, this, (byte) 0), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void delete(Event event) {
        event.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda20(this, event, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.C01651 c01651) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda69(i, i2, this, (byte) 1), c01651);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(PodcastEntity podcastEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda85(this, podcastEntity, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(AlbumEntity albumEntity) {
        return ((Number) AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda26(this, albumEntity, (byte) 0))).longValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(final Song song, final MediaMetadata mediaMetadata, final boolean z, final boolean z2) {
        AnonymousClass17.performBlocking(this.__db, false, true, new Function1() { // from class: com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ((SQLiteConnection) obj).getClass();
                SongEntity songEntity = song.song;
                MediaMetadata mediaMetadata2 = mediaMetadata;
                List list = mediaMetadata2.artists;
                String str = z ? mediaMetadata2.title : songEntity.title;
                int i = mediaMetadata2.duration;
                String str2 = str;
                String str3 = mediaMetadata2.thumbnailUrl;
                MediaMetadata.Album album = mediaMetadata2.album;
                SongEntity songEntityCopy$default = SongEntity.copy$default(songEntity, str2, i, str3, album != null ? album.id : null, album != null ? album.title : null, false, null, null, null, mediaMetadata2.libraryAddToken, mediaMetadata2.libraryRemoveToken, 0, false, false, false, null, 134021057);
                DatabaseDao_Impl databaseDao_Impl = this.f$0;
                databaseDao_Impl.update(songEntityCopy$default);
                if (z2 && !list.isEmpty()) {
                    Iterator it = databaseDao_Impl.songArtistMap(songEntity.id).iterator();
                    while (it.hasNext()) {
                        databaseDao_Impl.delete((SongArtistMap) it.next());
                    }
                    int i2 = 0;
                    for (Object obj2 : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        MediaMetadata.Artist artist = (MediaMetadata.Artist) obj2;
                        String strGenerateLocalId = artist.id;
                        if (strGenerateLocalId == null) {
                            ArtistEntity artistEntityArtistByName = databaseDao_Impl.artistByName(artist.name);
                            strGenerateLocalId = artistEntityArtistByName != null ? artistEntityArtistByName.id : null;
                            if (strGenerateLocalId == null) {
                                strGenerateLocalId = CollectionsKt__IterablesKt.generateLocalId("LA");
                            }
                        }
                        String str4 = strGenerateLocalId;
                        databaseDao_Impl.insert(new ArtistEntity(str4, artist.name, null, artist.id, null, false, null, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION));
                        databaseDao_Impl.insert(new SongArtistMap(songEntity.id, str4, i2));
                        i2 = i3;
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(PlaylistEntity playlistEntity) {
        playlistEntity.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda71(this, playlistEntity, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(SongEntity songEntity) {
        songEntity.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda19(this, songEntity, (byte) 1));
    }

    public final void insert(SongArtistMap songArtistMap) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda54(this, songArtistMap, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void update(AlbumEntity albumEntity, AlbumPage albumPage, List list) {
        albumEntity.getClass();
        albumPage.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MainActivity$$ExternalSyntheticLambda21(this, albumEntity, albumPage, list));
    }

    public final void insert(AlbumArtistMap albumArtistMap) {
        albumArtistMap.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda120(this, albumArtistMap, (byte) 0));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object songsByCreateDateAsc(int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda69(i, i2, this, (byte) 3), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(PlaylistSongMap playlistSongMap) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda2(this, playlistSongMap, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object albumSongs(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda88(str, i, i2, this, (byte) 1), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object artistSongsByCreateDateAsc(String str, int i, int i2, MediaLibrarySessionCallback.AnonymousClass1 anonymousClass1) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda88(str, i, i2, this, (byte) 0), anonymousClass1);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(SearchHistory searchHistory) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda18(this, searchHistory, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(Event event) {
        AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda20(this, event, (byte) 1));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final Object playlistSongs(String str, int i, int i2, MediaLibrarySessionCallback.C01641 c01641) {
        return AnonymousClass17.performSuspending(this.__db, true, true, new DatabaseDao_Impl$$ExternalSyntheticLambda88(str, i, i2, this, (byte) 2), c01641);
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(RelatedSongMap relatedSongMap) {
        relatedSongMap.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, relatedSongMap, (byte) 12));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(SetVideoIdEntity setVideoIdEntity) {
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, setVideoIdEntity, (byte) 11));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final long insert(PodcastEntity podcastEntity) {
        return ((Number) AnonymousClass17.performBlocking(this.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda85(this, podcastEntity, (byte) 1))).longValue();
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(MediaMetadata mediaMetadata, Function1 function1) {
        mediaMetadata.getClass();
        function1.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new MainActivity$$ExternalSyntheticLambda21((Object) this, (Object) mediaMetadata, (Object) function1, (byte) 7));
    }

    @Override // com.metrolist.music.db.DatabaseDao
    public final void insert(AlbumPage albumPage) {
        albumPage.getClass();
        AnonymousClass17.performBlocking(this.__db, false, true, new QuickJs$$ExternalSyntheticLambda1(this, albumPage, (byte) 18));
    }
}
