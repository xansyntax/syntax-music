package com.metrolist.music.discord;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import io.ktor.http.ParametersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiscordAuth$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$2;

    public /* synthetic */ DiscordAuth$$ExternalSyntheticLambda1(String str, String str2, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$2 = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.f$2;
        String str2 = this.f$0;
        switch (b) {
            case 0:
                ParametersBuilder parametersBuilder = (ParametersBuilder) obj;
                parametersBuilder.getClass();
                parametersBuilder.append("code", str2);
                parametersBuilder.append("redirect_uri", "metrolistdiscord://oauth2/callback");
                parametersBuilder.append("code_verifier", str);
                return unit;
            case 1:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE event SET songId = ? WHERE songId = ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str2);
                    sQLiteStatementPrepare.bindText(2, str);
                    sQLiteStatementPrepare.step();
                    return Integer.valueOf(MathKt.getTotalChangedRows(sQLiteConnection));
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("UPDATE artist SET thumbnailUrl = ? WHERE id = ?");
                try {
                    sQLiteStatementPrepare2.bindText(1, str2);
                    sQLiteStatementPrepare2.bindText(2, str);
                    sQLiteStatementPrepare2.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
        }
    }
}
