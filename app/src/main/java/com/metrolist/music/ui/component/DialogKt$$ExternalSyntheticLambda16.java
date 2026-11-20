package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.KeyboardActionRunner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.emoji2.text.EmojiProcessor;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.text.HexFormatKt;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda16 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda16(List list, NavHostController navHostController, boolean z, PlayerConnection playerConnection) {
        this.$r8$classId = (byte) 3;
        this.f$1 = list;
        this.f$0 = navHostController;
        this.f$2 = z;
        this.f$3 = playerConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$3;
        final boolean z = this.f$2;
        Object obj3 = this.f$0;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                Function1 function1 = (Function1) obj3;
                List list = (List) obj4;
                Function0 function0 = (Function0) obj2;
                ((KeyboardActionRunner) obj).getClass();
                if (function1 != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((TextFieldValue) ((Pair) it.next()).second).annotatedString.text);
                    }
                    function1.invoke(arrayList);
                    if (z) {
                        function0.invoke();
                    }
                }
                return unit;
            case 1:
                ImageBitmap imageBitmap = (ImageBitmap) obj3;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj4;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                if (((Boolean) ((Function0) obj2).invoke()).booleanValue()) {
                    if (z) {
                        long jMo555getCenterF1C5BW0 = canvasDrawScope.mo555getCenterF1C5BW0();
                        EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
                        long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                        emojiProcessor.getCanvas().save();
                        try {
                            ((DrawResult) emojiProcessor.mSpanFactory).m403scale0AR0LA0(-1.0f, 1.0f, jMo555getCenterF1C5BW0);
                            DrawScope.m545drawImagegbVJVH8$default(layoutNodeDrawScope, imageBitmap, blendModeColorFilter, 46);
                        } finally {
                            IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                        }
                    } else {
                        DrawScope.m545drawImagegbVJVH8$default(layoutNodeDrawScope, imageBitmap, blendModeColorFilter, 46);
                    }
                }
                return unit;
            case 2:
                Function0 function2 = (Function0) obj2;
                ((KeyboardActionRunner) obj).getClass();
                ((Function1) obj3).invoke(((TextFieldValue) ((MutableState) obj4).getValue()).annotatedString.text);
                if (z) {
                    function2.invoke();
                }
                return unit;
            default:
                final List list2 = (List) obj4;
                final NavHostController navHostController = (NavHostController) obj3;
                final PlayerConnection playerConnection = (PlayerConnection) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                lazyListIntervalContent.items(list2.size(), null, new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 18), list2, (byte) 15), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$8$5$0$0$0$$inlined$items$default$3
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) throws XmlPullParserException, IOException {
                        int i;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                        int iIntValue = ((Number) obj6).intValue();
                        Composer composer = (Composer) obj7;
                        int iIntValue2 = ((Number) obj8).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i = (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                        }
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                            CommunityPlaylistItem communityPlaylistItem = (CommunityPlaylistItem) list2.get(iIntValue);
                            gapComposer.startReplaceGroup(1659116553);
                            NavHostController navHostController2 = navHostController;
                            boolean zChangedInstance = gapComposer.changedInstance(navHostController2) | gapComposer.changedInstance(communityPlaylistItem);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new Http2Connection.ReaderRunnable(navHostController2, communityPlaylistItem, (byte) 9);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function3 = (Function0) objRememberedValue;
                            final boolean z2 = z;
                            boolean zChanged = gapComposer.changed(z2);
                            final PlayerConnection playerConnection2 = playerConnection;
                            boolean zChangedInstance2 = zChanged | gapComposer.changedInstance(playerConnection2);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$10$1$1$1$9$6$1$1$1$2$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj9) {
                                        SongItem songItem = (SongItem) obj9;
                                        songItem.getClass();
                                        if (!z2) {
                                            WatchEndpoint watchEndpoint = songItem.endpoint;
                                            if (watchEndpoint == null) {
                                                watchEndpoint = new WatchEndpoint(62, songItem.id, null, null);
                                            }
                                            playerConnection2.playQueue(new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem)));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            HomeScreenKt.CommunityPlaylistCard(communityPlaylistItem, function3, (Function1) objRememberedValue2, null, gapComposer, 8);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }));
                return unit;
        }
    }

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda16(Function0 function0, boolean z, ImageBitmap imageBitmap, BlendModeColorFilter blendModeColorFilter) {
        this.$r8$classId = (byte) 1;
        this.f$3 = function0;
        this.f$2 = z;
        this.f$0 = imageBitmap;
        this.f$1 = blendModeColorFilter;
    }

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda16(Function1 function1, Object obj, boolean z, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = obj;
        this.f$2 = z;
        this.f$3 = function0;
    }
}
