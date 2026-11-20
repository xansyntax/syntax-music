package androidx.compose.foundation;

import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.pager.DefaultPagerState;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.TimePickerStateImpl;
import androidx.compose.material3.TopAppBarState;
import androidx.compose.material3.carousel.CarouselPagerState;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.unit.IntSize;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollState$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ScrollState$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = false;
        switch (b) {
            case 0:
                return Integer.valueOf(((ScrollState) obj2).value$delegate.getIntValue());
            case 1:
                Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
                return ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
            case 2:
                EnterExitState enterExitState = (EnterExitState) obj2;
                if (((EnterExitState) obj) == enterExitState && enterExitState == EnterExitState.PostExit) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 3:
                LazyListState lazyListState = (LazyListState) obj2;
                return CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
            case 4:
                ((Integer) obj2).intValue();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(1));
            case 5:
                LazyGridState lazyGridState = (LazyGridState) obj2;
                return CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
            case 6:
                Map mapPerformSave = ((LazySaveableStateHolder) obj2).performSave();
                if (mapPerformSave.isEmpty()) {
                    return null;
                }
                return mapPerformSave;
            case 7:
                DefaultPagerState defaultPagerState = (DefaultPagerState) obj2;
                return CollectionsKt__IterablesKt.listOf(Integer.valueOf(defaultPagerState.getCurrentPage()), Float.valueOf(UuidKt.coerceIn(defaultPagerState.getCurrentPageOffsetFraction(), -0.5f, 0.5f)), Integer.valueOf(defaultPagerState.getPageCount()));
            case 8:
                TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) obj2;
                return CollectionsKt__IterablesKt.listOf(Float.valueOf(textFieldScrollerPosition.offset$delegate.getFloatValue()), Boolean.valueOf(((Orientation) textFieldScrollerPosition.orientation$delegate.getValue()) == Orientation.Vertical));
            case 9:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    SegmentedButtonDefaults.INSTANCE.ActiveIcon(6, gapComposer6);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 15:
            case 24:
                return unit;
            case 16:
                ((Integer) obj2).getClass();
                GapComposer gapComposer7 = (GapComposer) ((Composer) obj);
                gapComposer7.startReplaceGroup(-511854661);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                LimitInsets limitInsets = new LimitInsets(OffsetKt.current(gapComposer7).safeDrawing, 48);
                gapComposer7.end(false);
                return limitInsets;
            case 17:
                return ((SheetState) obj2).getCurrentValue();
            case 18:
                return CollectionsKt__IterablesKt.listOf(Float.valueOf(((SliderState) obj2).valueState$delegate.getFloatValue()));
            case 19:
                return ((SwipeToDismissBoxState) obj2).getCurrentValue();
            case 20:
                TimePickerStateImpl timePickerStateImpl = (TimePickerStateImpl) obj2;
                return CollectionsKt__IterablesKt.listOf(Integer.valueOf(timePickerStateImpl.hourState.getIntValue()), Integer.valueOf(timePickerStateImpl.minuteState.getIntValue()), Boolean.valueOf(timePickerStateImpl.is24hour), Integer.valueOf(timePickerStateImpl.mo241getSelectionyecRtBI()));
            case 21:
                TopAppBarState topAppBarState = (TopAppBarState) obj2;
                return CollectionsKt__IterablesKt.listOf((Object[]) new Float[]{Float.valueOf(topAppBarState.heightOffsetLimit), Float.valueOf(topAppBarState._heightOffset.getFloatValue()), Float.valueOf(topAppBarState.contentOffset$delegate.getFloatValue())});
            case 22:
                CarouselPagerState carouselPagerState = (CarouselPagerState) obj2;
                return CollectionsKt__IterablesKt.listOf(Integer.valueOf(carouselPagerState.getCurrentPage()), Float.valueOf(UuidKt.coerceIn(carouselPagerState.getCurrentPageOffsetFraction(), -0.5f, 0.5f)), carouselPagerState.pageCountState.getValue());
            case 23:
                CarouselState carouselState = (CarouselState) obj2;
                Integer numValueOf = Integer.valueOf(carouselState.pagerState.getCurrentPage());
                CarouselPagerState carouselPagerState2 = carouselState.pagerState;
                return CollectionsKt__IterablesKt.listOf(numValueOf, Float.valueOf(carouselPagerState2.getCurrentPageOffsetFraction()), Integer.valueOf(carouselPagerState2.getPageCount()));
            case 25:
                return Integer.valueOf(((Measurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            case 26:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            case 27:
                return Integer.valueOf(((Measurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            case 28:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            default:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
        }
    }
}
