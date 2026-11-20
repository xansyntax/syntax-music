package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StorageSettingsKt$$ExternalSyntheticLambda28 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 f$2;
    public final /* synthetic */ ParcelableSnapshotMutableLongState f$3;
    public final /* synthetic */ ParcelableSnapshotMutableLongState f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ MutableState f$6;
    public final /* synthetic */ MutableState f$7;

    public /* synthetic */ StorageSettingsKt$$ExternalSyntheticLambda28(List list, String str, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = str;
        this.f$2 = mimesKt$$ExternalSyntheticLambda0;
        this.f$3 = parcelableSnapshotMutableLongState;
        this.f$4 = parcelableSnapshotMutableLongState2;
        this.f$5 = mutableState;
        this.f$6 = mutableState2;
        this.f$7 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$7;
        MutableState mutableState2 = this.f$6;
        MutableState mutableState3 = this.f$5;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.f$4;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = this.f$3;
        final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = this.f$2;
        String str = this.f$1;
        List list = this.f$0;
        float fFloatValue = ((Float) obj).floatValue();
        switch (b) {
            case 0:
                final int iIntValue = ((Number) list.get(MathKt.roundToInt(fFloatValue))).intValue();
                if (((long) (iIntValue * 1024)) * 1024 >= parcelableSnapshotMutableLongState2.getLongValue()) {
                    mimesKt$$ExternalSyntheticLambda0.invoke(Integer.valueOf(iIntValue));
                } else {
                    parcelableSnapshotMutableLongState.setLongValue(parcelableSnapshotMutableLongState2.getLongValue());
                    mutableState3.setValue(str);
                    final byte b2 = 1;
                    mutableState2.setValue(new Function0() { // from class: com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b3 = b2;
                            Unit unit2 = Unit.INSTANCE;
                            int i = iIntValue;
                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                            switch (b3) {
                                case 0:
                                    mimesKt$$ExternalSyntheticLambda1.invoke(Integer.valueOf(i));
                                    break;
                                default:
                                    mimesKt$$ExternalSyntheticLambda1.invoke(Integer.valueOf(i));
                                    break;
                            }
                            return unit2;
                        }
                    });
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            default:
                final int iIntValue2 = ((Number) list.get(MathKt.roundToInt(fFloatValue))).intValue();
                if ((iIntValue2 == -1 ? Long.MAX_VALUE : 1024 * ((long) (iIntValue2 * 1024))) >= parcelableSnapshotMutableLongState2.getLongValue()) {
                    mimesKt$$ExternalSyntheticLambda0.invoke(Integer.valueOf(iIntValue2));
                } else {
                    parcelableSnapshotMutableLongState.setLongValue(parcelableSnapshotMutableLongState2.getLongValue());
                    mutableState3.setValue(str);
                    final byte b3 = 0;
                    mutableState2.setValue(new Function0() { // from class: com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = b3;
                            Unit unit2 = Unit.INSTANCE;
                            int i = iIntValue2;
                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                            switch (b4) {
                                case 0:
                                    mimesKt$$ExternalSyntheticLambda1.invoke(Integer.valueOf(i));
                                    break;
                                default:
                                    mimesKt$$ExternalSyntheticLambda1.invoke(Integer.valueOf(i));
                                    break;
                            }
                            return unit2;
                        }
                    });
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
        }
        return unit;
    }
}
