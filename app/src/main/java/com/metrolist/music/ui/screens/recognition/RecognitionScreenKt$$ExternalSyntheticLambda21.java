package com.metrolist.music.ui.screens.recognition;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecognitionScreenKt$$ExternalSyntheticLambda21 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ RecognitionScreenKt$$ExternalSyntheticLambda21(String str, Function0 function0, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$1;
        String str = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                RecognitionScreenKt.ErrorState(str, function0, composer, Stack.updateChangedFlags(1));
                break;
            default:
                RecognitionScreenKt.NoMatchState(str, function0, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }
}
