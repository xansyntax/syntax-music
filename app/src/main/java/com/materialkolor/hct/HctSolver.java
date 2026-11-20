package com.materialkolor.hct;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.materialkolor.utils.MathUtils;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HctSolver {
    public static final double[][] SCALED_DISCOUNT_FROM_LINRGB = {new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
    public static final double[][] LINRGB_FROM_SCALED_DISCOUNT = {new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
    public static final double[] Y_FROM_LINRGB = {0.2126d, 0.7152d, 0.0722d};
    public static final double[] CRITICAL_PLANES = {0.015176349177441876d, 0.045529047532325624d, 0.07588174588720938d, 0.10623444424209313d, 0.13658714259697685d, 0.16693984095186062d, 0.19729253930674434d, 0.2276452376616281d, 0.2579979360165119d, 0.28835063437139563d, 0.3188300904430532d, 0.350925934958123d, 0.3848314933096426d, 0.42057480301049466d, 0.458183274052838d, 0.4976837250274023d, 0.5391024159806381d, 0.5824650784040898d, 0.6277969426914107d, 0.6751227633498623d, 0.7244668422128921d, 0.775853049866786d, 0.829304845476233d, 0.8848452951698498d, 0.942497089126609d, 1.0022825574869039d, 1.0642236851973577d, 1.1283421258858297d, 1.1946592148522128d, 1.2631959812511864d, 1.3339731595349034d, 1.407011200216447d, 1.4823302800086415d, 1.5599503113873272d, 1.6398909516233677d, 1.7221716113234105d, 1.8068114625156377d, 1.8938294463134073d, 1.9832442801866852d, 2.075074464868551d, 2.1693382909216234d, 2.2660538449872063d, 2.36523901573795d, 2.4669114995532007d, 2.5710888059345764d, 2.6777882626779785d, 2.7870270208169257d, 2.898822059350997d, 3.0131901897720907d, 3.1301480604002863d, 3.2497121605402226d, 3.3718988244681087d, 3.4967242352587946d, 3.624204428461639d, 3.754355295633311d, 3.887192587735158d, 4.022731918402185d, 4.160988767090289d, 4.301978482107941d, 4.445716283538092d, 4.592217266055746d, 4.741496401646282d, 4.893568542229298d, 5.048448422192488d, 5.20615066083972d, 5.3666897647573375d, 5.5300801301023865d, 5.696336044816294d, 5.865471690767354d, 6.037501145825082d, 6.212438385869475d, 6.390297286737924d, 6.571091626112461d, 6.7548350853498045d, 6.941541251256611d, 7.131223617812143d, 7.323895587840543d, 7.5195704746346665d, 7.7182615035334345d, 7.919981813454504d, 8.124744458384042d, 8.332562408825165d, 8.543448553206703d, 8.757415699253682d, 8.974476575321063d, 9.194643831691977d, 9.417930041841839d, 9.644347703669503d, 9.873909240696694d, 10.106627003236781d, 10.342513269534024d, 10.58158024687427d, 10.8238400726681d, 11.069304815507364d, 11.317986476196008d, 11.569896988756009d, 11.825048221409341d, 12.083451977536606d, 12.345119996613247d, 12.610063955123938d, 12.878295467455942d, 13.149826086772048d, 13.42466730586372d, 13.702830557985108d, 13.984327217668513d, 14.269168601521828d, 14.55736596900856d, 14.848930523210871d, 15.143873411576273d, 15.44220572664832d, 15.743938506781891d, 16.04908273684337d, 16.35764934889634d, 16.66964922287304d, 16.985093187232053d, 17.30399201960269d, 17.62635644741625d, 17.95219714852476d, 18.281524751807332d, 18.614349837764564d, 18.95068293910138d, 19.290534541298456d, 19.633915083172692d, 19.98083495742689d, 20.331304511189067d, 20.685334046541502d, 21.042933821039977d, 21.404114048223256d, 21.76888489811322d, 22.137256497705877d, 22.50923893145328d, 22.884842241736916d, 23.264076429332462d, 23.6469514538663d, 24.033477234264016d, 24.42366364919083d, 24.817520537484558d, 25.21505769858089d, 25.61628489293138d, 26.021211842414342d, 26.429848230738664d, 26.842203703840827d, 27.258287870275353d, 27.678110301598522d, 28.10168053274597d, 28.529008062403893d, 28.96010235337422d, 29.39497283293396d, 29.83362889318845d, 30.276079891419332d, 30.722335150426627d, 31.172403958865512d, 31.62629557157785d, 32.08401920991837d, 32.54558406207592d, 33.010999283389665d, 33.4802739966603d, 33.953417292456834d, 34.430438229418264d, 34.911345834551085d, 35.39614910352207d, 35.88485700094671d, 36.37747846067349d, 36.87402238606382d, 37.37449765026789d, 37.87891309649659d, 38.38727753828926d, 38.89959975977785d, 39.41588851594697d, 39.93615253289054d, 40.460400508064545d, 40.98864111053629d, 41.520882981230194d, 42.05713473317016d, 42.597404951718396d, 43.141702194811224d, 43.6900349931913d, 44.24241185063697d, 44.798841244188324d, 45.35933162437017d, 45.92389141541209d, 46.49252901546552d, 47.065252796817916d, 47.64207110610409d, 48.22299226451468d, 48.808024568002054d, 49.3971762874833d, 49.9904556690408d, 50.587870934119984d, 51.189430279724725d, 51.79514187861014d, 52.40501387947288d, 53.0190544071392d, 53.637271562750364d, 54.259673423945976d, 54.88626804504493d, 55.517063457223934d, 56.15206766869424d, 56.79128866487574d, 57.43473440856916d, 58.08241284012621d, 58.734331877617365d, 59.39049941699807d, 60.05092333227251d, 60.715611475655585d, 61.38457167773311d, 62.057811747619894d, 62.7353394731159d, 63.417162620860914d, 64.10328893648692d, 64.79372614476921d, 65.48848194977529d, 66.18756403501224d, 66.89098006357258d, 67.59873767827808d, 68.31084450182222d, 69.02730813691093d, 69.74813616640164d, 70.47333615344107d, 71.20291564160104d, 71.93688215501312d, 72.67524319850172d, 73.41800625771542d, 74.16517879925733d, 74.9167682708136d, 75.67278210128072d, 76.43322770089146d, 77.1981124613393d, 77.96744375590167d, 78.74122893956174d, 79.51947534912904d, 80.30219030335869d, 81.08938110306934d, 81.88105503125999d, 82.67721935322541d, 83.4778813166706d, 84.28304815182372d, 85.09272707154808d, 85.90692527145302d, 86.72564993000343d, 87.54890820862819d, 88.3767072518277d, 89.2090541872801d, 90.04595612594655d, 90.88742016217518d, 91.73345337380438d, 92.58406282226491d, 93.43925555268066d, 94.29903859396902d, 95.16341895893969d, 96.03240364439274d, 96.9059996312159d, 97.78421388448044d, 98.6670533535366d, 99.55452497210776d};

    public static boolean areInCyclicOrder(double d, double d2, double d3) {
        return ((d2 - d) + 25.132741228718345d) % 6.283185307179586d < ((d3 - d) + 25.132741228718345d) % 6.283185307179586d;
    }

    public static double chromaticAdaptation(double d) {
        int i;
        double dPow = Math.pow(Math.abs(d), 0.42d);
        if (d < 0.0d) {
            i = -1;
        } else {
            i = d == 0.0d ? 0 : 1;
        }
        return ((((double) i) * 400.0d) * dPow) / (dPow + 27.13d);
    }

    public static Cam16 fromInt(int i) {
        int i2;
        int i3;
        int i4;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        viewingConditions.getClass();
        double dLinearized = MathUtils.linearized((16711680 & i) >> 16);
        double dLinearized2 = MathUtils.linearized((65280 & i) >> 8);
        double dLinearized3 = MathUtils.linearized(i & 255);
        double d = (0.18051042d * dLinearized3) + (0.35762064d * dLinearized2) + (0.41233895d * dLinearized);
        double d2 = (0.0722d * dLinearized3) + (0.7152d * dLinearized2) + (0.2126d * dLinearized);
        double d3 = (dLinearized3 * 0.95034478d) + (dLinearized2 * 0.11916382d) + (dLinearized * 0.01932141d);
        double d4 = viewingConditions.flRoot;
        double d5 = viewingConditions.c;
        double d6 = viewingConditions.aw;
        double[][] dArr = Cam16.XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d7 = (dArr2[2] * d3) + (dArr2[1] * d2) + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d8 = (dArr3[2] * d3) + (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        double d9 = (d3 * dArr4[2]) + (d2 * dArr4[1]) + (d * dArr4[0]);
        double[] dArr5 = viewingConditions.rgbD;
        double d10 = dArr5[0] * d7;
        double d11 = dArr5[1] * d8;
        double d12 = dArr5[2] * d9;
        double d13 = viewingConditions.fl;
        double dPow = Math.pow((Math.abs(d10) * d13) / 100.0d, 0.42d);
        double dPow2 = Math.pow((Math.abs(d11) * d13) / 100.0d, 0.42d);
        double dPow3 = Math.pow((Math.abs(d12) * d13) / 100.0d, 0.42d);
        if (d10 < 0.0d) {
            i2 = -1;
        } else {
            i2 = d10 == 0.0d ? 0 : 1;
        }
        double d14 = ((((double) i2) * 400.0d) * dPow) / (dPow + 27.13d);
        if (d11 < r6) {
            i3 = -1;
        } else {
            i3 = d11 == r6 ? 0 : 1;
        }
        double d15 = ((((double) i3) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        if (d12 < r6) {
            i4 = -1;
        } else {
            i4 = d12 == r6 ? 0 : 1;
        }
        double d16 = ((((double) i4) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d17 = ((((-12.0d) * d15) + (d14 * 11.0d)) + d16) / 11.0d;
        double dM = IntIntPair$$ExternalSyntheticOutline0.m(d16, 2.0d, d14 + d15, 9.0d);
        double d18 = d15 * 20.0d;
        double d19 = ((21.0d * d16) + ((d14 * 20.0d) + d18)) / 20.0d;
        double d20 = (((d14 * 40.0d) + d18) + d16) / 20.0d;
        double dAtan2 = (Math.atan2(dM, d17) * 57.29577951308232d) % 360.0d;
        if (dAtan2 < 0) {
            dAtan2 += 360.0d;
        }
        double d21 = dAtan2;
        double d22 = d21 * 0.017453292519943295d;
        double dPow4 = Math.pow((d20 * viewingConditions.nbb) / d6, viewingConditions.z * d5) * 100.0d;
        double d23 = dPow4 / 100.0d;
        Math.sqrt(d23);
        double d24 = d6 + 4.0d;
        double dPow5 = Math.pow((Math.hypot(d17, dM) * (((((Math.cos(((d21 < 20.14d ? d21 + 360.0d : d21) * 0.017453292519943295d) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.nc) * viewingConditions.ncb)) / (d19 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.n), 0.73d);
        double dSqrt = Math.sqrt(d23) * dPow5;
        Math.sqrt((dPow5 * d5) / d24);
        double dLog1p = Math.log1p(dSqrt * d4 * 0.0228d) * 43.859649122807014d;
        return new Cam16(d21, dSqrt, dPow4, (1.7000000000000002d * dPow4) / ((0.007d * dPow4) + 1.0d), Math.cos(d22) * dLog1p, Math.sin(d22) * dLog1p);
    }

    public static double hueOf(double[] dArr) {
        dArr.getClass();
        double[] dArrMatrixMultiply = MathUtils.matrixMultiply(dArr, SCALED_DISCOUNT_FROM_LINRGB);
        double dChromaticAdaptation = chromaticAdaptation(dArrMatrixMultiply[0]);
        double dChromaticAdaptation2 = chromaticAdaptation(dArrMatrixMultiply[1]);
        double dChromaticAdaptation3 = chromaticAdaptation(dArrMatrixMultiply[2]);
        return Math.atan2(IntIntPair$$ExternalSyntheticOutline0.m(dChromaticAdaptation3, 2.0d, dChromaticAdaptation + dChromaticAdaptation2, 9.0d), ((((-12.0d) * dChromaticAdaptation2) + (dChromaticAdaptation * 11.0d)) + dChromaticAdaptation3) / 11.0d);
    }

    public static double inverseChromaticAdaptation(double d) {
        int i;
        double dAbs = Math.abs(d);
        double dMax = Math.max(0.0d, (27.13d * dAbs) / (400.0d - dAbs));
        if (d < 0.0d) {
            i = -1;
        } else {
            i = d == 0.0d ? 0 : 1;
        }
        return Math.pow(dMax, 2.380952380952381d) * ((double) i);
    }

    public static boolean isBounded(double d) {
        return 0.0d <= d && d <= 100.0d;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0302  */
    /* JADX WARN: Code duplicated, block: B:106:0x030e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0312  */
    /* JADX WARN: Code duplicated, block: B:110:0x0329  */
    /* JADX WARN: Code duplicated, block: B:118:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:119:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:57:0x0209  */
    /* JADX WARN: Code duplicated, block: B:59:0x0217  */
    /* JADX WARN: Code duplicated, block: B:60:0x021a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0220  */
    /* JADX WARN: Code duplicated, block: B:65:0x0224  */
    /* JADX WARN: Code duplicated, block: B:67:0x0229  */
    /* JADX WARN: Code duplicated, block: B:69:0x0239  */
    /* JADX WARN: Code duplicated, block: B:70:0x0245  */
    /* JADX WARN: Code duplicated, block: B:71:0x0251  */
    /* JADX WARN: Code duplicated, block: B:73:0x0256  */
    /* JADX WARN: Code duplicated, block: B:75:0x026c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0275  */
    /* JADX WARN: Code duplicated, block: B:77:0x027e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0290  */
    /* JADX WARN: Code duplicated, block: B:80:0x0299  */
    /* JADX WARN: Code duplicated, block: B:84:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:86:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:87:0x02b3 A[PHI: r0 r1 r6 r10 r12
      0x02b3: PHI (r0v31 double[]) = (r0v20 double[]), (r0v20 double[]), (r0v35 double[]) binds: [B:82:0x02a5, B:90:0x02c3, B:86:0x02ae] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r1v10 double[]) = (r1v1 double[]), (r1v1 double[]), (r1v14 double[]) binds: [B:82:0x02a5, B:90:0x02c3, B:86:0x02ae] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r6v13 boolean) = (r6v8 boolean), (r6v8 boolean), (r6v15 boolean) binds: [B:82:0x02a5, B:90:0x02c3, B:86:0x02ae] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r10v15 double) = (r10v6 double), (r10v6 double), (r10v20 double) binds: [B:82:0x02a5, B:90:0x02c3, B:86:0x02ae] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r12v14 double) = (r12v5 double), (r12v5 double), (r12v18 double) binds: [B:82:0x02a5, B:90:0x02c3, B:86:0x02ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:96:0x02db  */
    /* JADX WARN: Code duplicated, block: B:98:0x02e1  */
    public static int solveToInt(double d, double d2, double d3) {
        double d4;
        int i;
        int iArgbFromRgb;
        double[] dArr;
        double d5;
        double[] dArr2;
        double d6;
        double d7;
        boolean z;
        int i2;
        int i3;
        double d8;
        double[] dArr3;
        double dHueOf;
        double[] dArr4;
        int i4;
        double d9;
        double d10;
        int iCeil;
        double dFloor;
        int i5;
        int i6;
        int iFloor;
        double[] dArr5;
        double dHueOf2;
        boolean zAreInCyclicOrder;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double dM;
        double[] dArr6;
        double dM2;
        double d19;
        double d20;
        double dHueOf3;
        double d21;
        double d22;
        double d23;
        double d24;
        double dM3;
        double d25 = d % 360.0d;
        if (d25 < 0.0d) {
            d25 += 360.0d;
        }
        if (d2 < 1.0E-4d || d3 < 1.0E-4d || d3 > 99.9999d) {
            int iDelinearized = MathUtils.delinearized(MathUtils.yFromLstar(d3));
            return MathUtils.argbFromRgb(iDelinearized, iDelinearized, iDelinearized);
        }
        double d26 = (d25 / 180.0d) * 3.141592653589793d;
        double d27 = (d3 + 16.0d) / 116.0d;
        double d28 = d27 * d27 * d27;
        if (d28 <= 0.008856451679035631d) {
            d28 = ((116.0d * d27) - 16.0d) / 903.2962962962963d;
        }
        double d29 = d28 * 100.0d;
        double dSqrt = Math.sqrt(d29) * 11.0d;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        double d30 = 100.0d;
        double d31 = 1.0d;
        double dPow = 1.0d / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.n), 0.73d);
        double dCos = (Math.cos(d26 + 2.0d) + 3.8d) * 0.25d * 3846.153846153846d * viewingConditions.nc * viewingConditions.ncb;
        double dSin = Math.sin(d26);
        double dCos2 = Math.cos(d26);
        int i7 = 0;
        while (true) {
            double d32 = d31;
            double[] dArr7 = Y_FROM_LINRGB;
            double d33 = d30;
            if (i7 < 5) {
                i = 1;
                double d34 = dSqrt / d33;
                d4 = d29;
                double dPow2 = Math.pow(((d2 == 0.0d || dSqrt == 0.0d) ? 0.0d : d2 / Math.sqrt(d34)) * dPow, 1.1111111111111112d);
                double d35 = dPow;
                ViewingConditions viewingConditions2 = viewingConditions;
                double dPow3 = (Math.pow(d34, (d32 / viewingConditions.c) / viewingConditions.z) * viewingConditions.aw) / viewingConditions2.nbb;
                double d36 = (((0.305d + dPow3) * 23.0d) * dPow2) / (((dPow2 * 108.0d) * dSin) + (((11.0d * dPow2) * dCos2) + (23.0d * dCos)));
                double d37 = d36 * dCos2;
                double d38 = d36 * dSin;
                double d39 = dPow3 * 460.0d;
                double[] dArrMatrixMultiply = MathUtils.matrixMultiply(new double[]{inverseChromaticAdaptation(((288.0d * d38) + ((451.0d * d37) + d39)) / 1403.0d), inverseChromaticAdaptation(IntIntPair$$ExternalSyntheticOutline0.m(d38, 261.0d, d39 - (891.0d * d37), 1403.0d)), inverseChromaticAdaptation(IntIntPair$$ExternalSyntheticOutline0.m(d38, 6300.0d, d39 - (d37 * 220.0d), 1403.0d))}, LINRGB_FROM_SCALED_DISCOUNT);
                double d40 = dArrMatrixMultiply[0];
                if (d40 >= 0.0d) {
                    double d41 = dArrMatrixMultiply[1];
                    if (d41 >= 0.0d) {
                        double d42 = dArrMatrixMultiply[2];
                        if (d42 >= 0.0d) {
                            double d43 = (dArr7[2] * d42) + (dArr7[1] * d41) + (dArr7[0] * d40);
                            if (d43 > 0.0d) {
                                if (i7 != 4) {
                                    double d44 = d43 - d4;
                                    if (Math.abs(d44) >= 0.002d) {
                                        dSqrt -= (d44 * dSqrt) / (d43 * 2.0d);
                                        i7++;
                                        d31 = d32;
                                        viewingConditions = viewingConditions2;
                                        d30 = d33;
                                        d29 = d4;
                                        dPow = d35;
                                    }
                                }
                                double d45 = dArrMatrixMultiply[0];
                                if (d45 <= 100.01d && dArrMatrixMultiply[1] <= 100.01d && dArrMatrixMultiply[2] <= 100.01d) {
                                    iArgbFromRgb = MathUtils.argbFromRgb(MathUtils.delinearized(d45), MathUtils.delinearized(dArrMatrixMultiply[1]), MathUtils.delinearized(dArrMatrixMultiply[2]));
                                }
                                if (iArgbFromRgb != 0) {
                                    return iArgbFromRgb;
                                }
                                dArr = new double[3];
                                d5 = -1.0d;
                                dArr[0] = -1.0d;
                                dArr[i] = -1.0d;
                                dArr[2] = -1.0d;
                                dArr2 = dArr;
                                d6 = 0.0d;
                                d7 = 0.0d;
                                z = false;
                                i2 = 0;
                                i3 = i;
                                while (i2 < 12) {
                                    d12 = dArr7[0];
                                    d13 = dArr7[i];
                                    d14 = dArr7[2];
                                    d15 = d5;
                                    if (i2 % 4 <= i) {
                                        d16 = 0.0d;
                                    } else {
                                        d16 = d33;
                                    }
                                    if (i2 % 2 == 0) {
                                        d17 = 0.0d;
                                    } else {
                                        d17 = d33;
                                    }
                                    if (i2 < 4) {
                                        dM3 = IntIntPair$$ExternalSyntheticOutline0.m(d17, d14, d4 - (d13 * d16), d12);
                                        if (isBounded(dM3)) {
                                            dArr6 = new double[]{dM3, d16, d17};
                                        } else {
                                            dArr6 = new double[]{d15, d15, d15};
                                        }
                                    } else if (i2 < 8) {
                                        dM2 = IntIntPair$$ExternalSyntheticOutline0.m(d16, d14, d4 - (d17 * d12), d13);
                                        d19 = d16;
                                        if (isBounded(dM2)) {
                                            dArr6 = new double[]{d17, dM2, d19};
                                        } else {
                                            dArr6 = new double[]{d15, d15, d15};
                                        }
                                    } else {
                                        d18 = d16;
                                        dM = IntIntPair$$ExternalSyntheticOutline0.m(d17, d13, d4 - (d18 * d12), d14);
                                        if (isBounded(dM)) {
                                            dArr6 = new double[]{d18, d17, dM};
                                        } else {
                                            dArr6 = new double[]{d15, d15, d15};
                                        }
                                    }
                                    if (dArr6[0] < 0.0d) {
                                        d20 = d26;
                                    } else {
                                        dHueOf3 = hueOf(dArr6);
                                        if (!z) {
                                            d6 = dHueOf3;
                                            d7 = d6;
                                            dArr = dArr6;
                                            dArr2 = dArr;
                                            z = true;
                                        } else if (i3 == 0 || areInCyclicOrder(d6, dHueOf3, d7)) {
                                            d22 = d26;
                                            d23 = d6;
                                            d6 = d23;
                                            d20 = d22;
                                            d24 = d21;
                                            if (areInCyclicOrder(d23, d22, d21)) {
                                                dArr2 = dArr6;
                                                d7 = d24;
                                            } else {
                                                dArr = dArr6;
                                                d6 = d24;
                                            }
                                            i3 = 0;
                                        }
                                        d20 = d26;
                                    }
                                    i2++;
                                    d26 = d20;
                                    d5 = d15;
                                    i = 1;
                                }
                                d8 = d26;
                                double[][] dArr8 = {dArr, dArr2};
                                dArr3 = dArr8[0];
                                dHueOf = hueOf(dArr3);
                                dArr4 = dArr8[1];
                                i4 = 0;
                                while (i4 < 3) {
                                    d9 = dArr3[i4];
                                    d10 = dArr4[i4];
                                    if (d9 != d10) {
                                        if (d9 < d10) {
                                            iCeil = (int) Math.floor(trueDelinearized(d9) - 0.5d);
                                            dFloor = Math.ceil(trueDelinearized(dArr4[i4]) - 0.5d);
                                        } else {
                                            iCeil = (int) Math.ceil(trueDelinearized(d9) - 0.5d);
                                            dFloor = Math.floor(trueDelinearized(dArr4[i4]) - 0.5d);
                                        }
                                        i5 = (int) dFloor;
                                        i6 = 0;
                                        while (i6 < 8 && Math.abs(i5 - iCeil) > 1) {
                                            iFloor = (int) Math.floor(((double) (iCeil + i5)) / 2.0d);
                                            double d46 = CRITICAL_PLANES[iFloor];
                                            double d47 = dArr3[i4];
                                            double d48 = (d46 - d47) / (dArr4[i4] - d47);
                                            double d49 = dArr3[0];
                                            double d50 = ((dArr4[0] - d49) * d48) + d49;
                                            double d51 = dArr3[1];
                                            double d52 = ((dArr4[1] - d51) * d48) + d51;
                                            double d53 = dArr3[2];
                                            dArr5 = new double[]{d50, d52, ((dArr4[2] - d53) * d48) + d53};
                                            dHueOf2 = hueOf(dArr5);
                                            double d54 = d8;
                                            double d55 = dHueOf;
                                            zAreInCyclicOrder = areInCyclicOrder(d55, d54, dHueOf2);
                                            d11 = d55;
                                            if (zAreInCyclicOrder) {
                                                i5 = iFloor;
                                                dArr4 = dArr5;
                                            } else {
                                                iCeil = iFloor;
                                                dArr3 = dArr5;
                                                d11 = dHueOf2;
                                            }
                                            i6++;
                                            d8 = d54;
                                            dHueOf = d11;
                                        }
                                    }
                                    i4++;
                                    d8 = d8;
                                    dHueOf = dHueOf;
                                }
                                double[] dArr9 = {(dArr3[0] + dArr4[0]) / 2.0d, (dArr3[1] + dArr4[1]) / 2.0d, (dArr3[2] + dArr4[2]) / 2.0d};
                                return MathUtils.argbFromRgb(MathUtils.delinearized(dArr9[0]), MathUtils.delinearized(dArr9[1]), MathUtils.delinearized(dArr9[2]));
                            }
                        }
                    }
                }
            } else {
                d4 = d29;
                i = 1;
            }
            iArgbFromRgb = 0;
            if (iArgbFromRgb != 0) {
                return iArgbFromRgb;
            }
            dArr = new double[3];
            d5 = -1.0d;
            dArr[0] = -1.0d;
            dArr[i] = -1.0d;
            dArr[2] = -1.0d;
            dArr2 = dArr;
            d6 = 0.0d;
            d7 = 0.0d;
            z = false;
            i2 = 0;
            i3 = i;
            while (i2 < 12) {
                d12 = dArr7[0];
                d13 = dArr7[i];
                d14 = dArr7[2];
                d15 = d5;
                if (i2 % 4 <= i) {
                    d16 = 0.0d;
                } else {
                    d16 = d33;
                }
                if (i2 % 2 == 0) {
                    d17 = 0.0d;
                } else {
                    d17 = d33;
                }
                if (i2 < 4) {
                    dM3 = IntIntPair$$ExternalSyntheticOutline0.m(d17, d14, d4 - (d13 * d16), d12);
                    if (isBounded(dM3)) {
                        dArr6 = new double[]{dM3, d16, d17};
                    } else {
                        dArr6 = new double[]{d15, d15, d15};
                    }
                } else if (i2 < 8) {
                    dM2 = IntIntPair$$ExternalSyntheticOutline0.m(d16, d14, d4 - (d17 * d12), d13);
                    d19 = d16;
                    if (isBounded(dM2)) {
                        dArr6 = new double[]{d17, dM2, d19};
                    } else {
                        dArr6 = new double[]{d15, d15, d15};
                    }
                } else {
                    d18 = d16;
                    dM = IntIntPair$$ExternalSyntheticOutline0.m(d17, d13, d4 - (d18 * d12), d14);
                    if (isBounded(dM)) {
                        dArr6 = new double[]{d18, d17, dM};
                    } else {
                        dArr6 = new double[]{d15, d15, d15};
                    }
                }
                if (dArr6[0] < 0.0d) {
                    d20 = d26;
                } else {
                    dHueOf3 = hueOf(dArr6);
                    if (!z) {
                        d6 = dHueOf3;
                        d7 = d6;
                        dArr = dArr6;
                        dArr2 = dArr;
                        z = true;
                    } else {
                        d21 = i3 == 0 ? dHueOf3 : dHueOf3;
                        d22 = d26;
                        d23 = d6;
                        d6 = d23;
                        d20 = d22;
                        d24 = d21;
                        if (areInCyclicOrder(d23, d22, d21)) {
                            dArr2 = dArr6;
                            d7 = d24;
                        } else {
                            dArr = dArr6;
                            d6 = d24;
                        }
                        i3 = 0;
                    }
                    d20 = d26;
                }
                i2++;
                d26 = d20;
                d5 = d15;
                i = 1;
            }
            d8 = d26;
            double[][] dArr10 = {dArr, dArr2};
            dArr3 = dArr10[0];
            dHueOf = hueOf(dArr3);
            dArr4 = dArr10[1];
            i4 = 0;
            while (i4 < 3) {
                d9 = dArr3[i4];
                d10 = dArr4[i4];
                if (d9 != d10) {
                    if (d9 < d10) {
                        iCeil = (int) Math.floor(trueDelinearized(d9) - 0.5d);
                        dFloor = Math.ceil(trueDelinearized(dArr4[i4]) - 0.5d);
                    } else {
                        iCeil = (int) Math.ceil(trueDelinearized(d9) - 0.5d);
                        dFloor = Math.floor(trueDelinearized(dArr4[i4]) - 0.5d);
                    }
                    i5 = (int) dFloor;
                    i6 = 0;
                    while (i6 < 8) {
                        iFloor = (int) Math.floor(((double) (iCeil + i5)) / 2.0d);
                        double d410 = CRITICAL_PLANES[iFloor];
                        double d411 = dArr3[i4];
                        double d412 = (d410 - d411) / (dArr4[i4] - d411);
                        double d413 = dArr3[0];
                        double d56 = ((dArr4[0] - d413) * d412) + d413;
                        double d57 = dArr3[1];
                        double d58 = ((dArr4[1] - d57) * d412) + d57;
                        double d59 = dArr3[2];
                        dArr5 = new double[]{d56, d58, ((dArr4[2] - d59) * d412) + d59};
                        dHueOf2 = hueOf(dArr5);
                        double d510 = d8;
                        double d511 = dHueOf;
                        zAreInCyclicOrder = areInCyclicOrder(d511, d510, dHueOf2);
                        d11 = d511;
                        if (zAreInCyclicOrder) {
                            i5 = iFloor;
                            dArr4 = dArr5;
                        } else {
                            iCeil = iFloor;
                            dArr3 = dArr5;
                            d11 = dHueOf2;
                        }
                        i6++;
                        d8 = d510;
                        dHueOf = d11;
                    }
                }
                i4++;
                d8 = d8;
                dHueOf = dHueOf;
            }
            double[] dArr11 = {(dArr3[0] + dArr4[0]) / 2.0d, (dArr3[1] + dArr4[1]) / 2.0d, (dArr3[2] + dArr4[2]) / 2.0d};
            return MathUtils.argbFromRgb(MathUtils.delinearized(dArr11[0]), MathUtils.delinearized(dArr11[1]), MathUtils.delinearized(dArr11[2]));
        }
    }

    public static double trueDelinearized(double d) {
        double d2 = d / 100.0d;
        return (d2 <= 0.0031308d ? d2 * 12.92d : (Math.pow(d2, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d;
    }
}
