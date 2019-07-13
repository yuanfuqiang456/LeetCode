package JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import net.sf.json.JSONObject;


public class Main {

    public static JSONObject compositionJSonObject(HashMap<String,Integer> hasmap,ArrayList<Integer> list)
    {
        JSONObject detailObject = new JSONObject();
        Iterator entries = hasmap.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry entry = (Map.Entry) entries.next();

            String key = (String)entry.getKey();

            Integer value = (Integer)entry.getValue();

            detailObject.put(key, value);

        }
        JSONObject schoolInfoObject = new JSONObject();
        schoolInfoObject.put("total_count",hasmap.size());
        schoolInfoObject.put("detail",detailObject);
        Sort s = new Sort();
        JSONObject totalObject = new JSONObject();
        totalObject.put("school_info",schoolInfoObject);
        ArrayList<Integer> ascAgeList = s.sortList(list,"ASC");
        totalObject.put("asc_age_list",ascAgeList);
        ArrayList<Integer> dscAgeList = s.sortList(list,"DESC");

        totalObject.put("desc_age_list",dscAgeList);
        return totalObject;
    }


    public static void main(String[] args)
    {
        HashMap<String,Integer> schmap = new HashMap<String, Integer>();
        ArrayList<Integer> agelist = new ArrayList<Integer>();

        String FilePath = "./conf/student_info.txt";
        try {
            FileInputStream inputStream = new FileInputStream(FilePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] strlist = str.split(";");
                if (schmap.containsKey(strlist[2])) {
                    Integer i = schmap.get(strlist[2]);
                    schmap.replace(strlist[2], i + 1);
                } else {
                    schmap.put(strlist[2], 1);
                }
                agelist.add(Integer.valueOf(strlist[1]));

            }
        }
        catch(Throwable t)
        {

        }


        JSONObject totalObject = compositionJSonObject(schmap,agelist);

        String jsonPath = "./result.json";

        write2Json(totalObject,jsonPath);


        return;



    }

    public static void  write2Json(JSONObject obj,String filepath)
    {
        File file = new File(filepath);
        try {
            file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(obj.toString());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


