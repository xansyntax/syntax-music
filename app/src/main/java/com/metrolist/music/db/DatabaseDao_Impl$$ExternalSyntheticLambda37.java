package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda37 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LocalDateTime f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda37(DatabaseDao_Impl databaseDao_Impl, LocalDateTime localDateTime, String str, byte b) {
        this.$r8$classId = b;
        this.f$2 = localDateTime;
        this.f$3 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.f$3;
        LocalDateTime localDateTime = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        switch (b) {
            case 0:
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE song SET inLibrary = ? WHERE id = ?");
                try {
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare.bindNull(1);
                    } else {
                        sQLiteStatementPrepare.bindLong(1, lDateToTimestamp.longValue());
                    }
                    sQLiteStatementPrepare.bindText(2, str);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection.prepare("UPDATE playlist SET lastUpdateTime = ? WHERE id = ?");
                try {
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatementPrepare2.bindNull(1);
                    } else {
                        sQLiteStatementPrepare2.bindLong(1, lDateToTimestamp2.longValue());
                    }
                    sQLiteStatementPrepare2.bindText(2, str);
                    sQLiteStatementPrepare2.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
        }
    }
}
