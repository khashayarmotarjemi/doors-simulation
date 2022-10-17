package io.khashayar.run;

import com.google.gson.Gson;
import io.khashayar.helper.json.FileManager;
import io.khashayar.run.model.Plot;

public class PlotSerializer {
    public static boolean saveToFile(Plot plot) {
        String json = new Gson().toJson(plot);

        try {
            FileManager.write(json);
            return true;
        } catch (Error e) {
            return false;
        }
    }
}
