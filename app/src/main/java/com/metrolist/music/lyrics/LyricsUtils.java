package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.github.promeg.pinyinhelper.Pinyin;
import com.metrolist.music.db.entities.ArtistPageCacheKt;
import com.metrolist.music.db.entities.CachedArtistPage;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.discord.DiscordUser;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.viewmodels.LyricsViewModel;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsUtils {
    public static final Set BELARUSIAN_CYRILLIC_LETTERS;
    public static final Map BELARUSIAN_ROMAJI_MAP;
    public static final Set BELARUSIAN_SPECIFIC_CYRILLIC_LETTERS;
    public static final Set BULGARIAN_CYRILLIC_LETTERS;
    public static final Map BULGARIAN_ROMAJI_MAP;
    public static final Map GENERAL_CYRILLIC_ROMAJI_MAP;
    public static final Set KYRGYZ_CYRILLIC_LETTERS;
    public static final Map KYRGYZ_ROMAJI_MAP;
    public static final Set KYRGYZ_SPECIFIC_CYRILLIC_LETTERS;
    public static final Set MACEDONIAN_CYRILLIC_LETTERS;
    public static final Map MACEDONIAN_ROMAJI_MAP;
    public static final Set MACEDONIAN_SPECIFIC_CYRILLIC_LETTERS;
    public static final Set RUSSIAN_CYRILLIC_LETTERS;
    public static final Map RUSSIAN_ROMAJI_MAP;
    public static final Set SERBIAN_CYRILLIC_LETTERS;
    public static final Map SERBIAN_ROMAJI_MAP;
    public static final Set SERBIAN_SPECIFIC_CYRILLIC_LETTERS;
    public static final Set UKRAINIAN_CYRILLIC_LETTERS;
    public static final Map UKRAINIAN_ROMAJI_MAP;
    public static final Set UKRAINIAN_SPECIFIC_CYRILLIC_LETTERS;
    public static final SynchronizedLazyImpl kuromojiTokenizer$delegate;
    public static final LyricsUtils INSTANCE = new LyricsUtils();
    public static final Map KANA_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("キャ", "kya"), ResultKt.to("キュ", "kyu"), ResultKt.to("キョ", "kyo"), ResultKt.to("シャ", "sha"), ResultKt.to("シュ", "shu"), ResultKt.to("ショ", "sho"), ResultKt.to("チャ", "cha"), ResultKt.to("チュ", "chu"), ResultKt.to("チョ", "cho"), ResultKt.to("ニャ", "nya"), ResultKt.to("ニュ", "nyu"), ResultKt.to("ニョ", "nyo"), ResultKt.to("ヒャ", "hya"), ResultKt.to("ヒュ", "hyu"), ResultKt.to("ヒョ", "hyo"), ResultKt.to("ミャ", "mya"), ResultKt.to("ミュ", "myu"), ResultKt.to("ミョ", "myo"), ResultKt.to("リャ", "rya"), ResultKt.to("リュ", "ryu"), ResultKt.to("リョ", "ryo"), ResultKt.to("ギャ", "gya"), ResultKt.to("ギュ", "gyu"), ResultKt.to("ギョ", "gyo"), ResultKt.to("ジャ", "ja"), ResultKt.to("ジュ", "ju"), ResultKt.to("ジョ", "jo"), ResultKt.to("ヂャ", "ja"), ResultKt.to("ヂュ", "ju"), ResultKt.to("ヂョ", "jo"), ResultKt.to("ビャ", "bya"), ResultKt.to("ビュ", "byu"), ResultKt.to("ビョ", "byo"), ResultKt.to("ピャ", "pya"), ResultKt.to("ピュ", "pyu"), ResultKt.to("ピョ", "pyo"), ResultKt.to("ア", "a"), ResultKt.to("イ", "i"), ResultKt.to("ウ", "u"), ResultKt.to("エ", "e"), ResultKt.to("オ", "o"), ResultKt.to("カ", "ka"), ResultKt.to("キ", "ki"), ResultKt.to("ク", "ku"), ResultKt.to("ケ", "ke"), ResultKt.to("コ", "ko"), ResultKt.to("サ", "sa"), ResultKt.to("シ", "shi"), ResultKt.to("ス", "su"), ResultKt.to("セ", "se"), ResultKt.to("ソ", "so"), ResultKt.to("タ", "ta"), ResultKt.to("チ", "chi"), ResultKt.to("ツ", "tsu"), ResultKt.to("テ", "te"), ResultKt.to("ト", "to"), ResultKt.to("ナ", "na"), ResultKt.to("ニ", "ni"), ResultKt.to("ヌ", "nu"), ResultKt.to("ネ", "ne"), ResultKt.to("ノ", "no"), ResultKt.to("ハ", "ha"), ResultKt.to("ヒ", "hi"), ResultKt.to("フ", "fu"), ResultKt.to("ヘ", "he"), ResultKt.to("ホ", "ho"), ResultKt.to("マ", "ma"), ResultKt.to("ミ", "mi"), ResultKt.to("ム", "mu"), ResultKt.to("メ", "me"), ResultKt.to("モ", "mo"), ResultKt.to("ヤ", "ya"), ResultKt.to("ユ", "yu"), ResultKt.to("ヨ", "yo"), ResultKt.to("ラ", "ra"), ResultKt.to("リ", "ri"), ResultKt.to("ル", "ru"), ResultKt.to("レ", "re"), ResultKt.to("ロ", "ro"), ResultKt.to("ワ", "wa"), ResultKt.to("ヲ", "o"), ResultKt.to("ン", "n"), ResultKt.to("ガ", "ga"), ResultKt.to("ギ", "gi"), ResultKt.to("グ", "gu"), ResultKt.to("ゲ", "ge"), ResultKt.to("ゴ", "go"), ResultKt.to("ザ", "za"), ResultKt.to("ジ", "ji"), ResultKt.to("ズ", "zu"), ResultKt.to("ゼ", "ze"), ResultKt.to("ゾ", "zo"), ResultKt.to("ダ", "da"), ResultKt.to("ヂ", "ji"), ResultKt.to("ヅ", "zu"), ResultKt.to("デ", "de"), ResultKt.to("ド", "do"), ResultKt.to("バ", "ba"), ResultKt.to("ビ", "bi"), ResultKt.to("ブ", "bu"), ResultKt.to("ベ", "be"), ResultKt.to("ボ", "bo"), ResultKt.to("パ", "pa"), ResultKt.to("ピ", "pi"), ResultKt.to("プ", "pu"), ResultKt.to("ペ", "pe"), ResultKt.to("ポ", "po"), ResultKt.to("ー", ""));
    public static final Map HANGUL_ROMAJA_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("cho", MapsKt__MapsKt.mapOf(ResultKt.to("ᄀ", "g"), ResultKt.to("ᄁ", "kk"), ResultKt.to("ᄂ", "n"), ResultKt.to("ᄃ", "d"), ResultKt.to("ᄄ", "tt"), ResultKt.to("ᄅ", "r"), ResultKt.to("ᄆ", "m"), ResultKt.to("ᄇ", "b"), ResultKt.to("ᄈ", "pp"), ResultKt.to("ᄉ", "s"), ResultKt.to("ᄊ", "ss"), ResultKt.to("ᄋ", ""), ResultKt.to("ᄌ", "j"), ResultKt.to("ᄍ", "jj"), ResultKt.to("ᄎ", "ch"), ResultKt.to("ᄏ", "k"), ResultKt.to("ᄐ", "t"), ResultKt.to("ᄑ", "p"), ResultKt.to("ᄒ", "h"))), ResultKt.to("jung", MapsKt__MapsKt.mapOf(ResultKt.to("ᅡ", "a"), ResultKt.to("ᅢ", "ae"), ResultKt.to("ᅣ", "ya"), ResultKt.to("ᅤ", "yae"), ResultKt.to("ᅥ", "eo"), ResultKt.to("ᅦ", "e"), ResultKt.to("ᅧ", "yeo"), ResultKt.to("ᅨ", "ye"), ResultKt.to("ᅩ", "o"), ResultKt.to("ᅪ", "wa"), ResultKt.to("ᅫ", "wae"), ResultKt.to("ᅬ", "oe"), ResultKt.to("ᅭ", "yo"), ResultKt.to("ᅮ", "u"), ResultKt.to("ᅯ", "wo"), ResultKt.to("ᅰ", "we"), ResultKt.to("ᅱ", "wi"), ResultKt.to("ᅲ", "yu"), ResultKt.to("ᅳ", "eu"), ResultKt.to("ᅴ", "eui"), ResultKt.to("ᅵ", "i"))), ResultKt.to("jong", MapsKt__MapsKt.mapOf(ResultKt.to("ᆨ", "k"), ResultKt.to("ᆨᄋ", "g"), ResultKt.to("ᆨᄂ", "ngn"), ResultKt.to("ᆨᄅ", "ngn"), ResultKt.to("ᆨᄆ", "ngm"), ResultKt.to("ᆨᄒ", "kh"), ResultKt.to("ᆩ", "kk"), ResultKt.to("ᆩᄋ", "kg"), ResultKt.to("ᆩᄂ", "ngn"), ResultKt.to("ᆩᄅ", "ngn"), ResultKt.to("ᆩᄆ", "ngm"), ResultKt.to("ᆩᄒ", "kh"), ResultKt.to("ᆪ", "k"), ResultKt.to("ᆪᄋ", "ks"), ResultKt.to("ᆪᄂ", "ngn"), ResultKt.to("ᆪᄅ", "ngn"), ResultKt.to("ᆪᄆ", "ngm"), ResultKt.to("ᆪᄒ", "kch"), ResultKt.to("ᆫ", "n"), ResultKt.to("ᆫᄅ", "ll"), ResultKt.to("ᆬ", "n"), ResultKt.to("ᆬᄋ", "nj"), ResultKt.to("ᆬᄂ", "nn"), ResultKt.to("ᆬᄅ", "nn"), ResultKt.to("ᆬᄆ", "nm"), ResultKt.to("ᆬㅎ", "nch"), ResultKt.to("ᆭ", "n"), ResultKt.to("ᆭᄋ", "nh"), ResultKt.to("ᆭᄅ", "nn"), ResultKt.to("ᆮ", "t"), ResultKt.to("ᆮᄋ", "d"), ResultKt.to("ᆮᄂ", "nn"), ResultKt.to("ᆮᄅ", "nn"), ResultKt.to("ᆮᄆ", "nm"), ResultKt.to("ᆮᄒ", "th"), ResultKt.to("ᆯ", "l"), ResultKt.to("ᆯᄋ", "r"), ResultKt.to("ᆯᄂ", "ll"), ResultKt.to("ᆯᄅ", "ll"), ResultKt.to("ᆰ", "k"), ResultKt.to("ᆰᄋ", "lg"), ResultKt.to("ᆰᄂ", "ngn"), ResultKt.to("ᆰᄅ", "ngn"), ResultKt.to("ᆰᄆ", "ngm"), ResultKt.to("ᆰᄒ", "lkh"), ResultKt.to("ᆱ", "m"), ResultKt.to("ᆱᄋ", "lm"), ResultKt.to("ᆱᄂ", "mn"), ResultKt.to("ᆱᄅ", "mn"), ResultKt.to("ᆱᄆ", "mm"), ResultKt.to("ᆱᄒ", "lmh"), ResultKt.to("ᆲ", "p"), ResultKt.to("ᆲᄋ", "lb"), ResultKt.to("ᆲᄂ", "mn"), ResultKt.to("ᆲᄅ", "mn"), ResultKt.to("ᆲᄆ", "mm"), ResultKt.to("ᆲᄒ", "lph"), ResultKt.to("ᆳ", "t"), ResultKt.to("ᆳᄋ", "ls"), ResultKt.to("ᆳᄂ", "nn"), ResultKt.to("ᆳᄅ", "nn"), ResultKt.to("ᆳᄆ", "nm"), ResultKt.to("ᆳᄒ", "lsh"), ResultKt.to("ᆴ", "t"), ResultKt.to("ᆴᄋ", "lt"), ResultKt.to("ᆴᄂ", "nn"), ResultKt.to("ᆴᄅ", "nn"), ResultKt.to("ᆴᄆ", "nm"), ResultKt.to("ᆴᄒ", "lth"), ResultKt.to("ᆵ", "p"), ResultKt.to("ᆵᄋ", "lp"), ResultKt.to("ᆵᄂ", "mn"), ResultKt.to("ᆵᄅ", "mn"), ResultKt.to("ᆵᄆ", "mm"), ResultKt.to("ᆵᄒ", "lph"), ResultKt.to("ᆶ", "l"), ResultKt.to("ᆶᄋ", "lh"), ResultKt.to("ᆶᄂ", "ll"), ResultKt.to("ᆶᄅ", "ll"), ResultKt.to("ᆶᄆ", "lm"), ResultKt.to("ᆶᄒ", "lh"), ResultKt.to("ᆷ", "m"), ResultKt.to("ᆷᄅ", "mn"), ResultKt.to("ᆸ", "p"), ResultKt.to("ᆸᄋ", "b"), ResultKt.to("ᆸᄂ", "mn"), ResultKt.to("ᆸᄅ", "mn"), ResultKt.to("ᆸᄆ", "mm"), ResultKt.to("ᆸᄒ", "ph"), ResultKt.to("ᆹ", "p"), ResultKt.to("ᆹᄋ", "ps"), ResultKt.to("ᆹᄂ", "mn"), ResultKt.to("ᆹᄅ", "mn"), ResultKt.to("ᆹᄆ", "mm"), ResultKt.to("ᆹᄒ", "psh"), ResultKt.to("ᆺ", "t"), ResultKt.to("ᆺᄋ", "s"), ResultKt.to("ᆺᄂ", "nn"), ResultKt.to("ᆺᄅ", "nn"), ResultKt.to("ᆺᄆ", "nm"), ResultKt.to("ᆺᄒ", "sh"), ResultKt.to("ᆻ", "t"), ResultKt.to("ᆻᄋ", "ss"), ResultKt.to("ᆻᄂ", "tn"), ResultKt.to("ᆻᄅ", "tn"), ResultKt.to("ᆻᄆ", "nm"), ResultKt.to("ᆻᄒ", "th"), ResultKt.to("ᆼ", "ng"), ResultKt.to("ᆽ", "t"), ResultKt.to("ᆽᄋ", "j"), ResultKt.to("ᆽᄂ", "nn"), ResultKt.to("ᆽᄅ", "nn"), ResultKt.to("ᆽᄆ", "nm"), ResultKt.to("ᆽᄒ", "ch"), ResultKt.to("ᆾ", "t"), ResultKt.to("ᆾᄋ", "ch"), ResultKt.to("ᆾᄂ", "nn"), ResultKt.to("ᆾᄅ", "nn"), ResultKt.to("ᆾᄆ", "nm"), ResultKt.to("ᆾᄒ", "ch"), ResultKt.to("ᆿ", "k"), ResultKt.to("ᆿᄋ", "k"), ResultKt.to("ᆿᄂ", "ngn"), ResultKt.to("ᆿᄅ", "ngn"), ResultKt.to("ᆿᄆ", "ngm"), ResultKt.to("ᆿᄒ", "kh"), ResultKt.to("ᇀ", "t"), ResultKt.to("ᇀᄋ", "t"), ResultKt.to("ᇀᄂ", "nn"), ResultKt.to("ᇀᄅ", "nn"), ResultKt.to("ᇀᄆ", "nm"), ResultKt.to("ᇀᄒ", "th"), ResultKt.to("ᇁ", "p"), ResultKt.to("ᇁᄋ", "p"), ResultKt.to("ᇁᄂ", "mn"), ResultKt.to("ᇁᄅ", "mn"), ResultKt.to("ᇁᄆ", "mm"), ResultKt.to("ᇁᄒ", "ph"), ResultKt.to("ᇂ", "t"), ResultKt.to("ᇂᄋ", "h"), ResultKt.to("ᇂᄂ", "nn"), ResultKt.to("ᇂᄅ", "nn"), ResultKt.to("ᇂᄆ", "mm"), ResultKt.to("ᇂᄒ", "t"), ResultKt.to("ᇂᄀ", "k"))));
    public static final Map DEVANAGARI_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("अ", "a"), ResultKt.to("आ", "aa"), ResultKt.to("इ", "i"), ResultKt.to("ई", "ee"), ResultKt.to("उ", "u"), ResultKt.to("ऊ", "oo"), ResultKt.to("ऋ", "ri"), ResultKt.to("ए", "e"), ResultKt.to("ऐ", "ai"), ResultKt.to("ओ", "o"), ResultKt.to("औ", "au"), ResultKt.to("क", "k"), ResultKt.to("ख", "kh"), ResultKt.to("ग", "g"), ResultKt.to("घ", "gh"), ResultKt.to("ङ", "ng"), ResultKt.to("च", "ch"), ResultKt.to("छ", "chh"), ResultKt.to("ज", "j"), ResultKt.to("झ", "jh"), ResultKt.to("ञ", "ny"), ResultKt.to("ट", "t"), ResultKt.to("ठ", "th"), ResultKt.to("ड", "d"), ResultKt.to("ढ", "dh"), ResultKt.to("ण", "n"), ResultKt.to("त", "t"), ResultKt.to("थ", "th"), ResultKt.to("द", "d"), ResultKt.to("ध", "dh"), ResultKt.to("न", "n"), ResultKt.to("प", "p"), ResultKt.to("फ", "ph"), ResultKt.to("ब", "b"), ResultKt.to("भ", "bh"), ResultKt.to("म", "m"), ResultKt.to("य", "y"), ResultKt.to("र", "r"), ResultKt.to("ल", "l"), ResultKt.to("व", "v"), ResultKt.to("श", "sh"), ResultKt.to("ष", "sh"), ResultKt.to("स", "s"), ResultKt.to("ह", "h"), ResultKt.to("क्ष", "ksh"), ResultKt.to("त्र", "tr"), ResultKt.to("ज्ञ", "gy"), ResultKt.to("श्र", "shr"), ResultKt.to("ा", "aa"), ResultKt.to("ि", "i"), ResultKt.to("ी", "ee"), ResultKt.to("ु", "u"), ResultKt.to("ू", "oo"), ResultKt.to("ृ", "ri"), ResultKt.to("े", "e"), ResultKt.to("ै", "ai"), ResultKt.to("ो", "o"), ResultKt.to("ौ", "au"), ResultKt.to("ं", "n"), ResultKt.to("ः", "h"), ResultKt.to("ँ", "n"), ResultKt.to("़", ""), ResultKt.to("्", ""), ResultKt.to("०", "0"), ResultKt.to("१", "1"), ResultKt.to("२", "2"), ResultKt.to("३", "3"), ResultKt.to("४", "4"), ResultKt.to("५", "5"), ResultKt.to("६", "6"), ResultKt.to("७", "7"), ResultKt.to("८", "8"), ResultKt.to("९", "9"), ResultKt.to("ॐ", "Om"), ResultKt.to("ऽ", ""), ResultKt.to("क़", "q"), ResultKt.to("ख़", "kh"), ResultKt.to("ग़", "g"), ResultKt.to("ज़", "z"), ResultKt.to("ड़", "r"), ResultKt.to("ढ़", "rh"), ResultKt.to("फ़", "f"), ResultKt.to("य़", "y"), ResultKt.to("क़", "q"), ResultKt.to("ख़", "kh"), ResultKt.to("ग़", "g"), ResultKt.to("ज़", "z"), ResultKt.to("ड़", "r"), ResultKt.to("ढ़", "rh"), ResultKt.to("फ़", "f"), ResultKt.to("य़", "y"));

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsUtils$romanizeHindi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsUtils.this.romanizeHindi(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsUtils$romanizeHindi$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ String $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(String str, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            String str = this.$text;
            switch (b) {
                case 0:
                    return new AnonymousClass2(str, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2(str, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass2(str, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass2(str, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass2(str, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass2(str, continuation, (byte) 5);
                default:
                    return new AnonymousClass2(str, continuation, (byte) 6);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 1:
                    ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                    return unit;
                case 2:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:119:0x0213  */
        /* JADX WARN: Code duplicated, block: B:133:0x0255  */
        /* JADX WARN: Code duplicated, block: B:203:0x03f4  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r4v22, types: [java.lang.Character] */
        /* JADX WARN: Type inference failed for: r4v29 */
        /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v24 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z;
            ?? surface;
            Throwable th;
            String lowerCase;
            boolean z2;
            Throwable th2;
            ?? r4;
            String strValueOf;
            Character orNull;
            Character orNull2;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            byte b = this.$r8$classId;
            Throwable th3 = null;
            int i = 0;
            String str6 = this.$text;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb = new StringBuilder(str6.length());
                    int i2 = 0;
                    while (i2 < str6.length()) {
                        if (i2 + 1 < str6.length()) {
                            int i3 = i2 + 2;
                            String str7 = (String) LyricsUtils.DEVANAGARI_ROMAJI_MAP.get(str6.substring(i2, i3));
                            if (str7 != null) {
                                sb.append(str7);
                                i2 = i3;
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            String strValueOf2 = String.valueOf(str6.charAt(i2));
                            String str8 = (String) LyricsUtils.DEVANAGARI_ROMAJI_MAP.get(strValueOf2);
                            if (str8 != null) {
                                strValueOf2 = str8;
                            }
                            sb.append(strValueOf2);
                            i2++;
                        }
                    }
                    return sb.toString();
                case 1:
                    ResultKt.throwOnFailure(obj);
                    DiscordUser discordUserFetchCurrentUser = DiscordRpcManager.INSTANCE.fetchCurrentUser(str6);
                    ((StateFlowImpl) DiscordRpcManager._currentUser).setValue(discordUserFetchCurrentUser);
                    if (discordUserFetchCurrentUser != null) {
                        Timber.Forest.tag("DiscordSvc");
                        ConnectionPool.i(discordUserFetchCurrentUser.username);
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    if (str6.length() == 0) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder(str6.length() * 2);
                    int length = str6.length();
                    while (i < length) {
                        char cCharAt = str6.charAt(i);
                        if (19968 > cCharAt || cCharAt >= 40960) {
                            sb2.append(cCharAt);
                        } else {
                            String strValueOf3 = ((19968 > cCharAt || cCharAt > 40869 || Pinyin.getPinyinCode(cCharAt) <= 0) && 12295 != cCharAt) ? String.valueOf(cCharAt) : cCharAt == 12295 ? "LING" : Pinyin.PINYIN_TABLE[Pinyin.getPinyinCode(cCharAt)];
                            strValueOf3.getClass();
                            Locale locale = Locale.getDefault();
                            locale.getClass();
                            String lowerCase2 = strValueOf3.toLowerCase(locale);
                            lowerCase2.getClass();
                            sb2.append(lowerCase2);
                            sb2.append(' ');
                        }
                        i++;
                    }
                    String string = sb2.toString();
                    Pattern patternCompile = Pattern.compile("\\s+([,.!?;:])");
                    patternCompile.getClass();
                    String strReplaceAll = patternCompile.matcher(string).replaceAll("$1");
                    strReplaceAll.getClass();
                    Pattern patternCompile2 = Pattern.compile("\\s+([，。！？；：、（）《》〈〉【】『』「」])");
                    patternCompile2.getClass();
                    String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("$1");
                    strReplaceAll2.getClass();
                    return StringsKt.trim(strReplaceAll2).toString();
                case 3:
                    ResultKt.throwOnFailure(obj);
                    List<Token> list = ((Tokenizer) LyricsUtils.kuromojiTokenizer$delegate.getValue()).tokenize(str6);
                    list.getClass();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    int i4 = 0;
                    for (Object obj2 : list) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            Throwable th4 = th3;
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw th4;
                        }
                        Token token = (Token) obj2;
                        String reading = token.getReading();
                        String surface2 = (reading == null || reading.length() == 0 || Intrinsics.areEqual(token.getReading(), "*")) ? token.getSurface() : token.getReading();
                        if (i5 < list.size()) {
                            String reading2 = list.get(i5).getReading();
                            if (reading2 == null) {
                                surface = list.get(i5).getSurface();
                            } else {
                                if (reading2.length() <= 0 || reading2.equals("*")) {
                                    surface = reading2;
                                    surface = th3;
                                }
                                if (surface == 0) {
                                    surface = list.get(i5).getSurface();
                                }
                            }
                        } else {
                            surface = th3;
                        }
                        Map map = LyricsUtils.KANA_ROMAJI_MAP;
                        if (surface2 == null || surface2.length() == 0) {
                            th = th3;
                            lowerCase = "";
                        } else {
                            StringBuilder sb3 = new StringBuilder(surface2.length());
                            int length2 = surface2.length();
                            int i6 = 0;
                            while (i6 < length2) {
                                if (i6 + 1 < length2) {
                                    int i7 = i6 + 2;
                                    String str9 = (String) map.get(surface2.substring(i6, i7));
                                    if (str9 != null) {
                                        sb3.append(str9);
                                        i6 = i7;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    th2 = th3;
                                } else {
                                    th2 = th3;
                                    if (surface2.charAt(i6) == 12483) {
                                        if (surface != 0) {
                                            orNull2 = StringsKt.getOrNull(0, surface);
                                        } else {
                                            r4 = th2;
                                        }
                                        if (r4 != 0) {
                                            String str10 = (String) map.get(String.valueOf(r4.charValue()));
                                            if (str10 == null || (orNull = StringsKt.getOrNull(0, str10)) == null || (strValueOf = String.valueOf(orNull.charValue())) == null) {
                                                r4 = orNull2;
                                                r4 = orNull2;
                                                r4 = orNull2;
                                                strValueOf = String.valueOf(r4.charValue());
                                            }
                                            r4 = orNull2;
                                            String lowerCase3 = strValueOf.toLowerCase(Locale.ROOT);
                                            lowerCase3.getClass();
                                            sb3.append(StringsKt.trim(lowerCase3).toString());
                                        }
                                        r4 = orNull2;
                                        i6++;
                                        z2 = true;
                                    }
                                }
                                if (!z2) {
                                    String strValueOf4 = String.valueOf(surface2.charAt(i6));
                                    String str11 = (String) map.get(strValueOf4);
                                    if (str11 != null) {
                                        sb3.append(str11);
                                    } else {
                                        sb3.append(strValueOf4);
                                    }
                                    i6++;
                                }
                                th3 = th2;
                            }
                            th = th3;
                            lowerCase = sb3.toString().toLowerCase(Locale.ROOT);
                            lowerCase.getClass();
                        }
                        arrayList.add(lowerCase);
                        i4 = i5;
                        th3 = th;
                    }
                    return CollectionsKt.joinToString$default(arrayList, ServerSentEventKt.SPACE, null, null, null, 62);
                case 4:
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb4 = new StringBuilder();
                    int length3 = str6.length();
                    String str12 = null;
                    while (i < length3) {
                        char cCharAt2 = str6.charAt(i);
                        if (44032 > cCharAt2 || cCharAt2 >= 55204) {
                            if (str12 != null) {
                                Map map2 = (Map) LyricsUtils.HANGUL_ROMAJA_MAP.get("jong");
                                if (map2 != null && (str2 = (String) map2.get(str12)) != null) {
                                    str12 = str2;
                                }
                                sb4.append(str12);
                                str12 = null;
                            }
                            sb4.append(cCharAt2);
                        } else {
                            int i8 = cCharAt2 - 44032;
                            int i9 = i8 / 588;
                            int i10 = (i8 % 588) / 28;
                            int i11 = i8 % 28;
                            String strValueOf5 = String.valueOf((char) (i9 + 4352));
                            String strValueOf6 = String.valueOf((char) (i10 + 4449));
                            String strValueOf7 = i11 == 0 ? null : String.valueOf((char) (i11 + 4519));
                            if (str12 != null) {
                                String strM = Fragment$5$$ExternalSyntheticOutline0.m(str12, strValueOf5);
                                Map map3 = LyricsUtils.HANGUL_ROMAJA_MAP;
                                Map map4 = (Map) map3.get("jong");
                                if (map4 == null || (str5 = (String) map4.get(strM)) == null) {
                                    Map map5 = (Map) map3.get("jong");
                                    String str13 = map5 != null ? (String) map5.get(str12) : null;
                                    if (str13 != null) {
                                        str12 = str13;
                                    }
                                } else {
                                    str12 = str5;
                                }
                                sb4.append(str12);
                            }
                            Map map6 = LyricsUtils.HANGUL_ROMAJA_MAP;
                            Map map7 = (Map) map6.get("cho");
                            if (map7 != null && (str4 = (String) map7.get(strValueOf5)) != null) {
                                strValueOf5 = str4;
                            }
                            Map map8 = (Map) map6.get("jung");
                            if (map8 != null && (str3 = (String) map8.get(strValueOf6)) != null) {
                                strValueOf6 = str3;
                            }
                            sb4.append(strValueOf5);
                            sb4.append(strValueOf6);
                            str12 = strValueOf7;
                        }
                        i++;
                    }
                    if (str12 != null) {
                        Map map9 = (Map) LyricsUtils.HANGUL_ROMAJA_MAP.get("jong");
                        if (map9 != null && (str = (String) map9.get(str12)) != null) {
                            str12 = str;
                        }
                        sb4.append(str12);
                    }
                    return sb4.toString();
                case 5:
                    ResultKt.throwOnFailure(obj);
                    JsonImpl jsonImpl = ArtistPageCacheKt.json;
                    jsonImpl.getClass();
                    return (CachedArtistPage) jsonImpl.decodeFromString(CachedArtistPage.INSTANCE.serializer(), str6);
                default:
                    ResultKt.throwOnFailure(obj);
                    Collection lyrics = EmptyList.INSTANCE;
                    if (str6 == null || str6.equals("LYRICS_NOT_FOUND")) {
                        return lyrics;
                    }
                    if (LyricsViewModel.timestampRegex.containsMatchIn(str6)) {
                        LyricsUtils lyricsUtils = LyricsUtils.INSTANCE;
                        lyrics = LyricsUtils.parseLyrics(str6);
                    }
                    if (!lyrics.isEmpty()) {
                        return CollectionsKt.plus((Iterable) lyrics, (Collection) CollectionsKt__IterablesKt.listOf(LyricsEntry.HEAD_LYRICS_ENTRY));
                    }
                    List listLines = StringsKt.lines(str6);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : listLines) {
                        String str14 = (String) obj3;
                        if (!StringsKt.isBlank(str14) && !LyricsViewModel.timestampRegex.containsMatchIn(str14)) {
                            arrayList2.add(obj3);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                    int size = arrayList2.size();
                    int i12 = 0;
                    while (i12 < size) {
                        Object obj4 = arrayList2.get(i12);
                        i12++;
                        int i13 = i + 1;
                        if (i < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        arrayList3.add(new LyricsEntry(1000000 + ((long) i), (String) obj4, null, null, false, 124));
                        i = i13;
                    }
                    return arrayList3;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsUtils$romanizeKorean$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01601 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01601(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsUtils.this.romanizeKorean(null, this);
        }
    }

    static {
        MapsKt__MapsKt.mapOf(ResultKt.to("ੳ", "o"), ResultKt.to("ਅ", "a"), ResultKt.to("ੲ", "e"), ResultKt.to("ਸ", "s"), ResultKt.to("ਹ", "h"), ResultKt.to("ਕ", "k"), ResultKt.to("ਖ", "kh"), ResultKt.to("ਗ", "g"), ResultKt.to("ਘ", "gh"), ResultKt.to("ਙ", "ng"), ResultKt.to("ਚ", "ch"), ResultKt.to("ਛ", "chh"), ResultKt.to("ਜ", "j"), ResultKt.to("ਝ", "jh"), ResultKt.to("ਞ", "ny"), ResultKt.to("ਟ", "t"), ResultKt.to("ਠ", "th"), ResultKt.to("ਡ", "d"), ResultKt.to("ਢ", "dh"), ResultKt.to("ਣ", "n"), ResultKt.to("ਤ", "t"), ResultKt.to("ਥ", "th"), ResultKt.to("ਦ", "d"), ResultKt.to("ਧ", "dh"), ResultKt.to("ਨ", "n"), ResultKt.to("ਪ", "p"), ResultKt.to("ਫ", "ph"), ResultKt.to("ਬ", "b"), ResultKt.to("ਭ", "bh"), ResultKt.to("ਮ", "m"), ResultKt.to("ਯ", "y"), ResultKt.to("ਰ", "r"), ResultKt.to("ਲ", "l"), ResultKt.to("ਵ", "v"), ResultKt.to("ੜ", "r"), ResultKt.to("ਸ਼", "sh"), ResultKt.to("ਖ਼", "kh"), ResultKt.to("ਗ਼", "g"), ResultKt.to("ਜ਼", "z"), ResultKt.to("ਫ਼", "f"), ResultKt.to("ਲ਼", "l"), ResultKt.to("ਾ", "aa"), ResultKt.to("ਿ", "i"), ResultKt.to("ੀ", "ee"), ResultKt.to("ੁ", "u"), ResultKt.to("ੂ", "oo"), ResultKt.to("ੇ", "e"), ResultKt.to("ੈ", "ai"), ResultKt.to("ੋ", "o"), ResultKt.to("ੌ", "au"), ResultKt.to("ੰ", "n"), ResultKt.to("ਂ", "n"), ResultKt.to("ੱ", ""), ResultKt.to("੍", ""), ResultKt.to("਼", ""), ResultKt.to("ੴ", "Ek Onkar"), ResultKt.to("੦", "0"), ResultKt.to("੧", "1"), ResultKt.to("੨", "2"), ResultKt.to("੩", "3"), ResultKt.to("੪", "4"), ResultKt.to("੫", "5"), ResultKt.to("੬", "6"), ResultKt.to("੭", "7"), ResultKt.to("੮", "8"), ResultKt.to("੯", "9"));
        GENERAL_CYRILLIC_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("А", "A"), ResultKt.to("Б", "B"), ResultKt.to("В", "V"), ResultKt.to("Г", "G"), ResultKt.to("Ґ", "G"), ResultKt.to("Д", "D"), ResultKt.to("Ѓ", "Ǵ"), ResultKt.to("Ђ", "Đ"), ResultKt.to("Е", "E"), ResultKt.to("Ё", "Yo"), ResultKt.to("Є", "Ye"), ResultKt.to("Ж", "Zh"), ResultKt.to("З", "Z"), ResultKt.to("Ѕ", "Dz"), ResultKt.to("И", "I"), ResultKt.to("І", "I"), ResultKt.to("Ї", "Yi"), ResultKt.to("Й", "Y"), ResultKt.to("Ј", "Y"), ResultKt.to("К", "K"), ResultKt.to("Л", "L"), ResultKt.to("Љ", "Ly"), ResultKt.to("М", "M"), ResultKt.to("Н", "N"), ResultKt.to("Њ", "Ny"), ResultKt.to("О", "O"), ResultKt.to("П", "P"), ResultKt.to("Р", "R"), ResultKt.to("С", "S"), ResultKt.to("Т", "T"), ResultKt.to("Ћ", "Ć"), ResultKt.to("У", "U"), ResultKt.to("Ў", "Ŭ"), ResultKt.to("Ф", "F"), ResultKt.to("Х", "Kh"), ResultKt.to("Ц", "Ts"), ResultKt.to("Ч", "Ch"), ResultKt.to("Џ", "Dž"), ResultKt.to("Ш", "Sh"), ResultKt.to("Щ", "Shch"), ResultKt.to("Ъ", "ʺ"), ResultKt.to("Ы", "Y"), ResultKt.to("Ь", "ʹ"), ResultKt.to("Э", "E"), ResultKt.to("Ю", "Yu"), ResultKt.to("Я", "Ya"), ResultKt.to("Ѡ", "O"), ResultKt.to("Ѣ", "Ya"), ResultKt.to("Ѥ", "Ye"), ResultKt.to("Ѧ", "Ya"), ResultKt.to("Ѩ", "Ya"), ResultKt.to("Ѫ", "U"), ResultKt.to("Ѭ", "Yu"), ResultKt.to("Ѯ", "Ks"), ResultKt.to("Ѱ", "Ps"), ResultKt.to("Ѳ", "F"), ResultKt.to("Ѵ", "I"), ResultKt.to("Ѷ", "I"), ResultKt.to("Ғ", "Gh"), ResultKt.to("Ҕ", "G"), ResultKt.to("Җ", "Zh"), ResultKt.to("Ҙ", "Dz"), ResultKt.to("Қ", "Q"), ResultKt.to("Ҝ", "K"), ResultKt.to("Ҟ", "K"), ResultKt.to("Ҡ", "K"), ResultKt.to("Ң", "Ng"), ResultKt.to("Ҥ", "Ng"), ResultKt.to("Ҧ", "P"), ResultKt.to("Ҩ", "O"), ResultKt.to("Ҫ", "S"), ResultKt.to("Ҭ", "T"), ResultKt.to("Ү", "U"), ResultKt.to("Ұ", "U"), ResultKt.to("Ҳ", "Kh"), ResultKt.to("Ҵ", "Ts"), ResultKt.to("Ҷ", "Ch"), ResultKt.to("Ҹ", "Ch"), ResultKt.to("Һ", "H"), ResultKt.to("Ҽ", "Ch"), ResultKt.to("Ҿ", "Ch"), ResultKt.to("Ќ", "Ḱ"), ResultKt.to("Ө", "Ö"), ResultKt.to("а", "a"), ResultKt.to("б", "b"), ResultKt.to("в", "v"), ResultKt.to("г", "g"), ResultKt.to("ґ", "g"), ResultKt.to("д", "d"), ResultKt.to("ѓ", "ǵ"), ResultKt.to("ђ", "đ"), ResultKt.to("е", "e"), ResultKt.to("ё", "yo"), ResultKt.to("є", "ye"), ResultKt.to("ж", "zh"), ResultKt.to("з", "z"), ResultKt.to("ѕ", "dz"), ResultKt.to("и", "i"), ResultKt.to("і", "i"), ResultKt.to("ї", "yi"), ResultKt.to("й", "y"), ResultKt.to("ј", "y"), ResultKt.to("к", "k"), ResultKt.to("л", "l"), ResultKt.to("љ", "ly"), ResultKt.to("м", "m"), ResultKt.to("н", "n"), ResultKt.to("њ", "ny"), ResultKt.to("о", "o"), ResultKt.to("п", "p"), ResultKt.to("р", "r"), ResultKt.to("с", "s"), ResultKt.to("т", "t"), ResultKt.to("ћ", "ć"), ResultKt.to("у", "u"), ResultKt.to("ў", "ŭ"), ResultKt.to("ф", "f"), ResultKt.to("х", "kh"), ResultKt.to("ц", "ts"), ResultKt.to("ч", "ch"), ResultKt.to("џ", "dž"), ResultKt.to("ш", "sh"), ResultKt.to("щ", "shch"), ResultKt.to("ъ", "ʺ"), ResultKt.to("ы", "y"), ResultKt.to("ь", "ʹ"), ResultKt.to("э", "e"), ResultKt.to("ю", "yu"), ResultKt.to("я", "ya"), ResultKt.to("ѡ", "o"), ResultKt.to("ѣ", "ya"), ResultKt.to("ѥ", "ye"), ResultKt.to("ѧ", "ya"), ResultKt.to("ѩ", "ya"), ResultKt.to("ѫ", "u"), ResultKt.to("ѭ", "yu"), ResultKt.to("ѯ", "ks"), ResultKt.to("ѱ", "ps"), ResultKt.to("ѳ", "f"), ResultKt.to("ѵ", "i"), ResultKt.to("ѷ", "i"), ResultKt.to("ғ", "gh"), ResultKt.to("ҕ", "g"), ResultKt.to("җ", "zh"), ResultKt.to("ҙ", "dz"), ResultKt.to("қ", "q"), ResultKt.to("ҝ", "k"), ResultKt.to("ҟ", "k"), ResultKt.to("ҡ", "k"), ResultKt.to("ң", "ng"), ResultKt.to("ҥ", "ng"), ResultKt.to("ҧ", "p"), ResultKt.to("ҩ", "o"), ResultKt.to("ҫ", "s"), ResultKt.to("ҭ", "t"), ResultKt.to("ү", "u"), ResultKt.to("ұ", "u"), ResultKt.to("ҳ", "kh"), ResultKt.to("ҵ", "ts"), ResultKt.to("ҷ", "ch"), ResultKt.to("ҹ", "ch"), ResultKt.to("һ", "h"), ResultKt.to("ҽ", "ch"), ResultKt.to("ҿ", "ch"), ResultKt.to("ќ", "ḱ"), ResultKt.to("ө", "ö"));
        RUSSIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("ого", "ovo"), ResultKt.to("Ого", "Ovo"), ResultKt.to("его", "evo"), ResultKt.to("Его", "Evo"));
        UKRAINIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Г", "H"), ResultKt.to("г", "h"), ResultKt.to("Ґ", "G"), ResultKt.to("ґ", "g"), ResultKt.to("Є", "Ye"), ResultKt.to("є", "ye"), ResultKt.to("І", "I"), ResultKt.to("і", "i"), ResultKt.to("Ї", "Yi"), ResultKt.to("ї", "yi"));
        SERBIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Ж", "Ž"), ResultKt.to("Љ", "Lj"), ResultKt.to("Њ", "Nj"), ResultKt.to("Ц", "C"), ResultKt.to("Ч", "Č"), ResultKt.to("Џ", "Dž"), ResultKt.to("Ш", "Š"), ResultKt.to("Х", "H"), ResultKt.to("ж", "ž"), ResultKt.to("љ", "lj"), ResultKt.to("њ", "nj"), ResultKt.to("ц", "c"), ResultKt.to("ч", "č"), ResultKt.to("џ", "dž"), ResultKt.to("ш", "š"), ResultKt.to("х", "h"));
        BULGARIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Ж", "Zh"), ResultKt.to("Ц", "Ts"), ResultKt.to("Ч", "Ch"), ResultKt.to("Ш", "Sh"), ResultKt.to("Щ", "Sht"), ResultKt.to("Ъ", "A"), ResultKt.to("Ь", "Y"), ResultKt.to("Ю", "Yu"), ResultKt.to("Я", "Ya"), ResultKt.to("ж", "zh"), ResultKt.to("ц", "ts"), ResultKt.to("ч", "ch"), ResultKt.to("ш", "sh"), ResultKt.to("щ", "sht"), ResultKt.to("ъ", "a"), ResultKt.to("ь", "y"), ResultKt.to("ю", "yu"), ResultKt.to("я", "ya"));
        BELARUSIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Г", "H"), ResultKt.to("г", "h"), ResultKt.to("Ў", "W"), ResultKt.to("ў", "w"));
        KYRGYZ_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Ү", "Ü"), ResultKt.to("ү", "ü"), ResultKt.to("Ы", "Y"), ResultKt.to("ы", "y"));
        MACEDONIAN_ROMAJI_MAP = MapsKt__MapsKt.mapOf(ResultKt.to("Ѓ", "Gj"), ResultKt.to("Ѕ", "Dz"), ResultKt.to("И", "I"), ResultKt.to("Ј", "J"), ResultKt.to("Љ", "Lj"), ResultKt.to("Њ", "Nj"), ResultKt.to("Ќ", "Kj"), ResultKt.to("Џ", "Dž"), ResultKt.to("Ч", "Č"), ResultKt.to("Ш", "Sh"), ResultKt.to("Ж", "Zh"), ResultKt.to("Ц", "C"), ResultKt.to("Х", "H"), ResultKt.to("ѓ", "gj"), ResultKt.to("ѕ", "dz"), ResultKt.to("и", "i"), ResultKt.to("ј", "j"), ResultKt.to("љ", "lj"), ResultKt.to("њ", "nj"), ResultKt.to("ќ", "kj"), ResultKt.to("џ", "dž"), ResultKt.to("ч", "č"), ResultKt.to("ш", "sh"), ResultKt.to("ж", "zh"), ResultKt.to("ц", "c"), ResultKt.to("х", "h"), ResultKt.to("Ѐ", "E"), ResultKt.to("ѐ", "e"), ResultKt.to("Ѝ", "I"), ResultKt.to("ѝ", "i"));
        RUSSIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"});
        UKRAINIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Ґ", "Д", "Е", "Є", "Ж", "З", "И", "І", "Ї", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ь", "Ю", "Я", "а", "б", "в", "г", "ґ", "д", "е", "є", "ж", "з", "и", "і", "ї", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ю", "я"});
        SERBIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Ђ", "Е", "Ж", "З", "И", "Ј", "К", "Л", "Љ", "М", "Н", "Њ", "О", "П", "Р", "С", "Т", "Ћ", "У", "Ф", "Х", "Ц", "Ч", "Џ", "Ш", "а", "б", "в", "г", "д", "ђ", "е", "ж", "з", "и", "ј", "к", "л", "љ", "м", "н", "њ", "о", "п", "р", "с", "т", "ћ", "у", "ф", "х", "ц", "ч", "џ", "ш"});
        BULGARIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ь", "Ю", "Я", "а", "б", "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ь", "ю", "я"});
        BELARUSIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "І", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ў", "Ф", "Х", "Ц", "Ч", "Ш", "Ь", "Ю", "Я", "Ы", "Э", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "і", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ў", "ф", "х", "ц", "ч", "ш", "ь", "ю", "я", "ы", "э"});
        KYRGYZ_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "Ң", "О", "Ө", "П", "Р", "С", "Т", "У", "Ү", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "ң", "о", "ө", "п", "р", "с", "т", "у", "ү", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"});
        MACEDONIAN_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"А", "Б", "В", "Г", "Д", "Ѓ", "Е", "Ж", "З", "Ѕ", "И", "Ј", "К", "Л", "Љ", "М", "Н", "Њ", "О", "П", "Р", "С", "Т", "Ќ", "У", "Ф", "Х", "Ц", "Ч", "Џ", "Ш", "а", "б", "в", "г", "д", "ѓ", "е", "ж", "з", "ѕ", "и", "ј", "к", "л", "љ", "м", "н", "њ", "о", "п", "р", "с", "т", "ќ", "у", "ф", "х", "ц", "ч", "џ", "ш", "Ѐ", "ѐ", "Ѝ", "ѝ"});
        UKRAINIAN_SPECIFIC_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"Ґ", "ґ", "Є", "є", "І", "і", "Ї", "ї"});
        SERBIAN_SPECIFIC_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"Ђ", "ђ", "Ј", "ј", "Љ", "љ", "Њ", "њ", "Ћ", "ћ", "Џ", "џ"});
        BELARUSIAN_SPECIFIC_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"Ў", "ў", "І", "і"});
        KYRGYZ_SPECIFIC_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"Ң", "ң", "Ө", "ө", "Ү", "ү"});
        MACEDONIAN_SPECIFIC_CYRILLIC_LETTERS = SetsKt.setOf((Object[]) new String[]{"Ѓ", "ѓ", "Ѕ", "ѕ", "Ќ", "ќ"});
        kuromojiTokenizer$delegate = ResultKt.lazy(new LyricLine$$ExternalSyntheticLambda0((byte) 12));
        Pattern.compile("&#x([0-9a-fA-F]+);").getClass();
        Pattern.compile("&#(\\d+);").getClass();
    }

    public static String cleanTitleForSearch(String str) {
        str.getClass();
        Pattern patternCompile = Pattern.compile("\\s*[(\\[].*?[)\\]]");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        return StringsKt.trim(strReplaceAll).toString();
    }

    public static String filterLyricsCreditLines(String str) {
        str.getClass();
        List listLines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            String string = StringsKt.trim((String) obj).toString();
            while (true) {
                boolean z = true;
                while (true) {
                    if (!z) {
                        break;
                    }
                    int length = string.length();
                    Pattern patternCompile = Pattern.compile("^\\[\\d\\d:\\d\\d\\.\\d{2,3}\\]");
                    patternCompile.getClass();
                    String strReplaceFirst = patternCompile.matcher(string).replaceFirst("");
                    strReplaceFirst.getClass();
                    Pattern patternCompile2 = Pattern.compile("^\\{agent:[^}]+\\}");
                    patternCompile2.getClass();
                    String strReplaceFirst2 = patternCompile2.matcher(strReplaceFirst).replaceFirst("");
                    strReplaceFirst2.getClass();
                    Pattern patternCompile3 = Pattern.compile("^\\{bg\\}");
                    patternCompile3.getClass();
                    String strReplaceFirst3 = patternCompile3.matcher(strReplaceFirst2).replaceFirst("");
                    strReplaceFirst3.getClass();
                    Pattern patternCompile4 = Pattern.compile("^\\[bg:.*\\]");
                    patternCompile4.getClass();
                    String strReplaceFirst4 = patternCompile4.matcher(strReplaceFirst3).replaceFirst("");
                    strReplaceFirst4.getClass();
                    Pattern patternCompile5 = Pattern.compile("^v\\d+:");
                    patternCompile5.getClass();
                    String strReplaceFirst5 = patternCompile5.matcher(strReplaceFirst4).replaceFirst("");
                    strReplaceFirst5.getClass();
                    string = StringsKt.trim(strReplaceFirst5).toString();
                    if (string.length() >= length) {
                        z = false;
                    }
                }
            }
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = string.toLowerCase(locale);
            lowerCase.getClass();
            if (!StringsKt__StringsJVMKt.startsWith(lowerCase, "synced by", false) && !StringsKt__StringsJVMKt.startsWith(lowerCase, "lyrics by", false) && !StringsKt__StringsJVMKt.startsWith(lowerCase, "music by", false) && !StringsKt__StringsJVMKt.startsWith(lowerCase, "arranged by", false) && (!StringsKt__StringsJVMKt.startsWith(lowerCase, "[", false) || !StringsKt__StringsJVMKt.endsWith(lowerCase, "]", false) || lowerCase.length() >= 40 || !StringsKt.contains(lowerCase, "synced by", false))) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", null, null, null, 62);
    }

    public static LinkedHashSet findActiveLineIndices(List list, long j) {
        boolean z;
        long j2;
        list.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (list.isEmpty()) {
            z = false;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            List list2 = ((LyricsEntry) it.next()).words;
            if (list2 != null && !list2.isEmpty()) {
                z = true;
                break;
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LyricsEntry lyricsEntry = (LyricsEntry) list.get(i);
            long j3 = lyricsEntry.time;
            List list3 = lyricsEntry.words;
            if (j3 > j) {
                break;
            }
            if (list3 == null || list3.isEmpty()) {
                int i2 = i + 1;
                j2 = i2 < list.size() ? ((LyricsEntry) list.get(i2)).time : Long.MAX_VALUE;
            } else {
                j2 = (long) (((WordTimestamp) CollectionsKt.last(list3)).endTime * 1000.0d);
            }
            if (j <= j2) {
                linkedHashSet.add(Integer.valueOf(i));
            }
        }
        if (!z && linkedHashSet.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : linkedHashSet) {
                if (!((LyricsEntry) list.get(((Number) obj).intValue())).isBackground) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() > 1) {
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                long j4 = ((LyricsEntry) list.get(((Number) it2.next()).intValue())).time;
                while (it2.hasNext()) {
                    long j5 = ((LyricsEntry) list.get(((Number) it2.next()).intValue())).time;
                    if (j4 < j5) {
                        j4 = j5;
                    }
                }
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    Integer num = (Integer) it3.next();
                    if (arrayList.contains(num) && ((LyricsEntry) list.get(num.intValue())).time < j4) {
                        it3.remove();
                    }
                }
                return linkedHashSet;
            }
        }
        return linkedHashSet;
    }

    public static boolean isBelarusian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strValueOf = String.valueOf(cCharAt);
            Set set = BELARUSIAN_CYRILLIC_LETTERS;
            boolean zContains = set.contains(strValueOf);
            Set set2 = BELARUSIAN_SPECIFIC_CYRILLIC_LETTERS;
            if (zContains || set2.contains(String.valueOf(cCharAt))) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt2)) && !set2.contains(String.valueOf(cCharAt2))) {
                        String strValueOf2 = String.valueOf(cCharAt2);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isBulgarian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            String strValueOf = String.valueOf(str.charAt(i));
            Set set = BULGARIAN_CYRILLIC_LETTERS;
            if (set.contains(strValueOf)) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt))) {
                        String strValueOf2 = String.valueOf(cCharAt);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isChinese(String str) {
        str.getClass();
        if (str.length() != 0) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (19968 <= cCharAt && cCharAt < 40960) {
                    i++;
                }
            }
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char cCharAt2 = str.charAt(i4);
                if ((12352 <= cCharAt2 && cCharAt2 < 12448) || (12448 <= cCharAt2 && cCharAt2 < 12544)) {
                    i3++;
                }
            }
            if (i > 0 && ((double) i3) / ((double) str.length()) < 0.1d) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHindi(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (2304 <= cCharAt && cCharAt < 2432) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJapanese(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (12352 <= cCharAt && cCharAt < 12448) {
                return true;
            }
            if (12448 <= cCharAt && cCharAt < 12544) {
                return true;
            }
            if (19968 <= cCharAt && cCharAt < 40960) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKorean(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (44032 <= cCharAt && cCharAt < 55204) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKyrgyz(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strValueOf = String.valueOf(cCharAt);
            Set set = KYRGYZ_CYRILLIC_LETTERS;
            boolean zContains = set.contains(strValueOf);
            Set set2 = KYRGYZ_SPECIFIC_CYRILLIC_LETTERS;
            if (zContains || set2.contains(String.valueOf(cCharAt))) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt2)) && !set2.contains(String.valueOf(cCharAt2))) {
                        String strValueOf2 = String.valueOf(cCharAt2);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isMacedonian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strValueOf = String.valueOf(cCharAt);
            Set set = MACEDONIAN_CYRILLIC_LETTERS;
            boolean zContains = set.contains(strValueOf);
            Set set2 = MACEDONIAN_SPECIFIC_CYRILLIC_LETTERS;
            if (zContains || set2.contains(String.valueOf(cCharAt))) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt2)) && !set2.contains(String.valueOf(cCharAt2))) {
                        String strValueOf2 = String.valueOf(cCharAt2);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isRussian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            String strValueOf = String.valueOf(str.charAt(i));
            Set set = RUSSIAN_CYRILLIC_LETTERS;
            if (set.contains(strValueOf)) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    String strValueOf2 = String.valueOf(str.charAt(i2));
                    if (!set.contains(strValueOf2)) {
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isSerbian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strValueOf = String.valueOf(cCharAt);
            Set set = SERBIAN_CYRILLIC_LETTERS;
            boolean zContains = set.contains(strValueOf);
            Set set2 = SERBIAN_SPECIFIC_CYRILLIC_LETTERS;
            if (zContains || set2.contains(String.valueOf(cCharAt))) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt2)) && !set2.contains(String.valueOf(cCharAt2))) {
                        String strValueOf2 = String.valueOf(cCharAt2);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isUkrainian(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String strValueOf = String.valueOf(cCharAt);
            Set set = UKRAINIAN_CYRILLIC_LETTERS;
            boolean zContains = set.contains(strValueOf);
            Set set2 = UKRAINIAN_SPECIFIC_CYRILLIC_LETTERS;
            if (zContains || set2.contains(String.valueOf(cCharAt))) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (!set.contains(String.valueOf(cCharAt2)) && !set2.contains(String.valueOf(cCharAt2))) {
                        String strValueOf2 = String.valueOf(cCharAt2);
                        Pattern patternCompile = Pattern.compile("[\\u0400-\\u04FF]");
                        patternCompile.getClass();
                        strValueOf2.getClass();
                        if (patternCompile.matcher(strValueOf2).matches()) {
                            break;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:248:0x054a  */
    /* JADX WARN: Code duplicated, block: B:273:0x0615  */
    /* JADX WARN: Code duplicated, block: B:276:0x0628 A[LOOP:5: B:274:0x0622->B:276:0x0628, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:278:0x064f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0143  */
    /* JADX WARN: Code duplicated, block: B:72:0x0146  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v73 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r25v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r35v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    public static List parseLyrics(String str) {
        int i;
        Throwable th;
        int iIndexOf$default;
        Integer intOrNull;
        String str2;
        String str3;
        ?? r12;
        String str4;
        ?? list;
        ?? wordTimestamps;
        ArrayList arrayList;
        long jLongValue;
        ?? r13;
        String string;
        String str5;
        String string2;
        Object wordTimestamps2;
        WordTimestamp wordTimestamp;
        String string3;
        String string4 = str;
        string4.getClass();
        if (StringsKt.isBlank(string4)) {
            return EmptyList.INSTANCE;
        }
        boolean z = false;
        if (StringsKt.contains$default(string4, '\\') || StringsKt__StringsJVMKt.startsWith(string4, "\"", false)) {
            String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.trim(string4).toString(), "\""), "\"");
            StringBuilder sb = new StringBuilder(strRemoveSuffix.length());
            int i2 = 0;
            while (i2 < strRemoveSuffix.length()) {
                char cCharAt = strRemoveSuffix.charAt(i2);
                if (cCharAt != '\\' || (i = i2 + 1) >= strRemoveSuffix.length()) {
                    sb.append(cCharAt);
                    i2++;
                } else {
                    char cCharAt2 = strRemoveSuffix.charAt(i);
                    if (cCharAt2 == '\\') {
                        sb.append('\\');
                    } else if (cCharAt2 == 'n') {
                        sb.append('\n');
                    } else if (cCharAt2 == 'r') {
                        sb.append('\r');
                    } else if (cCharAt2 != 't') {
                        sb.append(cCharAt);
                        sb.append(cCharAt2);
                    } else {
                        sb.append('\t');
                    }
                    i2 += 2;
                }
            }
            string4 = sb.toString();
        }
        char c = '&';
        int i3 = 2;
        if (StringsKt.contains$default(string4, '&')) {
            StringBuilder sb2 = new StringBuilder(string4.length());
            int i4 = 0;
            while (i4 < string4.length()) {
                char cCharAt3 = string4.charAt(i4);
                if (cCharAt3 == c && (iIndexOf$default = StringsKt.indexOf$default(string4, ';', i4 + 1, 4)) != -1) {
                    if (iIndexOf$default - i4 < 12) {
                        int i5 = iIndexOf$default + 1;
                        String strSubstring = string4.substring(i4, i5);
                        if (strSubstring.equals("&apos;")) {
                            str3 = "'";
                        } else if (strSubstring.equals("&quot;")) {
                            str3 = "\"";
                        } else if (strSubstring.equals("&lt;")) {
                            str3 = "<";
                        } else if (strSubstring.equals("&gt;")) {
                            str3 = ">";
                        } else if (strSubstring.equals("&nbsp;")) {
                            str3 = ServerSentEventKt.SPACE;
                        } else if (strSubstring.equals("&amp;")) {
                            str3 = "&";
                        } else if (StringsKt__StringsJVMKt.startsWith(strSubstring, "&#x", false)) {
                            Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(16, strSubstring.substring(3, strSubstring.length() - 1));
                            if (intOrNull2 != null) {
                                int iIntValue = intOrNull2.intValue();
                                if (Character.isValidCodePoint(iIntValue)) {
                                    char[] chars = Character.toChars(iIntValue);
                                    chars.getClass();
                                    str2 = new String(chars);
                                    str3 = str2;
                                } else {
                                    str3 = "�";
                                }
                            } else {
                                str3 = null;
                            }
                        } else if (!StringsKt__StringsJVMKt.startsWith(strSubstring, "&#", false) || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, strSubstring.substring(2, strSubstring.length() - 1))) == null) {
                            str3 = null;
                        } else {
                            int iIntValue2 = intOrNull.intValue();
                            if (Character.isValidCodePoint(iIntValue2)) {
                                char[] chars2 = Character.toChars(iIntValue2);
                                chars2.getClass();
                                str2 = new String(chars2);
                                str3 = str2;
                            } else {
                                str3 = "�";
                            }
                        }
                        if (str3 != null) {
                            sb2.append(str3);
                            i4 = i5;
                        }
                    }
                    c = '&';
                }
                sb2.append(cCharAt3);
                i4++;
                c = '&';
            }
            th = null;
            string4 = sb2.toString();
        } else {
            th = null;
        }
        List listLines = StringsKt.lines(string4);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listLines) {
            String str6 = (String) obj;
            if (!StringsKt.isBlank(str6) || StringsKt__StringsJVMKt.startsWith(StringsKt.trim(str6).toString(), "[", false) || StringsKt__StringsJVMKt.startsWith(StringsKt.trim(str6).toString(), "<", false)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            if (!StringsKt__StringsJVMKt.startsWith(StringsKt.trim((String) obj2).toString(), "[offset:", false)) {
                arrayList3.add(obj2);
            }
        }
        if (!arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj3 = arrayList3.get(i7);
                i7++;
                String str7 = (String) obj3;
                if (LyricsUtilsKt.RICH_SYNC_LINE_REGEX.matches(StringsKt.trim(str7).toString()) && LyricsUtilsKt.RICH_SYNC_WORD_REGEX.containsMatchIn(str7)) {
                    ArrayList arrayList4 = new ArrayList();
                    int size3 = arrayList3.size();
                    boolean z2 = z;
                    int i8 = z2 ? 1 : 0;
                    ?? r4 = th;
                    ?? r3 = z2;
                    while (i8 < size3) {
                        Object obj4 = arrayList3.get(i8);
                        i8++;
                        int i9 = r3 + 1;
                        if (r3 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw th;
                        }
                        String string5 = StringsKt.trim((String) obj4).toString();
                        MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(LyricsUtilsKt.PAXSENIX_BG_LINE_REGEX, string5);
                        if (matcherMatchResultFind$default != null) {
                            String str8 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1);
                            ArrayList richSyncWords = parseRichSyncWords(str8, r3, arrayList3);
                            if (richSyncWords == null) {
                                String str9 = (String) CollectionsKt.getOrNull(i9, arrayList3);
                                if (str9 == null || (string3 = StringsKt.trim(str9).toString()) == null) {
                                    wordTimestamps2 = richSyncWords;
                                    wordTimestamps2 = richSyncWords;
                                    string3 = "";
                                }
                                wordTimestamps2 = richSyncWords;
                                wordTimestamps2 = (StringsKt__StringsJVMKt.startsWith(string3, "<", z) && StringsKt__StringsJVMKt.endsWith(string3, ">", z)) ? parseWordTimestamps(StringsKt.removeSurrounding(string3, "<", ">")) : th;
                            }
                            wordTimestamps2 = richSyncWords;
                            ?? r25 = wordTimestamps2;
                            Pattern patternCompile = Pattern.compile("<\\d{1,2}:\\d{2}\\.\\d{2,3}>\\s*");
                            patternCompile.getClass();
                            str8.getClass();
                            String strReplaceAll = patternCompile.matcher(str8).replaceAll("");
                            strReplaceAll.getClass();
                            arrayList4.add(new LyricsEntry((r25 == 0 || (wordTimestamp = (WordTimestamp) CollectionsKt.firstOrNull((List) r25)) == null) ? 0L : (long) (wordTimestamp.startTime * 1000.0d), StringsKt.trim(strReplaceAll).toString(), r25, r4 == 0 ? "bg" : r4, true, 24));
                        } else {
                            MatcherMatchResult matcherMatchResultFind$default2 = Regex.find$default(LyricsUtilsKt.PAXSENIX_AGENT_LINE_REGEX, string5);
                            if (matcherMatchResultFind$default2 != null) {
                                Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(1));
                                long jLongValue2 = longOrNull != null ? longOrNull.longValue() : 0L;
                                Long longOrNull2 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i3));
                                long jLongValue3 = longOrNull2 != null ? longOrNull2.longValue() : 0L;
                                Long longOrNull3 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(3));
                                jLongValue = longOrNull3 != null ? longOrNull3.longValue() : 0L;
                                String str10 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(4);
                                String str11 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(5);
                                if (((String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(3)).length() != 3) {
                                    jLongValue *= 10;
                                }
                                long j = (jLongValue3 * 1000) + (jLongValue2 * 60000) + jLongValue;
                                ArrayList richSyncWords2 = parseRichSyncWords(str11, r3, arrayList3);
                                Object wordTimestamps3 = richSyncWords2;
                                if (richSyncWords2 == null) {
                                    String str12 = (String) CollectionsKt.getOrNull(i9, arrayList3);
                                    if (str12 == null || (string2 = StringsKt.trim(str12).toString()) == null) {
                                        string2 = "";
                                    }
                                    wordTimestamps3 = (StringsKt__StringsJVMKt.startsWith(string2, "<", false) && StringsKt__StringsJVMKt.endsWith(string2, ">", false)) ? parseWordTimestamps(StringsKt.removeSurrounding(string2, "<", ">")) : th;
                                }
                                ?? r35 = wordTimestamps3;
                                Pattern patternCompile2 = Pattern.compile("<\\d{1,2}:\\d{2}\\.\\d{2,3}>\\s*");
                                patternCompile2.getClass();
                                str11.getClass();
                                String strReplaceAll2 = patternCompile2.matcher(str11).replaceAll("");
                                strReplaceAll2.getClass();
                                String string6 = StringsKt.trim(strReplaceAll2).toString();
                                r4 = r4;
                                if (str10 != null && !StringsKt.isBlank(str10)) {
                                    r4 = r4;
                                    r4 = str10;
                                }
                                r4 = r4;
                                arrayList4.add(new LyricsEntry(j, string6, r35, str10, false, 24));
                            } else {
                                MatcherMatchResult matcherMatchResultMatchEntire = LyricsUtilsKt.RICH_SYNC_LINE_REGEX.matchEntire(string5);
                                if (matcherMatchResultMatchEntire != null) {
                                    Long longOrNull4 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(1));
                                    long jLongValue4 = longOrNull4 != null ? longOrNull4.longValue() : 0L;
                                    Long longOrNull5 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(i3));
                                    long jLongValue5 = longOrNull5 != null ? longOrNull5.longValue() : 0L;
                                    Long longOrNull6 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(3));
                                    jLongValue = longOrNull6 != null ? longOrNull6.longValue() : 0L;
                                    if (((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(3)).length() != 3) {
                                        jLongValue *= 10;
                                    }
                                    long j2 = (jLongValue5 * 1000) + (jLongValue4 * 60000) + jLongValue;
                                    String string7 = StringsKt.trimStart((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(4)).toString();
                                    Regex regex = LyricsUtilsKt.AGENT_REGEX;
                                    MatcherMatchResult matcherMatchResultFind$default3 = Regex.find$default(regex, string7);
                                    if (matcherMatchResultFind$default3 != null) {
                                        str5 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(1);
                                    } else {
                                        r13 = th;
                                    }
                                    if (matcherMatchResultFind$default3 != null) {
                                        r13 = str5;
                                        string7 = regex.replaceFirst(string7);
                                    }
                                    r13 = str5;
                                    Regex regex2 = LyricsUtilsKt.BACKGROUND_REGEX;
                                    boolean zContainsMatchIn = regex2.containsMatchIn(string7);
                                    if (zContainsMatchIn) {
                                        string7 = regex2.replaceFirst(string7);
                                    }
                                    ArrayList richSyncWords3 = parseRichSyncWords(string7, r3, arrayList3);
                                    Object wordTimestamps4 = richSyncWords3;
                                    if (richSyncWords3 == null) {
                                        String str13 = (String) CollectionsKt.getOrNull(i9, arrayList3);
                                        if (str13 == null || (string = StringsKt.trim(str13).toString()) == null) {
                                            string = "";
                                        }
                                        wordTimestamps4 = (StringsKt__StringsJVMKt.startsWith(string, "<", false) && StringsKt__StringsJVMKt.endsWith(string, ">", false)) ? parseWordTimestamps(StringsKt.removeSurrounding(string, "<", ">")) : th;
                                    }
                                    ?? r26 = wordTimestamps4;
                                    Pattern patternCompile3 = Pattern.compile("<\\d{1,2}:\\d{2}\\.\\d{2,3}>\\s*");
                                    patternCompile3.getClass();
                                    String strReplaceAll3 = patternCompile3.matcher(string7).replaceAll("");
                                    strReplaceAll3.getClass();
                                    String string8 = StringsKt.trim(strReplaceAll3).toString();
                                    r4 = r4;
                                    r4 = r4;
                                    if (!zContainsMatchIn && r13 != 0 && !StringsKt.isBlank(r13)) {
                                        r4 = r4;
                                        r4 = r13;
                                    }
                                    r4 = r4;
                                    arrayList4.add(new LyricsEntry(j2, string8, r26, zContainsMatchIn ? r4 == 0 ? "bg" : r4 : r13, zContainsMatchIn, 24));
                                }
                            }
                        }
                        r3 = i9;
                        z = false;
                        i3 = 2;
                        r4 = r4;
                    }
                    return CollectionsKt.sorted(arrayList4);
                }
                z = false;
                i3 = 2;
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (int i10 = 0; i10 < arrayList3.size(); i10++) {
            String str14 = (String) arrayList3.get(i10);
            if (!StringsKt__StringsJVMKt.startsWith(StringsKt.trim(str14).toString(), "<", false) || !StringsKt__StringsJVMKt.endsWith(StringsKt.trim(str14).toString(), ">", false)) {
                MatcherMatchResult matcherMatchResultMatchEntire2 = LyricsUtilsKt.LINE_REGEX.matchEntire(StringsKt.trim(str14).toString());
                if (matcherMatchResultMatchEntire2 == null) {
                    list = th;
                } else {
                    String str15 = (String) ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(1);
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    ref$ObjectRef.element = ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(3);
                    GeneratorSequence generatorSequenceFindAll$default = Regex.findAll$default(LyricsUtilsKt.TIME_REGEX, str15);
                    Regex regex3 = LyricsUtilsKt.AGENT_REGEX;
                    MatcherMatchResult matcherMatchResultFind$default4 = Regex.find$default(regex3, (CharSequence) ref$ObjectRef.element);
                    if (matcherMatchResultFind$default4 != null) {
                        str4 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default4.getGroupValues()).get(1);
                    } else {
                        r12 = th;
                    }
                    if (matcherMatchResultFind$default4 != null) {
                        r12 = str4;
                        ref$ObjectRef.element = regex3.replaceFirst((CharSequence) ref$ObjectRef.element);
                    }
                    r12 = str4;
                    Regex regex4 = LyricsUtilsKt.BACKGROUND_REGEX;
                    boolean zContainsMatchIn2 = regex4.containsMatchIn((CharSequence) ref$ObjectRef.element);
                    if (zContainsMatchIn2) {
                        ref$ObjectRef.element = regex4.replaceFirst((CharSequence) ref$ObjectRef.element);
                    }
                    list = SequencesKt.toList(new TransformingSequence(generatorSequenceFindAll$default, new LyricsUtils$$ExternalSyntheticLambda0(ref$ObjectRef, (String) r12, zContainsMatchIn2)));
                }
                if (list != 0) {
                    int i11 = i10 + 1;
                    if (i11 < arrayList3.size()) {
                        String str16 = (String) arrayList3.get(i11);
                        if (StringsKt__StringsJVMKt.startsWith(StringsKt.trim(str16).toString(), "<", false) && StringsKt__StringsJVMKt.endsWith(StringsKt.trim(str16).toString(), ">", false)) {
                            wordTimestamps = parseWordTimestamps(StringsKt.removeSurrounding(StringsKt.trim(str16).toString(), "<", ">"));
                        }
                        if (wordTimestamps != 0) {
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            for (LyricsEntry lyricsEntry : list) {
                                arrayList.add(new LyricsEntry(lyricsEntry.time, lyricsEntry.text, wordTimestamps, lyricsEntry.agent, lyricsEntry.isBackground, 24));
                            }
                            arrayList5.addAll(arrayList);
                        } else {
                            arrayList5.addAll(list);
                        }
                    }
                    wordTimestamps = th;
                    if (wordTimestamps != 0) {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        while (r4.hasNext()) {
                            arrayList.add(new LyricsEntry(lyricsEntry.time, lyricsEntry.text, wordTimestamps, lyricsEntry.agent, lyricsEntry.isBackground, 24));
                        }
                        arrayList5.addAll(arrayList);
                    } else {
                        arrayList5.addAll(list);
                    }
                }
            }
        }
        return CollectionsKt.sorted(arrayList5);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x034d  */
    /* JADX WARN: Code duplicated, block: B:170:0x048a  */
    /* JADX WARN: Code duplicated, block: B:171:0x049d  */
    public static ArrayList parseRichSyncWords(String str, int i, ArrayList arrayList) {
        double d;
        double d2;
        Double dValueOf;
        List listListOf;
        double d3;
        Long longOrNull;
        Double dValueOf2;
        double dDoubleValue;
        boolean zContainsMatchIn;
        String str2;
        double d4;
        double dDoubleValue2;
        boolean z;
        String strSubstring;
        boolean z2;
        List list = SequencesKt.toList(Regex.findAll$default(LyricsUtilsKt.RICH_SYNC_WORD_REGEX, str));
        if (list.isEmpty()) {
            return null;
        }
        int i2 = 1;
        String string = StringsKt.trim(str.substring(((MatcherMatchResult) ((MatchResult) CollectionsKt.last(list))).getRange().last + 1)).toString();
        Pattern patternCompile = Pattern.compile("<(\\d{1,2}):(\\d{2})\\.(\\d{2,3})>");
        patternCompile.getClass();
        string.getClass();
        Matcher matcher = patternCompile.matcher(string);
        matcher.getClass();
        MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, string);
        Pattern patternCompile2 = Pattern.compile("\\[(\\d{1,2}):(\\d{2})\\.(\\d{2,3})\\]");
        patternCompile2.getClass();
        Matcher matcher2 = patternCompile2.matcher(string);
        matcher2.getClass();
        MatcherMatchResult matcherMatchResultFindNext2 = RegexKt.findNext(matcher2, 0, string);
        if (matcherMatchResultFindNext == null) {
            matcherMatchResultFindNext = matcherMatchResultFindNext2;
        }
        int i3 = 3;
        int i4 = 2;
        if (matcherMatchResultFindNext == null || !StringsKt.isBlank(StringsKt.removeSuffix(string.substring(matcherMatchResultFindNext.getRange().last + 1), "]"))) {
            d = 100.0d;
            d2 = 1000.0d;
            dValueOf = null;
        } else {
            Long longOrNull2 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(1));
            long jLongValue = longOrNull2 != null ? longOrNull2.longValue() : 0L;
            d = 100.0d;
            Long longOrNull3 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(2));
            long jLongValue2 = longOrNull3 != null ? longOrNull3.longValue() : 0L;
            d2 = 1000.0d;
            Long longOrNull4 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(3));
            double dLongValue = longOrNull4 != null ? longOrNull4.longValue() : 0L;
            dValueOf = Double.valueOf((jLongValue * 60.0d) + jLongValue2 + (((String) ((ReversedListReadOnly) matcherMatchResultFindNext.getGroupValues()).get(3)).length() == 3 ? dLongValue / 1000.0d : dLongValue / 100.0d));
        }
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            MatcherMatchResult matcherMatchResult = (MatcherMatchResult) ((MatchResult) obj);
            Long longOrNull5 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(i2));
            long jLongValue3 = longOrNull5 != null ? longOrNull5.longValue() : 0L;
            int i7 = i2;
            Long longOrNull6 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(i4));
            long jLongValue4 = longOrNull6 != null ? longOrNull6.longValue() : 0L;
            Long longOrNull7 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(i3));
            long jLongValue5 = longOrNull7 != null ? longOrNull7.longValue() : 0L;
            Double d5 = dValueOf;
            double d6 = (jLongValue3 * 60.0d) + jLongValue4 + (((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(i3)).length() == i3 ? jLongValue5 / d2 : jLongValue5 / d);
            String str3 = (String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(4);
            boolean zEndsWith = StringsKt__StringsJVMKt.endsWith(str3, ServerSentEventKt.SPACE, false);
            String string2 = StringsKt.trim(str3).toString();
            Pattern patternCompile3 = Pattern.compile("\\s+");
            patternCompile3.getClass();
            string2.getClass();
            StringsKt.requireNonNegativeLimit(0);
            Matcher matcher3 = patternCompile3.matcher(string2);
            if (matcher3.find()) {
                ArrayList arrayList3 = new ArrayList(10);
                int iEnd = 0;
                while (true) {
                    arrayList3.add(string2.subSequence(iEnd, matcher3.start()).toString());
                    iEnd = matcher3.end();
                    if (!matcher3.find()) {
                        break;
                    }
                    arrayList = arrayList;
                }
                arrayList3.add(string2.subSequence(iEnd, string2.length()).toString());
                listListOf = arrayList3;
            } else {
                listListOf = CollectionsKt__IterablesKt.listOf(string2.toString());
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : listListOf) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList4.add(obj2);
                }
            }
            if (i5 < list.size() - 1) {
                MatcherMatchResult matcherMatchResult2 = (MatcherMatchResult) ((MatchResult) list.get(i6));
                d3 = 0.5d;
                Long longOrNull8 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult2.getGroupValues()).get(i7));
                long jLongValue6 = longOrNull8 != null ? longOrNull8.longValue() : 0L;
                Long longOrNull9 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult2.getGroupValues()).get(2));
                long jLongValue7 = longOrNull9 != null ? longOrNull9.longValue() : 0L;
                Long longOrNull10 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResult2.getGroupValues()).get(3));
                long jLongValue8 = longOrNull10 != null ? longOrNull10.longValue() : 0L;
                dDoubleValue = (jLongValue6 * 60.0d) + jLongValue7 + (((String) ((ReversedListReadOnly) matcherMatchResult2.getGroupValues()).get(3)).length() == 3 ? jLongValue8 / d2 : jLongValue8 / d);
                arrayList2 = arrayList2;
                dValueOf2 = null;
            } else {
                d6 = d6;
                d3 = 0.5d;
                int i8 = i + 1;
                while (i8 < arrayList.size()) {
                    String string3 = StringsKt.trim((String) arrayList.get(i8)).toString();
                    if (LyricsUtilsKt.PAXSENIX_BG_LINE_REGEX.matches(string3)) {
                        zContainsMatchIn = true;
                    } else {
                        MatcherMatchResult matcherMatchResultMatchEntire = LyricsUtilsKt.RICH_SYNC_LINE_REGEX.matchEntire(string3);
                        zContainsMatchIn = (matcherMatchResultMatchEntire == null || (str2 = (String) ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(4)) == null) ? false : LyricsUtilsKt.BACKGROUND_REGEX.containsMatchIn(StringsKt.trim(str2).toString());
                    }
                    if (!zContainsMatchIn) {
                        break;
                    }
                    int i9 = i8 + 1;
                    if (i9 < arrayList.size()) {
                        String string4 = StringsKt.trim((String) arrayList.get(i9)).toString();
                        if (StringsKt__StringsJVMKt.startsWith(string4, "<", false) && StringsKt__StringsJVMKt.endsWith(string4, ">", false)) {
                            i8 += 2;
                        }
                    }
                    i8 = i9;
                }
                if (i8 >= arrayList.size()) {
                    arrayList2 = arrayList2;
                    dValueOf2 = null;
                } else {
                    MatcherMatchResult matcherMatchResultMatchEntire2 = LyricsUtilsKt.RICH_SYNC_LINE_REGEX.matchEntire(StringsKt.trim((String) arrayList.get(i8)).toString());
                    if (matcherMatchResultMatchEntire2 == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(1))) == null) {
                        arrayList2 = arrayList2;
                        dValueOf2 = null;
                    } else {
                        long jLongValue9 = longOrNull.longValue();
                        Long longOrNull11 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(2));
                        if (longOrNull11 != null) {
                            long jLongValue10 = longOrNull11.longValue();
                            Long longOrNull12 = StringsKt__StringsJVMKt.toLongOrNull((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(3));
                            long jLongValue11 = longOrNull12 != null ? longOrNull12.longValue() : 0L;
                            dValueOf2 = Double.valueOf((jLongValue9 * 60.0d) + jLongValue10 + (((String) ((ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues()).get(3)).length() == 3 ? jLongValue11 / d2 : jLongValue11 / d));
                        } else {
                            arrayList2 = arrayList2;
                            dValueOf2 = null;
                        }
                    }
                }
                dDoubleValue = d5 != null ? d5.doubleValue() : dValueOf2 != null ? dValueOf2.doubleValue() : d6 + 0.5d;
            }
            int size = arrayList4.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj3 = arrayList4.get(i11);
                i11++;
                int i12 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                String str4 = (String) obj3;
                boolean z3 = i10 == arrayList4.size() + (-1);
                ArrayList arrayList5 = arrayList2;
                double d7 = dDoubleValue - d6;
                boolean z4 = i5 == list.size() + (-1) && z3;
                ArrayList arrayList6 = arrayList4;
                double size2 = ((((double) i10) * d7) / ((double) arrayList6.size())) + d6;
                if (z3) {
                    d4 = size2;
                    if (!z4) {
                        dDoubleValue2 = dDoubleValue;
                    } else if (d5 != null) {
                        dDoubleValue2 = d5.doubleValue();
                    } else {
                        dDoubleValue2 = dValueOf2 != null ? dValueOf2.doubleValue() : d6 + d3;
                    }
                } else {
                    d4 = size2;
                    dDoubleValue2 = ((d7 * ((double) i12)) / ((double) arrayList6.size())) + d6;
                }
                if (z3) {
                    if (z4) {
                        if (matcherMatchResultFindNext != 0) {
                            int i13 = matcherMatchResultFindNext.getRange().first;
                            z = false;
                            strSubstring = string.substring(0, i13);
                        } else {
                            z = false;
                            strSubstring = string;
                        }
                        z2 = !StringsKt.isBlank(strSubstring) ? true : z;
                    } else {
                        z2 = zEndsWith;
                    }
                    if (StringsKt.isBlank(str4)) {
                        arrayList2 = arrayList5;
                    } else {
                        arrayList2 = arrayList5;
                        arrayList2.add(new WordTimestamp(str4, d4, dDoubleValue2, z2));
                    }
                    i10 = i12;
                    arrayList4 = arrayList6;
                } else {
                    z2 = true;
                }
                if (StringsKt.isBlank(str4)) {
                    arrayList2 = arrayList5;
                    arrayList2.add(new WordTimestamp(str4, d4, dDoubleValue2, z2));
                } else {
                    arrayList2 = arrayList5;
                }
                i10 = i12;
                arrayList4 = arrayList6;
            }
            arrayList2 = arrayList2;
            i5 = i6;
            dValueOf = d5;
            i2 = 1;
            matcherMatchResultFindNext = matcherMatchResultFindNext;
            list = list;
            i4 = 2;
            i3 = 3;
        }
        ArrayList arrayList7 = arrayList2;
        if (arrayList7.isEmpty()) {
            return null;
        }
        return arrayList7;
    }

    public static ArrayList parseWordTimestamps(String str) {
        WordTimestamp wordTimestamp;
        if (!StringsKt.isBlank(str)) {
            try {
                List<String> listSplit$default = StringsKt.split$default(str, new String[]{"|"}, 0, 6);
                ArrayList arrayList = new ArrayList();
                for (String str2 : listSplit$default) {
                    List listSplit$default2 = StringsKt.split$default(str2, new String[]{ServerSentEventKt.COLON}, 0, 6);
                    if (listSplit$default2.size() >= 3) {
                        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.dropLast(2, listSplit$default2), ServerSentEventKt.COLON, null, null, null, 62);
                        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull((String) listSplit$default2.get(listSplit$default2.size() - 2));
                        double dDoubleValue = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
                        Double doubleOrNull2 = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull((String) listSplit$default2.get(listSplit$default2.size() - 1));
                        wordTimestamp = new WordTimestamp(strJoinToString$default, dDoubleValue, doubleOrNull2 != null ? doubleOrNull2.doubleValue() : 0.0d, !str2.equals(CollectionsKt.last(StringsKt.split$default(str, new String[]{"|"}, 0, 6))));
                    } else {
                        wordTimestamp = null;
                    }
                    if (wordTimestamp != null) {
                        arrayList.add(wordTimestamp);
                    }
                }
                return arrayList;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String romanizeBelarusianInternal(String str) {
        List listListOf;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList2.get(i);
            i++;
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    String strValueOf = String.valueOf(str2.charAt(i2));
                    if ((Intrinsics.areEqual(strValueOf, "е") || Intrinsics.areEqual(strValueOf, "Е")) && (i2 == 0 || CharsKt.isWhitespace(str2.charAt(i2 - 1)))) {
                        sb.append(Intrinsics.areEqual(strValueOf, "е") ? "ye" : "Ye");
                    } else {
                        String str3 = (String) BELARUSIAN_ROMAJI_MAP.get(strValueOf);
                        if (str3 != null || (str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                            strValueOf = str3;
                        }
                        sb.append(strValueOf);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String romanizeBulgarianInternal(String str) {
        List listListOf;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                for (int i4 = 0; i4 < str2.length(); i4++) {
                    String strValueOf = String.valueOf(str2.charAt(i4));
                    String str3 = (String) BULGARIAN_ROMAJI_MAP.get(strValueOf);
                    if (str3 != null || (str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                        strValueOf = str3;
                    }
                    sb.append(strValueOf);
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    public static Object romanizeCyrillic(String str, String str2, SuspendLambda suspendLambda) {
        return AwaitKt.withContext(Dispatchers.Default, new DownloadUtil.AnonymousClass2(str, str2, null, (byte) 14), suspendLambda);
    }

    public static String romanizeKyrgyzInternal(String str) {
        List listListOf;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                for (int i4 = 0; i4 < str2.length(); i4++) {
                    String strValueOf = String.valueOf(str2.charAt(i4));
                    String str3 = (String) KYRGYZ_ROMAJI_MAP.get(strValueOf);
                    if (str3 != null || (str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                        strValueOf = str3;
                    }
                    sb.append(strValueOf);
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    public static String romanizeMacedonianInternal(String str) {
        List listListOf;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                for (int i4 = 0; i4 < str2.length(); i4++) {
                    String strValueOf = String.valueOf(str2.charAt(i4));
                    String str3 = (String) MACEDONIAN_ROMAJI_MAP.get(strValueOf);
                    if (str3 != null || (str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                        strValueOf = str3;
                    }
                    sb.append(strValueOf);
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    public static String romanizeRussianInternal(String str) {
        List listListOf;
        int i;
        boolean z;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                int i5 = 0;
                while (i5 < str2.length()) {
                    if (i5 + 2 < str2.length()) {
                        i = i5 + 3;
                        String strSubstring = str2.substring(i5, i);
                        Map map = RUSSIAN_ROMAJI_MAP;
                        if (map.containsKey(strSubstring)) {
                            sb.append((String) map.get(strSubstring));
                            z = true;
                        } else {
                            i = i5;
                            z = false;
                        }
                    } else {
                        i = i5;
                        z = false;
                    }
                    if (z) {
                        i5 = i;
                    } else {
                        String strValueOf = String.valueOf(str2.charAt(i));
                        if ((Intrinsics.areEqual(strValueOf, "е") || Intrinsics.areEqual(strValueOf, "Е")) && (i == 0 || CharsKt.isWhitespace(str2.charAt(i - 1)))) {
                            sb.append(Intrinsics.areEqual(strValueOf, "е") ? "ye" : "Ye");
                        } else {
                            String str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf);
                            if (str3 != null) {
                                strValueOf = str3;
                            }
                            sb.append(strValueOf);
                        }
                        i5 = i + 1;
                    }
                }
            }
            i2 = i4;
        }
        return sb.toString();
    }

    public static String romanizeSerbianInternal(String str) {
        List listListOf;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str2.getClass();
            if (patternCompile2.matcher(str2).matches() || StringsKt.isBlank(str2)) {
                sb.append(str2);
            } else {
                for (int i4 = 0; i4 < str2.length(); i4++) {
                    String strValueOf = String.valueOf(str2.charAt(i4));
                    String str3 = (String) SERBIAN_ROMAJI_MAP.get(strValueOf);
                    if (str3 != null || (str3 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                        strValueOf = str3;
                    }
                    sb.append(strValueOf);
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x012b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0135  */
    /* JADX WARN: Code duplicated, block: B:63:0x0140 A[PHI: r8
      0x0140: PHI (r8v3 java.lang.String) = (r8v2 java.lang.String), (r8v6 java.lang.String) binds: [B:59:0x0133, B:61:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    public static String romanizeUkrainianInternal(String str) {
        List listListOf;
        String str2;
        StringBuilder sb = new StringBuilder(str.length());
        Pattern patternCompile = Pattern.compile("((?<=\\s|[.,!?;])|(?=\\s|[.,!?;]))");
        patternCompile.getClass();
        StringsKt.requireNonNegativeLimit(0);
        Matcher matcher = patternCompile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(iEnd, str.length()).toString());
            listListOf = arrayList;
        } else {
            listListOf = CollectionsKt__IterablesKt.listOf(str.toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str3 = (String) obj2;
            Pattern patternCompile2 = Pattern.compile("[.,!?;]");
            patternCompile2.getClass();
            str3.getClass();
            if (patternCompile2.matcher(str3).matches() || StringsKt.isBlank(str3)) {
                sb.append(str3);
            } else {
                for (int i4 = 0; i4 < str3.length(); i4++) {
                    String strValueOf = String.valueOf(str3.charAt(i4));
                    if (i4 > 0) {
                        int i5 = i4 - 1;
                        if (!Character.isLetter(str3.charAt(i5)) || StringsKt.contains$default("АаЕеЄєИиІіЇїОоУуЮюЯяЫыЭэ", str3.charAt(i5))) {
                            str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                            if (str2 == null || (str2 = (String) GENERAL_CYRILLIC_ROMAJI_MAP.get(strValueOf)) != null) {
                                strValueOf = str2;
                            }
                            sb.append(strValueOf);
                        } else {
                            int iHashCode = strValueOf.hashCode();
                            if (iHashCode != 1070) {
                                if (iHashCode != 1071) {
                                    if (iHashCode != 1102) {
                                        if (iHashCode == 1103 && strValueOf.equals("я")) {
                                            sb.append("ia");
                                        } else {
                                            str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                                            if (str2 == null) {
                                                strValueOf = str2;
                                            } else {
                                                strValueOf = str2;
                                            }
                                            sb.append(strValueOf);
                                        }
                                    } else if (strValueOf.equals("ю")) {
                                        sb.append("iu");
                                    } else {
                                        str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                                        if (str2 == null) {
                                            strValueOf = str2;
                                        } else {
                                            strValueOf = str2;
                                        }
                                        sb.append(strValueOf);
                                    }
                                } else if (strValueOf.equals("Я")) {
                                    sb.append("Ia");
                                } else {
                                    str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                                    if (str2 == null) {
                                        strValueOf = str2;
                                    } else {
                                        strValueOf = str2;
                                    }
                                    sb.append(strValueOf);
                                }
                            } else if (strValueOf.equals("Ю")) {
                                sb.append("Iu");
                            } else {
                                str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                                if (str2 == null) {
                                    strValueOf = str2;
                                } else {
                                    strValueOf = str2;
                                }
                                sb.append(strValueOf);
                            }
                        }
                    } else {
                        str2 = (String) UKRAINIAN_ROMAJI_MAP.get(strValueOf);
                        if (str2 == null) {
                            strValueOf = str2;
                        } else {
                            strValueOf = str2;
                        }
                        sb.append(strValueOf);
                    }
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object romanizeHindi(String str, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, continuation, (byte) 0);
            anonymousClass1.label = 1;
            objWithContext = AwaitKt.withContext(defaultScheduler, anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        objWithContext.getClass();
        return objWithContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object romanizeKorean(String str, ContinuationImpl continuationImpl) {
        C01601 c01601;
        if (continuationImpl instanceof C01601) {
            c01601 = (C01601) continuationImpl;
            int i = c01601.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01601.label = i - Integer.MIN_VALUE;
            } else {
                c01601 = new C01601(continuationImpl);
            }
        } else {
            c01601 = new C01601(continuationImpl);
        }
        Object objWithContext = c01601.result;
        int i2 = c01601.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, continuation, (byte) 4);
            c01601.label = 1;
            objWithContext = AwaitKt.withContext(defaultScheduler, anonymousClass2, c01601);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        objWithContext.getClass();
        return objWithContext;
    }
}
