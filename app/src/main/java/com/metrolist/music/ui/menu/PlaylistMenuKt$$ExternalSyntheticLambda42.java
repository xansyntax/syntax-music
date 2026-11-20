package com.metrolist.music.ui.menu;

import android.content.Context;
import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistMenuKt$$ExternalSyntheticLambda42 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ PlaylistMenuKt$$ExternalSyntheticLambda42(Context context, Function0 function0, String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = function0;
        this.f$2 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.f$2;
        Function0 function0 = this.f$1;
        Context context = this.f$0;
        switch (b) {
            case 0:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", str);
                context.startActivity(Intent.createChooser(intent, null));
                function0.invoke();
                break;
            default:
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.SEND");
                intent2.setType("text/plain");
                intent2.putExtra("android.intent.extra.TEXT", str);
                context.startActivity(Intent.createChooser(intent2, null));
                function0.invoke();
                break;
        }
        return unit;
    }
}
