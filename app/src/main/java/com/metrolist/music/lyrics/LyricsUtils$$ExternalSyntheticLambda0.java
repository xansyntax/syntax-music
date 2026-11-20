package com.metrolist.music.lyrics;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.utils.SyncOperation;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.openapi.KotlinxSerializerJsonSchemaInference;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.HexFormatKt;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsUtils$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ LyricsUtils$$ExternalSyntheticLambda0(Ref$ObjectRef ref$ObjectRef, String str, boolean z) {
        this.$r8$classId = (byte) 0;
        this.f$0 = ref$ObjectRef;
        this.f$2 = str;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        final byte b2 = 3;
        final byte b3 = 2;
        boolean z = false;
        int i = 0;
        z = false;
        z = false;
        final byte b4 = 1;
        Unit unit = Unit.INSTANCE;
        final boolean z2 = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj3;
                String str = (String) obj2;
                MatchResult matchResult = (MatchResult) obj;
                matchResult.getClass();
                MatcherMatchResult matcherMatchResult = (MatcherMatchResult) matchResult;
                long j = Long.parseLong((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(1));
                long j2 = Long.parseLong((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(2));
                String str2 = (String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(3);
                long j3 = Long.parseLong(str2);
                if (str2.length() == 2) {
                    j3 *= 10;
                }
                return new LyricsEntry((j2 * 1000) + (j * 60000) + j3, (String) ref$ObjectRef.element, null, str, this.f$3, 24);
            case 1:
                final PagerState pagerState = (PagerState) obj3;
                final CoroutineScope coroutineScope = (CoroutineScope) obj2;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                if (z2) {
                    final byte b5 = z ? (byte) 1 : (byte) 0;
                    Function0 function0 = new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b5;
                            boolean z3 = false;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            PagerState pagerState2 = pagerState;
                            switch (b6) {
                                case 0:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 1:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 2:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                default:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                            }
                        }
                    };
                    KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                    semanticsPropertyReceiver.set(SemanticsActions.PageUp, new AccessibilityAction(null, function0));
                    semanticsPropertyReceiver.set(SemanticsActions.PageDown, new AccessibilityAction(null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b4;
                            boolean z3 = false;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            PagerState pagerState2 = pagerState;
                            switch (b6) {
                                case 0:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 1:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 2:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                default:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                            }
                        }
                    }));
                } else {
                    Function0 function1 = new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b3;
                            boolean z3 = false;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            PagerState pagerState2 = pagerState;
                            switch (b6) {
                                case 0:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 1:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 2:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                default:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                            }
                        }
                    };
                    KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                    semanticsPropertyReceiver.set(SemanticsActions.PageLeft, new AccessibilityAction(null, function1));
                    semanticsPropertyReceiver.set(SemanticsActions.PageRight, new AccessibilityAction(null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b6 = b2;
                            boolean z3 = false;
                            CoroutineScope coroutineScope2 = coroutineScope;
                            PagerState pagerState2 = pagerState;
                            switch (b6) {
                                case 0:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 1:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                case 2:
                                    if (pagerState2.getCanScrollBackward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 1), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                                default:
                                    if (pagerState2.getCanScrollForward()) {
                                        AwaitKt.launch$default(coroutineScope2, null, null, new PagerState$requestScrollToPage$1(pagerState2, null, (byte) 2), 3);
                                        z3 = true;
                                    }
                                    return Boolean.valueOf(z3);
                            }
                        }
                    }));
                }
                return unit;
            case 2:
                ((Placeable.PlacementScope) obj).place((Placeable) obj2, 0, 0, ((Number) ((State) obj3).getValue()).floatValue() + (z2 ? 5.0f : CropImageView.DEFAULT_ASPECT_RATIO));
                return unit;
            case 3:
                String str3 = (String) obj2;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj3;
                SemanticsPropertyReceiver semanticsPropertyReceiver2 = (SemanticsPropertyReceiver) obj;
                if (z2) {
                    SemanticsPropertiesKt.m717setLiveRegionhR3wRGc(semanticsPropertyReceiver2, 0);
                }
                SnackbarKt$$ExternalSyntheticLambda3 snackbarKt$$ExternalSyntheticLambda3 = new SnackbarKt$$ExternalSyntheticLambda3(snackbarDataImpl, (byte) 1);
                KProperty[] kPropertyArr3 = SemanticsPropertiesKt.$$delegatedProperties;
                semanticsPropertyReceiver2.set(SemanticsActions.Dismiss, new AccessibilityAction(null, snackbarKt$$ExternalSyntheticLambda3));
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver2, str3);
                return unit;
            case 4:
                AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) obj3;
                InputModeManager inputModeManager = (InputModeManager) obj2;
                FocusProperties focusProperties = (FocusProperties) obj;
                if (z2 && ((Boolean) analogTimePickerState.isDialFocusable$delegate.getValue()).booleanValue() && ((InputMode) ((InputModeManagerImpl) inputModeManager).inputMode$delegate.getValue()).value != 1) {
                    z = true;
                }
                focusProperties.setCanFocus(z);
                return unit;
            case 5:
                SemanticsPropertyReceiver semanticsPropertyReceiver3 = (SemanticsPropertyReceiver) obj;
                CheckboxKt$$ExternalSyntheticLambda2 checkboxKt$$ExternalSyntheticLambda2 = new CheckboxKt$$ExternalSyntheticLambda2((byte) 2, (Function1) obj3, z2);
                KProperty[] kPropertyArr4 = SemanticsPropertiesKt.$$delegatedProperties;
                semanticsPropertyReceiver3.set(SemanticsActions.OnClick, new AccessibilityAction(null, checkboxKt$$ExternalSyntheticLambda2));
                SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver3, ((Boolean) ((State) obj2).getValue()).booleanValue());
                return unit;
            case 6:
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj3;
                final List list = (List) obj2;
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda4
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        boolean z3 = z2;
                        List list2 = list;
                        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
                        if (z3 && !list2.contains(navBackStackEntry2)) {
                            list2.add(navBackStackEntry2);
                        }
                        if (event == Lifecycle.Event.ON_START && !list2.contains(navBackStackEntry2)) {
                            list2.add(navBackStackEntry2);
                        }
                        if (event == Lifecycle.Event.ON_STOP) {
                            list2.remove(navBackStackEntry2);
                        }
                    }
                };
                navBackStackEntry.impl.lifecycle.addObserver(lifecycleEventObserver);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(navBackStackEntry, lifecycleEventObserver, (byte) 10);
            case 7:
                LocalDateTime localDateTime = (LocalDateTime) obj3;
                String str4 = (String) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE song SET isDownloaded = ?, dateDownload = ? WHERE id = ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, z2 ? 1L : 0L);
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare.bindNull(2);
                    } else {
                        sQLiteStatementPrepare.bindLong(2, lDateToTimestamp.longValue());
                    }
                    sQLiteStatementPrepare.bindText(3, str4);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 8:
                ArrayList arrayList = (ArrayList) obj3;
                SyncUtils syncUtils = (SyncUtils) obj2;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                int size = arrayList.size();
                while (i < size) {
                    Object obj4 = arrayList.get(i);
                    i++;
                    Song song = (Song) obj4;
                    if ((!z2 && !song.song.liked) || z2) {
                        SongEntity songEntity = song.song.toggleLike(true);
                        musicDatabase.$$delegate_0.update(songEntity);
                        syncUtils.getClass();
                        syncUtils.enqueue(new SyncOperation.LikeSong(songEntity));
                    }
                }
                return unit;
            case 9:
                Song song2 = (Song) obj3;
                SongItem songItem = (SongItem) obj2;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                DatabaseDao databaseDao = musicDatabase2.$$delegate_0;
                if (song2 != null) {
                    databaseDao.update(SongEntity.copy$default(song2.song, null, 0, null, null, null, false, null, z2 ? LocalDateTime.now() : null, null, null, null, 0, false, false, false, null, 134209535));
                } else {
                    databaseDao.insert(SongEntity.copy$default(HexFormatKt.toMediaMetadata(songItem).toSongEntity(), null, 0, null, null, null, false, null, LocalDateTime.now(), null, null, null, 0, false, false, false, null, 125820927));
                }
                return unit;
            case 10:
                Function1 function2 = (Function1) obj3;
                MutableState mutableState = (MutableState) obj2;
                ((Boolean) obj).getClass();
                if (z2) {
                    function2.invoke(Boolean.FALSE);
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                return unit;
            default:
                return KotlinxSerializerJsonSchemaInference.buildSchemaFromDescriptor$lambda$0((KotlinxSerializerJsonSchemaInference) obj3, z2, (Set) obj2, (KClass) obj);
        }
    }

    public /* synthetic */ LyricsUtils$$ExternalSyntheticLambda0(Object obj, boolean z, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$3 = z;
        this.f$2 = obj2;
    }

    public /* synthetic */ LyricsUtils$$ExternalSyntheticLambda0(boolean z, DatabaseDao_Impl databaseDao_Impl, LocalDateTime localDateTime, String str) {
        this.$r8$classId = (byte) 7;
        this.f$3 = z;
        this.f$0 = localDateTime;
        this.f$2 = str;
    }

    public /* synthetic */ LyricsUtils$$ExternalSyntheticLambda0(boolean z, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$3 = z;
        this.f$0 = obj;
        this.f$2 = obj2;
    }

    public /* synthetic */ LyricsUtils$$ExternalSyntheticLambda0(boolean z, String str, SnackbarHostState.SnackbarDataImpl snackbarDataImpl) {
        this.$r8$classId = (byte) 3;
        this.f$3 = z;
        this.f$2 = str;
        this.f$0 = snackbarDataImpl;
    }
}
