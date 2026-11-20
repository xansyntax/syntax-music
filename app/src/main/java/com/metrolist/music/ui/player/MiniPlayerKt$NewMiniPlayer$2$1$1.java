package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MiniPlayerKt$NewMiniPlayer$2$1$1 implements PointerInputEventHandler {
    public final /* synthetic */ SpringSpec $animationSpec;
    public final /* synthetic */ int $autoSwipeThreshold;
    public final /* synthetic */ State $canSkipNext$delegate;
    public final /* synthetic */ State $canSkipPrevious$delegate;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $dragStartTime$delegate;
    public final /* synthetic */ LayoutDirection $layoutDirection;
    public final /* synthetic */ Animatable $offsetXAnimatable;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 $swipeSensitivity$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $totalDragDistance$delegate;

    public /* synthetic */ MiniPlayerKt$NewMiniPlayer$2$1$1(ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Animatable animatable, int i, PlayerConnection playerConnection, CoroutineScope coroutineScope, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState, MutableState mutableState2, SpringSpec springSpec, LayoutDirection layoutDirection, byte b) {
        this.$r8$classId = b;
        this.$dragStartTime$delegate = parcelableSnapshotMutableLongState;
        this.$totalDragDistance$delegate = parcelableSnapshotMutableFloatState;
        this.$offsetXAnimatable = animatable;
        this.$autoSwipeThreshold = i;
        this.$playerConnection = playerConnection;
        this.$coroutineScope = coroutineScope;
        this.$swipeSensitivity$delegate = dataStoreKt$rememberPreference$1$1;
        this.$canSkipPrevious$delegate = mutableState;
        this.$canSkipNext$delegate = mutableState2;
        this.$animationSpec = springSpec;
        this.$layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$dragStartTime$delegate;
                final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$totalDragDistance$delegate;
                final byte b2 = 0;
                Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        byte b3 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState;
                        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = parcelableSnapshotMutableLongState;
                        switch (b3) {
                            case 0:
                                parcelableSnapshotMutableLongState2.setLongValue(System.currentTimeMillis());
                                parcelableSnapshotMutableFloatState2.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                parcelableSnapshotMutableLongState2.setLongValue(System.currentTimeMillis());
                                parcelableSnapshotMutableFloatState2.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit2;
                    }
                };
                final byte b3 = 0;
                final Animatable animatable = this.$offsetXAnimatable;
                final int i = this.$autoSwipeThreshold;
                final PlayerConnection playerConnection = this.$playerConnection;
                final CoroutineScope coroutineScope = this.$coroutineScope;
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.$swipeSensitivity$delegate;
                final State state = this.$canSkipPrevious$delegate;
                final State state2 = this.$canSkipNext$delegate;
                final SpringSpec springSpec = this.$animationSpec;
                Function0 function0 = new Function0() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        SpringSpec springSpec2 = springSpec;
                        State state3 = state2;
                        State state4 = state;
                        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState;
                        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = parcelableSnapshotMutableLongState;
                        CoroutineScope coroutineScope2 = coroutineScope;
                        PlayerConnection playerConnection2 = playerConnection;
                        int i2 = i;
                        Animatable animatable2 = animatable;
                        switch (b4) {
                            case 0:
                                long jCurrentTimeMillis = System.currentTimeMillis() - parcelableSnapshotMutableLongState2.getLongValue();
                                float floatValue = jCurrentTimeMillis > 0 ? parcelableSnapshotMutableFloatState2.getFloatValue() / jCurrentTimeMillis : 0.0f;
                                float fFloatValue = ((Number) animatable2.getValue()).floatValue();
                                float fFloatValue2 = (((Number) dataStoreKt$rememberPreference$1$2.$state.getValue()).floatValue() * (-8.25f)) + 8.5f;
                                if ((Math.abs(fFloatValue) > 50.0f && floatValue > fFloatValue2) || Math.abs(fFloatValue) > i2) {
                                    if (fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state4.getValue()).booleanValue()) {
                                        playerConnection2.getPlayerSafe().seekToPreviousMediaItemInternal();
                                    } else if (fFloatValue <= CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state3.getValue()).booleanValue()) {
                                        playerConnection2.getPlayerSafe().seekToNext();
                                    }
                                }
                                AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable2, springSpec2, null, (byte) 0), 3);
                                break;
                            default:
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - parcelableSnapshotMutableLongState2.getLongValue();
                                float floatValue2 = jCurrentTimeMillis2 > 0 ? parcelableSnapshotMutableFloatState2.getFloatValue() / jCurrentTimeMillis2 : 0.0f;
                                float fFloatValue3 = ((Number) animatable2.getValue()).floatValue();
                                float fFloatValue4 = (((Number) dataStoreKt$rememberPreference$1$2.$state.getValue()).floatValue() * (-8.25f)) + 8.5f;
                                if ((Math.abs(fFloatValue3) > 50.0f && floatValue2 > fFloatValue4) || Math.abs(fFloatValue3) > i2) {
                                    if (fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state4.getValue()).booleanValue()) {
                                        playerConnection2.getPlayerSafe().seekToPreviousMediaItemInternal();
                                    } else if (fFloatValue3 <= CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state3.getValue()).booleanValue()) {
                                        playerConnection2.getPlayerSafe().seekToNext();
                                    }
                                }
                                AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable2, springSpec2, null, (byte) 1), 3);
                                break;
                        }
                        return unit2;
                    }
                };
                Function0 function2 = new Function0() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b4 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        SpringSpec springSpec2 = springSpec;
                        Animatable animatable2 = animatable;
                        CoroutineScope coroutineScope2 = coroutineScope;
                        switch (b4) {
                            case 0:
                                AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable2, springSpec2, null, (byte) 3), 3);
                                break;
                            default:
                                AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable2, springSpec2, null, (byte) 2), 3);
                                break;
                        }
                        return unit2;
                    }
                };
                final byte b4 = 0;
                final LayoutDirection layoutDirection = this.$layoutDirection;
                Object objDetectHorizontalDragGestures = ScrollableKt.detectHorizontalDragGestures(pointerInputScope, function1, function0, function2, new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b5 = b4;
                        Unit unit2 = Unit.INSTANCE;
                        LayoutDirection layoutDirection2 = LayoutDirection.Rtl;
                        boolean z = true;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = parcelableSnapshotMutableFloatState;
                        CoroutineScope coroutineScope2 = coroutineScope;
                        Animatable animatable2 = animatable;
                        PlayerConnection playerConnection2 = playerConnection;
                        LayoutDirection layoutDirection3 = layoutDirection;
                        float fFloatValue = ((Float) obj2).floatValue();
                        ((PointerInputChange) obj).getClass();
                        switch (b5) {
                            case 0:
                                if (layoutDirection3 == layoutDirection2) {
                                    fFloatValue = -fFloatValue;
                                }
                                boolean z2 = playerConnection2.getPlayerSafe().getPreviousMediaItemIndex() != -1;
                                boolean z3 = playerConnection2.getPlayerSafe().getNextMediaItemIndex() != -1;
                                boolean z4 = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z5 = fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z6 = z5 && z3;
                                boolean z7 = z4 && z2;
                                if ((!z4 || z2 || ((Number) animatable2.getValue()).floatValue() >= CropImageView.DEFAULT_ASPECT_RATIO) && (!z5 || z3 || ((Number) animatable2.getValue()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO)) {
                                    z = false;
                                }
                                if (z6 || z7 || z) {
                                    parcelableSnapshotMutableFloatState2.setFloatValue(Math.abs(fFloatValue) + parcelableSnapshotMutableFloatState2.getFloatValue());
                                    AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable2, fFloatValue, null, (byte) 0), 3);
                                }
                                break;
                            default:
                                if (layoutDirection3 == layoutDirection2) {
                                    fFloatValue = -fFloatValue;
                                }
                                boolean z8 = playerConnection2.getPlayerSafe().getPreviousMediaItemIndex() != -1;
                                boolean z9 = playerConnection2.getPlayerSafe().getNextMediaItemIndex() != -1;
                                boolean z10 = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z11 = fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z12 = z11 && z9;
                                boolean z13 = z10 && z8;
                                if ((!z10 || z8 || ((Number) animatable2.getValue()).floatValue() >= CropImageView.DEFAULT_ASPECT_RATIO) && (!z11 || z9 || ((Number) animatable2.getValue()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO)) {
                                    z = false;
                                }
                                if (z12 || z13 || z) {
                                    parcelableSnapshotMutableFloatState2.setFloatValue(Math.abs(fFloatValue) + parcelableSnapshotMutableFloatState2.getFloatValue());
                                    AwaitKt.launch$default(coroutineScope2, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable2, fFloatValue, null, (byte) 4), 3);
                                }
                                break;
                        }
                        return unit2;
                    }
                }, continuation);
                return objDetectHorizontalDragGestures == coroutineSingletons ? objDetectHorizontalDragGestures : unit;
            default:
                final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = this.$dragStartTime$delegate;
                final ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = this.$totalDragDistance$delegate;
                final byte b5 = 1;
                Function1 function3 = new Function1() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        byte b6 = b5;
                        Unit unit2 = Unit.INSTANCE;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState2;
                        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = parcelableSnapshotMutableLongState2;
                        switch (b6) {
                            case 0:
                                parcelableSnapshotMutableLongState3.setLongValue(System.currentTimeMillis());
                                parcelableSnapshotMutableFloatState3.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                parcelableSnapshotMutableLongState3.setLongValue(System.currentTimeMillis());
                                parcelableSnapshotMutableFloatState3.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit2;
                    }
                };
                final byte b6 = 1;
                final Animatable animatable2 = this.$offsetXAnimatable;
                final int i2 = this.$autoSwipeThreshold;
                final PlayerConnection playerConnection2 = this.$playerConnection;
                final CoroutineScope coroutineScope2 = this.$coroutineScope;
                final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = this.$swipeSensitivity$delegate;
                final State state3 = this.$canSkipPrevious$delegate;
                final State state4 = this.$canSkipNext$delegate;
                final SpringSpec springSpec2 = this.$animationSpec;
                Function0 function4 = new Function0() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b6;
                        Unit unit2 = Unit.INSTANCE;
                        SpringSpec springSpec3 = springSpec2;
                        State state5 = state4;
                        State state6 = state3;
                        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$3 = dataStoreKt$rememberPreference$1$2;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState2;
                        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = parcelableSnapshotMutableLongState2;
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        PlayerConnection playerConnection3 = playerConnection2;
                        int i3 = i2;
                        Animatable animatable3 = animatable2;
                        switch (b7) {
                            case 0:
                                long jCurrentTimeMillis = System.currentTimeMillis() - parcelableSnapshotMutableLongState3.getLongValue();
                                float floatValue = jCurrentTimeMillis > 0 ? parcelableSnapshotMutableFloatState3.getFloatValue() / jCurrentTimeMillis : 0.0f;
                                float fFloatValue = ((Number) animatable3.getValue()).floatValue();
                                float fFloatValue2 = (((Number) dataStoreKt$rememberPreference$1$3.$state.getValue()).floatValue() * (-8.25f)) + 8.5f;
                                if ((Math.abs(fFloatValue) > 50.0f && floatValue > fFloatValue2) || Math.abs(fFloatValue) > i3) {
                                    if (fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state6.getValue()).booleanValue()) {
                                        playerConnection3.getPlayerSafe().seekToPreviousMediaItemInternal();
                                    } else if (fFloatValue <= CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state5.getValue()).booleanValue()) {
                                        playerConnection3.getPlayerSafe().seekToNext();
                                    }
                                }
                                AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable3, springSpec3, null, (byte) 0), 3);
                                break;
                            default:
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - parcelableSnapshotMutableLongState3.getLongValue();
                                float floatValue2 = jCurrentTimeMillis2 > 0 ? parcelableSnapshotMutableFloatState3.getFloatValue() / jCurrentTimeMillis2 : 0.0f;
                                float fFloatValue3 = ((Number) animatable3.getValue()).floatValue();
                                float fFloatValue4 = (((Number) dataStoreKt$rememberPreference$1$3.$state.getValue()).floatValue() * (-8.25f)) + 8.5f;
                                if ((Math.abs(fFloatValue3) > 50.0f && floatValue2 > fFloatValue4) || Math.abs(fFloatValue3) > i3) {
                                    if (fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state6.getValue()).booleanValue()) {
                                        playerConnection3.getPlayerSafe().seekToPreviousMediaItemInternal();
                                    } else if (fFloatValue3 <= CropImageView.DEFAULT_ASPECT_RATIO && ((Boolean) state5.getValue()).booleanValue()) {
                                        playerConnection3.getPlayerSafe().seekToNext();
                                    }
                                }
                                AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable3, springSpec3, null, (byte) 1), 3);
                                break;
                        }
                        return unit2;
                    }
                };
                Function0 function5 = new Function0() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b7 = b5;
                        Unit unit2 = Unit.INSTANCE;
                        SpringSpec springSpec3 = springSpec2;
                        Animatable animatable3 = animatable2;
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        switch (b7) {
                            case 0:
                                AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable3, springSpec3, null, (byte) 3), 3);
                                break;
                            default:
                                AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(animatable3, springSpec3, null, (byte) 2), 3);
                                break;
                        }
                        return unit2;
                    }
                };
                final byte b7 = 1;
                final LayoutDirection layoutDirection2 = this.$layoutDirection;
                Object objDetectHorizontalDragGestures2 = ScrollableKt.detectHorizontalDragGestures(pointerInputScope, function3, function4, function5, new Function2() { // from class: com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$2$1$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b8 = b7;
                        Unit unit2 = Unit.INSTANCE;
                        LayoutDirection layoutDirection3 = LayoutDirection.Rtl;
                        boolean z = true;
                        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState2;
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        Animatable animatable3 = animatable2;
                        PlayerConnection playerConnection3 = playerConnection2;
                        LayoutDirection layoutDirection4 = layoutDirection2;
                        float fFloatValue = ((Float) obj2).floatValue();
                        ((PointerInputChange) obj).getClass();
                        switch (b8) {
                            case 0:
                                if (layoutDirection4 == layoutDirection3) {
                                    fFloatValue = -fFloatValue;
                                }
                                boolean z2 = playerConnection3.getPlayerSafe().getPreviousMediaItemIndex() != -1;
                                boolean z3 = playerConnection3.getPlayerSafe().getNextMediaItemIndex() != -1;
                                boolean z4 = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z5 = fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z6 = z5 && z3;
                                boolean z7 = z4 && z2;
                                if ((!z4 || z2 || ((Number) animatable3.getValue()).floatValue() >= CropImageView.DEFAULT_ASPECT_RATIO) && (!z5 || z3 || ((Number) animatable3.getValue()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO)) {
                                    z = false;
                                }
                                if (z6 || z7 || z) {
                                    parcelableSnapshotMutableFloatState3.setFloatValue(Math.abs(fFloatValue) + parcelableSnapshotMutableFloatState3.getFloatValue());
                                    AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable3, fFloatValue, null, (byte) 0), 3);
                                }
                                break;
                            default:
                                if (layoutDirection4 == layoutDirection3) {
                                    fFloatValue = -fFloatValue;
                                }
                                boolean z8 = playerConnection3.getPlayerSafe().getPreviousMediaItemIndex() != -1;
                                boolean z9 = playerConnection3.getPlayerSafe().getNextMediaItemIndex() != -1;
                                boolean z10 = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z11 = fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO;
                                boolean z12 = z11 && z9;
                                boolean z13 = z10 && z8;
                                if ((!z10 || z8 || ((Number) animatable3.getValue()).floatValue() >= CropImageView.DEFAULT_ASPECT_RATIO) && (!z11 || z9 || ((Number) animatable3.getValue()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO)) {
                                    z = false;
                                }
                                if (z12 || z13 || z) {
                                    parcelableSnapshotMutableFloatState3.setFloatValue(Math.abs(fFloatValue) + parcelableSnapshotMutableFloatState3.getFloatValue());
                                    AwaitKt.launch$default(coroutineScope3, null, null, new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable3, fFloatValue, null, (byte) 4), 3);
                                }
                                break;
                        }
                        return unit2;
                    }
                }, continuation);
                return objDetectHorizontalDragGestures2 == coroutineSingletons ? objDetectHorizontalDragGestures2 : unit;
        }
    }
}
