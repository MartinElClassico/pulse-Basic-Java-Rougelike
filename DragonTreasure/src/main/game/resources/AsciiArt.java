package main.game.resources;

/**
 * Class to hold and handle ASCII art provided by course teacher.
 */
public class AsciiArt {

    private static final String TREASURE_ASCII = (
        "                  _.--.\n"+
        "              _.-'_:-'||\n"+
        "          _.-'_.-::::'||\n"+
        "     _.-:'_.-::::::'  ||\n"+
        "   .'`-.-:::::::'     ||\n"+
        "  /.'`;|:::::::'      ||_\n"+
        " ||   ||::::::'      _.;._'-._\n"+
        " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
        " \'.  ||:::::.-!() oo @!()@.-'_.||\n"+
        "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
        "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
        "      ||-._'-.@.-'_.-' _.-o  |'||\n"+
        "      ||=[ '-._.-\\U/.-'    o |'||\n"+
        "      || '-.]=|| |'|      o  |'||\n"+
        "      ||      || |'|        _| ';\n"+
        "      ||      || |'|    _.-'_.-'\n"+
        "      |'-._   || |'|_.-'_.-'\n"+
        "      '-._'-.|| |' `_.-'\n"+
        "           '-.||_/.-'\n");

    private static final String DRAGON_ASCII = (
        "                                                  .~))>>\n"+
        "                                                 .~)>>\n"+
        "                                               .~))))>>>\n"+
        "                                             .~))>>             ___\n"+
        "                                           .~))>>)))>>      .-~))>>\n"+
        "                                         .~)))))>>       .-~))>>)>\n"+
        "                                       .~)))>>))))>>  .-~)>>)>\n"+
        "                   )                 .~))>>))))>>  .-~)))))>>)>\n"+
        "                ( )@@*)             //)>))))))  .-~))))>>)>\n"+
        "              ).@(@@               //))>>))) .-~))>>)))))>>)>\n"+
        "            (( @.@).              //))))) .-~)>>)))))>>)>\n"+
        "          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n"+
        "       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n"+
        "      )) @@*. )@@ )   (\\_(\\-\\b  |))>)) //)))>>)))))))>>)>\n"+
        "    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n"+
        "     )* @@@ )@*     (@)  (@) /\\b|))) //))))))>>))))>>\n"+
        "   (( @. )@( @ .   _/  /    /  \\b)) //))>>)))))>>>_._\n"+
        "    )@@ (@@*)@@.  (6///6)- / ^  \\b)//))))))>>)))>>   ~~-.\n"+
        " ( @jgs@@. @@@.*@_ VvvvvV//  ^  \\b/)>>))))>>      _.     `bb\n"+
        " ((@@ @@@*.(@@ . - | o |' \\ (  ^   \\b)))>>        .'       b`,\n"+
        "   ((@@).*@@ )@ )   \\^^^/  ((   ^  ~)_        \\  /           b `,\n"+
        "     (@@. (@@ ).     `-'   (((   ^    `\\ \\ \\ \\ \\|             b  `.\n"+
        "       (*.@*              / ((((        \\| | |  \\       .       b `.\n"+
        "                         / / (((((  \\    \\ /  _.-~\\     Y,      b  ;\n"+
        "                        / / / (((((( \\    \\.-~   _.`\" _.-~`,    b  ;\n"+
        "                       /   /   `(((((()    )    (((((~      `,  b  ;\n"+
        "                     _/  _/      `\"\"\"/   /'                  ; b   ;\n"+
        "                 _.-~_.-~           /  /'                _.'~bb _.'\n"+
        "               ((((~~              / /'              _.'~bb.--~\n"+
        "                                  ((((          __.-~bb.-~\n"+
        "                                              .'  b .~~\n"+
        "                                              :bb ,' \n"+
        "                                              ~~~~\n");
    // COURTESY OF: https://www.asciiart.eu/weapons/swords 
    private static final String SWORD_ASCII = (
        "         />\r\n" + //
        "        //\r\n" + //
        "[//////<*>|||<==========================================--------------\r\n" + //
        "        \\\\\r\n" + //
        "         \\>"
    );
    // COURTESY OF: https://www.asciiart.eu/mythology/skeletons
    private static final String SKELETON_ASCII = (
        "              .7\r\n" + //
        "            .'/\r\n" + //
        "           / /\r\n" + //
        "          / /\r\n" + //
        "         / /\r\n" + //
        "        / /\r\n" + //
        "       / /\r\n" + //
        "      / /\r\n" + //
        "     / /         \r\n" + //
        "    / /          \r\n" + //
        "  __|/\r\n" + //
        ",-\\__\\\r\n" + //
        "|f-\"Y\\|\r\n" + //
        "\\()7L/\r\n" + //
        " cgD                            __ _\r\n" + //
        " |\\(                          .'  Y '>,\r\n" + //
        "  \\ \\                        / _   _   \\\r\n" + //
        "   \\\\\\                       )(_) (_)(|}\r\n" + //
        "    \\\\\\                      {  4A   } /\r\n" + //
        "     \\\\\\                      \\uLuJJ/\\l\r\n" + //
        "      \\\\\\                     |3    p)/\r\n" + //
        "       \\\\\\___ __________      /nnm_n//\r\n" + //
        "       c7___-__,__-)\\,__)(\".  \\_>-<_/D\r\n" + //
        "                  //V     \\_\"-._.__G G_c__.-__<\"/ ( \\\r\n" + //
        "                         <\"-._>__-,G_.___)\\   \\7\\\r\n" + //
        "                        (\"-.__.| \\\"<.__.-\" )   \\ \\\r\n" + //
        "                        |\"-.__\"\\  |\"-.__.-\".\\   \\ \\\r\n" + //
        "                        (\"-.__\"\". \\\"-.__.-\".|    \\_\\\r\n" + //
        "                        \\\"-.__\"\"|!|\"-.__.-\".)     \\ \\\r\n" + //
        "                         \"-.__\"\"\\_|\"-.__.-\"./      \\ l\r\n" + //
        "                          \".__\"\"\">G>-.__.-\">       .--,_\r\n" + //
        "                              \"\"  G"
    );
    // COURTESY OF: https://ascii.co.uk/art/keys
    private static final String KEY_ASCII = (
        "        ,OO.--.\r\n" + //
        "      ,O  //\\  '--------.\r\n" + //
        "      O   \\O/  .-,-,-,-,-'\r\n" + //
        "      O,  ,O--'\r\n" + //
        "      'O.-O.\r\n" + //
        "       /<__>\\\r\n" + //
        "       \\    /\r\n" + //
        "        '. |\r\n" + //
        "         < |\r\n" + //
        "         < |\r\n" + //
        "         <_/"
    );
    // COURTESY OF: https://ascii.co.uk/art/bottle
    private static final String POTION_ASCII = (
        "      _____\r\n" + //
        "     `.___,'\r\n" + //
        "      (___)\r\n" + //
        "      <   >\r\n" + //
        "       ) (\r\n" + //
        "      /`-.\\\r\n" + //
        "     /     \\\r\n" + //
        "    / _    _\\\r\n" + //
        "   :,' `-.' `:\r\n" + //
        "   |         |\r\n" + //
        "   :         ;\r\n" + //
        "    \\       /\r\n" + //
        "     `.___.' SSt"
    );
    // private constructor: prevent instantiation, methods and attributes are all static.
    private AsciiArt() {}
    
    // these are all self explanatory enough.
    public static void printTreasure() {
        System.out.println(TREASURE_ASCII);
    }
    public static String getTreasure() {
        return TREASURE_ASCII;
    }
    public static void printDragon() {
        System.out.println(DRAGON_ASCII);
    }
    public static String getDragon() {
        return DRAGON_ASCII;
    }
    public static void printSword() {
        System.out.println(SWORD_ASCII);
    }
    public static String getSword() {
        return SWORD_ASCII;
    }
    public static void printSkeleton(){
        System.out.println(SKELETON_ASCII);
    }
    public static String getSkeleton(){
        return SKELETON_ASCII;
    }
    public static void printKey(){
        System.out.println(KEY_ASCII);
    }
    public static String getKey(){
        return KEY_ASCII;
    }
    public static void printPotion(){
        System.out.println(POTION_ASCII);
    }
    public static String getPotion(){
        return POTION_ASCII;
    }
}
