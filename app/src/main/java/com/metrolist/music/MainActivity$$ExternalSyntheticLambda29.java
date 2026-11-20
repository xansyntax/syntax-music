package com.metrolist.music;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.material3.ExposedDropdownMenuAnchorType;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda29 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda29(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                int i = MainActivity.$r8$clinit;
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 1:
                return new LazyListIntervalContent((Function1) mutableState.getValue());
            case 2:
                return new LazyGridIntervalContent((Function1) mutableState.getValue());
            case 3:
                return (LazyLayoutItemProvider) ((Function0) mutableState.getValue()).invoke();
            case 4:
                if (mutableState != null) {
                    return (List) mutableState.getValue();
                }
                return null;
            case 5:
                Boolean bool = (Boolean) mutableState.getValue();
                bool.booleanValue();
                return bool;
            case 6:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates != null) {
                    return layoutCoordinates;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 7:
                LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates2 != null) {
                    return layoutCoordinates2;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 8:
                LayoutCoordinates layoutCoordinates3 = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates3;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 9:
                mutableState.setValue(unit);
                return unit;
            case 10:
                ((ExposedDropdownMenuAnchorType) mutableState.getValue()).getClass();
                mutableState.setValue(new ExposedDropdownMenuAnchorType());
                return unit;
            case 11:
                return (LayoutCoordinates) mutableState.getValue();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                int i2 = MainActivity.$r8$clinit;
                mutableState.setValue(null);
                return unit;
            case 13:
                int i3 = MainActivity.$r8$clinit;
                mutableState.setValue(null);
                return unit;
            case 14:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                return unit;
            case 15:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 16:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 17:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 18:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 19:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 20:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 21:
                mutableState.setValue(null);
                return unit;
            case 22:
                mutableState.setValue("daily");
                return unit;
            case 23:
                mutableState.setValue("custom");
                return unit;
            case 24:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                return unit;
            case 25:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                return unit;
            case 26:
                mutableState.setValue("global_start");
                return unit;
            case 27:
                mutableState.setValue("global_end");
                return unit;
            case 28:
                mutableState.setValue("weekends_start");
                return unit;
            default:
                mutableState.setValue("weekends_end");
                return unit;
        }
    }
}
