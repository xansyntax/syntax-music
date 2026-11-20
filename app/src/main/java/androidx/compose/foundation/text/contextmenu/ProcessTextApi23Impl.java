package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.ProcessTextKey;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProcessTextApi23Impl {
    public static final ChipKt$$ExternalSyntheticLambda3 processTextActivitiesQuery = new ChipKt$$ExternalSyntheticLambda3((byte) 10);
    public static final ProcessTextApi23Impl$$ExternalSyntheticLambda1 onClickProcessTextItem = new ProcessTextApi23Impl$$ExternalSyntheticLambda1((byte) 0);

    /* JADX INFO: renamed from: addProcessedTextContextMenuItems-UAq72N0, reason: not valid java name */
    public static final void m208addProcessedTextContextMenuItemsUAq72N0(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, final boolean z, final String str, final long j) {
        if (TextRange.m741getCollapsedimpl(j) || str.length() == 0) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        final Context context2 = context;
        List list = (List) processTextActivitiesQuery.invoke(context2);
        if (list.isEmpty()) {
            return;
        }
        MutableObjectList mutableObjectList = textContextMenuBuilderScope.components;
        MutableObjectList mutableObjectList2 = textContextMenuBuilderScope.components;
        TextContextMenuSeparator textContextMenuSeparator = TextContextMenuSeparator.INSTANCE;
        mutableObjectList.add(textContextMenuSeparator);
        int size = list.size();
        int i = 0;
        while (i < size) {
            final ResolveInfo resolveInfo = (ResolveInfo) list.get(i);
            mutableObjectList2.add(new TextContextMenuItem(new ProcessTextKey(i), resolveInfo.loadLabel(packageManager).toString(), 0, new Function1() { // from class: androidx.compose.foundation.text.contextmenu.ProcessText_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ProcessTextApi23Impl.onClickProcessTextItem.invoke(context2, resolveInfo, Boolean.valueOf(z), str, new TextRange(j));
                    ((TextContextMenuSession) obj).close();
                    return Unit.INSTANCE;
                }
            }));
            i++;
            context2 = context;
        }
        mutableObjectList2.add(textContextMenuSeparator);
    }
}
