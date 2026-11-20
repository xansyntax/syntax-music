package androidx.compose.material3;

import android.view.View;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.material3.carousel.CarouselPagerState;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.material3.internal.ParentSemanticsNode;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.HostDefaultProviderKt;
import androidx.compose.runtime.NextFrameEndCallbackQueue$NextFrameEndAwaiter;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.ViewTreeHostDefaultProvider;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.emoji2.text.EmojiProcessor;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ TextKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Unit.INSTANCE;
            case 1:
                KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpec.KeyframesSpecConfig) obj;
                keyframesSpecConfig.durationMillis = 6000;
                Float fValueOf = Float.valueOf(90.0f);
                keyframesSpecConfig.at(300, fValueOf).easing = new CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f);
                keyframesSpecConfig.at(1500, fValueOf);
                Float fValueOf2 = Float.valueOf(180.0f);
                keyframesSpecConfig.at(1800, fValueOf2);
                keyframesSpecConfig.at(3000, fValueOf2);
                Float fValueOf3 = Float.valueOf(270.0f);
                keyframesSpecConfig.at(3300, fValueOf3);
                keyframesSpecConfig.at(4500, fValueOf3);
                Float fValueOf4 = Float.valueOf(360.0f);
                keyframesSpecConfig.at(4800, fValueOf4);
                keyframesSpecConfig.at(6000, fValueOf4);
                return Unit.INSTANCE;
            case 2:
                return new RippleConfiguration();
            case 3:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 3);
                return Unit.INSTANCE;
            case 4:
                return Boolean.TRUE;
            case 5:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsContainer;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[6];
                Boolean bool = Boolean.TRUE;
                semanticsPropertyKey.getClass();
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey, bool);
                return Unit.INSTANCE;
            case 6:
                return Unit.INSTANCE;
            case 7:
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.SelectableGroup;
                Unit unit = Unit.INSTANCE;
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey2, unit);
                return unit;
            case 8:
                return Unit.INSTANCE;
            case 9:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            case 10:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            case 11:
                List list = (List) obj;
                int i = (list.size() <= 3 || !Intrinsics.areEqual(list.get(3), (Object) 1)) ? 0 : 1;
                Object obj2 = list.get(0);
                obj2.getClass();
                int iIntValue = ((Integer) obj2).intValue();
                Object obj3 = list.get(1);
                obj3.getClass();
                int iIntValue2 = ((Integer) obj3).intValue();
                Object obj4 = list.get(2);
                obj4.getClass();
                return new TimePickerStateImpl(iIntValue, iIntValue2, i, ((Boolean) obj4).booleanValue());
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 1);
                return Unit.INSTANCE;
            case 13:
                List list2 = (List) obj;
                return new TopAppBarState(((Number) list2.get(0)).floatValue(), ((Number) list2.get(1)).floatValue(), ((Number) list2.get(2)).floatValue());
            case 14:
                float fFloatValue = ((Float) obj).floatValue();
                return Float.valueOf((fFloatValue <= 0.1f || fFloatValue >= 0.95f) ? CropImageView.DEFAULT_ASPECT_RATIO : 1.0f);
            case 15:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 8);
                return Unit.INSTANCE;
            case 16:
                return Unit.INSTANCE;
            case 17:
                List list3 = (List) obj;
                Object obj5 = list3.get(0);
                obj5.getClass();
                int iIntValue3 = ((Integer) obj5).intValue();
                Object obj6 = list3.get(1);
                obj6.getClass();
                return new CarouselPagerState(iIntValue3, ((Float) obj6).floatValue(), new Url$$ExternalSyntheticLambda0(list3, (byte) 2));
            case 18:
                List list4 = (List) obj;
                Object obj7 = list4.get(0);
                obj7.getClass();
                int iIntValue4 = ((Integer) obj7).intValue();
                Object obj8 = list4.get(1);
                obj8.getClass();
                return new CarouselState(iIntValue4, ((Float) obj8).floatValue(), new Url$$ExternalSyntheticLambda0(list4, (byte) 3));
            case 19:
                return Unit.INSTANCE;
            case 20:
                return Unit.INSTANCE;
            case 21:
                return Unit.INSTANCE;
            case 22:
                TraversableNode traversableNode = (TraversableNode) obj;
                traversableNode.getClass();
                ParentSemanticsNode parentSemanticsNode = (ParentSemanticsNode) traversableNode;
                parentSemanticsNode.semanticsConsumed = false;
                HitTestResultKt.invalidateSemantics(parentSemanticsNode);
                return Boolean.FALSE;
            case 23:
                return Unit.INSTANCE;
            case 24:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                EmojiProcessor emojiProcessor = layoutNodeDrawScope.canvasDrawScope.drawContext;
                long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                emojiProcessor.getCanvas().save();
                try {
                    ((DrawResult) emojiProcessor.mSpanFactory).m401clipRectN_I0leg(-3.4028235E38f, CropImageView.DEFAULT_ASPECT_RATIO, Float.MAX_VALUE, Float.MAX_VALUE, 1);
                    layoutNodeDrawScope.drawContent();
                    return Unit.INSTANCE;
                } finally {
                    IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                }
            case 25:
                Float f = (Float) obj;
                f.getClass();
                return new PullToRefreshStateImpl(new Animatable(f, ArcSplineKt.FloatToVector, (Object) null, 12));
            case 26:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) obj;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = HostDefaultProviderKt.LocalHostDefaultProvider;
                persistentCompositionLocalHashMap.getClass();
                View view = ((ViewTreeHostDefaultProvider) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal)).view;
                while (view != null) {
                    Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
                    if (tag != null) {
                        return tag;
                    }
                    Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
                    view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
                }
                return null;
            case 27:
                ((NextFrameEndCallbackQueue$NextFrameEndAwaiter) obj).resume();
                return Unit.INSTANCE;
            case 28:
                return new SaveableStateHolderImpl((Map) obj);
            default:
                synchronized (SnapshotKt.lock) {
                    List list5 = SnapshotKt.globalWriteObservers;
                    int size = list5.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((Function1) list5.get(i2)).invoke(obj);
                    }
                }
                return Unit.INSTANCE;
        }
    }
}
