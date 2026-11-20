package com.metrolist.music.ui.utils;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ShowOffsetDialogKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$1;

    public /* synthetic */ ShowOffsetDialogKt$$ExternalSyntheticLambda2(MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
        this.f$0 = mutableState;
        this.f$1 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Integer intOrNull;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$1;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                StringBuilder sb = new StringBuilder();
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (Character.isDigit(cCharAt) || (cCharAt == '-' && StringsKt.indexOf$default(str, '-', 0, 6) == 0)) {
                        sb.append(cCharAt);
                    }
                }
                String string = sb.toString();
                String strTake = StringsKt.startsWith$default(string, '-') ? StringsKt.take(6, string) : StringsKt.take(5, string);
                mutableState.setValue(strTake);
                if (strTake.length() == 0) {
                    parcelableSnapshotMutableIntState.setIntValue(0);
                    mutableState.setValue("0");
                } else if (!strTake.equals("-") && (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, strTake)) != null) {
                    int iIntValue = intOrNull.intValue();
                    int iCoerceIn = UuidKt.coerceIn(iIntValue, -9999, 9999);
                    parcelableSnapshotMutableIntState.setIntValue(iCoerceIn);
                    if (iIntValue != iCoerceIn) {
                        mutableState.setValue(String.valueOf(iCoerceIn));
                    }
                    if (iCoerceIn == 0 && StringsKt.startsWith$default(strTake, '-')) {
                        mutableState.setValue("0");
                    }
                }
                break;
            default:
                int iFloatValue = ((int) (((Float) obj).floatValue() / 100.0f)) * 100;
                parcelableSnapshotMutableIntState.setIntValue(iFloatValue);
                mutableState.setValue(String.valueOf(iFloatValue));
                break;
        }
        return unit;
    }

    public /* synthetic */ ShowOffsetDialogKt$$ExternalSyntheticLambda2(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState) {
        this.f$1 = parcelableSnapshotMutableIntState;
        this.f$0 = mutableState;
    }
}
