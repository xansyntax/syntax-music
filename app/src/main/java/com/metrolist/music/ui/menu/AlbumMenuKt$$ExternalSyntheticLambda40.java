package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticLambda1;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridPrefetchResultScopeImpl;
import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import androidx.navigation.internal.NavControllerImpl;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda74;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.CsvImportState;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda40 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(MutableState mutableState, NavHostController navHostController, MutableState mutableState2, Function0 function0, Map map) {
        this.$r8$classId = (byte) 11;
        this.f$2 = mutableState;
        this.f$0 = navHostController;
        this.f$4 = mutableState2;
        this.f$1 = function0;
        this.f$3 = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Result.Failure failure;
        CsvImportState csvImportState;
        byte b = this.$r8$classId;
        List listSubList = EmptyList.INSTANCE;
        byte b2 = 27;
        byte b3 = 14;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$3;
        Object obj3 = this.f$1;
        Object obj4 = this.f$4;
        Object obj5 = this.f$2;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                Context context = (Context) obj6;
                AlbumEntity albumEntity = ((Album) obj3).album;
                String str = (String) obj2;
                MutableState mutableState = (MutableState) obj4;
                String str2 = (String) obj;
                str2.getClass();
                List<Song> list = (List) ((MutableState) obj5).getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Song song : list) {
                    arrayList.add(new PlaylistSong(new PlaylistSongMap(albumEntity.id, song.song.id, 0, (String) null, 17), song));
                }
                Serializable serializableM1526exportPlaylistAsCSV0E7RQCE = str2.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context, albumEntity.title, arrayList) : str2.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context, albumEntity.title, arrayList) : new Result.Failure(new IllegalArgumentException("Unknown format"));
                if (!(serializableM1526exportPlaylistAsCSV0E7RQCE instanceof Result.Failure)) {
                    Uri exportFileUri = UtilsKt.getExportFileUri(context, (File) serializableM1526exportPlaylistAsCSV0E7RQCE);
                    String str3 = str2.equals("csv") ? "text/csv" : "audio/x-mpegurl";
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType(str3);
                    intent.putExtra("android.intent.extra.STREAM", exportFileUri);
                    intent.addFlags(1);
                    context.startActivity(Intent.createChooser(intent, str));
                }
                if (Result.m1866exceptionOrNullimpl(serializableM1526exportPlaylistAsCSV0E7RQCE) != null) {
                    Toast.makeText(context, R.string.export_failed, 0).show();
                }
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 1:
                ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) obj6;
                activityResultLauncherHolder.launcher = ((ActivityResultRegistry) obj3).register((String) obj2, (ActivityResultContract) obj4, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 1, (MutableState) obj5));
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 1, activityResultLauncherHolder);
            case 2:
                List list2 = (List) obj6;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj3;
                List list3 = (List) obj5;
                Function1 function1 = (Function1) obj4;
                LazyGridMeasureResult lazyGridMeasureResult = (LazyGridMeasureResult) obj2;
                PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = (PrefetchHandleProvider$HandleAndRequestImpl) obj;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = prefetchHandleProvider$HandleAndRequestImpl.precomposeHandle;
                int placeablesCount = precomposedSlotHandle != null ? precomposedSlotHandle.getPlaceablesCount() : 0;
                int iMo613getSizeYEO4UFw = 0;
                for (int i = 0; i < placeablesCount; i++) {
                    Orientation orientation = lazyGridMeasureResult.orientation;
                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle2 = prefetchHandleProvider$HandleAndRequestImpl.precomposeHandle;
                    iMo613getSizeYEO4UFw += (int) (orientation == Orientation.Vertical ? 4294967295L & (precomposedSlotHandle2 != null ? precomposedSlotHandle2.mo613getSizeYEO4UFw(i) : 0L) : (precomposedSlotHandle2 != null ? precomposedSlotHandle2.mo613getSizeYEO4UFw(i) : 0L) >> 32);
                }
                if (list2 != null) {
                    list2.add(Integer.valueOf(iMo613getSizeYEO4UFw));
                }
                if (ref$IntRef.element != list3.size()) {
                    ref$IntRef.element++;
                } else if (function1 != null && list2 != null) {
                    function1.invoke(new LazyGridPrefetchResultScopeImpl(list2));
                }
                return unit;
            case 3:
                OffsetMapping offsetMapping = (OffsetMapping) obj3;
                TextFieldValue textFieldValue = (TextFieldValue) obj5;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj4;
                SolidColor solidColor = (SolidColor) obj2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                float floatValue = ((CursorAnimationState) obj6).cursorAlpha$delegate.getFloatValue();
                if (floatValue != CropImageView.DEFAULT_ASPECT_RATIO) {
                    long j = textFieldValue.selection;
                    int i2 = TextRange.$r8$clinit;
                    int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    Rect cursorRect = layoutResult != null ? layoutResult.value.getCursorRect(iOriginalToTransformed) : new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                    float fFloor = (float) Math.floor(layoutNodeDrawScope.mo81toPx0680j_4(2.0f));
                    if (fFloor < 1.0f) {
                        fFloor = 1.0f;
                    }
                    float f = fFloor / 2.0f;
                    float f2 = cursorRect.left + f;
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)) - f;
                    if (f2 > fIntBitsToFloat) {
                        f2 = fIntBitsToFloat;
                    }
                    if (f2 >= f) {
                        f = f2;
                    }
                    float fFloor2 = ((int) fFloor) % 2 == 1 ? ((float) Math.floor(f)) + 0.5f : (float) Math.rint(f);
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.top)) & 4294967295L);
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.bottom)) & 4294967295L);
                    Canvas canvas = canvasDrawScope.drawParams.canvas;
                    AndroidPaint androidPaintPaint = canvasDrawScope.strokePaint;
                    if (androidPaintPaint == null) {
                        androidPaintPaint = ColorKt.Paint();
                        androidPaintPaint.m468setStylek9PVt8s(1);
                        canvasDrawScope.strokePaint = androidPaintPaint;
                    }
                    Paint paint = androidPaintPaint.internalPaint;
                    solidColor.mo473applyToPq9zytI(floatValue, canvasDrawScope.mo556getSizeNHjbRc(), androidPaintPaint);
                    if (!Intrinsics.areEqual(androidPaintPaint.internalColorFilter, (Object) null)) {
                        androidPaintPaint.setColorFilter(null);
                    }
                    if (androidPaintPaint._blendMode != 3) {
                        androidPaintPaint.m463setBlendModes9anfk8(3);
                    }
                    if (paint.getStrokeWidth() != fFloor) {
                        androidPaintPaint.setStrokeWidth(fFloor);
                    }
                    if (paint.getStrokeMiter() != 4.0f) {
                        paint.setStrokeMiter(4.0f);
                    }
                    if (androidPaintPaint.m461getStrokeCapKaPHkGw() != 0) {
                        androidPaintPaint.m466setStrokeCapBeK7IIE(0);
                    }
                    if (androidPaintPaint.m462getStrokeJoinLxFBmk8() != 0) {
                        androidPaintPaint.m467setStrokeJoinWw9F2mQ(0);
                    }
                    if (!paint.isFilterBitmap()) {
                        androidPaintPaint.m465setFilterQualityvDHp3xo(1);
                    }
                    canvas.mo458drawLineWko1d7g(jFloatToRawIntBits, jFloatToRawIntBits2, androidPaintPaint);
                }
                return unit;
            case 4:
                LegacyTextInputMethodRequest legacyTextInputMethodRequest = (LegacyTextInputMethodRequest) obj;
                LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = ((AndroidLegacyPlatformTextInputServiceAdapter) obj3).textInputModifierNode;
                legacyTextInputMethodRequest.state = (TextFieldValue) obj6;
                legacyTextInputMethodRequest.imeOptions = (ImeOptions) obj5;
                legacyTextInputMethodRequest.onEditCommand = (UtilsKt$$ExternalSyntheticLambda0) obj4;
                legacyTextInputMethodRequest.onImeActionPerformed = (Function1) obj2;
                legacyTextInputMethodRequest.legacyTextFieldState = legacyAdaptingPlatformTextInputModifierNode != null ? legacyAdaptingPlatformTextInputModifierNode.legacyTextFieldState : null;
                legacyTextInputMethodRequest.textFieldSelectionManager = legacyAdaptingPlatformTextInputModifierNode != null ? legacyAdaptingPlatformTextInputModifierNode.textFieldSelectionManager : null;
                legacyTextInputMethodRequest.viewConfiguration = legacyAdaptingPlatformTextInputModifierNode != null ? (ViewConfiguration) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalViewConfiguration) : null;
                return unit;
            case 5:
                ArrayList arrayList2 = (ArrayList) obj3;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) obj5;
                NavControllerImpl navControllerImpl = (NavControllerImpl) obj4;
                Bundle bundle = (Bundle) obj2;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                navBackStackEntry.getClass();
                ((Ref$BooleanRef) obj6).element = true;
                int iIndexOf = arrayList2.indexOf(navBackStackEntry);
                if (iIndexOf != -1) {
                    int i3 = iIndexOf + 1;
                    listSubList = arrayList2.subList(ref$IntRef2.element, i3);
                    ref$IntRef2.element = i3;
                }
                navControllerImpl.addEntryToBackStack(navBackStackEntry.destination, bundle, navBackStackEntry, listSubList);
                return unit;
            case 6:
                SyncUtils syncUtils = (SyncUtils) obj3;
                MutableState mutableState2 = (MutableState) obj5;
                String str4 = (String) obj;
                str4.getClass();
                PlaylistEntity playlistEntity = new PlaylistEntity(null, str4, null, null, true, LocalDateTime.now(), null, null, null, null, null, 16285);
                boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                CrossfadeKt$$ExternalSyntheticLambda3 crossfadeKt$$ExternalSyntheticLambda3 = new CrossfadeKt$$ExternalSyntheticLambda3((Context) obj6, (String) obj2, (Function1) obj4, mutableState2, (byte) 4);
                syncUtils.getClass();
                AwaitKt.launch$default(syncUtils.syncScope, null, null, new SyncUtils$createPlaylist$1(zBooleanValue, playlistEntity, syncUtils, crossfadeKt$$ExternalSyntheticLambda3, null), 3);
                return unit;
            case 7:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj6;
                ((DisposableEffectScope) obj).getClass();
                ActivityResultRegistry$$ExternalSyntheticLambda1 activityResultRegistry$$ExternalSyntheticLambda1 = new ActivityResultRegistry$$ExternalSyntheticLambda1((LazyListState) obj3, (ParcelableSnapshotMutableIntState) obj2, (MutableState) obj5, (MutableState) obj4, (byte) 1);
                lifecycleOwner.getLifecycle().addObserver(activityResultRegistry$$ExternalSyntheticLambda1);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(lifecycleOwner, activityResultRegistry$$ExternalSyntheticLambda1, (byte) 14);
            case 8:
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj3;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj2;
                ((MutableState) obj5).setValue(Boolean.TRUE);
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(Float.intBitsToFloat((int) (((Offset) obj).packedValue >> 32)) / ((int) (((SuspendingPointerInputModifierNodeImpl) ((PointerInputScope) obj6)).boundsSize >> 32)), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                float f3 = closedFloatRange._start;
                ((Function1) obj4).invoke(Float.valueOf(((closedFloatRange._endInclusive - f3) * parcelableSnapshotMutableFloatState.getFloatValue()) + f3));
                return unit;
            case 9:
                MusicDatabase musicDatabase = (MusicDatabase) obj6;
                String str5 = (String) obj;
                str5.getClass();
                PlaylistEntity playlistEntity2 = new PlaylistEntity(null, str5, null, null, false, null, null, null, null, null, null, 16381);
                musicDatabase.query(new DiskLruCache$$ExternalSyntheticLambda0((byte) 29, playlistEntity2));
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj3, DefaultIoScheduler.INSTANCE, null, new MutatorMutex.AnonymousClass2(musicDatabase, playlistEntity2, (Function1) obj4, (Function0) obj2, (MutableState) obj5, (Continuation) null), 2);
                return unit;
            case 10:
                Context context2 = (Context) obj6;
                Playlist playlist = (Playlist) obj3;
                String str6 = (String) obj2;
                MutableState mutableState3 = (MutableState) obj4;
                String str7 = (String) obj;
                str7.getClass();
                List<Song> list4 = (List) ((MutableState) obj5).getValue();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                for (Song song2 : list4) {
                    arrayList3.add(new PlaylistSong(new PlaylistSongMap(playlist.playlist.id, song2.song.id, 0, (String) null, 17), song2));
                }
                Object objM1526exportPlaylistAsCSV0E7RQCE = str7.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context2, playlist.playlist.name, arrayList3) : str7.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context2, playlist.playlist.name, arrayList3) : new Result.Failure(new IllegalArgumentException("Unknown format"));
                if (!(objM1526exportPlaylistAsCSV0E7RQCE instanceof Result.Failure)) {
                    Uri exportFileUri2 = UtilsKt.getExportFileUri(context2, (File) objM1526exportPlaylistAsCSV0E7RQCE);
                    String str8 = str7.equals("csv") ? "text/csv" : "audio/x-mpegurl";
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType(str8);
                    intent2.putExtra("android.intent.extra.STREAM", exportFileUri2);
                    intent2.addFlags(1);
                    context2.startActivity(Intent.createChooser(intent2, str6));
                }
                if (Result.m1866exceptionOrNullimpl(objM1526exportPlaylistAsCSV0E7RQCE) != null) {
                    Toast.makeText(context2, R.string.export_failed, 0).show();
                }
                mutableState3.setValue(Boolean.FALSE);
                return unit;
            case 11:
                NavHostController navHostController = (NavHostController) obj6;
                MutableState mutableState4 = (MutableState) obj4;
                Function0 function0 = (Function0) obj3;
                Map map = (Map) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) ((MutableState) obj5).getValue();
                List list5 = albumWithSongs != null ? albumWithSongs.artists : null;
                if (list5 != null) {
                    listSubList = list5;
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj7 : listSubList) {
                    if (hashSet.add(((ArtistEntity) obj7).id)) {
                        arrayList4.add(obj7);
                    }
                }
                lazyListIntervalContent.items(arrayList4.size(), new Latch$await$2$2(new SongMenuKt$$ExternalSyntheticLambda16((byte) 16), arrayList4, b3), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList4, (byte) 3), new ComposableLambdaImpl(true, 802480018, new NavHostKt$NavHost$32((List) arrayList4, (Object) navHostController, mutableState4, (Object) function0, (Object) map, (byte) 1)));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MenuState menuState = (MenuState) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                NavHostController navHostController2 = (NavHostController) obj4;
                State state = (State) obj2;
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                List list6 = (List) ((State) obj6).getValue();
                if (list6 != null) {
                    HashSet hashSet2 = new HashSet();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj8 : list6) {
                        if (hashSet2.add(((YTItem) obj8).getId())) {
                            arrayList5.add(obj8);
                        }
                    }
                    lazyGridIntervalContent.items(arrayList5.size(), new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda4((byte) 13), arrayList5, (byte) 26), null, new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda4(b3), arrayList5, b2), new ComposableLambdaImpl(true, -1117249557, new NavHostKt$NavHost$32((Object) arrayList5, (Object) menuState, (Object) coroutineScope, (Object) navHostController2, (Object) state, (byte) 3)));
                    if (list6.isEmpty()) {
                        LazyGridIntervalContent.items$default(lazyGridIntervalContent, 8, null, AlbumScreenKt.f333lambda$842704838, 14);
                    }
                }
                return unit;
            case 13:
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                List list7 = (List) ((State) obj6).getValue();
                lazyListIntervalContent2.items(list7.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda97(b3), list7, (byte) 23), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list7, (byte) 25), new ComposableLambdaImpl(true, 2039820996, new NavHostKt$NavHost$32((Object) list7, obj3, obj5, obj4, obj2, (byte) 4)));
                return unit;
            case 14:
                State state2 = (State) obj6;
                MenuState menuState2 = (MenuState) obj3;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj5;
                State state3 = (State) obj4;
                State state4 = (State) obj2;
                LazyGridIntervalContent lazyGridIntervalContent2 = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent2.getClass();
                lazyGridIntervalContent2.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 3), 0, new ComposableLambdaImpl(true, -139449482, new PlayerKt$$ExternalSyntheticLambda74(state2, (byte) 1)));
                List list8 = (List) state2.getValue();
                HashSet hashSet3 = new HashSet();
                ArrayList arrayList6 = new ArrayList();
                for (Object obj9 : list8) {
                    if (hashSet3.add(((Album) obj9).album.id)) {
                        arrayList6.add(obj9);
                    }
                }
                lazyGridIntervalContent2.items(arrayList6.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 4), arrayList6, b2), null, new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 5), arrayList6, (byte) 28), new ComposableLambdaImpl(true, -1117249557, new NavHostKt$NavHost$32((List) arrayList6, menuState2, coroutineScope2, state3, state4, (byte) 5)));
                return unit;
            case 15:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new DownloadUtil.AnonymousClass1((Mutex) obj2, new SliderKt$$ExternalSyntheticLambda8(obj3, ((Boolean) obj).booleanValue(), (byte) 5), (Context) obj6, (MutableState) obj5, null), 3);
                return unit;
            case 16:
                ArrayList arrayList7 = (ArrayList) obj6;
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                lazyListIntervalContent3.items(arrayList7.size(), null, new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList7, b2), new ComposableLambdaImpl(true, 802480018, new NavHostKt$NavHost$32((List) arrayList7, obj3, (MutableState) obj5, obj2, obj4, (byte) 8)));
                return unit;
            case 17:
                BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) obj3;
                Context context3 = (Context) obj6;
                MutableState mutableState5 = (MutableState) obj5;
                MutableState mutableState6 = (MutableState) obj4;
                MutableState mutableState7 = (MutableState) obj2;
                Uri uri = (Uri) obj;
                if (uri != null) {
                    mutableState5.setValue(uri);
                    backupRestoreViewModel.getClass();
                    context3.getClass();
                    ArrayList arrayList8 = new ArrayList();
                    try {
                        InputStream inputStreamOpenInputStream = context3.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                ArrayList lines = RegexKt.readLines(new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, Charsets.UTF_8), 8192));
                                List listTake = CollectionsKt.take(lines, 6);
                                ArrayList arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listTake, 10));
                                Iterator it = listTake.iterator();
                                while (it.hasNext()) {
                                    arrayList9.add(BackupRestoreViewModel.parseCsvLine((String) it.next()));
                                }
                                arrayList8.addAll(arrayList9);
                                csvImportState = new CsvImportState(14, arrayList8, !lines.isEmpty() && StringsKt.contains((CharSequence) lines.get(0), ",", false));
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CharsKt.closeFinally(inputStreamOpenInputStream, th);
                                    throw th2;
                                }
                            }
                        } else {
                            failure = null;
                            Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
                            if (thM1866exceptionOrNullimpl != null) {
                                thM1866exceptionOrNullimpl.printStackTrace();
                                Toast.makeText(context3, "Failed to preview CSV file", 0).show();
                            }
                            csvImportState = new CsvImportState(31, null, false);
                        }
                    } catch (Throwable th3) {
                        failure = new Result.Failure(th3);
                    }
                    mutableState6.setValue(csvImportState);
                    mutableState7.setValue(Boolean.TRUE);
                }
                return unit;
            default:
                CoroutineScope coroutineScope3 = (CoroutineScope) obj6;
                MutableState mutableState8 = (MutableState) obj4;
                MutableState mutableState9 = (MutableState) obj3;
                MutableState mutableState10 = (MutableState) obj2;
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                ((MutableState) obj5).setValue(Boolean.FALSE);
                if (zBooleanValue2) {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope3, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2((Object) mutableState8, (Object) mutableState9, (Object) mutableState10, (Continuation) null, (byte) 20), 2);
                }
                return unit;
        }
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(ActivityResultLauncherHolder activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, MutableState mutableState) {
        this.$r8$classId = (byte) 1;
        this.f$0 = activityResultLauncherHolder;
        this.f$1 = activityResultRegistry;
        this.f$3 = str;
        this.f$4 = activityResultContract;
        this.f$2 = mutableState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(PointerInputScope pointerInputScope, ClosedFloatRange closedFloatRange, Function1 function1, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.$r8$classId = (byte) 8;
        this.f$0 = pointerInputScope;
        this.f$1 = closedFloatRange;
        this.f$4 = function1;
        this.f$2 = mutableState;
        this.f$3 = parcelableSnapshotMutableFloatState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(LifecycleOwner lifecycleOwner, LazyListState lazyListState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 7;
        this.f$0 = lifecycleOwner;
        this.f$1 = lazyListState;
        this.f$3 = parcelableSnapshotMutableIntState;
        this.f$2 = mutableState;
        this.f$4 = mutableState2;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(MusicDatabase musicDatabase, CoroutineScope coroutineScope, Function1 function1, Function0 function0, MutableState mutableState) {
        this.$r8$classId = (byte) 9;
        this.f$0 = musicDatabase;
        this.f$1 = coroutineScope;
        this.f$4 = function1;
        this.f$3 = function0;
        this.f$2 = mutableState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(MusicAlarmEntry musicAlarmEntry, CoroutineScope coroutineScope, Mutex mutex, Context context, MutableState mutableState) {
        this.$r8$classId = (byte) 15;
        this.f$1 = musicAlarmEntry;
        this.f$4 = coroutineScope;
        this.f$3 = mutex;
        this.f$0 = context;
        this.f$2 = mutableState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(SyncUtils syncUtils, MutableState mutableState, Context context, String str, Function1 function1) {
        this.$r8$classId = (byte) 6;
        this.f$1 = syncUtils;
        this.f$2 = mutableState;
        this.f$0 = context;
        this.f$3 = str;
        this.f$4 = function1;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(BackupRestoreViewModel backupRestoreViewModel, Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 17;
        this.f$1 = backupRestoreViewModel;
        this.f$0 = context;
        this.f$2 = mutableState;
        this.f$4 = mutableState2;
        this.f$3 = mutableState3;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(Object obj, Object obj2, MutableState mutableState, String str, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = mutableState;
        this.f$3 = str;
        this.f$4 = obj3;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$4 = obj4;
        this.f$3 = obj5;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(ArrayList arrayList, Ref$IntRef ref$IntRef, List list, Function1 function1, int i, LazyGridMeasureResult lazyGridMeasureResult) {
        this.$r8$classId = (byte) 2;
        this.f$0 = arrayList;
        this.f$1 = ref$IntRef;
        this.f$2 = list;
        this.f$4 = function1;
        this.f$3 = lazyGridMeasureResult;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda40(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        this.$r8$classId = (byte) 18;
        this.f$0 = coroutineScope;
        this.f$2 = mutableState;
        this.f$4 = mutableState2;
        this.f$1 = mutableState3;
        this.f$3 = mutableState4;
    }
}
