
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.io.*;

public class Test{
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            System.out.println("");
            System.out.println("enter file name");
            Scanner sc = new Scanner(System.in);
            String fileName = sc.nextLine();

			//args[0];
                 //  sc.nextLine();
            if (!fileName.endsWith(".arxml")){
            throw new NotVaildAutosarFileException("invalid file extension");
            }
            File file=new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            int d;
            StringBuilder stringBuilder = new StringBuilder();
            if(inputStream.read() == -1){
            throw new EmptyAutosarFileException("your file is an empty file");            
            }
            while((d = inputStream.read())!= -1){
            stringBuilder.append((char)d);
            }
            String data = stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<container> containers = new ArrayList<>();
            while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("<CONTAINER")){
            String ContainerUUID = line.substring(line.indexOf("UUID=")  , line.indexOf(">"));
            String ShortNameTag = scanner.nextLine();
            String ShortName = ShortNameTag.substring(ShortNameTag.indexOf(">")+1  , ShortNameTag.indexOf("</"));
            String LongNameTag = scanner.nextLine();
            String LongName = LongNameTag.substring(LongNameTag.indexOf(">")+1  , LongNameTag.indexOf("</"));

            container ccontainer = new container();
            ccontainer.setcontainerUUID(ContainerUUID);
            ccontainer.setshortName(ShortName);
            ccontainer.setlongName(LongName);
            containers.add(ccontainer);
            }
            }
            Collections.sort(containers);
            String outName = fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
            FileOutputStream outputSream = new FileOutputStream(outName);
            outputSream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputSream.write("<AUTOSAR>\n".getBytes());
            for(int i =0; i<containers.size(); i++){
             outputSream.write(containers.get(i).toString().getBytes());       
        }
             outputSream.write("</AUTOSAR>\n".getBytes());           
            
                }
       
            catch (NotVaildAutosarFileException e) {
                e = new NotVaildAutosarFileException("Not Valid Autosar File Exception");
            }
            catch (IOException e) {
                e = new IOException("IO Exception");
            }
      /*      catch (EmptyAutosarFileException e) {
                e = new EmptyAutosarFileException("empty file");
            }

     */
     
     
}  
}  
        
 
