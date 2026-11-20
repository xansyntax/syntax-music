package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.text.TextRange;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProcessTextApi23Impl$$ExternalSyntheticLambda1 implements Function5 {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                TextRange textRange = (TextRange) obj5;
                String string = ((CharSequence) obj4).subSequence(TextRange.m744getMinimpl(textRange.packedValue), TextRange.m743getMaximpl(textRange.packedValue)).toString();
                Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", zBooleanValue);
                ActivityInfo activityInfo = ((ResolveInfo) obj2).activityInfo;
                Intent className = intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
                className.putExtra("android.intent.extra.PROCESS_TEXT", string);
                ((Context) obj).startActivity(className);
                break;
            case 1:
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj;
                TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj2;
                Function0 function0 = (Function0) obj3;
                Composer composer = (Composer) obj4;
                int iIntValue = ((Integer) obj5).intValue();
                int i = (iIntValue & 6) == 0 ? iIntValue | ((iIntValue & 8) == 0 ? ((GapComposer) composer).changed(textContextMenuSession) : ((GapComposer) composer).changedInstance(textContextMenuSession) ? 4 : 2) : iIntValue;
                if ((iIntValue & 48) == 0) {
                    i |= (iIntValue & 64) == 0 ? ((GapComposer) composer).changed(textContextMenuDataProvider) : ((GapComposer) composer).changedInstance(textContextMenuDataProvider) ? 32 : 16;
                }
                if ((iIntValue & 384) == 0) {
                    i |= ((GapComposer) composer).changedInstance(function0) ? 256 : 128;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 1171) != 1170)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(textContextMenuSession, textContextMenuDataProvider, function0, gapComposer, i & 1022);
                }
                break;
            default:
                TextContextMenuSession textContextMenuSession2 = (TextContextMenuSession) obj;
                TextContextMenuDataProvider textContextMenuDataProvider2 = (TextContextMenuDataProvider) obj2;
                Function0 function1 = (Function0) obj3;
                Composer composer2 = (Composer) obj4;
                int iIntValue2 = ((Integer) obj5).intValue();
                int i2 = (iIntValue2 & 6) == 0 ? iIntValue2 | ((iIntValue2 & 8) == 0 ? ((GapComposer) composer2).changed(textContextMenuSession2) : ((GapComposer) composer2).changedInstance(textContextMenuSession2) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i2 |= (iIntValue2 & 64) == 0 ? ((GapComposer) composer2).changed(textContextMenuDataProvider2) : ((GapComposer) composer2).changedInstance(textContextMenuDataProvider2) ? 32 : 16;
                }
                if ((iIntValue2 & 384) == 0) {
                    i2 |= ((GapComposer) composer2).changedInstance(function1) ? 256 : 128;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(textContextMenuSession2, textContextMenuDataProvider2, function1, gapComposer2, i2 & 1022);
                }
                break;
        }
        return unit;
    }
}
