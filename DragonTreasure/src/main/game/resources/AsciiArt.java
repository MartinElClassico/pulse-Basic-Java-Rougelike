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
}
