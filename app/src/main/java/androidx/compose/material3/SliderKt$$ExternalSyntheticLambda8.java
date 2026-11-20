package androidx.compose.material3;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1;
import androidx.activity.compose.ComposeBackHandler;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import io.ktor.websocket.ControlFramesKt;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda8(Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 1;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$0;
        Object obj2 = this.f$1;
        switch (b) {
            case 0:
                SliderState sliderState = (SliderState) obj2;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                if (!z) {
                    KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                    semanticsPropertyReceiver.set(SemanticsProperties.Disabled, unit);
                }
                String strValueOf = String.valueOf(MathKt.roundToInt(sliderState.valueState$delegate.getFloatValue() * 100.0f) / 100.0f);
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.StateDescription;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[1];
                semanticsPropertyKey.getClass();
                semanticsPropertyReceiver.set(semanticsPropertyKey, strValueOf);
                semanticsPropertyReceiver.set(SemanticsActions.SetProgress, new AccessibilityAction(null, new SliderKt$$ExternalSyntheticLambda5(sliderState, b2)));
                return unit;
            case 1:
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) obj2;
                ((FragmentManager.AnonymousClass1) composeBackHandler.mContext).setEnabled(z);
                ((BackHandlerCompat$navigationEventHandler$1) composeBackHandler.mMenuItems).setBackEnabled(z);
                return new BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1((LifecycleStartStopEffectScope) obj, composeBackHandler, (byte) 0);
            case 2:
                ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) obj2;
                composePredictiveBackHandler.setBackEnabled(z);
                return new BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1((LifecycleStartStopEffectScope) obj, composePredictiveBackHandler, (byte) 1);
            case 3:
                MutableState mutableState = (MutableState) obj2;
                float fFloatValue = ((Float) obj).floatValue();
                if (z) {
                    mutableState.setValue(Long.valueOf((long) fFloatValue));
                }
                return unit;
            case 4:
                State state = (State) obj2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                if (z) {
                    reusableGraphicsLayerScope.setScaleX(((Number) state.getValue()).floatValue());
                    reusableGraphicsLayerScope.setScaleY(((Number) state.getValue()).floatValue());
                }
                return unit;
            case 5:
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj2;
                List<MusicAlarmEntry> list = (List) obj;
                list.getClass();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (MusicAlarmEntry musicAlarmEntryCopy$default : list) {
                    if (musicAlarmEntryCopy$default.id.equals(musicAlarmEntry.id)) {
                        musicAlarmEntryCopy$default = MusicAlarmEntry.copy$default(musicAlarmEntryCopy$default, this.f$0, 0, 0, null, false, 0L, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE);
                    }
                    arrayList.add(musicAlarmEntryCopy$default);
                }
                return arrayList;
            default:
                return SongEntity.copy$default((SongEntity) obj, null, 0, null, null, null, true, (LocalDateTime) obj2, null, null, null, null, 0, false, false, this.f$0, null, 130020351);
        }
    }

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda8(boolean z, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = obj;
    }
}
