package WaveFunctionCollapse.Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectWeights {

    public static final double[] weightNull = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    private final ArrayList<int[]>options;

    String cellBlankCharacter = "0";

    String cellGrass1Character = "1";
    String cellGrass2Character = "2";
    String cellGrass3Character = "3";
    String cellGrass4Character = "4";
    String cellGrass5Character = "5";
    String cellGrass6Character = "6";

    String cellBush1Character = "7";
    String cellBush2Character = "8";
    String cellBush3Character = "9";
    String cellBush4Character = "10";
    String cellBush5Character = "11";
    String cellBush6Character = "12";

    String cellCamp1Character = "13";
    String cellCamp2Character = "14";

    String cellStone1Character = "15";
    String cellStone2Character = "16";
    String cellStone3Character = "17";
    String cellStone4Character = "18";
    String cellStone5Character = "19";
    String cellStone6Character = "20";
    String cellStone7Character = "21";
    String cellStone8Character = "22";
    String cellStone9Character = "23";
    String cellStone10Character = "24";
    String cellStone11Character = "25";
    String cellStone12Character = "26";
    String cellStone13Character = "27";
    String cellStone14Character = "28";
    String cellStone15Character = "29";
    String cellStone16Character = "30";

    String cellFlower1Character = "31";
    String cellFlower2Character = "32";
    String cellFlower3Character = "33";
    String cellFlower4Character = "34";
    String cellFlower5Character = "35";
    String cellFlower6Character = "36";
    String cellFlower7Character = "37";
    String cellFlower8Character = "38";
    String cellFlower9Character = "39";
    String cellFlower10Character = "40";
    String cellFlower11Character = "41";
    String cellFlower12Character = "42";

    String cellBox1Character = "43";
    String cellBox2Character = "44";
    String cellBox3Character = "45";
    String cellBox4Character = "46";
    String cellLamp1Character = "47";
    String cellLamp2Character = "48";
    String cellLamp3Character = "49";
    String cellLog1Character = "50";
    String cellLog2Character = "51";
    String cellLog3Character = "52";
    String cellLog4Character = "53";
    String cellTree1Character = "54";
    String cellTree2Character = "55";

    String cellCampfireUnlitCharacter = "56";
    String cellCampfireLitCharacter = "57";

    String cellNullCharacter = "n";

    // Weights in percents Order from option index 0 - 12

    double[] weightBlank = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightGrass1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightGrass2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightGrass3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightGrass4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightGrass5 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightGrass6 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightBush1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBush2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBush3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBush4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBush5 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBush6 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightCamp1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightCamp2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightStone1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone5 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone6 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone7 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone8 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone9 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone10 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone11 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone12 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone13 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone14 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone15 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightStone16 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightFlower1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower5 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower6 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower7 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower8 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower9 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower10 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower11 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightFlower12 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightBox1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBox2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBox3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightBox4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLamp1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLamp2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLamp3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLog1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLog2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLog3 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightLog4 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightTree1 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightTree2 = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};

    double[] weightCampfireUnlit = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    double[] weightCampfireLit = {0.3,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02,0.02};
    public ObjectWeights(ArrayList<int[]>options){
        this.options = options;
    }

    public static HashMap<String, HashMap<int[], Boolean>> compatibilityMapFinder = new HashMap<>();

    public static HashMap<int[], Boolean> blankTileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> grass1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass5TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass6TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> bush1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> bush2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> bush3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> bush4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> bush5TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> bush6TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> camp1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> camp2TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> stone1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone5TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone6TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone7TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone8TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone9TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone10TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone11TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone12TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone13TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone14TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone15TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> stone16TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> flower1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower5TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower6TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower7TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower8TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower9TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower10TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower11TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> flower12TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> box1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> box2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> box3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> box4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> lamp1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> lamp2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> lamp3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> log1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> log2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> log3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> log4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> tree1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> tree2TileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> campfireUnlitTileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> campfireLitTileCompatibilityMap = new HashMap<>();

    public static HashMap<String, double[]> weightMap = new HashMap<>();

    public void initialize(){

        grass1TileCompatibilityMap.put(options.get(0), true);
        grass2TileCompatibilityMap.put(options.get(0), true);
        grass3TileCompatibilityMap.put(options.get(0), true);
        grass4TileCompatibilityMap.put(options.get(0), true);
        grass5TileCompatibilityMap.put(options.get(0), true);
        grass6TileCompatibilityMap.put(options.get(0), true);

        bush1TileCompatibilityMap.put(options.get(0), true);
        bush2TileCompatibilityMap.put(options.get(0), true);
        bush3TileCompatibilityMap.put(options.get(0), true);
        bush4TileCompatibilityMap.put(options.get(0), true);
        bush5TileCompatibilityMap.put(options.get(0), true);
        bush6TileCompatibilityMap.put(options.get(0), true);

        camp1TileCompatibilityMap.put(options.get(0), true);
        camp2TileCompatibilityMap.put(options.get(0), true);

        stone1TileCompatibilityMap.put(options.get(0), true);
        stone2TileCompatibilityMap.put(options.get(0), true);
        stone3TileCompatibilityMap.put(options.get(0), true);
        stone4TileCompatibilityMap.put(options.get(0), true);
        stone5TileCompatibilityMap.put(options.get(0), true);
        stone6TileCompatibilityMap.put(options.get(0), true);
        stone7TileCompatibilityMap.put(options.get(0), true);
        stone8TileCompatibilityMap.put(options.get(0), true);
        stone9TileCompatibilityMap.put(options.get(0), true);
        stone10TileCompatibilityMap.put(options.get(0), true);
        stone11TileCompatibilityMap.put(options.get(0), true);
        stone12TileCompatibilityMap.put(options.get(0), true);
        stone13TileCompatibilityMap.put(options.get(0), true);
        stone14TileCompatibilityMap.put(options.get(0), true);
        stone15TileCompatibilityMap.put(options.get(0), true);
        stone16TileCompatibilityMap.put(options.get(0), true);

        flower1TileCompatibilityMap.put(options.get(0), true);
        flower2TileCompatibilityMap.put(options.get(0), true);
        flower3TileCompatibilityMap.put(options.get(0), true);
        flower4TileCompatibilityMap.put(options.get(0), true);
        flower5TileCompatibilityMap.put(options.get(0), true);
        flower6TileCompatibilityMap.put(options.get(0), true);
        flower7TileCompatibilityMap.put(options.get(0), true);
        flower8TileCompatibilityMap.put(options.get(0), true);
        flower9TileCompatibilityMap.put(options.get(0), true);
        flower10TileCompatibilityMap.put(options.get(0), true);
        flower11TileCompatibilityMap.put(options.get(0), true);
        flower12TileCompatibilityMap.put(options.get(0), true);

        box1TileCompatibilityMap.put(options.get(0), true);
        box2TileCompatibilityMap.put(options.get(0), true);
        box3TileCompatibilityMap.put(options.get(0), true);
        box4TileCompatibilityMap.put(options.get(0), true);
        lamp1TileCompatibilityMap.put(options.get(0), true);
        lamp2TileCompatibilityMap.put(options.get(0), true);
        lamp3TileCompatibilityMap.put(options.get(0), true);
        log1TileCompatibilityMap.put(options.get(0), true);
        log2TileCompatibilityMap.put(options.get(0), true);
        log3TileCompatibilityMap.put(options.get(0), true);
        log4TileCompatibilityMap.put(options.get(0), true);
        tree1TileCompatibilityMap.put(options.get(0), true);
        tree2TileCompatibilityMap.put(options.get(0), true);

        campfireUnlitTileCompatibilityMap.put(options.get(0), true);
        campfireLitTileCompatibilityMap.put(options.get(0), true);


        for (int i = 0; i < options.size(); i++) {
            blankTileCompatibilityMap.put(options.get(i), true);

            if (i != 0) {
                grass1TileCompatibilityMap.put(options.get(i), false);
                grass2TileCompatibilityMap.put(options.get(i), false);
                grass3TileCompatibilityMap.put(options.get(i), false);
                grass4TileCompatibilityMap.put(options.get(i), false);
                grass5TileCompatibilityMap.put(options.get(i), false);
                grass6TileCompatibilityMap.put(options.get(i), false);

                bush1TileCompatibilityMap.put(options.get(i), false);
                bush2TileCompatibilityMap.put(options.get(i), false);
                bush3TileCompatibilityMap.put(options.get(i), false);
                bush4TileCompatibilityMap.put(options.get(i), false);
                bush5TileCompatibilityMap.put(options.get(i), false);
                bush6TileCompatibilityMap.put(options.get(i), false);

                camp1TileCompatibilityMap.put(options.get(i), false);
                camp2TileCompatibilityMap.put(options.get(i), false);

                stone1TileCompatibilityMap.put(options.get(i), false);
                stone2TileCompatibilityMap.put(options.get(i), false);
                stone3TileCompatibilityMap.put(options.get(i), false);
                stone4TileCompatibilityMap.put(options.get(i), false);
                stone5TileCompatibilityMap.put(options.get(i), false);
                stone6TileCompatibilityMap.put(options.get(i), false);
                stone7TileCompatibilityMap.put(options.get(i), false);
                stone8TileCompatibilityMap.put(options.get(i), false);
                stone9TileCompatibilityMap.put(options.get(i), false);
                stone10TileCompatibilityMap.put(options.get(i), false);
                stone11TileCompatibilityMap.put(options.get(i), false);
                stone12TileCompatibilityMap.put(options.get(i), false);
                stone13TileCompatibilityMap.put(options.get(i), false);
                stone14TileCompatibilityMap.put(options.get(i), false);
                stone15TileCompatibilityMap.put(options.get(i), false);
                stone16TileCompatibilityMap.put(options.get(i), false);

                flower1TileCompatibilityMap.put(options.get(i), false);
                flower2TileCompatibilityMap.put(options.get(i), false);
                flower3TileCompatibilityMap.put(options.get(i), false);
                flower4TileCompatibilityMap.put(options.get(i), false);
                flower5TileCompatibilityMap.put(options.get(i), false);
                flower6TileCompatibilityMap.put(options.get(i), false);
                flower7TileCompatibilityMap.put(options.get(i), false);
                flower8TileCompatibilityMap.put(options.get(i), false);
                flower9TileCompatibilityMap.put(options.get(i), false);
                flower10TileCompatibilityMap.put(options.get(i), false);
                flower11TileCompatibilityMap.put(options.get(i), false);
                flower12TileCompatibilityMap.put(options.get(i), false);

                box1TileCompatibilityMap.put(options.get(i), false);
                box2TileCompatibilityMap.put(options.get(i), false);
                box3TileCompatibilityMap.put(options.get(i), false);
                box4TileCompatibilityMap.put(options.get(i), false);
                lamp1TileCompatibilityMap.put(options.get(i), false);
                lamp2TileCompatibilityMap.put(options.get(i), false);
                lamp3TileCompatibilityMap.put(options.get(i), false);
                log1TileCompatibilityMap.put(options.get(i), false);
                log2TileCompatibilityMap.put(options.get(i), false);
                log3TileCompatibilityMap.put(options.get(i), false);
                log4TileCompatibilityMap.put(options.get(i), false);
                tree1TileCompatibilityMap.put(options.get(i), false);
                tree2TileCompatibilityMap.put(options.get(i), false);

                campfireUnlitTileCompatibilityMap.put(options.get(i), false);
                campfireLitTileCompatibilityMap.put(options.get(i), false);
            }
        }

        compatibilityMapFinder.put(cellBlankCharacter, blankTileCompatibilityMap);

        compatibilityMapFinder.put(cellGrass1Character, grass1TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass2Character, grass2TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass3Character, grass3TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass4Character, grass4TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass5Character, grass5TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass6Character, grass6TileCompatibilityMap);

        compatibilityMapFinder.put(cellBush1Character, bush1TileCompatibilityMap);
        compatibilityMapFinder.put(cellBush2Character, bush2TileCompatibilityMap);
        compatibilityMapFinder.put(cellBush3Character, bush3TileCompatibilityMap);
        compatibilityMapFinder.put(cellBush4Character, bush4TileCompatibilityMap);
        compatibilityMapFinder.put(cellBush5Character, bush5TileCompatibilityMap);
        compatibilityMapFinder.put(cellBush6Character, bush6TileCompatibilityMap);

        compatibilityMapFinder.put(cellCamp1Character, camp1TileCompatibilityMap);
        compatibilityMapFinder.put(cellCamp2Character, camp2TileCompatibilityMap);

        compatibilityMapFinder.put(cellStone1Character, stone1TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone2Character, stone2TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone3Character, stone3TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone4Character, stone4TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone5Character, stone5TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone6Character, stone6TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone7Character, stone7TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone8Character, stone8TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone9Character, stone9TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone10Character, stone10TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone11Character, stone11TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone12Character, stone12TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone13Character, stone13TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone14Character, stone14TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone15Character, stone15TileCompatibilityMap);
        compatibilityMapFinder.put(cellStone16Character, stone16TileCompatibilityMap);

        compatibilityMapFinder.put(cellFlower1Character, flower1TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower2Character, flower2TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower3Character, flower3TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower4Character, flower4TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower5Character, flower5TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower6Character, flower6TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower7Character, flower7TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower8Character, flower8TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower9Character, flower9TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower10Character, flower10TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower11Character, flower11TileCompatibilityMap);
        compatibilityMapFinder.put(cellFlower12Character, flower12TileCompatibilityMap);

        compatibilityMapFinder.put(cellBox1Character, box1TileCompatibilityMap);
        compatibilityMapFinder.put(cellBox2Character, box2TileCompatibilityMap);
        compatibilityMapFinder.put(cellBox3Character, box3TileCompatibilityMap);
        compatibilityMapFinder.put(cellBox4Character, box4TileCompatibilityMap);
        compatibilityMapFinder.put(cellLamp1Character, lamp1TileCompatibilityMap);
        compatibilityMapFinder.put(cellLamp2Character, lamp2TileCompatibilityMap);
        compatibilityMapFinder.put(cellLamp3Character, lamp3TileCompatibilityMap);
        compatibilityMapFinder.put(cellLog1Character, log1TileCompatibilityMap);
        compatibilityMapFinder.put(cellLog2Character, log2TileCompatibilityMap);
        compatibilityMapFinder.put(cellLog3Character, log3TileCompatibilityMap);
        compatibilityMapFinder.put(cellLog4Character, log4TileCompatibilityMap);
        compatibilityMapFinder.put(cellTree1Character, tree1TileCompatibilityMap);
        compatibilityMapFinder.put(cellTree2Character, tree2TileCompatibilityMap);

        compatibilityMapFinder.put(cellCampfireUnlitCharacter, campfireUnlitTileCompatibilityMap);
        compatibilityMapFinder.put(cellCampfireLitCharacter, campfireLitTileCompatibilityMap);

        weightMap.put(cellBlankCharacter, weightBlank);

        weightMap.put(cellGrass1Character, weightGrass1);
        weightMap.put(cellGrass2Character, weightGrass2);
        weightMap.put(cellGrass3Character, weightGrass3);
        weightMap.put(cellGrass4Character, weightGrass4);
        weightMap.put(cellGrass5Character, weightGrass5);
        weightMap.put(cellGrass6Character, weightGrass6);

        weightMap.put(cellBush1Character, weightBush1);
        weightMap.put(cellBush2Character, weightBush2);
        weightMap.put(cellBush3Character, weightBush3);
        weightMap.put(cellBush4Character, weightBush4);
        weightMap.put(cellBush5Character, weightBush5);
        weightMap.put(cellBush6Character, weightBush6);

        weightMap.put(cellCamp1Character, weightCamp1);
        weightMap.put(cellCamp2Character, weightCamp2);

        weightMap.put(cellStone1Character, weightStone1);
        weightMap.put(cellStone2Character, weightStone2);
        weightMap.put(cellStone3Character, weightStone3);
        weightMap.put(cellStone4Character, weightStone4);
        weightMap.put(cellStone5Character, weightStone5);
        weightMap.put(cellStone6Character, weightStone6);
        weightMap.put(cellStone7Character, weightStone7);
        weightMap.put(cellStone8Character, weightStone8);
        weightMap.put(cellStone9Character, weightStone9);
        weightMap.put(cellStone10Character, weightStone10);
        weightMap.put(cellStone11Character, weightStone11);
        weightMap.put(cellStone12Character, weightStone12);
        weightMap.put(cellStone13Character, weightStone13);
        weightMap.put(cellStone14Character, weightStone14);
        weightMap.put(cellStone15Character, weightStone15);
        weightMap.put(cellStone16Character, weightStone16);

        weightMap.put(cellFlower1Character, weightFlower1);
        weightMap.put(cellFlower2Character, weightFlower2);
        weightMap.put(cellFlower3Character, weightFlower3);
        weightMap.put(cellFlower4Character, weightFlower4);
        weightMap.put(cellFlower5Character, weightFlower5);
        weightMap.put(cellFlower6Character, weightFlower6);
        weightMap.put(cellFlower7Character, weightFlower7);
        weightMap.put(cellFlower8Character, weightFlower8);
        weightMap.put(cellFlower9Character, weightFlower9);
        weightMap.put(cellFlower10Character, weightFlower10);
        weightMap.put(cellFlower11Character, weightFlower11);
        weightMap.put(cellFlower12Character, weightFlower12);

        weightMap.put(cellBox1Character, weightBox1);
        weightMap.put(cellBox2Character, weightBox2);
        weightMap.put(cellBox3Character, weightBox3);
        weightMap.put(cellBox4Character, weightBox4);
        weightMap.put(cellLamp1Character, weightLamp1);
        weightMap.put(cellLamp2Character, weightLamp2);
        weightMap.put(cellLamp3Character, weightLamp3);
        weightMap.put(cellLog1Character, weightLog1);
        weightMap.put(cellLog2Character, weightLog2);
        weightMap.put(cellLog3Character, weightLog3);
        weightMap.put(cellLog4Character, weightLog4);
        weightMap.put(cellTree1Character, weightTree1);
        weightMap.put(cellTree2Character, weightTree2);

        weightMap.put(cellCampfireUnlitCharacter, weightCampfireUnlit);
        weightMap.put(cellCampfireLitCharacter, weightCampfireLit);

        weightMap.put(cellNullCharacter, weightNull);
    }
}
