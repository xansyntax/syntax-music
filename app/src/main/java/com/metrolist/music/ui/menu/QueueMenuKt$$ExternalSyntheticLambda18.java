package com.metrolist.music.ui.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.models.MediaMetadata;
import com.yalantis.ucrop.R;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda18 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ MediaMetadata f$2;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda18(Function0 function0, Context context, MediaMetadata mediaMetadata) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = context;
        this.f$2 = mediaMetadata;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$0;
        MediaMetadata mediaMetadata = this.f$2;
        Context context = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    function0.invoke();
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/watch?v=" + mediaMetadata.id);
                    context.startActivity(Intent.createChooser(intent, null));
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object systemService = context.getSystemService("clipboard");
                    systemService.getClass();
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Song Link", "https://music.youtube.com/watch?v=" + mediaMetadata.id));
                    Toast.makeText(context, R.string.link_copied, 0).show();
                    function0.invoke();
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Context applicationContext = context.getApplicationContext();
                    String str = mediaMetadata.title;
                    List list = mediaMetadata.artists;
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda16((byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(list, null, null, null, (Function1) objRememberedValue, 31);
                    String str2 = mediaMetadata.thumbnailUrl;
                    function0.invoke();
                    ContextScope contextScopeMainScope = AwaitKt.MainScope();
                    boolean zChangedInstance = gapComposer3.changedInstance(applicationContext) | gapComposer3.changed(str2) | gapComposer3.changed(str) | gapComposer3.changed(strJoinToString$default);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        InnerTube$feedback$2 innerTube$feedback$2 = new InnerTube$feedback$2(applicationContext, str2, str, strJoinToString$default, (Continuation) null, (byte) 13);
                        gapComposer3.updateRememberedValue(innerTube$feedback$2);
                        objRememberedValue2 = innerTube$feedback$2;
                    }
                    AwaitKt.launch$default(contextScopeMainScope, null, null, (Function2) objRememberedValue2, 3);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda18(Context context, MediaMetadata mediaMetadata, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$1 = context;
        this.f$2 = mediaMetadata;
        this.f$0 = function0;
    }
}
