
import java.io.*;
import java.net.URL; 
public class WebData {
    public WebData (String url) throws IOException{
       File  file = new File(url+".html");
        FileWriter fWriter = new FileWriter(file);
        file.createNewFile();
        try{
            String val;
            URL URL = new URL("https://"+url);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(URL.openStream()));
            while ((val = br.readLine()) != null) {
                // System.out.println(val);
                fWriter.append(val);
        }
        br.close();
        fWriter.close();
    }
        catch (Exception e){
        }
    }
    //  @SuppressWarnings("unused")
    // public static void main(String[] args) throws IOException {
    //      WebData we = new WebData("www.google.com");
    //  }
    // public static void main(String[] args)
    //     throws IOException
    // {   
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the website name");
    //     String website = sc.nextLine();
    //     sc.close();
    //     File file = new File(website+".html");
    //     file.createNewFile();
    //     FileWriter fw = new FileWriter(file);
    //     try {
    //         String val;
    //         URL URL = new URL(
    //             "https://www.youtube.com/watch?v=DNYugfiaSRc");
    //         BufferedReader br = new BufferedReader(
    //             new InputStreamReader(URL.openStream()));
    //         while ((val = br.readLine()) != null) {
    //             System.out.println(val);
    //             fw.append(val);
    //         }
    //         br.close();
    //     }
    //     catch (Exception ex) {
    //         System.out.println(ex.getMessage());
    //     }
    //     fw.close();
    // }
}
