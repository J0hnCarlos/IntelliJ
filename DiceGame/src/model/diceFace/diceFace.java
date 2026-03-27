package model.diceFace;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class diceFace {
    private static final String FILE_PATH = String.format("images%s", File.separator);
    private static final String[] FILE_STRINGS = new String[]
            {"0.gif", "1.gif", "2.gif", "3.gif", "4.gif", "5.gif", "6.gif"};

    private static Map<Integer, ImageIcon> diceFaceMap;

    public static ImageIcon getImageIcon(int i)
    {
        if (diceFaceMap == null)
        {
            createImageIcons();
        }

        return diceFaceMap.get(i);
    }

    private static void createImageIcons()
    {
        diceFaceMap = new HashMap<Integer, ImageIcon>();

        // update dice face map
        for (int i = 0; i < FILE_STRINGS.length; i++)
        {
            diceFaceMap.put(i, new ImageIcon(getFullPath(i)));
        }
    }

    private static String getFullPath(int i)
    {
        return String.format("%s%s%s", FILE_PATH, FILE_PATH.endsWith(File.separator) ? "" : File.separator,
                FILE_STRINGS[i]);
    }
}
