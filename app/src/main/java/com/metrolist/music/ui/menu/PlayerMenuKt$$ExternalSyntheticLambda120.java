package com.metrolist.music.ui.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda120 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda120(Context context, String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.f$1;
        Context context = this.f$0;
        switch (b) {
            case 0:
                Object systemService = context.getSystemService("clipboard");
                systemService.getClass();
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Listen Together Link", str));
                Toast.makeText(context, R.string.copied_to_clipboard, 0).show();
                break;
            case 1:
                Object systemService2 = context.getSystemService("clipboard");
                systemService2.getClass();
                ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("Auralys Playback Error", str));
                break;
            case 2:
                Object systemService3 = context.getSystemService("clipboard");
                systemService3.getClass();
                ((ClipboardManager) systemService3).setPrimaryClip(ClipData.newPlainText("Listen Together Link", str));
                Toast.makeText(context, R.string.copied_to_clipboard, 0).show();
                break;
            case 3:
                Object systemService4 = context.getSystemService("clipboard");
                systemService4.getClass();
                ((ClipboardManager) systemService4).setPrimaryClip(ClipData.newPlainText("Room Code", str));
                Toast.makeText(context, R.string.copied_to_clipboard, 0).show();
                break;
            case 4:
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                break;
            case 5:
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                break;
            default:
                Toast.makeText(context, str, 0).show();
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda120(String str, Context context, byte b) {
        this.$r8$classId = b;
        this.f$1 = str;
        this.f$0 = context;
    }
}
