import java.io.*;
import java.net.*;

public class FileDownloader {
    public static void downloadFile(String fileURL){
        String fileName=fileURL.substring(fileURL.lastIndexOf("/")+1,fileURL.length());
        URL url = null;
		try {
			url = new URL(fileURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] buf= new byte[512];
        try(
        	InputStream in = new BufferedInputStream(url.openStream());
        	ByteArrayOutputStream out = new ByteArrayOutputStream();
        	FileOutputStream output=new FileOutputStream(fileName);){
        	int read = in.read(buf);
            while(read != -1){
                out.write(buf,0,read);
                read = in.read(buf);
            }
            byte[] response= out.toByteArray();
            output.write(response);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        downloadFile("http://met.live.mediaspanonline.com/assets/31069/example-608web_w608.jpg");
    }
}