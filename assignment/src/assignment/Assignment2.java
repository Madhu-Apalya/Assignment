package assignment;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Assignment2 
{
//output of this method will be like this 
//Jul = 2
//
//Oct = 1
//
//Aug = 6
//
//Jun = 2
//
//Feb = 1
//
//Dec = 2
//
//Nov = 2
//
//May = 1
//
//Jan = 1
//
//Mar = 2
//	
	public void printFileCount() throws IOException 
	{
		String FOLDER_PATH = "E:\\Desktop\\SHAREit\\Redmi Note 4\\file";
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
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,File> fileCount = new HashMap<String,File>();
        for(File f:files)
        {
           String month = sdf.format(f.lastModified());
           if(fileCount.get(month) == null){
              fileCount.put(month,f);
            }else{
                 Date d = new Date(fileCount.get(month).lastModified());
                 Date d1 = new Date(f.lastModified());
                 if(d.compareTo(d1) > 0)
                 fileCount.put(month,f);
                  }
        }   
       Iterator<Map.Entry<String, File>> itr = fileCount.entrySet().iterator();
		while(itr.hasNext())		
		{		
		Map.Entry<String, File> entry = itr.next();		
		System.out.println(entry.getKey() +" = " + entry.getValue().getName()+"  "+sdf1.format(entry.getValue().lastModified()));		
		}
	}
}