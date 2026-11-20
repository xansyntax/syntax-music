package com.metrolist.music.ui.screens;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccountScreenKt$$ExternalSyntheticLambda20 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ Modifier f$4;

    public /* synthetic */ AccountScreenKt$$ExternalSyntheticLambda20(String str, String str2, String str3, Function0 function0, Modifier modifier, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
        this.f$3 = function0;
        this.f$4 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                AlbumScreenKt.PodcastAccountItem(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                AlbumScreenKt.SePlaylistAccountItem(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                LibraryScreenKt.AutoPlaylistCard(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }
}
