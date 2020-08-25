package assignment;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Assignment2 
{
	
	public void printFileCount() throws IOException 
	{
		String FOLDER_PATH = "C:\\Users\\madhu\\Desktop";
		File dir = new File(FOLDER_PATH);

		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file)
			{
				if (file.isFile())
				{
					return true;
				}
				return false;
			}
			});

		SimpleDateFormat sdf = new SimpleDateFormat("MMM");
		Map<String,Integer> fileCount = new HashMap<String,Integer>();

		for(File f:files)
		{
			
			String month = sdf.format(f.lastModified());
			if(fileCount.get(month) == null){
				fileCount.put(month,1);
			}else{
				fileCount.put(month,fileCount.get(month)+1);
			}
		}
		
		Iterator<Map.Entry<String, Integer>> itr = fileCount.entrySet().iterator(); 
          
        while(itr.hasNext()) 
        { 
             Map.Entry<String, Integer> entry = itr.next(); 
             System.out.println(entry.getKey() +" = " + entry.getValue()); 
        } 
	}
}