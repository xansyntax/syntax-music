package com.metrolist.music.ui.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Layout;
import android.widget.Toast;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.unit.Density;
import coil3.network.HttpException;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$3;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.utils.ComposeToImage$createLyricsImage$2;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentalLyricsKt$ExperimentalLyrics$19$1 implements Function4 {
    public final /* synthetic */ Object $arts;
    public final /* synthetic */ Object $configuration;
    public final /* synthetic */ Object $context;
    public final /* synthetic */ Object $density;
    public final /* synthetic */ Object $lyricsTextPosition$delegate;
    public final /* synthetic */ Object $mediaMetadata$delegate;
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ Object $scope;
    public final /* synthetic */ MutableState $showColorPickerDialog$delegate;
    public final /* synthetic */ MutableState $showProgressDialog$delegate;
    public final /* synthetic */ Object $title;
    public final /* synthetic */ Object $txt;

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$19$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $arts;
        public final /* synthetic */ long $bgColor;
        public final /* synthetic */ Configuration $configuration;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Density $density;
        public final /* synthetic */ ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 $lyricsTextPosition$delegate;
        public final /* synthetic */ MutableState $mediaMetadata$delegate;
        public final /* synthetic */ long $secTextColor;
        public final /* synthetic */ MutableState $showProgressDialog$delegate;
        public final /* synthetic */ LyricsBackgroundStyle $style;
        public final /* synthetic */ long $textColor;
        public final /* synthetic */ String $title;
        public final /* synthetic */ String $txt;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, String str, String str2, String str3, Configuration configuration, Density density, long j, LyricsBackgroundStyle lyricsBackgroundStyle, long j2, long j3, MutableState mutableState, ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2, MutableState mutableState2, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$title = str;
            this.$arts = str2;
            this.$txt = str3;
            this.$configuration = configuration;
            this.$density = density;
            this.$bgColor = j;
            this.$style = lyricsBackgroundStyle;
            this.$textColor = j2;
            this.$secTextColor = j3;
            this.$mediaMetadata$delegate = mutableState;
            this.$lyricsTextPosition$delegate = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2;
            this.$showProgressDialog$delegate = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$context, this.$title, this.$arts, this.$txt, this.$configuration, this.$density, this.$bgColor, this.$style, this.$textColor, this.$secTextColor, this.$mediaMetadata$delegate, this.$lyricsTextPosition$delegate, this.$showProgressDialog$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LyricsBackgroundStyle lyricsBackgroundStyle;
            Layout.Alignment alignment;
            Object objWithContext;
            Density density = this.$density;
            Configuration configuration = this.$configuration;
            boolean z = this.label;
            MutableState mutableState = this.$showProgressDialog$delegate;
            Context context = this.$context;
            try {
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Context context2 = this.$context;
                    MediaMetadata mediaMetadata = (MediaMetadata) this.$mediaMetadata$delegate.getValue();
                    String str = mediaMetadata != null ? mediaMetadata.thumbnailUrl : null;
                    String str2 = this.$title;
                    String str3 = this.$arts;
                    String str4 = this.$txt;
                    int i = configuration.screenWidthDp;
                    density.getDensity();
                    density.getDensity();
                    Integer num = new Integer(ColorKt.m498toArgb8_81llA(this.$bgColor));
                    int iOrdinal = this.$style.ordinal();
                    if (iOrdinal == 0) {
                        lyricsBackgroundStyle = LyricsBackgroundStyle.SOLID;
                    } else if (iOrdinal == 1) {
                        lyricsBackgroundStyle = LyricsBackgroundStyle.BLUR;
                    } else {
                        if (iOrdinal != 2) {
                            throw new HttpException();
                        }
                        lyricsBackgroundStyle = LyricsBackgroundStyle.GRADIENT;
                    }
                    LyricsBackgroundStyle lyricsBackgroundStyle2 = lyricsBackgroundStyle;
                    Integer num2 = new Integer(ColorKt.m498toArgb8_81llA(this.$textColor));
                    Integer num3 = new Integer(ColorKt.m498toArgb8_81llA(this.$secTextColor));
                    int iOrdinal2 = ((LyricsPosition) this.$lyricsTextPosition$delegate.getValue()).ordinal();
                    if (iOrdinal2 != 0) {
                        alignment = iOrdinal2 != 1 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
                    } else {
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    }
                    Layout.Alignment alignment2 = alignment;
                    this.label = true;
                    objWithContext = AwaitKt.withContext(Dispatchers.Default, new ComposeToImage$createLyricsImage$2(num, num2, num3, str, context2, lyricsBackgroundStyle2, str2, str3, str4, alignment2, null), this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                }
                Uri uriSaveBitmapAsFile = UtilsKt.saveBitmapAsFile(context, (Bitmap) objWithContext, "lyrics_" + System.currentTimeMillis());
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.STREAM", uriSaveBitmapAsFile);
                intent.addFlags(1);
                context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_lyrics)));
            } catch (Exception e) {
                Toast.makeText(context, context.getString(R.string.failed_to_create_image, e.getMessage()), 0).show();
            } finally {
                mutableState.setValue(Boolean.FALSE);
            }
            return Unit.INSTANCE;
        }
    }

    public ExperimentalLyricsKt$ExperimentalLyrics$19$1(List list, List list2, MutableState mutableState, HapticFeedback hapticFeedback, MutableState mutableState2, List list3, State state, PlayerConnection playerConnection, MutableState mutableState3, State state2, MenuState menuState) {
        this.$scope = list;
        this.$context = list2;
        this.$showColorPickerDialog$delegate = mutableState;
        this.$title = hapticFeedback;
        this.$showProgressDialog$delegate = mutableState2;
        this.$arts = list3;
        this.$txt = state;
        this.$configuration = playerConnection;
        this.$mediaMetadata$delegate = mutableState3;
        this.$density = state2;
        this.$lyricsTextPosition$delegate = menuState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        long j;
        Playlist playlist;
        Song song;
        final Song song2;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$showColorPickerDialog$delegate;
        Object obj5 = this.$mediaMetadata$delegate;
        Object obj6 = this.$lyricsTextPosition$delegate;
        Object obj7 = this.$density;
        Object obj8 = this.$scope;
        Object obj9 = this.$configuration;
        Object obj10 = this.$arts;
        boolean z = true;
        Object obj11 = this.$title;
        Object obj12 = this.$txt;
        Object obj13 = this.$context;
        switch (b) {
            case 0:
                long j2 = ((Color) obj).value;
                long j3 = ((Color) obj2).value;
                long j4 = ((Color) obj3).value;
                LyricsBackgroundStyle lyricsBackgroundStyle = (LyricsBackgroundStyle) obj4;
                lyricsBackgroundStyle.getClass();
                mutableState.setValue(Boolean.FALSE);
                Boolean bool = Boolean.TRUE;
                MutableState mutableState2 = this.$showProgressDialog$delegate;
                mutableState2.setValue(bool);
                AwaitKt.launch$default((CoroutineScope) obj8, null, null, new AnonymousClass1((Context) obj13, (String) obj11, (String) obj10, (String) obj12, (Configuration) obj9, (Density) obj7, j2, lyricsBackgroundStyle, j3, j4, (MutableState) obj5, (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2) obj6, mutableState2, null), 3);
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i = (iIntValue2 & 6) == 0 ? (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2 : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final Playlist playlist2 = (Playlist) ((List) obj5).get(iIntValue);
                    gapComposer.startReplaceGroup(-1259014618);
                    if (((Set) mutableState.getValue()).contains(playlist2.playlist.id)) {
                        gapComposer.startReplaceGroup(-179158935);
                        j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-179157404);
                        gapComposer.end(false);
                        j = 0;
                    }
                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(OffsetKt.m136paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 8.0f, 2.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f)), ((Color) SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "playlistBg", gapComposer, 432, 8).getValue()).value, ColorKt.RectangleShape);
                    boolean zChanged = gapComposer.changed((Function1) obj13) | gapComposer.changed(playlist2) | gapComposer.changedInstance((CoroutineScope) obj8) | gapComposer.changed((Function0) obj11) | gapComposer.changed((SnapshotStateList) obj10) | gapComposer.changed((Function1) obj12) | gapComposer.changedInstance((MusicDatabase) obj9) | gapComposer.changed((Function1) obj7) | gapComposer.changed(((AddToPlaylistPosition) obj6).ordinal());
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        final CoroutineScope coroutineScope = (CoroutineScope) obj8;
                        final Function0 function0 = (Function0) obj11;
                        final SnapshotStateList snapshotStateList = (SnapshotStateList) obj10;
                        final Function1 function1 = (Function1) obj12;
                        final MusicDatabase musicDatabase = (MusicDatabase) obj9;
                        final AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj6;
                        final Function1 function2 = (Function1) obj13;
                        final Function1 function3 = (Function1) obj7;
                        final MutableState mutableState3 = this.$showProgressDialog$delegate;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1

                            /* JADX INFO: renamed from: com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            public final class AnonymousClass1 extends SuspendLambda implements Function2 {
                                public final /* synthetic */ AddToPlaylistPosition $addToPlaylistPosition;
                                public final /* synthetic */ CoroutineScope $coroutineScope;
                                public final /* synthetic */ MusicDatabase $database;
                                public final /* synthetic */ Function0 $onDismiss;
                                public final /* synthetic */ Function1 $onPercentageChange;
                                public final /* synthetic */ Function1 $onProgressStart;
                                public final /* synthetic */ Function1 $onSongChange;
                                public final /* synthetic */ Playlist $playlist;
                                public final /* synthetic */ SnapshotStateList $songs;
                                public int I$0;
                                public String[] L$2;
                                public Throwable L$3;
                                public Iterator L$5;
                                public byte label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public AnonymousClass1(Function0 function0, SnapshotStateList snapshotStateList, Function1 function1, MusicDatabase musicDatabase, Playlist playlist, AddToPlaylistPosition addToPlaylistPosition, CoroutineScope coroutineScope, Function1 function2, Function1 function3, Continuation continuation) {
                                    super(2, continuation);
                                    this.$onDismiss = function0;
                                    this.$songs = snapshotStateList;
                                    this.$onProgressStart = function1;
                                    this.$database = musicDatabase;
                                    this.$playlist = playlist;
                                    this.$addToPlaylistPosition = addToPlaylistPosition;
                                    this.$coroutineScope = coroutineScope;
                                    this.$onSongChange = function2;
                                    this.$onPercentageChange = function3;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new AnonymousClass1(this.$onDismiss, this.$songs, this.$onProgressStart, this.$database, this.$playlist, this.$addToPlaylistPosition, this.$coroutineScope, this.$onSongChange, this.$onPercentageChange, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Code duplicated, block: B:45:0x00ec A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:43:0x00e6, B:45:0x00ec, B:50:0x0109, B:52:0x0121, B:53:0x0133), top: B:65:0x00e6 }] */
                                /* JADX WARN: Code duplicated, block: B:52:0x0121 A[Catch: all -> 0x0106, LOOP:1: B:51:0x011f->B:52:0x0121, LOOP_END, TryCatch #0 {all -> 0x0106, blocks: (B:43:0x00e6, B:45:0x00ec, B:50:0x0109, B:52:0x0121, B:53:0x0133), top: B:65:0x00e6 }] */
                                /* JADX WARN: Code duplicated, block: B:56:0x014c  */
                                /* JADX WARN: Code duplicated, block: B:60:0x0167 A[RETURN] */
                                /* JADX WARN: Code duplicated, block: B:63:0x0184 A[RETURN] */
                                /* JADX WARN: Code duplicated, block: B:75:0x0104 A[SYNTHETIC] */
                                /* JADX WARN: Code duplicated, block: B:77:? A[LOOP:0: B:65:0x00e6->B:77:?, LOOP_END, SYNTHETIC] */
                                /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    int i;
                                    int i2;
                                    Iterator it;
                                    int i3;
                                    String[] strArr;
                                    MusicDatabase musicDatabase;
                                    Playlist playlist;
                                    ArrayList arrayListFilterNotNull;
                                    ArrayList arrayList;
                                    int size;
                                    int i4;
                                    boolean z;
                                    Job job;
                                    HandlerContext handlerContext;
                                    DiscordRpcManager.AnonymousClass1 anonymousClass1;
                                    HandlerContext handlerContext2;
                                    DiscordRpcManager.AnonymousClass1 anonymousClass2;
                                    byte b = this.label;
                                    Unit unit = Unit.INSTANCE;
                                    Function1 function1 = this.$onProgressStart;
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (b == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.$onDismiss.invoke();
                                        SnapshotStateList snapshotStateList = this.$songs;
                                        int size2 = snapshotStateList.size();
                                        if (size2 != 0) {
                                            AtomicInteger atomicInteger = new AtomicInteger(0);
                                            int i5 = SemaphoreKt.MAX_SPIN_CYCLES;
                                            SemaphoreImpl semaphoreImpl = new SemaphoreImpl(15);
                                            String[] strArr2 = new String[size2];
                                            function1.invoke(Boolean.TRUE);
                                            try {
                                                CoroutineScope coroutineScope = this.$coroutineScope;
                                                Function1 function2 = this.$onSongChange;
                                                Function1 function3 = this.$onPercentageChange;
                                                MusicDatabase musicDatabase2 = this.$database;
                                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(snapshotStateList, 10));
                                                ListIterator listIterator = snapshotStateList.listIterator();
                                                int i6 = 0;
                                                while (true) {
                                                    StateListIterator stateListIterator = (StateListIterator) listIterator;
                                                    if (!stateListIterator.hasNext()) {
                                                        int i7 = size2;
                                                        String[] strArr3 = strArr2;
                                                        it = arrayList2.iterator();
                                                        i3 = i7;
                                                        strArr = strArr3;
                                                        break;
                                                    }
                                                    Object next = stateListIterator.next();
                                                    int i8 = i6 + 1;
                                                    if (i6 < 0) {
                                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                                        throw null;
                                                    }
                                                    i = size2;
                                                    try {
                                                        Function1 function4 = function2;
                                                        Function1 function5 = function3;
                                                        MusicDatabase musicDatabase3 = musicDatabase2;
                                                        String[] strArr4 = strArr2;
                                                        arrayList2.add(AwaitKt.launch$default(coroutineScope, null, null, new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1(semaphoreImpl, (Song) next, atomicInteger, function4, function5, i, musicDatabase3, strArr4, i6, null), 3));
                                                        function2 = function4;
                                                        function3 = function5;
                                                        size2 = i;
                                                        musicDatabase2 = musicDatabase3;
                                                        strArr2 = strArr4;
                                                        i6 = i8;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                    }
                                                    i2 = i;
                                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                    anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                                    this.L$2 = null;
                                                    this.L$3 = th;
                                                    this.L$5 = null;
                                                    this.I$0 = i2;
                                                    this.label = (byte) 4;
                                                    if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                    throw th;
                                                }
                                                while (it.hasNext()) {
                                                    job = (Job) it.next();
                                                    this.L$2 = strArr;
                                                    this.L$3 = null;
                                                    this.L$5 = it;
                                                    this.I$0 = i3;
                                                    this.label = (byte) 1;
                                                    if (job.join(this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                }
                                                musicDatabase = this.$database;
                                                playlist = this.$playlist;
                                                arrayListFilterNotNull = ArraysKt.filterNotNull(strArr);
                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull, 10));
                                                size = arrayListFilterNotNull.size();
                                                i4 = 0;
                                                while (i4 < size) {
                                                    Object obj2 = arrayListFilterNotNull.get(i4);
                                                    i4++;
                                                    arrayList.add(new Pair((String) obj2, null));
                                                }
                                                z = this.$addToPlaylistPosition.prepend;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$5 = null;
                                                this.I$0 = i3;
                                                this.label = (byte) 2;
                                                if (musicDatabase.$$delegate_0.addSongsToPlaylist(playlist, arrayList, z, this) != coroutineSingletons) {
                                                    i2 = i3;
                                                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                                    handlerContext2 = MainDispatcherLoader.dispatcher;
                                                    anonymousClass2 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.I$0 = i2;
                                                    this.label = (byte) 3;
                                                    if (AwaitKt.withContext(handlerContext2, anonymousClass2, this) != coroutineSingletons) {
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i = size2;
                                            }
                                            return coroutineSingletons;
                                        }
                                        return unit;
                                    }
                                    if (b == 1) {
                                        int i9 = this.I$0;
                                        it = this.L$5;
                                        strArr = this.L$2;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            i3 = i9;
                                            while (it.hasNext()) {
                                                try {
                                                    job = (Job) it.next();
                                                    this.L$2 = strArr;
                                                    this.L$3 = null;
                                                    this.L$5 = it;
                                                    this.I$0 = i3;
                                                    this.label = (byte) 1;
                                                    if (job.join(this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    i2 = i3;
                                                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                                                    handlerContext = MainDispatcherLoader.dispatcher;
                                                    anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                                    this.L$2 = null;
                                                    this.L$3 = th;
                                                    this.L$5 = null;
                                                    this.I$0 = i2;
                                                    this.label = (byte) 4;
                                                    if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                                                        throw th;
                                                    }
                                                }
                                            }
                                            musicDatabase = this.$database;
                                            playlist = this.$playlist;
                                            arrayListFilterNotNull = ArraysKt.filterNotNull(strArr);
                                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull, 10));
                                            size = arrayListFilterNotNull.size();
                                            i4 = 0;
                                            while (i4 < size) {
                                                Object obj3 = arrayListFilterNotNull.get(i4);
                                                i4++;
                                                arrayList.add(new Pair((String) obj3, null));
                                            }
                                            z = this.$addToPlaylistPosition.prepend;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.L$5 = null;
                                            this.I$0 = i3;
                                            this.label = (byte) 2;
                                            if (musicDatabase.$$delegate_0.addSongsToPlaylist(playlist, arrayList, z, this) != coroutineSingletons) {
                                                i2 = i3;
                                                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                                                handlerContext2 = MainDispatcherLoader.dispatcher;
                                                anonymousClass2 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.I$0 = i2;
                                                this.label = (byte) 3;
                                                if (AwaitKt.withContext(handlerContext2, anonymousClass2, this) != coroutineSingletons) {
                                                    return unit;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            i2 = i9;
                                        }
                                        return coroutineSingletons;
                                    }
                                    if (b != 2) {
                                        if (b == 3) {
                                            ResultKt.throwOnFailure(obj);
                                            return unit;
                                        }
                                        if (b != 4) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                            return null;
                                        }
                                        Throwable th5 = this.L$3;
                                        ResultKt.throwOnFailure(obj);
                                        throw th5;
                                    }
                                    i2 = this.I$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                                        handlerContext2 = MainDispatcherLoader.dispatcher;
                                        anonymousClass2 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.I$0 = i2;
                                        this.label = (byte) 3;
                                        if (AwaitKt.withContext(handlerContext2, anonymousClass2, this) != coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        return unit;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                                        handlerContext = MainDispatcherLoader.dispatcher;
                                        anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                        this.L$2 = null;
                                        this.L$3 = th;
                                        this.L$5 = null;
                                        this.I$0 = i2;
                                        this.label = (byte) 4;
                                        if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                                            throw th;
                                        }
                                    }
                                    DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                                    handlerContext = MainDispatcherLoader.dispatcher;
                                    anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 3, null, function1);
                                    this.L$2 = null;
                                    this.L$3 = th;
                                    this.L$5 = null;
                                    this.I$0 = i2;
                                    this.label = (byte) 4;
                                    if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    throw th;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                MutableState mutableState4 = mutableState3;
                                Playlist playlist3 = playlist2;
                                mutableState4.setValue(playlist3);
                                DefaultScheduler defaultScheduler = Dispatchers.Default;
                                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                Function1 function4 = function3;
                                Function0 function5 = function0;
                                SnapshotStateList snapshotStateList2 = snapshotStateList;
                                Function1 function6 = function1;
                                MusicDatabase musicDatabase2 = musicDatabase;
                                AddToPlaylistPosition addToPlaylistPosition2 = addToPlaylistPosition;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                AwaitKt.launch$default(coroutineScope2, defaultIoScheduler, null, new AnonymousClass1(function5, snapshotStateList2, function6, musicDatabase2, playlist3, addToPlaylistPosition2, coroutineScope2, function2, function4, null), 2);
                                return Unit.INSTANCE;
                            }
                        };
                        playlist = playlist2;
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        playlist = playlist2;
                    }
                    MenuKt.PlaylistListItem(playlist, ImageKt.m46clickableoSLSa3U$default(modifierM39backgroundbw27NRU, false, null, (Function0) objRememberedValue, 15), false, null, null, gapComposer, 0, 28);
                    gapComposer.end(false);
                }
                break;
            default:
                final MutableState mutableState4 = (MutableState) obj5;
                final PlayerConnection playerConnection = (PlayerConnection) obj9;
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                State state = (State) obj12;
                List list = (List) obj13;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                int i3 = i2;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i3 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Song song3 = (Song) ((List) obj8).get(iIntValue3);
                    gapComposer2.startReplaceGroup(-1778824098);
                    boolean zChangedInstance = gapComposer2.changedInstance(list) | gapComposer2.changed(song3);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1(list, song3, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    final Function1 function4 = (Function1) objRememberedValue2;
                    String str = song3.song.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                    boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) ((State) obj7).getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                    boolean zChangedInstance2 = gapComposer2.changedInstance((HapticFeedback) obj11) | gapComposer2.changed(mutableState) | gapComposer2.changed(function4) | gapComposer2.changed(this.$showProgressDialog$delegate) | gapComposer2.changed(song3) | gapComposer2.changedInstance((List) obj10);
                    if ((((i3 & 112) ^ 48) <= 32 || !gapComposer2.changed(iIntValue3)) && (i3 & 48) != 32) {
                        z = false;
                    }
                    boolean zChangedInstance3 = zChangedInstance2 | z | gapComposer2.changedInstance(list);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1((HapticFeedback) obj11, function4, song3, iIntValue3, (List) obj10, (List) obj13, this.$showColorPickerDialog$delegate, this.$showProgressDialog$delegate, (byte) 2);
                        song = song3;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        song = song3;
                    }
                    Function0 function5 = (Function0) objRememberedValue3;
                    boolean zChangedInstance4 = gapComposer2.changedInstance(list) | gapComposer2.changed(mutableState) | gapComposer2.changed(function4) | gapComposer2.changed(song) | gapComposer2.changed(state) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(mutableState4);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        final List list2 = (List) obj13;
                        final MutableState mutableState5 = this.$showColorPickerDialog$delegate;
                        final State state2 = (State) obj12;
                        song2 = song;
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.playlist.CachePlaylistScreenKt$CachePlaylistScreen$4$1$1$4$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                SongEntity songEntity = song2.song;
                                if (TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState5)) {
                                    function4.invoke(Boolean.valueOf(!list2.contains(songEntity.id)));
                                } else {
                                    String str2 = songEntity.id;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                                    boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                    PlayerConnection playerConnection2 = playerConnection;
                                    if (zAreEqual2) {
                                        playerConnection2.togglePlayPause();
                                    } else {
                                        MutableState mutableState6 = mutableState4;
                                        List list3 = (List) mutableState6.getValue();
                                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                                        Iterator it = list3.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                                        }
                                        Iterator it2 = ((List) mutableState6.getValue()).iterator();
                                        int i4 = 0;
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                i4 = -1;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(((Song) it2.next()).song.id, songEntity.id)) {
                                                break;
                                            }
                                            i4++;
                                        }
                                        playerConnection2.playQueue(new ListQueue("Cache Songs", arrayList, i4, 0L, 8, null));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        song2 = song;
                    }
                    MenuKt.SongListItem(song2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function5, (Function0) objRememberedValue4, 239), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(1095740304, new AlbumScreenKt$AlbumScreen$3$1$4$3((List) obj13, song2, function4, (MenuState) obj6, this.$showColorPickerDialog$delegate, (byte) 2), gapComposer2), null, gapComposer2, 24576, 384, 10732);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }

    public ExperimentalLyricsKt$ExperimentalLyrics$19$1(List list, Function1 function1, CoroutineScope coroutineScope, Function0 function0, SnapshotStateList snapshotStateList, Function1 function2, MusicDatabase musicDatabase, Function1 function3, AddToPlaylistPosition addToPlaylistPosition, MutableState mutableState, MutableState mutableState2) {
        this.$mediaMetadata$delegate = list;
        this.$context = function1;
        this.$scope = coroutineScope;
        this.$title = function0;
        this.$arts = snapshotStateList;
        this.$txt = function2;
        this.$configuration = musicDatabase;
        this.$density = function3;
        this.$lyricsTextPosition$delegate = addToPlaylistPosition;
        this.$showColorPickerDialog$delegate = mutableState;
        this.$showProgressDialog$delegate = mutableState2;
    }

    public ExperimentalLyricsKt$ExperimentalLyrics$19$1(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Context context, String str, String str2, String str3, Configuration configuration, Density density, MutableState mutableState3, ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2) {
        this.$scope = coroutineScope;
        this.$showColorPickerDialog$delegate = mutableState;
        this.$showProgressDialog$delegate = mutableState2;
        this.$context = context;
        this.$title = str;
        this.$arts = str2;
        this.$txt = str3;
        this.$configuration = configuration;
        this.$density = density;
        this.$mediaMetadata$delegate = mutableState3;
        this.$lyricsTextPosition$delegate = experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2;
    }
}
