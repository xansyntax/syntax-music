package com.metrolist.music.viewmodels;

import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.LinkStateInteractionSourceObserver;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.media3.common.MediaItem;
import coil3.ImageLoader$Builder;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.lyrics.LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1$2$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.MusicService$onCreate$11$2$1;
import com.metrolist.music.ui.component.ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$2$1 implements FlowCollector {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $wasOffline;
    public final /* synthetic */ Object this$0;

    public HomeViewModel$2$1(MusicService musicService, Ref$BooleanRef ref$BooleanRef) {
        this.$r8$classId = (byte) 6;
        this.this$0 = musicService;
        this.$wasOffline = ref$BooleanRef;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    /* JADX WARN: Code duplicated, block: B:136:0x026b  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:168:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:32:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:76:0x0137  */
    /* JADX WARN: Code duplicated, block: B:98:0x0175  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        MappedInteractionSource$special$$inlined$map$1$2$1 mappedInteractionSource$special$$inlined$map$1$2$1;
        PressInteraction.Release release;
        PressInteraction.Cancel cancel;
        Object release2;
        LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1 lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1;
        DownloadUtil$getDownload$$inlined$map$1$2$1 downloadUtil$getDownload$$inlined$map$1$2$1;
        String str;
        OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1;
        FlowKt__ErrorsKt$catchImpl$2$emit$1 flowKt__ErrorsKt$catchImpl$2$emit$1;
        FlowKt__LimitKt$drop$2$1$emit$1 flowKt__LimitKt$drop$2$1$emit$1;
        FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1 flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1;
        FlowCollector flowCollector;
        Object obj2 = obj;
        byte b = this.$r8$classId;
        byte b2 = 0;
        int i = 0;
        int i2 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation2 = null;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.$wasOffline;
        Object obj4 = this.this$0;
        switch (b) {
            case 0:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj3;
                if (!((Boolean) obj2).booleanValue()) {
                    ref$BooleanRef.element = true;
                } else if (ref$BooleanRef.element) {
                    ref$BooleanRef.element = false;
                    ((HomeViewModel) obj4).refresh();
                }
                return unit;
            case 1:
                Interaction interaction = (Interaction) obj2;
                LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) obj4;
                MutableObjectList mutableObjectList = (MutableObjectList) obj3;
                if ((interaction instanceof HoverInteraction$Enter) || (interaction instanceof FocusInteraction.Focus) || (interaction instanceof PressInteraction.Press)) {
                    mutableObjectList.add(interaction);
                } else if (interaction instanceof HoverInteraction$Exit) {
                    mutableObjectList.remove(((HoverInteraction$Exit) interaction).enter);
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    mutableObjectList.remove(((FocusInteraction.Unfocus) interaction).focus);
                } else if (interaction instanceof PressInteraction.Release) {
                    mutableObjectList.remove(((PressInteraction.Release) interaction).press);
                } else if (interaction instanceof PressInteraction.Cancel) {
                    mutableObjectList.remove(((PressInteraction.Cancel) interaction).press);
                }
                Object[] objArr = mutableObjectList.content;
                int i3 = mutableObjectList._size;
                int i4 = 0;
                while (b2 < i3) {
                    Interaction interaction2 = (Interaction) objArr[b2];
                    if (interaction2 instanceof HoverInteraction$Enter) {
                        linkStateInteractionSourceObserver.getClass();
                        i4 |= 2;
                    } else if (interaction2 instanceof FocusInteraction.Focus) {
                        linkStateInteractionSourceObserver.getClass();
                        i4 |= 1;
                    } else if (interaction2 instanceof PressInteraction.Press) {
                        linkStateInteractionSourceObserver.getClass();
                        i4 |= 4;
                    }
                    b2++;
                }
                linkStateInteractionSourceObserver.interactionState.setIntValue(i4);
                return unit;
            case 2:
                Offset offset = (Offset) obj2;
                long j = offset.packedValue;
                Animatable animatable = (Animatable) obj3;
                if ((((Offset) animatable.getValue()).packedValue & 9223372034707292159L) == 9205357640488583168L || (j & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((Offset) animatable.getValue()).packedValue & 4294967295L)) == Float.intBitsToFloat((int) (j & 4294967295L))) {
                    Object objSnapTo = animatable.snapTo(offset, continuation);
                    return objSnapTo == coroutineSingletons ? objSnapTo : unit;
                }
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new AndroidViewHolder.C00381(animatable, j, null, (byte) 1), 3);
                return unit;
            case 3:
                MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) obj4;
                LinkedHashMap linkedHashMap = mappedInteractionSource.mappedPresses;
                if (continuation instanceof MappedInteractionSource$special$$inlined$map$1$2$1) {
                    mappedInteractionSource$special$$inlined$map$1$2$1 = (MappedInteractionSource$special$$inlined$map$1$2$1) continuation;
                    int i5 = mappedInteractionSource$special$$inlined$map$1$2$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        mappedInteractionSource$special$$inlined$map$1$2$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        mappedInteractionSource$special$$inlined$map$1$2$1 = new MappedInteractionSource$special$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    mappedInteractionSource$special$$inlined$map$1$2$1 = new MappedInteractionSource$special$$inlined$map$1$2$1(this, continuation);
                }
                Object obj5 = mappedInteractionSource$special$$inlined$map$1$2$1.result;
                int i6 = mappedInteractionSource$special$$inlined$map$1$2$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    FlowCollector flowCollector2 = (FlowCollector) obj3;
                    Interaction interaction3 = (Interaction) obj2;
                    if (interaction3 instanceof PressInteraction.Press) {
                        PressInteraction.Press press = new PressInteraction.Press(Offset.m438minusMKHz9U(((PressInteraction.Press) interaction3).pressPosition, ((Offset) mappedInteractionSource.calculateDelta.invoke()).packedValue));
                        linkedHashMap.put(interaction3, press);
                        release2 = press;
                    } else if (interaction3 instanceof PressInteraction.Cancel) {
                        cancel = (PressInteraction.Cancel) interaction3;
                        PressInteraction.Press press2 = (PressInteraction.Press) linkedHashMap.remove(cancel.press);
                        if (press2 != null) {
                            release2 = cancel;
                            release2 = new PressInteraction.Cancel(press2);
                        }
                    } else if (interaction3 instanceof PressInteraction.Release) {
                        release = (PressInteraction.Release) interaction3;
                        PressInteraction.Press press3 = (PressInteraction.Press) linkedHashMap.remove(release.press);
                        if (press3 != null) {
                            release2 = interaction3;
                            release2 = release;
                            release2 = new PressInteraction.Release(press3);
                        }
                    }
                    release2 = interaction3;
                    release2 = release;
                    release2 = interaction3;
                    release2 = cancel;
                    mappedInteractionSource$special$$inlined$map$1$2$1.label = 1;
                    if (flowCollector2.emit(release2, mappedInteractionSource$special$$inlined$map$1$2$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i6 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj5);
                }
                return unit;
            case 4:
                if (continuation instanceof LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1) {
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1 = (LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1) continuation;
                    int i7 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1 = new LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1 = new LyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1(this, continuation);
                }
                Object obj6 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1.result;
                int i8 = lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    ((ImageLoader$Builder) obj4).getClass();
                    ArrayList arrayListResolveLyricsProviders = ImageLoader$Builder.resolveLyricsProviders((MutablePreferences) obj2);
                    lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1.label = 1;
                    if (((FlowCollector) obj3).emit(arrayListResolveLyricsProviders, lyricsHelper$getAllLyrics$3$invokeSuspend$$inlined$map$1$2$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i8 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                }
                return unit;
            case 5:
                if (continuation instanceof DownloadUtil$getDownload$$inlined$map$1$2$1) {
                    downloadUtil$getDownload$$inlined$map$1$2$1 = (DownloadUtil$getDownload$$inlined$map$1$2$1) continuation;
                    int i9 = downloadUtil$getDownload$$inlined$map$1$2$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        downloadUtil$getDownload$$inlined$map$1$2$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        downloadUtil$getDownload$$inlined$map$1$2$1 = new DownloadUtil$getDownload$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    downloadUtil$getDownload$$inlined$map$1$2$1 = new DownloadUtil$getDownload$$inlined$map$1$2$1(this, continuation);
                }
                Object obj7 = downloadUtil$getDownload$$inlined$map$1$2$1.result;
                int i10 = downloadUtil$getDownload$$inlined$map$1$2$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    Object obj8 = ((Map) obj2).get((String) obj4);
                    downloadUtil$getDownload$$inlined$map$1$2$1.label = 1;
                    if (((FlowCollector) obj3).emit(obj8, downloadUtil$getDownload$$inlined$map$1$2$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj7);
                }
                return unit;
            case 6:
                AudioQuality audioQuality = (AudioQuality) obj2;
                MusicService musicService = (MusicService) obj4;
                AudioQuality audioQuality2 = musicService.audioQuality;
                if (audioQuality2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioQuality");
                    throw null;
                }
                musicService.audioQuality = audioQuality;
                Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) obj3;
                if (ref$BooleanRef2.element) {
                    ref$BooleanRef2.element = false;
                    Timber.Forest.tag("MusicService");
                    Objects.toString(audioQuality);
                    ConnectionPool.i(new Object[0]);
                } else {
                    ConnectionPool connectionPool = Timber.Forest;
                    connectionPool.tag("MusicService");
                    audioQuality2.toString();
                    Objects.toString(audioQuality);
                    ConnectionPool.i(new Object[0]);
                    MediaItem currentMediaItem = musicService.player.getCurrentMediaItem();
                    if (currentMediaItem != null && (str = currentMediaItem.mediaId) != null) {
                        long currentPosition = musicService.player.getCurrentPosition();
                        boolean zIsPlaying = musicService.player.isPlaying();
                        int currentMediaItemIndex = musicService.player.getCurrentMediaItemIndex();
                        connectionPool.tag("MusicService");
                        ConnectionPool.i(new Object[0]);
                        musicService.songUrlCache.invalidate(str);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new MusicService$onCreate$11$2$1(musicService, str, continuation2, b2));
                        musicService.bypassCacheForQualityChange.add(str);
                        connectionPool.tag("MusicService");
                        "Set bypass cache flag for ".concat(str);
                        ConnectionPool.d(new Object[0]);
                        musicService.player.stop();
                        musicService.player.seekTo(currentMediaItemIndex, currentPosition, false);
                        musicService.player.prepare();
                        if (zIsPlaying) {
                            musicService.player.setPlayWhenReady(true);
                        }
                    }
                }
                return unit;
            case 7:
                return emit((Album) obj2, continuation);
            case 8:
                if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1) {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1) continuation;
                    int i11 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1(this, continuation);
                    }
                } else {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1(this, continuation);
                }
                Object obj9 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1.result;
                int i12 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    FlowCollector flowCollector3 = (FlowCollector) obj3;
                    List list = (List) obj2;
                    YTItem yTItem = (YTItem) obj4;
                    EmptyList emptyList = EmptyList.INSTANCE;
                    SearchSuggestionViewState searchSuggestionViewState = new SearchSuggestionViewState(list, emptyList, yTItem != null ? CollectionsKt__IterablesKt.listOf(yTItem) : emptyList, (YTItem) obj4, true);
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1.label = 1;
                    if (flowCollector3.emit(searchSuggestionViewState, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$2$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i12 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj9);
                }
                return unit;
            case 9:
                if (continuation instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) {
                    flowKt__ErrorsKt$catchImpl$2$emit$1 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) continuation;
                    int i13 = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        flowKt__ErrorsKt$catchImpl$2$emit$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, continuation);
                    }
                } else {
                    flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, continuation);
                }
                Object obj10 = flowKt__ErrorsKt$catchImpl$2$emit$1.result;
                int i14 = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
                try {
                    if (i14 == 0) {
                        ResultKt.throwOnFailure(obj10);
                        flowKt__ErrorsKt$catchImpl$2$emit$1.label = 1;
                        if (((FlowCollector) obj3).emit(obj2, flowKt__ErrorsKt$catchImpl$2$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i14 != 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj10);
                    }
                    return unit;
                } catch (Throwable th) {
                    ((Ref$ObjectRef) obj4).element = th;
                    throw th;
                }
            case 10:
                if (continuation instanceof FlowKt__LimitKt$drop$2$1$emit$1) {
                    flowKt__LimitKt$drop$2$1$emit$1 = (FlowKt__LimitKt$drop$2$1$emit$1) continuation;
                    int i15 = flowKt__LimitKt$drop$2$1$emit$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$drop$2$1$emit$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$drop$2$1$emit$1 = new FlowKt__LimitKt$drop$2$1$emit$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$drop$2$1$emit$1 = new FlowKt__LimitKt$drop$2$1$emit$1(this, continuation);
                }
                Object obj11 = flowKt__LimitKt$drop$2$1$emit$1.result;
                int i16 = flowKt__LimitKt$drop$2$1$emit$1.label;
                if (i16 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    Ref$IntRef ref$IntRef = (Ref$IntRef) obj3;
                    int i17 = ref$IntRef.element;
                    if (i17 >= 1) {
                        flowKt__LimitKt$drop$2$1$emit$1.label = 1;
                        if (((FlowCollector) obj4).emit(obj2, flowKt__LimitKt$drop$2$1$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        ref$IntRef.element = i17 + 1;
                    }
                } else {
                    if (i16 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                }
                return unit;
            case 11:
                if (continuation instanceof FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1) {
                    flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1 = (FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1) continuation;
                    int i18 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.label;
                    if ((i18 & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.label = i18 - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1 = new FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1 = new FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1(this, continuation);
                }
                Object objInvoke = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.result;
                int i19 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.label;
                if (i19 != 0) {
                    if (i19 == 1) {
                        i2 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.I$0;
                        obj2 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.L$2;
                        ResultKt.throwOnFailure(objInvoke);
                    } else {
                        if (i19 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(objInvoke);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(objInvoke);
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.L$2 = obj2;
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.I$0 = 0;
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.label = 1;
                objInvoke = ((Recomposer$join$2) obj3).invoke(obj2, flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1);
                if (objInvoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (!((Boolean) objInvoke).booleanValue()) {
                    throw new AbortFlowException(this);
                }
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.L$2 = null;
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.I$0 = i2;
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1.label = 2;
                if (((FlowCollector) obj4).emit(obj2, flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (continuation instanceof FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1) {
                    flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 = (FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1) continuation;
                    int i20 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.label;
                    if ((i20 & Integer.MIN_VALUE) != 0) {
                        flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.label = i20 - Integer.MIN_VALUE;
                    } else {
                        flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1(this, continuation);
                    }
                } else {
                    flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1(this, continuation);
                }
                Object obj12 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.result;
                int i21 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.label;
                if (i21 != 0) {
                    if (i21 == 1) {
                        i = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.I$0;
                        FlowCollector flowCollector4 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$3;
                        Object obj13 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$2;
                        ResultKt.throwOnFailure(obj12);
                        flowCollector = flowCollector4;
                        obj2 = obj13;
                    } else {
                        if (i21 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj12);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj12);
                flowCollector = (FlowCollector) obj3;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$2 = obj2;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$3 = flowCollector;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.I$0 = 0;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.label = 1;
                if (((PlaylistWidgetManager$observeQuickPickChanges$7) obj4).invoke(obj2, flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$2 = null;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.L$3 = null;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.I$0 = i;
                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.label = 2;
                if (flowCollector.emit(obj2, flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            default:
                return emit(((Number) obj2).intValue(), continuation);
        }
    }

    public /* synthetic */ HomeViewModel$2$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$wasOffline = obj;
        this.this$0 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object emit(int i, Continuation continuation) {
        StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1;
        if (continuation instanceof StartedLazily$command$1$1$emit$1) {
            startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) continuation;
            int i2 = startedLazily$command$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                startedLazily$command$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
            } else {
                startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, continuation);
            }
        } else {
            startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, continuation);
        }
        Object obj = startedLazily$command$1$1$emit$1.result;
        int i3 = startedLazily$command$1$1$emit$1.label;
        Unit unit = Unit.INSTANCE;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (i > 0) {
            Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.$wasOffline;
            if (!ref$BooleanRef.element) {
                ref$BooleanRef.element = true;
                FlowCollector flowCollector = (FlowCollector) this.this$0;
                startedLazily$command$1$1$emit$1.label = 1;
                Object objEmit = flowCollector.emit(SharingCommand.START, startedLazily$command$1$1$emit$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEmit == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object emit(Album album, Continuation continuation) {
        YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1 youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1;
        Object objM996album0E7RQCE;
        if (continuation instanceof YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1) {
            youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1 = (YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1) continuation;
            int i = youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1 = new YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1(this, continuation);
            }
        } else {
            youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1 = new YouTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1(this, continuation);
        }
        Object obj = youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1.result;
        int i2 = youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1.label;
        byte b = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (album == null) {
                YouTube youTube = YouTube.INSTANCE;
                String str = ((AlbumItem) this.$wasOffline).id;
                youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1.label = 1;
                objM996album0E7RQCE = YouTube.INSTANCE.m996album0E7RQCE(str, true, youTubeAlbumMenuKt$YouTubeAlbumMenu$1$1$1$emit$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM996album0E7RQCE == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            objM996album0E7RQCE = ((Result) obj).value;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        MusicDatabase musicDatabase = (MusicDatabase) this.this$0;
        if (!(objM996album0E7RQCE instanceof Result.Failure)) {
            musicDatabase.transaction(new ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0((AlbumPage) objM996album0E7RQCE, b));
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM996album0E7RQCE);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
