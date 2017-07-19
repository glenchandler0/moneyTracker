package gchandler.moneytracker;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by gchandler on 7/18/17.
 */

public class Data
{
    private static String fileName = "moneyTrackerData.txt";

    private double totalValue;
    private double subtractValue;
    private double addValue;

    public Data()
    {
        //Read file will happen here which will set data to fill the MainActivity
    }

    //Add subtract functions
    public void add(double value)
    {
        addValue = value;
        totalValue += value;
    }

    public void subtract(double value)
    {
        subtractValue = value;
        totalValue -= value;
    }


    //IO Functions

    public static void writeToFile(String writeText)
    {
        try {
            File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File dir = new File (sdCard.getAbsolutePath());
            dir.mkdirs();
            File file = new File(sdCard, (fileName));

            FileOutputStream f = new FileOutputStream(file);

            f.write(writeText.getBytes());
            f.close();

            Log.i("WRITE TO FILE: ", "");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Entire file will be read in to be parsed from another file
    public static String readFromFile()
    {
        String returnString = "";
        try {
            File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File dir = new File (sdCard.getAbsolutePath());
            dir.mkdirs();
            File file = new File(sdCard, (fileName));

            FileInputStream f = new FileInputStream(file);

            byte[] inStream = new byte[2048];
            f.read(inStream, 0, inStream.length);

            returnString = inStream.toString();


            f.close();

            Log.i("WRITE TO FILE: ", "");
        }catch(Exception e) {
            e.printStackTrace();
        }

        return returnString;
    }


    //Setters and getters
    public double getTotalValue()
    {
        return totalValue;
    }

    public double getSubtractValue()
    {
        return subtractValue;
    }

    public double getAddValue()
    {
        return addValue;
    }
}
