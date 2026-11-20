package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.runtime.MutableState;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherSettingsKt$$ExternalSyntheticLambda45 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ ListenTogetherSettingsKt$$ExternalSyntheticLambda45(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                mutableState.setValue(str);
                break;
            case 1:
                String str2 = (String) obj;
                str2.getClass();
                String upperCase = str2.toUpperCase(Locale.ROOT);
                upperCase.getClass();
                StringBuilder sb = new StringBuilder();
                int length = upperCase.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = upperCase.charAt(i);
                    if (Character.isLetterOrDigit(cCharAt)) {
                        sb.append(cCharAt);
                    }
                }
                mutableState.setValue(StringsKt.take(8, sb.toString()));
                break;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                mutableState.setValue(bool);
                break;
            case 3:
                String str3 = (String) obj;
                str3.getClass();
                mutableState.setValue(str3);
                break;
            case 4:
                String str4 = (String) obj;
                str4.getClass();
                mutableState.setValue(str4);
                break;
            case 5:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                mutableState.setValue(bool2);
                break;
            default:
                String str5 = (String) obj;
                str5.getClass();
                mutableState.setValue(str5);
                break;
        }
        return unit;
    }
}
