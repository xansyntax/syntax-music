package com.metrolist.music.ui.screens;

import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.utils.AppBarKt;
import com.metrolist.music.viewmodels.HomeViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$HomeScreen$8$1 extends FunctionReferenceImpl implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenKt$HomeScreen$8$1(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
        super(i, obj, cls, str, str2, i2);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((HomeViewModel) this.receiver).refresh();
                break;
            case 1:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 2:
                AppBarKt.backToMain((NavHostController) this.receiver);
                break;
            case 3:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 4:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 5:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 6:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 7:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 8:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 9:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 10:
                AppBarKt.backToMain((NavHostController) this.receiver);
                break;
            case 11:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 13:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 14:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 15:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 16:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 17:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 18:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 19:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 20:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 21:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 22:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 23:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 24:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 25:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 26:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 27:
                ((MenuState) this.receiver).setVisible(false);
                break;
            case 28:
                ((MenuState) this.receiver).setVisible(false);
                break;
            default:
                ((MenuState) this.receiver).setVisible(false);
                break;
        }
        return unit;
    }
}
