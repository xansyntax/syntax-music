package com.dokar.quickjs;

import android.content.Intent;
import android.database.SQLException;
import android.graphics.Typeface;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.font.AsyncFontListLoader;
import androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult;
import androidx.compose.ui.text.font.DefaultFontFamily;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.compose.ui.text.font.TypefaceRequest;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$5$0$$inlined$onDispose$1;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.core.util.Consumer;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.analytics.PlaybackStats;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.materialkolor.DynamicMaterialThemeState;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.music.MainActivity;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda30;
import com.metrolist.music.MainActivity$MetrolistApp$lambda$23$2$1$25$0$$inlined$onDispose$1;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.daos.SpeedDialDao_Impl;
import com.metrolist.music.db.entities.AlbumArtistMap;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlayCountEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.RelatedSongMap;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongAlbumMap;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda50;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.SyncOperation;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.sequences.SequencesKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.ReorderableLazyListState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QuickJs$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ QuickJs$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:274:0x0774  */
    /* JADX WARN: Code duplicated, block: B:277:0x0785  */
    /* JADX WARN: Code duplicated, block: B:279:0x0794  */
    /* JADX WARN: Code duplicated, block: B:301:0x07e0  */
    /* JADX WARN: Code duplicated, block: B:304:0x07f1  */
    /* JADX WARN: Code duplicated, block: B:306:0x0800  */
    /* JADX WARN: Code duplicated, block: B:329:0x0850  */
    /* JADX WARN: Code duplicated, block: B:332:0x0861  */
    /* JADX WARN: Code duplicated, block: B:334:0x0870  */
    /* JADX WARN: Code duplicated, block: B:338:0x087c  */
    /* JADX WARN: Code duplicated, block: B:340:0x0887  */
    /* JADX WARN: Code duplicated, block: B:345:0x089c  */
    /* JADX WARN: Code duplicated, block: B:347:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:348:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:350:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:351:0x08b0  */
    /* JADX WARN: Code duplicated, block: B:353:0x08b6  */
    /* JADX WARN: Code duplicated, block: B:354:0x08b8  */
    /* JADX WARN: Code duplicated, block: B:356:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:361:0x08c9  */
    /* JADX WARN: Code duplicated, block: B:364:0x08da  */
    /* JADX WARN: Code duplicated, block: B:366:0x08e9  */
    /* JADX WARN: Code duplicated, block: B:419:0x09e2  */
    /* JADX WARN: Code duplicated, block: B:420:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:487:0x0797 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x0803 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x0873 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:507:0x08c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x08ec A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        Pair pair;
        Continuation continuation;
        Object async;
        Object objInvoke;
        Object objInvoke2;
        int size;
        int i;
        FontWeight fontWeight;
        int size2;
        FontWeight fontWeight2;
        FontWeight fontWeight3;
        int i2;
        int size3;
        int i3;
        Object obj2;
        FontWeight fontWeight4;
        int i4;
        Object obj3;
        int size4;
        int i5;
        Object obj4;
        int size5;
        int i6;
        Object obj5;
        Typeface typefaceMo755createDefaultFO1MlWM;
        Object immutable;
        Lifecycle lifecycle;
        Object failure;
        ExoPlayerImpl playerSafe;
        boolean z;
        byte b = 10;
        byte b2 = 0;
        int i7 = 0;
        int i8 = 0;
        byte b3 = 1;
        switch (this.$r8$classId) {
            case 0:
                QuickJs.invokeAsyncFunction$lambda$1((QuickJs) this.f$0, (StandaloneCoroutine) this.f$1, (Throwable) obj);
                return Unit.INSTANCE;
            case 1:
                FontFamilyResolverImpl fontFamilyResolverImpl = (FontFamilyResolverImpl) this.f$0;
                TypefaceRequest typefaceRequest = (TypefaceRequest) this.f$1;
                Function1 function1 = (Function1) obj;
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter;
                NavContext navContext = fontFamilyResolverImpl.platformFontLoader;
                DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = fontFamilyResolverImpl.createDefaultTypeface;
                FontFamily fontFamily = typefaceRequest.fontFamily;
                if (fontFamily instanceof FontListFontFamily) {
                    List list = ((FontListFontFamily) fontFamily).fonts;
                    FontWeight fontWeight5 = typefaceRequest.fontWeight;
                    int i9 = typefaceRequest.fontStyle;
                    ArrayList arrayList = new ArrayList(list.size());
                    int size6 = list.size();
                    for (int i10 = 0; i10 < size6; i10++) {
                        Object obj6 = list.get(i10);
                        ResourceFont resourceFont = (ResourceFont) obj6;
                        if (Intrinsics.areEqual(resourceFont.weight, fontWeight5) && resourceFont.style == i9) {
                            arrayList.add(obj6);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(list.size());
                        int size7 = list.size();
                        for (int i11 = 0; i11 < size7; i11++) {
                            Object obj7 = list.get(i11);
                            if (((ResourceFont) obj7).style == i9) {
                                arrayList2.add(obj7);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            list = arrayList2;
                        }
                        int iCompareTo = fontWeight5.compareTo(FontWeight.W400);
                        int i12 = fontWeight5.weight;
                        if (iCompareTo < 0) {
                            int size8 = list.size();
                            FontWeight fontWeight6 = null;
                            FontWeight fontWeight7 = null;
                            for (int i13 = 0; i13 < size8; i13++) {
                                FontWeight fontWeight8 = ((ResourceFont) list.get(i13)).weight;
                                int i14 = fontWeight8.weight;
                                if (Intrinsics.compare(i14, i12) < 0) {
                                    if (fontWeight6 == null || Intrinsics.compare(i14, fontWeight6.weight) > 0) {
                                        fontWeight6 = fontWeight8;
                                    }
                                } else if (Intrinsics.compare(i14, i12) <= 0) {
                                    fontWeight6 = fontWeight8;
                                    fontWeight7 = fontWeight6;
                                    if (fontWeight6 == null) {
                                        fontWeight6 = fontWeight7;
                                    }
                                    arrayList = new ArrayList(list.size());
                                    size5 = list.size();
                                    for (i6 = 0; i6 < size5; i6++) {
                                        obj5 = list.get(i6);
                                        if (Intrinsics.areEqual(((ResourceFont) obj5).weight, fontWeight6)) {
                                            arrayList.add(obj5);
                                        }
                                    }
                                } else if (fontWeight7 == null || Intrinsics.compare(i14, fontWeight7.weight) < 0) {
                                    fontWeight7 = fontWeight8;
                                }
                            }
                            if (fontWeight6 == null) {
                                fontWeight6 = fontWeight7;
                            }
                            arrayList = new ArrayList(list.size());
                            size5 = list.size();
                            while (i6 < size5) {
                                obj5 = list.get(i6);
                                if (Intrinsics.areEqual(((ResourceFont) obj5).weight, fontWeight6)) {
                                    arrayList.add(obj5);
                                }
                            }
                        } else {
                            FontWeight fontWeight9 = FontWeight.W500;
                            if (fontWeight5.compareTo(fontWeight9) > 0) {
                                int size9 = list.size();
                                FontWeight fontWeight10 = null;
                                FontWeight fontWeight11 = null;
                                for (int i15 = 0; i15 < size9; i15++) {
                                    FontWeight fontWeight12 = ((ResourceFont) list.get(i15)).weight;
                                    int i16 = fontWeight12.weight;
                                    if (Intrinsics.compare(i16, i12) < 0) {
                                        if (fontWeight10 == null || Intrinsics.compare(i16, fontWeight10.weight) > 0) {
                                            fontWeight10 = fontWeight12;
                                        }
                                    } else if (Intrinsics.compare(i16, i12) <= 0) {
                                        fontWeight10 = fontWeight12;
                                        fontWeight11 = fontWeight10;
                                        if (fontWeight11 != null) {
                                            fontWeight10 = fontWeight11;
                                        }
                                        arrayList = new ArrayList(list.size());
                                        size4 = list.size();
                                        for (i5 = 0; i5 < size4; i5++) {
                                            obj4 = list.get(i5);
                                            if (Intrinsics.areEqual(((ResourceFont) obj4).weight, fontWeight10)) {
                                                arrayList.add(obj4);
                                            }
                                        }
                                    } else if (fontWeight11 == null || Intrinsics.compare(i16, fontWeight11.weight) < 0) {
                                        fontWeight11 = fontWeight12;
                                    }
                                }
                                if (fontWeight11 != null) {
                                    fontWeight10 = fontWeight11;
                                }
                                arrayList = new ArrayList(list.size());
                                size4 = list.size();
                                while (i5 < size4) {
                                    obj4 = list.get(i5);
                                    if (Intrinsics.areEqual(((ResourceFont) obj4).weight, fontWeight10)) {
                                        arrayList.add(obj4);
                                    }
                                }
                            } else {
                                int size10 = list.size();
                                FontWeight fontWeight13 = null;
                                FontWeight fontWeight14 = null;
                                for (int i17 = 0; i17 < size10; i17++) {
                                    FontWeight fontWeight15 = ((ResourceFont) list.get(i17)).weight;
                                    if (Intrinsics.compare(fontWeight15.weight, fontWeight9.weight) <= 0) {
                                        int i18 = fontWeight15.weight;
                                        if (Intrinsics.compare(i18, i12) < 0) {
                                            if (fontWeight13 == null || Intrinsics.compare(i18, fontWeight13.weight) > 0) {
                                                fontWeight13 = fontWeight15;
                                            }
                                        } else if (Intrinsics.compare(i18, i12) <= 0) {
                                            fontWeight13 = fontWeight15;
                                            fontWeight14 = fontWeight13;
                                            if (fontWeight14 != null) {
                                                fontWeight13 = fontWeight14;
                                            }
                                            arrayList = new ArrayList(list.size());
                                            size = list.size();
                                            for (i = 0; i < size; i++) {
                                                obj3 = list.get(i);
                                                if (Intrinsics.areEqual(((ResourceFont) obj3).weight, fontWeight13)) {
                                                    arrayList.add(obj3);
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                                fontWeight = FontWeight.W500;
                                                size2 = list.size();
                                                fontWeight2 = null;
                                                fontWeight3 = null;
                                                for (i2 = 0; i2 < size2; i2++) {
                                                    fontWeight4 = ((ResourceFont) list.get(i2)).weight;
                                                    if (fontWeight != null || Intrinsics.compare(fontWeight4.weight, fontWeight.weight) >= 0) {
                                                        i4 = fontWeight4.weight;
                                                        if (Intrinsics.compare(i4, i12) < 0) {
                                                            if (fontWeight2 != null || Intrinsics.compare(i4, fontWeight2.weight) > 0) {
                                                                fontWeight2 = fontWeight4;
                                                            }
                                                        } else if (Intrinsics.compare(i4, i12) <= 0) {
                                                            fontWeight2 = fontWeight4;
                                                            fontWeight3 = fontWeight2;
                                                            if (fontWeight3 != null) {
                                                                fontWeight2 = fontWeight3;
                                                            }
                                                            arrayList = new ArrayList(list.size());
                                                            size3 = list.size();
                                                            for (i3 = 0; i3 < size3; i3++) {
                                                                obj2 = list.get(i3);
                                                                if (Intrinsics.areEqual(((ResourceFont) obj2).weight, fontWeight2)) {
                                                                    arrayList.add(obj2);
                                                                }
                                                            }
                                                        } else if (fontWeight3 != null || Intrinsics.compare(i4, fontWeight3.weight) < 0) {
                                                            fontWeight3 = fontWeight4;
                                                        }
                                                    }
                                                }
                                                if (fontWeight3 != null) {
                                                    fontWeight2 = fontWeight3;
                                                }
                                                arrayList = new ArrayList(list.size());
                                                size3 = list.size();
                                                while (i3 < size3) {
                                                    obj2 = list.get(i3);
                                                    if (Intrinsics.areEqual(((ResourceFont) obj2).weight, fontWeight2)) {
                                                        arrayList.add(obj2);
                                                    }
                                                }
                                            }
                                        } else if (fontWeight14 == null || Intrinsics.compare(i18, fontWeight14.weight) < 0) {
                                            fontWeight14 = fontWeight15;
                                        }
                                    }
                                }
                                if (fontWeight14 != null) {
                                    fontWeight13 = fontWeight14;
                                }
                                arrayList = new ArrayList(list.size());
                                size = list.size();
                                while (i < size) {
                                    obj3 = list.get(i);
                                    if (Intrinsics.areEqual(((ResourceFont) obj3).weight, fontWeight13)) {
                                        arrayList.add(obj3);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    fontWeight = FontWeight.W500;
                                    size2 = list.size();
                                    fontWeight2 = null;
                                    fontWeight3 = null;
                                    while (i2 < size2) {
                                        fontWeight4 = ((ResourceFont) list.get(i2)).weight;
                                        if (fontWeight != null) {
                                            i4 = fontWeight4.weight;
                                            if (Intrinsics.compare(i4, i12) < 0) {
                                                if (fontWeight2 != null) {
                                                    fontWeight2 = fontWeight4;
                                                } else {
                                                    fontWeight2 = fontWeight4;
                                                }
                                            } else if (Intrinsics.compare(i4, i12) <= 0) {
                                                fontWeight2 = fontWeight4;
                                                fontWeight3 = fontWeight2;
                                                if (fontWeight3 != null) {
                                                    fontWeight2 = fontWeight3;
                                                }
                                                arrayList = new ArrayList(list.size());
                                                size3 = list.size();
                                                while (i3 < size3) {
                                                    obj2 = list.get(i3);
                                                    if (Intrinsics.areEqual(((ResourceFont) obj2).weight, fontWeight2)) {
                                                        arrayList.add(obj2);
                                                    }
                                                }
                                            } else if (fontWeight3 != null) {
                                                fontWeight3 = fontWeight4;
                                            } else {
                                                fontWeight3 = fontWeight4;
                                            }
                                        } else {
                                            i4 = fontWeight4.weight;
                                            if (Intrinsics.compare(i4, i12) < 0) {
                                                if (fontWeight2 != null) {
                                                    fontWeight2 = fontWeight4;
                                                } else {
                                                    fontWeight2 = fontWeight4;
                                                }
                                            } else if (Intrinsics.compare(i4, i12) <= 0) {
                                                fontWeight2 = fontWeight4;
                                                fontWeight3 = fontWeight2;
                                                if (fontWeight3 != null) {
                                                    fontWeight2 = fontWeight3;
                                                }
                                                arrayList = new ArrayList(list.size());
                                                size3 = list.size();
                                                while (i3 < size3) {
                                                    obj2 = list.get(i3);
                                                    if (Intrinsics.areEqual(((ResourceFont) obj2).weight, fontWeight2)) {
                                                        arrayList.add(obj2);
                                                    }
                                                }
                                            } else if (fontWeight3 != null) {
                                                fontWeight3 = fontWeight4;
                                            } else {
                                                fontWeight3 = fontWeight4;
                                            }
                                        }
                                    }
                                    if (fontWeight3 != null) {
                                        fontWeight2 = fontWeight3;
                                    }
                                    arrayList = new ArrayList(list.size());
                                    size3 = list.size();
                                    while (i3 < size3) {
                                        obj2 = list.get(i3);
                                        if (Intrinsics.areEqual(((ResourceFont) obj2).weight, fontWeight2)) {
                                            arrayList.add(obj2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    EmojiProcessor emojiProcessor = fontListFontFamilyTypefaceAdapter.asyncTypefaceCache;
                    if (arrayList.size() > 0) {
                        final ResourceFont resourceFont2 = (ResourceFont) arrayList.get(0);
                        resourceFont2.getClass();
                        synchronized (((Lock) emojiProcessor.mGlyphChecker)) {
                            try {
                                Object obj8 = new Object(resourceFont2) { // from class: androidx.compose.ui.text.font.AsyncTypefaceCache$Key
                                    public final ResourceFont font;

                                    {
                                        this.font = resourceFont2;
                                    }

                                    public final boolean equals(Object obj9) {
                                        if (this == obj9) {
                                            return true;
                                        }
                                        return (obj9 instanceof AsyncTypefaceCache$Key) && Intrinsics.areEqual(this.font, ((AsyncTypefaceCache$Key) obj9).font);
                                    }

                                    public final int hashCode() {
                                        return this.font.hashCode() * 31;
                                    }

                                    public final String toString() {
                                        return "Key(font=" + this.font + ", loaderKey=null)";
                                    }
                                };
                                AsyncTypefaceCache$AsyncTypefaceResult asyncTypefaceCache$AsyncTypefaceResult = (AsyncTypefaceCache$AsyncTypefaceResult) ((LruCache) emojiProcessor.mSpanFactory).get(obj8);
                                if (asyncTypefaceCache$AsyncTypefaceResult == null) {
                                    asyncTypefaceCache$AsyncTypefaceResult = (AsyncTypefaceCache$AsyncTypefaceResult) ((MutableScatterMap) emojiProcessor.mMetadataRepo).get(obj8);
                                }
                                if (asyncTypefaceCache$AsyncTypefaceResult != null) {
                                    objInvoke2 = asyncTypefaceCache$AsyncTypefaceResult.result;
                                } else {
                                    try {
                                        objInvoke = navContext.loadBlocking(resourceFont2);
                                    } catch (Exception unused) {
                                        objInvoke = diskLruCache$$ExternalSyntheticLambda0.invoke(typefaceRequest);
                                    }
                                    emojiProcessor.getClass();
                                    Object obj9 = new Object(resourceFont2) { // from class: androidx.compose.ui.text.font.AsyncTypefaceCache$Key
                                        public final ResourceFont font;

                                        {
                                            this.font = resourceFont2;
                                        }

                                        public final boolean equals(Object obj10) {
                                            if (this == obj10) {
                                                return true;
                                            }
                                            return (obj10 instanceof AsyncTypefaceCache$Key) && Intrinsics.areEqual(this.font, ((AsyncTypefaceCache$Key) obj10).font);
                                        }

                                        public final int hashCode() {
                                            return this.font.hashCode() * 31;
                                        }

                                        public final String toString() {
                                            return "Key(font=" + this.font + ", loaderKey=null)";
                                        }
                                    };
                                    synchronized (((Lock) emojiProcessor.mGlyphChecker)) {
                                        try {
                                            if (objInvoke == null) {
                                                ((MutableScatterMap) emojiProcessor.mMetadataRepo).set(obj9, new AsyncTypefaceCache$AsyncTypefaceResult(null));
                                            } else {
                                                ((LruCache) emojiProcessor.mSpanFactory).put(obj9, new AsyncTypefaceCache$AsyncTypefaceResult(objInvoke));
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                        break;
                                    }
                                    objInvoke2 = objInvoke;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        if (objInvoke2 == null) {
                            objInvoke2 = diskLruCache$$ExternalSyntheticLambda0.invoke(typefaceRequest);
                        }
                        pair = new Pair(null, IntMath.m904synthesizeTypefaceFxwP2eA(typefaceRequest.fontSynthesis, objInvoke2, resourceFont2, typefaceRequest.fontWeight, typefaceRequest.fontStyle));
                    } else {
                        pair = new Pair(null, diskLruCache$$ExternalSyntheticLambda0.invoke(typefaceRequest));
                    }
                    List list2 = (List) pair.first;
                    Object obj10 = pair.second;
                    if (list2 == null) {
                        async = new TypefaceResult.Immutable(obj10, true);
                        continuation = null;
                    } else {
                        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list2, obj10, typefaceRequest, fontListFontFamilyTypefaceAdapter.asyncTypefaceCache, function1, navContext);
                        continuation = null;
                        AwaitKt.launch$default(fontListFontFamilyTypefaceAdapter.asyncLoadScope, null, CoroutineStart.UNDISPATCHED, new SyncUtils.AnonymousClass2(asyncFontListLoader, continuation, (byte) 14), 1);
                        async = new TypefaceResult.Async(asyncFontListLoader);
                    }
                } else {
                    async = null;
                    continuation = null;
                }
                if (async != null) {
                    return async;
                }
                PlatformTypefaces platformTypefaces = (PlatformTypefaces) fontFamilyResolverImpl.platformFamilyTypefaceAdapter.block;
                FontFamily fontFamily2 = typefaceRequest.fontFamily;
                int i19 = typefaceRequest.fontStyle;
                FontWeight fontWeight16 = typefaceRequest.fontWeight;
                if (fontFamily2 != null && !(fontFamily2 instanceof DefaultFontFamily)) {
                    if (fontFamily2 instanceof GenericFontFamily) {
                        typefaceMo755createDefaultFO1MlWM = platformTypefaces.mo756createNamedRetOiIg((GenericFontFamily) fontFamily2, fontWeight16, i19);
                    } else {
                        immutable = continuation;
                    }
                    if (immutable != null) {
                        return immutable;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not load font");
                    return continuation;
                }
                typefaceMo755createDefaultFO1MlWM = platformTypefaces.mo755createDefaultFO1MlWM(fontWeight16, i19);
                immutable = new TypefaceResult.Immutable(typefaceMo755createDefaultFO1MlWM, true);
                if (immutable != null) {
                    return immutable;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not load font");
                return continuation;
            case 2:
                WeakCache weakCache = (WeakCache) this.f$0;
                TypefaceRequest typefaceRequest2 = (TypefaceRequest) this.f$1;
                TypefaceResult typefaceResult = (TypefaceResult) obj;
                synchronized (((Lock) weakCache.values)) {
                    try {
                        boolean cacheable = typefaceResult.getCacheable();
                        LruCache lruCache = (LruCache) weakCache.referenceQueue;
                        if (cacheable) {
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return Unit.INSTANCE;
            case 3:
                ((LayoutNode) this.f$0).setModifier(((Modifier) obj).then((Modifier) this.f$1));
                return Unit.INSTANCE;
            case 4:
                PopupLayout popupLayout = (PopupLayout) this.f$0;
                popupLayout.setPositionProvider((PopupPositionProvider) this.f$1);
                popupLayout.updatePosition();
                return new AndroidPopup_androidKt$Popup$lambda$5$0$$inlined$onDispose$1();
            case 5:
                NavDestination navDestination = (NavDestination) this.f$0;
                NavControllerImpl navControllerImpl = ((NavHostController) this.f$1).impl;
                NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
                navOptionsBuilder.getClass();
                NavOptions.Builder builder = navOptionsBuilder.builder;
                builder.enterAnim = 0;
                builder.exitAnim = 0;
                if (navDestination instanceof NavGraph) {
                    int i20 = NavDestination.$r8$clinit;
                    for (NavDestination navDestination2 : FileSystemsKt.getHierarchy(navDestination)) {
                        NavDestination currentDestination$navigation_runtime_release = navControllerImpl.getCurrentDestination$navigation_runtime_release();
                        if (Intrinsics.areEqual(navDestination2, currentDestination$navigation_runtime_release != null ? currentDestination$navigation_runtime_release.parent : null)) {
                        }
                    }
                    int i21 = NavGraph.$r8$clinit;
                    navOptionsBuilder.popUpToId = ((NavDestination) SequencesKt.last(SequencesKt.generateSequence(navControllerImpl.getGraph$navigation_runtime_release(), new RoomDatabase$$ExternalSyntheticLambda2(b)))).impl.size;
                    navOptionsBuilder.inclusive = false;
                    navOptionsBuilder.saveState = true;
                }
                return Unit.INSTANCE;
            case 6:
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1((State) this.f$0, (ComposeNavigator) this.f$1, (byte) 11);
            case 7:
                NavHostController navHostController = (NavHostController) this.f$0;
                LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f$1;
                navHostController.getClass();
                lifecycleOwner.getClass();
                NavControllerImpl navControllerImpl2 = navHostController.impl;
                NavControllerImpl$$ExternalSyntheticLambda3 navControllerImpl$$ExternalSyntheticLambda3 = navControllerImpl2.lifecycleObserver;
                if (!lifecycleOwner.equals(navControllerImpl2.lifecycleOwner)) {
                    LifecycleOwner lifecycleOwner2 = navControllerImpl2.lifecycleOwner;
                    if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
                        lifecycle.removeObserver(navControllerImpl$$ExternalSyntheticLambda3);
                    }
                    navControllerImpl2.lifecycleOwner = lifecycleOwner;
                    lifecycleOwner.getLifecycle().addObserver(navControllerImpl$$ExternalSyntheticLambda3);
                }
                return new NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1();
            case 8:
                Function2 function2 = (Function2) this.f$0;
                DynamicMaterialThemeState dynamicMaterialThemeState = (DynamicMaterialThemeState) this.f$1;
                ColorScheme colorScheme = (ColorScheme) obj;
                colorScheme.getClass();
                return (ColorScheme) function2.invoke(dynamicMaterialThemeState, colorScheme);
            case 9:
                PlayerConnection playerConnection = (PlayerConnection) this.f$0;
                final BottomSheetState bottomSheetState = (BottomSheetState) this.f$1;
                int i22 = MainActivity.$r8$clinit;
                ((DisposableEffectScope) obj).getClass();
                if (playerConnection != null) {
                    try {
                        playerSafe = playerConnection.getPlayerSafe();
                    } catch (Throwable th4) {
                        failure = new Result.Failure(th4);
                    }
                    break;
                } else {
                    playerSafe = null;
                }
                failure = playerSafe;
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) (failure instanceof Result.Failure ? null : failure);
                if (exoPlayerImpl == null) {
                    return new MainActivity$MetrolistApp$lambda$23$2$1$25$0$$inlined$onDispose$1();
                }
                Player.Listener listener = new Player.Listener() { // from class: com.metrolist.music.MainActivity$MetrolistApp$6$1$1$6$1$listener$1
                    @Override // androidx.media3.common.Player.Listener
                    public final void onMediaItemTransition(int i23, MediaItem mediaItem) {
                        if (i23 != 3 || mediaItem == null) {
                            return;
                        }
                        BottomSheetState bottomSheetState2 = bottomSheetState;
                        if (bottomSheetState2.isDismissed()) {
                            bottomSheetState2.collapseSoft();
                        }
                    }
                };
                exoPlayerImpl.listeners.add(listener);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(exoPlayerImpl, listener, (byte) 12);
            case 10:
                final MainActivity mainActivity = (MainActivity) this.f$0;
                final NavHostController navHostController2 = (NavHostController) this.f$1;
                int i23 = MainActivity.$r8$clinit;
                ((DisposableEffectScope) obj).getClass();
                Consumer consumer = new Consumer() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda41
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj11) {
                        Intent intent = (Intent) obj11;
                        int i24 = MainActivity.$r8$clinit;
                        intent.getClass();
                        NavHostController navHostController3 = navHostController2;
                        MainActivity.handleWidgetTargetIntent(intent, navHostController3);
                        MainActivity.handleRecognitionIntent(intent, navHostController3);
                        mainActivity.handleDeepLinkIntent(intent, navHostController3);
                    }
                };
                mainActivity.addOnNewIntentListener(consumer);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(mainActivity, consumer, (byte) 13);
            case 11:
                DatabaseDao_Impl databaseDao_Impl = (DatabaseDao_Impl) this.f$0;
                SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) this.f$1;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                databaseDao_Impl.__insertAdapterOfSetVideoIdEntity.insert(sQLiteConnection, setVideoIdEntity);
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DatabaseDao_Impl databaseDao_Impl2 = (DatabaseDao_Impl) this.f$0;
                RelatedSongMap relatedSongMap = (RelatedSongMap) this.f$1;
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                databaseDao_Impl2.__insertAdapterOfRelatedSongMap.insert(sQLiteConnection2, relatedSongMap);
                return Unit.INSTANCE;
            case 13:
                DatabaseDao_Impl databaseDao_Impl3 = (DatabaseDao_Impl) this.f$0;
                PlayCountEntity playCountEntity = (PlayCountEntity) this.f$1;
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                return Long.valueOf(databaseDao_Impl3.__insertAdapterOfPlayCountEntity.insertAndReturnId(sQLiteConnection3, playCountEntity));
            case 14:
                DatabaseDao_Impl databaseDao_Impl4 = (DatabaseDao_Impl) this.f$0;
                SongAlbumMap songAlbumMap = (SongAlbumMap) this.f$1;
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                databaseDao_Impl4.__upsertAdapterOfSongAlbumMap.upsert(sQLiteConnection4, songAlbumMap);
                return Unit.INSTANCE;
            case 15:
                DatabaseDao_Impl databaseDao_Impl5 = (DatabaseDao_Impl) this.f$0;
                RecognitionHistory recognitionHistory = (RecognitionHistory) this.f$1;
                SQLiteConnection sQLiteConnection5 = (SQLiteConnection) obj;
                sQLiteConnection5.getClass();
                return Long.valueOf(databaseDao_Impl5.__insertAdapterOfRecognitionHistory.insertAndReturnId(sQLiteConnection5, recognitionHistory));
            case 16:
                Long l = (Long) this.f$0;
                String str = (String) this.f$1;
                SQLiteConnection sQLiteConnection6 = (SQLiteConnection) obj;
                sQLiteConnection6.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection6.prepare("UPDATE song SET playbackPosition = ? WHERE id = ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, l.longValue());
                    sQLiteStatementPrepare.bindText(2, str);
                    sQLiteStatementPrepare.step();
                    return Unit.INSTANCE;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 17:
                String str2 = (String) this.f$0;
                ConnectionPool connectionPool = (ConnectionPool) this.f$1;
                SQLiteConnection sQLiteConnection7 = (SQLiteConnection) obj;
                sQLiteConnection7.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection7.prepare(str2);
                try {
                    ((DiskLruCache$$ExternalSyntheticLambda0) connectionPool.delegate).invoke(sQLiteStatementPrepare2);
                    return Integer.valueOf(sQLiteStatementPrepare2.step() ? (int) sQLiteStatementPrepare2.getLong(0) : 0);
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 18:
                DatabaseDao_Impl databaseDao_Impl6 = (DatabaseDao_Impl) this.f$0;
                AlbumPage albumPage = (AlbumPage) this.f$1;
                ((SQLiteConnection) obj).getClass();
                albumPage.getClass();
                AlbumItem albumItem = albumPage.album;
                String str3 = albumItem.browseId;
                String str4 = albumItem.playlistId;
                String str5 = albumItem.title;
                Integer num = albumItem.year;
                String str6 = albumItem.thumbnail;
                List list3 = albumPage.songs;
                int size11 = list3.size();
                Iterator it = list3.iterator();
                int iIntValue = 0;
                while (it.hasNext()) {
                    Integer num2 = ((SongItem) it.next()).duration;
                    iIntValue += num2 != null ? num2.intValue() : 0;
                }
                if (albumItem.explicit) {
                    z = true;
                } else {
                    if (!list3.isEmpty()) {
                        Iterator it2 = list3.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((SongItem) it2.next()).explicit) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z = false;
                }
                if (databaseDao_Impl6.insert(new AlbumEntity(str3, str4, str5, num, str6, size11, iIntValue, z, 32288)) != -1) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(HexFormatKt.toMediaMetadata((SongItem) it3.next()));
                    }
                    int size12 = arrayList3.size();
                    int i24 = 0;
                    while (i24 < size12) {
                        Object obj11 = arrayList3.get(i24);
                        i24++;
                        databaseDao_Impl6.insert((MediaMetadata) obj11, new DatabaseDao$$ExternalSyntheticLambda0(b2));
                    }
                    int size13 = arrayList3.size();
                    int i25 = 0;
                    while (i25 < size13) {
                        Object obj12 = arrayList3.get(i25);
                        i25++;
                        MediaMetadata mediaMetadata = (MediaMetadata) obj12;
                        Song songByIdBlocking = databaseDao_Impl6.getSongByIdBlocking(mediaMetadata.id);
                        if (songByIdBlocking != null) {
                            databaseDao_Impl6.update(songByIdBlocking, mediaMetadata, false, false);
                        }
                    }
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                    int size14 = arrayList3.size();
                    int i26 = 0;
                    int i27 = 0;
                    while (i27 < size14) {
                        Object obj13 = arrayList3.get(i27);
                        i27++;
                        int i28 = i26 + 1;
                        if (i26 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        arrayList4.add(new SongAlbumMap(((MediaMetadata) obj13).id, str3, i26));
                        i26 = i28;
                    }
                    int size15 = arrayList4.size();
                    int i29 = 0;
                    while (i29 < size15) {
                        Object obj14 = arrayList4.get(i29);
                        i29++;
                        databaseDao_Impl6.upsert((SongAlbumMap) obj14);
                    }
                    List<Artist> list4 = albumItem.artists;
                    if (list4 != null) {
                        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                        for (Artist artist : list4) {
                            String strGenerateLocalId = artist.id;
                            String str7 = artist.name;
                            if (strGenerateLocalId == null) {
                                ArtistEntity artistEntityArtistByName = databaseDao_Impl6.artistByName(str7);
                                strGenerateLocalId = artistEntityArtistByName != null ? artistEntityArtistByName.id : null;
                                if (strGenerateLocalId == null) {
                                    strGenerateLocalId = CollectionsKt__IterablesKt.generateLocalId("LA");
                                }
                            }
                            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                            arrayList5.add(new ArtistEntity(strGenerateLocalId, ArtistNameAliases.resolve(artist.id, str7), null, null, null, false, null, 508));
                        }
                        int size16 = arrayList5.size();
                        int i30 = 0;
                        while (i30 < size16) {
                            Object obj15 = arrayList5.get(i30);
                            i30++;
                            databaseDao_Impl6.insert((ArtistEntity) obj15);
                        }
                        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                        int size17 = arrayList5.size();
                        int i31 = 0;
                        int i32 = 0;
                        while (i32 < size17) {
                            Object obj16 = arrayList5.get(i32);
                            i32++;
                            int i33 = i31 + 1;
                            if (i31 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            arrayList6.add(new AlbumArtistMap(str3, ((ArtistEntity) obj16).id, i31));
                            i31 = i33;
                        }
                        int size18 = arrayList6.size();
                        while (i8 < size18) {
                            Object obj17 = arrayList6.get(i8);
                            i8++;
                            databaseDao_Impl6.insert((AlbumArtistMap) obj17);
                        }
                    }
                }
                return Unit.INSTANCE;
            case 19:
                DatabaseDao_Impl databaseDao_Impl7 = (DatabaseDao_Impl) this.f$0;
                FormatEntity formatEntity = (FormatEntity) this.f$1;
                SQLiteConnection sQLiteConnection8 = (SQLiteConnection) obj;
                sQLiteConnection8.getClass();
                databaseDao_Impl7.__upsertAdapterOfFormatEntity.upsert(sQLiteConnection8, formatEntity);
                return Unit.INSTANCE;
            case 20:
                SpeedDialDao_Impl speedDialDao_Impl = (SpeedDialDao_Impl) this.f$0;
                SpeedDialItem speedDialItem = (SpeedDialItem) this.f$1;
                SQLiteConnection sQLiteConnection9 = (SQLiteConnection) obj;
                sQLiteConnection9.getClass();
                speedDialDao_Impl.__insertAdapterOfSpeedDialItem.insert(sQLiteConnection9, speedDialItem);
                return Unit.INSTANCE;
            case 21:
                String str8 = (String) this.f$0;
                Parameters parameters = (Parameters) this.f$1;
                ParametersBuilder parametersBuilder = (ParametersBuilder) obj;
                parametersBuilder.getClass();
                parametersBuilder.append("client_id", String.valueOf((Object) 1447278780795064401L));
                parametersBuilder.append("grant_type", str8);
                parameters.forEach(new MainActivity$$ExternalSyntheticLambda0((byte) 5, parametersBuilder));
                return Unit.INSTANCE;
            case 22:
                RelatedPage relatedPage = (RelatedPage) this.f$0;
                String str9 = (String) this.f$1;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                boolean z2 = MusicService.isRunning;
                musicDatabase.getClass();
                ArrayList arrayList7 = relatedPage.songs;
                ArrayList arrayList8 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10));
                int size19 = arrayList7.size();
                int i34 = 0;
                while (i34 < size19) {
                    Object obj18 = arrayList7.get(i34);
                    i34++;
                    arrayList8.add(HexFormatKt.toMediaMetadata((SongItem) obj18));
                }
                int size20 = arrayList8.size();
                int i35 = 0;
                while (i35 < size20) {
                    Object obj19 = arrayList8.get(i35);
                    i35++;
                    musicDatabase.insert((MediaMetadata) obj19, new DatabaseDao$$ExternalSyntheticLambda0(b2));
                }
                ArrayList arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList8, 10));
                int size21 = arrayList8.size();
                int i36 = 0;
                while (i36 < size21) {
                    Object obj20 = arrayList8.get(i36);
                    i36++;
                    arrayList9.add(new RelatedSongMap(str9, ((MediaMetadata) obj20).id));
                }
                int size22 = arrayList9.size();
                while (i7 < size22) {
                    Object obj21 = arrayList9.get(i7);
                    i7++;
                    musicDatabase.insert((RelatedSongMap) obj21);
                }
                return Unit.INSTANCE;
            case 23:
                MediaItem mediaItem = (MediaItem) this.f$0;
                PlaybackStats playbackStats = (PlaybackStats) this.f$1;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                boolean z3 = MusicService.isRunning;
                musicDatabase2.getClass();
                String str10 = mediaItem.mediaId;
                str10.getClass();
                long[] jArr = playbackStats.playbackStateDurationsMs;
                long j = jArr[3];
                DatabaseDao databaseDao = musicDatabase2.$$delegate_0;
                databaseDao.incrementTotalPlayTime(j, str10);
                try {
                    str10.getClass();
                    LocalDateTime localDateTimeNow = LocalDateTime.now();
                    localDateTimeNow.getClass();
                    databaseDao.insert(new Event(0L, str10, localDateTimeNow, jArr[3]));
                    break;
                } catch (SQLException unused2) {
                }
                return Unit.INSTANCE;
            case 24:
                SongEntity songEntity = (SongEntity) this.f$0;
                MusicService musicService = (MusicService) this.f$1;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                musicDatabase3.getClass();
                musicDatabase3.$$delegate_0.update(songEntity);
                SyncUtils syncUtils = musicService.syncUtils;
                if (syncUtils == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncUtils");
                    throw null;
                }
                syncUtils.enqueue(new SyncOperation.LikeSong(songEntity));
                if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.AutoDownloadOnLikeKey, Boolean.FALSE)).booleanValue() && songEntity.liked) {
                    DownloadUtil downloadUtil = musicService.downloadUtil;
                    if (downloadUtil == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadUtil");
                        throw null;
                    }
                    String str11 = songEntity.id;
                    str11.getClass();
                    AwaitKt.launch$default(downloadUtil.scope, null, null, new DownloadUtil.AnonymousClass2(downloadUtil, str11, (Continuation) null), 3);
                }
                return Unit.INSTANCE;
            case 25:
                LensController lensController = (LensController) this.f$0;
                RoundedCornerShape roundedCornerShape = (RoundedCornerShape) this.f$1;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setShadowElevation(reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((((Number) lensController.press.getValue()).floatValue() * 14.0f) + CropImageView.DEFAULT_ASPECT_RATIO));
                reusableGraphicsLayerScope.setShape(roundedCornerShape);
                reusableGraphicsLayerScope.setClip(false);
                reusableGraphicsLayerScope.m515setAmbientShadowColor8_81llA(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.3f, Color.m483getColorSpaceimpl(-72057594037927936L)));
                reusableGraphicsLayerScope.m516setSpotShadowColor8_81llA(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.4f, Color.m483getColorSpaceimpl(-72057594037927936L)));
                return Unit.INSTANCE;
            case 26:
                List list5 = (List) this.f$0;
                ReorderableLazyListState reorderableLazyListState = (ReorderableLazyListState) this.f$1;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                lazyListIntervalContent.items(list5.size(), new Latch$await$2$2(new MainActivity$$ExternalSyntheticLambda30((byte) 23), list5, (byte) 7), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list5, (byte) 1), new ComposableLambdaImpl(true, 2039820996, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(list5, reorderableLazyListState, b3)));
                return Unit.INSTANCE;
            case 27:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) this.f$0;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.f$1;
                Animatable animatable = (Animatable) obj;
                parcelableSnapshotMutableFloatState.setFloatValue((((Number) animatable.getValue()).floatValue() - ref$FloatRef.element) + parcelableSnapshotMutableFloatState.getFloatValue());
                ref$FloatRef.element = ((Number) animatable.getValue()).floatValue();
                return Unit.INSTANCE;
            case 28:
                HapticFeedback hapticFeedback = (HapticFeedback) this.f$0;
                Function1 function3 = (Function1) this.f$1;
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(6);
                if (function3 != null) {
                    function3.invoke(bool);
                }
                return Unit.INSTANCE;
            default:
                Unit unit = Unit.INSTANCE;
                Function0 function0 = (Function0) this.f$0;
                MusicDatabase musicDatabase4 = (MusicDatabase) this.f$1;
                if (((Boolean) obj).booleanValue()) {
                    LyricsTranslationHelper._manualTrigger.tryEmit(unit);
                } else {
                    LyricsEntity lyricsEntity = (LyricsEntity) function0.invoke();
                    if (lyricsEntity != null) {
                        StateFlowImpl stateFlowImpl = LyricsTranslationHelper._status;
                        musicDatabase4.query(new LyricsMenuKt$$ExternalSyntheticLambda50(LyricsEntity.copy$default(lyricsEntity, "", "", ""), b3));
                        LyricsTranslationHelper._clearTranslationsTrigger.tryEmit(unit);
                        StateFlowImpl stateFlowImpl2 = LyricsTranslationHelper._hasActiveTranslations;
                        Boolean bool2 = Boolean.FALSE;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, bool2);
                    }
                }
                return unit;
        }
    }
}
