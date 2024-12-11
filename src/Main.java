
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        int total = 0;
        for (int i = 0; i < fileData.size(); i++){
            String[] line = fileData.get(i).split(" ");
            if(isSafeP2(line)){
                total++;
            }
        }
        System.out.println(total);
    }

    public static boolean is_safe(String[] file){
        boolean inc = isInc(file);
        for (int i = 0; i < file.length-1; i++){
            int val1 = Integer.parseInt(file[i]);
            int val2 = Integer.parseInt(file[i+1]);
            if(inc) {
                int diff = val2 - val1;
                if (diff < 1 || diff > 3) {
                    return false;
                }
            } else {
                int diff =  val1 - val2;
                if (diff < 1 || diff > 3) {

                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isSafeP2(String[] file){
        if(is_safe(file)){
            return true;
        } else {
            for(int i = 0; i < file.length; i++){
                String[] array = new String[file.length-1];
                for(int j = 0, k = 0; j < file.length; j++) {
                    if (j != i) {
                        array[k++] = file[j];
                    }
                }
                if(is_safe(array)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInc(String[] file){
        int inc = 0;
        int dec = 0;
        for(int i=0; i<file.length-1; i++){
            if(Integer.parseInt(file[i]) < Integer.parseInt(file[i+1])){
                inc++;
            } else {
                dec ++;
            }
        }
        return inc > dec;
    }




    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
