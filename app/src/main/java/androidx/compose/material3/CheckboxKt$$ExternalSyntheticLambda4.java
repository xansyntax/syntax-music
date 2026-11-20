package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SuspendAnimationKt$$ExternalSyntheticLambda2;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import coil3.util.LifecyclesKt;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CheckboxKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(float f, Transition.TransitionAnimationState transitionAnimationState, Transition.TransitionAnimationState transitionAnimationState2, CheckDrawingCache checkDrawingCache, State state, State state2, AnimateAsState animateAsState) {
        this.f$2 = f;
        this.f$3 = transitionAnimationState;
        this.f$4 = transitionAnimationState2;
        this.f$6 = checkDrawingCache;
        this.f$7 = state;
        this.f$8 = state2;
        this.f$9 = animateAsState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float f;
        byte b = this.$r8$classId;
        Object obj2 = this.f$4;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$6;
        Object obj4 = this.f$3;
        Object obj5 = this.f$9;
        Object obj6 = this.f$8;
        Object obj7 = this.f$7;
        switch (b) {
            case 0:
                State state = (State) obj4;
                State state2 = (State) obj2;
                CheckDrawingCache checkDrawingCache = (CheckDrawingCache) obj3;
                State state3 = (State) obj5;
                DrawScope drawScope = (DrawScope) obj;
                long j = ((Color) ((State) obj7).getValue()).value;
                long j2 = ((Color) ((State) obj6).getValue()).value;
                float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(2.0f);
                float f2 = this.f$2;
                Stroke stroke = new Stroke(f2, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30);
                float f3 = stroke.width;
                float f4 = f3 / 2.0f;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(j, j2);
                Fill fill = Fill.INSTANCE;
                if (zM1869equalsimpl0) {
                    f = 0.0f;
                    DrawScope.m552drawRoundRectuAw5IA$default(drawScope, j, 0L, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) & 4294967295L), fill, 226);
                } else {
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
                    float f5 = fIntBitsToFloat - (f3 * 2.0f);
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L);
                    float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fMo81toPx0680j_4 - f3);
                    long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L);
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                    DrawScope.m552drawRoundRectuAw5IA$default(drawScope, j, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits3, fill, 224);
                    float f6 = fIntBitsToFloat - f3;
                    float f7 = fMo81toPx0680j_4 - f4;
                    DrawScope.m552drawRoundRectuAw5IA$default(drawScope, j2, (((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L), (((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L), stroke, 224);
                }
                long j3 = ((Color) state3.getValue()).value;
                float fFloatValue = ((Number) state.getValue()).floatValue();
                float fFloatValue2 = ((Number) state2.getValue()).floatValue();
                Stroke stroke2 = new Stroke(f2, CropImageView.DEFAULT_ASPECT_RATIO, 2, 0, 26);
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                float fLerp = LifecyclesKt.lerp(0.4f, 0.5f, fFloatValue2);
                float fLerp2 = LifecyclesKt.lerp(0.7f, 0.5f, fFloatValue2);
                float fLerp3 = LifecyclesKt.lerp(0.5f, 0.5f, fFloatValue2);
                float fLerp4 = LifecyclesKt.lerp(0.3f, 0.5f, fFloatValue2);
                AndroidPath androidPath = checkDrawingCache.checkPath;
                AndroidPath androidPath2 = checkDrawingCache.pathToDraw;
                androidPath.rewind();
                AndroidPath androidPath3 = checkDrawingCache.checkPath;
                androidPath3.moveTo(0.2f * fIntBitsToFloat2, fLerp3 * fIntBitsToFloat2);
                androidPath3.lineTo(fLerp * fIntBitsToFloat2, fLerp2 * fIntBitsToFloat2);
                androidPath3.lineTo(0.8f * fIntBitsToFloat2, fIntBitsToFloat2 * fLerp4);
                AndroidPathMeasure androidPathMeasure = checkDrawingCache.pathMeasure;
                androidPathMeasure.setPath(androidPath3);
                androidPath2.rewind();
                androidPathMeasure.getSegment(f, androidPathMeasure.internalPathMeasure.getLength() * fFloatValue, androidPath2);
                DrawScope.m548drawPathLG529CI$default(drawScope, androidPath2, j3, CropImageView.DEFAULT_ASPECT_RATIO, stroke2, 52);
                break;
            case 1:
                Animation animation = (Animation) obj7;
                AnimationState animationState = (AnimationState) obj5;
                long jLongValue = ((Long) obj).longValue();
                AnimationScope animationScope = new AnimationScope(this.f$4, animation.getTypeConverter(), (AnimationVector) obj6, jLongValue, animation.getTargetValue(), jLongValue, new SuspendAnimationKt$$ExternalSyntheticLambda2(animationState, (byte) 1));
                ArcSplineKt.doAnimationFrameWithScale(animationScope, jLongValue, this.f$2, animation, animationState, (Function1) obj3);
                ((Ref$ObjectRef) obj4).element = animationScope;
                break;
            default:
                final HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                final MenuState menuState = (MenuState) obj5;
                final State state4 = (State) obj4;
                final PlayerConnection playerConnection = (PlayerConnection) obj3;
                final State state5 = (State) obj2;
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                ArrayList arrayList = ((ChartsPage.ChartSection) obj7).items;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj8 = arrayList.get(i2);
                    i2++;
                    if (obj8 instanceof SongItem) {
                        arrayList2.add(obj8);
                    }
                }
                HashSet hashSet = new HashSet();
                final ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj9 = arrayList2.get(i);
                    i++;
                    if (hashSet.add(((SongItem) obj9).id)) {
                        arrayList3.add(obj9);
                    }
                }
                QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda3 = new QueueKt$$ExternalSyntheticLambda3((byte) 8);
                int size3 = arrayList3.size();
                Latch$await$2$2 latch$await$2$2 = new Latch$await$2$2(queueKt$$ExternalSyntheticLambda3, arrayList3, (byte) 28);
                AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass3 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList3, (byte) 9);
                final float f8 = this.f$2;
                lazyGridIntervalContent.items(size3, latch$await$2$2, null, anonymousClass3, new ComposableLambdaImpl(true, -1942245546, new Function4() { // from class: com.metrolist.music.ui.screens.ChartsScreenKt$ChartsScreen$lambda$7$0$0$0$1$1$0$1$0$$inlined$itemsIndexed$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj10, Object obj11, Object obj12, Object obj13) {
                        int i3;
                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                        int iIntValue = ((Number) obj11).intValue();
                        Composer composer = (Composer) obj12;
                        int iIntValue2 = ((Number) obj13).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i3 = (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i3 = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i3 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                        }
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                            final SongItem songItem = (SongItem) arrayList3.get(iIntValue);
                            gapComposer.startReplaceGroup(-1210262853);
                            int i4 = iIntValue + 1;
                            String str = songItem.id;
                            final State state6 = state4;
                            MediaMetadata mediaMetadata = (MediaMetadata) state6.getValue();
                            boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                            boolean zBooleanValue = ((Boolean) state5.getValue()).booleanValue();
                            Modifier modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(Modifier.Companion.$$INSTANCE, f8);
                            HapticFeedback hapticFeedback2 = hapticFeedback;
                            boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback2);
                            MenuState menuState2 = menuState;
                            boolean zChanged = zChangedInstance | gapComposer.changed(menuState2) | gapComposer.changedInstance(songItem);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new ChartsScreenKt$ChartsScreen$3$1$1$1$4$1$1$1$3$1$1(hapticFeedback2, menuState2, songItem, (byte) 1);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            boolean zChangedInstance2 = gapComposer.changedInstance(songItem) | gapComposer.changed(state6);
                            final PlayerConnection playerConnection2 = playerConnection;
                            boolean zChangedInstance3 = zChangedInstance2 | gapComposer.changedInstance(playerConnection2);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.ChartsScreenKt$ChartsScreen$3$1$1$1$2$2$1$1$1$4$2$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        SongItem songItem2 = songItem;
                                        String str2 = songItem2.id;
                                        MediaMetadata mediaMetadata2 = (MediaMetadata) state6.getValue();
                                        boolean zAreEqual2 = Intrinsics.areEqual(str2, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                        PlayerConnection playerConnection3 = playerConnection2;
                                        if (zAreEqual2) {
                                            playerConnection3.togglePlayPause();
                                        } else {
                                            playerConnection3.playQueue(new YouTubeQueue(new WatchEndpoint(62, str2, null, null), HexFormatKt.toMediaMetadata(songItem2)));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            MenuKt.YouTubeListItem(songItem, ImageKt.m48combinedClickablehoGz1lA$default(modifierM155width3ABfNKs, false, function0, (Function0) objRememberedValue2, 239), false, zAreEqual, zBooleanValue, false, Integer.valueOf(i4), Expect_jvmKt.rememberComposableLambda(1215019454, new HomeScreenKt$HomeScreen$10$1$1$1$9$16$2$2$1$3$3(menuState2, songItem, (byte) 3), gapComposer), null, gapComposer, 102236160, 524);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
        }
        return unit;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(ChartsPage.ChartSection chartSection, float f, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, State state2) {
        this.f$7 = chartSection;
        this.f$2 = f;
        this.f$8 = hapticFeedback;
        this.f$9 = menuState;
        this.f$3 = state;
        this.f$6 = playerConnection;
        this.f$4 = state2;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(Ref$ObjectRef ref$ObjectRef, Object obj, Animation animation, AnimationVector animationVector, AnimationState animationState, float f, Function1 function1) {
        this.f$3 = ref$ObjectRef;
        this.f$4 = obj;
        this.f$7 = animation;
        this.f$8 = animationVector;
        this.f$9 = animationState;
        this.f$2 = f;
        this.f$6 = function1;
    }
}
