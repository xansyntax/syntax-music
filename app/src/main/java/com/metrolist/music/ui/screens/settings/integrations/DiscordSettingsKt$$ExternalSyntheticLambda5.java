package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiscordSettingsKt$$ExternalSyntheticLambda5 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ DiscordSettingsKt$$ExternalSyntheticLambda5(MutableState mutableState, byte b) {
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
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 1:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 2:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 3:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 4:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 5:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 6:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 7:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 8:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 9:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 10:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 11:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 13:
                return Stack.mutableStateOf$default((String) mutableState.getValue());
            case 14:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 15:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 16:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 17:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 18:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 19:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 20:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 21:
                return Stack.mutableStateOf$default((String) mutableState.getValue());
            case 22:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                return unit;
            case 23:
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 24:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 25:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 26:
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 27:
                return Stack.mutableStateOf$default((String) mutableState.getValue());
            case 28:
                mutableState.setValue("");
                return unit;
            default:
                mutableState.setValue(Boolean.FALSE);
                return unit;
        }
    }
}
