package alvi17.eidrecipe;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by User on 4/21/2017.
 */

public class Util {

    public static void saveInfo(Context context, String key, String value )
    {
        try
        {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).apply();

        }
        catch (Exception ex)
        {
            Log.e("Util"," saveInfo "+ex+"");
        }
    }
    public static String getInfo(Context context, String key)
    {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(key,"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }



    public static void saveInfo(Context context, String key, Set<String> value )
    {
        try
        {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet(key, value).apply();
            Log.e("Util"," saveInfo "+value+"");
        }
        catch (Exception ex)
        {
            Log.e("Util"," saveInfo "+ex+"");
        }
    }
    public static ArrayList<String> getInfoList(Context context, String key)
    {
        ArrayList<String> list=new ArrayList<>();
        try {
            Set<String> set= PreferenceManager.getDefaultSharedPreferences(context).getStringSet(key,null);
            list.addAll(set);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Log.e("Util"," getInfoList "+list+"");
        return list;
    }

}
