package wl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class File {
	static int count=1; 
	static int c=0;
   static String[] q= {"һ","��","��","��","��","��","��"};
 
	  public static void WriteStringToFile2(List<mean>  means,String type,String name) {

	        try {
	        	
	            FileWriter fw = new FileWriter(name, true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.append(q[c]+"."+type);//���
              	bw.write("\n");
                for(mean model:means) {
                String word=model.getWord();//����
	            bw.write(count+"."+model.getWord());
	            bw.write("\n");
	            bw.write("   ");
	            bw.write(model.getMeann());
	            bw.write("\r\n");
	            count++;
                }

	            bw.close();

	            fw.close();

	        } catch (Exception e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	        }

	    }
	  
	  
	  public static void down() {
		  c=0;
		  String[] type= {"��������","������","��ά","�������","������","�ܹ�","�˹�����"};
		  Date day=new Date();    
		  SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");   
		  String name="C:\\Users\\Administrator\\Desktop\\�ȴʽ���"+df.format(day)+".doc";
		  mulu(name);
		  for(int i=0;i<type.length;i++) {
			  count=1;
			  List<mean> words=dao.find_allwords1(type[i]);
			  WriteStringToFile2(words,type[i],name);
			  c++;
		  }
		  
				  
	  }
	  
	  public static void mulu(String name) {
       try {
	        	
	            FileWriter fw = new FileWriter(name, true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.append("                          ��Ϣ�����ȴʽ���");//���
              	    bw.write("\n");
              	bw.write("\n");
              	bw.write("\n");
	            bw.write("һ.��������....................................................................1");
	            bw.write("\n");
	            bw.write("��.������......................................................................2");
	            bw.write("\n");
	            bw.write("��.��ά........................................................................2");
	            bw.write("\n");
	            bw.write("��.�������....................................................................3");
	            bw.write("\n");
	            bw.write("��.������......................................................................4");
	            bw.write("\n");
	            bw.write("��.�ܹ�....................................................................... 4");
	            bw.write("\n");
	            bw.write("��.�˹�����....................................................................5");
	            bw.write("\n");
	            bw.write("\n");
	            bw.write("\n");
	            bw.write("\n");
	            bw.write("\n");
	            bw.write("\n");
	            bw.close();

	            fw.close();

	        } catch (Exception e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	        }
		  
	  }
	  
	  


}
