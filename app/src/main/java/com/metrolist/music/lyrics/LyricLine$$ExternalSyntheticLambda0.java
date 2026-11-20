package com.metrolist.music.lyrics;

import com.atilika.kuromoji.ipadic.Tokenizer;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricLine$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LyricLine$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                LyricLine.Companion companion = LyricLine.Companion;
                return new HashSetSerializer(LyricWord$$serializer.INSTANCE, (byte) 1);
            case 1:
                BinimumLyricsApiResponse.Companion companion2 = BinimumLyricsApiResponse.Companion;
                return new HashSetSerializer(BinimumLyricsResult$$serializer.INSTANCE, (byte) 1);
            case 2:
                LyricsMetadata.Companion companion3 = LyricsMetadata.INSTANCE;
                return new HashMapSerializer(StringSerializer.INSTANCE, AgentInfo$$serializer.INSTANCE, (byte) 1);
            case 3:
                LyricsMetadata.Companion companion4 = LyricsMetadata.INSTANCE;
                return new HashSetSerializer(SongPart$$serializer.INSTANCE, (byte) 1);
            case 4:
                LyricsMetadata.Companion companion5 = LyricsMetadata.INSTANCE;
                return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
            case 5:
                LyricsPlusResponse.Companion companion6 = LyricsPlusResponse.Companion;
                return new HashSetSerializer(LyricLine$$serializer.INSTANCE, (byte) 1);
            case 6:
                Transliteration.Companion companion7 = Transliteration.Companion;
                return new HashSetSerializer(LyricWord$$serializer.INSTANCE, (byte) 1);
            case 7:
                ZemerLyricsProvider.FeedPage.Companion companion8 = ZemerLyricsProvider.FeedPage.Companion;
                return new HashSetSerializer(ZemerLyricsProvider$FeedSong$$serializer.INSTANCE, (byte) 1);
            case 8:
                ZemerLyricsProvider.FeedSong.Companion companion9 = ZemerLyricsProvider.FeedSong.Companion;
                return new HashSetSerializer(ZemerLyricsProvider$FeedLine$$serializer.INSTANCE, (byte) 1);
            case 9:
                ZemerLyricsProvider.Resolved.Companion companion10 = ZemerLyricsProvider.Resolved.Companion;
                return new HashSetSerializer(ZemerLyricsProvider$Source$$serializer.INSTANCE, (byte) 1);
            case 10:
                return new Regex("^[A-Z]{2}[A-Z0-9]{3}\\d{2}\\d{5}$");
            case 11:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 6));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new Tokenizer();
            default:
                return HttpClientKt.HttpClient(OkHttp.INSTANCE, new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 13));
        }
    }
}
