import java.io.*;
import java.util.List;

public class CsvMethod{
    private String fileName = null;
    private CsvReader csvReader;
    private CsvWriter csvWriter;
    private boolean isSucess = false;
    private File file  = null;
    private FileOutputStream out = null;
    private OutputStreamWriter osw = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    public CsvMethod(){}
    public CsvMethod(String fileName){
        this.fileName = fileName;
        try {
            csvReader = new CsvReader(this.fileName);
            csvWriter = new CsvWriter(this.fileName);
            file = new File(this.fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * add
     */

    public void AddCsv(List<String> contest){
        try {
            out = new FileOutputStream(file, true);
            osw = new OutputStreamWriter(out);
            bw = new BufferedWriter(osw);
            long cnt = 0;
            for(String line : contest){
                cnt++;
                bw.append(line).append("\r");
                if (cnt%500==0) {
                    bw.flush();
                }
            }
            bw.close();
        }catch (Exception e){
            isSucess = true;
        }
    }

    /**
     * insert select(标注header数字或名字， 以及相等条件来筛选)
     */
    public void SelectCsv(int[] header, long row){
        try {
            csvReader.readHeaders();
            for (int i = 0; i < header.length; i++) {
                System.out.print(csvReader.getHeader(header[i])+" | ");
            }
            System.out.println();
            for (long i = 0; i < row; i++) {
                csvReader.skipRecord();
            }
            for (int i = 0; i < header.length; i++) {
                System.out.print(csvReader.get(header[i])+" | ");
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void SelectCsv(String[] header, long row){
        try {
            csvReader.readHeaders();
            for (int i = 0; i < header.length; i++) {
                System.out.print(header[i]+" | ");
            }
            System.out.println();
            for (long i = 0; i < row; i++) {
                csvReader.skipRecord();
            }
            for (int i = 0; i < header.length; i++) {
                System.out.print(csvReader.get(header[i])+" | ");
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void SelectCsv(String[] select, String[] header, String[] equals){
        try {
            csvReader.readHeaders();
            for (int i = 0; i < header.length; i++) {
                System.out.print(header[i] + " | ");
            }
            System.out.println();
            while (csvReader.readRecord()){
                int j=0;
                for (int i = 0; i < header.length; i++) {
                    if (!csvReader.get(header[i]).equals(equals[i])){
                        j=1;
                        break;
                    }
                }
                if (j == 0){
                    for (int i = 0; i < select.length; i++) {
                        System.out.print(csvReader.get(select[i]) + " | ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void SelectCsv(String s){
        long count = 0;
        if (s.equals("count(*)")){
            try {
                csvReader.readHeaders();
                while (csvReader.readRecord()){
                    count++;
                }
                System.out.println(count);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else if (s.equals("*")){
            try {
                csvReader.readHeaders();
                for (String header : csvReader.getHeaders()) {
                    System.out.print(header + " | ");
                }
                System.out.println();
                while (csvReader.readRecord()){
                    for (String contest : csvReader.getRawRecord().split(",")) {
                        System.out.print(contest + " | ");
                    }
                    System.out.println();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * updata (以及相等条件来筛选)
     */
    public void updata(int[] headf, String[] find, int[] headu, String[] updata){
        try {
            long cnt=0;
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(file));
            String[] head = br.readLine().split(",");
            bw.append("\r");
            String line = null;
            while((line= br.readLine())!= null){
                cnt++;
                String[] item = line.split(",");
                int j = 0;
                for (int th : headf){
                    if (!item[th].equals(find[th])) {
                        j = 1;
                        break;
                    }
                }
                if (j == 0){
                    for (int th : headu){
                        item[th] = updata[th];
                    }
                }
                bw.append(line).append("\r");
                if (cnt%500 == 0) {
                    bw.flush();
                }
            }
            bw.close();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * updata (以及相等条件来筛选)
     */
    public void delete(int[] headf, String[] find){
        try {
            long cnt=0;
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(file));
            String[] head = br.readLine().split(",");
            bw.append("\r");
            String line = null;
            while((line= br.readLine())!= null){
                cnt++;
                String[] item = line.split(",");
                int j = 0;
                for (int th : headf){
                    if (!item[th].equals(find[th])) {
                        j = 1;
                        break;
                    }
                }
                if (j == 1){
                    bw.append(line).append("\r");
                }

                if (cnt%500 == 0) {
                    bw.flush();
                }
            }
            bw.close();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

