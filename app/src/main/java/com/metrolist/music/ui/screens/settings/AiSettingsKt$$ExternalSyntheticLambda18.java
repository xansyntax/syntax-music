package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AiSettingsKt$$ExternalSyntheticLambda18 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ AiSettingsKt$$ExternalSyntheticLambda18(DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = dataStoreKt$rememberPreference$1$1;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.f$0;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(str);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 1:
                String str2 = (String) obj;
                str2.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(str2);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 2:
                String str3 = (String) obj;
                str3.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(str3);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 3:
                String str4 = (String) obj;
                str4.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(str4);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 4:
                String str5 = (String) obj;
                str5.getClass();
                if (StringsKt.isBlank(str5) || str5.equals("You are a precise lyrics translation assistant. Your output must ALWAYS be a valid JSON object of the form {\"lines\": [\"line1\", \"line2\", \"line3\"]}.\n\nCRITICAL RULES:\n1. Output ONLY the JSON object: {\"lines\": [\"line1\", \"line2\", \"line3\"]}\n2. NO explanations, NO questions, NO additional text\n3. Each input line maps to exactly one entry in the \"lines\" array\n4. Preserve empty lines as empty strings \"\"\n5. The \"lines\" array must contain EXACTLY {lineCount} items\n6. If uncertain, provide best approximation but maintain line count")) {
                    str5 = "";
                }
                dataStoreKt$rememberPreference$1$1.setValue(str5);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 5:
                ListenTogetherServer listenTogetherServer = (ListenTogetherServer) obj;
                listenTogetherServer.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(listenTogetherServer.url);
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                String str6 = (String) obj;
                str6.getClass();
                dataStoreKt$rememberPreference$1$1.setValue(str6);
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
