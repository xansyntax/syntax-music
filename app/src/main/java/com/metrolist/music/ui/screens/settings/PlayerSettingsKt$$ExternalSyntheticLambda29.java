package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerSettingsKt$$ExternalSyntheticLambda29 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda29(MutableState mutableState, byte b) {
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
                mutableState.setValue(Boolean.TRUE);
                break;
            case 1:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 2:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 3:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 4:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 5:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 6:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 7:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 8:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 9:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 10:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 11:
                mutableState.setValue(Boolean.TRUE);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 13:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 14:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 15:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 16:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 17:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 18:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 19:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 20:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                break;
            case 21:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 22:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 23:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 24:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 25:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 26:
                mutableState.setValue(Boolean.FALSE);
                break;
            case 27:
                mutableState.setValue(Boolean.TRUE);
                break;
            case 28:
                mutableState.setValue(Boolean.TRUE);
                break;
            default:
                mutableState.setValue(Boolean.TRUE);
                break;
        }
        return unit;
    }
}
