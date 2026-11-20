package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda101 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda101(String str, List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        int i = 1;
        List list = this.f$1;
        String str = this.f$0;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        switch (b) {
            case 0:
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sQLiteStatementPrepare.bindText(i, (String) it.next());
                        i++;
                    }
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        arrayList.add(sQLiteStatementPrepare.getText(0));
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection.prepare(str);
                try {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        sQLiteStatementPrepare2.bindText(i, (String) it2.next());
                        i++;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        arrayList2.add(sQLiteStatementPrepare2.getText(0));
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
        }
    }
}
